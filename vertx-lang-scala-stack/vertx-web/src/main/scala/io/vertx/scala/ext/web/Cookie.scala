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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
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

//cached methods
//fluent methods
  def setValue(value: String):Cookie = {
    asJava.asInstanceOf[JCookie].setValue(value.asInstanceOf[java.lang.String])
    this
  }

  def setDomain(domain: scala.Option[String]):Cookie = {
    asJava.asInstanceOf[JCookie].setDomain(domain.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null))
    this
  }

  def setPath(path: scala.Option[String]):Cookie = {
    asJava.asInstanceOf[JCookie].setPath(path.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null))
    this
  }

  def setMaxAge(maxAge: Long):Cookie = {
    asJava.asInstanceOf[JCookie].setMaxAge(maxAge.asInstanceOf[java.lang.Long])
    this
  }

  def setSecure(secure: Boolean):Cookie = {
    asJava.asInstanceOf[JCookie].setSecure(secure.asInstanceOf[java.lang.Boolean])
    this
  }

  def setHttpOnly(httpOnly: Boolean):Cookie = {
    asJava.asInstanceOf[JCookie].setHttpOnly(httpOnly.asInstanceOf[java.lang.Boolean])
    this
  }

//default methods
//basic methods
  def getName():String = {
    asJava.asInstanceOf[JCookie].getName().asInstanceOf[String]
  }

  def getValue():String = {
    asJava.asInstanceOf[JCookie].getValue().asInstanceOf[String]
  }

  def getDomain():scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JCookie].getDomain().asInstanceOf[String])
  }

  def getPath():scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JCookie].getPath().asInstanceOf[String])
  }

  def encode():String = {
    asJava.asInstanceOf[JCookie].encode().asInstanceOf[String]
  }

  def isChanged():Boolean = {
    asJava.asInstanceOf[JCookie].isChanged().asInstanceOf[Boolean]
  }

  def setChanged(changed: Boolean):Unit = {
    asJava.asInstanceOf[JCookie].setChanged(changed.asInstanceOf[java.lang.Boolean])
  }

//future methods
}

  object Cookie{
    def apply(asJava: JCookie) = new Cookie(asJava)  
  //static methods
    def cookie(name: String,value: String):Cookie = {
      Cookie(JCookie.cookie(name.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String]))
    }

  }
