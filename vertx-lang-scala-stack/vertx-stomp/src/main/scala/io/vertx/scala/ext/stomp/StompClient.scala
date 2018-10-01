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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.stomp.{StompClientConnection => JStompClientConnection}
import io.vertx.scala.core.net.NetClient
import io.vertx.core.net.{NetClient => JNetClient}
import scala.reflect.runtime.universe._
import io.vertx.ext.stomp.{StompClient => JStompClient}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.Converter._
import io.vertx.ext.stomp.{Frame => JFrame}
import io.vertx.ext.stomp.{StompClientOptions => JStompClientOptions}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * Defines a STOMP client.
  */

class StompClient(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Connects to the server.   * @param port the server port
   * @param host the server host
   * @param resultHandler handler called with the connection result
   * @return the current StompClient
   */
  
  def connect(port: Int, host: String, resultHandler: Handler[AsyncResult[StompClientConnection]]): StompClient = {
    asJava.asInstanceOf[JStompClient].connect(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], {x: AsyncResult[JStompClientConnection] => resultHandler.handle(AsyncResultWrapper[JStompClientConnection, StompClientConnection](x, a => StompClientConnection(a)))})
    this
  }

  /**
   * Connects to the server.   * @param net the NET client to use
   * @param resultHandler handler called with the connection result
   * @return the current StompClient
   */
  
  def connect(net: NetClient, resultHandler: Handler[AsyncResult[StompClientConnection]]): StompClient = {
    asJava.asInstanceOf[JStompClient].connect(net.asJava.asInstanceOf[JNetClient], {x: AsyncResult[JStompClientConnection] => resultHandler.handle(AsyncResultWrapper[JStompClientConnection, StompClientConnection](x, a => StompClientConnection(a)))})
    this
  }

  /**
   * Connects to the server.   * @param port the server port
   * @param host the server host
   * @param net the NET client to use
   * @param resultHandler handler called with the connection result
   * @return the current StompClient
   */
  
  def connect(port: Int, host: String, net: NetClient, resultHandler: Handler[AsyncResult[StompClientConnection]]): StompClient = {
    asJava.asInstanceOf[JStompClient].connect(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], net.asJava.asInstanceOf[JNetClient], {x: AsyncResult[JStompClientConnection] => resultHandler.handle(AsyncResultWrapper[JStompClientConnection, StompClientConnection](x, a => StompClientConnection(a)))})
    this
  }

  /**
   * Connects to the server using the host and port configured in the client's options.   * @param resultHandler handler called with the connection result. A failure will be sent to the handler if a TCP level issue happen before the `CONNECTED` frame is received. Afterwards, the #exceptionHandler(Handler) is called.
   * @return the current StompClient
   */
  
  def connect(resultHandler: Handler[AsyncResult[StompClientConnection]]): StompClient = {
    asJava.asInstanceOf[JStompClient].connect({x: AsyncResult[JStompClientConnection] => resultHandler.handle(AsyncResultWrapper[JStompClientConnection, StompClientConnection](x, a => StompClientConnection(a)))})
    this
  }

  /**
   * Configures a received handler that gets notified when a STOMP frame is received by the client.
   * This handler can be used for logging, debugging or ad-hoc behavior. The frame can still be modified at the time.
   * 
   * When a connection is created, the handler is used as
   * [[io.vertx.scala.ext.stomp.StompClientConnection#receivedFrameHandler]].   * @param handler the handler
   * @return the current StompClient
   */
  
  def receivedFrameHandler(handler: Handler[Frame]): StompClient = {
    asJava.asInstanceOf[JStompClient].receivedFrameHandler({x: JFrame => handler.handle(Frame(x))})
    this
  }

  /**
   * Configures a writing handler that gets notified when a STOMP frame is written on the wire.
   * This handler can be used for logging, debugging or ad-hoc behavior. The frame can still be modified at the time.
   * 
   * When a connection is created, the handler is used as
   * [[io.vertx.scala.ext.stomp.StompClientConnection#writingFrameHandler]].   * @param handler the handler
   * @return the current StompClient
   */
  
  def writingFrameHandler(handler: Handler[Frame]): StompClient = {
    asJava.asInstanceOf[JStompClient].writingFrameHandler({x: JFrame => handler.handle(Frame(x))})
    this
  }

  /**
   * A general error frame handler. It can be used to catch `ERROR` frame emitted during the connection process
   * (wrong authentication). This error handler will be pass to all [[io.vertx.scala.ext.stomp.StompClientConnection]] created from this
   * client. Obviously, the client can override it when the connection is established.   * @param handler the handler
   * @return the current StompClient
   */
  
  def errorFrameHandler(handler: Handler[Frame]): StompClient = {
    asJava.asInstanceOf[JStompClient].errorFrameHandler({x: JFrame => handler.handle(Frame(x))})
    this
  }

  /**
   * Sets an exception handler notified for TCP-level errors.   * @param handler the handler
   * @return the current StompClient
   */
  
  def exceptionHandler(handler: Handler[Throwable]): StompClient = {
    asJava.asInstanceOf[JStompClient].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }



  /**
   * Closes the client.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JStompClient].close()
  }

  /**
   * @return the client's options.see <a href="../../../../../../../cheatsheet/StompClientOptions.html">StompClientOptions</a>
   */
  def options (): StompClientOptions = {
    StompClientOptions(asJava.asInstanceOf[JStompClient].options())
  }

  /**
   * @return the vert.x instance used by the client.
   */
  def vertx (): Vertx = {
    Vertx(asJava.asInstanceOf[JStompClient].vertx())
  }

  /**
   * @return whether or not the client is connected to the server.
   */
  def isClosed (): Boolean = {
    asJava.asInstanceOf[JStompClient].isClosed().asInstanceOf[Boolean]
  }


 /**
  * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def connectFuture (port: Int, host: String): scala.concurrent.Future[StompClientConnection] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JStompClientConnection, StompClientConnection](x => StompClientConnection(x))
    asJava.asInstanceOf[JStompClient].connect(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def connectFuture (net: NetClient): scala.concurrent.Future[StompClientConnection] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JStompClientConnection, StompClientConnection](x => StompClientConnection(x))
    asJava.asInstanceOf[JStompClient].connect(net.asJava.asInstanceOf[JNetClient], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def connectFuture (port: Int, host: String, net: NetClient): scala.concurrent.Future[StompClientConnection] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JStompClientConnection, StompClientConnection](x => StompClientConnection(x))
    asJava.asInstanceOf[JStompClient].connect(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], net.asJava.asInstanceOf[JNetClient], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def connectFuture (): scala.concurrent.Future[StompClientConnection] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JStompClientConnection, StompClientConnection](x => StompClientConnection(x))
    asJava.asInstanceOf[JStompClient].connect(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object StompClient {
  def apply(asJava: JStompClient) = new StompClient(asJava)
  
  /**
   * Creates a [[io.vertx.scala.ext.stomp.StompClient]] using the default implementation.   * @param vertx the vert.x instance to use
   * @return the created StompClient
   */
  def create(vertx: Vertx): StompClient = {
    StompClient(JStompClient.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
   * Creates a [[io.vertx.scala.ext.stomp.StompClient]] using the default implementation.   * @param vertx the vert.x instance to use
   * @param options the options see <a href="../../../../../../../cheatsheet/StompClientOptions.html">StompClientOptions</a>
   * @return the created StompClient
   */
  def create(vertx: Vertx,options: StompClientOptions): StompClient = {
    StompClient(JStompClient.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

}
