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
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
      val h: Handler[io.vertx.core.Promise[T]] = {f => util.Try(blockingFunction()) match {
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
     * Like [[putLocal]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putLocal(key: java.lang.String,value: AnyRef): Unit = {
      asJava.putLocal(key, value)
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
    def listenMulticastGroup(multicastAddress: java.lang.String,networkInterface: java.lang.String,source: scala.Option[java.lang.String],handler: AsyncResult[Void] => Unit): io.vertx.core.datagram.DatagramSocket = {
      asJava.listenMulticastGroup(multicastAddress, networkInterface, source.orNull, {p:AsyncResult[Void] => handler(p)})
    }


    /**
     * Like [[unlistenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlistenMulticastGroup(multicastAddress: java.lang.String,networkInterface: java.lang.String,source: scala.Option[java.lang.String],handler: AsyncResult[Void] => Unit): io.vertx.core.datagram.DatagramSocket = {
      asJava.unlistenMulticastGroup(multicastAddress, networkInterface, source.orNull, {p:AsyncResult[Void] => handler(p)})
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
     * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.datagram.DatagramPacket]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture(packet: io.vertx.core.buffer.Buffer,port: java.lang.Integer,host: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.send(packet, port, host, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture(str: java.lang.String,port: java.lang.Integer,host: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.send(str, port, host, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture(str: java.lang.String,enc: java.lang.String,port: java.lang.Integer,host: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.send(str, enc, port, host, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
    def listenMulticastGroupFuture(multicastAddress: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.listenMulticastGroup(multicastAddress, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenMulticastGroupFuture(multicastAddress: java.lang.String,networkInterface: java.lang.String,source: scala.Option[java.lang.String]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.listenMulticastGroup(multicastAddress, networkInterface, source, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unlistenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlistenMulticastGroupFuture(multicastAddress: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.unlistenMulticastGroup(multicastAddress, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unlistenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlistenMulticastGroupFuture(multicastAddress: java.lang.String,networkInterface: java.lang.String,source: scala.Option[java.lang.String]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.unlistenMulticastGroup(multicastAddress, networkInterface, source, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[blockMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def blockMulticastGroupFuture(multicastAddress: java.lang.String,sourceToBlock: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.blockMulticastGroup(multicastAddress, sourceToBlock, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[blockMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def blockMulticastGroupFuture(multicastAddress: java.lang.String,networkInterface: java.lang.String,sourceToBlock: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.blockMulticastGroup(multicastAddress, networkInterface, sourceToBlock, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
    def send(address: java.lang.String,message: AnyRef,options: io.vertx.core.eventbus.DeliveryOptions): io.vertx.core.eventbus.EventBus = {
      asJava.send(address, message, options)
    }


    /**
     * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def request[T](address: java.lang.String,message: AnyRef,replyHandler: AsyncResult[io.vertx.core.eventbus.Message[T]] => Unit): io.vertx.core.eventbus.EventBus = {
      asJava.request[T](address, message, {p:AsyncResult[io.vertx.core.eventbus.Message[T]] => replyHandler(p)})
    }


    /**
     * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def request[T](address: java.lang.String,message: AnyRef,options: io.vertx.core.eventbus.DeliveryOptions,replyHandler: AsyncResult[io.vertx.core.eventbus.Message[T]] => Unit): io.vertx.core.eventbus.EventBus = {
      asJava.request[T](address, message, options, {p:AsyncResult[io.vertx.core.eventbus.Message[T]] => replyHandler(p)})
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
     * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def requestFuture[T](address: java.lang.String,message: AnyRef): scala.concurrent.Future[io.vertx.core.eventbus.Message[T]] = {
      val promise = Promise[io.vertx.core.eventbus.Message[T]]()
      asJava.request[T](address, message, {a:AsyncResult[io.vertx.core.eventbus.Message[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def requestFuture[T](address: java.lang.String,message: AnyRef,options: io.vertx.core.eventbus.DeliveryOptions): scala.concurrent.Future[io.vertx.core.eventbus.Message[T]] = {
      val promise = Promise[io.vertx.core.eventbus.Message[T]]()
      asJava.request[T](address, message, options, {a:AsyncResult[io.vertx.core.eventbus.Message[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def requestFuture(method: io.vertx.core.http.HttpMethod,options: io.vertx.core.http.RequestOptions): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.request(method, options, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def requestFuture(method: io.vertx.core.http.HttpMethod,serverAddress: io.vertx.core.net.SocketAddress,options: io.vertx.core.http.RequestOptions): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.request(method, serverAddress, options, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def requestFuture(method: io.vertx.core.http.HttpMethod,port: java.lang.Integer,host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.request(method, port, host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def requestFuture(method: io.vertx.core.http.HttpMethod,serverAddress: io.vertx.core.net.SocketAddress,port: java.lang.Integer,host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.request(method, serverAddress, port, host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def requestFuture(method: io.vertx.core.http.HttpMethod,host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.request(method, host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def requestFuture(method: io.vertx.core.http.HttpMethod,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.request(method, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[requestAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def requestAbsFuture(method: io.vertx.core.http.HttpMethod,absoluteURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.requestAbs(method, absoluteURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[requestAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def requestAbsFuture(method: io.vertx.core.http.HttpMethod,serverAddress: io.vertx.core.net.SocketAddress,absoluteURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.requestAbs(method, serverAddress, absoluteURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getFuture(options: io.vertx.core.http.RequestOptions): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.get(options, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getFuture(port: java.lang.Integer,host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.get(port, host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getFuture(host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.get(host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getFuture(requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.get(requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getAbsFuture(absoluteURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.getAbs(absoluteURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getNowFuture(options: io.vertx.core.http.RequestOptions): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.getNow(options, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getNowFuture(port: java.lang.Integer,host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.getNow(port, host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getNowFuture(host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.getNow(host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getNowFuture(requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.getNow(requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[post]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def postFuture(options: io.vertx.core.http.RequestOptions): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(options, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[post]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def postFuture(port: java.lang.Integer,host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(port, host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[post]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def postFuture(host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[post]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def postFuture(requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.post(requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[postAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def postAbsFuture(absoluteURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.postAbs(absoluteURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[head]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def headFuture(options: io.vertx.core.http.RequestOptions): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.head(options, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[head]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def headFuture(port: java.lang.Integer,host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.head(port, host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[head]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def headFuture(host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.head(host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[head]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def headFuture(requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.head(requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[headAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def headAbsFuture(absoluteURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.headAbs(absoluteURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[headNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def headNowFuture(options: io.vertx.core.http.RequestOptions): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.headNow(options, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[headNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def headNowFuture(port: java.lang.Integer,host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.headNow(port, host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[headNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def headNowFuture(host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.headNow(host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[headNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def headNowFuture(requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.headNow(requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[options]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def optionsFuture(options: io.vertx.core.http.RequestOptions): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.options(options, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[options]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def optionsFuture(port: java.lang.Integer,host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.options(port, host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[options]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def optionsFuture(host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.options(host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[options]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def optionsFuture(requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.options(requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[optionsAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def optionsAbsFuture(absoluteURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.optionsAbs(absoluteURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[optionsNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def optionsNowFuture(options: io.vertx.core.http.RequestOptions): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.optionsNow(options, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[optionsNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def optionsNowFuture(port: java.lang.Integer,host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.optionsNow(port, host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[optionsNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def optionsNowFuture(host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.optionsNow(host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[optionsNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def optionsNowFuture(requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.optionsNow(requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putFuture(options: io.vertx.core.http.RequestOptions): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(options, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putFuture(port: java.lang.Integer,host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(port, host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putFuture(host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putFuture(requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.put(requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[putAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putAbsFuture(absoluteURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.putAbs(absoluteURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[delete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deleteFuture(options: io.vertx.core.http.RequestOptions): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.delete(options, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[delete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deleteFuture(port: java.lang.Integer,host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.delete(port, host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[delete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deleteFuture(host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.delete(host, requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[delete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deleteFuture(requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.delete(requestURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[deleteAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deleteAbsFuture(absoluteURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.deleteAbs(absoluteURI, {a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[webSocket]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def webSocketFuture(port: java.lang.Integer,host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.WebSocket] = {
      val promise = Promise[io.vertx.core.http.WebSocket]()
      asJava.webSocket(port, host, requestURI, {a:AsyncResult[io.vertx.core.http.WebSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[webSocket]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def webSocketFuture(host: java.lang.String,requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.WebSocket] = {
      val promise = Promise[io.vertx.core.http.WebSocket]()
      asJava.webSocket(host, requestURI, {a:AsyncResult[io.vertx.core.http.WebSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[webSocket]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def webSocketFuture(requestURI: java.lang.String): scala.concurrent.Future[io.vertx.core.http.WebSocket] = {
      val promise = Promise[io.vertx.core.http.WebSocket]()
      asJava.webSocket(requestURI, {a:AsyncResult[io.vertx.core.http.WebSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[webSocket]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def webSocketFuture(options: io.vertx.core.http.WebSocketConnectOptions): scala.concurrent.Future[io.vertx.core.http.WebSocket] = {
      val promise = Promise[io.vertx.core.http.WebSocket]()
      asJava.webSocket(options, {a:AsyncResult[io.vertx.core.http.WebSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[webSocketAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def webSocketAbsFuture(url: java.lang.String,headers: io.vertx.core.MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.http.WebSocket] = {
      val promise = Promise[io.vertx.core.http.WebSocket]()
      asJava.webSocketAbs(url, headers, version, subProtocols, {a:AsyncResult[io.vertx.core.http.WebSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.http.HttpClientRequest = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def drainHandler(handler: scala.Option[Void => Unit]): io.vertx.core.http.HttpClientRequest = {
      asJava.drainHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    /**
     * Like [[continueHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def continueHandler(handler: scala.Option[Void => Unit]): io.vertx.core.http.HttpClientRequest = {
      asJava.continueHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    /**
     * Like [[connectionHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectionHandler(handler: scala.Option[io.vertx.core.http.HttpConnection => Unit]): io.vertx.core.http.HttpClientRequest = {
      asJava.connectionHandler(handler match {case Some(t) => p:io.vertx.core.http.HttpConnection => t(p); case None => null})
    }

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(chunk: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(chunk, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(chunk: java.lang.String,enc: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(chunk, enc, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(chunk: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end(chunk, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(chunk: java.lang.String,enc: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end(chunk, enc, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(chunk: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end(chunk, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def setFuture(): scala.concurrent.Future[io.vertx.core.http.HttpClientResponse] = {
      val promise = Promise[io.vertx.core.http.HttpClientResponse]()
      asJava.setHandler({a:AsyncResult[io.vertx.core.http.HttpClientResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.http.HttpClientResponse = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.http.HttpClientResponse = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.core.http.HttpClientResponse = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }


    /**
     * Like [[getHeader]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getHeaderOption(headerName: java.lang.String): scala.Option[java.lang.String] = {
      scala.Option(asJava.getHeader(headerName))
    }


    /**
     * Like [[getTrailer]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getTrailerOption(trailerName: java.lang.String): scala.Option[java.lang.String] = {
      scala.Option(asJava.getTrailer(trailerName))
    }

    /**
     * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[body]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bodyFuture(): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = Promise[io.vertx.core.buffer.Buffer]()
      asJava.body({a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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


  /**
    * Represents an file upload from an HTML FORM.
    */

  implicit class HttpServerFileUploadScala(val asJava: io.vertx.core.http.HttpServerFileUpload) extends AnyVal {


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.http.HttpServerFileUpload = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.http.HttpServerFileUpload = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.core.http.HttpServerFileUpload = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }

    /**
     * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.http.HttpServerRequest = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.http.HttpServerRequest = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.core.http.HttpServerRequest = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }


    /**
     * Like [[scheme]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def schemeOption(): scala.Option[java.lang.String] = {
      scala.Option(asJava.scheme())
    }


    /**
     * Like [[path]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pathOption(): scala.Option[java.lang.String] = {
      scala.Option(asJava.path())
    }


    /**
     * Like [[query]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def queryOption(): scala.Option[java.lang.String] = {
      scala.Option(asJava.query())
    }


    /**
     * Like [[host]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hostOption(): scala.Option[java.lang.String] = {
      scala.Option(asJava.host())
    }


    /**
     * Like [[getHeader]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getHeaderOption(headerName: java.lang.String): scala.Option[java.lang.String] = {
      scala.Option(asJava.getHeader(headerName))
    }


    /**
     * Like [[getParam]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getParamOption(paramName: java.lang.String): scala.Option[java.lang.String] = {
      scala.Option(asJava.getParam(paramName))
    }


    /**
     * Like [[bodyHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bodyHandler(bodyHandler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.http.HttpServerRequest = {
      asJava.bodyHandler(bodyHandler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    /**
     * Like [[uploadHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def uploadHandler(uploadHandler: scala.Option[io.vertx.core.http.HttpServerFileUpload => Unit]): io.vertx.core.http.HttpServerRequest = {
      asJava.uploadHandler(uploadHandler match {case Some(t) => p:io.vertx.core.http.HttpServerFileUpload => t(p); case None => null})
    }


    /**
     * Like [[getFormAttribute]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getFormAttributeOption(attributeName: java.lang.String): scala.Option[java.lang.String] = {
      scala.Option(asJava.getFormAttribute(attributeName))
    }

    /**
     * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[body]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bodyFuture(): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = Promise[io.vertx.core.buffer.Buffer]()
      asJava.body({a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(chunk: java.lang.String,enc: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(chunk, enc, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(chunk: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(chunk, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(chunk: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end(chunk, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(chunk: java.lang.String,enc: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end(chunk, enc, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(chunk: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end(chunk, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.core.parsetools.JsonParser = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }


    def handler(handler: scala.Option[io.vertx.core.parsetools.JsonEvent => Unit]): io.vertx.core.parsetools.JsonParser = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.core.parsetools.JsonEvent => t(p); case None => null})
    }


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.parsetools.JsonParser = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }

    /**
     * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.parsetools.JsonEvent]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
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
    def reply(message: AnyRef,options: io.vertx.core.eventbus.DeliveryOptions): Unit = {
      asJava.reply(message, options)
    }


    /**
     * Like [[replyAndRequest]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replyAndRequest[R](message: AnyRef,replyHandler: AsyncResult[io.vertx.core.eventbus.Message[R]] => Unit): Unit = {
      asJava.replyAndRequest[R](message, {p:AsyncResult[io.vertx.core.eventbus.Message[R]] => replyHandler(p)})
    }


    /**
     * Like [[replyAndRequest]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replyAndRequest[R](message: AnyRef,options: io.vertx.core.eventbus.DeliveryOptions,replyHandler: AsyncResult[io.vertx.core.eventbus.Message[R]] => Unit): Unit = {
      asJava.replyAndRequest[R](message, options, {p:AsyncResult[io.vertx.core.eventbus.Message[R]] => replyHandler(p)})
    }

    /**
     * Like [[replyAndRequest]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replyAndRequestFuture[R](message: AnyRef): scala.concurrent.Future[io.vertx.core.eventbus.Message[R]] = {
      val promise = Promise[io.vertx.core.eventbus.Message[R]]()
      asJava.replyAndRequest[R](message, {a:AsyncResult[io.vertx.core.eventbus.Message[R]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[replyAndRequest]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replyAndRequestFuture[R](message: AnyRef,options: io.vertx.core.eventbus.DeliveryOptions): scala.concurrent.Future[io.vertx.core.eventbus.Message[R]] = {
      val promise = Promise[io.vertx.core.eventbus.Message[R]]()
      asJava.replyAndRequest[R](message, options, {a:AsyncResult[io.vertx.core.eventbus.Message[R]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.eventbus.Message[T]]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
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
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def write(data: T,handler: AsyncResult[Void] => Unit): Unit = {
      asJava.write(data, {p:AsyncResult[Void] => handler(p)})
    }


    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def end(data: T,handler: AsyncResult[Void] => Unit): Unit = {
      asJava.end(data, {p:AsyncResult[Void] => handler(p)})
    }


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.eventbus.MessageProducer[T] = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def drainHandler(handler: scala.Option[Void => Unit]): io.vertx.core.eventbus.MessageProducer[T] = {
      asJava.drainHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(data: T): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(data: T): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(str: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(str, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(str: java.lang.String,enc: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(str, enc, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
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

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[upgradeToSsl]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def upgradeToSslFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.upgradeToSsl({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[upgradeToSsl]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def upgradeToSslFuture(serverName: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.upgradeToSsl(serverName, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[to]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def toFuture(dst: io.vertx.core.streams.WriteStream[T]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.to(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type ProxyOptions = io.vertx.core.net.ProxyOptions

  object ProxyOptions {
    def apply() = new ProxyOptions()
    def apply(json: JsonObject) = new ProxyOptions(json)
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
     * Like [[exceptionHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.streams.ReadStream[T] = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    /**
     * Like [[handler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def handler(handler: scala.Option[T => Unit]): io.vertx.core.streams.ReadStream[T] = {
      asJava.handler(handler match {case Some(t) => p:T => t(p); case None => null})
    }


    /**
     * Like [[endHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.core.streams.ReadStream[T] = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }

    /**
     * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[T]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.parsetools.RecordParser = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.parsetools.RecordParser = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.core.parsetools.RecordParser = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }

    /**
     * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  type RequestOptions = io.vertx.core.http.RequestOptions

  object RequestOptions {
    def apply() = new RequestOptions()
    def apply(json: JsonObject) = new RequestOptions(json)
  }




  /**
    * Represents a server side WebSocket.
    * 
    * Instances of this class are passed into a [[io.vertx.core.http.HttpServer#websocketHandler]] or provided
    * when a WebSocket handshake is manually [[io.vertx.core.http.HttpServerRequest#upgrade]]ed.
    */

  implicit class ServerWebSocketScala(val asJava: io.vertx.core.http.ServerWebSocket) extends AnyVal {


    /**
     * Like [[textMessageHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def textMessageHandler(handler: scala.Option[java.lang.String => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.textMessageHandler(handler match {case Some(t) => p:java.lang.String => t(p); case None => null})
    }


    /**
     * Like [[binaryMessageHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def binaryMessageHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.binaryMessageHandler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    /**
     * Like [[pongHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pongHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.pongHandler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def close(statusCode: java.lang.Short,reason: scala.Option[java.lang.String],handler: AsyncResult[Void] => Unit): Unit = {
      asJava.close(statusCode, reason.orNull, {p:AsyncResult[Void] => handler(p)})
    }


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.http.ServerWebSocket = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.http.ServerWebSocket = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.core.http.ServerWebSocket = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }


    def drainHandler(handler: scala.Option[Void => Unit]): io.vertx.core.http.ServerWebSocket = {
      asJava.drainHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    def closeHandler(handler: scala.Option[Void => Unit]): io.vertx.core.http.ServerWebSocket = {
      asJava.closeHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    def frameHandler(handler: scala.Option[io.vertx.core.http.WebSocketFrame => Unit]): io.vertx.core.http.ServerWebSocket = {
      asJava.frameHandler(handler match {case Some(t) => p:io.vertx.core.http.WebSocketFrame => t(p); case None => null})
    }


    /**
     * Like [[query]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def queryOption(): scala.Option[java.lang.String] = {
      scala.Option(asJava.query())
    }

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(statusCode: java.lang.Short): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close(statusCode, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(statusCode: java.lang.Short,reason: scala.Option[java.lang.String]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close(statusCode, reason, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def writeFrameFuture(frame: io.vertx.core.http.WebSocketFrame): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeFrame(frame, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def writeFinalTextFrameFuture(text: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeFinalTextFrame(text, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def writeFinalBinaryFrameFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeFinalBinaryFrame(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def writeBinaryMessageFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeBinaryMessage(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def writeTextMessageFuture(text: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeTextMessage(text, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[getLocalAsyncMap]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getLocalAsyncMapFuture[K, V](name: java.lang.String): scala.concurrent.Future[io.vertx.core.shareddata.AsyncMap[K, V]] = {
      val promise = Promise[io.vertx.core.shareddata.AsyncMap[K, V]]()
      asJava.getLocalAsyncMap[K, V](name, {a:AsyncResult[io.vertx.core.shareddata.AsyncMap[K,V]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[getLocalLock]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getLocalLockFuture(name: java.lang.String): scala.concurrent.Future[io.vertx.core.shareddata.Lock] = {
      val promise = Promise[io.vertx.core.shareddata.Lock]()
      asJava.getLocalLock(name, {a:AsyncResult[io.vertx.core.shareddata.Lock] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getLocalLockWithTimeout]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getLocalLockWithTimeoutFuture(name: java.lang.String,timeout: java.lang.Long): scala.concurrent.Future[io.vertx.core.shareddata.Lock] = {
      val promise = Promise[io.vertx.core.shareddata.Lock]()
      asJava.getLocalLockWithTimeout(name, timeout, {a:AsyncResult[io.vertx.core.shareddata.Lock] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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

    /**
     * Like [[getLocalCounter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getLocalCounterFuture(name: java.lang.String): scala.concurrent.Future[io.vertx.core.shareddata.Counter] = {
      val promise = Promise[io.vertx.core.shareddata.Counter]()
      asJava.getLocalCounter(name, {a:AsyncResult[io.vertx.core.shareddata.Counter] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
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


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.TimeoutStream = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def handler(handler: scala.Option[java.lang.Long => Unit]): io.vertx.core.TimeoutStream = {
      asJava.handler(handler match {case Some(t) => p:java.lang.Long => t(p); case None => null})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.core.TimeoutStream = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }

    /**
     * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[java.lang.Long]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
      val h: Handler[io.vertx.core.Promise[T]] = {f => util.Try(blockingFunction()) match {
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
    * Represents a client-side WebSocket.
    */

  implicit class WebSocketScala(val asJava: io.vertx.core.http.WebSocket) extends AnyVal {


    /**
     * Like [[textMessageHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def textMessageHandler(handler: scala.Option[java.lang.String => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.textMessageHandler(handler match {case Some(t) => p:java.lang.String => t(p); case None => null})
    }


    /**
     * Like [[binaryMessageHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def binaryMessageHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.binaryMessageHandler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    /**
     * Like [[pongHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pongHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.pongHandler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def close(statusCode: java.lang.Short,reason: scala.Option[java.lang.String],handler: AsyncResult[Void] => Unit): Unit = {
      asJava.close(statusCode, reason.orNull, {p:AsyncResult[Void] => handler(p)})
    }


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.http.WebSocket = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.http.WebSocket = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.core.http.WebSocket = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }


    def drainHandler(handler: scala.Option[Void => Unit]): io.vertx.core.http.WebSocket = {
      asJava.drainHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    def closeHandler(handler: scala.Option[Void => Unit]): io.vertx.core.http.WebSocket = {
      asJava.closeHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    def frameHandler(handler: scala.Option[io.vertx.core.http.WebSocketFrame => Unit]): io.vertx.core.http.WebSocket = {
      asJava.frameHandler(handler match {case Some(t) => p:io.vertx.core.http.WebSocketFrame => t(p); case None => null})
    }

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(statusCode: java.lang.Short): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close(statusCode, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(statusCode: java.lang.Short,reason: scala.Option[java.lang.String]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close(statusCode, reason, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def writeFrameFuture(frame: io.vertx.core.http.WebSocketFrame): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeFrame(frame, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def writeFinalTextFrameFuture(text: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeFinalTextFrame(text, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def writeFinalBinaryFrameFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeFinalBinaryFrame(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def writeBinaryMessageFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeBinaryMessage(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def writeTextMessageFuture(text: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeTextMessage(text, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }


    def drainHandler(handler: scala.Option[Void => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.drainHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    /**
     * Like [[closeHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeHandler(handler: scala.Option[Void => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.closeHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    /**
     * Like [[frameHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def frameHandler(handler: scala.Option[io.vertx.core.http.WebSocketFrame => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.frameHandler(handler match {case Some(t) => p:io.vertx.core.http.WebSocketFrame => t(p); case None => null})
    }


    /**
     * Like [[textMessageHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def textMessageHandler(handler: scala.Option[java.lang.String => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.textMessageHandler(handler match {case Some(t) => p:java.lang.String => t(p); case None => null})
    }


    /**
     * Like [[binaryMessageHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def binaryMessageHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.binaryMessageHandler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    /**
     * Like [[pongHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pongHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.core.http.WebSocketBase = {
      asJava.pongHandler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def close(statusCode: java.lang.Short,reason: scala.Option[java.lang.String],handler: AsyncResult[Void] => Unit): Unit = {
      asJava.close(statusCode, reason.orNull, {p:AsyncResult[Void] => handler(p)})
    }

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[writeFrame]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFrameFuture(frame: io.vertx.core.http.WebSocketFrame): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeFrame(frame, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[writeFinalTextFrame]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFinalTextFrameFuture(text: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeFinalTextFrame(text, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[writeFinalBinaryFrame]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFinalBinaryFrameFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeFinalBinaryFrame(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[writeBinaryMessage]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeBinaryMessageFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeBinaryMessage(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[writeTextMessage]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeTextMessageFuture(text: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.writeTextMessage(text, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(statusCode: java.lang.Short): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close(statusCode, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(statusCode: java.lang.Short,reason: scala.Option[java.lang.String]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close(statusCode, reason, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  type WebSocketConnectOptions = io.vertx.core.http.WebSocketConnectOptions

  object WebSocketConnectOptions {
    def apply() = new WebSocketConnectOptions()
    def apply(json: JsonObject) = new WebSocketConnectOptions(json)
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
     * Like [[exceptionHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.core.streams.WriteStream[T] = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def write(data: T,handler: AsyncResult[Void] => Unit): Unit = {
      asJava.write(data, {p:AsyncResult[Void] => handler(p)})
    }


    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def end(data: T,handler: AsyncResult[Void] => Unit): Unit = {
      asJava.end(data, {p:AsyncResult[Void] => handler(p)})
    }


    /**
     * Like [[drainHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def drainHandler(handler: scala.Option[Void => Unit]): io.vertx.core.streams.WriteStream[T] = {
      asJava.drainHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(data: T): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.write(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endFuture(data: T): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.end(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

}
