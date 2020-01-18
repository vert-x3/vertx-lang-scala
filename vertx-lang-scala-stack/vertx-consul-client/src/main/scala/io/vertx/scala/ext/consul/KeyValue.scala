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

import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.ext.consul.{KeyValue => JKeyValue}

/**
 * Represents key/value pair stored in Consul
 */

class KeyValue(private val _asJava: JKeyValue) {
  def asJava = _asJava
  /**
   * Set the internal index value that represents when the entry was created.
   */
  def setCreateIndex(value: Long) = {
    asJava.setCreateIndex(value)
    this
  }

  def getCreateIndex: Long = {
    asJava.getCreateIndex().asInstanceOf[Long]
  }

  /**
   * Set the flags attached to this entry. Clients can choose to use this however makes sense for their application.
   */
  def setFlags(value: Long) = {
    asJava.setFlags(value)
    this
  }

  def getFlags: Long = {
    asJava.getFlags().asInstanceOf[Long]
  }

  /**
   * Set the key
   */
  def setKey(value: String) = {
    asJava.setKey(value)
    this
  }

  def getKey: String = {
    asJava.getKey().asInstanceOf[String]
  }

  /**
   * Set the number of times this key has successfully been acquired in a lock.
   */
  def setLockIndex(value: Long) = {
    asJava.setLockIndex(value)
    this
  }

  def getLockIndex: Long = {
    asJava.getLockIndex().asInstanceOf[Long]
  }

  /**
   * Set the last index that modified this key.
   */
  def setModifyIndex(value: Long) = {
    asJava.setModifyIndex(value)
    this
  }

  def getModifyIndex: Long = {
    asJava.getModifyIndex().asInstanceOf[Long]
  }

  /**
   * Set the session that owns the lock
   */
  def setSession(value: String) = {
    asJava.setSession(value)
    this
  }

  def getSession: String = {
    asJava.getSession().asInstanceOf[String]
  }

  /**
   * Set the value
   */
  def setValue(value: String) = {
    asJava.setValue(value)
    this
  }

  def getValue: String = {
    asJava.getValue().asInstanceOf[String]
  }

}


object KeyValue {

  def apply() = {
    new KeyValue(new JKeyValue(emptyObj()))
  }

  def apply(t: JKeyValue) = {
    if (t != null) {
      new KeyValue(t)
    } else {
      new KeyValue(new JKeyValue(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): KeyValue = {
    if (json != null) {
      new KeyValue(new JKeyValue(json))
    } else {
      new KeyValue(new JKeyValue(emptyObj()))
    }
  }
}

