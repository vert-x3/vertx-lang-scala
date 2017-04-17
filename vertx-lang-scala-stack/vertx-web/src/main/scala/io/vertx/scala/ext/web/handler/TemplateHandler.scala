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
import io.vertx.ext.web.handler.{TemplateHandler => JTemplateHandler}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.scala.ext.web.templ.TemplateEngine
import io.vertx.ext.web.templ.{TemplateEngine => JTemplateEngine}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler

/**
  *
  * A handler which renders responses using a template engine and where the template name is selected from the URI
  * path.
  */
class TemplateHandler(private val _asJava: Object)
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava = _asJava

  /**
    * Set the index template
    * @param indexTemplate the index template
    * @return a reference to this, so the API can be used fluently
    */
  def setIndexTemplate(indexTemplate: String): TemplateHandler = {
    asJava.asInstanceOf[JTemplateHandler].setIndexTemplate(indexTemplate.asInstanceOf[java.lang.String])
    this
  }

  override def handle(arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JTemplateHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object TemplateHandler {
  def apply(asJava: JTemplateHandler) = new TemplateHandler(asJava)  
  /**
    * Create a handler
    * @param engine the template engine
    * @return the handler
    */
  def create(engine: TemplateEngine): TemplateHandler = {
    TemplateHandler(JTemplateHandler.create(engine.asJava.asInstanceOf[JTemplateEngine]))
  }

  /**
    * Create a handler
    * @param engine the template engine
    * @param templateDirectory the template directory where templates will be looked for
    * @param contentType the content type header to be used in the response
    * @return the handler
    */
  def create(engine: TemplateEngine, templateDirectory: String, contentType: String): TemplateHandler = {
    TemplateHandler(JTemplateHandler.create(engine.asJava.asInstanceOf[JTemplateEngine], templateDirectory.asInstanceOf[java.lang.String], contentType.asInstanceOf[java.lang.String]))
  }

}
