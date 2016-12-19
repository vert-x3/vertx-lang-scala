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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.{Context => JContext}
import io.vertx.core.{Future => JFuture}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.core.{Vertx => JVertx}

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
class Context(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
  def exceptionHandler(handler: Handler[Throwable]):Context = {
    asJava.asInstanceOf[JContext].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

//basic methods
  def runOnContext(action: Handler[Unit]):Unit = {
    asJava.asInstanceOf[JContext].runOnContext({x: Void => action.handle(x)})
  }

  def executeBlocking[T](blockingCodeHandler: Handler[Future[T]],ordered: Boolean,resultHandler: Handler[AsyncResult[T]]):Unit = {
    asJava.asInstanceOf[JContext].executeBlocking[T]({x: JFuture[T] => blockingCodeHandler.handle(Future[T](x))},ordered,{x: AsyncResult[T] => resultHandler.handle(AsyncResultWrapper[T,T](x, a => a))})
  }

  def executeBlocking[T](blockingCodeHandler: Handler[Future[T]],resultHandler: Handler[AsyncResult[T]]):Unit = {
    asJava.asInstanceOf[JContext].executeBlocking[T]({x: JFuture[T] => blockingCodeHandler.handle(Future[T](x))},{x: AsyncResult[T] => resultHandler.handle(AsyncResultWrapper[T,T](x, a => a))})
  }

  def deploymentID():String = {
    asJava.asInstanceOf[JContext].deploymentID()
  }

  def config():io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JContext].config()
  }

  def processArgs():scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JContext].processArgs().asScala.map(x => x)
  }

  def isEventLoopContext():Boolean = {
    asJava.asInstanceOf[JContext].isEventLoopContext()
  }

  def isWorkerContext():Boolean = {
    asJava.asInstanceOf[JContext].isWorkerContext()
  }

  def isMultiThreadedWorkerContext():Boolean = {
    asJava.asInstanceOf[JContext].isMultiThreadedWorkerContext()
  }

  def get[T](key: String):T = {
    asJava.asInstanceOf[JContext].get[T](key)
  }

  def put(key: String,value: AnyRef):Unit = {
    asJava.asInstanceOf[JContext].put(key,value)
  }

  def remove(key: String):Boolean = {
    asJava.asInstanceOf[JContext].remove(key)
  }

  def owner():Vertx = {
    Vertx(asJava.asInstanceOf[JContext].owner())
  }

  def getInstanceCount():Int = {
    asJava.asInstanceOf[JContext].getInstanceCount()
  }

}

object Context{
  def apply(asJava: JContext) = new Context(asJava)
//static methods
  def isOnWorkerThread():Boolean = {
    JContext.isOnWorkerThread()
  }

  def isOnEventLoopThread():Boolean = {
    JContext.isOnEventLoopThread()
  }

  def isOnVertxThread():Boolean = {
    JContext.isOnVertxThread()
  }

}
