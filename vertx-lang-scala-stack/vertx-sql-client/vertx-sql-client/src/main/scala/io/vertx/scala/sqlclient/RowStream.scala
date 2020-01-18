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

package io.vertx.scala.sqlclient

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.core.streams.Pipe
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.sqlclient.{RowStream => JRowStream}
import io.vertx.lang.scala.HandlerOps._

/**
  * A row oriented stream.

  */

class RowStream[T: TypeTag](private val _asJava: Object) extends ReadStream[T] {
  def asJava = _asJava




  override 
  def fetch(arg0: Long): ReadStream[T] = {
    asJava.asInstanceOf[JRowStream[Object]].fetch(arg0.asInstanceOf[java.lang.Long])
    this
  }


  override 
  def exceptionHandler(handler: Handler[Throwable]): RowStream[T] = {
    asJava.asInstanceOf[JRowStream[Object]].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }


  override 
  def handler(handler: Handler[T]): RowStream[T] = {
    asJava.asInstanceOf[JRowStream[Object]].handler((if (handler == null) null else new io.vertx.core.Handler[Object]{def handle(x: Object) {handler.handle(toScala[T](x))}}))
    this
  }


  override 
  def pause(): RowStream[T] = {
    asJava.asInstanceOf[JRowStream[Object]].pause()
    this
  }


  override 
  def resume(): RowStream[T] = {
    asJava.asInstanceOf[JRowStream[Object]].resume()
    this
  }


  override 
  def endHandler(endHandler: Handler[Unit]): RowStream[T] = {
    asJava.asInstanceOf[JRowStream[Object]].endHandler((if (endHandler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {endHandler.handle(x)}}))
    this
  }



  override def pipe(): Pipe[T] = {
    Pipe[T](asJava.asInstanceOf[JRowStream[Object]].pipe())
  }


  override def pipeTo(dst: WriteStream[T]): Unit = {
    asJava.asInstanceOf[JRowStream[Object]].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Object]])
  }


  override def pipeTo(dst: WriteStream[T], handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRowStream[Object]].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Object]], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


  /**
   * Close the stream and release the resources.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JRowStream[Object]].close()
  }

  /**
   * Close the stream and release the resources.   * @param completionHandler the completion handler for this operation
   */
  def close (completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRowStream[Object]].close((if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }



  override def pipeToFuture (dst: WriteStream[T]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRowStream[Object]].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Object]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRowStream[Object]].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object RowStream {
  def apply[T: TypeTag](asJava: JRowStream[_]) = new RowStream[T](asJava)

}
