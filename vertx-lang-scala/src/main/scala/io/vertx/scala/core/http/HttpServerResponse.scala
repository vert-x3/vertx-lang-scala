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
    asJava.asInstanceOf[JHttpServerResponse].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }

  override def drainHandler(handler: Handler[Unit]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].drainHandler({x: Void => handler.handle(x)})
    this
  }

  def setStatusCode(statusCode: Int):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].setStatusCode(statusCode.asInstanceOf[java.lang.Integer])
    this
  }

  def setStatusMessage(statusMessage: String):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].setStatusMessage(statusMessage.asInstanceOf[java.lang.String])
    this
  }

  def setChunked(chunked: Boolean):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].setChunked(chunked.asInstanceOf[java.lang.Boolean])
    this
  }

  def putHeader(name: String,value: String):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].putHeader(name.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String])
    this
  }

  def putTrailer(name: String,value: String):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].putTrailer(name.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String])
    this
  }

  def closeHandler(handler: Handler[Unit]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].closeHandler({x: Void => handler.handle(x)})
    this
  }

  def write(chunk: String,enc: String):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].write(chunk.asInstanceOf[java.lang.String],enc.asInstanceOf[java.lang.String])
    this
  }

  def write(chunk: String):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].write(chunk.asInstanceOf[java.lang.String])
    this
  }

  def writeContinue():HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].writeContinue()
    this
  }

  def sendFile(filename: String):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String])
    this
  }

  def sendFile(filename: String,offset: Long):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String],offset.asInstanceOf[java.lang.Long])
    this
  }

  def sendFile(filename: String,offset: Long,length: Long):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String],offset.asInstanceOf[java.lang.Long],length.asInstanceOf[java.lang.Long])
    this
  }

  def sendFile(filename: String,resultHandler: Handler[AsyncResult[Unit]]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def sendFile(filename: String,offset: Long,resultHandler: Handler[AsyncResult[Unit]]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String],offset.asInstanceOf[java.lang.Long],{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def sendFile(filename: String,offset: Long,length: Long,resultHandler: Handler[AsyncResult[Unit]]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String],offset.asInstanceOf[java.lang.Long],length.asInstanceOf[java.lang.Long],{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
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
    asJava.asInstanceOf[JHttpServerResponse].push(method,path.asInstanceOf[java.lang.String],{x: AsyncResult[JHttpServerResponse] => handler.handle(AsyncResultWrapper[JHttpServerResponse,HttpServerResponse](x, a => HttpServerResponse(a)))})
    this
  }

  def push(method: io.vertx.core.http.HttpMethod,host: String,path: String,headers: MultiMap,handler: Handler[AsyncResult[HttpServerResponse]]):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].push(method,host.asInstanceOf[java.lang.String],path.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],{x: AsyncResult[JHttpServerResponse] => handler.handle(AsyncResultWrapper[JHttpServerResponse,HttpServerResponse](x, a => HttpServerResponse(a)))})
    this
  }

  def writeCustomFrame(`type`: Int,flags: Int,payload: Buffer):HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].writeCustomFrame(`type`.asInstanceOf[java.lang.Integer],flags.asInstanceOf[java.lang.Integer],payload.asJava.asInstanceOf[JBuffer])
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
    asJava.asInstanceOf[JHttpServerResponse].writeQueueFull().asInstanceOf[Boolean]
  }

  def getStatusCode():Int = {
    asJava.asInstanceOf[JHttpServerResponse].getStatusCode().asInstanceOf[Int]
  }

  def getStatusMessage():String = {
    asJava.asInstanceOf[JHttpServerResponse].getStatusMessage().asInstanceOf[String]
  }

  def isChunked():Boolean = {
    asJava.asInstanceOf[JHttpServerResponse].isChunked().asInstanceOf[Boolean]
  }

  def end(chunk: String):Unit = {
    asJava.asInstanceOf[JHttpServerResponse].end(chunk.asInstanceOf[java.lang.String])
  }

  def end(chunk: String,enc: String):Unit = {
    asJava.asInstanceOf[JHttpServerResponse].end(chunk.asInstanceOf[java.lang.String],enc.asInstanceOf[java.lang.String])
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
    asJava.asInstanceOf[JHttpServerResponse].ended().asInstanceOf[Boolean]
  }

  def closed():Boolean = {
    asJava.asInstanceOf[JHttpServerResponse].closed().asInstanceOf[Boolean]
  }

  def headWritten():Boolean = {
    asJava.asInstanceOf[JHttpServerResponse].headWritten().asInstanceOf[Boolean]
  }

  def bytesWritten():Long = {
    asJava.asInstanceOf[JHttpServerResponse].bytesWritten().asInstanceOf[Long]
  }

  def streamId():Int = {
    asJava.asInstanceOf[JHttpServerResponse].streamId().asInstanceOf[Int]
  }

  def push(method: io.vertx.core.http.HttpMethod,host: String,path: String,handler: Handler[AsyncResult[HttpServerResponse]]):HttpServerResponse = {
    HttpServerResponse(asJava.asInstanceOf[JHttpServerResponse].push(method,host.asInstanceOf[java.lang.String],path.asInstanceOf[java.lang.String],{x: AsyncResult[JHttpServerResponse] => handler.handle(AsyncResultWrapper[JHttpServerResponse,HttpServerResponse](x, a => HttpServerResponse(a)))}))
  }

  def push(method: io.vertx.core.http.HttpMethod,path: String,headers: MultiMap,handler: Handler[AsyncResult[HttpServerResponse]]):HttpServerResponse = {
    HttpServerResponse(asJava.asInstanceOf[JHttpServerResponse].push(method,path.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],{x: AsyncResult[JHttpServerResponse] => handler.handle(AsyncResultWrapper[JHttpServerResponse,HttpServerResponse](x, a => HttpServerResponse(a)))}))
  }

  def reset(code: Long):Unit = {
    asJava.asInstanceOf[JHttpServerResponse].reset(code.asInstanceOf[java.lang.Long])
  }

