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

package io.vertx.scala.circuitbreaker

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.circuitbreaker.{HystrixMetricHandler => JHystrixMetricHandler}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.scala.ext.web.RoutingContext

/**
  * A Vert.x web handler to expose the circuit breaker to the Hystrix dasbboard. The handler listens to the circuit
  * breaker notifications sent on the event bus.
  */
class HystrixMetricHandler(private val _asJava: JHystrixMetricHandler) 
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava: JHystrixMetricHandler = _asJava

  def handle(arg0: RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object HystrixMetricHandler {

  def apply(_asJava: JHystrixMetricHandler): HystrixMetricHandler =
    new HystrixMetricHandler(_asJava)

  def create(vertx: Vertx): HystrixMetricHandler = {
    HystrixMetricHandler.apply(io.vertx.circuitbreaker.HystrixMetricHandler.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  def create(vertx: Vertx, address: String): HystrixMetricHandler = {
    HystrixMetricHandler.apply(io.vertx.circuitbreaker.HystrixMetricHandler.create(vertx.asJava.asInstanceOf[JVertx], address))
  }

}
