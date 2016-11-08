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
import io.vertx.ext.stomp.{StompServerHandler => JStompServerHandler}
import io.vertx.ext.stomp.{Acknowledgement => JAcknowledgement}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.ext.stomp.{StompServer => JStompServer}
import io.vertx.ext.stomp.{StompServerConnection => JStompServerConnection}
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.ext.stomp.{BridgeOptions => JBridgeOptions}
import io.vertx.scala.ext.stomp.BridgeOptions
import io.vertx.ext.stomp.{Destination => JDestination}
import io.vertx.ext.stomp.{DestinationFactory => JDestinationFactory}
import io.vertx.ext.stomp.{Frame => JFrame}
import io.vertx.scala.ext.stomp.Frame
import io.vertx.ext.stomp.{ServerFrame => JServerFrame}

/**
  * STOMP server handler implements the behavior of the STOMP server when a specific event occurs. For instance, if
  * let customize the behavior when specific STOMP frames arrives or when a connection is closed. This class has been
  * designed to let you customize the server behavior. The default implementation is compliant with the STOMP
  * specification. In this default implementation, not acknowledge frames are dropped.
  */
class StompServerHandler(private val _asJava: JStompServerHandler) {

  def asJava: JStompServerHandler = _asJava

  def handle(arg0: ServerFrame): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[JServerFrame])
  }

  /**
    * Configures a handler that get notified when a STOMP frame is received by the server.
    * This handler can be used for logging, debugging or ad-hoc behavior.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def receivedFrameHandler(handler: ServerFrame => Unit): StompServerHandler = {
    _asJava.receivedFrameHandler(funcToMappedHandler(ServerFrame.apply)(handler))
    this
  }

  /**
    * Configures the action to execute when a `CONNECT` frame is received.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def connectHandler(handler: ServerFrame => Unit): StompServerHandler = {
    _asJava.connectHandler(funcToMappedHandler(ServerFrame.apply)(handler))
    this
  }

  /**
    * Configures the action to execute when a `STOMP` frame is received.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def stompHandler(handler: ServerFrame => Unit): StompServerHandler = {
    _asJava.stompHandler(funcToMappedHandler(ServerFrame.apply)(handler))
    this
  }

  /**
    * Configures the action to execute when a `SUBSCRIBE` frame is received.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def subscribeHandler(handler: ServerFrame => Unit): StompServerHandler = {
    _asJava.subscribeHandler(funcToMappedHandler(ServerFrame.apply)(handler))
    this
  }

  /**
    * Configures the action to execute when a `UNSUBSCRIBE` frame is received.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def unsubscribeHandler(handler: ServerFrame => Unit): StompServerHandler = {
    _asJava.unsubscribeHandler(funcToMappedHandler(ServerFrame.apply)(handler))
    this
  }

  /**
    * Configures the action to execute when a `SEND` frame is received.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def sendHandler(handler: ServerFrame => Unit): StompServerHandler = {
    _asJava.sendHandler(funcToMappedHandler(ServerFrame.apply)(handler))
    this
  }

  /**
    * Configures the action to execute when a connection with the client is closed.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def closeHandler(handler: StompServerConnection => Unit): StompServerHandler = {
    _asJava.closeHandler(funcToMappedHandler(StompServerConnection.apply)(handler))
    this
  }

  /**
    * Called when the connection is closed. This method executes a default behavior and must calls the configured
    * [[io.vertx.scala.ext.stomp.StompServerHandler#closeHandler]] if any.
    * @param connection the connection
    */
  def onClose(connection: StompServerConnection): Unit = {
    _asJava.onClose(connection.asJava.asInstanceOf[JStompServerConnection])
  }

  /**
    * Configures the action to execute when a `COMMIT` frame is received.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def commitHandler(handler: ServerFrame => Unit): StompServerHandler = {
    _asJava.commitHandler(funcToMappedHandler(ServerFrame.apply)(handler))
    this
  }

  /**
    * Configures the action to execute when a `ABORT` frame is received.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def abortHandler(handler: ServerFrame => Unit): StompServerHandler = {
    _asJava.abortHandler(funcToMappedHandler(ServerFrame.apply)(handler))
    this
  }

  /**
    * Configures the action to execute when a `BEGIN` frame is received.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def beginHandler(handler: ServerFrame => Unit): StompServerHandler = {
    _asJava.beginHandler(funcToMappedHandler(ServerFrame.apply)(handler))
    this
  }

  /**
    * Configures the action to execute when a `DISCONNECT` frame is received.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def disconnectHandler(handler: ServerFrame => Unit): StompServerHandler = {
    _asJava.disconnectHandler(funcToMappedHandler(ServerFrame.apply)(handler))
    this
  }

  /**
    * Configures the action to execute when a `ACK` frame is received.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def ackHandler(handler: ServerFrame => Unit): StompServerHandler = {
    _asJava.ackHandler(funcToMappedHandler(ServerFrame.apply)(handler))
    this
  }

  /**
    * Configures the action to execute when a `NACK` frame is received.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def nackHandler(handler: ServerFrame => Unit): StompServerHandler = {
    _asJava.nackHandler(funcToMappedHandler(ServerFrame.apply)(handler))
    this
  }

  /**
    * Called when the client connects to a server requiring authentication. It invokes the  configured
    * using [[io.vertx.scala.ext.stomp.StompServerHandler#authProvider]].
    * @param server the STOMP server.
    * @param login the login
    * @param passcode the password
    * @return future receiving the authentication result
    */
  def onAuthenticationRequestFuture(server: StompServer, login: String, passcode: String): concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean,Boolean]((x => x))
    _asJava.onAuthenticationRequest(server.asJava.asInstanceOf[JStompServer], login, passcode, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Configures the  to be used to authenticate the user.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def authProvider(handler: AuthProvider): StompServerHandler = {
    _asJava.authProvider(handler.asJava.asInstanceOf[JAuthProvider])
    this
  }

  /**
    * @return the list of destination managed by the STOMP server. Don't forget the STOMP interprets destination as opaque Strings.
    */
  def getDestinations(): scala.collection.mutable.Buffer[Destination] = {
    _asJava.getDestinations().asScala.map(Destination.apply)
  }

  /**
    * Gets the destination with the given name.
    * @param destination the destination
    * @return the [[Destination]], `null` if not existing.
    */
  def getDestination(destination: String): Destination = {
    Destination.apply(_asJava.getDestination(destination))
  }

  /**
    * Method called by single message (client-individual policy) or a set of message (client policy) are acknowledged.
    * Implementations must call the handler configured using [[io.vertx.scala.ext.stomp.StompServerHandler#onAckHandler]].
    * @param connection the connection
    * @param subscribe the `SUBSCRIBE` framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @param messages the acknowledge messages
    * @return the current [[StompServerHandler]]
    */
  def onAck(connection: StompServerConnection, subscribe: Frame, messages: scala.collection.mutable.Buffer[Frame]): StompServerHandler = {
    _asJava.onAck(connection.asJava.asInstanceOf[JStompServerConnection], subscribe.asJava, messages.map(x => if (x == null) null else x.asJava).asJava)
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
    * @return the current [[StompServerHandler]]
    */
  def onNack(connection: StompServerConnection, subscribe: Frame, messages: scala.collection.mutable.Buffer[Frame]): StompServerHandler = {
    _asJava.onNack(connection.asJava.asInstanceOf[JStompServerConnection], subscribe.asJava, messages.map(x => if (x == null) null else x.asJava).asJava)
    this
  }

  /**
    * Configures the action to execute when messages are acknowledged.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def onAckHandler(handler: Acknowledgement => Unit): StompServerHandler = {
    _asJava.onAckHandler(funcToMappedHandler(Acknowledgement.apply)(handler))
    this
  }

  /**
    * Configures the action to execute when messages are <strong>not</strong> acknowledged.
    * @param handler the handler
    * @return the current [[StompServerHandler]]
    */
  def onNackHandler(handler: Acknowledgement => Unit): StompServerHandler = {
    _asJava.onNackHandler(funcToMappedHandler(Acknowledgement.apply)(handler))
    this
  }

  /**
    * Allows customizing the action to do when the server needs to send a `PING` to the client. By default it send a
    * frame containing `EOL` (specification). However, you can customize this and send another frame. However,
    * be aware that this may requires a custom client.
    * <p/>
    * The handler will only be called if the connection supports heartbeats.
    * @param handler the action to execute when a `PING` needs to be sent.
    * @return the current [[StompServerHandler]]
    */
  def pingHandler(handler: StompServerConnection => Unit): StompServerHandler = {
    _asJava.pingHandler(funcToMappedHandler(StompServerConnection.apply)(handler))
    this
  }

  /**
    * Gets a [[io.vertx.scala.ext.stomp.Destination]] object if existing, or create a new one. The creation is delegated to the
    * [[io.vertx.scala.ext.stomp.DestinationFactory]].
    * @param destination the destination
    * @return the [[Destination]] instance, may have been created.
    */
  def getOrCreateDestination(destination: String): Destination = {
    Destination.apply(_asJava.getOrCreateDestination(destination))
  }

  /**
    * Configures the [[io.vertx.scala.ext.stomp.DestinationFactory]] used to create [[io.vertx.scala.ext.stomp.Destination]] objects.
    * @param factory the factory
    * @return the current [[StompServerHandler]].
    */
  def destinationFactory(factory: DestinationFactory): StompServerHandler = {
    _asJava.destinationFactory(factory.asJava.asInstanceOf[JDestinationFactory])
    this
  }

  /**
    * Configures the STOMP server to act as a bridge with the Vert.x event bus.
    * @param options the configuration optionssee <a href="../../../../../../../cheatsheet/BridgeOptions.html">BridgeOptions</a>
    * @return the current [[StompServerHandler]].
    */
  def bridge(options: BridgeOptions): StompServerHandler = {
    _asJava.bridge(options.asJava)
    this
  }

}

object StompServerHandler {

  def apply(_asJava: JStompServerHandler): StompServerHandler =
    new StompServerHandler(_asJava)

  def create(vertx: Vertx): StompServerHandler = {
    StompServerHandler.apply(io.vertx.ext.stomp.StompServerHandler.create(vertx.asJava.asInstanceOf[JVertx]))
  }

}
