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
import io.vertx.scala.ext.web.Route
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.scala.ext.auth.oauth2.OAuth2Auth

/**
  * An auth handler that provides OAuth2 Authentication support. This handler is suitable for AuthCode flows.
  */
class OAuth2AuthHandler(private val _asJava: io.vertx.ext.web.handler.OAuth2AuthHandler) 
    extends io.vertx.scala.ext.web.handler.AuthHandler {

  def asJava: io.vertx.ext.web.handler.OAuth2AuthHandler = _asJava

  def handle(arg0: io.vertx.scala.ext.web.RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[io.vertx.ext.web.RoutingContext])
  }

  /**
    * Add a required authority for this auth handler
    * @param authority the authority
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthority(authority: String): io.vertx.scala.ext.web.handler.AuthHandler = {
    _asJava.addAuthority(authority)
    this
  }

  /**
    * Add a set of required authorities for this auth handler
    * @param authorities the set of authorities
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthorities(authorities: Set[String]): io.vertx.scala.ext.web.handler.AuthHandler = {
    _asJava.addAuthorities(authorities.map(x => if (x == null) null else x:java.lang.String).asJava)
    this
  }

  /**
    * Build the authorization URL.
    * @param redirectURL where is the callback mounted.
    * @param state state opaque token to avoid forged requests
    * @return the redirect URL
    */
  def authURI(redirectURL: String, state: String): String = {
    _asJava.authURI(redirectURL, state)
  }

  /**
    * add the callback handler to a given route.
    * @param route a given route e.g.: `/callback`
    * @return self
    */
  def setupCallback(route: io.vertx.scala.ext.web.Route): io.vertx.scala.ext.web.handler.OAuth2AuthHandler = {
    _asJava.setupCallback(route.asJava.asInstanceOf[io.vertx.ext.web.Route])
    this
  }

}

object OAuth2AuthHandler {

  def apply(_asJava: io.vertx.ext.web.handler.OAuth2AuthHandler): io.vertx.scala.ext.web.handler.OAuth2AuthHandler =
    new io.vertx.scala.ext.web.handler.OAuth2AuthHandler(_asJava)

  def create(authProvider: io.vertx.scala.ext.auth.oauth2.OAuth2Auth, uri: String): io.vertx.scala.ext.web.handler.OAuth2AuthHandler = {
    OAuth2AuthHandler.apply(io.vertx.ext.web.handler.OAuth2AuthHandler.create(authProvider.asJava.asInstanceOf[io.vertx.ext.auth.oauth2.OAuth2Auth], uri))
  }

}
