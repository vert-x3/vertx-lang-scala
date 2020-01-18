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

package io.vertx.scala.core.http

import io.vertx.core.json.JsonObject
import io.vertx.core.http.{StreamPriority => JStreamPriority}
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * This class represents HTTP/2 stream priority defined in RFC 7540 clause 5.3

 */

class StreamPriority(private val _asJava: JStreamPriority) {
  def asJava = _asJava
  /**
   * Set the priority dependency value.
   */
  def setDependency(value: Int) = {
    asJava.setDependency(value)
    this
  }

  def getDependency: Int = {
    asJava.getDependency().asInstanceOf[Int]
  }

  /**
   * Set the priority exclusive value.
   */
  def setExclusive(value: Boolean) = {
    asJava.setExclusive(value)
    this
  }

  def isExclusive: Boolean = {
    asJava.isExclusive().asInstanceOf[Boolean]
  }

  /**
   * Set the priority weight.
   */
  def setWeight(value: Short) = {
    asJava.setWeight(value)
    this
  }

  def getWeight: Short = {
    asJava.getWeight().asInstanceOf[Short]
  }

}


object StreamPriority {

  def apply() = {
    new StreamPriority(new JStreamPriority(emptyObj()))
  }

  def apply(t: JStreamPriority) = {
    if (t != null) {
      new StreamPriority(t)
    } else {
      new StreamPriority(new JStreamPriority(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): StreamPriority = {
    if (json != null) {
      new StreamPriority(new JStreamPriority(json))
    } else {
      new StreamPriority(new JStreamPriority(emptyObj()))
    }
  }
}

