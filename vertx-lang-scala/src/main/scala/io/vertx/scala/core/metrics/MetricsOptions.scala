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

package io.vertx.scala.core.metrics

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._
import io.vertx.core.metrics.{MetricsOptions => JMetricsOptions}

/**
  * Vert.x metrics base configuration, this class can be extended by provider implementations to configure
  * those specific implementations.
  */

class MetricsOptions(val asJava: JMetricsOptions) {

  /**
    * Set whether metrics will be enabled on the Vert.x instance.
    */
  def setEnabled(value:Boolean) = {
    asJava.setEnabled(value)
    this
  }
  def isEnabled = {
    asJava.isEnabled()
  }
}

object MetricsOptions {
  
  def apply() = {
    new MetricsOptions(new JMetricsOptions(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: JMetricsOptions) = {
    if(t != null)
      new MetricsOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):MetricsOptions = {
    if(json != null)
      new MetricsOptions(new JMetricsOptions(json))
    else
      null
  }
}
