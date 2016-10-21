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
import io.vertx.ext.stomp.Frame

/**
  * Utility methods to build common <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>s. It defines a non-STOMP frame (`PING`) that is used for
  * heartbeats. When such frame is written on the wire it is just the `0` byte.
  * <p/>
  * This class is thread-safe.
  */
class Frames(private val _asJava: io.vertx.ext.stomp.Frames) {

  def asJava: io.vertx.ext.stomp.Frames = _asJava

}

object Frames {

  def apply(_asJava: io.vertx.ext.stomp.Frames): io.vertx.scala.ext.stomp.Frames =
    new io.vertx.scala.ext.stomp.Frames(_asJava)

  def createErrorFrame(message: String, headers: Map[String, String], body: String): io.vertx.scala.ext.stomp.Frame = {
    io.vertx.scala.ext.stomp.Frame(io.vertx.ext.stomp.Frames.createErrorFrame(message, headers.map(kv => (kv._1:java.lang.String, kv._2:java.lang.String)).asJava, body))
  }

  def createReceiptFrame(receiptId: String, headers: Map[String, String]): io.vertx.scala.ext.stomp.Frame = {
    io.vertx.scala.ext.stomp.Frame(io.vertx.ext.stomp.Frames.createReceiptFrame(receiptId, headers.map(kv => (kv._1:java.lang.String, kv._2:java.lang.String)).asJava))
  }

  def handleReceipt(frame: io.vertx.scala.ext.stomp.Frame, connection: io.vertx.scala.ext.stomp.StompServerConnection): Unit = {
    io.vertx.ext.stomp.Frames.handleReceipt(frame.asJava, connection.asJava.asInstanceOf[io.vertx.ext.stomp.StompServerConnection])
  }

  def ping(): io.vertx.scala.ext.stomp.Frame = {
    io.vertx.scala.ext.stomp.Frame(io.vertx.ext.stomp.Frames.ping())
  }

}
