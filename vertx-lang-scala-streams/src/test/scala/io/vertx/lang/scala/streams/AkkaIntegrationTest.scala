package io.vertx.lang.scala.streams

import java.util.concurrent.CopyOnWriteArrayList

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Flow, Sink, Source}
import io.vertx.lang.scala.VertxExecutionContext
import io.vertx.lang.scala.streams.Rs._
import io.vertx.lang.scala.streams.source.VertxListSource
import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Assertions, AsyncFlatSpec, Matchers}

import scala.collection.mutable
import scala.collection.JavaConverters._
import scala.concurrent.Promise


@RunWith(classOf[JUnitRunner])
class AkkaIntegrationTest extends AsyncFlatSpec with Matchers with Assertions {

  "Using Akka-Stream as a Source in Vert.x" should "work" in {
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

      implicit val system = ActorSystem("reactive-streams-test")
      implicit val materializer = ActorMaterializer()
      val source: Source[Int, NotUsed] = Source(0 to 100)
        .map(a => a + 1)
      val src = source.runWith(Sink.asPublisher(false))

      src.toSource
        .sink(producer.toSink())
    })

    prom.future.map(s => s should equal(List(1, 2, 3, 4, 5)))

  }

  "Using Akka-Stream as a Sink in Vert.x" should "work" in {
    val vertx = Vertx.vertx()
    val ctx = vertx.getOrCreateContext()
    implicit val ec = VertxExecutionContext(ctx)

    val prom = Promise[List[String]]

    ec.execute(() => {
      implicit val system = ActorSystem("reactive-streams-test")
      implicit val materializer = ActorMaterializer()

      val received = new CopyOnWriteArrayList[String]()

      val akkaFlow = Flow[Int]
        .map(a => s"Akka $a")
        .to(Sink.foreach[String](a => {
          received.add(a)
          if(received.size() == 5) {
            prom.success(received.asScala.toList)
            cancel()
          }
        }))
        .runWith(Source.asSubscriber[Int])

      new VertxListSource(List(1, 2, 3, 4, 5))
        .sink(akkaFlow.toSink)

    })

    prom.future.map(s => s should equal(List("Akka 1", "Akka 2", "Akka 3", "Akka 4", "Akka 5")))

  }
}
