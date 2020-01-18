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
import io.vertx.mqtt.messages.{MqttSubAckMessage => JMqttSubAckMessage}
import io.netty.handler.codec.mqtt.MqttQoS
import scala.reflect.runtime.universe._
import io.vertx.scala.mqtt.messages.MqttPublishMessage
import io.vertx.scala.mqtt.messages.MqttConnAckMessage
import io.vertx.mqtt.{MqttClientOptions => JMqttClientOptions}
import io.vertx.mqtt.messages.{MqttPublishMessage => JMqttPublishMessage}
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.Converter._
import io.vertx.core.buffer.Buffer
import io.vertx.mqtt.messages.{MqttConnAckMessage => JMqttConnAckMessage}
import io.vertx.mqtt.{MqttClient => JMqttClient}
import io.vertx.core.AsyncResult
import io.vertx.scala.mqtt.messages.MqttSubAckMessage
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * An MQTT client

  */

class MqttClient(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Connects to an MQTT server calling connectHandler after connection   * @param port port of the MQTT server
   * @param host hostname/ip address of the MQTT server
   * @param connectHandler handler called when the asynchronous connect call ends
   * @return current MQTT client instance
   */
  
  def connect(port: Int, host: String, connectHandler: Handler[AsyncResult[MqttConnAckMessage]]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].connect(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], (if (connectHandler == null) null else new io.vertx.core.Handler[AsyncResult[JMqttConnAckMessage]]{def handle(x: AsyncResult[JMqttConnAckMessage]) {connectHandler.handle(AsyncResultWrapper[JMqttConnAckMessage, MqttConnAckMessage](x, a => MqttConnAckMessage(a)))}}))
    this
  }

  /**
   * Connects to an MQTT server calling connectHandler after connection   * @param port port of the MQTT server
   * @param host hostname/ip address of the MQTT server
   * @param serverName the SNI server name
   * @param connectHandler handler called when the asynchronous connect call ends
   * @return current MQTT client instance
   */
  
  def connect(port: Int, host: String, serverName: String, connectHandler: Handler[AsyncResult[MqttConnAckMessage]]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].connect(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], serverName.asInstanceOf[java.lang.String], (if (connectHandler == null) null else new io.vertx.core.Handler[AsyncResult[JMqttConnAckMessage]]{def handle(x: AsyncResult[JMqttConnAckMessage]) {connectHandler.handle(AsyncResultWrapper[JMqttConnAckMessage, MqttConnAckMessage](x, a => MqttConnAckMessage(a)))}}))
    this
  }

  /**
   * Disconnects from the MQTT server   * @return current MQTT client instance
   */
  
  def disconnect(): MqttClient = {
    asJava.asInstanceOf[JMqttClient].disconnect()
    this
  }

  /**
   * Disconnects from the MQTT server calling disconnectHandler after disconnection   * @param disconnectHandler handler called when asynchronous disconnect call ends
   * @return current MQTT client instance
   */
  
  def disconnect(disconnectHandler: Handler[AsyncResult[Unit]]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].disconnect((if (disconnectHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {disconnectHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Sends the PUBLISH message to the remote MQTT server   * @param topic topic on which the message is published
   * @param payload message payload
   * @param qosLevel QoS level
   * @param isDup if the message is a duplicate
   * @param isRetain if the message needs to be retained
   * @return current MQTT client instance
   */
  
  def publish(topic: String, payload: io.vertx.core.buffer.Buffer, qosLevel: io.netty.handler.codec.mqtt.MqttQoS, isDup: Boolean, isRetain: Boolean): MqttClient = {
    asJava.asInstanceOf[JMqttClient].publish(topic.asInstanceOf[java.lang.String], payload, qosLevel, isDup.asInstanceOf[java.lang.Boolean], isRetain.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Sends the PUBLISH message to the remote MQTT server   * @param topic topic on which the message is published
   * @param payload message payload
   * @param qosLevel QoS level
   * @param isDup if the message is a duplicate
   * @param isRetain if the message needs to be retained
   * @param publishSentHandler handler called after PUBLISH packet sent with packetid (not when QoS 0)
   * @return current MQTT client instance
   */
  
  def publish(topic: String, payload: io.vertx.core.buffer.Buffer, qosLevel: io.netty.handler.codec.mqtt.MqttQoS, isDup: Boolean, isRetain: Boolean, publishSentHandler: Handler[AsyncResult[Int]]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].publish(topic.asInstanceOf[java.lang.String], payload, qosLevel, isDup.asInstanceOf[java.lang.Boolean], isRetain.asInstanceOf[java.lang.Boolean], (if (publishSentHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.Integer]]{def handle(x: AsyncResult[java.lang.Integer]) {publishSentHandler.handle(AsyncResultWrapper[java.lang.Integer, Int](x, a => a.asInstanceOf[Int]))}}))
    this
  }

  /**
   * Sets handler which will be called each time publish is completed   * @param publishCompletionHandler handler called with the packetId
   * @return current MQTT client instance
   */
  
  def publishCompletionHandler(publishCompletionHandler: Handler[Int]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].publishCompletionHandler((if (publishCompletionHandler == null) null else new io.vertx.core.Handler[java.lang.Integer]{def handle(x: java.lang.Integer) {publishCompletionHandler.handle(x.asInstanceOf[Int])}}))
    this
  }

  /**
   * Sets handler which will be called each time server publish something to client   * @param publishHandler handler to call
   * @return current MQTT client instance
   */
  
  def publishHandler(publishHandler: Handler[MqttPublishMessage]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].publishHandler((if (publishHandler == null) null else new io.vertx.core.Handler[JMqttPublishMessage]{def handle(x: JMqttPublishMessage) {publishHandler.handle(MqttPublishMessage(x))}}))
    this
  }

  /**
   * Sets handler which will be called after SUBACK packet receiving   * @param subscribeCompletionHandler handler to call. List inside is a granted QoS array
   * @return current MQTT client instance
   */
  
  def subscribeCompletionHandler(subscribeCompletionHandler: Handler[MqttSubAckMessage]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].subscribeCompletionHandler((if (subscribeCompletionHandler == null) null else new io.vertx.core.Handler[JMqttSubAckMessage]{def handle(x: JMqttSubAckMessage) {subscribeCompletionHandler.handle(MqttSubAckMessage(x))}}))
    this
  }

  /**
   * Subscribes to the topic with a specified QoS level   * @param topic topic you subscribe on
   * @param qos QoS level
   * @return current MQTT client instance
   */
  
  def subscribe(topic: String, qos: Int): MqttClient = {
    asJava.asInstanceOf[JMqttClient].subscribe(topic.asInstanceOf[java.lang.String], qos.asInstanceOf[java.lang.Integer])
    this
  }

  /**
   * Subscribes to the topic with a specified QoS level   * @param topic topic you subscribe on
   * @param qos QoS level
   * @param subscribeSentHandler handler called after SUBSCRIBE packet sent with packetid
   * @return current MQTT client instance
   */
  
  def subscribe(topic: String, qos: Int, subscribeSentHandler: Handler[AsyncResult[Int]]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].subscribe(topic.asInstanceOf[java.lang.String], qos.asInstanceOf[java.lang.Integer], (if (subscribeSentHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.Integer]]{def handle(x: AsyncResult[java.lang.Integer]) {subscribeSentHandler.handle(AsyncResultWrapper[java.lang.Integer, Int](x, a => a.asInstanceOf[Int]))}}))
    this
  }

  /**
   * Subscribes to the topics with related QoS levels   * @param topics topics and related QoS levels to subscribe to
   * @return current MQTT client instance
   */
  
  def subscribe(topics: scala.collection.mutable.Map[String, Int]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].subscribe(topics.mapValues(x => x.asInstanceOf[java.lang.Integer]).asJava)
    this
  }

  /**
   * Subscribes to the topic and adds a handler which will be called after the request is sent   * @param topics topics you subscribe on
   * @param subscribeSentHandler handler called after SUBSCRIBE packet sent with packetid
   * @return current MQTT client instance
   */
  
  def subscribe(topics: scala.collection.mutable.Map[String, Int], subscribeSentHandler: Handler[AsyncResult[Int]]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].subscribe(topics.mapValues(x => x.asInstanceOf[java.lang.Integer]).asJava, (if (subscribeSentHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.Integer]]{def handle(x: AsyncResult[java.lang.Integer]) {subscribeSentHandler.handle(AsyncResultWrapper[java.lang.Integer, Int](x, a => a.asInstanceOf[Int]))}}))
    this
  }

  /**
   * Sets handler which will be called after UNSUBACK packet receiving   * @param unsubscribeCompletionHandler handler to call with the packetid
   * @return current MQTT client instance
   */
  
  def unsubscribeCompletionHandler(unsubscribeCompletionHandler: Handler[Int]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].unsubscribeCompletionHandler((if (unsubscribeCompletionHandler == null) null else new io.vertx.core.Handler[java.lang.Integer]{def handle(x: java.lang.Integer) {unsubscribeCompletionHandler.handle(x.asInstanceOf[Int])}}))
    this
  }

  /**
   * Unsubscribe from receiving messages on given topic   * @param topic Topic you want to unsubscribe from
   * @return current MQTT client instance
   */
  
  def unsubscribe(topic: String): MqttClient = {
    asJava.asInstanceOf[JMqttClient].unsubscribe(topic.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Unsubscribe from receiving messages on given topic   * @param topic Topic you want to unsubscribe from
   * @param unsubscribeSentHandler handler called after UNSUBSCRIBE packet sent
   * @return current MQTT client instance
   */
  
  def unsubscribe(topic: String, unsubscribeSentHandler: Handler[AsyncResult[Int]]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].unsubscribe(topic.asInstanceOf[java.lang.String], (if (unsubscribeSentHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.Integer]]{def handle(x: AsyncResult[java.lang.Integer]) {unsubscribeSentHandler.handle(AsyncResultWrapper[java.lang.Integer, Int](x, a => a.asInstanceOf[Int]))}}))
    this
  }

  /**
   * Sets handler which will be called after PINGRESP packet receiving   * @param pingResponseHandler handler to call
   * @return current MQTT client instance
   */
  
  def pingResponseHandler(pingResponseHandler: Handler[Unit]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].pingResponseHandler((if (pingResponseHandler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {pingResponseHandler.handle(x)}}))
    this
  }

  /**
   * Set an exception handler for the client, that will be called when an error happens
   * in internal netty structures.
   *
   * `io.netty.handler.codec.DecoderException` can be one of the cause   * @param handler the exception handler
   * @return current MQTT client instance
   */
  
  def exceptionHandler(handler: Handler[Throwable]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }

  /**
   * Set a handler that will be called when the connection with server is closed   * @param closeHandler handler to call
   * @return current MQTT client instance
   */
  
  def closeHandler(closeHandler: Handler[Unit]): MqttClient = {
    asJava.asInstanceOf[JMqttClient].closeHandler((if (closeHandler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {closeHandler.handle(x)}}))
    this
  }

  /**
   * This method is needed by the client in order to avoid server closes the
   * connection due to the keep alive timeout if client has no messages to send   * @return current MQTT client instance
   */
  
  def ping(): MqttClient = {
    asJava.asInstanceOf[JMqttClient].ping()
    this
  }



  /**
   * @return the client identifier
   */
  def clientId (): String = {
    asJava.asInstanceOf[JMqttClient].clientId().asInstanceOf[String]
  }

  /**
   * @return if the connection between client and remote server is established/open
   */
  def isConnected (): Boolean = {
    asJava.asInstanceOf[JMqttClient].isConnected().asInstanceOf[Boolean]
  }


 /**
  * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def connectFuture (port: Int, host: String): scala.concurrent.Future[MqttConnAckMessage] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMqttConnAckMessage, MqttConnAckMessage](x => MqttConnAckMessage(x))
    asJava.asInstanceOf[JMqttClient].connect(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def connectFuture (port: Int, host: String, serverName: String): scala.concurrent.Future[MqttConnAckMessage] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMqttConnAckMessage, MqttConnAckMessage](x => MqttConnAckMessage(x))
    asJava.asInstanceOf[JMqttClient].connect(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], serverName.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[disconnect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def disconnectFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMqttClient].disconnect(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[publish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def publishFuture (topic: String, payload: io.vertx.core.buffer.Buffer, qosLevel: io.netty.handler.codec.mqtt.MqttQoS, isDup: Boolean, isRetain: Boolean): scala.concurrent.Future[Int] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Integer, Int](x => x.asInstanceOf[Int])
    asJava.asInstanceOf[JMqttClient].publish(topic.asInstanceOf[java.lang.String], payload, qosLevel, isDup.asInstanceOf[java.lang.Boolean], isRetain.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def subscribeFuture (topic: String, qos: Int): scala.concurrent.Future[Int] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Integer, Int](x => x.asInstanceOf[Int])
    asJava.asInstanceOf[JMqttClient].subscribe(topic.asInstanceOf[java.lang.String], qos.asInstanceOf[java.lang.Integer], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def subscribeFuture (topics: scala.collection.mutable.Map[String, Int]): scala.concurrent.Future[Int] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Integer, Int](x => x.asInstanceOf[Int])
    asJava.asInstanceOf[JMqttClient].subscribe(topics.mapValues(x => x.asInstanceOf[java.lang.Integer]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[unsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def unsubscribeFuture (topic: String): scala.concurrent.Future[Int] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Integer, Int](x => x.asInstanceOf[Int])
    asJava.asInstanceOf[JMqttClient].unsubscribe(topic.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object MqttClient {
  def apply(asJava: JMqttClient) = new MqttClient(asJava)

  /**
   * Return an MQTT client instance   * @param vertx Vert.x instance
   * @param options MQTT client options see <a href="../../../../../../cheatsheet/MqttClientOptions.html">MqttClientOptions</a>
   * @return MQTT client instance
   */
  def create(vertx: Vertx,options: MqttClientOptions): MqttClient = {
    MqttClient(JMqttClient.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))//2 create
  }

  /**
   * Return an MQTT client instance using the default options   * @param vertx Vert.x instance
   * @return MQTT client instance
   */
  def create(vertx: Vertx): MqttClient = {
    MqttClient(JMqttClient.create(vertx.asJava.asInstanceOf[JVertx]))//2 create
  }

}
