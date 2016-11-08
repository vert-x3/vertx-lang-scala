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
import io.vertx.ext.sql.{ResultSet => JResultSet}
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject

/**
  * Represents the results of a SQL query.
  * 
  * It contains a list for the column names of the results, and a list of `JsonArray` - one for each row of the
  * results.
  */

class ResultSet(val asJava: JResultSet) {

  /**
    * Get the column names
    */
  def setColumnNames(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setColumnNames(value.asJava)
    this
  }
  def getColumnNames = {
    asJava.getColumnNames()
  }

  /**
    * Return the number of columns in the result set
    */

  /**
    * Return the number of rows in the result set
    */

  /**
    * Get the registered outputs
    */
  def setOutput(value: JsonArray) = {
    asJava.setOutput(value)
    this
  }
  def getOutput = {
    asJava.getOutput()
  }

  /**
    * Get the results
    */
  def setResults(value: scala.collection.mutable.Buffer[JsonArray]) = {
    asJava.setResults(value.asJava)
    this
  }
  def getResults = {
    asJava.getResults()
  }

  /**
    * Get the rows - each row represented as a JsonObject where the keys are the column names and the values are
    * the column values.
    * 
    * Beware that it's legal for a query result in SQL to contain duplicate column names, in which case one will
    * overwrite the other if using this method. If that's the case use <a href="../../../../../../../cheatsheet/ResultSet.html">ResultSet</a> instead.
    */
}

object ResultSet {
  
  def apply() = {
    new ResultSet(new JResultSet(emptyObj()))
  }
  
  def apply(t: JResultSet) = {
    if(t != null)
      new ResultSet(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):ResultSet = {
    if(json != null)
      new ResultSet(new JResultSet(json))
    else
      null
  }
}
