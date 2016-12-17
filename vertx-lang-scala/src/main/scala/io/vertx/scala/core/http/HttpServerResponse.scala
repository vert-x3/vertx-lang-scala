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
import io.vertx.scala.core.http.HttpFrame
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
import io.vertx.core.http.HttpMethod
import io.vertx.scala.core.MultiMap
import io.vertx.core.{MultiMap => JMultiMap}

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
    extends WriteStream[Buffer](_asJava) {

  override def asJava = _asJava.asInstanceOf[JHttpServerResponse]
//methods returning a future
  def push(method: io.vertx.core.http.HttpMethod,host: String,path: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[HttpServerResponse]]):HttpServerResponse = {
    asJava.push( )
  }

  def push(method: io.vertx.core.http.HttpMethod,path: String,headers: MultiMap,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[HttpServerResponse]]):HttpServerResponse = {
    asJava.push( )
  }

//cached methods
  def headers():MultiMap = {
    asJava.headers( )
  }

  def trailers():MultiMap = {
    asJava.trailers( )
  }

//fluent methods
  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):HttpServerResponse = {
    asJava.exceptionHandler( )
    this
  }

  override def write(data: Buffer):HttpServerResponse = {
    asJava.write( )
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):HttpServerResponse = {
    asJava.setWriteQueueMaxSize( )
    this
  }

  override def drainHandler(handler: io.vertx.core.Handler[Unit]):HttpServerResponse = {
    asJava.drainHandler( )
    this
  }

  def setStatusCode(statusCode: Int):HttpServerResponse = {
    asJava.setStatusCode( )
    this
  }

  def setStatusMessage(statusMessage: String):HttpServerResponse = {
    asJava.setStatusMessage( )
    this
  }

  def setChunked(chunked: Boolean):HttpServerResponse = {
    asJava.setChunked( )
    this
  }

  def putHeader(name: String,value: String):HttpServerResponse = {
    asJava.putHeader( )
    this
  }

  def putTrailer(name: String,value: String):HttpServerResponse = {
    asJava.putTrailer( )
    this
  }

  def closeHandler(handler: io.vertx.core.Handler[Unit]):HttpServerResponse = {
    asJava.closeHandler( )
    this
  }

  def write(chunk: String,enc: String):HttpServerResponse = {
    asJava.write( )
    this
  }

  def write(chunk: String):HttpServerResponse = {
    asJava.write( )
    this
  }

  def writeContinue():HttpServerResponse = {
    asJava.writeContinue( )
    this
  }

  def sendFile(filename: String):HttpServerResponse = {
    asJava.sendFile( )
    this
  }

  def sendFile(filename: String,offset: Long):HttpServerResponse = {
    asJava.sendFile( )
    this
  }

  def sendFile(filename: String,offset: Long,length: Long):HttpServerResponse = {
    asJava.sendFile( )
    this
  }

  def sendFile(filename: String,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):HttpServerResponse = {
    asJava.sendFile( )
    this
  }

  def sendFile(filename: String,offset: Long,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):HttpServerResponse = {
    asJava.sendFile( )
    this
  }

  def sendFile(filename: String,offset: Long,length: Long,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):HttpServerResponse = {
    asJava.sendFile( )
    this
  }

  def headersEndHandler(handler: io.vertx.core.Handler[Unit]):HttpServerResponse = {
    asJava.headersEndHandler( )
    this
  }

  def bodyEndHandler(handler: io.vertx.core.Handler[Unit]):HttpServerResponse = {
    asJava.bodyEndHandler( )
    this
  }

  def push(method: io.vertx.core.http.HttpMethod,path: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[HttpServerResponse]]):HttpServerResponse = {
    asJava.push( )
    this
  }

  def push(method: io.vertx.core.http.HttpMethod,host: String,path: String,headers: MultiMap,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[HttpServerResponse]]):HttpServerResponse = {
    asJava.push( )
    this
  }

  def writeCustomFrame(type: Int,flags: Int,payload: Buffer):HttpServerResponse = {
    asJava.writeCustomFrame( )
    this
  }

  def writeCustomFrame(frame: HttpFrame):HttpServerResponse = {
    asJava.writeCustomFrame( )
    this
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.writeQueueFull( )
  }

  def getStatusCode():Int = {
    asJava.getStatusCode( )
  }

  def getStatusMessage():String = {
    asJava.getStatusMessage( )
  }

  def isChunked():Boolean = {
    asJava.isChunked( )
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

  def close():Unit = {
    asJava.close( )
  }

  def ended():Boolean = {
    asJava.ended( )
  }

  def closed():Boolean = {
    asJava.closed( )
  }

  def headWritten():Boolean = {
    asJava.headWritten( )
  }

  def bytesWritten():Long = {
    asJava.bytesWritten( )
  }

  def streamId():Int = {
    asJava.streamId( )
  }

  def push(method: io.vertx.core.http.HttpMethod,host: String,path: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[HttpServerResponse]]):HttpServerResponse = {
    asJava.push( )
  }

  def push(method: io.vertx.core.http.HttpMethod,path: String,headers: MultiMap,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[HttpServerResponse]]):HttpServerResponse = {
    asJava.push( )
  }

  def reset(code: Long):Unit = {
    asJava.reset( )
  }

}

object HttpServerResponse{
//in object!
//static methods
}
