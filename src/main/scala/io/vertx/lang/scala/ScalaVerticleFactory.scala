package io.vertx.lang.scala

import io.vertx.core.{Vertx, Verticle}
import io.vertx.core.spi.VerticleFactory
import io.vertx.scala.core.ScalaVerticle

/**
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
