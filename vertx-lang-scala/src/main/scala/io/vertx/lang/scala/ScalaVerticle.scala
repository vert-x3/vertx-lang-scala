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
import io.vertx.core.*
import io.vertx.lang.scala.VertxExecutionContext

import scala.collection.mutable
import scala.compiletime.uninitialized
import scala.concurrent.Future
import scala.jdk.CollectionConverters.*
import scala.reflect.ClassTag
import scala.util.{Failure, Success}

/**
 * Base class for verticle implementations.
 *
 * @author <a href="mailto:jochen@codepitbull.de">Jochen Mader</a
 */
abstract class ScalaVerticle:
  protected var executionContext: VertxExecutionContext = uninitialized
  given ec: VertxExecutionContext = executionContext
  protected var vertx: Vertx = uninitialized
  protected var ctx: Context = uninitialized
  private var javaVerticle: AbstractVerticle = uninitialized

  /**
   * Initialise the verticle.<p>
   * This is called by Vert.x when the verticle instance is deployed. Don't call it yourself.
   *
   * @param vertx   the deploying Vert.x instance
   * @param context the context of the verticle
   */
  def init(vertx: Vertx, context: Context, verticle: AbstractVerticle): Unit =
    this.vertx = vertx
    this.ctx = context
    this.javaVerticle = verticle
    this.executionContext = VertxExecutionContext(vertx, this.vertx.getOrCreateContext())

  /**
   * Start the verticle.
   */
  def start(): Unit = ()

  /**
   * Stop the verticle.
   */
  def stop(): Unit = ()

  /**
   * Start the verticle.
   */
  def start(promise: concurrent.Promise[Unit]): Unit = {
    start()
    promise.complete(Success(()))
  }

  /**
   * Stop the verticle.
   */
  def stop(promise: concurrent.Promise[Unit]): Unit = {
    stop()
    promise.complete(Success(()))
  }

  /**
   * Start the verticle.
   * This is called by Vert.x when the verticle instance is deployed. Don't call it yourself.
   *
   * If your verticle does things in its startup which take some time then you can override this method
   * and return a [[concurrent.Future]] completed with the start up is complete. Propagating a failure fails the deployment
   * of the verticle
   *
   * @return a [[concurrent.Future]], completed when the start up completes, or failed if the verticle cannot be started.
   */
  def asyncStart: concurrent.Future[Unit] =
    val promise = concurrent.Promise[Unit]()
    start(promise)
    promise.future

  /**
   * Stop the verticle.
   * This is called by Vert.x when the verticle instance is un-deployed. Don't call it yourself.
   *
   * If your verticle does things in its shut-down which take some time then you can override this method and return
   * a [[concurrent.Future]] completed when the clean-up is complete.
   *
   * @return a [[concurrent.Future]] completed when the clean-up completes, or failed if the verticle cannot be stopped gracefully.
   */
  def asyncStop: concurrent.Future[Unit] =
    val promise = concurrent.Promise[Unit]()
    stop(promise)
    promise.future

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

  def asJava: Verticle = new AbstractVerticle {
    private val that = ScalaVerticle.this
    override def init(vertx: io.vertx.core.Vertx, context: io.vertx.core.Context): Unit = {
      super.init(vertx, context)
      ScalaVerticle.this.init(vertx, context, this)
    }

    override final def start(startPromise: Promise[Void]): Unit =
      that.asyncStart.onComplete {
        case Failure(exception) => startPromise.fail(exception)
        case Success(_)         => startPromise.complete()
      }


    override final def stop(stopPromise: Promise[Void]): Unit =
      that.asyncStop.onComplete {
        case Failure(exception) => stopPromise.fail(exception)
        case Success(_)         => stopPromise.complete()
      }

  }
end ScalaVerticle

object ScalaVerticle:
  def nameForVerticle[A <: ScalaVerticle : ClassTag](): String = {
    "scala:" + implicitly[ClassTag[A]].runtimeClass.getTypeName
  }
