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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.{DataObjectWithListAdders => JDataObjectWithListAdders}
import io.vertx.core.json.JsonObject

/**
  */
class DataObjectWithListAdders(private val _asJava: JDataObjectWithListAdders) {

  def asJava = _asJava
  def addBooleanValue(value: Boolean) = {
    asJava.addBooleanValue(value)
    this
  }
  def addDataObjectValue(value: TestDataObject) = {
    asJava.addDataObjectValue(value.asJava)
    this
  }
  def addDoubleValue(value: Double) = {
    asJava.addDoubleValue(value)
    this
  }
  def addEnumValue(value: io.vertx.codegen.testmodel.TestEnum) = {
    asJava.addEnumValue(value)
    this
  }
  def addFloatValue(value: Float) = {
    asJava.addFloatValue(value)
    this
  }
  def addGenEnumValue(value: io.vertx.codegen.testmodel.TestGenEnum) = {
    asJava.addGenEnumValue(value)
    this
  }
  def addInstantValue(value: java.time.Instant) = {
    asJava.addInstantValue(value.asInstanceOf)
    this
  }
  def addIntegerValue(value: Int) = {
    asJava.addIntegerValue(value)
    this
  }
  def addJsonArrayValue(value: io.vertx.core.json.JsonArray) = {
    asJava.addJsonArrayValue(value)
    this
  }
  def addJsonObjectValue(value: io.vertx.core.json.JsonObject) = {
    asJava.addJsonObjectValue(value)
    this
  }
  def addLongValue(value: Long) = {
    asJava.addLongValue(value)
    this
  }
  def addShortValue(value: Short) = {
    asJava.addShortValue(value)
    this
  }
  def addStringValue(value: String) = {
    asJava.addStringValue(value)
    this
  }
}

object DataObjectWithListAdders {
  
  def apply() = {
    new DataObjectWithListAdders(new JDataObjectWithListAdders(emptyObj()))
  }
  
  def apply(t: JDataObjectWithListAdders) = {
    if (t != null) {
      new DataObjectWithListAdders(t)
    } else {
      new DataObjectWithListAdders(new JDataObjectWithListAdders(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): DataObjectWithListAdders = {
    if (json != null) {
      new DataObjectWithListAdders(new JDataObjectWithListAdders(json))
    } else {
      new DataObjectWithListAdders(new JDataObjectWithListAdders(emptyObj()))
    }
  }
}
