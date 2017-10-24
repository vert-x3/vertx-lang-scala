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
import io.vertx.scala.ext.auth.User
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.web.handler.{AuthHandler => JAuthHandler}
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler

/**
  * Base interface for auth handlers.
  * 
  * An auth handler allows your application to provide authentication/authorisation support.
  * 
  * Auth handler requires a [[io.vertx.scala.ext.web.handler.SessionHandler]] to be on the routing chain before it.
  */
trait AuthHandler
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava: java.lang.Object

  override def handle(arg0: RoutingContext): Unit

  /**
    * Add a required authority for this auth handler
    * @param authority the authority
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthority(authority: String): AuthHandler

  /**
    * Add a set of required authorities for this auth handler
    * @param authorities the set of authorities
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthorities(authorities: scala.collection.mutable.Set[String]): AuthHandler

  /**
    * Parses the credentials from the request into a JsonObject. The implementation should
    * be able to extract the required info for the auth provider in the format the provider
    * expects.
    * @param context the routing context
    * @param handler the handler to be called once the information is available.
    */
  def parseCredentials(context: RoutingContext, handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit

  /**
    * Authorizes the given user against all added authorities.
    * @param user a user.
    * @param handler the handler for the result.
    */
  def authorize(user: User, handler: Handler[AsyncResult[Unit]]): Unit

 /**
   * Like [[parseCredentials]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def parseCredentialsFuture(context: RoutingContext): scala.concurrent.Future[io.vertx.core.json.JsonObject]
 /**
   * Like [[authorize]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def authorizeFuture(user: User): scala.concurrent.Future[Unit]
}

object AuthHandler {
  def apply(asJava: JAuthHandler): AuthHandler = new AuthHandlerImpl(asJava)
    private class AuthHandlerImpl(private val _asJava: Object) extends AuthHandler {

      def asJava = _asJava


  /**
    * Add a required authority for this auth handler
    * @param authority the authority
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthority(authority: String): AuthHandler = {
    asJava.asInstanceOf[JAuthHandler].addAuthority(authority.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Add a set of required authorities for this auth handler
    * @param authorities the set of authorities
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthorities(authorities: scala.collection.mutable.Set[String]): AuthHandler = {
    asJava.asInstanceOf[JAuthHandler].addAuthorities(authorities.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  override def handle(arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JAuthHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

  /**
    * Parses the credentials from the request into a JsonObject. The implementation should
    * be able to extract the required info for the auth provider in the format the provider
    * expects.
    * @param context the routing context
    * @param handler the handler to be called once the information is available.
    */
  def parseCredentials(context: RoutingContext, handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JAuthHandler].parseCredentials(context.asJava.asInstanceOf[JRoutingContext], {x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  /**
    * Authorizes the given user against all added authorities.
    * @param user a user.
    * @param handler the handler for the result.
    */
  def authorize(user: User, handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JAuthHandler].authorize(user.asJava.asInstanceOf[JUser], {x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

 /**
   * Like [[parseCredentials]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def parseCredentialsFuture(context: RoutingContext): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JAuthHandler].parseCredentials(context.asJava.asInstanceOf[JRoutingContext], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[authorize]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def authorizeFuture(user: User): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAuthHandler].authorize(user.asJava.asInstanceOf[JUser], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}
}
