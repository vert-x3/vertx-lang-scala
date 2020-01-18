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

package io.vertx.scala.ext.web

import io.vertx.ext.web.{Http2PushMapping => JHttp2PushMapping}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._


class Http2PushMapping(private val _asJava: JHttp2PushMapping) {
  def asJava = _asJava
  def setExtensionTarget(value: String) = {
    asJava.setExtensionTarget(value)
    this
  }

  def getExtensionTarget: String = {
    asJava.getExtensionTarget().asInstanceOf[String]
  }

  def setFilePath(value: String) = {
    asJava.setFilePath(value)
    this
  }

  def getFilePath: String = {
    asJava.getFilePath().asInstanceOf[String]
  }

  def setNoPush(value: Boolean) = {
    asJava.setNoPush(value)
    this
  }

  def isNoPush: Boolean = {
    asJava.isNoPush().asInstanceOf[Boolean]
  }

}


object Http2PushMapping {

  def apply() = {
    new Http2PushMapping(new JHttp2PushMapping(emptyObj()))
  }

  def apply(t: JHttp2PushMapping) = {
    if (t != null) {
      new Http2PushMapping(t)
    } else {
      new Http2PushMapping(new JHttp2PushMapping(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): Http2PushMapping = {
    if (json != null) {
      new Http2PushMapping(new JHttp2PushMapping(json))
    } else {
      new Http2PushMapping(new JHttp2PushMapping(emptyObj()))
    }
  }
}

