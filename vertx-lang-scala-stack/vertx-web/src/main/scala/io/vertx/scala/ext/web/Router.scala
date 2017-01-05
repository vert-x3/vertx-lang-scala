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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.core.http.HttpMethod
import io.vertx.scala.core.http.HttpServerRequest
import io.vertx.ext.web.{Route => JRoute}
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.ext.web.{Router => JRouter}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * A router receives request from an [[io.vertx.scala.core.http.HttpServer]] and routes it to the first matching
  * [[io.vertx.scala.ext.web.Route]] that it contains. A router can contain many routes.
  * 
  * Routers are also used for routing failures.
  */
class Router(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
  def clear():Router = {
    asJava.asInstanceOf[JRouter].clear()
    this
  }

  def mountSubRouter(mountPoint: String,subRouter: Router):Router = {
    asJava.asInstanceOf[JRouter].mountSubRouter(mountPoint.asInstanceOf[java.lang.String],subRouter.asJava.asInstanceOf[JRouter])
    this
  }

  def exceptionHandler(exceptionHandler: Handler[Throwable]):Router = {
    asJava.asInstanceOf[JRouter].exceptionHandler({x: Throwable => exceptionHandler.handle(x)})
    this
  }

//default methods
//basic methods
  def accept(request: HttpServerRequest):Unit = {
    asJava.asInstanceOf[JRouter].accept(request.asJava.asInstanceOf[JHttpServerRequest])
  }

  def route():Route = {
    Route(asJava.asInstanceOf[JRouter].route())
  }

  def route(method: io.vertx.core.http.HttpMethod,path: String):Route = {
    Route(asJava.asInstanceOf[JRouter].route(method,path.asInstanceOf[java.lang.String]))
  }

  def route(path: String):Route = {
    Route(asJava.asInstanceOf[JRouter].route(path.asInstanceOf[java.lang.String]))
  }

  def routeWithRegex(method: io.vertx.core.http.HttpMethod,regex: String):Route = {
    Route(asJava.asInstanceOf[JRouter].routeWithRegex(method,regex.asInstanceOf[java.lang.String]))
  }

  def routeWithRegex(regex: String):Route = {
    Route(asJava.asInstanceOf[JRouter].routeWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  def get():Route = {
    Route(asJava.asInstanceOf[JRouter].get())
  }

  def get(path: String):Route = {
    Route(asJava.asInstanceOf[JRouter].get(path.asInstanceOf[java.lang.String]))
  }

  def getWithRegex(regex: String):Route = {
    Route(asJava.asInstanceOf[JRouter].getWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  def head():Route = {
    Route(asJava.asInstanceOf[JRouter].head())
  }

  def head(path: String):Route = {
    Route(asJava.asInstanceOf[JRouter].head(path.asInstanceOf[java.lang.String]))
  }

  def headWithRegex(regex: String):Route = {
    Route(asJava.asInstanceOf[JRouter].headWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  def options():Route = {
    Route(asJava.asInstanceOf[JRouter].options())
  }

  def options(path: String):Route = {
    Route(asJava.asInstanceOf[JRouter].options(path.asInstanceOf[java.lang.String]))
  }

  def optionsWithRegex(regex: String):Route = {
    Route(asJava.asInstanceOf[JRouter].optionsWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  def put():Route = {
    Route(asJava.asInstanceOf[JRouter].put())
  }

  def put(path: String):Route = {
    Route(asJava.asInstanceOf[JRouter].put(path.asInstanceOf[java.lang.String]))
  }

  def putWithRegex(regex: String):Route = {
    Route(asJava.asInstanceOf[JRouter].putWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  def post():Route = {
    Route(asJava.asInstanceOf[JRouter].post())
  }

  def post(path: String):Route = {
    Route(asJava.asInstanceOf[JRouter].post(path.asInstanceOf[java.lang.String]))
  }

  def postWithRegex(regex: String):Route = {
    Route(asJava.asInstanceOf[JRouter].postWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  def delete():Route = {
    Route(asJava.asInstanceOf[JRouter].delete())
  }

  def delete(path: String):Route = {
    Route(asJava.asInstanceOf[JRouter].delete(path.asInstanceOf[java.lang.String]))
  }

  def deleteWithRegex(regex: String):Route = {
    Route(asJava.asInstanceOf[JRouter].deleteWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  def trace():Route = {
    Route(asJava.asInstanceOf[JRouter].trace())
  }

  def trace(path: String):Route = {
    Route(asJava.asInstanceOf[JRouter].trace(path.asInstanceOf[java.lang.String]))
  }

  def traceWithRegex(regex: String):Route = {
    Route(asJava.asInstanceOf[JRouter].traceWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  def connect():Route = {
    Route(asJava.asInstanceOf[JRouter].connect())
  }

  def connect(path: String):Route = {
    Route(asJava.asInstanceOf[JRouter].connect(path.asInstanceOf[java.lang.String]))
  }

  def connectWithRegex(regex: String):Route = {
    Route(asJava.asInstanceOf[JRouter].connectWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  def patch():Route = {
    Route(asJava.asInstanceOf[JRouter].patch())
  }

  def patch(path: String):Route = {
    Route(asJava.asInstanceOf[JRouter].patch(path.asInstanceOf[java.lang.String]))
  }

  def patchWithRegex(regex: String):Route = {
    Route(asJava.asInstanceOf[JRouter].patchWithRegex(regex.asInstanceOf[java.lang.String]))
  }

  def getRoutes():scala.collection.mutable.Buffer[Route] = {
    asJava.asInstanceOf[JRouter].getRoutes().asScala.map(x => Route(x))
  }

  def handleContext(context: RoutingContext):Unit = {
    asJava.asInstanceOf[JRouter].handleContext(context.asJava.asInstanceOf[JRoutingContext])
  }

  def handleFailure(context: RoutingContext):Unit = {
    asJava.asInstanceOf[JRouter].handleFailure(context.asJava.asInstanceOf[JRoutingContext])
  }

//future methods
}

  object Router{
    def apply(asJava: JRouter) = new Router(asJava)  
  //static methods
    def router(vertx: Vertx):Router = {
      Router(JRouter.router(vertx.asJava.asInstanceOf[JVertx]))
    }

  }
