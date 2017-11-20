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
import io.vertx.ext.consul.{CheckOptions => JCheckOptions}

/**
  * Options used to register checks in Consul.
  */
class CheckOptions(private val _asJava: JCheckOptions) {

  def asJava = _asJava

  /**
    * Set deregister timeout. This is optional field, which is a timeout in the same time format as Interval and TTL.
    * If a check is associated with a service and has the critical state for more than this configured value,
    * then its associated service (and all of its associated checks) will automatically be deregistered.
    * The minimum timeout is 1 minute, and the process that reaps critical services runs every 30 seconds,
    * so it may take slightly longer than the configured timeout to trigger the deregistration.
    * This should generally be configured with a timeout that's much, much longer than any expected recoverable outage
    * for the given service.
    */
  def setDeregisterAfter(value: String) = {
    asJava.setDeregisterAfter(value)
    this
  }
  def getDeregisterAfter: String = {
    asJava.getDeregisterAfter().asInstanceOf[String]
  }

  /**
    * Set HTTP address to check. Also you should set checking interval
    */
  def setHttp(value: String) = {
    asJava.setHttp(value)
    this
  }
  def getHttp: String = {
    asJava.getHttp().asInstanceOf[String]
  }

  /**
    * Set check ID
    */
  def setId(value: String) = {
    asJava.setId(value)
    this
  }
  def getId: String = {
    asJava.getId().asInstanceOf[String]
  }

  /**
    * Set checking interval
    */
  def setInterval(value: String) = {
    asJava.setInterval(value)
    this
  }
  def getInterval: String = {
    asJava.getInterval().asInstanceOf[String]
  }

  /**
    * Set check name. This is mandatory field
    */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }
  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
    * Set check notes
    */
  def setNotes(value: String) = {
    asJava.setNotes(value)
    this
  }
  def getNotes: String = {
    asJava.getNotes().asInstanceOf[String]
  }

  /**
    * Set path to checking script. Also you should set checking interval
    */
  def setScript(value: String) = {
    asJava.setScript(value)
    this
  }
  def getScript: String = {
    asJava.getScript().asInstanceOf[String]
  }

  /**
    * Set the service ID to associate the registered check with an existing service provided by the agent.
    */
  def setServiceId(value: String) = {
    asJava.setServiceId(value)
    this
  }
  def getServiceId: String = {
    asJava.getServiceId().asInstanceOf[String]
  }

  /**
    * Set the check status to specify the initial state of the health check.
    */
  def setStatus(value: io.vertx.ext.consul.CheckStatus) = {
    asJava.setStatus(value)
    this
  }
  def getStatus: io.vertx.ext.consul.CheckStatus = {
    asJava.getStatus()
  }

  /**
    * Set TCP address to check. Also you should set checking interval
    */
  def setTcp(value: String) = {
    asJava.setTcp(value)
    this
  }
  def getTcp: String = {
    asJava.getTcp().asInstanceOf[String]
  }

  /**
    * Set Time to Live of check.
    */
  def setTtl(value: String) = {
    asJava.setTtl(value)
    this
  }
  def getTtl: String = {
    asJava.getTtl().asInstanceOf[String]
  }
}

object CheckOptions {
  
  def apply() = {
    new CheckOptions(new JCheckOptions(emptyObj()))
  }
  
  def apply(t: JCheckOptions) = {
    if (t != null) {
      new CheckOptions(t)
    } else {
      new CheckOptions(new JCheckOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): CheckOptions = {
    if (json != null) {
      new CheckOptions(new JCheckOptions(json))
    } else {
      new CheckOptions(new JCheckOptions(emptyObj()))
    }
  }
}
