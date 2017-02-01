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

package io.vertx.scala.ext.web.client

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.web.codec.{BodyCodec => JBodyCodec}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.ext.web.client.{HttpRequest => JHttpRequest}
import io.vertx.ext.web.client.{HttpResponse => JHttpResponse}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpMethod
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.MultiMap
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.ext.web.codec.BodyCodec

/**
  * A client-side HTTP request.
  * 
  * Instances are created by an [[io.vertx.scala.ext.web.client.WebClient]] instance, via one of the methods corresponding to the specific
  * HTTP methods such as [[io.vertx.scala.ext.web.client.WebClient#get]], etc...
  * 
  * The request shall be configured prior sending, the request is immutable and when a mutator method
  * is called, a new request is returned allowing to expose the request in a public API and apply further customization.
  * 
  * After the request has been configured, the methods
  * <ul>
  *   <li>[[io.vertx.scala.ext.web.client.HttpRequest#sendFuture]]</li>
  *   <li>[[io.vertx.scala.ext.web.client.HttpRequest#sendStreamFuture]]</li>
  *   <li>[[io.vertx.scala.ext.web.client.HttpRequest#sendJsonFuture]] ()}</li>
  *   <li>[[io.vertx.scala.ext.web.client.HttpRequest#sendFormFuture]]</li>
  * </ul>
  * can be called.
  * The `sendXXX` methods perform the actual request, they can be called multiple times to perform the same HTTP
  * request at different points in time.
  * 
  * The handler is called back with
  * <ul>
  *   <li>an [[io.vertx.scala.ext.web.client.HttpResponse]] instance when the HTTP response has been received</li>
  *   <li>a failure when the HTTP request failed (like a connection error) or when the HTTP response could
  *   not be obtained (like connection or unmarshalling errors)</li>
  * </ul>
  * 
  * Most of the time, this client will buffer the HTTP response fully unless a specific  is used
  * such as .
  */
