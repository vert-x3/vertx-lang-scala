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

package io.vertx.scala.ext.mongo

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.mongo.{FindOptions => JFindOptions}
import io.vertx.core.json.JsonObject

/**
  * Options used to configure find operations.
  */

class FindOptions(val asJava: JFindOptions) {

  /**
    * Set the fields
    */
  def setFields(value: JsonObject) = {
    asJava.setFields(value)
    this
  }
  def getFields = {
    asJava.getFields()
  }

  /**
    * Set the limit
    */
  def setLimit(value: Int) = {
    asJava.setLimit(value)
    this
  }
  def getLimit = {
    asJava.getLimit()
  }

  /**
    * Set the skip
    */
  def setSkip(value: Int) = {
    asJava.setSkip(value)
    this
  }
  def getSkip = {
    asJava.getSkip()
  }

  /**
    * Set the sort document
    */
  def setSort(value: JsonObject) = {
    asJava.setSort(value)
    this
  }
  def getSort = {
    asJava.getSort()
  }
}

object FindOptions {
  
  def apply() = {
    new FindOptions(new JFindOptions(emptyObj()))
  }
  
  def apply(t: JFindOptions) = {
    if(t != null)
      new FindOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):FindOptions = {
    if(json != null)
      new FindOptions(new JFindOptions(json))
    else
      null
  }
}
