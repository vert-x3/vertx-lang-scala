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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.eventbus.{SendContext => JSendContext}
import io.vertx.core.eventbus.{Message => JMessage}

/**
  *
  * Encapsulates a message being sent from Vert.x. Used with event bus interceptors
  */
class SendContext[T: TypeTag](private val _asJava: Object) {

  def asJava = _asJava

  /**
    * @return The message being sent
    */
  def message(): Message[T] = {
    Message[T](asJava.asInstanceOf[JSendContext[Object]].message())
  }

  /**
    * Call the next interceptor
    */
  def next(): Unit = {
    asJava.asInstanceOf[JSendContext[Object]].next()
  }

  /**
    * @return true if the message is being sent (point to point) or False if the message is being published
    */
  def send(): Boolean = {
    asJava.asInstanceOf[JSendContext[Object]].send().asInstanceOf[Boolean]
  }

  /**
    * @return the value sent or published (before being processed by the codec)
    */
  def sentBody(): AnyRef = {
    toScala[java.lang.Object](asJava.asInstanceOf[JSendContext[Object]].sentBody())
  }

}

object SendContext {
  def apply[T: TypeTag](asJava: JSendContext[_]) = new SendContext[T](asJava)  
}
