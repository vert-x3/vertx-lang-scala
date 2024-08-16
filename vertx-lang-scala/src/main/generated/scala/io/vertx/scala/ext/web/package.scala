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


package io.vertx.scala.ext

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.web.handler.sockjs.{SockJSHandlerOptions => JSockJSHandlerOptions}
package object web{


  type Http2PushMapping = io.vertx.ext.web.Http2PushMapping
  object Http2PushMapping {
    def apply() = new Http2PushMapping()
    def apply(json: JsonObject) = new Http2PushMapping(json)
    def apply( extensionTarget: java.lang.String = null, filePath: java.lang.String = null, noPush: java.lang.Boolean = null): Http2PushMapping = {
      val ret = new Http2PushMapping(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (extensionTarget != null) ret.setExtensionTarget(extensionTarget) 
      if (filePath != null) ret.setFilePath(filePath) 
      if (noPush != null) ret.setNoPush(noPush) 
      ret
    }
  }



  type SockJSBridgeOptions = io.vertx.ext.web.handler.sockjs.SockJSBridgeOptions
  object SockJSBridgeOptions {
    def apply() = new SockJSBridgeOptions()
    def apply(json: JsonObject) = new SockJSBridgeOptions(json)
    def apply( inboundPermitteds: scala.collection.immutable.List[io.vertx.ext.bridge.PermittedOptions] = null, maxAddressLength: java.lang.Integer = null, maxHandlersPerSocket: java.lang.Integer = null, outboundPermitteds: scala.collection.immutable.List[io.vertx.ext.bridge.PermittedOptions] = null, pingTimeout: java.lang.Long = null, replyTimeout: java.lang.Long = null): SockJSBridgeOptions = {
      val ret = new SockJSBridgeOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (inboundPermitteds != null) ret.setInboundPermitteds(inboundPermitteds.asJava) 
      if (maxAddressLength != null) ret.setMaxAddressLength(maxAddressLength) 
      if (maxHandlersPerSocket != null) ret.setMaxHandlersPerSocket(maxHandlersPerSocket) 
      if (outboundPermitteds != null) ret.setOutboundPermitteds(outboundPermitteds.asJava) 
      if (pingTimeout != null) ret.setPingTimeout(pingTimeout) 
      if (replyTimeout != null) ret.setReplyTimeout(replyTimeout) 
      ret
    }
  }



  type SockJSHandlerOptions = io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions
  object SockJSHandlerOptions {
    def apply() = new SockJSHandlerOptions()
    def apply(json: JsonObject) = new SockJSHandlerOptions(json)
    def apply( heartbeatInterval: java.lang.Long = null, insertJSESSIONID: java.lang.Boolean = null, libraryURL: java.lang.String = null, localWriteHandler: java.lang.Boolean = null, maxBytesStreaming: java.lang.Integer = null, origin: java.lang.String = null, registerWriteHandler: java.lang.Boolean = null, sessionTimeout: java.lang.Long = null): SockJSHandlerOptions = {
      val ret = new SockJSHandlerOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (heartbeatInterval != null) ret.setHeartbeatInterval(heartbeatInterval) 
      if (insertJSESSIONID != null) ret.setInsertJSESSIONID(insertJSESSIONID) 
      if (libraryURL != null) ret.setLibraryURL(libraryURL) 
      if (localWriteHandler != null) ret.setLocalWriteHandler(localWriteHandler) 
      if (maxBytesStreaming != null) ret.setMaxBytesStreaming(maxBytesStreaming) 
      if (origin != null) ret.setOrigin(origin) 
      if (registerWriteHandler != null) ret.setRegisterWriteHandler(registerWriteHandler) 
      if (sessionTimeout != null) ret.setSessionTimeout(sessionTimeout) 
      ret
    }
  }



}
