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
  * HTTP2 settings, the settings is initialized with the default HTTP/2 values.
  *
  * The settings expose the parameters defined by the HTTP/2 specification, as well as extra settings for
  * protocol extensions.
  */

class Http2Settings(val java: io.vertx.core.http.Http2Settings) {
  def setHeaderTableSize(value:Long) = {
    java.setHeaderTableSize(value)
    this
  }
  def getHeaderTableSize = {
    java.getHeaderTableSize()
  }
  def setInitialWindowSize(value:Int) = {
    java.setInitialWindowSize(value)
    this
  }
  def getInitialWindowSize = {
    java.getInitialWindowSize()
  }
  def setMaxConcurrentStreams(value:Long) = {
    java.setMaxConcurrentStreams(value)
    this
  }
  def getMaxConcurrentStreams = {
    java.getMaxConcurrentStreams()
  }
  def setMaxFrameSize(value:Int) = {
    java.setMaxFrameSize(value)
    this
  }
  def getMaxFrameSize = {
    java.getMaxFrameSize()
  }
  def setMaxHeaderListSize(value:Int) = {
    java.setMaxHeaderListSize(value)
    this
  }
  def getMaxHeaderListSize = {
    java.getMaxHeaderListSize()
  }
  def setPushEnabled(value:Boolean) = {
    java.setPushEnabled(value)
    this
  }
  def isPushEnabled = {
    java.isPushEnabled()
  }
}

object Http2Settings {
  type Http2SettingsJava = io.vertx.core.http.Http2Settings
  
  def apply(t: Http2SettingsJava) = {
    if(t != null)
      new Http2Settings(t)
    else
      null
   
  }
  
  def fromJson(json: JsonObject):Http2Settings = {
    if(json != null)
      new Http2Settings(new Http2SettingsJava(json))
    else
      null
  }
}
