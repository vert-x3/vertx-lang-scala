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

import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
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

def asJava = _asJava.asInstanceOf[JWebSocketFrame]
//methods returning a future
//cached methods
  def textData():String = {
    asJava.textData( )
  }

  def binaryData():Buffer = {
    asJava.binaryData( )
  }

//fluent methods
//basic methods
  def isText():Boolean = {
    asJava.isText( )
  }

  def isBinary():Boolean = {
    asJava.isBinary( )
  }

  def isContinuation():Boolean = {
    asJava.isContinuation( )
  }

  def isFinal():Boolean = {
    asJava.isFinal( )
  }

}

object WebSocketFrame{
//in object!
//static methods
  def binaryFrame(data: Buffer,isFinal: Boolean):WebSocketFrame = {
    JWebSocketFrame.binaryFrame( )
  }

  def textFrame(str: String,isFinal: Boolean):WebSocketFrame = {
    JWebSocketFrame.textFrame( )
  }

  def continuationFrame(data: Buffer,isFinal: Boolean):WebSocketFrame = {
    JWebSocketFrame.continuationFrame( )
  }

}
