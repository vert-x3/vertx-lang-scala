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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.web.handler.{AuthHandler => JAuthHandler}
import io.vertx.scala.ext.web.RoutingContext
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

  override def handle(arg0: RoutingContext):Unit

  /**
    * Add a required authority for this auth handler
    * @param authority the authority
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthority(authority: String):AuthHandler

  /**
    * Add a set of required authorities for this auth handler
    * @param authorities the set of authorities
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthorities(authorities: scala.collection.mutable.Set[String]):AuthHandler

}

object AuthHandler{
  def apply(asJava: JAuthHandler):AuthHandler = new AuthHandlerImpl(asJava)
    private class AuthHandlerImpl(private val _asJava: Object) extends AuthHandler {

      def asJava = _asJava

  /**
    * Add a required authority for this auth handler
    * @param authority the authority
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthority(authority: String):AuthHandler = {
    asJava.asInstanceOf[JAuthHandler].addAuthority(authority.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Add a set of required authorities for this auth handler
    * @param authorities the set of authorities
    * @return a reference to this, so the API can be used fluently
    */
  def addAuthorities(authorities: scala.collection.mutable.Set[String]):AuthHandler = {
    asJava.asInstanceOf[JAuthHandler].addAuthorities(authorities.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  override def handle(arg0: RoutingContext):Unit = {
    asJava.asInstanceOf[JAuthHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}
}
