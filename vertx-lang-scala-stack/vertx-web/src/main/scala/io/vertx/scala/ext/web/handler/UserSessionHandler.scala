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
import io.vertx.ext.web.handler.{UserSessionHandler => JUserSessionHandler}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.scala.ext.auth.AuthProvider

/**
  *
  * This handler should be used if you want to store the User object in the Session so it's available between
  * different requests, without you having re-authenticate each time.
  *
  * It requires that the session handler is already present on previous matching routes.
  *
  * It requires an Auth provider so, if the user is deserialized from a clustered session it knows which Auth provider
  * to associate the session with.
  */
class UserSessionHandler(private val _asJava: JUserSessionHandler) {

  def asJava: JUserSessionHandler = _asJava

  def handle(arg0: RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object UserSessionHandler {

  def apply(_asJava: JUserSessionHandler): UserSessionHandler =
    new UserSessionHandler(_asJava)

  def create(authProvider: AuthProvider): UserSessionHandler = {
    UserSessionHandler.apply(io.vertx.ext.web.handler.UserSessionHandler.create(authProvider.asJava.asInstanceOf[JAuthProvider]))
  }

}
