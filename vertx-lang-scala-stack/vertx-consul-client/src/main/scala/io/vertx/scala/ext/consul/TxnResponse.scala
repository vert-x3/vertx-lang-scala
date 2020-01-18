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

package io.vertx.scala.ext.consul

import io.vertx.ext.consul.{TxnResponse => JTxnResponse}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Holds results of transaction
 */

class TxnResponse(private val _asJava: JTxnResponse) {
  def asJava = _asJava
  /**
   * Adds error to this response
   */
  def addError(value: TxnError) = {
    asJava.addError(value.asJava)
    this
  }

  def getErrors: scala.collection.mutable.Buffer[TxnError] = {
    asJava.getErrors().asScala.map(x => TxnError(x))
  }

  /**
   * Returns the number of errors in this response
   */
  /**
   * Returns the number of results in this response
   */
}


object TxnResponse {

  def apply() = {
    new TxnResponse(new JTxnResponse(emptyObj()))
  }

  def apply(t: JTxnResponse) = {
    if (t != null) {
      new TxnResponse(t)
    } else {
      new TxnResponse(new JTxnResponse(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): TxnResponse = {
    if (json != null) {
      new TxnResponse(new JTxnResponse(json))
    } else {
      new TxnResponse(new JTxnResponse(emptyObj()))
    }
  }
}

