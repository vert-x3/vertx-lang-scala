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

import io.vertx.scala.ext.jdbc.JDBCClient
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.servicediscovery.{Record => JRecord}
import scala.reflect.runtime.universe._
import io.vertx.scala.servicediscovery.ServiceDiscovery
import io.vertx.lang.scala.Converter._
import io.vertx.servicediscovery.{ServiceDiscovery => JServiceDiscovery}
import io.vertx.servicediscovery.types.{JDBCDataSource => JJDBCDataSource}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.jdbc.{JDBCClient => JJDBCClient}
import io.vertx.scala.servicediscovery.Record
import io.vertx.lang.scala.HandlerOps._

/**

  */

class JDBCDataSource(private val _asJava: Object) {
  def asJava = _asJava






}

object JDBCDataSource {
  def apply(asJava: JJDBCDataSource) = new JDBCDataSource(asJava)
  

  def createRecord(name: String,location: io.vertx.core.json.JsonObject,metadata: io.vertx.core.json.JsonObject): Record = {
    Record(JJDBCDataSource.createRecord(name.asInstanceOf[java.lang.String], location, metadata))
  }

  /**
   * Convenient method that looks for a JDBC datasource source and provides the configured [[io.vertx.scala.ext.jdbc.JDBCClient]]. The
   * async result is marked as failed is there are no matching services, or if the lookup fails.   * @param discovery The service discovery instance
   * @param filter The filter, optional
   * @param resultHandler The result handler
   */
  def getJDBCClient(discovery: ServiceDiscovery,filter: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[JDBCClient]]): Unit = {
    JJDBCDataSource.getJDBCClient(discovery.asJava.asInstanceOf[JServiceDiscovery], filter, {x: AsyncResult[JJDBCClient] => resultHandler.handle(AsyncResultWrapper[JJDBCClient, JDBCClient](x, a => JDBCClient(a)))})
  }

  /**
   * Convenient method that looks for a JDBC datasource source and provides the configured [[io.vertx.scala.ext.jdbc.JDBCClient]]. The
   * async result is marked as failed is there are no matching services, or if the lookup fails.   * @param discovery The service discovery instance
   * @param filter The filter (must not be `null`)
   * @param resultHandler The result handler
   */
  def getJDBCClient(discovery: ServiceDiscovery,filter: Record => Boolean,resultHandler: Handler[AsyncResult[JDBCClient]]): Unit = {
    JJDBCDataSource.getJDBCClient(discovery.asJava.asInstanceOf[JServiceDiscovery], {x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]}, {x: AsyncResult[JJDBCClient] => resultHandler.handle(AsyncResultWrapper[JJDBCClient, JDBCClient](x, a => JDBCClient(a)))})
  }

  /**
   * Convenient method that looks for a JDBC datasource source and provides the configured [[io.vertx.scala.ext.jdbc.JDBCClient]]. The
   * async result is marked as failed is there are no matching services, or if the lookup fails.   * @param discovery The service discovery instance
   * @param filter The filter, optional
   * @param consumerConfiguration the consumer configuration
   * @param resultHandler the result handler
   */
  def getJDBCClient(discovery: ServiceDiscovery,filter: io.vertx.core.json.JsonObject,consumerConfiguration: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[JDBCClient]]): Unit = {
    JJDBCDataSource.getJDBCClient(discovery.asJava.asInstanceOf[JServiceDiscovery], filter, consumerConfiguration, {x: AsyncResult[JJDBCClient] => resultHandler.handle(AsyncResultWrapper[JJDBCClient, JDBCClient](x, a => JDBCClient(a)))})
  }

  /**
   * Convenient method that looks for a JDBC datasource source and provides the configured [[io.vertx.scala.ext.jdbc.JDBCClient]]. The
   * async result is marked as failed is there are no matching services, or if the lookup fails.   * @param discovery The service discovery instance
   * @param filter The filter, must not be `null`
   * @param consumerConfiguration the consumer configuration
   * @param resultHandler the result handler
   */
  def getJDBCClient(discovery: ServiceDiscovery,filter: Record => Boolean,consumerConfiguration: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[JDBCClient]]): Unit = {
    JJDBCDataSource.getJDBCClient(discovery.asJava.asInstanceOf[JServiceDiscovery], {x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]}, consumerConfiguration, {x: AsyncResult[JJDBCClient] => resultHandler.handle(AsyncResultWrapper[JJDBCClient, JDBCClient](x, a => JDBCClient(a)))})
  }

}
