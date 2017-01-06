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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.servicediscovery.{ServiceDiscovery => JServiceDiscovery}
import io.vertx.scala.servicediscovery.ServiceDiscovery
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.servicediscovery.types.{EventBusService => JEventBusService}
import io.vertx.scala.servicediscovery.Record

/**
  *  for event bus services (service proxies).
  * Consumers receive a service proxy to use the service.
  */
class EventBusService(private val _asJava: Object) {

  def asJava = _asJava

}

object EventBusService{
  def apply(asJava: JEventBusService) = new EventBusService(asJava)  
  /**
    * Sugar method to creates a record for this type.
    * 
    * The java interface is added to the metadata in the `service.interface` key.
    * @param name the name of the service.
    * @param address the event bus address on which the service available
    * @param itf the Java interface (name)
    * @param metadata the metadata
    * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
    */
  def createRecord(name: String,address: String,itf: String,metadata: io.vertx.core.json.JsonObject):Record = {
    Record(JEventBusService.createRecord(name.asInstanceOf[java.lang.String],address.asInstanceOf[java.lang.String],itf.asInstanceOf[java.lang.String],metadata))
  }

  /**
    * Lookup for a service record and if found, retrieve it and return the service object (used to consume the service).
    * This is a convenient method to avoid explicit lookup and then retrieval of the service.
    * @param discovery the service discovery instance
    * @param filter the filter to select the service
    */
  def getProxy[T:TypeTag](discovery: ServiceDiscovery,filter: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[T]]):Unit = {
    JEventBusService.getProxy[Object](discovery.asJava.asInstanceOf[JServiceDiscovery],filter,{x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object,T](x, a => toScala[T](a)))})
  }

  def getProxy[T:TypeTag](discovery: ServiceDiscovery,serviceInterface: String,proxyInterface: String,resultHandler: Handler[AsyncResult[T]]):Unit = {
    JEventBusService.getProxy[Object](discovery.asJava.asInstanceOf[JServiceDiscovery],serviceInterface.asInstanceOf[java.lang.String],proxyInterface.asInstanceOf[java.lang.String],{x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object,T](x, a => toScala[T](a)))})
  }

  def getProxy[T:TypeTag](discovery: ServiceDiscovery,filter: io.vertx.core.json.JsonObject,proxyClass: String,resultHandler: Handler[AsyncResult[T]]):Unit = {
    JEventBusService.getProxy[Object](discovery.asJava.asInstanceOf[JServiceDiscovery],filter,proxyClass.asInstanceOf[java.lang.String],{x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object,T](x, a => toScala[T](a)))})
  }

  /**
    * Lookup for a service record and if found, retrieve it and return the service object (used to consume the service).
    * This is a convenient method to avoid explicit lookup and then retrieval of the service. A filter based on the
    * request interface is used.
    * @param discovery the service discovery instance
    * @param itf the service interface
    */
  def getProxy[T:TypeTag](discovery: ServiceDiscovery,itf: String,resultHandler: Handler[AsyncResult[T]]):Unit = {
    JEventBusService.getProxy[Object](discovery.asJava.asInstanceOf[JServiceDiscovery],itf.asInstanceOf[java.lang.String],{x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object,T](x, a => toScala[T](a)))})
  }

}
