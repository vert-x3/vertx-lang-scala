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

package io.vertx.scala.ext.web

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.http.HttpMethod
import io.vertx.core.Handler

/**
  * A route is a holder for a set of criteria which determine whether an HTTP request or failure should be routed
  * to a handler.
  */
class Route(private val _asJava: io.vertx.ext.web.Route) {

  def asJava: io.vertx.ext.web.Route = _asJava

  /**
    * Add an HTTP method for this route. By default a route will match all HTTP methods. If any are specified then the route
    * will only match any of the specified methods
    * @param method the HTTP method to add
    * @return a reference to this, so the API can be used fluently
    */
  def method(method: io.vertx.core.http.HttpMethod): io.vertx.scala.ext.web.Route = {
    _asJava.method(method)
    this
  }

  /**
    * Set the path prefix for this route. If set then this route will only match request URI paths which start with this
    * path prefix. Only a single path or path regex can be set for a route.
    * @param path the path prefix
    * @return a reference to this, so the API can be used fluently
    */
  def path(path: String): io.vertx.scala.ext.web.Route = {
    _asJava.path(path)
    this
  }

  /**
    * Set the path prefix as a regular expression. If set then this route will only match request URI paths, the beginning
    * of which match the regex. Only a single path or path regex can be set for a route.
    * @param path the path regex
    * @return a reference to this, so the API can be used fluently
    */
  def pathRegex(path: String): io.vertx.scala.ext.web.Route = {
    _asJava.pathRegex(path)
    this
  }

  /**
    * Add a content type produced by this route. Used for content based routing.
    * @param contentType the content type
    * @return a reference to this, so the API can be used fluently
    */
  def produces(contentType: String): io.vertx.scala.ext.web.Route = {
    _asJava.produces(contentType)
    this
  }

  /**
    * Add a content type consumed by this route. Used for content based routing.
    * @param contentType the content type
    * @return a reference to this, so the API can be used fluently
    */
  def consumes(contentType: String): io.vertx.scala.ext.web.Route = {
    _asJava.consumes(contentType)
    this
  }

  /**
    * Specify the order for this route. The router tests routes in that order.
    * @param order the order
    * @return a reference to this, so the API can be used fluently
    */
  def order(order: Int): io.vertx.scala.ext.web.Route = {
    _asJava.order(order)
    this
  }

  /**
    * Specify this is the last route for the router.
    * @return a reference to this, so the API can be used fluently
    */
  def last(): io.vertx.scala.ext.web.Route = {
    _asJava.last()
    this
  }

  /**
    * Specify a request handler for the route. The router routes requests to handlers depending on whether the various
    * criteria such as method, path, etc match. There can be only one request handler for a route. If you set this more
    * than once it will overwrite the previous handler.
    * @param requestHandler the request handler
    * @return a reference to this, so the API can be used fluently
    */
  def handler(requestHandler: io.vertx.scala.ext.web.RoutingContext => Unit): io.vertx.scala.ext.web.Route = {
    _asJava.handler(funcToMappedHandler(RoutingContext.apply)(requestHandler))
    this
  }

  /**
    * Like [[io.vertx.scala.ext.web.Route#blockingHandler]] called with ordered = true
    */
  def blockingHandler(requestHandler: io.vertx.scala.ext.web.RoutingContext => Unit): io.vertx.scala.ext.web.Route = {
    _asJava.blockingHandler(funcToMappedHandler(RoutingContext.apply)(requestHandler))
    this
  }

  /**
    * Specify a blocking request handler for the route.
    * This method works just like [[io.vertx.scala.ext.web.Route#handler]] excepted that it will run the blocking handler on a worker thread
    * so that it won't block the event loop. Note that it's safe to call context.next() from the
    * blocking handler as it will be executed on the event loop context (and not on the worker thread.
    *
    * If the blocking handler is ordered it means that any blocking handlers for the same context are never executed
    * concurrently but always in the order they were called. The default value of ordered is true. If you do not want this
    * behaviour and don't mind if your blocking handlers are executed in parallel you can set ordered to false.
    * @param requestHandler the blocking request handler
    * @param ordered if true handlers are executed in sequence, otherwise are run in parallel
    * @return a reference to this, so the API can be used fluently
    */
  def blockingHandler(requestHandler: io.vertx.scala.ext.web.RoutingContext => Unit, ordered: Boolean): io.vertx.scala.ext.web.Route = {
    _asJava.blockingHandler(funcToMappedHandler(RoutingContext.apply)(requestHandler), ordered)
    this
  }

  /**
    * Specify a failure handler for the route. The router routes failures to failurehandlers depending on whether the various
    * criteria such as method, path, etc match. There can be only one failure handler for a route. If you set this more
    * than once it will overwrite the previous handler.
    * @param failureHandler the request handler
    * @return a reference to this, so the API can be used fluently
    */
  def failureHandler(failureHandler: io.vertx.scala.ext.web.RoutingContext => Unit): io.vertx.scala.ext.web.Route = {
    _asJava.failureHandler(funcToMappedHandler(RoutingContext.apply)(failureHandler))
    this
  }

  /**
    * Remove this route from the router
    * @return a reference to this, so the API can be used fluently
    */
  def remove(): io.vertx.scala.ext.web.Route = {
    _asJava.remove()
    this
  }

  /**
    * Disable this route. While disabled the router will not route any requests or failures to it.
    * @return a reference to this, so the API can be used fluently
    */
  def disable(): io.vertx.scala.ext.web.Route = {
    _asJava.disable()
    this
  }

  /**
    * Enable this route.
    * @return a reference to this, so the API can be used fluently
    */
  def enable(): io.vertx.scala.ext.web.Route = {
    _asJava.enable()
    this
  }

  /**
    * If true then the normalised request path will be used when routing (e.g. removing duplicate /)
    * Default is true
    * @param useNormalisedPath use normalised path for routing?
    * @return a reference to this, so the API can be used fluently
    */
  def useNormalisedPath(useNormalisedPath: Boolean): io.vertx.scala.ext.web.Route = {
    _asJava.useNormalisedPath(useNormalisedPath)
    this
  }

  /**
    * @return the path prefix (if any) for this route
    */
  def getPath(): scala.Option[String] = {
        scala.Option(_asJava.getPath())
  }

}

object Route {

  def apply(_asJava: io.vertx.ext.web.Route): io.vertx.scala.ext.web.Route =
    new io.vertx.scala.ext.web.Route(_asJava)

}
