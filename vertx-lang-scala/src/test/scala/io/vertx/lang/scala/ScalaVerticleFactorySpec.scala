package io.vertx.lang.scala

import java.io.File
import java.nio.file.Files
import java.util.concurrent.Callable
import io.vertx.core.{AsyncResult, Handler, Verticle, Vertx, Promise => VertxPromise}
import org.scalatest.concurrent.PatienceConfiguration.Timeout
import org.scalatest.time.SpanSugar._
import org.scalatest.concurrent.ScalaFutures.whenReady
import org.scalatest.matchers.should.Matchers
import org.scalatest.flatspec.AsyncFlatSpec
import language.postfixOps
import scala.concurrent.Promise

class ScalaVerticleFactorySpec extends AsyncFlatSpec with Matchers {

  val defaultPatience = Timeout(2 seconds)
  val vertx: Vertx    = Vertx.vertx

  "ScalaVerticleFactory" should "deploy a ScalaVerticle" in {
    for {
      deploymentId <- vertx.deployVerticle(s"scala:${classOf[TestVerticle].getName}").asScala
      assertion = deploymentId should not be empty
    }
    yield assertion
  }

  "A bare Scala-Verticle" should "compile and deploy on the fly" in {
    val promise = Promise[String]()
    val vertx = Vertx.vertx()
    val dir = Files.createTempDirectory("clazzes")
    val file = new File(dir.toString, "ScalaTestVerticle.scala")
    val rs = getClass.getClassLoader.getResourceAsStream("ScalaTestVerticle.scala")
    Files.copy(rs, file.toPath)

    val scalaVerticleFactory = new ScalaVerticleFactory
    val verticlePromise: VertxPromise[Callable[Verticle]] = VertxPromise.promise()
    scalaVerticleFactory.createVerticle(file.toPath.toString, getClass.getClassLoader, verticlePromise)
    verticlePromise.future().onComplete(v => {
      vertx.deployVerticle(v.result().call(), new Handler[AsyncResult[java.lang.String]] {
          override def handle(event: AsyncResult[String]): Unit = promise.success(event.result())
        })
    })

    whenReady(promise.future, defaultPatience) {_ shouldNot be(null)}
  }

  "A bare Scala-Verticle from the classpath" should "compile and deploy on the fly" in {
    val promise = Promise[String]()
    val vertx = Vertx.vertx()
    val scalaVerticleFactory = new ScalaVerticleFactory

    val verticlePromise: VertxPromise[Callable[Verticle]] = VertxPromise.promise()
    scalaVerticleFactory.createVerticle("ScalaTestVerticle2.scala", getClass.getClassLoader, verticlePromise)
    verticlePromise.future().onComplete(v => {
      vertx.deployVerticle(v.result().call(), new Handler[AsyncResult[java.lang.String]] {
        override def handle(event: AsyncResult[String]): Unit = promise.success(event.result())
      })
    })

    whenReady(promise.future, defaultPatience) {_ shouldNot be(null)}
  }
}
