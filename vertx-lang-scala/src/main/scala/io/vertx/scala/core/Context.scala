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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
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

//default methods
//basic methods
  def runOnContext(action: Handler[Unit]):Unit = {
    asJava.asInstanceOf[JContext].runOnContext({x: Void => action.handle(x)})
  }

  def executeBlocking[T:TypeTag](blockingCodeHandler: Handler[Future[T]],ordered: Boolean,resultHandler: Handler[AsyncResult[T]]):Unit = {
    asJava.asInstanceOf[JContext].executeBlocking[Object]({x: JFuture[Object] => blockingCodeHandler.handle(Future[T](x))},ordered.asInstanceOf[java.lang.Boolean],{x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object,T](x, a => toScala[T](a)))})
  }

  def executeBlocking[T:TypeTag](blockingCodeHandler: Handler[Future[T]],resultHandler: Handler[AsyncResult[T]]):Unit = {
    asJava.asInstanceOf[JContext].executeBlocking[Object]({x: JFuture[Object] => blockingCodeHandler.handle(Future[T](x))},{x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object,T](x, a => toScala[T](a)))})
  }

  def deploymentID():String = {
    asJava.asInstanceOf[JContext].deploymentID().asInstanceOf[String]
  }

  def config():scala.Option[io.vertx.core.json.JsonObject] = {
    scala.Option(asJava.asInstanceOf[JContext].config())
  }

  def processArgs():scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JContext].processArgs().asScala.map(x => x.asInstanceOf[String])
  }

  def isEventLoopContext():Boolean = {
    asJava.asInstanceOf[JContext].isEventLoopContext().asInstanceOf[Boolean]
  }

  def isWorkerContext():Boolean = {
    asJava.asInstanceOf[JContext].isWorkerContext().asInstanceOf[Boolean]
  }

  def isMultiThreadedWorkerContext():Boolean = {
    asJava.asInstanceOf[JContext].isMultiThreadedWorkerContext().asInstanceOf[Boolean]
  }

  def get[T:TypeTag](key: String):T = {
    toScala[T](asJava.asInstanceOf[JContext].get[Object](key.asInstanceOf[java.lang.String]))
  }

  def put(key: String,value: AnyRef):Unit = {
    asJava.asInstanceOf[JContext].put(key.asInstanceOf[java.lang.String],toJava[Object](value))
  }

  def remove(key: String):Boolean = {
    asJava.asInstanceOf[JContext].remove(key.asInstanceOf[java.lang.String]).asInstanceOf[Boolean]
  }

  def owner():Vertx = {
    Vertx(asJava.asInstanceOf[JContext].owner())
  }

  def getInstanceCount():Int = {
    asJava.asInstanceOf[JContext].getInstanceCount().asInstanceOf[Int]
  }

//future methods
  def executeBlockingFuture[T:TypeTag](blockingCodeHandler: Handler[Future[T]],ordered: Boolean):scala.concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, T](x => if (x == null) null.asInstanceOf[T] else toScala[T](x))
    asJava.asInstanceOf[JContext].executeBlocking[Object]({x: JFuture[Object] => blockingCodeHandler.handle(Future[T](x))},ordered.asInstanceOf[java.lang.Boolean],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def executeBlockingFuture[T:TypeTag](blockingCodeHandler: Handler[Future[T]]):scala.concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, T](x => if (x == null) null.asInstanceOf[T] else toScala[T](x))
    asJava.asInstanceOf[JContext].executeBlocking[Object]({x: JFuture[Object] => blockingCodeHandler.handle(Future[T](x))},promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object Context{
    def apply(asJava: JContext) = new Context(asJava)  
  //static methods
    def isOnWorkerThread():Boolean = {
      JContext.isOnWorkerThread().asInstanceOf[Boolean]
    }

    def isOnEventLoopThread():Boolean = {
      JContext.isOnEventLoopThread().asInstanceOf[Boolean]
    }

    def isOnVertxThread():Boolean = {
      JContext.isOnVertxThread().asInstanceOf[Boolean]
    }

  }
