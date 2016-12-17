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

import io.vertx.scala.core.MultiMap
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.http.HttpClientResponse
import io.vertx.core.http.{HttpClientResponse => JHttpClientResponse}
import io.vertx.core.http.{HttpClientRequest => JHttpClientRequest}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.http.HttpFrame
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.core.http.HttpVersion
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.core.http.HttpMethod
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.http.HttpConnection
import io.vertx.core.http.{HttpConnection => JHttpConnection}

/**
  * Represents a client-side HTTP request.
  * 
  * Instances are created by an [[io.vertx.scala.core.http.HttpClient]] instance, via one of the methods corresponding to the
  * specific HTTP methods, or the generic request methods. On creation the request will not have been written to the
  * wire.
  * 
  * Once a request has been obtained, headers can be set on it, and data can be written to its body if required. Once
  * you are ready to send the request, one of the [[io.vertx.scala.core.http.HttpClientRequest#end]] methods should be called.
  * 
  * Nothing is actually sent until the request has been internally assigned an HTTP connection.
  * 
  * The [[io.vertx.scala.core.http.HttpClient]] instance will return an instance of this class immediately, even if there are no HTTP
  * connections available in the pool. Any requests sent before a connection is assigned will be queued
  * internally and actually sent when an HTTP connection becomes available from the pool.
  * 
  * The headers of the request are queued for writing either when the [[io.vertx.scala.core.http.HttpClientRequest#end]] method is called, or, when the first
  * part of the body is written, whichever occurs first.
  * 
  * This class supports both chunked and non-chunked HTTP.
  * 
  * It implements [[io.vertx.scala.core.streams.WriteStream]] so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  * 
  * An example of using this class is as follows:
  * 
  */
class HttpClientRequest(private val _asJava: Object) 
    extends WriteStream[Buffer](_asJava) 
    with ReadStream[HttpClientResponse](_asJava) {

  override def asJava = _asJava.asInstanceOf[JHttpClientRequest]
//methods returning a future
//cached methods
  def headers():MultiMap = {
    asJava.headers( )
  }

  def connection():HttpConnection = {
    asJava.connection( )
  }

//fluent methods
  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):HttpClientRequest = {
    asJava.exceptionHandler( )
    this
  }

  override def write(data: Buffer):HttpClientRequest = {
    asJava.write( )
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):HttpClientRequest = {
    asJava.setWriteQueueMaxSize( )
    this
  }

  override def drainHandler(handler: io.vertx.core.Handler[Unit]):HttpClientRequest = {
    asJava.drainHandler( )
    this
  }

  override def handler(handler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.handler( )
    this
  }

  override def pause():HttpClientRequest = {
    asJava.pause( )
    this
  }

  override def resume():HttpClientRequest = {
    asJava.resume( )
    this
  }

  override def endHandler(endHandler: io.vertx.core.Handler[Unit]):HttpClientRequest = {
    asJava.endHandler( )
    this
  }

  def setChunked(chunked: Boolean):HttpClientRequest = {
    asJava.setChunked( )
    this
  }

  def setRawMethod(method: String):HttpClientRequest = {
    asJava.setRawMethod( )
    this
  }

  def setHost(host: String):HttpClientRequest = {
    asJava.setHost( )
    this
  }

  def putHeader(name: String,value: String):HttpClientRequest = {
    asJava.putHeader( )
    this
  }

  def write(chunk: String):HttpClientRequest = {
    asJava.write( )
    this
  }

  def write(chunk: String,enc: String):HttpClientRequest = {
    asJava.write( )
    this
  }

  def continueHandler(handler: io.vertx.core.Handler[Unit]):HttpClientRequest = {
    asJava.continueHandler( )
    this
  }

  def sendHead():HttpClientRequest = {
    asJava.sendHead( )
    this
  }

  def sendHead(completionHandler: io.vertx.core.Handler[io.vertx.core.http.HttpVersion]):HttpClientRequest = {
    asJava.sendHead( )
    this
  }

  def setTimeout(timeoutMs: Long):HttpClientRequest = {
    asJava.setTimeout( )
    this
  }

  def pushHandler(handler: io.vertx.core.Handler[HttpClientRequest]):HttpClientRequest = {
    asJava.pushHandler( )
    this
  }

  def connectionHandler(handler: io.vertx.core.Handler[HttpConnection]):HttpClientRequest = {
    asJava.connectionHandler( )
    this
  }

  def writeCustomFrame(type: Int,flags: Int,payload: Buffer):HttpClientRequest = {
    asJava.writeCustomFrame( )
    this
  }

  def writeCustomFrame(frame: HttpFrame):HttpClientRequest = {
    asJava.writeCustomFrame( )
    this
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.writeQueueFull( )
  }

  def isChunked():Boolean = {
    asJava.isChunked( )
  }

  def method():io.vertx.core.http.HttpMethod = {
    asJava.method( )
  }

  def getRawMethod():String = {
    asJava.getRawMethod( )
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

  def getHost():String = {
    asJava.getHost( )
  }

  def end(chunk: String):Unit = {
    asJava.end( )
  }

  def end(chunk: String,enc: String):Unit = {
    asJava.end( )
  }

  override def end(chunk: Buffer):Unit = {
    asJava.end( )
  }

  override def end():Unit = {
    asJava.end( )
  }

  def reset(code: Long):Boolean = {
    asJava.reset( )
  }

}

object HttpClientRequest{
//in object!
//static methods
}
