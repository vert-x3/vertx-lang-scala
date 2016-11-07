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

package io.vertx.scala.ext.dropwizard

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.dropwizard.{DropwizardMetricsOptions => JDropwizardMetricsOptions}

/**
  * Vert.x Dropwizard metrics configuration.
  */

class DropwizardMetricsOptions(val asJava: JDropwizardMetricsOptions) {

  /**
    * Set the path for a config file that contains options in JSON format, to be used to create a new options object.
    * The file will be looked for on the file system first and then on the classpath if it's not found.
    */
  def setConfigPath(value: String) = {
    asJava.setConfigPath(value)
    this
  }
  def getConfigPath = {
    asJava.getConfigPath()
  }
  def setEnabled(value: Boolean) = {
    asJava.setEnabled(value)
    this
  }
  def isEnabled = {
    asJava.isEnabled()
  }

  /**
    * Set the JMX domain to use when JMX metrics are enabled.
    */
  def setJmxDomain(value: String) = {
    asJava.setJmxDomain(value)
    this
  }
  def getJmxDomain = {
    asJava.getJmxDomain()
  }

  /**
    * Set whether JMX will be enabled on the Vert.x instance.
    */
  def setJmxEnabled(value: Boolean) = {
    asJava.setJmxEnabled(value)
    this
  }
  def isJmxEnabled = {
    asJava.isJmxEnabled()
  }

  /**
    * Add a monitored event bus handler.
    */
  def addMonitoredEventBusHandler(value: Match) = {
    asJava.addMonitoredEventBusHandler(value.asJava)
    this
  }
  def getMonitoredEventBusHandlers = {
    asJava.getMonitoredEventBusHandlers()
  }

  /**
    */

  /**
    * Add an monitored http client endpoint.
    */
  def addMonitoredHttpClientEndpoint(value: Match) = {
    asJava.addMonitoredHttpClientEndpoint(value.asJava)
    this
  }

  /**
    * Add an monitored http client uri.
    */
  def addMonitoredHttpClientUri(value: Match) = {
    asJava.addMonitoredHttpClientUri(value.asJava)
    this
  }
  def getMonitoredHttpClientUris = {
    asJava.getMonitoredHttpClientUris()
  }

  /**
    * Add an monitored http server uri.
    */
  def addMonitoredHttpServerUri(value: Match) = {
    asJava.addMonitoredHttpServerUri(value.asJava)
    this
  }
  def getMonitoredHttpServerUris = {
    asJava.getMonitoredHttpServerUris()
  }

  /**
    * Set the name used for registering the metrics in the Dropwizard shared registry.
    */
  def setRegistryName(value: String) = {
    asJava.setRegistryName(value)
    this
  }
  def getRegistryName = {
    asJava.getRegistryName()
  }
}

object DropwizardMetricsOptions {
  
  def apply() = {
    new DropwizardMetricsOptions(new JDropwizardMetricsOptions(emptyObj()))
  }
  
  def apply(t: JDropwizardMetricsOptions) = {
    if(t != null)
      new DropwizardMetricsOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):DropwizardMetricsOptions = {
    if(json != null)
      new DropwizardMetricsOptions(new JDropwizardMetricsOptions(json))
    else
      null
  }
}
