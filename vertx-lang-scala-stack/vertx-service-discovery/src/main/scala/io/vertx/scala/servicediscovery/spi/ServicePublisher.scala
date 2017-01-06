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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.servicediscovery.spi.{ServicePublisher => JServicePublisher}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.servicediscovery.Record

/**
  * The publisher is used by the importer to publish or unpublish records.
  */
class ServicePublisher(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Publishes a record.
    * @param record the recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
    */
  def publish(record: Record,resultHandler: Handler[AsyncResult[Record]]):Unit = {
    asJava.asInstanceOf[JServicePublisher].publish(record.asJava,{x: AsyncResult[JRecord] => resultHandler.handle(AsyncResultWrapper[JRecord,Record](x, a => Record(a)))})
  }

  /**
    * Un-publishes a record.
    * @param id the registration id
    */
  def unpublish(id: String,resultHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JServicePublisher].unpublish(id.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

 /**
   * Publishes a record.
   * @param record the recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
   * @return future called when the operation has completed (successfully or not). In case of success, the passed record has a registration id required to modify and un-register the service.
   */
    def publishFuture(record: Record):scala.concurrent.Future[Record] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRecord, Record](x => Record(x))
    asJava.asInstanceOf[JServicePublisher].publish(record.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Un-publishes a record.
   * @param id the registration id
   * @return future called when the operation has completed (successfully or not).
   */
    def unpublishFuture(id: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JServicePublisher].unpublish(id.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object ServicePublisher{
  def apply(asJava: JServicePublisher) = new ServicePublisher(asJava)  
}
