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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.mqtt.messages.{MqttSubscribeMessage => JMqttSubscribeMessage}
import io.netty.handler.codec.mqtt.MqttQoS
import io.vertx.mqtt.{MqttEndpoint => JMqttEndpoint}
import io.netty.handler.codec.mqtt.MqttConnectReturnCode
import io.vertx.scala.mqtt.messages.MqttSubscribeMessage
import io.vertx.scala.mqtt.messages.MqttPublishMessage
import io.vertx.mqtt.{MqttWill => JMqttWill}
import io.vertx.mqtt.messages.{MqttPublishMessage => JMqttPublishMessage}
import io.vertx.mqtt.{MqttAuth => JMqttAuth}
import scala.collection.JavaConverters._
import io.vertx.core.buffer.Buffer
import io.vertx.scala.mqtt.messages.MqttUnsubscribeMessage
import io.vertx.core.Handler
import io.vertx.mqtt.messages.{MqttUnsubscribeMessage => JMqttUnsubscribeMessage}

/**
  * Represents an MQTT endpoint for point-to-point communication with the remote MQTT client
  */
class MqttEndpoint(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0: String = _
  private var cached_1: MqttAuth = _
  private var cached_2: MqttWill = _
  private var cached_3: Int = _
  private var cached_4: String = _
  private var cached_5: Boolean = _
  private var cached_6: Int = _
  private var cached_7: Int = _

  /**
    * Client identifier as provided by the remote MQTT client
    * @return 
    */
  def clientIdentifier(): String = {
    if (cached_0 == null) {
      val tmp = asJava.asInstanceOf[JMqttEndpoint].clientIdentifier()
      cached_0 = tmp.asInstanceOf[String]
    }
    cached_0
  }

  /**
    * Authentication information as provided by the remote MQTT client
    * @return 
    */
  def auth(): MqttAuth = {
    if (cached_1 == null) {
      val tmp = asJava.asInstanceOf[JMqttEndpoint].auth()
      cached_1 = MqttAuth(tmp)
    }
    cached_1
  }

  /**
    * Will information as provided by the remote MQTT client
    * @return 
    */
  def will(): MqttWill = {
    if (cached_2 == null) {
      val tmp = asJava.asInstanceOf[JMqttEndpoint].will()
      cached_2 = MqttWill(tmp)
    }
    cached_2
  }

  /**
    * Protocol version required by the remote MQTT client
    * @return 
    */
  def protocolVersion(): Int = {
    if (cached_3 == null) {
      val tmp = asJava.asInstanceOf[JMqttEndpoint].protocolVersion()
      cached_3 = tmp.asInstanceOf[Int]
    }
    cached_3
  }

  /**
    * Protocol name provided by the remote MQTT client
    * @return 
    */
  def protocolName(): String = {
    if (cached_4 == null) {
      val tmp = asJava.asInstanceOf[JMqttEndpoint].protocolName()
      cached_4 = tmp.asInstanceOf[String]
    }
    cached_4
  }

  /**
    * If clean session is requested by the remote MQTT client
    * @return 
    */
  def isCleanSession(): Boolean = {
    if (cached_5 == null) {
      val tmp = asJava.asInstanceOf[JMqttEndpoint].isCleanSession()
      cached_5 = tmp.asInstanceOf[Boolean]
    }
    cached_5
  }

  /**
    * Keep alive timeout (in seconds) specified by the remote MQTT client
    * @return 
    */
  def keepAliveTimeSeconds(): Int = {
    if (cached_6 == null) {
      val tmp = asJava.asInstanceOf[JMqttEndpoint].keepAliveTimeSeconds()
      cached_6 = tmp.asInstanceOf[Int]
    }
    cached_6
  }

  /**
    * Message identifier used for last published message
    * @return 
    */
  def lastMessageId(): Int = {
    if (cached_7 == null) {
      val tmp = asJava.asInstanceOf[JMqttEndpoint].lastMessageId()
      cached_7 = tmp.asInstanceOf[Int]
    }
    cached_7
  }

  /**
    * Enable/disable publishing (in/out) auto acknowledge
    * @param isPublishAutoAck auto acknowledge status
    * @return a reference to this, so the API can be used fluently
    */
  def publishAutoAck(isPublishAutoAck: Boolean): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].publishAutoAck(isPublishAutoAck.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Enable/disable auto keep alive (sending ping response)
    * @param isAutoKeepAlive auto keep alive
    * @return a reference to this, so the API can be used fluently
    */
  def autoKeepAlive(isAutoKeepAlive: Boolean): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].autoKeepAlive(isAutoKeepAlive.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Set a disconnect handler on the MQTT endpoint. This handler is called when a DISCONNECT
    * message is received by the remote MQTT client
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def disconnectHandler(handler: Handler[Unit]): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].disconnectHandler({x: Void => handler.handle(x)})
    this
  }

  /**
    * Set a subscribe handler on the MQTT endpoint. This handler is called when a SUBSCRIBE
    * message is received by the remote MQTT client
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def subscribeHandler(handler: Handler[MqttSubscribeMessage]): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].subscribeHandler({x: JMqttSubscribeMessage => handler.handle(MqttSubscribeMessage(x))})
    this
  }

  /**
    * Set a unsubscribe handler on the MQTT endpoint. This handler is called when a UNSUBSCRIBE
    * message is received by the remote MQTT client
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def unsubscribeHandler(handler: Handler[MqttUnsubscribeMessage]): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].unsubscribeHandler({x: JMqttUnsubscribeMessage => handler.handle(MqttUnsubscribeMessage(x))})
    this
  }

  /**
    * Set the publish handler on the MQTT endpoint. This handler is called when a PUBLISH
    * message is received by the remote MQTT client
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def publishHandler(handler: Handler[MqttPublishMessage]): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].publishHandler({x: JMqttPublishMessage => handler.handle(MqttPublishMessage(x))})
    this
  }

  /**
    * Set the puback handler on the MQTT endpoint. This handler is called when a PUBACK
    * message is received by the remote MQTT client
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def publishAcknowledgeHandler(handler: Handler[Int]): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].publishAcknowledgeHandler({x: java.lang.Integer => handler.handle(x.asInstanceOf[Int])})
    this
  }

  /**
    * Set the pubrec handler on the MQTT endpoint. This handler is called when a PUBREC
    * message is received by the remote MQTT client
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def publishReceivedHandler(handler: Handler[Int]): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].publishReceivedHandler({x: java.lang.Integer => handler.handle(x.asInstanceOf[Int])})
    this
  }

  /**
    * Set the pubrel handler on the MQTT endpoint. This handler is called when a PUBREL
    * message is received by the remote MQTT client
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def publishReleaseHandler(handler: Handler[Int]): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].publishReleaseHandler({x: java.lang.Integer => handler.handle(x.asInstanceOf[Int])})
    this
  }

  /**
    * Set the pubcomp handler on the MQTT endpoint. This handler is called when a PUBCOMP
    * message is received by the remote MQTT client
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def publishCompleteHandler(handler: Handler[Int]): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].publishCompleteHandler({x: java.lang.Integer => handler.handle(x.asInstanceOf[Int])})
    this
  }

  /**
    * Set the pingreq handler on the MQTT endpoint. This handler is called when a PINGREQ
    * message is received by the remote MQTT client. In any case the endpoint sends the
    * PINGRESP internally after executing this handler.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def pingHandler(handler: Handler[Unit]): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].pingHandler({x: Void => handler.handle(x)})
    this
  }

  /**
    * Set a close handler. This will be called when the MQTT endpoint is closed
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def closeHandler(handler: Handler[Unit]): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].closeHandler({x: Void => handler.handle(x)})
    this
  }

  /**
    * Sends the CONNACK message to the remote MQTT client with "connection accepted"
    * return code. See [[io.vertx.scala.mqtt.MqttEndpoint#reject]] for refusing connection
    * @param sessionPresent if a previous session is present
    * @return a reference to this, so the API can be used fluently
    */
  def accept(sessionPresent: Boolean): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].accept(sessionPresent.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Sends the CONNACK message to the remote MQTT client rejecting the connection
    * request with specified return code. See [[io.vertx.scala.mqtt.MqttEndpoint#accept]] for accepting connection
    * @param returnCode the connect return code
    * @return a reference to this, so the API can be used fluently
    */
  def reject(returnCode: io.netty.handler.codec.mqtt.MqttConnectReturnCode): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].reject(returnCode)
    this
  }

  /**
    * Sends the SUBACK message to the remote MQTT client
    * @param subscribeMessageId identifier of the SUBSCRIBE message to acknowledge
    * @param grantedQoSLevels granted QoS levels for the requested topics
    * @return a reference to this, so the API can be used fluently
    */
  def subscribeAcknowledge(subscribeMessageId: Int, grantedQoSLevels: scala.collection.mutable.Buffer[Int]): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].subscribeAcknowledge(subscribeMessageId.asInstanceOf[java.lang.Integer], grantedQoSLevels.map(x => x.asInstanceOf[java.lang.Integer]).asJava)
    this
  }

  /**
    * Sends the UNSUBACK message to the remote MQTT client
    * @param unsubscribeMessageId identifier of the UNSUBSCRIBE message to acknowledge
    * @return a reference to this, so the API can be used fluently
    */
  def unsubscribeAcknowledge(unsubscribeMessageId: Int): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].unsubscribeAcknowledge(unsubscribeMessageId.asInstanceOf[java.lang.Integer])
    this
  }

  /**
    * Sends the PUBACK message to the remote MQTT client
    * @param publishMessageId identifier of the PUBLISH message to acknowledge
    * @return a reference to this, so the API can be used fluently
    */
  def publishAcknowledge(publishMessageId: Int): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].publishAcknowledge(publishMessageId.asInstanceOf[java.lang.Integer])
    this
  }

  /**
    * Sends the PUBREC message to the remote MQTT client
    * @param publishMessageId identifier of the PUBLISH message to acknowledge
    * @return a reference to this, so the API can be used fluently
    */
  def publishReceived(publishMessageId: Int): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].publishReceived(publishMessageId.asInstanceOf[java.lang.Integer])
    this
  }

  /**
    * Sends the PUBREL message to the remote MQTT client
    * @param publishMessageId identifier of the PUBLISH message to acknowledge
    * @return a reference to this, so the API can be used fluently
    */
  def publishRelease(publishMessageId: Int): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].publishRelease(publishMessageId.asInstanceOf[java.lang.Integer])
    this
  }

  /**
    * Sends the PUBCOMP message to the remote MQTT client
    * @param publishMessageId identifier of the PUBLISH message to acknowledge
    * @return a reference to this, so the API can be used fluently
    */
  def publishComplete(publishMessageId: Int): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].publishComplete(publishMessageId.asInstanceOf[java.lang.Integer])
    this
  }

  /**
    * Sends the PUBLISH message to the remote MQTT client
    * @param topic topic on which the message is published
    * @param payload message payload
    * @param qosLevel quality of service level
    * @param isDup if the message is a duplicate
    * @param isRetain if the message needs to be retained
    * @return a reference to this, so the API can be used fluently
    */
  def publish(topic: String, payload: io.vertx.core.buffer.Buffer, qosLevel: io.netty.handler.codec.mqtt.MqttQoS, isDup: Boolean, isRetain: Boolean): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].publish(topic.asInstanceOf[java.lang.String], payload, qosLevel, isDup.asInstanceOf[java.lang.Boolean], isRetain.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Sends the PINGRESP message to the remote MQTT client
    * @return a reference to this, so the API can be used fluently
    */
  def pong(): MqttEndpoint = {
    asJava.asInstanceOf[JMqttEndpoint].pong()
    this
  }

  /**
    * Close the endpoint, so the connection with remote MQTT client
    */
  def close(): Unit = {
    asJava.asInstanceOf[JMqttEndpoint].close()
  }

  /**
    * Enable/disable subscription/unsubscription requests auto acknowledge
    * @param isSubscriptionAutoAck auto acknowledge status
    */
  def subscriptionAutoAck(isSubscriptionAutoAck: Boolean): Unit = {
    asJava.asInstanceOf[JMqttEndpoint].subscriptionAutoAck(isSubscriptionAutoAck.asInstanceOf[java.lang.Boolean])
  }

  /**
    * Return auto acknowledge status for subscription/unsubscription requests
    * @return 
    */
  def isSubscriptionAutoAck(): Boolean = {
    asJava.asInstanceOf[JMqttEndpoint].isSubscriptionAutoAck().asInstanceOf[Boolean]
  }

  /**
    * @return auto acknowledge status for publishing (in/out)
    */
  def isPublishAutoAck(): Boolean = {
    asJava.asInstanceOf[JMqttEndpoint].isPublishAutoAck().asInstanceOf[Boolean]
  }

  /**
    * Return auto keep alive status (sending ping response)
    * @return 
    */
  def isAutoKeepAlive(): Boolean = {
    asJava.asInstanceOf[JMqttEndpoint].isAutoKeepAlive().asInstanceOf[Boolean]
  }

}

object MqttEndpoint {
  def apply(asJava: JMqttEndpoint) = new MqttEndpoint(asJava)  
}
