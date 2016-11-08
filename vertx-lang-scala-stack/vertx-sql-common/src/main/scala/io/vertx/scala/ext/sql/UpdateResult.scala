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

package io.vertx.scala.ext.sql

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.sql.{UpdateResult => JUpdateResult}
import io.vertx.core.json.JsonArray

/**
  * Represents the result of an update/insert/delete operation on the database.
  * 
  * The number of rows updated is available with <a href="../../../../../../../cheatsheet/UpdateResult.html">UpdateResult</a> and any generated
  * keys are available with <a href="../../../../../../../cheatsheet/UpdateResult.html">UpdateResult</a>.
  */

class UpdateResult(val asJava: JUpdateResult) {

  /**
    * Get any generated keys
    */
  def setKeys(value: JsonArray) = {
    asJava.setKeys(value)
    this
  }
  def getKeys = {
    asJava.getKeys()
  }

  /**
    * Get the number of rows updated
    */
  def setUpdated(value: Int) = {
    asJava.setUpdated(value)
    this
  }
  def getUpdated = {
    asJava.getUpdated()
  }
}

object UpdateResult {
  
  def apply() = {
    new UpdateResult(new JUpdateResult(emptyObj()))
  }
  
  def apply(t: JUpdateResult) = {
    if(t != null)
      new UpdateResult(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):UpdateResult = {
    if(json != null)
      new UpdateResult(new JUpdateResult(json))
    else
      null
  }
}
