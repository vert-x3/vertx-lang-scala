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
import io.vertx.scala.ext.auth.htdigest.HtdigestAuth
import io.vertx.ext.auth.htdigest.{HtdigestAuth => JHtdigestAuth}
import io.vertx.ext.web.handler.{DigestAuthHandler => JDigestAuthHandler}
import io.vertx.ext.web.handler.{AuthHandler => JAuthHandler}
import io.vertx.scala.ext.web.RoutingContext
import scala.collection.JavaConverters._

/**
  * An auth handler that provides HTTP Basic Authentication support.
  */
class DigestAuthHandler(private val _asJava: Object)
    extends  AuthHandler {

  def asJava = _asJava

  /**
    * Add a required authority for this auth handler
    * @param authority the authority
    * @return a reference to this, so the API can be used fluently
    */
  override def addAuthority(authority: String): AuthHandler = {
    asJava.asInstanceOf[JDigestAuthHandler].addAuthority(authority.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Add a set of required authorities for this auth handler
    * @param authorities the set of authorities
    * @return a reference to this, so the API can be used fluently
    */
  override def addAuthorities(authorities: scala.collection.mutable.Set[String]): AuthHandler = {
    asJava.asInstanceOf[JDigestAuthHandler].addAuthorities(authorities.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  override def handle(arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JDigestAuthHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object DigestAuthHandler{
  def apply(asJava: JDigestAuthHandler) = new DigestAuthHandler(asJava)  
  /**
    * Create a digest auth handler
    * @param authProvider the auth provider to use
    * @return the auth handler
    */
  def create(authProvider: HtdigestAuth): DigestAuthHandler = {
    DigestAuthHandler(JDigestAuthHandler.create(authProvider.asJava.asInstanceOf[JHtdigestAuth]))
  }

  /**
    * Create a digest auth handler, specifying the expire timeout for nonces.
    * @param authProvider the auth service to use
    * @param nonceExpireTimeout the nonce expire timeout in milliseconds.
    * @return the auth handler
    */
  def create(authProvider: HtdigestAuth,nonceExpireTimeout: Long): DigestAuthHandler = {
    DigestAuthHandler(JDigestAuthHandler.create(authProvider.asJava.asInstanceOf[JHtdigestAuth],nonceExpireTimeout.asInstanceOf[java.lang.Long]))
  }

}
