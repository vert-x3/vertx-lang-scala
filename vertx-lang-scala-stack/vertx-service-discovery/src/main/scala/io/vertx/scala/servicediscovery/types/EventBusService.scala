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
import io.vertx.servicediscovery.types.{EventBusService => JEventBusService}
import io.vertx.servicediscovery.spi.{ServiceType => JServiceType}
import io.vertx.core.json.JsonObject
import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.scala.servicediscovery.Record
import io.vertx.servicediscovery.{ServiceDiscovery => JServiceDiscovery}
import io.vertx.scala.servicediscovery.ServiceDiscovery

/**
  *  for event bus services (service proxies).
  * Consumers receive a service proxy to use the service.
  */
class EventBusService(private val _asJava: JEventBusService) {

  def asJava: JEventBusService = _asJava

}

object EventBusService {

  def apply(_asJava: JEventBusService): EventBusService =
    new EventBusService(_asJava)

  def createRecord(name: String, address: String, itf: String, metadata: JsonObject): Record = {
    Record(io.vertx.servicediscovery.types.EventBusService.createRecord(name, address, itf, metadata))
  }

  def getProxyFuture[T](discovery: ServiceDiscovery, filter: JsonObject): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T,T]((x => x))
    io.vertx.servicediscovery.types.EventBusService.getProxy(discovery.asJava.asInstanceOf[JServiceDiscovery], filter, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def getProxyFuture[T](discovery: ServiceDiscovery, serviceInterface: String, proxyInterface: String): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T,T]((x => x))
    io.vertx.servicediscovery.types.EventBusService.getProxy(discovery.asJava.asInstanceOf[JServiceDiscovery], serviceInterface, proxyInterface, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def getProxyFuture[T](discovery: ServiceDiscovery, filter: JsonObject, proxyClass: String): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T,T]((x => x))
    io.vertx.servicediscovery.types.EventBusService.getProxy(discovery.asJava.asInstanceOf[JServiceDiscovery], filter, proxyClass, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def getProxyFuture[T](discovery: ServiceDiscovery, itf: String): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T,T]((x => x))
    io.vertx.servicediscovery.types.EventBusService.getProxy(discovery.asJava.asInstanceOf[JServiceDiscovery], itf, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}
