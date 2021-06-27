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

import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.core.json.JsonObject
package object servicediscovery{


  type HttpLocation = io.vertx.servicediscovery.types.HttpLocation
  object HttpLocation {
    def apply() = new HttpLocation()
    def apply(json: JsonObject) = new HttpLocation(json)
  }



  type Record = io.vertx.servicediscovery.Record
  object Record {
    def apply() = new Record()
    def apply(json: JsonObject) = new Record(json)
  }



  type ServiceDiscoveryOptions = io.vertx.servicediscovery.ServiceDiscoveryOptions
  object ServiceDiscoveryOptions {
    def apply() = new ServiceDiscoveryOptions()
    def apply(json: JsonObject) = new ServiceDiscoveryOptions(json)
  }



}
