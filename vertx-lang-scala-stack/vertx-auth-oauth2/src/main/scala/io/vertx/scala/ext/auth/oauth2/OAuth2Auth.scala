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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.auth.oauth2.{AccessToken => JAccessToken}
import scala.reflect.runtime.universe._
import io.vertx.ext.auth.oauth2.OAuth2FlowType
import io.vertx.ext.auth.oauth2.{OAuth2ClientOptions => JOAuth2ClientOptions}
import io.vertx.ext.auth.oauth2.{OAuth2Auth => JOAuth2Auth}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.auth.oauth2.{OAuth2RBAC => JOAuth2RBAC}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * Factory interface for creating OAuth2 based [[io.vertx.scala.ext.auth.AuthProvider]] instances.
  */

class OAuth2Auth(private val _asJava: Object) extends AuthProvider (_asJava) {




  /**
   * Decode a token to a [[io.vertx.scala.ext.auth.oauth2.AccessToken]] object. This is useful to handle bearer JWT tokens.   * @param token the access token (base64 string)
   * @param handler A handler to receive the event
   * @return self
   */
  
  def decodeToken(token: String, handler: Handler[AsyncResult[AccessToken]]): OAuth2Auth = {
    asJava.asInstanceOf[JOAuth2Auth].decodeToken(token.asInstanceOf[java.lang.String], {x: AsyncResult[JAccessToken] => handler.handle(AsyncResultWrapper[JAccessToken, AccessToken](x, a => AccessToken(a)))})
    this
  }

  /**
   * Query an OAuth 2.0 authorization server to determine the active state of an OAuth 2.0 token and to determine
   * meta-information about this token.   * @param token the access token (base64 string)
   * @param handler A handler to receive the event
   * @return self
   */
  
  def introspectToken(token: String, handler: Handler[AsyncResult[AccessToken]]): OAuth2Auth = {
    asJava.asInstanceOf[JOAuth2Auth].introspectToken(token.asInstanceOf[java.lang.String], {x: AsyncResult[JAccessToken] => handler.handle(AsyncResultWrapper[JAccessToken, AccessToken](x, a => AccessToken(a)))})
    this
  }

  /**
   * Query an OAuth 2.0 authorization server to determine the active state of an OAuth 2.0 token and to determine
   * meta-information about this token.   * @param token the access token (base64 string)
   * @param tokenType hint to the token type e.g.: `access_token`
   * @param handler A handler to receive the event
   * @return self
   */
  
  def introspectToken(token: String, tokenType: String, handler: Handler[AsyncResult[AccessToken]]): OAuth2Auth = {
    asJava.asInstanceOf[JOAuth2Auth].introspectToken(token.asInstanceOf[java.lang.String], tokenType.asInstanceOf[java.lang.String], {x: AsyncResult[JAccessToken] => handler.handle(AsyncResultWrapper[JAccessToken, AccessToken](x, a => AccessToken(a)))})
    this
  }

  /**
   * Loads a JWK Set from the remote provider.
   *
   * When calling this method several times, the loaded JWKs are updated in the underlying JWT object.
   */
  
