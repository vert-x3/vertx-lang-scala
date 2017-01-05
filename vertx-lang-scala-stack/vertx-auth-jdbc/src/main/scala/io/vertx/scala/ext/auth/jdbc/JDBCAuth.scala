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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.scala.ext.jdbc.JDBCClient
import io.vertx.lang.scala.AsyncResultWrapper
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
    extends AuthProvider(_asJava) {


//cached methods
//fluent methods
//default methods
//basic methods
  def setAuthenticationQuery(authenticationQuery: String):JDBCAuth = {
    JDBCAuth(asJava.asInstanceOf[JJDBCAuth].setAuthenticationQuery(authenticationQuery.asInstanceOf[java.lang.String]))
  }

  def setRolesQuery(rolesQuery: String):JDBCAuth = {
    JDBCAuth(asJava.asInstanceOf[JJDBCAuth].setRolesQuery(rolesQuery.asInstanceOf[java.lang.String]))
  }

  def setPermissionsQuery(permissionsQuery: String):JDBCAuth = {
    JDBCAuth(asJava.asInstanceOf[JJDBCAuth].setPermissionsQuery(permissionsQuery.asInstanceOf[java.lang.String]))
  }

  def setRolePrefix(rolePrefix: String):JDBCAuth = {
    JDBCAuth(asJava.asInstanceOf[JJDBCAuth].setRolePrefix(rolePrefix.asInstanceOf[java.lang.String]))
  }

//future methods
}

  object JDBCAuth{
    def apply(asJava: JJDBCAuth) = new JDBCAuth(asJava)  
  //static methods
    def create(client: JDBCClient):JDBCAuth = {
      JDBCAuth(JJDBCAuth.create(client.asJava.asInstanceOf[JJDBCClient]))
    }

  }
