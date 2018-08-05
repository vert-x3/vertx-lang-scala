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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.ext.web.Route
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.web.handler.{OAuth2AuthHandler => JOAuth2AuthHandler}
import io.vertx.scala.ext.auth.oauth2.OAuth2Auth
import scala.reflect.runtime.universe._
import io.vertx.ext.web.handler.{AuthHandler => JAuthHandler}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.ext.web.{Route => JRoute}
import scala.collection.JavaConverters._
import io.vertx.ext.auth.oauth2.{OAuth2Auth => JOAuth2Auth}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.ext.auth.User
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * An auth handler that provides OAuth2 Authentication support. This handler is suitable for AuthCode flows.
  */

class OAuth2AuthHandler(private val _asJava: Object) extends AuthHandler with io.vertx.core.Handler[RoutingContext] {
  def asJava = _asJava



  /**
   * Add a required authority for this auth handler   * @param authority the authority
   * @return a reference to this, so the API can be used fluently
   */
  override 
  def addAuthority(authority: String): AuthHandler = {
    asJava.asInstanceOf[JOAuth2AuthHandler].addAuthority(authority.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Add a set of required authorities for this auth handler   * @param authorities the set of authorities
   * @return a reference to this, so the API can be used fluently
   */
  override 
  def addAuthorities(authorities: scala.collection.mutable.Set[String]): AuthHandler = {
    asJava.asInstanceOf[JOAuth2AuthHandler].addAuthorities(authorities.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  /**
   * Extra parameters needed to be passed while requesting a token.   * @param extraParams extra optional parameters.
   * @return self
   */
  
  def extraParams(extraParams: io.vertx.core.json.JsonObject): OAuth2AuthHandler = {
    asJava.asInstanceOf[JOAuth2AuthHandler].extraParams(extraParams)
    this
  }

  /**
   * add the callback handler to a given route.   * @param route a given route e.g.: `/callback`
   * @return self
   */
  
  def setupCallback(route: Route): OAuth2AuthHandler = {
    asJava.asInstanceOf[JOAuth2AuthHandler].setupCallback(route.asJava.asInstanceOf[JRoute])
    this
  }




  override def handle (arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JOAuth2AuthHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

  /**
   * Parses the credentials from the request into a JsonObject. The implementation should
   * be able to extract the required info for the auth provider in the format the provider
   * expects.   * @param context the routing context
   * @param handler the handler to be called once the information is available.
   */
  override def parseCredentials (context: RoutingContext, handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JOAuth2AuthHandler].parseCredentials(context.asJava.asInstanceOf[JRoutingContext], {x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  /**
   * Authorizes the given user against all added authorities.   * @param user a user.
   * @param handler the handler for the result.
   */
  override def authorize (user: User, handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JOAuth2AuthHandler].authorize(user.asJava.asInstanceOf[JUser], {x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }


 /**
  * Like [[parseCredentials]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def parseCredentialsFuture (context: RoutingContext): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JOAuth2AuthHandler].parseCredentials(context.asJava.asInstanceOf[JRoutingContext], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[authorize]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def authorizeFuture (user: User): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JOAuth2AuthHandler].authorize(user.asJava.asInstanceOf[JUser], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object OAuth2AuthHandler {
  def apply(asJava: JOAuth2AuthHandler) = new OAuth2AuthHandler(asJava)
  
  /**
   * Create a OAuth2 auth handler with host pinning   * @param authProvider the auth provider to use
   * @param callbackURL the callback URL you entered in your provider admin console, usually it should be something like: `https://myserver:8888/callback`
   * @return the auth handler
   */
  def create(authProvider: OAuth2Auth,callbackURL: String): OAuth2AuthHandler = {
    OAuth2AuthHandler(JOAuth2AuthHandler.create(authProvider.asJava.asInstanceOf[JOAuth2Auth], callbackURL.asInstanceOf[java.lang.String]))
  }

  /**
   * Create a OAuth2 auth handler without host pinning.
   * Most providers will not look to the redirect url but always redirect to
   * the preconfigured callback. So this factory does not provide a callback url.   * @param authProvider the auth provider to use
   * @return the auth handler
   */
  def create(authProvider: OAuth2Auth): OAuth2AuthHandler = {
    OAuth2AuthHandler(JOAuth2AuthHandler.create(authProvider.asJava.asInstanceOf[JOAuth2Auth]))
  }

}
