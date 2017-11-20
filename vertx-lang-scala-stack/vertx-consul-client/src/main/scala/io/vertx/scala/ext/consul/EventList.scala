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
import io.vertx.ext.consul.{EventList => JEventList}

/**
  * Holds result of events query
  */
class EventList(private val _asJava: JEventList) {

  def asJava = _asJava

  /**
    * Set Consul index, a unique identifier representing the current state of the requested events
    */
  def setIndex(value: Long) = {
    asJava.setIndex(value)
    this
  }
  def getIndex: Long = {
    asJava.getIndex().asInstanceOf[Long]
  }

  /**
    * Set list of events
    */
  def setList(value: scala.collection.mutable.Buffer[Event]) = {
    asJava.setList(value.map(_.asJava).asJava)
    this
  }
  def getList: scala.collection.mutable.Buffer[Event] = {
    asJava.getList().asScala.map(x => Event(x))
  }
}

object EventList {
  
  def apply() = {
    new EventList(new JEventList(emptyObj()))
  }
  
  def apply(t: JEventList) = {
    if (t != null) {
      new EventList(t)
    } else {
      new EventList(new JEventList(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): EventList = {
    if (json != null) {
      new EventList(new JEventList(json))
    } else {
      new EventList(new JEventList(emptyObj()))
    }
  }
}
