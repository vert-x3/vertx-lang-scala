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

package io.vertx.scala.ext.web.handler

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.web.handler.{VirtualHostHandler => JVirtualHostHandler}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.scala.ext.web.RoutingContext

/**
  * Handler that will filter requests based on the request Host name.
  */
class VirtualHostHandler(private val _asJava: JVirtualHostHandler) {

  def asJava: JVirtualHostHandler = _asJava

  def handle(arg0: RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object VirtualHostHandler {

  def apply(_asJava: JVirtualHostHandler): VirtualHostHandler =
    new VirtualHostHandler(_asJava)

  def create(hostname: String, handler: RoutingContext => Unit): VirtualHostHandler = {
    VirtualHostHandler.apply(io.vertx.ext.web.handler.VirtualHostHandler.create(hostname, funcToMappedHandler(RoutingContext.apply)(handler)))
  }

}
