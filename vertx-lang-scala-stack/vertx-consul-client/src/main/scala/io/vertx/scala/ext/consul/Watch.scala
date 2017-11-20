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

package io.vertx.scala.ext.consul

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.consul.{ServiceEntryList => JServiceEntryList}
import io.vertx.ext.consul.{KeyValueList => JKeyValueList}
import io.vertx.ext.consul.{EventList => JEventList}
import io.vertx.ext.consul.{NodeList => JNodeList}
import io.vertx.ext.consul.{WatchResult => JWatchResult}
import io.vertx.ext.consul.{ServiceList => JServiceList}
import io.vertx.core.Handler
import io.vertx.ext.consul.{ConsulClientOptions => JConsulClientOptions}
import io.vertx.ext.consul.{KeyValue => JKeyValue}
import io.vertx.scala.core.Vertx
import io.vertx.ext.consul.{Watch => JWatch}
import io.vertx.core.{Vertx => JVertx}

/**
  * Watches are a way of specifying a view of data (e.g. list of nodes, KV pairs, health checks)
  * which is monitored for updates. When an update is detected, an `Handler` with `AsyncResult` is invoked.
  * As an example, you could watch the status of health checks and notify when a check is critical.
  */
class Watch[T: TypeTag](private val _asJava: Object) {

  def asJava = _asJava


  /**
    * Set the result handler. As data is changed, the handler will be called with the result.
    * @param handler the result handler
    * @return reference to this, for fluency
    */
  def setHandler(handler: Handler[WatchResult[T]]): Watch[T] = {
    asJava.asInstanceOf[JWatch[Object]].setHandler({x: JWatchResult[Object] => handler.handle(WatchResult[T](x))})
    this
  }

  /**
    * Start this `Watch`
    * @return reference to this, for fluency
    */
  def start(): Watch[T] = {
    asJava.asInstanceOf[JWatch[Object]].start()
    this
  }

  /**
    * Stop the watch and release its resources
    */
  def stop(): Unit = {
    asJava.asInstanceOf[JWatch[Object]].stop()
  }

}

