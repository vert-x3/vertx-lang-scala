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
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.http.HttpMethod
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}

/**
  * Represents a server-side HTTP response.
  * 
  * An instance of this is created and associated to every instance of
  * [[io.vertx.scala.core.http.HttpServerRequest]] that.
  * 
  * It allows the developer to control the HTTP response that is sent back to the
  * client for a particular HTTP request.
  * 
  * It contains methods that allow HTTP headers and trailers to be set, and for a body to be written out to the response.
  * 
  * It also allows files to be streamed by the kernel directly from disk to the
  * outgoing HTTP connection, bypassing user space altogether (where supported by
  * the underlying operating system). This is a very efficient way of
  * serving files from the server since buffers do not have to be read one by one
  * from the file and written to the outgoing socket.
  * 
  * It implements [[io.vertx.scala.core.streams.WriteStream]] so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  */
class HttpServerResponse(private val _asJava: Object) 
    extends WriteStream[Buffer] {

  def asJava = _asJava
  private var cached_0:MultiMap = _
  private var cached_1:MultiMap = _

//cached methods
  def headers():MultiMap = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JHttpServerResponse].headers()
      cached_0 = MultiMap(tmp)
    }
    cached_0
  }

  def trailers():MultiMap = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JHttpServerResponse].trailers()
      cached_1 = MultiMap(tmp)
    }
    cached_1
  }

//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def write(data: Buffer):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].setWriteQueueMaxSize(maxSize)
    this
  }

  override def drainHandler(handler: Handler[Unit]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].drainHandler({x: Void => handler.handle(x)})
    this
  }

  def setStatusCode(statusCode: Int):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].setStatusCode(statusCode)
    this
  }

  def setStatusMessage(statusMessage: String):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].setStatusMessage(statusMessage)
    this
  }

  def setChunked(chunked: Boolean):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].setChunked(chunked)
    this
  }

  def putHeader(name: String,value: String):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].putHeader(name,value)
    this
  }

  def putTrailer(name: String,value: String):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].putTrailer(name,value)
    this
  }

  def closeHandler(handler: Handler[Unit]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].closeHandler({x: Void => handler.handle(x)})
    this
  }

  def write(chunk: String,enc: String):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].write(chunk,enc)
    this
  }

  def write(chunk: String):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].write(chunk)
    this
  }

  def writeContinue():HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].writeContinue()
    this
  }

  def sendFile(filename: String):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename)
    this
  }

  def sendFile(filename: String,offset: Long):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename,offset)
    this
  }

  def sendFile(filename: String,offset: Long,length: Long):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename,offset,length)
    this
  }

  def sendFile(filename: String,resultHandler: Handler[AsyncResult[Unit]]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def sendFile(filename: String,offset: Long,resultHandler: Handler[AsyncResult[Unit]]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename,offset,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def sendFile(filename: String,offset: Long,length: Long,resultHandler: Handler[AsyncResult[Unit]]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename,offset,length,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def headersEndHandler(handler: Handler[Unit]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].headersEndHandler({x: Void => handler.handle(x)})
    this
  }

  def bodyEndHandler(handler: Handler[Unit]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].bodyEndHandler({x: Void => handler.handle(x)})
    this
  }

  def push(method: io.vertx.core.http.HttpMethod,path: String,handler: Handler[AsyncResult[HttpServerResponse]]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].push(method,path,{x: AsyncResult[JHttpServerResponse] => handler.handle(AsyncResultWrapper[JHttpServerResponse,HttpServerResponse](x, a => HttpServerResponse(a)))})
    this
  }

  def push(method: io.vertx.core.http.HttpMethod,host: String,path: String,headers: MultiMap,handler: Handler[AsyncResult[HttpServerResponse]]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].push(method,host,path,headers.asJava.asInstanceOf[JMultiMap],{x: AsyncResult[JHttpServerResponse] => handler.handle(AsyncResultWrapper[JHttpServerResponse,HttpServerResponse](x, a => HttpServerResponse(a)))})
    this
  }

  def writeCustomFrame(`type`: Int,flags: Int,payload: Buffer):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].writeCustomFrame(`type`,flags,payload.asJava.asInstanceOf[JBuffer])
    this
  }

  def writeCustomFrame(frame: HttpFrame):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].writeCustomFrame(frame.asJava.asInstanceOf[JHttpFrame])
    this
  }

//default methods
  //io.vertx.core.http.HttpServerResponse
  def reset():Unit = {
    asJava.asInstanceOf[JHttpServerResponse].reset()
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JHttpServerResponse].writeQueueFull()
  }

  def getStatusCode():Int = {
    asJava.asInstanceOf[JHttpServerResponse].getStatusCode()
  }

  def getStatusMessage():String = {
    asJava.asInstanceOf[JHttpServerResponse].getStatusMessage()
  }

  def isChunked():Boolean = {
    asJava.asInstanceOf[JHttpServerResponse].isChunked()
  }

  def end(chunk: String):Unit = {
    asJava.asInstanceOf[JHttpServerResponse].end(chunk)
  }

  def end(chunk: String,enc: String):Unit = {
    asJava.asInstanceOf[JHttpServerResponse].end(chunk,enc)
  }

  override def end(chunk: Buffer):Unit = {
    asJava.asInstanceOf[JHttpServerResponse].end(chunk.asJava.asInstanceOf[JBuffer])
  }

  override def end():Unit = {
    asJava.asInstanceOf[JHttpServerResponse].end()
  }

  def close():Unit = {
    asJava.asInstanceOf[JHttpServerResponse].close()
  }

  def ended():Boolean = {
    asJava.asInstanceOf[JHttpServerResponse].ended()
  }

  def closed():Boolean = {
    asJava.asInstanceOf[JHttpServerResponse].closed()
  }

  def headWritten():Boolean = {
    asJava.asInstanceOf[JHttpServerResponse].headWritten()
  }

  def bytesWritten():Long = {
    asJava.asInstanceOf[JHttpServerResponse].bytesWritten()
  }

  def streamId():Int = {
    asJava.asInstanceOf[JHttpServerResponse].streamId()
  }

  def push(method: io.vertx.core.http.HttpMethod,host: String,path: String,handler: Handler[AsyncResult[HttpServerResponse]]):HttpServerResponse = {
    HttpServerResponse(asJava.asInstanceOf[JHttpServerResponse].push(method,host,path,{x: AsyncResult[JHttpServerResponse] => handler.handle(AsyncResultWrapper[JHttpServerResponse,HttpServerResponse](x, a => HttpServerResponse(a)))}))
  }

  def push(method: io.vertx.core.http.HttpMethod,path: String,headers: MultiMap,handler: Handler[AsyncResult[HttpServerResponse]]):HttpServerResponse = {
    HttpServerResponse(asJava.asInstanceOf[JHttpServerResponse].push(method,path,headers.asJava.asInstanceOf[JMultiMap],{x: AsyncResult[JHttpServerResponse] => handler.handle(AsyncResultWrapper[JHttpServerResponse,HttpServerResponse](x, a => HttpServerResponse(a)))}))
  }

  def reset(code: Long):Unit = {
    asJava.asInstanceOf[JHttpServerResponse].reset(code)
  }

}

  object HttpServerResponse{
    def apply(asJava: JHttpServerResponse) = new HttpServerResponse(asJava)  
  //static methods
  }
