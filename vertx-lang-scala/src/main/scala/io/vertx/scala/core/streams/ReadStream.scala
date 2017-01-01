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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.core.streams.{StreamBase => JStreamBase}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.Handler

/**
  * Represents a stream of items that can be read from.
  * 
  * Any class that implements this interface can be used by a [[io.vertx.scala.core.streams.Pump]] to pump data from it
  * to a [[io.vertx.scala.core.streams.WriteStream]].
  */
trait ReadStream[T] 
    extends StreamBase {

  def asJava: java.lang.Object

  override def exceptionHandler(handler: Handler[Throwable]):ReadStream[T]

  def handler(handler: Handler[T]):ReadStream[T]

  def pause():ReadStream[T]

  def resume():ReadStream[T]

  def endHandler(endHandler: Handler[Unit]):ReadStream[T]

}

object ReadStream{
  def apply[T:TypeTag](asJava: Object, objectToT: Option[Object => T] = None):ReadStream[T] = new ReadStreamImpl[T](asJava, objectToT)
    private class ReadStreamImpl[T:TypeTag](private val _asJava: Object, objectToT: Option[Object => T] = None) extends ReadStream[T] {

      def asJava = _asJava

//cached methods
//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):ReadStream[T] = {
    asJava.asInstanceOf[JReadStream[T]].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  def handler(handler: Handler[T]):ReadStream[T] = {
    asJava.asInstanceOf[JReadStream[T]].handler({x: T => handler.handle(x)})
    this
  }

  def pause():ReadStream[T] = {
    asJava.asInstanceOf[JReadStream[T]].pause()
    this
  }

  def resume():ReadStream[T] = {
    asJava.asInstanceOf[JReadStream[T]].resume()
    this
  }

  def endHandler(endHandler: Handler[Unit]):ReadStream[T] = {
    asJava.asInstanceOf[JReadStream[T]].endHandler({x: Void => endHandler.handle(x)})
    this
  }

//default methods
//basic methods
//future methods
}
}
