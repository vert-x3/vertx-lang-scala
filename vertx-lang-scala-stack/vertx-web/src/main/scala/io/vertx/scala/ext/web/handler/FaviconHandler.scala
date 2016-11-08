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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.web.handler.{FaviconHandler => JFaviconHandler}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.scala.ext.web.RoutingContext

/**
  * A handler that serves favicons.
  * 
  * If no file system path is specified it will attempt to serve a resource called `favicon.ico` from the classpath.
  */
class FaviconHandler(private val _asJava: JFaviconHandler) {

  def asJava: JFaviconHandler = _asJava

  def handle(arg0: RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object FaviconHandler {

  def apply(_asJava: JFaviconHandler): FaviconHandler =
    new FaviconHandler(_asJava)

  def create(): FaviconHandler = {
    FaviconHandler.apply(io.vertx.ext.web.handler.FaviconHandler.create())
  }

  def create(path: String): FaviconHandler = {
    FaviconHandler.apply(io.vertx.ext.web.handler.FaviconHandler.create(path))
  }

  def create(path: String, maxAgeSeconds: Long): FaviconHandler = {
    FaviconHandler.apply(io.vertx.ext.web.handler.FaviconHandler.create(path, maxAgeSeconds))
  }

  def create(maxAgeSeconds: Long): FaviconHandler = {
    FaviconHandler.apply(io.vertx.ext.web.handler.FaviconHandler.create(maxAgeSeconds))
  }

}
