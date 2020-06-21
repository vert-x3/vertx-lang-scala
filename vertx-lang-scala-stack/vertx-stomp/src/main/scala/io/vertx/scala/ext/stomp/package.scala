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


package io.vertx.scala.ext

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core.buffer.Buffer
import io.vertx.ext.stomp.{StompServer => JStompServer}
import io.vertx.ext.stomp.{Frame => JFrame}
import io.vertx.ext.stomp.{StompServerConnection => JStompServerConnection}
import io.vertx.core.Handler
import io.vertx.ext.stomp.{StompServerHandler => JStompServerHandler}
package object stomp{




  type BridgeOptions = io.vertx.ext.stomp.BridgeOptions
  object BridgeOptions {
    def apply() = new BridgeOptions()
    def apply(json: JsonObject) = new BridgeOptions(json)
  }



  object Destination {
  def topic(vertx: io.vertx.core.Vertx, destination: java.lang.String) = {
      io.vertx.ext.stomp.Destination.topic(vertx, destination)
  }

  def queue(vertx: io.vertx.core.Vertx, destination: java.lang.String) = {
      io.vertx.ext.stomp.Destination.queue(vertx, destination)
  }

  def bridge(vertx: io.vertx.core.Vertx, options: io.vertx.ext.stomp.BridgeOptions) = {
      io.vertx.ext.stomp.Destination.bridge(vertx, options)
  }
  }




  type Frame = io.vertx.ext.stomp.Frame
  object Frame {
    def apply() = new Frame()
    def apply(json: JsonObject) = new Frame(json)
  }



  object Frames {
  def createErrorFrame(message: java.lang.String, headers: scala.collection.mutable.Map[String, java.lang.String], body: java.lang.String) = {
      io.vertx.ext.stomp.Frames.createErrorFrame(message, headers.asJava, body)
  }

  def createReceiptFrame(receiptId: java.lang.String, headers: scala.collection.mutable.Map[String, java.lang.String]) = {
      io.vertx.ext.stomp.Frames.createReceiptFrame(receiptId, headers.asJava)
  }

  def handleReceipt(frame: io.vertx.ext.stomp.Frame, connection: io.vertx.ext.stomp.StompServerConnection) = {
      io.vertx.ext.stomp.Frames.handleReceipt(frame, connection)
  }

  def ping() = {
      io.vertx.ext.stomp.Frames.ping()
  }
  }





  /**
    * Defines a STOMP client.
    */

  implicit class StompClientScala(val asJava: io.vertx.ext.stomp.StompClient) extends AnyVal {


    /**
     * Like connect from [[io.vertx.ext.stomp.StompClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def connectFuture(port: java.lang.Integer, host: java.lang.String) : scala.concurrent.Future[io.vertx.ext.stomp.StompClientConnection] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.StompClientConnection]/*io.vertx.ext.stomp.StompClientConnection API*/()
      asJava.connect(port, host, new Handler[AsyncResult[io.vertx.ext.stomp.StompClientConnection]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.StompClientConnection]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like connect from [[io.vertx.ext.stomp.StompClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def connectFuture(net: io.vertx.core.net.NetClient) : scala.concurrent.Future[io.vertx.ext.stomp.StompClientConnection] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.StompClientConnection]/*io.vertx.ext.stomp.StompClientConnection API*/()
      asJava.connect(net, new Handler[AsyncResult[io.vertx.ext.stomp.StompClientConnection]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.StompClientConnection]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like connect from [[io.vertx.ext.stomp.StompClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def connectFuture(port: java.lang.Integer, host: java.lang.String, net: io.vertx.core.net.NetClient) : scala.concurrent.Future[io.vertx.ext.stomp.StompClientConnection] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.StompClientConnection]/*io.vertx.ext.stomp.StompClientConnection API*/()
      asJava.connect(port, host, net, new Handler[AsyncResult[io.vertx.ext.stomp.StompClientConnection]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.StompClientConnection]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like connect from [[io.vertx.ext.stomp.StompClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def connectFuture() : scala.concurrent.Future[io.vertx.ext.stomp.StompClientConnection] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.StompClientConnection]/*io.vertx.ext.stomp.StompClientConnection API*/()
      asJava.connect(new Handler[AsyncResult[io.vertx.ext.stomp.StompClientConnection]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.StompClientConnection]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * Once a connection to the STOMP server has been made, client receives a [[io.vertx.ext.stomp.StompClientConnection]], that let
    * send and receive STOMP frames.
    */

  implicit class StompClientConnectionScala(val asJava: io.vertx.ext.stomp.StompClientConnection) extends AnyVal {


    /**
     * Like send from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(headers: scala.collection.mutable.Map[String, java.lang.String], body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.send(headers.asJava, body, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(destination: java.lang.String, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.send(destination, body, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(frame: io.vertx.ext.stomp.Frame) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.send(frame, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(destination: java.lang.String, headers: scala.collection.mutable.Map[String, java.lang.String], body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.send(destination, headers.asJava, body, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like subscribe from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def subscribeFuture(destination: java.lang.String, handler: io.vertx.ext.stomp.Frame => Unit) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]/*java.lang.String STRING*/()
      asJava.subscribe(destination, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.ext.stomp.Frame]], new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like subscribe from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def subscribeFuture(destination: java.lang.String, headers: scala.collection.mutable.Map[String, java.lang.String], handler: io.vertx.ext.stomp.Frame => Unit) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]/*java.lang.String STRING*/()
      asJava.subscribe(destination, headers.asJava, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.ext.stomp.Frame]], new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like unsubscribe from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def unsubscribeFuture(destination: java.lang.String) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.unsubscribe(destination, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like unsubscribe from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def unsubscribeFuture(destination: java.lang.String, headers: scala.collection.mutable.Map[String, java.lang.String]) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.unsubscribe(destination, headers.asJava, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like beginTX from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def beginTXFuture(id: java.lang.String) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.beginTX(id, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like beginTX from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def beginTXFuture(id: java.lang.String, headers: scala.collection.mutable.Map[String, java.lang.String]) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.beginTX(id, headers.asJava, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like commit from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def commitFuture(id: java.lang.String) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.commit(id, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like commit from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def commitFuture(id: java.lang.String, headers: scala.collection.mutable.Map[String, java.lang.String]) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.commit(id, headers.asJava, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like abort from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def abortFuture(id: java.lang.String) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.abort(id, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like abort from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def abortFuture(id: java.lang.String, headers: scala.collection.mutable.Map[String, java.lang.String]) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.abort(id, headers.asJava, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like disconnect from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def disconnectFuture() : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.disconnect(new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like disconnect from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def disconnectFuture(frame: io.vertx.ext.stomp.Frame) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.disconnect(frame, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like ack from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def ackFuture(id: java.lang.String) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.ack(id, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like nack from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def nackFuture(id: java.lang.String) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.nack(id, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like ack from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def ackFuture(id: java.lang.String, txId: java.lang.String) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.ack(id, txId, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like nack from [[io.vertx.ext.stomp.StompClientConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def nackFuture(id: java.lang.String, txId: java.lang.String) : scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]/*io.vertx.ext.stomp.Frame OTHER*/()
      asJava.nack(id, txId, new Handler[AsyncResult[io.vertx.ext.stomp.Frame]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.Frame]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type StompClientOptions = io.vertx.ext.stomp.StompClientOptions
  object StompClientOptions {
    def apply() = new StompClientOptions()
    def apply(json: JsonObject) = new StompClientOptions(json)
  }




  /**
    * Defines a STOMP server. STOMP servers delegates to a [[io.vertx.ext.stomp.StompServerHandler]] that let customize the behavior of
    * the server. By default, it uses a handler compliant with the STOMP specification, but let you change anything.
    */

  implicit class StompServerScala(val asJava: io.vertx.ext.stomp.StompServer) extends AnyVal {


    /**
     * Like listen from [[io.vertx.ext.stomp.StompServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenFuture() : scala.concurrent.Future[io.vertx.ext.stomp.StompServer] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.StompServer]/*io.vertx.ext.stomp.StompServer API*/()
      asJava.listen(new Handler[AsyncResult[io.vertx.ext.stomp.StompServer]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.StompServer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like listen from [[io.vertx.ext.stomp.StompServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenFuture(port: java.lang.Integer) : scala.concurrent.Future[io.vertx.ext.stomp.StompServer] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.StompServer]/*io.vertx.ext.stomp.StompServer API*/()
      asJava.listen(port, new Handler[AsyncResult[io.vertx.ext.stomp.StompServer]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.StompServer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like listen from [[io.vertx.ext.stomp.StompServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenFuture(port: java.lang.Integer, host: java.lang.String) : scala.concurrent.Future[io.vertx.ext.stomp.StompServer] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.StompServer]/*io.vertx.ext.stomp.StompServer API*/()
      asJava.listen(port, host, new Handler[AsyncResult[io.vertx.ext.stomp.StompServer]] { override def handle(event: AsyncResult[io.vertx.ext.stomp.StompServer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.ext.stomp.StompServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }






  /**
    * STOMP server handler implements the behavior of the STOMP server when a specific event occurs. For instance, if
    * let customize the behavior when specific STOMP frames arrives or when a connection is closed. This class has been
    * designed to let you customize the server behavior. The default implementation is compliant with the STOMP
    * specification. In this default implementation, not acknowledge frames are dropped.
    */

  implicit class StompServerHandlerScala(val asJava: io.vertx.ext.stomp.StompServerHandler) extends AnyVal {


    /**
     * Like onAuthenticationRequest from [[io.vertx.ext.stomp.StompServerHandler]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def onAuthenticationRequestFuture(connection: io.vertx.ext.stomp.StompServerConnection, login: java.lang.String, passcode: java.lang.String) : scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]/*java.lang.Boolean BOXED_PRIMITIVE*/()
      asJava.onAuthenticationRequest(connection, login, passcode, new Handler[AsyncResult[java.lang.Boolean]] { override def handle(event: AsyncResult[java.lang.Boolean]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Method called by single message (client-individual policy) or a set of message (client policy) are acknowledged.
     * Implementations must call the handler configured using [[io.vertx.ext.stomp.StompServerHandler#onAckHandler]].     * @param connection the connection
     * @param subscribe the `SUBSCRIBE` frame see <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
     * @param messages the acknowledge messages
     * @return the current StompServerHandler
     */
  def onAck(connection: io.vertx.ext.stomp.StompServerConnection, subscribe: io.vertx.ext.stomp.Frame, messages: scala.collection.mutable.Buffer[io.vertx.ext.stomp.Frame]) = {
      asJava.onAck(connection, subscribe, messages.asJava)
  }

    /**
     * Method called by single message (client-individual policy) or a set of message (client policy) are
     * <strong>not</strong> acknowledged. Not acknowledgment can result from a `NACK` frame or from a timeout (no
     * `ACK` frame received in a given time. Implementations must call the handler configured using
     * [[io.vertx.ext.stomp.StompServerHandler#onNackHandler]].     * @param connection the connection
     * @param subscribe the `SUBSCRIBE` frame see <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
     * @param messages the acknowledge messages
     * @return the current StompServerHandler
     */
  def onNack(connection: io.vertx.ext.stomp.StompServerConnection, subscribe: io.vertx.ext.stomp.Frame, messages: scala.collection.mutable.Buffer[io.vertx.ext.stomp.Frame]) = {
      asJava.onNack(connection, subscribe, messages.asJava)
  }

  }



  type StompServerOptions = io.vertx.ext.stomp.StompServerOptions
  object StompServerOptions {
    def apply() = new StompServerOptions()
    def apply(json: JsonObject) = new StompServerOptions(json)
  }



}
