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
import io.vertx.ext.stomp.{StompServerConnection => JStompServerConnection}
  import io.vertx.ext.stomp.{StompServerHandler => JStompServerHandler}
  import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
  import io.vertx.ext.stomp.{Frame => JFrame}
  import io.vertx.ext.stomp.{StompServer => JStompServer}
      import io.vertx.ext.stomp.{StompServerConnection => JStompServerConnection}

/**
  * Class representing a connection between a STOMP client a the server. It keeps a references on the client socket,
  * so let write to this socket.
  */
class StompServerConnection(private val _asJava: JStompServerConnection) {

  def asJava: JStompServerConnection = _asJava

  /**
    * Writes the given frame to the socket.
    * @param frame the frame, must not be `null`.see <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    * @return the current [[StompServerConnection]]
    */
  def write(frame: Frame): StompServerConnection = {
    _asJava.write(frame.asJava)
    this
  }

  /**
    * Writes the given buffer to the socket. This is a low level API that should be used carefully.
    * @param buffer the buffer
    * @return the current [[StompServerConnection]]
    */
  def write(buffer: Buffer): StompServerConnection = {
    _asJava.write(buffer.asJava.asInstanceOf[JBuffer])
    this
  }

  /**
    * @return the STOMP server serving this connection.
    */
  def server(): StompServer = {
    StompServer.apply(_asJava.server())
  }

  /**
    * @return the STOMP server handler dealing with this connection
    */
  def handler(): StompServerHandler = {
    StompServerHandler.apply(_asJava.handler())
  }

  /**
    * @return the STOMP session id computed when the client has established the connection to the server
    */
  def session(): String = {
    _asJava.session()
  }

  /**
    * Closes the connection with the client.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Sends a `PING` frame to the client. A `PING` frame is a frame containing only `EOL`.
    */
  def ping(): Unit = {
    _asJava.ping()
  }

  /**
    * Notifies the connection about server activity (the server has sent a frame). This method is used to handle the
    * heartbeat.
    */
  def onServerActivity(): Unit = {
    _asJava.onServerActivity()
  }

  /**
    * Configures the heartbeat.
    * @param ping ping time
    * @param pong pong time
    * @param pingHandler the ping handler
    */
  def configureHeartbeat(ping: Long, pong: Long, pingHandler: StompServerConnection => Unit): Unit = {
    _asJava.configureHeartbeat(ping, pong, funcToMappedHandler(StompServerConnection.apply)(pingHandler))
  }

}

object StompServerConnection {

  def apply(_asJava: JStompServerConnection): StompServerConnection =
    new StompServerConnection(_asJava)

}
