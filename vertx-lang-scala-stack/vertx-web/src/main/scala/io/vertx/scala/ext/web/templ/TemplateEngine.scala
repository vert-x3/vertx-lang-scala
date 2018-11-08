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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.core.buffer.Buffer
import scala.reflect.runtime.universe._
import io.vertx.scala.ext.web.common.template.{TemplateEngine => STemplateEngine}
import io.vertx.ext.web.templ.{TemplateEngine => JTemplateEngine}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A template engine uses a specific template and the data in a routing context to render a resource into a buffer.
  * 
  * Concrete implementations exist for several well-known template engines.
  */

class TemplateEngine(private val _asJava: Object) extends STemplateEngine (_asJava) {





  /**
   * Render the template   * @param context the routing context
   * @param templateFileName the template file name to use
   * @param handler the handler that will be called with a result containing the buffer or a failure.
   */
  def render(context: RoutingContext, templateFileName: String, handler: Handler[AsyncResult[io.vertx.core.buffer.Buffer]]): Unit = {
    asJava.asInstanceOf[JTemplateEngine].render(context.asJava.asInstanceOf[JRoutingContext], templateFileName.asInstanceOf[java.lang.String], {x: AsyncResult[Buffer] => handler.handle(AsyncResultWrapper[Buffer, io.vertx.core.buffer.Buffer](x, a => a))})
  }

  /**
   * Render the template
   * 
   * <b>NOTE</b> if you call method directly (i.e. not using [[io.vertx.scala.ext.web.handler.TemplateHandler]]) make sure
   * that <i>templateFileName</i> is sanitized via    * @param context the routing context
   * @param templateDirectory the template directory to use
   * @param templateFileName the relative template file name to use
   * @param handler the handler that will be called with a result containing the buffer or a failure.
   */
  def render(context: RoutingContext, templateDirectory: String, templateFileName: String, handler: Handler[AsyncResult[io.vertx.core.buffer.Buffer]]): Unit = {
    asJava.asInstanceOf[JTemplateEngine].render(context.asJava.asInstanceOf[JRoutingContext], templateDirectory.asInstanceOf[java.lang.String], templateFileName.asInstanceOf[java.lang.String], {x: AsyncResult[Buffer] => handler.handle(AsyncResultWrapper[Buffer, io.vertx.core.buffer.Buffer](x, a => a))})
  }

  /**
   * Returns true if the template engine caches template files. If false, then template files are freshly loaded each
   * time they are used.   * @return True if template files are cached; otherwise, false.
   */
  override def isCachingEnabled(): Boolean = {
    asJava.asInstanceOf[JTemplateEngine].isCachingEnabled().asInstanceOf[Boolean]
  }



 /**
  * Like [[render]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def renderFuture (context: RoutingContext, templateFileName: String): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Buffer, io.vertx.core.buffer.Buffer](x => x)
    asJava.asInstanceOf[JTemplateEngine].render(context.asJava.asInstanceOf[JRoutingContext], templateFileName.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[render]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def renderFuture (context: RoutingContext, templateDirectory: String, templateFileName: String): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Buffer, io.vertx.core.buffer.Buffer](x => x)
    asJava.asInstanceOf[JTemplateEngine].render(context.asJava.asInstanceOf[JRoutingContext], templateDirectory.asInstanceOf[java.lang.String], templateFileName.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object TemplateEngine {
  def apply(asJava: JTemplateEngine) = new TemplateEngine(asJava)
  
}
