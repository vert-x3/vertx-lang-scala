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

import io.vertx.ext.auth
import io.vertx.ext.auth.mongo.{MongoAuthOptions => JMongoAuthOptions}
import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.{AuthOptions => JAuthOptions}
package object mongo{


  type MongoAuthOptions = io.vertx.ext.auth.mongo.MongoAuthOptions
  object MongoAuthOptions {
    def apply() = new MongoAuthOptions()
    def apply(json: JsonObject) = new MongoAuthOptions(json)
  }



  type MongoAuthenticationOptions = io.vertx.ext.auth.mongo.MongoAuthenticationOptions
  object MongoAuthenticationOptions {
    def apply() = new MongoAuthenticationOptions()
    def apply(json: JsonObject) = new MongoAuthenticationOptions(json)
  }



  type MongoAuthorizationOptions = io.vertx.ext.auth.mongo.MongoAuthorizationOptions
  object MongoAuthorizationOptions {
    def apply() = new MongoAuthorizationOptions()
    def apply(json: JsonObject) = new MongoAuthorizationOptions(json)
  }



}
