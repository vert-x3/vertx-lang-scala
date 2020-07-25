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

package io.vertx.scala.core.http

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.core.http.{GoAway => JGoAway}
import scala.reflect.runtime.universe._
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.http.{Http2Settings => JHttp2Settings}
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Represents an HTTP connection.
  * <p/>
  * HTTP/1.x connection provides an limited implementation, the following methods are implemented:
  * <ul>
  *   <li>[[io.vertx.scala.core.http.HttpConnection#close]]</li>
  *   <li>[[io.vertx.scala.core.http.HttpConnection#closeHandler]]</li>
  *   <li>[[io.vertx.scala.core.http.HttpConnection#exceptionHandler]]</li>
  * </ul>
  */

class HttpConnection(private val _asJava: Object) {
  def asJava = _asJava
  private var cached_0: Option[SocketAddress] = None
  private var cached_1: Option[SocketAddress] = None


  /**
   * @return the remote address for this connection, possibly `null` (e.g a server bound on a domain socket)
   */
  def remoteAddress(): SocketAddress = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JHttpConnection].remoteAddress()
      cached_0 = Some(SocketAddress(tmp))
    }
    cached_0.get
  }

  /**
   * @return the local address for this connection, possibly `null` (e.g a server bound on a domain socket)
   */
  def localAddress(): SocketAddress = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JHttpConnection].localAddress()
      cached_1 = Some(SocketAddress(tmp))
    }
    cached_1.get
  }


  /**
   * Update the current connection wide window size to a new size.
   * <p/>
   * Increasing this value, gives better performance when several data streams are multiplexed
   * <p/>
   * This is not implemented for HTTP/1.x.   * @param windowSize the new window size
   * @return a reference to this, so the API can be used fluently
   */
  
  def setWindowSize(windowSize: Int): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].setWindowSize(windowSize.asInstanceOf[java.lang.Integer])
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpConnection#goAway]] with a last stream id `-1` which means to disallow any new stream creation.
   */
  
  def goAway(errorCode: Long): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].goAway(errorCode.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpConnection#goAway]] with no buffer.
   */
  
  def goAway(errorCode: Long, lastStreamId: Int): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].goAway(errorCode.asInstanceOf[java.lang.Long], lastStreamId.asInstanceOf[java.lang.Integer])
    this
  }

  /**
   * Send a go away frame to the remote endpoint of the connection.
   * <p/>
   * <ul>
   *   <li>a  frame is sent to the to the remote endpoint with the `errorCode` and `debugData`</li>
   *   <li>any stream created after the stream identified by `lastStreamId` will be closed</li>
   *   <li>for an  is different than `0` when all the remaining streams are closed this connection will be closed automatically</li>
   * </ul>
   * <p/>
   * This is not implemented for HTTP/1.x.   * @param errorCode the ` GOAWAY` error code
   * @param lastStreamId the last stream id
   * @param debugData additional debug data sent to the remote endpoint
   * @return a reference to this, so the API can be used fluently
   */
  
  def goAway(errorCode: Long, lastStreamId: Int, debugData: io.vertx.core.buffer.Buffer): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].goAway(errorCode.asInstanceOf[java.lang.Long], lastStreamId.asInstanceOf[java.lang.Integer], debugData)
    this
  }

  /**
   * Set an handler called when a  frame is received.
   * <p/>
   * This is not implemented for HTTP/1.x.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def goAwayHandler(handler: Handler[GoAway]): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].goAwayHandler((if (handler == null) null else new io.vertx.core.Handler[JGoAway]{def handle(x: JGoAway) {handler.handle(GoAway(x))}}))
    this
  }

  /**
   * Set an handler called when a  frame has been sent or received and all connections are closed.
   * <p/>
   * This is not implemented for HTTP/1.x.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def shutdownHandler(handler: Handler[Unit]): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].shutdownHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }

  /**
   * Initiate a graceful connection shutdown, the connection is taken out of service and closed when all current requests
   * are processed, otherwise after 30 seconds the connection will be closed. Client connection are immediately removed
   * from the pool.
   *
   * <ul>
   *   <li>HTTP/2 connections will send a go away frame immediately to signal the other side the connection will close</li>
   *   <li>HTTP/1.x client connection supports this feature</li>
   *   <li>HTTP/1.x server connections do not support this feature</li>
   * </ul>   * @return a reference to this, so the API can be used fluently
   */
  
  def shutdown(): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].shutdown()
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpConnection#shutdown]] but with a configurable timeout value.   * @param timeoutMs the timeout in milliseconds
   * @return a reference to this, so the API can be used fluently
   */
  
  def shutdown(timeoutMs: Long): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].shutdown(timeoutMs.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Set a close handler. The handler will get notified when the connection is closed.   * @param handler the handler to be notified
   * @return a reference to this, so the API can be used fluently
   */
  
  def closeHandler(handler: Handler[Unit]): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].closeHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }

  /**
   * Send to the remote endpoint an update of the server settings.
   * <p/>
   * This is not implemented for HTTP/1.x.   * @param settings the new settings see <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>
   * @return a reference to this, so the API can be used fluently
   */
  
  def updateSettings(settings: Http2Settings): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].updateSettings(settings.asJava)
    this
  }

  /**
   * Send to the remote endpoint an update of this endpoint settings
   * <p/>
   * The `completionHandler` will be notified when the remote endpoint has acknowledged the settings.
   * <p/>
   * This is not implemented for HTTP/1.x.   * @param settings the new settings see <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>
   * @param completionHandler the handler notified when the settings have been acknowledged by the remote endpoint
   * @return a reference to this, so the API can be used fluently
   */
  
  def updateSettings(settings: Http2Settings, completionHandler: Handler[AsyncResult[Unit]]): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].updateSettings(settings.asJava, (if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Set an handler that is called when remote endpoint <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a> are updated.
   * <p/>
   * This is not implemented for HTTP/1.x.   * @param handler the handler for remote endpoint settings
   * @return a reference to this, so the API can be used fluently
   */
  
  def remoteSettingsHandler(handler: Handler[Http2Settings]): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].remoteSettingsHandler((if (handler == null) null else new io.vertx.core.Handler[JHttp2Settings]{def handle(x: JHttp2Settings) {handler.handle(Http2Settings(x))}}))
    this
  }

  /**
   * Send a  frame to the remote endpoint.
   * <p/>
   * This is not implemented for HTTP/1.x.   * @param data the 8 bytes data of the frame
   * @param pongHandler an async result handler notified with pong reply or the failure
   * @return a reference to this, so the API can be used fluently
   */
  
  def ping(data: io.vertx.core.buffer.Buffer, pongHandler: Handler[AsyncResult[io.vertx.core.buffer.Buffer]]): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].ping(data, (if (pongHandler == null) null else new io.vertx.core.Handler[AsyncResult[Buffer]]{def handle(x: AsyncResult[Buffer]) {pongHandler.handle(AsyncResultWrapper[Buffer, io.vertx.core.buffer.Buffer](x, a => a))}}))
    this
  }

  /**
   * Set an handler notified when a  frame is received from the remote endpoint.
   * <p/>
   * This is not implemented for HTTP/1.x.   * @param handler the handler to be called when a ` PING` is received
   * @return a reference to this, so the API can be used fluently
   */
  
  def pingHandler(handler: Handler[io.vertx.core.buffer.Buffer]): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].pingHandler((if (handler == null) null else new io.vertx.core.Handler[Buffer]{def handle(x: Buffer) {handler.handle(x)}}))
    this
  }

  /**
   * Set an handler called when a connection error happens   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def exceptionHandler(handler: Handler[Throwable]): HttpConnection = {
    asJava.asInstanceOf[JHttpConnection].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }


  /**
   * @return the current connection window size or `-1` for HTTP/1.x
   */
  def getWindowSize(): Int = {
    asJava.asInstanceOf[JHttpConnection].getWindowSize().asInstanceOf[Int]
  }


  /**
   * Close the connection and all the currently active streams.
   * <p/>
   * An HTTP/2 connection will send a  frame before.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JHttpConnection].close()
  }

  /**
   * @return the latest server settings acknowledged by the remote endpoint - this is not implemented for HTTP/1.xsee <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>
   */
  def settings (): Http2Settings = {
    Http2Settings(asJava.asInstanceOf[JHttpConnection].settings())
  }

  /**
   * @return the current remote endpoint settings for this connection - this is not implemented for HTTP/1.xsee <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>
   */
  def remoteSettings (): Http2Settings = {
    Http2Settings(asJava.asInstanceOf[JHttpConnection].remoteSettings())
  }

  /**
   * @return true if this io.vertx.scala.core.http.HttpConnection is encrypted via SSL/TLS.
   */
  def isSsl (): Boolean = {
    asJava.asInstanceOf[JHttpConnection].isSsl().asInstanceOf[Boolean]
  }

  /**
   * Returns the SNI server name presented during the SSL handshake by the client.   * @return the indicated server name
   */
  def indicatedServerName (): String = {
    asJava.asInstanceOf[JHttpConnection].indicatedServerName().asInstanceOf[String]
  }


 /**
  * Like [[updateSettings]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def updateSettingsFuture (settings: Http2Settings): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpConnection].updateSettings(settings.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[ping]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pingFuture (data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Buffer, io.vertx.core.buffer.Buffer](x => x)
    asJava.asInstanceOf[JHttpConnection].ping(data, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object HttpConnection {
  def apply(asJava: JHttpConnection) = new HttpConnection(asJava)

}
