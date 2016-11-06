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

package io.vertx.scala.ext.auth.shiro

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.auth.shiro.{ShiroAuth => JShiroAuth}
  import io.vertx.ext.auth.{User => JUser}
import io.vertx.scala.ext.auth.User
import io.vertx.ext.auth.{User => JUser}
  import io.vertx.ext.auth.shiro.{ShiroAuth => JShiroAuth}
  import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
  import io.vertx.core.json.JsonObject
        import io.vertx.ext.auth.shiro.{ShiroAuthOptions => JShiroAuthOptions}
  import io.vertx.ext.auth.shiro.ShiroAuthRealmType
  import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}

/**
  * Factory interface for creating Apache Shiro based [[io.vertx.scala.ext.auth.AuthProvider]] instances.
  */
class ShiroAuth(private val _asJava: JShiroAuth) {

  def asJava: JShiroAuth = _asJava

  /**
    * Set the role prefix to distinguish from permissions when checking for isPermitted requests.
    * @param rolePrefix a Prefix e.g.: "role:"
    * @return a reference to this for fluency
    */
  def setRolePrefix(rolePrefix: String): ShiroAuth = {
    ShiroAuth.apply(_asJava.setRolePrefix(rolePrefix))
  }

}

object ShiroAuth {

  def apply(_asJava: JShiroAuth): ShiroAuth =
    new ShiroAuth(_asJava)

  def create(vertx: Vertx, realmType: io.vertx.ext.auth.shiro.ShiroAuthRealmType, config: JsonObject): ShiroAuth = {
    ShiroAuth.apply(io.vertx.ext.auth.shiro.ShiroAuth.create(vertx.asJava.asInstanceOf[JVertx], realmType, config))
  }

  def create(vertx: Vertx, options: ShiroAuthOptions): ShiroAuth = {
    ShiroAuth.apply(io.vertx.ext.auth.shiro.ShiroAuth.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

}
