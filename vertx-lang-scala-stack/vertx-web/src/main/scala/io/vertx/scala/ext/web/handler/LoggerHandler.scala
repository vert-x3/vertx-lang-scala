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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.web.handler.{LoggerHandler => JLoggerHandler}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler
import io.vertx.ext.web.handler.LoggerFormat

/**
  * A handler which logs request information to the Vert.x logger.
  */
class LoggerHandler(private val _asJava: Object)
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava = _asJava

  override def handle(arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JLoggerHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object LoggerHandler {
  def apply(asJava: JLoggerHandler) = new LoggerHandler(asJava)  
  /**
    * Create a handler with default format
    * @return the handler
    */
  def create(): LoggerHandler = {
    LoggerHandler(JLoggerHandler.create())
  }

  /**
    * Create a handler with he specified format
    * @param format the format
    * @return the handler
    */
  def create(format: io.vertx.ext.web.handler.LoggerFormat): LoggerHandler = {
    LoggerHandler(JLoggerHandler.create(format))
  }

  /**
    * Create a handler with he specified format
    * @param immediate true if logging should occur as soon as request arrives
    * @param format the format
    * @return the handler
    */
  def create(immediate: Boolean, format: io.vertx.ext.web.handler.LoggerFormat): LoggerHandler = {
    LoggerHandler(JLoggerHandler.create(immediate.asInstanceOf[java.lang.Boolean], format))
  }

}
