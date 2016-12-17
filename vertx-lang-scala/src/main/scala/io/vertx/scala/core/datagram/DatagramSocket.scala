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

import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.datagram.{DatagramPacket => JDatagramPacket}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.datagram.{DatagramSocket => JDatagramSocket}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.datagram.{PacketWritestream => JPacketWritestream}
import io.vertx.scala.core.net.SocketAddress

/**
  * A datagram socket can be used to send [[io.vertx.scala.core.datagram.DatagramPacket]]'s to remote datagram servers
  * and receive [[io.vertx.scala.core.datagram.DatagramPacket]]s .
  * 
  * Usually you use a datagram socket to send UDP over the wire. UDP is connection-less which means you are not connected
  * to the remote peer in a persistent way. Because of this you have to supply the address and port of the remote peer
  * when sending data.
  * 
  * You can send data to ipv4 or ipv6 addresses, which also include multicast addresses.
  * 
  * Please consult the documentation for more information on datagram sockets.
  */
class DatagramSocket(private val _asJava: Object) 
    extends ReadStream[DatagramPacket](_asJava) 
    with Measured(_asJava) {

  private var cached_0:SocketAddress = _
  
//methods returning a future
  def close(handler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JDatagramSocket].close(handler)
  }

//cached methods
  def localAddress():SocketAddress = {
    if(cached_0 == null)
      cached_0 = SocketAddress(asJava.asInstanceOf[JDatagramSocket].localAddress())
    return cached_0
  }

//fluent methods
  def send(packet: Buffer,port: Int,host: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].send(packet.asJava.asInstanceOf[JBuffer],port,host,handler))
    this
  }

  def send(str: String,port: Int,host: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].send(str,port,host,handler))
    this
  }

  def send(str: String,enc: String,port: Int,host: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].send(str,enc,port,host,handler))
    this
  }

  def listenMulticastGroup(multicastAddress: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].listenMulticastGroup(multicastAddress,handler))
    this
  }

  def listenMulticastGroup(multicastAddress: String,networkInterface: String,source: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].listenMulticastGroup(multicastAddress,networkInterface,source,handler))
    this
  }

  def unlistenMulticastGroup(multicastAddress: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].unlistenMulticastGroup(multicastAddress,handler))
    this
  }

  def unlistenMulticastGroup(multicastAddress: String,networkInterface: String,source: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].unlistenMulticastGroup(multicastAddress,networkInterface,source,handler))
    this
  }

  def blockMulticastGroup(multicastAddress: String,sourceToBlock: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].blockMulticastGroup(multicastAddress,sourceToBlock,handler))
    this
  }

  def blockMulticastGroup(multicastAddress: String,networkInterface: String,sourceToBlock: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].blockMulticastGroup(multicastAddress,networkInterface,sourceToBlock,handler))
    this
  }

  def listen(port: Int,host: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].listen(port,host,handler))
    this
  }

  override def pause():DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].pause())
    this
  }

  override def resume():DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].resume())
    this
  }

  override def endHandler(endHandler: Handler[Unit]):DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].endHandler(endHandler))
    this
  }

  override def handler(handler: Handler[DatagramPacket]):DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].handler(handler))
    this
  }

  override def exceptionHandler(handler: Handler[Throwable]):DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JDatagramSocket].exceptionHandler(handler))
    this
  }

//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JDatagramSocket].isMetricsEnabled()
  }

  def sender(port: Int,host: String):PacketWritestream = {
    PacketWritestream(asJava.asInstanceOf[JDatagramSocket].sender(port,host))
  }

  def close(handler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JDatagramSocket].close(handler)
  }

  def close():Unit = {
    asJava.asInstanceOf[JDatagramSocket].close()
  }

}

object DatagramSocket{
  def apply(asJava: JDatagramSocket) = new DatagramSocket(asJava)//static methods
}
