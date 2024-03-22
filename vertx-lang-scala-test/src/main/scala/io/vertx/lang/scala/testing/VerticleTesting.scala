package io.vertx.lang.scala.testing

import io.vertx.core.Vertx
import io.vertx.lang.scala.*
import io.vertx.lang.scala.json.{Json, JsonObject}
import io.vertx.lang.scala.testing.TypeUtility.typeName
import io.vertx.scala.core.DeploymentOptions
import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AsyncFlatSpec
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.Await
import scala.concurrent.duration.*
import scala.language.postfixOps
import scala.util.{Failure, Success}

abstract class VerticleTesting[A <: ScalaVerticle](using TypeName[A]) extends AsyncFlatSpec, BeforeAndAfter:
  val vertx: Vertx                                   = Vertx.vertx()
  val typeName: String                               = TypeUtility.typeName[A]
  val log: Logger                                    = LoggerFactory.getLogger(typeName)
  given vertxExecutionContext: VertxExecutionContext = VertxExecutionContext(vertx, vertx.getOrCreateContext())
  private var deploymentId                           = ""

  def config(): JsonObject = Json.obj()

  before {
    log.info(s"Deploying $typeName...")
    deploymentId = Await.result(
      vertx
        .deployVerticle("scala:" + typeName, DeploymentOptions().setConfig(config()))
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
    log.info(s"Undeploying $typeName...")
    Await.result(
      vertx
        .undeploy(deploymentId)
        .asScala
        .andThen {
          case Success(_) => log.info(s"$typeName undeployed")
          case Failure(t) => throw new RuntimeException(t)
        },
      10000 millis
    )
  }
