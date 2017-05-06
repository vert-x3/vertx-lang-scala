package io.vertx.lang.scala.streams

import java.util.concurrent.Executors

import io.vertx.lang.scala.ScalaVerticle.nameForVerticle
import io.vertx.lang.scala.{ScalaVerticle, VertxExecutionContext, WorkerExecutorExecutionContext}
import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.{Assertions, AsyncFlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner
import io.vertx.lang.scala.streams.Rs._
import io.vertx.lang.scala.streams.source.ReactiveStreamsPublisherSource
import org.reactivestreams.example.unicast.AsyncIterablePublisher

import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.concurrent.Promise

@RunWith(classOf[JUnitRunner])
class ReactiveStreamsTest extends AsyncFlatSpec with Matchers with Assertions {

  "Transforming events in a stream" should "work" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())

    val promise = Promise[List[Int]]

    val received = mutable.ListBuffer[Int]()

    vertx.eventBus()
      .localConsumer[Int]("sinkAddress")
      .handler(m => {
        received += m.body()
        if(received.size == 5)
          promise.success(received.toList)
      })

    vertx
      .deployVerticle(nameForVerticle[ReactiveStreamsVerticle])
    promise.future.map(r => r should contain allElementsOf(List(1,2,3,4,5)))
  }

}

class ReactiveStreamsVerticle extends ScalaVerticle {
  override def start() = {
    val producer = vertx.eventBus().sender[Int]("sinkAddress")

    val publisher = new AsyncIterablePublisher[Int](List(1,2,3,4,5).asJava, Executors.newFixedThreadPool(5))
    val rsSource = new ReactiveStreamsPublisherSource[Int](publisher)
    rsSource
      .sink(producer.toSink())

  }
}

