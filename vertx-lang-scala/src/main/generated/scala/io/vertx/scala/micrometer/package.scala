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
    def apply( alias: java.lang.String = null, domain: io.vertx.micrometer.MetricsDomain = null, label: java.lang.String = null, `type`: io.vertx.micrometer.MatchType = null, value: java.lang.String = null): Match = {
      val ret = new Match(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (alias != null) ret.setAlias(alias) 
      if (domain != null) ret.setDomain(domain) 
      if (label != null) ret.setLabel(label) 
      if (`type` != null) ret.setType(`type`) 
      if (value != null) ret.setValue(value) 
      ret
    }
  }



  type MetricsNaming = io.vertx.micrometer.MetricsNaming
  object MetricsNaming {
    def apply() = new MetricsNaming()
    def apply(json: JsonObject) = new MetricsNaming(json)
    def apply( clientProcessingPending: java.lang.String = null, clientProcessingTime: java.lang.String = null, clientQueuePending: java.lang.String = null, clientQueueTime: java.lang.String = null, clientResetsCount: java.lang.String = null, datagramBytesRead: java.lang.String = null, datagramBytesWritten: java.lang.String = null, datagramErrorCount: java.lang.String = null, ebBytesRead: java.lang.String = null, ebBytesWritten: java.lang.String = null, ebDelivered: java.lang.String = null, ebDiscarded: java.lang.String = null, ebHandlers: java.lang.String = null, ebPending: java.lang.String = null, ebProcessed: java.lang.String = null, ebPublished: java.lang.String = null, ebReceived: java.lang.String = null, ebReplyFailures: java.lang.String = null, ebSent: java.lang.String = null, httpActiveRequests: java.lang.String = null, httpActiveWsConnections: java.lang.String = null, httpQueuePending: java.lang.String = null, httpQueueTime: java.lang.String = null, httpRequestBytes: java.lang.String = null, httpRequestResetsCount: java.lang.String = null, httpRequestsCount: java.lang.String = null, httpResponseBytes: java.lang.String = null, httpResponseTime: java.lang.String = null, httpResponsesCount: java.lang.String = null, netActiveConnections: java.lang.String = null, netBytesRead: java.lang.String = null, netBytesWritten: java.lang.String = null, netErrorCount: java.lang.String = null, poolCompleted: java.lang.String = null, poolInUse: java.lang.String = null, poolQueuePending: java.lang.String = null, poolQueueTime: java.lang.String = null, poolUsage: java.lang.String = null, poolUsageRatio: java.lang.String = null): MetricsNaming = {
      val ret = new MetricsNaming(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (clientProcessingPending != null) ret.setClientProcessingPending(clientProcessingPending) 
      if (clientProcessingTime != null) ret.setClientProcessingTime(clientProcessingTime) 
      if (clientQueuePending != null) ret.setClientQueuePending(clientQueuePending) 
      if (clientQueueTime != null) ret.setClientQueueTime(clientQueueTime) 
      if (clientResetsCount != null) ret.setClientResetsCount(clientResetsCount) 
      if (datagramBytesRead != null) ret.setDatagramBytesRead(datagramBytesRead) 
      if (datagramBytesWritten != null) ret.setDatagramBytesWritten(datagramBytesWritten) 
      if (datagramErrorCount != null) ret.setDatagramErrorCount(datagramErrorCount) 
      if (ebBytesRead != null) ret.setEbBytesRead(ebBytesRead) 
      if (ebBytesWritten != null) ret.setEbBytesWritten(ebBytesWritten) 
      if (ebDelivered != null) ret.setEbDelivered(ebDelivered) 
      if (ebDiscarded != null) ret.setEbDiscarded(ebDiscarded) 
      if (ebHandlers != null) ret.setEbHandlers(ebHandlers) 
      if (ebPending != null) ret.setEbPending(ebPending) 
      if (ebProcessed != null) ret.setEbProcessed(ebProcessed) 
      if (ebPublished != null) ret.setEbPublished(ebPublished) 
      if (ebReceived != null) ret.setEbReceived(ebReceived) 
      if (ebReplyFailures != null) ret.setEbReplyFailures(ebReplyFailures) 
      if (ebSent != null) ret.setEbSent(ebSent) 
      if (httpActiveRequests != null) ret.setHttpActiveRequests(httpActiveRequests) 
      if (httpActiveWsConnections != null) ret.setHttpActiveWsConnections(httpActiveWsConnections) 
      if (httpQueuePending != null) ret.setHttpQueuePending(httpQueuePending) 
      if (httpQueueTime != null) ret.setHttpQueueTime(httpQueueTime) 
      if (httpRequestBytes != null) ret.setHttpRequestBytes(httpRequestBytes) 
      if (httpRequestResetsCount != null) ret.setHttpRequestResetsCount(httpRequestResetsCount) 
      if (httpRequestsCount != null) ret.setHttpRequestsCount(httpRequestsCount) 
      if (httpResponseBytes != null) ret.setHttpResponseBytes(httpResponseBytes) 
      if (httpResponseTime != null) ret.setHttpResponseTime(httpResponseTime) 
      if (httpResponsesCount != null) ret.setHttpResponsesCount(httpResponsesCount) 
      if (netActiveConnections != null) ret.setNetActiveConnections(netActiveConnections) 
      if (netBytesRead != null) ret.setNetBytesRead(netBytesRead) 
      if (netBytesWritten != null) ret.setNetBytesWritten(netBytesWritten) 
      if (netErrorCount != null) ret.setNetErrorCount(netErrorCount) 
      if (poolCompleted != null) ret.setPoolCompleted(poolCompleted) 
      if (poolInUse != null) ret.setPoolInUse(poolInUse) 
      if (poolQueuePending != null) ret.setPoolQueuePending(poolQueuePending) 
      if (poolQueueTime != null) ret.setPoolQueueTime(poolQueueTime) 
      if (poolUsage != null) ret.setPoolUsage(poolUsage) 
      if (poolUsageRatio != null) ret.setPoolUsageRatio(poolUsageRatio) 
      ret
    }
  }



  type MicrometerMetricsOptions = io.vertx.micrometer.MicrometerMetricsOptions
  object MicrometerMetricsOptions {
    def apply() = new MicrometerMetricsOptions()
    def apply(json: JsonObject) = new MicrometerMetricsOptions(json)
    def apply( disabledMetricsCategories: scala.collection.immutable.Set[java.lang.String] = null, enabled: java.lang.Boolean = null, factory: io.vertx.core.spi.VertxMetricsFactory = null, influxDbOptions: io.vertx.micrometer.VertxInfluxDbOptions = null, jmxMetricsOptions: io.vertx.micrometer.VertxJmxMetricsOptions = null, jvmMetricsEnabled: java.lang.Boolean = null, labelMatches: scala.collection.immutable.List[io.vertx.micrometer.Match] = null, labels: scala.collection.immutable.Set[io.vertx.micrometer.Label] = null, metricsNaming: io.vertx.micrometer.MetricsNaming = null, micrometerRegistry: io.micrometer.core.instrument.MeterRegistry = null, prometheusOptions: io.vertx.micrometer.VertxPrometheusOptions = null, registryName: java.lang.String = null): MicrometerMetricsOptions = {
      val ret = new MicrometerMetricsOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (disabledMetricsCategories != null) ret.setDisabledMetricsCategories(disabledMetricsCategories.asJava) 
      if (enabled != null) ret.setEnabled(enabled) 
      if (factory != null) ret.setFactory(factory) 
      if (influxDbOptions != null) ret.setInfluxDbOptions(influxDbOptions) 
      if (jmxMetricsOptions != null) ret.setJmxMetricsOptions(jmxMetricsOptions) 
      if (jvmMetricsEnabled != null) ret.setJvmMetricsEnabled(jvmMetricsEnabled) 
      if (labelMatches != null) ret.setLabelMatches(labelMatches.asJava) 
      if (labels != null) ret.setLabels(labels.asJava) 
      if (metricsNaming != null) ret.setMetricsNaming(metricsNaming) 
      if (micrometerRegistry != null) ret.setMicrometerRegistry(micrometerRegistry) 
      if (prometheusOptions != null) ret.setPrometheusOptions(prometheusOptions) 
      if (registryName != null) ret.setRegistryName(registryName) 
      ret
    }
  }



  type VertxInfluxDbOptions = io.vertx.micrometer.VertxInfluxDbOptions
  object VertxInfluxDbOptions {
    def apply() = new VertxInfluxDbOptions()
    def apply(json: JsonObject) = new VertxInfluxDbOptions(json)
    def apply( batchSize: java.lang.Integer = null, bucket: java.lang.String = null, compressed: java.lang.Boolean = null, connectTimeout: java.lang.Integer = null, db: java.lang.String = null, enabled: java.lang.Boolean = null, numThreads: java.lang.Integer = null, org: java.lang.String = null, password: java.lang.String = null, readTimeout: java.lang.Integer = null, retentionPolicy: java.lang.String = null, step: java.lang.Integer = null, token: java.lang.String = null, uri: java.lang.String = null, userName: java.lang.String = null): VertxInfluxDbOptions = {
      val ret = new VertxInfluxDbOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (batchSize != null) ret.setBatchSize(batchSize) 
      if (bucket != null) ret.setBucket(bucket) 
      if (compressed != null) ret.setCompressed(compressed) 
      if (connectTimeout != null) ret.setConnectTimeout(connectTimeout) 
      if (db != null) ret.setDb(db) 
      if (enabled != null) ret.setEnabled(enabled) 
      if (numThreads != null) ret.setNumThreads(numThreads) 
      if (org != null) ret.setOrg(org) 
      if (password != null) ret.setPassword(password) 
      if (readTimeout != null) ret.setReadTimeout(readTimeout) 
      if (retentionPolicy != null) ret.setRetentionPolicy(retentionPolicy) 
      if (step != null) ret.setStep(step) 
      if (token != null) ret.setToken(token) 
      if (uri != null) ret.setUri(uri) 
      if (userName != null) ret.setUserName(userName) 
      ret
    }
  }



  type VertxJmxMetricsOptions = io.vertx.micrometer.VertxJmxMetricsOptions
  object VertxJmxMetricsOptions {
    def apply() = new VertxJmxMetricsOptions()
    def apply(json: JsonObject) = new VertxJmxMetricsOptions(json)
    def apply( domain: java.lang.String = null, enabled: java.lang.Boolean = null, step: java.lang.Integer = null): VertxJmxMetricsOptions = {
      val ret = new VertxJmxMetricsOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (domain != null) ret.setDomain(domain) 
      if (enabled != null) ret.setEnabled(enabled) 
      if (step != null) ret.setStep(step) 
      ret
    }
  }



  type VertxPrometheusOptions = io.vertx.micrometer.VertxPrometheusOptions
  object VertxPrometheusOptions {
    def apply() = new VertxPrometheusOptions()
    def apply(json: JsonObject) = new VertxPrometheusOptions(json)
    def apply( embeddedServerEndpoint: java.lang.String = null, embeddedServerOptions: io.vertx.core.http.HttpServerOptions = null, enabled: java.lang.Boolean = null, publishQuantiles: java.lang.Boolean = null, startEmbeddedServer: java.lang.Boolean = null): VertxPrometheusOptions = {
      val ret = new VertxPrometheusOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (embeddedServerEndpoint != null) ret.setEmbeddedServerEndpoint(embeddedServerEndpoint) 
      if (embeddedServerOptions != null) ret.setEmbeddedServerOptions(embeddedServerOptions) 
      if (enabled != null) ret.setEnabled(enabled) 
      if (publishQuantiles != null) ret.setPublishQuantiles(publishQuantiles) 
      if (startEmbeddedServer != null) ret.setStartEmbeddedServer(startEmbeddedServer) 
      ret
    }
  }



}
