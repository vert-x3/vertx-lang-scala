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

import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import scala.reflect.runtime.universe._
import io.vertx.scala.core.http.HttpServerRequest
import io.vertx.ext.web.{Route => JRoute}
import scala.collection.JavaConverters._
import io.vertx.ext.web.{Router => JRouter}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.Converter._
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.core.http.HttpMethod
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * A router receives request from an [[io.vertx.scala.core.http.HttpServer]] and routes it to the first matching
  * [[io.vertx.scala.ext.web.Route]] that it contains. A router can contain many routes.
  * 
  * Routers are also used for routing failures.
  */

class Router(private val _asJava: Object) extends io.vertx.core.Handler[HttpServerRequest] {
  def asJava = _asJava



  /**
   * Remove all the routes from this router   * @return a reference to this, so the API can be used fluently
   */
  
  def clear(): Router = {
    asJava.asInstanceOf[JRouter].clear()
    this
  }

  /**
   * Mount a sub router on this router   * @param mountPoint the mount point (path prefix) to mount it on
   * @param subRouter the router to mount as a sub router
   * @return a reference to this, so the API can be used fluently
   */
  
  def mountSubRouter(mountPoint: String, subRouter: Router): Router = {
    asJava.asInstanceOf[JRouter].mountSubRouter(mountPoint.asInstanceOf[java.lang.String], subRouter.asJava.asInstanceOf[JRouter])
    this
  }

  /**
   * Specify a handler for any unhandled exceptions on this router. The handler will be called for exceptions thrown
   * from handlers. This does not affect the normal failure routing logic.   * @param exceptionHandler the exception handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def exceptionHandler(exceptionHandler: Handler[Throwable]): Router = {
    asJava.asInstanceOf[JRouter].exceptionHandler({x: Throwable => exceptionHandler.handle(x)})
    this
  }


  /**
   * This method is used to provide a request to the router. Usually you take request from the
   * [[io.vertx.scala.core.http.HttpServer#requestHandler]] and pass it to this method. The
   * router then routes it to matching routes.
   *
   * This method is now deprecated you can use this object directly as a request handler, which
   * means there is no need for a method reference anymore.   * @param request the request
   */
  def accept(request: HttpServerRequest): Unit = {
    asJava.asInstanceOf[JRouter].accept(request.asJava.asInstanceOf[JHttpServerRequest])
  }



  override def handle (arg0: HttpServerRequest): Unit = {
    asJava.asInstanceOf[JRouter].handle(arg0.asJava.asInstanceOf[JHttpServerRequest])
  }

  /**
   * Add a route with no matching criteria, i.e. it matches all requests or failures.   * @return the route
   */
  def route (): Route = {
    Route(asJava.asInstanceOf[JRouter].route())
  }

