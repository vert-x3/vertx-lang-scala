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

package io.vertx.groovy.servicediscovery.spi;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.servicediscovery.Record
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * The publisher is used by the importer to publish or unpublish records.
*/
@CompileStatic
public class ServicePublisher {
  private final def io.vertx.servicediscovery.spi.ServicePublisher delegate;
  public ServicePublisher(Object delegate) {
    this.delegate = (io.vertx.servicediscovery.spi.ServicePublisher) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Publishes a record.
   * @param record the record (see <a href="../../../../../../../cheatsheet/Record.html">Record</a>)
   * @param resultHandler handler called when the operation has completed (successfully or not). In case of success, the passed record has a registration id required to modify and un-register the service.
   */
  public void publish(Map<String, Object> record = [:], Handler<AsyncResult<Map<String, Object>>> resultHandler) {
    delegate.publish(record != null ? new io.vertx.servicediscovery.Record(io.vertx.lang.groovy.InternalHelper.toJsonObject(record)) : null, resultHandler != null ? new Handler<AsyncResult<io.vertx.servicediscovery.Record>>() {
      public void handle(AsyncResult<io.vertx.servicediscovery.Record> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
  /**
   * Un-publishes a record.
   * @param id the registration id
   * @param resultHandler handler called when the operation has completed (successfully or not).
   */
  public void unpublish(String id, Handler<AsyncResult<Void>> resultHandler) {
    delegate.unpublish(id, resultHandler);
  }
}
