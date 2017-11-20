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

package io.vertx.scala.ext.consul

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.ext.consul.{MaintenanceOptions => JMaintenanceOptions}

/**
  * Options used to placing a given service into "maintenance mode".
  * During maintenance mode, the service will be marked as unavailable
  * and will not be present in DNS or API queries. Maintenance mode is persistent
  * and will be automatically restored on agent restart.
  */
class MaintenanceOptions(private val _asJava: JMaintenanceOptions) {

  def asJava = _asJava

  /**
    * Set maintenance mode to enabled: `true` to enter maintenance mode or `false` to resume normal operation.
    * This flag is required.
    */
  def setEnable(value: Boolean) = {
    asJava.setEnable(value)
    this
  }
  def isEnable: Boolean = {
    asJava.isEnable().asInstanceOf[Boolean]
  }

  /**
    * Set the ID of service. This field is required.
    */
  def setId(value: String) = {
    asJava.setId(value)
    this
  }
  def getId: String = {
    asJava.getId().asInstanceOf[String]
  }

  /**
    * Set the reason message. If provided, its value should be a text string explaining the reason for placing
    * the service into maintenance mode. This is simply to aid human operators.
    */
  def setReason(value: String) = {
    asJava.setReason(value)
    this
  }
  def getReason: String = {
    asJava.getReason().asInstanceOf[String]
  }
}

object MaintenanceOptions {
  
  def apply() = {
    new MaintenanceOptions(new JMaintenanceOptions(emptyObj()))
  }
  
  def apply(t: JMaintenanceOptions) = {
    if (t != null) {
      new MaintenanceOptions(t)
    } else {
      new MaintenanceOptions(new JMaintenanceOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): MaintenanceOptions = {
    if (json != null) {
      new MaintenanceOptions(new JMaintenanceOptions(json))
    } else {
      new MaintenanceOptions(new JMaintenanceOptions(emptyObj()))
    }
  }
}
