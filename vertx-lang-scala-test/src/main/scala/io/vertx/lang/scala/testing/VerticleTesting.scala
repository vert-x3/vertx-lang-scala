package io.vertx.lang.scala.testing

import io.vertx.core.Vertx
import io.vertx.lang.scala.*
import io.vertx.lang.scala.json.{Json, JsonObject}
import io.vertx.lang.scala.testing.TypeUtility.typeName
import io.vertx.scala.core.DeploymentOptions
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AsyncFlatSpec
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.Await
import scala.concurrent.duration.*
import scala.language.postfixOps
import scala.util.{Failure, Success}

abstract class VerticleTesting[A <: ScalaVerticle](using TypeName[A]) extends AsyncFlatSpec, BeforeAndAfterAll:
  val vertx: Vertx                                   = Vertx.vertx()
  private val typeName: String                       = TypeUtility.typeName[A]
  private val log: Logger                            = LoggerFactory.getLogger(typeName)
  private var deploymentId                           = ""
  given vertxExecutionContext: VertxExecutionContext = VertxExecutionContext(vertx, vertx.getOrCreateContext())

  private def config(): JsonObject = Json.obj()

  override def beforeAll(): Unit = {
    log.info(s"Deploying $typeName...")
    deploymentId = Await.result(
      vertx
        .deployVerticle("scala:" + typeName, DeploymentOptions().setConfig(config()))
        .asScala
        .andThen {
          case Success(id) => log.info("Deployment of {} done, got ID: {}", typeName, id)
          case Failure(ex) => log.error("Deployment of {} failed: {}", typeName, ex.getMessage)
        },
      10000 millis
    )
  }

  override def afterAll(): Unit = {
    log.info(s"Undeploying $typeName...")
    Await.result(
      vertx
        .undeploy(deploymentId)
        .asScala
        .andThen {
          case Success(_) => log.info("{} undeployed", typeName)
          case Failure(t) => log.error("Cannot undeploy {}", typeName, t)
        },
      10000 millis
    )
  }
