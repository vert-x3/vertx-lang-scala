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

import io.vertx.ext.consul.{TxnError => JTxnError}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Holds information describing which operations failed if the transaction was rolled back.
 */

class TxnError(private val _asJava: JTxnError) {
  def asJava = _asJava
  /**
   * Set the index of the failed operation in the transaction
   */
  def setOpIndex(value: Int) = {
    asJava.setOpIndex(value)
    this
  }

  def getOpIndex: Int = {
    asJava.getOpIndex().asInstanceOf[Int]
  }

  /**
   * Set error message about why that operation failed.
   */
  def setWhat(value: String) = {
    asJava.setWhat(value)
    this
  }

  def getWhat: String = {
    asJava.getWhat().asInstanceOf[String]
  }

}


object TxnError {
  
  def apply() = {
    new TxnError(new JTxnError(emptyObj()))
  }
  
  def apply(t: JTxnError) = {
    if (t != null) {
      new TxnError(t)
    } else {
      new TxnError(new JTxnError(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): TxnError = {
    if (json != null) {
      new TxnError(new JTxnError(json))
    } else {
      new TxnError(new JTxnError(emptyObj()))
    }
  }
}