  /**
   * Add a route that matches the specified HTTP method and path   * @param method the HTTP method to match
   * @param path URI paths that begin with this path will match
   * @return the route
   */
  def route (method: io.vertx.core.http.HttpMethod, path: String): Route = {
    Route(asJava.asInstanceOf[JRouter].route(method, path.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches the specified path   * @param path URI paths that begin with this path will match
   * @return the route
   */
  def route (path: String): Route = {
    Route(asJava.asInstanceOf[JRouter].route(path.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches the specified HTTP method and path regex   * @param method the HTTP method to match
   * @param regex URI paths that begin with a match for this regex will match
   * @return the route
   */
  def routeWithRegex (method: io.vertx.core.http.HttpMethod, regex: String): Route = {
    Route(asJava.asInstanceOf[JRouter].routeWithRegex(method, regex.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches the specified path regex   * @param regex URI paths that begin with a match for this regex will match
   * @return the route
   */
  def routeWithRegex (regex: String): Route = {
    Route(asJava.asInstanceOf[JRouter].routeWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches any HTTP GET request   * @return the route
   */
  def get (): Route = {
    Route(asJava.asInstanceOf[JRouter].get())
  }

  /**
   * Add a route that matches a HTTP GET request and the specified path   * @param path URI paths that begin with this path will match
   * @return the route
   */
  def get (path: String): Route = {
    Route(asJava.asInstanceOf[JRouter].get(path.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches a HTTP GET request and the specified path regex   * @param regex URI paths that begin with a match for this regex will match
   * @return the route
   */
  def getWithRegex (regex: String): Route = {
    Route(asJava.asInstanceOf[JRouter].getWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches any HTTP HEAD request   * @return the route
   */
  def head (): Route = {
    Route(asJava.asInstanceOf[JRouter].head())
  }

  /**
   * Add a route that matches a HTTP HEAD request and the specified path   * @param path URI paths that begin with this path will match
   * @return the route
   */
  def head (path: String): Route = {
    Route(asJava.asInstanceOf[JRouter].head(path.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches a HTTP HEAD request and the specified path regex   * @param regex URI paths that begin with a match for this regex will match
   * @return the route
   */
  def headWithRegex (regex: String): Route = {
    Route(asJava.asInstanceOf[JRouter].headWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches any HTTP OPTIONS request   * @return the route
   */
  def options (): Route = {
    Route(asJava.asInstanceOf[JRouter].options())
  }

  /**
   * Add a route that matches a HTTP OPTIONS request and the specified path   * @param path URI paths that begin with this path will match
   * @return the route
   */
  def options (path: String): Route = {
    Route(asJava.asInstanceOf[JRouter].options(path.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches a HTTP OPTIONS request and the specified path regex   * @param regex URI paths that begin with a match for this regex will match
   * @return the route
   */
  def optionsWithRegex (regex: String): Route = {
    Route(asJava.asInstanceOf[JRouter].optionsWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches any HTTP PUT request   * @return the route
   */
  def put (): Route = {
    Route(asJava.asInstanceOf[JRouter].put())
  }

  /**
   * Add a route that matches a HTTP PUT request and the specified path   * @param path URI paths that begin with this path will match
   * @return the route
   */
  def put (path: String): Route = {
    Route(asJava.asInstanceOf[JRouter].put(path.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches a HTTP PUT request and the specified path regex   * @param regex URI paths that begin with a match for this regex will match
   * @return the route
   */
  def putWithRegex (regex: String): Route = {
    Route(asJava.asInstanceOf[JRouter].putWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches any HTTP POST request   * @return the route
   */
  def post (): Route = {
    Route(asJava.asInstanceOf[JRouter].post())
  }

  /**
   * Add a route that matches a HTTP POST request and the specified path   * @param path URI paths that begin with this path will match
   * @return the route
   */
  def post (path: String): Route = {
    Route(asJava.asInstanceOf[JRouter].post(path.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches a HTTP POST request and the specified path regex   * @param regex URI paths that begin with a match for this regex will match
   * @return the route
   */
  def postWithRegex (regex: String): Route = {
    Route(asJava.asInstanceOf[JRouter].postWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches any HTTP DELETE request   * @return the route
   */
  def delete (): Route = {
    Route(asJava.asInstanceOf[JRouter].delete())
  }

  /**
   * Add a route that matches a HTTP DELETE request and the specified path   * @param path URI paths that begin with this path will match
   * @return the route
   */
  def delete (path: String): Route = {
    Route(asJava.asInstanceOf[JRouter].delete(path.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches a HTTP DELETE request and the specified path regex   * @param regex URI paths that begin with a match for this regex will match
   * @return the route
   */
  def deleteWithRegex (regex: String): Route = {
    Route(asJava.asInstanceOf[JRouter].deleteWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches any HTTP TRACE request   * @return the route
   */
  def trace (): Route = {
    Route(asJava.asInstanceOf[JRouter].trace())
  }

  /**
   * Add a route that matches a HTTP TRACE request and the specified path   * @param path URI paths that begin with this path will match
   * @return the route
   */
  def trace (path: String): Route = {
    Route(asJava.asInstanceOf[JRouter].trace(path.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches a HTTP TRACE request and the specified path regex   * @param regex URI paths that begin with a match for this regex will match
   * @return the route
   */
  def traceWithRegex (regex: String): Route = {
    Route(asJava.asInstanceOf[JRouter].traceWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches any HTTP CONNECT request   * @return the route
   */
  def connect (): Route = {
    Route(asJava.asInstanceOf[JRouter].connect())
  }

  /**
   * Add a route that matches a HTTP CONNECT request and the specified path   * @param path URI paths that begin with this path will match
   * @return the route
   */
  def connect (path: String): Route = {
    Route(asJava.asInstanceOf[JRouter].connect(path.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches a HTTP CONNECT request and the specified path regex   * @param regex URI paths that begin with a match for this regex will match
   * @return the route
   */
  def connectWithRegex (regex: String): Route = {
    Route(asJava.asInstanceOf[JRouter].connectWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches any HTTP PATCH request   * @return the route
   */
  def patch (): Route = {
    Route(asJava.asInstanceOf[JRouter].patch())
  }

  /**
   * Add a route that matches a HTTP PATCH request and the specified path   * @param path URI paths that begin with this path will match
   * @return the route
   */
  def patch (path: String): Route = {
    Route(asJava.asInstanceOf[JRouter].patch(path.asInstanceOf[java.lang.String]))
  }

  /**
   * Add a route that matches a HTTP PATCH request and the specified path regex   * @param regex URI paths that begin with a match for this regex will match
   * @return the route
   */
  def patchWithRegex (regex: String): Route = {
    Route(asJava.asInstanceOf[JRouter].patchWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  /**
   * @return a list of all the routes on this router
   */
  def getRoutes (): scala.collection.mutable.Buffer[Route] = {
    asJava.asInstanceOf[JRouter].getRoutes().asScala.map(x => Route(x))
  }

  /**
   * Specify an handler to handle an error for a particular status code. You can use to manage general errors too using status code 500.
   * The handler will be called when the context fails and other failure handlers didn't write the reply or when an exception is thrown inside an handler.
   * You <b>must not</b> use [[io.vertx.scala.ext.web.RoutingContext#next]] inside the error handler
   * This does not affect the normal failure routing logic.   * @param statusCode status code the errorHandler is capable of handle
   * @param errorHandler error handler. Note: You <b>must not</b> use RoutingContext#next() inside the provided handler
   * @return a reference to this, so the API can be used fluently
   */
  def errorHandler (statusCode: Int, errorHandler: Handler[RoutingContext]): Router = {
    Router(asJava.asInstanceOf[JRouter].errorHandler(statusCode.asInstanceOf[java.lang.Integer], {x: JRoutingContext => errorHandler.handle(RoutingContext(x))}))
  }

  /**
   * Used to route a context to the router. Used for sub-routers. You wouldn't normally call this method directly.   * @param context the routing context
   */
  def handleContext (context: RoutingContext): Unit = {
    asJava.asInstanceOf[JRouter].handleContext(context.asJava.asInstanceOf[JRoutingContext])
  }

  /**
   * Used to route a failure to the router. Used for sub-routers. You wouldn't normally call this method directly.   * @param context the routing context
   */
  def handleFailure (context: RoutingContext): Unit = {
    asJava.asInstanceOf[JRouter].handleFailure(context.asJava.asInstanceOf[JRoutingContext])
  }


}

object Router {
  def apply(asJava: JRouter) = new Router(asJava)
  
  /**
   * Create a router   * @param vertx the Vert.x instance
   * @return the router
   */
  def router(vertx: Vertx): Router = {
    Router(JRouter.router(vertx.asJava.asInstanceOf[JVertx]))
  }

}
