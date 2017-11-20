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
import io.vertx.ext.consul.{SessionList => JSessionList}

/**
  * Holds result of sessions query
  */
class SessionList(private val _asJava: JSessionList) {

  def asJava = _asJava

  /**
    * Set Consul index, a unique identifier representing the current state of the requested list of sessions
    */
  def setIndex(value: Long) = {
    asJava.setIndex(value)
    this
  }
  def getIndex: Long = {
    asJava.getIndex().asInstanceOf[Long]
  }

  /**
    * Set list of sessions
    */
  def setList(value: scala.collection.mutable.Buffer[Session]) = {
    asJava.setList(value.map(_.asJava).asJava)
    this
  }
  def getList: scala.collection.mutable.Buffer[Session] = {
    asJava.getList().asScala.map(x => Session(x))
  }
}

object SessionList {
  
  def apply() = {
    new SessionList(new JSessionList(emptyObj()))
  }
  
  def apply(t: JSessionList) = {
    if (t != null) {
      new SessionList(t)
    } else {
      new SessionList(new JSessionList(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): SessionList = {
    if (json != null) {
      new SessionList(new JSessionList(json))
    } else {
      new SessionList(new JSessionList(emptyObj()))
    }
  }
}
