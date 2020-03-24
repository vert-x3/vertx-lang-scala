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


package io.vertx.scala

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core
import io.vertx.core.streams
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.config.{ConfigChange => JConfigChange}
import io.vertx.core.{Future => JFuture}
import io.vertx.core.json.JsonObject
import io.vertx.config.{ConfigRetrieverOptions => JConfigRetrieverOptions}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.config.{ConfigRetriever => JConfigRetriever}
import io.vertx.core.{Vertx => JVertx}
package object config{


  type ConfigChange = io.vertx.config.ConfigChange
  object ConfigChange {
    def apply() = new ConfigChange()
    def apply(json: JsonObject) = new ConfigChange(json)
  }




  /**
    * Defines a configuration retriever that read configuration from
    * 
    * and tracks changes periodically.
    */

  implicit class ConfigRetrieverScala(val asJava: io.vertx.config.ConfigRetriever) extends AnyVal {


    /**
     * Like getConfig from [[io.vertx.config.ConfigRetriever]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getConfigFuture() : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]()
      asJava.getConfig(new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  }



  type ConfigRetrieverOptions = io.vertx.config.ConfigRetrieverOptions
  object ConfigRetrieverOptions {
    def apply() = new ConfigRetrieverOptions()
    def apply(json: JsonObject) = new ConfigRetrieverOptions(json)
  }



  type ConfigStoreOptions = io.vertx.config.ConfigStoreOptions
  object ConfigStoreOptions {
    def apply() = new ConfigStoreOptions()
    def apply(json: JsonObject) = new ConfigStoreOptions(json)
  }



}
