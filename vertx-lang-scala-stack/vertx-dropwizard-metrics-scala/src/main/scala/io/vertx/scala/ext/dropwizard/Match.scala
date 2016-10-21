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

package io.vertx.scala.ext.dropwizard

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * A match for a value.
  */

class Match(val asJava: io.vertx.ext.dropwizard.Match) {

  /**
    * Set the type of matching to apply.
    */
  def setType(value:io.vertx.ext.dropwizard.MatchType) = {
    asJava.setType(value)
    this
  }
  def getType = {
    asJava.getType()
  }

  /**
    * Set the matched value.
    */
  def setValue(value:String) = {
    asJava.setValue(value)
    this
  }
  def getValue = {
    asJava.getValue()
  }
}

object Match {
  type MatchJava = io.vertx.ext.dropwizard.Match
  
  def apply() = {
    new Match(new MatchJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: MatchJava) = {
    if(t != null)
      new Match(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):Match = {
    if(json != null)
      new Match(new MatchJava(json))
    else
      null
  }
}
