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
import io.vertx.core.Handler

/**
  * Base interface for a stream.
  */
trait StreamBase {

  def asJava: java.lang.Object

  def exceptionHandler(handler: Handler[Throwable]):StreamBase

}

object StreamBase{
  def apply(asJava: Object, useTypeTags:Boolean = false):StreamBase = new StreamBaseImpl(asJava, useTypeTags)
    private class StreamBaseImpl(private val _asJava: Object, private val _useTypeTags:Boolean) extends StreamBase {

      def asJava = _asJava

//cached methods
//fluent methods
  def exceptionHandler(handler: Handler[Throwable]):StreamBase = {
    asJava.asInstanceOf[JStreamBase].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

//default methods
//basic methods
//future methods
}
}
