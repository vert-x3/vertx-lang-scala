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
import io.vertx.servicediscovery.types.{MessageSource => JMessageSource}
import io.vertx.servicediscovery.spi.{ServiceType => JServiceType}
import io.vertx.core.json.JsonObject
import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.scala.servicediscovery.Record
import io.vertx.servicediscovery.{ServiceDiscovery => JServiceDiscovery}
import io.vertx.scala.servicediscovery.ServiceDiscovery
import io.vertx.core.eventbus.{MessageConsumer => JMessageConsumer}
import io.vertx.scala.core.eventbus.MessageConsumer

/**
  * Service type for data producer. Providers are publishing data to a specific event bus address.
  */
class MessageSource(private val _asJava: JMessageSource) {

  def asJava: JMessageSource = _asJava

}

object MessageSource {

  def apply(_asJava: JMessageSource): MessageSource =
    new MessageSource(_asJava)

  def createRecord(name: String, address: String, `type`: String, metadata: JsonObject): Record = {
    Record(io.vertx.servicediscovery.types.MessageSource.createRecord(name, address, `type`, metadata))
  }

  def createRecord(name: String, address: String, `type`: String): Record = {
    Record(io.vertx.servicediscovery.types.MessageSource.createRecord(name, address, `type`))
  }

  def createRecord(name: String, address: String): Record = {
    Record(io.vertx.servicediscovery.types.MessageSource.createRecord(name, address))
  }

  def getConsumerFuture[T](discovery: ServiceDiscovery, filter: JsonObject): concurrent.Future[MessageConsumer[T]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMessageConsumer[T],MessageConsumer[T]]((x => if (x == null) null else MessageConsumer.apply[T](x)))
    io.vertx.servicediscovery.types.MessageSource.getConsumer(discovery.asJava.asInstanceOf[JServiceDiscovery], filter, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}
