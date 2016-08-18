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
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.Handler

/**
  * Represents a TCP server
  */
class NetServer(private val _asJava: io.vertx.core.net.NetServer) 
    extends io.vertx.scala.core.metrics.Measured {

  def asJava: io.vertx.core.net.NetServer = _asJava

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
    NetServer.apply(_asJava.connectHandler(funcToMappedHandler(NetSocket.apply)(handler)))
  }

  /**
    * Start listening on the port and host as configured in the <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when
    * creating the server.
    * 
    * The server may not be listening until some time after the call to listen has returned.
    * @return a reference to this, so the API can be used fluently
    */
  def listen(): io.vertx.scala.core.net.NetServer = {
    _asJava.listen()
    this
  }

  /**
    * Like [[io.vertx.scala.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.
    * @param listenHandler handler that will be notified when listening or failed
    * @return a reference to this, so the API can be used fluently
    */
  def listen(listenHandler: io.vertx.core.AsyncResult [io.vertx.scala.core.net.NetServer] => Unit): io.vertx.scala.core.net.NetServer = {
    _asJava.listen(funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.net.NetServer], io.vertx.core.AsyncResult [io.vertx.scala.core.net.NetServer]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.net.NetServer, io.vertx.scala.core.net.NetServer](x,(x => if (x == null) null else NetServer.apply(x))))(listenHandler))
    this
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
  def listen(port: Int, host: String): io.vertx.scala.core.net.NetServer = {
    _asJava.listen(port, host)
    this
  }

  /**
    * Like [[io.vertx.scala.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.
    * @param port the port to listen on
    * @param host the host to listen on
    * @param listenHandler handler that will be notified when listening or failed
    * @return a reference to this, so the API can be used fluently
    */
  def listenWithHandler(port: Int, host: String)( listenHandler: io.vertx.core.AsyncResult [io.vertx.scala.core.net.NetServer] => Unit): io.vertx.scala.core.net.NetServer = {
    _asJava.listen(port, host, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.net.NetServer], io.vertx.core.AsyncResult [io.vertx.scala.core.net.NetServer]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.net.NetServer, io.vertx.scala.core.net.NetServer](x,(x => if (x == null) null else NetServer.apply(x))))(listenHandler))
    this
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
  def listen(port: Int): io.vertx.scala.core.net.NetServer = {
    _asJava.listen(port)
    this
  }

  /**
    * Like [[io.vertx.scala.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.
    * @param port the port to listen on
    * @param listenHandler handler that will be notified when listening or failed
    * @return a reference to this, so the API can be used fluently
    */
  def listenWithHandler(port: Int)( listenHandler: io.vertx.core.AsyncResult [io.vertx.scala.core.net.NetServer] => Unit): io.vertx.scala.core.net.NetServer = {
    _asJava.listen(port, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.net.NetServer], io.vertx.core.AsyncResult [io.vertx.scala.core.net.NetServer]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.net.NetServer, io.vertx.scala.core.net.NetServer](x,(x => if (x == null) null else NetServer.apply(x))))(listenHandler))
    this
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
    * @param completionHandler the handler
    */
  def close(completionHandler: io.vertx.core.AsyncResult [Unit] => Unit): Unit = {
    _asJava.close(funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(completionHandler))
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
