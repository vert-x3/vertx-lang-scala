package io.vertx.lang.scala

import io.vertx.core.{DeploymentOptions, Vertx, Verticle}
import io.vertx.core.Future;
import io.vertx.core.spi.VerticleFactory

/**
 * Factory for creating Verticle-Instances from a compiled class or scala source code.
 *
 * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
 * @author <a href="http://www.campudus.com/">Joern Bernhardt</a>
 */
class ScalaVerticleFactory extends VerticleFactory {

  private var vertx: Vertx = null

  override def init(vertx: Vertx): Unit = this.vertx = vertx

  override def prefix(): String = "scala"

  override def close(): Unit = this.vertx = null

  override def createVerticle(verticleName: String, classLoader: ClassLoader): Verticle =
    if (verticleName.endsWith(".scala")) {
      verticleFromSource(verticleName, classLoader)
    } else {
      verticleFromClass(verticleName, classLoader)
    }

  private def verticleFromSource(verticleName: String, classLoader: ClassLoader): Verticle =
    throw new NotImplementedError("not yet implemented")

  private def verticleFromClass(verticleName: String, classLoader: ClassLoader): Verticle = {
    val clazz = classLoader.loadClass(verticleName)
    val instance = clazz.newInstance().asInstanceOf[ScalaVerticle]
    instance.asJava
  }
}
