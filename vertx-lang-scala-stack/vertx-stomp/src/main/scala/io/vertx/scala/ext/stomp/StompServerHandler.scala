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
import io.vertx.ext.stomp.{StompServer => JStompServer}
import io.vertx.ext.stomp.{BridgeOptions => JBridgeOptions}
import io.vertx.ext.stomp.{DestinationFactory => JDestinationFactory}
import io.vertx.ext.stomp.{Destination => JDestination}
import io.vertx.ext.stomp.{Acknowledgement => JAcknowledgement}
import io.vertx.ext.stomp.{StompServerConnection => JStompServerConnection}
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.stomp.{Frame => JFrame}
import io.vertx.core.AsyncResult
import io.vertx.ext.stomp.{ServerFrame => JServerFrame}
import io.vertx.core.Handler
import io.vertx.ext.stomp.{StompServerHandler => JStompServerHandler}

/**
  * STOMP server handler implements the behavior of the STOMP server when a specific event occurs. For instance, if
  * let customize the behavior when specific STOMP frames arrives or when a connection is closed. This class has been
  * designed to let you customize the server behavior. The default implementation is compliant with the STOMP
  * specification. In this default implementation, not acknowledge frames are dropped.
  */
class StompServerHandler(private val _asJava: Object)
    extends io.vertx.core.Handler[ServerFrame] {

  def asJava = _asJava

  /**
    * Configures a handler that get notified when a STOMP frame is received by the server.
    * This handler can be used for logging, debugging or ad-hoc behavior.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def receivedFrameHandler(handler: Handler[ServerFrame]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].receivedFrameHandler({x: JServerFrame => handler.handle(ServerFrame(x))})
    this
  }

  /**
    * Configures the action to execute when a `CONNECT` frame is received.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def connectHandler(handler: Handler[ServerFrame]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].connectHandler({x: JServerFrame => handler.handle(ServerFrame(x))})
    this
  }

  /**
    * Configures the action to execute when a `STOMP` frame is received.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def stompHandler(handler: Handler[ServerFrame]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].stompHandler({x: JServerFrame => handler.handle(ServerFrame(x))})
    this
  }

  /**
    * Configures the action to execute when a `SUBSCRIBE` frame is received.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def subscribeHandler(handler: Handler[ServerFrame]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].subscribeHandler({x: JServerFrame => handler.handle(ServerFrame(x))})
    this
  }

  /**
    * Configures the action to execute when a `UNSUBSCRIBE` frame is received.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def unsubscribeHandler(handler: Handler[ServerFrame]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].unsubscribeHandler({x: JServerFrame => handler.handle(ServerFrame(x))})
    this
  }

  /**
    * Configures the action to execute when a `SEND` frame is received.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def sendHandler(handler: Handler[ServerFrame]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].sendHandler({x: JServerFrame => handler.handle(ServerFrame(x))})
    this
  }

  /**
    * Configures the action to execute when a connection with the client is closed.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def closeHandler(handler: Handler[StompServerConnection]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].closeHandler({x: JStompServerConnection => handler.handle(StompServerConnection(x))})
    this
  }

  /**
    * Configures the action to execute when a `COMMIT` frame is received.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def commitHandler(handler: Handler[ServerFrame]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].commitHandler({x: JServerFrame => handler.handle(ServerFrame(x))})
    this
  }

  /**
    * Configures the action to execute when a `ABORT` frame is received.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def abortHandler(handler: Handler[ServerFrame]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].abortHandler({x: JServerFrame => handler.handle(ServerFrame(x))})
    this
  }

  /**
    * Configures the action to execute when a `BEGIN` frame is received.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def beginHandler(handler: Handler[ServerFrame]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].beginHandler({x: JServerFrame => handler.handle(ServerFrame(x))})
    this
  }

  /**
    * Configures the action to execute when a `DISCONNECT` frame is received.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def disconnectHandler(handler: Handler[ServerFrame]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].disconnectHandler({x: JServerFrame => handler.handle(ServerFrame(x))})
    this
  }

  /**
    * Configures the action to execute when a `ACK` frame is received.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def ackHandler(handler: Handler[ServerFrame]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].ackHandler({x: JServerFrame => handler.handle(ServerFrame(x))})
    this
  }

  /**
    * Configures the action to execute when a `NACK` frame is received.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def nackHandler(handler: Handler[ServerFrame]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].nackHandler({x: JServerFrame => handler.handle(ServerFrame(x))})
    this
  }

  /**
    * Called when the client connects to a server requiring authentication. It invokes the  configured
    * using [[io.vertx.scala.ext.stomp.StompServerHandler#authProvider]].
    * @param server the STOMP server.
    * @param login the login
    * @param passcode the password
    * @return the current StompServerHandler
    */
  def onAuthenticationRequest(server: StompServer, login: String, passcode: String, handler: Handler[AsyncResult[Boolean]]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].onAuthenticationRequest(server.asJava.asInstanceOf[JStompServer],login.asInstanceOf[java.lang.String],passcode.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Boolean] => handler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a.asInstanceOf[Boolean]))})
    this
  }

  /**
    * Configures the  to be used to authenticate the user.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def authProvider(handler: AuthProvider): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].authProvider(handler.asJava.asInstanceOf[JAuthProvider])
    this
  }

  /**
    * Method called by single message (client-individual policy) or a set of message (client policy) are acknowledged.
    * Implementations must call the handler configured using [[io.vertx.scala.ext.stomp.StompServerHandler#onAckHandler]].
    * @param connection the connection
    * @param subscribe the `SUBSCRIBE` framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @param messages the acknowledge messages
    * @return the current StompServerHandler
    */
  def onAck(connection: StompServerConnection, subscribe: Frame, messages: scala.collection.mutable.Buffer[Frame]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].onAck(connection.asJava.asInstanceOf[JStompServerConnection],subscribe.asJava,messages.map(x => x.asJava).asJava)
    this
  }

  /**
    * Method called by single message (client-individual policy) or a set of message (client policy) are
    * <strong>not</strong> acknowledged. Not acknowledgment can result from a `NACK` frame or from a timeout (no
    * `ACK` frame received in a given time. Implementations must call the handler configured using
    * [[io.vertx.scala.ext.stomp.StompServerHandler#onNackHandler]].
    * @param connection the connection
    * @param subscribe the `SUBSCRIBE` framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @param messages the acknowledge messages
    * @return the current StompServerHandler
    */
  def onNack(connection: StompServerConnection, subscribe: Frame, messages: scala.collection.mutable.Buffer[Frame]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].onNack(connection.asJava.asInstanceOf[JStompServerConnection],subscribe.asJava,messages.map(x => x.asJava).asJava)
    this
  }

  /**
    * Configures the action to execute when messages are acknowledged.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def onAckHandler(handler: Handler[Acknowledgement]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].onAckHandler({x: JAcknowledgement => handler.handle(Acknowledgement(x))})
    this
  }

  /**
    * Configures the action to execute when messages are <strong>not</strong> acknowledged.
    * @param handler the handler
    * @return the current StompServerHandler
    */
  def onNackHandler(handler: Handler[Acknowledgement]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].onNackHandler({x: JAcknowledgement => handler.handle(Acknowledgement(x))})
    this
  }

  /**
    * Allows customizing the action to do when the server needs to send a `PING` to the client. By default it send a
    * frame containing `EOL` (specification). However, you can customize this and send another frame. However,
    * be aware that this may requires a custom client.
    * <p/>
    * The handler will only be called if the connection supports heartbeats.
    * @param handler the action to execute when a `PING` needs to be sent.
    * @return the current StompServerHandler
    */
  def pingHandler(handler: Handler[StompServerConnection]): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].pingHandler({x: JStompServerConnection => handler.handle(StompServerConnection(x))})
    this
  }

  /**
    * Configures the [[io.vertx.scala.ext.stomp.DestinationFactory]] used to create [[io.vertx.scala.ext.stomp.Destination]] objects.
    * @param factory the factory
    * @return the current StompServerHandler.
    */
  def destinationFactory(factory: DestinationFactory): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].destinationFactory(factory.asJava.asInstanceOf[JDestinationFactory])
    this
  }

  /**
    * Configures the STOMP server to act as a bridge with the Vert.x event bus.
    * @param options the configuration optionssee <a href="../../../../../../../cheatsheet/BridgeOptions.html">BridgeOptions</a>
    * @return the current StompServerHandler.
    */
  def bridge(options: BridgeOptions): StompServerHandler = {
    asJava.asInstanceOf[JStompServerHandler].bridge(options.asJava)
    this
  }

  override def handle(arg0: ServerFrame): Unit = {
    asJava.asInstanceOf[JStompServerHandler].handle(arg0.asJava.asInstanceOf[JServerFrame])
  }

  /**
    * Called when the connection is closed. This method executes a default behavior and must calls the configured
    * [[io.vertx.scala.ext.stomp.StompServerHandler#closeHandler]] if any.
    * @param connection the connection
    */
  def onClose(connection: StompServerConnection): Unit = {
    asJava.asInstanceOf[JStompServerHandler].onClose(connection.asJava.asInstanceOf[JStompServerConnection])
  }

  /**
    * @return the list of destination managed by the STOMP server. Don't forget the STOMP interprets destination as opaque Strings.
    */
  def getDestinations(): scala.collection.mutable.Buffer[Destination] = {
    asJava.asInstanceOf[JStompServerHandler].getDestinations().asScala.map(x => Destination(x))
  }

  /**
    * Gets the destination with the given name.
    * @param destination the destination
    * @return the Destination, `null` if not existing.
    */
  def getDestination(destination: String): Destination = {
    Destination(asJava.asInstanceOf[JStompServerHandler].getDestination(destination.asInstanceOf[java.lang.String]))
  }

  /**
    * Gets a [[io.vertx.scala.ext.stomp.Destination]] object if existing, or create a new one. The creation is delegated to the
    * [[io.vertx.scala.ext.stomp.DestinationFactory]].
    * @param destination the destination
    * @return the Destination instance, may have been created.
    */
  def getOrCreateDestination(destination: String): Destination = {
    Destination(asJava.asInstanceOf[JStompServerHandler].getOrCreateDestination(destination.asInstanceOf[java.lang.String]))
  }

 /**
   * Called when the client connects to a server requiring authentication. It invokes the  configured
   * using [[io.vertx.scala.ext.stomp.StompServerHandler#authProvider]].
   * @param server the STOMP server.
   * @param login the login
   * @param passcode the password
   * @return future receiving the authentication result
   */
  def onAuthenticationRequestFuture(server: StompServer, login: String, passcode: String): scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JStompServerHandler].onAuthenticationRequest(server.asJava.asInstanceOf[JStompServer],login.asInstanceOf[java.lang.String],passcode.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object StompServerHandler {
  def apply(asJava: JStompServerHandler) = new StompServerHandler(asJava)  
  /**
    * Creates an instance of [[io.vertx.scala.ext.stomp.StompServerHandler]] using the default (compliant) implementation.
    * @param vertx the vert.x instance to use
    * @return the created StompServerHandler
    */
  def create(vertx: Vertx): StompServerHandler = {
    StompServerHandler(JStompServerHandler.create(vertx.asJava.asInstanceOf[JVertx]))
  }

}
