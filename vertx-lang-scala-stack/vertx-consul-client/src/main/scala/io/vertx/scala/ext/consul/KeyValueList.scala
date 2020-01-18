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

import io.vertx.ext.consul.{KeyValueList => JKeyValueList}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Holds result of key/value pairs query
 */

class KeyValueList(private val _asJava: JKeyValueList) {
  def asJava = _asJava
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
   * Set list of key/value pairs
   */
  def setList(value: scala.collection.mutable.Buffer[KeyValue]) = {
    asJava.setList(value.map(_.asJava).asJava)
    this
  }

  def getList: scala.collection.mutable.Buffer[KeyValue] = {
    asJava.getList().asScala.map(x => KeyValue(x))
  }

}


object KeyValueList {

  def apply() = {
    new KeyValueList(new JKeyValueList(emptyObj()))
  }

  def apply(t: JKeyValueList) = {
    if (t != null) {
      new KeyValueList(t)
    } else {
      new KeyValueList(new JKeyValueList(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): KeyValueList = {
    if (json != null) {
      new KeyValueList(new JKeyValueList(json))
    } else {
      new KeyValueList(new JKeyValueList(emptyObj()))
    }
  }
}

