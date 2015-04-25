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

package io.vertx.scala.core;

import io.vertx.core.json.JsonObject
import io.vertx.core.Handler

/**
  * The execution context of a [[io.vertx.core.Handler]] execution.
  * 
  * When Vert.x provides an event to a handler or calls the start or stop methods of a [[io.vertx.core.Verticle]],
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

  def asJava: java.lang.Object = _asJava

  /**
    * Run the specified action asynchronously on the same context, some time after the current execution has completed.
    * @param action the action to run
    */
  def runOnContext(action: => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.runOnContext(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>action))
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
  def config(): io.vertx.core.json.JsonObject = {
    _asJava.config()
  }

  /**
    * The process args
    */
  def processArgs(): List[String] = {
    import scala.collection.JavaConverters._
    _asJava.processArgs().asScala.map(x => x:String).toList
  }

  /**
    * @return true if this is an event loop context, false otherwise
    */
  def isEventLoopContext(): Boolean = {
    _asJava.isEventLoopContext()
  }

  /**
    * @return true if this is an worker context, false otherwise
    */
  def isWorker(): Boolean = {
    _asJava.isWorker()
  }

  /**
    * @return true if this is a multi-threaded worker context, false otherwise
    */
  def isMultiThreaded(): Boolean = {
    _asJava.isMultiThreaded()
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

}

object Context {

  def apply(_asJava: io.vertx.core.Context): io.vertx.scala.core.Context =
    new io.vertx.scala.core.Context(_asJava)
}
