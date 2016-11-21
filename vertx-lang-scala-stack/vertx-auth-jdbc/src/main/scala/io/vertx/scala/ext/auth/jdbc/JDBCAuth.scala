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

package io.vertx.scala.ext.auth.jdbc

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.auth.jdbc.{JDBCAuth => JJDBCAuth}
import io.vertx.ext.auth.{User => JUser}
import io.vertx.scala.ext.auth.User
import io.vertx.ext.jdbc.{JDBCClient => JJDBCClient}
import io.vertx.scala.ext.jdbc.JDBCClient
import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.scala.ext.auth.AuthProvider

/**
  * Factory interface for creating [[io.vertx.scala.ext.auth.AuthProvider]] instances that use the Vert.x JDBC client
  */
class JDBCAuth(private val _asJava: JJDBCAuth) 
    extends  {

  def asJava: JJDBCAuth = _asJava

  /**
    * Set the authentication query to use. Use this if you want to override the default authentication query.
    * @param authenticationQuery the authentication query
    * @return a reference to this for fluency
    */
  def setAuthenticationQuery(authenticationQuery: String): JDBCAuth = {
    JDBCAuth.apply(_asJava.setAuthenticationQuery(authenticationQuery))
  }

  /**
    * Set the roles query to use. Use this if you want to override the default roles query.
    * @param rolesQuery the roles query
    * @return a reference to this for fluency
    */
  def setRolesQuery(rolesQuery: String): JDBCAuth = {
    JDBCAuth.apply(_asJava.setRolesQuery(rolesQuery))
  }

  /**
    * Set the permissions query to use. Use this if you want to override the default permissions query.
    * @param permissionsQuery the permissions query
    * @return a reference to this for fluency
    */
  def setPermissionsQuery(permissionsQuery: String): JDBCAuth = {
    JDBCAuth.apply(_asJava.setPermissionsQuery(permissionsQuery))
  }

  /**
    * Set the role prefix to distinguish from permissions when checking for isPermitted requests.
    * @param rolePrefix a Prefix e.g.: "role:"
    * @return a reference to this for fluency
    */
  def setRolePrefix(rolePrefix: String): JDBCAuth = {
    JDBCAuth.apply(_asJava.setRolePrefix(rolePrefix))
  }

}

object JDBCAuth {

  def apply(_asJava: JJDBCAuth): JDBCAuth =
    new JDBCAuth(_asJava)

  def create(client: JDBCClient): JDBCAuth = {
    JDBCAuth.apply(io.vertx.ext.auth.jdbc.JDBCAuth.create(client.asJava.asInstanceOf[JJDBCClient]))
  }

}
