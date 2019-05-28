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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.web.multipart.{MultipartForm => JMultipartForm}
import io.vertx.ext.web.codec.{BodyCodec => JBodyCodec}
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import io.vertx.ext.web.client.{HttpRequest => JHttpRequest}
import io.vertx.ext.web.client.predicate.{ResponsePredicate => JResponsePredicate}
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.client.{HttpResponse => JHttpResponse}
import io.vertx.ext.web.client.predicate.{ResponsePredicateResult => JResponsePredicateResult}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.ext.web.multipart.MultipartForm
import io.vertx.core.buffer.Buffer
import io.vertx.scala.ext.web.client.predicate.ResponsePredicate
import io.vertx.core.http.HttpMethod
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.MultiMap
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.ext.web.client.predicate.ResponsePredicateResult
import io.vertx.scala.ext.web.codec.BodyCodec
import io.vertx.lang.scala.HandlerOps._

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
  *   <li>[[io.vertx.scala.ext.web.client.HttpRequest#send]]</li>
  *   <li>[[io.vertx.scala.ext.web.client.HttpRequest#sendStream]]</li>
  *   <li>[[io.vertx.scala.ext.web.client.HttpRequest#sendJson]] ()}</li>
  *   <li>[[io.vertx.scala.ext.web.client.HttpRequest#sendForm]]</li>
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
  private var cached_0: Option[MultiMap] = None


  /**
   * @return The HTTP headers
   */
  def headers(): MultiMap = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JHttpRequest[Object]].headers()
      cached_0 = Some(MultiMap(tmp))
    }
    cached_0.get
  }


  /**
   * Configure the request to use a new method `value`.   * @return a reference to this, so the API can be used fluently
   */
  
  def method(value: io.vertx.core.http.HttpMethod): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].method(value)
    this
  }

  /**
   * Configure the request to use a new port `value`.   * @return a reference to this, so the API can be used fluently
   */
  
  def port(value: Int): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].port(value.asInstanceOf[java.lang.Integer])
    this
  }

  /**
   * Configure the request to use a new host `value`.   * @return a reference to this, so the API can be used fluently
   */
  
  def host(value: String): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].host(value.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Configure the request to use a virtual host `value`.
   * <p/>
   * Usually the header <i>host</i> (<i>:authority</i> pseudo header for HTTP/2) is set from the request host value
   * since this host value resolves to the server IP address.
   * <p/>
   * Sometimes you need to set a host header for an address that does not resolve to the server IP address.
   * The virtual host value overrides the value of the actual <i>host</i> header (<i>:authority</i> pseudo header
   * for HTTP/2).
   * <p/>
   * The virtual host is also be used for SNI.   * @return a reference to this, so the API can be used fluently
   */
  
  def virtualHost(value: String): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].virtualHost(value.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Configure the request to use a new request URI `value`.
   * 
   * When the uri has query parameters, they are set in the [[io.vertx.scala.ext.web.client.HttpRequest#queryParams]] multimap, overwritting
   * any parameters previously set.   * @return a reference to this, so the API can be used fluently
   */
  
  def uri(value: String): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].uri(value.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Configure the request to add multiple HTTP headers .   * @param headers The HTTP headers
   * @return a reference to this, so the API can be used fluently
   */
  
  def putHeaders(headers: MultiMap): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].putHeaders(headers.asJava.asInstanceOf[JMultiMap])
    this
  }

  /**
   * Configure the request to add a new HTTP header.   * @param name the header name
   * @param value the header value
   * @return a reference to this, so the API can be used fluently
   */
  
  def putHeader(name: String, value: String): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].putHeader(name.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Configure the request to perform basic access authentication.
   * 
   * In basic HTTP authentication, a request contains a header field of the form 'Authorization: Basic &#60;credentials&#62;',
   * where credentials is the base64 encoding of id and password joined by a colon.
   * </p>   * @param id the id
   * @param password the password
   * @return a reference to this, so the API can be used fluently
   */
  
  def basicAuthentication(id: String, password: String): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].basicAuthentication(id.asInstanceOf[java.lang.String], password.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Configure the request to perform basic access authentication.
   * 
   * In basic HTTP authentication, a request contains a header field of the form 'Authorization: Basic &#60;credentials&#62;',
   * where credentials is the base64 encoding of id and password joined by a colon.
   * </p>   * @param id the id
   * @param password the password
   * @return a reference to this, so the API can be used fluently
   */
  
  def basicAuthentication(id: io.vertx.core.buffer.Buffer, password: io.vertx.core.buffer.Buffer): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].basicAuthentication(id, password)
    this
  }

  /**
   * Configure the request to perform bearer token authentication.
   * 
   * In OAuth 2.0, a request contains a header field of the form 'Authorization: Bearer &#60;bearerToken&#62;',
   * where bearerToken is the bearer token issued by an authorization server to access protected resources.
   * </p>   * @param bearerToken the bearer token
   * @return a reference to this, so the API can be used fluently
   */
  
  def bearerTokenAuthentication(bearerToken: String): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].bearerTokenAuthentication(bearerToken.asInstanceOf[java.lang.String])
    this
  }


  
  def ssl(value: Boolean): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].ssl(value.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Configures the amount of time in milliseconds after which if the request does not return any data within the timeout
   * period an TimeoutException fails the request.
   * 
   * Setting zero or a negative `value` disables the timeout.   * @param value The quantity of time in milliseconds.
   * @return a reference to this, so the API can be used fluently
   */
  
  def timeout(value: Long): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].timeout(value.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Add a query parameter to the request.   * @param paramName the param name
   * @param paramValue the param value
   * @return a reference to this, so the API can be used fluently
   */
  
  def addQueryParam(paramName: String, paramValue: String): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].addQueryParam(paramName.asInstanceOf[java.lang.String], paramValue.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Set a query parameter to the request.   * @param paramName the param name
   * @param paramValue the param value
   * @return a reference to this, so the API can be used fluently
   */
  
  def setQueryParam(paramName: String, paramValue: String): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].setQueryParam(paramName.asInstanceOf[java.lang.String], paramValue.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Set wether or not to follow the directs for the request.   * @param value true if redirections should be followed
   * @return a reference to this, so the API can be used fluently
   */
  
  def followRedirects(value: Boolean): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].followRedirects(value.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Add an expectation that the response is valid according to the provided `predicate`.
   * 
   * Multiple predicates can be added.   * @param predicate the predicate
   * @return a reference to this, so the API can be used fluently
   */
  
  def expect(predicate: HttpResponse[Unit] => ResponsePredicateResult): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].expect({x: JHttpResponse[Void] => predicate(HttpResponse[Unit](x)).asJava.asInstanceOf[JResponsePredicateResult]})
    this
  }

  /**
   * Add an expectation that the response is valid according to the provided `predicate`.
   * 
   * Multiple predicates can be added.   * @param predicate the predicate
   * @return a reference to this, so the API can be used fluently
   */
  
  def expect(predicate: ResponsePredicate): HttpRequest[T] = {
    asJava.asInstanceOf[JHttpRequest[Object]].expect(predicate.asJava.asInstanceOf[JResponsePredicate])
    this
  }



  /**
   * Configure the request to decode the response with the `responseCodec`.   * @param responseCodec the response codec
   * @return a reference to this, so the API can be used fluently
   */
  def as [U: TypeTag](responseCodec: BodyCodec[U]): HttpRequest[U] = {
    HttpRequest[U](asJava.asInstanceOf[JHttpRequest[Object]].as[Object](responseCodec.asJava.asInstanceOf[JBodyCodec[Object]]))
  }

  /**
   * Return the current query parameters.   * @return the current query parameters
   */
  def queryParams (): MultiMap = {
    MultiMap(asJava.asInstanceOf[JHttpRequest[Object]].queryParams())
  }

  /**
   * Copy this request   * @return a copy of this request
   */
  def copy (): HttpRequest[T] = {
    HttpRequest[T](asJava.asInstanceOf[JHttpRequest[Object]].copy())
  }

  /**
   * Like [[io.vertx.scala.ext.web.client.HttpRequest#send]] but with an HTTP request `body` stream.   * @param body the body
   */
  def sendStream (body: ReadStream[io.vertx.core.buffer.Buffer], handler: Handler[AsyncResult[HttpResponse[T]]]): Unit = {
    asJava.asInstanceOf[JHttpRequest[Object]].sendStream(body.asJava.asInstanceOf[JReadStream[Buffer]], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JHttpResponse[Object]]]{def handle(x: AsyncResult[JHttpResponse[Object]]) {handler.handle(AsyncResultWrapper[JHttpResponse[Object], HttpResponse[T]](x, a => HttpResponse[T](a)))}}))
  }

  /**
   * Like [[io.vertx.scala.ext.web.client.HttpRequest#send]] but with an HTTP request `body` buffer.   * @param body the body
   */
  def sendBuffer (body: io.vertx.core.buffer.Buffer, handler: Handler[AsyncResult[HttpResponse[T]]]): Unit = {
    asJava.asInstanceOf[JHttpRequest[Object]].sendBuffer(body, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JHttpResponse[Object]]]{def handle(x: AsyncResult[JHttpResponse[Object]]) {handler.handle(AsyncResultWrapper[JHttpResponse[Object], HttpResponse[T]](x, a => HttpResponse[T](a)))}}))
  }

  /**
   * Like [[io.vertx.scala.ext.web.client.HttpRequest#send]] but with an HTTP request `body` object encoded as json and the content type
   * set to `application/json`.   * @param body the body
   */
  def sendJsonObject (body: io.vertx.core.json.JsonObject, handler: Handler[AsyncResult[HttpResponse[T]]]): Unit = {
    asJava.asInstanceOf[JHttpRequest[Object]].sendJsonObject(body, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JHttpResponse[Object]]]{def handle(x: AsyncResult[JHttpResponse[Object]]) {handler.handle(AsyncResultWrapper[JHttpResponse[Object], HttpResponse[T]](x, a => HttpResponse[T](a)))}}))
  }

  /**
   * Like [[io.vertx.scala.ext.web.client.HttpRequest#send]] but with an HTTP request `body` object encoded as json and the content type
   * set to `application/json`.   * @param body the body
   */
  def sendJson (body: AnyRef, handler: Handler[AsyncResult[HttpResponse[T]]]): Unit = {
    asJava.asInstanceOf[JHttpRequest[Object]].sendJson(body, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JHttpResponse[Object]]]{def handle(x: AsyncResult[JHttpResponse[Object]]) {handler.handle(AsyncResultWrapper[JHttpResponse[Object], HttpResponse[T]](x, a => HttpResponse[T](a)))}}))
  }

  /**
   * Like [[io.vertx.scala.ext.web.client.HttpRequest#send]] but with an HTTP request `body` multimap encoded as form and the content type
   * set to `application/x-www-form-urlencoded`.
   * 
   * When the content type header is previously set to `multipart/form-data` it will be used instead.   * @param body the body
   */
  def sendForm (body: MultiMap, handler: Handler[AsyncResult[HttpResponse[T]]]): Unit = {
    asJava.asInstanceOf[JHttpRequest[Object]].sendForm(body.asJava.asInstanceOf[JMultiMap], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JHttpResponse[Object]]]{def handle(x: AsyncResult[JHttpResponse[Object]]) {handler.handle(AsyncResultWrapper[JHttpResponse[Object], HttpResponse[T]](x, a => HttpResponse[T](a)))}}))
  }

  /**
   * Like [[io.vertx.scala.ext.web.client.HttpRequest#send]] but with an HTTP request `body` multimap encoded as form and the content type
   * set to `multipart/form-data`. You may use this method to send attributes and upload files.   * @param body the body
   */
  def sendMultipartForm (body: MultipartForm, handler: Handler[AsyncResult[HttpResponse[T]]]): Unit = {
    asJava.asInstanceOf[JHttpRequest[Object]].sendMultipartForm(body.asJava.asInstanceOf[JMultipartForm], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JHttpResponse[Object]]]{def handle(x: AsyncResult[JHttpResponse[Object]]) {handler.handle(AsyncResultWrapper[JHttpResponse[Object], HttpResponse[T]](x, a => HttpResponse[T](a)))}}))
  }

  /**
   * Send a request, the `handler` will receive the response as an [[io.vertx.scala.ext.web.client.HttpResponse]].
   */
  def send (handler: Handler[AsyncResult[HttpResponse[T]]]): Unit = {
    asJava.asInstanceOf[JHttpRequest[Object]].send((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JHttpResponse[Object]]]{def handle(x: AsyncResult[JHttpResponse[Object]]) {handler.handle(AsyncResultWrapper[JHttpResponse[Object], HttpResponse[T]](x, a => HttpResponse[T](a)))}}))
  }


 /**
  * Like [[sendStream]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendStreamFuture (body: ReadStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[HttpResponse[T]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[T]](x => HttpResponse[T](x))
    asJava.asInstanceOf[JHttpRequest[Object]].sendStream(body.asJava.asInstanceOf[JReadStream[Buffer]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sendBuffer]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendBufferFuture (body: io.vertx.core.buffer.Buffer): scala.concurrent.Future[HttpResponse[T]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[T]](x => HttpResponse[T](x))
    asJava.asInstanceOf[JHttpRequest[Object]].sendBuffer(body, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sendJsonObject]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendJsonObjectFuture (body: io.vertx.core.json.JsonObject): scala.concurrent.Future[HttpResponse[T]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[T]](x => HttpResponse[T](x))
    asJava.asInstanceOf[JHttpRequest[Object]].sendJsonObject(body, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sendJson]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendJsonFuture (body: AnyRef): scala.concurrent.Future[HttpResponse[T]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[T]](x => HttpResponse[T](x))
    asJava.asInstanceOf[JHttpRequest[Object]].sendJson(body, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sendForm]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendFormFuture (body: MultiMap): scala.concurrent.Future[HttpResponse[T]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[T]](x => HttpResponse[T](x))
    asJava.asInstanceOf[JHttpRequest[Object]].sendForm(body.asJava.asInstanceOf[JMultiMap], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sendMultipartForm]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendMultipartFormFuture (body: MultipartForm): scala.concurrent.Future[HttpResponse[T]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[T]](x => HttpResponse[T](x))
    asJava.asInstanceOf[JHttpRequest[Object]].sendMultipartForm(body.asJava.asInstanceOf[JMultipartForm], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendFuture (): scala.concurrent.Future[HttpResponse[T]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpResponse[Object], HttpResponse[T]](x => HttpResponse[T](x))
    asJava.asInstanceOf[JHttpRequest[Object]].send(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object HttpRequest {
  def apply[T: TypeTag](asJava: JHttpRequest[_]) = new HttpRequest[T](asJava)
  
}
