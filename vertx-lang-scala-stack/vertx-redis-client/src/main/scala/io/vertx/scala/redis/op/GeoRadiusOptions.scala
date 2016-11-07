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
import io.vertx.redis.op.{GeoRadiusOptions => JGeoRadiusOptions}

/**
  */

class GeoRadiusOptions(val asJava: JGeoRadiusOptions) {

  /**
    * Set the radius options limit the result count.
    */
  def setCount(value: Long) = {
    asJava.setCount(value)
    this
  }

  /**
    * Set the radius options to be coordinate based.
    */
  def setWithCoord(value: Boolean) = {
    asJava.setWithCoord(value)
    this
  }

  /**
    * Set the radius options to be distance based.
    */
  def setWithDist(value: Boolean) = {
    asJava.setWithDist(value)
    this
  }

  /**
    * Set the radius options to be hash based.
    */
  def setWithHash(value: Boolean) = {
    asJava.setWithHash(value)
    this
  }
}

object GeoRadiusOptions {
  
  def apply() = {
    new GeoRadiusOptions(new JGeoRadiusOptions(emptyObj()))
  }
  
  def apply(t: JGeoRadiusOptions) = {
    if(t != null)
      new GeoRadiusOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):GeoRadiusOptions = {
    if(json != null)
      new GeoRadiusOptions(new JGeoRadiusOptions(json))
    else
      null
  }
}
