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

import io.vertx.ext.consul.{PreparedQueryExecuteResponse => JPreparedQueryExecuteResponse}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * The results of executing prepared query
 */

class PreparedQueryExecuteResponse(private val _asJava: JPreparedQueryExecuteResponse) {
  def asJava = _asJava
  /**
   * Set the datacenter that ultimately provided the list of nodes
   */
  def setDc(value: String) = {
    asJava.setDc(value)
    this
  }

  def getDc: String = {
    asJava.getDc().asInstanceOf[String]
  }

  /**
   * Set the TTL duration when query results are served over DNS. If this is specified, it will take precedence over any Consul agent-specific configuration.
   */
  def setDnsTtl(value: String) = {
    asJava.setDnsTtl(value)
    this
  }

  def getDnsTtl: String = {
    asJava.getDnsTtl().asInstanceOf[String]
  }

  /**
   * Set the number of remote datacenters that were queried while executing the query.
   */
  def setFailovers(value: Int) = {
    asJava.setFailovers(value)
    this
  }

  def getFailovers: Int = {
    asJava.getFailovers().asInstanceOf[Int]
  }

  /**
   * Set the list of healthy nodes providing the given service, as specified by the constraints of the prepared query.
   */
  def setNodes(value: scala.collection.mutable.Buffer[ServiceEntry]) = {
    asJava.setNodes(value.map(_.asJava).asJava)
    this
  }

  def getNodes: scala.collection.mutable.Buffer[ServiceEntry] = {
    asJava.getNodes().asScala.map(x => ServiceEntry(x))
  }

  /**
   * Set the service name that the query was selecting.
   * This is useful for context in case an empty list of nodes is returned.
   */
  def setService(value: String) = {
    asJava.setService(value)
    this
  }

  def getService: String = {
    asJava.getService().asInstanceOf[String]
  }

}


object PreparedQueryExecuteResponse {
  
  def apply() = {
    new PreparedQueryExecuteResponse(new JPreparedQueryExecuteResponse(emptyObj()))
  }
  
  def apply(t: JPreparedQueryExecuteResponse) = {
    if (t != null) {
      new PreparedQueryExecuteResponse(t)
    } else {
      new PreparedQueryExecuteResponse(new JPreparedQueryExecuteResponse(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): PreparedQueryExecuteResponse = {
    if (json != null) {
      new PreparedQueryExecuteResponse(new JPreparedQueryExecuteResponse(json))
    } else {
      new PreparedQueryExecuteResponse(new JPreparedQueryExecuteResponse(emptyObj()))
    }
  }
}

