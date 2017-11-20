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
import io.vertx.ext.consul.{EventListOptions => JEventListOptions}

/**
  * Holds options for events list request
  */
class EventListOptions(private val _asJava: JEventListOptions) {

  def asJava = _asJava

  /**
    * Set options for blocking query
    */
  def setBlockingOptions(value: BlockingQueryOptions) = {
    asJava.setBlockingOptions(value.asJava)
    this
  }
  def getBlockingOptions: BlockingQueryOptions = {
    BlockingQueryOptions(asJava.getBlockingOptions())
  }

  /**
    * Set event name for filtering on events
    */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }
  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }
}

object EventListOptions {
  
  def apply() = {
    new EventListOptions(new JEventListOptions(emptyObj()))
  }
  
  def apply(t: JEventListOptions) = {
    if (t != null) {
      new EventListOptions(t)
    } else {
      new EventListOptions(new JEventListOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): EventListOptions = {
    if (json != null) {
      new EventListOptions(new JEventListOptions(json))
    } else {
      new EventListOptions(new JEventListOptions(emptyObj()))
    }
  }
}
