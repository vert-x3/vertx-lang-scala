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
    def apply( endpoint: java.lang.String = null, host: java.lang.String = null, port: java.lang.Integer = null, root: java.lang.String = null, ssl: java.lang.Boolean = null): HttpLocation = {
      val ret = new HttpLocation(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (endpoint != null) ret.setEndpoint(endpoint) 
      if (host != null) ret.setHost(host) 
      if (port != null) ret.setPort(port) 
      if (root != null) ret.setRoot(root) 
      if (ssl != null) ret.setSsl(ssl) 
      ret
    }
  }



  type Record = io.vertx.servicediscovery.Record
  object Record {
    def apply() = new Record()
    def apply(json: JsonObject) = new Record(json)
    def apply( location: io.vertx.core.json.JsonObject = null, metadata: io.vertx.core.json.JsonObject = null, name: java.lang.String = null, registration: java.lang.String = null, status: io.vertx.servicediscovery.Status = null, `type`: java.lang.String = null): Record = {
      val ret = new Record(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (location != null) ret.setLocation(location) 
      if (metadata != null) ret.setMetadata(metadata) 
      if (name != null) ret.setName(name) 
      if (registration != null) ret.setRegistration(registration) 
      if (status != null) ret.setStatus(status) 
      if (`type` != null) ret.setType(`type`) 
      ret
    }
  }



  type ServiceDiscoveryOptions = io.vertx.servicediscovery.ServiceDiscoveryOptions
  object ServiceDiscoveryOptions {
    def apply() = new ServiceDiscoveryOptions()
    def apply(json: JsonObject) = new ServiceDiscoveryOptions(json)
    def apply( announceAddress: java.lang.String = null, autoRegistrationOfImporters: java.lang.Boolean = null, backendConfiguration: io.vertx.core.json.JsonObject = null, name: java.lang.String = null, usageAddress: java.lang.String = null): ServiceDiscoveryOptions = {
      val ret = new ServiceDiscoveryOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (announceAddress != null) ret.setAnnounceAddress(announceAddress) 
      if (autoRegistrationOfImporters != null) ret.setAutoRegistrationOfImporters(autoRegistrationOfImporters) 
      if (backendConfiguration != null) ret.setBackendConfiguration(backendConfiguration) 
      if (name != null) ret.setName(name) 
      if (usageAddress != null) ret.setUsageAddress(usageAddress) 
      ret
    }
  }



}
