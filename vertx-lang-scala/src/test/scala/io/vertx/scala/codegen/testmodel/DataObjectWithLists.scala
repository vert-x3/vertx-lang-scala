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
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.codegen.testmodel.{DataObjectWithLists => JDataObjectWithLists}
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject

/**
  */

class DataObjectWithLists(val asJava: JDataObjectWithLists) {
  def setBooleanValues(value: scala.collection.mutable.Buffer[Boolean]) = {
    asJava.setBooleanValues(value.map(Boolean.box).asJava)
    this
  }
  def setDataObjectValues(value: scala.collection.mutable.Buffer[TestDataObject]) = {
    asJava.setDataObjectValues(value.map(_.asJava).asJava)
    this
  }
  def setDoubleValues(value: scala.collection.mutable.Buffer[Double]) = {
    asJava.setDoubleValues(value.map(Double.box).asJava)
    this
  }
  def setEnumValues(value: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]) = {
    asJava.setEnumValues(value.asJava)
    this
  }
  def setFloatValues(value: scala.collection.mutable.Buffer[Float]) = {
    asJava.setFloatValues(value.map(Float.box).asJava)
    this
  }
  def setGenEnumValues(value: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]) = {
    asJava.setGenEnumValues(value.asJava)
    this
  }
  def setIntegerValues(value: scala.collection.mutable.Buffer[Int]) = {
    asJava.setIntegerValues(value.map(Int.box).asJava)
    this
  }
  def setJsonArrayValues(value: scala.collection.mutable.Buffer[JsonArray]) = {
    asJava.setJsonArrayValues(value.asJava)
    this
  }
  def setJsonObjectValues(value: scala.collection.mutable.Buffer[JsonObject]) = {
    asJava.setJsonObjectValues(value.asJava)
    this
  }
  def setLongValues(value: scala.collection.mutable.Buffer[Long]) = {
    asJava.setLongValues(value.map(Long.box).asJava)
    this
  }
  def setShortValues(value: scala.collection.mutable.Buffer[Short]) = {
    asJava.setShortValues(value.map(Short.box).asJava)
    this
  }
  def setStringValues(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setStringValues(value.asJava)
    this
  }
}

object DataObjectWithLists {
  
  def apply() = {
    new DataObjectWithLists(new JDataObjectWithLists(emptyObj()))
  }
  
  def apply(t: JDataObjectWithLists) = {
    if(t != null)
      new DataObjectWithLists(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):DataObjectWithLists = {
    if(json != null)
      new DataObjectWithLists(new JDataObjectWithLists(json))
    else
      null
  }
}
