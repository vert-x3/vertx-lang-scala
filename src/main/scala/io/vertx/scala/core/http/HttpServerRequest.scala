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

package io.vertx.scala.core.http;

import io.vertx.scala.core.MultiMap
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.http.HttpVersion
import io.vertx.core.http.HttpMethod
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress
import io.vertx.scala.core.net.NetSocket

class HttpServerRequest(private val _asJava: io.vertx.core.http.HttpServerRequest) 
    extends io.vertx.scala.core.streams.ReadStream[io.vertx.scala.core.buffer.Buffer] {

  def asJava: java.lang.Object = _asJava

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.HttpServerRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.http.HttpServerRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.handler(funcToMappedHandler(Buffer.apply)(handler))
    this
  }

  def pause(): io.vertx.scala.core.http.HttpServerRequest = {
    _asJava.pause()
    this
  }

  def resume(): io.vertx.scala.core.http.HttpServerRequest = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: => Unit): io.vertx.scala.core.http.HttpServerRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>endHandler))
    this
  }

  def version(): io.vertx.core.http.HttpVersion = {
    _asJava.version()
  }

  def method(): io.vertx.core.http.HttpMethod = {
    _asJava.method()
  }

  def uri(): String = {
    _asJava.uri()
  }

  def path(): String = {
    _asJava.path()
  }

  def query(): String = {
    _asJava.query()
  }

  def response(): io.vertx.scala.core.http.HttpServerResponse = {
    HttpServerResponse.apply(_asJava.response())
  }

  def headers(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.headers())
  }

  def getHeader(headerName: String): String = {
    _asJava.getHeader(headerName)
  }

  def params(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.params())
  }

  def getParam(paramName: String): String = {
    _asJava.getParam(paramName)
  }

  def remoteAddress(): io.vertx.scala.core.net.SocketAddress = {
    SocketAddress.apply(_asJava.remoteAddress())
  }

  def localAddress(): io.vertx.scala.core.net.SocketAddress = {
    SocketAddress.apply(_asJava.localAddress())
  }

  def absoluteURI(): String = {
    _asJava.absoluteURI()
  }

  def bodyHandler(bodyHandler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.http.HttpServerRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.bodyHandler(funcToMappedHandler(Buffer.apply)(bodyHandler))
    this
  }

  def netSocket(): io.vertx.scala.core.net.NetSocket = {
    NetSocket.apply(_asJava.netSocket())
  }

  def setExpectMultipart(expect: Boolean): io.vertx.scala.core.http.HttpServerRequest = {
    _asJava.setExpectMultipart(expect)
    this
  }

  def isExpectMultipart(): Boolean = {
    _asJava.isExpectMultipart()
  }

  def uploadHandler(uploadHandler: io.vertx.scala.core.http.HttpServerFileUpload => Unit): io.vertx.scala.core.http.HttpServerRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.uploadHandler(funcToMappedHandler(HttpServerFileUpload.apply)(uploadHandler))
    this
  }

  def formAttributes(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.formAttributes())
  }

  def getFormAttribute(attributeName: String): String = {
    _asJava.getFormAttribute(attributeName)
  }

  def upgrade(): io.vertx.scala.core.http.ServerWebSocket = {
    ServerWebSocket.apply(_asJava.upgrade())
  }

  def isEnded(): Boolean = {
    _asJava.isEnded()
  }

}

object HttpServerRequest {

  def apply(_asJava: io.vertx.core.http.HttpServerRequest): io.vertx.scala.core.http.HttpServerRequest =
    new io.vertx.scala.core.http.HttpServerRequest(_asJava)
}
