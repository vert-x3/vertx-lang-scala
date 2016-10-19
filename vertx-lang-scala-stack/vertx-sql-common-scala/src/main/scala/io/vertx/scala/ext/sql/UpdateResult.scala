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
import scala.collection.JavaConversions._

/**
  * Represents the result of an update/insert/delete operation on the database.
  * 
  * The number of rows updated is available with <a href="../../../../../../../cheatsheet/UpdateResult.html">UpdateResult</a> and any generated
  * keys are available with <a href="../../../../../../../cheatsheet/UpdateResult.html">UpdateResult</a>.
  */

class UpdateResult(val asJava: io.vertx.ext.sql.UpdateResult) {

  /**
    * Get any generated keys
    */
  def setKeys(value:io.vertx.core.json.JsonArray) = {
    asJava.setKeys(value)
    this
  }
  def getKeys = {
    asJava.getKeys()
  }

  /**
    * Get the number of rows updated
    */
  def setUpdated(value:Int) = {
    asJava.setUpdated(value)
    this
  }
  def getUpdated = {
    asJava.getUpdated()
  }
}

object UpdateResult {
  type UpdateResultJava = io.vertx.ext.sql.UpdateResult
  
  def apply() = {
    new UpdateResult(new UpdateResultJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: UpdateResultJava) = {
    if(t != null)
      new UpdateResult(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):UpdateResult = {
    if(json != null)
      new UpdateResult(new UpdateResultJava(json))
    else
      null
  }
}
