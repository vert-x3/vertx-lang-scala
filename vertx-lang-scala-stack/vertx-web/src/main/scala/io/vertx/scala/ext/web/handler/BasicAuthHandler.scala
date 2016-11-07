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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.web.handler.{BasicAuthHandler => JBasicAuthHandler}
import io.vertx.ext.web.handler.{AuthHandler => JAuthHandler}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.scala.ext.auth.AuthProvider

/**
  * An auth handler that provides HTTP Basic Authentication support.
  */
class BasicAuthHandler(private val _asJava: JBasicAuthHandler) 
    extends AuthHandler {

  def asJava: JBasicAuthHandler = _asJava

  def handle(arg0: RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

  /**
    * Add a required authority for this auth handler
    * @param authority the authority
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthority(authority: String): AuthHandler = {
    _asJava.addAuthority(authority)
    this
  }

  /**
    * Add a set of required authorities for this auth handler
    * @param authorities the set of authorities
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthorities(authorities: Set[String]): AuthHandler = {
    _asJava.addAuthorities(authorities.map(x => if (x == null) null else x:java.lang.String).asJava)
    this
  }

}

object BasicAuthHandler {

  def apply(_asJava: JBasicAuthHandler): BasicAuthHandler =
    new BasicAuthHandler(_asJava)

  def create(authProvider: AuthProvider): AuthHandler = {
    AuthHandler.apply(io.vertx.ext.web.handler.BasicAuthHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider]))
  }

  def create(authProvider: AuthProvider, realm: String): AuthHandler = {
    AuthHandler.apply(io.vertx.ext.web.handler.BasicAuthHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider], realm))
  }

}
