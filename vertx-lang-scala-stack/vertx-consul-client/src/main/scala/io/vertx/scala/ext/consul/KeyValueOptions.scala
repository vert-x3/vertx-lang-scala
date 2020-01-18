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

import io.vertx.ext.consul.{KeyValueOptions => JKeyValueOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Options used to put key/value pair to Consul.
 */

class KeyValueOptions(private val _asJava: JKeyValueOptions) {
  def asJava = _asJava
  /**
   * Set session ID for lock acquisition operation.
   */
  def setAcquireSession(value: String) = {
    asJava.setAcquireSession(value)
    this
  }

  def getAcquireSession: String = {
    asJava.getAcquireSession().asInstanceOf[String]
  }

  /**
   * Set the Check-And-Set index. If the index is `0`, Consul will only put the key if it does not already exist.
   * If the index is non-zero, the key is only set if the index matches the ModifyIndex of that key.
   */
  def setCasIndex(value: Long) = {
    asJava.setCasIndex(value)
    this
  }

  def getCasIndex: Long = {
    asJava.getCasIndex().asInstanceOf[Long]
  }

  /**
   * Set the flags. Flags is an value between `0` and 2<sup>64</sup>-1 that can be attached to each entry.
   * Clients can choose to use this however makes sense for their application.
   */
  def setFlags(value: Long) = {
    asJava.setFlags(value)
    this
  }

  def getFlags: Long = {
    asJava.getFlags().asInstanceOf[Long]
  }

  /**
   * Set session ID for lock release operation.
   */
  def setReleaseSession(value: String) = {
    asJava.setReleaseSession(value)
    this
  }

  def getReleaseSession: String = {
    asJava.getReleaseSession().asInstanceOf[String]
  }

}


object KeyValueOptions {

  def apply() = {
    new KeyValueOptions(new JKeyValueOptions(emptyObj()))
  }

  def apply(t: JKeyValueOptions) = {
    if (t != null) {
      new KeyValueOptions(t)
    } else {
      new KeyValueOptions(new JKeyValueOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): KeyValueOptions = {
    if (json != null) {
      new KeyValueOptions(new JKeyValueOptions(json))
    } else {
      new KeyValueOptions(new JKeyValueOptions(emptyObj()))
    }
  }
}

