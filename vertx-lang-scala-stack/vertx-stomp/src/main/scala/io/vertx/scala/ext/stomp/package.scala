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





  type Frame = io.vertx.ext.stomp.Frame

  object Frame {
    def apply() = new Frame()
    def apply(json: JsonObject) = new Frame(json)
  }





  /**
    * Defines a STOMP client.
    */

  implicit class StompClientScala(val asJava: io.vertx.ext.stomp.StompClient) extends AnyVal {

    /**
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(port: java.lang.Integer,host: java.lang.String): scala.concurrent.Future[io.vertx.ext.stomp.StompClientConnection] = {
      val promise = Promise[io.vertx.ext.stomp.StompClientConnection]()
      asJava.connect(port, host, {a:AsyncResult[io.vertx.ext.stomp.StompClientConnection] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(net: io.vertx.core.net.NetClient): scala.concurrent.Future[io.vertx.ext.stomp.StompClientConnection] = {
      val promise = Promise[io.vertx.ext.stomp.StompClientConnection]()
      asJava.connect(net, {a:AsyncResult[io.vertx.ext.stomp.StompClientConnection] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(port: java.lang.Integer,host: java.lang.String,net: io.vertx.core.net.NetClient): scala.concurrent.Future[io.vertx.ext.stomp.StompClientConnection] = {
      val promise = Promise[io.vertx.ext.stomp.StompClientConnection]()
      asJava.connect(port, host, net, {a:AsyncResult[io.vertx.ext.stomp.StompClientConnection] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(): scala.concurrent.Future[io.vertx.ext.stomp.StompClientConnection] = {
      val promise = Promise[io.vertx.ext.stomp.StompClientConnection]()
      asJava.connect({a:AsyncResult[io.vertx.ext.stomp.StompClientConnection] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
      val promise = Promise[io.vertx.ext.stomp.StompServer]()
      asJava.listen({a:AsyncResult[io.vertx.ext.stomp.StompServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(port: java.lang.Integer): scala.concurrent.Future[io.vertx.ext.stomp.StompServer] = {
      val promise = Promise[io.vertx.ext.stomp.StompServer]()
      asJava.listen(port, {a:AsyncResult[io.vertx.ext.stomp.StompServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(port: java.lang.Integer,host: java.lang.String): scala.concurrent.Future[io.vertx.ext.stomp.StompServer] = {
      val promise = Promise[io.vertx.ext.stomp.StompServer]()
      asJava.listen(port, host, {a:AsyncResult[io.vertx.ext.stomp.StompServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
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
