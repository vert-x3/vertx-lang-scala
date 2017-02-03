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

  /**
    * Set the name of the form param used to submit the username
    * @param usernameParam the name of the param
    * @return a reference to this for a fluent API
    */
  def setUsernameParam(usernameParam: String): FormLoginHandler = {
    asJava.asInstanceOf[JFormLoginHandler].setUsernameParam(usernameParam.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set the name of the form param used to submit the password
    * @param passwordParam the name of the param
    * @return a reference to this for a fluent API
    */
  def setPasswordParam(passwordParam: String): FormLoginHandler = {
    asJava.asInstanceOf[JFormLoginHandler].setPasswordParam(passwordParam.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set the name of the session attrioute used to specify the return url
    * @param returnURLParam the name of the param
    * @return a reference to this for a fluent API
    */
  def setReturnURLParam(returnURLParam: String): FormLoginHandler = {
    asJava.asInstanceOf[JFormLoginHandler].setReturnURLParam(returnURLParam.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set the url to redirect to if the user logs in directly at the url of the form login handler
    * without being redirected here first
    * @param directLoggedInOKURL the URL to redirect to
    * @return a reference to this for a fluent API
    */
  def setDirectLoggedInOKURL(directLoggedInOKURL: String): FormLoginHandler = {
    asJava.asInstanceOf[JFormLoginHandler].setDirectLoggedInOKURL(directLoggedInOKURL.asInstanceOf[java.lang.String])
    this
  }

  override def handle(arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JFormLoginHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object FormLoginHandler {
  def apply(asJava: JFormLoginHandler) = new FormLoginHandler(asJava)  
  /**
    * Create a handler
    * @param authProvider the auth service to use
    * @return the handler
    */
  def create(authProvider: AuthProvider): FormLoginHandler = {
    FormLoginHandler(JFormLoginHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider]))
  }

  /**
    * Create a handler
    * @param authProvider the auth service to use
    * @param usernameParam the value of the form attribute which will contain the username
    * @param passwordParam the value of the form attribute which will contain the password
    * @param returnURLParam the value of the session attribute which will contain the return url
    * @param directLoggedInOKURL a url to redirect to if the user logs in directly at the url of the form login handler without being redirected here first
    * @return the handler
    */
  def create(authProvider: AuthProvider, usernameParam: String, passwordParam: String, returnURLParam: String, directLoggedInOKURL: String): FormLoginHandler = {
    FormLoginHandler(JFormLoginHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider], usernameParam.asInstanceOf[java.lang.String], passwordParam.asInstanceOf[java.lang.String], returnURLParam.asInstanceOf[java.lang.String], directLoggedInOKURL.asInstanceOf[java.lang.String]))
  }

}
