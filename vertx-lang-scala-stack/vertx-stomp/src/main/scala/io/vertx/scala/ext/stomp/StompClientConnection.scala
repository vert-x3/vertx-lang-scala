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
import io.vertx.ext.stomp.{StompClientConnection => JStompClientConnection}
import io.vertx.core.buffer.Buffer
import io.vertx.ext.stomp.{Frame => JFrame}
import scala.collection.JavaConverters._
import io.vertx.core.Handler

/**
  * Once a connection to the STOMP server has been made, client receives a [[io.vertx.scala.ext.stomp.StompClientConnection]], that let
  * send and receive STOMP frames.
  */
class StompClientConnection(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Sends a `SEND` frame to the server.
    * @param headers the headers, must not be `null`
    * @param body the body, may be `null`
    * @return the current StompClientConnection
    */
  def send(headers: scala.collection.mutable.Map[String, String], body: io.vertx.core.buffer.Buffer): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].send(headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, body)
    this
  }

  /**
    * Sends a `SEND` frame to the server.
    * @param headers the headers, must not be `null`
    * @param body the body, may be `null`
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the sent frame has been received. The handler receives the sent frame.
    * @return the current StompClientConnection
    */
  def send(headers: scala.collection.mutable.Map[String, String], body: io.vertx.core.buffer.Buffer, receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].send(headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, body, {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Sends a `SEND` frame to the server to the given destination. The message does not have any other header.
    * @param destination the destination, must not be `null`
    * @param body the body, may be `null`
    * @return the current StompClientConnection
    */
  def send(destination: String, body: io.vertx.core.buffer.Buffer): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].send(destination.asInstanceOf[java.lang.String], body)
    this
  }

  /**
    * Sends a `SEND` frame to the server to the given destination. The message does not have any other header.
    * @param destination the destination, must not be `null`
    * @param body the body, may be `null`
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the sent frame has been received. The handler receives the sent frame.
    * @return the current StompClientConnection
    */
  def send(destination: String, body: io.vertx.core.buffer.Buffer, receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].send(destination.asInstanceOf[java.lang.String], body, {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Sends the given frame to the server.
    * @param frame the framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @return the current StompClientConnection
    */
  def send(frame: Frame): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].send(frame.asJava)
    this
  }

  /**
    * Sends the given frame to the server.
    * @param frame the framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the sent frame has been received. The handler receives the sent frame.
    * @return the current StompClientConnection
    */
  def send(frame: Frame, receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].send(frame.asJava, {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Sends a `SEND` frame to the server to the given destination.
    * @param destination the destination, must not be `null`
    * @param headers the header. The `destination` header is replaced by the value given to the `destination` parameter
    * @param body the body, may be `null`
    * @return the current StompClientConnection
    */
  def send(destination: String, headers: scala.collection.mutable.Map[String, String], body: io.vertx.core.buffer.Buffer): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].send(destination.asInstanceOf[java.lang.String], headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, body)
    this
  }

  /**
    * Sends a `SEND` frame to the server to the given destination.
    * @param destination the destination, must not be `null`
    * @param headers the header. The `destination` header is replaced by the value given to the `destination` parameter
    * @param body the body, may be `null`
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the sent frame has been received. The handler receives the sent frame.
    * @return the current StompClientConnection
    */
  def send(destination: String, headers: scala.collection.mutable.Map[String, String], body: io.vertx.core.buffer.Buffer, receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].send(destination.asInstanceOf[java.lang.String], headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, body, {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Un-subscribes from the given destination. This method only works if the subscription did not specifies a
    * subscription id (using the `id` header).
    * @param destination the destination
    * @return the current StompClientConnection
    */
  def unsubscribe(destination: String): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].unsubscribe(destination.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Un-subscribes from the given destination. This method only works if the subscription did not specifies a
    * subscription id (using the `id` header).
    * @param destination the destination
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the un-subscription has been received. The handler receives the sent frame (`UNSUBSCRIBE`).
    * @return the current StompClientConnection
    */
  def unsubscribe(destination: String, receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].unsubscribe(destination.asInstanceOf[java.lang.String], {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Un-subscribes from the given destination. This method computes the subscription id as follows. If the given
    * headers contains the `id` header, the header value is used. Otherwise the destination is used.
    * @param destination the destination
    * @param headers the headers
    * @return the current StompClientConnection
    */
  def unsubscribe(destination: String, headers: scala.collection.mutable.Map[String, String]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].unsubscribe(destination.asInstanceOf[java.lang.String], headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  /**
    * Un-subscribes from the given destination. This method computes the subscription id as follows. If the given
    * headers contains the `id` header, the header value is used. Otherwise the destination is used.
    * @param destination the destination
    * @param headers the headers
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the un-subscription has been received. The handler receives the sent frame (`UNSUBSCRIBE`).
    * @return the current StompClientConnection
    */
  def unsubscribe(destination: String, headers: scala.collection.mutable.Map[String, String], receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].unsubscribe(destination.asInstanceOf[java.lang.String], headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Sets a handler notified when an `ERROR` frame is received by the client. The handler receives the `ERROR` frame and a reference on the [[io.vertx.scala.ext.stomp.StompClientConnection]].
    * @param handler the handler
    * @return the current StompClientConnection
    */
  def errorHandler(handler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].errorHandler({x: JFrame => handler.handle(Frame(x))})
    this
  }

  /**
    * Sets a handler notified when the STOMP connection is closed.
    * @param handler the handler
    * @return the current StompClientConnection
    */
  def closeHandler(handler: Handler[StompClientConnection]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].closeHandler({x: JStompClientConnection => handler.handle(StompClientConnection(x))})
    this
  }

  /**
    * Sets a handler notified when the server does not respond to a `ping` request in time. In other
    * words, this handler is invoked when the heartbeat has detected a connection failure with the server.
    * The handler can decide to reconnect to the server.
    * @param handler the handler
    * @return the current StompClientConnection receiving the dropped connection.
    */
  def connectionDroppedHandler(handler: Handler[StompClientConnection]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].connectionDroppedHandler({x: JStompClientConnection => handler.handle(StompClientConnection(x))})
    this
  }

  /**
    * Sets a handler that let customize the behavior when a ping needs to be sent to the server. Be aware that
    * changing the default behavior may break the compliance with the STOMP specification.
    * @param handler the handler
    * @return the current StompClientConnection
    */
  def pingHandler(handler: Handler[StompClientConnection]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].pingHandler({x: JStompClientConnection => handler.handle(StompClientConnection(x))})
    this
  }

  /**
    * Begins a transaction.
    * @param id the transaction id, must not be `null`
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the transaction begin has been processed by the server. The handler receives the sent frame (`BEGIN`).
    * @return the current StompClientConnection
    */
  def beginTX(id: String, receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].beginTX(id.asInstanceOf[java.lang.String], {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Begins a transaction.
    * @param id the transaction id, must not be `null`
    * @return the current StompClientConnection
    */
  def beginTX(id: String): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].beginTX(id.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Begins a transaction.
    * @param id the transaction id, must not be `null`
    * @param headers additional headers to send to the server. The `transaction` header is replaced by the value passed in the @{code id` parameter
    * @return the current StompClientConnection
    */
  def beginTX(id: String, headers: scala.collection.mutable.Map[String, String]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].beginTX(id.asInstanceOf[java.lang.String], headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  /**
    * Begins a transaction.
    * @param id the transaction id, must not be `null`
    * @param headers additional headers to send to the server. The `transaction` header is replaced by the value passed in the @{code id` parameter
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the transaction begin has been processed by the server. The handler receives the sent frame (`BEGIN`).
    * @return the current StompClientConnection
    */
  def beginTX(id: String, headers: scala.collection.mutable.Map[String, String], receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].beginTX(id.asInstanceOf[java.lang.String], headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Commits a transaction.
    * @param id the transaction id, must not be `null`
    * @return the current StompClientConnection
    */
  def commit(id: String): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].commit(id.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Commits a transaction.
    * @param id the transaction id, must not be `null`
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the transaction commit has been processed by the server. The handler receives the sent frame (`COMMIT`).
    * @return the current StompClientConnection
    */
  def commit(id: String, receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].commit(id.asInstanceOf[java.lang.String], {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Commits a transaction.
    * @param id the transaction id, must not be `null`
    * @param headers additional headers to send to the server. The `transaction` header is replaced by the value passed in the @{code id` parameter
    * @return the current StompClientConnection
    */
  def commit(id: String, headers: scala.collection.mutable.Map[String, String]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].commit(id.asInstanceOf[java.lang.String], headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  /**
    * Commits a transaction.
    * @param id the transaction id, must not be `null`
    * @param headers additional headers to send to the server. The `transaction` header is replaced by the value passed in the @{code id` parameter
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the transaction commit has been processed by the server. The handler receives the sent frame (`COMMIT`).
    * @return the current StompClientConnection
    */
  def commit(id: String, headers: scala.collection.mutable.Map[String, String], receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].commit(id.asInstanceOf[java.lang.String], headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Aborts a transaction.
    * @param id the transaction id, must not be `null`
    * @return the current StompClientConnection
    */
  def abort(id: String): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].abort(id.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Aborts a transaction.
    * @param id the transaction id, must not be `null`
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the transaction cancellation has been processed by the server. The handler receives the sent frame (`ABORT`).
    * @return the current StompClientConnection
    */
  def abort(id: String, receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].abort(id.asInstanceOf[java.lang.String], {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Aborts a transaction.
    * @param id the transaction id, must not be `null`
    * @param headers additional headers to send to the server. The `transaction` header is replaced by the value passed in the @{code id` parameter
    * @return the current StompClientConnection
    */
  def abort(id: String, headers: scala.collection.mutable.Map[String, String]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].abort(id.asInstanceOf[java.lang.String], headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  /**
    * Aborts a transaction.
    * @param id the transaction id, must not be `null`
    * @param headers additional headers to send to the server. The `transaction` header is replaced by the value passed in the @{code id` parameter
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the transaction cancellation has been processed by the server. The handler receives the sent frame (`ABORT`).
    * @return the current StompClientConnection
    */
  def abort(id: String, headers: scala.collection.mutable.Map[String, String], receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].abort(id.asInstanceOf[java.lang.String], headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Disconnects the client. Unlike the [[io.vertx.scala.ext.stomp.StompClientConnection#close]] method, this method send the `DISCONNECT` frame to the
    * server.
    * @return the current StompClientConnection
    */
  def disconnect(): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].disconnect()
    this
  }

  /**
    * Disconnects the client. Unlike the [[io.vertx.scala.ext.stomp.StompClientConnection#close]] method, this method send the `DISCONNECT` frame to the
    * server.
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the disconnection has been processed by the server. The handler receives the sent frame (`DISCONNECT`).
    * @return the current StompClientConnection
    */
  def disconnect(receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].disconnect({x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Disconnects the client. Unlike the [[io.vertx.scala.ext.stomp.StompClientConnection#close]] method, this method send the `DISCONNECT` frame to the
    * server. This method lets you customize the `DISCONNECT` frame.
    * @param frame the `DISCONNECT` frame.see <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @return the current StompClientConnection
    */
  def disconnect(frame: Frame): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].disconnect(frame.asJava)
    this
  }

  /**
    * Disconnects the client. Unlike the [[io.vertx.scala.ext.stomp.StompClientConnection#close]] method, this method send the `DISCONNECT` frame to the
    * server. This method lets you customize the `DISCONNECT` frame.
    * @param frame the `DISCONNECT` frame.see <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the disconnection has been processed by the server. The handler receives the sent frame (`DISCONNECT`).
    * @return the current StompClientConnection
    */
  def disconnect(frame: Frame, receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].disconnect(frame.asJava, {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Sends an acknowledgement for a specific message. It means that the message has been handled and processed by the
    * client. The `id` parameter is the message id received in the frame.
    * @param id the message id of the message to acknowledge
    * @return the current StompClientConnection
    */
  def ack(id: String): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].ack(id.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Sends an acknowledgement for a specific message. It means that the message has been handled and processed by the
    * client. The `id` parameter is the message id received in the frame.
    * @param id the message id of the message to acknowledge
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the acknowledgment has been processed by the server. The handler receives the sent frame (`ACK`).
    * @return the current StompClientConnection
    */
  def ack(id: String, receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].ack(id.asInstanceOf[java.lang.String], {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Sends a non-acknowledgement for the given message. It means that the message has not been handled by the client.
    * The `id` parameter is the message id received in the frame.
    * @param id the message id of the message to acknowledge
    * @return the current StompClientConnection
    */
  def nack(id: String): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].nack(id.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Sends a non-acknowledgement for the given message. It means that the message has not been handled by the client.
    * The `id` parameter is the message id received in the frame.
    * @param id the message id of the message to acknowledge
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the non-acknowledgment has been processed by the server. The handler receives the sent frame (`NACK`).
    * @return the current StompClientConnection
    */
  def nack(id: String, receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].nack(id.asInstanceOf[java.lang.String], {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Sends an acknowledgement for the given frame. It means that the frame has been handled and processed by the
    * client. The sent acknowledgement is part of the transaction identified by the given id.
    * @param id the message id of the message to acknowledge
    * @param txId the transaction id
    * @return the current StompClientConnection
    */
  def ack(id: String, txId: String): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].ack(id.asInstanceOf[java.lang.String], txId.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Sends an acknowledgement for the given frame. It means that the frame has been handled and processed by the
    * client. The sent acknowledgement is part of the transaction identified by the given id.
    * @param id the message id of the message to acknowledge
    * @param txId the transaction id
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the acknowledgment has been processed by the server. The handler receives the sent frame (`ACK`).
    * @return the current StompClientConnection
    */
  def ack(id: String, txId: String, receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].ack(id.asInstanceOf[java.lang.String], txId.asInstanceOf[java.lang.String], {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Sends a non-acknowledgement for the given frame. It means that the frame has not been handled by the client.
    * The sent non-acknowledgement is part of the transaction identified by the given id.
    * @param id the message id of the message to acknowledge
    * @param txId the transaction id
    * @return the current StompClientConnection
    */
  def nack(id: String, txId: String): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].nack(id.asInstanceOf[java.lang.String], txId.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Sends a non-acknowledgement for the given frame. It means that the frame has not been handled by the client.
    * The sent non-acknowledgement is part of the transaction identified by the given id.
    * @param id the message id of the message to acknowledge
    * @param txId the transaction id
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the non-acknowledgment has been processed by the server. The handler receives the sent frame (`NACK`).
    * @return the current StompClientConnection
    */
  def nack(id: String, txId: String, receiptHandler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].nack(id.asInstanceOf[java.lang.String], txId.asInstanceOf[java.lang.String], {x: JFrame => receiptHandler.handle(Frame(x))})
    this
  }

  /**
    * Configures a received handler that get notified when a STOMP frame is received by the client.
    * This handler can be used for logging, debugging or ad-hoc behavior. The frame can still be modified by the handler.
    * 
    * Unlike [[io.vertx.scala.ext.stomp.StompClient#receivedFrameHandler]], the given handler won't receive the `CONNECTED` frame. If a received frame handler is set on the [[io.vertx.scala.ext.stomp.StompClient]], it will be used by all
    * clients connection, so calling this method is useless, except if you want to use a different handler.
    * @param handler the handler
    * @return the current StompClientConnection
    */
  def receivedFrameHandler(handler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].receivedFrameHandler({x: JFrame => handler.handle(Frame(x))})
    this
  }

  /**
    * Configures a handler notified when a frame is going to be written on the wire. This handler can be used from
    * logging, debugging. The handler can modify the received frame.
    *
    * If a writing frame handler is set on the [[io.vertx.scala.ext.stomp.StompClient]], it will be used by all
    * clients connection, so calling this method is useless, except if you want to use a different handler.
    * @param handler the handler
    * @return the current StompClientConnection
    */
  def writingFrameHandler(handler: Handler[Frame]): StompClientConnection = {
    asJava.asInstanceOf[JStompClientConnection].writingFrameHandler({x: JFrame => handler.handle(Frame(x))})
    this
  }

  /**
    * @return the session id.
    */
  def session(): String = {
    asJava.asInstanceOf[JStompClientConnection].session().asInstanceOf[String]
  }

  /**
    * @return the STOMP protocol version negotiated with the server.
    */
  def version(): String = {
    asJava.asInstanceOf[JStompClientConnection].version().asInstanceOf[String]
  }

  /**
    * Closes the connection without sending the `DISCONNECT` frame.
    */
  def close(): Unit = {
    asJava.asInstanceOf[JStompClientConnection].close()
  }

  /**
    * @return the server name.
    */
  def server(): String = {
    asJava.asInstanceOf[JStompClientConnection].server().asInstanceOf[String]
  }

  /**
    * Subscribes to the given destination. This destination is used as subscription id.
    * @param destination the destination, must not be `null`
    * @param handler the handler invoked when a message is received on the given destination. Must not be `null`.
    * @return the subscription id.
    */
  def subscribe(destination: String, handler: Handler[Frame]): String = {
    asJava.asInstanceOf[JStompClientConnection].subscribe(destination.asInstanceOf[java.lang.String], {x: JFrame => handler.handle(Frame(x))}).asInstanceOf[String]
  }

  /**
    * Subscribes to the given destination. This destination is used as subscription id.
    * @param destination the destination, must not be `null`
    * @param handler the handler invoked when a message is received on the given destination. Must not be `null`.
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the subscription has been received. The handler receives the sent frame (`SUBSCRIBE`).
    * @return the subscription id.
    */
  def subscribe(destination: String, handler: Handler[Frame], receiptHandler: Handler[Frame]): String = {
    asJava.asInstanceOf[JStompClientConnection].subscribe(destination.asInstanceOf[java.lang.String], {x: JFrame => handler.handle(Frame(x))}, {x: JFrame => receiptHandler.handle(Frame(x))}).asInstanceOf[String]
  }

  /**
    * Subscribes to the given destination.
    * @param destination the destination, must not be `null`.
    * @param headers the headers to configure the subscription. It may contain the `ack` header to configure the acknowledgment policy. If the given set of headers contains the `id` header, this value is used as subscription id.
    * @param handler the handler invoked when a message is received on the given destination. Must not be `null`.
    * @return the subscription id, which can either be the destination or the id set in the headers.
    */
  def subscribe(destination: String, headers: scala.collection.mutable.Map[String, String], handler: Handler[Frame]): String = {
    asJava.asInstanceOf[JStompClientConnection].subscribe(destination.asInstanceOf[java.lang.String], headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, {x: JFrame => handler.handle(Frame(x))}).asInstanceOf[String]
  }

  /**
    * Subscribes to the given destination.
    * @param destination the destination, must not be `null`
    * @param headers the headers to configure the subscription. It may contain the `ack` header to configure the acknowledgment policy. If the given set of headers contains the `id` header, this value is used as subscription id.
    * @param handler the handler invoked when a message is received on the given destination. Must not be `null`.
    * @param receiptHandler the handler invoked when the `RECEIPT` frame associated with the subscription has been received. The handler receives the sent frame (`SUBSCRIBE`).
    * @return the subscription id, which can either be the destination or the id set in the headers.
    */
  def subscribe(destination: String, headers: scala.collection.mutable.Map[String, String], handler: Handler[Frame], receiptHandler: Handler[Frame]): String = {
    asJava.asInstanceOf[JStompClientConnection].subscribe(destination.asInstanceOf[java.lang.String], headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, {x: JFrame => handler.handle(Frame(x))}, {x: JFrame => receiptHandler.handle(Frame(x))}).asInstanceOf[String]
  }

}

object StompClientConnection {
  def apply(asJava: JStompClientConnection) = new StompClientConnection(asJava)  
}
