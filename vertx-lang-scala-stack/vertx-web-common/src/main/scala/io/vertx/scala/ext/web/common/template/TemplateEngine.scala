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

package io.vertx.scala.ext.web.common.template

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.buffer.Buffer
import scala.reflect.runtime.universe._
import io.vertx.ext.web.common.template.{TemplateEngine => JTemplateEngine}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A template template uses a specific template and the data in a routing context to render a resource into a buffer.
  * 
  * Concrete implementations exist for several well-known template engines.
  */

class TemplateEngine(private val _asJava: Object) {
  def asJava = _asJava




  /**
   * Render the template. Template engines that support partials/fragments should extract the template base path from
   * the template filename up to the last file separator.
   *
   * Some engines support localization, for these engines, there is a predefined key "lang" to specify the language to
   * be used in the localization, the format should follow the standard locale formats e.g.: "en-gb", "pt-br", "en".   * @param context the routing context
   * @param templateFileName the template file name to use
   * @param handler the handler that will be called with a result containing the buffer or a failure.
   */
  def render(context: io.vertx.core.json.JsonObject, templateFileName: String, handler: Handler[AsyncResult[io.vertx.core.buffer.Buffer]]): Unit = {
    asJava.asInstanceOf[JTemplateEngine].render(context, templateFileName.asInstanceOf[java.lang.String], {x: AsyncResult[Buffer] => handler.handle(AsyncResultWrapper[Buffer, io.vertx.core.buffer.Buffer](x, a => a))})
  }


  /**
   * Returns true if the template template caches template files. If false, then template files are freshly loaded each
   * time they are used.   * @return True if template files are cached; otherwise, false.
   */
  def isCachingEnabled (): Boolean = {
    asJava.asInstanceOf[JTemplateEngine].isCachingEnabled().asInstanceOf[Boolean]
  }


 /**
  * Like [[render]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def renderFuture (context: io.vertx.core.json.JsonObject, templateFileName: String): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Buffer, io.vertx.core.buffer.Buffer](x => x)
    asJava.asInstanceOf[JTemplateEngine].render(context, templateFileName.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object TemplateEngine {
  def apply(asJava: JTemplateEngine) = new TemplateEngine(asJava)
  
}
