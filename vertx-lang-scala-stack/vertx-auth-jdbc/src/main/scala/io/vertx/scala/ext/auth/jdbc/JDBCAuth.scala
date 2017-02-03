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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.scala.ext.jdbc.JDBCClient
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.scala.ext.auth.User
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.auth.{User => JUser}
import io.vertx.ext.auth.jdbc.{JDBCAuth => JJDBCAuth}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.jdbc.{JDBCClient => JJDBCClient}

/**
  * Factory interface for creating [[io.vertx.scala.ext.auth.AuthProvider]] instances that use the Vert.x JDBC client
  */
class JDBCAuth(private val _asJava: Object)
    extends AuthProvider(_asJava)  {


  /**
    * Set the authentication query to use. Use this if you want to override the default authentication query.
    * @param authenticationQuery the authentication query
    * @return a reference to this for fluency
    */
  def setAuthenticationQuery(authenticationQuery: String): JDBCAuth = {
    JDBCAuth(asJava.asInstanceOf[JJDBCAuth].setAuthenticationQuery(authenticationQuery.asInstanceOf[java.lang.String]))
  }

  /**
    * Set the roles query to use. Use this if you want to override the default roles query.
    * @param rolesQuery the roles query
    * @return a reference to this for fluency
    */
  def setRolesQuery(rolesQuery: String): JDBCAuth = {
    JDBCAuth(asJava.asInstanceOf[JJDBCAuth].setRolesQuery(rolesQuery.asInstanceOf[java.lang.String]))
  }

  /**
    * Set the permissions query to use. Use this if you want to override the default permissions query.
    * @param permissionsQuery the permissions query
    * @return a reference to this for fluency
    */
  def setPermissionsQuery(permissionsQuery: String): JDBCAuth = {
    JDBCAuth(asJava.asInstanceOf[JJDBCAuth].setPermissionsQuery(permissionsQuery.asInstanceOf[java.lang.String]))
  }

  /**
    * Set the role prefix to distinguish from permissions when checking for isPermitted requests.
    * @param rolePrefix a Prefix e.g.: "role:"
    * @return a reference to this for fluency
    */
  def setRolePrefix(rolePrefix: String): JDBCAuth = {
    JDBCAuth(asJava.asInstanceOf[JJDBCAuth].setRolePrefix(rolePrefix.asInstanceOf[java.lang.String]))
  }

  /**
    * Compute the hashed password given the unhashed password and the salt
    *
    * The implementation relays to the JDBCHashStrategy provided.
    * @param password the unhashed password
    * @param salt the salt
    * @return the hashed password
    */
  def computeHash(password: String, salt: String): String = {
    asJava.asInstanceOf[JJDBCAuth].computeHash(password.asInstanceOf[java.lang.String], salt.asInstanceOf[java.lang.String]).asInstanceOf[String]
  }

  /**
    * Compute a salt string.
    *
    * The implementation relays to the JDBCHashStrategy provided.
    * @return a non null salt value
    */
  def generateSalt(): String = {
    asJava.asInstanceOf[JJDBCAuth].generateSalt().asInstanceOf[String]
  }

}

object JDBCAuth {
  def apply(asJava: JJDBCAuth) = new JDBCAuth(asJava)  
  /**
    * Create a JDBC auth provider implementation
    * @param client the JDBC client instance
    * @return the auth provider
    */
  def create(vertx: Vertx, client: JDBCClient): JDBCAuth = {
    JDBCAuth(JJDBCAuth.create(vertx.asJava.asInstanceOf[JVertx], client.asJava.asInstanceOf[JJDBCClient]))
  }

}
