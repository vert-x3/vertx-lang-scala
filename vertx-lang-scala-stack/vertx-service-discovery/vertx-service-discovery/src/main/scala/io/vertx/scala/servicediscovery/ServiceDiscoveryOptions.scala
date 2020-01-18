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

package io.vertx.scala.servicediscovery

import io.vertx.servicediscovery.{ServiceDiscoveryOptions => JServiceDiscoveryOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Options to configure the service discovery.
 */

class ServiceDiscoveryOptions(private val _asJava: JServiceDiscoveryOptions) {
  def asJava = _asJava
  /**
   * Sets the event bus address on which the service arrivals, departures and modifications are announced. This
   * address must be consistent in the whole application.
   */
  def setAnnounceAddress(value: String) = {
    asJava.setAnnounceAddress(value)
    this
  }

  def getAnnounceAddress: String = {
    asJava.getAnnounceAddress().asInstanceOf[String]
  }

  /**
   * Sets whether or not the registration of importers declared as SPI is enabled.
   */
  def setAutoRegistrationOfImporters(value: Boolean) = {
    asJava.setAutoRegistrationOfImporters(value)
    this
  }

  def isAutoRegistrationOfImporters: Boolean = {
    asJava.isAutoRegistrationOfImporters().asInstanceOf[Boolean]
  }

  /**
   * Sets the configuration passed to the .
   * Refer to the backend documentation to get more details on the requirements. The default backend
   * does not need any configuration.
   */
  def setBackendConfiguration(value: io.vertx.core.json.JsonObject) = {
    asJava.setBackendConfiguration(value)
    this
  }

  def getBackendConfiguration: io.vertx.core.json.JsonObject = {
    asJava.getBackendConfiguration()
  }

  /**
   * Sets the service discovery name used in the service usage events.
   * If not set, the node id is used.
   */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }

  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
   * Sets the usage address: the event bus address on which are sent the service usage events (bind / release).
   */
  def setUsageAddress(value: String) = {
    asJava.setUsageAddress(value)
    this
  }

  def getUsageAddress: String = {
    asJava.getUsageAddress().asInstanceOf[String]
  }

}


object ServiceDiscoveryOptions {

  def apply() = {
    new ServiceDiscoveryOptions(new JServiceDiscoveryOptions(emptyObj()))
  }

  def apply(t: JServiceDiscoveryOptions) = {
    if (t != null) {
      new ServiceDiscoveryOptions(t)
    } else {
      new ServiceDiscoveryOptions(new JServiceDiscoveryOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): ServiceDiscoveryOptions = {
    if (json != null) {
      new ServiceDiscoveryOptions(new JServiceDiscoveryOptions(json))
    } else {
      new ServiceDiscoveryOptions(new JServiceDiscoveryOptions(emptyObj()))
    }
  }
}

