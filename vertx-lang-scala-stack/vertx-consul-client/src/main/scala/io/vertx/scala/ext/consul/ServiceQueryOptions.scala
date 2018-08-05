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
import io.vertx.ext.consul.{ServiceQueryOptions => JServiceQueryOptions}
import scala.collection.JavaConverters._

/**
 * Options used to requesting list of services
 */

class ServiceQueryOptions(private val _asJava: JServiceQueryOptions) {
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

  /**
   * Set tag for filtering request results
   */
  def setTag(value: String) = {
    asJava.setTag(value)
    this
  }

  def getTag: String = {
    asJava.getTag().asInstanceOf[String]
  }

}


object ServiceQueryOptions {
  
  def apply() = {
    new ServiceQueryOptions(new JServiceQueryOptions(emptyObj()))
  }
  
  def apply(t: JServiceQueryOptions) = {
    if (t != null) {
      new ServiceQueryOptions(t)
    } else {
      new ServiceQueryOptions(new JServiceQueryOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): ServiceQueryOptions = {
    if (json != null) {
      new ServiceQueryOptions(new JServiceQueryOptions(json))
    } else {
      new ServiceQueryOptions(new JServiceQueryOptions(emptyObj()))
    }
  }
}

