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

import io.vertx.ext.web.client.predicate
import io.vertx.ext.web.codec
import io.vertx.ext.web.multipart.{MultipartForm => JMultipartForm}
import io.vertx.ext.web.codec.{BodyCodec => JBodyCodec}
import io.vertx.core
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.ext.web.client.{HttpRequest => JHttpRequest}
import io.vertx.ext.web.client.predicate.{ResponsePredicate => JResponsePredicate}
import io.vertx.core.http
import io.vertx.ext.web.multipart
import io.vertx.ext.web.client.{HttpResponse => JHttpResponse}
import io.vertx.ext.web.client.predicate.{ResponsePredicateResult => JResponsePredicateResult}
import io.vertx.core.buffer.Buffer
import io.vertx.core.streams
import io.vertx.core.{Future => JFuture}
import io.vertx.core.http.{HttpMethod => JHttpMethod}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

package object client{

  object ErrorConverter {
    /**
     * Like create from [[io.vertx.ext.web.client.predicate.ErrorConverter]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def create(converter: io.vertx.ext.web.client.predicate.ResponsePredicateResult => Throwable) = {
      io.vertx.ext.web.client.predicate.ErrorConverter.create({x: io.vertx.ext.web.client.predicate.ResponsePredicateResult => converter(x)})
}
    /**
     * Like createFullBody from [[io.vertx.ext.web.client.predicate.ErrorConverter]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def createFullBody(converter: io.vertx.ext.web.client.predicate.ResponsePredicateResult => Throwable) = {
      io.vertx.ext.web.client.predicate.ErrorConverter.createFullBody({x: io.vertx.ext.web.client.predicate.ResponsePredicateResult => converter(x)})
}
  }



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
     * Like sendJson from [[io.vertx.ext.web.client.HttpRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def sendJson(body: scala.Option[AnyRef],handler: AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => Unit) = {
      scala.Option(asJava.sendJson(body.getOrElse(null), handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]]]))
}

    /**
     * Like sendStream from [[io.vertx.ext.web.client.HttpRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def sendStreamFuture(body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = concurrent.Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendStream(body, new Handler[AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]] { override def handle(event: AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sendBuffer from [[io.vertx.ext.web.client.HttpRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def sendBufferFuture(body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = concurrent.Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendBuffer(body, new Handler[AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]] { override def handle(event: AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sendJsonObject from [[io.vertx.ext.web.client.HttpRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def sendJsonObjectFuture(body: io.vertx.core.json.JsonObject) : scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = concurrent.Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendJsonObject(body, new Handler[AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]] { override def handle(event: AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sendJson from [[io.vertx.ext.web.client.HttpRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def sendJsonFuture(body: scala.Option[AnyRef]) : scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = concurrent.Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendJson(body.getOrElse(null), new Handler[AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]] { override def handle(event: AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sendForm from [[io.vertx.ext.web.client.HttpRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def sendFormFuture(body: io.vertx.core.MultiMap) : scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = concurrent.Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendForm(body, new Handler[AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]] { override def handle(event: AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sendMultipartForm from [[io.vertx.ext.web.client.HttpRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def sendMultipartFormFuture(body: io.vertx.ext.web.multipart.MultipartForm) : scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = concurrent.Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendMultipartForm(body, new Handler[AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]] { override def handle(event: AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like send from [[io.vertx.ext.web.client.HttpRequest]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def sendFuture() : scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = concurrent.Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.send(new Handler[AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]] { override def handle(event: AsyncResult[io.vertx.ext.web.client.HttpResponse[T]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }




  object ResponsePredicate {
    /**
     * Like status from [[io.vertx.ext.web.client.predicate.ResponsePredicate]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def status(statusCode: java.lang.Integer) = {
      io.vertx.ext.web.client.predicate.ResponsePredicate.status(statusCode)
}
    /**
     * Like status from [[io.vertx.ext.web.client.predicate.ResponsePredicate]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def status(min: java.lang.Integer,max: java.lang.Integer) = {
      io.vertx.ext.web.client.predicate.ResponsePredicate.status(min, max)
}
    /**
     * Like contentType from [[io.vertx.ext.web.client.predicate.ResponsePredicate]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def contentType(mimeType: java.lang.String) = {
      io.vertx.ext.web.client.predicate.ResponsePredicate.contentType(mimeType)
}
    /**
     * Like contentType from [[io.vertx.ext.web.client.predicate.ResponsePredicate]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def contentType(mimeTypes: java.util.List[java.lang.String]) = {
      io.vertx.ext.web.client.predicate.ResponsePredicate.contentType(mimeTypes)
}
    /**
     * Like create from [[io.vertx.ext.web.client.predicate.ResponsePredicate]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def create(test: io.vertx.ext.web.client.HttpResponse[Void] => io.vertx.ext.web.client.predicate.ResponsePredicateResult) = {
      io.vertx.ext.web.client.predicate.ResponsePredicate.create({x: io.vertx.ext.web.client.HttpResponse[Void] => test(x)})
}
    /**
     * Like create from [[io.vertx.ext.web.client.predicate.ResponsePredicate]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def create(test: io.vertx.ext.web.client.HttpResponse[Void] => io.vertx.ext.web.client.predicate.ResponsePredicateResult,errorConverter: io.vertx.ext.web.client.predicate.ErrorConverter) = {
      io.vertx.ext.web.client.predicate.ResponsePredicate.create({x: io.vertx.ext.web.client.HttpResponse[Void] => test(x)}, errorConverter)
}
  }


  object ResponsePredicateResult {
    /**
     * Like success from [[io.vertx.ext.web.client.predicate.ResponsePredicateResult]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def success() = {
      io.vertx.ext.web.client.predicate.ResponsePredicateResult.success()
}
    /**
     * Like failure from [[io.vertx.ext.web.client.predicate.ResponsePredicateResult]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def failure(message: java.lang.String) = {
      io.vertx.ext.web.client.predicate.ResponsePredicateResult.failure(message)
}
  }


  object WebClient {
    /**
     * Like create from [[io.vertx.ext.web.client.WebClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def create(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.web.client.WebClient.create(vertx)
}
    /**
     * Like create from [[io.vertx.ext.web.client.WebClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def create(vertx: io.vertx.core.Vertx,options: io.vertx.ext.web.client.WebClientOptions) = {
      io.vertx.ext.web.client.WebClient.create(vertx, options)
}
    /**
     * Like wrap from [[io.vertx.ext.web.client.WebClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def wrap(httpClient: io.vertx.core.http.HttpClient) = {
      io.vertx.ext.web.client.WebClient.wrap(httpClient)
}
    /**
     * Like wrap from [[io.vertx.ext.web.client.WebClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def wrap(httpClient: io.vertx.core.http.HttpClient,options: io.vertx.ext.web.client.WebClientOptions) = {
      io.vertx.ext.web.client.WebClient.wrap(httpClient, options)
}
  }


    type WebClientOptions = io.vertx.ext.web.client.WebClientOptions
  object WebClientOptions {
    def apply() = new WebClientOptions()
    def apply(json: JsonObject) = new WebClientOptions(json)
  }



}
