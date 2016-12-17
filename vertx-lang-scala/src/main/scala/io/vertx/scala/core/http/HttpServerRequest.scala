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

import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.scala.core.http.ServerWebSocket
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.scala.core.http.HttpServerFileUpload
import io.vertx.core.http.{HttpServerFileUpload => JHttpServerFileUpload}
import io.vertx.scala.core.MultiMap
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.http.HttpFrame
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.core.http.HttpVersion
import io.vertx.core.http.HttpMethod
import io.vertx.scala.core.http.HttpServerResponse
import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.http.HttpConnection
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.scala.core.net.SocketAddress
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.scala.core.net.NetSocket
import io.vertx.core.net.{NetSocket => JNetSocket}

/**
  * Represents a server-side HTTP request.
  * 
  * Instances are created for each request and passed to the user via a handler.
  * 
  * Each instance of this class is associated with a corresponding [[io.vertx.scala.core.http.HttpServerResponse]] instance via
  * [[io.vertx.scala.core.http.HttpServerRequest#response]].
  * It implements [[io.vertx.scala.core.streams.ReadStream]] so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  * 
  */
class HttpServerRequest(private val _asJava: Object) 
    extends ReadStream[Buffer](_asJava) {

  override def asJava = _asJava.asInstanceOf[JHttpServerRequest]
//methods returning a future
//cached methods
  def response():HttpServerResponse = {
    asJava.response( )
  }

  def headers():MultiMap = {
    asJava.headers( )
  }

  def params():MultiMap = {
    asJava.params( )
  }

  def remoteAddress():SocketAddress = {
    asJava.remoteAddress( )
  }

  def localAddress():SocketAddress = {
    asJava.localAddress( )
  }

  def netSocket():NetSocket = {
    asJava.netSocket( )
  }

  def formAttributes():MultiMap = {
    asJava.formAttributes( )
  }

  def connection():HttpConnection = {
    asJava.connection( )
  }

//fluent methods
  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):HttpServerRequest = {
    asJava.exceptionHandler( )
    this
  }

  override def handler(handler: io.vertx.core.Handler[Buffer]):HttpServerRequest = {
    asJava.handler( )
    this
  }

  override def pause():HttpServerRequest = {
    asJava.pause( )
    this
  }

  override def resume():HttpServerRequest = {
    asJava.resume( )
    this
  }

  override def endHandler(endHandler: io.vertx.core.Handler[Unit]):HttpServerRequest = {
    asJava.endHandler( )
    this
  }

  def bodyHandler(bodyHandler: io.vertx.core.Handler[Buffer]):HttpServerRequest = {
    asJava.bodyHandler( )
    this
  }

  def setExpectMultipart(expect: Boolean):HttpServerRequest = {
    asJava.setExpectMultipart( )
    this
  }

  def uploadHandler(uploadHandler: io.vertx.core.Handler[HttpServerFileUpload]):HttpServerRequest = {
    asJava.uploadHandler( )
    this
  }

  def customFrameHandler(handler: io.vertx.core.Handler[HttpFrame]):HttpServerRequest = {
    asJava.customFrameHandler( )
    this
  }

//basic methods
  def version():io.vertx.core.http.HttpVersion = {
    asJava.version( )
  }

  def method():io.vertx.core.http.HttpMethod = {
    asJava.method( )
  }

  def rawMethod():String = {
    asJava.rawMethod( )
  }

  def isSSL():Boolean = {
    asJava.isSSL( )
  }

  def scheme():String = {
    asJava.scheme( )
  }

  def uri():String = {
    asJava.uri( )
  }

  def path():String = {
    asJava.path( )
  }

  def query():String = {
    asJava.query( )
  }

  def host():String = {
    asJava.host( )
  }

  def getHeader(headerName: String):String = {
    asJava.getHeader( )
  }

  def getParam(paramName: String):String = {
    asJava.getParam( )
  }

  def absoluteURI():String = {
    asJava.absoluteURI( )
  }

  def isExpectMultipart():Boolean = {
    asJava.isExpectMultipart( )
  }

  def getFormAttribute(attributeName: String):String = {
    asJava.getFormAttribute( )
  }

  def upgrade():ServerWebSocket = {
    asJava.upgrade( )
  }

  def isEnded():Boolean = {
    asJava.isEnded( )
  }

}

object HttpServerRequest{
//in object!
//static methods
}
