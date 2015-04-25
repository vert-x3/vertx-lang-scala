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

package io.vertx.scala.core.eventbus;

import io.vertx.core.eventbus.DeliveryOptions
import io.vertx.scala.core.metrics.Measured
import scala.util.Try
import io.vertx.core.Handler

class EventBus(private val _asJava: io.vertx.core.eventbus.EventBus) 
    extends io.vertx.scala.core.metrics.Measured {

  def asJava: java.lang.Object = _asJava

  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  def send(address: String, message: AnyRef): io.vertx.scala.core.eventbus.EventBus = {
    _asJava.send(address, message)
    this
  }

  def send[T](address: String, message: AnyRef)(replyHandler: Try[io.vertx.scala.core.eventbus.Message[T]] => Unit): io.vertx.scala.core.eventbus.EventBus = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.send(address, message, funcToMappedAsyncResultHandler(Message.apply[T])(replyHandler))
    this
  }

  def send[T](address: String, message: AnyRef, options: io.vertx.core.eventbus.DeliveryOptions): io.vertx.scala.core.eventbus.EventBus = {
    _asJava.send(address, message, options)
    this
  }

  def send[T](address: String, message: AnyRef, options: io.vertx.core.eventbus.DeliveryOptions)(replyHandler: Try[io.vertx.scala.core.eventbus.Message[T]] => Unit): io.vertx.scala.core.eventbus.EventBus = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.send(address, message, options, funcToMappedAsyncResultHandler(Message.apply[T])(replyHandler))
    this
  }

  def publish(address: String, message: AnyRef): io.vertx.scala.core.eventbus.EventBus = {
    _asJava.publish(address, message)
    this
  }

  def publish(address: String, message: AnyRef, options: io.vertx.core.eventbus.DeliveryOptions): io.vertx.scala.core.eventbus.EventBus = {
    _asJava.publish(address, message, options)
    this
  }

  def consumer[T](address: String): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    MessageConsumer.apply[T](_asJava.consumer(address))
  }

  def consumer[T](address: String)(handler: io.vertx.scala.core.eventbus.Message[T] => Unit): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    MessageConsumer.apply[T](_asJava.consumer(address, funcToMappedHandler(Message.apply[T])(handler)))
  }

  def localConsumer[T](address: String): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    MessageConsumer.apply[T](_asJava.localConsumer(address))
  }

  def localConsumer[T](address: String)(handler: io.vertx.scala.core.eventbus.Message[T] => Unit): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    MessageConsumer.apply[T](_asJava.localConsumer(address, funcToMappedHandler(Message.apply[T])(handler)))
  }

  def sender[T](address: String): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    MessageProducer.apply[T](_asJava.sender(address))
  }

  def sender[T](address: String, options: io.vertx.core.eventbus.DeliveryOptions): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    MessageProducer.apply[T](_asJava.sender(address, options))
  }

  def publisher[T](address: String): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    MessageProducer.apply[T](_asJava.publisher(address))
  }

  def publisher[T](address: String, options: io.vertx.core.eventbus.DeliveryOptions): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    MessageProducer.apply[T](_asJava.publisher(address, options))
  }

  def close(completionHandler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.close(funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(completionHandler))
  }

}

object EventBus {

  def apply(_asJava: io.vertx.core.eventbus.EventBus): io.vertx.scala.core.eventbus.EventBus =
    new io.vertx.scala.core.eventbus.EventBus(_asJava)
}
