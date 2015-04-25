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

import io.vertx.scala.core.metrics.Measured
import io.vertx.core.http.HttpMethod
import io.vertx.scala.core.MultiMap
import io.vertx.core.http.WebsocketVersion
import io.vertx.core.Handler

class HttpClient(private val _asJava: io.vertx.core.http.HttpClient) 
    extends io.vertx.scala.core.metrics.Measured {

  def asJava: java.lang.Object = _asJava

  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  def request(method: io.vertx.core.http.HttpMethod, port: Int, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, port, host, requestURI))
  }

  def request(method: io.vertx.core.http.HttpMethod, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, host, requestURI))
  }

  def request(method: io.vertx.core.http.HttpMethod, port: Int, host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.request(method, port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def request(method: io.vertx.core.http.HttpMethod, host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.request(method, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def request(method: io.vertx.core.http.HttpMethod, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, requestURI))
  }

  def request(method: io.vertx.core.http.HttpMethod, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.request(method, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def requestAbs(method: io.vertx.core.http.HttpMethod, absoluteURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.requestAbs(method, absoluteURI))
  }

  def requestAbs(method: io.vertx.core.http.HttpMethod, absoluteURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.requestAbs(method, absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def get(port: Int, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(port, host, requestURI))
  }

  def get(host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(host, requestURI))
  }

  def get(port: Int, host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.get(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def get(host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.get(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def get(requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(requestURI))
  }

  def get(requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.get(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def getAbs(absoluteURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.getAbs(absoluteURI))
  }

  def getAbs(absoluteURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.getAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def getNow(port: Int, host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.getNow(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def getNow(host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.getNow(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def getNow(requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.getNow(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def post(port: Int, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(port, host, requestURI))
  }

  def post(host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(host, requestURI))
  }

  def post(port: Int, host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.post(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def post(host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.post(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def post(requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(requestURI))
  }

  def post(requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.post(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def postAbs(absoluteURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.postAbs(absoluteURI))
  }

  def postAbs(absoluteURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.postAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def head(port: Int, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(port, host, requestURI))
  }

  def head(host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(host, requestURI))
  }

  def head(port: Int, host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.head(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def head(host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.head(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def head(requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(requestURI))
  }

  def head(requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.head(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def headAbs(absoluteURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.headAbs(absoluteURI))
  }

  def headAbs(absoluteURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.headAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def headNow(port: Int, host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.headNow(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def headNow(host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.headNow(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def headNow(requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.headNow(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def options(port: Int, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(port, host, requestURI))
  }

  def options(host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(host, requestURI))
  }

  def options(port: Int, host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.options(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def options(host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.options(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def options(requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(requestURI))
  }

  def options(requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.options(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def optionsAbs(absoluteURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.optionsAbs(absoluteURI))
  }

  def optionsAbs(absoluteURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.optionsAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def optionsNow(port: Int, host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.optionsNow(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def optionsNow(host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.optionsNow(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def optionsNow(requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.optionsNow(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def put(port: Int, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(port, host, requestURI))
  }

  def put(host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(host, requestURI))
  }

  def put(port: Int, host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.put(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def put(host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.put(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def put(requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(requestURI))
  }

  def put(requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.put(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def putAbs(absoluteURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.putAbs(absoluteURI))
  }

  def putAbs(absoluteURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.putAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def delete(port: Int, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(port, host, requestURI))
  }

  def delete(host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(host, requestURI))
  }

  def delete(port: Int, host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.delete(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def delete(host: String, requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.delete(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def delete(requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(requestURI))
  }

  def delete(requestURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.delete(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def deleteAbs(absoluteURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.deleteAbs(absoluteURI))
  }

  def deleteAbs(absoluteURI: String)(responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClientRequest.apply(_asJava.deleteAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  def websocket(port: Int, host: String, requestURI: String)(wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.websocket(port, host, requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect)))
  }

  def websocket(host: String, requestURI: String)(wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.websocket(host, requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect)))
  }

  def websocket(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap)(wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect)))
  }

  def websocket(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap)(wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect)))
  }

  def websocket(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion)(wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect)))
  }

  def websocket(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion)(wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect)))
  }

  def websocket(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String)(wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect)))
  }

  def websocket(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String)(wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect)))
  }

  def websocket(requestURI: String)(wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.websocket(requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect)))
  }

  def websocket(requestURI: String, headers: io.vertx.scala.core.MultiMap)(wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.websocket(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect)))
  }

  def websocket(requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion)(wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.websocket(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect)))
  }

  def websocket(requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String)(wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpClient.apply(_asJava.websocket(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect)))
  }

  def websocketStream(port: Int, host: String, requestURI: String): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(port, host, requestURI))
  }

  def websocketStream(host: String, requestURI: String): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(host, requestURI))
  }

  def websocketStream(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap]))
  }

  def websocketStream(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap]))
  }

  def websocketStream(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version))
  }

  def websocketStream(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version))
  }

  def websocketStream(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols))
  }

  def websocketStream(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols))
  }

  def websocketStream(requestURI: String): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(requestURI))
  }

  def websocketStream(requestURI: String, headers: io.vertx.scala.core.MultiMap): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap]))
  }

  def websocketStream(requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version))
  }

  def websocketStream(requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols))
  }

  def close(): Unit = {
    _asJava.close()
  }

}

object HttpClient {

  def apply(_asJava: io.vertx.core.http.HttpClient): io.vertx.scala.core.http.HttpClient =
    new io.vertx.scala.core.http.HttpClient(_asJava)
}
