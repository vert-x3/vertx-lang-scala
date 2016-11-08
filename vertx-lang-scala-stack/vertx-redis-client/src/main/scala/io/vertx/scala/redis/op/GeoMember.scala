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
import io.vertx.redis.op.{GeoMember => JGeoMember}

/**
  */

class GeoMember(val asJava: JGeoMember) {

  /**
    * Set Latitude as per EPSG:900913 / EPSG:3785 / OSGEO:41001
    */
  def setLatitude(value: Double) = {
    asJava.setLatitude(value)
    this
  }

  /**
    * Set Longitude as per EPSG:900913 / EPSG:3785 / OSGEO:41001
    */
  def setLongitude(value: Double) = {
    asJava.setLongitude(value)
    this
  }

  /**
    * Set the member name.
    */
  def setMember(value: String) = {
    asJava.setMember(value)
    this
  }
}

object GeoMember {
  
  def apply() = {
    new GeoMember(new JGeoMember(emptyObj()))
  }
  
  def apply(t: JGeoMember) = {
    if(t != null)
      new GeoMember(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):GeoMember = {
    if(json != null)
      new GeoMember(new JGeoMember(json))
    else
      null
  }
}
