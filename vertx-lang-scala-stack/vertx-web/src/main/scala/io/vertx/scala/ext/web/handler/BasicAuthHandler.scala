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
import io.vertx.ext.web.handler.{BasicAuthHandler => JBasicAuthHandler}
import io.vertx.ext.web.handler.{AuthHandler => JAuthHandler}
import io.vertx.scala.ext.web.RoutingContext
import scala.collection.JavaConverters._

/**
  * An auth handler that provides HTTP Basic Authentication support.
  */
class BasicAuthHandler(private val _asJava: Object) 
    extends AuthHandler {

  def asJava = _asJava

//cached methods
//fluent methods
  override def addAuthority(authority: String):AuthHandler = {
    asJava.asInstanceOf[JBasicAuthHandler].addAuthority(authority.asInstanceOf[java.lang.String])
    this
  }

  override def addAuthorities(authorities: scala.collection.mutable.Set[String]):AuthHandler = {
    asJava.asInstanceOf[JBasicAuthHandler].addAuthorities(authorities.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

//default methods
//basic methods
  override def handle(arg0: RoutingContext):Unit = {
    asJava.asInstanceOf[JBasicAuthHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

//future methods
}

  object BasicAuthHandler{
    def apply(asJava: JBasicAuthHandler) = new BasicAuthHandler(asJava)  
  //static methods
    def create(authProvider: AuthProvider):AuthHandler = {
      AuthHandler(JBasicAuthHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider]))
    }

    def create(authProvider: AuthProvider,realm: String):AuthHandler = {
      AuthHandler(JBasicAuthHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider],realm.asInstanceOf[java.lang.String]))
    }

  }
