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


package io.vertx.scala.ext.auth

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.auth.jdbc.{JDBCAuthorizationOptions => JJDBCAuthorizationOptions}
package object jdbc{


  type JDBCAuthOptions = io.vertx.ext.auth.jdbc.JDBCAuthOptions
  object JDBCAuthOptions {
    def apply() = new JDBCAuthOptions()
    def apply(json: JsonObject) = new JDBCAuthOptions(json)
    def apply( authenticationQuery: java.lang.String = null, config: io.vertx.core.json.JsonObject = null, datasourceName: java.lang.String = null, permissionsQuery: java.lang.String = null, rolesPrefix: java.lang.String = null, rolesQuery: java.lang.String = null, shared: java.lang.Boolean = null): JDBCAuthOptions = {
      val ret = new JDBCAuthOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (authenticationQuery != null) ret.setAuthenticationQuery(authenticationQuery) 
      if (config != null) ret.setConfig(config) 
      if (datasourceName != null) ret.setDatasourceName(datasourceName) 
      if (permissionsQuery != null) ret.setPermissionsQuery(permissionsQuery) 
      if (rolesPrefix != null) ret.setRolesPrefix(rolesPrefix) 
      if (rolesQuery != null) ret.setRolesQuery(rolesQuery) 
      if (shared != null) ret.setShared(shared) 
      ret
    }
  }



  type JDBCAuthenticationOptions = io.vertx.ext.auth.jdbc.JDBCAuthenticationOptions
  object JDBCAuthenticationOptions {
    def apply() = new JDBCAuthenticationOptions()
    def apply(json: JsonObject) = new JDBCAuthenticationOptions(json)
    def apply( authenticationQuery: java.lang.String = null): JDBCAuthenticationOptions = {
      val ret = new JDBCAuthenticationOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (authenticationQuery != null) ret.setAuthenticationQuery(authenticationQuery) 
      ret
    }
  }



  type JDBCAuthorizationOptions = io.vertx.ext.auth.jdbc.JDBCAuthorizationOptions
  object JDBCAuthorizationOptions {
    def apply() = new JDBCAuthorizationOptions()
    def apply(json: JsonObject) = new JDBCAuthorizationOptions(json)
    def apply( permissionsQuery: java.lang.String = null, rolesQuery: java.lang.String = null): JDBCAuthorizationOptions = {
      val ret = new JDBCAuthorizationOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (permissionsQuery != null) ret.setPermissionsQuery(permissionsQuery) 
      if (rolesQuery != null) ret.setRolesQuery(rolesQuery) 
      ret
    }
  }



}
