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

package io.vertx.scala.ext.stomp

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx

/**
  * Interface implemented to customize the destination creation.
  */
class DestinationFactory(private val _asJava: io.vertx.ext.stomp.DestinationFactory) {

  def asJava: io.vertx.ext.stomp.DestinationFactory = _asJava

  /**
    * Creates a destination for the given <em>address</em>.
    * @param vertx the vert.x instance used by the STOMP server.
    * @param name the destination name.
    * @return the destination, `null` to reject the creation.
    */
  def create(vertx: io.vertx.scala.core.Vertx, name: String): io.vertx.scala.ext.stomp.Destination = {
    Destination.apply(_asJava.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], name))
  }

}

object DestinationFactory {

  def apply(_asJava: io.vertx.ext.stomp.DestinationFactory): io.vertx.scala.ext.stomp.DestinationFactory =
    new io.vertx.scala.ext.stomp.DestinationFactory(_asJava)

}
