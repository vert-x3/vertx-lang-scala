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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.core.json.JsonObject

/**
  * Describes a `service`. The record is the only piece of information shared between consumer and provider. It should
  * contains enough metadata to let consumer find the service they want.
  */
class Record(private val _asJava: JRecord) {

  def asJava = _asJava

  /**
    * Sets the json object describing the location of the service. By convention, this json object should contain
    * the <a href="../../../../../../cheatsheet/Record.html">Record</a> entry.
    */
  def setLocation(value: io.vertx.core.json.JsonObject) = {
    asJava.setLocation(value)
    this
  }
  def getLocation: io.vertx.core.json.JsonObject = {
    asJava.getLocation()
  }

  /**
    * Gets the metadata attached to the record.
    */
  def setMetadata(value: io.vertx.core.json.JsonObject) = {
    asJava.setMetadata(value)
    this
  }
  def getMetadata: io.vertx.core.json.JsonObject = {
    asJava.getMetadata()
  }

  /**
    * Sets the name of the service. It can reflect the service name of the name of the provider.
    */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }
  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
    * Sets the registration id. This method is called when the service is published.
    */
  def setRegistration(value: String) = {
    asJava.setRegistration(value)
    this
  }
  def getRegistration: String = {
    asJava.getRegistration().asInstanceOf[String]
  }

  /**
    * Sets the status of the service. When published, the status is set to. When withdrawn, the
    * status is set to .
    */
  def setStatus(value: io.vertx.servicediscovery.Status) = {
    asJava.setStatus(value)
    this
  }
  def getStatus: io.vertx.servicediscovery.Status = {
    asJava.getStatus()
  }

  /**
    * Sets the type of service.
    */
  def setType(value: String) = {
    asJava.setType(value)
    this
  }
  def getType: String = {
    asJava.getType().asInstanceOf[String]
  }
}

object Record {
  
  def apply() = {
    new Record(new JRecord(emptyObj()))
  }
  
  def apply(t: JRecord) = {
    if(t != null)
      new Record(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):Record = {
    if(json != null)
      new Record(new JRecord(json))
    else
      null
  }
}
