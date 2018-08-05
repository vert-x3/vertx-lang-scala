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

package io.vertx.scala.ext.web.handler

import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import scala.reflect.runtime.universe._
import io.vertx.ext.web.handler.{TimeoutHandler => JTimeoutHandler}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Handler that will timeout requests if the response has not been written after a certain time.
  * Timeout requests will be ended with an HTTP status code `503`.
  */

class TimeoutHandler(private val _asJava: Object) extends io.vertx.core.Handler[RoutingContext] {
  def asJava = _asJava






  override def handle (arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JTimeoutHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }


}

object TimeoutHandler {
  def apply(asJava: JTimeoutHandler) = new TimeoutHandler(asJava)
  
  /**
   * Create a handler   * @return the handler
   */
  def create(): TimeoutHandler = {
    TimeoutHandler(JTimeoutHandler.create())
  }

  /**
   * Create a handler   * @param timeout the timeout, in ms
   * @return the handler
   */
  def create(timeout: Long): TimeoutHandler = {
    TimeoutHandler(JTimeoutHandler.create(timeout.asInstanceOf[java.lang.Long]))
  }

  /**
   * Create a handler   * @param timeout the timeout, in ms
   * @return the handler
   */
  def create(timeout: Long,errorCode: Int): TimeoutHandler = {
    TimeoutHandler(JTimeoutHandler.create(timeout.asInstanceOf[java.lang.Long], errorCode.asInstanceOf[java.lang.Integer]))
  }

}
