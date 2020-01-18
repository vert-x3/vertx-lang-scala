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
import io.vertx.ext.web.handler.{ResponseContentTypeHandler => JResponseContentTypeHandler}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A handler which sets the response content type automatically according to the best `Accept` header match.
  *
  * The header is set only if:
  * <ul>
  * <li>no object is stored in the routing context under the name [[io.vertx.scala.ext.web.handler.ResponseContentTypeHandler]]</li>
  * <li>a match is found</li>
  * <li>the header is not present already</li>
  * <li>content length header is absent or set to something different than zero</li>
  * </ul>
  */

class ResponseContentTypeHandler(private val _asJava: Object) extends io.vertx.core.Handler[RoutingContext] {
  def asJava = _asJava






  override def handle (arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JResponseContentTypeHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }


}

object ResponseContentTypeHandler {
  def apply(asJava: JResponseContentTypeHandler) = new ResponseContentTypeHandler(asJava)

  /**
   * Create a response content type handler.   * @return the response content type handler
   */
  def create(): ResponseContentTypeHandler = {
    ResponseContentTypeHandler(JResponseContentTypeHandler.create())//2 create
  }

  /**
   * Create a response content type handler with a custom disable flag.   * @return the response content type handler
   */
  def create(disableFlag: String): ResponseContentTypeHandler = {
    ResponseContentTypeHandler(JResponseContentTypeHandler.create(disableFlag.asInstanceOf[java.lang.String]))//2 create
  }

}
