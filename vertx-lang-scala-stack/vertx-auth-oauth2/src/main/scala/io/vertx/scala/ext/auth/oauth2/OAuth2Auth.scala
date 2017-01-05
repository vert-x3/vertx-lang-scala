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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.auth.oauth2.{AccessToken => JAccessToken}
import io.vertx.ext.auth.oauth2.OAuth2FlowType
import io.vertx.ext.auth.oauth2.{OAuth2ClientOptions => JOAuth2ClientOptions}
import io.vertx.ext.auth.oauth2.{OAuth2Auth => JOAuth2Auth}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.scala.ext.auth.User
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.core.http.HttpMethod
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Factory interface for creating OAuth2 based [[io.vertx.scala.ext.auth.AuthProvider]] instances.
  */
class OAuth2Auth(private val _asJava: Object) 
    extends AuthProvider(_asJava) {


  /**
    * Call OAuth2 APIs.
    * @param method HttpMethod
    * @param path target path
    * @param params parameters
    * @return self
    */
  def api(method: io.vertx.core.http.HttpMethod,path: String,params: io.vertx.core.json.JsonObject,handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):OAuth2Auth = {
    asJava.asInstanceOf[JOAuth2Auth].api(method,path.asInstanceOf[java.lang.String],params,{x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Decode a token to a [[io.vertx.scala.ext.auth.oauth2.AccessToken]] object. This is useful to handle bearer JWT tokens.
    * @param token the access token (base64 string)
    * @return self
    */
  def decodeToken(token: String,handler: Handler[AsyncResult[AccessToken]]):OAuth2Auth = {
    asJava.asInstanceOf[JOAuth2Auth].decodeToken(token.asInstanceOf[java.lang.String],{x: AsyncResult[JAccessToken] => handler.handle(AsyncResultWrapper[JAccessToken,AccessToken](x, a => AccessToken(a)))})
    this
  }

  /**
    * Query an OAuth 2.0 authorization server to determine the active state of an OAuth 2.0 token and to determine
    * meta-information about this token.
    * @param token the access token (base64 string)
    * @return self
    */
  def introspectToken(token: String,handler: Handler[AsyncResult[AccessToken]]):OAuth2Auth = {
    asJava.asInstanceOf[JOAuth2Auth].introspectToken(token.asInstanceOf[java.lang.String],{x: AsyncResult[JAccessToken] => handler.handle(AsyncResultWrapper[JAccessToken,AccessToken](x, a => AccessToken(a)))})
    this
  }

  /**
    * Query an OAuth 2.0 authorization server to determine the active state of an OAuth 2.0 token and to determine
    * meta-information about this token.
    * @param token the access token (base64 string)
    * @param tokenType hint to the token type e.g.: `access_token`
    * @return self
    */
  def introspectToken(token: String,tokenType: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):OAuth2Auth = {
    asJava.asInstanceOf[JOAuth2Auth].introspectToken(token.asInstanceOf[java.lang.String],tokenType.asInstanceOf[java.lang.String],{x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Generate a redirect URL to the authN/Z backend. It only applies to auth_code flow.
    */
  def authorizeURL(params: io.vertx.core.json.JsonObject):String = {
    asJava.asInstanceOf[JOAuth2Auth].authorizeURL(params).asInstanceOf[String]
  }

  /**
    * Returns the Access Token object.
    * @param params - JSON with the options, each flow requires different options.
    */
  def getToken(params: io.vertx.core.json.JsonObject,handler: Handler[AsyncResult[AccessToken]]):Unit = {
    asJava.asInstanceOf[JOAuth2Auth].getToken(params,{x: AsyncResult[JAccessToken] => handler.handle(AsyncResultWrapper[JAccessToken,AccessToken](x, a => AccessToken(a)))})
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
  def hasJWTToken():Boolean = {
    asJava.asInstanceOf[JOAuth2Auth].hasJWTToken().asInstanceOf[Boolean]
  }

  /**
    * Returns the scope separator.
    *
    * The RFC 6749 states that a scope is expressed as a set of case-sensitive and space-delimited strings, however
    * vendors tend not to agree on this and we see the following cases being used: space, plus sign, comma.
    * @return what value was used in the configuration of the object, falling back to the default value which is a space.
    */
  def getScopeSeparator():String = {
    asJava.asInstanceOf[JOAuth2Auth].getScopeSeparator().asInstanceOf[String]
  }

 /**
   * Returns the Access Token object.
   * @param params - JSON with the options, each flow requires different options.
   * @return - The future returning the results.
   */
    def getTokenFuture(params: io.vertx.core.json.JsonObject):scala.concurrent.Future[AccessToken] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAccessToken, AccessToken](x => AccessToken(x))
    asJava.asInstanceOf[JOAuth2Auth].getToken(params,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Call OAuth2 APIs.
   * @param method HttpMethod
   * @param path target path
   * @param params parameters
   * @return future
   */
    def apiFuture(method: io.vertx.core.http.HttpMethod,path: String,params: io.vertx.core.json.JsonObject):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JOAuth2Auth].api(method,path.asInstanceOf[java.lang.String],params,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Decode a token to a [[io.vertx.scala.ext.auth.oauth2.AccessToken]] object. This is useful to handle bearer JWT tokens.
   * @param token the access token (base64 string)
   * @return A future to receive the event
   */
    def decodeTokenFuture(token: String):scala.concurrent.Future[AccessToken] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAccessToken, AccessToken](x => AccessToken(x))
    asJava.asInstanceOf[JOAuth2Auth].decodeToken(token.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Query an OAuth 2.0 authorization server to determine the active state of an OAuth 2.0 token and to determine
   * meta-information about this token.
   * @param token the access token (base64 string)
   * @return A future to receive the event
   */
    def introspectTokenFuture(token: String):scala.concurrent.Future[AccessToken] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAccessToken, AccessToken](x => AccessToken(x))
    asJava.asInstanceOf[JOAuth2Auth].introspectToken(token.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Query an OAuth 2.0 authorization server to determine the active state of an OAuth 2.0 token and to determine
   * meta-information about this token.
   * @param token the access token (base64 string)
   * @param tokenType hint to the token type e.g.: `access_token`
   * @return A future to receive the event
   */
    def introspectTokenFuture(token: String,tokenType: String):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JOAuth2Auth].introspectToken(token.asInstanceOf[java.lang.String],tokenType.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object OAuth2Auth{
  def apply(asJava: JOAuth2Auth) = new OAuth2Auth(asJava)  
  /**
    * @param vertx the Vertx instance
    * @param config the config as exported from the admin console
    * @return the auth provider
    */
  def createKeycloak(vertx: Vertx,flow: io.vertx.ext.auth.oauth2.OAuth2FlowType,config: io.vertx.core.json.JsonObject):OAuth2Auth = {
    OAuth2Auth(JOAuth2Auth.createKeycloak(vertx.asJava.asInstanceOf[JVertx],flow,config))
  }

  /**
    * Create a OAuth2 auth provider
    * @param vertx the Vertx instance
    * @param config the configsee <a href="../../../../../../../../cheatsheet/OAuth2ClientOptions.html">OAuth2ClientOptions</a>
    * @return the auth provider
    */
  def create(vertx: Vertx,flow: io.vertx.ext.auth.oauth2.OAuth2FlowType,config: OAuth2ClientOptions):OAuth2Auth = {
    OAuth2Auth(JOAuth2Auth.create(vertx.asJava.asInstanceOf[JVertx],flow,config.asJava))
  }

  /**
    * Create a OAuth2 auth provider
    * @param vertx the Vertx instance
    * @return the auth provider
    */
  def create(vertx: Vertx,flow: io.vertx.ext.auth.oauth2.OAuth2FlowType):OAuth2Auth = {
    OAuth2Auth(JOAuth2Auth.create(vertx.asJava.asInstanceOf[JVertx],flow))
  }

}
