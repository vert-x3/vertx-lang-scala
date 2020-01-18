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

import io.vertx.rabbitmq.{RabbitMQOptions => JRabbitMQOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * RabbitMQ client options, most
 */

class RabbitMQOptions(private val _asJava: JRabbitMQOptions) {
  def asJava = _asJava
  /**
   * Enables or disables automatic connection recovery.
   */
  def setAutomaticRecoveryEnabled(value: Boolean) = {
    asJava.setAutomaticRecoveryEnabled(value)
    this
  }

  def isAutomaticRecoveryEnabled: Boolean = {
    asJava.isAutomaticRecoveryEnabled().asInstanceOf[Boolean]
  }

  /**
   * Set the number of connection retries to attempt when connecting, the `null` value disables it.
   */
  def setConnectionRetries(value: Int) = {
    asJava.setConnectionRetries(value)
    this
  }

  def getConnectionRetries: Int = {
    asJava.getConnectionRetries().asInstanceOf[Int]
  }

  /**
   * Set the delay in milliseconds between connection retries.
   */
  def setConnectionRetryDelay(value: Long) = {
    asJava.setConnectionRetryDelay(value)
    this
  }

  def getConnectionRetryDelay: Long = {
    asJava.getConnectionRetryDelay().asInstanceOf[Long]
  }

  /**
   * Set the TCP connection timeout, in milliseconds, `zero` for infinite).
   */
  def setConnectionTimeout(value: Int) = {
    asJava.setConnectionTimeout(value)
    this
  }

  def getConnectionTimeout: Int = {
    asJava.getConnectionTimeout().asInstanceOf[Int]
  }

  /**
   * Set the AMQP 0-9-1 protocol handshake timeout, in milliseconds
   */
  def setHandshakeTimeout(value: Int) = {
    asJava.setHandshakeTimeout(value)
    this
  }

  def getHandshakeTimeout: Int = {
    asJava.getHandshakeTimeout().asInstanceOf[Int]
  }

  /**
   * Set the default host to use for connections.
   */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }

  def getHost: String = {
    asJava.getHost().asInstanceOf[String]
  }

  /**
   * Set wether to include properties when a broker message is passed on the event bus
   */
  def setIncludeProperties(value: Boolean) = {
    asJava.setIncludeProperties(value)
    this
  }

  def getIncludeProperties: Boolean = {
    asJava.getIncludeProperties().asInstanceOf[Boolean]
  }

  /**
   * Set how long in milliseconds will automatic recovery wait before attempting to reconnect, default is `5000`
   */
  def setNetworkRecoveryInterval(value: Long) = {
    asJava.setNetworkRecoveryInterval(value)
    this
  }

  def getNetworkRecoveryInterval: Long = {
    asJava.getNetworkRecoveryInterval().asInstanceOf[Long]
  }

  /**
   * Set the password to use when connecting to the broker.
   */
  def setPassword(value: String) = {
    asJava.setPassword(value)
    this
  }

  def getPassword: String = {
    asJava.getPassword().asInstanceOf[String]
  }

  /**
   * Set the default port to use for connections.
   */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }

  def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }

  /**
   * Set the initially requested maximum channel number, `zero` for unlimited.
   */
  def setRequestedChannelMax(value: Int) = {
    asJava.setRequestedChannelMax(value)
    this
  }

  def getRequestedChannelMax: Int = {
    asJava.getRequestedChannelMax().asInstanceOf[Int]
  }

  /**
   * Set the initially requested heartbeat interval, in seconds, `zero` for none.
   */
  def setRequestedHeartbeat(value: Int) = {
    asJava.setRequestedHeartbeat(value)
    this
  }

  def getRequestedHeartbeat: Int = {
    asJava.getRequestedHeartbeat().asInstanceOf[Int]
  }

  def setUri(value: String) = {
    asJava.setUri(value)
    this
  }

  def getUri: String = {
    asJava.getUri().asInstanceOf[String]
  }

  /**
   * Set the AMQP user name to use when connecting to the broker.
   */
  def setUser(value: String) = {
    asJava.setUser(value)
    this
  }

  def getUser: String = {
    asJava.getUser().asInstanceOf[String]
  }

  /**
   * Set the virtual host to use when connecting to the broker.
   */
  def setVirtualHost(value: String) = {
    asJava.setVirtualHost(value)
    this
  }

  def getVirtualHost: String = {
    asJava.getVirtualHost().asInstanceOf[String]
  }

}


object RabbitMQOptions {

  def apply() = {
    new RabbitMQOptions(new JRabbitMQOptions(emptyObj()))
  }

  def apply(t: JRabbitMQOptions) = {
    if (t != null) {
      new RabbitMQOptions(t)
    } else {
      new RabbitMQOptions(new JRabbitMQOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): RabbitMQOptions = {
    if (json != null) {
      new RabbitMQOptions(new JRabbitMQOptions(json))
    } else {
      new RabbitMQOptions(new JRabbitMQOptions(emptyObj()))
    }
  }
}

