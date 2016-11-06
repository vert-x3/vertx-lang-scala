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

package io.vertx.scala.ext.web

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.web.{Cookie => JCookie}
  import io.vertx.ext.web.{Cookie => JCookie}
  
/**
  * Represents an HTTP Cookie.
  * 
  * All cookies must have a name and a value and can optionally have other fields set such as path, domain, etc.
  * 
  * (Derived from io.netty.handler.codec.http.Cookie)
  */
class Cookie(private val _asJava: JCookie) {

  def asJava: JCookie = _asJava

  /**
    * @return the name of this cookie
    */
  def getName(): String = {
    _asJava.getName()
  }

  /**
    * @return the value of this cookie
    */
  def getValue(): String = {
    _asJava.getValue()
  }

  /**
    * Sets the value of this cookie
    * @param value The value to set
    * @return a reference to this, so the API can be used fluently
    */
  def setValue(value: String): Cookie = {
    _asJava.setValue(value)
    this
  }

  /**
    * Sets the domain of this cookie
    * @param domain The domain to use
    * @return a reference to this, so the API can be used fluently
    */
  def setDomain(domain: scala.Option[String]): Cookie = {
    _asJava.setDomain((if (domain.isDefined) domain.get else null))
    this
  }

  /**
    * @return the domain for the cookie
    */
  def getDomain(): scala.Option[String] = {
        scala.Option(_asJava.getDomain())
  }

  /**
    * Sets the path of this cookie.
    * @param path The path to use for this cookie
    * @return a reference to this, so the API can be used fluently
    */
  def setPath(path: scala.Option[String]): Cookie = {
    _asJava.setPath((if (path.isDefined) path.get else null))
    this
  }

  /**
    * @return the path for this cookie
    */
  def getPath(): scala.Option[String] = {
        scala.Option(_asJava.getPath())
  }

  /**
    * Sets the maximum age of this cookie in seconds.
    * If an age of `0` is specified, this cookie will be
    * automatically removed by browser because it will expire immediately.
    * If MIN_VALUE is specified, this cookie will be removed when the
    * browser is closed.
    * If you don't set this the cookie will be a session cookie and be removed when the browser is closed.
    * @param maxAge The maximum age of this cookie in seconds
    */
  def setMaxAge(maxAge: Long): Cookie = {
    _asJava.setMaxAge(maxAge)
    this
  }

  /**
    * Sets the security getStatus of this cookie
    * @param secure True if this cookie is to be secure, otherwise false
    * @return a reference to this, so the API can be used fluently
    */
  def setSecure(secure: Boolean): Cookie = {
    _asJava.setSecure(secure)
    this
  }

  /**
    * Determines if this cookie is HTTP only.
    * If set to true, this cookie cannot be accessed by a client
    * side script. However, this works only if the browser supports it.
    * For for information, please look
    * <a href="http://www.owasp.org/index.php/HTTPOnly">here</a>.
    * @param httpOnly True if the cookie is HTTP only, otherwise false.
    */
  def setHttpOnly(httpOnly: Boolean): Cookie = {
    _asJava.setHttpOnly(httpOnly)
    this
  }

  /**
    * Encode the cookie to a string. This is what is used in the Set-Cookie header
    * @return the encoded cookie
    */
  def encode(): String = {
    _asJava.encode()
  }

  /**
    * Has the cookie been changed? Changed cookies will be saved out in the response and sent to the browser.
    * @return true if changed
    */
  def isChanged(): Boolean = {
    _asJava.isChanged()
  }

  /**
    * Set the cookie as being changed. Changed will be true for a cookie just created, false by default if just
    * read from the request
    * @param changed true if changed
    */
  def setChanged(changed: Boolean): Unit = {
    _asJava.setChanged(changed)
  }

}

object Cookie {

  def apply(_asJava: JCookie): Cookie =
    new Cookie(_asJava)

  def cookie(name: String, value: String): Cookie = {
    Cookie.apply(io.vertx.ext.web.Cookie.cookie(name, value))
  }

}
