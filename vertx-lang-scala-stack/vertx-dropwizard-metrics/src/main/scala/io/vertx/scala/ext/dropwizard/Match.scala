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

import io.vertx.ext.dropwizard.{Match => JMatch}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * A match for a value.
 */

class Match(private val _asJava: JMatch) {
  def asJava = _asJava
  /**
   * Set the alias the human readable name that will be used as a part of
   * registry entry name when the value matches.
   */
  def setAlias(value: String) = {
    asJava.setAlias(value)
    this
  }

  def getAlias: String = {
    asJava.getAlias().asInstanceOf[String]
  }

  /**
   * Set the type of matching to apply.
   */
  def setType(value: io.vertx.ext.dropwizard.MatchType) = {
    asJava.setType(value)
    this
  }

  def getType: io.vertx.ext.dropwizard.MatchType = {
    asJava.getType()
  }

  /**
   * Set the matched value.
   */
  def setValue(value: String) = {
    asJava.setValue(value)
    this
  }

  def getValue: String = {
    asJava.getValue().asInstanceOf[String]
  }

}


object Match {
  
  def apply() = {
    new Match(new JMatch(emptyObj()))
  }
  
  def apply(t: JMatch) = {
    if (t != null) {
      new Match(t)
    } else {
      new Match(new JMatch(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): Match = {
    if (json != null) {
      new Match(new JMatch(json))
    } else {
      new Match(new JMatch(emptyObj()))
    }
  }
}

