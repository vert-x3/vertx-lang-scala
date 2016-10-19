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
import io.vertx.groovy.ext.jdbc.JDBCClient
import io.vertx.servicediscovery.types.DataSource
import io.vertx.core.json.JsonObject
import io.vertx.servicediscovery.Record
import io.vertx.groovy.servicediscovery.ServiceDiscovery
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
*/
@CompileStatic
public class JDBCDataSource {
  private final def io.vertx.servicediscovery.types.JDBCDataSource delegate;
  public JDBCDataSource(Object delegate) {
    this.delegate = (io.vertx.servicediscovery.types.JDBCDataSource) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public static Map<String, Object> createRecord(String name, Map<String, Object> location, Map<String, Object> metadata) {
    def ret = (Map<String, Object>)InternalHelper.wrapObject(io.vertx.servicediscovery.types.JDBCDataSource.createRecord(name, location != null ? new io.vertx.core.json.JsonObject(location) : null, metadata != null ? new io.vertx.core.json.JsonObject(metadata) : null)?.toJson());
    return ret;
  }
  /**
   * Convenient method that looks for a JDBC datasource source and provides the configured {@link io.vertx.groovy.ext.jdbc.JDBCClient}. The
   * async result is marked as failed is there are no matching services, or if the lookup fails.
   * @param discovery The service discovery instance
   * @param filter The filter, optional
   * @param resultHandler The result handler
   */
  public static void getJDBCClient(ServiceDiscovery discovery, Map<String, Object> filter, Handler<AsyncResult<JDBCClient>> resultHandler) {
    io.vertx.servicediscovery.types.JDBCDataSource.getJDBCClient(discovery != null ? (io.vertx.servicediscovery.ServiceDiscovery)discovery.getDelegate() : null, filter != null ? new io.vertx.core.json.JsonObject(filter) : null, resultHandler != null ? new Handler<AsyncResult<io.vertx.ext.jdbc.JDBCClient>>() {
      public void handle(AsyncResult<io.vertx.ext.jdbc.JDBCClient> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.ext.jdbc.JDBCClient.class)));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  /**
   * Convenient method that looks for a JDBC datasource source and provides the configured {@link io.vertx.groovy.ext.jdbc.JDBCClient}. The
   * async result is marked as failed is there are no matching services, or if the lookup fails.
   * @param discovery The service discovery instance
   * @param filter The filter, optional
   * @param consumerConfiguration the consumer configuration
   * @param resultHandler the result handler
   */
  public static void getJDBCClient(ServiceDiscovery discovery, Map<String, Object> filter, Map<String, Object> consumerConfiguration, Handler<AsyncResult<JDBCClient>> resultHandler) {
    io.vertx.servicediscovery.types.JDBCDataSource.getJDBCClient(discovery != null ? (io.vertx.servicediscovery.ServiceDiscovery)discovery.getDelegate() : null, filter != null ? new io.vertx.core.json.JsonObject(filter) : null, consumerConfiguration != null ? new io.vertx.core.json.JsonObject(consumerConfiguration) : null, resultHandler != null ? new Handler<AsyncResult<io.vertx.ext.jdbc.JDBCClient>>() {
      public void handle(AsyncResult<io.vertx.ext.jdbc.JDBCClient> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture(InternalHelper.safeCreate(ar.result(), io.vertx.groovy.ext.jdbc.JDBCClient.class)));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
}
