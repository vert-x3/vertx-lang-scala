package io.vertx.lang.scala.testing

import io.vertx.core.Vertx
import io.vertx.lang.scala.*
import io.vertx.lang.scala.json.{Json, JsonObject}
import io.vertx.lang.scala.testing.TypeUtility.typeName
import io.vertx.scala.core.DeploymentOptions
import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AsyncFlatSpec

import scala.concurrent.Await
import scala.concurrent.duration.*
import scala.language.postfixOps
import scala.quoted.{Expr, Quotes, Type}
import scala.reflect.ClassTag
import scala.util.{Failure, Success}

abstract class VerticleTesting[A <: ScalaVerticle](using TypeName[A]) extends AsyncFlatSpec with BeforeAndAfter {
  val vertx: Vertx = Vertx.vertx()
  val typeName = TypeUtility.typeName[A]
  implicit val vertxExecutionContext: VertxExecutionContext = VertxExecutionContext(
    vertx,
    vertx.getOrCreateContext()
  )

  private var deploymentId = ""

  def config(): JsonObject = Json.obj()

  before {
    deploymentId = Await.result(
      vertx
        .deployVerticle("scala:" + typeName, DeploymentOptions().setConfig(config()))
        .asScala()
        .andThen {
          case Success(d) => {
            println(d)
            d
          }
          case Failure(t) => {
            println(t.getMessage)
            throw new RuntimeException(t)
          }
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


