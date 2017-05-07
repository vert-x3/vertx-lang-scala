package io.vertx.lang.scala.streams

import java.util.concurrent.atomic.AtomicInteger

import io.vertx.lang.scala.ScalaVerticle.nameForVerticle
import io.vertx.lang.scala.streams.sink.{FunctionSink, WriteStreamSink}
import io.vertx.lang.scala.streams.source.{ReadStreamSource, VertxListSource}
import io.vertx.lang.scala.streams.stage.{FilterStage, MapStage, ProcessStage, SyncStage}
import io.vertx.lang.scala.{ScalaVerticle, VertxExecutionContext, WorkerExecutorExecutionContext}
import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Assertions, AsyncFlatSpec, Matchers}

import scala.collection.mutable
import scala.concurrent.Promise

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class StreamBasicsTest extends AsyncFlatSpec with Matchers with Assertions {

  "Streaming a List in Vert.x" should "work" in {
    val vertx = Vertx.vertx()
    val ctx = vertx.getOrCreateContext()
    implicit val ec = VertxExecutionContext(ctx)

    val prom = Promise[List[Int]]

    val original = List(1, 2, 3, 5, 8)

    ec.execute(() => {
      val streamed = mutable.Buffer[Int]()

      val source = new VertxListSource[Int](original)
      val sink = new FunctionSink[Int](f => {
        streamed += f
        if (streamed.size == 5)
          prom.success(streamed.toList)
      })

      source.subscribe(sink)
    })

    prom.future.map(s => s should equal(original))
  }

  "Using SyncStage" should "not change the thread the stream is running on" in {
    val vertx = Vertx.vertx()
    val ctx = vertx.getOrCreateContext()
    implicit val ec = VertxExecutionContext(ctx)
    implicit val wc = new WorkerExecutorExecutionContext(vertx.createSharedWorkerExecutor("test"))

    val prom = Promise[List[String]]

    ec.execute(() => {
      val streamed = mutable.Buffer[String]()

      val source = new VertxListSource[Int](List(1, 2, 3, 5, 8))
      val syncStage = new SyncStage[Int, Int]((a: Int) => {
        Thread.sleep(200)
        a
      })
      val mapStage = new MapStage((i: Int) => s"${Thread.currentThread().getName.equals("vert.x-eventloop-thread-0")} $i")

      val sink = new FunctionSink[String](f => {
        streamed += f
        if (streamed.size == 5)
          prom.success(streamed.toList)
      })

      source.subscribe(syncStage)
      syncStage.subscribe(mapStage)
      mapStage.subscribe(sink)
    })

    prom.future.map(s => s should equal(List("true 1", "true 2", "true 3", "true 5", "true 8")))(ec)
  }

  "Using a MapStage" should "transform events" in {
    val vertx = Vertx.vertx()
    val ctx = vertx.getOrCreateContext()
    implicit val ec = VertxExecutionContext(ctx)

    val prom = Promise[List[String]]

    val original = List(1, 2, 3, 5, 8)
    val expected = List("Int 1", "Int 2", "Int 3", "Int 5", "Int 8")

    ec.execute(() => {
      val streamed = mutable.Buffer[String]()

      val source = new VertxListSource[Int](original)
      val stage = new MapStage((i: Int) => s"Int $i")
      val sink = new FunctionSink[String](f => {
        streamed += f
        if (streamed.size == 5)
          prom.success(streamed.toList)
      })

      stage.subscribe(sink)
      source.subscribe(stage)
    })

    prom.future.map(s => s should equal(expected))
  }

  "Using a FilterStage" should "remove specific events from the stream" in {
    val vertx = Vertx.vertx()
    val ctx = vertx.getOrCreateContext()
    implicit val ec = VertxExecutionContext(ctx)

    val prom = Promise[List[Int]]
    val original = List(1, 2, 3, 5, 8)
    val expected = List(1, 3, 5, 8)

    ec.execute(() => {
      val streamed = mutable.Buffer[Int]()

      val source = new VertxListSource[Int](original)
      val stage = new FilterStage((i: Int) => i != 2)
      val sink = new FunctionSink[Int](f => {
        streamed += f
        if (streamed.size == 4)
          prom.success(streamed.toList)
      })

      stage.subscribe(sink)
      source.subscribe(stage)
    })


    prom.future.map(s => s should equal(expected))
  }

  "Using a ProcessStage" should "not change the events" in {
    val vertx = Vertx.vertx()
    val ctx = vertx.getOrCreateContext()
    implicit val ec = VertxExecutionContext(ctx)

    val counter = new AtomicInteger(0)
    val prom = Promise[List[Int]]

    ec.execute(() => {
      val streamed = mutable.Buffer[Int]()

      val source = new VertxListSource[Int](List(1, 2, 3, 5, 8))
      val processStage = new ProcessStage((i: Int) => counter.addAndGet(i))
      val sink = new FunctionSink[Int](f => {
        streamed += f
        if (streamed.size == 5)
          prom.success(streamed.toList)
      })

      processStage.subscribe(sink)
      source.subscribe(processStage)
    })


    prom.future
      .map(s => s should equal(List(1, 2, 3, 5, 8)))
      .map(s => counter.get() should equal(19))
  }

  "Transforming events in a Verticle " should "work" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())

    val result = Promise[String]
    vertx.eventBus()
      .localConsumer[String]("result")
      .handler(m => result.success(m.body()))

    vertx
      .deployVerticleFuture(nameForVerticle[StreamTestVerticle])
      .map(s => vertx.eventBus().send("testAddress", "World"))

    result.future.map(r => r should equal("Hello World"))
  }

}

class StreamTestVerticle extends ScalaVerticle {
  override def startFuture() = {
    val consumer = vertx.eventBus().consumer[String]("testAddress")
    val producer = vertx.eventBus().sender[String]("result")
    val source = new ReadStreamSource(consumer.bodyStream())
    val mapStage = new MapStage((a: String) => s"Hello $a")
    val sink = new WriteStreamSink[String](producer, 5)

    source.subscribe(mapStage)
    mapStage.subscribe(sink)

    consumer.completionFuture()
  }
}
