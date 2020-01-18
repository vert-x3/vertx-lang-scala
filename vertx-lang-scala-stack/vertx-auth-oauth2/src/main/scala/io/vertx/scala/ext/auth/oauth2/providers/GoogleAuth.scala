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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.ext.auth.oauth2.OAuth2ClientOptions
import io.vertx.ext.auth.oauth2.providers.{GoogleAuth => JGoogleAuth}
import io.vertx.scala.ext.auth.oauth2.OAuth2Auth
import scala.reflect.runtime.universe._
import io.vertx.core.http.{HttpClientOptions => JHttpClientOptions}
import io.vertx.ext.auth.oauth2.{OAuth2ClientOptions => JOAuth2ClientOptions}
import io.vertx.scala.core.Vertx
import io.vertx.ext.auth.oauth2.{OAuth2Auth => JOAuth2Auth}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.Converter._
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.scala.core.http.HttpClientOptions
import io.vertx.core.Handler
import io.vertx.ext.auth.oauth2.providers.{OpenIDConnectAuth => JOpenIDConnectAuth}
import io.vertx.lang.scala.HandlerOps._

/**
  * Simplified factory to create an [[io.vertx.scala.ext.auth.oauth2.OAuth2Auth]] for Google.
  */

class GoogleAuth(private val _asJava: Object) extends OpenIDConnectAuth (_asJava) {







}

object GoogleAuth {
  def apply(asJava: JGoogleAuth) = new GoogleAuth(asJava)

  /**
   * Create a OAuth2Auth provider for Google   * @param clientId the client id given to you by Google
   * @param clientSecret the client secret given to you by Google
   */
  def create(vertx: Vertx,clientId: String,clientSecret: String): OAuth2Auth = {
    OAuth2Auth(JGoogleAuth.create(vertx.asJava.asInstanceOf[JVertx], clientId.asInstanceOf[java.lang.String], clientSecret.asInstanceOf[java.lang.String]))//2 create
  }

  /**
   * Create a OAuth2Auth provider for Google   * @param clientId the client id given to you by Google
   * @param clientSecret the client secret given to you by Google
   * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
   */
  def create(vertx: Vertx,clientId: String,clientSecret: String,httpClientOptions: HttpClientOptions): OAuth2Auth = {
    OAuth2Auth(JGoogleAuth.create(vertx.asJava.asInstanceOf[JVertx], clientId.asInstanceOf[java.lang.String], clientSecret.asInstanceOf[java.lang.String], httpClientOptions.asJava))//2 create
  }

  /**
   * Create a OAuth2Auth provider for OpenID Connect Discovery. The discovery will use the default site in the
   * configuration options and attempt to load the well known descriptor. If a site is provided (for example when
   * running on a custom instance) that site will be used to do the lookup.
   * 
   * If the discovered config includes a json web key url, it will be also fetched and the JWKs will be loaded
   * into the OAuth provider so tokens can be decoded.   * @param vertx the vertx instance
   * @param config the initial config see <a href="../../../../../../../../../cheatsheet/OAuth2ClientOptions.html">OAuth2ClientOptions</a>
   * @param handler the instantiated Oauth2 provider instance handler
   */
  def discover(vertx: Vertx,config: OAuth2ClientOptions,handler: Handler[AsyncResult[OAuth2Auth]]): Unit = {
    JGoogleAuth.discover(vertx.asJava.asInstanceOf[JVertx], config.asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JOAuth2Auth]]{def handle(x: AsyncResult[JOAuth2Auth]) {handler.handle(AsyncResultWrapper[JOAuth2Auth, OAuth2Auth](x, a => OAuth2Auth(a)))}}))//2 discover
  }

  /**
   * Create a OAuth2Auth provider for Google Service Account (Server to Server)   * @param serviceAccountJson the configuration json file from your Google API page
   */
  def create(vertx: Vertx,serviceAccountJson: io.vertx.core.json.JsonObject): OAuth2Auth = {
    OAuth2Auth(JGoogleAuth.create(vertx.asJava.asInstanceOf[JVertx], serviceAccountJson))//2 create
  }

  /**
   * Create a OAuth2Auth provider for Google Service Account (Server to Server)   * @param serviceAccountJson the configuration json file from your Google API page
   * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
   */
  def create(vertx: Vertx,serviceAccountJson: io.vertx.core.json.JsonObject,httpClientOptions: HttpClientOptions): OAuth2Auth = {
    OAuth2Auth(JGoogleAuth.create(vertx.asJava.asInstanceOf[JVertx], serviceAccountJson, httpClientOptions.asJava))//2 create
  }

}
