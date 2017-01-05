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
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.web.handler.{FormLoginHandler => JFormLoginHandler}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler

/**
  * Handler that handles login from a form on a custom login page.
  * 
  * Used in conjunction with the [[io.vertx.scala.ext.web.handler.RedirectAuthHandler]].
  */
class FormLoginHandler(private val _asJava: Object) 
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava = _asJava

//cached methods
//fluent methods
  def setUsernameParam(usernameParam: String):FormLoginHandler = {
    asJava.asInstanceOf[JFormLoginHandler].setUsernameParam(usernameParam.asInstanceOf[java.lang.String])
    this
  }

  def setPasswordParam(passwordParam: String):FormLoginHandler = {
    asJava.asInstanceOf[JFormLoginHandler].setPasswordParam(passwordParam.asInstanceOf[java.lang.String])
    this
  }

  def setReturnURLParam(returnURLParam: String):FormLoginHandler = {
    asJava.asInstanceOf[JFormLoginHandler].setReturnURLParam(returnURLParam.asInstanceOf[java.lang.String])
    this
  }

  def setDirectLoggedInOKURL(directLoggedInOKURL: String):FormLoginHandler = {
    asJava.asInstanceOf[JFormLoginHandler].setDirectLoggedInOKURL(directLoggedInOKURL.asInstanceOf[java.lang.String])
    this
  }

//default methods
//basic methods
  override def handle(arg0: RoutingContext):Unit = {
    asJava.asInstanceOf[JFormLoginHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

//future methods
}

  object FormLoginHandler{
    def apply(asJava: JFormLoginHandler) = new FormLoginHandler(asJava)  
  //static methods
    def create(authProvider: AuthProvider):FormLoginHandler = {
      FormLoginHandler(JFormLoginHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider]))
    }

    def create(authProvider: AuthProvider,usernameParam: String,passwordParam: String,returnURLParam: String,directLoggedInOKURL: String):FormLoginHandler = {
      FormLoginHandler(JFormLoginHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider],usernameParam.asInstanceOf[java.lang.String],passwordParam.asInstanceOf[java.lang.String],returnURLParam.asInstanceOf[java.lang.String],directLoggedInOKURL.asInstanceOf[java.lang.String]))
    }

  }
