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

import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.datagram.{DatagramPacket => JDatagramPacket}
import io.vertx.scala.core.net.SocketAddress

/**
  * A received datagram packet (UDP) which contains the data and information about the sender of the data itself.
  */
class DatagramPacket(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//basic methods
  def sender():SocketAddress = {
    SocketAddress(asJava.asInstanceOf[JDatagramPacket].sender())
  }

  def data():Buffer = {
    Buffer(asJava.asInstanceOf[JDatagramPacket].data())
  }

}

  object DatagramPacket{
    def apply(asJava: JDatagramPacket) = new DatagramPacket(asJava)  
  //static methods
  }
