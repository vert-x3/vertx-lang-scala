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

package io.vertx.scala.core.datagram;

import io.vertx.scala.core.buffer.Buffer
import io.vertx.scala.core.metrics.Measured
import io.vertx.scala.core.streams.ReadStream
import scala.util.Try
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress

class DatagramSocket(private val _asJava: io.vertx.core.datagram.DatagramSocket) 
    extends io.vertx.scala.core.streams.ReadStream[io.vertx.scala.core.datagram.DatagramPacket] 
    with io.vertx.scala.core.metrics.Measured {

  def asJava: java.lang.Object = _asJava

  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  def send(packet: io.vertx.scala.core.buffer.Buffer, port: Int, host: String)(handler: Try[io.vertx.scala.core.datagram.DatagramSocket] => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.send(packet.asJava.asInstanceOf[io.vertx.core.buffer.Buffer], port, host, funcToMappedAsyncResultHandler(DatagramSocket.apply)(handler))
    this
  }

  def sender(port: Int, host: String): io.vertx.scala.core.datagram.PacketWritestream = {
    PacketWritestream.apply(_asJava.sender(port, host))
  }

  def send(str: String, port: Int, host: String)(handler: Try[io.vertx.scala.core.datagram.DatagramSocket] => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.send(str, port, host, funcToMappedAsyncResultHandler(DatagramSocket.apply)(handler))
    this
  }

  def send(str: String, enc: String, port: Int, host: String)(handler: Try[io.vertx.scala.core.datagram.DatagramSocket] => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.send(str, enc, port, host, funcToMappedAsyncResultHandler(DatagramSocket.apply)(handler))
    this
  }

  def close(handler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.close(funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
  }

  def close(): Unit = {
    _asJava.close()
  }

  def localAddress(): io.vertx.scala.core.net.SocketAddress = {
    SocketAddress.apply(_asJava.localAddress())
  }

  def listenMulticastGroup(multicastAddress: String)(handler: Try[io.vertx.scala.core.datagram.DatagramSocket] => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.listenMulticastGroup(multicastAddress, funcToMappedAsyncResultHandler(DatagramSocket.apply)(handler))
    this
  }

  def listenMulticastGroup(multicastAddress: String, networkInterface: String, source: String)(handler: Try[io.vertx.scala.core.datagram.DatagramSocket] => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.listenMulticastGroup(multicastAddress, networkInterface, source, funcToMappedAsyncResultHandler(DatagramSocket.apply)(handler))
    this
  }

  def unlistenMulticastGroup(multicastAddress: String)(handler: Try[io.vertx.scala.core.datagram.DatagramSocket] => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.unlistenMulticastGroup(multicastAddress, funcToMappedAsyncResultHandler(DatagramSocket.apply)(handler))
    this
  }

  def unlistenMulticastGroup(multicastAddress: String, networkInterface: String, source: String)(handler: Try[io.vertx.scala.core.datagram.DatagramSocket] => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.unlistenMulticastGroup(multicastAddress, networkInterface, source, funcToMappedAsyncResultHandler(DatagramSocket.apply)(handler))
    this
  }

  def blockMulticastGroup(multicastAddress: String, sourceToBlock: String)(handler: Try[io.vertx.scala.core.datagram.DatagramSocket] => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.blockMulticastGroup(multicastAddress, sourceToBlock, funcToMappedAsyncResultHandler(DatagramSocket.apply)(handler))
    this
  }

  def blockMulticastGroup(multicastAddress: String, networkInterface: String, sourceToBlock: String)(handler: Try[io.vertx.scala.core.datagram.DatagramSocket] => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.blockMulticastGroup(multicastAddress, networkInterface, sourceToBlock, funcToMappedAsyncResultHandler(DatagramSocket.apply)(handler))
    this
  }

  def listen(port: Int, host: String)(handler: Try[io.vertx.scala.core.datagram.DatagramSocket] => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.listen(port, host, funcToMappedAsyncResultHandler(DatagramSocket.apply)(handler))
    this
  }

  def pause(): io.vertx.scala.core.datagram.DatagramSocket = {
    _asJava.pause()
    this
  }

  def resume(): io.vertx.scala.core.datagram.DatagramSocket = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>endHandler))
    this
  }

  def handler(handler: io.vertx.scala.core.datagram.DatagramPacket => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.handler(funcToMappedHandler(DatagramPacket.apply)(handler))
    this
  }

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

}

object DatagramSocket {

  def apply(_asJava: io.vertx.core.datagram.DatagramSocket): io.vertx.scala.core.datagram.DatagramSocket =
    new io.vertx.scala.core.datagram.DatagramSocket(_asJava)
}
