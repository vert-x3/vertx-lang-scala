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
import io.vertx.ext.web.handler.{TemplateHandler => JTemplateHandler}
  import io.vertx.ext.web.handler.{TemplateHandler => JTemplateHandler}
  import io.vertx.ext.web.templ.{TemplateEngine => JTemplateEngine}
import io.vertx.scala.ext.web.templ.TemplateEngine
import io.vertx.ext.web.templ.{TemplateEngine => JTemplateEngine}
  import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
    
/**
  *
  * A handler which renders responses using a template engine and where the template name is selected from the URI
  * path.
  */
class TemplateHandler(private val _asJava: JTemplateHandler) {

  def asJava: JTemplateHandler = _asJava

  def handle(arg0: RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object TemplateHandler {

  def apply(_asJava: JTemplateHandler): TemplateHandler =
    new TemplateHandler(_asJava)

  def create(engine: TemplateEngine): TemplateHandler = {
    TemplateHandler.apply(io.vertx.ext.web.handler.TemplateHandler.create(engine.asJava.asInstanceOf[JTemplateEngine]))
  }

  def create(engine: TemplateEngine, templateDirectory: String, contentType: String): TemplateHandler = {
    TemplateHandler.apply(io.vertx.ext.web.handler.TemplateHandler.create(engine.asJava.asInstanceOf[JTemplateEngine], templateDirectory, contentType))
  }

}
