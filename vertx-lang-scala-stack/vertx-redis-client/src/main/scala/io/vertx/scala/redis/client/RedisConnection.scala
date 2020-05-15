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

package io.vertx.scala.redis.client

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.core.streams.Pipe
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import io.vertx.redis.client.{RedisConnection => JRedisConnection}
import scala.collection.JavaConverters._
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.redis.client.{Request => JRequest}
import io.vertx.lang.scala.Converter._
import io.vertx.redis.client.{Response => JResponse}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.lang.scala.HandlerOps._

/**
  * A simple Redis client.

  */

class RedisConnection(private val _asJava: Object) extends ReadStream[Response] {
  def asJava = _asJava



  /**
   * 
   */
  override 
  def exceptionHandler(handler: Handler[Throwable]): RedisConnection = {
    asJava.asInstanceOf[JRedisConnection].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }

  /**
   * 
   */
  override 
  def handler(handler: Handler[Response]): RedisConnection = {
    asJava.asInstanceOf[JRedisConnection].handler((if (handler == null) null else new io.vertx.core.Handler[JResponse]{def handle(x: JResponse) {handler.handle(Response(x))}}))
    this
  }

  /**
   * 
   */
  override 
  def pause(): RedisConnection = {
    asJava.asInstanceOf[JRedisConnection].pause()
    this
  }

  /**
   * 
   */
  override 
  def resume(): RedisConnection = {
    asJava.asInstanceOf[JRedisConnection].resume()
    this
  }

  /**
   * 
   */
  override 
  def fetch(amount: Long): RedisConnection = {
    asJava.asInstanceOf[JRedisConnection].fetch(amount.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * 
   */
  override 
  def endHandler(endHandler: Handler[Unit]): RedisConnection = {
    asJava.asInstanceOf[JRedisConnection].endHandler((if (endHandler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {endHandler.handle(x)}}))
    this
  }

  /**
   * Send the given command to the redis server or cluster.   * @param command the command to send
   * @param onSend the asynchronous result handler.
   * @return fluent self.
   */
  
  def send(command: Request, onSend: Handler[AsyncResult[scala.Option[Response]]]): RedisConnection = {
    asJava.asInstanceOf[JRedisConnection].send(command.asJava.asInstanceOf[JRequest], (if (onSend == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {onSend.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Sends a list of commands in a single IO operation, this prevents any inter twinning to happen from other
   * client users.   * @param commands list of command to send
   * @param onSend the asynchronous result handler.
   * @return fluent self.
   */
  
  def batch(commands: scala.collection.mutable.Buffer[Request], onSend: Handler[AsyncResult[scala.collection.mutable.Buffer[scala.Option[Response]]]]): RedisConnection = {
    asJava.asInstanceOf[JRedisConnection].batch(commands.map(x => x.asJava.asInstanceOf[JRequest]).asJava, (if (onSend == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JResponse]]]{def handle(x: AsyncResult[java.util.List[JResponse]]) {onSend.handle(AsyncResultWrapper[java.util.List[JResponse], scala.collection.mutable.Buffer[scala.Option[Response]]](x, a => a.asScala.map(x => scala.Option(x).map(Response(_)))))}}))
    this
  }



  override def pipe(): Pipe[Response] = {
    Pipe[Response](asJava.asInstanceOf[JRedisConnection].pipe())
  }


  override def pipeTo(dst: WriteStream[Response]): Unit = {
    asJava.asInstanceOf[JRedisConnection].pipeTo(dst.asJava.asInstanceOf[JWriteStream[JResponse]])
  }


  override def pipeTo(dst: WriteStream[Response], handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRedisConnection].pipeTo(dst.asJava.asInstanceOf[JWriteStream[JResponse]], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


  /**
   * Closes the connection or returns to the pool.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JRedisConnection].close()
  }

  /**
   * Flag to notify if the pending message queue (commands in transit) is full.
   *
   * When the pending message queue is full and a new send command is issued it will result in a exception to be thrown.
   * Checking this flag before sending can allow the application to wait before sending the next message.   * @return true is queue is full.
   */
  def pendingQueueFull (): Boolean = {
    asJava.asInstanceOf[JRedisConnection].pendingQueueFull().asInstanceOf[Boolean]
  }



  override def pipeToFuture (dst: WriteStream[Response]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisConnection].pipeTo(dst.asJava.asInstanceOf[JWriteStream[JResponse]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendFuture (command: Request): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisConnection].send(command.asJava.asInstanceOf[JRequest], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[batch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def batchFuture (commands: scala.collection.mutable.Buffer[Request]): scala.concurrent.Future[scala.collection.mutable.Buffer[scala.Option[Response]]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JResponse], scala.collection.mutable.Buffer[scala.Option[Response]]](x => x.asScala.map(x => scala.Option(x).map(Response(_))))
    asJava.asInstanceOf[JRedisConnection].batch(commands.map(x => x.asJava.asInstanceOf[JRequest]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object RedisConnection {
  def apply(asJava: JRedisConnection) = new RedisConnection(asJava)

}
