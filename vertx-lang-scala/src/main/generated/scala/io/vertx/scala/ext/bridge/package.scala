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

import io.vertx.ext.bridge.{PermittedOptions => JPermittedOptions}
import io.vertx.core.json.JsonObject
package object bridge{


  type BridgeOptions = io.vertx.ext.bridge.BridgeOptions
  object BridgeOptions {
    def apply() = new BridgeOptions()
    def apply(json: JsonObject) = new BridgeOptions(json)
    def apply( inboundPermitteds: scala.collection.immutable.List[io.vertx.ext.bridge.PermittedOptions] = null, outboundPermitteds: scala.collection.immutable.List[io.vertx.ext.bridge.PermittedOptions] = null): BridgeOptions = {
      val ret = new BridgeOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (inboundPermitteds != null) ret.setInboundPermitteds(inboundPermitteds.asJava) 
      if (outboundPermitteds != null) ret.setOutboundPermitteds(outboundPermitteds.asJava) 
      ret
    }
  }



  type PermittedOptions = io.vertx.ext.bridge.PermittedOptions
  object PermittedOptions {
    def apply() = new PermittedOptions()
    def apply(json: JsonObject) = new PermittedOptions(json)
    def apply( address: java.lang.String = null, addressRegex: java.lang.String = null, `match`: io.vertx.core.json.JsonObject = null, requiredAuthority: java.lang.String = null): PermittedOptions = {
      val ret = new PermittedOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (address != null) ret.setAddress(address) 
      if (addressRegex != null) ret.setAddressRegex(addressRegex) 
      if (`match` != null) ret.setMatch(`match`) 
      if (requiredAuthority != null) ret.setRequiredAuthority(requiredAuthority) 
      ret
    }
  }



}
