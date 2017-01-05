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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
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

//cached methods
//fluent methods
  def setCookieName(name: String):CSRFHandler = {
    asJava.asInstanceOf[JCSRFHandler].setCookieName(name.asInstanceOf[java.lang.String])
    this
  }

  def setHeaderName(name: String):CSRFHandler = {
    asJava.asInstanceOf[JCSRFHandler].setHeaderName(name.asInstanceOf[java.lang.String])
    this
  }

  def setNagHttps(nag: Boolean):CSRFHandler = {
    asJava.asInstanceOf[JCSRFHandler].setNagHttps(nag.asInstanceOf[java.lang.Boolean])
    this
  }

  def setTimeout(timeout: Long):CSRFHandler = {
    asJava.asInstanceOf[JCSRFHandler].setTimeout(timeout.asInstanceOf[java.lang.Long])
    this
  }

//default methods
//basic methods
  override def handle(arg0: RoutingContext):Unit = {
    asJava.asInstanceOf[JCSRFHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

//future methods
}

  object CSRFHandler{
    def apply(asJava: JCSRFHandler) = new CSRFHandler(asJava)  
  //static methods
    def create(secret: String):CSRFHandler = {
      CSRFHandler(JCSRFHandler.create(secret.asInstanceOf[java.lang.String]))
    }

  }
