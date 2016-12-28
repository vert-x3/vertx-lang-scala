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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
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
    extends ReadStream[DatagramPacket] 
    with Measured {

  def asJava = _asJava
  private var cached_0:SocketAddress = _

//cached methods
  def localAddress():SocketAddress = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JDatagramSocket].localAddress()
      cached_0 = SocketAddress(tmp)
    }
    cached_0
  }

//fluent methods
  def send(packet: Buffer,port: Int,host: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].send(packet.asJava.asInstanceOf[JBuffer],port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],{x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  def send(str: String,port: Int,host: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].send(str.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],{x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  def send(str: String,enc: String,port: Int,host: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].send(str.asInstanceOf[java.lang.String],enc.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],{x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  def listenMulticastGroup(multicastAddress: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].listenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String],{x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  def listenMulticastGroup(multicastAddress: String,networkInterface: String,source: scala.Option[String],handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].listenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String],networkInterface.asInstanceOf[java.lang.String],source.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null),{x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  def unlistenMulticastGroup(multicastAddress: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].unlistenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String],{x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  def unlistenMulticastGroup(multicastAddress: String,networkInterface: String,source: scala.Option[String],handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].unlistenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String],networkInterface.asInstanceOf[java.lang.String],source.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null),{x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  def blockMulticastGroup(multicastAddress: String,sourceToBlock: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].blockMulticastGroup(multicastAddress.asInstanceOf[java.lang.String],sourceToBlock.asInstanceOf[java.lang.String],{x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  def blockMulticastGroup(multicastAddress: String,networkInterface: String,sourceToBlock: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].blockMulticastGroup(multicastAddress.asInstanceOf[java.lang.String],networkInterface.asInstanceOf[java.lang.String],sourceToBlock.asInstanceOf[java.lang.String],{x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  def listen(port: Int,host: String,handler: Handler[AsyncResult[DatagramSocket]]):DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].listen(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],{x: AsyncResult[JDatagramSocket] => handler.handle(AsyncResultWrapper[JDatagramSocket,DatagramSocket](x, a => DatagramSocket(a)))})
    this
  }

  override def pause():DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].pause()
    this
  }

  override def resume():DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]):DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  override def handler(handler: Handler[DatagramPacket]):DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].handler({x: JDatagramPacket => handler.handle(DatagramPacket(x))})
    this
  }

  override def exceptionHandler(handler: Handler[Throwable]):DatagramSocket = {
    asJava.asInstanceOf[JDatagramSocket].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

//default methods
//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JDatagramSocket].isMetricsEnabled()
  }

  def sender(port: Int,host: String):PacketWritestream = {
    PacketWritestream(asJava.asInstanceOf[JDatagramSocket].sender(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String]))
  }

  def close(handler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JDatagramSocket].close({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  def close():Unit = {
    asJava.asInstanceOf[JDatagramSocket].close()
  }

//future methods
def sendFuture(packet: Buffer,port: Int,host: String):scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].send(packet.asJava.asInstanceOf[JBuffer],port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def sendFuture(str: String,port: Int,host: String):scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].send(str.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def sendFuture(str: String,enc: String,port: Int,host: String):scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].send(str.asInstanceOf[java.lang.String],enc.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def closeFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JDatagramSocket].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def listenMulticastGroupFuture(multicastAddress: String):scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].listenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def listenMulticastGroupFuture(multicastAddress: String,networkInterface: String,source: scala.Option[String]):scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].listenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String],networkInterface.asInstanceOf[java.lang.String],source.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null),promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def unlistenMulticastGroupFuture(multicastAddress: String):scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].unlistenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def unlistenMulticastGroupFuture(multicastAddress: String,networkInterface: String,source: scala.Option[String]):scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].unlistenMulticastGroup(multicastAddress.asInstanceOf[java.lang.String],networkInterface.asInstanceOf[java.lang.String],source.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null),promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def blockMulticastGroupFuture(multicastAddress: String,sourceToBlock: String):scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].blockMulticastGroup(multicastAddress.asInstanceOf[java.lang.String],sourceToBlock.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def blockMulticastGroupFuture(multicastAddress: String,networkInterface: String,sourceToBlock: String):scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].blockMulticastGroup(multicastAddress.asInstanceOf[java.lang.String],networkInterface.asInstanceOf[java.lang.String],sourceToBlock.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def listenFuture(port: Int,host: String):scala.concurrent.Future[DatagramSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JDatagramSocket, DatagramSocket](x => DatagramSocket(x))
    asJava.asInstanceOf[JDatagramSocket].listen(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object DatagramSocket{
    def apply(asJava: JDatagramSocket) = new DatagramSocket(asJava)  
  //static methods
  }
