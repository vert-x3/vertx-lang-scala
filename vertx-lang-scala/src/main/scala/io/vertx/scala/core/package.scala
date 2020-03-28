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


package io.vertx.scala

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core.buffer.Buffer
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
package object core{


  import io.vertx.core.json.{JsonObject => JJsonObject}
  import io.vertx.core.json.{JsonArray => JJsonArray}

  type JsonObject = JJsonObject
  type JsonArray = JJsonArray

  object JsonObject {
    def apply(): JsonObject = new JJsonObject()
    def apply(json: String): JsonObject = new JJsonObject(json)
    def apply(fields: (String, Any)*): JsonObject = {
      val o = new JsonObject()
      fields.foreach {
        case (key, l: Array[_]) => o.put(key, listToJsArr(l))
        case (key, l: Seq[_]) => o.put(key, listToJsArr(l))
        case (key, value) => o.put(key, value)
      }
      o
    }
  }

  object JsonArray {
    def apply(): JsonArray = new JJsonArray()
    def apply(json: String): JsonArray = new JJsonArray(json)
    def apply(fields: Any*): JsonArray = {
      val a = new JsonArray()
      fields.foreach {
        case array: Array[_] => a.add(listToJsArr(array))
        case seq: Seq[_] => a.add(listToJsArr(seq))
        case f => a.add(f)
      }
      a
    }
  }

  private def listToJsArr(a: Seq[_]) = JsonArray(a: _*)


  type AddressResolverOptions = io.vertx.core.dns.AddressResolverOptions
  object AddressResolverOptions {
    def apply() = new AddressResolverOptions()
    def apply(json: JsonObject) = new AddressResolverOptions(json)
  }



  type Argument = io.vertx.core.cli.Argument
  object Argument {
    def apply() = new Argument()
    def apply(json: JsonObject) = new Argument(json)
  }




  /**
    * Represents a file on the file-system which can be read from, or written to asynchronously.
    * 
    * This class also implements [[io.vertx.core.streams.ReadStream]] and
    * [[io.vertx.core.streams.WriteStream]]. This allows the data to be pumped to and from
    * other streams, e.g. an [[io.vertx.core.http.HttpClientRequest]] instance,
    * using the [[io.vertx.core.streams.Pump]] class
    */

  implicit class AsyncFileScala(val asJava: io.vertx.core.file.AsyncFile) extends AnyVal {

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def drainHandler(handler: scala.Option[Void => Unit]) = {
      asJava.drainHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

    /**
     * Like pipeTo from [[io.vertx.core.file.AsyncFile]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like write from [[io.vertx.core.file.AsyncFile]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.file.AsyncFile]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.file.AsyncFile]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.file.AsyncFile]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like write from [[io.vertx.core.file.AsyncFile]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(buffer: io.vertx.core.buffer.Buffer, position: java.lang.Long) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(buffer, position, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like read from [[io.vertx.core.file.AsyncFile]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def readFuture(buffer: io.vertx.core.buffer.Buffer, offset: java.lang.Integer, position: java.lang.Long, length: java.lang.Integer) : scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = concurrent.Promise[io.vertx.core.buffer.Buffer]()
      asJava.read(buffer, offset, position, length, new Handler[AsyncResult[io.vertx.core.buffer.Buffer]] { override def handle(event: AsyncResult[io.vertx.core.buffer.Buffer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like flush from [[io.vertx.core.file.AsyncFile]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def flushFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.flush(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * An asynchronous map.
    * 
    * [[io.vertx.core.shareddata.AsyncMap]] does <em>not</em> allow `null` to be used as a key or value.
    */

  implicit class AsyncMapScala[K, V](val asJava: io.vertx.core.shareddata.AsyncMap[K, V]) extends AnyVal {

    /**
     * Get a value from the map, asynchronously.     * @param k the key
     * @param resultHandler - this will be called some time later with the async result.
     */
  def get(k: K, resultHandler: AsyncResult[V] => Unit) = {
      asJava.get(k, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]])
  }

    /**
     * Put a value in the map, asynchronously.     * @param k the key
     * @param v the value
     * @param completionHandler - this will be called some time later to signify the value has been put
     */
  def put(k: K, v: V, completionHandler: AsyncResult[Void] => Unit) = {
      asJava.put(k, v, completionHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
  }

    /**
     * Like [[io.vertx.core.shareddata.AsyncMap#put]] but specifying a time to live for the entry. Entry will expire and get evicted after the
     * ttl.     * @param k the key
     * @param v the value
     * @param ttl The time to live (in ms) for the entry
     * @param completionHandler the handler
     */
  def put(k: K, v: V, ttl: java.lang.Long, completionHandler: AsyncResult[Void] => Unit) = {
      asJava.put(k, v, ttl, completionHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
  }

    /**
     * Put the entry only if there is no entry with the key already present. If key already present then the existing
     * value will be returned to the handler, otherwise null.     * @param k the key
     * @param v the value
     * @param completionHandler the handler
     */
  def putIfAbsent(k: K, v: V, completionHandler: AsyncResult[V] => Unit) = {
      asJava.putIfAbsent(k, v, completionHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]])
  }

    /**
     * Link [[io.vertx.core.shareddata.AsyncMap#putIfAbsent]] but specifying a time to live for the entry. Entry will expire and get evicted
     * after the ttl.     * @param k the key
     * @param v the value
     * @param ttl The time to live (in ms) for the entry
     * @param completionHandler the handler
     */
  def putIfAbsent(k: K, v: V, ttl: java.lang.Long, completionHandler: AsyncResult[V] => Unit) = {
      asJava.putIfAbsent(k, v, ttl, completionHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]])
  }

    /**
     * Remove a value from the map, asynchronously.     * @param k the key
     * @param resultHandler - this will be called some time later to signify the value has been removed
     */
  def remove(k: K, resultHandler: AsyncResult[V] => Unit) = {
      asJava.remove(k, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]])
  }

    /**
     * Remove a value from the map, only if entry already exists with same value.     * @param k the key
     * @param v the value
     * @param resultHandler - this will be called some time later to signify the value has been removed
     */
  def removeIfPresent(k: K, v: V, resultHandler: AsyncResult[java.lang.Boolean] => Unit) = {
      asJava.removeIfPresent(k, v, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Boolean]]])
  }

    /**
     * Replace the entry only if it is currently mapped to some value     * @param k the key
     * @param v the new value
     * @param resultHandler the result handler will be passed the previous value
     */
  def replace(k: K, v: V, resultHandler: AsyncResult[V] => Unit) = {
      asJava.replace(k, v, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]])
  }

    /**
     * Replace the entry only if it is currently mapped to a specific value     * @param k the key
     * @param oldValue the existing value
     * @param newValue the new value
     * @param resultHandler the result handler
     */
  def replaceIfPresent(k: K, oldValue: V, newValue: V, resultHandler: AsyncResult[java.lang.Boolean] => Unit) = {
      asJava.replaceIfPresent(k, oldValue, newValue, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Boolean]]])
  }

    /**
     * Like get from [[io.vertx.core.shareddata.AsyncMap]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getFuture(k: K) : scala.concurrent.Future[V] = {
      val promise = concurrent.Promise[V]()
      asJava.get(k, new Handler[AsyncResult[V]] { override def handle(event: AsyncResult[V]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.shareddata.AsyncMap]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(k: K, v: V) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.put(k, v, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.shareddata.AsyncMap]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(k: K, v: V, ttl: java.lang.Long) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.put(k, v, ttl, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like putIfAbsent from [[io.vertx.core.shareddata.AsyncMap]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putIfAbsentFuture(k: K, v: V) : scala.concurrent.Future[V] = {
      val promise = concurrent.Promise[V]()
      asJava.putIfAbsent(k, v, new Handler[AsyncResult[V]] { override def handle(event: AsyncResult[V]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like putIfAbsent from [[io.vertx.core.shareddata.AsyncMap]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putIfAbsentFuture(k: K, v: V, ttl: java.lang.Long) : scala.concurrent.Future[V] = {
      val promise = concurrent.Promise[V]()
      asJava.putIfAbsent(k, v, ttl, new Handler[AsyncResult[V]] { override def handle(event: AsyncResult[V]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like remove from [[io.vertx.core.shareddata.AsyncMap]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def removeFuture(k: K) : scala.concurrent.Future[V] = {
      val promise = concurrent.Promise[V]()
      asJava.remove(k, new Handler[AsyncResult[V]] { override def handle(event: AsyncResult[V]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like removeIfPresent from [[io.vertx.core.shareddata.AsyncMap]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def removeIfPresentFuture(k: K, v: V) : scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]()
      asJava.removeIfPresent(k, v, new Handler[AsyncResult[java.lang.Boolean]] { override def handle(event: AsyncResult[java.lang.Boolean]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like replace from [[io.vertx.core.shareddata.AsyncMap]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def replaceFuture(k: K, v: V) : scala.concurrent.Future[V] = {
      val promise = concurrent.Promise[V]()
      asJava.replace(k, v, new Handler[AsyncResult[V]] { override def handle(event: AsyncResult[V]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like replaceIfPresent from [[io.vertx.core.shareddata.AsyncMap]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def replaceIfPresentFuture(k: K, oldValue: V, newValue: V) : scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]()
      asJava.replaceIfPresent(k, oldValue, newValue, new Handler[AsyncResult[java.lang.Boolean]] { override def handle(event: AsyncResult[java.lang.Boolean]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like clear from [[io.vertx.core.shareddata.AsyncMap]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def clearFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.clear(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like size from [[io.vertx.core.shareddata.AsyncMap]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sizeFuture() : scala.concurrent.Future[java.lang.Integer] = {
      val promise = concurrent.Promise[java.lang.Integer]()
      asJava.size(new Handler[AsyncResult[java.lang.Integer]] { override def handle(event: AsyncResult[java.lang.Integer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object CLI {
    /**
     * Creates an instance of [[io.vertx.core.cli.CLI]] using the default implementation.     * @param name the name of the CLI (must not be `null`)
     * @return the created instance of CLI
     */
  def create(name: java.lang.String) = {
      io.vertx.core.cli.CLI.create(name)
  }
  }





  object CommandLine {
    /**
     * Creates a command line object from the [[io.vertx.core.cli.CLI]]. This object is intended to be used by
     * the parser to set the argument and option values.     * @param cli the CLI definition
     * @return the command line object
     */
  def create(cli: io.vertx.core.cli.CLI) = {
      io.vertx.core.cli.CommandLine.create(cli)
  }
  }



  /**
    * The composite future wraps a list of [[io.vertx.core.Future]], it is useful when several futures
    * needs to be coordinated.
    * The handlers set for the coordinated futures are overridden by the handler of the composite future.
    */

  implicit class CompositeFutureScala(val asJava: io.vertx.core.CompositeFuture) extends AnyVal {


  def onCompleteFuture() : scala.concurrent.Future[io.vertx.core.CompositeFuture] = {
      val promise = concurrent.Promise[io.vertx.core.CompositeFuture]()
      asJava.onComplete(new Handler[AsyncResult[io.vertx.core.CompositeFuture]] { override def handle(event: AsyncResult[io.vertx.core.CompositeFuture]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




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
    * This class also allows arbitrary data to be [[io.vertx.core.Context#put]] and [[io.vertx.core.Context#get]] on the context so it can be shared easily
    * amongst different handlers of, for example, a verticle instance.
    * 
    * This class also provides [[io.vertx.core.Context#runOnContext]] which allows an action to be executed asynchronously using the same context.
    */

  implicit class ContextScala(val asJava: io.vertx.core.Context) extends AnyVal {
    /**
      * Safely execute some blocking code.
      *
      * Executes the blocking code in the handler `blockingCodeHandler` using a thread from the worker pool.
      *
      * When the code is complete the returned Future will be completed with the result.
      *
      * @param blockingFunction function containing blocking code
      * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
      * @return a Future representing the result of the blocking operation
      */
    def executeBlockingFuture[T](blockingFunction: () => T, ordered: Boolean = true): concurrent.Future[T] = {
      val promise = concurrent.Promise[T]
      val h: Handler[io.vertx.core.Promise[T]] = {f => util.Try(blockingFunction()) match {
        case util.Success(s) => f.complete(s)
        case util.Failure(t) => f.fail(t)
      }}
      asJava.executeBlocking[T](h, ordered, {h:AsyncResult[T] => {if (h.succeeded()) promise.success(h.result()) else promise.failure(h.cause());()} })
      promise.future
    }



    /**
     * Like config from [[io.vertx.core.Context]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def configOption() = {
      scala.Option(asJava.config())
  }

    /**
     * Put some data in the context.
     * 
     * This can be used to share data between different handlers that share a context     * @param key the key of the data
     * @param value the data
     */
  def put(key: java.lang.String, value: AnyRef) = {
      asJava.put(key, value)
  }

    /**
     * Put some local data in the context.
     * 
     * This can be used to share data between different handlers that share a context     * @param key the key of the data
     * @param value the data
     */
  def putLocal(key: java.lang.String, value: AnyRef) = {
      asJava.putLocal(key, value)
  }

    /**
     * Set an exception handler called when the context runs an action throwing an uncaught throwable.<p/>
     *
     * When this handler is called, [[io.vertx.core.Vertx#currentContext]] will return this context.     * @param handler the exception handler
     * @return a reference to this, so the API can be used fluently
     */
  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }



  }



  object Cookie {
    /**
     * Create a new cookie     * @param name the name of the cookie
     * @param value the cookie value
     * @return the cookie
     */
  def cookie(name: java.lang.String, value: java.lang.String) = {
      io.vertx.core.http.Cookie.cookie(name, value)
  }
  }


  type CopyOptions = io.vertx.core.file.CopyOptions
  object CopyOptions {
    def apply() = new CopyOptions()
    def apply(json: JsonObject) = new CopyOptions(json)
  }




  /**
    * An asynchronous counter that can be used to across the cluster to maintain a consistent count.
    * 
    */

  implicit class CounterScala(val asJava: io.vertx.core.shareddata.Counter) extends AnyVal {


    /**
     * Like get from [[io.vertx.core.shareddata.Counter]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getFuture() : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]()
      asJava.get(new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like incrementAndGet from [[io.vertx.core.shareddata.Counter]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def incrementAndGetFuture() : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]()
      asJava.incrementAndGet(new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getAndIncrement from [[io.vertx.core.shareddata.Counter]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getAndIncrementFuture() : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]()
      asJava.getAndIncrement(new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like decrementAndGet from [[io.vertx.core.shareddata.Counter]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def decrementAndGetFuture() : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]()
      asJava.decrementAndGet(new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like addAndGet from [[io.vertx.core.shareddata.Counter]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def addAndGetFuture(value: java.lang.Long) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]()
      asJava.addAndGet(value, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getAndAdd from [[io.vertx.core.shareddata.Counter]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getAndAddFuture(value: java.lang.Long) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]()
      asJava.getAndAdd(value, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like compareAndSet from [[io.vertx.core.shareddata.Counter]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def compareAndSetFuture(expected: java.lang.Long, value: java.lang.Long) : scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]()
      asJava.compareAndSet(expected, value, new Handler[AsyncResult[java.lang.Boolean]] { override def handle(event: AsyncResult[java.lang.Boolean]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }






  /**
    * A datagram socket can be used to send [[io.vertx.core.datagram.DatagramPacket]]'s to remote datagram servers
    * and receive [[io.vertx.core.datagram.DatagramPacket]]s .
    * 
    * Usually you use a datagram socket to send UDP over the wire. UDP is connection-less which means you are not connected
    * to the remote peer in a persistent way. Because of this you have to supply the address and port of the remote peer
    * when sending data.
    * 
    * You can send data to ipv4 or ipv6 addresses, which also include multicast addresses.
    * 
    * Please consult the documentation for more information on datagram sockets.
    */

  implicit class DatagramSocketScala(val asJava: io.vertx.core.datagram.DatagramSocket) extends AnyVal {

    /**
     * Joins a multicast group and listens for packets send to it on the given network interface.
     * The  is notified once the operation completes.     * @param multicastAddress the address of the multicast group to join
     * @param networkInterface the network interface on which to listen for packets.
     * @param source the address of the source for which we will listen for multicast packets
     * @param handler then handler to notify once the operation completes
     * @return a reference to this, so the API can be used fluently
     */
  def listenMulticastGroup(multicastAddress: java.lang.String, networkInterface: java.lang.String, source: scala.Option[java.lang.String], handler: AsyncResult[Void] => Unit) = {
      asJava.listenMulticastGroup(multicastAddress, networkInterface, source.getOrElse(null), handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
  }

    /**
     * Leaves a multicast group and stops listening for packets send to it on the given network interface.
     * The  is notified once the operation completes.     * @param multicastAddress the address of the multicast group to join
     * @param networkInterface the network interface on which to listen for packets.
     * @param source the address of the source for which we will listen for multicast packets
     * @param handler the handler to notify once the operation completes
     * @return a reference to this, so the API can be used fluently
     */
  def unlistenMulticastGroup(multicastAddress: java.lang.String, networkInterface: java.lang.String, source: scala.Option[java.lang.String], handler: AsyncResult[Void] => Unit) = {
      asJava.unlistenMulticastGroup(multicastAddress, networkInterface, source.getOrElse(null), handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
  }

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def handler(handler: scala.Option[io.vertx.core.datagram.DatagramPacket => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.datagram.DatagramPacket]]).getOrElse(null))
  }

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

    /**
     * Like pipeTo from [[io.vertx.core.datagram.DatagramSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.datagram.DatagramPacket]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.datagram.DatagramSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(packet: io.vertx.core.buffer.Buffer, port: java.lang.Integer, host: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.send(packet, port, host, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.datagram.DatagramSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(str: java.lang.String, port: java.lang.Integer, host: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.send(str, port, host, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.datagram.DatagramSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(str: java.lang.String, enc: java.lang.String, port: java.lang.Integer, host: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.send(str, enc, port, host, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.datagram.DatagramSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like listenMulticastGroup from [[io.vertx.core.datagram.DatagramSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenMulticastGroupFuture(multicastAddress: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.listenMulticastGroup(multicastAddress, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like listenMulticastGroup from [[io.vertx.core.datagram.DatagramSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenMulticastGroupFuture(multicastAddress: java.lang.String, networkInterface: java.lang.String, source: scala.Option[java.lang.String]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.listenMulticastGroup(multicastAddress, networkInterface, source.getOrElse(null), new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like unlistenMulticastGroup from [[io.vertx.core.datagram.DatagramSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def unlistenMulticastGroupFuture(multicastAddress: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.unlistenMulticastGroup(multicastAddress, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like unlistenMulticastGroup from [[io.vertx.core.datagram.DatagramSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def unlistenMulticastGroupFuture(multicastAddress: java.lang.String, networkInterface: java.lang.String, source: scala.Option[java.lang.String]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.unlistenMulticastGroup(multicastAddress, networkInterface, source.getOrElse(null), new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like blockMulticastGroup from [[io.vertx.core.datagram.DatagramSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def blockMulticastGroupFuture(multicastAddress: java.lang.String, sourceToBlock: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.blockMulticastGroup(multicastAddress, sourceToBlock, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like blockMulticastGroup from [[io.vertx.core.datagram.DatagramSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def blockMulticastGroupFuture(multicastAddress: java.lang.String, networkInterface: java.lang.String, sourceToBlock: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.blockMulticastGroup(multicastAddress, networkInterface, sourceToBlock, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like listen from [[io.vertx.core.datagram.DatagramSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenFuture(port: java.lang.Integer, host: java.lang.String) : scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
      val promise = concurrent.Promise[io.vertx.core.datagram.DatagramSocket]()
      asJava.listen(port, host, new Handler[AsyncResult[io.vertx.core.datagram.DatagramSocket]] { override def handle(event: AsyncResult[io.vertx.core.datagram.DatagramSocket]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type DatagramSocketOptions = io.vertx.core.datagram.DatagramSocketOptions
  object DatagramSocketOptions {
    def apply() = new DatagramSocketOptions()
    def apply(json: JsonObject) = new DatagramSocketOptions(json)
  }





  type DeliveryOptions = io.vertx.core.eventbus.DeliveryOptions
  object DeliveryOptions {
    def apply() = new DeliveryOptions()
    def apply(json: JsonObject) = new DeliveryOptions(json)
  }



  type DeploymentOptions = io.vertx.core.DeploymentOptions
  object DeploymentOptions {
    def apply() = new DeploymentOptions()
    def apply(json: JsonObject) = new DeploymentOptions(json)
  }




  /**
    * Provides a way to asynchronously lookup information from DNS servers.
    * 
    * Please consult the documentation for more information on DNS clients.
    */

  implicit class DnsClientScala(val asJava: io.vertx.core.dns.DnsClient) extends AnyVal {


    /**
     * Like lookup from [[io.vertx.core.dns.DnsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def lookupFuture(name: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.lookup(name, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like lookup4 from [[io.vertx.core.dns.DnsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def lookup4Future(name: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.lookup4(name, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like lookup6 from [[io.vertx.core.dns.DnsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def lookup6Future(name: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.lookup6(name, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like resolveA from [[io.vertx.core.dns.DnsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def resolveAFuture(name: java.lang.String) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]()
      asJava.resolveA(name, new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like resolveAAAA from [[io.vertx.core.dns.DnsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def resolveAAAAFuture(name: java.lang.String) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]()
      asJava.resolveAAAA(name, new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like resolveCNAME from [[io.vertx.core.dns.DnsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def resolveCNAMEFuture(name: java.lang.String) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]()
      asJava.resolveCNAME(name, new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like resolveMX from [[io.vertx.core.dns.DnsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def resolveMXFuture(name: java.lang.String) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.dns.MxRecord]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.core.dns.MxRecord]]()
      asJava.resolveMX(name, new Handler[AsyncResult[java.util.List[io.vertx.core.dns.MxRecord]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.core.dns.MxRecord]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like resolveTXT from [[io.vertx.core.dns.DnsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def resolveTXTFuture(name: java.lang.String) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]()
      asJava.resolveTXT(name, new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like resolvePTR from [[io.vertx.core.dns.DnsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def resolvePTRFuture(name: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.resolvePTR(name, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like resolveNS from [[io.vertx.core.dns.DnsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def resolveNSFuture(name: java.lang.String) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]()
      asJava.resolveNS(name, new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like resolveSRV from [[io.vertx.core.dns.DnsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def resolveSRVFuture(name: java.lang.String) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.dns.SrvRecord]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.core.dns.SrvRecord]]()
      asJava.resolveSRV(name, new Handler[AsyncResult[java.util.List[io.vertx.core.dns.SrvRecord]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.core.dns.SrvRecord]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like reverseLookup from [[io.vertx.core.dns.DnsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def reverseLookupFuture(ipaddress: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.reverseLookup(ipaddress, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type DnsClientOptions = io.vertx.core.dns.DnsClientOptions
  object DnsClientOptions {
    def apply() = new DnsClientOptions()
    def apply(json: JsonObject) = new DnsClientOptions(json)
  }




  /**
    * A Vert.x event-bus is a light-weight distributed messaging system which allows different parts of your application,
    * or different applications and services to communicate with each in a loosely coupled way.
    * 
    * An event-bus supports publish-subscribe messaging, point-to-point messaging and request-response messaging.
    * 
    * Message delivery is best-effort and messages can be lost if failure of all or part of the event bus occurs.
    * 
    * Please refer to the documentation for more information on the event bus.
    */

  implicit class EventBusScala(val asJava: io.vertx.core.eventbus.EventBus) extends AnyVal {

    /**
     * Sends a message.
     * 
     * The message will be delivered to at most one of the handlers registered to the address.     * @param address the address to send it to
     * @param message the message, may be `null`
     * @return a reference to this, so the API can be used fluently
     */
  def send(address: java.lang.String, message: scala.Option[AnyRef]) = {
      asJava.send(address, message.getOrElse(null))
  }

    /**
     * Like [[io.vertx.core.eventbus.EventBus#send]] but specifying `options` that can be used to configure the delivery.     * @param address the address to send it to
     * @param message the message, may be `null`
     * @param options delivery options see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
     * @return a reference to this, so the API can be used fluently
     */
  def send(address: java.lang.String, message: scala.Option[AnyRef], options: io.vertx.core.eventbus.DeliveryOptions) = {
      asJava.send(address, message.getOrElse(null), options)
  }

    /**
     * Sends a message and and specify a `replyHandler` that will be called if the recipient
     * subsequently replies to the message.
     * 
     * The message will be delivered to at most one of the handlers registered to the address.     * @param address the address to send it to
     * @param message the message body, may be `null`
     * @param replyHandler reply handler will be called when any reply from the recipient is received
     * @return a reference to this, so the API can be used fluently
     */
  def request[T](address: java.lang.String, message: scala.Option[AnyRef], replyHandler: AsyncResult[io.vertx.core.eventbus.Message[T]] => Unit) = {
      asJava.request[T](address, message.getOrElse(null), replyHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.eventbus.Message[T]]]])
  }

    /**
     * Like [[io.vertx.core.eventbus.EventBus#request]] but specifying `options` that can be used to configure the delivery.     * @param address the address to send it to
     * @param message the message body, may be `null`
     * @param options delivery options see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
     * @param replyHandler reply handler will be called when any reply from the recipient is received
     * @return a reference to this, so the API can be used fluently
     */
  def request[T](address: java.lang.String, message: scala.Option[AnyRef], options: io.vertx.core.eventbus.DeliveryOptions, replyHandler: AsyncResult[io.vertx.core.eventbus.Message[T]] => Unit) = {
      asJava.request[T](address, message.getOrElse(null), options, replyHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.eventbus.Message[T]]]])
  }

    /**
     * Publish a message.
     * The message will be delivered to all handlers registered to the address.     * @param address the address to publish it to
     * @param message the message, may be `null`
     * @return a reference to this, so the API can be used fluently
     */
  def publish(address: java.lang.String, message: scala.Option[AnyRef]) = {
      asJava.publish(address, message.getOrElse(null))
  }

    /**
     * Like [[io.vertx.core.eventbus.EventBus#publish]] but specifying `options` that can be used to configure the delivery.     * @param address the address to publish it to
     * @param message the message, may be `null`
     * @param options the delivery options see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
     * @return a reference to this, so the API can be used fluently
     */
  def publish(address: java.lang.String, message: scala.Option[AnyRef], options: io.vertx.core.eventbus.DeliveryOptions) = {
      asJava.publish(address, message.getOrElse(null), options)
  }

    /**
     * Like request from [[io.vertx.core.eventbus.EventBus]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def requestFuture[T](address: java.lang.String, message: scala.Option[AnyRef]) : scala.concurrent.Future[io.vertx.core.eventbus.Message[T]] = {
      val promise = concurrent.Promise[io.vertx.core.eventbus.Message[T]]()
      asJava.request[T](address, message.getOrElse(null), new Handler[AsyncResult[io.vertx.core.eventbus.Message[T]]] { override def handle(event: AsyncResult[io.vertx.core.eventbus.Message[T]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like request from [[io.vertx.core.eventbus.EventBus]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def requestFuture[T](address: java.lang.String, message: scala.Option[AnyRef], options: io.vertx.core.eventbus.DeliveryOptions) : scala.concurrent.Future[io.vertx.core.eventbus.Message[T]] = {
      val promise = concurrent.Promise[io.vertx.core.eventbus.Message[T]]()
      asJava.request[T](address, message.getOrElse(null), options, new Handler[AsyncResult[io.vertx.core.eventbus.Message[T]]] { override def handle(event: AsyncResult[io.vertx.core.eventbus.Message[T]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type EventBusOptions = io.vertx.core.eventbus.EventBusOptions
  object EventBusOptions {
    def apply() = new EventBusOptions()
    def apply(json: JsonObject) = new EventBusOptions(json)
  }






  /**
    * Contains a broad set of operations for manipulating files on the file system.
    * 
    * A (potential) blocking and non blocking version of each operation is provided.
    * 
    * The non blocking versions take a handler which is called when the operation completes or an error occurs.
    * 
    * The blocking versions are named `xxxBlocking` and return the results, or throw exceptions directly.
    * In many cases, depending on the operating system and file system some of the potentially blocking operations
    * can return quickly, which is why we provide them, but it's highly recommended that you test how long they take to
    * return in your particular application before using them on an event loop.
    * 
    * Please consult the documentation for more information on file system support.
    */

  implicit class FileSystemScala(val asJava: io.vertx.core.file.FileSystem) extends AnyVal {

    /**
     * Change the ownership on the file represented by `path` to `user` and {code group`, asynchronously.     * @param path the path to the file
     * @param user the user name, `null` will not change the user name
     * @param group the user group, `null` will not change the user group name
     * @param handler the handler that will be called on completion
     * @return a reference to this, so the API can be used fluently
     */
  def chown(path: java.lang.String, user: scala.Option[java.lang.String], group: scala.Option[java.lang.String], handler: AsyncResult[Void] => Unit) = {
      asJava.chown(path, user.getOrElse(null), group.getOrElse(null), handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
  }

    /**
     * Blocking version of [[io.vertx.core.file.FileSystem#chown]]
     *
     */
  def chownBlocking(path: java.lang.String, user: scala.Option[java.lang.String], group: scala.Option[java.lang.String]) = {
      asJava.chownBlocking(path, user.getOrElse(null), group.getOrElse(null))
  }

    /**
     * Like copy from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def copyFuture(from: java.lang.String, to: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.copy(from, to, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like copy from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def copyFuture(from: java.lang.String, to: java.lang.String, options: io.vertx.core.file.CopyOptions) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.copy(from, to, options, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like copyRecursive from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def copyRecursiveFuture(from: java.lang.String, to: java.lang.String, recursive: java.lang.Boolean) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.copyRecursive(from, to, recursive, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like move from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def moveFuture(from: java.lang.String, to: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.move(from, to, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like move from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def moveFuture(from: java.lang.String, to: java.lang.String, options: io.vertx.core.file.CopyOptions) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.move(from, to, options, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like truncate from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def truncateFuture(path: java.lang.String, len: java.lang.Long) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.truncate(path, len, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like chmod from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def chmodFuture(path: java.lang.String, perms: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.chmod(path, perms, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like chmodRecursive from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def chmodRecursiveFuture(path: java.lang.String, perms: java.lang.String, dirPerms: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.chmodRecursive(path, perms, dirPerms, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like chown from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def chownFuture(path: java.lang.String, user: scala.Option[java.lang.String], group: scala.Option[java.lang.String]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.chown(path, user.getOrElse(null), group.getOrElse(null), new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like props from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def propsFuture(path: java.lang.String) : scala.concurrent.Future[io.vertx.core.file.FileProps] = {
      val promise = concurrent.Promise[io.vertx.core.file.FileProps]()
      asJava.props(path, new Handler[AsyncResult[io.vertx.core.file.FileProps]] { override def handle(event: AsyncResult[io.vertx.core.file.FileProps]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like lprops from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def lpropsFuture(path: java.lang.String) : scala.concurrent.Future[io.vertx.core.file.FileProps] = {
      val promise = concurrent.Promise[io.vertx.core.file.FileProps]()
      asJava.lprops(path, new Handler[AsyncResult[io.vertx.core.file.FileProps]] { override def handle(event: AsyncResult[io.vertx.core.file.FileProps]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like link from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def linkFuture(link: java.lang.String, existing: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.link(link, existing, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like symlink from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def symlinkFuture(link: java.lang.String, existing: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.symlink(link, existing, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like unlink from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def unlinkFuture(link: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.unlink(link, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like readSymlink from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def readSymlinkFuture(link: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.readSymlink(link, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like delete from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deleteFuture(path: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.delete(path, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like deleteRecursive from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deleteRecursiveFuture(path: java.lang.String, recursive: java.lang.Boolean) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.deleteRecursive(path, recursive, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like mkdir from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def mkdirFuture(path: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.mkdir(path, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like mkdir from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def mkdirFuture(path: java.lang.String, perms: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.mkdir(path, perms, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like mkdirs from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def mkdirsFuture(path: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.mkdirs(path, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like mkdirs from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def mkdirsFuture(path: java.lang.String, perms: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.mkdirs(path, perms, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like readDir from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def readDirFuture(path: java.lang.String) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]()
      asJava.readDir(path, new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like readDir from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def readDirFuture(path: java.lang.String, filter: java.lang.String) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]()
      asJava.readDir(path, filter, new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like readFile from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def readFileFuture(path: java.lang.String) : scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = concurrent.Promise[io.vertx.core.buffer.Buffer]()
      asJava.readFile(path, new Handler[AsyncResult[io.vertx.core.buffer.Buffer]] { override def handle(event: AsyncResult[io.vertx.core.buffer.Buffer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like writeFile from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFileFuture(path: java.lang.String, data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeFile(path, data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like open from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def openFuture(path: java.lang.String, options: io.vertx.core.file.OpenOptions) : scala.concurrent.Future[io.vertx.core.file.AsyncFile] = {
      val promise = concurrent.Promise[io.vertx.core.file.AsyncFile]()
      asJava.open(path, options, new Handler[AsyncResult[io.vertx.core.file.AsyncFile]] { override def handle(event: AsyncResult[io.vertx.core.file.AsyncFile]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createFile from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createFileFuture(path: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.createFile(path, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createFile from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createFileFuture(path: java.lang.String, perms: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.createFile(path, perms, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like exists from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def existsFuture(path: java.lang.String) : scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]()
      asJava.exists(path, new Handler[AsyncResult[java.lang.Boolean]] { override def handle(event: AsyncResult[java.lang.Boolean]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like fsProps from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def fsPropsFuture(path: java.lang.String) : scala.concurrent.Future[io.vertx.core.file.FileSystemProps] = {
      val promise = concurrent.Promise[io.vertx.core.file.FileSystemProps]()
      asJava.fsProps(path, new Handler[AsyncResult[io.vertx.core.file.FileSystemProps]] { override def handle(event: AsyncResult[io.vertx.core.file.FileSystemProps]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createTempDirectory from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createTempDirectoryFuture(prefix: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.createTempDirectory(prefix, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createTempDirectory from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createTempDirectoryFuture(prefix: java.lang.String, perms: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.createTempDirectory(prefix, perms, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createTempDirectory from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createTempDirectoryFuture(dir: java.lang.String, prefix: java.lang.String, perms: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.createTempDirectory(dir, prefix, perms, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createTempFile from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createTempFileFuture(prefix: java.lang.String, suffix: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.createTempFile(prefix, suffix, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createTempFile from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createTempFileFuture(prefix: java.lang.String, suffix: java.lang.String, perms: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.createTempFile(prefix, suffix, perms, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createTempFile from [[io.vertx.core.file.FileSystem]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createTempFileFuture(dir: java.lang.String, prefix: java.lang.String, suffix: java.lang.String, perms: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.createTempFile(dir, prefix, suffix, perms, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type FileSystemOptions = io.vertx.core.file.FileSystemOptions
  object FileSystemOptions {
    def apply() = new FileSystemOptions()
    def apply(json: JsonObject) = new FileSystemOptions(json)
  }






  /**
    * Represents the result of an action that may, or may not, have occurred yet.
    * 
    */

  implicit class FutureScala[T](val asJava: io.vertx.core.Future[T]) extends AnyVal {


    /**
     * Like onComplete from [[io.vertx.core.Future]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def onCompleteFuture() : scala.concurrent.Future[T] = {
      val promise = concurrent.Promise[T]()
      asJava.onComplete(new Handler[AsyncResult[T]] { override def handle(event: AsyncResult[T]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type GoAway = io.vertx.core.http.GoAway
  object GoAway {
    def apply() = new GoAway()
    def apply(json: JsonObject) = new GoAway(json)
  }



  type Http2Settings = io.vertx.core.http.Http2Settings
  object Http2Settings {
    def apply() = new Http2Settings()
    def apply(json: JsonObject) = new Http2Settings(json)
  }




  /**
    * An asynchronous HTTP client.
    * 
    * It allows you to make requests to HTTP servers, and a single client can make requests to any server.
    * 
    * It also allows you to open WebSockets to servers.
    * 
    * The client can also pool HTTP connections.
    * 
    * For pooling to occur, keep-alive must be true on the <a href="../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a> (default is true).
    * In this case connections will be pooled and re-used if there are pending HTTP requests waiting to get a connection,
    * otherwise they will be closed.
    * 
    * This gives the benefits of keep alive when the client is loaded but means we don't keep connections hanging around
    * unnecessarily when there would be no benefits anyway.
    * 
    * The client also supports pipe-lining of requests. Pipe-lining means another request is sent on the same connection
    * before the response from the preceding one has returned. Pipe-lining is not appropriate for all requests.
    * 
    * To enable pipe-lining, it must be enabled on the <a href="../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a> (default is false).
    * 
    * When pipe-lining is enabled the connection will be automatically closed when all in-flight responses have returned
    * and there are no outstanding pending requests to write.
    * 
    * The client is designed to be reused between requests.
    */

  implicit class HttpClientScala(val asJava: io.vertx.core.http.HttpClient) extends AnyVal {


    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(options: io.vertx.core.http.RequestOptions) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(options, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(options: io.vertx.core.http.RequestOptions, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(options, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(options: io.vertx.core.http.RequestOptions, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(options, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, port, host, requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, port, host, requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, port, host, requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, port, host, requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, port, host, requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, port, host, requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, host, requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, host, requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, host, requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, host: java.lang.String, requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, host, requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, host: java.lang.String, requestURI: java.lang.String, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, host, requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, host: java.lang.String, requestURI: java.lang.String, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, host, requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, requestURI: java.lang.String, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(method: io.vertx.core.http.HttpMethod, requestURI: java.lang.String, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.send(method, requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like get from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.get(port, host, requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like get from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getFuture(host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.get(host, requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like get from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getFuture(requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.get(requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like get from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getFuture(options: io.vertx.core.http.RequestOptions) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.get(options, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like get from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.get(port, host, requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like get from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getFuture(host: java.lang.String, requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.get(host, requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like get from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getFuture(requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.get(requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(port, host, requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(port, host, requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(host, requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(host, requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(options: io.vertx.core.http.RequestOptions, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(options, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(options: io.vertx.core.http.RequestOptions, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(options, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(port, host, requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(port, host, requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(host: java.lang.String, requestURI: java.lang.String, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(host, requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(host: java.lang.String, requestURI: java.lang.String, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(host, requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(requestURI: java.lang.String, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(requestURI: java.lang.String, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(port, host, requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(port, host, requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(host, requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(host, requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(requestURI: java.lang.String, headers: io.vertx.core.MultiMap, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(requestURI, headers, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(options: io.vertx.core.http.RequestOptions, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(options, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(options: io.vertx.core.http.RequestOptions, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(options, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(port, host, requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(port, host, requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(host: java.lang.String, requestURI: java.lang.String, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(host, requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(host: java.lang.String, requestURI: java.lang.String, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(host, requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(requestURI: java.lang.String, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(requestURI: java.lang.String, body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(requestURI, body, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like head from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def headFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.head(port, host, requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like head from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def headFuture(host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.head(host, requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like head from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def headFuture(requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.head(requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like head from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def headFuture(options: io.vertx.core.http.RequestOptions) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.head(options, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like head from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def headFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.head(port, host, requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like head from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def headFuture(host: java.lang.String, requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.head(host, requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like head from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def headFuture(requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.head(requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like options from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def optionsFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.options(port, host, requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like options from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def optionsFuture(host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.options(host, requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like options from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def optionsFuture(requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.options(requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like options from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def optionsFuture(options: io.vertx.core.http.RequestOptions) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.options(options, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like options from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def optionsFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.options(port, host, requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like options from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def optionsFuture(host: java.lang.String, requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.options(host, requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like options from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def optionsFuture(requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.options(requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like delete from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deleteFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.delete(port, host, requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like delete from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deleteFuture(host: java.lang.String, requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.delete(host, requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like delete from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deleteFuture(requestURI: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.delete(requestURI, headers, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like delete from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deleteFuture(options: io.vertx.core.http.RequestOptions) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.delete(options, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like delete from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deleteFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.delete(port, host, requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like delete from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deleteFuture(host: java.lang.String, requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.delete(host, requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like delete from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deleteFuture(requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.delete(requestURI, new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like webSocket from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def webSocketFuture(port: java.lang.Integer, host: java.lang.String, requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.WebSocket] = {
      val promise = concurrent.Promise[io.vertx.core.http.WebSocket]()
      asJava.webSocket(port, host, requestURI, new Handler[AsyncResult[io.vertx.core.http.WebSocket]] { override def handle(event: AsyncResult[io.vertx.core.http.WebSocket]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like webSocket from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def webSocketFuture(host: java.lang.String, requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.WebSocket] = {
      val promise = concurrent.Promise[io.vertx.core.http.WebSocket]()
      asJava.webSocket(host, requestURI, new Handler[AsyncResult[io.vertx.core.http.WebSocket]] { override def handle(event: AsyncResult[io.vertx.core.http.WebSocket]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like webSocket from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def webSocketFuture(requestURI: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.WebSocket] = {
      val promise = concurrent.Promise[io.vertx.core.http.WebSocket]()
      asJava.webSocket(requestURI, new Handler[AsyncResult[io.vertx.core.http.WebSocket]] { override def handle(event: AsyncResult[io.vertx.core.http.WebSocket]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like webSocket from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def webSocketFuture(options: io.vertx.core.http.WebSocketConnectOptions) : scala.concurrent.Future[io.vertx.core.http.WebSocket] = {
      val promise = concurrent.Promise[io.vertx.core.http.WebSocket]()
      asJava.webSocket(options, new Handler[AsyncResult[io.vertx.core.http.WebSocket]] { override def handle(event: AsyncResult[io.vertx.core.http.WebSocket]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like webSocketAbs from [[io.vertx.core.http.HttpClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def webSocketAbsFuture(url: java.lang.String, headers: io.vertx.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.core.http.WebSocket] = {
      val promise = concurrent.Promise[io.vertx.core.http.WebSocket]()
      asJava.webSocketAbs(url, headers, version, subProtocols.asJava, new Handler[AsyncResult[io.vertx.core.http.WebSocket]] { override def handle(event: AsyncResult[io.vertx.core.http.WebSocket]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type HttpClientOptions = io.vertx.core.http.HttpClientOptions
  object HttpClientOptions {
    def apply() = new HttpClientOptions()
    def apply(json: JsonObject) = new HttpClientOptions(json)
  }




  /**
    * Represents a client-side HTTP request.
    * 
    * Instances are created by an [[io.vertx.core.http.HttpClient]] instance, via one of the methods corresponding to the
    * specific HTTP methods, or the generic request methods. On creation the request will not have been written to the
    * wire.
    * 
    * Once a request has been obtained, headers can be set on it, and data can be written to its body if required. Once
    * you are ready to send the request, one of the [[io.vertx.core.http.HttpClientRequest#end]] methods should be called.
    * 
    * Nothing is actually sent until the request has been internally assigned an HTTP connection.
    * 
    * The [[io.vertx.core.http.HttpClient]] instance will return an instance of this class immediately, even if there are no HTTP
    * connections available in the pool. Any requests sent before a connection is assigned will be queued
    * internally and actually sent when an HTTP connection becomes available from the pool.
    * 
    * The headers of the request are queued for writing either when the [[io.vertx.core.http.HttpClientRequest#end]] method is called, or, when the first
    * part of the body is written, whichever occurs first.
    * 
    * This class supports both chunked and non-chunked HTTP.
    * 
    * It implements [[io.vertx.core.streams.WriteStream]] so it can be used with
    * [[io.vertx.core.streams.Pump]] to pump data with flow control.
    * 
    * An example of using this class is as follows:
    * 
    */

  implicit class HttpClientRequestScala(val asJava: io.vertx.core.http.HttpClientRequest) extends AnyVal {

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def drainHandler(handler: scala.Option[Void => Unit]) = {
      asJava.drainHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * If you send an HTTP request with the header `Expect` set to the value `100-continue`
     * and the server responds with an interim HTTP response with a status code of `100` and a continue handler
     * has been set using this method, then the `handler` will be called.
     * 
     * You can then continue to write data to the request body and later end it. This is normally used in conjunction with
     * the [[io.vertx.core.http.HttpClientRequest#sendHead]] method to force the request header to be written before the request has ended.     * @return a reference to this, so the API can be used fluently
     */
  def continueHandler(handler: scala.Option[Void => Unit]) = {
      asJava.continueHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Like write from [[io.vertx.core.http.HttpClientRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like write from [[io.vertx.core.http.HttpClientRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(chunk: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(chunk, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like write from [[io.vertx.core.http.HttpClientRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(chunk: java.lang.String, enc: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(chunk, enc, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sendHead from [[io.vertx.core.http.HttpClientRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendHeadFuture() : scala.concurrent.Future[io.vertx.core.http.HttpVersion] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpVersion]()
      asJava.sendHead(new Handler[AsyncResult[io.vertx.core.http.HttpVersion]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpVersion]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.http.HttpClientRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture(chunk: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(chunk, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.http.HttpClientRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture(chunk: java.lang.String, enc: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(chunk, enc, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.http.HttpClientRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture(chunk: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(chunk, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.http.HttpClientRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like netSocket from [[io.vertx.core.http.HttpClientRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def netSocketFuture() : scala.concurrent.Future[io.vertx.core.net.NetSocket] = {
      val promise = concurrent.Promise[io.vertx.core.net.NetSocket]()
      asJava.netSocket(new Handler[AsyncResult[io.vertx.core.net.NetSocket]] { override def handle(event: AsyncResult[io.vertx.core.net.NetSocket]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def onCompleteFuture() : scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.onComplete(new Handler[AsyncResult[io.vertx.core.http.HttpClientResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpClientResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * Represents a client-side HTTP response.
    * 
    * Vert.x provides you with one of these via the handler that was provided when creating the [[io.vertx.core.http.HttpClientRequest]]
    * or that was set on the [[io.vertx.core.http.HttpClientRequest]] instance.
    * 
    * It implements [[io.vertx.core.streams.ReadStream]] so it can be used with
    * [[io.vertx.core.streams.Pump]] to pump data with flow control.
    */

  implicit class HttpClientResponseScala(val asJava: io.vertx.core.http.HttpClientResponse) extends AnyVal {

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Like getHeader from [[io.vertx.core.http.HttpClientResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getHeaderOption(headerName: java.lang.String) = {
      scala.Option(asJava.getHeader(headerName))
  }

    /**
     * Like getTrailer from [[io.vertx.core.http.HttpClientResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getTrailerOption(trailerName: java.lang.String) = {
      scala.Option(asJava.getTrailer(trailerName))
  }

    /**
     * Like pipeTo from [[io.vertx.core.http.HttpClientResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like body from [[io.vertx.core.http.HttpClientResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def bodyFuture() : scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = concurrent.Promise[io.vertx.core.buffer.Buffer]()
      asJava.body(new Handler[AsyncResult[io.vertx.core.buffer.Buffer]] { override def handle(event: AsyncResult[io.vertx.core.buffer.Buffer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * Represents an HTTP connection.
    * <p/>
    * HTTP/1.x connection provides an limited implementation, the following methods are implemented:
    * <ul>
    *   <li>[[io.vertx.core.http.HttpConnection#close]]</li>
    *   <li>[[io.vertx.core.http.HttpConnection#closeHandler]]</li>
    *   <li>[[io.vertx.core.http.HttpConnection#exceptionHandler]]</li>
    * </ul>
    */

  implicit class HttpConnectionScala(val asJava: io.vertx.core.http.HttpConnection) extends AnyVal {

    /**
     * Set an handler called when a  frame is received.
     * <p/>
     * This is not implemented for HTTP/1.x.     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def goAwayHandler(handler: scala.Option[io.vertx.core.http.GoAway => Unit]) = {
      asJava.goAwayHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.GoAway]]).getOrElse(null))
  }

    /**
     * Set an handler called when a  frame has been sent or received and all connections are closed.
     * <p/>
     * This is not implemented for HTTP/1.x.     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def shutdownHandler(handler: scala.Option[Void => Unit]) = {
      asJava.shutdownHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Set an handler notified when a  frame is received from the remote endpoint.
     * <p/>
     * This is not implemented for HTTP/1.x.     * @param handler the handler to be called when a ` PING` is received
     * @return a reference to this, so the API can be used fluently
     */
  def pingHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.pingHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

    /**
     * Like updateSettings from [[io.vertx.core.http.HttpConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def updateSettingsFuture(settings: io.vertx.core.http.Http2Settings) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.updateSettings(settings, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like ping from [[io.vertx.core.http.HttpConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pingFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = concurrent.Promise[io.vertx.core.buffer.Buffer]()
      asJava.ping(data, new Handler[AsyncResult[io.vertx.core.buffer.Buffer]] { override def handle(event: AsyncResult[io.vertx.core.buffer.Buffer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }





  object HttpHeaders {
  def headers() = {
      io.vertx.core.http.HttpHeaders.headers()
  }

  def set(name: java.lang.String, value: java.lang.String) = {
      io.vertx.core.http.HttpHeaders.set(name, value)
  }
  }


  object HttpMethod {
    /**
     * Lookup the `HttpMethod` value for the specified `value`.
     * <br/>
     * The predefined method constants [[io.vertx.core.http.HttpMethod]], [[io.vertx.core.http.HttpMethod]], [[io.vertx.core.http.HttpMethod]], [[io.vertx.core.http.HttpMethod]], [[io.vertx.core.http.HttpMethod]],
     * [[io.vertx.core.http.HttpMethod]], [[io.vertx.core.http.HttpMethod]], [[io.vertx.core.http.HttpMethod]] and [[io.vertx.core.http.HttpMethod]] are interned and will be returned
     * when case sensitively matching their string value (i.e `"GET"`, etc...)
     * <br/>
     * Otherwise a new instance is returned.     * @param value the value
     * @return the `HttpMethod` instance for the specified string `value`
     */
  def valueOf(value: java.lang.String) = {
      io.vertx.core.http.HttpMethod.valueOf(value)
  }

    /**
     * @return an un-modifiable list of known HTTP methods
     */
  def values() = {
      io.vertx.core.http.HttpMethod.values()
  }
  }



  /**
    * An HTTP and WebSockets server.
    * 
    * You receive HTTP requests by providing a [[io.vertx.core.http.HttpServer#requestHandler]]. As requests arrive on the server the handler
    * will be called with the requests.
    * 
    * You receive WebSockets by providing a [[io.vertx.core.http.HttpServer#webSocketHandler]]. As WebSocket connections arrive on the server, the
    * WebSocket is passed to the handler.
    */

  implicit class HttpServerScala(val asJava: io.vertx.core.http.HttpServer) extends AnyVal {


    /**
     * Like listen from [[io.vertx.core.http.HttpServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenFuture(port: java.lang.Integer, host: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpServer] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpServer]()
      asJava.listen(port, host, new Handler[AsyncResult[io.vertx.core.http.HttpServer]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpServer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like listen from [[io.vertx.core.http.HttpServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenFuture(address: io.vertx.core.net.SocketAddress) : scala.concurrent.Future[io.vertx.core.http.HttpServer] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpServer]()
      asJava.listen(address, new Handler[AsyncResult[io.vertx.core.http.HttpServer]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpServer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like listen from [[io.vertx.core.http.HttpServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenFuture(port: java.lang.Integer) : scala.concurrent.Future[io.vertx.core.http.HttpServer] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpServer]()
      asJava.listen(port, new Handler[AsyncResult[io.vertx.core.http.HttpServer]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpServer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like listen from [[io.vertx.core.http.HttpServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenFuture() : scala.concurrent.Future[io.vertx.core.http.HttpServer] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpServer]()
      asJava.listen(new Handler[AsyncResult[io.vertx.core.http.HttpServer]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpServer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.http.HttpServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * Represents an file upload from an HTML FORM.
    */

  implicit class HttpServerFileUploadScala(val asJava: io.vertx.core.http.HttpServerFileUpload) extends AnyVal {

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Like pipeTo from [[io.vertx.core.http.HttpServerFileUpload]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type HttpServerOptions = io.vertx.core.http.HttpServerOptions
  object HttpServerOptions {
    def apply() = new HttpServerOptions()
    def apply(json: JsonObject) = new HttpServerOptions(json)
  }




  /**
    * Represents a server-side HTTP request.
    * 
    * Instances are created for each request and passed to the user via a handler.
    * 
    * Each instance of this class is associated with a corresponding [[io.vertx.core.http.HttpServerResponse]] instance via
    * [[io.vertx.core.http.HttpServerRequest#response]].
    * It implements [[io.vertx.core.streams.ReadStream]] so it can be used with
    * [[io.vertx.core.streams.Pump]] to pump data with flow control.
    * 
    */

  implicit class HttpServerRequestScala(val asJava: io.vertx.core.http.HttpServerRequest) extends AnyVal {

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Like scheme from [[io.vertx.core.http.HttpServerRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def schemeOption() = {
      scala.Option(asJava.scheme())
  }

    /**
     * Like path from [[io.vertx.core.http.HttpServerRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pathOption() = {
      scala.Option(asJava.path())
  }

    /**
     * Like query from [[io.vertx.core.http.HttpServerRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def queryOption() = {
      scala.Option(asJava.query())
  }

    /**
     * Like host from [[io.vertx.core.http.HttpServerRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hostOption() = {
      scala.Option(asJava.host())
  }

    /**
     * Like getHeader from [[io.vertx.core.http.HttpServerRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getHeaderOption(headerName: java.lang.String) = {
      scala.Option(asJava.getHeader(headerName))
  }

    /**
     * Like getParam from [[io.vertx.core.http.HttpServerRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getParamOption(paramName: java.lang.String) = {
      scala.Option(asJava.getParam(paramName))
  }

    /**
     * Convenience method for receiving the entire request body in one piece.
     * 
     * This saves the user having to manually setting a data and end handler and append the chunks of the body until
     * the whole body received. Don't use this if your request body is large - you could potentially run out of RAM.     * @param bodyHandler This handler will be called after all the body has been received
     */
  def bodyHandler(bodyHandler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.bodyHandler(bodyHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

    /**
     * Set an upload handler. The handler will get notified once a new file upload was received to allow you to deal
     * with the file upload.     * @return a reference to this, so the API can be used fluently
     */
  def uploadHandler(uploadHandler: scala.Option[io.vertx.core.http.HttpServerFileUpload => Unit]) = {
      asJava.uploadHandler(uploadHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpServerFileUpload]]).getOrElse(null))
  }

    /**
     * Like getFormAttribute from [[io.vertx.core.http.HttpServerRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getFormAttributeOption(attributeName: java.lang.String) = {
      scala.Option(asJava.getFormAttribute(attributeName))
  }

    /**
     * Like getCookie from [[io.vertx.core.http.HttpServerRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getCookieOption(name: java.lang.String) = {
      scala.Option(asJava.getCookie(name))
  }

    /**
     * Like pipeTo from [[io.vertx.core.http.HttpServerRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like body from [[io.vertx.core.http.HttpServerRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def bodyFuture() : scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = concurrent.Promise[io.vertx.core.buffer.Buffer]()
      asJava.body(new Handler[AsyncResult[io.vertx.core.buffer.Buffer]] { override def handle(event: AsyncResult[io.vertx.core.buffer.Buffer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * Represents a server-side HTTP response.
    * 
    * An instance of this is created and associated to every instance of
    * [[io.vertx.core.http.HttpServerRequest]] that.
    * 
    * It allows the developer to control the HTTP response that is sent back to the
    * client for a particular HTTP request.
    * 
    * It contains methods that allow HTTP headers and trailers to be set, and for a body to be written out to the response.
    * 
    * It also allows files to be streamed by the kernel directly from disk to the
    * outgoing HTTP connection, bypassing user space altogether (where supported by
    * the underlying operating system). This is a very efficient way of
    * serving files from the server since buffers do not have to be read one by one
    * from the file and written to the outgoing socket.
    * 
    * It implements [[io.vertx.core.streams.WriteStream]] so it can be used with
    * [[io.vertx.core.streams.Pump]] to pump data with flow control.
    */

  implicit class HttpServerResponseScala(val asJava: io.vertx.core.http.HttpServerResponse) extends AnyVal {

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def drainHandler(handler: scala.Option[Void => Unit]) = {
      asJava.drainHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Set a close handler for the response, this is called when the underlying connection is closed and the response
     * was still using the connection.
     * 
     * For HTTP/1.x it is called when the connection is closed before `end()` is called, therefore it is not
     * guaranteed to be called.
     * 
     * For HTTP/2 it is called when the related stream is closed, and therefore it will be always be called.     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def closeHandler(handler: scala.Option[Void => Unit]) = {
      asJava.closeHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Set an end handler for the response. This will be called when the response is disposed to allow consistent cleanup
     * of the response.     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def endHandler(handler: scala.Option[Void => Unit]) = {
      asJava.endHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Provide a handler that will be called just before the headers are written to the wire.
     * This provides a hook allowing you to add any more headers or do any more operations before this occurs.     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def headersEndHandler(handler: scala.Option[Void => Unit]) = {
      asJava.headersEndHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Provides a handler that will be called after the last part of the body is written to the wire.
     * The handler is called asynchronously of when the response has been received by the client.
     * This provides a hook allowing you to do more operations once the request has been sent over the wire
     * such as resource cleanup.     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def bodyEndHandler(handler: scala.Option[Void => Unit]) = {
      asJava.bodyEndHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Like removeCookie from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def removeCookieOption(name: java.lang.String) = {
      scala.Option(asJava.removeCookie(name))
  }

    /**
     * Like removeCookie from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def removeCookieOption(name: java.lang.String, invalidate: java.lang.Boolean) = {
      scala.Option(asJava.removeCookie(name, invalidate))
  }

    /**
     * Like write from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like write from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(chunk: java.lang.String, enc: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(chunk, enc, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like write from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(chunk: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(chunk, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture(chunk: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(chunk, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture(chunk: java.lang.String, enc: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(chunk, enc, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture(chunk: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(chunk, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sendFile from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFileFuture(filename: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.sendFile(filename, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sendFile from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFileFuture(filename: java.lang.String, offset: java.lang.Long) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.sendFile(filename, offset, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sendFile from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFileFuture(filename: java.lang.String, offset: java.lang.Long, length: java.lang.Long) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.sendFile(filename, offset, length, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like push from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pushFuture(method: io.vertx.core.http.HttpMethod, host: java.lang.String, path: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpServerResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpServerResponse]()
      asJava.push(method, host, path, new Handler[AsyncResult[io.vertx.core.http.HttpServerResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpServerResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like push from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pushFuture(method: io.vertx.core.http.HttpMethod, path: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpServerResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpServerResponse]()
      asJava.push(method, path, headers, new Handler[AsyncResult[io.vertx.core.http.HttpServerResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpServerResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like push from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pushFuture(method: io.vertx.core.http.HttpMethod, path: java.lang.String) : scala.concurrent.Future[io.vertx.core.http.HttpServerResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpServerResponse]()
      asJava.push(method, path, new Handler[AsyncResult[io.vertx.core.http.HttpServerResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpServerResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like push from [[io.vertx.core.http.HttpServerResponse]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pushFuture(method: io.vertx.core.http.HttpMethod, host: java.lang.String, path: java.lang.String, headers: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.core.http.HttpServerResponse] = {
      val promise = concurrent.Promise[io.vertx.core.http.HttpServerResponse]()
      asJava.push(method, host, path, headers, new Handler[AsyncResult[io.vertx.core.http.HttpServerResponse]] { override def handle(event: AsyncResult[io.vertx.core.http.HttpServerResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type JdkSSLEngineOptions = io.vertx.core.net.JdkSSLEngineOptions
  object JdkSSLEngineOptions {
    def apply() = new JdkSSLEngineOptions()
    def apply(json: JsonObject) = new JdkSSLEngineOptions(json)
  }



  type JksOptions = io.vertx.core.net.JksOptions
  object JksOptions {
    def apply() = new JksOptions()
    def apply(json: JsonObject) = new JksOptions(json)
  }






  /**
    * A parser class which allows to incrementally parse json elements and emit json parse events instead of parsing a json
    * element fully. This parser is convenient for parsing large json structures.
    * <p/>
    * The parser also parses concatenated json streams or line delimited json streams.
    * <p/>
    * The parser can also parse entire object or array when it is convenient, for instance a very large array
    * of small objects can be parsed efficiently by handling array <i>start</i>/<i>end</i> and <i>object</i>
    * events.
    * <p/>
    * Whenever the parser fails to parse or process the stream, the [[io.vertx.core.parsetools.JsonParser#exceptionHandler]] is called with
    * the cause of the failure and the current handling stops. After such event, the parser should not handle data
    * anymore.
    */

  implicit class JsonParserScala(val asJava: io.vertx.core.parsetools.JsonParser) extends AnyVal {

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def handler(handler: scala.Option[io.vertx.core.parsetools.JsonEvent => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.parsetools.JsonEvent]]).getOrElse(null))
  }

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

    /**
     * Like pipeTo from [[io.vertx.core.parsetools.JsonParser]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.parsetools.JsonEvent]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object JsonPointer {
    /**
     * Build an empty JsonPointer     * @return a new empty JsonPointer
     */
  def create() = {
      io.vertx.core.json.pointer.JsonPointer.create()
  }

    /**
     * Build a JsonPointer from a json pointer string     * @param pointer the string representing a pointer
     * @return new instance of JsonPointer
     */
  def from(pointer: java.lang.String) = {
      io.vertx.core.json.pointer.JsonPointer.from(pointer)
  }
  }











  /**
    * Represents a message that is received from the event bus in a handler.
    * 
    * Messages have a [[io.vertx.core.eventbus.Message#body]], which can be null, and also [[io.vertx.core.eventbus.Message#headers]], which can be empty.
    * 
    * If the message was sent specifying a reply handler, it can be replied to using [[io.vertx.core.eventbus.Message#reply]].
    * 
    * If you want to notify the sender that processing failed, then [[io.vertx.core.eventbus.Message#fail]] can be called.
    */

  implicit class MessageScala[T](val asJava: io.vertx.core.eventbus.Message[T]) extends AnyVal {

    /**
     * Like replyAddress from [[io.vertx.core.eventbus.Message]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def replyAddressOption() = {
      scala.Option(asJava.replyAddress())
  }

    /**
     * Reply to this message.
     * 
     * If the message was sent specifying a reply handler, that handler will be
     * called when it has received a reply. If the message wasn't sent specifying a receipt handler
     * this method does nothing.     * @param message the message to reply with.
     */
  def reply(message: scala.Option[AnyRef]) = {
      asJava.reply(message.getOrElse(null))
  }

    /**
     * Link [[io.vertx.core.eventbus.Message#reply]] but allows you to specify delivery options for the reply.     * @param message the reply message
     * @param options the delivery options see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
     */
  def reply(message: scala.Option[AnyRef], options: io.vertx.core.eventbus.DeliveryOptions) = {
      asJava.reply(message.getOrElse(null), options)
  }

    /**
     * Reply to this message, specifying a `replyHandler` for the reply - i.e.
     * to receive the reply to the reply.
     * 
     * If the message was sent specifying a reply handler, that handler will be
     * called when it has received a reply. If the message wasn't sent specifying a receipt handler
     * this method does nothing.     * @param message the message to reply with.
     * @param replyHandler the reply handler for the reply.
     */
  def replyAndRequest[R](message: scala.Option[AnyRef], replyHandler: AsyncResult[io.vertx.core.eventbus.Message[R]] => Unit) = {
      asJava.replyAndRequest[R](message.getOrElse(null), replyHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.eventbus.Message[R]]]])
  }

    /**
     * Like [[io.vertx.core.eventbus.Message#replyAndRequest]] but specifying `options` that can be used
     * to configure the delivery.     * @param message the message body, may be `null`
     * @param options delivery options see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
     * @param replyHandler reply handler will be called when any reply from the recipient is received
     */
  def replyAndRequest[R](message: scala.Option[AnyRef], options: io.vertx.core.eventbus.DeliveryOptions, replyHandler: AsyncResult[io.vertx.core.eventbus.Message[R]] => Unit) = {
      asJava.replyAndRequest[R](message.getOrElse(null), options, replyHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.eventbus.Message[R]]]])
  }

    /**
     * Like replyAndRequest from [[io.vertx.core.eventbus.Message]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def replyAndRequestFuture[R](message: scala.Option[AnyRef]) : scala.concurrent.Future[io.vertx.core.eventbus.Message[R]] = {
      val promise = concurrent.Promise[io.vertx.core.eventbus.Message[R]]()
      asJava.replyAndRequest[R](message.getOrElse(null), new Handler[AsyncResult[io.vertx.core.eventbus.Message[R]]] { override def handle(event: AsyncResult[io.vertx.core.eventbus.Message[R]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like replyAndRequest from [[io.vertx.core.eventbus.Message]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def replyAndRequestFuture[R](message: scala.Option[AnyRef], options: io.vertx.core.eventbus.DeliveryOptions) : scala.concurrent.Future[io.vertx.core.eventbus.Message[R]] = {
      val promise = concurrent.Promise[io.vertx.core.eventbus.Message[R]]()
      asJava.replyAndRequest[R](message.getOrElse(null), options, new Handler[AsyncResult[io.vertx.core.eventbus.Message[R]]] { override def handle(event: AsyncResult[io.vertx.core.eventbus.Message[R]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  import io.vertx.core.MultiMap
  import io.vertx.core.eventbus.Message

  object Message{
    type Address = String
    type Headers = MultiMap
    type ReplyAddress = String
    type Send = Boolean
    def unapply[T](message: MessageScala[T]): scala.Option[(Address, Headers, ReplyAddress, Send, T)] = Some(message.asJava.address(), message.asJava.headers(), message.asJava.replyAddress(), message.asJava.isSend, message.asJava.body())
  }



  /**
    * An event bus consumer object representing a stream of message to an [[io.vertx.core.eventbus.EventBus]] address that can
    * be read from.
    * 
    * The [[io.vertx.core.eventbus.EventBus#consumer]] or [[io.vertx.core.eventbus.EventBus#localConsumer]]
    * creates a new consumer, the returned consumer is not yet registered against the event bus. Registration
    * is effective after the [[io.vertx.core.eventbus.MessageConsumer#handler]] method is invoked.
    *
    * The consumer is unregistered from the event bus using the [[io.vertx.core.eventbus.MessageConsumer#unregister]] method or by calling the
    * [[io.vertx.core.eventbus.MessageConsumer#handler]] with a null value..
    */

  implicit class MessageConsumerScala[T](val asJava: io.vertx.core.eventbus.MessageConsumer[T]) extends AnyVal {

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def handler(handler: scala.Option[io.vertx.core.eventbus.Message[T] => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.eventbus.Message[T]]]).getOrElse(null))
  }

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Like pipeTo from [[io.vertx.core.eventbus.MessageConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.eventbus.Message[T]]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like completionHandler from [[io.vertx.core.eventbus.MessageConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def completionFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.completionHandler(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like unregister from [[io.vertx.core.eventbus.MessageConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def unregisterFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.unregister(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * Represents a stream of message that can be written to.
    * 
    */

  implicit class MessageProducerScala[T](val asJava: io.vertx.core.eventbus.MessageProducer[T]) extends AnyVal {

    /**
     * Same as  but with an `handler` called when the operation completes
     */
  def write(data: T, handler: AsyncResult[Void] => Unit) = {
      asJava.write(data, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
  }

    /**
     * Same as  but with an `handler` called when the operation completes
     */
  def end(data: T, handler: AsyncResult[Void] => Unit) = {
      asJava.end(data, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
  }

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def drainHandler(handler: scala.Option[Void => Unit]) = {
      asJava.drainHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Like write from [[io.vertx.core.eventbus.MessageProducer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(data: T) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.eventbus.MessageProducer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture(data: T) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.eventbus.MessageProducer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.eventbus.MessageProducer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type MetricsOptions = io.vertx.core.metrics.MetricsOptions
  object MetricsOptions {
    def apply() = new MetricsOptions()
    def apply(json: JsonObject) = new MetricsOptions(json)
  }



  object MultiMap {
    /**
     * Create a multi-map implementation with case insensitive keys, for instance it can be used to hold some HTTP headers.     * @return the multi-map
     */
  def caseInsensitiveMultiMap() = {
      io.vertx.core.MultiMap.caseInsensitiveMultiMap()
  }
  }





  /**
    * A TCP client.
    * 
    * Multiple connections to different servers can be made using the same instance.
    * 
    * This client supports a configurable number of connection attempts and a configurable
    * delay between attempts.
    */

  implicit class NetClientScala(val asJava: io.vertx.core.net.NetClient) extends AnyVal {


    /**
     * Like connect from [[io.vertx.core.net.NetClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def connectFuture(port: java.lang.Integer, host: java.lang.String) : scala.concurrent.Future[io.vertx.core.net.NetSocket] = {
      val promise = concurrent.Promise[io.vertx.core.net.NetSocket]()
      asJava.connect(port, host, new Handler[AsyncResult[io.vertx.core.net.NetSocket]] { override def handle(event: AsyncResult[io.vertx.core.net.NetSocket]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like connect from [[io.vertx.core.net.NetClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def connectFuture(port: java.lang.Integer, host: java.lang.String, serverName: java.lang.String) : scala.concurrent.Future[io.vertx.core.net.NetSocket] = {
      val promise = concurrent.Promise[io.vertx.core.net.NetSocket]()
      asJava.connect(port, host, serverName, new Handler[AsyncResult[io.vertx.core.net.NetSocket]] { override def handle(event: AsyncResult[io.vertx.core.net.NetSocket]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like connect from [[io.vertx.core.net.NetClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def connectFuture(remoteAddress: io.vertx.core.net.SocketAddress) : scala.concurrent.Future[io.vertx.core.net.NetSocket] = {
      val promise = concurrent.Promise[io.vertx.core.net.NetSocket]()
      asJava.connect(remoteAddress, new Handler[AsyncResult[io.vertx.core.net.NetSocket]] { override def handle(event: AsyncResult[io.vertx.core.net.NetSocket]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like connect from [[io.vertx.core.net.NetClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def connectFuture(remoteAddress: io.vertx.core.net.SocketAddress, serverName: java.lang.String) : scala.concurrent.Future[io.vertx.core.net.NetSocket] = {
      val promise = concurrent.Promise[io.vertx.core.net.NetSocket]()
      asJava.connect(remoteAddress, serverName, new Handler[AsyncResult[io.vertx.core.net.NetSocket]] { override def handle(event: AsyncResult[io.vertx.core.net.NetSocket]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type NetClientOptions = io.vertx.core.net.NetClientOptions
  object NetClientOptions {
    def apply() = new NetClientOptions()
    def apply(json: JsonObject) = new NetClientOptions(json)
  }




  /**
    * Represents a TCP server
    */

  implicit class NetServerScala(val asJava: io.vertx.core.net.NetServer) extends AnyVal {

    /**
     * Supply a connect handler for this server. The server can only have at most one connect handler at any one time.
     * As the server accepts TCP or SSL connections it creates an instance of [[io.vertx.core.net.NetSocket]] and passes it to the
     * connect handler.     * @return a reference to this, so the API can be used fluently
     */
  def connectHandler(handler: scala.Option[io.vertx.core.net.NetSocket => Unit]) = {
      asJava.connectHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.net.NetSocket]]).getOrElse(null))
  }

    /**
     * Like listen from [[io.vertx.core.net.NetServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenFuture() : scala.concurrent.Future[io.vertx.core.net.NetServer] = {
      val promise = concurrent.Promise[io.vertx.core.net.NetServer]()
      asJava.listen(new Handler[AsyncResult[io.vertx.core.net.NetServer]] { override def handle(event: AsyncResult[io.vertx.core.net.NetServer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like listen from [[io.vertx.core.net.NetServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenFuture(port: java.lang.Integer, host: java.lang.String) : scala.concurrent.Future[io.vertx.core.net.NetServer] = {
      val promise = concurrent.Promise[io.vertx.core.net.NetServer]()
      asJava.listen(port, host, new Handler[AsyncResult[io.vertx.core.net.NetServer]] { override def handle(event: AsyncResult[io.vertx.core.net.NetServer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like listen from [[io.vertx.core.net.NetServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenFuture(port: java.lang.Integer) : scala.concurrent.Future[io.vertx.core.net.NetServer] = {
      val promise = concurrent.Promise[io.vertx.core.net.NetServer]()
      asJava.listen(port, new Handler[AsyncResult[io.vertx.core.net.NetServer]] { override def handle(event: AsyncResult[io.vertx.core.net.NetServer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like listen from [[io.vertx.core.net.NetServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenFuture(localAddress: io.vertx.core.net.SocketAddress) : scala.concurrent.Future[io.vertx.core.net.NetServer] = {
      val promise = concurrent.Promise[io.vertx.core.net.NetServer]()
      asJava.listen(localAddress, new Handler[AsyncResult[io.vertx.core.net.NetServer]] { override def handle(event: AsyncResult[io.vertx.core.net.NetServer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.net.NetServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type NetServerOptions = io.vertx.core.net.NetServerOptions
  object NetServerOptions {
    def apply() = new NetServerOptions()
    def apply(json: JsonObject) = new NetServerOptions(json)
  }




  /**
    * Represents a socket-like interface to a TCP connection on either the
    * client or the server side.
    * 
    * Instances of this class are created on the client side by an [[io.vertx.core.net.NetClient]]
    * when a connection to a server is made, or on the server side by a [[io.vertx.core.net.NetServer]]
    * when a server accepts a connection.
    * 
    * It implements both  and  so it can be used with
    * [[io.vertx.core.streams.Pump]] to pump data with flow control.
    */

  implicit class NetSocketScala(val asJava: io.vertx.core.net.NetSocket) extends AnyVal {

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

    /**
     * 
     * 
     * This handler might be called after the close handler when the socket is paused and there are still
     * buffers to deliver.
     */
  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def drainHandler(handler: scala.Option[Void => Unit]) = {
      asJava.drainHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Set a handler that will be called when the NetSocket is closed     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def closeHandler(handler: scala.Option[Void => Unit]) = {
      asJava.closeHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Like pipeTo from [[io.vertx.core.net.NetSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.net.NetSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like write from [[io.vertx.core.net.NetSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(str: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(str, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like write from [[io.vertx.core.net.NetSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(str: java.lang.String, enc: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(str, enc, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like write from [[io.vertx.core.net.NetSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(message: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(message, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sendFile from [[io.vertx.core.net.NetSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFileFuture(filename: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.sendFile(filename, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sendFile from [[io.vertx.core.net.NetSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFileFuture(filename: java.lang.String, offset: java.lang.Long) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.sendFile(filename, offset, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sendFile from [[io.vertx.core.net.NetSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFileFuture(filename: java.lang.String, offset: java.lang.Long, length: java.lang.Long) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.sendFile(filename, offset, length, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.net.NetSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.net.NetSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like upgradeToSsl from [[io.vertx.core.net.NetSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def upgradeToSslFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.upgradeToSsl(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like upgradeToSsl from [[io.vertx.core.net.NetSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def upgradeToSslFuture(serverName: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.upgradeToSsl(serverName, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }






  type OpenOptions = io.vertx.core.file.OpenOptions
  object OpenOptions {
    def apply() = new OpenOptions()
    def apply(json: JsonObject) = new OpenOptions(json)
  }



  type OpenSSLEngineOptions = io.vertx.core.net.OpenSSLEngineOptions
  object OpenSSLEngineOptions {
    def apply() = new OpenSSLEngineOptions()
    def apply(json: JsonObject) = new OpenSSLEngineOptions(json)
  }



  type Option = io.vertx.core.cli.Option
  object Option {
    def apply() = new Option()
    def apply(json: JsonObject) = new Option(json)
  }



  type PemKeyCertOptions = io.vertx.core.net.PemKeyCertOptions
  object PemKeyCertOptions {
    def apply() = new PemKeyCertOptions()
    def apply(json: JsonObject) = new PemKeyCertOptions(json)
  }



  type PemTrustOptions = io.vertx.core.net.PemTrustOptions
  object PemTrustOptions {
    def apply() = new PemTrustOptions()
    def apply(json: JsonObject) = new PemTrustOptions(json)
  }



  type PfxOptions = io.vertx.core.net.PfxOptions
  object PfxOptions {
    def apply() = new PfxOptions()
    def apply(json: JsonObject) = new PfxOptions(json)
  }




  /**
    * Pipe data from a [[io.vertx.core.streams.ReadStream]] to a [[io.vertx.core.streams.WriteStream]] and performs flow control where necessary to
    * prevent the write stream buffer from getting overfull.
    * 
    * Instances of this class read items from a [[io.vertx.core.streams.ReadStream]] and write them to a [[io.vertx.core.streams.WriteStream]]. If data
    * can be read faster than it can be written this could result in the write queue of the [[io.vertx.core.streams.WriteStream]] growing
    * without bound, eventually causing it to exhaust all available RAM.
    * 
    * To prevent this, after each write, instances of this class check whether the write queue of the [[io.vertx.core.streams.WriteStream]] is full, and if so, the [[io.vertx.core.streams.ReadStream]] is paused, and a `drainHandler` is set on the
    * [[io.vertx.core.streams.WriteStream]].
    * 
    * When the [[io.vertx.core.streams.WriteStream]] has processed half of its backlog, the `drainHandler` will be
    * called, which results in the pump resuming the [[io.vertx.core.streams.ReadStream]].
    * 
    * This class can be used to pipe from any [[io.vertx.core.streams.ReadStream]] to any [[io.vertx.core.streams.WriteStream]],
    * e.g. from an [[io.vertx.core.http.HttpServerRequest]] to an [[io.vertx.core.file.AsyncFile]],
    * or from [[io.vertx.core.net.NetSocket]] to a [[io.vertx.core.http.WebSocket]].
    * 
    * Please see the documentation for more information.

    */

  implicit class PipeScala[T](val asJava: io.vertx.core.streams.Pipe[T]) extends AnyVal {


    /**
     * Like to from [[io.vertx.core.streams.Pipe]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def toFuture(dst: io.vertx.core.streams.WriteStream[T]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.to(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object Promise {
    /**
     * Create a promise that hasn't completed yet     * @return the promise
     */
  def promise[T]() = {
      io.vertx.core.Promise.promise[T]()
  }
  }


  type ProxyOptions = io.vertx.core.net.ProxyOptions
  object ProxyOptions {
    def apply() = new ProxyOptions()
    def apply(json: JsonObject) = new ProxyOptions(json)
  }



  object Pump {
    /**
     * Create a new `Pump` with the given `ReadStream` and `WriteStream`     * @param rs the read stream
     * @param ws the write stream
     * @return the pump
     */
  def pump[T](rs: io.vertx.core.streams.ReadStream[T], ws: io.vertx.core.streams.WriteStream[T]) = {
      io.vertx.core.streams.Pump.pump[T](rs, ws)
  }

    /**
     * Create a new `Pump` with the given `ReadStream` and `WriteStream` and
     * `writeQueueMaxSize`     * @param rs the read stream
     * @param ws the write stream
     * @param writeQueueMaxSize the max size of the write queue
     * @return the pump
     */
  def pump[T](rs: io.vertx.core.streams.ReadStream[T], ws: io.vertx.core.streams.WriteStream[T], writeQueueMaxSize: java.lang.Integer) = {
      io.vertx.core.streams.Pump.pump[T](rs, ws, writeQueueMaxSize)
  }
  }



  /**
    * Represents a stream of items that can be read from.
    * 
    * Any class that implements this interface can be used by a [[io.vertx.core.streams.Pump]] to pump data from it
    * to a [[io.vertx.core.streams.WriteStream]].
    * 
    * <h3>Streaming mode</h3>
    * The stream is either in <i>flowing</i> or <i>fetch</i> mode.
    * <ul>
    *   <i>Initially the stream is in <i>flowing</i> mode.</i>
    *   <li>When the stream is in <i>flowing</i> mode, elements are delivered to the `handler`.</li>
    *   <li>When the stream is in <i>fetch</i> mode, only the number of requested elements will be delivered to the `handler`.</li>
    * </ul>
    * The mode can be changed with the [[io.vertx.core.streams.ReadStream#pause]], [[io.vertx.core.streams.ReadStream#resume]] and [[io.vertx.core.streams.ReadStream#fetch]] methods:
    * <ul>
    *   <li>Calling [[io.vertx.core.streams.ReadStream#resume]] sets the <i>flowing</i> mode</li>
    *   <li>Calling [[io.vertx.core.streams.ReadStream#pause]] sets the <i>fetch</i> mode and resets the demand to `0`</li>
    *   <li>Calling [[io.vertx.core.streams.ReadStream#fetch]] requests a specific amount of elements and adds it to the actual demand</li>
    * </ul>
    */

  implicit class ReadStreamScala[T](val asJava: io.vertx.core.streams.ReadStream[T]) extends AnyVal {

    /**
     * Set an exception handler on the read stream.     * @param handler the exception handler
     * @return a reference to this, so the API can be used fluently
     */
  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

    /**
     * Set a data handler. As data is read, the handler will be called with the data.     * @return a reference to this, so the API can be used fluently
     */
  def handler(handler: scala.Option[T => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[T]]).getOrElse(null))
  }

    /**
     * Set an end handler. Once the stream has ended, and there is no more data to be read, this handler will be called.     * @return a reference to this, so the API can be used fluently
     */
  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Like pipeTo from [[io.vertx.core.streams.ReadStream]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[T]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * A helper class which allows you to easily parse protocols which are delimited by a sequence of bytes, or fixed
    * size records.
    * 
    * Instances of this class take as input [[io.vertx.core.buffer.Buffer]] instances containing raw bytes,
    * and output records.
    * 
    * For example, if I had a simple ASCII text protocol delimited by '\n' and the input was the following:
    * 
    * <pre>
    * buffer1:HELLO\nHOW ARE Y
    * buffer2:OU?\nI AM
    * buffer3: DOING OK
    * buffer4:\n
    * </pre>
    * Then the output would be:
    * <pre>
    * buffer1:HELLO
    * buffer2:HOW ARE YOU?
    * buffer3:I AM DOING OK
    * </pre>
    * Instances of this class can be changed between delimited mode and fixed size record mode on the fly as
    * individual records are read, this allows you to parse protocols where, for example, the first 5 records might
    * all be fixed size (of potentially different sizes), followed by some delimited records, followed by more fixed
    * size records.
    * 
    * Instances of this class can't currently be used for protocols where the text is encoded with something other than
    * a 1-1 byte-char mapping.
    * 
    * Please see the documentation for more information.
    */

  implicit class RecordParserScala(val asJava: io.vertx.core.parsetools.RecordParser) extends AnyVal {

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Like pipeTo from [[io.vertx.core.parsetools.RecordParser]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type RequestOptions = io.vertx.core.http.RequestOptions
  object RequestOptions {
    def apply() = new RequestOptions()
    def apply(json: JsonObject) = new RequestOptions(json)
  }



  object SelfSignedCertificate {
    /**
     * Create a new `SelfSignedCertificate` instance.     * @return a new instance.
     */
  def create() = {
      io.vertx.core.net.SelfSignedCertificate.create()
  }

    /**
     * Create a new `SelfSignedCertificate` instance with a fully-qualified domain name,     * @param fqdn a fully qualified domain name.
     * @return a new instance.
     */
  def create(fqdn: java.lang.String) = {
      io.vertx.core.net.SelfSignedCertificate.create(fqdn)
  }
  }



  /**
    * Represents a server side WebSocket.
    * 
    * Instances of this class are passed into a [[io.vertx.core.http.HttpServer#webSocketHandler]] or provided
    * when a WebSocket handshake is manually [[io.vertx.core.http.HttpServerRequest#upgrade]]ed.
    */

  implicit class ServerWebSocketScala(val asJava: io.vertx.core.http.ServerWebSocket) extends AnyVal {

    /**
     * Set a text message handler on the connection. This handler will be called similar to the
     * [[io.vertx.core.http.WebSocketBase#binaryMessageHandler]], but the buffer will be converted to a String first     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def textMessageHandler(handler: scala.Option[java.lang.String => Unit]) = {
      asJava.textMessageHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.String]]).getOrElse(null))
  }

    /**
     * Set a binary message handler on the connection. This handler serves a similar purpose to [[io.vertx.core.http.ServerWebSocket#handler]]
     * except that if a message comes into the socket in multiple frames, the data from the frames will be aggregated
     * into a single buffer before calling the handler (using [[io.vertx.core.http.WebSocketFrame#isFinal]] to find the boundaries).     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def binaryMessageHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.binaryMessageHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

    /**
     * Set a pong frame handler on the connection.  This handler will be invoked every time a pong frame is received
     * on the server, and can be used by both clients and servers since the RFC 6455 <a href="https://tools.ietf.org/html/rfc6455#section-5.5.2">section 5.5.2</a> and <a href="https://tools.ietf.org/html/rfc6455#section-5.5.3">section 5.5.3</a> do not
     * specify whether the client or server sends a ping.
     * 
     * Pong frames may be at most 125 bytes (octets).
     * 
     * There is no ping handler since ping frames should immediately be responded to with a pong frame with identical content
     * 
     * Pong frames may be received unsolicited.     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def pongHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.pongHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

    /**
     * Same as [[io.vertx.core.http.WebSocketBase#close]] but with an `handler` called when the operation completes
     */
  def close(statusCode: java.lang.Short, reason: scala.Option[java.lang.String], handler: AsyncResult[Void] => Unit) = {
      asJava.close(statusCode, reason.getOrElse(null), handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
  }

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def drainHandler(handler: scala.Option[Void => Unit]) = {
      asJava.drainHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def closeHandler(handler: scala.Option[Void => Unit]) = {
      asJava.closeHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def frameHandler(handler: scala.Option[io.vertx.core.http.WebSocketFrame => Unit]) = {
      asJava.frameHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocketFrame]]).getOrElse(null))
  }

    /**
     * Like query from [[io.vertx.core.http.ServerWebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def queryOption() = {
      scala.Option(asJava.query())
  }

    /**
     * Like pipeTo from [[io.vertx.core.http.ServerWebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like write from [[io.vertx.core.http.ServerWebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.http.ServerWebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like writePing from [[io.vertx.core.http.ServerWebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writePingFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writePing(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like writePong from [[io.vertx.core.http.ServerWebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writePongFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writePong(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.http.ServerWebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.http.ServerWebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.http.ServerWebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture(statusCode: java.lang.Short) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(statusCode, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.http.ServerWebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture(statusCode: java.lang.Short, reason: scala.Option[java.lang.String]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(statusCode, reason.getOrElse(null), new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def writeFrameFuture(frame: io.vertx.core.http.WebSocketFrame) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeFrame(frame, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def writeFinalTextFrameFuture(text: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeFinalTextFrame(text, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def writeFinalBinaryFrameFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeFinalBinaryFrame(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def writeBinaryMessageFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeBinaryMessage(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def writeTextMessageFuture(text: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeTextMessage(text, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like setHandshake from [[io.vertx.core.http.ServerWebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def setHandshakeFuture(future: io.vertx.core.Future[java.lang.Integer]) : scala.concurrent.Future[java.lang.Integer] = {
      val promise = concurrent.Promise[java.lang.Integer]()
      asJava.setHandshake(future, new Handler[AsyncResult[java.lang.Integer]] { override def handle(event: AsyncResult[java.lang.Integer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * Shared data allows you to share data safely between different parts of your application in a safe way.
    * 
    * Shared data provides:
    * <ul>
    *   <li>synchronous shared maps (local)</li>
    *   <li>asynchronous maps (local or cluster-wide)</li>
    *   <li>asynchronous locks (local or cluster-wide)</li>
    *   <li>asynchronous counters (local or cluster-wide)</li>
    * </ul>
    * 
    * 
    *   <strong>WARNING</strong>: In clustered mode, asynchronous maps/locks/counters rely on distributed data structures provided by the cluster manager.
    *   Beware that the latency relative to asynchronous maps/locks/counters operations can be much higher in clustered than in local mode.
    * </p>
    * Please see the documentation for more information.
    */

  implicit class SharedDataScala(val asJava: io.vertx.core.shareddata.SharedData) extends AnyVal {


    /**
     * Like getClusterWideMap from [[io.vertx.core.shareddata.SharedData]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getClusterWideMapFuture[K, V](name: java.lang.String) : scala.concurrent.Future[io.vertx.core.shareddata.AsyncMap[K, V]] = {
      val promise = concurrent.Promise[io.vertx.core.shareddata.AsyncMap[K, V]]()
      asJava.getClusterWideMap[K, V](name, new Handler[AsyncResult[io.vertx.core.shareddata.AsyncMap[K,V]]] { override def handle(event: AsyncResult[io.vertx.core.shareddata.AsyncMap[K,V]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getAsyncMap from [[io.vertx.core.shareddata.SharedData]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getAsyncMapFuture[K, V](name: java.lang.String) : scala.concurrent.Future[io.vertx.core.shareddata.AsyncMap[K, V]] = {
      val promise = concurrent.Promise[io.vertx.core.shareddata.AsyncMap[K, V]]()
      asJava.getAsyncMap[K, V](name, new Handler[AsyncResult[io.vertx.core.shareddata.AsyncMap[K,V]]] { override def handle(event: AsyncResult[io.vertx.core.shareddata.AsyncMap[K,V]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getLocalAsyncMap from [[io.vertx.core.shareddata.SharedData]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getLocalAsyncMapFuture[K, V](name: java.lang.String) : scala.concurrent.Future[io.vertx.core.shareddata.AsyncMap[K, V]] = {
      val promise = concurrent.Promise[io.vertx.core.shareddata.AsyncMap[K, V]]()
      asJava.getLocalAsyncMap[K, V](name, new Handler[AsyncResult[io.vertx.core.shareddata.AsyncMap[K,V]]] { override def handle(event: AsyncResult[io.vertx.core.shareddata.AsyncMap[K,V]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getLock from [[io.vertx.core.shareddata.SharedData]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getLockFuture(name: java.lang.String) : scala.concurrent.Future[io.vertx.core.shareddata.Lock] = {
      val promise = concurrent.Promise[io.vertx.core.shareddata.Lock]()
      asJava.getLock(name, new Handler[AsyncResult[io.vertx.core.shareddata.Lock]] { override def handle(event: AsyncResult[io.vertx.core.shareddata.Lock]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getLockWithTimeout from [[io.vertx.core.shareddata.SharedData]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getLockWithTimeoutFuture(name: java.lang.String, timeout: java.lang.Long) : scala.concurrent.Future[io.vertx.core.shareddata.Lock] = {
      val promise = concurrent.Promise[io.vertx.core.shareddata.Lock]()
      asJava.getLockWithTimeout(name, timeout, new Handler[AsyncResult[io.vertx.core.shareddata.Lock]] { override def handle(event: AsyncResult[io.vertx.core.shareddata.Lock]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getLocalLock from [[io.vertx.core.shareddata.SharedData]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getLocalLockFuture(name: java.lang.String) : scala.concurrent.Future[io.vertx.core.shareddata.Lock] = {
      val promise = concurrent.Promise[io.vertx.core.shareddata.Lock]()
      asJava.getLocalLock(name, new Handler[AsyncResult[io.vertx.core.shareddata.Lock]] { override def handle(event: AsyncResult[io.vertx.core.shareddata.Lock]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getLocalLockWithTimeout from [[io.vertx.core.shareddata.SharedData]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getLocalLockWithTimeoutFuture(name: java.lang.String, timeout: java.lang.Long) : scala.concurrent.Future[io.vertx.core.shareddata.Lock] = {
      val promise = concurrent.Promise[io.vertx.core.shareddata.Lock]()
      asJava.getLocalLockWithTimeout(name, timeout, new Handler[AsyncResult[io.vertx.core.shareddata.Lock]] { override def handle(event: AsyncResult[io.vertx.core.shareddata.Lock]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getCounter from [[io.vertx.core.shareddata.SharedData]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getCounterFuture(name: java.lang.String) : scala.concurrent.Future[io.vertx.core.shareddata.Counter] = {
      val promise = concurrent.Promise[io.vertx.core.shareddata.Counter]()
      asJava.getCounter(name, new Handler[AsyncResult[io.vertx.core.shareddata.Counter]] { override def handle(event: AsyncResult[io.vertx.core.shareddata.Counter]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getLocalCounter from [[io.vertx.core.shareddata.SharedData]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getLocalCounterFuture(name: java.lang.String) : scala.concurrent.Future[io.vertx.core.shareddata.Counter] = {
      val promise = concurrent.Promise[io.vertx.core.shareddata.Counter]()
      asJava.getLocalCounter(name, new Handler[AsyncResult[io.vertx.core.shareddata.Counter]] { override def handle(event: AsyncResult[io.vertx.core.shareddata.Counter]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object SocketAddress {
    /**
     * Create a inet socket address, `host` must be non `null` and `port` must be between `0`
     * and `65536`.
     * <br/>
     * The `host` string can be an host name or an host address.
     * <br/>
     * No name resolution will be attempted.     * @param port the port
     * @param host the host
     * @return the created socket address
     */
  def inetSocketAddress(port: java.lang.Integer, host: java.lang.String) = {
      io.vertx.core.net.SocketAddress.inetSocketAddress(port, host)
  }

    /**
     * Create a domain socket address from a `path`.     * @param path the address path
     * @return the created socket address
     */
  def domainSocketAddress(path: java.lang.String) = {
      io.vertx.core.net.SocketAddress.domainSocketAddress(path)
  }
  }






  type StreamPriority = io.vertx.core.http.StreamPriority
  object StreamPriority {
    def apply() = new StreamPriority()
    def apply(json: JsonObject) = new StreamPriority(json)
  }







  /**
    * A timeout stream is triggered by a timer, the scala-function will be call when the timer is fired,
    * it can be once or several times depending on the nature of the timer related to this stream. The
    *  will be called after the timer handler has been called.
    * 
    * Pausing the timer inhibits the timer shots until the stream is resumed. Setting a null handler callback cancels
    * the timer.
    */

  implicit class TimeoutStreamScala(val asJava: io.vertx.core.TimeoutStream) extends AnyVal {

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def handler(handler: scala.Option[java.lang.Long => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Long]]).getOrElse(null))
  }

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Like pipeTo from [[io.vertx.core.TimeoutStream]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[java.lang.Long]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type TracingOptions = io.vertx.core.tracing.TracingOptions
  object TracingOptions {
    def apply() = new TracingOptions()
    def apply(json: JsonObject) = new TracingOptions(json)
  }




  /**
    * The entry point into the Vert.x Core API.
    * 
    * You use an instance of this class for functionality including:
    * <ul>
    *   <li>Creating TCP clients and servers</li>
    *   <li>Creating HTTP clients and servers</li>
    *   <li>Creating DNS clients</li>
    *   <li>Creating Datagram sockets</li>
    *   <li>Setting and cancelling periodic and one-shot timers</li>
    *   <li>Getting a reference to the event bus API</li>
    *   <li>Getting a reference to the file system API</li>
    *   <li>Getting a reference to the shared data API</li>
    *   <li>Deploying and undeploying verticles</li>
    * </ul>
    * 
    * Most functionality in Vert.x core is fairly low level.
    * 
    * To create an instance of this class you can use the static factory methods: [[io.vertx.core.Vertx#vertx]],
    * [[io.vertx.core.Vertx#vertx]] and [[io.vertx.core.Vertx#clusteredVertx]].
    * 
    * Please see the user manual for more detailed usage information.
    */

  type Vertx = io.vertx.core.Vertx

  object Vertx {
    def vertx(options: VertxOptions = null): io.vertx.core.Vertx =
      if(options == null)
        io.vertx.core.Vertx.vertx()
      else
        io.vertx.core.Vertx.vertx(options)

    def clusteredVertx(options: VertxOptions): scala.concurrent.Future[io.vertx.core.Vertx] = {
      val promise = concurrent.Promise[io.vertx.core.Vertx]()
      io.vertx.core.Vertx.clusteredVertx(options).onComplete({a:AsyncResult[io.vertx.core.Vertx] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def currentContext(): scala.Option[io.vertx.core.Context] =
      scala.Option(io.vertx.core.Vertx.currentContext())
  }


  implicit class VertxScala(val asJava: io.vertx.core.Vertx) extends AnyVal {

    import io.vertx.lang.scala.ScalaVerticle

    /**
      * Deploy a verticle instance that you have created yourself.
      * <p>
      * Vert.x will assign the verticle a context and start the verticle.
      * <p>
      * The actual deploy happens asynchronously and may not complete until after the call has returned.
      *
      * @param  verticle the verticle instance to deploy.
      */
    def deployVerticle(verticle: ScalaVerticle): Unit = {
      asJava.deployVerticle(verticle.asJava())
    }

    /**
      * Like [[deployVerticle]] but returns a Scala Future instead of taking an AsyncResultHandler.
      */
    def deployVerticleFuture(verticle: ScalaVerticle): scala.concurrent.Future[String] = {
      val promise = concurrent.Promise[String]()
      asJava.deployVerticle(verticle.asJava(), {a:AsyncResult[String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
      * Like {@link #deployVerticle(Verticle)} but {@link io.vertx.core.DeploymentOptions} are provided to configure the
      * deployment.
      *
      * @param verticle the verticle instance to deploy
      * @param options  the deployment options.
      */
    def deployVerticle(verticle: ScalaVerticle, options: DeploymentOptions): Unit = {
      asJava.deployVerticle(verticle.asJava(), options)
    }

    /**
      * Like [[deployVerticle]] but returns a Scala Future instead of taking an AsyncResultHandler.
      */
    def deployVerticleFuture(verticle: ScalaVerticle, options: DeploymentOptions): scala.concurrent.Future[String] = {
      val promise = concurrent.Promise[String]()
      asJava.deployVerticle(verticle.asJava(),options , {a:AsyncResult[String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
      * Safely execute some blocking code.
      *
      * Executes the blocking code in the handler `blockingCodeHandler` using a thread from the worker pool.
      *
      * When the code is complete the returned Future will be completed with the result.
      *
      * @param blockingFunction function containing blocking code
      * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
      * @return a Future representing the result of the blocking operation
      */
    def executeBlockingFuture[T](blockingFunction: () => T, ordered: Boolean = true): concurrent.Future[T] = {
      val promise = concurrent.Promise[T]
      val h: Handler[io.vertx.core.Promise[T]] = {f => util.Try(blockingFunction()) match {
        case util.Success(s) => f.complete(s)
        case util.Failure(t) => f.fail(t)
      }}
      asJava.executeBlocking[T](h, ordered, {h:AsyncResult[T] => {if (h.succeeded()) promise.success(h.result()) else promise.failure(h.cause());()} })
      promise.future
    }



    /**
     * Set a default exception handler for [[io.vertx.core.Context]], set on [[io.vertx.core.Context#exceptionHandler]] at creation.     * @param handler the exception handler
     * @return a reference to this, so the API can be used fluently
     */
  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

    /**
     * Like close from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like deployVerticle from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deployVerticleFuture(name: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.deployVerticle(name, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like deployVerticle from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deployVerticleFuture(name: java.lang.String, options: io.vertx.core.DeploymentOptions) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.deployVerticle(name, options, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like undeploy from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def undeployFuture(deploymentID: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.undeploy(deploymentID, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type VertxOptions = io.vertx.core.VertxOptions
  object VertxOptions {
    def apply() = new VertxOptions()
    def apply(json: JsonObject) = new VertxOptions(json)
  }




  /**
    * Represents a client-side WebSocket.
    */

  implicit class WebSocketScala(val asJava: io.vertx.core.http.WebSocket) extends AnyVal {

    /**
     * Set a text message handler on the connection. This handler will be called similar to the
     * [[io.vertx.core.http.WebSocketBase#binaryMessageHandler]], but the buffer will be converted to a String first     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def textMessageHandler(handler: scala.Option[java.lang.String => Unit]) = {
      asJava.textMessageHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.String]]).getOrElse(null))
  }

    /**
     * Set a binary message handler on the connection. This handler serves a similar purpose to [[io.vertx.core.http.WebSocket#handler]]
     * except that if a message comes into the socket in multiple frames, the data from the frames will be aggregated
     * into a single buffer before calling the handler (using [[io.vertx.core.http.WebSocketFrame#isFinal]] to find the boundaries).     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def binaryMessageHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.binaryMessageHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

    /**
     * Set a pong frame handler on the connection.  This handler will be invoked every time a pong frame is received
     * on the server, and can be used by both clients and servers since the RFC 6455 <a href="https://tools.ietf.org/html/rfc6455#section-5.5.2">section 5.5.2</a> and <a href="https://tools.ietf.org/html/rfc6455#section-5.5.3">section 5.5.3</a> do not
     * specify whether the client or server sends a ping.
     * 
     * Pong frames may be at most 125 bytes (octets).
     * 
     * There is no ping handler since ping frames should immediately be responded to with a pong frame with identical content
     * 
     * Pong frames may be received unsolicited.     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def pongHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.pongHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

    /**
     * Same as [[io.vertx.core.http.WebSocketBase#close]] but with an `handler` called when the operation completes
     */
  def close(statusCode: java.lang.Short, reason: scala.Option[java.lang.String], handler: AsyncResult[Void] => Unit) = {
      asJava.close(statusCode, reason.getOrElse(null), handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
  }

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def drainHandler(handler: scala.Option[Void => Unit]) = {
      asJava.drainHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def closeHandler(handler: scala.Option[Void => Unit]) = {
      asJava.closeHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def frameHandler(handler: scala.Option[io.vertx.core.http.WebSocketFrame => Unit]) = {
      asJava.frameHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocketFrame]]).getOrElse(null))
  }

    /**
     * Like pipeTo from [[io.vertx.core.http.WebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like write from [[io.vertx.core.http.WebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.http.WebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like writePing from [[io.vertx.core.http.WebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writePingFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writePing(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like writePong from [[io.vertx.core.http.WebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writePongFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writePong(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.http.WebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.http.WebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.http.WebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture(statusCode: java.lang.Short) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(statusCode, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.http.WebSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture(statusCode: java.lang.Short, reason: scala.Option[java.lang.String]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(statusCode, reason.getOrElse(null), new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def writeFrameFuture(frame: io.vertx.core.http.WebSocketFrame) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeFrame(frame, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def writeFinalTextFrameFuture(text: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeFinalTextFrame(text, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def writeFinalBinaryFrameFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeFinalBinaryFrame(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def writeBinaryMessageFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeBinaryMessage(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def writeTextMessageFuture(text: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeTextMessage(text, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * Base WebSocket implementation.
    * 
    * It implements both  and  so it can be used with
    * [[io.vertx.core.streams.Pipe]] to pipe data with flow control.
    */

  implicit class WebSocketBaseScala(val asJava: io.vertx.core.http.WebSocketBase) extends AnyVal {

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def drainHandler(handler: scala.Option[Void => Unit]) = {
      asJava.drainHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Set a close handler. This will be called when the WebSocket is closed.
     * <p/>
     * After this callback, no more messages are expected. When the WebSocket received a close frame, the
     * [[io.vertx.core.http.WebSocketBase#closeStatusCode]] will return the status code and [[io.vertx.core.http.WebSocketBase#closeReason]] will return the reason.     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def closeHandler(handler: scala.Option[Void => Unit]) = {
      asJava.closeHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Set a frame handler on the connection. This handler will be called when frames are read on the connection.     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def frameHandler(handler: scala.Option[io.vertx.core.http.WebSocketFrame => Unit]) = {
      asJava.frameHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocketFrame]]).getOrElse(null))
  }

    /**
     * Set a text message handler on the connection. This handler will be called similar to the
     * [[io.vertx.core.http.WebSocketBase#binaryMessageHandler]], but the buffer will be converted to a String first     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def textMessageHandler(handler: scala.Option[java.lang.String => Unit]) = {
      asJava.textMessageHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.String]]).getOrElse(null))
  }

    /**
     * Set a binary message handler on the connection. This handler serves a similar purpose to [[io.vertx.core.http.WebSocketBase#handler]]
     * except that if a message comes into the socket in multiple frames, the data from the frames will be aggregated
     * into a single buffer before calling the handler (using [[io.vertx.core.http.WebSocketFrame#isFinal]] to find the boundaries).     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def binaryMessageHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.binaryMessageHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

    /**
     * Set a pong frame handler on the connection.  This handler will be invoked every time a pong frame is received
     * on the server, and can be used by both clients and servers since the RFC 6455 <a href="https://tools.ietf.org/html/rfc6455#section-5.5.2">section 5.5.2</a> and <a href="https://tools.ietf.org/html/rfc6455#section-5.5.3">section 5.5.3</a> do not
     * specify whether the client or server sends a ping.
     * 
     * Pong frames may be at most 125 bytes (octets).
     * 
     * There is no ping handler since ping frames should immediately be responded to with a pong frame with identical content
     * 
     * Pong frames may be received unsolicited.     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def pongHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.pongHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

    /**
     * Same as [[io.vertx.core.http.WebSocketBase#close]] but with an `handler` called when the operation completes
     */
  def close(statusCode: java.lang.Short, reason: scala.Option[java.lang.String], handler: AsyncResult[Void] => Unit) = {
      asJava.close(statusCode, reason.getOrElse(null), handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
  }

    /**
     * Like pipeTo from [[io.vertx.core.http.WebSocketBase]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like write from [[io.vertx.core.http.WebSocketBase]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.http.WebSocketBase]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like writeFrame from [[io.vertx.core.http.WebSocketBase]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFrameFuture(frame: io.vertx.core.http.WebSocketFrame) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeFrame(frame, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like writeFinalTextFrame from [[io.vertx.core.http.WebSocketBase]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFinalTextFrameFuture(text: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeFinalTextFrame(text, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like writeFinalBinaryFrame from [[io.vertx.core.http.WebSocketBase]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFinalBinaryFrameFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeFinalBinaryFrame(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like writeBinaryMessage from [[io.vertx.core.http.WebSocketBase]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeBinaryMessageFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeBinaryMessage(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like writeTextMessage from [[io.vertx.core.http.WebSocketBase]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeTextMessageFuture(text: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writeTextMessage(text, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like writePing from [[io.vertx.core.http.WebSocketBase]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writePingFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writePing(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like writePong from [[io.vertx.core.http.WebSocketBase]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writePongFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.writePong(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.http.WebSocketBase]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.http.WebSocketBase]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.http.WebSocketBase]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture(statusCode: java.lang.Short) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(statusCode, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.core.http.WebSocketBase]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture(statusCode: java.lang.Short, reason: scala.Option[java.lang.String]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(statusCode, reason.getOrElse(null), new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type WebSocketConnectOptions = io.vertx.core.http.WebSocketConnectOptions
  object WebSocketConnectOptions {
    def apply() = new WebSocketConnectOptions()
    def apply(json: JsonObject) = new WebSocketConnectOptions(json)
  }



  object WebSocketFrame {
    /**
     * Create a binary WebSocket frame.     * @param data the data for the frame
     * @param isFinal true if it's the final frame in the WebSocket message
     * @return the frame
     */
  def binaryFrame(data: io.vertx.core.buffer.Buffer, isFinal: java.lang.Boolean) = {
      io.vertx.core.http.WebSocketFrame.binaryFrame(data, isFinal)
  }

    /**
     * Create a text WebSocket frame.     * @param str the string for the frame
     * @param isFinal true if it's the final frame in the WebSocket message
     * @return the frame
     */
  def textFrame(str: java.lang.String, isFinal: java.lang.Boolean) = {
      io.vertx.core.http.WebSocketFrame.textFrame(str, isFinal)
  }

    /**
     * Create a ping WebSocket frame.  Will be a final frame. There is no option for non final ping frames.     * @param data the bytes for the frame, may be at most 125 bytes
     * @return the frame
     */
  def pingFrame(data: io.vertx.core.buffer.Buffer) = {
      io.vertx.core.http.WebSocketFrame.pingFrame(data)
  }

    /**
     * Create a pong WebSocket frame.  Will be a final frame. There is no option for non final pong frames.     * @param data the bytes for the frame, may be at most 125 bytes
     * @return the frame
     */
  def pongFrame(data: io.vertx.core.buffer.Buffer) = {
      io.vertx.core.http.WebSocketFrame.pongFrame(data)
  }

    /**
     * Create a continuation frame     * @param data the data for the frame
     * @param isFinal true if it's the final frame in the WebSocket message
     * @return the frame
     */
  def continuationFrame(data: io.vertx.core.buffer.Buffer, isFinal: java.lang.Boolean) = {
      io.vertx.core.http.WebSocketFrame.continuationFrame(data, isFinal)
  }
  }



  /**
    * An executor for executing blocking code in Vert.x .
    *
    * It provides the same <code>executeBlocking</code> operation than [[io.vertx.core.Context]] and
    * [[io.vertx.core.Vertx]] but on a separate worker pool.
    */

  implicit class WorkerExecutorScala(val asJava: io.vertx.core.WorkerExecutor) extends AnyVal {
    /**
      * Safely execute some blocking code.
      *
      * Executes the blocking code in the handler `blockingCodeHandler` using a thread from the worker pool.
      *
      * When the code is complete the returned Future will be completed with the result.
      *
      * @param blockingFunction function containing blocking code
      * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
      * @return a Future representing the result of the blocking operation
      */
    def executeBlockingFuture[T](blockingFunction: () => T, ordered: Boolean = true): concurrent.Future[T] = {
      val promise = concurrent.Promise[T]
      val h: Handler[io.vertx.core.Promise[T]] = {f => util.Try(blockingFunction()) match {
        case util.Success(s) => f.complete(s)
        case util.Failure(t) => f.fail(t)
      }}
      asJava.executeBlocking[T](h, ordered, {h:AsyncResult[T] => {if (h.succeeded()) promise.success(h.result()) else promise.failure(h.cause());()} })
      promise.future
    }






  }




  /**
    *
    * Represents a stream of data that can be written to.
    * 
    * Any class that implements this interface can be used by a [[io.vertx.core.streams.Pipe]] to pipe data from a `ReadStream`
    * to it.
    */

  implicit class WriteStreamScala[T](val asJava: io.vertx.core.streams.WriteStream[T]) extends AnyVal {

    /**
     * Set an exception handler on the write stream.     * @param handler the exception handler
     * @return a reference to this, so the API can be used fluently
     */
  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

    /**
     * Same as  but with an `handler` called when the operation completes
     */
  def write(data: T, handler: AsyncResult[Void] => Unit) = {
      asJava.write(data, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
  }

    /**
     * Same as  but with an `handler` called when the operation completes
     */
  def end(data: T, handler: AsyncResult[Void] => Unit) = {
      asJava.end(data, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
  }

    /**
     * Set a drain handler on the stream. If the write queue is full, then the handler will be called when the write
     * queue is ready to accept buffers again. See [[io.vertx.core.streams.Pump]] for an example of this being used.
     * <p/>
     * The stream implementation defines when the drain handler, for example it could be when the queue size has been
     * reduced to `maxSize / 2`.     * @param handler the handler
     * @return a reference to this, so the API can be used fluently
     */
  def drainHandler(handler: scala.Option[Void => Unit]) = {
      asJava.drainHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Like write from [[io.vertx.core.streams.WriteStream]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def writeFuture(data: T) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.streams.WriteStream]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like end from [[io.vertx.core.streams.WriteStream]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endFuture(data: T) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



}
