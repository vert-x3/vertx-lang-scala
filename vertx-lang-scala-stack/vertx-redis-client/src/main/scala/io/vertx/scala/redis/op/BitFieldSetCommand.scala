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

import io.vertx.redis.op.{BitFieldSetCommand => JBitFieldSetCommand}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._


class BitFieldSetCommand(private val _asJava: JBitFieldSetCommand) {
  def asJava = _asJava
  def setOffset(value: Long) = {
    asJava.setOffset(value)
    this
  }

  def getOffset: Long = {
    asJava.getOffset().asInstanceOf[Long]
  }

  def setType(value: String) = {
    asJava.setType(value)
    this
  }

  def getType: String = {
    asJava.getType().asInstanceOf[String]
  }

  def setValue(value: Long) = {
    asJava.setValue(value)
    this
  }

  def getValue: Long = {
    asJava.getValue().asInstanceOf[Long]
  }

}


object BitFieldSetCommand {
  
  def apply() = {
    new BitFieldSetCommand(new JBitFieldSetCommand(emptyObj()))
  }
  
  def apply(t: JBitFieldSetCommand) = {
    if (t != null) {
      new BitFieldSetCommand(t)
    } else {
      new BitFieldSetCommand(new JBitFieldSetCommand(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): BitFieldSetCommand = {
    if (json != null) {
      new BitFieldSetCommand(new JBitFieldSetCommand(json))
    } else {
      new BitFieldSetCommand(new JBitFieldSetCommand(emptyObj()))
    }
  }
}

