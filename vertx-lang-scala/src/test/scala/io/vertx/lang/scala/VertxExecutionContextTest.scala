package io.vertx.lang.scala

import io.vertx.core.{AsyncResult, Handler, Vertx, VertxOptions}
import io.vertx.lang.scala.ThreadIdReplyer.{EVENTBUS_ADDRESS, HANDLER_TYPE_EVENTLOOP, HANDLER_TYPE_VERTXCONTEXT, HANDLER_TYPE_WORKERPOOL}
import io.vertx.lang.scala.conv._
import io.vertx.lang.scala.core.eventbus.Message
import org.scalatest.{Assertions, BeforeAndAfter}
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.{Failure, Success}

class VertxExecutionContextTest extends AsyncFlatSpec with Matchers with Assertions with BeforeAndAfter {

  private var vertx: Vertx = _
  private var vertxExecutionContext: VertxExecutionContext = _

  before {
    vertx = Vertx.vertx(new VertxOptions().setEventLoopPoolSize(1))
    vertxExecutionContext = VertxExecutionContext(vertx, vertx.getOrCreateContext)
  }

  "Completing a Vertx-Future in a Scala Future" should "work with the VertxExecutionContext" in {
    vertx.deployVerticle(new SuccessVerticle())
         .map(res => res should not be empty)(vertxExecutionContext)
  }

  "Switching to the event loop execution context" should "work even when another context is used in between" in {
    for {
      _ <- vertx.deployVerticle(new ThreadIdReplyer())
      idInEventLoopMsg <- vertx.eventBus.request[Long](EVENTBUS_ADDRESS, HANDLER_TYPE_EVENTLOOP).asScala
      idInWorkerPoolMsg <- vertx.eventBus.request[Long](EVENTBUS_ADDRESS, HANDLER_TYPE_WORKERPOOL).asScala
      idInContextMsg <- vertx.eventBus.request[Long](EVENTBUS_ADDRESS, HANDLER_TYPE_VERTXCONTEXT).asScala
      idInEventLoop = idInEventLoopMsg.body
      idInWorkerPool = idInWorkerPoolMsg.body
      idInContext = idInContextMsg.body
      assertion = idInEventLoop should equal(idInContext) shouldNot equal(idInWorkerPool)
    } yield assertion
  }

  "A deployment" should "fail if the deployed verticle fails" in {
    vertx.deployVerticle(new FailVerticle())
      .transformWith {
        case Failure(t) => t.getMessage should equal("wuha")
        case Success(_) => fail("Deployment shouldn't succeed!")
      }(vertxExecutionContext)
  }
}

object VertxDemo {

  import io.vertx.scala.core.HttpServerOptions

  def main(args: Array[String]): Unit = {
    val vertx = Vertx.vertx
    implicit val exec: VertxExecutionContext = VertxExecutionContext(vertx, vertx.getOrCreateContext)
    vertx
      .createHttpServer(HttpServerOptions(port = 8080))
      .requestHandler(req => {
        req.response().end("Hello world!")
      })
      .listen.asScala
      .onComplete{
        case Success(_) => println("Success")
        case Failure(_) => println("Failure")
      }
  }
}

class SuccessVerticle extends ScalaVerticle {
  override def asyncStart: Future[Unit] = {
    val consumer1Registered = handleInFuture(vertx.eventBus.consumer[String]("asd")
                                                          .handler(println)
                                                          .completionHandler)
    val consumer2Registered = handleInFuture(vertx.eventBus().consumer[String]("asd2")
                                                          .handler(println)
                                                          .completionHandler)
    consumer1Registered.zip(consumer2Registered)
      .map(_ => ())
  }
}

class FailVerticle extends ScalaVerticle {
  override def asyncStart: Future[Unit] = {
    val consumerRegistered = handleInFuture(vertx.eventBus().consumer[String]("asd")
      .handler(a => println(a))
      .completionHandler)
    consumerRegistered.zip(Future.failed(new Exception("wuha")))
      .map(_ => ())
  }
}

class ThreadIdReplyer extends ScalaVerticle {
  override def asyncStart: Future[Unit] = handleInFuture(
    vertx.eventBus.consumer[String](EVENTBUS_ADDRESS)
      .handler(msg => msg match {
        case Message(body) if body == HANDLER_TYPE_EVENTLOOP => msg.reply(Thread.currentThread.getId)
        case Message(body) if body == HANDLER_TYPE_WORKERPOOL =>
          vertx.executeBlockingScala(() => Thread.currentThread.getId).onComplete {
            case Success(threadId) => msg.reply(threadId)
            case Failure(_) => msg.reply(-1)
          }
        case Message(body) if body == HANDLER_TYPE_VERTXCONTEXT => vertx.runOnContext(_ => msg.reply(Thread.currentThread.getId))
      })
          .completionHandler)
   .map(_ => ())

}

object ThreadIdReplyer {
  val EVENTBUS_ADDRESS = "ThreadIdReplyer"
  val HANDLER_TYPE_EVENTLOOP = "eventLoop"
  val HANDLER_TYPE_WORKERPOOL = "workerPool"
  val HANDLER_TYPE_VERTXCONTEXT = "vertxContext"
}
