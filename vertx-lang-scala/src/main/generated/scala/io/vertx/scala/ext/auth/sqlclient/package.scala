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

import io.vertx.ext.auth.sqlclient.{SqlAuthenticationOptions => JSqlAuthenticationOptions}
package object sqlclient{


  type SqlAuthenticationOptions = io.vertx.ext.auth.sqlclient.SqlAuthenticationOptions
  object SqlAuthenticationOptions {
    def apply() = new SqlAuthenticationOptions()
    def apply(json: JsonObject) = new SqlAuthenticationOptions(json)
  }



  type SqlAuthorizationOptions = io.vertx.ext.auth.sqlclient.SqlAuthorizationOptions
  object SqlAuthorizationOptions {
    def apply() = new SqlAuthorizationOptions()
    def apply(json: JsonObject) = new SqlAuthorizationOptions(json)
  }



}
