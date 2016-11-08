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
import io.vertx.ext.stomp.{Frames => JFrames}
import io.vertx.ext.stomp.{Frame => JFrame}
import io.vertx.scala.ext.stomp.Frame
import io.vertx.ext.stomp.{StompServerConnection => JStompServerConnection}

/**
  * Utility methods to build common <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>s. It defines a non-STOMP frame (`PING`) that is used for
  * heartbeats. When such frame is written on the wire it is just the `0` byte.
  * <p/>
  * This class is thread-safe.
  */
class Frames(private val _asJava: JFrames) {

  def asJava: JFrames = _asJava

}

object Frames {

  def apply(_asJava: JFrames): Frames =
    new Frames(_asJava)

  def createErrorFrame(message: String, headers: Map[String, String], body: String): Frame = {
    Frame(io.vertx.ext.stomp.Frames.createErrorFrame(message, headers.map(kv => (kv._1:java.lang.String, kv._2:java.lang.String)).asJava, body))
  }

  def createReceiptFrame(receiptId: String, headers: Map[String, String]): Frame = {
    Frame(io.vertx.ext.stomp.Frames.createReceiptFrame(receiptId, headers.map(kv => (kv._1:java.lang.String, kv._2:java.lang.String)).asJava))
  }

  def handleReceipt(frame: Frame, connection: StompServerConnection): Unit = {
    io.vertx.ext.stomp.Frames.handleReceipt(frame.asJava, connection.asJava.asInstanceOf[JStompServerConnection])
  }

  def ping(): Frame = {
    Frame(io.vertx.ext.stomp.Frames.ping())
  }

}
