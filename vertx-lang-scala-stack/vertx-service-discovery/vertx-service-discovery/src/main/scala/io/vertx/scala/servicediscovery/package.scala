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

package io.vertx.scala

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.core.{Promise => JPromise}
import io.vertx.core
import io.vertx.servicediscovery
import io.vertx.servicediscovery.spi.{ServicePublisher => JServicePublisher}
import io.vertx.core.json.JsonObject
import io.vertx.core.Handler
import io.vertx.servicediscovery.spi.{ServiceExporter => JServiceExporter}
import io.vertx.core.{Vertx => JVertx}

package object servicediscovery{

  object EventBusService {
    /**
     * Sugar method to creates a record for this type.
     * 
     * The java interface is added to the metadata in the `service.interface` key.     * @param name the name of the service.
     * @param address the event bus address on which the service available
     * @param itf the Java interface (name)
     * @param metadata the metadata
     * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
     */
def createRecord(name: java.lang.String,address: java.lang.String,itf: java.lang.String,metadata: io.vertx.core.json.JsonObject) = {
      io.vertx.servicediscovery.types.EventBusService.createRecord(name, address, itf, metadata)
}
    /**
     * Lookup for a service record and if found, retrieve it and return the service object (used to consume the service).
     * This is a convenient method to avoid explicit lookup and then retrieval of the service. This method requires to
     * have the `clientClass` set with the expected set of client. This is important for usages not using Java so
     * you can pass the expected type.     * @param discovery the service discovery
     * @param filter the filter
     * @param clientClass the client class
     * @param resultHandler the result handler
     * @return `null` - do not use
     */
def getServiceProxy[T](discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.servicediscovery.Record => java.lang.Boolean,clientClass: Class[T],resultHandler: AsyncResult[T] => Unit) = {
      io.vertx.servicediscovery.types.EventBusService.getServiceProxy[T](discovery, {x: io.vertx.servicediscovery.Record => filter(x)}, clientClass, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]])
}
    /**
     * Lookup for a service record and if found, retrieve it and return the service object (used to consume the service).
     * This is a convenient method to avoid explicit lookup and then retrieval of the service. This method requires to
     * have the `clientClass` set with the expected set of client. This is important for usages not using Java so
     * you can pass the expected type.     * @param discovery the service discovery
     * @param filter the filter
     * @param clientClass the client class
     * @param conf the configuration for message delivery
     * @param resultHandler the result handler
     * @return `null` - do not use
     */
def getServiceProxy[T](discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.servicediscovery.Record => java.lang.Boolean,clientClass: Class[T],conf: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[T] => Unit) = {
      io.vertx.servicediscovery.types.EventBusService.getServiceProxy[T](discovery, {x: io.vertx.servicediscovery.Record => filter(x)}, clientClass, conf, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]])
}
    /**
     * Lookup for a service record and if found, retrieve it and return the service object (used to consume the service).
     * This is a convenient method to avoid explicit lookup and then retrieval of the service. This method requires to
     * have the `clientClass` set with the expected set of client. This is important for usages not using Java so
     * you can pass the expected type.     * @param discovery the service discovery
     * @param filter the filter as json object
     * @param clientClass the client class
     * @param resultHandler the result handler
     * @return `null` - do not use
     */
def getServiceProxyWithJsonFilter[T](discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.core.json.JsonObject,clientClass: Class[T],resultHandler: AsyncResult[T] => Unit) = {
      io.vertx.servicediscovery.types.EventBusService.getServiceProxyWithJsonFilter[T](discovery, filter, clientClass, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]])
}
    /**
     * Lookup for a service record and if found, retrieve it and return the service object (used to consume the service).
     * This is a convenient method to avoid explicit lookup and then retrieval of the service. This method requires to
     * have the `clientClass` set with the expected set of client. This is important for usages not using Java so
     * you can pass the expected type.     * @param discovery the service discovery
     * @param filter the filter as json object
     * @param clientClass the client class
     * @param conf the configuration for message delivery
     * @param resultHandler the result handler
     * @return `null` - do not use
     */
