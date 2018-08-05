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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.servicediscovery.{ServiceDiscovery => JServiceDiscovery}
import scala.reflect.runtime.universe._
import io.vertx.scala.servicediscovery.ServiceDiscovery
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.servicediscovery.types.{EventBusService => JEventBusService}
import io.vertx.scala.servicediscovery.Record
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  *  for event bus services (service proxies).
  * Consumers receive a service proxy to use the service.
  */

class EventBusService(private val _asJava: Object) {
  def asJava = _asJava






}

object EventBusService {
  def apply(asJava: JEventBusService) = new EventBusService(asJava)
  
  /**
   * Sugar method to creates a record for this type.
   * 
   * The java interface is added to the metadata in the `service.interface` key.   * @param name the name of the service.
   * @param address the event bus address on which the service available
   * @param itf the Java interface (name)
   * @param metadata the metadata
   * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
   */
  def createRecord(name: String,address: String,itf: String,metadata: io.vertx.core.json.JsonObject): Record = {
    Record(JEventBusService.createRecord(name.asInstanceOf[java.lang.String], address.asInstanceOf[java.lang.String], itf.asInstanceOf[java.lang.String], metadata))
  }

  /**
   * Lookup for a service record and if found, retrieve it and return the service object (used to consume the service).
   * This is a convenient method to avoid explicit lookup and then retrieval of the service. This method requires to
   * have the `clientClass` set with the expected set of client. This is important for usages not using Java so
   * you can pass the expected type.   * @param discovery the service discovery
   * @param filter the filter
   * @param clientClass the client class
   * @param resultHandler the result handler
   * @return `null` - do not use
   */
  def getServiceProxy[T: TypeTag](discovery: ServiceDiscovery,filter: Record => Boolean,clientClass: Class[T],resultHandler: Handler[AsyncResult[T]]): T = {
    toScala[T](JEventBusService.getServiceProxy[Object](discovery.asJava.asInstanceOf[JServiceDiscovery], {x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]}, toJavaClass(clientClass), {x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object, T](x, a => toScala[T](a)))}))
  }

  /**
   * Lookup for a service record and if found, retrieve it and return the service object (used to consume the service).
   * This is a convenient method to avoid explicit lookup and then retrieval of the service. This method requires to
   * have the `clientClass` set with the expected set of client. This is important for usages not using Java so
   * you can pass the expected type.   * @param discovery the service discovery
   * @param filter the filter as json object
   * @param clientClass the client class
   * @param resultHandler the result handler
   * @return `null` - do not use
   */
  def getServiceProxyWithJsonFilter[T: TypeTag](discovery: ServiceDiscovery,filter: io.vertx.core.json.JsonObject,clientClass: Class[T],resultHandler: Handler[AsyncResult[T]]): T = {
    toScala[T](JEventBusService.getServiceProxyWithJsonFilter[Object](discovery.asJava.asInstanceOf[JServiceDiscovery], filter, toJavaClass(clientClass), {x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object, T](x, a => toScala[T](a)))}))
  }

  /**
   * Creates a record based on the parameters.   * @param name the service name
   * @param address the address
   * @param classname the payload class
   * @return the recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
   */
  def createRecord(name: String,address: String,classname: String): Record = {
    Record(JEventBusService.createRecord(name.asInstanceOf[java.lang.String], address.asInstanceOf[java.lang.String], classname.asInstanceOf[java.lang.String]))
  }

}
