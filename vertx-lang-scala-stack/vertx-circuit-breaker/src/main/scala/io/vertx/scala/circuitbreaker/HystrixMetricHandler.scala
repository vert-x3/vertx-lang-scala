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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.circuitbreaker.{HystrixMetricHandler => JHystrixMetricHandler}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * A Vert.x web handler to expose the circuit breaker to the Hystrix dasbboard. The handler listens to the circuit
  * breaker notifications sent on the event bus.
  */
class HystrixMetricHandler(private val _asJava: Object)
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava = _asJava

  override def handle(arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JHystrixMetricHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object HystrixMetricHandler {
  def apply(asJava: JHystrixMetricHandler) = new HystrixMetricHandler(asJava)  
  /**
    * Creates the handler, using the default notification address.
    * @param vertx the Vert.x instance
    * @return the handler
    */
  def create(vertx: Vertx): HystrixMetricHandler = {
    HystrixMetricHandler(JHystrixMetricHandler.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Creates the handler.
    * @param vertx the Vert.x instance
    * @param address the address to listen on the event bus
    * @return the handler
    */
  def create(vertx: Vertx, address: String): HystrixMetricHandler = {
    HystrixMetricHandler(JHystrixMetricHandler.create(vertx.asJava.asInstanceOf[JVertx], address.asInstanceOf[java.lang.String]))
  }

}
