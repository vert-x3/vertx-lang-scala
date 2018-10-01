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

import io.vertx.ext.consul.{TxnRequest => JTxnRequest}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Holds list of operations in transaction
 */

class TxnRequest(private val _asJava: JTxnRequest) {
  def asJava = _asJava
  /**
   * Returns the number of operations in this request
   */
}


object TxnRequest {
  
  def apply() = {
    new TxnRequest(new JTxnRequest(emptyObj()))
  }
  
  def apply(t: JTxnRequest) = {
    if (t != null) {
      new TxnRequest(t)
    } else {
      new TxnRequest(new JTxnRequest(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): TxnRequest = {
    if (json != null) {
      new TxnRequest(new JTxnRequest(json))
    } else {
      new TxnRequest(new JTxnRequest(emptyObj()))
    }
  }
}

