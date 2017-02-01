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

package io.vertx.scala.core.http

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}

/**
  * A WebSocket frame that represents either text or binary data.
  * 
  * A WebSocket message is composed of one or more WebSocket frames.
  * 
  * If there is a just a single frame in the message then a single text or binary frame should be created with final = true.
  * 
  * If there are more than one frames in the message, then the first frame should be a text or binary frame with
  * final = false, followed by one or more continuation frames. The last continuation frame should have final = true.
  */
class WebSocketFrame(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0: String = _
  private var cached_1: io.vertx.core.buffer.Buffer = _

  /**
    * @return the content of this frame as a UTF-8 string and returns the converted string. Only use this for text frames.
    */
  def textData(): String = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JWebSocketFrame].textData()
      cached_0 = tmp.asInstanceOf[String]
    }
    cached_0
  }

  /**
    * @return the data of the frame
    */
  def binaryData(): io.vertx.core.buffer.Buffer = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JWebSocketFrame].binaryData()
      cached_1 = tmp
    }
    cached_1
  }

  /**
    * @return true if it's a text frame
    */
  def isText(): Boolean = {
    asJava.asInstanceOf[JWebSocketFrame].isText().asInstanceOf[Boolean]
  }

  /**
    * @return true if it's a binary frame
    */
  def isBinary(): Boolean = {
    asJava.asInstanceOf[JWebSocketFrame].isBinary().asInstanceOf[Boolean]
  }

  /**
    * @return true if it's a continuation frame
    */
  def isContinuation(): Boolean = {
    asJava.asInstanceOf[JWebSocketFrame].isContinuation().asInstanceOf[Boolean]
  }

  /**
    * @return true if this is the final frame.
    */
  def isFinal(): Boolean = {
    asJava.asInstanceOf[JWebSocketFrame].isFinal().asInstanceOf[Boolean]
  }

}

object WebSocketFrame {
  def apply(asJava: JWebSocketFrame) = new WebSocketFrame(asJava)  
  /**
    * Create a binary WebSocket frame.
    * @param data the data for the frame
    * @param isFinal true if it's the final frame in the WebSocket message
    * @return the frame
    */
  def binaryFrame(data: io.vertx.core.buffer.Buffer, isFinal: Boolean): WebSocketFrame = {
    WebSocketFrame(JWebSocketFrame.binaryFrame(data,isFinal.asInstanceOf[java.lang.Boolean]))
  }

  /**
    * Create a text WebSocket frame.
    * @param str the string for the frame
    * @param isFinal true if it's the final frame in the WebSocket message
    * @return the frame
    */
  def textFrame(str: String, isFinal: Boolean): WebSocketFrame = {
    WebSocketFrame(JWebSocketFrame.textFrame(str.asInstanceOf[java.lang.String],isFinal.asInstanceOf[java.lang.Boolean]))
  }

  /**
    * Create a continuation frame
    * @param data the data for the frame
    * @param isFinal true if it's the final frame in the WebSocket message
    * @return the frame
    */
  def continuationFrame(data: io.vertx.core.buffer.Buffer, isFinal: Boolean): WebSocketFrame = {
    WebSocketFrame(JWebSocketFrame.continuationFrame(data,isFinal.asInstanceOf[java.lang.Boolean]))
  }

}
