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


package io.vertx.scala.ext

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.auth.{PubSecKeyOptions => JPubSecKeyOptions}
import io.vertx.core.buffer.Buffer
package object auth{





  type JWTOptions = io.vertx.ext.auth.JWTOptions
  object JWTOptions {
    def apply() = new JWTOptions()
    def apply(json: JsonObject) = new JWTOptions(json)
  }



  type KeyStoreOptions = io.vertx.ext.auth.KeyStoreOptions
  object KeyStoreOptions {
    def apply() = new KeyStoreOptions()
    def apply(json: JsonObject) = new KeyStoreOptions(json)
  }



  type PubSecKeyOptions = io.vertx.ext.auth.PubSecKeyOptions
  object PubSecKeyOptions {
    def apply() = new PubSecKeyOptions()
    def apply(json: JsonObject) = new PubSecKeyOptions(json)
  }



  type TokenCredentials = io.vertx.ext.auth.authentication.TokenCredentials
  object TokenCredentials {
    def apply(json: JsonObject) = new TokenCredentials(json)
    def apply(str: String) = new TokenCredentials(str)
  }



  type UsernamePasswordCredentials = io.vertx.ext.auth.authentication.UsernamePasswordCredentials
  object UsernamePasswordCredentials {
    def apply(json: JsonObject) = new UsernamePasswordCredentials(json)
  }



}
