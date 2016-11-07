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
import io.vertx.ext.web.handler.{OAuth2AuthHandler => JOAuth2AuthHandler}
import io.vertx.ext.web.{Route => JRoute}
import io.vertx.scala.ext.web.Route
import io.vertx.ext.web.handler.{AuthHandler => JAuthHandler}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.ext.auth.oauth2.{OAuth2Auth => JOAuth2Auth}
import io.vertx.scala.ext.auth.oauth2.OAuth2Auth

/**
  * An auth handler that provides OAuth2 Authentication support. This handler is suitable for AuthCode flows.
  */
class OAuth2AuthHandler(private val _asJava: JOAuth2AuthHandler) 
    extends AuthHandler {

  def asJava: JOAuth2AuthHandler = _asJava

  def handle(arg0: RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

  /**
    * Add a required authority for this auth handler
    * @param authority the authority
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthority(authority: String): AuthHandler = {
    _asJava.addAuthority(authority)
    this
  }

  /**
    * Add a set of required authorities for this auth handler
    * @param authorities the set of authorities
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthorities(authorities: Set[String]): AuthHandler = {
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
  def setupCallback(route: Route): OAuth2AuthHandler = {
    _asJava.setupCallback(route.asJava.asInstanceOf[JRoute])
    this
  }

}

object OAuth2AuthHandler {

  def apply(_asJava: JOAuth2AuthHandler): OAuth2AuthHandler =
    new OAuth2AuthHandler(_asJava)

  def create(authProvider: OAuth2Auth, uri: String): OAuth2AuthHandler = {
    OAuth2AuthHandler.apply(io.vertx.ext.web.handler.OAuth2AuthHandler.create(authProvider.asJava.asInstanceOf[JOAuth2Auth], uri))
  }

}
