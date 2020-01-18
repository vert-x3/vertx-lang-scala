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
import io.vertx.ext.consul.{CheckQueryOptions => JCheckQueryOptions}

/**
 * Options used to requesting list of checks
 */

class CheckQueryOptions(private val _asJava: JCheckQueryOptions) {
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
   * Set node name for sorting the list in ascending order based on the estimated round trip time from that node.
   */
  def setNear(value: String) = {
    asJava.setNear(value)
    this
  }

  def getNear: String = {
    asJava.getNear().asInstanceOf[String]
  }

}


object CheckQueryOptions {

  def apply() = {
    new CheckQueryOptions(new JCheckQueryOptions(emptyObj()))
  }

  def apply(t: JCheckQueryOptions) = {
    if (t != null) {
      new CheckQueryOptions(t)
    } else {
      new CheckQueryOptions(new JCheckQueryOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): CheckQueryOptions = {
    if (json != null) {
      new CheckQueryOptions(new JCheckQueryOptions(json))
    } else {
      new CheckQueryOptions(new JCheckQueryOptions(emptyObj()))
    }
  }
}

