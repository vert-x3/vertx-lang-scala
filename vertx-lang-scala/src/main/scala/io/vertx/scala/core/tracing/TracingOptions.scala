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

package io.vertx.scala.core.tracing

import io.vertx.core.json.JsonObject
import io.vertx.core.tracing.{TracingOptions => JTracingOptions}
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Vert.x tracing base configuration, this class can be extended by provider implementations to configure
 * those specific implementations.
 */

class TracingOptions(private val _asJava: JTracingOptions) {
  def asJava = _asJava
  /**
   * Set whether tracing will be enabled on the Vert.x instance.
   */
  def setEnabled(value: Boolean) = {
    asJava.setEnabled(value)
    this
  }

  def isEnabled: Boolean = {
    asJava.isEnabled().asInstanceOf[Boolean]
  }

}


object TracingOptions {
  
  def apply() = {
    new TracingOptions(new JTracingOptions(emptyObj()))
  }
  
  def apply(t: JTracingOptions) = {
    if (t != null) {
      new TracingOptions(t)
    } else {
      new TracingOptions(new JTracingOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): TracingOptions = {
    if (json != null) {
      new TracingOptions(new JTracingOptions(json))
    } else {
      new TracingOptions(new JTracingOptions(emptyObj()))
    }
  }
}

