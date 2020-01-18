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

import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.ext.auth.shiro.{ShiroAuthOptions => JShiroAuthOptions}
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import scala.reflect.runtime.universe._
import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.shiro.{ShiroAuth => JShiroAuth}
import io.vertx.scala.core.Vertx
import io.vertx.ext.auth.shiro.ShiroAuthRealmType
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Factory interface for creating Apache Shiro based [[io.vertx.scala.ext.auth.AuthProvider]] instances.
  */

class ShiroAuth(private val _asJava: Object) extends AuthProvider (_asJava) {






  /**
   * Set the role prefix to distinguish from permissions when checking for isPermitted requests.   * @param rolePrefix a Prefix e.g.: "role:"
   * @return a reference to this for fluency
   */
  def setRolePrefix (rolePrefix: String): ShiroAuth = {
    ShiroAuth(asJava.asInstanceOf[JShiroAuth].setRolePrefix(rolePrefix.asInstanceOf[java.lang.String]))
  }


}

object ShiroAuth {
  def apply(asJava: JShiroAuth) = new ShiroAuth(asJava)

  /**
   * Create a Shiro auth provider   * @param vertx the Vert.x instance
   * @param realmType the Shiro realm type
   * @param config the config
   * @return the auth provider
   */
  def create(vertx: Vertx,realmType: io.vertx.ext.auth.shiro.ShiroAuthRealmType,config: io.vertx.core.json.JsonObject): ShiroAuth = {
    ShiroAuth(JShiroAuth.create(vertx.asJava.asInstanceOf[JVertx], realmType, config))//2 create
  }

  /**
   * Create a Shiro auth provider   * @param vertx the Vert.x instance
   * @param options the Shiro configuration options see <a href="../../../../../../../../cheatsheet/ShiroAuthOptions.html">ShiroAuthOptions</a>
   * @return the auth provider
   */
  def create(vertx: Vertx,options: ShiroAuthOptions): ShiroAuth = {
    ShiroAuth(JShiroAuth.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))//2 create
  }

}
