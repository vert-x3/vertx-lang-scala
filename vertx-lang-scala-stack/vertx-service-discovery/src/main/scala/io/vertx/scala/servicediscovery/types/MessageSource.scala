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
import io.vertx.scala.core.eventbus.MessageConsumer
import io.vertx.core.json.JsonObject
import io.vertx.servicediscovery.types.{MessageSource => JMessageSource}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.servicediscovery.Record
import io.vertx.core.eventbus.{MessageConsumer => JMessageConsumer}

/**
  * Service type for data producer. Providers are publishing data to a specific event bus address.
  */
class MessageSource(private val _asJava: Object) {

  def asJava = _asJava

}

object MessageSource {
  def apply(asJava: JMessageSource) = new MessageSource(asJava)  
  /**
    * Create a record representing a data producer.
    * @param name the name of the service
    * @param address the address on which the data is sent
    * @param type the type of payload (fully qualified name of the class)
    * @param metadata additional metadata
    * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
    */
  def createRecord(name: String, address: String, `type`: String, metadata: io.vertx.core.json.JsonObject): Record = {
    Record(JMessageSource.createRecord(name.asInstanceOf[java.lang.String],address.asInstanceOf[java.lang.String],`type`.asInstanceOf[java.lang.String],metadata))
  }

  /**
    * Same as [[io.vertx.scala.servicediscovery.types.MessageSource#createRecord]] without additional metadata.
    * @param name the name of the service
    * @param address the address on which the data is sent
    * @param type the type of payload
    * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
    */
  def createRecord(name: String, address: String, `type`: String): Record = {
    Record(JMessageSource.createRecord(name.asInstanceOf[java.lang.String],address.asInstanceOf[java.lang.String],`type`.asInstanceOf[java.lang.String]))
  }

  /**
    * Same as [[io.vertx.scala.servicediscovery.types.MessageSource#createRecord]] without additional metadata, and no type for
    * the payload.
    * @param name the name of the service
    * @param address the address on which the data is sent.
    * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
    */
  def createRecord(name: String, address: String): Record = {
    Record(JMessageSource.createRecord(name.asInstanceOf[java.lang.String],address.asInstanceOf[java.lang.String]))
  }

  /**
    * Convenient method that looks for a message source and provides the configured . The
    * async result is marked as failed is there are no matching services, or if the lookup fails.
    * @param discovery The service discovery instance
    * @param filter The filter, optional
    */
  def getConsumer[T: TypeTag](discovery: ServiceDiscovery, filter: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[MessageConsumer[T]]]): Unit = {
    JMessageSource.getConsumer[Object](discovery.asJava.asInstanceOf[JServiceDiscovery],filter,{x: AsyncResult[JMessageConsumer[Object]] => resultHandler.handle(AsyncResultWrapper[JMessageConsumer[Object],MessageConsumer[T]](x, a => MessageConsumer[T](a)))})
  }

  /**
    * Convenient method that looks for a message source and provides the configured . The
    * async result is marked as failed is there are no matching services, or if the lookup fails.
    * @param discovery The service discovery instance
    * @param filter The filter, must not be `null`
    */
  def getConsumer[T: TypeTag](discovery: ServiceDiscovery, filter: Record => Boolean, resultHandler: Handler[AsyncResult[MessageConsumer[T]]]): Unit = {
    JMessageSource.getConsumer[Object](discovery.asJava.asInstanceOf[JServiceDiscovery],{x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]},{x: AsyncResult[JMessageConsumer[Object]] => resultHandler.handle(AsyncResultWrapper[JMessageConsumer[Object],MessageConsumer[T]](x, a => MessageConsumer[T](a)))})
  }

}
