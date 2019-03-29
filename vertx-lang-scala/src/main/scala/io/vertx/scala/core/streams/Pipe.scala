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

package io.vertx.scala.core.streams

import io.vertx.lang.scala.AsyncResultWrapper
import scala.reflect.runtime.universe._
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Pipe data from a [[io.vertx.scala.core.streams.ReadStream]] to a [[io.vertx.scala.core.streams.WriteStream]] and performs flow control where necessary to
  * prevent the write stream buffer from getting overfull.
  * 
  * Instances of this class read items from a [[io.vertx.scala.core.streams.ReadStream]] and write them to a [[io.vertx.scala.core.streams.WriteStream]]. If data
  * can be read faster than it can be written this could result in the write queue of the [[io.vertx.scala.core.streams.WriteStream]] growing
  * without bound, eventually causing it to exhaust all available RAM.
  * 
  * To prevent this, after each write, instances of this class check whether the write queue of the [[io.vertx.scala.core.streams.WriteStream]] is full, and if so, the [[io.vertx.scala.core.streams.ReadStream]] is paused, and a `drainHandler` is set on the
  * [[io.vertx.scala.core.streams.WriteStream]].
  * 
  * When the [[io.vertx.scala.core.streams.WriteStream]] has processed half of its backlog, the `drainHandler` will be
  * called, which results in the pump resuming the [[io.vertx.scala.core.streams.ReadStream]].
  * 
  * This class can be used to pipe from any [[io.vertx.scala.core.streams.ReadStream]] to any [[io.vertx.scala.core.streams.WriteStream]],
  * e.g. from an [[io.vertx.scala.core.http.HttpServerRequest]] to an [[io.vertx.scala.core.file.AsyncFile]],
  * or from [[io.vertx.scala.core.net.NetSocket]] to a [[io.vertx.scala.core.http.WebSocket]].
  * 
  * Please see the documentation for more information.

  */

class Pipe[T: TypeTag](private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Set to `true` to call [[io.vertx.scala.core.streams.WriteStream#end]] when the source `ReadStream` fails, `false` otherwise.   * @param end `true` to end the stream on a source `ReadStream` failure
   * @return a reference to this, so the API can be used fluently
   */
  
  def endOnFailure(end: Boolean): Pipe[T] = {
    asJava.asInstanceOf[JPipe[Object]].endOnFailure(end.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Set to `true` to call [[io.vertx.scala.core.streams.WriteStream#end]] when the source `ReadStream` succeeds, `false` otherwise.   * @param end `true` to end the stream on a source `ReadStream` success
   * @return a reference to this, so the API can be used fluently
   */
  
  def endOnSuccess(end: Boolean): Pipe[T] = {
    asJava.asInstanceOf[JPipe[Object]].endOnSuccess(end.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Set to `true` to call [[io.vertx.scala.core.streams.WriteStream#end]] when the source `ReadStream` completes, `false` otherwise.
   * 
   * Calling this overwrites [[io.vertx.scala.core.streams.Pipe#endOnFailure]] and [[io.vertx.scala.core.streams.Pipe#endOnSuccess]].   * @param end `true` to end the stream on a source `ReadStream` completion
   * @return a reference to this, so the API can be used fluently
   */
  
  def endOnComplete(end: Boolean): Pipe[T] = {
    asJava.asInstanceOf[JPipe[Object]].endOnComplete(end.asInstanceOf[java.lang.Boolean])
    this
  }



  /**
   * Like [[io.vertx.scala.core.streams.Pipe#to]] but without a completion handler
   */
  def to (dst: WriteStream[T]): Unit = {
    asJava.asInstanceOf[JPipe[Object]].to(dst.asJava.asInstanceOf[JWriteStream[Object]])
  }

  /**
   * Start to pipe the elements to the destination `WriteStream`.
   * 
   * When the operation fails with a write error, the source stream is resumed.   * @param dst the destination write stream
   * @param completionHandler the handler called when the pipe operation completes
   */
  def to (dst: WriteStream[T], completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JPipe[Object]].to(dst.asJava.asInstanceOf[JWriteStream[Object]], {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * Close the pipe.
   * 
   * The streams handlers will be unset and the read stream resumed unless it is already ended.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JPipe[Object]].close()
  }


 /**
  * Like [[to]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def toFuture (dst: WriteStream[T]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JPipe[Object]].to(dst.asJava.asInstanceOf[JWriteStream[Object]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object Pipe {
  def apply[T: TypeTag](asJava: JPipe[_]) = new Pipe[T](asJava)
  
}
