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
import io.vertx.servicediscovery.spi.{ServiceImporter => JServiceImporter}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.core.{Future => JFuture}
import io.vertx.scala.core.Future
import io.vertx.servicediscovery.spi.{ServicePublisher => JServicePublisher}

/**
  * The service importer allows integrate other discovery technologies with the Vert.x service discovery. It maps
  * entries from another technology to a  and maps  to a publication in this other
  * technology. The importer is one side of a service discovery bridge.
  */
class ServiceImporter(private val _asJava: JServiceImporter) {

  def asJava: JServiceImporter = _asJava

  /**
    * Starts the importer.
    * @param vertx the vertx instance
    * @param publisher the service discovery instance
    * @param configuration the bridge configuration if any
    * @param future a future on which the bridge must report the completion of the starting
    */
  def start(vertx: Vertx, publisher: ServicePublisher, configuration: JsonObject, future: Future[Unit]): Unit = {
    _asJava.start(vertx.asJava.asInstanceOf[JVertx], publisher.asJava.asInstanceOf[JServicePublisher], configuration, future.asJava.asInstanceOf[JFuture[Void]])
  }

  /**
    * Closes the importer
    * @param closeHandler the handle to be notified when importer is closed, may be `null`
    */
  def close(closeHandler: () => Unit): Unit = {
    _asJava.close(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => closeHandler()))
  }

}

object ServiceImporter {

  def apply(_asJava: JServiceImporter): ServiceImporter =
    new ServiceImporter(_asJava)

}
