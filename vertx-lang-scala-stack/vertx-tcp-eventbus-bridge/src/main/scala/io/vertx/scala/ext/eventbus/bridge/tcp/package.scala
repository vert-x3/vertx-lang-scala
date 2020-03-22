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

package io.vertx.scala.ext.eventbus.bridge

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.eventbus.bridge.tcp.{TcpEventBusBridge => JTcpEventBusBridge}
import io.vertx.core
import io.vertx.ext.eventbus.bridge.tcp.{BridgeEvent => JBridgeEvent}
import io.vertx.ext.bridge
import io.vertx.ext.bridge.{BridgeOptions => JBridgeOptions}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.net
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
import io.vertx.core.{Vertx => JVertx}

package object tcp{




  /**
    * TCP EventBus bridge for Vert.x
    */

  implicit class TcpEventBusBridgeScala(val asJava: io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge) extends AnyVal {

    /**
     * Like listen from [[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def listenFuture() : scala.concurrent.Future[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] = {
      val promise = concurrent.Promise[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]()
      asJava.listen(new Handler[AsyncResult[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]] { override def handle(event: AsyncResult[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like listen from [[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def listenFuture(port: java.lang.Integer,address: java.lang.String) : scala.concurrent.Future[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] = {
      val promise = concurrent.Promise[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]()
      asJava.listen(port, address, new Handler[AsyncResult[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]] { override def handle(event: AsyncResult[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like listen from [[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def listenFuture(port: java.lang.Integer) : scala.concurrent.Future[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] = {
      val promise = concurrent.Promise[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]()
      asJava.listen(port, new Handler[AsyncResult[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]] { override def handle(event: AsyncResult[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like close from [[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def closeFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }


}
