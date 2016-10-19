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

package io.vertx.scala.ext.stomp

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.stomp.Frame
import io.vertx.scala.core.Vertx
import io.vertx.core.Handler
import io.vertx.scala.core.net.NetClient
import io.vertx.ext.stomp.StompClientOptions

/**
  * Defines a STOMP client.
  */
class StompClient(private val _asJava: io.vertx.ext.stomp.StompClient) {

  def asJava: io.vertx.ext.stomp.StompClient = _asJava

  /**
    * Connects to the server.
    * @param port the server port
    * @param host the server host
    * @return future called with the connection result
    */
  def connectFuture(port: Int, host: String): concurrent.Future[io.vertx.scala.ext.stomp.StompClientConnection] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.stomp.StompClientConnection,io.vertx.scala.ext.stomp.StompClientConnection]((x => if (x == null) null else StompClientConnection.apply(x)))
    _asJava.connect(port, host, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Connects to the server.
    * @param net the NET client to use
    * @return future called with the connection result
    */
  def connectFuture(net: io.vertx.scala.core.net.NetClient): concurrent.Future[io.vertx.scala.ext.stomp.StompClientConnection] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.stomp.StompClientConnection,io.vertx.scala.ext.stomp.StompClientConnection]((x => if (x == null) null else StompClientConnection.apply(x)))
    _asJava.connect(net.asJava.asInstanceOf[io.vertx.core.net.NetClient], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Connects to the server.
    * @param port the server port
    * @param host the server host
    * @param net the NET client to use
    * @return future called with the connection result
    */
  def connectFuture(port: Int, host: String, net: io.vertx.scala.core.net.NetClient): concurrent.Future[io.vertx.scala.ext.stomp.StompClientConnection] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.stomp.StompClientConnection,io.vertx.scala.ext.stomp.StompClientConnection]((x => if (x == null) null else StompClientConnection.apply(x)))
    _asJava.connect(port, host, net.asJava.asInstanceOf[io.vertx.core.net.NetClient], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Connects to the server using the host and port configured in the client's options.
    * @return future called with the connection result
    */
  def connectFuture(): concurrent.Future[io.vertx.scala.ext.stomp.StompClientConnection] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.stomp.StompClientConnection,io.vertx.scala.ext.stomp.StompClientConnection]((x => if (x == null) null else StompClientConnection.apply(x)))
    _asJava.connect(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Configures a received handler that gets notified when a STOMP frame is received by the client.
    * This handler can be used for logging, debugging or ad-hoc behavior. The frame can still be modified at the time.
    * 
    * When a connection is created, the handler is used as
    * [[io.vertx.scala.ext.stomp.StompClientConnection#receivedFrameHandler]].
    * @param handler the handler
    * @return the current [[StompClient]]
    */
  def receivedFrameHandler(handler: io.vertx.scala.ext.stomp.Frame => Unit): io.vertx.scala.ext.stomp.StompClient = {
    _asJava.receivedFrameHandler(funcToMappedHandler[io.vertx.ext.stomp.Frame, io.vertx.scala.ext.stomp.Frame](a => Frame(a))(handler))
    this
  }

  /**
    * Configures a writing handler that gets notified when a STOMP frame is written on the wire.
    * This handler can be used for logging, debugging or ad-hoc behavior. The frame can still be modified at the time.
    * 
    * When a connection is created, the handler is used as
    * [[io.vertx.scala.ext.stomp.StompClientConnection#writingFrameHandler]].
    * @param handler the handler
    * @return the current [[StompClient]]
    */
  def writingFrameHandler(handler: io.vertx.scala.ext.stomp.Frame => Unit): io.vertx.scala.ext.stomp.StompClient = {
    _asJava.writingFrameHandler(funcToMappedHandler[io.vertx.ext.stomp.Frame, io.vertx.scala.ext.stomp.Frame](a => Frame(a))(handler))
    this
  }

  /**
    * A general error frame handler. It can be used to catch `ERROR` frame emitted during the connection process
    * (wrong authentication). This error handler will be pass to all [[io.vertx.scala.ext.stomp.StompClientConnection]] created from this
    * client. Obviously, the client can override it when the connection is established.
    * @param handler the handler
    * @return the current [[StompClient]]
    */
  def errorFrameHandler(handler: io.vertx.scala.ext.stomp.Frame => Unit): io.vertx.scala.ext.stomp.StompClient = {
    _asJava.errorFrameHandler(funcToMappedHandler[io.vertx.ext.stomp.Frame, io.vertx.scala.ext.stomp.Frame](a => Frame(a))(handler))
    this
  }

  /**
    * Closes the client.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * @return the client's options.see <a href="../../../../../../../cheatsheet/StompClientOptions.html">StompClientOptions</a>
    */
  def options(): io.vertx.scala.ext.stomp.StompClientOptions = {
    io.vertx.scala.ext.stomp.StompClientOptions(_asJava.options())
  }

  /**
    * @return the vert.x instance used by the client.
    */
  def vertx(): io.vertx.scala.core.Vertx = {
    Vertx.apply(_asJava.vertx())
  }

  /**
    * @return whether or not the client is connected to the server.
    */
  def isClosed(): Boolean = {
    _asJava.isClosed()
  }

}

object StompClient {

  def apply(_asJava: io.vertx.ext.stomp.StompClient): io.vertx.scala.ext.stomp.StompClient =
    new io.vertx.scala.ext.stomp.StompClient(_asJava)

  def create(vertx: io.vertx.scala.core.Vertx): io.vertx.scala.ext.stomp.StompClient = {
    StompClient.apply(io.vertx.ext.stomp.StompClient.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx]))
  }

  def create(vertx: io.vertx.scala.core.Vertx, options: io.vertx.scala.ext.stomp.StompClientOptions): io.vertx.scala.ext.stomp.StompClient = {
    StompClient.apply(io.vertx.ext.stomp.StompClient.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], options.asJava))
  }

}
