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

package io.vertx.scala.core.streams;

import io.vertx.core.Handler

trait ReadStream[T] 
    extends io.vertx.scala.core.streams.StreamBase {

  def asJava: java.lang.Object

def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.streams.ReadStream[T]

def handler(handler: T => Unit): io.vertx.scala.core.streams.ReadStream[T]

def pause(): io.vertx.scala.core.streams.ReadStream[T]

def resume(): io.vertx.scala.core.streams.ReadStream[T]

def endHandler(endHandler: => Unit): io.vertx.scala.core.streams.ReadStream[T]

}

object ReadStream {

  def apply[T](_asJava: io.vertx.core.streams.ReadStream[T]): io.vertx.scala.core.streams.ReadStream[T] =
    new ReadStreamImpl[T](_asJava)

  private class ReadStreamImpl[T](private val _asJava: io.vertx.core.streams.ReadStream[T]) extends ReadStream[T] { 
  def asJava: java.lang.Object = _asJava

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.streams.ReadStream[T] = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: T => Unit): io.vertx.scala.core.streams.ReadStream[T] = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.handler(funcToHandler(handler))
    this
  }

  def pause(): io.vertx.scala.core.streams.ReadStream[T] = {
    _asJava.pause()
    this
  }

  def resume(): io.vertx.scala.core.streams.ReadStream[T] = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: => Unit): io.vertx.scala.core.streams.ReadStream[T] = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>endHandler))
    this
  }
  }

}
