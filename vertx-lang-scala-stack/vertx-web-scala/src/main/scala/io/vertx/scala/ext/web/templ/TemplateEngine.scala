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

package io.vertx.scala.ext.web.templ

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.core.buffer.Buffer
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler

/**
  * A template engine uses a specific template and the data in a routing context to render a resource into a buffer.
  * 
  * Concrete implementations exist for several well-known template engines.
  */
class TemplateEngine(private val _asJava: io.vertx.ext.web.templ.TemplateEngine) {

  def asJava: io.vertx.ext.web.templ.TemplateEngine = _asJava

  /**
    * Render
    * @param context the routing context
    * @param templateFileName the template file name to use
    * @return the future that will be called with a result containing the buffer or a failure.
    */
  def renderFuture(context: io.vertx.scala.ext.web.RoutingContext, templateFileName: String): concurrent.Future[io.vertx.scala.core.buffer.Buffer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.buffer.Buffer,io.vertx.scala.core.buffer.Buffer]((x => if (x == null) null else Buffer.apply(x)))
    _asJava.render(context.asJava.asInstanceOf[io.vertx.ext.web.RoutingContext], templateFileName, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object TemplateEngine {

  def apply(_asJava: io.vertx.ext.web.templ.TemplateEngine): io.vertx.scala.ext.web.templ.TemplateEngine =
    new io.vertx.scala.ext.web.templ.TemplateEngine(_asJava)

}
