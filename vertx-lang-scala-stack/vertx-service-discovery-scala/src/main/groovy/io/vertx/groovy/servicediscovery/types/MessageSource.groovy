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

package io.vertx.groovy.servicediscovery.types;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.servicediscovery.spi.ServiceType
import io.vertx.core.json.JsonObject
import io.vertx.servicediscovery.Record
import io.vertx.groovy.servicediscovery.ServiceDiscovery
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.groovy.core.eventbus.MessageConsumer
/**
 * Service type for data producer. Providers are publishing data to a specific event bus address.
*/
@CompileStatic
public class MessageSource {
  private final def io.vertx.servicediscovery.types.MessageSource delegate;
  public MessageSource(Object delegate) {
    this.delegate = (io.vertx.servicediscovery.types.MessageSource) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Create a record representing a data producer.
   * @param name the name of the service
   * @param address the address on which the data is sent
   * @param type the type of payload (fully qualified name of the class)
   * @param metadata additional metadata
   * @return the created record (see <a href="../../../../../../../cheatsheet/Record.html">Record</a>)
   */
  public static Map<String, Object> createRecord(String name, String address, String type, Map<String, Object> metadata) {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(io.vertx.servicediscovery.types.MessageSource.createRecord(name, address, type, metadata != null ? new io.vertx.core.json.JsonObject(metadata) : null)?.toJson());
    return ret;
  }
  /**
   * Same as {@link io.vertx.groovy.servicediscovery.types.MessageSource#createRecord} without additional metadata.
   * @param name the name of the service
   * @param address the address on which the data is sent
   * @param type the type of payload
   * @return the created record (see <a href="../../../../../../../cheatsheet/Record.html">Record</a>)
   */
  public static Map<String, Object> createRecord(String name, String address, String type) {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(io.vertx.servicediscovery.types.MessageSource.createRecord(name, address, type)?.toJson());
    return ret;
  }
  /**
   * Same as {@link io.vertx.groovy.servicediscovery.types.MessageSource#createRecord} without additional metadata, and no type for
   * the payload.
   * @param name the name of the service
   * @param address the address on which the data is sent.
   * @return the created record (see <a href="../../../../../../../cheatsheet/Record.html">Record</a>)
   */
  public static Map<String, Object> createRecord(String name, String address) {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(io.vertx.servicediscovery.types.MessageSource.createRecord(name, address)?.toJson());
    return ret;
  }
  /**
   * Convenient method that looks for a message source and provides the configured . The
   * async result is marked as failed is there are no matching services, or if the lookup fails.
   * @param discovery The service discovery instance
   * @param filter The filter, optional
   * @param resultHandler The result handler
   */
  public static <T> void getConsumer(ServiceDiscovery discovery, Map<String, Object> filter, Handler<AsyncResult<MessageConsumer<T>>> resultHandler) {
    io.vertx.servicediscovery.types.MessageSource.getConsumer(discovery != null ? (io.vertx.servicediscovery.ServiceDiscovery)discovery.getDelegate() : null, filter != null ? new io.vertx.core.json.JsonObject(filter) : null, resultHandler != null ? new Handler<AsyncResult<io.vertx.core.eventbus.MessageConsumer<java.lang.Object>>>() {
      public void handle(AsyncResult<io.vertx.core.eventbus.MessageConsumer<java.lang.Object>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.eventbus.MessageConsumer.class)));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
}
