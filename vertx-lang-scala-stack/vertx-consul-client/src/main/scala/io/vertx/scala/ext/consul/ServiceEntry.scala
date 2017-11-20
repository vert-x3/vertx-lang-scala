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
import io.vertx.ext.consul.{ServiceEntry => JServiceEntry}

/**
  * Holds properties of service, node and related checks
  */
class ServiceEntry(private val _asJava: JServiceEntry) {

  def asJava = _asJava

  /**
    * Set list of checks
    */
  def setChecks(value: scala.collection.mutable.Buffer[Check]) = {
    asJava.setChecks(value.map(_.asJava).asJava)
    this
  }
  def getChecks: scala.collection.mutable.Buffer[Check] = {
    asJava.getChecks().asScala.map(x => Check(x))
  }

  /**
    * Set node
    */
  def setNode(value: Node) = {
    asJava.setNode(value.asJava)
    this
  }
  def getNode: Node = {
    Node(asJava.getNode())
  }

  /**
    * Set service
    */
  def setService(value: Service) = {
    asJava.setService(value.asJava)
    this
  }
  def getService: Service = {
    Service(asJava.getService())
  }
}

object ServiceEntry {
  
  def apply() = {
    new ServiceEntry(new JServiceEntry(emptyObj()))
  }
  
  def apply(t: JServiceEntry) = {
    if (t != null) {
      new ServiceEntry(t)
    } else {
      new ServiceEntry(new JServiceEntry(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): ServiceEntry = {
    if (json != null) {
      new ServiceEntry(new JServiceEntry(json))
    } else {
      new ServiceEntry(new JServiceEntry(emptyObj()))
    }
  }
}
