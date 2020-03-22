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

package io.vertx.scala

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.mqtt.{MqttEndpoint => JMqttEndpoint}
import io.vertx.core
import io.vertx.mqtt.{MqttServerOptions => JMqttServerOptions}
import io.vertx.core.{Future => JFuture}
import io.vertx.mqtt.{MqttServer => JMqttServer}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.{Vertx => JVertx}

package object mqtt{


  type MqttAuth = io.vertx.mqtt.MqttAuth
  object MqttAuth {
    
    def apply(json: JsonObject) = new MqttAuth(json)
  }




  /**
    * An MQTT client

    */

  implicit class MqttClientScala(val asJava: io.vertx.mqtt.MqttClient) extends AnyVal {

    /**
     * Like connect from [[io.vertx.mqtt.MqttClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def connectFuture(port: java.lang.Integer,host: java.lang.String) : scala.concurrent.Future[io.vertx.mqtt.messages.MqttConnAckMessage] = {
      val promise = concurrent.Promise[io.vertx.mqtt.messages.MqttConnAckMessage]()
      asJava.connect(port, host, new Handler[AsyncResult[io.vertx.mqtt.messages.MqttConnAckMessage]] { override def handle(event: AsyncResult[io.vertx.mqtt.messages.MqttConnAckMessage]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like connect from [[io.vertx.mqtt.MqttClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def connectFuture(port: java.lang.Integer,host: java.lang.String,serverName: java.lang.String) : scala.concurrent.Future[io.vertx.mqtt.messages.MqttConnAckMessage] = {
      val promise = concurrent.Promise[io.vertx.mqtt.messages.MqttConnAckMessage]()
      asJava.connect(port, host, serverName, new Handler[AsyncResult[io.vertx.mqtt.messages.MqttConnAckMessage]] { override def handle(event: AsyncResult[io.vertx.mqtt.messages.MqttConnAckMessage]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like disconnect from [[io.vertx.mqtt.MqttClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def disconnectFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.disconnect(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like publish from [[io.vertx.mqtt.MqttClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def publishFuture(topic: java.lang.String,payload: io.vertx.core.buffer.Buffer,qosLevel: io.netty.handler.codec.mqtt.MqttQoS,isDup: java.lang.Boolean,isRetain: java.lang.Boolean) : scala.concurrent.Future[java.lang.Integer] = {
      val promise = concurrent.Promise[java.lang.Integer]()
      asJava.publish(topic, payload, qosLevel, isDup, isRetain, new Handler[AsyncResult[java.lang.Integer]] { override def handle(event: AsyncResult[java.lang.Integer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like subscribe from [[io.vertx.mqtt.MqttClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def subscribeFuture(topic: java.lang.String,qos: java.lang.Integer) : scala.concurrent.Future[java.lang.Integer] = {
      val promise = concurrent.Promise[java.lang.Integer]()
      asJava.subscribe(topic, qos, new Handler[AsyncResult[java.lang.Integer]] { override def handle(event: AsyncResult[java.lang.Integer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like subscribe from [[io.vertx.mqtt.MqttClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def subscribeFuture(topics: java.util.Map[String, java.lang.Integer]) : scala.concurrent.Future[java.lang.Integer] = {
      val promise = concurrent.Promise[java.lang.Integer]()
      asJava.subscribe(topics, new Handler[AsyncResult[java.lang.Integer]] { override def handle(event: AsyncResult[java.lang.Integer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like unsubscribe from [[io.vertx.mqtt.MqttClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def unsubscribeFuture(topic: java.lang.String) : scala.concurrent.Future[java.lang.Integer] = {
      val promise = concurrent.Promise[java.lang.Integer]()
      asJava.unsubscribe(topic, new Handler[AsyncResult[java.lang.Integer]] { override def handle(event: AsyncResult[java.lang.Integer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }



  type MqttClientOptions = io.vertx.mqtt.MqttClientOptions
  object MqttClientOptions {
    def apply() = new MqttClientOptions()
    def apply(json: JsonObject) = new MqttClientOptions(json)
  }



  object MqttConnAckMessage {
    /**
     * Create a concrete instance of a Vert.x connack message     * @param code return code from the connection request
     * @param isSessionPresent is an old session is present
     * @return 
     */
def create(code: io.netty.handler.codec.mqtt.MqttConnectReturnCode,isSessionPresent: java.lang.Boolean) = {
      io.vertx.mqtt.messages.MqttConnAckMessage.create(code, isSessionPresent)
}
  }



  /**
    * Represents an MQTT endpoint for point-to-point communication with the remote MQTT client

    */

  implicit class MqttEndpointScala(val asJava: io.vertx.mqtt.MqttEndpoint) extends AnyVal {

    /**
     * Like publish from [[io.vertx.mqtt.MqttEndpoint]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def publishFuture(topic: java.lang.String,payload: io.vertx.core.buffer.Buffer,qosLevel: io.netty.handler.codec.mqtt.MqttQoS,isDup: java.lang.Boolean,isRetain: java.lang.Boolean) : scala.concurrent.Future[java.lang.Integer] = {
      val promise = concurrent.Promise[java.lang.Integer]()
      asJava.publish(topic, payload, qosLevel, isDup, isRetain, new Handler[AsyncResult[java.lang.Integer]] { override def handle(event: AsyncResult[java.lang.Integer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like publish from [[io.vertx.mqtt.MqttEndpoint]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def publishFuture(topic: java.lang.String,payload: io.vertx.core.buffer.Buffer,qosLevel: io.netty.handler.codec.mqtt.MqttQoS,isDup: java.lang.Boolean,isRetain: java.lang.Boolean,messageId: java.lang.Integer) : scala.concurrent.Future[java.lang.Integer] = {
      val promise = concurrent.Promise[java.lang.Integer]()
      asJava.publish(topic, payload, qosLevel, isDup, isRetain, messageId, new Handler[AsyncResult[java.lang.Integer]] { override def handle(event: AsyncResult[java.lang.Integer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }







  /**
    * An MQTT server
    * 
    *    You can accept incoming MQTT connection requests providing a [[io.vertx.mqtt.MqttServer#endpointHandler]]. As the
    *    requests arrive, the handler will be called with an instance of [[io.vertx.mqtt.MqttEndpoint]] in order to manage the
    *    communication with the remote MQTT client.
    * </p>

    */

  implicit class MqttServerScala(val asJava: io.vertx.mqtt.MqttServer) extends AnyVal {

    /**
     * Like listen from [[io.vertx.mqtt.MqttServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def listenFuture(port: java.lang.Integer,host: java.lang.String) : scala.concurrent.Future[io.vertx.mqtt.MqttServer] = {
      val promise = concurrent.Promise[io.vertx.mqtt.MqttServer]()
      asJava.listen(port, host, new Handler[AsyncResult[io.vertx.mqtt.MqttServer]] { override def handle(event: AsyncResult[io.vertx.mqtt.MqttServer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like listen from [[io.vertx.mqtt.MqttServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def listenFuture(port: java.lang.Integer) : scala.concurrent.Future[io.vertx.mqtt.MqttServer] = {
      val promise = concurrent.Promise[io.vertx.mqtt.MqttServer]()
      asJava.listen(port, new Handler[AsyncResult[io.vertx.mqtt.MqttServer]] { override def handle(event: AsyncResult[io.vertx.mqtt.MqttServer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like listen from [[io.vertx.mqtt.MqttServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def listenFuture() : scala.concurrent.Future[io.vertx.mqtt.MqttServer] = {
      val promise = concurrent.Promise[io.vertx.mqtt.MqttServer]()
      asJava.listen(new Handler[AsyncResult[io.vertx.mqtt.MqttServer]] { override def handle(event: AsyncResult[io.vertx.mqtt.MqttServer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like close from [[io.vertx.mqtt.MqttServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def closeFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }



  type MqttServerOptions = io.vertx.mqtt.MqttServerOptions
  object MqttServerOptions {
    def apply() = new MqttServerOptions()
    def apply(json: JsonObject) = new MqttServerOptions(json)
  }












  type MqttWill = io.vertx.mqtt.MqttWill
  object MqttWill {
    
    def apply(json: JsonObject) = new MqttWill(json)
  }



}
