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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.net.{NetClient => JNetClient}
import scala.reflect.runtime.universe._
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A TCP client.
  * 
  * Multiple connections to different servers can be made using the same instance.
  * 
  * This client supports a configurable number of connection attempts and a configurable
  * delay between attempts.
  */

class NetClient(private val _asJava: Object) extends Measured {
  def asJava = _asJava



  /**
   * Open a connection to a server at the specific `port` and `host`.
   * 
   * `host` can be a valid host name or IP address. The connect is done asynchronously and on success, a
   * [[io.vertx.scala.core.net.NetSocket]] instance is supplied via the `connectHandler` instance   * @param port the port
   * @param host the host
   * @return a reference to this, so the API can be used fluently
   */
  
  def connect(port: Int, host: String, connectHandler: Handler[AsyncResult[NetSocket]]): NetClient = {
    asJava.asInstanceOf[JNetClient].connect(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], (if (connectHandler == null) null else new io.vertx.core.Handler[AsyncResult[JNetSocket]]{def handle(x: AsyncResult[JNetSocket]) {connectHandler.handle(AsyncResultWrapper[JNetSocket, NetSocket](x, a => NetSocket(a)))}}))
    this
  }

  /**
   * Open a connection to a server at the specific `port` and `host`.
   * 
   * `host` can be a valid host name or IP address. The connect is done asynchronously and on success, a
   * [[io.vertx.scala.core.net.NetSocket]] instance is supplied via the `connectHandler` instance   * @param port the port
   * @param host the host
   * @param serverName the SNI server name
   * @return a reference to this, so the API can be used fluently
   */
  
  def connect(port: Int, host: String, serverName: String, connectHandler: Handler[AsyncResult[NetSocket]]): NetClient = {
    asJava.asInstanceOf[JNetClient].connect(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], serverName.asInstanceOf[java.lang.String], (if (connectHandler == null) null else new io.vertx.core.Handler[AsyncResult[JNetSocket]]{def handle(x: AsyncResult[JNetSocket]) {connectHandler.handle(AsyncResultWrapper[JNetSocket, NetSocket](x, a => NetSocket(a)))}}))
    this
  }

  /**
   * Open a connection to a server at the specific `remoteAddress`.
   * 
   * The connect is done asynchronously and on success, a [[io.vertx.scala.core.net.NetSocket]] instance is supplied via the `connectHandler` instance   * @param remoteAddress the remote address
   * @return a reference to this, so the API can be used fluently
   */
  
  def connect(remoteAddress: SocketAddress, connectHandler: Handler[AsyncResult[NetSocket]]): NetClient = {
    asJava.asInstanceOf[JNetClient].connect(remoteAddress.asJava.asInstanceOf[JSocketAddress], (if (connectHandler == null) null else new io.vertx.core.Handler[AsyncResult[JNetSocket]]{def handle(x: AsyncResult[JNetSocket]) {connectHandler.handle(AsyncResultWrapper[JNetSocket, NetSocket](x, a => NetSocket(a)))}}))
    this
  }

  /**
   * Open a connection to a server at the specific `remoteAddress`.
   * 
   * The connect is done asynchronously and on success, a [[io.vertx.scala.core.net.NetSocket]] instance is supplied via the `connectHandler` instance   * @param remoteAddress the remote address
   * @param serverName the SNI server name
   * @return a reference to this, so the API can be used fluently
   */
  
  def connect(remoteAddress: SocketAddress, serverName: String, connectHandler: Handler[AsyncResult[NetSocket]]): NetClient = {
    asJava.asInstanceOf[JNetClient].connect(remoteAddress.asJava.asInstanceOf[JSocketAddress], serverName.asInstanceOf[java.lang.String], (if (connectHandler == null) null else new io.vertx.core.Handler[AsyncResult[JNetSocket]]{def handle(x: AsyncResult[JNetSocket]) {connectHandler.handle(AsyncResultWrapper[JNetSocket, NetSocket](x, a => NetSocket(a)))}}))
    this
  }


  /**
   * Whether the metrics are enabled for this measured object   * @return `true` if metrics are enabled
   */
  override def isMetricsEnabled(): Boolean = {
    asJava.asInstanceOf[JNetClient].isMetricsEnabled().asInstanceOf[Boolean]
  }


  /**
   * Close the client.
   * 
   * Any sockets which have not been closed manually will be closed here. The close is asynchronous and may not
   * complete until some time after the method has returned.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JNetClient].close()
  }


 /**
  * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def connectFuture (port: Int, host: String): scala.concurrent.Future[NetSocket] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetSocket, NetSocket](x => NetSocket(x))
    asJava.asInstanceOf[JNetClient].connect(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def connectFuture (port: Int, host: String, serverName: String): scala.concurrent.Future[NetSocket] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetSocket, NetSocket](x => NetSocket(x))
    asJava.asInstanceOf[JNetClient].connect(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], serverName.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def connectFuture (remoteAddress: SocketAddress): scala.concurrent.Future[NetSocket] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetSocket, NetSocket](x => NetSocket(x))
    asJava.asInstanceOf[JNetClient].connect(remoteAddress.asJava.asInstanceOf[JSocketAddress], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def connectFuture (remoteAddress: SocketAddress, serverName: String): scala.concurrent.Future[NetSocket] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetSocket, NetSocket](x => NetSocket(x))
    asJava.asInstanceOf[JNetClient].connect(remoteAddress.asJava.asInstanceOf[JSocketAddress], serverName.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object NetClient {
  def apply(asJava: JNetClient) = new NetClient(asJava)
  
}
