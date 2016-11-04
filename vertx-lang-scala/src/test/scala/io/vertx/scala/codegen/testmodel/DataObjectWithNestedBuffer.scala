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
import io.vertx.codegen.testmodel.{DataObjectWithNestedBuffer => JDataObjectWithNestedBuffer}

/**
  */

class DataObjectWithNestedBuffer(val asJava: JDataObjectWithNestedBuffer) {
  def setBuffer(value:io.vertx.core.buffer.Buffer) = {
    asJava.setBuffer(value)
    this
  }
  def getBuffer = {
    asJava.getBuffer()
  }
  def setBuffers(value:scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer]) = {
    asJava.setBuffers(value)
    this
  }
  def getBuffers = {
    asJava.getBuffers()
  }
  def setNested(value:io.vertx.scala.codegen.testmodel.DataObjectWithBuffer) = {
    asJava.setNested(value.asJava)
    this
  }
  def getNested = {
    asJava.getNested()
  }
}

object DataObjectWithNestedBuffer {
  
  def apply() = {
    new DataObjectWithNestedBuffer(new JDataObjectWithNestedBuffer(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: JDataObjectWithNestedBuffer) = {
    if(t != null)
      new DataObjectWithNestedBuffer(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):DataObjectWithNestedBuffer = {
    if(json != null)
      new DataObjectWithNestedBuffer(new JDataObjectWithNestedBuffer(json))
    else
      null
  }
}
