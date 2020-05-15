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

import io.vertx.redis.op.{BitFieldOptions => JBitFieldOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**

 */

class BitFieldOptions(private val _asJava: JBitFieldOptions) {
  def asJava = _asJava
  def setGet(value: BitFieldGetCommand) = {
    asJava.setGet(value.asJava)
    this
  }

  def getGet: BitFieldGetCommand = {
    BitFieldGetCommand(asJava.getGet())
  }

  def setIncrby(value: BitFieldIncrbyCommand) = {
    asJava.setIncrby(value.asJava)
    this
  }

  def getIncrby: BitFieldIncrbyCommand = {
    BitFieldIncrbyCommand(asJava.getIncrby())
  }

  def setSet(value: BitFieldSetCommand) = {
    asJava.setSet(value.asJava)
    this
  }

  def getSet: BitFieldSetCommand = {
    BitFieldSetCommand(asJava.getSet())
  }

}


object BitFieldOptions {

  def apply() = {
    new BitFieldOptions(new JBitFieldOptions(emptyObj()))
  }

  def apply(t: JBitFieldOptions) = {
    if (t != null) {
      new BitFieldOptions(t)
    } else {
      new BitFieldOptions(new JBitFieldOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): BitFieldOptions = {
    if (json != null) {
      new BitFieldOptions(new JBitFieldOptions(json))
    } else {
      new BitFieldOptions(new JBitFieldOptions(emptyObj()))
    }
  }
}

