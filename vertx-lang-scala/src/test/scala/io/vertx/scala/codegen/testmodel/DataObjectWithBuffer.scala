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
import io.vertx.codegen.testmodel.{DataObjectWithBuffer => JDataObjectWithBuffer}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}

/**
  */

class DataObjectWithBuffer(val asJava: JDataObjectWithBuffer) {
  def setBuffer(value: JBuffer) = {
    asJava.setBuffer(value)
    this
  }
  def getBuffer = {
    asJava.getBuffer()
  }
}

object DataObjectWithBuffer {
  
  def apply() = {
    new DataObjectWithBuffer(new JDataObjectWithBuffer(emptyObj()))
  }
  
  def apply(t: JDataObjectWithBuffer) = {
    if(t != null)
      new DataObjectWithBuffer(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):DataObjectWithBuffer = {
    if(json != null)
      new DataObjectWithBuffer(new JDataObjectWithBuffer(json))
    else
      null
  }
}
