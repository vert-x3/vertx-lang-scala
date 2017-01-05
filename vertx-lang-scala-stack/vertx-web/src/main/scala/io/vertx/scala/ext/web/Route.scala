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
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.{Route => JRoute}
import io.vertx.core.Handler

/**
  * A route is a holder for a set of criteria which determine whether an HTTP request or failure should be routed
  * to a handler.
  */
class Route(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
  def method(method: io.vertx.core.http.HttpMethod):Route = {
    asJava.asInstanceOf[JRoute].method(method)
    this
  }

  def path(path: String):Route = {
    asJava.asInstanceOf[JRoute].path(path.asInstanceOf[java.lang.String])
    this
  }

  def pathRegex(path: String):Route = {
    asJava.asInstanceOf[JRoute].pathRegex(path.asInstanceOf[java.lang.String])
    this
  }

  def produces(contentType: String):Route = {
    asJava.asInstanceOf[JRoute].produces(contentType.asInstanceOf[java.lang.String])
    this
  }

  def consumes(contentType: String):Route = {
    asJava.asInstanceOf[JRoute].consumes(contentType.asInstanceOf[java.lang.String])
    this
  }

  def order(order: Int):Route = {
    asJava.asInstanceOf[JRoute].order(order.asInstanceOf[java.lang.Integer])
    this
  }

  def last():Route = {
    asJava.asInstanceOf[JRoute].last()
    this
  }

  def handler(requestHandler: Handler[RoutingContext]):Route = {
    asJava.asInstanceOf[JRoute].handler({x: JRoutingContext => requestHandler.handle(RoutingContext(x))})
    this
  }

  def blockingHandler(requestHandler: Handler[RoutingContext]):Route = {
    asJava.asInstanceOf[JRoute].blockingHandler({x: JRoutingContext => requestHandler.handle(RoutingContext(x))})
    this
  }

  def blockingHandler(requestHandler: Handler[RoutingContext],ordered: Boolean):Route = {
    asJava.asInstanceOf[JRoute].blockingHandler({x: JRoutingContext => requestHandler.handle(RoutingContext(x))},ordered.asInstanceOf[java.lang.Boolean])
    this
  }

  def failureHandler(failureHandler: Handler[RoutingContext]):Route = {
    asJava.asInstanceOf[JRoute].failureHandler({x: JRoutingContext => failureHandler.handle(RoutingContext(x))})
    this
  }

  def remove():Route = {
    asJava.asInstanceOf[JRoute].remove()
    this
  }

  def disable():Route = {
    asJava.asInstanceOf[JRoute].disable()
    this
  }

  def enable():Route = {
    asJava.asInstanceOf[JRoute].enable()
    this
  }

  def useNormalisedPath(useNormalisedPath: Boolean):Route = {
    asJava.asInstanceOf[JRoute].useNormalisedPath(useNormalisedPath.asInstanceOf[java.lang.Boolean])
    this
  }

//default methods
//basic methods
  def getPath():scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JRoute].getPath().asInstanceOf[String])
  }

//future methods
}

  object Route{
    def apply(asJava: JRoute) = new Route(asJava)  
  //static methods
  }
