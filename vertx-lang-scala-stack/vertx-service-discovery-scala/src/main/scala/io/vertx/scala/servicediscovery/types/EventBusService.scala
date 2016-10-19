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

package io.vertx.scala.servicediscovery.types

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.servicediscovery.spi.ServiceType
import io.vertx.core.json.JsonObject
import io.vertx.servicediscovery.Record
import io.vertx.scala.servicediscovery.ServiceDiscovery
import io.vertx.core.Handler

/**
  *  for event bus services (service proxies).
  * Consumers receive a service proxy to use the service.
  */
class EventBusService(private val _asJava: io.vertx.servicediscovery.types.EventBusService) {

  def asJava: io.vertx.servicediscovery.types.EventBusService = _asJava

}

object EventBusService {

  def apply(_asJava: io.vertx.servicediscovery.types.EventBusService): io.vertx.scala.servicediscovery.types.EventBusService =
    new io.vertx.scala.servicediscovery.types.EventBusService(_asJava)

  def createRecord(name: String, address: String, itf: String, metadata: io.vertx.core.json.JsonObject): io.vertx.scala.servicediscovery.Record = {
    io.vertx.scala.servicediscovery.Record(io.vertx.servicediscovery.types.EventBusService.createRecord(name, address, itf, metadata))
  }

  def getProxyFuture[T](discovery: io.vertx.scala.servicediscovery.ServiceDiscovery, filter: io.vertx.core.json.JsonObject): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T,T]((x => x))
    io.vertx.servicediscovery.types.EventBusService.getProxy(discovery.asJava.asInstanceOf[io.vertx.servicediscovery.ServiceDiscovery], filter, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def getProxyFuture[T](discovery: io.vertx.scala.servicediscovery.ServiceDiscovery, serviceInterface: String, proxyInterface: String): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T,T]((x => x))
    io.vertx.servicediscovery.types.EventBusService.getProxy(discovery.asJava.asInstanceOf[io.vertx.servicediscovery.ServiceDiscovery], serviceInterface, proxyInterface, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def getProxyFuture[T](discovery: io.vertx.scala.servicediscovery.ServiceDiscovery, filter: io.vertx.core.json.JsonObject, proxyClass: String): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T,T]((x => x))
    io.vertx.servicediscovery.types.EventBusService.getProxy(discovery.asJava.asInstanceOf[io.vertx.servicediscovery.ServiceDiscovery], filter, proxyClass, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def getProxyFuture[T](discovery: io.vertx.scala.servicediscovery.ServiceDiscovery, itf: String): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T,T]((x => x))
    io.vertx.servicediscovery.types.EventBusService.getProxy(discovery.asJava.asInstanceOf[io.vertx.servicediscovery.ServiceDiscovery], itf, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}
