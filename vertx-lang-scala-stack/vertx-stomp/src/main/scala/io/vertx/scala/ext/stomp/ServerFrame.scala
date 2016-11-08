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
import io.vertx.ext.stomp.{ServerFrame => JServerFrame}
import io.vertx.ext.stomp.{Frame => JFrame}
import io.vertx.scala.ext.stomp.Frame
import io.vertx.ext.stomp.{StompServerConnection => JStompServerConnection}

/**
  * Structure passed to server handler when receiving a frame. It provides a reference on the received <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
  * but also on the [[io.vertx.scala.ext.stomp.StompServerConnection]].
  */
class ServerFrame(private val _asJava: JServerFrame) {

  def asJava: JServerFrame = _asJava

  /**
    * @return the received framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    */
  def frame(): Frame = {
    Frame(_asJava.frame())
  }

  /**
    * @return the connection
    */
  def connection(): StompServerConnection = {
    StompServerConnection.apply(_asJava.connection())
  }

}

object ServerFrame {

  def apply(_asJava: JServerFrame): ServerFrame =
    new ServerFrame(_asJava)

}
