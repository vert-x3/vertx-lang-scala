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

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.web.client.predicate
import io.vertx.ext.web.codec
import io.vertx.ext.web.multipart.{MultipartForm => JMultipartForm}
import io.vertx.ext.web.codec.{BodyCodec => JBodyCodec}
import io.vertx.core
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.ext.web.client.{HttpRequest => JHttpRequest}
import io.vertx.ext.web.client.predicate.{ResponsePredicate => JResponsePredicate}
import io.vertx.ext.web.multipart
import io.vertx.ext.web.client.{HttpResponse => JHttpResponse}
import io.vertx.ext.web.client.predicate.{ResponsePredicateResult => JResponsePredicateResult}
import io.vertx.core.buffer.Buffer
import io.vertx.core.streams
import io.vertx.core.http.HttpMethod
import io.vertx.core.{Future => JFuture}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

package object client{

  type ErrorConverter = io.vertx.ext.web.client.predicate.ErrorConverter



  /**
    * A client-side HTTP request.
    * 
    * Instances are created by an [[io.vertx.ext.web.client.WebClient]] instance, via one of the methods corresponding to the specific
    * HTTP methods such as [[io.vertx.ext.web.client.WebClient#get]], etc...
    * 
    * The request shall be configured prior sending, the request is immutable and when a mutator method
    * is called, a new request is returned allowing to expose the request in a public API and apply further customization.
    * 
    * After the request has been configured, the methods
    * <ul>
    *   <li>[[io.vertx.ext.web.client.HttpRequest#send]]</li>
    *   <li>[[io.vertx.ext.web.client.HttpRequest#sendStream]]</li>
    *   <li>[[io.vertx.ext.web.client.HttpRequest#sendJson]] ()}</li>
    *   <li>[[io.vertx.ext.web.client.HttpRequest#sendForm]]</li>
    * </ul>
    * can be called.
    * The `sendXXX` methods perform the actual request, they can be called multiple times to perform the same HTTP
    * request at different points in time.
    * 
    * The handler is called back with
    * <ul>
    *   <li>an [[io.vertx.ext.web.client.HttpResponse]] instance when the HTTP response has been received</li>
    *   <li>a failure when the HTTP request failed (like a connection error) or when the HTTP response could
    *   not be obtained (like connection or unmarshalling errors)</li>
    * </ul>
    * 
    * Most of the time, this client will buffer the HTTP response fully unless a specific  is used
    * such as .
    */

  implicit class HttpRequestScala[T](val asJava: io.vertx.ext.web.client.HttpRequest[T]) extends AnyVal {


    /**
     * Like [[sendJson]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendJson(body: AnyRef,handler: AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => Unit): Unit = {
      asJava.sendJson(body, {p:AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => handler(p)})
    }

    /**
     * Like [[sendStream]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendStreamFuture(body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendStream(body, {a:AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sendBuffer]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendBufferFuture(body: io.vertx.core.buffer.Buffer): scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendBuffer(body, {a:AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sendJsonObject]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendJsonObjectFuture(body: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendJsonObject(body, {a:AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sendJson]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendJsonFuture(body: AnyRef): scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendJson(body, {a:AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sendForm]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFormFuture(body: io.vertx.core.MultiMap): scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendForm(body, {a:AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sendMultipartForm]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendMultipartFormFuture(body: io.vertx.ext.web.multipart.MultipartForm): scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendMultipartForm(body, {a:AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture(): scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.send({a:AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  type HttpResponse[T] = io.vertx.ext.web.client.HttpResponse[T]


  type ResponsePredicate = io.vertx.ext.web.client.predicate.ResponsePredicate


  type ResponsePredicateResult = io.vertx.ext.web.client.predicate.ResponsePredicateResult


  type WebClient = io.vertx.ext.web.client.WebClient



  type WebClientOptions = io.vertx.ext.web.client.WebClientOptions
  object WebClientOptions {
    def apply() = new WebClientOptions()
    def apply(json: JsonObject) = new WebClientOptions(json)
  }



}
