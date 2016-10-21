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
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.scala.ext.auth.jwt.JWTAuth

/**
  * An auth handler that provides JWT Authentication support.
  */
class JWTAuthHandler(private val _asJava: io.vertx.ext.web.handler.JWTAuthHandler) 
    extends io.vertx.scala.ext.web.handler.AuthHandler {

  def asJava: io.vertx.ext.web.handler.JWTAuthHandler = _asJava

  def handle(arg0: io.vertx.scala.ext.web.RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[io.vertx.ext.web.RoutingContext])
  }

  /**
    * Add a required authority for this auth handler
    * @param authority the authority
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthority(authority: String): io.vertx.scala.ext.web.handler.AuthHandler = {
    _asJava.addAuthority(authority)
    this
  }

  /**
    * Add a set of required authorities for this auth handler
    * @param authorities the set of authorities
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthorities(authorities: Set[String]): io.vertx.scala.ext.web.handler.AuthHandler = {
    _asJava.addAuthorities(authorities.map(x => if (x == null) null else x:java.lang.String).asJava)
    this
  }

  /**
    * Set the audience list
    * @param audience the audience list
    * @return a reference to this for fluency
    */
  def setAudience(audience: scala.collection.mutable.Buffer[String]): io.vertx.scala.ext.web.handler.JWTAuthHandler = {
    _asJava.setAudience(audience.map(x => if (x == null) null else x:java.lang.String).asJava)
    this
  }

  /**
    * Set the issuer
    * @param issuer the issuer
    * @return a reference to this for fluency
    */
  def setIssuer(issuer: String): io.vertx.scala.ext.web.handler.JWTAuthHandler = {
    _asJava.setIssuer(issuer)
    this
  }

  /**
    * Set whether expiration is ignored
    * @param ignoreExpiration whether expiration is ignored
    * @return a reference to this for fluency
    */
  def setIgnoreExpiration(ignoreExpiration: Boolean): io.vertx.scala.ext.web.handler.JWTAuthHandler = {
    _asJava.setIgnoreExpiration(ignoreExpiration)
    this
  }

}

object JWTAuthHandler {

  def apply(_asJava: io.vertx.ext.web.handler.JWTAuthHandler): io.vertx.scala.ext.web.handler.JWTAuthHandler =
    new io.vertx.scala.ext.web.handler.JWTAuthHandler(_asJava)

  def create(authProvider: io.vertx.scala.ext.auth.jwt.JWTAuth): io.vertx.scala.ext.web.handler.JWTAuthHandler = {
    JWTAuthHandler.apply(io.vertx.ext.web.handler.JWTAuthHandler.create(authProvider.asJava.asInstanceOf[io.vertx.ext.auth.jwt.JWTAuth]))
  }

  def create(authProvider: io.vertx.scala.ext.auth.jwt.JWTAuth, skip: String): io.vertx.scala.ext.web.handler.JWTAuthHandler = {
    JWTAuthHandler.apply(io.vertx.ext.web.handler.JWTAuthHandler.create(authProvider.asJava.asInstanceOf[io.vertx.ext.auth.jwt.JWTAuth], skip))
  }

}
