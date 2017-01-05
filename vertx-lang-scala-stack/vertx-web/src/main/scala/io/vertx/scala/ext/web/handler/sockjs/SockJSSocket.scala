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

package io.vertx.scala.ext.web.handler.sockjs

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.handler.sockjs.{SockJSSocket => JSockJSSocket}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.ext.auth.User
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.ext.auth.{User => JUser}
import io.vertx.ext.web.{Session => JSession}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.scala.core.MultiMap
import io.vertx.core.Handler
import io.vertx.scala.ext.web.Session
import io.vertx.scala.core.net.SocketAddress

/**
  *
  * You interact with SockJS clients through instances of SockJS socket.
  * 
  * The API is very similar to [[io.vertx.scala.core.http.WebSocket]].
  * It implements both  and 
  * so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  */
class SockJSSocket(private val _asJava: Object) 
    extends ReadStream[Buffer] 
    with WriteStream[Buffer] {

  def asJava = _asJava

//cached methods
//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[Buffer]):SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].handler({x: JBuffer => handler.handle(Buffer(x))})
    this
  }

  override def pause():SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].pause()
    this
  }

  override def resume():SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]):SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  override def write(data: Buffer):SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }

  override def drainHandler(handler: Handler[Unit]):SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].drainHandler({x: Void => handler.handle(x)})
    this
  }

//default methods
  //io.vertx.core.streams.WriteStream
  override def end(t: Buffer):Unit = {
    asJava.asInstanceOf[JSockJSSocket].end(t.asJava.asInstanceOf[JBuffer])
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JSockJSSocket].writeQueueFull().asInstanceOf[Boolean]
  }

  def writeHandlerID():String = {
    asJava.asInstanceOf[JSockJSSocket].writeHandlerID().asInstanceOf[String]
  }

  override def end():Unit = {
    asJava.asInstanceOf[JSockJSSocket].end()
  }

  def close():Unit = {
    asJava.asInstanceOf[JSockJSSocket].close()
  }

  def remoteAddress():SocketAddress = {
    SocketAddress(asJava.asInstanceOf[JSockJSSocket].remoteAddress())
  }

  def localAddress():SocketAddress = {
    SocketAddress(asJava.asInstanceOf[JSockJSSocket].localAddress())
  }

  def headers():MultiMap = {
    MultiMap(asJava.asInstanceOf[JSockJSSocket].headers())
  }

  def uri():String = {
    asJava.asInstanceOf[JSockJSSocket].uri().asInstanceOf[String]
  }

  def webSession():scala.Option[Session] = {
    scala.Option(asJava.asInstanceOf[JSockJSSocket].webSession()).map(Session(_))
  }

  def webUser():scala.Option[User] = {
    scala.Option(asJava.asInstanceOf[JSockJSSocket].webUser()).map(User(_))
  }

//future methods
}

  object SockJSSocket{
    def apply(asJava: JSockJSSocket) = new SockJSSocket(asJava)  
  //static methods
  }
