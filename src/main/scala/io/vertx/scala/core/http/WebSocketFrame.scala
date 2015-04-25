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

package io.vertx.scala.core.http;

import io.vertx.scala.core.buffer.Buffer

class WebSocketFrame(private val _asJava: io.vertx.core.http.WebSocketFrame) {

  def asJava: java.lang.Object = _asJava

  def isText(): Boolean = {
    _asJava.isText()
  }

  def isBinary(): Boolean = {
    _asJava.isBinary()
  }

  def isContinuation(): Boolean = {
    _asJava.isContinuation()
  }

  def textData(): String = {
    _asJava.textData()
  }

  def binaryData(): io.vertx.scala.core.buffer.Buffer = {
    Buffer.apply(_asJava.binaryData())
  }

  def isFinal(): Boolean = {
    _asJava.isFinal()
  }

}

object WebSocketFrame {

  def apply(_asJava: io.vertx.core.http.WebSocketFrame): io.vertx.scala.core.http.WebSocketFrame =
    new io.vertx.scala.core.http.WebSocketFrame(_asJava)
  
    def binaryFrame(data: io.vertx.scala.core.buffer.Buffer, isFinal: Boolean): io.vertx.scala.core.http.WebSocketFrame = {
      WebSocketFrame.apply(io.vertx.core.http.WebSocketFrame.binaryFrame(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer], isFinal))
    }
  
    def textFrame(str: String, isFinal: Boolean): io.vertx.scala.core.http.WebSocketFrame = {
      WebSocketFrame.apply(io.vertx.core.http.WebSocketFrame.textFrame(str, isFinal))
    }
  
    def continuationFrame(data: io.vertx.scala.core.buffer.Buffer, isFinal: Boolean): io.vertx.scala.core.http.WebSocketFrame = {
      WebSocketFrame.apply(io.vertx.core.http.WebSocketFrame.continuationFrame(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer], isFinal))
    }
}
