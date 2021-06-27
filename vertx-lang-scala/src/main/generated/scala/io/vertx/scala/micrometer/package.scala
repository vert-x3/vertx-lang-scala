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

import io.vertx.micrometer.{VertxJmxMetricsOptions => JVertxJmxMetricsOptions}
package object micrometer{


  type Match = io.vertx.micrometer.Match
  object Match {
    def apply() = new Match()
    def apply(json: JsonObject) = new Match(json)
  }



  type MetricsNaming = io.vertx.micrometer.MetricsNaming
  object MetricsNaming {
    def apply() = new MetricsNaming()
    def apply(json: JsonObject) = new MetricsNaming(json)
  }



  type MicrometerMetricsOptions = io.vertx.micrometer.MicrometerMetricsOptions
  object MicrometerMetricsOptions {
    def apply() = new MicrometerMetricsOptions()
    def apply(json: JsonObject) = new MicrometerMetricsOptions(json)
  }



  type VertxInfluxDbOptions = io.vertx.micrometer.VertxInfluxDbOptions
  object VertxInfluxDbOptions {
    def apply() = new VertxInfluxDbOptions()
    def apply(json: JsonObject) = new VertxInfluxDbOptions(json)
  }



  type VertxJmxMetricsOptions = io.vertx.micrometer.VertxJmxMetricsOptions
  object VertxJmxMetricsOptions {
    def apply() = new VertxJmxMetricsOptions()
    def apply(json: JsonObject) = new VertxJmxMetricsOptions(json)
  }



  type VertxPrometheusOptions = io.vertx.micrometer.VertxPrometheusOptions
  object VertxPrometheusOptions {
    def apply() = new VertxPrometheusOptions()
    def apply(json: JsonObject) = new VertxPrometheusOptions(json)
  }



}
