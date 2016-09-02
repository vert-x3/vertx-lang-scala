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
import io.vertx.scala.core.metrics.Measured
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.Handler
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
class DatagramSocket(private val _asJava: io.vertx.core.datagram.DatagramSocket) 
    extends io.vertx.scala.core.streams.ReadStream[io.vertx.scala.core.datagram.DatagramPacket] 
    with io.vertx.scala.core.metrics.Measured {

  def asJava: io.vertx.core.datagram.DatagramSocket = _asJava

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  /**
    * Write the given [[io.vertx.scala.core.buffer.Buffer]] to the [[io.vertx.scala.core.net.SocketAddress]].
    * The scala-function will be notified once the write completes.
    * @param packet the [[io.vertx.scala.core.buffer.Buffer]] to write
    * @param port the host port of the remote peer
    * @param host the host address of the remote peer
    * @return the scala-function to notify once the write completes.
    */
  def sendFuture(packet: io.vertx.scala.core.buffer.Buffer, port: Int, host: String): concurrent.Future[io.vertx.scala.core.datagram.DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.datagram.DatagramSocket,io.vertx.scala.core.datagram.DatagramSocket]((x => if (x == null) null else DatagramSocket.apply(x)))
    _asJava.send(packet.asJava.asInstanceOf[io.vertx.core.buffer.Buffer], port, host, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Returns a [[io.vertx.scala.core.datagram.PacketWritestream]] able to send  to the
    * [[io.vertx.scala.core.net.SocketAddress]].
    * @param port the port of the remote peer
    * @param host the host address of the remote peer
    * @return the write stream for sending packets
    */
  def sender(port: Int, host: String): io.vertx.scala.core.datagram.PacketWritestream = {
    PacketWritestream.apply(_asJava.sender(port, host))
  }

  /**
    * Write the given String to the [[io.vertx.scala.core.net.SocketAddress]] using UTF8 encoding.
    * The  will be notified once the write completes.
    * @param str the [[String]] to write
    * @param port the host port of the remote peer
    * @param host the host address of the remote peer
    * @return the scala-function to notify once the write completes.
    */
  def sendFuture(str: String, port: Int, host: String): concurrent.Future[io.vertx.scala.core.datagram.DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.datagram.DatagramSocket,io.vertx.scala.core.datagram.DatagramSocket]((x => if (x == null) null else DatagramSocket.apply(x)))
    _asJava.send(str, port, host, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Write the given String to the [[io.vertx.scala.core.net.SocketAddress]] using the given encoding.
    * The  will be notified once the write completes.
    * @param str the [[String]] to write
    * @param enc the charset used for encoding
    * @param port the host port of the remote peer
    * @param host the host address of the remote peer
    * @return the scala-function to notify once the write completes.
    */
  def sendFuture(str: String, enc: String, port: Int, host: String): concurrent.Future[io.vertx.scala.core.datagram.DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.datagram.DatagramSocket,io.vertx.scala.core.datagram.DatagramSocket]((x => if (x == null) null else DatagramSocket.apply(x)))
    _asJava.send(str, enc, port, host, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Closes the [[io.vertx.scala.core.datagram.DatagramSocket]] implementation asynchronous
    * and notifies the handler once done.
    * @return the future to notify once complete
    */
  def closeFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Closes the [[io.vertx.scala.core.datagram.DatagramSocket]]. The close itself is asynchronous.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Return the [[io.vertx.scala.core.net.SocketAddress]] to which
    * this [[io.vertx.scala.core.datagram.DatagramSocket]] is bound.
    * @return the socket address
    */
  def localAddress(): io.vertx.scala.core.net.SocketAddress = {
    if(cached_0 == null) {
      cached_0=    SocketAddress.apply(_asJava.localAddress())
    }
    cached_0
  }

  /**
    * Joins a multicast group and listens for packets send to it.
    * The  is notified once the operation completes.
    * @param multicastAddress the address of the multicast group to join
    * @return then future to notify once the operation completes
    */
  def listenMulticastGroupFuture(multicastAddress: String): concurrent.Future[io.vertx.scala.core.datagram.DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.datagram.DatagramSocket,io.vertx.scala.core.datagram.DatagramSocket]((x => if (x == null) null else DatagramSocket.apply(x)))
    _asJava.listenMulticastGroup(multicastAddress, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Joins a multicast group and listens for packets send to it on the given network interface.
    * The  is notified once the operation completes.
    * @param multicastAddress the address of the multicast group to join
    * @param networkInterface the network interface on which to listen for packets.
    * @param source the address of the source for which we will listen for multicast packets
    * @return then future to notify once the operation completes
    */
  def listenMulticastGroupFuture(multicastAddress: String, networkInterface: String, source: scala.Option[String]): concurrent.Future[io.vertx.scala.core.datagram.DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.datagram.DatagramSocket,io.vertx.scala.core.datagram.DatagramSocket]((x => if (x == null) null else DatagramSocket.apply(x)))
    _asJava.listenMulticastGroup(multicastAddress, networkInterface, (if(source.isDefined) source.get else null), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Leaves a multicast group and stops listening for packets send to it.
    * The  is notified once the operation completes.
    * @param multicastAddress the address of the multicast group to leave
    * @return then future to notify once the operation completes
    */
  def unlistenMulticastGroupFuture(multicastAddress: String): concurrent.Future[io.vertx.scala.core.datagram.DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.datagram.DatagramSocket,io.vertx.scala.core.datagram.DatagramSocket]((x => if (x == null) null else DatagramSocket.apply(x)))
    _asJava.unlistenMulticastGroup(multicastAddress, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Leaves a multicast group and stops listening for packets send to it on the given network interface.
    * The  is notified once the operation completes.
    * @param multicastAddress the address of the multicast group to join
    * @param networkInterface the network interface on which to listen for packets.
    * @param source the address of the source for which we will listen for multicast packets
    * @return the future to notify once the operation completes
    */
  def unlistenMulticastGroupFuture(multicastAddress: String, networkInterface: String, source: scala.Option[String]): concurrent.Future[io.vertx.scala.core.datagram.DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.datagram.DatagramSocket,io.vertx.scala.core.datagram.DatagramSocket]((x => if (x == null) null else DatagramSocket.apply(x)))
    _asJava.unlistenMulticastGroup(multicastAddress, networkInterface, (if(source.isDefined) source.get else null), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Block the given address for the given multicast address and notifies the  once
    * the operation completes.
    * @param multicastAddress the address for which you want to block the source address
    * @param sourceToBlock the source address which should be blocked. You will not receive an multicast packets for it anymore.
    * @return the future to notify once the operation completes
    */
  def blockMulticastGroupFuture(multicastAddress: String, sourceToBlock: String): concurrent.Future[io.vertx.scala.core.datagram.DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.datagram.DatagramSocket,io.vertx.scala.core.datagram.DatagramSocket]((x => if (x == null) null else DatagramSocket.apply(x)))
    _asJava.blockMulticastGroup(multicastAddress, sourceToBlock, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Block the given address for the given multicast address on the given network interface and notifies
    * the  once the operation completes.
    * @param multicastAddress the address for which you want to block the source address
    * @param networkInterface the network interface on which the blocking should occur.
    * @param sourceToBlock the source address which should be blocked. You will not receive an multicast packets for it anymore.
    * @return the future to notify once the operation completes
    */
  def blockMulticastGroupFuture(multicastAddress: String, networkInterface: String, sourceToBlock: String): concurrent.Future[io.vertx.scala.core.datagram.DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.datagram.DatagramSocket,io.vertx.scala.core.datagram.DatagramSocket]((x => if (x == null) null else DatagramSocket.apply(x)))
    _asJava.blockMulticastGroup(multicastAddress, networkInterface, sourceToBlock, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Start listening on the given port and host. The handler will be called when the socket is listening.
    * @param port the port to listen on
    * @param host the host to listen on
    * @return the future will be called when listening
    */
  def listenFuture(port: Int, host: String): concurrent.Future[io.vertx.scala.core.datagram.DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.datagram.DatagramSocket,io.vertx.scala.core.datagram.DatagramSocket]((x => if (x == null) null else DatagramSocket.apply(x)))
    _asJava.listen(port, host, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def pause(): io.vertx.scala.core.datagram.DatagramSocket = {
    _asJava.pause()
    this
  }

  def resume(): io.vertx.scala.core.datagram.DatagramSocket = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: () => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => endHandler()))
    this
  }

  def handler(handler: io.vertx.scala.core.datagram.DatagramPacket => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    _asJava.handler(funcToMappedHandler(DatagramPacket.apply)(handler))
    this
  }

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.datagram.DatagramSocket = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  private var cached_0: io.vertx.scala.core.net.SocketAddress = _
}

object DatagramSocket {

  def apply(_asJava: io.vertx.core.datagram.DatagramSocket): io.vertx.scala.core.datagram.DatagramSocket =
    new io.vertx.scala.core.datagram.DatagramSocket(_asJava)

}
