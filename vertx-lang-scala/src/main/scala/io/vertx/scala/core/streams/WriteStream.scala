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
import io.vertx.lang.scala.Converter._
import io.vertx.core.streams.{StreamBase => JStreamBase}
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}

/**
  *
  * Represents a stream of data that can be written to.
  * 
  * Any class that implements this interface can be used by a [[io.vertx.scala.core.streams.Pump]] to pump data from a `ReadStream`
  * to it.
  */
trait WriteStream[T] 
    extends StreamBase {

  def asJava: java.lang.Object

  override def exceptionHandler(handler: Handler[Throwable]):WriteStream[T]

  def write(data: T):WriteStream[T]

  def end():Unit

  def end(t: T):Unit

  def setWriteQueueMaxSize(maxSize: Int):WriteStream[T]

  def writeQueueFull():Boolean

  def drainHandler(handler: Handler[Unit]):WriteStream[T]

}

object WriteStream{
  def apply[T:TypeTag](asJava: JWriteStream[_]):WriteStream[T] = new WriteStreamImpl[T](asJava)
    private class WriteStreamImpl[T:TypeTag](private val _asJava: Object) extends WriteStream[T] {

      def asJava = _asJava

//cached methods
//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):WriteStream[T] = {
    asJava.asInstanceOf[JWriteStream[Object]].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  def write(data: T):WriteStream[T] = {
    asJava.asInstanceOf[JWriteStream[Object]].write(toJava[T](data))
    this
  }

  def setWriteQueueMaxSize(maxSize: Int):WriteStream[T] = {
    asJava.asInstanceOf[JWriteStream[Object]].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }

  def drainHandler(handler: Handler[Unit]):WriteStream[T] = {
    asJava.asInstanceOf[JWriteStream[Object]].drainHandler({x: Void => handler.handle(x)})
    this
  }

//default methods
  //io.vertx.core.streams.WriteStream
  def end(t: T):Unit = {
    asJava.asInstanceOf[JWriteStream[Object]].end(toJava[T](t))
  }

//basic methods
  def end():Unit = {
    asJava.asInstanceOf[JWriteStream[Object]].end()
  }

  def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JWriteStream[Object]].writeQueueFull().asInstanceOf[Boolean]
  }

//future methods
}
}
