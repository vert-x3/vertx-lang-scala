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

import io.vertx.ext.stomp.{Frames => JFrames}
import io.vertx.ext.stomp.{Frame => JFrame}
import scala.reflect.runtime.universe._
import io.vertx.ext.stomp.{StompServerConnection => JStompServerConnection}
import scala.collection.JavaConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Utility methods to build common <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>s. It defines a non-STOMP frame (`PING`) that is used for
  * heartbeats. When such frame is written on the wire it is just the `0` byte.
  * <p/>
  * This class is thread-safe.
  */

class Frames(private val _asJava: Object) {
  def asJava = _asJava






}

object Frames {
  def apply(asJava: JFrames) = new Frames(asJava)


  def createErrorFrame(message: String,headers: scala.collection.mutable.Map[String, String],body: String): Frame = {
    Frame(JFrames.createErrorFrame(message.asInstanceOf[java.lang.String], headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, body.asInstanceOf[java.lang.String]))//2 createErrorFrame
  }


  def createReceiptFrame(receiptId: String,headers: scala.collection.mutable.Map[String, String]): Frame = {
    Frame(JFrames.createReceiptFrame(receiptId.asInstanceOf[java.lang.String], headers.mapValues(x => x.asInstanceOf[java.lang.String]).asJava))//2 createReceiptFrame
  }


  def handleReceipt(frame: Frame,connection: StompServerConnection): Unit = {
    JFrames.handleReceipt(frame.asJava, connection.asJava.asInstanceOf[JStompServerConnection])//2 handleReceipt
  }


  def ping(): Frame = {
    Frame(JFrames.ping())//2 ping
  }

}