class HttpRequest[T: TypeTag](private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0: MultiMap = _

  /**
    * @return The HTTP headers
    */
  def headers(): MultiMap = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JHttpRequest[Object]].headers()
      cached_0 = MultiMap(tmp)
    }
    cached_0
  }

  /**
    * Configure the request to use a new method `value`.
    * @return a reference to this, so the API can be used fluently
    */
  def method(value: io.vertx.core.http.HttpMethod): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].method(value)
    this
  }

  /**
    * Configure the request to use a new port `value`.
    * @return a reference to this, so the API can be used fluently
    */
  def port(value: Int): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].port(value.asInstanceOf[java.lang.Integer])
    this
  }

  /**
    * Configure the request to use a new host `value`.
    * @return a reference to this, so the API can be used fluently
    */
  def host(value: String): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].host(value.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Configure the request to use a new request URI `value`.
    * 
    * When the uri has query parameters, they are set in the [[io.vertx.scala.ext.web.client.HttpRequest#queryParams]] multimap, overwritting
    * any parameters previously set.
    * @return a reference to this, so the API can be used fluently
    */
  def uri(value: String): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].uri(value.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Configure the request to add a new HTTP header.
    * @param name the header name
    * @param value the header value
    * @return a reference to this, so the API can be used fluently
    */
  def putHeader(name: String, value: String): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].putHeader(name.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Configures the amount of time in milliseconds after which if the request does not return any data within the timeout
    * period an TimeoutException fails the request.
    * 
    * Setting zero or a negative `value` disables the timeout.
    * @param value The quantity of time in milliseconds.
    * @return a reference to this, so the API can be used fluently
    */
  def timeout(value: Long): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].timeout(value.asInstanceOf[java.lang.Long])
    this
  }

  /**
    * Add a query parameter to the request.
    * @param paramName the param name
    * @param paramValue the param value
    * @return a reference to this, so the API can be used fluently
    */
  def addQueryParam(paramName: String, paramValue: String): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].addQueryParam(paramName.asInstanceOf[java.lang.String],paramValue.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set a query parameter to the request.
    * @param paramName the param name
    * @param paramValue the param value
    * @return a reference to this, so the API can be used fluently
    */
  def setQueryParam(paramName: String, paramValue: String): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].setQueryParam(paramName.asInstanceOf[java.lang.String],paramValue.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Configure the request to decode the response with the `responseCodec`.
    * @param responseCodec the response codec
    * @return a reference to this, so the API can be used fluently
    */
  def as[U: TypeTag](responseCodec: BodyCodec[U]): HttpRequest[U] = {
    HttpRequest[U](asJava.asInstanceOf[JHttpRequest[Object]].as[Object](responseCodec.asJava.asInstanceOf[JBodyCodec[Object]]))
  }

  /**
    * Return the current query parameters.
    * @return the current query parameters
    */
  def queryParams(): MultiMap = {
    MultiMap(asJava.asInstanceOf[JHttpRequest[Object]].queryParams())
  }

  /**
    * Copy this request
    * @return a copy of this request
    */
  def copy(): HttpRequest[T] = {
    HttpRequest[T](asJava.asInstanceOf[JHttpRequest[Object]].copy())
  }

  /**
    * Like [[io.vertx.scala.ext.web.client.HttpRequest#sendFuture]] but with an HTTP request `body` stream.
    * @param body the body
    */
  def sendStream(body: ReadStream[io.vertx.core.buffer.Buffer], handler: Handler[AsyncResult[HttpResponse[T]]]): Unit = {
    asJava.asInstanceOf[JHttpRequest[Object]].sendStream(body.asJava.asInstanceOf[JReadStream[Buffer]],{x: AsyncResult[JHttpResponse[Object]] => handler.handle(AsyncResultWrapper[JHttpResponse[Object],HttpResponse[T]](x, a => HttpResponse[T](a)))})
  }

  /**
    * Like [[io.vertx.scala.ext.web.client.HttpRequest#sendFuture]] but with an HTTP request `body` buffer.
    * @param body the body
    */
  def sendBuffer(body: io.vertx.core.buffer.Buffer, handler: Handler[AsyncResult[HttpResponse[T]]]): Unit = {
    asJava.asInstanceOf[JHttpRequest[Object]].sendBuffer(body,{x: AsyncResult[JHttpResponse[Object]] => handler.handle(AsyncResultWrapper[JHttpResponse[Object],HttpResponse[T]](x, a => HttpResponse[T](a)))})
  }

  /**
    * Like [[io.vertx.scala.ext.web.client.HttpRequest#sendFuture]] but with an HTTP request `body` object encoded as json and the content type
    * set to `application/json`.
    * @param body the body
    */
  def sendJsonObject(body: io.vertx.core.json.JsonObject, handler: Handler[AsyncResult[HttpResponse[T]]]): Unit = {
    asJava.asInstanceOf[JHttpRequest[Object]].sendJsonObject(body,{x: AsyncResult[JHttpResponse[Object]] => handler.handle(AsyncResultWrapper[JHttpResponse[Object],HttpResponse[T]](x, a => HttpResponse[T](a)))})
  }

  /**
    * Like [[io.vertx.scala.ext.web.client.HttpRequest#sendFuture]] but with an HTTP request `body` object encoded as json and the content type
    * set to `application/json`.
    * @param body the body
    */
  def sendJson(body: AnyRef, handler: Handler[AsyncResult[HttpResponse[T]]]): Unit = {
    asJava.asInstanceOf[JHttpRequest[Object]].sendJson(body,{x: AsyncResult[JHttpResponse[Object]] => handler.handle(AsyncResultWrapper[JHttpResponse[Object],HttpResponse[T]](x, a => HttpResponse[T](a)))})
  }

  /**
    * Like [[io.vertx.scala.ext.web.client.HttpRequest#sendFuture]] but with an HTTP request `body` multimap encoded as form and the content type
    * set to `application/x-www-form-urlencoded`.
    * 
    * When the content type header is previously set to `multipart/form-data` it will be used instead.
    * @param body the body
    */
  def sendForm(body: MultiMap, handler: Handler[AsyncResult[HttpResponse[T]]]): Unit = {
    asJava.asInstanceOf[JHttpRequest[Object]].sendForm(body.asJava.asInstanceOf[JMultiMap],{x: AsyncResult[JHttpResponse[Object]] => handler.handle(AsyncResultWrapper[JHttpResponse[Object],HttpResponse[T]](x, a => HttpResponse[T](a)))})
  }

  /**
    * Send a request, the `handler` will receive the response as an [[io.vertx.scala.ext.web.client.HttpResponse]].
    */
  def send(handler: Handler[AsyncResult[HttpResponse[T]]]): Unit = {
    asJava.asInstanceOf[JHttpRequest[Object]].send({x: AsyncResult[JHttpResponse[Object]] => handler.handle(AsyncResultWrapper[JHttpResponse[Object],HttpResponse[T]](x, a => HttpResponse[T](a)))})
  }

 /**
   * Like [[io.vertx.scala.ext.web.client.HttpRequest#sendFuture]] but with an HTTP request `body` stream.
   * @param body the body
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendStreamFuture(body: ReadStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[HttpResponse[T]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[T]](x => HttpResponse[T](x))
    asJava.asInstanceOf[JHttpRequest[Object]].sendStream(body.asJava.asInstanceOf[JReadStream[Buffer]],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.ext.web.client.HttpRequest#sendFuture]] but with an HTTP request `body` buffer.
   * @param body the body
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendBufferFuture(body: io.vertx.core.buffer.Buffer): scala.concurrent.Future[HttpResponse[T]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[T]](x => HttpResponse[T](x))
    asJava.asInstanceOf[JHttpRequest[Object]].sendBuffer(body,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.ext.web.client.HttpRequest#sendFuture]] but with an HTTP request `body` object encoded as json and the content type
   * set to `application/json`.
   * @param body the body
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendJsonObjectFuture(body: io.vertx.core.json.JsonObject): scala.concurrent.Future[HttpResponse[T]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[T]](x => HttpResponse[T](x))
    asJava.asInstanceOf[JHttpRequest[Object]].sendJsonObject(body,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.ext.web.client.HttpRequest#sendFuture]] but with an HTTP request `body` object encoded as json and the content type
   * set to `application/json`.
   * @param body the body
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendJsonFuture(body: AnyRef): scala.concurrent.Future[HttpResponse[T]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[T]](x => HttpResponse[T](x))
    asJava.asInstanceOf[JHttpRequest[Object]].sendJson(body,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.ext.web.client.HttpRequest#sendFuture]] but with an HTTP request `body` multimap encoded as form and the content type
   * set to `application/x-www-form-urlencoded`.
   * 
   * When the content type header is previously set to `multipart/form-data` it will be used instead.
   * @param body the body
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendFormFuture(body: MultiMap): scala.concurrent.Future[HttpResponse[T]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[T]](x => HttpResponse[T](x))
    asJava.asInstanceOf[JHttpRequest[Object]].sendForm(body.asJava.asInstanceOf[JMultiMap],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Send a request, the `handler` will receive the response as an [[io.vertx.scala.ext.web.client.HttpResponse]].
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendFuture(): scala.concurrent.Future[HttpResponse[T]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[T]](x => HttpResponse[T](x))
    asJava.asInstanceOf[JHttpRequest[Object]].send(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object HttpRequest {
  def apply[T: TypeTag](asJava: JHttpRequest[_]) = new HttpRequest[T](asJava)  
}
