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
import io.vertx.scala.ext.web.Route
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.web.handler.{OAuth2AuthHandler => JOAuth2AuthHandler}
import io.vertx.scala.ext.auth.oauth2.OAuth2Auth
import io.vertx.ext.web.handler.{AuthHandler => JAuthHandler}
import io.vertx.core.json.JsonObject
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.ext.web.{Route => JRoute}
import scala.collection.JavaConverters._
import io.vertx.ext.auth.oauth2.{OAuth2Auth => JOAuth2Auth}

/**
  * An auth handler that provides OAuth2 Authentication support. This handler is suitable for AuthCode flows.
  */
class OAuth2AuthHandler(private val _asJava: Object) 
    extends AuthHandler {

  def asJava = _asJava

//cached methods
//fluent methods
  override def addAuthority(authority: String):AuthHandler = {
    asJava.asInstanceOf[JOAuth2AuthHandler].addAuthority(authority.asInstanceOf[java.lang.String])
    this
  }

  override def addAuthorities(authorities: scala.collection.mutable.Set[String]):AuthHandler = {
    asJava.asInstanceOf[JOAuth2AuthHandler].addAuthorities(authorities.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  def extraParams(extraParams: io.vertx.core.json.JsonObject):OAuth2AuthHandler = {
    asJava.asInstanceOf[JOAuth2AuthHandler].extraParams(extraParams)
    this
  }

  def setupCallback(route: Route):OAuth2AuthHandler = {
    asJava.asInstanceOf[JOAuth2AuthHandler].setupCallback(route.asJava.asInstanceOf[JRoute])
    this
  }

//default methods
//basic methods
  override def handle(arg0: RoutingContext):Unit = {
    asJava.asInstanceOf[JOAuth2AuthHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

//future methods
}

  object OAuth2AuthHandler{
    def apply(asJava: JOAuth2AuthHandler) = new OAuth2AuthHandler(asJava)  
  //static methods
    def create(authProvider: OAuth2Auth,callbackURL: String):OAuth2AuthHandler = {
      OAuth2AuthHandler(JOAuth2AuthHandler.create(authProvider.asJava.asInstanceOf[JOAuth2Auth],callbackURL.asInstanceOf[java.lang.String]))
    }

  }
