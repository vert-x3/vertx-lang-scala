package examples

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Sink, Source}
import io.vertx.lang.scala.ScalaVerticle
import io.vertx.lang.scala.streams.Rs._
import org.reactivestreams.Publisher

/**
  * A [[ScalaVerticle]] taht sends numbers produced by an akka-flow to
  * a eventbus address.
  */
class VertxAkkaVerticle extends ScalaVerticle{
  override def start(): Unit = {
    val producer = vertx.eventBus().sender[Int]("sinkAddress")

    akkaFlow.toSource
      .sink(producer.toSink())
  }

  def akkaFlow: Publisher[Int] = {
    implicit val system = ActorSystem("reactive-streams-test")
    implicit val materializer = ActorMaterializer()
    val source: Source[Int, NotUsed] = Source(0 to 100)
      .map(a => a + 1)
    source.runWith(Sink.asPublisher(false))
  }
}
