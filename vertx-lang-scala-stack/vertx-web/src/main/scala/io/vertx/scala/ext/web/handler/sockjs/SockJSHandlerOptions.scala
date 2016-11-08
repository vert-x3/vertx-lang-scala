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

package io.vertx.scala.ext.web.handler.sockjs

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.web.handler.sockjs.{SockJSHandlerOptions => JSockJSHandlerOptions}

/**
  * Options for configuring a SockJS handler
  */

class SockJSHandlerOptions(val asJava: JSockJSHandlerOptions) {
  def addDisabledTransport(value: String) = {
    asJava.addDisabledTransport(value)
    this
  }
  def getDisabledTransports = {
    asJava.getDisabledTransports()
  }
  def setHeartbeatInterval(value: Long) = {
    asJava.setHeartbeatInterval(value)
    this
  }
  def getHeartbeatInterval = {
    asJava.getHeartbeatInterval()
  }
  def setInsertJSESSIONID(value: Boolean) = {
    asJava.setInsertJSESSIONID(value)
    this
  }
  def isInsertJSESSIONID = {
    asJava.isInsertJSESSIONID()
  }
  def setLibraryURL(value: String) = {
    asJava.setLibraryURL(value)
    this
  }
  def getLibraryURL = {
    asJava.getLibraryURL()
  }
  def setMaxBytesStreaming(value: Int) = {
    asJava.setMaxBytesStreaming(value)
    this
  }
  def getMaxBytesStreaming = {
    asJava.getMaxBytesStreaming()
  }
  def setSessionTimeout(value: Long) = {
    asJava.setSessionTimeout(value)
    this
  }
  def getSessionTimeout = {
    asJava.getSessionTimeout()
  }
}

object SockJSHandlerOptions {
  
  def apply() = {
    new SockJSHandlerOptions(new JSockJSHandlerOptions(emptyObj()))
  }
  
  def apply(t: JSockJSHandlerOptions) = {
    if(t != null)
      new SockJSHandlerOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):SockJSHandlerOptions = {
    if(json != null)
      new SockJSHandlerOptions(new JSockJSHandlerOptions(json))
    else
      null
  }
}
