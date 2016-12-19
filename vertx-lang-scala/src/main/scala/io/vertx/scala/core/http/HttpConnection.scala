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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.http.{GoAway => JGoAway}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.http.{Http2Settings => JHttp2Settings}
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress

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

  def asJava = _asJava

  private var cached_0:SocketAddress = _
  private var cached_1:SocketAddress = _

//cached methods
  def remoteAddress():SocketAddress = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JHttpConnection].remoteAddress()
      cached_0 = SocketAddress(tmp)
    }
    cached_0
  }

  def localAddress():SocketAddress = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JHttpConnection].localAddress()
      cached_1 = SocketAddress(tmp)
    }
    cached_1
  }

//fluent methods
  def setWindowSize(windowSize: Int):HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].setWindowSize(windowSize)
    this
  }

  def goAway(errorCode: Long):HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].goAway(errorCode)
    this
  }

  def goAway(errorCode: Long,lastStreamId: Int):HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].goAway(errorCode,lastStreamId)
    this
  }

  def goAway(errorCode: Long,lastStreamId: Int,debugData: Buffer):HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].goAway(errorCode,lastStreamId,debugData.asJava!!.asInstanceOf[JBuffer])
    this
  }

  def goAwayHandler(handler: Handler[GoAway]):HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].goAwayHandler(x => handler.handle(x.asJava))
    this
  }

  def shutdownHandler(handler: Handler[Unit]):HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].shutdownHandler(x => handler.handle(x))
    this
  }

  def shutdown():HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].shutdown()
    this
  }

  def shutdown(timeoutMs: Long):HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].shutdown(timeoutMs)
    this
  }

  def closeHandler(handler: Handler[Unit]):HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].closeHandler(x => handler.handle(x))
    this
  }

  def updateSettings(settings: Http2Settings):HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].updateSettings(settings.asJava)
    this
  }

  def updateSettings(settings: Http2Settings,completionHandler: Handler[AsyncResult[Unit]]):HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].updateSettings(settings.asJava,x => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a)))
    this
  }

  def remoteSettingsHandler(handler: Handler[Http2Settings]):HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].remoteSettingsHandler(x => handler.handle(x.asJava))
    this
  }

  def ping(data: Buffer,pongHandler: Handler[AsyncResult[Buffer]]):HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].ping(data.asJava!!.asInstanceOf[JBuffer],x => pongHandler.handle(AsyncResultWrapper[JBuffer,Buffer](x, a => Buffer(a))))
    this
  }

  def pingHandler(handler: Handler[Buffer]):HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].pingHandler(x => handler.handle(x.asJava!!.asInstanceOf[JBuffer]))
    this
  }

  def exceptionHandler(handler: Handler[Throwable]):HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].exceptionHandler(x => handler.handle(x))
    this
  }

//basic methods
  def close():Unit = {
    asJava.asInstanceOf[JHttpConnection].close()
  }

  def settings():Http2Settings = {
    Http2Settings(asJava.asInstanceOf[JHttpConnection].settings())
  }

  def remoteSettings():Http2Settings = {
    Http2Settings(asJava.asInstanceOf[JHttpConnection].remoteSettings())
  }

}

object HttpConnection{
  def apply(asJava: JHttpConnection) = new HttpConnection(asJava)
//static methods
}
