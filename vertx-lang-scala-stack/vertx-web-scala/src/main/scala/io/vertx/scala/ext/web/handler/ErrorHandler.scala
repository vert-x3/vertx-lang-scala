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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.web.handler.{ErrorHandler => JErrorHandler}
  import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
      import io.vertx.ext.web.handler.{ErrorHandler => JErrorHandler}

/**
  * A pretty error handler for rendering error pages.
  */
class ErrorHandler(private val _asJava: JErrorHandler) {

  def asJava: JErrorHandler = _asJava

  def handle(arg0: RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object ErrorHandler {

  def apply(_asJava: JErrorHandler): ErrorHandler =
    new ErrorHandler(_asJava)

  def create(): ErrorHandler = {
    ErrorHandler.apply(io.vertx.ext.web.handler.ErrorHandler.create())
  }

  def create(errorTemplateName: String, displayExceptionDetails: Boolean): ErrorHandler = {
    ErrorHandler.apply(io.vertx.ext.web.handler.ErrorHandler.create(errorTemplateName, displayExceptionDetails))
  }

  def create(displayExceptionDetails: Boolean): ErrorHandler = {
    ErrorHandler.apply(io.vertx.ext.web.handler.ErrorHandler.create(displayExceptionDetails))
  }

  def create(errorTemplateName: String): ErrorHandler = {
    ErrorHandler.apply(io.vertx.ext.web.handler.ErrorHandler.create(errorTemplateName))
  }

}
