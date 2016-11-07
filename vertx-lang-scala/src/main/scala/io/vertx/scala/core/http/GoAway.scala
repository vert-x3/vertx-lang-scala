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

package io.vertx.scala.core.http

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.core.http.{GoAway => JGoAway}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer

/**
  * A  frame.
  */

class GoAway(val asJava: JGoAway) {

  /**
    * Set the additional debug data
    */
  def setDebugData(value: Buffer) = {
    asJava.setDebugData(value.asJava)
    this
  }
  def getDebugData = {
    asJava.getDebugData()
  }

  /**
    */
  def setErrorCode(value: Long) = {
    asJava.setErrorCode(value)
    this
  }
  def getErrorCode = {
    asJava.getErrorCode()
  }

  /**
    * Set the last stream id.
    */
  def setLastStreamId(value: Int) = {
    asJava.setLastStreamId(value)
    this
  }
  def getLastStreamId = {
    asJava.getLastStreamId()
  }
}

object GoAway {
  
  def apply() = {
    new GoAway(new JGoAway(emptyObj()))
  }
  
  def apply(t: JGoAway) = {
    if(t != null)
      new GoAway(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):GoAway = {
    if(json != null)
      new GoAway(new JGoAway(json))
    else
      null
  }
}
