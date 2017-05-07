package io.vertx.lang.scala.streams

import java.util.concurrent.{CopyOnWriteArrayList, Executors}

import io.vertx.lang.scala.VertxExecutionContext
import io.vertx.lang.scala.streams.Rs._
import io.vertx.lang.scala.streams.source.VertxListSource
import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.reactivestreams.example.unicast.{AsyncIterablePublisher, AsyncSubscriber}
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Assertions, AsyncFlatSpec, Matchers}

import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.concurrent.Promise

@RunWith(classOf[JUnitRunner])
class ReactiveStreamsTest extends AsyncFlatSpec with Matchers with Assertions {

  "A ReactiveStreams based Publisher" should "work as a Source in a stream" in {
    val vertx = Vertx.vertx()
    val ctx = vertx.getOrCreateContext()
    implicit val ec = VertxExecutionContext(ctx)

    val prom = Promise[List[Int]]
    val received = mutable.ListBuffer[Int]()

    vertx.eventBus()
      .localConsumer[Int]("sinkAddress")
      .handler(m => {
        received += m.body()
        if (received.size == 5)
          prom.success(received.toList)
      })

    ec.execute(() => {
      val producer = vertx.eventBus().sender[Int]("sinkAddress")

      val publisher = new AsyncIterablePublisher[Int](List(1, 2, 3, 4, 5).asJava, Executors.newFixedThreadPool(5))
      publisher.toSource
        .sink(producer.toSink())
    })

    prom.future.map(s => s should equal(List(1, 2, 3, 4, 5)))

  }

  "A ReactiveStreams based Subscriber" should "work as Sink in a stream" in {
    val vertx = Vertx.vertx()
    val ctx = vertx.getOrCreateContext()
    implicit val ec = VertxExecutionContext(ctx)

    val prom = Promise[List[Int]]

    val received = new CopyOnWriteArrayList[Int]()

    ec.execute(() => {
      val source = new VertxListSource[Int](List(1, 2, 3, 5, 8))
      val rsSubscriber = new AsyncSubscriber[Int](Executors.newFixedThreadPool(5)) {
        override def whenNext(element: Int): Boolean = {
          received.add(element)
          if(received.size() == 5)
            prom.success(received.asScala.toList)
          true
        }
      }

      source
        .sink(rsSubscriber.toSink)
    })

    prom.future.map(s => s should equal(List(1, 2, 3, 5, 8)))
  }

}
