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
import io.vertx.ext.web.handler.{CSRFHandler => JCSRFHandler}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler

/**
  * This handler adds a CSRF token to requests which mutate state. In order change the state a (XSRF-TOKEN) cookie is set
  * with a unique token, that is expected to be sent back in a (X-XSRF-TOKEN) header.
  *
  * The behavior is to check the request body header and cookie for validity.
  *
  * This Handler requires session support, thus should be added somewhere below Session and Body handlers.
  */
class CSRFHandler(private val _asJava: Object) 
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava = _asJava

  /**
    * Set the cookie name. By default XSRF-TOKEN is used as it is the expected name by AngularJS however other frameworks
    * might use other names.
    * @param name a new name for the cookie.
    * @return fluent
    */
//java.lang.String
  def setCookieName(name: String):CSRFHandler = {
    asJava.asInstanceOf[JCSRFHandler].setCookieName(name.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set the header name. By default X-XSRF-TOKEN is used as it is the expected name by AngularJS however other
    * frameworks might use other names.
    * @param name a new name for the header.
    * @return fluent
    */
//java.lang.String
  def setHeaderName(name: String):CSRFHandler = {
    asJava.asInstanceOf[JCSRFHandler].setHeaderName(name.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Should the handler give warning messages if this handler is used in other than https protocols?
    * @param nag true to nag
    * @return fluent
    */
//boolean
  def setNagHttps(nag: Boolean):CSRFHandler = {
    asJava.asInstanceOf[JCSRFHandler].setNagHttps(nag.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Set the timeout for tokens generated by the handler, by default it uses the default from the session handler.
    * @param timeout token timeout
    * @return fluent
    */
//long
  def setTimeout(timeout: Long):CSRFHandler = {
    asJava.asInstanceOf[JCSRFHandler].setTimeout(timeout.asInstanceOf[java.lang.Long])
    this
  }

  override def handle(arg0: RoutingContext):Unit = {
    asJava.asInstanceOf[JCSRFHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object CSRFHandler{
  def apply(asJava: JCSRFHandler) = new CSRFHandler(asJava)  
  /**
    * Instantiate a new CSRFHandlerImpl with a secret
    * 
    * <pre>
    * CSRFHandler.create("s3cr37")
    * </pre>
    * @param secret server secret to sign the token.
    */
  def create(secret: String):CSRFHandler = {
    CSRFHandler(JCSRFHandler.create(secret.asInstanceOf[java.lang.String]))
  }

}
