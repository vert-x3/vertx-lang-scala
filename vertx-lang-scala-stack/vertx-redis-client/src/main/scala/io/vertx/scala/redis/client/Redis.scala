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
import io.vertx.redis.client.{RedisOptions => JRedisOptions}
import io.vertx.scala.core.streams.Pipe
import io.vertx.redis.client.{Redis => JRedis}
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import scala.collection.JavaConverters._
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.redis.client.{Request => JRequest}
import io.vertx.lang.scala.Converter._
import io.vertx.redis.client.{Response => JResponse}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.scala.core.net.SocketAddress
import io.vertx.lang.scala.HandlerOps._

/**
  * A simple Redis client.

  */

class Redis(private val _asJava: Object) extends ReadStream[Response] {
  def asJava = _asJava



  /**
   * Connects to the redis server.   * @param handler the async result handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def connect(handler: Handler[AsyncResult[Redis]]): Redis = {
    asJava.asInstanceOf[JRedis].connect({x: AsyncResult[JRedis] => handler.handle(AsyncResultWrapper[JRedis, Redis](x, a => Redis(a)))})
    this
  }

  /**
   * Set an exception handler on the read stream.   * @param handler the exception handler
   * @return a reference to this, so the API can be used fluently
   */
  override 
  def exceptionHandler(handler: Handler[Throwable]): Redis = {
    asJava.asInstanceOf[JRedis].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  /**
   * Set a data handler. As data is read, the handler will be called with the data.   * @return a reference to this, so the API can be used fluently
   */
  override 
  def handler(handler: Handler[Response]): Redis = {
    asJava.asInstanceOf[JRedis].handler({x: JResponse => handler.handle(Response(x))})
    this
  }

  /**
   * Pause the `ReadStream`, it sets the buffer in `fetch` mode and clears the actual demand.
   * 
   * While it's paused, no data will be sent to the data `handler`.   * @return a reference to this, so the API can be used fluently
   */
  override 
  def pause(): Redis = {
    asJava.asInstanceOf[JRedis].pause()
    this
  }

  /**
   * Resume reading, and sets the buffer in `flowing` mode.
   * <p/>
   * If the `ReadStream` has been paused, reading will recommence on it.   * @return a reference to this, so the API can be used fluently
   */
  override 
  def resume(): Redis = {
    asJava.asInstanceOf[JRedis].resume()
    this
  }

  /**
   * Fetch the specified `amount` of elements. If the `ReadStream` has been paused, reading will
   * recommence with the specified `amount` of items, otherwise the specified `amount` will
   * be added to the current stream demand.   * @return a reference to this, so the API can be used fluently
   */
  override 
  def fetch(amount: Long): Redis = {
    asJava.asInstanceOf[JRedis].fetch(amount.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Set an end handler. Once the stream has ended, and there is no more data to be read, this handler will be called.   * @return a reference to this, so the API can be used fluently
   */
  override 
  def endHandler(endHandler: Handler[Unit]): Redis = {
    asJava.asInstanceOf[JRedis].endHandler({x: Void => endHandler.handle(x)})
    this
  }


  
  def send(command: Request, onSend: Handler[AsyncResult[scala.Option[Response]]]): Redis = {
    asJava.asInstanceOf[JRedis].send(command.asJava.asInstanceOf[JRequest], {x: AsyncResult[JResponse] => onSend.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def batch(commands: scala.collection.mutable.Buffer[Request], handler: Handler[AsyncResult[scala.collection.mutable.Buffer[scala.Option[Response]]]]): Redis = {
    asJava.asInstanceOf[JRedis].batch(commands.map(x => x.asJava.asInstanceOf[JRequest]).asJava, {x: AsyncResult[java.util.List[JResponse]] => handler.handle(AsyncResultWrapper[java.util.List[JResponse], scala.collection.mutable.Buffer[scala.Option[Response]]](x, a => a.asScala.map(x => scala.Option(x).map(Response(_)))))})
    this
  }



  override def pipe(): Pipe[Response] = {
    Pipe[Response](asJava.asInstanceOf[JRedis].pipe())
  }


  override def pipeTo(dst: WriteStream[Response]): Unit = {
    asJava.asInstanceOf[JRedis].pipeTo(dst.asJava.asInstanceOf[JWriteStream[JResponse]])
  }


  override def pipeTo(dst: WriteStream[Response], handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRedis].pipeTo(dst.asJava.asInstanceOf[JWriteStream[JResponse]], {x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }


  /**
   * Returns the address associated with this client.   * @return the address.
   */
  def socketAddress (): SocketAddress = {
    SocketAddress(asJava.asInstanceOf[JRedis].socketAddress())
  }


  def close (): Unit = {
    asJava.asInstanceOf[JRedis].close()
  }



  override def pipeToFuture (dst: WriteStream[Response]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedis].pipeTo(dst.asJava.asInstanceOf[JWriteStream[JResponse]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def connectFuture (): scala.concurrent.Future[Redis] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRedis, Redis](x => Redis(x))
    asJava.asInstanceOf[JRedis].connect(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def sendFuture (command: Request): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedis].send(command.asJava.asInstanceOf[JRequest], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def batchFuture (commands: scala.collection.mutable.Buffer[Request]): scala.concurrent.Future[scala.collection.mutable.Buffer[scala.Option[Response]]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JResponse], scala.collection.mutable.Buffer[scala.Option[Response]]](x => x.asScala.map(x => scala.Option(x).map(Response(_))))
    asJava.asInstanceOf[JRedis].batch(commands.map(x => x.asJava.asInstanceOf[JRequest]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object Redis {
  def apply(asJava: JRedis) = new Redis(asJava)
  
  /**
   * Connect to redis, the `onConnect` will get the [[io.vertx.scala.redis.client.Redis]] instance.
   *
   * This connection will use the default options which are connect
   * to a standalone server on the default port on "localhost".
   */
  def createClient(vertx: Vertx,address: SocketAddress): Redis = {
    Redis(JRedis.createClient(vertx.asJava.asInstanceOf[JVertx], address.asJava.asInstanceOf[JSocketAddress]))
  }

  /**
   * Connect to redis, the `onConnect` will get the [[io.vertx.scala.redis.client.Redis]] instance.
   */
  def createClient(vertx: Vertx,options: RedisOptions): Redis = {
    Redis(JRedis.createClient(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

}
