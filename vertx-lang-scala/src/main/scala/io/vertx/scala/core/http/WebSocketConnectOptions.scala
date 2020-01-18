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

import io.vertx.scala.core.http.{RequestOptions => ExtRequestOptions}
import io.vertx.core.http.{WebSocketConnectOptions => JWebSocketConnectOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Options describing how an [[io.vertx.scala.core.http.HttpClient]] connect a [[io.vertx.scala.core.http.WebSocket]].
 */

class WebSocketConnectOptions(private val _asJava: JWebSocketConnectOptions) extends ExtRequestOptions(_asJava) {
  override def asJava = _asJava
  /**
   * Add a request header.
   */
  override def addHeader(key: String, value: String) = {
    asJava.addHeader(key, value.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Set the host name to be used by the client request.
   */
  override def setHost(value: String) = {
    asJava.setHost(value)
    this
  }

  override def getHost: String = {
    asJava.getHost().asInstanceOf[String]
  }

  /**
   * Set the port to be used by the client request.
   */
  override def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }

  override def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }

  /**
   * Set whether SSL/TLS is enabled
   */
  override def setSsl(value: Boolean) = {
    asJava.setSsl(value)
    this
  }

  override def isSsl: Boolean = {
    asJava.isSsl().asInstanceOf[Boolean]
  }

  /**
   * Set the WebSocket sub protocols to use.
   */
  def addSubProtocol(value: String) = {
    asJava.addSubProtocol(value)
    this
  }

  def setSubProtocols(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setSubProtocols(value.asJava)
    this
  }

  def getSubProtocols: scala.collection.mutable.Buffer[String] = {
    asJava.getSubProtocols().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * Set the request relative URI
   */
  override def setURI(value: String) = {
    asJava.setURI(value)
    this
  }

  override def getURI: String = {
    asJava.getURI().asInstanceOf[String]
  }

  /**
   * Set the WebSocket version.
   */
  def setVersion(value: io.vertx.core.http.WebsocketVersion) = {
    asJava.setVersion(value)
    this
  }

  def getVersion: io.vertx.core.http.WebsocketVersion = {
    asJava.getVersion()
  }

}


object WebSocketConnectOptions {

  def apply() = {
    new WebSocketConnectOptions(new JWebSocketConnectOptions(emptyObj()))
  }

  def apply(t: JWebSocketConnectOptions) = {
    if (t != null) {
      new WebSocketConnectOptions(t)
    } else {
      new WebSocketConnectOptions(new JWebSocketConnectOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): WebSocketConnectOptions = {
    if (json != null) {
      new WebSocketConnectOptions(new JWebSocketConnectOptions(json))
    } else {
      new WebSocketConnectOptions(new JWebSocketConnectOptions(emptyObj()))
    }
  }
}

