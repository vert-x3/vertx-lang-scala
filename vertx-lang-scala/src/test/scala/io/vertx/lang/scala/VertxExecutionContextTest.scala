package io.vertx.lang.scala

import io.vertx.lang.scala.ScalaVerticle.nameForVerticle
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServerOptions
import io.vertx.scala.core.NetServerOptions
import org.scalatest.Assertions
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.{Failure, Success}
import io.vertx.lang.scala.conv._

class VertxExecutionContextTest extends AsyncFlatSpec with Matchers with Assertions {

  "Using Promise to complete a Vertx-Future" should "work with a VertxExecutionContext" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    vertx.deployVerticle(nameForVerticle[SuccessVerticle]()).asScala()
      .map(res => res should not be empty)
  }

  "Switching back to the event loop execution context" should "work even when another context is used in between" in {
    val idInEventLoopPromise = Promise[Long]()
    val idInGlobalPromise = Promise[Long]()
    val idBackInEventLoopPromise = Promise[Long]()
    val vertx = Vertx.vertx
    val ctx = vertx.getOrCreateContext()
    implicit val exec = VertxExecutionContext(vertx, ctx)
    vertx.deployVerticle(nameForVerticle[SuccessVerticle]()).asScala()
      .map(res => {
        idInEventLoopPromise.success(Thread.currentThread().getId)
              Future {
                idInGlobalPromise.success(Thread.currentThread().getId)
              Thread.sleep(1000)
              "computed"
            }(ExecutionContext.global).onComplete{
                case Success(s) => idBackInEventLoopPromise.success(Thread.currentThread().getId)
                case Failure(t) => idBackInEventLoopPromise.failure(t)
              }(exec)
      })

    val aggFut = for{
      idInEventLoop <- idInEventLoopPromise.future
      idInGlobal <- idInGlobalPromise.future
      idBackInEvent <- idBackInEventLoopPromise.future
    } yield (idInEventLoop, idInGlobal, idBackInEvent)

    aggFut.map(s => s._1 should equal(s._3) shouldNot equal(s._2))
  }

  "A deployment" should "fail if the deployed verticle fails" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    vertx.deployVerticle(nameForVerticle[FailVerticle]()).asScala()
      .transformWith {
        case Failure(t) => t.getMessage should equal("wuha")
        case Success(_) => fail("Deployment shouldn't succeed!")
      }
  }

  "eventbus" should "bla" in {



  }

}

import io.vertx.scala.core.HttpServerOptions
import io.vertx.lang.scala._
object VertxDemo {
  def main(args: Array[String]): Unit = {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    vertx
      .createHttpServer(HttpServerOptions(port = 8080))
      .requestHandler(req => {
        req.response().end("Hello world!")
      })
      .listen().asScala()
      .onComplete{
        case Success(_) => println("Success")
        case Failure(_) => println("Failure")
      }
  }
}

class SuccessVerticle extends ScalaVerticle {

  override def start(promise: Promise[Unit]) {
    val p1 = Promise[Void]()
    val p2 = Promise[Void]()
    vertx.eventBus().consumer[String]("asd").handler(a => println(a)).completionHandler(ar => {
      if (ar.failed()) {
        p1.failure(ar.cause())
      } else {
        p1.success(null)
      }
    })
    vertx.eventBus().consumer[String]("asd2").handler(a => println(a)).completionHandler(ar => {
      if (ar.failed()) {
        p2.failure(ar.cause())
      } else {
        p2.success(null)
      }
    })
    p1.future.zip(p2.future)
      .onComplete{
        case Success(_) => promise.complete(Success())
        case Failure(e) => promise.failure(e)
      }
  }
}

class FailVerticle extends ScalaVerticle {

  override def start(promise: Promise[Unit]) {
    val p1 = Promise[Void]()
    vertx.eventBus().consumer[String]("asd").handler(a => println(a)).completionHandler(ar => {
      if (ar.failed()) {
        p1.failure(ar.cause())
      } else {
        p1.success(null)
      }
    })

    p1.future.zip(Future.failed(new java.lang.Exception("wuha")))
      .onComplete{
        case Success(_) => promise.complete(Success())
        case Failure(e) => promise.failure(e)
      }
  }
}
