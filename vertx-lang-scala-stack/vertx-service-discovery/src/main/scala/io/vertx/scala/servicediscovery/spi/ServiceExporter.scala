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
import io.vertx.servicediscovery.spi.{ServiceExporter => JServiceExporter}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.scala.servicediscovery.Record
import io.vertx.core.{Future => JFuture}
import io.vertx.scala.core.Future
import io.vertx.servicediscovery.spi.{ServicePublisher => JServicePublisher}

/**
  * The service exporter allows integrate other discovery technologies with the Vert.x service discovery. It maps
  * entries from another technology to a  and maps  to a publication in this other
  * technology. The exporter is one side of a service discovery bridge.
  */
class ServiceExporter(private val _asJava: JServiceExporter) {

  def asJava: JServiceExporter = _asJava

  /**
    * Starts the exporter.
    * @param vertx the vertx instance
    * @param publisher the service discovery instance
    * @param configuration the bridge configuration if any
    * @param future a future on which the bridge must report the completion of the starting
    */
  def init(vertx: Vertx, publisher: ServicePublisher, configuration: JsonObject, future: Future[Unit]): Unit = {
    _asJava.init(vertx.asJava.asInstanceOf[JVertx], publisher.asJava.asInstanceOf[JServicePublisher], configuration, future.asJava.asInstanceOf[JFuture[Void]])
  }

  /**
    * Notify a new record has been published, the record's registration can be used to uniquely
    * identify the record
    * @param record the recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
    */
  def onPublish(record: Record): Unit = {
    _asJava.onPublish(record.asJava)
  }

  /**
    * Notify an existing record has been updated, the record's registration can be used to uniquely
    * identify the record
    * @param record the recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
    */
  def onUpdate(record: Record): Unit = {
    _asJava.onUpdate(record.asJava)
  }

  /**
    * Notify an existing record has been removed
    * @param id the record registration id
    */
  def onUnpublish(id: String): Unit = {
    _asJava.onUnpublish(id)
  }

  /**
    * Close the exporter
    * @param closeHandler the handle to be notified when exporter is closed, may be `null`
    */
  def close(closeHandler: () => Unit): Unit = {
    _asJava.close(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => closeHandler()))
  }

}

object ServiceExporter {

  def apply(_asJava: JServiceExporter): ServiceExporter =
    new ServiceExporter(_asJava)

}
