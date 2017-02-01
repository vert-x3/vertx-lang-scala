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
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.auth.jwt.{JWTAuth => JJWTAuth}
import io.vertx.ext.web.handler.{JWTAuthHandler => JJWTAuthHandler}
import io.vertx.ext.web.handler.{AuthHandler => JAuthHandler}
import io.vertx.scala.ext.auth.jwt.JWTAuth
import io.vertx.scala.ext.web.RoutingContext
import scala.collection.JavaConverters._

/**
  * An auth handler that provides JWT Authentication support.
  */
class JWTAuthHandler(private val _asJava: Object)
    extends  AuthHandler {

  def asJava = _asJava

  /**
    * Add a required authority for this auth handler
    * @param authority the authority
    * @return a reference to this, so the API can be used fluently
    */
  override def addAuthority(authority: String): AuthHandler = {
    asJava.asInstanceOf[JJWTAuthHandler].addAuthority(authority.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Add a set of required authorities for this auth handler
    * @param authorities the set of authorities
    * @return a reference to this, so the API can be used fluently
    */
  override def addAuthorities(authorities: scala.collection.mutable.Set[String]): AuthHandler = {
    asJava.asInstanceOf[JJWTAuthHandler].addAuthorities(authorities.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  /**
    * Set the audience list
    * @param audience the audience list
    * @return a reference to this for fluency
    */
  def setAudience(audience: scala.collection.mutable.Buffer[String]): JWTAuthHandler = {
    asJava.asInstanceOf[JJWTAuthHandler].setAudience(audience.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  /**
    * Set the issuer
    * @param issuer the issuer
    * @return a reference to this for fluency
    */
  def setIssuer(issuer: String): JWTAuthHandler = {
    asJava.asInstanceOf[JJWTAuthHandler].setIssuer(issuer.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set whether expiration is ignored
    * @param ignoreExpiration whether expiration is ignored
    * @return a reference to this for fluency
    */
  def setIgnoreExpiration(ignoreExpiration: Boolean): JWTAuthHandler = {
    asJava.asInstanceOf[JJWTAuthHandler].setIgnoreExpiration(ignoreExpiration.asInstanceOf[java.lang.Boolean])
    this
  }

  override def handle(arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JJWTAuthHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object JWTAuthHandler {
  def apply(asJava: JJWTAuthHandler) = new JWTAuthHandler(asJava)  
  /**
    * Create a JWT auth handler
    * @param authProvider the auth provider to use
    * @return the auth handler
    */
  def create(authProvider: JWTAuth): JWTAuthHandler = {
    JWTAuthHandler(JJWTAuthHandler.create(authProvider.asJava.asInstanceOf[JJWTAuth]))
  }

  /**
    * Create a JWT auth handler
    * @param authProvider the auth provider to use.
    * @return the auth handler
    */
  def create(authProvider: JWTAuth, skip: String): JWTAuthHandler = {
    JWTAuthHandler(JJWTAuthHandler.create(authProvider.asJava.asInstanceOf[JJWTAuth],skip.asInstanceOf[java.lang.String]))
  }

}
