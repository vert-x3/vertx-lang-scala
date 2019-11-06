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

import scala.collection.JavaConverters._
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
    def topic(vertx: io.vertx.core.Vertx,destination: java.lang.String) = {
      io.vertx.ext.stomp.Destination.topic(vertx, destination)
    }
    def queue(vertx: io.vertx.core.Vertx,destination: java.lang.String) = {
      io.vertx.ext.stomp.Destination.queue(vertx, destination)
    }
    def bridge(vertx: io.vertx.core.Vertx,options: io.vertx.ext.stomp.BridgeOptions) = {
      io.vertx.ext.stomp.Destination.bridge(vertx, options)
    }
  }





  type Frame = io.vertx.ext.stomp.Frame
  object Frame {
    def apply() = new Frame()
    def apply(json: JsonObject) = new Frame(json)
  }



  object Frames {
    def createErrorFrame(message: java.lang.String,headers: java.util.Map[String, java.lang.String],body: java.lang.String) = {
      io.vertx.ext.stomp.Frames.createErrorFrame(message, headers, body)
    }
    def createReceiptFrame(receiptId: java.lang.String,headers: java.util.Map[String, java.lang.String]) = {
      io.vertx.ext.stomp.Frames.createReceiptFrame(receiptId, headers)
    }
    def handleReceipt(frame: io.vertx.ext.stomp.Frame,connection: io.vertx.ext.stomp.StompServerConnection) = {
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
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(port: java.lang.Integer,host: java.lang.String): scala.concurrent.Future[io.vertx.ext.stomp.StompClientConnection] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.StompClientConnection]()
      asJava.connect(port, host, {a:AsyncResult[io.vertx.ext.stomp.StompClientConnection] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(net: io.vertx.core.net.NetClient): scala.concurrent.Future[io.vertx.ext.stomp.StompClientConnection] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.StompClientConnection]()
      asJava.connect(net, {a:AsyncResult[io.vertx.ext.stomp.StompClientConnection] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(port: java.lang.Integer,host: java.lang.String,net: io.vertx.core.net.NetClient): scala.concurrent.Future[io.vertx.ext.stomp.StompClientConnection] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.StompClientConnection]()
      asJava.connect(port, host, net, {a:AsyncResult[io.vertx.ext.stomp.StompClientConnection] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(): scala.concurrent.Future[io.vertx.ext.stomp.StompClientConnection] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.StompClientConnection]()
      asJava.connect({a:AsyncResult[io.vertx.ext.stomp.StompClientConnection] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  /**
    * Once a connection to the STOMP server has been made, client receives a [[io.vertx.ext.stomp.StompClientConnection]], that let
    * send and receive STOMP frames.
    */

  implicit class StompClientConnectionScala(val asJava: io.vertx.ext.stomp.StompClientConnection) extends AnyVal {

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture(headers: java.util.Map[String, java.lang.String],body: io.vertx.core.buffer.Buffer): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.send(headers, body, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture(destination: java.lang.String,body: io.vertx.core.buffer.Buffer): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.send(destination, body, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture(frame: io.vertx.ext.stomp.Frame): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.send(frame, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture(destination: java.lang.String,headers: java.util.Map[String, java.lang.String],body: io.vertx.core.buffer.Buffer): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.send(destination, headers, body, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def subscribeFuture(destination: java.lang.String,handler: io.vertx.ext.stomp.Frame => Unit): scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.subscribe(destination, {x: io.vertx.ext.stomp.Frame => handler(x)}, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def subscribeFuture(destination: java.lang.String,headers: java.util.Map[String, java.lang.String],handler: io.vertx.ext.stomp.Frame => Unit): scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.subscribe(destination, headers, {x: io.vertx.ext.stomp.Frame => handler(x)}, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unsubscribeFuture(destination: java.lang.String): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.unsubscribe(destination, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unsubscribeFuture(destination: java.lang.String,headers: java.util.Map[String, java.lang.String]): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.unsubscribe(destination, headers, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[beginTX]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def beginTXFuture(id: java.lang.String): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.beginTX(id, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[beginTX]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def beginTXFuture(id: java.lang.String,headers: java.util.Map[String, java.lang.String]): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.beginTX(id, headers, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commitFuture(id: java.lang.String): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.commit(id, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commitFuture(id: java.lang.String,headers: java.util.Map[String, java.lang.String]): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.commit(id, headers, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[abort]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def abortFuture(id: java.lang.String): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.abort(id, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[abort]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def abortFuture(id: java.lang.String,headers: java.util.Map[String, java.lang.String]): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.abort(id, headers, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[disconnect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def disconnectFuture(): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.disconnect({a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[disconnect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def disconnectFuture(frame: io.vertx.ext.stomp.Frame): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.disconnect(frame, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ack]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def ackFuture(id: java.lang.String): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.ack(id, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[nack]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def nackFuture(id: java.lang.String): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.nack(id, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ack]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def ackFuture(id: java.lang.String,txId: java.lang.String): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.ack(id, txId, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[nack]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def nackFuture(id: java.lang.String,txId: java.lang.String): scala.concurrent.Future[io.vertx.ext.stomp.Frame] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.Frame]()
      asJava.nack(id, txId, {a:AsyncResult[io.vertx.ext.stomp.Frame] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(): scala.concurrent.Future[io.vertx.ext.stomp.StompServer] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.StompServer]()
      asJava.listen({a:AsyncResult[io.vertx.ext.stomp.StompServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(port: java.lang.Integer): scala.concurrent.Future[io.vertx.ext.stomp.StompServer] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.StompServer]()
      asJava.listen(port, {a:AsyncResult[io.vertx.ext.stomp.StompServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(port: java.lang.Integer,host: java.lang.String): scala.concurrent.Future[io.vertx.ext.stomp.StompServer] = {
      val promise = concurrent.Promise[io.vertx.ext.stomp.StompServer]()
      asJava.listen(port, host, {a:AsyncResult[io.vertx.ext.stomp.StompServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }







  type StompServerOptions = io.vertx.ext.stomp.StompServerOptions
  object StompServerOptions {
    def apply() = new StompServerOptions()
    def apply(json: JsonObject) = new StompServerOptions(json)
  }



}
