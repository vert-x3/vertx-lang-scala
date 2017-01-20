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
import io.vertx.servicediscovery.types.{MongoDataSource => JMongoDataSource}
import io.vertx.ext.mongo.{MongoClient => JMongoClient}
import io.vertx.scala.servicediscovery.ServiceDiscovery
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.servicediscovery.Record
import io.vertx.scala.ext.mongo.MongoClient

/**
  */
class MongoDataSource(private val _asJava: Object) {

  def asJava = _asJava

}

object MongoDataSource{
  def apply(asJava: JMongoDataSource) = new MongoDataSource(asJava)  
  /**
    * Convenient method to create a record for a Mongo data source.
    * @param name the service name
    * @param location the location of the service (e.g. url, port...)
    * @param metadata additional metadata
    * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
    */
  def createRecord(name: String,location: io.vertx.core.json.JsonObject,metadata: io.vertx.core.json.JsonObject):Record = {
    Record(JMongoDataSource.createRecord(name.asInstanceOf[java.lang.String],location,metadata))
  }

  /**
    * Convenient method that looks for a Mongo datasource source and provides the configured [[io.vertx.scala.ext.mongo.MongoClient]]. The
    * async result is marked as failed is there are no matching services, or if the lookup fails.
    * @param discovery The service discovery instance
    * @param filter The filter, optional
    */
  def getMongoClient(discovery: ServiceDiscovery,filter: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[MongoClient]]):Unit = {
    JMongoDataSource.getMongoClient(discovery.asJava.asInstanceOf[JServiceDiscovery],filter,{x: AsyncResult[JMongoClient] => resultHandler.handle(AsyncResultWrapper[JMongoClient,MongoClient](x, a => MongoClient(a)))})
  }

  /**
    * Convenient method that looks for a Mongo datasource source and provides the configured
    * [[io.vertx.scala.ext.mongo.MongoClient]]. The
    * async result is marked as failed is there are no matching services, or if the lookup fails.
    * @param discovery The service discovery instance
    * @param filter The filter
    */
  def getMongoClient(discovery: ServiceDiscovery,filter: Record => Boolean,resultHandler: Handler[AsyncResult[MongoClient]]):Unit = {
    JMongoDataSource.getMongoClient(discovery.asJava.asInstanceOf[JServiceDiscovery],{x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]},{x: AsyncResult[JMongoClient] => resultHandler.handle(AsyncResultWrapper[JMongoClient,MongoClient](x, a => MongoClient(a)))})
  }

  /**
    * Convenient method that looks for a Mongo datasource source and provides the configured [[io.vertx.scala.ext.mongo.MongoClient]]. The
    * async result is marked as failed is there are no matching services, or if the lookup fails.
    * @param discovery The service discovery instance
    * @param filter The filter, optional
    * @param consumerConfiguration the consumer configuration
    */
  def getMongoClient(discovery: ServiceDiscovery,filter: io.vertx.core.json.JsonObject,consumerConfiguration: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[MongoClient]]):Unit = {
    JMongoDataSource.getMongoClient(discovery.asJava.asInstanceOf[JServiceDiscovery],filter,consumerConfiguration,{x: AsyncResult[JMongoClient] => resultHandler.handle(AsyncResultWrapper[JMongoClient,MongoClient](x, a => MongoClient(a)))})
  }

}
