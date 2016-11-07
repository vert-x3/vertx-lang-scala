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

package io.vertx.scala.ext.stomp

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.stomp.{Destination => JDestination}
import io.vertx.ext.stomp.{BridgeOptions => JBridgeOptions}
import io.vertx.scala.ext.stomp.BridgeOptions
import io.vertx.ext.stomp.{Frame => JFrame}
import io.vertx.scala.ext.stomp.Frame
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.core.shareddata.{Shareable => JShareable}
import io.vertx.ext.stomp.{StompServerConnection => JStompServerConnection}

/**
  * Represents a STOMP destination.
  * Depending on the implementation, the message delivery is different. Queue are sending message to only one
  * subscribers, while topics are broadcasting the message to all subscribers.
  * <p/>
  * Implementations <strong>must</strong> be thread-safe.
  */
class Destination(private val _asJava: JDestination) {

  def asJava: JDestination = _asJava

  /**
    * @return the destination address.
    */
  def destination(): String = {
    _asJava.destination()
  }

  /**
    * Dispatches the given frame.
    * @param connection the connection
    * @param frame the framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @return the current instance of [[Destination]]
    */
  def dispatch(connection: StompServerConnection, frame: Frame): Destination = {
    _asJava.dispatch(connection.asJava.asInstanceOf[JStompServerConnection], frame.asJava)
    this
  }

  /**
    * Handles a subscription request to the current [[io.vertx.scala.ext.stomp.Destination]].
    * @param connection the connection
    * @param frame the `SUBSCRIBE` framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @return the current instance of [[Destination]]
    */
  def subscribe(connection: StompServerConnection, frame: Frame): Destination = {
    _asJava.subscribe(connection.asJava.asInstanceOf[JStompServerConnection], frame.asJava)
    this
  }

  /**
    * Handles a un-subscription request to the current [[io.vertx.scala.ext.stomp.Destination]].
    * @param connection the connection
    * @param frame the `UNSUBSCRIBE` framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @return `true` if the un-subscription has been handled, `false` otherwise.
    */
  def unsubscribe(connection: StompServerConnection, frame: Frame): Boolean = {
    _asJava.unsubscribe(connection.asJava.asInstanceOf[JStompServerConnection], frame.asJava)
  }

  /**
    * Removes all subscriptions of the given connection
    * @param connection the connection
    * @return the current instance of [[Destination]]
    */
  def unsubscribeConnection(connection: StompServerConnection): Destination = {
    _asJava.unsubscribeConnection(connection.asJava.asInstanceOf[JStompServerConnection])
    this
  }

  /**
    * Handles a `ACK` frame.
    * @param connection the connection
    * @param frame the `ACK` framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @return `true` if the destination has handled the frame (meaning it has sent the message with id)
    */
  def ack(connection: StompServerConnection, frame: Frame): Boolean = {
    _asJava.ack(connection.asJava.asInstanceOf[JStompServerConnection], frame.asJava)
  }

  /**
    * Handles a `NACK` frame.
    * @param connection the connection
    * @param frame the `NACK` framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @return `true` if the destination has handled the frame (meaning it has sent the message with id)
    */
  def nack(connection: StompServerConnection, frame: Frame): Boolean = {
    _asJava.nack(connection.asJava.asInstanceOf[JStompServerConnection], frame.asJava)
  }

  /**
    * Gets all subscription ids for the given destination hold by the given client
    * @param connection the connection (client)
    * @return the list of subscription id, empty if none
    */
  def getSubscriptions(connection: StompServerConnection): scala.collection.mutable.Buffer[String] = {
    _asJava.getSubscriptions(connection.asJava.asInstanceOf[JStompServerConnection]).asScala.map(x => x:String)
  }

  /**
    * Gets the number of subscriptions attached to the current [[io.vertx.scala.ext.stomp.Destination]].
    * @return the number of subscriptions.
    */
  def numberOfSubscriptions(): Int = {
    _asJava.numberOfSubscriptions()
  }

  /**
    * Checks whether or not the given address matches with the current destination.
    * @param address the address
    * @return `true` if it matches, `false` otherwise.
    */
  def matches(address: String): Boolean = {
    _asJava.matches(address)
  }

}

object Destination {

  def apply(_asJava: JDestination): Destination =
    new Destination(_asJava)

  def topic(vertx: Vertx, destination: String): Destination = {
    Destination.apply(io.vertx.ext.stomp.Destination.topic(vertx.asJava.asInstanceOf[JVertx], destination))
  }

  def queue(vertx: Vertx, destination: String): Destination = {
    Destination.apply(io.vertx.ext.stomp.Destination.queue(vertx.asJava.asInstanceOf[JVertx], destination))
  }

  def bridge(vertx: Vertx, options: BridgeOptions): Destination = {
    Destination.apply(io.vertx.ext.stomp.Destination.bridge(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

}
