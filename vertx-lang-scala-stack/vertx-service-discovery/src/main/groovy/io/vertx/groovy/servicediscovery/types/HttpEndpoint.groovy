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
import java.util.function.Function
import io.vertx.groovy.core.http.HttpClient
/**
 *  for HTTP endpoint (REST api).
 * Consumers receive a HTTP client configured with the host and port of the endpoint.
*/
@CompileStatic
public class HttpEndpoint {
  private final def io.vertx.servicediscovery.types.HttpEndpoint delegate;
  public HttpEndpoint(Object delegate) {
    this.delegate = (io.vertx.servicediscovery.types.HttpEndpoint) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Convenient method to create a record for a HTTP endpoint.
   * @param name the service name
   * @param host the host (IP or DNS name), it must be the _public_ IP / name
   * @param port the port, it must be the _public_ port
   * @param root the path of the service, "/" if not set
   * @param metadata additional metadata
   * @return the created record (see <a href="../../../../../../../cheatsheet/Record.html">Record</a>)
   */
  public static Map<String, Object> createRecord(String name, String host, int port, String root, Map<String, Object> metadata) {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(io.vertx.servicediscovery.types.HttpEndpoint.createRecord(name, host, port, root, metadata != null ? new io.vertx.core.json.JsonObject(metadata) : null)?.toJson());
    return ret;
  }
  /**
   * Same as {@link io.vertx.groovy.servicediscovery.types.HttpEndpoint#createRecord} but let you configure whether or not the
   * service is using <code>https</code>.
   * @param name the service name
   * @param ssl whether or not the service is using HTTPS
   * @param host the host (IP or DNS name), it must be the _public_ IP / name
   * @param port the port, it must be the _public_ port
   * @param root the path of the service, "/" if not set
   * @param metadata additional metadata
   * @return the created record (see <a href="../../../../../../../cheatsheet/Record.html">Record</a>)
   */
  public static Map<String, Object> createRecord(String name, boolean ssl, String host, int port, String root, Map<String, Object> metadata) {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(io.vertx.servicediscovery.types.HttpEndpoint.createRecord(name, ssl, host, port, root, metadata != null ? new io.vertx.core.json.JsonObject(metadata) : null)?.toJson());
    return ret;
  }
  /**
   * Same as {@link io.vertx.groovy.servicediscovery.types.HttpEndpoint#createRecord} but without metadata.
   * @param name the service name
   * @param host the host, must be public
   * @param port the port
   * @param root the root, if not set "/" is used
   * @return the created record (see <a href="../../../../../../../cheatsheet/Record.html">Record</a>)
   */
  public static Map<String, Object> createRecord(String name, String host, int port, String root) {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(io.vertx.servicediscovery.types.HttpEndpoint.createRecord(name, host, port, root)?.toJson());
    return ret;
  }
  /**
   * Same as {@link io.vertx.groovy.servicediscovery.types.HttpEndpoint#createRecord} but without metadata, using the port 80
   * and using "/" as root.
   * @param name the name
   * @param host the host
   * @return the created record (see <a href="../../../../../../../cheatsheet/Record.html">Record</a>)
   */
  public static Map<String, Object> createRecord(String name, String host) {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(io.vertx.servicediscovery.types.HttpEndpoint.createRecord(name, host)?.toJson());
    return ret;
  }
  /**
   * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
   * is marked as failed is there are no matching services, or if the lookup fails.
   * @param discovery The service discovery instance
   * @param filter The filter, optional
   * @param resultHandler The result handler
   */
  public static void getClient(ServiceDiscovery discovery, Map<String, Object> filter, Handler<AsyncResult<HttpClient>> resultHandler) {
    io.vertx.servicediscovery.types.HttpEndpoint.getClient(discovery != null ? (io.vertx.servicediscovery.ServiceDiscovery)discovery.getDelegate() : null, filter != null ? new io.vertx.core.json.JsonObject(filter) : null, resultHandler != null ? new Handler<AsyncResult<io.vertx.core.http.HttpClient>>() {
      public void handle(AsyncResult<io.vertx.core.http.HttpClient> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.http.HttpClient.class)));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  /**
   * Convenient method that looks for a HTTP endpoint and provides the configured . The async result
   * is marked as failed is there are no matching services, or if the lookup fails.
   * @param discovery The service discovery instance
   * @param filter The filter
   * @param resultHandler The result handler
   */
  public static void getClient(ServiceDiscovery discovery, java.util.function.Function<Map<String, Object>, Boolean> filter, Handler<AsyncResult<HttpClient>> resultHandler) {
    io.vertx.servicediscovery.types.HttpEndpoint.getClient(discovery != null ? (io.vertx.servicediscovery.ServiceDiscovery)discovery.getDelegate() : null, filter != null ? new java.util.function.Function<io.vertx.servicediscovery.Record, java.lang.Boolean>(){
      public java.lang.Boolean apply(io.vertx.servicediscovery.Record arg_) {
        def ret = filter.apply((Map<String, Object>)InternalHelper.wrapObject(arg_?.toJson()));
        return ret != null ? ret : null;
      }
    } : null, resultHandler != null ? new Handler<AsyncResult<io.vertx.core.http.HttpClient>>() {
      public void handle(AsyncResult<io.vertx.core.http.HttpClient> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.core.http.HttpClient.class)));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
}
