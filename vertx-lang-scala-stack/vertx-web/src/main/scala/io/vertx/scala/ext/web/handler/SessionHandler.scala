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
import io.vertx.ext.web.handler.{SessionHandler => JSessionHandler}
import io.vertx.ext.web.sstore.{SessionStore => JSessionStore}
import io.vertx.scala.ext.web.sstore.SessionStore
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.scala.ext.web.RoutingContext

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
class SessionHandler(private val _asJava: JSessionHandler) {

  def asJava: JSessionHandler = _asJava

  def handle(arg0: RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

  /**
    * Set the session timeout
    * @param timeout the timeout, in ms.
    * @return a reference to this, so the API can be used fluently
    */
  def setSessionTimeout(timeout: Long): SessionHandler = {
    _asJava.setSessionTimeout(timeout)
    this
  }

  /**
    * Set whether a nagging log warning should be written if the session handler is accessed over HTTP, not
    * HTTPS
    * @param nag true to nag
    * @return a reference to this, so the API can be used fluently
    */
  def setNagHttps(nag: Boolean): SessionHandler = {
    _asJava.setNagHttps(nag)
    this
  }

  /**
    * Sets whether the 'secure' flag should be set for the session cookie. When set this flag instructs browsers to only
    * send the cookie over HTTPS. Note that this will probably stop your sessions working if used without HTTPS (e.g. in development).
    * @param secure true to set the secure flag on the cookie
    * @return a reference to this, so the API can be used fluently
    */
  def setCookieSecureFlag(secure: Boolean): SessionHandler = {
    _asJava.setCookieSecureFlag(secure)
    this
  }

  /**
    * Sets whether the 'HttpOnly' flag should be set for the session cookie. When set this flag instructs browsers to
    * prevent Javascript access to the the cookie. Used as a line of defence against the most common XSS attacks.
    * @param httpOnly true to set the HttpOnly flag on the cookie
    * @return a reference to this, so the API can be used fluently
    */
  def setCookieHttpOnlyFlag(httpOnly: Boolean): SessionHandler = {
    _asJava.setCookieHttpOnlyFlag(httpOnly)
    this
  }

  /**
    * Set the session cookie name
    * @param sessionCookieName the session cookie name
    * @return a reference to this, so the API can be used fluently
    */
  def setSessionCookieName(sessionCookieName: String): SessionHandler = {
    _asJava.setSessionCookieName(sessionCookieName)
    this
  }

}

object SessionHandler {

  def apply(_asJava: JSessionHandler): SessionHandler =
    new SessionHandler(_asJava)

  def create(sessionStore: SessionStore): SessionHandler = {
    SessionHandler.apply(io.vertx.ext.web.handler.SessionHandler.create(sessionStore.asJava.asInstanceOf[JSessionStore]))
  }

}
