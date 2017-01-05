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
import io.vertx.ext.web.sstore.{SessionStore => JSessionStore}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler
import io.vertx.ext.web.handler.{SessionHandler => JSessionHandler}
import io.vertx.scala.ext.web.sstore.SessionStore

/**
  * A handler that maintains a [[io.vertx.scala.ext.web.Session]] for each browser session.
  * 
  * It looks up the session for each request based on a session cookie which contains a session ID. It stores the session
  * when the response is ended in the session store.
  * 
  * The session is available on the routing context with .
  * 
  * The session handler requires a [[io.vertx.scala.ext.web.handler.CookieHandler]] to be on the routing chain before it.
  */
class SessionHandler(private val _asJava: Object) 
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava = _asJava

//cached methods
//fluent methods
  def setSessionTimeout(timeout: Long):SessionHandler = {
    asJava.asInstanceOf[JSessionHandler].setSessionTimeout(timeout.asInstanceOf[java.lang.Long])
    this
  }

  def setNagHttps(nag: Boolean):SessionHandler = {
    asJava.asInstanceOf[JSessionHandler].setNagHttps(nag.asInstanceOf[java.lang.Boolean])
    this
  }

  def setCookieSecureFlag(secure: Boolean):SessionHandler = {
    asJava.asInstanceOf[JSessionHandler].setCookieSecureFlag(secure.asInstanceOf[java.lang.Boolean])
    this
  }

  def setCookieHttpOnlyFlag(httpOnly: Boolean):SessionHandler = {
    asJava.asInstanceOf[JSessionHandler].setCookieHttpOnlyFlag(httpOnly.asInstanceOf[java.lang.Boolean])
    this
  }

  def setSessionCookieName(sessionCookieName: String):SessionHandler = {
    asJava.asInstanceOf[JSessionHandler].setSessionCookieName(sessionCookieName.asInstanceOf[java.lang.String])
    this
  }

  def setMinLength(minLength: Int):SessionHandler = {
    asJava.asInstanceOf[JSessionHandler].setMinLength(minLength.asInstanceOf[java.lang.Integer])
    this
  }

//default methods
//basic methods
  override def handle(arg0: RoutingContext):Unit = {
    asJava.asInstanceOf[JSessionHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

//future methods
}

  object SessionHandler{
    def apply(asJava: JSessionHandler) = new SessionHandler(asJava)  
  //static methods
    def create(sessionStore: SessionStore):SessionHandler = {
      SessionHandler(JSessionHandler.create(sessionStore.asJava.asInstanceOf[JSessionStore]))
    }

  }
