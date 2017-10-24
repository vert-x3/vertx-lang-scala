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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.web.handler.{AuthHandler => JAuthHandler}
import io.vertx.scala.ext.web.RoutingContext
import scala.collection.JavaConverters._
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.scala.ext.auth.User
import io.vertx.ext.web.handler.{RedirectAuthHandler => JRedirectAuthHandler}
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * An auth handler that's used to handle auth by redirecting user to a custom login page.
  */
class RedirectAuthHandler(private val _asJava: Object)
    extends  AuthHandler 
    with io.vertx.core.Handler[RoutingContext]  {

  def asJava = _asJava


  /**
    * Add a required authority for this auth handler
    * @param authority the authority
    * @return a reference to this, so the API can be used fluently
    */
  override def addAuthority(authority: String): AuthHandler = {
    asJava.asInstanceOf[JRedirectAuthHandler].addAuthority(authority.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Add a set of required authorities for this auth handler
    * @param authorities the set of authorities
    * @return a reference to this, so the API can be used fluently
    */
  override def addAuthorities(authorities: scala.collection.mutable.Set[String]): AuthHandler = {
    asJava.asInstanceOf[JRedirectAuthHandler].addAuthorities(authorities.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  override def handle(arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JRedirectAuthHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

  /**
    * Parses the credentials from the request into a JsonObject. The implementation should
    * be able to extract the required info for the auth provider in the format the provider
    * expects.
    * @param context the routing context
    * @param handler the handler to be called once the information is available.
    */
  override def parseCredentials(context: RoutingContext, handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JRedirectAuthHandler].parseCredentials(context.asJava.asInstanceOf[JRoutingContext], {x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  /**
    * Authorizes the given user against all added authorities.
    * @param user a user.
    * @param handler the handler for the result.
    */
  override def authorize(user: User, handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRedirectAuthHandler].authorize(user.asJava.asInstanceOf[JUser], {x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

 /**
   * Like [[parseCredentials]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  override def parseCredentialsFuture(context: RoutingContext): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JRedirectAuthHandler].parseCredentials(context.asJava.asInstanceOf[JRoutingContext], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[authorize]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  override def authorizeFuture(user: User): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedirectAuthHandler].authorize(user.asJava.asInstanceOf[JUser], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object RedirectAuthHandler {
  def apply(asJava: JRedirectAuthHandler) = new RedirectAuthHandler(asJava)  
  /**
    * Create a handler
    * @param authProvider the auth service to use
    * @return the handler
    */
  def create(authProvider: AuthProvider): AuthHandler = {
    AuthHandler(JRedirectAuthHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider]))
  }

  /**
    * Create a handler
    * @param authProvider the auth service to use
    * @param loginRedirectURL the url to redirect the user to
    * @return the handler
    */
  def create(authProvider: AuthProvider, loginRedirectURL: String): AuthHandler = {
    AuthHandler(JRedirectAuthHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider], loginRedirectURL.asInstanceOf[java.lang.String]))
  }

  /**
    * Create a handler
    * @param authProvider the auth service to use
    * @param loginRedirectURL the url to redirect the user to
    * @param returnURLParam the name of param used to store return url information in session
    * @return the handler
    */
  def create(authProvider: AuthProvider, loginRedirectURL: String, returnURLParam: String): AuthHandler = {
    AuthHandler(JRedirectAuthHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider], loginRedirectURL.asInstanceOf[java.lang.String], returnURLParam.asInstanceOf[java.lang.String]))
  }

}