  def loadJWK(handler: Handler[AsyncResult[Unit]]): OAuth2Auth = {
    asJava.asInstanceOf[JOAuth2Auth].loadJWK({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }


  
  def rbacHandler(rbac: OAuth2RBAC): OAuth2Auth = {
    asJava.asInstanceOf[JOAuth2Auth].rbacHandler(rbac.asJava.asInstanceOf[JOAuth2RBAC])
    this
  }



  /**
   * Generate a redirect URL to the authN/Z backend. It only applies to auth_code flow.
   */
  def authorizeURL (params: io.vertx.core.json.JsonObject): String = {
    asJava.asInstanceOf[JOAuth2Auth].authorizeURL(params).asInstanceOf[String]
  }

  /**
   * Returns the Access Token object.   * @param params - JSON with the options, each flow requires different options.
   * @param handler - The handler returning the results.
   */
  def getToken (params: io.vertx.core.json.JsonObject, handler: Handler[AsyncResult[AccessToken]]): Unit = {
    asJava.asInstanceOf[JOAuth2Auth].getToken(params, {x: AsyncResult[JAccessToken] => handler.handle(AsyncResultWrapper[JAccessToken, AccessToken](x, a => AccessToken(a)))})
  }

  /**
   * Returns the scope separator.
   *
   * The RFC 6749 states that a scope is expressed as a set of case-sensitive and space-delimited strings, however
   * vendors tend not to agree on this and we see the following cases being used: space, plus sign, comma.   * @return what value was used in the configuration of the object, falling back to the default value which is a space.
   */
  def getScopeSeparator (): String = {
    asJava.asInstanceOf[JOAuth2Auth].getScopeSeparator().asInstanceOf[String]
  }

  /**
   * Returns the configured flow type for the Oauth2 provider.   * @return the flow type.
   */
  def getFlowType (): io.vertx.ext.auth.oauth2.OAuth2FlowType = {
    asJava.asInstanceOf[JOAuth2Auth].getFlowType()
  }


 /**
  * Like [[getToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getTokenFuture (params: io.vertx.core.json.JsonObject): scala.concurrent.Future[AccessToken] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAccessToken, AccessToken](x => AccessToken(x))
    asJava.asInstanceOf[JOAuth2Auth].getToken(params, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[decodeToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def decodeTokenFuture (token: String): scala.concurrent.Future[AccessToken] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAccessToken, AccessToken](x => AccessToken(x))
    asJava.asInstanceOf[JOAuth2Auth].decodeToken(token.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[introspectToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def introspectTokenFuture (token: String): scala.concurrent.Future[AccessToken] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAccessToken, AccessToken](x => AccessToken(x))
    asJava.asInstanceOf[JOAuth2Auth].introspectToken(token.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[introspectToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def introspectTokenFuture (token: String, tokenType: String): scala.concurrent.Future[AccessToken] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAccessToken, AccessToken](x => AccessToken(x))
    asJava.asInstanceOf[JOAuth2Auth].introspectToken(token.asInstanceOf[java.lang.String], tokenType.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[loadJWK]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def loadJWKFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JOAuth2Auth].loadJWK(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object OAuth2Auth {
  def apply(asJava: JOAuth2Auth) = new OAuth2Auth(asJava)
  
  /**
   * @param vertx the Vertx instance
   * @param config the config as exported from the admin console
   * @return the auth provider
   */
  def createKeycloak(vertx: Vertx,flow: io.vertx.ext.auth.oauth2.OAuth2FlowType,config: io.vertx.core.json.JsonObject): OAuth2Auth = {
    OAuth2Auth(JOAuth2Auth.createKeycloak(vertx.asJava.asInstanceOf[JVertx], flow, config))
  }

  /**
   * Create a OAuth2 auth provider   * @param vertx the Vertx instance
   * @param config the config see <a href="../../../../../../../../cheatsheet/OAuth2ClientOptions.html">OAuth2ClientOptions</a>
   * @return the auth provider
   */
  def create(vertx: Vertx,flow: io.vertx.ext.auth.oauth2.OAuth2FlowType,config: OAuth2ClientOptions): OAuth2Auth = {
    OAuth2Auth(JOAuth2Auth.create(vertx.asJava.asInstanceOf[JVertx], flow, config.asJava))
  }

  /**
   * Create a OAuth2 auth provider   * @param vertx the Vertx instance
   * @return the auth provider
   */
  def create(vertx: Vertx,flow: io.vertx.ext.auth.oauth2.OAuth2FlowType): OAuth2Auth = {
    OAuth2Auth(JOAuth2Auth.create(vertx.asJava.asInstanceOf[JVertx], flow))
  }

  /**
   * Create a OAuth2 auth provider   * @param vertx the Vertx instance
   * @return the auth provider
   */
  def create(vertx: Vertx): OAuth2Auth = {
    OAuth2Auth(JOAuth2Auth.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
   * Create a OAuth2 auth provider   * @param vertx the Vertx instance
   * @param config the config see <a href="../../../../../../../../cheatsheet/OAuth2ClientOptions.html">OAuth2ClientOptions</a>
   * @return the auth provider
   */
  def create(vertx: Vertx,config: OAuth2ClientOptions): OAuth2Auth = {
    OAuth2Auth(JOAuth2Auth.create(vertx.asJava.asInstanceOf[JVertx], config.asJava))
  }

}
