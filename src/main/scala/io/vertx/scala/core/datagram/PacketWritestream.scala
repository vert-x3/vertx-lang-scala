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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.core.buffer.Buffer
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.Handler

/**
  * A [[io.vertx.scala.core.streams.WriteStream]] for sending packets to a [[io.vertx.scala.core.net.SocketAddress]].
  * The stream  is called when the write fails.
  */
class PacketWritestream(private val _asJava: io.vertx.core.datagram.PacketWritestream) 
    extends io.vertx.scala.core.streams.WriteStream[io.vertx.scala.core.buffer.Buffer] {

  def asJava: io.vertx.core.datagram.PacketWritestream = _asJava

  /**
    * Ends the stream.
    * 
    * Once the stream has ended, it cannot be used any more.
    */
  def end(): Unit = {
    _asJava.end()
  }

  /**
    * Same as [[io.vertx.scala.core.streams.WriteStream#end]] but writes some data to the stream before ending.
    */
  def end(t: io.vertx.scala.core.buffer.Buffer): Unit = {
    _asJava.end(t.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.datagram.PacketWritestream#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    _asJava.writeQueueFull()
  }

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.datagram.PacketWritestream = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def write(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.datagram.PacketWritestream = {
    _asJava.write(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): io.vertx.scala.core.datagram.PacketWritestream = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: () => Unit): io.vertx.scala.core.datagram.PacketWritestream = {
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

}

object PacketWritestream {

  def apply(_asJava: io.vertx.core.datagram.PacketWritestream): io.vertx.scala.core.datagram.PacketWritestream =
    new io.vertx.scala.core.datagram.PacketWritestream(_asJava)

}
