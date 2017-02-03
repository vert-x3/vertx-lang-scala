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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.datagram.{DatagramPacket => JDatagramPacket}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.datagram.{DatagramSocket => JDatagramSocket}
import io.vertx.core.buffer.Buffer
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
    extends  ReadStream[DatagramPacket] 
    with Measured {

  def asJava = _asJava
  private var cached_0: SocketAddress = _

  /**
    * Return the [[io.vertx.scala.core.net.SocketAddress]] to which
    * this [[io.vertx.scala.core.datagram.DatagramSocket]] is bound.
    * @return the socket address
    */
  def localAddress(): SocketAddress = {
    if (cached_0 == null) {
      val tmp = asJava.asInstanceOf[JDatagramSocket].localAddress()
      cached_0 = SocketAddress(tmp)
    }
    cached_0
  }

  /**
    * Write the given [[io.vertx.scala.core.buffer.Buffer]] to the [[io.vertx.scala.core.net.SocketAddress]].
    * The scala-function will be notified once the write completes.
    * @param packet the io.vertx.scala.core.buffer.Buffer to write
    * @param port the host port of the remote peer
    * @param host the host address of the remote peer
    * @return a reference to this, so the API can be used fluently
    */
  def send(packet: io.vertx.core.buffer.Buffer, port: Int, host: String, handler: Handler[AsyncResult[DatagramSocket]]): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].send(packet, port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], {x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  /**
    * Write the given String to the [[io.vertx.scala.core.net.SocketAddress]] using UTF8 encoding.
    * The  will be notified once the write completes.
    * @param str the String to write
    * @param port the host port of the remote peer
    * @param host the host address of the remote peer
    * @return a reference to this, so the API can be used fluently
    */
  def send(str: String, port: Int, host: String, handler: Handler[AsyncResult[DatagramSocket]]): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].send(str.asInstanceOf[java.lang.String], port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], {x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  /**
    * Write the given String to the [[io.vertx.scala.core.net.SocketAddress]] using the given encoding.
    * The  will be notified once the write completes.
    * @param str the String to write
    * @param enc the charset used for encoding
    * @param port the host port of the remote peer
    * @param host the host address of the remote peer
    * @return a reference to this, so the API can be used fluently
    */
  def send(str: String, enc: String, port: Int, host: String, handler: Handler[AsyncResult[DatagramSocket]]): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].send(str.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String], port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], {x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  /**
    * Joins a multicast group and listens for packets send to it.
    * The  is notified once the operation completes.
    * @param multicastAddress the address of the multicast group to join
    * @return a reference to this, so the API can be used fluently
    */
  def listenMulticastGroup(multicastAddress: String, handler: Handler[AsyncResult[DatagramSocket]]): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].listenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String], {x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  /**
    * Joins a multicast group and listens for packets send to it on the given network interface.
    * The  is notified once the operation completes.
    * @param multicastAddress the address of the multicast group to join
    * @param networkInterface the network interface on which to listen for packets.
    * @param source the address of the source for which we will listen for multicast packets
    * @return a reference to this, so the API can be used fluently
    */
  def listenMulticastGroup(multicastAddress: String, networkInterface: String, source: scala.Option[String], handler: Handler[AsyncResult[DatagramSocket]]): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].listenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String], networkInterface.asInstanceOf[java.lang.String], source.map(x => x.asInstanceOf[java.lang.String]).orNull, {x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  /**
    * Leaves a multicast group and stops listening for packets send to it.
    * The  is notified once the operation completes.
    * @param multicastAddress the address of the multicast group to leave
    * @return a reference to this, so the API can be used fluently
    */
  def unlistenMulticastGroup(multicastAddress: String, handler: Handler[AsyncResult[DatagramSocket]]): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].unlistenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String], {x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  /**
    * Leaves a multicast group and stops listening for packets send to it on the given network interface.
    * The  is notified once the operation completes.
    * @param multicastAddress the address of the multicast group to join
    * @param networkInterface the network interface on which to listen for packets.
    * @param source the address of the source for which we will listen for multicast packets
    * @return a reference to this, so the API can be used fluently
    */
  def unlistenMulticastGroup(multicastAddress: String, networkInterface: String, source: scala.Option[String], handler: Handler[AsyncResult[DatagramSocket]]): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].unlistenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String], networkInterface.asInstanceOf[java.lang.String], source.map(x => x.asInstanceOf[java.lang.String]).orNull, {x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  /**
    * Block the given address for the given multicast address and notifies the  once
    * the operation completes.
    * @param multicastAddress the address for which you want to block the source address
    * @param sourceToBlock the source address which should be blocked. You will not receive an multicast packets for it anymore.
    * @return a reference to this, so the API can be used fluently
    */
  def blockMulticastGroup(multicastAddress: String, sourceToBlock: String, handler: Handler[AsyncResult[DatagramSocket]]): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].blockMulticastGroup(multicastAddress.asInstanceOf[java.lang.String], sourceToBlock.asInstanceOf[java.lang.String], {x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  /**
    * Block the given address for the given multicast address on the given network interface and notifies
    * the  once the operation completes.
    * @param multicastAddress the address for which you want to block the source address
    * @param networkInterface the network interface on which the blocking should occur.
    * @param sourceToBlock the source address which should be blocked. You will not receive an multicast packets for it anymore.
    * @return a reference to this, so the API can be used fluently
    */
  def blockMulticastGroup(multicastAddress: String, networkInterface: String, sourceToBlock: String, handler: Handler[AsyncResult[DatagramSocket]]): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].blockMulticastGroup(multicastAddress.asInstanceOf[java.lang.String], networkInterface.asInstanceOf[java.lang.String], sourceToBlock.asInstanceOf[java.lang.String], {x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  /**
    * Start listening on the given port and host. The handler will be called when the socket is listening.
    * @param port the port to listen on
    * @param host the host to listen on
    * @return a reference to this, so the API can be used fluently
    */
  def listen(port: Int, host: String, handler: Handler[AsyncResult[DatagramSocket]]): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].listen(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], {x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  override def pause(): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].pause()
    this
  }

  override def resume(): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  override def handler(handler: Handler[DatagramPacket]): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].handler({x: JDatagramPacket => handler.handle(DatagramPacket(x))})
    this
  }

  override def exceptionHandler(handler: Handler[Throwable]): DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  override def isMetricsEnabled(): Boolean = {
    asJava.asInstanceOf[JDatagramSocket].isMetricsEnabled().asInstanceOf[Boolean]
  }

  /**
    * Returns a [[io.vertx.scala.core.datagram.PacketWritestream]] able to send  to the
    * [[io.vertx.scala.core.net.SocketAddress]].
    * @param port the port of the remote peer
    * @param host the host address of the remote peer
    * @return the write stream for sending packets
    */
  def sender(port: Int, host: String): PacketWritestream = {
    PacketWritestream(asJava.asInstanceOf[JDatagramSocket].sender(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String]))
  }

  /**
    * Closes the [[io.vertx.scala.core.datagram.DatagramSocket]] implementation asynchronous
    * and notifies the handler once done.
    */
  def close(handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JDatagramSocket].close({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  /**
    * Closes the [[io.vertx.scala.core.datagram.DatagramSocket]]. The close itself is asynchronous.
    */
  def close(): Unit = {
    asJava.asInstanceOf[JDatagramSocket].close()
  }

 /**
   * Write the given [[io.vertx.scala.core.buffer.Buffer]] to the [[io.vertx.scala.core.net.SocketAddress]].
   * The [[scala.concurrent.Future]] will be notified once the write completes.
   * @param packet the io.vertx.scala.core.buffer.Buffer to write
   * @param port the host port of the remote peer
   * @param host the host address of the remote peer
   * @return the [[scala.concurrent.Future]] to complete once the write completes.
   */
  def sendFuture(packet: io.vertx.core.buffer.Buffer, port: Int, host: String): scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].send(packet, port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Write the given String to the [[io.vertx.scala.core.net.SocketAddress]] using UTF8 encoding.
   * The  will be notified once the write completes.
   * @param str the String to write
   * @param port the host port of the remote peer
   * @param host the host address of the remote peer
   * @return the [[scala.concurrent.Future]] to complete once the write completes.
   */
  def sendFuture(str: String, port: Int, host: String): scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].send(str.asInstanceOf[java.lang.String], port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Write the given String to the [[io.vertx.scala.core.net.SocketAddress]] using the given encoding.
   * The  will be notified once the write completes.
   * @param str the String to write
   * @param enc the charset used for encoding
   * @param port the host port of the remote peer
   * @param host the host address of the remote peer
   * @return the [[scala.concurrent.Future]] to complete once the write completes.
   */
  def sendFuture(str: String, enc: String, port: Int, host: String): scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].send(str.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String], port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Closes the [[io.vertx.scala.core.datagram.DatagramSocket]] implementation asynchronous
   * and notifies the handler once done.
   * @return the future to complete once complete
   */
  def closeFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JDatagramSocket].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Joins a multicast group and listens for packets send to it.
   * The  is notified once the operation completes.
   * @param multicastAddress the address of the multicast group to join
   * @return then future to complete once the operation completes
   */
  def listenMulticastGroupFuture(multicastAddress: String): scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].listenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Joins a multicast group and listens for packets send to it on the given network interface.
   * The  is notified once the operation completes.
   * @param multicastAddress the address of the multicast group to join
   * @param networkInterface the network interface on which to listen for packets.
   * @param source the address of the source for which we will listen for multicast packets
   * @return then future to complete once the operation completes
   */
  def listenMulticastGroupFuture(multicastAddress: String, networkInterface: String, source: scala.Option[String]): scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].listenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String], networkInterface.asInstanceOf[java.lang.String], source.map(x => x.asInstanceOf[java.lang.String]).orNull, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Leaves a multicast group and stops listening for packets send to it.
   * The  is notified once the operation completes.
   * @param multicastAddress the address of the multicast group to leave
   * @return then future to complete once the operation completes
   */
  def unlistenMulticastGroupFuture(multicastAddress: String): scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].unlistenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Leaves a multicast group and stops listening for packets send to it on the given network interface.
   * The  is notified once the operation completes.
   * @param multicastAddress the address of the multicast group to join
   * @param networkInterface the network interface on which to listen for packets.
   * @param source the address of the source for which we will listen for multicast packets
   * @return the future to complete once the operation completes
   */
  def unlistenMulticastGroupFuture(multicastAddress: String, networkInterface: String, source: scala.Option[String]): scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].unlistenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String], networkInterface.asInstanceOf[java.lang.String], source.map(x => x.asInstanceOf[java.lang.String]).orNull, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Block the given address for the given multicast address and notifies the  once
   * the operation completes.
   * @param multicastAddress the address for which you want to block the source address
   * @param sourceToBlock the source address which should be blocked. You will not receive an multicast packets for it anymore.
   * @return the future to complete once the operation completes
   */
  def blockMulticastGroupFuture(multicastAddress: String, sourceToBlock: String): scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].blockMulticastGroup(multicastAddress.asInstanceOf[java.lang.String], sourceToBlock.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Block the given address for the given multicast address on the given network interface and notifies
   * the  once the operation completes.
   * @param multicastAddress the address for which you want to block the source address
   * @param networkInterface the network interface on which the blocking should occur.
   * @param sourceToBlock the source address which should be blocked. You will not receive an multicast packets for it anymore.
   * @return the future to complete once the operation completes
   */
  def blockMulticastGroupFuture(multicastAddress: String, networkInterface: String, sourceToBlock: String): scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].blockMulticastGroup(multicastAddress.asInstanceOf[java.lang.String], networkInterface.asInstanceOf[java.lang.String], sourceToBlock.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Start listening on the given port and host. The handler will be called when the socket is listening.
   * @param port the port to listen on
   * @param host the host to listen on
   * @return the future will be called when listening
   */
  def listenFuture(port: Int, host: String): scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].listen(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object DatagramSocket {
  def apply(asJava: JDatagramSocket) = new DatagramSocket(asJava)  
}
