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

package io.vertx.scala.core.net;

import io.vertx.scala.core.metrics.Measured
import io.vertx.core.Handler

/**
  * Represents a TCP server
  */
class NetServer(private val _asJava: io.vertx.core.net.NetServer) 
    extends io.vertx.scala.core.metrics.Measured {

  def asJava: java.lang.Object = _asJava

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  /**
    * Return the connect stream for this server. The server can only have at most one handler at any one time.
    * As the server accepts TCP or SSL connections it creates an instance of [[io.vertx.scala.core.net.NetSocket]] and passes it to the
    * connect stream .
    * @return the connect stream
    */
  def connectStream(): io.vertx.scala.core.net.NetSocketStream = {
    NetSocketStream.apply(_asJava.connectStream())
  }

  /**
    * Supply a connect handler for this server. The server can only have at most one connect handler at any one time.
    * As the server accepts TCP or SSL connections it creates an instance of [[io.vertx.scala.core.net.NetSocket]] and passes it to the
    * connect handler.
    * @return a reference to this, so the API can be used fluently
    */
  def connectHandler(handler: io.vertx.scala.core.net.NetSocket => Unit): io.vertx.scala.core.net.NetServer = {
    import io.vertx.lang.scala.HandlerOps._
    NetServer.apply(_asJava.connectHandler(funcToMappedHandler(NetSocket.apply)(handler)))
  }

  /**
    * Like [[io.vertx.scala.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.
    * @return handler that will be notified when listening or failed
    */
  def listen(): scala.concurrent.Future[io.vertx.scala.core.net.NetServer] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[io.vertx.scala.core.net.NetServer]()
    _asJava.listen(promiseToMappedAsyncResultHandler(NetServer.apply)(promise))
    promise.future
  }

  /**
    * Like [[io.vertx.scala.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.
    * @param port the port to listen on
    * @param host the host to listen on
    * @return handler that will be notified when listening or failed
    */
  def listen(port: Int, host: String): scala.concurrent.Future[io.vertx.scala.core.net.NetServer] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[io.vertx.scala.core.net.NetServer]()
    _asJava.listen(port, host, promiseToMappedAsyncResultHandler(NetServer.apply)(promise))
    promise.future
  }

  /**
    * Like [[io.vertx.scala.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.
    * @param port the port to listen on
    * @return handler that will be notified when listening or failed
    */
  def listen(port: Int): scala.concurrent.Future[io.vertx.scala.core.net.NetServer] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[io.vertx.scala.core.net.NetServer]()
    _asJava.listen(port, promiseToMappedAsyncResultHandler(NetServer.apply)(promise))
    promise.future
  }

  /**
    * Like [[io.vertx.scala.core.net.NetServer#close]] but supplying a handler that will be notified when close is complete.
    * @return the handler
    */
  def close(): scala.concurrent.Future[Unit] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Unit]()
    _asJava.close(promiseToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(promise))
    promise.future
  }

  /**
    * The actual port the server is listening on. This is useful if you bound the server specifying 0 as port number
    * signifying an ephemeral port
    * @return the actual port the server is listening on.
    */
  def actualPort(): Int = {
    _asJava.actualPort()
  }

}

object NetServer {

  def apply(_asJava: io.vertx.core.net.NetServer): io.vertx.scala.core.net.NetServer =
    new io.vertx.scala.core.net.NetServer(_asJava)
}
