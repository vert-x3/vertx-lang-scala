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

import scala.collection.JavaConverters._
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


    def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.file.AsyncFile = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.core.file.AsyncFile = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }


    def drainHandler(handler: scala.Option[Void => Unit]): io.vertx.core.file.AsyncFile = {
      asJava.drainHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.file.AsyncFile = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(buffer: io.vertx.core.buffer.Buffer,position: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(buffer, position, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[read]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def readFuture(buffer: io.vertx.core.buffer.Buffer,offset: java.lang.Integer,position: java.lang.Long,length: java.lang.Integer): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = Promise[io.vertx.core.buffer.Buffer]()
      asJava.read(buffer, offset, position, length, {a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[flush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def flushFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.flush({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def get(k: K,resultHandler: AsyncResult[V] => Unit): Unit = {
      asJava.get(k, {p:AsyncResult[V] => resultHandler(p)})
    }


    /**
     * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def put(k: K,v: V,completionHandler: AsyncResult[Void] => Unit): Unit = {
      asJava.put(k, v, {p:AsyncResult[Void] => completionHandler(p)})
    }


    /**
     * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def put(k: K,v: V,ttl: java.lang.Long,completionHandler: AsyncResult[Void] => Unit): Unit = {
      asJava.put(k, v, ttl, {p:AsyncResult[Void] => completionHandler(p)})
    }


    /**
     * Like [[putIfAbsent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putIfAbsent(k: K,v: V,completionHandler: AsyncResult[V] => Unit): Unit = {
      asJava.putIfAbsent(k, v, {p:AsyncResult[V] => completionHandler(p)})
    }


    /**
     * Like [[putIfAbsent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putIfAbsent(k: K,v: V,ttl: java.lang.Long,completionHandler: AsyncResult[V] => Unit): Unit = {
      asJava.putIfAbsent(k, v, ttl, {p:AsyncResult[V] => completionHandler(p)})
    }


    /**
     * Like [[remove]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def remove(k: K,resultHandler: AsyncResult[V] => Unit): Unit = {
      asJava.remove(k, {p:AsyncResult[V] => resultHandler(p)})
    }


    /**
     * Like [[removeIfPresent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def removeIfPresent(k: K,v: V,resultHandler: AsyncResult[java.lang.Boolean] => Unit): Unit = {
      asJava.removeIfPresent(k, v, {p:AsyncResult[java.lang.Boolean] => resultHandler(p)})
    }


    /**
     * Like [[replace]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replace(k: K,v: V,resultHandler: AsyncResult[V] => Unit): Unit = {
      asJava.replace(k, v, {p:AsyncResult[V] => resultHandler(p)})
    }


    /**
     * Like [[replaceIfPresent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replaceIfPresent(k: K,oldValue: V,newValue: V,resultHandler: AsyncResult[java.lang.Boolean] => Unit): Unit = {
      asJava.replaceIfPresent(k, oldValue, newValue, {p:AsyncResult[java.lang.Boolean] => resultHandler(p)})
    }

    /**
     * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getFuture(k: K): scala.concurrent.Future[V] = {
      val promise = Promise[V]()
      asJava.get(k, {a:AsyncResult[V] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putFuture(k: K,v: V): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.put(k, v, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putFuture(k: K,v: V,ttl: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.put(k, v, ttl, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[putIfAbsent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putIfAbsentFuture(k: K,v: V): scala.concurrent.Future[V] = {
      val promise = Promise[V]()
      asJava.putIfAbsent(k, v, {a:AsyncResult[V] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[putIfAbsent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putIfAbsentFuture(k: K,v: V,ttl: java.lang.Long): scala.concurrent.Future[V] = {
      val promise = Promise[V]()
      asJava.putIfAbsent(k, v, ttl, {a:AsyncResult[V] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[remove]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def removeFuture(k: K): scala.concurrent.Future[V] = {
      val promise = Promise[V]()
      asJava.remove(k, {a:AsyncResult[V] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[removeIfPresent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def removeIfPresentFuture(k: K,v: V): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.removeIfPresent(k, v, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[replace]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replaceFuture(k: K,v: V): scala.concurrent.Future[V] = {
      val promise = Promise[V]()
      asJava.replace(k, v, {a:AsyncResult[V] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[replaceIfPresent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replaceIfPresentFuture(k: K,oldValue: V,newValue: V): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.replaceIfPresent(k, oldValue, newValue, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clear]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clearFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clear({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[size]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sizeFuture(): scala.concurrent.Future[java.lang.Integer] = {
      val promise = Promise[java.lang.Integer]()
      asJava.size({a:AsyncResult[java.lang.Integer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }







  /**
    * The composite future wraps a list of [[io.vertx.core.Future]], it is useful when several futures
    * needs to be coordinated.
    * The handlers set for the coordinated futures are overridden by the handler of the composite future.
    */

  implicit class CompositeFutureScala(val asJava: io.vertx.core.CompositeFuture) extends AnyVal {

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
      val h: Handler[io.vertx.core.Future[T]] = {f => util.Try(blockingFunction()) match {
        case util.Success(s) => f.complete(s)
        case util.Failure(t) => f.fail(t)
      }}
      asJava.executeBlocking[T](h, ordered, {h:AsyncResult[T] => {if (h.succeeded()) promise.success(h.result()) else promise.failure(h.cause());()} })
      promise.future
    }



    /**
     * Like [[config]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configOption(): scala.Option[io.vertx.core.json.JsonObject] = {
      scala.Option(asJava.config())
    }


    /**
     * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def put(key: java.lang.String,value: AnyRef): Unit = {
      asJava.put(key, value)
    }


    /**
     * Like [[exceptionHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.Context = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
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
     * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getFuture(): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.get({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incrementAndGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrementAndGetFuture(): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.incrementAndGet({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getAndIncrement]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getAndIncrementFuture(): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.getAndIncrement({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[decrementAndGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def decrementAndGetFuture(): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.decrementAndGet({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[addAndGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def addAndGetFuture(value: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.addAndGet(value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getAndAdd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getAndAddFuture(value: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.getAndAdd(value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[compareAndSet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def compareAndSetFuture(expected: java.lang.Long,value: java.lang.Long): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.compareAndSet(expected, value, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[listenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenMulticastGroup(multicastAddress: java.lang.String,networkInterface: java.lang.String,source: scala.Option[java.lang.String],handler: AsyncResult[io.vertx.core.datagram.DatagramSocket] => Unit): io.vertx.core.datagram.DatagramSocket = {
      asJava.listenMulticastGroup(multicastAddress, networkInterface, source.orNull, {p:AsyncResult[io.vertx.core.datagram.DatagramSocket] => handler(p)})
    }


    /**
     * Like [[unlistenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlistenMulticastGroup(multicastAddress: java.lang.String,networkInterface: java.lang.String,source: scala.Option[java.lang.String],handler: AsyncResult[io.vertx.core.datagram.DatagramSocket] => Unit): io.vertx.core.datagram.DatagramSocket = {
      asJava.unlistenMulticastGroup(multicastAddress, networkInterface, source.orNull, {p:AsyncResult[io.vertx.core.datagram.DatagramSocket] => handler(p)})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.core.datagram.DatagramSocket = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }


    def handler(handler: scala.Option[io.vertx.core.datagram.DatagramPacket => Unit]): io.vertx.core.datagram.DatagramSocket = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.core.datagram.DatagramPacket => t(p); case None => null})
    }


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.datagram.DatagramSocket = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture(packet: io.vertx.core.buffer.Buffer,port: java.lang.Integer,host: java.lang.String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
      val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
      asJava.send(packet, port, host, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture(str: java.lang.String,port: java.lang.Integer,host: java.lang.String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
      val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
      asJava.send(str, port, host, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture(str: java.lang.String,enc: java.lang.String,port: java.lang.Integer,host: java.lang.String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
      val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
      asJava.send(str, enc, port, host, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenMulticastGroupFuture(multicastAddress: java.lang.String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
      val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
      asJava.listenMulticastGroup(multicastAddress, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenMulticastGroupFuture(multicastAddress: java.lang.String,networkInterface: java.lang.String,source: scala.Option[java.lang.String]): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
      val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
      asJava.listenMulticastGroup(multicastAddress, networkInterface, source, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unlistenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlistenMulticastGroupFuture(multicastAddress: java.lang.String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
      val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
      asJava.unlistenMulticastGroup(multicastAddress, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unlistenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlistenMulticastGroupFuture(multicastAddress: java.lang.String,networkInterface: java.lang.String,source: scala.Option[java.lang.String]): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
      val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
      asJava.unlistenMulticastGroup(multicastAddress, networkInterface, source, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[blockMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def blockMulticastGroupFuture(multicastAddress: java.lang.String,sourceToBlock: java.lang.String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
      val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
      asJava.blockMulticastGroup(multicastAddress, sourceToBlock, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[blockMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def blockMulticastGroupFuture(multicastAddress: java.lang.String,networkInterface: java.lang.String,sourceToBlock: java.lang.String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
      val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
      asJava.blockMulticastGroup(multicastAddress, networkInterface, sourceToBlock, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(port: java.lang.Integer,host: java.lang.String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
      val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
      asJava.listen(port, host, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[lookup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lookupFuture(name: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lookup(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lookup4]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lookup4Future(name: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lookup4(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lookup6]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lookup6Future(name: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lookup6(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[resolveA]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def resolveAFuture(name: java.lang.String): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.resolveA(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[resolveAAAA]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def resolveAAAAFuture(name: java.lang.String): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.resolveAAAA(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[resolveCNAME]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def resolveCNAMEFuture(name: java.lang.String): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.resolveCNAME(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[resolveMX]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def resolveMXFuture(name: java.lang.String): scala.concurrent.Future[java.util.List[io.vertx.core.dns.MxRecord]] = {
      val promise = Promise[java.util.List[io.vertx.core.dns.MxRecord]]()
      asJava.resolveMX(name, {a:AsyncResult[java.util.List[io.vertx.core.dns.MxRecord]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[resolveTXT]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def resolveTXTFuture(name: java.lang.String): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.resolveTXT(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[resolvePTR]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def resolvePTRFuture(name: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.resolvePTR(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[resolveNS]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def resolveNSFuture(name: java.lang.String): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.resolveNS(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[resolveSRV]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def resolveSRVFuture(name: java.lang.String): scala.concurrent.Future[java.util.List[io.vertx.core.dns.SrvRecord]] = {
      val promise = Promise[java.util.List[io.vertx.core.dns.SrvRecord]]()
      asJava.resolveSRV(name, {a:AsyncResult[java.util.List[io.vertx.core.dns.SrvRecord]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[reverseLookup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def reverseLookupFuture(ipaddress: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.reverseLookup(ipaddress, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def send(address: java.lang.String,message: AnyRef): io.vertx.core.eventbus.EventBus = {
      asJava.send(address, message)
    }


    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def send[T](address: java.lang.String,message: AnyRef,replyHandler: AsyncResult[io.vertx.core.eventbus.Message[T]] => Unit): io.vertx.core.eventbus.EventBus = {
      asJava.send[T](address, message, {p:AsyncResult[io.vertx.core.eventbus.Message[T]] => replyHandler(p)})
    }


    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def send(address: java.lang.String,message: AnyRef,options: io.vertx.core.eventbus.DeliveryOptions): io.vertx.core.eventbus.EventBus = {
      asJava.send(address, message, options)
    }


    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def send[T](address: java.lang.String,message: AnyRef,options: io.vertx.core.eventbus.DeliveryOptions,replyHandler: AsyncResult[io.vertx.core.eventbus.Message[T]] => Unit): io.vertx.core.eventbus.EventBus = {
      asJava.send[T](address, message, options, {p:AsyncResult[io.vertx.core.eventbus.Message[T]] => replyHandler(p)})
    }


    /**
     * Like [[publish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def publish(address: java.lang.String,message: AnyRef): io.vertx.core.eventbus.EventBus = {
      asJava.publish(address, message)
    }


    /**
     * Like [[publish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def publish(address: java.lang.String,message: AnyRef,options: io.vertx.core.eventbus.DeliveryOptions): io.vertx.core.eventbus.EventBus = {
      asJava.publish(address, message, options)
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture[T](address: java.lang.String,message: AnyRef): scala.concurrent.Future[io.vertx.core.eventbus.Message[T]] = {
      val promise = Promise[io.vertx.core.eventbus.Message[T]]()
      asJava.send[T](address, message, {a:AsyncResult[io.vertx.core.eventbus.Message[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture[T](address: java.lang.String,message: AnyRef,options: io.vertx.core.eventbus.DeliveryOptions): scala.concurrent.Future[io.vertx.core.eventbus.Message[T]] = {
      val promise = Promise[io.vertx.core.eventbus.Message[T]]()
      asJava.send[T](address, message, options, {a:AsyncResult[io.vertx.core.eventbus.Message[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[chown]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def chown(path: java.lang.String,user: scala.Option[java.lang.String],group: scala.Option[java.lang.String],handler: AsyncResult[Void] => Unit): io.vertx.core.file.FileSystem = {
      asJava.chown(path, user.orNull, group.orNull, {p:AsyncResult[Void] => handler(p)})
    }


    /**
     * Like [[chownBlocking]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def chownBlocking(path: java.lang.String,user: scala.Option[java.lang.String],group: scala.Option[java.lang.String]): io.vertx.core.file.FileSystem = {
      asJava.chownBlocking(path, user.orNull, group.orNull)
    }

    /**
     * Like [[copy]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def copyFuture(from: java.lang.String,to: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.copy(from, to, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[copy]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def copyFuture(from: java.lang.String,to: java.lang.String,options: io.vertx.core.file.CopyOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.copy(from, to, options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[copyRecursive]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def copyRecursiveFuture(from: java.lang.String,to: java.lang.String,recursive: java.lang.Boolean): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.copyRecursive(from, to, recursive, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[move]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def moveFuture(from: java.lang.String,to: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.move(from, to, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[move]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def moveFuture(from: java.lang.String,to: java.lang.String,options: io.vertx.core.file.CopyOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.move(from, to, options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[truncate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def truncateFuture(path: java.lang.String,len: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.truncate(path, len, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[chmod]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def chmodFuture(path: java.lang.String,perms: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.chmod(path, perms, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[chmodRecursive]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def chmodRecursiveFuture(path: java.lang.String,perms: java.lang.String,dirPerms: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.chmodRecursive(path, perms, dirPerms, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[chown]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def chownFuture(path: java.lang.String,user: scala.Option[java.lang.String],group: scala.Option[java.lang.String]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.chown(path, user, group, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[props]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def propsFuture(path: java.lang.String): scala.concurrent.Future[io.vertx.core.file.FileProps] = {
      val promise = Promise[io.vertx.core.file.FileProps]()
      asJava.props(path, {a:AsyncResult[io.vertx.core.file.FileProps] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lprops]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpropsFuture(path: java.lang.String): scala.concurrent.Future[io.vertx.core.file.FileProps] = {
      val promise = Promise[io.vertx.core.file.FileProps]()
      asJava.lprops(path, {a:AsyncResult[io.vertx.core.file.FileProps] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[link]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def linkFuture(link: java.lang.String,existing: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.link(link, existing, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[symlink]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def symlinkFuture(link: java.lang.String,existing: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.symlink(link, existing, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unlink]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlinkFuture(link: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.unlink(link, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[readSymlink]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def readSymlinkFuture(link: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.readSymlink(link, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[delete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deleteFuture(path: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.delete(path, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[deleteRecursive]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deleteRecursiveFuture(path: java.lang.String,recursive: java.lang.Boolean): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.deleteRecursive(path, recursive, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mkdir]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mkdirFuture(path: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.mkdir(path, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mkdir]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mkdirFuture(path: java.lang.String,perms: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.mkdir(path, perms, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mkdirs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mkdirsFuture(path: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.mkdirs(path, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mkdirs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mkdirsFuture(path: java.lang.String,perms: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.mkdirs(path, perms, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[readDir]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def readDirFuture(path: java.lang.String): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.readDir(path, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[readDir]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def readDirFuture(path: java.lang.String,filter: java.lang.String): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.readDir(path, filter, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[readFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def readFileFuture(path: java.lang.String): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = Promise[io.vertx.core.buffer.Buffer]()
      asJava.readFile(path, {a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[writeFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFileFuture(path: java.lang.String,data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeFile(path, data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[open]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def openFuture(path: java.lang.String,options: io.vertx.core.file.OpenOptions): scala.concurrent.Future[io.vertx.core.file.AsyncFile] = {
      val promise = Promise[io.vertx.core.file.AsyncFile]()
      asJava.open(path, options, {a:AsyncResult[io.vertx.core.file.AsyncFile] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createFileFuture(path: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.createFile(path, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createFileFuture(path: java.lang.String,perms: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.createFile(path, perms, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[exists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def existsFuture(path: java.lang.String): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.exists(path, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[fsProps]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def fsPropsFuture(path: java.lang.String): scala.concurrent.Future[io.vertx.core.file.FileSystemProps] = {
      val promise = Promise[io.vertx.core.file.FileSystemProps]()
      asJava.fsProps(path, {a:AsyncResult[io.vertx.core.file.FileSystemProps] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createTempDirectory]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createTempDirectoryFuture(prefix: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.createTempDirectory(prefix, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createTempDirectory]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createTempDirectoryFuture(prefix: java.lang.String,perms: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.createTempDirectory(prefix, perms, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createTempDirectory]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createTempDirectoryFuture(dir: java.lang.String,prefix: java.lang.String,perms: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.createTempDirectory(dir, prefix, perms, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createTempFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createTempFileFuture(prefix: java.lang.String,suffix: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.createTempFile(prefix, suffix, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createTempFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createTempFileFuture(prefix: java.lang.String,suffix: java.lang.String,perms: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.createTempFile(prefix, suffix, perms, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createTempFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createTempFileFuture(dir: java.lang.String,prefix: java.lang.String,suffix: java.lang.String,perms: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.createTempFile(dir, prefix, suffix, perms, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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




  type HttpClientOptions = io.vertx.core.http.HttpClientOptions

  object HttpClientOptions {
    def apply() = new HttpClientOptions()
    def apply(json: JsonObject) = new HttpClientOptions(json)
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
     * Like [[goAwayHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def goAwayHandler(handler: scala.Option[io.vertx.core.http.GoAway => Unit]): io.vertx.core.http.HttpConnection = {
      asJava.goAwayHandler(handler match {case Some(t) => p:io.vertx.core.http.GoAway => t(p); case None => null})
    }


    /**
     * Like [[shutdownHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def shutdownHandler(handler: scala.Option[Void => Unit]): io.vertx.core.http.HttpConnection = {
      asJava.shutdownHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    /**
     * Like [[pingHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pingHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.http.HttpConnection = {
      asJava.pingHandler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }

    /**
     * Like [[updateSettings]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def updateSettingsFuture(settings: io.vertx.core.http.Http2Settings): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.updateSettings(settings, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ping]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pingFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = Promise[io.vertx.core.buffer.Buffer]()
      asJava.ping(data, {a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  /**
    * An HTTP and WebSockets server.
    * 
    * You receive HTTP requests by providing a [[io.vertx.core.http.HttpServer#requestHandler]]. As requests arrive on the server the handler
    * will be called with the requests.
    * 
    * You receive WebSockets by providing a [[io.vertx.core.http.HttpServer#websocketHandler]]. As WebSocket connections arrive on the server, the
    * WebSocket is passed to the handler.
    */

  implicit class HttpServerScala(val asJava: io.vertx.core.http.HttpServer) extends AnyVal {

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(port: java.lang.Integer,host: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpServer] = {
      val promise = Promise[io.vertx.core.http.HttpServer]()
      asJava.listen(port, host, {a:AsyncResult[io.vertx.core.http.HttpServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(address: io.vertx.core.net.SocketAddress): scala.concurrent.Future[io.vertx.core.http.HttpServer] = {
      val promise = Promise[io.vertx.core.http.HttpServer]()
      asJava.listen(address, {a:AsyncResult[io.vertx.core.http.HttpServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(port: java.lang.Integer): scala.concurrent.Future[io.vertx.core.http.HttpServer] = {
      val promise = Promise[io.vertx.core.http.HttpServer]()
      asJava.listen(port, {a:AsyncResult[io.vertx.core.http.HttpServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(): scala.concurrent.Future[io.vertx.core.http.HttpServer] = {
      val promise = Promise[io.vertx.core.http.HttpServer]()
      asJava.listen({a:AsyncResult[io.vertx.core.http.HttpServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type HttpServerOptions = io.vertx.core.http.HttpServerOptions

  object HttpServerOptions {
    def apply() = new HttpServerOptions()
    def apply(json: JsonObject) = new HttpServerOptions(json)
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


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.http.HttpServerResponse = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def drainHandler(handler: scala.Option[Void => Unit]): io.vertx.core.http.HttpServerResponse = {
      asJava.drainHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    /**
     * Like [[closeHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeHandler(handler: scala.Option[Void => Unit]): io.vertx.core.http.HttpServerResponse = {
      asJava.closeHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    /**
     * Like [[endHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endHandler(handler: scala.Option[Void => Unit]): io.vertx.core.http.HttpServerResponse = {
      asJava.endHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    /**
     * Like [[headersEndHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def headersEndHandler(handler: scala.Option[Void => Unit]): io.vertx.core.http.HttpServerResponse = {
      asJava.headersEndHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    /**
     * Like [[bodyEndHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bodyEndHandler(handler: scala.Option[Void => Unit]): io.vertx.core.http.HttpServerResponse = {
      asJava.bodyEndHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }

    /**
     * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFileFuture(filename: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.sendFile(filename, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFileFuture(filename: java.lang.String,offset: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.sendFile(filename, offset, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFileFuture(filename: java.lang.String,offset: java.lang.Long,length: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.sendFile(filename, offset, length, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pushFuture(method: io.vertx.core.http.HttpMethod,host: java.lang.String,path: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpServerResponse] = {
      val promise = Promise[io.vertx.core.http.HttpServerResponse]()
      asJava.push(method, host, path, {a:AsyncResult[io.vertx.core.http.HttpServerResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pushFuture(method: io.vertx.core.http.HttpMethod,path: java.lang.String,headers: io.vertx.core.MultiMap): scala.concurrent.Future[io.vertx.core.http.HttpServerResponse] = {
      val promise = Promise[io.vertx.core.http.HttpServerResponse]()
      asJava.push(method, path, headers, {a:AsyncResult[io.vertx.core.http.HttpServerResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pushFuture(method: io.vertx.core.http.HttpMethod,path: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpServerResponse] = {
      val promise = Promise[io.vertx.core.http.HttpServerResponse]()
      asJava.push(method, path, {a:AsyncResult[io.vertx.core.http.HttpServerResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pushFuture(method: io.vertx.core.http.HttpMethod,host: java.lang.String,path: java.lang.String,headers: io.vertx.core.MultiMap): scala.concurrent.Future[io.vertx.core.http.HttpServerResponse] = {
      val promise = Promise[io.vertx.core.http.HttpServerResponse]()
      asJava.push(method, host, path, headers, {a:AsyncResult[io.vertx.core.http.HttpServerResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[replyAddress]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replyAddressOption(): scala.Option[java.lang.String] = {
      scala.Option(asJava.replyAddress())
    }


    /**
     * Like [[reply]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def reply(message: AnyRef): Unit = {
      asJava.reply(message)
    }


    /**
     * Like [[reply]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def reply[R](message: AnyRef,replyHandler: AsyncResult[io.vertx.core.eventbus.Message[R]] => Unit): Unit = {
      asJava.reply[R](message, {p:AsyncResult[io.vertx.core.eventbus.Message[R]] => replyHandler(p)})
    }


    /**
     * Like [[reply]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def reply(message: AnyRef,options: io.vertx.core.eventbus.DeliveryOptions): Unit = {
      asJava.reply(message, options)
    }


    /**
     * Like [[reply]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def reply[R](message: AnyRef,options: io.vertx.core.eventbus.DeliveryOptions,replyHandler: AsyncResult[io.vertx.core.eventbus.Message[R]] => Unit): Unit = {
      asJava.reply[R](message, options, {p:AsyncResult[io.vertx.core.eventbus.Message[R]] => replyHandler(p)})
    }

    /**
     * Like [[reply]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replyFuture[R](message: AnyRef): scala.concurrent.Future[io.vertx.core.eventbus.Message[R]] = {
      val promise = Promise[io.vertx.core.eventbus.Message[R]]()
      asJava.reply[R](message, {a:AsyncResult[io.vertx.core.eventbus.Message[R]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[reply]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replyFuture[R](message: AnyRef,options: io.vertx.core.eventbus.DeliveryOptions): scala.concurrent.Future[io.vertx.core.eventbus.Message[R]] = {
      val promise = Promise[io.vertx.core.eventbus.Message[R]]()
      asJava.reply[R](message, options, {a:AsyncResult[io.vertx.core.eventbus.Message[R]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.eventbus.MessageConsumer[T] = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def handler(handler: scala.Option[io.vertx.core.eventbus.Message[T] => Unit]): io.vertx.core.eventbus.MessageConsumer[T] = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.core.eventbus.Message[T] => t(p); case None => null})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.core.eventbus.MessageConsumer[T] = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }

    /**
     * Like [[completionHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def completionFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.completionHandler({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unregister]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unregisterFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.unregister({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  /**
    * Represents a stream of message that can be written to.
    * 
    */

  implicit class MessageProducerScala[T](val asJava: io.vertx.core.eventbus.MessageProducer[T]) extends AnyVal {


    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def end(t: T): Unit = {
      asJava.end(t)
    }


    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def send(message: T): io.vertx.core.eventbus.MessageProducer[T] = {
      asJava.send(message)
    }


    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def send[R](message: T,replyHandler: AsyncResult[io.vertx.core.eventbus.Message[R]] => Unit): io.vertx.core.eventbus.MessageProducer[T] = {
      asJava.send[R](message, {p:AsyncResult[io.vertx.core.eventbus.Message[R]] => replyHandler(p)})
    }


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.eventbus.MessageProducer[T] = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def write(data: T): io.vertx.core.eventbus.MessageProducer[T] = {
      asJava.write(data)
    }


    def drainHandler(handler: scala.Option[Void => Unit]): io.vertx.core.eventbus.MessageProducer[T] = {
      asJava.drainHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture[R](message: T): scala.concurrent.Future[io.vertx.core.eventbus.Message[R]] = {
      val promise = Promise[io.vertx.core.eventbus.Message[R]]()
      asJava.send[R](message, {a:AsyncResult[io.vertx.core.eventbus.Message[R]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  type MetricsOptions = io.vertx.core.metrics.MetricsOptions

  object MetricsOptions {
    def apply() = new MetricsOptions()
    def apply(json: JsonObject) = new MetricsOptions(json)
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
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(port: java.lang.Integer,host: java.lang.String): scala.concurrent.Future[io.vertx.core.net.NetSocket] = {
      val promise = Promise[io.vertx.core.net.NetSocket]()
      asJava.connect(port, host, {a:AsyncResult[io.vertx.core.net.NetSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(port: java.lang.Integer,host: java.lang.String,serverName: java.lang.String): scala.concurrent.Future[io.vertx.core.net.NetSocket] = {
      val promise = Promise[io.vertx.core.net.NetSocket]()
      asJava.connect(port, host, serverName, {a:AsyncResult[io.vertx.core.net.NetSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(remoteAddress: io.vertx.core.net.SocketAddress): scala.concurrent.Future[io.vertx.core.net.NetSocket] = {
      val promise = Promise[io.vertx.core.net.NetSocket]()
      asJava.connect(remoteAddress, {a:AsyncResult[io.vertx.core.net.NetSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(remoteAddress: io.vertx.core.net.SocketAddress,serverName: java.lang.String): scala.concurrent.Future[io.vertx.core.net.NetSocket] = {
      val promise = Promise[io.vertx.core.net.NetSocket]()
      asJava.connect(remoteAddress, serverName, {a:AsyncResult[io.vertx.core.net.NetSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[connectHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectHandler(handler: scala.Option[io.vertx.core.net.NetSocket => Unit]): io.vertx.core.net.NetServer = {
      asJava.connectHandler(handler match {case Some(t) => p:io.vertx.core.net.NetSocket => t(p); case None => null})
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(): scala.concurrent.Future[io.vertx.core.net.NetServer] = {
      val promise = Promise[io.vertx.core.net.NetServer]()
      asJava.listen({a:AsyncResult[io.vertx.core.net.NetServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(port: java.lang.Integer,host: java.lang.String): scala.concurrent.Future[io.vertx.core.net.NetServer] = {
      val promise = Promise[io.vertx.core.net.NetServer]()
      asJava.listen(port, host, {a:AsyncResult[io.vertx.core.net.NetServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(port: java.lang.Integer): scala.concurrent.Future[io.vertx.core.net.NetServer] = {
      val promise = Promise[io.vertx.core.net.NetServer]()
      asJava.listen(port, {a:AsyncResult[io.vertx.core.net.NetServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(localAddress: io.vertx.core.net.SocketAddress): scala.concurrent.Future[io.vertx.core.net.NetServer] = {
      val promise = Promise[io.vertx.core.net.NetServer]()
      asJava.listen(localAddress, {a:AsyncResult[io.vertx.core.net.NetServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.net.NetSocket = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.net.NetSocket = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    /**
     * Like [[endHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.core.net.NetSocket = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }


    def drainHandler(handler: scala.Option[Void => Unit]): io.vertx.core.net.NetSocket = {
      asJava.drainHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    /**
     * Like [[closeHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeHandler(handler: scala.Option[Void => Unit]): io.vertx.core.net.NetSocket = {
      asJava.closeHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(message: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(message, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFileFuture(filename: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.sendFile(filename, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFileFuture(filename: java.lang.String,offset: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.sendFile(filename, offset, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFileFuture(filename: java.lang.String,offset: java.lang.Long,length: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.sendFile(filename, offset, length, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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



  type ProxyOptions = io.vertx.core.net.ProxyOptions

  object ProxyOptions {
    def apply() = new ProxyOptions()
    def apply(json: JsonObject) = new ProxyOptions(json)
  }






  type RequestOptions = io.vertx.core.http.RequestOptions

  object RequestOptions {
    def apply() = new RequestOptions()
    def apply(json: JsonObject) = new RequestOptions(json)
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
     * Like [[getClusterWideMap]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getClusterWideMapFuture[K, V](name: java.lang.String): scala.concurrent.Future[io.vertx.core.shareddata.AsyncMap[K, V]] = {
      val promise = Promise[io.vertx.core.shareddata.AsyncMap[K, V]]()
      asJava.getClusterWideMap[K, V](name, {a:AsyncResult[io.vertx.core.shareddata.AsyncMap[K,V]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getAsyncMap]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getAsyncMapFuture[K, V](name: java.lang.String): scala.concurrent.Future[io.vertx.core.shareddata.AsyncMap[K, V]] = {
      val promise = Promise[io.vertx.core.shareddata.AsyncMap[K, V]]()
      asJava.getAsyncMap[K, V](name, {a:AsyncResult[io.vertx.core.shareddata.AsyncMap[K,V]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getLock]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getLockFuture(name: java.lang.String): scala.concurrent.Future[io.vertx.core.shareddata.Lock] = {
      val promise = Promise[io.vertx.core.shareddata.Lock]()
      asJava.getLock(name, {a:AsyncResult[io.vertx.core.shareddata.Lock] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getLockWithTimeout]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getLockWithTimeoutFuture(name: java.lang.String,timeout: java.lang.Long): scala.concurrent.Future[io.vertx.core.shareddata.Lock] = {
      val promise = Promise[io.vertx.core.shareddata.Lock]()
      asJava.getLockWithTimeout(name, timeout, {a:AsyncResult[io.vertx.core.shareddata.Lock] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getCounter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getCounterFuture(name: java.lang.String): scala.concurrent.Future[io.vertx.core.shareddata.Counter] = {
      val promise = Promise[io.vertx.core.shareddata.Counter]()
      asJava.getCounter(name, {a:AsyncResult[io.vertx.core.shareddata.Counter] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }





  type StreamPriority = io.vertx.core.http.StreamPriority

  object StreamPriority {
    def apply() = new StreamPriority()
    def apply(json: JsonObject) = new StreamPriority(json)
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
      * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
      */
    def deployVerticleFuture(verticle: ScalaVerticle): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
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
      * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
      */
    def deployVerticleFuture(verticle: ScalaVerticle, options: DeploymentOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
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
      val h: Handler[io.vertx.core.Future[T]] = {f => util.Try(blockingFunction()) match {
        case util.Success(s) => f.complete(s)
        case util.Failure(t) => f.fail(t)
      }}
      asJava.executeBlocking[T](h, ordered, {h:AsyncResult[T] => {if (h.succeeded()) promise.success(h.result()) else promise.failure(h.cause());()} })
      promise.future
    }



    /**
     * Like [[exceptionHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.Vertx = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deployVerticleFuture(name: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.deployVerticle(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deployVerticleFuture(name: java.lang.String,options: io.vertx.core.DeploymentOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.deployVerticle(name, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[undeploy]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def undeployFuture(deploymentID: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.undeploy(deploymentID, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  type VertxOptions = io.vertx.core.VertxOptions

  object VertxOptions {
    def apply() = new VertxOptions()
    def apply(json: JsonObject) = new VertxOptions(json)
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
      val h: Handler[io.vertx.core.Future[T]] = {f => util.Try(blockingFunction()) match {
        case util.Success(s) => f.complete(s)
        case util.Failure(t) => f.fail(t)
      }}
      asJava.executeBlocking[T](h, ordered, {h:AsyncResult[T] => {if (h.succeeded()) promise.success(h.result()) else promise.failure(h.cause());()} })
      promise.future
    }


  }


}
