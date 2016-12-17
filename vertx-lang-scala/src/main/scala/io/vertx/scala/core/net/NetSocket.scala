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

package io.vertx.scala.core.net

import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}

/**
  * Represents a socket-like interface to a TCP connection on either the
  * client or the server side.
  * 
  * Instances of this class are created on the client side by an [[io.vertx.scala.core.net.NetClient]]
  * when a connection to a server is made, or on the server side by a [[io.vertx.scala.core.net.NetServer]]
  * when a server accepts a connection.
  * 
  * It implements both  and  so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  */
class NetSocket(private val _asJava: Object) 
    extends ReadStream[Buffer](_asJava) 
    with WriteStream[Buffer](_asJava) {

  private var cached_0:SocketAddress = _
    private var cached_1:SocketAddress = _
  
//methods returning a future
//cached methods
  def remoteAddress():SocketAddress = {
    if(cached_0 == null)
      cached_0 = SocketAddress(asJava.asInstanceOf[JNetSocket].remoteAddress())
    return cached_0
  }

  def localAddress():SocketAddress = {
    if(cached_1 == null)
      cached_1 = SocketAddress(asJava.asInstanceOf[JNetSocket].localAddress())
    return cached_1
  }

//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].exceptionHandler(handler))
    this
  }

  override def handler(handler: Handler[Buffer]):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].handler(handler))
    this
  }

  override def pause():NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].pause())
    this
  }

  override def resume():NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].resume())
    this
  }

  override def endHandler(endHandler: Handler[Unit]):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].endHandler(endHandler))
    this
  }

  override def write(data: Buffer):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].write(data.asJava.asInstanceOf[JBuffer]))
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].setWriteQueueMaxSize(maxSize))
    this
  }

  override def drainHandler(handler: Handler[Unit]):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].drainHandler(handler))
    this
  }

  def write(str: String):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].write(str))
    this
  }

  def write(str: String,enc: String):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].write(str,enc))
    this
  }

  def sendFile(filename: String):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].sendFile(filename))
    this
  }

  def sendFile(filename: String,offset: Long):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].sendFile(filename,offset))
    this
  }

  def sendFile(filename: String,offset: Long,length: Long):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].sendFile(filename,offset,length))
    this
  }

  def sendFile(filename: String,resultHandler: Handler[AsyncResult[Unit]]):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].sendFile(filename,resultHandler))
    this
  }

  def sendFile(filename: String,offset: Long,resultHandler: Handler[AsyncResult[Unit]]):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].sendFile(filename,offset,resultHandler))
    this
  }

  def sendFile(filename: String,offset: Long,length: Long,resultHandler: Handler[AsyncResult[Unit]]):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].sendFile(filename,offset,length,resultHandler))
    this
  }

  def closeHandler(handler: Handler[Unit]):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].closeHandler(handler))
    this
  }

  def upgradeToSsl(handler: Handler[Unit]):NetSocket = {
    NetSocket(asJava.asInstanceOf[JNetSocket].upgradeToSsl(handler))
    this
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JNetSocket].writeQueueFull()
  }

  def writeHandlerID():String = {
    asJava.asInstanceOf[JNetSocket].writeHandlerID()
  }

  override def end():Unit = {
    asJava.asInstanceOf[JNetSocket].end()
  }

  def close():Unit = {
    asJava.asInstanceOf[JNetSocket].close()
  }

  def isSsl():Boolean = {
    asJava.asInstanceOf[JNetSocket].isSsl()
  }

}

object NetSocket{
  def apply(asJava: JNetSocket) = new NetSocket(asJava)//static methods
}
