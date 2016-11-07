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

package io.vertx.scala.servicediscovery.types

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.servicediscovery.types.{HttpLocation => JHttpLocation}

/**
  * Represents the location of a HTTP endpoint. This object (its json representation) will be used as "location" in a
  * service record.
  */

class HttpLocation(val asJava: JHttpLocation) {

  /**
    * Sets the endpoint, which is the URL of the service. The endpoint is automatically computed when you use the
    * other `setX` method.
    */
  def setEndpoint(value: String) = {
    asJava.setEndpoint(value)
    this
  }
  def getEndpoint = {
    asJava.getEndpoint()
  }

  /**
    * Sets the host.
    */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }
  def getHost = {
    asJava.getHost()
  }

  /**
    * Sets the port
    */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  def getPort = {
    asJava.getPort()
  }

  /**
    * Sets the path of the service (root)
    */
  def setRoot(value: String) = {
    asJava.setRoot(value)
    this
  }
  def getRoot = {
    asJava.getRoot()
  }

  /**
    * Sets whether or not the HTTP service is using `https`.
    */
  def setSsl(value: Boolean) = {
    asJava.setSsl(value)
    this
  }
  def isSsl = {
    asJava.isSsl()
  }
}

object HttpLocation {
  
  def apply() = {
    new HttpLocation(new JHttpLocation(emptyObj()))
  }
  
  def apply(t: JHttpLocation) = {
    if(t != null)
      new HttpLocation(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):HttpLocation = {
    if(json != null)
      new HttpLocation(new JHttpLocation(json))
    else
      null
  }
}
