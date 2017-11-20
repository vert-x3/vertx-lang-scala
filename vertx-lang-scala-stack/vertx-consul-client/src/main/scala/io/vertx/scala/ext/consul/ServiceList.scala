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
import io.vertx.ext.consul.{ServiceList => JServiceList}

/**
  * Holds result of services query
  */
class ServiceList(private val _asJava: JServiceList) {

  def asJava = _asJava

  /**
    * Set Consul index, a unique identifier representing the current state of the requested list of services
    */
  def setIndex(value: Long) = {
    asJava.setIndex(value)
    this
  }
  def getIndex: Long = {
    asJava.getIndex().asInstanceOf[Long]
  }

  /**
    * Set list of services
    */
  def setList(value: scala.collection.mutable.Buffer[Service]) = {
    asJava.setList(value.map(_.asJava).asJava)
    this
  }
  def getList: scala.collection.mutable.Buffer[Service] = {
    asJava.getList().asScala.map(x => Service(x))
  }
}

object ServiceList {
  
  def apply() = {
    new ServiceList(new JServiceList(emptyObj()))
  }
  
  def apply(t: JServiceList) = {
    if (t != null) {
      new ServiceList(t)
    } else {
      new ServiceList(new JServiceList(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): ServiceList = {
    if (json != null) {
      new ServiceList(new JServiceList(json))
    } else {
      new ServiceList(new JServiceList(emptyObj()))
    }
  }
}
