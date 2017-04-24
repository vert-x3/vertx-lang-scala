package io.vertx.lang.scala.rx
import io.vertx.lang.scala.{ScalaVerticle, VertxExecutionContext}
import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.{Assertions, AsyncFlatSpec, FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner
import rx.lang.scala.Observable._
import Rx._

import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}


@RunWith(classOf[JUnitRunner])
class RxTest extends AsyncFlatSpec with Matchers with Assertions {

  "Switching between Schedulers" should "work" in {
    val vertx = Vertx.vertx()
    implicit val ctx = VertxExecutionContext(vertx.getOrCreateContext())
    implicit val vertxEc = vertx.vertxScheduler()

    val workerEx = vertx.workerScheduler("myworker")

    val prom = Promise[List[String]]
    just(List(1,2,3))
      .subscribeOn(vertxEc)
      .map(_ => Thread.currentThread().getName.split("-").head :: Nil)
      .observeOn(workerEx)
      .map(l => Thread.currentThread().getName.split("-").head :: l)
      .doOnNext(l => prom.success(l))
      .subscribe()

    prom.future.map(l => l should equal(List("myworker", "vert.x")))
  }

  "Using RX inside a Verticle" should "work" in {
    val vertx = Vertx.vertx()
    vertx.deployVerticleFuture(ScalaVerticle.nameForVerticle[ConsumerVerticle])
      .map(_ => succeed)
  }
}

class ConsumerVerticle extends ScalaVerticle {

  override def startFuture(): Future[Unit] = {
    val prom = Promise[Unit]

    just(List(1,2,3))
      .subscribeOn(vertx.vertxScheduler())
      .map(_ => Thread.currentThread().getName.split("-").head :: Nil)
      .observeOn(vertx.workerScheduler("myworker"))
      .map(l => Thread.currentThread().getName.split("-").head :: l)
      .doOnNext{
        case List("myworker", "vert.x") => prom.success()
        case _ => prom.failure(new Exception("FAILED"))
      }
      .subscribe()

    prom.future
  }
}
