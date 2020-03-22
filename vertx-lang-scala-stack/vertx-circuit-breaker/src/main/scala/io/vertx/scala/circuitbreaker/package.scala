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

package io.vertx.scala

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.web
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.core
import io.vertx.circuitbreaker.{HystrixMetricHandler => JHystrixMetricHandler}
import io.vertx.core.Handler
import io.vertx.core.{Vertx => JVertx}

package object circuitbreaker{


  /**
    * An implementation of the circuit breaker pattern for Vert.x
    */

  implicit class CircuitBreakerScala(val asJava: io.vertx.circuitbreaker.CircuitBreaker) extends AnyVal {

    /**
     * Like executeWithFallback from [[io.vertx.circuitbreaker.CircuitBreaker]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def executeWithFallbackFuture[T](command: io.vertx.core.Promise[T] => Unit,fallback: Throwable => T) : scala.concurrent.Future[T] = {
      val promise = concurrent.Promise[T]()
      asJava.executeWithFallback[T](command.asInstanceOf[io.vertx.core.Handler[io.vertx.core.Promise[T]]], {x: Throwable => fallback(x)}, new Handler[AsyncResult[T]] { override def handle(event: AsyncResult[T]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like execute from [[io.vertx.circuitbreaker.CircuitBreaker]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def executeFuture[T](command: io.vertx.core.Promise[T] => Unit) : scala.concurrent.Future[T] = {
      val promise = concurrent.Promise[T]()
      asJava.execute[T](command.asInstanceOf[io.vertx.core.Handler[io.vertx.core.Promise[T]]], new Handler[AsyncResult[T]] { override def handle(event: AsyncResult[T]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }



  type CircuitBreakerOptions = io.vertx.circuitbreaker.CircuitBreakerOptions
  object CircuitBreakerOptions {
    def apply() = new CircuitBreakerOptions()
    def apply(json: JsonObject) = new CircuitBreakerOptions(json)
  }





}
