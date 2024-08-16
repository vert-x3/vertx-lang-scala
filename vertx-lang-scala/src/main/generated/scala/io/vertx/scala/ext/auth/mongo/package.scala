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

import io.vertx.ext.auth
import io.vertx.ext.auth.mongo.{MongoAuthOptions => JMongoAuthOptions}
import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.{AuthOptions => JAuthOptions}
package object mongo{


  type MongoAuthOptions = io.vertx.ext.auth.mongo.MongoAuthOptions
  object MongoAuthOptions {
    def apply() = new MongoAuthOptions()
    def apply(json: JsonObject) = new MongoAuthOptions(json)
    def apply( collectionName: java.lang.String = null, config: io.vertx.core.json.JsonObject = null, datasourceName: java.lang.String = null, passwordField: java.lang.String = null, permissionField: java.lang.String = null, roleField: java.lang.String = null, saltField: java.lang.String = null, saltStyle: io.vertx.ext.auth.mongo.HashSaltStyle = null, shared: java.lang.Boolean = null, usernameCredentialField: java.lang.String = null, usernameField: java.lang.String = null): MongoAuthOptions = {
      val ret = new MongoAuthOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (collectionName != null) ret.setCollectionName(collectionName) 
      if (config != null) ret.setConfig(config) 
      if (datasourceName != null) ret.setDatasourceName(datasourceName) 
      if (passwordField != null) ret.setPasswordField(passwordField) 
      if (permissionField != null) ret.setPermissionField(permissionField) 
      if (roleField != null) ret.setRoleField(roleField) 
      if (saltField != null) ret.setSaltField(saltField) 
      if (saltStyle != null) ret.setSaltStyle(saltStyle) 
      if (shared != null) ret.setShared(shared) 
      if (usernameCredentialField != null) ret.setUsernameCredentialField(usernameCredentialField) 
      if (usernameField != null) ret.setUsernameField(usernameField) 
      ret
    }
  }



  type MongoAuthenticationOptions = io.vertx.ext.auth.mongo.MongoAuthenticationOptions
  object MongoAuthenticationOptions {
    def apply() = new MongoAuthenticationOptions()
    def apply(json: JsonObject) = new MongoAuthenticationOptions(json)
    def apply( collectionName: java.lang.String = null, passwordCredentialField: java.lang.String = null, passwordField: java.lang.String = null, usernameCredentialField: java.lang.String = null, usernameField: java.lang.String = null): MongoAuthenticationOptions = {
      val ret = new MongoAuthenticationOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (collectionName != null) ret.setCollectionName(collectionName) 
      if (passwordCredentialField != null) ret.setPasswordCredentialField(passwordCredentialField) 
      if (passwordField != null) ret.setPasswordField(passwordField) 
      if (usernameCredentialField != null) ret.setUsernameCredentialField(usernameCredentialField) 
      if (usernameField != null) ret.setUsernameField(usernameField) 
      ret
    }
  }



  type MongoAuthorizationOptions = io.vertx.ext.auth.mongo.MongoAuthorizationOptions
  object MongoAuthorizationOptions {
    def apply() = new MongoAuthorizationOptions()
    def apply(json: JsonObject) = new MongoAuthorizationOptions(json)
    def apply( collectionName: java.lang.String = null, permissionField: java.lang.String = null, roleField: java.lang.String = null, usernameField: java.lang.String = null): MongoAuthorizationOptions = {
      val ret = new MongoAuthorizationOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (collectionName != null) ret.setCollectionName(collectionName) 
      if (permissionField != null) ret.setPermissionField(permissionField) 
      if (roleField != null) ret.setRoleField(roleField) 
      if (usernameField != null) ret.setUsernameField(usernameField) 
      ret
    }
  }



}
