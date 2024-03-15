package io.vertx.lang.scala

import io.vertx.core
import io.vertx.core.Vertx
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import org.scalatest.concurrent.PatienceConfiguration.Timeout
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.SpanSugar.*

import scala.language.{implicitConversions, postfixOps}

class ScalaVerticleFactorySpec extends AsyncFlatSpec, Matchers:

  val defaultPatience: Timeout = Timeout(2 seconds)
  val vertx: Vertx             = Vertx.vertx()

  "ScalaVerticleFactory" should "deploy a ScalaVerticle" in:
    for
      deploymentId <- vertx.deployVerticle(s"scala:${classOf[TestVerticle].getName}")
      assertion = deploymentId should not be empty
    yield assertion

//  "A bare Scala-Verticle" should "compile and deploy on the fly" in {
//    val promise = Promise[String]()
//    val vertx = Vertx.vertx()
//    val dir = Files.createTempDirectory("clazzes")
//    val file = new File(dir.toString, "ScalaTestVerticle.scala")
//    val rs = getClass.getClassLoader.getResourceAsStream("ScalaTestVerticle.scala")
//    Files.copy(rs, file.toPath)
//
//    val scalaVerticleFactory = new ScalaVerticleFactory
//    val verticlePromise: core.Promise[Callable[Verticle]] = core.Promise.promise()
//    scalaVerticleFactory.createVerticle(file.toPath.toString, getClass.getClassLoader, verticlePromise)
//    verticlePromise.future().onComplete(v => {
//      vertx.deployVerticle(v.result().call(), new Handler[AsyncResult[java.lang.String]] {
//          override def handle(event: AsyncResult[String]): Unit = promise.success(event.result())
//        })
//    })
//
//    whenReady(promise.future, defaultPatience) {_ shouldNot be(null)}
//  }
//
//  "A bare Scala-Verticle from the classpath" should "compile and deploy on the fly" in {
//    val promise = Promise[String]()
//    val vertx = Vertx.vertx()
//    val scalaVerticleFactory = new ScalaVerticleFactory
//
//    val verticlePromise:core.Promise[Callable[Verticle]] = core.Promise.promise()
//    scalaVerticleFactory.createVerticle("ScalaTestVerticle2.scala", getClass.getClassLoader, verticlePromise)
//    verticlePromise.future().onComplete(v => {
//      vertx.deployVerticle(v.result().call(), new Handler[AsyncResult[java.lang.String]] {
//        override def handle(event: AsyncResult[String]): Unit = promise.success(event.result())
//      })
//    })
//
//    whenReady(promise.future, defaultPatience) {_ shouldNot be(null)}
//  }
