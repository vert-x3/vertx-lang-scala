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

package io.vertx.scala.ext.auth.oauth2

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.auth.oauth2.{OAuth2Auth => JOAuth2Auth}
  import io.vertx.ext.auth.{User => JUser}
import io.vertx.scala.ext.auth.User
import io.vertx.ext.auth.{User => JUser}
  import io.vertx.core.http.HttpMethod
  import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
  import io.vertx.core.json.JsonObject
    import io.vertx.ext.auth.oauth2.{OAuth2Auth => JOAuth2Auth}
      import io.vertx.ext.auth.oauth2.OAuth2FlowType
  import io.vertx.ext.auth.oauth2.{AccessToken => JAccessToken}
  import io.vertx.ext.auth.oauth2.{OAuth2ClientOptions => JOAuth2ClientOptions}
  import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}

/**
  * Factory interface for creating OAuth2 based [[io.vertx.scala.ext.auth.AuthProvider]] instances.
  */
class OAuth2Auth(private val _asJava: JOAuth2Auth) {

  def asJava: JOAuth2Auth = _asJava

  /**
    * Generate a redirect URL to the authN/Z backend. It only applies to auth_code flow.
    */
  def authorizeURL(params: JsonObject): String = {
    _asJava.authorizeURL(params)
  }

  /**
    * Returns the Access Token object.
    * @param params - JSON with the options, each flow requires different options.
    * @return - The future returning the results.
    */
  def getTokenFuture(params: JsonObject): concurrent.Future[AccessToken] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAccessToken,AccessToken]((x => if (x == null) null else AccessToken.apply(x)))
    _asJava.getToken(params, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Call OAuth2 APIs.
    * @param method HttpMethod
    * @param path target path
    * @param params parameters
    * @return future
    */
  def apiFuture(method: io.vertx.core.http.HttpMethod, path: String, params: JsonObject): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.api(method, path, params, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Returns true if this provider supports JWT tokens as the access_token. This is typically true if the provider
    * implements the `openid-connect` protocol. This is a plain return from the config option jwtToken, which is false
    * by default.
    *
    * This information is important to validate grants. Since pure OAuth2 should be used for authorization and when a
    * token is requested all grants should be declared, in case of openid-connect this is not true. OpenId will issue
    * a token and all grants will be encoded on the token itself so the requester does not need to list the required
    * grants.
    * @return true if openid-connect is used.
    */
  def hasJWTToken(): Boolean = {
    _asJava.hasJWTToken()
  }

}

object OAuth2Auth {

  def apply(_asJava: JOAuth2Auth): OAuth2Auth =
    new OAuth2Auth(_asJava)

  def createKeycloak(vertx: Vertx, flow: io.vertx.ext.auth.oauth2.OAuth2FlowType, config: JsonObject): OAuth2Auth = {
    OAuth2Auth.apply(io.vertx.ext.auth.oauth2.OAuth2Auth.createKeycloak(vertx.asJava.asInstanceOf[JVertx], flow, config))
  }

  def create(vertx: Vertx, flow: io.vertx.ext.auth.oauth2.OAuth2FlowType, config: OAuth2ClientOptions): OAuth2Auth = {
    OAuth2Auth.apply(io.vertx.ext.auth.oauth2.OAuth2Auth.create(vertx.asJava.asInstanceOf[JVertx], flow, config.asJava))
  }

  def create(vertx: Vertx, flow: io.vertx.ext.auth.oauth2.OAuth2FlowType): OAuth2Auth = {
    OAuth2Auth.apply(io.vertx.ext.auth.oauth2.OAuth2Auth.create(vertx.asJava.asInstanceOf[JVertx], flow))
  }

}
