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

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core.json.JsonObject
import io.vertx.config.{ConfigStoreOptions => JConfigStoreOptions}
package object config{


  type ConfigChange = io.vertx.config.ConfigChange
  object ConfigChange {
    def apply() = new ConfigChange()
    def apply(json: JsonObject) = new ConfigChange(json)
    def apply( newConfiguration: io.vertx.core.json.JsonObject = null, previousConfiguration: io.vertx.core.json.JsonObject = null): ConfigChange = {
      val ret = new ConfigChange(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (newConfiguration != null) ret.setNewConfiguration(newConfiguration) 
      if (previousConfiguration != null) ret.setPreviousConfiguration(previousConfiguration) 
      ret
    }
  }



  type ConfigRetrieverOptions = io.vertx.config.ConfigRetrieverOptions
  object ConfigRetrieverOptions {
    def apply() = new ConfigRetrieverOptions()
    def apply(json: JsonObject) = new ConfigRetrieverOptions(json)
    def apply( includeDefaultStores: java.lang.Boolean = null, scanPeriod: java.lang.Long = null, stores: scala.collection.immutable.List[io.vertx.config.ConfigStoreOptions] = null): ConfigRetrieverOptions = {
      val ret = new ConfigRetrieverOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (includeDefaultStores != null) ret.setIncludeDefaultStores(includeDefaultStores) 
      if (scanPeriod != null) ret.setScanPeriod(scanPeriod) 
      if (stores != null) ret.setStores(stores.asJava) 
      ret
    }
  }



  type ConfigStoreOptions = io.vertx.config.ConfigStoreOptions
  object ConfigStoreOptions {
    def apply() = new ConfigStoreOptions()
    def apply(json: JsonObject) = new ConfigStoreOptions(json)
    def apply( config: io.vertx.core.json.JsonObject = null, format: java.lang.String = null, optional: java.lang.Boolean = null, `type`: java.lang.String = null): ConfigStoreOptions = {
      val ret = new ConfigStoreOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (config != null) ret.setConfig(config) 
      if (format != null) ret.setFormat(format) 
      if (optional != null) ret.setOptional(optional) 
      if (`type` != null) ret.setType(`type`) 
      ret
    }
  }



}
