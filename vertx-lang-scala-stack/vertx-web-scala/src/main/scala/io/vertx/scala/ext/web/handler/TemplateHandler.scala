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
import io.vertx.scala.ext.web.templ.TemplateEngine
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler

/**
  *
  * A handler which renders responses using a template engine and where the template name is selected from the URI
  * path.
  */
class TemplateHandler(private val _asJava: io.vertx.ext.web.handler.TemplateHandler) {

  def asJava: io.vertx.ext.web.handler.TemplateHandler = _asJava

  def handle(arg0: io.vertx.scala.ext.web.RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[io.vertx.ext.web.RoutingContext])
  }

}

object TemplateHandler {

  def apply(_asJava: io.vertx.ext.web.handler.TemplateHandler): io.vertx.scala.ext.web.handler.TemplateHandler =
    new io.vertx.scala.ext.web.handler.TemplateHandler(_asJava)

  def create(engine: io.vertx.scala.ext.web.templ.TemplateEngine): io.vertx.scala.ext.web.handler.TemplateHandler = {
    TemplateHandler.apply(io.vertx.ext.web.handler.TemplateHandler.create(engine.asJava.asInstanceOf[io.vertx.ext.web.templ.TemplateEngine]))
  }

  def create(engine: io.vertx.scala.ext.web.templ.TemplateEngine, templateDirectory: String, contentType: String): io.vertx.scala.ext.web.handler.TemplateHandler = {
    TemplateHandler.apply(io.vertx.ext.web.handler.TemplateHandler.create(engine.asJava.asInstanceOf[io.vertx.ext.web.templ.TemplateEngine], templateDirectory, contentType))
  }

}
