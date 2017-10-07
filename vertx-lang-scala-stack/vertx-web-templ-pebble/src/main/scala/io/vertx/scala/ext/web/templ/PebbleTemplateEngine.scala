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

package io.vertx.scala.ext.web.templ

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.templ.{PebbleTemplateEngine => JPebbleTemplateEngine}
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.core.buffer.Buffer
import io.vertx.ext.web.templ.{TemplateEngine => JTemplateEngine}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * A template engine that uses the Pebble library.
  */
class PebbleTemplateEngine(private val _asJava: Object)
    extends TemplateEngine(_asJava)   {


  /**
    * Set the extension for the engine
    * @param extension the extension
    * @return a reference to this for fluency
    */
  def setExtension(extension: String): PebbleTemplateEngine = {
    asJava.asInstanceOf[JPebbleTemplateEngine].setExtension(extension.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set the max cache size for the engine
    * @param maxCacheSize the maxCacheSize
    * @return a reference to this for fluency
    */
  def setMaxCacheSize(maxCacheSize: Int): PebbleTemplateEngine = {
    asJava.asInstanceOf[JPebbleTemplateEngine].setMaxCacheSize(maxCacheSize.asInstanceOf[java.lang.Integer])
    this
  }

}

object PebbleTemplateEngine {
  def apply(asJava: JPebbleTemplateEngine) = new PebbleTemplateEngine(asJava)  
  /**
    * Create a template engine using defaults
    * @return the engine
    */
  def create(vertx: Vertx): PebbleTemplateEngine = {
    PebbleTemplateEngine(JPebbleTemplateEngine.create(vertx.asJava.asInstanceOf[JVertx]))
  }

}
