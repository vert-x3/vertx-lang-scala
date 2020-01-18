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

package io.vertx.scala.ext.web.handler

import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import scala.reflect.runtime.universe._
import io.vertx.ext.web.handler.{MultiTenantHandler => JMultiTenantHandler}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A handler which selectively executes another handler if a precondition is met.
  *
  * There are cases where applications are build as multi tenant, in this cases one of the
  * common tasks is to configure different authentication mechanisms for each tenant.
  *
  * This handler will allow registering any other handler and will only execute it if
  * the precondition is met. There are 2 way of defining a precondition:
  *
  * <ul>
  *     <li>A http header value for example <pre>X-Tenant</pre></li>
  *     <li>A custom extractor function that can return a String from the context</li>
  * </ul>
  *
  * Requests that pass the validation will contain a new key in the routing context with
  * the tenant id, for the case of being a default handler the value if this key will be "default".
  */

class MultiTenantHandler(private val _asJava: Object) extends io.vertx.core.Handler[RoutingContext] {
  def asJava = _asJava



  /**
   * Add a handler for a given tenant to this handler.
   *
   * Both tenant and handler cannot be null.   * @param tenant the tenant id
   * @param handler the handler to register.
   * @return a fluent reference to self.
   */
  
  def addTenantHandler(tenant: String, handler: Handler[RoutingContext]): MultiTenantHandler = {
    asJava.asInstanceOf[JMultiTenantHandler].addTenantHandler(tenant.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[JRoutingContext]{def handle(x: JRoutingContext) {handler.handle(RoutingContext(x))}}))
    this
  }

  /**
   * Remove a handler for a given tenant from this handler.
   *
   * Tenant cannot be null.   * @param tenant the tenant id
   * @return a fluent reference to self.
   */
  
  def removeTenant(tenant: String): MultiTenantHandler = {
    asJava.asInstanceOf[JMultiTenantHandler].removeTenant(tenant.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Add a default handler for the case when no tenant was matched.
   *
   * The handler cannot be null.   * @param handler the handler to register.
   * @return a fluent reference to self.
   */
  
  def addDefaultHandler(handler: Handler[RoutingContext]): MultiTenantHandler = {
    asJava.asInstanceOf[JMultiTenantHandler].addDefaultHandler((if (handler == null) null else new io.vertx.core.Handler[JRoutingContext]{def handle(x: JRoutingContext) {handler.handle(RoutingContext(x))}}))
    this
  }




  override def handle (arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JMultiTenantHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }


}

object MultiTenantHandler {
  def apply(asJava: JMultiTenantHandler) = new MultiTenantHandler(asJava)

  /**
   * Create a MultiTenant handler that will extract the tenant id from a given header name.   * @param header the header to lookup (e.g.: "X-Tenant")
   * @return the new handler.
   */
  def create(header: String): MultiTenantHandler = {
    MultiTenantHandler(JMultiTenantHandler.create(header.asInstanceOf[java.lang.String]))//2 create
  }

  /**
   * Create a MultiTenant handler using a custom tenant extraction function.   * @param tenantExtractor the function that extracts the tenant id from the request
   * @return the new handler.
   */
  def create(tenantExtractor: RoutingContext => String): MultiTenantHandler = {
    MultiTenantHandler(JMultiTenantHandler.create({x: JRoutingContext => tenantExtractor(RoutingContext(x)).asInstanceOf[java.lang.String]}))//2 create
  }

  /**
   * Create a MultiTenant handler using a custom tenant extraction function.   * @param tenantExtractor the function that extracts the tenant id from the request
   * @param contextKey the custom key to store the tenant id in the context
   * @return the new handler.
   */
  def create(tenantExtractor: RoutingContext => String,contextKey: String): MultiTenantHandler = {
    MultiTenantHandler(JMultiTenantHandler.create({x: JRoutingContext => tenantExtractor(RoutingContext(x)).asInstanceOf[java.lang.String]}, contextKey.asInstanceOf[java.lang.String]))//2 create
  }

}
