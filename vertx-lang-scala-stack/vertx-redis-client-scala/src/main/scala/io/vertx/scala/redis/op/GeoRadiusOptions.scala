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
import scala.collection.JavaConversions._

/**
  */

class GeoRadiusOptions(val asJava: io.vertx.redis.op.GeoRadiusOptions) {

  /**
    * Set the radius options limit the result count.
    */
  def setCount(value:Long) = {
    asJava.setCount(value)
    this
  }

  /**
    * Set the radius options to be coordinate based.
    */
  def setWithCoord(value:Boolean) = {
    asJava.setWithCoord(value)
    this
  }

  /**
    * Set the radius options to be distance based.
    */
  def setWithDist(value:Boolean) = {
    asJava.setWithDist(value)
    this
  }

  /**
    * Set the radius options to be hash based.
    */
  def setWithHash(value:Boolean) = {
    asJava.setWithHash(value)
    this
  }
}

object GeoRadiusOptions {
  type GeoRadiusOptionsJava = io.vertx.redis.op.GeoRadiusOptions
  
  def apply() = {
    new GeoRadiusOptions(new GeoRadiusOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: GeoRadiusOptionsJava) = {
    if(t != null)
      new GeoRadiusOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):GeoRadiusOptions = {
    if(json != null)
      new GeoRadiusOptions(new GeoRadiusOptionsJava(json))
    else
      null
  }
}
