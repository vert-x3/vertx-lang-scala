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

import io.vertx.ext.web.handler.{CorsHandler => JCorsHandler}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import scala.reflect.runtime.universe._
import io.vertx.core.http.HttpMethod
import io.vertx.scala.ext.web.RoutingContext
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A handler which implements server side http://www.w3.org/TR/cors/[CORS] support for Vert.x-Web.
  */

class CorsHandler(private val _asJava: Object) extends io.vertx.core.Handler[RoutingContext] {
  def asJava = _asJava



  /**
   * Add an allowed method   * @param method the method to add
   * @return a reference to this, so the API can be used fluently
   */
  
  def allowedMethod(method: io.vertx.core.http.HttpMethod): CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].allowedMethod(method)
    this
  }

  /**
   * Add a set of  allowed methods   * @param methods the methods to add
   * @return a reference to this, so the API can be used fluently
   */
  
  def allowedMethods(methods: scala.collection.mutable.Set[io.vertx.core.http.HttpMethod]): CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].allowedMethods(methods.asJava)
    this
  }

  /**
   * Add an allowed header   * @param headerName the allowed header name
   * @return a reference to this, so the API can be used fluently
   */
  
  def allowedHeader(headerName: String): CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].allowedHeader(headerName.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Add a set of allowed headers   * @param headerNames the allowed header names
   * @return a reference to this, so the API can be used fluently
   */
  
  def allowedHeaders(headerNames: scala.collection.mutable.Set[String]): CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].allowedHeaders(headerNames.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  /**
   * Add an exposed header   * @param headerName the exposed header name
   * @return a reference to this, so the API can be used fluently
   */
  
  def exposedHeader(headerName: String): CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].exposedHeader(headerName.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Add a set of exposed headers   * @param headerNames the exposed header names
   * @return a reference to this, so the API can be used fluently
   */
  
  def exposedHeaders(headerNames: scala.collection.mutable.Set[String]): CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].exposedHeaders(headerNames.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  /**
   * Set whether credentials are allowed. Note that user agents will block
   * requests that use a wildcard as origin and include credentials.
   *
   * From the MDN documentation you can read:
   *
   * <blockquote>
   * Important note: when responding to a credentialed request,
   * server must specify a domain, and cannot use wild carding.
   * </blockquote>   * @param allow true if allowed
   * @return a reference to this, so the API can be used fluently
   */
  
  def allowCredentials(allow: Boolean): CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].allowCredentials(allow.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Set how long the browser should cache the information   * @param maxAgeSeconds max age in seconds
   * @return a reference to this, so the API can be used fluently
   */
  
  def maxAgeSeconds(maxAgeSeconds: Int): CorsHandler = {
    asJava.asInstanceOf[JCorsHandler].maxAgeSeconds(maxAgeSeconds.asInstanceOf[java.lang.Integer])
    this
  }




  override def handle (arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JCorsHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }


}

object CorsHandler {
  def apply(asJava: JCorsHandler) = new CorsHandler(asJava)

  /**
   * Create a CORS handler   * @param allowedOriginPattern the allowed origin pattern
   * @return the handler
   */
  def create(allowedOriginPattern: String): CorsHandler = {
    CorsHandler(JCorsHandler.create(allowedOriginPattern.asInstanceOf[java.lang.String]))//2 create
  }

}
