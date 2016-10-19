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
import io.vertx.scala.core.net.SocketAddress

/**
  * A received datagram packet (UDP) which contains the data and information about the sender of the data itself.
  */
class DatagramPacket(private val _asJava: io.vertx.core.datagram.DatagramPacket) {

  def asJava: io.vertx.core.datagram.DatagramPacket = _asJava

  /**
    * Returns the [[io.vertx.scala.core.net.SocketAddress]] of the sender that sent
    * this [[io.vertx.scala.core.datagram.DatagramPacket]].
    * @return the address of the sender
    */
  def sender(): io.vertx.scala.core.net.SocketAddress = {
    SocketAddress.apply(_asJava.sender())
  }

  /**
    * Returns the data of the [[io.vertx.scala.core.datagram.DatagramPacket]]
    * @return the data
    */
  def data(): io.vertx.scala.core.buffer.Buffer = {
    Buffer.apply(_asJava.data())
  }

}

object DatagramPacket {

  def apply(_asJava: io.vertx.core.datagram.DatagramPacket): io.vertx.scala.core.datagram.DatagramPacket =
    new io.vertx.scala.core.datagram.DatagramPacket(_asJava)

}
