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
import io.vertx.servicediscovery.spi.ServiceType
import io.vertx.core.json.JsonObject
import io.vertx.servicediscovery.Record
import io.vertx.scala.servicediscovery.ServiceDiscovery
import io.vertx.core.Handler
import java.util.function.Function
import io.vertx.scala.core.http.HttpClient

/**
  *  for HTTP endpoint (REST api).
  * Consumers receive a HTTP client configured with the host and port of the endpoint.
  */
class HttpEndpoint(private val _asJava: io.vertx.servicediscovery.types.HttpEndpoint) {

  def asJava: io.vertx.servicediscovery.types.HttpEndpoint = _asJava

}

object HttpEndpoint {

  def apply(_asJava: io.vertx.servicediscovery.types.HttpEndpoint): io.vertx.scala.servicediscovery.types.HttpEndpoint =
    new io.vertx.scala.servicediscovery.types.HttpEndpoint(_asJava)

  def createRecord(name: String, host: String, port: Int, root: String, metadata: io.vertx.core.json.JsonObject): io.vertx.scala.servicediscovery.Record = {
    io.vertx.scala.servicediscovery.Record(io.vertx.servicediscovery.types.HttpEndpoint.createRecord(name, host, port, root, metadata))
  }

  def createRecord(name: String, ssl: Boolean, host: String, port: Int, root: String, metadata: io.vertx.core.json.JsonObject): io.vertx.scala.servicediscovery.Record = {
    io.vertx.scala.servicediscovery.Record(io.vertx.servicediscovery.types.HttpEndpoint.createRecord(name, ssl, host, port, root, metadata))
  }

  def createRecord(name: String, host: String, port: Int, root: String): io.vertx.scala.servicediscovery.Record = {
    io.vertx.scala.servicediscovery.Record(io.vertx.servicediscovery.types.HttpEndpoint.createRecord(name, host, port, root))
  }

  def createRecord(name: String, host: String): io.vertx.scala.servicediscovery.Record = {
    io.vertx.scala.servicediscovery.Record(io.vertx.servicediscovery.types.HttpEndpoint.createRecord(name, host))
  }

  def getClientFuture(discovery: io.vertx.scala.servicediscovery.ServiceDiscovery, filter: io.vertx.core.json.JsonObject): concurrent.Future[io.vertx.scala.core.http.HttpClient] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.http.HttpClient,io.vertx.scala.core.http.HttpClient]((x => if (x == null) null else HttpClient.apply(x)))
    io.vertx.servicediscovery.types.HttpEndpoint.getClient(discovery.asJava.asInstanceOf[io.vertx.servicediscovery.ServiceDiscovery], filter, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def getClientFuture(discovery: io.vertx.scala.servicediscovery.ServiceDiscovery, filter: io.vertx.servicediscovery.Record => java.lang.Boolean): concurrent.Future[io.vertx.scala.core.http.HttpClient] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.http.HttpClient,io.vertx.scala.core.http.HttpClient]((x => if (x == null) null else HttpClient.apply(x)))
    io.vertx.servicediscovery.types.HttpEndpoint.getClient(discovery.asJava.asInstanceOf[io.vertx.servicediscovery.ServiceDiscovery], asJavaFunction(filter), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}
