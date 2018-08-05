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

import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.{DataObjectWithMapAdders => JDataObjectWithMapAdders}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**

 */

class DataObjectWithMapAdders(private val _asJava: JDataObjectWithMapAdders) {
  def asJava = _asJava
  def addBooleanValue(key: String, value: Boolean) = {
    asJava.addBooleanValue(key, value.asInstanceOf[java.lang.Boolean])
    this
  }

  def addDataObjectValue(key: String, value: TestDataObject) = {
    asJava.addDataObjectValue(key, value.asJava)
    this
  }

  def addDoubleValue(key: String, value: Double) = {
    asJava.addDoubleValue(key, value.asInstanceOf[java.lang.Double])
    this
  }

  def addEnumValue(key: String, value: io.vertx.codegen.testmodel.TestEnum) = {
    asJava.addEnumValue(key, value)
    this
  }

  def addFloatValue(key: String, value: Float) = {
    asJava.addFloatValue(key, value.asInstanceOf[java.lang.Float])
    this
  }

  def addGenEnumValue(key: String, value: io.vertx.codegen.testmodel.TestGenEnum) = {
    asJava.addGenEnumValue(key, value)
    this
  }

  def addInstantValue(key: String, value: java.time.Instant) = {
    asJava.addInstantValue(key, value.asInstanceOf[java.time.Instant])
    this
  }

  def addIntegerValue(key: String, value: Int) = {
    asJava.addIntegerValue(key, value.asInstanceOf[java.lang.Integer])
    this
  }

  def addJsonArrayValue(key: String, value: io.vertx.core.json.JsonArray) = {
    asJava.addJsonArrayValue(key, value)
    this
  }

  def addJsonObjectValue(key: String, value: io.vertx.core.json.JsonObject) = {
    asJava.addJsonObjectValue(key, value)
    this
  }

  def addLongValue(key: String, value: Long) = {
    asJava.addLongValue(key, value.asInstanceOf[java.lang.Long])
    this
  }

  def addShortValue(key: String, value: Short) = {
    asJava.addShortValue(key, value.asInstanceOf[java.lang.Short])
    this
  }

  def addStringValue(key: String, value: String) = {
    asJava.addStringValue(key, value.asInstanceOf[java.lang.String])
    this
  }

}


object DataObjectWithMapAdders {
  
  def apply() = {
    new DataObjectWithMapAdders(new JDataObjectWithMapAdders(emptyObj()))
  }
  
  def apply(t: JDataObjectWithMapAdders) = {
    if (t != null) {
      new DataObjectWithMapAdders(t)
    } else {
      new DataObjectWithMapAdders(new JDataObjectWithMapAdders(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): DataObjectWithMapAdders = {
    if (json != null) {
      new DataObjectWithMapAdders(new JDataObjectWithMapAdders(json))
    } else {
      new DataObjectWithMapAdders(new JDataObjectWithMapAdders(emptyObj()))
    }
  }
}

