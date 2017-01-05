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
import io.vertx.ext.web.handler.{CorsHandler => JCorsHandler}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.core.http.HttpMethod
import io.vertx.scala.ext.web.RoutingContext
import scala.collection.JavaConverters._
import io.vertx.core.Handler

/**
  * A handler which implements server side http://www.w3.org/TR/cors/[CORS] support for Vert.x-Web.
  */
class CorsHandler(private val _asJava: Object) 
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava = _asJava

//cached methods
//fluent methods
  def allowedMethod(method: io.vertx.core.http.HttpMethod):CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].allowedMethod(method)
    this
  }

  def allowedHeader(headerName: String):CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].allowedHeader(headerName.asInstanceOf[java.lang.String])
    this
  }

  def allowedHeaders(headerNames: scala.collection.mutable.Set[String]):CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].allowedHeaders(headerNames.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  def exposedHeader(headerName: String):CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].exposedHeader(headerName.asInstanceOf[java.lang.String])
    this
  }

  def exposedHeaders(headerNames: scala.collection.mutable.Set[String]):CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].exposedHeaders(headerNames.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  def allowCredentials(allow: Boolean):CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].allowCredentials(allow.asInstanceOf[java.lang.Boolean])
    this
  }

  def maxAgeSeconds(maxAgeSeconds: Int):CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].maxAgeSeconds(maxAgeSeconds.asInstanceOf[java.lang.Integer])
    this
  }

//default methods
//basic methods
  override def handle(arg0: RoutingContext):Unit = {
    asJava.asInstanceOf[JCorsHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

//future methods
}

  object CorsHandler{
    def apply(asJava: JCorsHandler) = new CorsHandler(asJava)  
  //static methods
    def create(allowedOriginPattern: String):CorsHandler = {
      CorsHandler(JCorsHandler.create(allowedOriginPattern.asInstanceOf[java.lang.String]))
    }

  }
