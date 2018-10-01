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

import io.vertx.ext.consul.{CheckList => JCheckList}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Holds result of checks query
 */

class CheckList(private val _asJava: JCheckList) {
  def asJava = _asJava
  /**
   * Set Consul index, a unique identifier representing the current state of the requested list of checks
   */
  def setIndex(value: Long) = {
    asJava.setIndex(value)
    this
  }

  def getIndex: Long = {
    asJava.getIndex().asInstanceOf[Long]
  }

  /**
   * Set list of checks
   */
  def setList(value: scala.collection.mutable.Buffer[Check]) = {
    asJava.setList(value.map(_.asJava).asJava)
    this
  }

  def getList: scala.collection.mutable.Buffer[Check] = {
    asJava.getList().asScala.map(x => Check(x))
  }

}


object CheckList {
  
  def apply() = {
    new CheckList(new JCheckList(emptyObj()))
  }
  
  def apply(t: JCheckList) = {
    if (t != null) {
      new CheckList(t)
    } else {
      new CheckList(new JCheckList(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): CheckList = {
    if (json != null) {
      new CheckList(new JCheckList(json))
    } else {
      new CheckList(new JCheckList(emptyObj()))
    }
  }
}

