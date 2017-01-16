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
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.scala.ext.auth.User
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.auth.oauth2.{AccessToken => JAccessToken}
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * AccessToken extension to the User interface
  */
class AccessToken(private val _asJava: Object) 
    extends User(_asJava)  {


  /**
    * Refresh the access token
    */
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def refresh(callback: Handler[AsyncResult[Unit]]):AccessToken = {
    asJava.asInstanceOf[JAccessToken].refresh({x: AsyncResult[Void] => callback.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Revoke access or refresh token
    * @param token_type - A String containing the type of token to revoke. Should be either "access_token" or "refresh_token".
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def revoke(token_type: String,callback: Handler[AsyncResult[Unit]]):AccessToken = {
    asJava.asInstanceOf[JAccessToken].revoke(token_type.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => callback.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Revoke refresh token and calls the logout endpoint. This is a openid-connect extension and might not be
    * available on all providers.
    */
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def logout(callback: Handler[AsyncResult[Unit]]):AccessToken = {
    asJava.asInstanceOf[JAccessToken].logout({x: AsyncResult[Void] => callback.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Introspect access token. This is an OAuth2 extension that allow to verify if an access token is still valid.
    */
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def introspect(callback: Handler[AsyncResult[Unit]]):AccessToken = {
    asJava.asInstanceOf[JAccessToken].introspect({x: AsyncResult[Void] => callback.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Check if the access token is expired or not.
    */
  def expired():Boolean = {
    asJava.asInstanceOf[JAccessToken].expired().asInstanceOf[Boolean]
  }

 /**
   * Refresh the access token
   * @return - The callback function returning the results.
   */
  def refreshFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAccessToken].refresh(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Revoke access or refresh token
   * @param token_type - A String containing the type of token to revoke. Should be either "access_token" or "refresh_token".
   * @return - The callback function returning the results.
   */
  def revokeFuture(token_type: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAccessToken].revoke(token_type.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Revoke refresh token and calls the logout endpoint. This is a openid-connect extension and might not be
   * available on all providers.
   * @return - The callback function returning the results.
   */
  def logoutFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAccessToken].logout(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Introspect access token. This is an OAuth2 extension that allow to verify if an access token is still valid.
   * @return - The callback function returning the results.
   */
  def introspectFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAccessToken].introspect(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object AccessToken{
  def apply(asJava: JAccessToken) = new AccessToken(asJava)  
}