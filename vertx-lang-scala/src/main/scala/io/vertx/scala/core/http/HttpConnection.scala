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

import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.http.GoAway
import io.vertx.core.http.{GoAway => JGoAway}
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.scala.core.http.Http2Settings
import io.vertx.core.http.{Http2Settings => JHttp2Settings}
import io.vertx.scala.core.net.SocketAddress
import io.vertx.core.net.{SocketAddress => JSocketAddress}

/**
  * Represents an HTTP connection.
  * <p/>
  * HTTP/1.x connection provides an limited implementation, the following methods are implemented:
  * <ul>
  *   <li>[[io.vertx.scala.core.http.HttpConnection#close]]</li>
  *   <li>[[io.vertx.scala.core.http.HttpConnection#closeHandler]]</li>
  *   <li>[[io.vertx.scala.core.http.HttpConnection#exceptionHandler]]</li>
  * </ul>
  */
class HttpConnection(private val _asJava: Object) {

def asJava = _asJava.asInstanceOf[JHttpConnection]
//methods returning a future
//cached methods
  def remoteAddress():SocketAddress = {
    asJava.remoteAddress( )
  }

  def localAddress():SocketAddress = {
    asJava.localAddress( )
  }

//fluent methods
  def setWindowSize(windowSize: Int):HttpConnection = {
    asJava.setWindowSize( )
    this
  }

  def goAway(errorCode: Long):HttpConnection = {
    asJava.goAway( )
    this
  }

  def goAway(errorCode: Long,lastStreamId: Int):HttpConnection = {
    asJava.goAway( )
    this
  }

  def goAway(errorCode: Long,lastStreamId: Int,debugData: Buffer):HttpConnection = {
    asJava.goAway( )
    this
  }

  def goAwayHandler(handler: io.vertx.core.Handler[GoAway]):HttpConnection = {
    asJava.goAwayHandler( )
    this
  }

  def shutdownHandler(handler: io.vertx.core.Handler[Unit]):HttpConnection = {
    asJava.shutdownHandler( )
    this
  }

  def shutdown():HttpConnection = {
    asJava.shutdown( )
    this
  }

  def shutdown(timeoutMs: Long):HttpConnection = {
    asJava.shutdown( )
    this
  }

  def closeHandler(handler: io.vertx.core.Handler[Unit]):HttpConnection = {
    asJava.closeHandler( )
    this
  }

  def updateSettings(settings: Http2Settings):HttpConnection = {
    asJava.updateSettings( )
    this
  }

  def updateSettings(settings: Http2Settings,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):HttpConnection = {
    asJava.updateSettings( )
    this
  }

  def remoteSettingsHandler(handler: io.vertx.core.Handler[Http2Settings]):HttpConnection = {
    asJava.remoteSettingsHandler( )
    this
  }

  def ping(data: Buffer,pongHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Buffer]]):HttpConnection = {
    asJava.ping( )
    this
  }

  def pingHandler(handler: io.vertx.core.Handler[Buffer]):HttpConnection = {
    asJava.pingHandler( )
    this
  }

  def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):HttpConnection = {
    asJava.exceptionHandler( )
    this
  }

//basic methods
  def close():Unit = {
    asJava.close( )
  }

  def settings():Http2Settings = {
    asJava.settings( )
  }

  def remoteSettings():Http2Settings = {
    asJava.remoteSettings( )
  }

}

object HttpConnection{
//in object!
//static methods
}
