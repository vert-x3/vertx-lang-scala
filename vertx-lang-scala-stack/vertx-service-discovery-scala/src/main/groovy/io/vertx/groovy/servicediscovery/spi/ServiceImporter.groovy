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
import io.vertx.groovy.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.core.Handler
import io.vertx.groovy.core.Future
/**
 * The service importer allows integrate other discovery technologies with the Vert.x service discovery. It maps
 * entries from another technology to a  and maps  to a publication in this other
 * technology. The importer is one side of a service discovery bridge.
*/
@CompileStatic
public class ServiceImporter {
  private final def io.vertx.servicediscovery.spi.ServiceImporter delegate;
  public ServiceImporter(Object delegate) {
    this.delegate = (io.vertx.servicediscovery.spi.ServiceImporter) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Starts the importer.
   * @param vertx the vertx instance
   * @param publisher the service discovery instance
   * @param configuration the bridge configuration if any
   * @param future a future on which the bridge must report the completion of the starting
   */
  public void start(Vertx vertx, ServicePublisher publisher, Map<String, Object> configuration, Future<Void> future) {
    delegate.start(vertx != null ? (io.vertx.core.Vertx)vertx.getDelegate() : null, publisher != null ? (io.vertx.servicediscovery.spi.ServicePublisher)publisher.getDelegate() : null, configuration != null ? new io.vertx.core.json.JsonObject(configuration) : null, future != null ? (io.vertx.core.Future<java.lang.Void>)future.getDelegate() : null);
  }
  /**
   * Closes the importer
   * @param closeHandler the handle to be notified when importer is closed, may be <code>null</code>
   */
  public void close(Handler<Void> closeHandler) {
    delegate.close(closeHandler);
  }
}
