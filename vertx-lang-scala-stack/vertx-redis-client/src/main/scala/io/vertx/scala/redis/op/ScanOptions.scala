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

import io.vertx.redis.op.{ScanOptions => JScanOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**

 */

class ScanOptions(private val _asJava: JScanOptions) {
  def asJava = _asJava
  def setCount(value: Int) = {
    asJava.setCount(value)
    this
  }

  def setMatch(value: String) = {
    asJava.setMatch(value)
    this
  }

}


object ScanOptions {

  def apply() = {
    new ScanOptions(new JScanOptions(emptyObj()))
  }

  def apply(t: JScanOptions) = {
    if (t != null) {
      new ScanOptions(t)
    } else {
      new ScanOptions(new JScanOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): ScanOptions = {
    if (json != null) {
      new ScanOptions(new JScanOptions(json))
    } else {
      new ScanOptions(new JScanOptions(emptyObj()))
    }
  }
}

