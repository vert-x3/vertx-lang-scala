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

import scala.collection.JavaConverters._
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
     * Like [[executeCommandWithFallback]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def executeCommandWithFallbackFuture[T](command: io.vertx.core.Future[T] => Unit,fallback: Throwable => T): scala.concurrent.Future[T] = {
      val promise = Promise[T]()
      asJava.executeCommandWithFallback[T]({x: io.vertx.core.Future[T] => command(x)}, {x: Throwable => fallback(x)}, {a:AsyncResult[T] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[executeCommand]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def executeCommandFuture[T](command: io.vertx.core.Future[T] => Unit): scala.concurrent.Future[T] = {
      val promise = Promise[T]()
      asJava.executeCommand[T]({x: io.vertx.core.Future[T] => command(x)}, {a:AsyncResult[T] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  type CircuitBreakerOptions = io.vertx.circuitbreaker.CircuitBreakerOptions

  object CircuitBreakerOptions {
    def apply() = new CircuitBreakerOptions()
    def apply(json: JsonObject) = new CircuitBreakerOptions(json)
  }



}
