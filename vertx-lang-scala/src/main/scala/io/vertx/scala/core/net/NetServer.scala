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

package io.vertx.scala.core.net

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.net.{NetServer => JNetServer}
import io.vertx.core.net.{NetSocketStream => JNetSocketStream}
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.net.{NetSocket => JNetSocket}

/**
  * Represents a TCP server
  */
class NetServer(private val _asJava: JNetServer) 
    extends Measured {

  def asJava: JNetServer = _asJava

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
  def connectStream(): NetSocketStream = {
    NetSocketStream.apply(_asJava.connectStream())
  }

  /**
    * Supply a connect handler for this server. The server can only have at most one connect handler at any one time.
    * As the server accepts TCP or SSL connections it creates an instance of [[io.vertx.scala.core.net.NetSocket]] and passes it to the
    * connect handler.
    * @return a reference to this, so the API can be used fluently
    */
  def connectHandler(handler: NetSocket => Unit): NetServer = {
    NetServer.apply(_asJava.connectHandler(funcToMappedHandler(NetSocket.apply)(handler)))
  }

  /**
    * Start listening on the port and host as configured in the <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when
    * creating the server.
    * 
    * The server may not be listening until some time after the call to listen has returned.
    * @return a reference to this, so the API can be used fluently
    */
  def listen(): NetServer = {
    _asJava.listen()
    this
  }

  /**
    * Like [[io.vertx.scala.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.
    * @return future that will be notified when listening or failed
    */
  def listenFuture(): concurrent.Future[NetServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetServer,NetServer]((x => if (x == null) null else NetServer.apply(x)))
    _asJava.listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Start listening on the specified port and host, ignoring post and host configured in the <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when
    * creating the server.
    * 
    * Port `0` can be specified meaning "choose an random port".
    * 
    * Host `0.0.0.0` can be specified meaning "listen on all available interfaces".
    * 
    * The server may not be listening until some time after the call to listen has returned.
    * @return a reference to this, so the API can be used fluently
    */
  def listen(port: Int, host: String): NetServer = {
    _asJava.listen(port, host)
    this
  }

  /**
    * Like [[io.vertx.scala.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.
    * @param port the port to listen on
    * @param host the host to listen on
    * @return future that will be notified when listening or failed
    */
  def listenFuture(port: Int, host: String): concurrent.Future[NetServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetServer,NetServer]((x => if (x == null) null else NetServer.apply(x)))
    _asJava.listen(port, host, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Start listening on the specified port and host "0.0.0.0", ignoring post and host configured in the
    * <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when creating the server.
    * 
    * Port `0` can be specified meaning "choose an random port".
    * 
    * The server may not be listening until some time after the call to listen has returned.
    * @return a reference to this, so the API can be used fluently
    */
  def listen(port: Int): NetServer = {
    _asJava.listen(port)
    this
  }

  /**
    * Like [[io.vertx.scala.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.
    * @param port the port to listen on
    * @return future that will be notified when listening or failed
    */
  def listenFuture(port: Int): concurrent.Future[NetServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetServer,NetServer]((x => if (x == null) null else NetServer.apply(x)))
    _asJava.listen(port, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Close the server. This will close any currently open connections. The close may not complete until after this
    * method has returned.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Like [[io.vertx.scala.core.net.NetServer#close]] but supplying a handler that will be notified when close is complete.
    * @return the future
    */
  def closeFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.close(promiseAndHandler._1)
    promiseAndHandler._2.future
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

  def apply(_asJava: JNetServer): NetServer =
    new NetServer(_asJava)

}
