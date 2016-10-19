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

package io.vertx.ext.scala.eventbus.bridge.tcp

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.net.NetServerOptions
import io.vertx.scala.core.Vertx
import io.vertx.ext.bridge.BridgeOptions
import io.vertx.core.Handler

/**
  * TCP EventBus bridge for Vert.x
  */
class TcpEventBusBridge(private val _asJava: io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge) {

  def asJava: io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge = _asJava

  /**
    * Listen on default port 7000
    * @return self
    */
  def listen(): io.vertx.ext.scala.eventbus.bridge.tcp.TcpEventBusBridge = {
    _asJava.listen()
    this
  }

  /**
    * Listen on default port 7000 with a handler to report the state of the socket listen operation.
    * @return the result future
    */
  def listenFuture(): concurrent.Future[io.vertx.ext.scala.eventbus.bridge.tcp.TcpEventBusBridge] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge,io.vertx.ext.scala.eventbus.bridge.tcp.TcpEventBusBridge]((x => if (x == null) null else TcpEventBusBridge.apply(x)))
    _asJava.listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Listen on specific port and bind to specific address
    * @param port tcp port
    * @param address tcp address to the bind
    * @return self
    */
  def listen(port: Int, address: String): io.vertx.ext.scala.eventbus.bridge.tcp.TcpEventBusBridge = {
    _asJava.listen(port, address)
    this
  }

  /**
    * Listen on specific port and bind to specific address
    * @param port tcp port
    * @param address tcp address to the bind
    * @return the result future
    */
  def listenFuture(port: Int, address: String): concurrent.Future[io.vertx.ext.scala.eventbus.bridge.tcp.TcpEventBusBridge] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge,io.vertx.ext.scala.eventbus.bridge.tcp.TcpEventBusBridge]((x => if (x == null) null else TcpEventBusBridge.apply(x)))
    _asJava.listen(port, address, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Listen on specific port
    * @param port tcp port
    * @return self
    */
  def listen(port: Int): io.vertx.ext.scala.eventbus.bridge.tcp.TcpEventBusBridge = {
    _asJava.listen(port)
    this
  }

  /**
    * Listen on specific port
    * @param port tcp port
    * @return the result future
    */
  def listenFuture(port: Int): concurrent.Future[io.vertx.ext.scala.eventbus.bridge.tcp.TcpEventBusBridge] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge,io.vertx.ext.scala.eventbus.bridge.tcp.TcpEventBusBridge]((x => if (x == null) null else TcpEventBusBridge.apply(x)))
    _asJava.listen(port, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Close the current socket.
    * @return the result future
    */
  def closeFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Close the current socket.
    */
  def close(): Unit = {
    _asJava.close()
  }

}

object TcpEventBusBridge {

  def apply(_asJava: io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge): io.vertx.ext.scala.eventbus.bridge.tcp.TcpEventBusBridge =
    new io.vertx.ext.scala.eventbus.bridge.tcp.TcpEventBusBridge(_asJava)

  def create(vertx: io.vertx.scala.core.Vertx): io.vertx.ext.scala.eventbus.bridge.tcp.TcpEventBusBridge = {
    TcpEventBusBridge.apply(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx]))
  }

  def create(vertx: io.vertx.scala.core.Vertx, options: io.vertx.scala.ext.bridge.BridgeOptions): io.vertx.ext.scala.eventbus.bridge.tcp.TcpEventBusBridge = {
    TcpEventBusBridge.apply(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], options.asJava))
  }

  def create(vertx: io.vertx.scala.core.Vertx, options: io.vertx.scala.ext.bridge.BridgeOptions, netServerOptions: io.vertx.scala.core.net.NetServerOptions): io.vertx.ext.scala.eventbus.bridge.tcp.TcpEventBusBridge = {
    TcpEventBusBridge.apply(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], options.asJava, netServerOptions.asJava))
  }

}
