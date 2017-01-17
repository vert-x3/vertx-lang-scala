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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.eventbus.bridge.tcp.{TcpEventBusBridge => JTcpEventBusBridge}
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.ext.bridge.BridgeOptions
import io.vertx.ext.bridge.{BridgeOptions => JBridgeOptions}
import io.vertx.core.AsyncResult
import io.vertx.scala.core.net.NetServerOptions
import io.vertx.core.Handler
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * TCP EventBus bridge for Vert.x
  */
class TcpEventBusBridge(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Listen on default port 7000
    * @return self
    */
  def listen():TcpEventBusBridge = {
    asJava.asInstanceOf[JTcpEventBusBridge].listen()
    this
  }

  /**
    * Listen on default port 7000 with a handler to report the state of the socket listen operation.
    * @return self
    */
  def listen(handler: Handler[AsyncResult[TcpEventBusBridge]]):TcpEventBusBridge = {
    asJava.asInstanceOf[JTcpEventBusBridge].listen({x: AsyncResult[JTcpEventBusBridge] => handler.handle(AsyncResultWrapper[JTcpEventBusBridge,TcpEventBusBridge](x, a => TcpEventBusBridge(a)))})
    this
  }

  /**
    * Listen on specific port and bind to specific address
    * @param port tcp port
    * @param address tcp address to the bind
    * @return self
    */
  def listen(port: Int,address: String):TcpEventBusBridge = {
    asJava.asInstanceOf[JTcpEventBusBridge].listen(port.asInstanceOf[java.lang.Integer],address.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Listen on specific port and bind to specific address
    * @param port tcp port
    * @param address tcp address to the bind
    * @return self
    */
  def listen(port: Int,address: String,handler: Handler[AsyncResult[TcpEventBusBridge]]):TcpEventBusBridge = {
    asJava.asInstanceOf[JTcpEventBusBridge].listen(port.asInstanceOf[java.lang.Integer],address.asInstanceOf[java.lang.String],{x: AsyncResult[JTcpEventBusBridge] => handler.handle(AsyncResultWrapper[JTcpEventBusBridge,TcpEventBusBridge](x, a => TcpEventBusBridge(a)))})
    this
  }

  /**
    * Listen on specific port
    * @param port tcp port
    * @return self
    */
  def listen(port: Int):TcpEventBusBridge = {
    asJava.asInstanceOf[JTcpEventBusBridge].listen(port.asInstanceOf[java.lang.Integer])
    this
  }

  /**
    * Listen on specific port
    * @param port tcp port
    * @return self
    */
  def listen(port: Int,handler: Handler[AsyncResult[TcpEventBusBridge]]):TcpEventBusBridge = {
    asJava.asInstanceOf[JTcpEventBusBridge].listen(port.asInstanceOf[java.lang.Integer],{x: AsyncResult[JTcpEventBusBridge] => handler.handle(AsyncResultWrapper[JTcpEventBusBridge,TcpEventBusBridge](x, a => TcpEventBusBridge(a)))})
    this
  }

  /**
    * Close the current socket.
    */
  def close(handler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JTcpEventBusBridge].close({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  /**
    * Close the current socket.
    */
  def close():Unit = {
    asJava.asInstanceOf[JTcpEventBusBridge].close()
  }

 /**
   * Listen on default port 7000 with a handler to report the state of the socket listen operation.
   * @return the result future
   */
  def listenFuture():scala.concurrent.Future[TcpEventBusBridge] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JTcpEventBusBridge, TcpEventBusBridge](x => TcpEventBusBridge(x))
    asJava.asInstanceOf[JTcpEventBusBridge].listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Listen on specific port and bind to specific address
   * @param port tcp port
   * @param address tcp address to the bind
   * @return the result future
   */
  def listenFuture(port: Int,address: String):scala.concurrent.Future[TcpEventBusBridge] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JTcpEventBusBridge, TcpEventBusBridge](x => TcpEventBusBridge(x))
    asJava.asInstanceOf[JTcpEventBusBridge].listen(port.asInstanceOf[java.lang.Integer],address.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Listen on specific port
   * @param port tcp port
   * @return the result future
   */
  def listenFuture(port: Int):scala.concurrent.Future[TcpEventBusBridge] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JTcpEventBusBridge, TcpEventBusBridge](x => TcpEventBusBridge(x))
    asJava.asInstanceOf[JTcpEventBusBridge].listen(port.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Close the current socket.
   * @return the result future
   */
  def closeFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JTcpEventBusBridge].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object TcpEventBusBridge{
  def apply(asJava: JTcpEventBusBridge) = new TcpEventBusBridge(asJava)  
  def create(vertx: Vertx):TcpEventBusBridge = {
    TcpEventBusBridge(JTcpEventBusBridge.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  def create(vertx: Vertx,options: BridgeOptions):TcpEventBusBridge = {
    TcpEventBusBridge(JTcpEventBusBridge.create(vertx.asJava.asInstanceOf[JVertx],options.asJava))
  }

  def create(vertx: Vertx,options: BridgeOptions,netServerOptions: NetServerOptions):TcpEventBusBridge = {
    TcpEventBusBridge(JTcpEventBusBridge.create(vertx.asJava.asInstanceOf[JVertx],options.asJava,netServerOptions.asJava))
  }

}
