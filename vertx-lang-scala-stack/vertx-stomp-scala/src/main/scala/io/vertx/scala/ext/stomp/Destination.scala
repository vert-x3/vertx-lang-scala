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
import io.vertx.ext.stomp.BridgeOptions
import io.vertx.ext.stomp.Frame
import io.vertx.scala.core.Vertx
import io.vertx.core.shareddata.Shareable

/**
  * Represents a STOMP destination.
  * Depending on the implementation, the message delivery is different. Queue are sending message to only one
  * subscribers, while topics are broadcasting the message to all subscribers.
  * <p/>
  * Implementations <strong>must</strong> be thread-safe.
  */
class Destination(private val _asJava: io.vertx.ext.stomp.Destination) {

  def asJava: io.vertx.ext.stomp.Destination = _asJava

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
  def dispatch(connection: io.vertx.scala.ext.stomp.StompServerConnection, frame: io.vertx.scala.ext.stomp.Frame): io.vertx.scala.ext.stomp.Destination = {
    _asJava.dispatch(connection.asJava.asInstanceOf[io.vertx.ext.stomp.StompServerConnection], frame.asJava)
    this
  }

  /**
    * Handles a subscription request to the current [[io.vertx.scala.ext.stomp.Destination]].
    * @param connection the connection
    * @param frame the `SUBSCRIBE` framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @return the current instance of [[Destination]]
    */
  def subscribe(connection: io.vertx.scala.ext.stomp.StompServerConnection, frame: io.vertx.scala.ext.stomp.Frame): io.vertx.scala.ext.stomp.Destination = {
    _asJava.subscribe(connection.asJava.asInstanceOf[io.vertx.ext.stomp.StompServerConnection], frame.asJava)
    this
  }

  /**
    * Handles a un-subscription request to the current [[io.vertx.scala.ext.stomp.Destination]].
    * @param connection the connection
    * @param frame the `UNSUBSCRIBE` framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @return `true` if the un-subscription has been handled, `false` otherwise.
    */
  def unsubscribe(connection: io.vertx.scala.ext.stomp.StompServerConnection, frame: io.vertx.scala.ext.stomp.Frame): Boolean = {
    _asJava.unsubscribe(connection.asJava.asInstanceOf[io.vertx.ext.stomp.StompServerConnection], frame.asJava)
  }

  /**
    * Removes all subscriptions of the given connection
    * @param connection the connection
    * @return the current instance of [[Destination]]
    */
  def unsubscribeConnection(connection: io.vertx.scala.ext.stomp.StompServerConnection): io.vertx.scala.ext.stomp.Destination = {
    _asJava.unsubscribeConnection(connection.asJava.asInstanceOf[io.vertx.ext.stomp.StompServerConnection])
    this
  }

  /**
    * Handles a `ACK` frame.
    * @param connection the connection
    * @param frame the `ACK` framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @return `true` if the destination has handled the frame (meaning it has sent the message with id)
    */
  def ack(connection: io.vertx.scala.ext.stomp.StompServerConnection, frame: io.vertx.scala.ext.stomp.Frame): Boolean = {
    _asJava.ack(connection.asJava.asInstanceOf[io.vertx.ext.stomp.StompServerConnection], frame.asJava)
  }

  /**
    * Handles a `NACK` frame.
    * @param connection the connection
    * @param frame the `NACK` framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @return `true` if the destination has handled the frame (meaning it has sent the message with id)
    */
  def nack(connection: io.vertx.scala.ext.stomp.StompServerConnection, frame: io.vertx.scala.ext.stomp.Frame): Boolean = {
    _asJava.nack(connection.asJava.asInstanceOf[io.vertx.ext.stomp.StompServerConnection], frame.asJava)
  }

  /**
    * Gets all subscription ids for the given destination hold by the given client
    * @param connection the connection (client)
    * @return the list of subscription id, empty if none
    */
  def getSubscriptions(connection: io.vertx.scala.ext.stomp.StompServerConnection): scala.collection.mutable.Buffer[String] = {
    _asJava.getSubscriptions(connection.asJava.asInstanceOf[io.vertx.ext.stomp.StompServerConnection]).asScala.map(x => x:String)
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

  def apply(_asJava: io.vertx.ext.stomp.Destination): io.vertx.scala.ext.stomp.Destination =
    new io.vertx.scala.ext.stomp.Destination(_asJava)

  def topic(vertx: io.vertx.scala.core.Vertx, destination: String): io.vertx.scala.ext.stomp.Destination = {
    Destination.apply(io.vertx.ext.stomp.Destination.topic(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], destination))
  }

  def queue(vertx: io.vertx.scala.core.Vertx, destination: String): io.vertx.scala.ext.stomp.Destination = {
    Destination.apply(io.vertx.ext.stomp.Destination.queue(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], destination))
  }

  def bridge(vertx: io.vertx.scala.core.Vertx, options: io.vertx.scala.ext.stomp.BridgeOptions): io.vertx.scala.ext.stomp.Destination = {
    Destination.apply(io.vertx.ext.stomp.Destination.bridge(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], options.asJava))
  }

}
