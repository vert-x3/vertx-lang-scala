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

package io.vertx.scala.ext.hawkular

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.hawkular.{VertxHawkularOptions => JVertxHawkularOptions}
import io.vertx.core.json.JsonObject
import io.vertx.core.http.{HttpClientOptions => JHttpClientOptions}
import io.vertx.scala.core.http.HttpClientOptions

/**
  * Vert.x Hawkular monitoring configuration.
  */

class VertxHawkularOptions(val asJava: JVertxHawkularOptions) {

  /**
    * Set the options for authentication.
    */
  def setAuthenticationOptions(value: AuthenticationOptions) = {
    asJava.setAuthenticationOptions(value.asJava)
    this
  }
  def getAuthenticationOptions = {
    asJava.getAuthenticationOptions()
  }

  /**
    * Set the maximum delay between two consecutive batches (in seconds). To reduce the number of HTTP exchanges, metric
    * data is sent to the Hawkular server in batches. A batch is sent as soon as the number of metrics collected reaches
    * the configured `batchSize`, or after the `batchDelay` expires. Defaults to `1` second.
    */
  def setBatchDelay(value: Int) = {
    asJava.setBatchDelay(value)
    this
  }
  def getBatchDelay = {
    asJava.getBatchDelay()
  }

  /**
    * Set the maximum number of metrics in a batch. To reduce the number of HTTP exchanges, metric data is sent to the
    * Hawkular server in batches. A batch is sent as soon as the number of metrics collected reaches the configured
    * `batchSize`, or after the `batchDelay` expires. Defaults to `50`.
    */
  def setBatchSize(value: Int) = {
    asJava.setBatchSize(value)
    this
  }
  def getBatchSize = {
    asJava.getBatchSize()
  }

  /**
    * Sets metrics types that are disabled.
    */
  def addDisabledMetricsType(value: io.vertx.ext.hawkular.MetricsType) = {
    asJava.addDisabledMetricsType(value)
    this
  }
  def setDisabledMetricsTypes(value: Set[io.vertx.ext.hawkular.MetricsType]) = {
    asJava.setDisabledMetricsTypes(value.asJava)
    this
  }
  def getDisabledMetricsTypes = {
    asJava.getDisabledMetricsTypes()
  }

  /**
    * Set whether metrics will be enabled on the Vert.x instance. Metrics are not enabled by default.
    */
  def setEnabled(value: Boolean) = {
    asJava.setEnabled(value)
    this
  }
  def isEnabled = {
    asJava.isEnabled()
  }

  /**
    * Set the Hawkular Metrics service host. Defaults to `localhost`.
    */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }
  def getHost = {
    asJava.getHost()
  }

  /**
    * Set specific headers to include in HTTP requests.
    */
  def setHttpHeaders(value: JsonObject) = {
    asJava.setHttpHeaders(value)
    this
  }
  def getHttpHeaders = {
    asJava.getHttpHeaders()
  }

  /**
    * Set the configuration of the Hawkular Metrics HTTP client.
    */
  def setHttpOptions(value: HttpClientOptions) = {
    asJava.setHttpOptions(value.asJava)
    this
  }
  def getHttpOptions = {
    asJava.getHttpOptions()
  }

  /**
    * Sets the metric bridge address on which the application is sending the custom metrics. Application can send
    * metrics to this event bus address. The message is a JSON object specifying at least the `id` and
    * `value` fields.
    * <p/>
    * Don't forget to also enable the bridge with `metricsBridgeEnabled`.
    */
  def setMetricsBridgeAddress(value: String) = {
    asJava.setMetricsBridgeAddress(value)
    this
  }
  def getMetricsBridgeAddress = {
    asJava.getMetricsBridgeAddress()
  }

  /**
    * Sets whether or not the metrics bridge should be enabled. The metrics bridge is disabled by default.
    */
  def setMetricsBridgeEnabled(value: Boolean) = {
    asJava.setMetricsBridgeEnabled(value)
    this
  }
  def isMetricsBridgeEnabled = {
    asJava.isMetricsBridgeEnabled()
  }

  /**
    * Set the Hawkular Metrics service URI. Defaults to `/hawkular/metrics`. This can be useful if you host the
    * Hawkular server behind a proxy and manipulate the default service URI.
    */
  def setMetricsServiceUri(value: String) = {
    asJava.setMetricsServiceUri(value)
    this
  }
  def getMetricsServiceUri = {
    asJava.getMetricsServiceUri()
  }

  /**
    * Set the Hawkular Metrics service port.  Defaults to `8080`.
    */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  def getPort = {
    asJava.getPort()
  }

  /**
    * Set the metric name prefix. Metric names are not prefixed by default. Prefixing metric names is required to
    * distinguish data sent by different Vert.x instances.
    */
  def setPrefix(value: String) = {
    asJava.setPrefix(value)
    this
  }
  def getPrefix = {
    asJava.getPrefix()
  }

  /**
    * Set the metric collection interval (in seconds). Defaults to `1`.
    */
  def setSchedule(value: Int) = {
    asJava.setSchedule(value)
    this
  }
  def getSchedule = {
    asJava.getSchedule()
  }

  /**
    * Set whether Hawkular tenant header should be sent. Defaults to `true`.
    * Must be set to `false` when working with pre-Alpha13 Hawkular servers.
    */
  def setSendTenantHeader(value: Boolean) = {
    asJava.setSendTenantHeader(value)
    this
  }
  def isSendTenantHeader = {
    asJava.isSendTenantHeader()
  }

  /**
    * Set the Hawkular tenant. Defaults to `default`.
    */
  def setTenant(value: String) = {
    asJava.setTenant(value)
    this
  }
  def getTenant = {
    asJava.getTenant()
  }
}

object VertxHawkularOptions {
  
  def apply() = {
    new VertxHawkularOptions(new JVertxHawkularOptions(emptyObj()))
  }
  
  def apply(t: JVertxHawkularOptions) = {
    if(t != null)
      new VertxHawkularOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):VertxHawkularOptions = {
    if(json != null)
      new VertxHawkularOptions(new JVertxHawkularOptions(json))
    else
      null
  }
}
