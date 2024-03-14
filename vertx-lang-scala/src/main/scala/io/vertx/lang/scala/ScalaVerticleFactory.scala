/*
 * Copyright (c) 2011-2016 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 *     The Eclipse Public License is available at
 *     http://www.eclipse.org/legal/epl-v10.html
 *
 *     The Apache License v2.0 is available at
 *     http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.lang.scala

import java.util.concurrent.Callable
import io.vertx.core.{Promise, Verticle, Vertx}
import io.vertx.core.spi.VerticleFactory

import scala.compiletime.uninitialized

/**
 * Factory for creating Verticle-Instances from a compiled class or scala source code.
 *
 * @author <a href="mailto:jochen@codepitbull.de">Jochen Mader</a
 * @author <a href="http://www.campudus.com/">Joern Bernhardt</a>
 */
class ScalaVerticleFactory extends VerticleFactory {

  private var vertx: Vertx = uninitialized

  override def init(vertx: Vertx): Unit = this.vertx = vertx

  override def prefix(): String = "scala"

  override def close(): Unit = this.vertx = null


  override def createVerticle(verticleName: String, classLoader: ClassLoader, promise: Promise[Callable[Verticle]]): Unit =
    promise.complete(() => {
      verticleFromClass(verticleName, classLoader)
    })

  private def verticleFromClass(verticleName: String, classLoader: ClassLoader): Verticle = {
    val clazz = classLoader.loadClass(verticleName.replace("scala:",""))
    val instance = clazz.getDeclaredConstructor().newInstance().asInstanceOf[ScalaVerticle]
    instance.asJava
  }
}
