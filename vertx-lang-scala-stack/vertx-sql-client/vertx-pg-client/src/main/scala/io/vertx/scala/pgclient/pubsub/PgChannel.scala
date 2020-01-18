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

package io.vertx.scala.pgclient.pubsub

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.core.streams.Pipe
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.pgclient.pubsub.{PgChannel => JPgChannel}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.lang.scala.HandlerOps._

/**
  * A channel to Postgres that tracks the subscription to a given Postgres channel using the `LISTEN/UNLISTEN` commands.
  * <p/>
  * When paused the channel discards the messages.

  */

class PgChannel(private val _asJava: Object) extends ReadStream[String] {
  def asJava = _asJava




  override 
  def fetch(arg0: Long): ReadStream[String] = {
    asJava.asInstanceOf[JPgChannel].fetch(arg0.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Set an handler called when the the channel get subscribed.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def subscribeHandler(handler: Handler[Unit]): PgChannel = {
    asJava.asInstanceOf[JPgChannel].subscribeHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }

  /**
   * Set or unset an handler to be called when a the channel is notified by Postgres.
   * <p/>
   * <ul>
   *   <li>when the handler is set, the subscriber sends a `LISTEN` command if needed</li>
   *   <li>when the handler is unset, the subscriber sends a `UNLISTEN` command if needed</li>
   * </ul>   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  override 
  def handler(handler: Handler[String]): PgChannel = {
    asJava.asInstanceOf[JPgChannel].handler((if (handler == null) null else new io.vertx.core.Handler[java.lang.String]{def handle(x: java.lang.String) {handler.handle(x.asInstanceOf[String])}}))
    this
  }

  /**
   * Pause the channel, all notifications are discarded.   * @return a reference to this, so the API can be used fluently
   */
  override 
  def pause(): PgChannel = {
    asJava.asInstanceOf[JPgChannel].pause()
    this
  }

  /**
   * Resume the channel.   * @return a reference to this, so the API can be used fluently
   */
  override 
  def resume(): PgChannel = {
    asJava.asInstanceOf[JPgChannel].resume()
    this
  }

  /**
   * Set an handler to be called when no more notifications will be received.   * @param endHandler the handler
   * @return a reference to this, so the API can be used fluently
   */
  override 
  def endHandler(endHandler: Handler[Unit]): PgChannel = {
    asJava.asInstanceOf[JPgChannel].endHandler((if (endHandler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {endHandler.handle(x)}}))
    this
  }


  override 
  def exceptionHandler(handler: Handler[Throwable]): PgChannel = {
    asJava.asInstanceOf[JPgChannel].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }



  override def pipe(): Pipe[String] = {
    Pipe[String](asJava.asInstanceOf[JPgChannel].pipe())
  }


  override def pipeTo(dst: WriteStream[String]): Unit = {
    asJava.asInstanceOf[JPgChannel].pipeTo(dst.asJava.asInstanceOf[JWriteStream[java.lang.String]])
  }


  override def pipeTo(dst: WriteStream[String], handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JPgChannel].pipeTo(dst.asJava.asInstanceOf[JWriteStream[java.lang.String]], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }




  override def pipeToFuture (dst: WriteStream[String]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JPgChannel].pipeTo(dst.asJava.asInstanceOf[JWriteStream[java.lang.String]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object PgChannel {
  def apply(asJava: JPgChannel) = new PgChannel(asJava)

}
