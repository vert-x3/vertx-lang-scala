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
import io.vertx.ext.auth.oauth2.{OAuth2Response => JOAuth2Response}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.ext.auth.User
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpMethod
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * AccessToken extension to the User interface
  */

class AccessToken(private val _asJava: Object) extends User (_asJava) {

  private var cached_0: Option[io.vertx.core.json.JsonObject] = None
  private var cached_1: Option[io.vertx.core.json.JsonObject] = None
  private var cached_2: Option[io.vertx.core.json.JsonObject] = None


  /**
   * The Access Token if present parsed as a JsonObject   * @return JSON
   */
  def accessToken(): io.vertx.core.json.JsonObject = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JAccessToken].accessToken()
      cached_0 = Some(tmp)
    }
    cached_0.get
  }

  /**
   * The Refresh Token if present parsed as a JsonObject   * @return JSON
   */
  def refreshToken(): io.vertx.core.json.JsonObject = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JAccessToken].refreshToken()
      cached_1 = Some(tmp)
    }
    cached_1.get
  }

  /**
   * The Id Token if present parsed as a JsonObject   * @return JSON
   */
  def idToken(): io.vertx.core.json.JsonObject = {
    if (cached_2 == None) {
      val tmp = asJava.asInstanceOf[JAccessToken].idToken()
      cached_2 = Some(tmp)
    }
    cached_2.get
  }



  
  def setTrustJWT(trust: Boolean): AccessToken = {
    asJava.asInstanceOf[JAccessToken].setTrustJWT(trust.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Refresh the access token   * @param callback - The callback function returning the results.
   */
  
  def refresh(callback: Handler[AsyncResult[Unit]]): AccessToken = {
    asJava.asInstanceOf[JAccessToken].refresh({x: AsyncResult[Void] => callback.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Revoke access or refresh token   * @param token_type - A String containing the type of token to revoke. Should be either "access_token" or "refresh_token".
   * @param callback - The callback function returning the results.
   */
  
  def revoke(token_type: String, callback: Handler[AsyncResult[Unit]]): AccessToken = {
    asJava.asInstanceOf[JAccessToken].revoke(token_type.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => callback.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Revoke refresh token and calls the logout endpoint. This is a openid-connect extension and might not be
   * available on all providers.   * @param callback - The callback function returning the results.
   */
  
  def logout(callback: Handler[AsyncResult[Unit]]): AccessToken = {
    asJava.asInstanceOf[JAccessToken].logout({x: AsyncResult[Void] => callback.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Introspect access token. This is an OAuth2 extension that allow to verify if an access token is still valid.   * @param callback - The callback function returning the results.
   */
  
  def introspect(callback: Handler[AsyncResult[Unit]]): AccessToken = {
    asJava.asInstanceOf[JAccessToken].introspect({x: AsyncResult[Void] => callback.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Introspect access token. This is an OAuth2 extension that allow to verify if an access token is still valid.   * @param tokenType - A String containing the type of token to revoke. Should be either "access_token" or "refresh_token".
   * @param callback - The callback function returning the results.
   */
  
  def introspect(tokenType: String, callback: Handler[AsyncResult[Unit]]): AccessToken = {
    asJava.asInstanceOf[JAccessToken].introspect(tokenType.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => callback.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Load the user info as per OIDC spec.   * @param callback - The callback function returning the results.
   */
  
  def userInfo(callback: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): AccessToken = {
    asJava.asInstanceOf[JAccessToken].userInfo({x: AsyncResult[JsonObject] => callback.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
   * Fetches a JSON resource using this Access Token.   * @param resource - the resource to fetch.
   * @param callback - The callback function returning the results.
   */
  
  def fetch(resource: String, callback: Handler[AsyncResult[OAuth2Response]]): AccessToken = {
    asJava.asInstanceOf[JAccessToken].fetch(resource.asInstanceOf[java.lang.String], {x: AsyncResult[JOAuth2Response] => callback.handle(AsyncResultWrapper[JOAuth2Response, OAuth2Response](x, a => OAuth2Response(a)))})
    this
  }

  /**
   * Fetches a JSON resource using this Access Token.   * @param method - the HTTP method to user.
   * @param resource - the resource to fetch.
   * @param headers - extra headers to pass to the request.
   * @param payload - payload to send to the server.
   * @param callback - The callback function returning the results.
   */
  
  def fetch(method: io.vertx.core.http.HttpMethod, resource: String, headers: io.vertx.core.json.JsonObject, payload: io.vertx.core.buffer.Buffer, callback: Handler[AsyncResult[OAuth2Response]]): AccessToken = {
    asJava.asInstanceOf[JAccessToken].fetch(method, resource.asInstanceOf[java.lang.String], headers, payload, {x: AsyncResult[JOAuth2Response] => callback.handle(AsyncResultWrapper[JOAuth2Response, OAuth2Response](x, a => OAuth2Response(a)))})
    this
  }



  /**
   * Check if the access token is expired or not.
   */
  def expired (): Boolean = {
    asJava.asInstanceOf[JAccessToken].expired().asInstanceOf[Boolean]
  }

  /**
   * The RAW String if available for the Access Token   * @return String
   */
  def opaqueAccessToken (): String = {
    asJava.asInstanceOf[JAccessToken].opaqueAccessToken().asInstanceOf[String]
  }

  /**
   * The RAW String if available for the Refresh Token   * @return String
   */
  def opaqueRefreshToken (): String = {
    asJava.asInstanceOf[JAccessToken].opaqueRefreshToken().asInstanceOf[String]
  }

  /**
   * The RAW String if available for the Id Token   * @return String
   */
  def opaqueIdToken (): String = {
    asJava.asInstanceOf[JAccessToken].opaqueIdToken().asInstanceOf[String]
  }


  def tokenType (): String = {
    asJava.asInstanceOf[JAccessToken].tokenType().asInstanceOf[String]
  }


 /**
  * Like [[refresh]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def refreshFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAccessToken].refresh(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[revoke]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def revokeFuture (token_type: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAccessToken].revoke(token_type.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[logout]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def logoutFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAccessToken].logout(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[introspect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def introspectFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAccessToken].introspect(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[introspect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def introspectFuture (tokenType: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAccessToken].introspect(tokenType.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[userInfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def userInfoFuture (): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JAccessToken].userInfo(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[fetch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def fetchFuture (resource: String): scala.concurrent.Future[OAuth2Response] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JOAuth2Response, OAuth2Response](x => OAuth2Response(x))
    asJava.asInstanceOf[JAccessToken].fetch(resource.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[fetch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def fetchFuture (method: io.vertx.core.http.HttpMethod, resource: String, headers: io.vertx.core.json.JsonObject, payload: io.vertx.core.buffer.Buffer): scala.concurrent.Future[OAuth2Response] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JOAuth2Response, OAuth2Response](x => OAuth2Response(x))
    asJava.asInstanceOf[JAccessToken].fetch(method, resource.asInstanceOf[java.lang.String], headers, payload, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object AccessToken {
  def apply(asJava: JAccessToken) = new AccessToken(asJava)
  
}