def getServiceProxyWithJsonFilter[T](discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.core.json.JsonObject,clientClass: Class[T],conf: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[T] => Unit) = {
      io.vertx.servicediscovery.types.EventBusService.getServiceProxyWithJsonFilter[T](discovery, filter, clientClass, conf, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]])
}
    /**
     * Creates a record based on the parameters.     * @param name the service name
     * @param address the address
     * @param classname the payload class
     * @return the recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
     */
def createRecord(name: java.lang.String,address: java.lang.String,classname: java.lang.String) = {
      io.vertx.servicediscovery.types.EventBusService.createRecord(name, address, classname)
}
  }


  object HttpEndpoint {
    /**
     * Convenient method to create a record for a HTTP endpoint.     * @param name the service name
     * @param host the host (IP or DNS name), it must be the _public_ IP / name
     * @param port the port, it must be the _public_ port
     * @param root the path of the service, "/" if not set
     * @param metadata additional metadata
     * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
     */
def createRecord(name: java.lang.String,host: java.lang.String,port: java.lang.Integer,root: java.lang.String,metadata: io.vertx.core.json.JsonObject) = {
      io.vertx.servicediscovery.types.HttpEndpoint.createRecord(name, host, port, root, metadata)
}
    /**
     * Same as [[io.vertx.servicediscovery.types.HttpEndpoint#createRecord]] but let you configure whether or not the
     * service is using `https`.     * @param name the service name
     * @param ssl whether or not the service is using HTTPS
     * @param host the host (IP or DNS name), it must be the _public_ IP / name
     * @param port the port, it must be the _public_ port
     * @param root the path of the service, "/" if not set
     * @param metadata additional metadata
     * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
     */
def createRecord(name: java.lang.String,ssl: java.lang.Boolean,host: java.lang.String,port: java.lang.Integer,root: java.lang.String,metadata: io.vertx.core.json.JsonObject) = {
      io.vertx.servicediscovery.types.HttpEndpoint.createRecord(name, ssl, host, port, root, metadata)
}
    /**
     * Same as [[io.vertx.servicediscovery.types.HttpEndpoint#createRecord]] but without metadata.     * @param name the service name
     * @param host the host, must be public
     * @param port the port
     * @param root the root, if not set "/" is used
     * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
     */
def createRecord(name: java.lang.String,host: java.lang.String,port: java.lang.Integer,root: java.lang.String) = {
      io.vertx.servicediscovery.types.HttpEndpoint.createRecord(name, host, port, root)
}
    /**
     * Same as [[io.vertx.servicediscovery.types.HttpEndpoint#createRecord]] but without metadata, using the port 80
     * and using "/" as root.     * @param name the name
     * @param host the host
     * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
     */
def createRecord(name: java.lang.String,host: java.lang.String) = {
      io.vertx.servicediscovery.types.HttpEndpoint.createRecord(name, host)
}
    /**
     * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
     * is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter, optional
     * @param resultHandler The result handler
     */
def getClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.core.http.HttpClient] => Unit) = {
      io.vertx.servicediscovery.types.HttpEndpoint.getClient(discovery, filter, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.http.HttpClient]]])
}
    /**
     * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
     * is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter, optional
     * @param resultHandler The result handler
     */
def getWebClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.ext.web.client.WebClient] => Unit) = {
      io.vertx.servicediscovery.types.HttpEndpoint.getWebClient(discovery, filter, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.web.client.WebClient]]])
}
    /**
     * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
     * is marked as failed is there are no matching services, or if the lookup fails. This method accepts a
     * configuration for the HTTP client     * @param discovery The service discovery instance
     * @param filter The filter, optional
     * @param conf the configuration of the client
     * @param resultHandler The result handler
     */
def getClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.core.json.JsonObject,conf: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.core.http.HttpClient] => Unit) = {
      io.vertx.servicediscovery.types.HttpEndpoint.getClient(discovery, filter, conf, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.http.HttpClient]]])
}
    /**
     * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
     * is marked as failed is there are no matching services, or if the lookup fails. This method accepts a
     * configuration for the HTTP client     * @param discovery The service discovery instance
     * @param filter The filter, optional
     * @param conf the configuration of the client
     * @param resultHandler The result handler
     */
def getWebClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.core.json.JsonObject,conf: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.ext.web.client.WebClient] => Unit) = {
      io.vertx.servicediscovery.types.HttpEndpoint.getWebClient(discovery, filter, conf, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.web.client.WebClient]]])
}
    /**
     * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
     * is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter
     * @param resultHandler The result handler
     */
def getClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.servicediscovery.Record => java.lang.Boolean,resultHandler: AsyncResult[io.vertx.core.http.HttpClient] => Unit) = {
      io.vertx.servicediscovery.types.HttpEndpoint.getClient(discovery, {x: io.vertx.servicediscovery.Record => filter(x)}, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.http.HttpClient]]])
}
    /**
     * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
     * is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter
     * @param resultHandler The result handler
     */
def getWebClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.servicediscovery.Record => java.lang.Boolean,resultHandler: AsyncResult[io.vertx.ext.web.client.WebClient] => Unit) = {
      io.vertx.servicediscovery.types.HttpEndpoint.getWebClient(discovery, {x: io.vertx.servicediscovery.Record => filter(x)}, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.web.client.WebClient]]])
}
    /**
     * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
     * is marked as failed is there are no matching services, or if the lookup fails. This method accepts a
     * configuration for the HTTP client.     * @param discovery The service discovery instance
     * @param filter The filter
     * @param conf the configuration of the client
     * @param resultHandler The result handler
     */
def getClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.servicediscovery.Record => java.lang.Boolean,conf: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.core.http.HttpClient] => Unit) = {
      io.vertx.servicediscovery.types.HttpEndpoint.getClient(discovery, {x: io.vertx.servicediscovery.Record => filter(x)}, conf, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.http.HttpClient]]])
}
    /**
     * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
     * is marked as failed is there are no matching services, or if the lookup fails. This method accepts a
     * configuration for the HTTP client.     * @param discovery The service discovery instance
     * @param filter The filter
     * @param conf the configuration of the client
     * @param resultHandler The result handler
     */
def getWebClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.servicediscovery.Record => java.lang.Boolean,conf: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.ext.web.client.WebClient] => Unit) = {
      io.vertx.servicediscovery.types.HttpEndpoint.getWebClient(discovery, {x: io.vertx.servicediscovery.Record => filter(x)}, conf, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.web.client.WebClient]]])
}
  }



  type HttpLocation = io.vertx.servicediscovery.types.HttpLocation
  object HttpLocation {
    def apply() = new HttpLocation()
    def apply(json: JsonObject) = new HttpLocation(json)
  }



  object JDBCDataSource {
def createRecord(name: java.lang.String,location: io.vertx.core.json.JsonObject,metadata: io.vertx.core.json.JsonObject) = {
      io.vertx.servicediscovery.types.JDBCDataSource.createRecord(name, location, metadata)
}
    /**
     * Convenient method that looks for a JDBC datasource source and provides the configured [[io.vertx.ext.jdbc.JDBCClient]]. The
     * async result is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter, optional
     * @param resultHandler The result handler
     */
def getJDBCClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.ext.jdbc.JDBCClient] => Unit) = {
      io.vertx.servicediscovery.types.JDBCDataSource.getJDBCClient(discovery, filter, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.jdbc.JDBCClient]]])
}
    /**
     * Convenient method that looks for a JDBC datasource source and provides the configured [[io.vertx.ext.jdbc.JDBCClient]]. The
     * async result is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter (must not be `null`)
     * @param resultHandler The result handler
     */
def getJDBCClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.servicediscovery.Record => java.lang.Boolean,resultHandler: AsyncResult[io.vertx.ext.jdbc.JDBCClient] => Unit) = {
      io.vertx.servicediscovery.types.JDBCDataSource.getJDBCClient(discovery, {x: io.vertx.servicediscovery.Record => filter(x)}, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.jdbc.JDBCClient]]])
}
    /**
     * Convenient method that looks for a JDBC datasource source and provides the configured [[io.vertx.ext.jdbc.JDBCClient]]. The
     * async result is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter, optional
     * @param consumerConfiguration the consumer configuration
     * @param resultHandler the result handler
     */
def getJDBCClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.core.json.JsonObject,consumerConfiguration: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.ext.jdbc.JDBCClient] => Unit) = {
      io.vertx.servicediscovery.types.JDBCDataSource.getJDBCClient(discovery, filter, consumerConfiguration, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.jdbc.JDBCClient]]])
}
    /**
     * Convenient method that looks for a JDBC datasource source and provides the configured [[io.vertx.ext.jdbc.JDBCClient]]. The
     * async result is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter, must not be `null`
     * @param consumerConfiguration the consumer configuration
     * @param resultHandler the result handler
     */
def getJDBCClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.servicediscovery.Record => java.lang.Boolean,consumerConfiguration: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.ext.jdbc.JDBCClient] => Unit) = {
      io.vertx.servicediscovery.types.JDBCDataSource.getJDBCClient(discovery, {x: io.vertx.servicediscovery.Record => filter(x)}, consumerConfiguration, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.jdbc.JDBCClient]]])
}
  }


  object MessageSource {
    /**
     * Create a record representing a data producer.     * @param name the name of the service
     * @param address the address on which the data is sent
     * @param type the type of payload (fully qualified name of the class)
     * @param metadata additional metadata
     * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
     */
def createRecord(name: java.lang.String,address: java.lang.String,`type`: java.lang.String,metadata: io.vertx.core.json.JsonObject) = {
      io.vertx.servicediscovery.types.MessageSource.createRecord(name, address, `type`, metadata)
}
    /**
     * Same as [[io.vertx.servicediscovery.types.MessageSource#createRecord]] without additional metadata.     * @param name the name of the service
     * @param address the address on which the data is sent
     * @param type the type of payload
     * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
     */
def createRecord(name: java.lang.String,address: java.lang.String,`type`: java.lang.String) = {
      io.vertx.servicediscovery.types.MessageSource.createRecord(name, address, `type`)
}
    /**
     * Same as [[io.vertx.servicediscovery.types.MessageSource#createRecord]] without additional metadata, and no type for
     * the payload.     * @param name the name of the service
     * @param address the address on which the data is sent.
     * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
     */
def createRecord(name: java.lang.String,address: java.lang.String) = {
      io.vertx.servicediscovery.types.MessageSource.createRecord(name, address)
}
    /**
     * Convenient method that looks for a message source and provides the configured . The
     * async result is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter, optional
     * @param resultHandler The result handler
     */
def getConsumer[T](discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.core.eventbus.MessageConsumer[T]] => Unit) = {
      io.vertx.servicediscovery.types.MessageSource.getConsumer[T](discovery, filter, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.eventbus.MessageConsumer[T]]]])
}
    /**
     * Convenient method that looks for a message source and provides the configured . The
     * async result is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter, must not be `null`
     * @param resultHandler The result handler
     */
def getConsumer[T](discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.servicediscovery.Record => java.lang.Boolean,resultHandler: AsyncResult[io.vertx.core.eventbus.MessageConsumer[T]] => Unit) = {
      io.vertx.servicediscovery.types.MessageSource.getConsumer[T](discovery, {x: io.vertx.servicediscovery.Record => filter(x)}, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.eventbus.MessageConsumer[T]]]])
}
  }


  object MongoDataSource {
    /**
     * Convenient method to create a record for a Mongo data source.     * @param name the service name
     * @param location the location of the service (e.g. url, port...)
     * @param metadata additional metadata
     * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
     */
def createRecord(name: java.lang.String,location: io.vertx.core.json.JsonObject,metadata: io.vertx.core.json.JsonObject) = {
      io.vertx.servicediscovery.types.MongoDataSource.createRecord(name, location, metadata)
}
    /**
     * Convenient method that looks for a Mongo datasource source and provides the configured [[io.vertx.ext.mongo.MongoClient]]. The
     * async result is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter, optional
     * @param resultHandler The result handler
     */
def getMongoClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.ext.mongo.MongoClient] => Unit) = {
      io.vertx.servicediscovery.types.MongoDataSource.getMongoClient(discovery, filter, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClient]]])
}
    /**
     * Convenient method that looks for a Mongo datasource source and provides the configured
     * [[io.vertx.ext.mongo.MongoClient]]. The
     * async result is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter
     * @param resultHandler The result handler
     */
def getMongoClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.servicediscovery.Record => java.lang.Boolean,resultHandler: AsyncResult[io.vertx.ext.mongo.MongoClient] => Unit) = {
      io.vertx.servicediscovery.types.MongoDataSource.getMongoClient(discovery, {x: io.vertx.servicediscovery.Record => filter(x)}, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClient]]])
}
    /**
     * Convenient method that looks for a Mongo datasource source and provides the configured [[io.vertx.ext.mongo.MongoClient]]. The
     * async result is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter, optional
     * @param consumerConfiguration the consumer configuration
     * @param resultHandler the result handler
     */
def getMongoClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.core.json.JsonObject,consumerConfiguration: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.ext.mongo.MongoClient] => Unit) = {
      io.vertx.servicediscovery.types.MongoDataSource.getMongoClient(discovery, filter, consumerConfiguration, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClient]]])
}
  }



  type Record = io.vertx.servicediscovery.Record
  object Record {
    def apply() = new Record()
    def apply(json: JsonObject) = new Record(json)
  }



  object RedisDataSource {
    /**
     * Convenient method to create a record for a Redis data source.     * @param name the service name
     * @param location the location of the service (e.g. url, port...)
     * @param metadata additional metadata
     * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
     */
def createRecord(name: java.lang.String,location: io.vertx.core.json.JsonObject,metadata: io.vertx.core.json.JsonObject) = {
      io.vertx.servicediscovery.types.RedisDataSource.createRecord(name, location, metadata)
}
    /**
     * Convenient method that looks for a Redis data source and provides the configured [[io.vertx.redis.client.Redis]].
     * The async result is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter, optional
     * @param resultHandler The result handler
     */
def getRedisClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.redis.client.Redis] => Unit) = {
      io.vertx.servicediscovery.types.RedisDataSource.getRedisClient(discovery, filter, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.redis.client.Redis]]])
}
    /**
     * Convenient method that looks for a Redis data source and provides the configured [[io.vertx.redis.client.Redis]].
     * The async result is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter, cannot be `null`
     * @param resultHandler The result handler
     */
def getRedisClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.servicediscovery.Record => java.lang.Boolean,resultHandler: AsyncResult[io.vertx.redis.client.Redis] => Unit) = {
      io.vertx.servicediscovery.types.RedisDataSource.getRedisClient(discovery, {x: io.vertx.servicediscovery.Record => filter(x)}, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.redis.client.Redis]]])
}
    /**
     * Convenient method that looks for a Redis data source and provides the configured [[io.vertx.redis.client.Redis]].
     * The async result is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter, optional
     * @param consumerConfiguration The additional consumer configuration
     * @param resultHandler The result handler
     */
def getRedisClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.core.json.JsonObject,consumerConfiguration: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.redis.client.Redis] => Unit) = {
      io.vertx.servicediscovery.types.RedisDataSource.getRedisClient(discovery, filter, consumerConfiguration, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.redis.client.Redis]]])
}
    /**
     * Convenient method that looks for a Redis data source and provides the configured [[io.vertx.redis.client.Redis]].
     * The async result is marked as failed is there are no matching services, or if the lookup fails.     * @param discovery The service discovery instance
     * @param filter The filter, cannot be `null`
     * @param consumerConfiguration The additional consumer configuration
     * @param resultHandler The result handler
     */
