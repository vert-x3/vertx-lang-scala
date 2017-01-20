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
import io.vertx.scala.core.http.HttpClient
import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.scala.servicediscovery.ServiceDiscovery
import io.vertx.webclient.{WebClient => JWebClient}
import io.vertx.scala.webclient.WebClient
import io.vertx.servicediscovery.types.{HttpEndpoint => JHttpEndpoint}
import io.vertx.core.http.{HttpClient => JHttpClient}
import io.vertx.servicediscovery.{ServiceDiscovery => JServiceDiscovery}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.servicediscovery.Record

/**
  *  for HTTP endpoint (REST api).
  * Consumers receive a HTTP client configured with the host and port of the endpoint.
  */
class HttpEndpoint(private val _asJava: Object) {

  def asJava = _asJava

}

object HttpEndpoint{
  def apply(asJava: JHttpEndpoint) = new HttpEndpoint(asJava)  
  /**
    * Convenient method to create a record for a HTTP endpoint.
    * @param name the service name
    * @param host the host (IP or DNS name), it must be the _public_ IP / name
    * @param port the port, it must be the _public_ port
    * @param root the path of the service, "/" if not set
    * @param metadata additional metadata
    * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
    */
  def createRecord(name: String,host: String,port: Int,root: String,metadata: io.vertx.core.json.JsonObject):Record = {
    Record(JHttpEndpoint.createRecord(name.asInstanceOf[java.lang.String],host.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],root.asInstanceOf[java.lang.String],metadata))
  }

  /**
    * Same as [[io.vertx.scala.servicediscovery.types.HttpEndpoint#createRecord]] but let you configure whether or not the
    * service is using `https`.
    * @param name the service name
    * @param ssl whether or not the service is using HTTPS
    * @param host the host (IP or DNS name), it must be the _public_ IP / name
    * @param port the port, it must be the _public_ port
    * @param root the path of the service, "/" if not set
    * @param metadata additional metadata
    * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
    */
  def createRecord(name: String,ssl: Boolean,host: String,port: Int,root: String,metadata: io.vertx.core.json.JsonObject):Record = {
    Record(JHttpEndpoint.createRecord(name.asInstanceOf[java.lang.String],ssl.asInstanceOf[java.lang.Boolean],host.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],root.asInstanceOf[java.lang.String],metadata))
  }

  /**
    * Same as [[io.vertx.scala.servicediscovery.types.HttpEndpoint#createRecord]] but without metadata.
    * @param name the service name
    * @param host the host, must be public
    * @param port the port
    * @param root the root, if not set "/" is used
    * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
    */
  def createRecord(name: String,host: String,port: Int,root: String):Record = {
    Record(JHttpEndpoint.createRecord(name.asInstanceOf[java.lang.String],host.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],root.asInstanceOf[java.lang.String]))
  }

  /**
    * Same as [[io.vertx.scala.servicediscovery.types.HttpEndpoint#createRecord]] but without metadata, using the port 80
    * and using "/" as root.
    * @param name the name
    * @param host the host
    * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
    */
  def createRecord(name: String,host: String):Record = {
    Record(JHttpEndpoint.createRecord(name.asInstanceOf[java.lang.String],host.asInstanceOf[java.lang.String]))
  }

  /**
    * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
    * is marked as failed is there are no matching services, or if the lookup fails.
    * @param discovery The service discovery instance
    * @param filter The filter, optional
    */
  def getClientFuture(discovery: ServiceDiscovery,filter: io.vertx.core.json.JsonObject):scala.concurrent.Future[HttpClient] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClient, HttpClient](x => HttpClient(x))
    JHttpEndpoint.getClient(discovery.asJava.asInstanceOf[JServiceDiscovery],filter,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
    * is marked as failed is there are no matching services, or if the lookup fails.
    * @param discovery The service discovery instance
    * @param filter The filter, optional
    */
  def getWebClientFuture(discovery: ServiceDiscovery,filter: io.vertx.core.json.JsonObject):scala.concurrent.Future[WebClient] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JWebClient, WebClient](x => WebClient(x))
    JHttpEndpoint.getWebClient(discovery.asJava.asInstanceOf[JServiceDiscovery],filter,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
    * is marked as failed is there are no matching services, or if the lookup fails. This method accepts a
    * configuration for the HTTP client
    * @param discovery The service discovery instance
    * @param filter The filter, optional
    * @param conf the configuration of the client
    */
  def getClientFuture(discovery: ServiceDiscovery,filter: io.vertx.core.json.JsonObject,conf: io.vertx.core.json.JsonObject):scala.concurrent.Future[HttpClient] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClient, HttpClient](x => HttpClient(x))
    JHttpEndpoint.getClient(discovery.asJava.asInstanceOf[JServiceDiscovery],filter,conf,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
    * is marked as failed is there are no matching services, or if the lookup fails. This method accepts a
    * configuration for the HTTP client
    * @param discovery The service discovery instance
    * @param filter The filter, optional
    * @param conf the configuration of the client
    */
  def getWebClientFuture(discovery: ServiceDiscovery,filter: io.vertx.core.json.JsonObject,conf: io.vertx.core.json.JsonObject):scala.concurrent.Future[WebClient] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JWebClient, WebClient](x => WebClient(x))
    JHttpEndpoint.getWebClient(discovery.asJava.asInstanceOf[JServiceDiscovery],filter,conf,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
    * is marked as failed is there are no matching services, or if the lookup fails.
    * @param discovery The service discovery instance
    * @param filter The filter
    */
  def getClientFuture(discovery: ServiceDiscovery,filter: Record => Boolean):scala.concurrent.Future[HttpClient] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClient, HttpClient](x => HttpClient(x))
    JHttpEndpoint.getClient(discovery.asJava.asInstanceOf[JServiceDiscovery],{x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]},promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
    * is marked as failed is there are no matching services, or if the lookup fails.
    * @param discovery The service discovery instance
    * @param filter The filter
    */
  def getWebClientFuture(discovery: ServiceDiscovery,filter: Record => Boolean):scala.concurrent.Future[WebClient] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JWebClient, WebClient](x => WebClient(x))
    JHttpEndpoint.getWebClient(discovery.asJava.asInstanceOf[JServiceDiscovery],{x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]},promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
    * is marked as failed is there are no matching services, or if the lookup fails. This method accepts a
    * configuration for the HTTP client.
    * @param discovery The service discovery instance
    * @param filter The filter
    * @param conf the configuration of the client
    */
  def getClientFuture(discovery: ServiceDiscovery,filter: Record => Boolean,conf: io.vertx.core.json.JsonObject):scala.concurrent.Future[HttpClient] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClient, HttpClient](x => HttpClient(x))
    JHttpEndpoint.getClient(discovery.asJava.asInstanceOf[JServiceDiscovery],{x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]},conf,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
    * is marked as failed is there are no matching services, or if the lookup fails. This method accepts a
    * configuration for the HTTP client.
    * @param discovery The service discovery instance
    * @param filter The filter
    * @param conf the configuration of the client
    */
  def getWebClientFuture(discovery: ServiceDiscovery,filter: Record => Boolean,conf: io.vertx.core.json.JsonObject):scala.concurrent.Future[WebClient] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JWebClient, WebClient](x => WebClient(x))
    JHttpEndpoint.getWebClient(discovery.asJava.asInstanceOf[JServiceDiscovery],{x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]},conf,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}
