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

import io.vertx.ext.consul.{PreparedQueryExecuteOptions => JPreparedQueryExecuteOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Options used to execute prepared query
 */

class PreparedQueryExecuteOptions(private val _asJava: JPreparedQueryExecuteOptions) {
  def asJava = _asJava
  /**
   * Set the size of the list to the given number of nodes. This is applied after any sorting or shuffling.
   */
  def setLimit(value: Int) = {
    asJava.setLimit(value)
    this
  }

  def getLimit: Int = {
    asJava.getLimit().asInstanceOf[Int]
  }

  /**
   * Set node name for sorting the list in ascending order based on the estimated round trip time from that node.
   * Passing `_agent` will use the agent's node for the sort. If this is not present,
   * the default behavior will shuffle the nodes randomly each time the query is executed.
   */
  def setNear(value: String) = {
    asJava.setNear(value)
    this
  }

  def getNear: String = {
    asJava.getNear().asInstanceOf[String]
  }

}


object PreparedQueryExecuteOptions {
  
  def apply() = {
    new PreparedQueryExecuteOptions(new JPreparedQueryExecuteOptions(emptyObj()))
  }
  
  def apply(t: JPreparedQueryExecuteOptions) = {
    if (t != null) {
      new PreparedQueryExecuteOptions(t)
    } else {
      new PreparedQueryExecuteOptions(new JPreparedQueryExecuteOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): PreparedQueryExecuteOptions = {
    if (json != null) {
      new PreparedQueryExecuteOptions(new JPreparedQueryExecuteOptions(json))
    } else {
      new PreparedQueryExecuteOptions(new JPreparedQueryExecuteOptions(emptyObj()))
    }
  }
}

