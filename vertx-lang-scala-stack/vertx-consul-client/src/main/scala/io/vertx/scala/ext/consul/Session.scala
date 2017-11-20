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
import io.vertx.ext.consul.{Session => JSession}

/**
  * Holds properties of Consul sessions
  */
class Session(private val _asJava: JSession) {

  def asJava = _asJava

  /**
    * Set the list of associated health checks
    */
  def setChecks(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setChecks(value.asJava)
    this
  }
  def getChecks: scala.collection.mutable.Buffer[String] = {
    asJava.getChecks().asScala.map(x => x.asInstanceOf[String])
  }

  /**
    * Set the create index of session
    */
  def setCreateIndex(value: Long) = {
    asJava.setCreateIndex(value)
    this
  }
  def getCreateIndex: Long = {
    asJava.getCreateIndex().asInstanceOf[Long]
  }

  /**
    * Set the ID of node
    */
  def setId(value: String) = {
    asJava.setId(value)
    this
  }
  def getId: String = {
    asJava.getId().asInstanceOf[String]
  }

  /**
    * Set Consul index
    */
  def setIndex(value: Long) = {
    asJava.setIndex(value)
    this
  }
  def getIndex: Long = {
    asJava.getIndex().asInstanceOf[Long]
  }

  /**
    * Set the Lock delay of session
    */
  def setLockDelay(value: Long) = {
    asJava.setLockDelay(value)
    this
  }
  def getLockDelay: Long = {
    asJava.getLockDelay().asInstanceOf[Long]
  }

  /**
    * Set the ID of node
    */
  def setNode(value: String) = {
    asJava.setNode(value)
    this
  }
  def getNode: String = {
    asJava.getNode().asInstanceOf[String]
  }
}

object Session {
  
  def apply() = {
    new Session(new JSession(emptyObj()))
  }
  
  def apply(t: JSession) = {
    if (t != null) {
      new Session(t)
    } else {
      new Session(new JSession(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): Session = {
    if (json != null) {
      new Session(new JSession(json))
    } else {
      new Session(new JSession(emptyObj()))
    }
  }
}
