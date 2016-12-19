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

package io.vertx.scala.core.datagram

import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.core.datagram.{PacketWritestream => JPacketWritestream}

/**
  * A [[io.vertx.scala.core.streams.WriteStream]] for sending packets to a [[io.vertx.scala.core.net.SocketAddress]].
  * The stream  is called when the write fails.
  */
class PacketWritestream(private val _asJava: Object) 
    extends WriteStream[Buffer] {

  def asJava = _asJava

//cached methods
//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):PacketWritestream = {
    asJava.asInstanceOf[JPacketWritestream].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def write(data: Buffer):PacketWritestream = {
    asJava.asInstanceOf[JPacketWritestream].write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):PacketWritestream = {
    asJava.asInstanceOf[JPacketWritestream].setWriteQueueMaxSize(maxSize)
    this
  }

  override def drainHandler(handler: Handler[Unit]):PacketWritestream = {
    asJava.asInstanceOf[JPacketWritestream].drainHandler({x: Void => handler.handle(x)})
    this
  }

//basic methods
  override def end():Unit = {
    asJava.asInstanceOf[JPacketWritestream].end()
  }

  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JPacketWritestream].writeQueueFull()
  }

}

object PacketWritestream{
  def apply(asJava: JPacketWritestream) = new PacketWritestream(asJava)
//static methods
}
