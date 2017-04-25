package io.vertx.lang.scala.rx
import io.vertx.lang.scala.rx.Rx._
import io.vertx.lang.scala.{ScalaVerticle, VertxExecutionContext}
import io.vertx.scala.core.Vertx
import io.vertx.scala.core.eventbus.Message
import io.vertx.scala.core.streams.Pump
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Assertions, AsyncFlatSpec, Matchers}
import rx.lang.scala.Observable._

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

  "Using ObservableHandler inside a Verticle" should "work" in {
    val prom = Promise[String]
    val vertx = Vertx.vertx()
    vertx.eventBus().localConsumer[String]("response").handler(r => prom.success(r.body()))
    vertx.deployVerticleFuture(ScalaVerticle.nameForVerticle[ObservableHandlerVerticle]).onComplete{
      case Success(s) => vertx.eventBus().send("obsHand","Welt")
      case Failure(t) => prom.failure(t)
    }

    prom.future.map(r => r should startWith("Hallo Welt vert.x-eventloop-thread-"))
  }

  "Using ObservableReadStream inside a Verticle" should "work" in {
    val prom = Promise[String]
    val vertx = Vertx.vertx()
    vertx.eventBus().localConsumer[String]("response").handler(r => prom.success(r.body()))
    vertx.deployVerticleFuture(ScalaVerticle.nameForVerticle[PumpingVerticle]).onComplete{
      case Success(s) => vertx.eventBus().send("obsHand","Hallo Welt")
      case Failure(t) => prom.failure(t)
    }

    prom.future.map(r => r should equal("Hallo Welt"))
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

class ObservableHandlerVerticle extends ScalaVerticle {

  override def startFuture(): Future[Unit] = {
    val obsHand = observableHandler[Message[String]]()
    obsHand
      .map(_.body())
      .doOnNext(s =>
        vertx.eventBus().send("response", s"Hallo $s ${Thread.currentThread().getName}"))
    .subscribe()
    vertx.eventBus().consumer[String]("obsHand").handler(obsHand.toHandler).completionFuture()
  }
}


class PumpingVerticle extends ScalaVerticle {

  override def startFuture(): Future[Unit] = {
    val consumer = vertx.eventBus().consumer[String]("obsHand")
    val sender = vertx.eventBus().sender[String]("response")
    val pump = Pump.pump[String](consumer.bodyStream(), sender)
    pump.start()
    consumer.completionFuture()
  }
}
