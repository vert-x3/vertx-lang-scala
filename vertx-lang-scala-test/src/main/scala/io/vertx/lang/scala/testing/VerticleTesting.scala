package io.vertx.lang.scala.testing

import io.vertx.core.Vertx
import io.vertx.lang.scala._
import io.vertx.lang.scala.json.{Json, JsonObject}
import io.vertx.scala.core.DeploymentOptions
import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AsyncFlatSpec

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.reflect.runtime.universe._
import scala.util.{Failure, Success}

abstract class VerticleTesting[A <: ScalaVerticle: TypeTag] extends AsyncFlatSpec with BeforeAndAfter{
  val vertx = Vertx.vertx()
  implicit val vertxExecutionContext = VertxExecutionContext(
    vertx,
    vertx.getOrCreateContext()
  )

  private var deploymentId = ""

  def config(): JsonObject = Json.obj()

  before {
    deploymentId = Await.result(
      vertx
        .deployVerticle("scala:" + implicitly[TypeTag[A]].tpe.typeSymbol.fullName,
          DeploymentOptions().setConfig(config()))
        .asScala()
        .andThen {
          case Success(d) => d
          case Failure(t) => throw new RuntimeException(t)
        },
      10000 millis
    )
  }

  after {
    Await.result(
      vertx.undeploy(deploymentId)
        .asScala()
        .andThen {
          case Success(d) => d
          case Failure(t) => throw new RuntimeException(t)
        },
      10000 millis
    )
  }

}
