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
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import scala.reflect.runtime.universe._
import io.vertx.ext.auth.jwt.{JWTAuth => JJWTAuth}
import io.vertx.ext.web.handler.{JWTAuthHandler => JJWTAuthHandler}
import io.vertx.ext.web.handler.{AuthHandler => JAuthHandler}
import io.vertx.scala.ext.web.RoutingContext
import scala.collection.JavaConverters._
import io.vertx.lang.scala.Converter._
import io.vertx.scala.ext.auth.User
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.scala.ext.auth.jwt.JWTAuth
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * An auth handler that provides JWT Authentication support.
  */

class JWTAuthHandler(private val _asJava: Object) extends AuthHandler with io.vertx.core.Handler[RoutingContext] {
  def asJava = _asJava



  /**
   * Add a required authority for this auth handler   * @param authority the authority
   * @return a reference to this, so the API can be used fluently
   */
  override 
  def addAuthority(authority: String): AuthHandler = {
    asJava.asInstanceOf[JJWTAuthHandler].addAuthority(authority.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Add a set of required authorities for this auth handler   * @param authorities the set of authorities
   * @return a reference to this, so the API can be used fluently
   */
  override 
  def addAuthorities(authorities: scala.collection.mutable.Set[String]): AuthHandler = {
    asJava.asInstanceOf[JJWTAuthHandler].addAuthorities(authorities.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  /**
   * Set the audience list   * @param audience the audience list
   * @return a reference to this for fluency
   */
  
  def setAudience(audience: scala.collection.mutable.Buffer[String]): JWTAuthHandler = {
    asJava.asInstanceOf[JJWTAuthHandler].setAudience(audience.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  /**
   * Set the issuer   * @param issuer the issuer
   * @return a reference to this for fluency
   */
  
  def setIssuer(issuer: String): JWTAuthHandler = {
    asJava.asInstanceOf[JJWTAuthHandler].setIssuer(issuer.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Set whether expiration is ignored   * @param ignoreExpiration whether expiration is ignored
   * @return a reference to this for fluency
   */
  
  def setIgnoreExpiration(ignoreExpiration: Boolean): JWTAuthHandler = {
    asJava.asInstanceOf[JJWTAuthHandler].setIgnoreExpiration(ignoreExpiration.asInstanceOf[java.lang.Boolean])
    this
  }




  override def handle (arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JJWTAuthHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

  /**
   * Parses the credentials from the request into a JsonObject. The implementation should
   * be able to extract the required info for the auth provider in the format the provider
   * expects.   * @param context the routing context
   * @param handler the handler to be called once the information is available.
   */
  override def parseCredentials (context: RoutingContext, handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JJWTAuthHandler].parseCredentials(context.asJava.asInstanceOf[JRoutingContext], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JsonObject]]{def handle(x: AsyncResult[JsonObject]) {handler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))}}))
  }

  /**
   * Authorizes the given user against all added authorities.   * @param user a user.
   * @param handler the handler for the result.
   */
  override def authorize (user: User, handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JJWTAuthHandler].authorize(user.asJava.asInstanceOf[JUser], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


 /**
  * Like [[parseCredentials]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def parseCredentialsFuture (context: RoutingContext): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JJWTAuthHandler].parseCredentials(context.asJava.asInstanceOf[JRoutingContext], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[authorize]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def authorizeFuture (user: User): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JJWTAuthHandler].authorize(user.asJava.asInstanceOf[JUser], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object JWTAuthHandler {
  def apply(asJava: JJWTAuthHandler) = new JWTAuthHandler(asJava)

  /**
   * Create a JWT auth handler   * @param authProvider the auth provider to use
   * @return the auth handler
   */
  def create(authProvider: JWTAuth): JWTAuthHandler = {
    JWTAuthHandler(JJWTAuthHandler.create(authProvider.asJava.asInstanceOf[JJWTAuth]))//2 create
  }

  /**
   * Create a JWT auth handler   * @param authProvider the auth provider to use.
   * @return the auth handler
   */
  def create(authProvider: JWTAuth,skip: String): JWTAuthHandler = {
    JWTAuthHandler(JJWTAuthHandler.create(authProvider.asJava.asInstanceOf[JJWTAuth], skip.asInstanceOf[java.lang.String]))//2 create
  }

}
