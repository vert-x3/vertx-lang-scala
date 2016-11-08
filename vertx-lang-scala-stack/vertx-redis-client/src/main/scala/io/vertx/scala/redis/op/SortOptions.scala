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
import io.vertx.redis.op.{SortOptions => JSortOptions}

/**
  */

class SortOptions(val asJava: JSortOptions) {
  def setBy(value: String) = {
    asJava.setBy(value)
    this
  }
  def addGet(value: String) = {
    asJava.addGet(value)
    this
  }
  def setStore(value: String) = {
    asJava.setStore(value)
    this
  }
}

object SortOptions {
  
  def apply() = {
    new SortOptions(new JSortOptions(emptyObj()))
  }
  
  def apply(t: JSortOptions) = {
    if(t != null)
      new SortOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):SortOptions = {
    if(json != null)
      new SortOptions(new JSortOptions(json))
    else
      null
  }
}
