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

package io.vertx.scala.webclient

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.webclient.{BodyCodec => JBodyCodec}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.webclient.{HttpResponse => JHttpResponse}
import io.vertx.scala.webclient.HttpResponse
import io.vertx.webclient.{HttpRequest => JHttpRequest}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpMethod
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.MultiMap
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * A client-side HTTP request.
  * 
  * Instances are created by an [[io.vertx.scala.webclient.WebClient]] instance, via one of the methods corresponding to the specific
  * HTTP methods such as [[io.vertx.scala.webclient.WebClient#get]], etc...
  * 
  * The request shall be configured prior sending, the request is immutable and when a mutator method
  * is called, a new request is returned allowing to expose the request in a public API and apply further customization.
  * 
  * After the request has been configured, the methods
  * <ul>
  *   <li>[[io.vertx.scala.webclient.HttpRequest#sendFuture]]</li>
  *   <li>[[io.vertx.scala.webclient.HttpRequest#sendStreamFuture]]</li>
  *   <li>[[io.vertx.scala.webclient.HttpRequest#sendJsonFuture]] ()}</li>
  *   <li>[[io.vertx.scala.webclient.HttpRequest#sendFuture]] (Handler)}</li>
  * </ul>
  * can be called.
  * The `sendXXX` methods perform the actual request, they can be called multiple times to perform the same HTTP
  * request at different points in time.
  * 
  * The handler is called back with
  * <ul>
  *   <li>an [[io.vertx.scala.webclient.HttpResponse]] instance when the HTTP response has been received</li>
  *   <li>a failure when the HTTP request failed (like a connection error) or when the HTTP response could
  *   not be obtained (like connection or unmarshalling errors)</li>
  * </ul>
  * 
  * Most of the time, this client will buffer the HTTP response fully unless a specific [[io.vertx.scala.webclient.BodyCodec]] is used
  * such as [[io.vertx.scala.webclient.BodyCodec#createFuture]].
  */
class HttpRequest(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0:MultiMap = _

  /**
    * @return The HTTP headers
    */
  def headers():MultiMap = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JHttpRequest].headers()
      cached_0 = MultiMap(tmp)
    }
    cached_0
  }

  /**
    * Configure the request to use a new method `value`.
    * @return a reference to this, so the API can be used fluently
    */
//io.vertx.core.http.HttpMethod
  def method(value: io.vertx.core.http.HttpMethod):HttpRequest = {
    asJava.asInstanceOf[JHttpRequest].method(value)
    this
  }

  /**
    * Configure the request to use a new port `value`.
    * @return a reference to this, so the API can be used fluently
    */
//int
  def port(value: Int):HttpRequest = {
    asJava.asInstanceOf[JHttpRequest].port(value.asInstanceOf[java.lang.Integer])
    this
  }

  /**
    * Configure the request to use a new host `value`.
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
  def host(value: String):HttpRequest = {
    asJava.asInstanceOf[JHttpRequest].host(value.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Configure the request to use a new request URI `value`.
    * 
    * When the uri has query parameters, they are set in the [[io.vertx.scala.webclient.HttpRequest#queryParams]] multimap, overwritting
    * any parameters previously set.
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
  def uri(value: String):HttpRequest = {
    asJava.asInstanceOf[JHttpRequest].uri(value.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Configure the request to add a new HTTP header.
    * @param name the header name
    * @param value the header value
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
  def putHeader(name: String,value: String):HttpRequest = {
    asJava.asInstanceOf[JHttpRequest].putHeader(name.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String])
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
//long
  def timeout(value: Long):HttpRequest = {
    asJava.asInstanceOf[JHttpRequest].timeout(value.asInstanceOf[java.lang.Long])
    this
  }

  /**
    * Add a query parameter to the request.
    * @param paramName the param name
    * @param paramValue the param value
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
  def addQueryParam(paramName: String,paramValue: String):HttpRequest = {
    asJava.asInstanceOf[JHttpRequest].addQueryParam(paramName.asInstanceOf[java.lang.String],paramValue.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set a query parameter to the request.
    * @param paramName the param name
    * @param paramValue the param value
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
  def setQueryParam(paramName: String,paramValue: String):HttpRequest = {
    asJava.asInstanceOf[JHttpRequest].setQueryParam(paramName.asInstanceOf[java.lang.String],paramValue.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Return the current query parameters.
    * @return the current query parameters
    */
  def queryParams():MultiMap = {
    MultiMap(asJava.asInstanceOf[JHttpRequest].queryParams())
  }

  /**
    * Copy this request
    * @return a copy of this request
    */
  def copy():HttpRequest = {
    HttpRequest(asJava.asInstanceOf[JHttpRequest].copy())
  }

  /**
    * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` stream.
    * @param body the body
    */
  def sendStream(body: ReadStream[io.vertx.core.buffer.Buffer],handler: Handler[AsyncResult[HttpResponse[io.vertx.core.buffer.Buffer]]]):Unit = {
    asJava.asInstanceOf[JHttpRequest].sendStream(body.asJava.asInstanceOf[JReadStream[Buffer]],{x: AsyncResult[JHttpResponse[Buffer]] => handler.handle(AsyncResultWrapper[JHttpResponse[Buffer],HttpResponse[io.vertx.core.buffer.Buffer]](x, a => HttpResponse[io.vertx.core.buffer.Buffer](a)))})
  }

  /**
    * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` stream.
    * @param body the body
    * @param responseCodec the codec to decode the response
    */
  def sendStream[R:TypeTag](body: ReadStream[io.vertx.core.buffer.Buffer],responseCodec: BodyCodec[R],handler: Handler[AsyncResult[HttpResponse[R]]]):Unit = {
    asJava.asInstanceOf[JHttpRequest].sendStream[Object](body.asJava.asInstanceOf[JReadStream[Buffer]],responseCodec.asJava.asInstanceOf[JBodyCodec[Object]],{x: AsyncResult[JHttpResponse[Object]] => handler.handle(AsyncResultWrapper[JHttpResponse[Object],HttpResponse[R]](x, a => HttpResponse[R](a)))})
  }

  /**
    * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` buffer.
    * @param body the body
    */
  def sendBuffer(body: io.vertx.core.buffer.Buffer,handler: Handler[AsyncResult[HttpResponse[io.vertx.core.buffer.Buffer]]]):Unit = {
    asJava.asInstanceOf[JHttpRequest].sendBuffer(body,{x: AsyncResult[JHttpResponse[Buffer]] => handler.handle(AsyncResultWrapper[JHttpResponse[Buffer],HttpResponse[io.vertx.core.buffer.Buffer]](x, a => HttpResponse[io.vertx.core.buffer.Buffer](a)))})
  }

  /**
    * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` buffer.
    * @param body the body
    * @param responseCodec the codec to decode the response
    */
  def sendBuffer[R:TypeTag](body: io.vertx.core.buffer.Buffer,responseCodec: BodyCodec[R],handler: Handler[AsyncResult[HttpResponse[R]]]):Unit = {
    asJava.asInstanceOf[JHttpRequest].sendBuffer[Object](body,responseCodec.asJava.asInstanceOf[JBodyCodec[Object]],{x: AsyncResult[JHttpResponse[Object]] => handler.handle(AsyncResultWrapper[JHttpResponse[Object],HttpResponse[R]](x, a => HttpResponse[R](a)))})
  }

  /**
    * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` object encoded as json and the content type
    * set to `application/json`.
    * @param body the body
    */
  def sendJsonObject(body: io.vertx.core.json.JsonObject,handler: Handler[AsyncResult[HttpResponse[io.vertx.core.buffer.Buffer]]]):Unit = {
    asJava.asInstanceOf[JHttpRequest].sendJsonObject(body,{x: AsyncResult[JHttpResponse[Buffer]] => handler.handle(AsyncResultWrapper[JHttpResponse[Buffer],HttpResponse[io.vertx.core.buffer.Buffer]](x, a => HttpResponse[io.vertx.core.buffer.Buffer](a)))})
  }

  /**
    * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` object encoded as json and the content type
    * set to `application/json`.
    * @param body the body
    * @param responseCodec the codec to decode the response
    */
  def sendJsonObject[R:TypeTag](body: io.vertx.core.json.JsonObject,responseCodec: BodyCodec[R],handler: Handler[AsyncResult[HttpResponse[R]]]):Unit = {
    asJava.asInstanceOf[JHttpRequest].sendJsonObject[Object](body,responseCodec.asJava.asInstanceOf[JBodyCodec[Object]],{x: AsyncResult[JHttpResponse[Object]] => handler.handle(AsyncResultWrapper[JHttpResponse[Object],HttpResponse[R]](x, a => HttpResponse[R](a)))})
  }

  /**
    * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` object encoded as json and the content type
    * set to `application/json`.
    * @param body the body
    */
  def sendJson(body: AnyRef,handler: Handler[AsyncResult[HttpResponse[io.vertx.core.buffer.Buffer]]]):Unit = {
    asJava.asInstanceOf[JHttpRequest].sendJson(body,{x: AsyncResult[JHttpResponse[Buffer]] => handler.handle(AsyncResultWrapper[JHttpResponse[Buffer],HttpResponse[io.vertx.core.buffer.Buffer]](x, a => HttpResponse[io.vertx.core.buffer.Buffer](a)))})
  }

  /**
    * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` object encoded as json and the content type
    * set to `application/json`.
    * @param body the body
    * @param responseCodec the codec to decode the response
    */
  def sendJson[R:TypeTag](body: AnyRef,responseCodec: BodyCodec[R],handler: Handler[AsyncResult[HttpResponse[R]]]):Unit = {
    asJava.asInstanceOf[JHttpRequest].sendJson[Object](body,responseCodec.asJava.asInstanceOf[JBodyCodec[Object]],{x: AsyncResult[JHttpResponse[Object]] => handler.handle(AsyncResultWrapper[JHttpResponse[Object],HttpResponse[R]](x, a => HttpResponse[R](a)))})
  }

  /**
    * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` multimap encoded as form and the content type
    * set to `application/x-www-form-urlencoded`.
    * 
    * When the content type header is previously set to `multipart/form-data` it will be used instead.
    * @param body the body
    */
  def sendForm(body: MultiMap,handler: Handler[AsyncResult[HttpResponse[io.vertx.core.buffer.Buffer]]]):Unit = {
    asJava.asInstanceOf[JHttpRequest].sendForm(body.asJava.asInstanceOf[JMultiMap],{x: AsyncResult[JHttpResponse[Buffer]] => handler.handle(AsyncResultWrapper[JHttpResponse[Buffer],HttpResponse[io.vertx.core.buffer.Buffer]](x, a => HttpResponse[io.vertx.core.buffer.Buffer](a)))})
  }

  /**
    * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` multimap encoded as a form and the content type
    * set to `application/x-www-form-urlencoded`.
    * 
    * When the content type header is previously set to `multipart/form-data` it will be used instead.
    * @param body the body
    * @param responseCodec the codec to decode the response
    */
  def sendForm[R:TypeTag](body: MultiMap,responseCodec: BodyCodec[R],handler: Handler[AsyncResult[HttpResponse[R]]]):Unit = {
    asJava.asInstanceOf[JHttpRequest].sendForm[Object](body.asJava.asInstanceOf[JMultiMap],responseCodec.asJava.asInstanceOf[JBodyCodec[Object]],{x: AsyncResult[JHttpResponse[Object]] => handler.handle(AsyncResultWrapper[JHttpResponse[Object],HttpResponse[R]](x, a => HttpResponse[R](a)))})
  }

  /**
    * Send a request, the `handler` will receive the response as an [[io.vertx.scala.webclient.HttpResponse]].
    */
  def send(handler: Handler[AsyncResult[HttpResponse[io.vertx.core.buffer.Buffer]]]):Unit = {
    asJava.asInstanceOf[JHttpRequest].send({x: AsyncResult[JHttpResponse[Buffer]] => handler.handle(AsyncResultWrapper[JHttpResponse[Buffer],HttpResponse[io.vertx.core.buffer.Buffer]](x, a => HttpResponse[io.vertx.core.buffer.Buffer](a)))})
  }

  /**
    * Send a request, the `handler` will receive the response as an [[io.vertx.scala.webclient.HttpResponse]] decoded using
    * the provided `responseCodec`.
    * @param responseCodec the codec to decode the response
    */
  def send[R:TypeTag](responseCodec: BodyCodec[R],handler: Handler[AsyncResult[HttpResponse[R]]]):Unit = {
    asJava.asInstanceOf[JHttpRequest].send[Object](responseCodec.asJava.asInstanceOf[JBodyCodec[Object]],{x: AsyncResult[JHttpResponse[Object]] => handler.handle(AsyncResultWrapper[JHttpResponse[Object],HttpResponse[R]](x, a => HttpResponse[R](a)))})
  }

 /**
   * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` stream.
   * @param body the body
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendStreamFuture(body: ReadStream[io.vertx.core.buffer.Buffer]):scala.concurrent.Future[HttpResponse[io.vertx.core.buffer.Buffer]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Buffer], HttpResponse[io.vertx.core.buffer.Buffer]](x => HttpResponse[io.vertx.core.buffer.Buffer](x))
    asJava.asInstanceOf[JHttpRequest].sendStream(body.asJava.asInstanceOf[JReadStream[Buffer]],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` stream.
   * @param body the body
   * @param responseCodec the codec to decode the response
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendStreamFuture[R:TypeTag](body: ReadStream[io.vertx.core.buffer.Buffer],responseCodec: BodyCodec[R]):scala.concurrent.Future[HttpResponse[R]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[R]](x => HttpResponse[R](x))
    asJava.asInstanceOf[JHttpRequest].sendStream[Object](body.asJava.asInstanceOf[JReadStream[Buffer]],responseCodec.asJava.asInstanceOf[JBodyCodec[Object]],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` buffer.
   * @param body the body
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendBufferFuture(body: io.vertx.core.buffer.Buffer):scala.concurrent.Future[HttpResponse[io.vertx.core.buffer.Buffer]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Buffer], HttpResponse[io.vertx.core.buffer.Buffer]](x => HttpResponse[io.vertx.core.buffer.Buffer](x))
    asJava.asInstanceOf[JHttpRequest].sendBuffer(body,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` buffer.
   * @param body the body
   * @param responseCodec the codec to decode the response
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendBufferFuture[R:TypeTag](body: io.vertx.core.buffer.Buffer,responseCodec: BodyCodec[R]):scala.concurrent.Future[HttpResponse[R]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[R]](x => HttpResponse[R](x))
    asJava.asInstanceOf[JHttpRequest].sendBuffer[Object](body,responseCodec.asJava.asInstanceOf[JBodyCodec[Object]],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` object encoded as json and the content type
   * set to `application/json`.
   * @param body the body
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendJsonObjectFuture(body: io.vertx.core.json.JsonObject):scala.concurrent.Future[HttpResponse[io.vertx.core.buffer.Buffer]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Buffer], HttpResponse[io.vertx.core.buffer.Buffer]](x => HttpResponse[io.vertx.core.buffer.Buffer](x))
    asJava.asInstanceOf[JHttpRequest].sendJsonObject(body,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` object encoded as json and the content type
   * set to `application/json`.
   * @param body the body
   * @param responseCodec the codec to decode the response
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendJsonObjectFuture[R:TypeTag](body: io.vertx.core.json.JsonObject,responseCodec: BodyCodec[R]):scala.concurrent.Future[HttpResponse[R]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[R]](x => HttpResponse[R](x))
    asJava.asInstanceOf[JHttpRequest].sendJsonObject[Object](body,responseCodec.asJava.asInstanceOf[JBodyCodec[Object]],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` object encoded as json and the content type
   * set to `application/json`.
   * @param body the body
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendJsonFuture(body: AnyRef):scala.concurrent.Future[HttpResponse[io.vertx.core.buffer.Buffer]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Buffer], HttpResponse[io.vertx.core.buffer.Buffer]](x => HttpResponse[io.vertx.core.buffer.Buffer](x))
    asJava.asInstanceOf[JHttpRequest].sendJson(body,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` object encoded as json and the content type
   * set to `application/json`.
   * @param body the body
   * @param responseCodec the codec to decode the response
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendJsonFuture[R:TypeTag](body: AnyRef,responseCodec: BodyCodec[R]):scala.concurrent.Future[HttpResponse[R]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[R]](x => HttpResponse[R](x))
    asJava.asInstanceOf[JHttpRequest].sendJson[Object](body,responseCodec.asJava.asInstanceOf[JBodyCodec[Object]],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` multimap encoded as form and the content type
   * set to `application/x-www-form-urlencoded`.
   * 
   * When the content type header is previously set to `multipart/form-data` it will be used instead.
   * @param body the body
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendFormFuture(body: MultiMap):scala.concurrent.Future[HttpResponse[io.vertx.core.buffer.Buffer]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Buffer], HttpResponse[io.vertx.core.buffer.Buffer]](x => HttpResponse[io.vertx.core.buffer.Buffer](x))
    asJava.asInstanceOf[JHttpRequest].sendForm(body.asJava.asInstanceOf[JMultiMap],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.webclient.HttpRequest#sendFuture]] but with an HTTP request `body` multimap encoded as a form and the content type
   * set to `application/x-www-form-urlencoded`.
   * 
   * When the content type header is previously set to `multipart/form-data` it will be used instead.
   * @param body the body
   * @param responseCodec the codec to decode the response
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendFormFuture[R:TypeTag](body: MultiMap,responseCodec: BodyCodec[R]):scala.concurrent.Future[HttpResponse[R]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[R]](x => HttpResponse[R](x))
    asJava.asInstanceOf[JHttpRequest].sendForm[Object](body.asJava.asInstanceOf[JMultiMap],responseCodec.asJava.asInstanceOf[JBodyCodec[Object]],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Send a request, the `handler` will receive the response as an [[io.vertx.scala.webclient.HttpResponse]].
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendFuture():scala.concurrent.Future[HttpResponse[io.vertx.core.buffer.Buffer]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Buffer], HttpResponse[io.vertx.core.buffer.Buffer]](x => HttpResponse[io.vertx.core.buffer.Buffer](x))
    asJava.asInstanceOf[JHttpRequest].send(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Send a request, the `handler` will receive the response as an [[io.vertx.scala.webclient.HttpResponse]] decoded using
   * the provided `responseCodec`.
   * @param responseCodec the codec to decode the response
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def sendFuture[R:TypeTag](responseCodec: BodyCodec[R]):scala.concurrent.Future[HttpResponse[R]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[R]](x => HttpResponse[R](x))
    asJava.asInstanceOf[JHttpRequest].send[Object](responseCodec.asJava.asInstanceOf[JBodyCodec[Object]],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object HttpRequest{
  def apply(asJava: JHttpRequest) = new HttpRequest(asJava)  
}
