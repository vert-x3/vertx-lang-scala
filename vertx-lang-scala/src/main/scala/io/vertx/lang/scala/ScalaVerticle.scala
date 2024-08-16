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

import io.vertx.core.json.JsonObject
import io.vertx.core.{AbstractVerticle, Context, Promise, Verticle, Vertx}
import io.vertx.lang.scala.conv.newPromise

import scala.util.Success
import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.reflect.ClassTag

/**
  * Base class for verticle implementations.
  *
  * @author <a href="mailto:jochen@codepitbull.de">Jochen Mader</a
  */
abstract class ScalaVerticle {
  protected implicit var executionContext:VertxExecutionContext = _
  protected var vertx: Vertx = _
  protected var ctx: Context = _
  private var javaVerticle: AbstractVerticle = _

  /**
    * Initialise the verticle.<p>
    * This is called by Vert.x when the verticle instance is deployed. Don't call it yourself.
    *
    * @param vertx   the deploying Vert.x instance
    * @param context the context of the verticle
    */
  def init(vertx: io.vertx.core.Vertx, context: io.vertx.core.Context, verticle: AbstractVerticle): Unit = {
    this.vertx = vertx
    this.ctx = context
    this.javaVerticle = verticle
    this.executionContext = VertxExecutionContext(vertx, this.vertx.getOrCreateContext())
  }

  /**
    * Start the verticle.
    */
  def start(): Unit = {
  }

  /**
    * Stop the verticle.
    */
  def stop(): Unit = {
  }


  /**
   * Start the verticle.
   */
  def start(promise: concurrent.Promise[Unit]) {
    start()
    promise.complete(Success(()))
  }

  /**
   * Stop the verticle.
   */
  def stop(promise: concurrent.Promise[Unit]) {
    stop()
    promise.complete(Success(()))
  }

  /**
    * Get the deployment ID of the verticle deployment
    *
    * @return the deployment ID
    */
  def deploymentID: String = javaVerticle.deploymentID()

  /**
    * Get the configuration of the verticle.
    * <p>
    * This can be specified when the verticle is deployed.
    *
    * @return the configuration
    */
  def config: JsonObject = javaVerticle.config()

  /**
    * Get the arguments used when deploying the Vert.x process.
    *
    * @return the list of arguments
    */
  def processArgs: mutable.Buffer[String] = javaVerticle.processArgs().asScala

  def asJava(): Verticle = new AbstractVerticle {
    private val that = ScalaVerticle.this
    override def init(vertx: io.vertx.core.Vertx, context: io.vertx.core.Context): Unit = {
      super.init(vertx, context)
      ScalaVerticle.this.init(vertx, context, this)
    }

    override final def start(startPromise: Promise[Void]): Unit = {
      that.start(toScalaPromiseUnit(startPromise))
    }

    override final def stop(stopPromise: Promise[Void]): Unit = {
      that.stop(toScalaPromiseUnit(stopPromise))
    }

    private def toScalaPromiseUnit(promise: Promise[Void]) = {
      val scalaPromise = newPromise[Unit]()

      scalaPromise.future.onComplete(scalaTry => {
        //Not doing pattern matching because of import shenanigans when
        //getting stuff from scala-package
        try {
          //get without exception is a success
          scalaTry.get
          promise.complete()
        } catch {
          case e: Throwable => promise.fail(e)
        }
      })

      scalaPromise
    }
  }
}

object ScalaVerticle {
  def nameForVerticle[A <: ScalaVerticle: ClassTag]():String = {
    "scala:"+implicitly[ClassTag[A]].runtimeClass.getTypeName
  }
}
