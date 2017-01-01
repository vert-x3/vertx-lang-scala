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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.http.HttpVersion
import io.vertx.core.http.HttpMethod
import io.vertx.core.http.{HttpClientResponse => JHttpClientResponse}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.scala.core.MultiMap
import io.vertx.core.Handler
import io.vertx.core.http.{HttpClientRequest => JHttpClientRequest}

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
    extends WriteStream[Buffer] 
    with ReadStream[HttpClientResponse] {

  def asJava = _asJava
  private var cached_0:MultiMap = _
  private var cached_1:HttpConnection = _

//cached methods
  def headers():MultiMap = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JHttpClientRequest].headers()
      cached_0 = MultiMap(tmp)
    }
    cached_0
  }

  def connection():HttpConnection = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JHttpClientRequest].connection()
      cached_1 = HttpConnection(tmp)
    }
    cached_1
  }

//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def write(data: Buffer):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }

  override def drainHandler(handler: Handler[Unit]):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].drainHandler({x: Void => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].handler({x: JHttpClientResponse => handler.handle(HttpClientResponse(x))})
    this
  }

  override def pause():HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].pause()
    this
  }

  override def resume():HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  def setChunked(chunked: Boolean):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].setChunked(chunked.asInstanceOf[java.lang.Boolean])
    this
  }

  def setRawMethod(method: String):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].setRawMethod(method.asInstanceOf[java.lang.String])
    this
  }

  def setHost(host: String):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].setHost(host.asInstanceOf[java.lang.String])
    this
  }

  def putHeader(name: String,value: String):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].putHeader(name.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String])
    this
  }

  def write(chunk: String):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].write(chunk.asInstanceOf[java.lang.String])
    this
  }

  def write(chunk: String,enc: String):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].write(chunk.asInstanceOf[java.lang.String],enc.asInstanceOf[java.lang.String])
    this
  }

  def continueHandler(handler: Handler[Unit]):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].continueHandler({x: Void => handler.handle(x)})
    this
  }

  def sendHead():HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].sendHead()
    this
  }

  def sendHead(completionHandler: Handler[io.vertx.core.http.HttpVersion]):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].sendHead({x: HttpVersion => completionHandler.handle(x)})
    this
  }

  def setTimeout(timeoutMs: Long):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].setTimeout(timeoutMs.asInstanceOf[java.lang.Long])
    this
  }

  def pushHandler(handler: Handler[HttpClientRequest]):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].pushHandler({x: JHttpClientRequest => handler.handle(HttpClientRequest(x))})
    this
  }

  def connectionHandler(handler: Handler[HttpConnection]):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].connectionHandler({x: JHttpConnection => handler.handle(HttpConnection(x))})
    this
  }

  def writeCustomFrame(`type`: Int,flags: Int,payload: Buffer):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].writeCustomFrame(`type`.asInstanceOf[java.lang.Integer],flags.asInstanceOf[java.lang.Integer],payload.asJava.asInstanceOf[JBuffer])
    this
  }

  def writeCustomFrame(frame: HttpFrame):HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].writeCustomFrame(frame.asJava.asInstanceOf[JHttpFrame])
    this
  }

//default methods
  //io.vertx.core.http.HttpClientRequest
  def reset():Boolean = {
    asJava.asInstanceOf[JHttpClientRequest].reset().asInstanceOf[Boolean]
  }

  //io.vertx.core.http.HttpClientRequest
  def streamId():Int = {
    asJava.asInstanceOf[JHttpClientRequest].streamId().asInstanceOf[Int]
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JHttpClientRequest].writeQueueFull().asInstanceOf[Boolean]
  }

  def isChunked():Boolean = {
    asJava.asInstanceOf[JHttpClientRequest].isChunked().asInstanceOf[Boolean]
  }

  def method():io.vertx.core.http.HttpMethod = {
    asJava.asInstanceOf[JHttpClientRequest].method()
  }

  def getRawMethod():String = {
    asJava.asInstanceOf[JHttpClientRequest].getRawMethod().asInstanceOf[String]
  }

  def uri():String = {
    asJava.asInstanceOf[JHttpClientRequest].uri().asInstanceOf[String]
  }

  def path():String = {
    asJava.asInstanceOf[JHttpClientRequest].path().asInstanceOf[String]
  }

  def query():String = {
    asJava.asInstanceOf[JHttpClientRequest].query().asInstanceOf[String]
  }

  def getHost():String = {
    asJava.asInstanceOf[JHttpClientRequest].getHost().asInstanceOf[String]
  }

  def end(chunk: String):Unit = {
    asJava.asInstanceOf[JHttpClientRequest].end(chunk.asInstanceOf[java.lang.String])
  }

  def end(chunk: String,enc: String):Unit = {
    asJava.asInstanceOf[JHttpClientRequest].end(chunk.asInstanceOf[java.lang.String],enc.asInstanceOf[java.lang.String])
  }

  override def end(chunk: Buffer):Unit = {
    asJava.asInstanceOf[JHttpClientRequest].end(chunk.asJava.asInstanceOf[JBuffer])
  }

  override def end():Unit = {
    asJava.asInstanceOf[JHttpClientRequest].end()
  }

  def reset(code: Long):Boolean = {
    asJava.asInstanceOf[JHttpClientRequest].reset(code.asInstanceOf[java.lang.Long]).asInstanceOf[Boolean]
  }

//future methods
}

  object HttpClientRequest{
    def apply(asJava: Object) = new HttpClientRequest(asJava)  
  //static methods
  }
