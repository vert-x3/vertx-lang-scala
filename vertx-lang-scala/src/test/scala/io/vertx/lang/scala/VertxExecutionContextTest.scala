package io.vertx.lang.scala

import io.vertx.lang.scala.ScalaVerticle.nameForVerticle
import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Assertions, AsyncFlatSpec, Matchers}

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.{Failure, Success}

@RunWith(classOf[JUnitRunner])
class VertxExecutionContextTest extends AsyncFlatSpec with Matchers with Assertions {

  "Using Promise to complete a Vertx-Future" should "work with a VertxExecutionContext" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    vertx.deployVerticleFuture(nameForVerticle[SuccessVerticle])
      .map(res => res should not be empty)
  }

  "bla" should "work with a VertxExecutionContext" in {
    val idInEventLoopPromise = Promise[Long]
    val idInGlobalPromise = Promise[Long]
    val idBackInEventLoopPromise = Promise[Long]
    val vertx = Vertx.vertx
    val ctx = vertx.getOrCreateContext()
    implicit val exec = VertxExecutionContext(ctx)
    vertx.deployVerticleFuture(nameForVerticle[SuccessVerticle])
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
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    vertx.deployVerticleFuture(nameForVerticle[FailVerticle])
      .transformWith {
        case Failure(t) => t.getMessage should equal("wuha")
        case Success(_) => fail("Deployment shouldn't succeed!")
      }
  }

}

class SuccessVerticle extends ScalaVerticle {

  override def startFuture(): Future[Unit] = {
    Future.sequence(Seq(
      vertx.eventBus().consumer[String]("asd").handler(a => println(a)).completionFuture(),
      vertx.eventBus().consumer[String]("asd2").handler(a => println(a)).completionFuture())
    ).map(_ => ())
  }
}

class FailVerticle extends ScalaVerticle {

  override def startFuture(): Future[Unit] = {
    Future.sequence(Seq(
      vertx.eventBus().consumer[String]("asd").handler(a => println(a)).completionFuture(),
      Future.failed(new java.lang.Exception("wuha")))
    ).map(_ => ())
  }
}
