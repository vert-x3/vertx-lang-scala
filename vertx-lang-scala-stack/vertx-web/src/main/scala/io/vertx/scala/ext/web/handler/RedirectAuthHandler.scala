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
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.ext.web.handler.{RedirectAuthHandler => JRedirectAuthHandler}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.web.handler.{AuthHandler => JAuthHandler}
import io.vertx.scala.ext.web.RoutingContext
import scala.collection.JavaConverters._

/**
  * An auth handler that's used to handle auth by redirecting user to a custom login page.
  */
class RedirectAuthHandler(private val _asJava: Object) 
    extends  AuthHandler {

  def asJava = _asJava

  /**
    * Add a required authority for this auth handler
    * @param authority the authority
    * @return a reference to this, so the API can be used fluently
    */
  override def addAuthority(authority: String):AuthHandler = {
    asJava.asInstanceOf[JRedirectAuthHandler].addAuthority(authority.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Add a set of required authorities for this auth handler
    * @param authorities the set of authorities
    * @return a reference to this, so the API can be used fluently
    */
  override def addAuthorities(authorities: scala.collection.mutable.Set[String]):AuthHandler = {
    asJava.asInstanceOf[JRedirectAuthHandler].addAuthorities(authorities.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  override def handle(arg0: RoutingContext):Unit = {
    asJava.asInstanceOf[JRedirectAuthHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object RedirectAuthHandler{
  def apply(asJava: JRedirectAuthHandler) = new RedirectAuthHandler(asJava)  
  /**
    * Create a handler
    * @param authProvider the auth service to use
    * @return the handler
    */
  def create(authProvider: AuthProvider):AuthHandler = {
    AuthHandler(JRedirectAuthHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider]))
  }

  /**
    * Create a handler
    * @param authProvider the auth service to use
    * @param loginRedirectURL the url to redirect the user to
    * @return the handler
    */
  def create(authProvider: AuthProvider,loginRedirectURL: String):AuthHandler = {
    AuthHandler(JRedirectAuthHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider],loginRedirectURL.asInstanceOf[java.lang.String]))
  }

  /**
    * Create a handler
    * @param authProvider the auth service to use
    * @param loginRedirectURL the url to redirect the user to
    * @param returnURLParam the name of param used to store return url information in session
    * @return the handler
    */
  def create(authProvider: AuthProvider,loginRedirectURL: String,returnURLParam: String):AuthHandler = {
    AuthHandler(JRedirectAuthHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider],loginRedirectURL.asInstanceOf[java.lang.String],returnURLParam.asInstanceOf[java.lang.String]))
  }

}