object Watch {
  def apply[T: TypeTag](asJava: JWatch[_]) = new Watch[T](asJava)  
  /**
    * Creates `Watch` to monitoring a specific key in the KV store.
    * The underlying Consul client will be created with default options.
    * This maps to the <a href="https://www.consul.io/api/kv.html">/v1/kv/</a> API internally.
    * @param key the key
    * @param vertx the `Vertx` instance
    * @return the `Watch` instance
    */
  def key(key: String, vertx: Vertx): Watch[KeyValue] = {
    Watch[KeyValue](JWatch.key(key.asInstanceOf[java.lang.String], vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Creates `Watch` to monitoring a specific key in the KV store.
    * This maps to the <a href="https://www.consul.io/api/kv.html">/v1/kv/</a> API internally.
    * @param key the key
    * @param vertx the `Vertx` instance
    * @param options the options to create underlying Consul clientsee <a href="../../../../../../../cheatsheet/ConsulClientOptions.html">ConsulClientOptions</a>
    * @return the `Watch` instance
    */
  def key(key: String, vertx: Vertx, options: ConsulClientOptions): Watch[KeyValue] = {
    Watch[KeyValue](JWatch.key(key.asInstanceOf[java.lang.String], vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  /**
    * Creates `Watch` to monitoring a prefix of keys in the KV store.
    * The underlying Consul client will be created with default options.
    * This maps to the <a href="https://www.consul.io/api/kv.html">/v1/kv/</a> API internally.
    * @param keyPrefix the key
    * @param vertx the `Vertx` instance
    * @return the `Watch` instance
    */
  def keyPrefix(keyPrefix: String, vertx: Vertx): Watch[KeyValueList] = {
    Watch[KeyValueList](JWatch.keyPrefix(keyPrefix.asInstanceOf[java.lang.String], vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Creates `Watch` to monitoring a prefix of keys in the KV store.
    * This maps to the <a href="https://www.consul.io/api/kv.html">/v1/kv/</a> API internally.
    * @param keyPrefix the key
    * @param vertx the `Vertx` instance
    * @param options the options to create underlying Consul clientsee <a href="../../../../../../../cheatsheet/ConsulClientOptions.html">ConsulClientOptions</a>
    * @return the `Watch` instance
    */
  def keyPrefix(keyPrefix: String, vertx: Vertx, options: ConsulClientOptions): Watch[KeyValueList] = {
    Watch[KeyValueList](JWatch.keyPrefix(keyPrefix.asInstanceOf[java.lang.String], vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  /**
    * Creates `Watch` to monitoring the list of available services.
    * The underlying Consul client will be created with default options.
    * This maps to the <a href="https://www.consul.io/docs/agent/http/catalog.html#catalog_services">/v1/catalog/services</a> API internally.
    * @param vertx the `Vertx` instance
    * @return the `Watch` instance
    */
  def services(vertx: Vertx): Watch[ServiceList] = {
    Watch[ServiceList](JWatch.services(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Creates `Watch` to monitoring the list of available services.
    * This maps to the <a href="https://www.consul.io/docs/agent/http/catalog.html#catalog_services">/v1/catalog/services</a> API internally.
    * @param vertx the `Vertx` instance
    * @param options the options to create underlying Consul clientsee <a href="../../../../../../../cheatsheet/ConsulClientOptions.html">ConsulClientOptions</a>
    * @return the `Watch` instance
    */
  def services(vertx: Vertx, options: ConsulClientOptions): Watch[ServiceList] = {
    Watch[ServiceList](JWatch.services(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  /**
    * Creates `Watch` to monitoring the nodes providing the service.
    * The underlying Consul client will be created with default options.
    * This maps to the <a href="https://www.consul.io/docs/agent/http/health.html#health_service">/v1/health/service/&lt;service&gt;</a> API internally.
    * @param service the service name
    * @param vertx the `Vertx` instance
    * @return the `Watch` instance
    */
  def service(service: String, vertx: Vertx): Watch[ServiceEntryList] = {
    Watch[ServiceEntryList](JWatch.service(service.asInstanceOf[java.lang.String], vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Creates `Watch` to monitoring the nodes providing the service.
    * This maps to the <a href="https://www.consul.io/docs/agent/http/health.html#health_service">/v1/health/service/&lt;service&gt;</a> API internally.
    * @param service the service name
    * @param vertx the `Vertx` instance
    * @param options the options to create underlying Consul clientsee <a href="../../../../../../../cheatsheet/ConsulClientOptions.html">ConsulClientOptions</a>
    * @return the `Watch` instance
    */
  def service(service: String, vertx: Vertx, options: ConsulClientOptions): Watch[ServiceEntryList] = {
    Watch[ServiceEntryList](JWatch.service(service.asInstanceOf[java.lang.String], vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  /**
    * Creates `Watch` to monitoring the custom user events.
    * The underlying Consul client will be created with default options.
    * This maps to the <a href="https://www.consul.io/docs/agent/http/event.html#event_list">/v1/event/list</a> API internally.
    * @param event the event name
    * @param vertx the `Vertx` instance
    * @return the `Watch` instance
    */
  def events(event: String, vertx: Vertx): Watch[EventList] = {
    Watch[EventList](JWatch.events(event.asInstanceOf[java.lang.String], vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Creates `Watch` to monitoring the custom user events.
    * This maps to the <a href="https://www.consul.io/docs/agent/http/event.html#event_list">/v1/event/list</a> API internally.
    * @param event the event name
    * @param vertx the `Vertx` instance
    * @param options the options to create underlying Consul clientsee <a href="../../../../../../../cheatsheet/ConsulClientOptions.html">ConsulClientOptions</a>
    * @return the `Watch` instance
    */
  def events(event: String, vertx: Vertx, options: ConsulClientOptions): Watch[EventList] = {
    Watch[EventList](JWatch.events(event.asInstanceOf[java.lang.String], vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  /**
    * Creates `Watch` to monitoring the list of available nodes.
    * The underlying Consul client will be created with default options.
    * This maps to the <a href="https://www.consul.io/api/catalog.html#list-nodes">/v1/catalog/nodes</a> API internally.
    * @param vertx the `Vertx` instance
    * @return the `Watch` instance
    */
  def nodes(vertx: Vertx): Watch[NodeList] = {
    Watch[NodeList](JWatch.nodes(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Creates `Watch` to monitoring the list of available nodes.
    * This maps to the <a href="https://www.consul.io/api/catalog.html#list-nodes">/v1/catalog/nodes</a> API internally.
    * @param vertx the `Vertx` instance
    * @param options the options to create underlying Consul clientsee <a href="../../../../../../../cheatsheet/ConsulClientOptions.html">ConsulClientOptions</a>
    * @return the `Watch` instance
    */
  def nodes(vertx: Vertx, options: ConsulClientOptions): Watch[NodeList] = {
    Watch[NodeList](JWatch.nodes(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

}
