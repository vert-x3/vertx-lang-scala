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


package io.vertx.scala.ext.web

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core
import io.vertx.ext.web.api.{OperationRequest => JOperationRequest}
import io.vertx.core.json.JsonObject
import io.vertx.core.{MultiMap => JMultiMap}
package object api{


  type OperationRequest = io.vertx.ext.web.api.OperationRequest
  object OperationRequest {
    def apply() = new OperationRequest()
    def apply(json: JsonObject) = new OperationRequest(json)
    def apply( extra: io.vertx.core.json.JsonObject = null, headers: io.vertx.core.MultiMap = null, params: io.vertx.core.json.JsonObject = null, user: io.vertx.core.json.JsonObject = null): OperationRequest = {
      val ret = new OperationRequest(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (extra != null) ret.setExtra(extra) 
      if (headers != null) ret.setHeaders(headers) 
      if (params != null) ret.setParams(params) 
      if (user != null) ret.setUser(user) 
      ret
    }
  }



  type OperationResponse = io.vertx.ext.web.api.OperationResponse
  object OperationResponse {
    def apply() = new OperationResponse()
    def apply(json: JsonObject) = new OperationResponse(json)
    def apply( headers: io.vertx.core.MultiMap = null, payload: io.vertx.core.buffer.Buffer = null, statusCode: java.lang.Integer = null, statusMessage: java.lang.String = null): OperationResponse = {
      val ret = new OperationResponse(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (headers != null) ret.setHeaders(headers) 
      if (payload != null) ret.setPayload(payload) 
      if (statusCode != null) ret.setStatusCode(statusCode) 
      if (statusMessage != null) ret.setStatusMessage(statusMessage) 
      ret
    }
  }



  type RouterFactoryOptions = io.vertx.ext.web.api.contract.RouterFactoryOptions
  object RouterFactoryOptions {
    def apply() = new RouterFactoryOptions()
    def apply(json: JsonObject) = new RouterFactoryOptions(json)
    def apply( mountNotImplementedHandler: java.lang.Boolean = null, mountResponseContentTypeHandler: java.lang.Boolean = null, mountValidationFailureHandler: java.lang.Boolean = null, operationModelKey: java.lang.String = null, requireSecurityHandlers: java.lang.Boolean = null): RouterFactoryOptions = {
      val ret = new RouterFactoryOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (mountNotImplementedHandler != null) ret.setMountNotImplementedHandler(mountNotImplementedHandler) 
      if (mountResponseContentTypeHandler != null) ret.setMountResponseContentTypeHandler(mountResponseContentTypeHandler) 
      if (mountValidationFailureHandler != null) ret.setMountValidationFailureHandler(mountValidationFailureHandler) 
      if (operationModelKey != null) ret.setOperationModelKey(operationModelKey) 
      if (requireSecurityHandlers != null) ret.setRequireSecurityHandlers(requireSecurityHandlers) 
      ret
    }
  }



}
