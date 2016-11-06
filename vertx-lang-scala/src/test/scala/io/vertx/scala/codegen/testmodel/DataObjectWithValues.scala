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
import io.vertx.codegen.testmodel.{DataObjectWithValues => JDataObjectWithValues}
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject

/**
  */

class DataObjectWithValues(val asJava: JDataObjectWithValues) {
  def setBooleanValue(value: Boolean) = {
    asJava.setBooleanValue(value)
    this
  }
  def setBoxedBooleanValue(value: Boolean) = {
    asJava.setBoxedBooleanValue(value)
    this
  }
  def setBoxedDoubleValue(value: Double) = {
    asJava.setBoxedDoubleValue(value)
    this
  }
  def setBoxedFloatValue(value: Float) = {
    asJava.setBoxedFloatValue(value)
    this
  }
  def setBoxedIntValue(value: Int) = {
    asJava.setBoxedIntValue(value)
    this
  }
  def setBoxedLongValue(value: Long) = {
    asJava.setBoxedLongValue(value)
    this
  }
  def setBoxedShortValue(value: Short) = {
    asJava.setBoxedShortValue(value)
    this
  }
  def setDataObjectValue(value: TestDataObject) = {
    asJava.setDataObjectValue(value.asJava)
    this
  }
  def setDoubleValue(value: Double) = {
    asJava.setDoubleValue(value)
    this
  }
  def setEnumValue(value: io.vertx.codegen.testmodel.TestEnum) = {
    asJava.setEnumValue(value)
    this
  }
  def setFloatValue(value: Float) = {
    asJava.setFloatValue(value)
    this
  }
  def setGenEnumValue(value: io.vertx.codegen.testmodel.TestGenEnum) = {
    asJava.setGenEnumValue(value)
    this
  }
  def setIntValue(value: Int) = {
    asJava.setIntValue(value)
    this
  }
  def setJsonArrayValue(value: JsonArray) = {
    asJava.setJsonArrayValue(value)
    this
  }
  def setJsonObjectValue(value: JsonObject) = {
    asJava.setJsonObjectValue(value)
    this
  }
  def setLongValue(value: Long) = {
    asJava.setLongValue(value)
    this
  }
  def setShortValue(value: Short) = {
    asJava.setShortValue(value)
    this
  }
  def setStringValue(value: String) = {
    asJava.setStringValue(value)
    this
  }
}

object DataObjectWithValues {
  
  def apply() = {
    new DataObjectWithValues(new JDataObjectWithValues(emptyObj()))
  }
  
  def apply(t: JDataObjectWithValues) = {
    if(t != null)
      new DataObjectWithValues(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):DataObjectWithValues = {
    if(json != null)
      new DataObjectWithValues(new JDataObjectWithValues(json))
    else
      null
  }
}
