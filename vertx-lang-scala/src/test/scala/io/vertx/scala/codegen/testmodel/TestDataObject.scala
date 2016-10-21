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

/**
  */

class TestDataObject(val asJava: io.vertx.codegen.testmodel.TestDataObject) {
  def setBar(value:Int) = {
    asJava.setBar(value)
    this
  }
  def getBar = {
    asJava.getBar()
  }
  def setFoo(value:String) = {
    asJava.setFoo(value)
    this
  }
  def getFoo = {
    asJava.getFoo()
  }
  def setWibble(value:Double) = {
    asJava.setWibble(value)
    this
  }
  def getWibble = {
    asJava.getWibble()
  }
}

object TestDataObject {
  type TestDataObjectJava = io.vertx.codegen.testmodel.TestDataObject
  
  def apply() = {
    new TestDataObject(new TestDataObjectJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: TestDataObjectJava) = {
    if(t != null)
      new TestDataObject(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):TestDataObject = {
    if(json != null)
      new TestDataObject(new TestDataObjectJava(json))
    else
      null
  }
}
