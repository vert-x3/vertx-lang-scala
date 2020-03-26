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


package io.vertx.scala

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.proton.{ProtonTransportOptions => JProtonTransportOptions}
package object proton{


  type ProtonClientOptions = io.vertx.proton.ProtonClientOptions
  object ProtonClientOptions {
    def apply() = new ProtonClientOptions()
    def apply(json: JsonObject) = new ProtonClientOptions(json)
  }



  type ProtonLinkOptions = io.vertx.proton.ProtonLinkOptions
  object ProtonLinkOptions {
    def apply() = new ProtonLinkOptions()
    def apply(json: JsonObject) = new ProtonLinkOptions(json)
  }



  type ProtonServerOptions = io.vertx.proton.ProtonServerOptions
  object ProtonServerOptions {
    def apply() = new ProtonServerOptions()
    def apply(json: JsonObject) = new ProtonServerOptions(json)
  }



  type ProtonTransportOptions = io.vertx.proton.ProtonTransportOptions
  object ProtonTransportOptions {
    def apply() = new ProtonTransportOptions()
    def apply(json: JsonObject) = new ProtonTransportOptions(json)
  }



}