//future methods
  def sendFileFuture(filename: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def sendFileFuture(filename: String,offset: Long):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String],offset.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def sendFileFuture(filename: String,offset: Long,length: Long):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String],offset.asInstanceOf[java.lang.Long],length.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def pushFuture(method: io.vertx.core.http.HttpMethod,host: String,path: String):scala.concurrent.Future[HttpServerResponse] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServerResponse, HttpServerResponse](x => if (x == null) null.asInstanceOf[HttpServerResponse] else HttpServerResponse(x))
    asJava.asInstanceOf[JHttpServerResponse].push(method,host.asInstanceOf[java.lang.String],path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def pushFuture(method: io.vertx.core.http.HttpMethod,path: String,headers: MultiMap):scala.concurrent.Future[HttpServerResponse] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServerResponse, HttpServerResponse](x => if (x == null) null.asInstanceOf[HttpServerResponse] else HttpServerResponse(x))
    asJava.asInstanceOf[JHttpServerResponse].push(method,path.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def pushFuture(method: io.vertx.core.http.HttpMethod,path: String):scala.concurrent.Future[HttpServerResponse] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServerResponse, HttpServerResponse](x => if (x == null) null.asInstanceOf[HttpServerResponse] else HttpServerResponse(x))
    asJava.asInstanceOf[JHttpServerResponse].push(method,path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def pushFuture(method: io.vertx.core.http.HttpMethod,host: String,path: String,headers: MultiMap):scala.concurrent.Future[HttpServerResponse] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServerResponse, HttpServerResponse](x => if (x == null) null.asInstanceOf[HttpServerResponse] else HttpServerResponse(x))
    asJava.asInstanceOf[JHttpServerResponse].push(method,host.asInstanceOf[java.lang.String],path.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object HttpServerResponse{
    def apply(asJava: Object) = new HttpServerResponse(asJava)  
  //static methods
  }
