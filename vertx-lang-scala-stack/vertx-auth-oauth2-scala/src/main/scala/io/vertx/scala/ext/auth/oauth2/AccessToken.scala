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
import io.vertx.ext.auth.oauth2.{AccessToken => JAccessToken}
    import io.vertx.ext.auth.{User => JUser}
import io.vertx.scala.ext.auth.User
import io.vertx.ext.auth.{User => JUser}
    import io.vertx.core.json.JsonObject
        import io.vertx.ext.auth.oauth2.{AccessToken => JAccessToken}
  import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}

/**
  * AccessToken extension to the User interface
  */
class AccessToken(private val _asJava: JAccessToken) {

  def asJava: JAccessToken = _asJava

  /**
    * Check if the access token is expired or not.
    */
  def expired(): Boolean = {
    _asJava.expired()
  }

  /**
    * Refresh the access token
    * @return - The callback function returning the results.
    */
  def refreshFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.refresh(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Revoke access or refresh token
    * @param token_type - A String containing the type of token to revoke. Should be either "access_token" or "refresh_token".
    * @return - The callback function returning the results.
    */
  def revokeFuture(token_type: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.revoke(token_type, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Revoke refresh token and calls the logout endpoint. This is a openid-connect extension and might not be
    * available on all providers.
    * @return - The callback function returning the results.
    */
  def logoutFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.logout(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object AccessToken {

  def apply(_asJava: JAccessToken): AccessToken =
    new AccessToken(_asJava)

}
