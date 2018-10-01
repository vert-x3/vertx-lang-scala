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

import io.vertx.core.eventbus.{Message => JMessage}
import scala.reflect.runtime.universe._
import io.vertx.core.eventbus.{DeliveryContext => JDeliveryContext}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  *
  * Encapsulates a message being delivered by Vert.x as well as providing control over the message delivery.
  * <p/>
  * Used with event bus interceptors.
  */

class DeliveryContext[T: TypeTag](private val _asJava: Object) {
  def asJava = _asJava





  /**
   * @return The message being delivered
   */
  def message (): Message[T] = {
    Message[T](asJava.asInstanceOf[JDeliveryContext[Object]].message())
  }

  /**
   * Call the next interceptor
   */
  def next (): Unit = {
    asJava.asInstanceOf[JDeliveryContext[Object]].next()
  }

  /**
   * @return true if the message is being sent (point to point) or False if the message is being published
   */
  def send (): Boolean = {
    asJava.asInstanceOf[JDeliveryContext[Object]].send().asInstanceOf[Boolean]
  }

  /**
   * @return the value delivered by the message (before or after being processed by the codec)
   */
  def body (): AnyRef = {
    toScala[java.lang.Object](asJava.asInstanceOf[JDeliveryContext[Object]].body())
  }


}

object DeliveryContext {
  def apply[T: TypeTag](asJava: JDeliveryContext[_]) = new DeliveryContext[T](asJava)
  
}
