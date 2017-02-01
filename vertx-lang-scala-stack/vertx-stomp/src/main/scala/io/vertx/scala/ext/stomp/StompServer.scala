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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.net.{NetServer => JNetServer}
import io.vertx.ext.stomp.{StompServer => JStompServer}
import io.vertx.scala.core.Vertx
import io.vertx.scala.core.http.ServerWebSocket
import io.vertx.core.{Vertx => JVertx}
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.ext.stomp.{StompServerOptions => JStompServerOptions}
import io.vertx.scala.core.net.NetServer
import io.vertx.core.AsyncResult
import io.vertx.ext.stomp.{ServerFrame => JServerFrame}
import io.vertx.core.Handler
import io.vertx.ext.stomp.{StompServerHandler => JStompServerHandler}

/**
  * Defines a STOMP server. STOMP servers delegates to a [[io.vertx.scala.ext.stomp.StompServerHandler]] that let customize the behavior of
  * the server. By default, it uses a handler compliant with the STOMP specification, but let you change anything.
  */
class StompServer(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Configures the [[io.vertx.scala.ext.stomp.StompServerHandler]]. You must calls this method before calling the [[io.vertx.scala.ext.stomp.StompServer#listen]] method.
    * @param handler the handler
    * @return the current StompServer
    */
  def handler(handler: StompServerHandler): StompServer = {
    asJava.asInstanceOf[JStompServer].handler(handler.asJava.asInstanceOf[JStompServerHandler])
    this
  }

  /**
    * Connects the STOMP server to the given port.
    * @param port the port
    * @return the current StompServer
    */
  def listen(port: Int): StompServer = {
    asJava.asInstanceOf[JStompServer].listen(port.asInstanceOf[java.lang.Integer])
    this
  }

  /**
    * Connects the STOMP server to the given port / interface.
    * @param port the port
    * @param host the interface
    * @return the current StompServer
    */
  def listen(port: Int, host: String): StompServer = {
    asJava.asInstanceOf[JStompServer].listen(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Connects the STOMP server to the port / host configured in the server options.
    * @return the current StompServer
    */
  def listen(): StompServer = {
    asJava.asInstanceOf[JStompServer].listen()
    this
  }

  /**
    * Connects the STOMP server default port (61613) and network interface (`0.0.0.0`). Once the socket
    * it bounds calls the given handler with the result. The result may be a failure if the socket is already used.
    * @return the current StompServer
    */
  def listen(handler: Handler[AsyncResult[StompServer]]): StompServer = {
    asJava.asInstanceOf[JStompServer].listen({x: AsyncResult[JStompServer] => handler.handle(AsyncResultWrapper[JStompServer,StompServer](x, a => StompServer(a)))})
    this
  }

  /**
    * Connects the STOMP server to the given port. This method use the default host (`0.0.0.0`). Once the socket
    * it bounds calls the given handler with the result. The result may be a failure if the socket is already used.
    * @param port the port
    * @return the current StompServer
    */
  def listen(port: Int, handler: Handler[AsyncResult[StompServer]]): StompServer = {
    asJava.asInstanceOf[JStompServer].listen(port.asInstanceOf[java.lang.Integer],{x: AsyncResult[JStompServer] => handler.handle(AsyncResultWrapper[JStompServer,StompServer](x, a => StompServer(a)))})
    this
  }

  /**
    * Connects the STOMP server to the given port / interface. Once the socket it bounds calls the given handler with
    * the result. The result may be a failure if the socket is already used.
    * @param port the port
    * @param host the host / interface
    * @return the current StompServer
    */
  def listen(port: Int, host: String, handler: Handler[AsyncResult[StompServer]]): StompServer = {
    asJava.asInstanceOf[JStompServer].listen(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],{x: AsyncResult[JStompServer] => handler.handle(AsyncResultWrapper[JStompServer,StompServer](x, a => StompServer(a)))})
    this
  }

  /**
    * Configures the handler that is invoked every time a frame is going to be written to the "wire". It lets you log
    * the frames, but also adapt the frame if needed.
    * @param handler the handler, must not be `null`
    * @return the current StompServer
    */
  def writingFrameHandler(handler: Handler[ServerFrame]): StompServer = {
    asJava.asInstanceOf[JStompServer].writingFrameHandler({x: JServerFrame => handler.handle(ServerFrame(x))})
    this
  }

  /**
    * Closes the server.
    */
  def close(completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JStompServer].close({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  /**
    * Closes the server.
    */
  def close(): Unit = {
    asJava.asInstanceOf[JStompServer].close()
  }

  /**
    * Checks whether or not the server is listening.
    * @return `true` if the server is listening, `false` otherwise
    */
  def isListening(): Boolean = {
    asJava.asInstanceOf[JStompServer].isListening().asInstanceOf[Boolean]
  }

  /**
    * Gets the port on which the server is listening.
    * <p/>
    * This is useful if you bound the server specifying 0 as port number signifying an ephemeral port.
    * @return the port
    */
  def actualPort(): Int = {
    asJava.asInstanceOf[JStompServer].actualPort().asInstanceOf[Int]
  }

  /**
    * @return the server optionssee <a href="../../../../../../../cheatsheet/StompServerOptions.html">StompServerOptions</a>
    */
  def options(): StompServerOptions = {
    StompServerOptions(asJava.asInstanceOf[JStompServer].options())
  }

  /**
    * @return the instance of vert.x used by the server.
    */
  def vertx(): Vertx = {
    Vertx(asJava.asInstanceOf[JStompServer].vertx())
  }

  /**
    * @return the StompServerHandler used by this server.
    */
  def stompHandler(): StompServerHandler = {
    StompServerHandler(asJava.asInstanceOf[JStompServer].stompHandler())
  }

  /**
    * Gets the  able to manage web socket connections. If the web socket bridge is disabled, it returns
    * `null`.
    * @return the handler that can be passed to io.vertx.scala.core.http.HttpServer#websocketHandler(Handler).
    */
  def webSocketHandler(): Handler[ServerWebSocket] = {
    {x: ServerWebSocket => asJava.asInstanceOf[JStompServer].webSocketHandler().handle(x.asJava.asInstanceOf[JServerWebSocket])}
  }

 /**
   * Connects the STOMP server default port (61613) and network interface (`0.0.0.0`). Once the socket
   * it bounds calls the given handler with the result. The result may be a failure if the socket is already used.
   * @return the future to call with the result
   */
  def listenFuture(): scala.concurrent.Future[StompServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JStompServer, StompServer](x => StompServer(x))
    asJava.asInstanceOf[JStompServer].listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Connects the STOMP server to the given port. This method use the default host (`0.0.0.0`). Once the socket
   * it bounds calls the given handler with the result. The result may be a failure if the socket is already used.
   * @param port the port
   * @return the future to call with the result
   */
  def listenFuture(port: Int): scala.concurrent.Future[StompServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JStompServer, StompServer](x => StompServer(x))
    asJava.asInstanceOf[JStompServer].listen(port.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Connects the STOMP server to the given port / interface. Once the socket it bounds calls the given handler with
   * the result. The result may be a failure if the socket is already used.
   * @param port the port
   * @param host the host / interface
   * @return the future to call with the result
   */
  def listenFuture(port: Int, host: String): scala.concurrent.Future[StompServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JStompServer, StompServer](x => StompServer(x))
    asJava.asInstanceOf[JStompServer].listen(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Closes the server.
   * @return future called once the server has been stopped
   */
  def closeFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JStompServer].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object StompServer {
  def apply(asJava: JStompServer) = new StompServer(asJava)  
  /**
    * Creates a [[io.vertx.scala.ext.stomp.StompServer]] based on the default Stomp Server implementation.
    * @param vertx the vert.x instance to use
    * @param options the server optionssee <a href="../../../../../../../cheatsheet/StompServerOptions.html">StompServerOptions</a>
    * @return the created StompServer
    */
  def create(vertx: Vertx, options: StompServerOptions): StompServer = {
    StompServer(JStompServer.create(vertx.asJava.asInstanceOf[JVertx],options.asJava))
  }

  /**
    * Creates a [[io.vertx.scala.ext.stomp.StompServer]] based on the default Stomp Server implementation.
    * @param vertx the vert.x instance to use
    * @param netServer the Net server used by the STOMP server
    * @return the created StompServer
    */
  def create(vertx: Vertx, netServer: NetServer): StompServer = {
    StompServer(JStompServer.create(vertx.asJava.asInstanceOf[JVertx],netServer.asJava.asInstanceOf[JNetServer]))
  }

  /**
    * Creates a [[io.vertx.scala.ext.stomp.StompServer]] based on the default Stomp Server implementation.
    * @param vertx the vert.x instance to use
    * @param net the Net server used by the STOMP server
    * @param options the server optionssee <a href="../../../../../../../cheatsheet/StompServerOptions.html">StompServerOptions</a>
    * @return the created StompServer
    */
  def create(vertx: Vertx, net: NetServer, options: StompServerOptions): StompServer = {
    StompServer(JStompServer.create(vertx.asJava.asInstanceOf[JVertx],net.asJava.asInstanceOf[JNetServer],options.asJava))
  }

  /**
    * Creates a [[io.vertx.scala.ext.stomp.StompServer]] based on the default Stomp Server implementation, and use the default options.
    * @param vertx the vert.x instance to use
    * @return the created StompServer
    */
  def create(vertx: Vertx): StompServer = {
    StompServer(JStompServer.create(vertx.asJava.asInstanceOf[JVertx]))
  }

}
