package io.vertx.lang.scala.stream

import io.vertx.lang.scala.ScalaVerticle.nameForVerticle
import io.vertx.lang.scala.stream.Rs._
import io.vertx.lang.scala.stream.builder.StreamBuilder
import io.vertx.lang.scala.stream.sink.FunctionSink
import io.vertx.lang.scala.stream.source.VertxListSource
import io.vertx.lang.scala.{ScalaVerticle, VertxExecutionContext}
import io.vertx.scala.core.Vertx
import io.vertx.scala.core.eventbus.{MessageConsumer, MessageProducer}
import io.vertx.scala.core.streams.ReadStream
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Assertions, AsyncFlatSpec, Matchers}

import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class RsTest extends AsyncFlatSpec with Matchers with Assertions {

  "Streaming through a Future" should "work" in {
    val vertx = Vertx.vertx
    val ctx = vertx.getOrCreateContext()
    val builder = StreamBuilder[Int](new VertxListSource[Int](ctx, List(1,2,3,5,8)))

    val prom = Promise[String]

    implicit val global = VertxExecutionContext(ctx)
    val sink = new FunctionSink[String](s => prom.success(s))

    println(Thread.currentThread().getName)

    builder
      .map(r => s"HALLO $r")
      .process(s => println(s"vertx ${Thread.currentThread().getName}"))
      .future(f => Future({
        f+" "+Thread.currentThread().getId
      }))
      .sink(sink)

    prom.future.map(s => s should startWith("HALLO "))
  }

  "ReadStream/WriteStream combin inside a Verticle" should "work" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())

    val result = Promise[String]
    vertx.eventBus()
      .localConsumer[String]("transformed")
      .handler(m => result.success(m.body()))

    vertx
      .deployVerticleFuture(nameForVerticle[StreamVerticle])
      .onComplete{
        case Failure(t) => t.printStackTrace()
        case Success(s) => vertx.eventBus().send("stream", "Welt")
      }
    result.future.map(r => r should equal("HALLO Welt"))
  }
}

class StreamVerticle extends ScalaVerticle {

  /**
    * Start the verticle.<p>
    * This is called by Vert.x when the verticle instance is deployed. Don't call it yourself.<p>
    * If your verticle does things in it's startup which take some time then you can override this method
    * and complete the future some time later when start up is complete.
    *
    * @return a future which should be completed when verticle start-up is complete.
    */
  override def startFuture() = {
    val reader:MessageConsumer[String] = vertx.eventBus().consumer[String]("stream")
    val bodyStream:ReadStream[String] = reader.bodyStream()

    val writer:MessageProducer[String] = vertx.eventBus().publisher[String]("transformed")

    bodyStream.toSource()
      .map("HALLO " + _)
      .sink(writer.toSink())

    reader.completionFuture()
  }
}
