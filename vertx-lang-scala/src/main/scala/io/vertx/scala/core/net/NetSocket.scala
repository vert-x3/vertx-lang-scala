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

import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.scala.core.net.SocketAddress
import io.vertx.core.net.{SocketAddress => JSocketAddress}

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

  override def asJava = _asJava.asInstanceOf[JNetSocket]
//methods returning a future
//cached methods
  def remoteAddress():SocketAddress = {
    asJava.remoteAddress( )
  }

  def localAddress():SocketAddress = {
    asJava.localAddress( )
  }

//fluent methods
  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):NetSocket = {
    asJava.exceptionHandler( )
    this
  }

  override def handler(handler: io.vertx.core.Handler[Buffer]):NetSocket = {
    asJava.handler( )
    this
  }

  override def pause():NetSocket = {
    asJava.pause( )
    this
  }

  override def resume():NetSocket = {
    asJava.resume( )
    this
  }

  override def endHandler(endHandler: io.vertx.core.Handler[Unit]):NetSocket = {
    asJava.endHandler( )
    this
  }

  override def write(data: Buffer):NetSocket = {
    asJava.write( )
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):NetSocket = {
    asJava.setWriteQueueMaxSize( )
    this
  }

  override def drainHandler(handler: io.vertx.core.Handler[Unit]):NetSocket = {
    asJava.drainHandler( )
    this
  }

  def write(str: String):NetSocket = {
    asJava.write( )
    this
  }

  def write(str: String,enc: String):NetSocket = {
    asJava.write( )
    this
  }

  def sendFile(filename: String):NetSocket = {
    asJava.sendFile( )
    this
  }

  def sendFile(filename: String,offset: Long):NetSocket = {
    asJava.sendFile( )
    this
  }

  def sendFile(filename: String,offset: Long,length: Long):NetSocket = {
    asJava.sendFile( )
    this
  }

  def sendFile(filename: String,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):NetSocket = {
    asJava.sendFile( )
    this
  }

  def sendFile(filename: String,offset: Long,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):NetSocket = {
    asJava.sendFile( )
    this
  }

  def sendFile(filename: String,offset: Long,length: Long,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):NetSocket = {
    asJava.sendFile( )
    this
  }

  def closeHandler(handler: io.vertx.core.Handler[Unit]):NetSocket = {
    asJava.closeHandler( )
    this
  }

  def upgradeToSsl(handler: io.vertx.core.Handler[Unit]):NetSocket = {
    asJava.upgradeToSsl( )
    this
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.writeQueueFull( )
  }

  def writeHandlerID():String = {
    asJava.writeHandlerID( )
  }

  override def end():Unit = {
    asJava.end( )
  }

  def close():Unit = {
    asJava.close( )
  }

  def isSsl():Boolean = {
    asJava.isSsl( )
  }

}

object NetSocket{
//in object!
//static methods
}
