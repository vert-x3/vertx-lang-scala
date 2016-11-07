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

package io.vertx.scala.rabbitmq

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.rabbitmq.{RabbitMQClient => JRabbitMQClient}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.core.json.JsonObject

/**
  */
class RabbitMQClient(private val _asJava: JRabbitMQClient) {

  def asJava: JRabbitMQClient = _asJava

  /**
    * Acknowledge one or several received messages. Supply the deliveryTag from the AMQP.Basic.GetOk or AMQP.Basic.Deliver
    * method containing the received message being acknowledged.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def basicAckFuture(deliveryTag: Long, multiple: Boolean): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.basicAck(deliveryTag, multiple, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Reject one or several received messages.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def basicNackFuture(deliveryTag: Long, multiple: Boolean, requeue: Boolean): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.basicNack(deliveryTag, multiple, requeue, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Retrieve a message from a queue using AMQP.Basic.Get
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def basicGetFuture(queue: String, autoAck: Boolean): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.basicGet(queue, autoAck, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Start a non-nolocal, non-exclusive consumer, with auto acknowledgement and a server-generated consumerTag.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def basicConsumeFuture(queue: String, address: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.basicConsume(queue, address, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Start a non-nolocal, non-exclusive consumer, with a server-generated consumerTag.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def basicConsumeFuture(queue: String, address: String, autoAck: Boolean): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.basicConsume(queue, address, autoAck, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Publish a message. Publishing to a non-existent exchange will result in a channel-level protocol exception,
    * which closes the channel. Invocations of Channel#basicPublish will eventually block if a resource-driven alarm is in effect.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def basicPublishFuture(exchange: String, routingKey: String, message: JsonObject): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.basicPublish(exchange, routingKey, message, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Request specific "quality of service" settings, Limiting the number of unacknowledged messages on
    * a channel (or connection). This limit is applied separately to each new consumer on the channel.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def basicQosFuture(prefetchCount: Int): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.basicQos(prefetchCount, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Declare an exchange.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def exchangeDeclareFuture(exchange: String, `type`: String, durable: Boolean, autoDelete: Boolean): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.exchangeDeclare(exchange, `type`, durable, autoDelete, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Declare an exchange with additional parameters such as dead lettering or an alternate exchnage.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def exchangeDeclareFuture(exchange: String, `type`: String, durable: Boolean, autoDelete: Boolean, config: Map[String, String]): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.exchangeDeclare(exchange, `type`, durable, autoDelete, config.map(kv => (kv._1:java.lang.String, kv._2:java.lang.String)).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Delete an exchange, without regard for whether it is in use or not.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def exchangeDeleteFuture(exchange: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.exchangeDelete(exchange, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Bind an exchange to an exchange.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def exchangeBindFuture(destination: String, source: String, routingKey: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.exchangeBind(destination, source, routingKey, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Unbind an exchange from an exchange.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def exchangeUnbindFuture(destination: String, source: String, routingKey: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.exchangeUnbind(destination, source, routingKey, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Actively declare a server-named exclusive, autodelete, non-durable queue.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def queueDeclareAutoFuture(): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.queueDeclareAuto(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Declare a queue
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def queueDeclareFuture(queue: String, durable: Boolean, exclusive: Boolean, autoDelete: Boolean): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.queueDeclare(queue, durable, exclusive, autoDelete, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Delete a queue, without regard for whether it is in use or has messages on it
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def queueDeleteFuture(queue: String): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.queueDelete(queue, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Delete a queue
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def queueDeleteIfFuture(queue: String, ifUnused: Boolean, ifEmpty: Boolean): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.queueDeleteIf(queue, ifUnused, ifEmpty, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Bind a queue to an exchange
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def queueBindFuture(queue: String, exchange: String, routingKey: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.queueBind(queue, exchange, routingKey, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Returns the number of messages in a queue ready to be delivered.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def messageCountFuture(queue: String): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.messageCount(queue, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Start the rabbitMQ client. Create the connection and the chanel.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def startFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.start(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Stop the rabbitMQ client. Close the connection and its chanel.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def stopFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.stop(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Check if a connection is open
    * @return true when the connection is open, false otherwise
    */
  def isConnected(): Boolean = {
    _asJava.isConnected()
  }

  /**
    * Check if a channel is open
    * @return true when the connection is open, false otherwise
    */
  def isOpenChannel(): Boolean = {
    _asJava.isOpenChannel()
  }

}

object RabbitMQClient {

  def apply(_asJava: JRabbitMQClient): RabbitMQClient =
    new RabbitMQClient(_asJava)

  def create(vertx: Vertx, config: JsonObject): RabbitMQClient = {
    RabbitMQClient.apply(io.vertx.rabbitmq.RabbitMQClient.create(vertx.asJava.asInstanceOf[JVertx], config))
  }

}
