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

package io.vertx.scala.core.net

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Configures a <a href="../../../../../../../cheatsheet/TCPSSLOptions.html">TCPSSLOptions</a> to use the JDK ssl engine implementation.
  */

class JdkSSLEngineOptions(val asJava: io.vertx.core.net.JdkSSLEngineOptions) {

  /**
    * @return if alpn support is available via the JDK SSL engine
    */
}

object JdkSSLEngineOptions {
  type JdkSSLEngineOptionsJava = io.vertx.core.net.JdkSSLEngineOptions
  
  def apply() = {
    new JdkSSLEngineOptions(new JdkSSLEngineOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: JdkSSLEngineOptionsJava) = {
    if(t != null)
      new JdkSSLEngineOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):JdkSSLEngineOptions = {
    if(json != null)
      new JdkSSLEngineOptions(new JdkSSLEngineOptionsJava(json))
    else
      null
  }
}
