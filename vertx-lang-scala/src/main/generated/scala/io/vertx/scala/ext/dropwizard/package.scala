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

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.dropwizard.{Match => JMatch}
package object dropwizard{


  type DropwizardMetricsOptions = io.vertx.ext.dropwizard.DropwizardMetricsOptions
  object DropwizardMetricsOptions {
    def apply() = new DropwizardMetricsOptions()
    def apply(json: JsonObject) = new DropwizardMetricsOptions(json)
    def apply( baseName: java.lang.String = null, configPath: java.lang.String = null, enabled: java.lang.Boolean = null, factory: io.vertx.core.spi.VertxMetricsFactory = null, jmxDomain: java.lang.String = null, jmxEnabled: java.lang.Boolean = null, metricRegistry: com.codahale.metrics.MetricRegistry = null, registryName: java.lang.String = null): DropwizardMetricsOptions = {
      val ret = new DropwizardMetricsOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (baseName != null) ret.setBaseName(baseName) 
      if (configPath != null) ret.setConfigPath(configPath) 
      if (enabled != null) ret.setEnabled(enabled) 
      if (factory != null) ret.setFactory(factory) 
      if (jmxDomain != null) ret.setJmxDomain(jmxDomain) 
      if (jmxEnabled != null) ret.setJmxEnabled(jmxEnabled) 
      if (metricRegistry != null) ret.setMetricRegistry(metricRegistry) 
      if (registryName != null) ret.setRegistryName(registryName) 
      ret
    }
  }



  type Match = io.vertx.ext.dropwizard.Match
  object Match {
    def apply() = new Match()
    def apply(json: JsonObject) = new Match(json)
    def apply( alias: java.lang.String = null, `type`: io.vertx.ext.dropwizard.MatchType = null, value: java.lang.String = null): Match = {
      val ret = new Match(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (alias != null) ret.setAlias(alias) 
      if (`type` != null) ret.setType(`type`) 
      if (value != null) ret.setValue(value) 
      ret
    }
  }



}
