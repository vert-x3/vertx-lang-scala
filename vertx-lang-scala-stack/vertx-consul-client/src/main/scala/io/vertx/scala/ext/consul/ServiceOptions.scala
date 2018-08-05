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
import io.vertx.ext.consul.{ServiceOptions => JServiceOptions}

/**
 * Options used to register service.
 */

class ServiceOptions(private val _asJava: JServiceOptions) {
  def asJava = _asJava
  /**
   * Set service address
   */
  def setAddress(value: String) = {
    asJava.setAddress(value)
    this
  }

  def getAddress: String = {
    asJava.getAddress().asInstanceOf[String]
  }

  /**
   * Set check options of service
   */
  def setCheckOptions(value: CheckOptions) = {
    asJava.setCheckOptions(value.asJava)
    this
  }

  def getCheckOptions: CheckOptions = {
    CheckOptions(asJava.getCheckOptions())
  }

  /**
   * Set the ID of session
   */
  def setId(value: String) = {
    asJava.setId(value)
    this
  }

  def getId: String = {
    asJava.getId().asInstanceOf[String]
  }

  /**
   * Set service name
   */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }

  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
   * Set service port
   */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }

  def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }

  /**
   * Set list of tags associated with service
   */
  def setTags(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setTags(value.asJava)
    this
  }

  def getTags: scala.collection.mutable.Buffer[String] = {
    asJava.getTags().asScala.map(x => x.asInstanceOf[String])
  }

}


object ServiceOptions {
  
  def apply() = {
    new ServiceOptions(new JServiceOptions(emptyObj()))
  }
  
  def apply(t: JServiceOptions) = {
    if (t != null) {
      new ServiceOptions(t)
    } else {
      new ServiceOptions(new JServiceOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): ServiceOptions = {
    if (json != null) {
      new ServiceOptions(new JServiceOptions(json))
    } else {
      new ServiceOptions(new JServiceOptions(emptyObj()))
    }
  }
}

