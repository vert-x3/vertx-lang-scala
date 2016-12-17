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

import io.vertx.scala.core.datagram.PacketWritestream
import io.vertx.core.datagram.{PacketWritestream => JPacketWritestream}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.datagram.DatagramPacket
import io.vertx.core.datagram.{DatagramPacket => JDatagramPacket}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.datagram.{DatagramSocket => JDatagramSocket}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.net.SocketAddress
import io.vertx.core.net.{SocketAddress => JSocketAddress}

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

  override def asJava = _asJava.asInstanceOf[JDatagramSocket]
//methods returning a future
  def close(handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.close( )
  }

//cached methods
  def localAddress():SocketAddress = {
    asJava.localAddress( )
  }

//fluent methods
  def send(packet: Buffer,port: Int,host: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.send( )
    this
  }

  def send(str: String,port: Int,host: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.send( )
    this
  }

  def send(str: String,enc: String,port: Int,host: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.send( )
    this
  }

  def listenMulticastGroup(multicastAddress: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.listenMulticastGroup( )
    this
  }

  def listenMulticastGroup(multicastAddress: String,networkInterface: String,source: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.listenMulticastGroup( )
    this
  }

  def unlistenMulticastGroup(multicastAddress: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.unlistenMulticastGroup( )
    this
  }

  def unlistenMulticastGroup(multicastAddress: String,networkInterface: String,source: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.unlistenMulticastGroup( )
    this
  }

  def blockMulticastGroup(multicastAddress: String,sourceToBlock: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.blockMulticastGroup( )
    this
  }

  def blockMulticastGroup(multicastAddress: String,networkInterface: String,sourceToBlock: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.blockMulticastGroup( )
    this
  }

  def listen(port: Int,host: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.listen( )
    this
  }

  override def pause():DatagramSocket = {
    asJava.pause( )
    this
  }

  override def resume():DatagramSocket = {
    asJava.resume( )
    this
  }

  override def endHandler(endHandler: io.vertx.core.Handler[Unit]):DatagramSocket = {
    asJava.endHandler( )
    this
  }

  override def handler(handler: io.vertx.core.Handler[DatagramPacket]):DatagramSocket = {
    asJava.handler( )
    this
  }

  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):DatagramSocket = {
    asJava.exceptionHandler( )
    this
  }

//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.isMetricsEnabled( )
  }

  def sender(port: Int,host: String):PacketWritestream = {
    asJava.sender( )
  }

  def close(handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.close( )
  }

  def close():Unit = {
    asJava.close( )
  }

}

object DatagramSocket{
//in object!
//static methods
}
