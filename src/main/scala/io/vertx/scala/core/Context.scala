/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.core

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.Handler

/**
  * The execution context of a scala-function execution.
  * 
  * When Vert.x provides an event to a handler or calls the start or stop methods of a [[io.vertx.lang.scala.ScalaVerticle]],
  * the execution is associated with a `Context`.
  * 
  * Usually a context is an *event-loop context* and is tied to a specific event loop thread. So executions for that
  * context always occur on that exact same event loop thread.
  * 
  * In the case of worker verticles and running inline blocking code a worker context will be associated with the execution
  * which will use a thread from the worker thread pool.
  * 
  * When a handler is set by a thread associated with a specific context, the Vert.x will guarantee that when that handler
  * is executed, that execution will be associated with the same context.
  * 
  * If a handler is set by a thread not associated with a context (i.e. a non Vert.x thread). Then a new context will
  * be created for that handler.
  * 
  * In other words, a context is propagated.
  * 
  * This means that when a verticle is deployed, any handlers it sets will be associated with the same context - the context
  * of the verticle.
  * 
  * This means (in the case of a standard verticle) that the verticle code will always be executed with the exact same
  * thread, so you don't have to worry about multi-threaded acccess to the verticle state and you can code your application
  * as single threaded.
  * 
  * This class also allows arbitrary data to be [[io.vertx.scala.core.Context#put]] and [[io.vertx.scala.core.Context#get]] on the context so it can be shared easily
  * amongst different handlers of, for example, a verticle instance.
  * 
  * This class also provides [[io.vertx.scala.core.Context#runOnContext]] which allows an action to be executed asynchronously using the same context.
  */
class Context(private val _asJava: io.vertx.core.Context) {

  def asJava: io.vertx.core.Context = _asJava

  /**
    * Run the specified action asynchronously on the same context, some time after the current execution has completed.
    * @param action the action to run
    */
  def runOnContext(action: () => Unit): Unit = {
    _asJava.runOnContext(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => action()))
  }

  /**
    * Safely execute some blocking code.
    * 
    * Executes the blocking code in the handler `blockingCodeHandler` using a thread from the worker pool.
    * 
    * When the code is complete the handler `resultHandler` will be called with the result on the original context
    * (e.g. on the original event loop of the caller).
    * 
    * A `Future` instance is passed into `blockingCodeHandler`. When the blocking code successfully completes,
    * the handler should call the [[io.vertx.scala.core.Future#complete]] or [[io.vertx.scala.core.Future#complete]] method, or the [[io.vertx.scala.core.Future#fail]]
    * method if it failed.
    * @param blockingCodeHandler handler representing the blocking code to run
    * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
    * @return future that will be called when the blocking code is complete
    */
  def executeBlockingFuture[T](blockingCodeHandler: io.vertx.scala.core.Future[T] => Unit, ordered: Boolean): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T,T]((x => x))
    _asJava.executeBlocking(funcToMappedHandler(Future.apply[T])(blockingCodeHandler), ordered, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Invoke [[io.vertx.scala.core.Context#executeBlocking]] with order = true.
    * @param blockingCodeHandler handler representing the blocking code to run
    * @return future that will be called when the blocking code is complete
    */
  def executeBlockingFuture[T](blockingCodeHandler: io.vertx.scala.core.Future[T] => Unit): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T,T]((x => x))
    _asJava.executeBlocking(funcToMappedHandler(Future.apply[T])(blockingCodeHandler), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * If the context is associated with a Verticle deployment, this returns the deployment ID of that deployment.
    * @return the deployment ID of the deployment or null if not a Verticle deployment
    */
  def deploymentID(): String = {
    _asJava.deploymentID()
  }

  /**
    * If the context is associated with a Verticle deployment, this returns the configuration that was specified when
    * the verticle was deployed.
    * @return the configuration of the deployment or null if not a Verticle deployment
    */
  def config(): scala.Option[io.vertx.core.json.JsonObject] = {
        scala.Option(_asJava.config())
  }

  /**
    * The process args
    */
  def processArgs(): scala.collection.mutable.Buffer[String] = {
    _asJava.processArgs().asScala.map(x => x:String)
  }

  /**
    * Is the current context an event loop context?
    * 
    * NOTE! when running blocking code using [[io.vertx.scala.core.Vertx#executeBlocking]] from a
    * standard (not worker) verticle, the context will still an event loop context and this 
    * will return true.
    * @return true if false otherwise
    */
  def isEventLoopContext(): Boolean = {
    _asJava.isEventLoopContext()
  }

  /**
    * Is the current context a worker context?
    * 
    * NOTE! when running blocking code using [[io.vertx.scala.core.Vertx#executeBlocking]] from a
    * standard (not worker) verticle, the context will still an event loop context and this 
    * will return false.
    * @return true if the current context is a worker context, false otherwise
    */
  def isWorkerContext(): Boolean = {
    _asJava.isWorkerContext()
  }

  /**
    * Is the current context a multi-threaded worker context?
    * @return true if the current context is a multi-threaded worker context, false otherwise
    */
  def isMultiThreadedWorkerContext(): Boolean = {
    _asJava.isMultiThreadedWorkerContext()
  }

  /**
    * Get some data from the context.
    * @param key the key of the data
    * @return the data
    */
  def get[T](key: String): T = {
    _asJava.get(key)
  }

  /**
    * Put some data in the context.
    * 
    * This can be used to share data between different handlers that share a context
    * @param key the key of the data
    * @param value the data
    */
  def put(key: String, value: AnyRef): Unit = {
    _asJava.put(key, value)
  }

  /**
    * Remove some data from the context.
    * @param key the key to remove
    * @return true if removed successfully, false otherwise
    */
  def remove(key: String): Boolean = {
    _asJava.remove(key)
  }

  /**
    * @return The Vertx instance that created the context
    */
  def owner(): io.vertx.scala.core.Vertx = {
    Vertx.apply(_asJava.owner())
  }

  /**
    * @return  the number of instances of the verticle that were deployed in the deployment (if any) related
    * to this context
    */
  def getInstanceCount(): Int = {
    _asJava.getInstanceCount()
  }

  /**
    * Set an exception handler called when the context runs an action throwing an uncaught throwable.<p/>
    *
    * When this handler is called, [[io.vertx.scala.core.Vertx#currentContext]] will return this context.
    * @param handler the exception handler
    * @return a reference to this, so the API can be used fluently
    */
  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.Context = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

}

object Context {

  def apply(_asJava: io.vertx.core.Context): io.vertx.scala.core.Context =
    new io.vertx.scala.core.Context(_asJava)

  def isOnWorkerThread(): Boolean = {
    io.vertx.core.Context.isOnWorkerThread()
  }

  def isOnEventLoopThread(): Boolean = {
    io.vertx.core.Context.isOnEventLoopThread()
  }

  def isOnVertxThread(): Boolean = {
    io.vertx.core.Context.isOnVertxThread()
  }

}
