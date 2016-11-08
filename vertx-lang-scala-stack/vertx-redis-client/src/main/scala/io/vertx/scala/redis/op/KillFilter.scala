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

package io.vertx.scala.redis.op

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.redis.op.{KillFilter => JKillFilter}
import io.vertx.redis.op.KillFilter.Type

/**
  */

class KillFilter(val asJava: JKillFilter) {

  /**
    * Set ADDR filter
    */
  def setAddr(value: String) = {
    asJava.setAddr(value)
    this
  }

  /**
    * Set ID filter
    */
  def setId(value: String) = {
    asJava.setId(value)
    this
  }

  /**
    * Set SKIPME filter
    */
  def setSkipme(value: Boolean) = {
    asJava.setSkipme(value)
    this
  }

  /**
    * Set TYPE filter
    */
  def setType(value: io.vertx.redis.op.KillFilter.Type) = {
    asJava.setType(value)
    this
  }
}

object KillFilter {
  
  def apply() = {
    new KillFilter(new JKillFilter(emptyObj()))
  }
  
  def apply(t: JKillFilter) = {
    if(t != null)
      new KillFilter(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):KillFilter = {
    if(json != null)
      new KillFilter(new JKillFilter(json))
    else
      null
  }
}
