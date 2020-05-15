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

import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.redis.op.{BitFieldGetCommand => JBitFieldGetCommand}

/**

 */

class BitFieldGetCommand(private val _asJava: JBitFieldGetCommand) {
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

}


object BitFieldGetCommand {

  def apply() = {
    new BitFieldGetCommand(new JBitFieldGetCommand(emptyObj()))
  }

  def apply(t: JBitFieldGetCommand) = {
    if (t != null) {
      new BitFieldGetCommand(t)
    } else {
      new BitFieldGetCommand(new JBitFieldGetCommand(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): BitFieldGetCommand = {
    if (json != null) {
      new BitFieldGetCommand(new JBitFieldGetCommand(json))
    } else {
      new BitFieldGetCommand(new JBitFieldGetCommand(emptyObj()))
    }
  }
}

