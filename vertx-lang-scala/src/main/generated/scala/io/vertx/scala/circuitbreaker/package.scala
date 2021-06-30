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

import io.vertx.circuitbreaker.{CircuitBreakerOptions => JCircuitBreakerOptions}
package object circuitbreaker{


  type CircuitBreakerOptions = io.vertx.circuitbreaker.CircuitBreakerOptions
  object CircuitBreakerOptions {
    def apply() = new CircuitBreakerOptions()
    def apply(json: JsonObject) = new CircuitBreakerOptions(json)
    def apply( failuresRollingWindow: java.lang.Long = null, fallbackOnFailure: java.lang.Boolean = null, maxFailures: java.lang.Integer = null, maxRetries: java.lang.Integer = null, metricsRollingBuckets: java.lang.Integer = null, metricsRollingWindow: java.lang.Long = null, notificationAddress: java.lang.String = null, notificationPeriod: java.lang.Long = null, resetTimeout: java.lang.Long = null, timeout: java.lang.Long = null): CircuitBreakerOptions = {
      val ret = new CircuitBreakerOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (failuresRollingWindow != null) ret.setFailuresRollingWindow(failuresRollingWindow) 
      if (fallbackOnFailure != null) ret.setFallbackOnFailure(fallbackOnFailure) 
      if (maxFailures != null) ret.setMaxFailures(maxFailures) 
      if (maxRetries != null) ret.setMaxRetries(maxRetries) 
      if (metricsRollingBuckets != null) ret.setMetricsRollingBuckets(metricsRollingBuckets) 
      if (metricsRollingWindow != null) ret.setMetricsRollingWindow(metricsRollingWindow) 
      if (notificationAddress != null) ret.setNotificationAddress(notificationAddress) 
      if (notificationPeriod != null) ret.setNotificationPeriod(notificationPeriod) 
      if (resetTimeout != null) ret.setResetTimeout(resetTimeout) 
      if (timeout != null) ret.setTimeout(timeout) 
      ret
    }
  }



}
