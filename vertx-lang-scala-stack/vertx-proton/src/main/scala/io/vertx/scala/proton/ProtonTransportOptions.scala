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

package io.vertx.scala.proton

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.proton.{ProtonTransportOptions => JProtonTransportOptions}

/**
  * Options for configuring transport layer
  */
class ProtonTransportOptions(private val _asJava: JProtonTransportOptions) {

  def asJava = _asJava

  /**
    * Set the heart beat as maximum delay between sending frames for the remote peers.
    * If no frames are received within 2 * heart beat, the connection is closed
    */
  def setHeartbeat(value: Int) = {
    asJava.setHeartbeat(value)
    this
  }
  def getHeartbeat: Int = {
    asJava.getHeartbeat().asInstanceOf[Int]
  }

  /**
    * Sets the maximum frame size to announce in the AMQP <em>OPEN</em> frame.
    * 
    * If this property is not set explicitly, a reasonable default value is used.
    * 
    * Setting this property to a negative value will result in no maximum frame size being announced at all.
    */
  def setMaxFrameSize(value: Int) = {
    asJava.setMaxFrameSize(value)
    this
  }
  def getMaxFrameSize: Int = {
    asJava.getMaxFrameSize().asInstanceOf[Int]
  }
}

object ProtonTransportOptions {
  
  def apply() = {
    new ProtonTransportOptions(new JProtonTransportOptions(emptyObj()))
  }
  
  def apply(t: JProtonTransportOptions) = {
    if (t != null) {
      new ProtonTransportOptions(t)
    } else {
      new ProtonTransportOptions(new JProtonTransportOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): ProtonTransportOptions = {
    if (json != null) {
      new ProtonTransportOptions(new JProtonTransportOptions(json))
    } else {
      new ProtonTransportOptions(new JProtonTransportOptions(emptyObj()))
    }
  }
}
