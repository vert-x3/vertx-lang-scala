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
import io.vertx.core.http.{Http2Settings => JHttp2Settings}

/**
  * HTTP2 settings, the settings is initialized with the default HTTP/2 values.
  *
  * The settings expose the parameters defined by the HTTP/2 specification, as well as extra settings for
  * protocol extensions.
  */

class Http2Settings(val asJava: JHttp2Settings) {

  /**
    * Set  HTTP/2 setting.
    */
  def setHeaderTableSize(value: Long) = {
    asJava.setHeaderTableSize(value)
    this
  }
  def getHeaderTableSize = {
    asJava.getHeaderTableSize()
  }

  /**
    * Set the  HTTP/2 setting
    */
  def setInitialWindowSize(value: Int) = {
    asJava.setInitialWindowSize(value)
    this
  }
  def getInitialWindowSize = {
    asJava.getInitialWindowSize()
  }

  /**
    * Set the  HTTP/2 setting
    */
  def setMaxConcurrentStreams(value: Long) = {
    asJava.setMaxConcurrentStreams(value)
    this
  }
  def getMaxConcurrentStreams = {
    asJava.getMaxConcurrentStreams()
  }

  /**
    * Set the  HTTP/2 setting
    */
  def setMaxFrameSize(value: Int) = {
    asJava.setMaxFrameSize(value)
    this
  }
  def getMaxFrameSize = {
    asJava.getMaxFrameSize()
  }

  /**
    * Set the  HTTP/2 setting
    */
  def setMaxHeaderListSize(value: Int) = {
    asJava.setMaxHeaderListSize(value)
    this
  }
  def getMaxHeaderListSize = {
    asJava.getMaxHeaderListSize()
  }

  /**
    * Set the  HTTP/2 setting
    */
  def setPushEnabled(value: Boolean) = {
    asJava.setPushEnabled(value)
    this
  }
  def isPushEnabled = {
    asJava.isPushEnabled()
  }
}

object Http2Settings {
  
  def apply() = {
    new Http2Settings(new JHttp2Settings(emptyObj()))
  }
  
  def apply(t: JHttp2Settings) = {
    if(t != null)
      new Http2Settings(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):Http2Settings = {
    if(json != null)
      new Http2Settings(new JHttp2Settings(json))
    else
      null
  }
}
