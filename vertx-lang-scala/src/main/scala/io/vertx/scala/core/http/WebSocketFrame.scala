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

import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.scala.core.buffer.Buffer

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
  private var cached_0:String = _
    private var cached_1:Buffer = _
  
//methods returning a future
//cached methods
  def textData():String = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JWebSocketFrame].textData()
      cached_0 = tmp
    }
    return cached_0
  }

  def binaryData():Buffer = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JWebSocketFrame].binaryData()
      cached_1 = Buffer(tmp)
    }
    return cached_1
  }

//fluent methods
//basic methods
  def isText():Boolean = {
    asJava.asInstanceOf[JWebSocketFrame].isText()
  }

  def isBinary():Boolean = {
    asJava.asInstanceOf[JWebSocketFrame].isBinary()
  }

  def isContinuation():Boolean = {
    asJava.asInstanceOf[JWebSocketFrame].isContinuation()
  }

  def isFinal():Boolean = {
    asJava.asInstanceOf[JWebSocketFrame].isFinal()
  }

}

object WebSocketFrame{
  def apply(asJava: JWebSocketFrame) = new WebSocketFrame(asJava)//static methods
  def binaryFrame(data: Buffer,isFinal: Boolean):WebSocketFrame = {
    WebSocketFrame(JWebSocketFrame.binaryFrame(data.asJava.asInstanceOf[JBuffer],isFinal))
  }

  def textFrame(str: String,isFinal: Boolean):WebSocketFrame = {
    WebSocketFrame(JWebSocketFrame.textFrame(str,isFinal))
  }

  def continuationFrame(data: Buffer,isFinal: Boolean):WebSocketFrame = {
    WebSocketFrame(JWebSocketFrame.continuationFrame(data.asJava.asInstanceOf[JBuffer],isFinal))
  }

}
