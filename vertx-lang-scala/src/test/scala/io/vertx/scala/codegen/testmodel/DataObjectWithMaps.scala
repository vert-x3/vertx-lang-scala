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

package io.vertx.scala.codegen.testmodel

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._
import io.vertx.lang.scala.json.Json._
import io.vertx.codegen.testmodel.{DataObjectWithMaps => JDataObjectWithMaps}
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject

/**
  */

class DataObjectWithMaps(val asJava: JDataObjectWithMaps) {
  def setBooleanValues(value: Map[String, Boolean]) = {
    asJava.setBooleanValues(value.mapValues(Boolean.box))
    this
  }
  def setDataObjectValues(value: Map[String, TestDataObject]) = {
    asJava.setDataObjectValues(value.mapValues(_.asJava))
    this
  }
  def setDoubleValues(value: Map[String, Double]) = {
    asJava.setDoubleValues(value.mapValues(Double.box))
    this
  }
  def setEnumValues(value: Map[String, io.vertx.codegen.testmodel.TestEnum]) = {
    asJava.setEnumValues(value)
    this
  }
  def setFloatValues(value: Map[String, Float]) = {
    asJava.setFloatValues(value.mapValues(Float.box))
    this
  }
  def setGenEnumValues(value: Map[String, io.vertx.codegen.testmodel.TestGenEnum]) = {
    asJava.setGenEnumValues(value)
    this
  }
  def setIntegerValues(value: Map[String, Int]) = {
    asJava.setIntegerValues(value.mapValues(Int.box))
    this
  }
  def setJsonArrayValues(value: Map[String, JsonArray]) = {
    asJava.setJsonArrayValues(value)
    this
  }
  def setJsonObjectValues(value: Map[String, JsonObject]) = {
    asJava.setJsonObjectValues(value)
    this
  }
  def setLongValues(value: Map[String, Long]) = {
    asJava.setLongValues(value.mapValues(Long.box))
    this
  }
  def setShortValues(value: Map[String, Short]) = {
    asJava.setShortValues(value.mapValues(Short.box))
    this
  }
  def setStringValues(value: Map[String, String]) = {
    asJava.setStringValues(value)
    this
  }
}

object DataObjectWithMaps {
  
  def apply() = {
    new DataObjectWithMaps(new JDataObjectWithMaps(emptyObj()))
  }
  
  def apply(t: JDataObjectWithMaps) = {
    if(t != null)
      new DataObjectWithMaps(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):DataObjectWithMaps = {
    if(json != null)
      new DataObjectWithMaps(new JDataObjectWithMaps(json))
    else
      null
  }
}
