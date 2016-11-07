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
import io.vertx.ext.eventbus.bridge.tcp.{TcpEventBusBridge => JTcpEventBusBridge}
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
import io.vertx.scala.core.net.NetServerOptions
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.ext.bridge.{BridgeOptions => JBridgeOptions}
import io.vertx.scala.ext.bridge.BridgeOptions

/**
  * TCP EventBus bridge for Vert.x
  */
class TcpEventBusBridge(private val _asJava: JTcpEventBusBridge) {

  def asJava: JTcpEventBusBridge = _asJava

  /**
    * Listen on default port 7000
    * @return self
    */
  def listen(): TcpEventBusBridge = {
    _asJava.listen()
    this
  }

  /**
    * Listen on default port 7000 with a handler to report the state of the socket listen operation.
    * @return the result future
    */
  def listenFuture(): concurrent.Future[TcpEventBusBridge] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JTcpEventBusBridge,TcpEventBusBridge]((x => if (x == null) null else TcpEventBusBridge.apply(x)))
    _asJava.listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Listen on specific port and bind to specific address
    * @param port tcp port
    * @param address tcp address to the bind
    * @return self
    */
  def listen(port: Int, address: String): TcpEventBusBridge = {
    _asJava.listen(port, address)
    this
  }

  /**
    * Listen on specific port and bind to specific address
    * @param port tcp port
    * @param address tcp address to the bind
    * @return the result future
    */
  def listenFuture(port: Int, address: String): concurrent.Future[TcpEventBusBridge] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JTcpEventBusBridge,TcpEventBusBridge]((x => if (x == null) null else TcpEventBusBridge.apply(x)))
    _asJava.listen(port, address, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Listen on specific port
    * @param port tcp port
    * @return self
    */
  def listen(port: Int): TcpEventBusBridge = {
    _asJava.listen(port)
    this
  }

  /**
    * Listen on specific port
    * @param port tcp port
    * @return the result future
    */
  def listenFuture(port: Int): concurrent.Future[TcpEventBusBridge] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JTcpEventBusBridge,TcpEventBusBridge]((x => if (x == null) null else TcpEventBusBridge.apply(x)))
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

  def apply(_asJava: JTcpEventBusBridge): TcpEventBusBridge =
    new TcpEventBusBridge(_asJava)

  def create(vertx: Vertx): TcpEventBusBridge = {
    TcpEventBusBridge.apply(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  def create(vertx: Vertx, options: BridgeOptions): TcpEventBusBridge = {
    TcpEventBusBridge.apply(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  def create(vertx: Vertx, options: BridgeOptions, netServerOptions: NetServerOptions): TcpEventBusBridge = {
    TcpEventBusBridge.apply(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge.create(vertx.asJava.asInstanceOf[JVertx], options.asJava, netServerOptions.asJava))
  }

}
