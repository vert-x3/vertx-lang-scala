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

package io.vertx.scala.servicediscovery.spi

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.servicediscovery.spi.{ServicePublisher => JServicePublisher}
import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.scala.servicediscovery.Record

/**
  * The publisher is used by the importer to publish or unpublish records.
  */
class ServicePublisher(private val _asJava: JServicePublisher) {

  def asJava: JServicePublisher = _asJava

  /**
    * Publishes a record.
    * @param record the recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
    * @return future called when the operation has completed (successfully or not). In case of success, the passed record has a registration id required to modify and un-register the service.
    */
  def publishFuture(record: Record): concurrent.Future[Record] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRecord,Record]((x => io.vertx.scala.servicediscovery.Record(x)))
    _asJava.publish(record.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Un-publishes a record.
    * @param id the registration id
    * @return future called when the operation has completed (successfully or not).
    */
  def unpublishFuture(id: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.unpublish(id, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object ServicePublisher {

  def apply(_asJava: JServicePublisher): ServicePublisher =
    new ServicePublisher(_asJava)

}
