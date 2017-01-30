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
import io.vertx.codegen.testmodel.{DataObjectWithRecursion => JDataObjectWithRecursion}

/**
  */
class DataObjectWithRecursion(private val _asJava: JDataObjectWithRecursion) {

  def asJava = _asJava
  def setData(value: String) = {
    asJava.setData(value)
    this
  }
  def getData: String = {
    asJava.getData().asInstanceOf[String]
  }
  def setNext(value: DataObjectWithRecursion) = {
    asJava.setNext(value.asJava)
    this
  }
  def getNext: DataObjectWithRecursion = {
    DataObjectWithRecursion(asJava.getNext())
  }
}

object DataObjectWithRecursion {
  
  def apply() = {
    new DataObjectWithRecursion(new JDataObjectWithRecursion(emptyObj()))
  }
  
  def apply(t: JDataObjectWithRecursion) = {
    if(t != null)
      new DataObjectWithRecursion(t)
    else
      null
  }
  
  def fromJson(json: JsonObject): DataObjectWithRecursion = {
    if(json != null)
      new DataObjectWithRecursion(new JDataObjectWithRecursion(json))
    else
      null
  }
}
