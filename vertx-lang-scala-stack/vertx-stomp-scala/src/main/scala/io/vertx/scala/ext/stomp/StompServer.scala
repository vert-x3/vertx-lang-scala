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
import io.vertx.ext.stomp.{StompServer => JStompServer}
import io.vertx.ext.stomp.{StompServerHandler => JStompServerHandler}
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.scala.core.http.ServerWebSocket
import io.vertx.core.net.{NetServer => JNetServer}
import io.vertx.scala.core.net.NetServer
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.ext.stomp.{StompServerOptions => JStompServerOptions}
import io.vertx.scala.ext.stomp.StompServerOptions
import io.vertx.ext.stomp.{ServerFrame => JServerFrame}

/**
  * Defines a STOMP server. STOMP servers delegates to a [[io.vertx.scala.ext.stomp.StompServerHandler]] that let customize the behavior of
  * the server. By default, it uses a handler compliant with the STOMP specification, but let you change anything.
  */
class StompServer(private val _asJava: JStompServer) {

  def asJava: JStompServer = _asJava

  /**
    * Configures the [[io.vertx.scala.ext.stomp.StompServerHandler]]. You must calls this method before calling the [[io.vertx.scala.ext.stomp.StompServer#listen]] method.
    * @param handler the handler
    * @return the current [[StompServer]]
    */
  def handler(handler: StompServerHandler): StompServer = {
    _asJava.handler(handler.asJava.asInstanceOf[JStompServerHandler])
    this
  }

  /**
    * Connects the STOMP server to the given port.
    * @param port the port
    * @return the current [[StompServer]]
    */
  def listen(port: Int): StompServer = {
    _asJava.listen(port)
    this
  }

  /**
    * Connects the STOMP server to the given port / interface.
    * @param port the port
    * @param host the interface
    * @return the current [[StompServer]]
    */
  def listen(port: Int, host: String): StompServer = {
    _asJava.listen(port, host)
    this
  }

  /**
    * Connects the STOMP server to the port / host configured in the server options.
    * @return the current [[StompServer]]
    */
  def listen(): StompServer = {
    _asJava.listen()
    this
  }

  /**
    * Connects the STOMP server default port (61613) and network interface (`0.0.0.0`). Once the socket
    * it bounds calls the given handler with the result. The result may be a failure if the socket is already used.
    * @return the future to call with the result
    */
  def listenFuture(): concurrent.Future[StompServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JStompServer,StompServer]((x => if (x == null) null else StompServer.apply(x)))
    _asJava.listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Connects the STOMP server to the given port. This method use the default host (`0.0.0.0`). Once the socket
    * it bounds calls the given handler with the result. The result may be a failure if the socket is already used.
    * @param port the port
    * @return the future to call with the result
    */
  def listenFuture(port: Int): concurrent.Future[StompServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JStompServer,StompServer]((x => if (x == null) null else StompServer.apply(x)))
    _asJava.listen(port, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Connects the STOMP server to the given port / interface. Once the socket it bounds calls the given handler with
    * the result. The result may be a failure if the socket is already used.
    * @param port the port
    * @param host the host / interface
    * @return the future to call with the result
    */
  def listenFuture(port: Int, host: String): concurrent.Future[StompServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JStompServer,StompServer]((x => if (x == null) null else StompServer.apply(x)))
    _asJava.listen(port, host, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Closes the server.
    * @return future called once the server has been stopped
    */
  def closeFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Closes the server.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Checks whether or not the server is listening.
    * @return `true` if the server is listening, `false` otherwise
    */
  def isListening(): Boolean = {
    _asJava.isListening()
  }

  /**
    * Gets the port on which the server is listening.
    * <p/>
    * This is useful if you bound the server specifying 0 as port number signifying an ephemeral port.
    * @return the port
    */
  def actualPort(): Int = {
    _asJava.actualPort()
  }

  /**
    * @return the server optionssee <a href="../../../../../../../cheatsheet/StompServerOptions.html">StompServerOptions</a>
    */
  def options(): StompServerOptions = {
    StompServerOptions(_asJava.options())
  }

  /**
    * @return the instance of vert.x used by the server.
    */
  def vertx(): Vertx = {
    Vertx.apply(_asJava.vertx())
  }

  /**
    * @return the [[StompServerHandler]] used by this server.
    */
  def stompHandler(): StompServerHandler = {
    StompServerHandler.apply(_asJava.stompHandler())
  }

  /**
    * Gets the  able to manage web socket connections. If the web socket bridge is disabled, it returns
    * `null`.
    * @return the handler that can be passed to [[io.vertx.scala.core.http.HttpServer#websocketHandler(Handler)]].
    */
  def webSocketHandler(): ServerWebSocket => Unit = {
    handlerToMappedFunction[JServerWebSocket, ServerWebSocket](x => x.asJava)(_asJava.webSocketHandler())
  }

  /**
    * Configures the handler that is invoked every time a frame is going to be written to the "wire". It lets you log
    * the frames, but also adapt the frame if needed.
    * @param handler the handler, must not be `null`
    * @return the current [[StompServer]]
    */
  def writingFrameHandler(handler: ServerFrame => Unit): StompServer = {
    _asJava.writingFrameHandler(funcToMappedHandler(ServerFrame.apply)(handler))
    this
  }

}

object StompServer {

  def apply(_asJava: JStompServer): StompServer =
    new StompServer(_asJava)

  def create(vertx: Vertx, options: StompServerOptions): StompServer = {
    StompServer.apply(io.vertx.ext.stomp.StompServer.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  def create(vertx: Vertx, netServer: NetServer): StompServer = {
    StompServer.apply(io.vertx.ext.stomp.StompServer.create(vertx.asJava.asInstanceOf[JVertx], netServer.asJava.asInstanceOf[JNetServer]))
  }

  def create(vertx: Vertx, net: NetServer, options: StompServerOptions): StompServer = {
    StompServer.apply(io.vertx.ext.stomp.StompServer.create(vertx.asJava.asInstanceOf[JVertx], net.asJava.asInstanceOf[JNetServer], options.asJava))
  }

  def create(vertx: Vertx): StompServer = {
    StompServer.apply(io.vertx.ext.stomp.StompServer.create(vertx.asJava.asInstanceOf[JVertx]))
  }

}
