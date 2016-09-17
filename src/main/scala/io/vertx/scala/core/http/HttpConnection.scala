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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.http.GoAway
import io.vertx.core.http.Http2Settings
import io.vertx.core.Handler

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
class HttpConnection(private val _asJava: io.vertx.core.http.HttpConnection) {

  def asJava: io.vertx.core.http.HttpConnection = _asJava

  /**
    * @return the current connection window size or `-1` for HTTP/1.x
    */
  def getWindowSize(): Int = {
    _asJava.getWindowSize()
  }

  /**
    * Update the current connection wide window size to a new size.
    * <p/>
    * Increasing this value, gives better performance when several data streams are multiplexed
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param windowSize the new window size
    * @return a reference to this, so the API can be used fluently
    */
  def setWindowSize(windowSize: Int): io.vertx.scala.core.http.HttpConnection = {
    _asJava.setWindowSize(windowSize)
    this
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpConnection#goAway]] with a last stream id `2^31-1`.
    */
  def goAway(errorCode: Long): io.vertx.scala.core.http.HttpConnection = {
    _asJava.goAway(errorCode)
    this
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpConnection#goAway]] with no buffer.
    */
  def goAway(errorCode: Long, lastStreamId: Int): io.vertx.scala.core.http.HttpConnection = {
    _asJava.goAway(errorCode, lastStreamId)
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
    * This is not implemented for HTTP/1.x.
    * @param errorCode the {@literal GOAWAY` error code
    * @param lastStreamId the last stream id
    * @param debugData additional debug data sent to the remote endpoint
    * @return a reference to this, so the API can be used fluently
    */
  def goAway(errorCode: Long, lastStreamId: Int, debugData: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.HttpConnection = {
    _asJava.goAway(errorCode, lastStreamId, debugData.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  /**
    * Set an handler called when a  frame is received.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def goAwayHandler(handler: io.vertx.scala.core.http.GoAway => Unit): io.vertx.scala.core.http.HttpConnection = {
    _asJava.goAwayHandler(funcToMappedHandler[io.vertx.core.http.GoAway, io.vertx.scala.core.http.GoAway](a => GoAway(a))(handler))
    this
  }

  /**
    * Set an handler called when a  frame has been sent or received and all connections are closed.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def shutdownHandler(handler: () => Unit): io.vertx.scala.core.http.HttpConnection = {
    _asJava.shutdownHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  /**
    * Initiate a connection shutdown, a go away frame is sent and the connection is closed when all current active streams
    * are closed or after a time out of 30 seconds.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @return a reference to this, so the API can be used fluently
    */
  def shutdown(): io.vertx.scala.core.http.HttpConnection = {
    _asJava.shutdown()
    this
  }

  /**
    * Initiate a connection shutdown, a go away frame is sent and the connection is closed when all current streams
    * will be closed or the `timeout` is fired.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param timeoutMs the timeout in milliseconds
    * @return a reference to this, so the API can be used fluently
    */
  def shutdown(timeoutMs: Long): io.vertx.scala.core.http.HttpConnection = {
    _asJava.shutdown(timeoutMs)
    this
  }

  /**
    * Set a close handler. The handler will get notified when the connection is closed.
    * @param handler the handler to be notified
    * @return a reference to this, so the API can be used fluently
    */
  def closeHandler(handler: () => Unit): io.vertx.scala.core.http.HttpConnection = {
    _asJava.closeHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  /**
    * Close the connection and all the currently active streams.
    * <p/>
    * An HTTP/2 connection will send a  frame before.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * @return the latest server settings acknowledged by the remote endpoint - this is not implemented for HTTP/1.x
    */
  def settings(): io.vertx.scala.core.http.Http2Settings = {
    Http2Settings(_asJava.settings())
  }

  /**
    * Send to the remote endpoint an update of the server settings.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param settings the new settingssee <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>
    * @return a reference to this, so the API can be used fluently
    */
  def updateSettings(settings: io.vertx.scala.core.http.Http2Settings): io.vertx.scala.core.http.HttpConnection = {
    _asJava.updateSettings(settings.asJava)
    this
  }

  /**
    * Send to the remote endpoint an update of this endpoint settings
    * <p/>
    * The `completionHandler` will be notified when the remote endpoint has acknowledged the settings.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param settings the new settingssee <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>
    * @return the future notified when the settings have been acknowledged by the remote endpoint
    */
  def updateSettingsFuture(settings: io.vertx.scala.core.http.Http2Settings): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.updateSettings(settings.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * @return the current remote endpoint settings for this connection - this is not implemented for HTTP/1.x
    */
  def remoteSettings(): io.vertx.scala.core.http.Http2Settings = {
    Http2Settings(_asJava.remoteSettings())
  }

  /**
    * Set an handler that is called when remote endpoint <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a> are updated.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param handler the handler for remote endpoint settings
    * @return a reference to this, so the API can be used fluently
    */
  def remoteSettingsHandler(handler: io.vertx.scala.core.http.Http2Settings => Unit): io.vertx.scala.core.http.HttpConnection = {
    _asJava.remoteSettingsHandler(funcToMappedHandler[io.vertx.core.http.Http2Settings, io.vertx.scala.core.http.Http2Settings](a => Http2Settings(a))(handler))
    this
  }

  /**
    * Send a  frame to the remote endpoint.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param data the 8 bytes data of the frame
    * @return an async result future notified with pong reply or the failure
    */
  def pingFuture(data: io.vertx.scala.core.buffer.Buffer): concurrent.Future[io.vertx.scala.core.buffer.Buffer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.buffer.Buffer,io.vertx.scala.core.buffer.Buffer]((x => if (x == null) null else Buffer.apply(x)))
    _asJava.ping(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set an handler notified when a  frame is received from the remote endpoint.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param handler the handler to be called when a {@literal PING` is received
    * @return a reference to this, so the API can be used fluently
    */
  def pingHandler(handler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.http.HttpConnection = {
    _asJava.pingHandler(funcToMappedHandler(Buffer.apply)(handler))
    this
  }

  /**
    * Set an handler called when a connection error happens
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.HttpConnection = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

}

object HttpConnection {

  def apply(_asJava: io.vertx.core.http.HttpConnection): io.vertx.scala.core.http.HttpConnection =
    new io.vertx.scala.core.http.HttpConnection(_asJava)

}
