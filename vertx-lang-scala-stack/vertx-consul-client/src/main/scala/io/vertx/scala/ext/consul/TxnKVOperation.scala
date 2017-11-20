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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.ext.consul.{TxnKVOperation => JTxnKVOperation}

/**
  * Holds operation to apply to the key/value store inside a transaction
  */
class TxnKVOperation(private val _asJava: JTxnKVOperation) {

  def asJava = _asJava

  /**
    * Set the flags attached to this entry. Clients can choose to use this however makes sense for their application.
    */
  def setFlags(value: Long) = {
    asJava.setFlags(value)
    this
  }
  def getFlags: Long = {
    asJava.getFlags().asInstanceOf[Long]
  }

  /**
    * Set the index used for locking, unlocking, and check-and-set operations.
    */
  def setIndex(value: Long) = {
    asJava.setIndex(value)
    this
  }
  def getIndex: Long = {
    asJava.getIndex().asInstanceOf[Long]
  }

  /**
    * Set the key
    */
  def setKey(value: String) = {
    asJava.setKey(value)
    this
  }
  def getKey: String = {
    asJava.getKey().asInstanceOf[String]
  }

  /**
    * Set the session used for locking, unlocking, and check-and-set operations.
    */
  def setSession(value: String) = {
    asJava.setSession(value)
    this
  }
  def getSession: String = {
    asJava.getSession().asInstanceOf[String]
  }

  /**
    * Set the type of operation to perform
    */
  def setType(value: io.vertx.ext.consul.TxnKVVerb) = {
    asJava.setType(value)
    this
  }
  def getType: io.vertx.ext.consul.TxnKVVerb = {
    asJava.getType()
  }

  /**
    * Set the value
    */
  def setValue(value: String) = {
    asJava.setValue(value)
    this
  }
  def getValue: String = {
    asJava.getValue().asInstanceOf[String]
  }
}

object TxnKVOperation {
  
  def apply() = {
    new TxnKVOperation(new JTxnKVOperation(emptyObj()))
  }
  
  def apply(t: JTxnKVOperation) = {
    if (t != null) {
      new TxnKVOperation(t)
    } else {
      new TxnKVOperation(new JTxnKVOperation(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): TxnKVOperation = {
    if (json != null) {
      new TxnKVOperation(new JTxnKVOperation(json))
    } else {
      new TxnKVOperation(new JTxnKVOperation(emptyObj()))
    }
  }
}