def getRedisClient(discovery: io.vertx.servicediscovery.ServiceDiscovery,filter: io.vertx.servicediscovery.Record => java.lang.Boolean,consumerConfiguration: io.vertx.core.json.JsonObject,resultHandler: AsyncResult[io.vertx.redis.client.Redis] => Unit) = {
      io.vertx.servicediscovery.types.RedisDataSource.getRedisClient(discovery, {x: io.vertx.servicediscovery.Record => filter(x)}, consumerConfiguration, resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.redis.client.Redis]]])
}
  }



  /**
    * Service Discovery main entry point.
    * 
    * The service discovery is an infrastructure that let you publish and find `services`. A `service` is a discoverable
    * functionality. It can be qualified by its type, metadata, and location. So a `service` can be a database, a
    * service proxy, a HTTP endpoint. It does not have to be a vert.x entity, but can be anything. Each service is
    * described by a <a href="../../../../../../cheatsheet/Record.html">Record</a>.
    * 
    * The service discovery implements the interactions defined in the service-oriented computing. And to some extend,
    * also provides the dynamic service-oriented computing interaction. So, application can react to arrival and
    * departure of services.
    * 
    * A service provider can:
    * 
    * * publish a service record
    * * un-publish a published record
    * * update the status of a published service (down, out of service...)
    * 
    * A service consumer can:
    * 
    * * lookup for services
    * * bind to a selected service (it gets a [[io.vertx.servicediscovery.ServiceReference]]) and use it
    * * release the service once the consumer is done with it
    * * listen for arrival, departure and modification of services.
    * 
    * Consumer would 1) lookup for service record matching their need, 2) retrieve the [[io.vertx.servicediscovery.ServiceReference]] that give access
    * to the service, 3) get a service object to access the service, 4) release the service object once done.
    * 
    * A state above, the central piece of information shared by the providers and consumers are <a href="../../../../../../cheatsheet/Record.html">Record</a>.
    * 
    * Providers and consumers must create their own [[io.vertx.servicediscovery.ServiceDiscovery]] instance. These instances are collaborating
    * in background (distributed structure) to keep the set of services in sync.
    */

  implicit class ServiceDiscoveryScala(val asJava: io.vertx.servicediscovery.ServiceDiscovery) extends AnyVal {

    /**
     * Like registerServiceImporter from [[io.vertx.servicediscovery.ServiceDiscovery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def registerServiceImporterFuture(importer: io.vertx.servicediscovery.spi.ServiceImporter,configuration: io.vertx.core.json.JsonObject) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.registerServiceImporter(importer, configuration, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like registerServiceExporter from [[io.vertx.servicediscovery.ServiceDiscovery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def registerServiceExporterFuture(exporter: io.vertx.servicediscovery.spi.ServiceExporter,configuration: io.vertx.core.json.JsonObject) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.registerServiceExporter(exporter, configuration, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like publish from [[io.vertx.servicediscovery.ServiceDiscovery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def publishFuture(record: io.vertx.servicediscovery.Record) : scala.concurrent.Future[io.vertx.servicediscovery.Record] = {
      val promise = concurrent.Promise[io.vertx.servicediscovery.Record]()
      asJava.publish(record, new Handler[AsyncResult[io.vertx.servicediscovery.Record]] { override def handle(event: AsyncResult[io.vertx.servicediscovery.Record]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like unpublish from [[io.vertx.servicediscovery.ServiceDiscovery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def unpublishFuture(id: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.unpublish(id, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like getRecord from [[io.vertx.servicediscovery.ServiceDiscovery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getRecordFuture(filter: io.vertx.core.json.JsonObject) : scala.concurrent.Future[io.vertx.servicediscovery.Record] = {
      val promise = concurrent.Promise[io.vertx.servicediscovery.Record]()
      asJava.getRecord(filter, new Handler[AsyncResult[io.vertx.servicediscovery.Record]] { override def handle(event: AsyncResult[io.vertx.servicediscovery.Record]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like getRecord from [[io.vertx.servicediscovery.ServiceDiscovery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getRecordFuture(filter: io.vertx.servicediscovery.Record => java.lang.Boolean) : scala.concurrent.Future[io.vertx.servicediscovery.Record] = {
      val promise = concurrent.Promise[io.vertx.servicediscovery.Record]()
      asJava.getRecord({x: io.vertx.servicediscovery.Record => filter(x)}, new Handler[AsyncResult[io.vertx.servicediscovery.Record]] { override def handle(event: AsyncResult[io.vertx.servicediscovery.Record]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like getRecord from [[io.vertx.servicediscovery.ServiceDiscovery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getRecordFuture(filter: io.vertx.servicediscovery.Record => java.lang.Boolean,includeOutOfService: java.lang.Boolean) : scala.concurrent.Future[io.vertx.servicediscovery.Record] = {
      val promise = concurrent.Promise[io.vertx.servicediscovery.Record]()
      asJava.getRecord({x: io.vertx.servicediscovery.Record => filter(x)}, includeOutOfService, new Handler[AsyncResult[io.vertx.servicediscovery.Record]] { override def handle(event: AsyncResult[io.vertx.servicediscovery.Record]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like getRecords from [[io.vertx.servicediscovery.ServiceDiscovery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getRecordsFuture(filter: io.vertx.core.json.JsonObject) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.servicediscovery.Record]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.servicediscovery.Record]]()
      asJava.getRecords(filter, new Handler[AsyncResult[java.util.List[io.vertx.servicediscovery.Record]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.servicediscovery.Record]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}

    /**
     * Like getRecords from [[io.vertx.servicediscovery.ServiceDiscovery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getRecordsFuture(filter: io.vertx.servicediscovery.Record => java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.servicediscovery.Record]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.servicediscovery.Record]]()
      asJava.getRecords({x: io.vertx.servicediscovery.Record => filter(x)}, new Handler[AsyncResult[java.util.List[io.vertx.servicediscovery.Record]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.servicediscovery.Record]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}

    /**
     * Like getRecords from [[io.vertx.servicediscovery.ServiceDiscovery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getRecordsFuture(filter: io.vertx.servicediscovery.Record => java.lang.Boolean,includeOutOfService: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.servicediscovery.Record]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.servicediscovery.Record]]()
      asJava.getRecords({x: io.vertx.servicediscovery.Record => filter(x)}, includeOutOfService, new Handler[AsyncResult[java.util.List[io.vertx.servicediscovery.Record]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.servicediscovery.Record]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}

    /**
     * Like update from [[io.vertx.servicediscovery.ServiceDiscovery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def updateFuture(record: io.vertx.servicediscovery.Record) : scala.concurrent.Future[io.vertx.servicediscovery.Record] = {
      val promise = concurrent.Promise[io.vertx.servicediscovery.Record]()
      asJava.update(record, new Handler[AsyncResult[io.vertx.servicediscovery.Record]] { override def handle(event: AsyncResult[io.vertx.servicediscovery.Record]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }



  type ServiceDiscoveryOptions = io.vertx.servicediscovery.ServiceDiscoveryOptions
  object ServiceDiscoveryOptions {
    def apply() = new ServiceDiscoveryOptions()
    def apply(json: JsonObject) = new ServiceDiscoveryOptions(json)
  }








  /**
    * The publisher is used by the importer to publish or unpublish records.
    */

  implicit class ServicePublisherScala(val asJava: io.vertx.servicediscovery.spi.ServicePublisher) extends AnyVal {

    /**
     * Like publish from [[io.vertx.servicediscovery.spi.ServicePublisher]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def publishFuture(record: io.vertx.servicediscovery.Record) : scala.concurrent.Future[io.vertx.servicediscovery.Record] = {
      val promise = concurrent.Promise[io.vertx.servicediscovery.Record]()
      asJava.publish(record, new Handler[AsyncResult[io.vertx.servicediscovery.Record]] { override def handle(event: AsyncResult[io.vertx.servicediscovery.Record]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like unpublish from [[io.vertx.servicediscovery.spi.ServicePublisher]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def unpublishFuture(id: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.unpublish(id, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like update from [[io.vertx.servicediscovery.spi.ServicePublisher]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def updateFuture(record: io.vertx.servicediscovery.Record) : scala.concurrent.Future[io.vertx.servicediscovery.Record] = {
      val promise = concurrent.Promise[io.vertx.servicediscovery.Record]()
      asJava.update(record, new Handler[AsyncResult[io.vertx.servicediscovery.Record]] { override def handle(event: AsyncResult[io.vertx.servicediscovery.Record]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }




}
