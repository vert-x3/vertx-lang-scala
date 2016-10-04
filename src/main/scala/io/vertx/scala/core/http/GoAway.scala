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
import scala.collection.JavaConversions._

/**
  * A  frame.
  */

class GoAway(val asJava: io.vertx.core.http.GoAway) {

  /**
    * Set the additional debug data
    */
  def setDebugData(value:io.vertx.core.buffer.Buffer) = {
    asJava.setDebugData(value)
    this
  }
  def getDebugData = {
    asJava.getDebugData()
  }

  /**
    * @return the  error code
    */
  def setErrorCode(value:Long) = {
    asJava.setErrorCode(value)
    this
  }
  def getErrorCode = {
    asJava.getErrorCode()
  }

  /**
    * Set the last stream id.
    */
  def setLastStreamId(value:Int) = {
    asJava.setLastStreamId(value)
    this
  }
  def getLastStreamId = {
    asJava.getLastStreamId()
  }
}

object GoAway {
  type GoAwayJava = io.vertx.core.http.GoAway
  
  def apply() = {
    new GoAway(new GoAwayJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: GoAwayJava) = {
    if(t != null)
      new GoAway(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):GoAway = {
    if(json != null)
      new GoAway(new GoAwayJava(json))
    else
      null
  }
}
