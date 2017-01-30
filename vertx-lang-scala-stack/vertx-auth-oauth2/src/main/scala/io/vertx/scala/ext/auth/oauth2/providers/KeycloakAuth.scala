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

package io.vertx.scala.ext.auth.oauth2.providers

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.scala.ext.auth.oauth2.OAuth2Auth
import io.vertx.core.http.{HttpClientOptions => JHttpClientOptions}
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.http.HttpClientOptions
import io.vertx.ext.auth.oauth2.OAuth2FlowType
import io.vertx.scala.core.Vertx
import io.vertx.ext.auth.oauth2.{OAuth2Auth => JOAuth2Auth}
import io.vertx.ext.auth.oauth2.providers.{KeycloakAuth => JKeycloakAuth}
import io.vertx.core.{Vertx => JVertx}

/**
  * Simplified factory to create an  for Keycloak.
  */
class KeycloakAuth(private val _asJava: Object) {

  def asJava = _asJava

}

object KeycloakAuth{
  def apply(asJava: JKeycloakAuth) = new KeycloakAuth(asJava)  
  /**
    * Create a OAuth2Auth provider for Keycloak
    * @param config the json config file exported from Keycloak admin console
    */
  def create(vertx: Vertx,config: io.vertx.core.json.JsonObject): OAuth2Auth = {
    OAuth2Auth(JKeycloakAuth.create(vertx.asJava.asInstanceOf[JVertx],config))
  }

  /**
    * Create a OAuth2Auth provider for Keycloak
    * @param flow the oauth2 flow to use
    * @param config the json config file exported from Keycloak admin console
    */
  def create(vertx: Vertx,flow: io.vertx.ext.auth.oauth2.OAuth2FlowType,config: io.vertx.core.json.JsonObject): OAuth2Auth = {
    OAuth2Auth(JKeycloakAuth.create(vertx.asJava.asInstanceOf[JVertx],flow,config))
  }

  /**
    * Create a OAuth2Auth provider for Keycloak
    * @param config the json config file exported from Keycloak admin console
    * @param httpClientOptions custom http client optionssee <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
    */
  def create(vertx: Vertx,config: io.vertx.core.json.JsonObject,httpClientOptions: HttpClientOptions): OAuth2Auth = {
    OAuth2Auth(JKeycloakAuth.create(vertx.asJava.asInstanceOf[JVertx],config,httpClientOptions.asJava))
  }

  /**
    * Create a OAuth2Auth provider for Keycloak
    * @param flow the oauth2 flow to use
    * @param config the json config file exported from Keycloak admin console
    * @param httpClientOptions custom http client optionssee <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
    */
  def create(vertx: Vertx,flow: io.vertx.ext.auth.oauth2.OAuth2FlowType,config: io.vertx.core.json.JsonObject,httpClientOptions: HttpClientOptions): OAuth2Auth = {
    OAuth2Auth(JKeycloakAuth.create(vertx.asJava.asInstanceOf[JVertx],flow,config,httpClientOptions.asJava))
  }

}
