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
import io.vertx.ext.auth.oauth2.{OAuth2RBAC => JOAuth2RBAC}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Functional interface that allows users to implement custom RBAC verifiers for OAuth2/OpenId Connect.
  *
  * Users are to implement the <code>isAuthorized</code> method to verify authorities. For provides that do not
  * export the permissions/roles in the token, this interface allows you to communicate with 3rd party services
  * such as graph APIs to collect the required data.
  *
  * The contract is that once an authority is checked for a given user, it's value is cached during the execution
  * of the request. If a user is stored to a persistent storage, or the token is introspected, the cache is cleared
  * and a new call will be handled to the implementation.

  */

class OAuth2RBAC(private val _asJava: Object) {
  def asJava = _asJava





  /**
   * This method should verify if the user has the given authority and return either a boolean value or an error.
   *
   * Note that false and errors are not the same. A user might not have a given authority but that doesn't mean that
   * there was an error during the call.   * @param user the given user to assert on
   * @param authority the authority to lookup
   * @param handler the result handler.
   */
  def isAuthorized (user: AccessToken, authority: String, handler: Handler[AsyncResult[Boolean]]): Unit = {
    asJava.asInstanceOf[JOAuth2RBAC].isAuthorized(user.asJava.asInstanceOf[JAccessToken], authority.asInstanceOf[java.lang.String], {x: AsyncResult[java.lang.Boolean] => handler.handle(AsyncResultWrapper[java.lang.Boolean, Boolean](x, a => a.asInstanceOf[Boolean]))})
  }


 /**
  * Like [[isAuthorized]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def isAuthorizedFuture (user: AccessToken, authority: String): scala.concurrent.Future[Boolean] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JOAuth2RBAC].isAuthorized(user.asJava.asInstanceOf[JAccessToken], authority.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object OAuth2RBAC {
  def apply(asJava: JOAuth2RBAC) = new OAuth2RBAC(asJava)
  
}
