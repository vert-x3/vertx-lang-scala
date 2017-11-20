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
import io.vertx.ext.consul.{Check => JCheck}

/**
  * Holds check properties
  */
class Check(private val _asJava: JCheck) {

  def asJava = _asJava

  /**
    * Set the ID of check
    */
  def setId(value: String) = {
    asJava.setId(value)
    this
  }
  def getId: String = {
    asJava.getId().asInstanceOf[String]
  }

  /**
    * Set the name of check
    */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }
  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
    * Set the name of node
    */
  def setNodeName(value: String) = {
    asJava.setNodeName(value)
    this
  }
  def getNodeName: String = {
    asJava.getNodeName().asInstanceOf[String]
  }

  /**
    * Set the human-readable note of check
    */
  def setNotes(value: String) = {
    asJava.setNotes(value)
    this
  }
  def getNotes: String = {
    asJava.getNotes().asInstanceOf[String]
  }

  /**
    * Set the output of check
    */
  def setOutput(value: String) = {
    asJava.setOutput(value)
    this
  }
  def getOutput: String = {
    asJava.getOutput().asInstanceOf[String]
  }

  /**
    * Set the ID of service with which this check associated
    */
  def setServiceId(value: String) = {
    asJava.setServiceId(value)
    this
  }
  def getServiceId: String = {
    asJava.getServiceId().asInstanceOf[String]
  }

  /**
    * Set the name of service with which this check associated
    */
  def setServiceName(value: String) = {
    asJava.setServiceName(value)
    this
  }
  def getServiceName: String = {
    asJava.getServiceName().asInstanceOf[String]
  }

  /**
    * Set the status of check
    */
  def setStatus(value: io.vertx.ext.consul.CheckStatus) = {
    asJava.setStatus(value)
    this
  }
  def getStatus: io.vertx.ext.consul.CheckStatus = {
    asJava.getStatus()
  }
}

object Check {
  
  def apply() = {
    new Check(new JCheck(emptyObj()))
  }
  
  def apply(t: JCheck) = {
    if (t != null) {
      new Check(t)
    } else {
      new Check(new JCheck(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): Check = {
    if (json != null) {
      new Check(new JCheck(json))
    } else {
      new Check(new JCheck(emptyObj()))
    }
  }
}
