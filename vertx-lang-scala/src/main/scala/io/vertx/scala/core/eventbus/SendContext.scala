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

package io.vertx.scala.core.eventbus

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.eventbus.{SendContext => JSendContext}
import io.vertx.core.eventbus.{Message => JMessage}

/**
  *
  * Encapsulates a message being sent from Vert.x. Used with event bus interceptors
  */
class SendContext[T:TypeTag](private val _asJava: Object, objectToT: Option[Object => T] = None) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  def message():Message[T] = {
    Message[T](asJava.asInstanceOf[JSendContext[Object]].message())
  }

  def next():Unit = {
    asJava.asInstanceOf[JSendContext[Object]].next()
  }

  def send():Boolean = {
    asJava.asInstanceOf[JSendContext[Object]].send().asInstanceOf[Boolean]
  }

//future methods
}

  object SendContext{
    def apply[T:TypeTag](asJava: JSendContext[_], objectToT: Option[Object => T] = None) = new SendContext[T](asJava, objectToT)  
  //static methods
  }
