package io.vertx.lang.scala.testing

import io.vertx.core.Vertx
import io.vertx.lang.scala.*
import io.vertx.lang.scala.json.Json
import io.vertx.scala.core.{DeploymentOptions, JsonObject}
import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AsyncFlatSpec
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.Await
import scala.concurrent.duration.*
import scala.language.postfixOps
import scala.reflect.runtime.universe.*
import scala.util.{Failure, Success}

abstract class VerticleTesting[A <: ScalaVerticle: TypeTag] extends AsyncFlatSpec with BeforeAndAfter{
  val vertx = Vertx.vertx
  val typeName: String = implicitly[TypeTag[A]].tpe.typeSymbol.fullName
  val log: Logger      = LoggerFactory.getLogger(typeName)
  implicit val vertxExecutionContext: VertxExecutionContext = VertxExecutionContext( vertx, vertx.getOrCreateContext() )

  private var deploymentId = ""

  def config: JsonObject = Json.obj()

  before {
    log.info(s"Deploying $typeName...")
    deploymentId = Await.result(
      vertx
        .deployVerticle("scala:" + typeName, DeploymentOptions(config))
        .asScala
        .andThen {
          case Success(id) =>
            log.info(s"Deployment of $typeName done, got ID: $id")
            id
          case Failure(t)  =>
            log.error(s"Deployment of $typeName failed: ${t.getMessage}")
            throw new RuntimeException(t)
        },
      10000 millis
    )
  }

  after {
    if(deploymentId.nonEmpty) {
      log.info(s"Undeploying $typeName...")
      Await.result(
        vertx.undeploy(deploymentId)
          .asScala
          .andThen {
          case Success(_) => log.info(s"$typeName undeployed")
            case Failure(t) => throw new RuntimeException(t)
          },
        10000 millis
      )
    }
  }
}
