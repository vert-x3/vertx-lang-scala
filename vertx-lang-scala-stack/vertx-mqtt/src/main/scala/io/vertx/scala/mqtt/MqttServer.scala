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

package io.vertx.scala.mqtt

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.mqtt.{MqttEndpoint => JMqttEndpoint}
import scala.reflect.runtime.universe._
import io.vertx.mqtt.{MqttServerOptions => JMqttServerOptions}
import io.vertx.mqtt.{MqttServer => JMqttServer}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * An MQTT server
  * 
  *    You can accept incoming MQTT connection requests providing a [[io.vertx.scala.mqtt.MqttServer#endpointHandler]]. As the
  *    requests arrive, the handler will be called with an instance of [[io.vertx.scala.mqtt.MqttEndpoint]] in order to manage the
  *    communication with the remote MQTT client.
  * </p>

  */

class MqttServer(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Start the server listening for incoming connections using the specified options
   * through the constructor   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(): MqttServer = {
    asJava.asInstanceOf[JMqttServer].listen()
    this
  }

  /**
   * Start the server listening for incoming connections on the port and host specified   * @param port the port to listen on
   * @param host the host to listen on
   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(port: Int, host: String): MqttServer = {
    asJava.asInstanceOf[JMqttServer].listen(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Start the server listening for incoming connections on the port and host specified
   * It ignores any options specified through the constructor   * @param port the port to listen on
   * @param host the host to listen on
   * @param listenHandler handler called when the asynchronous listen call ends
   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(port: Int, host: String, listenHandler: Handler[AsyncResult[MqttServer]]): MqttServer = {
    asJava.asInstanceOf[JMqttServer].listen(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], (if (listenHandler == null) null else new io.vertx.core.Handler[AsyncResult[JMqttServer]]{def handle(x: AsyncResult[JMqttServer]) {listenHandler.handle(AsyncResultWrapper[JMqttServer, MqttServer](x, a => MqttServer(a)))}}))
    this
  }

  /**
   * Start the server listening for incoming connections on the port specified but on
   * "0.0.0.0" as host. It ignores any options specified through the constructor   * @param port the port to listen on
   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(port: Int): MqttServer = {
    asJava.asInstanceOf[JMqttServer].listen(port.asInstanceOf[java.lang.Integer])
    this
  }

  /**
   * Start the server listening for incoming connections on the port specified but on
   * "0.0.0.0" as host. It ignores any options specified through the constructor   * @param port the port to listen on
   * @param listenHandler handler called when the asynchronous listen call ends
   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(port: Int, listenHandler: Handler[AsyncResult[MqttServer]]): MqttServer = {
    asJava.asInstanceOf[JMqttServer].listen(port.asInstanceOf[java.lang.Integer], (if (listenHandler == null) null else new io.vertx.core.Handler[AsyncResult[JMqttServer]]{def handle(x: AsyncResult[JMqttServer]) {listenHandler.handle(AsyncResultWrapper[JMqttServer, MqttServer](x, a => MqttServer(a)))}}))
    this
  }

  /**
   * Start the server listening for incoming connections using the specified options
   * through the constructor   * @param listenHandler handler called when the asynchronous listen call ends
   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(listenHandler: Handler[AsyncResult[MqttServer]]): MqttServer = {
    asJava.asInstanceOf[JMqttServer].listen((if (listenHandler == null) null else new io.vertx.core.Handler[AsyncResult[JMqttServer]]{def handle(x: AsyncResult[JMqttServer]) {listenHandler.handle(AsyncResultWrapper[JMqttServer, MqttServer](x, a => MqttServer(a)))}}))
    this
  }

  /**
   * Set the endpoint handler for the server. If an MQTT client connect to the server a
   * new MqttEndpoint instance will be created and passed to the handler   * @param handler the endpoint handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def endpointHandler(handler: Handler[MqttEndpoint]): MqttServer = {
    asJava.asInstanceOf[JMqttServer].endpointHandler((if (handler == null) null else new io.vertx.core.Handler[JMqttEndpoint]{def handle(x: JMqttEndpoint) {handler.handle(MqttEndpoint(x))}}))
    this
  }

  /**
   * Set an exception handler for the server, that will be called when an error happens independantly of an
   * accepted [[io.vertx.scala.mqtt.MqttEndpoint]], like a rejected connection   * @param handler the exception handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def exceptionHandler(handler: Handler[Throwable]): MqttServer = {
    asJava.asInstanceOf[JMqttServer].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }



  /**
   * The actual port the server is listening on. This is useful if you bound the server specifying 0 as port number
   * signifying an ephemeral port   * @return the actual port the server is listening on.
   */
  def actualPort (): Int = {
    asJava.asInstanceOf[JMqttServer].actualPort().asInstanceOf[Int]
  }

  /**
   * Close the server.
   * 
   * The close happens asynchronously and the server may not be closed until some time after the call has returned.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JMqttServer].close()
  }

  /**
   * Close the server supplying an handler that will be called when the server is actually closed (or has failed).   * @param completionHandler the handler called on completion
   */
  def close (completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JMqttServer].close((if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


 /**
  * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listenFuture (port: Int, host: String): scala.concurrent.Future[MqttServer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMqttServer, MqttServer](x => MqttServer(x))
    asJava.asInstanceOf[JMqttServer].listen(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listenFuture (port: Int): scala.concurrent.Future[MqttServer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMqttServer, MqttServer](x => MqttServer(x))
    asJava.asInstanceOf[JMqttServer].listen(port.asInstanceOf[java.lang.Integer], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listenFuture (): scala.concurrent.Future[MqttServer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMqttServer, MqttServer](x => MqttServer(x))
    asJava.asInstanceOf[JMqttServer].listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMqttServer].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object MqttServer {
  def apply(asJava: JMqttServer) = new MqttServer(asJava)
  
  /**
   * Return an MQTT server instance   * @param vertx Vert.x instance
   * @param options MQTT server options see <a href="../../../../../../cheatsheet/MqttServerOptions.html">MqttServerOptions</a>
   * @return MQTT server instance
   */
  def create(vertx: Vertx,options: MqttServerOptions): MqttServer = {
    MqttServer(JMqttServer.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  /**
   * Return an MQTT server instance using default options   * @param vertx Vert.x instance
   * @return MQTT server instance
   */
  def create(vertx: Vertx): MqttServer = {
    MqttServer(JMqttServer.create(vertx.asJava.asInstanceOf[JVertx]))
  }

}
