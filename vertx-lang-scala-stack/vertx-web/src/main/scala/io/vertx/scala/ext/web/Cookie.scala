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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.{Cookie => JCookie}

/**
  * Represents an HTTP Cookie.
  * 
  * All cookies must have a name and a value and can optionally have other fields set such as path, domain, etc.
  * 
  * (Derived from io.netty.handler.codec.http.Cookie)
  */
class Cookie(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Sets the value of this cookie
    * @param value The value to set
    * @return a reference to this, so the API can be used fluently
    */
  def setValue(value: String): Cookie = {
    asJava.asInstanceOf[JCookie].setValue(value.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Sets the domain of this cookie
    * @param domain The domain to use
    * @return a reference to this, so the API can be used fluently
    */
  def setDomain(domain: scala.Option[String]): Cookie = {
    asJava.asInstanceOf[JCookie].setDomain(domain.map(x => x.asInstanceOf[java.lang.String]).orNull)
    this
  }

  /**
    * Sets the path of this cookie.
    * @param path The path to use for this cookie
    * @return a reference to this, so the API can be used fluently
    */
  def setPath(path: scala.Option[String]): Cookie = {
    asJava.asInstanceOf[JCookie].setPath(path.map(x => x.asInstanceOf[java.lang.String]).orNull)
    this
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
    asJava.asInstanceOf[JCookie].setMaxAge(maxAge.asInstanceOf[java.lang.Long])
    this
  }

  /**
    * Sets the security getStatus of this cookie
    * @param secure True if this cookie is to be secure, otherwise false
    * @return a reference to this, so the API can be used fluently
    */
  def setSecure(secure: Boolean): Cookie = {
    asJava.asInstanceOf[JCookie].setSecure(secure.asInstanceOf[java.lang.Boolean])
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
    asJava.asInstanceOf[JCookie].setHttpOnly(httpOnly.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * @return the name of this cookie
    */
  def getName(): String = {
    asJava.asInstanceOf[JCookie].getName().asInstanceOf[String]
  }

  /**
    * @return the value of this cookie
    */
  def getValue(): String = {
    asJava.asInstanceOf[JCookie].getValue().asInstanceOf[String]
  }

  /**
    * @return the domain for the cookie
    */
  def getDomain(): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JCookie].getDomain().asInstanceOf[String])
  }

  /**
    * @return the path for this cookie
    */
  def getPath(): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JCookie].getPath().asInstanceOf[String])
  }

  /**
    * Encode the cookie to a string. This is what is used in the Set-Cookie header
    * @return the encoded cookie
    */
  def encode(): String = {
    asJava.asInstanceOf[JCookie].encode().asInstanceOf[String]
  }

  /**
    * Has the cookie been changed? Changed cookies will be saved out in the response and sent to the browser.
    * @return true if changed
    */
  def isChanged(): Boolean = {
    asJava.asInstanceOf[JCookie].isChanged().asInstanceOf[Boolean]
  }

  /**
    * Set the cookie as being changed. Changed will be true for a cookie just created, false by default if just
    * read from the request
    * @param changed true if changed
    */
  def setChanged(changed: Boolean): Unit = {
    asJava.asInstanceOf[JCookie].setChanged(changed.asInstanceOf[java.lang.Boolean])
  }

}

object Cookie {
  def apply(asJava: JCookie) = new Cookie(asJava)  
  /**
    * Create a new cookie
    * @param name the name of the cookie
    * @param value the cookie value
    * @return the cookie
    */
  def cookie(name: String, value: String): Cookie = {
    Cookie(JCookie.cookie(name.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String]))
  }

}
