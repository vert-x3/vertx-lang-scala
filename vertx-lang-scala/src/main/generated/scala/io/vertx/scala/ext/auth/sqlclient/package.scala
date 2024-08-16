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

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.auth.sqlclient.{SqlAuthenticationOptions => JSqlAuthenticationOptions}
package object sqlclient{


  type SqlAuthenticationOptions = io.vertx.ext.auth.sqlclient.SqlAuthenticationOptions
  object SqlAuthenticationOptions {
    def apply() = new SqlAuthenticationOptions()
    def apply(json: JsonObject) = new SqlAuthenticationOptions(json)
    def apply( authenticationQuery: java.lang.String = null): SqlAuthenticationOptions = {
      val ret = new SqlAuthenticationOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (authenticationQuery != null) ret.setAuthenticationQuery(authenticationQuery) 
      ret
    }
  }



  type SqlAuthorizationOptions = io.vertx.ext.auth.sqlclient.SqlAuthorizationOptions
  object SqlAuthorizationOptions {
    def apply() = new SqlAuthorizationOptions()
    def apply(json: JsonObject) = new SqlAuthorizationOptions(json)
    def apply( permissionsQuery: java.lang.String = null, rolesQuery: java.lang.String = null): SqlAuthorizationOptions = {
      val ret = new SqlAuthorizationOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (permissionsQuery != null) ret.setPermissionsQuery(permissionsQuery) 
      if (rolesQuery != null) ret.setRolesQuery(rolesQuery) 
      ret
    }
  }



}
