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

package io.vertx.scala.config

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.config.{ConfigChange => JConfigChange}
import io.vertx.config.{ConfigRetrieverOptions => JConfigRetrieverOptions}
import io.vertx.scala.core.Future
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.{Future => JFuture}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.config.{ConfigRetriever => JConfigRetriever}

/**
  * Defines a configuration retriever that read configuration from
  * 
  * and tracks changes periodically.
  */
class ConfigRetriever(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0: Option[ReadStream[io.vertx.core.json.JsonObject]] = None

  /**
    * @return the stream of configurations. It's single stream (unicast) and that delivers the last known config and the successors periodically.
    */
  def configStream(): ReadStream[io.vertx.core.json.JsonObject] = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JConfigRetriever].configStream()
      cached_0 = Some(ReadStream[io.vertx.core.json.JsonObject](tmp))
    }
    cached_0.get
  }

  /**
    * Reads the configuration from the different 
    * and computes the final configuration.
    * @param completionHandler handler receiving the computed configuration, or a failure if the configuration cannot be retrieved
    */
  def getConfig(completionHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JConfigRetriever].getConfig({x: AsyncResult[JsonObject] => completionHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  /**
    * Closes the retriever.
    */
  def close(): Unit = {
    asJava.asInstanceOf[JConfigRetriever].close()
  }

  /**
    * Gets the last computed configuration.
    * @return the last configuration
    */
  def getCachedConfig(): io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JConfigRetriever].getCachedConfig()
  }

  /**
    * Registers a listener receiving configuration changes. This method cannot only be called if
    * the configuration is broadcasted.
    * @param listener the listener
    */
  def listen(listener: Handler[ConfigChange]): Unit = {
    asJava.asInstanceOf[JConfigRetriever].listen({x: JConfigChange => listener.handle(ConfigChange(x))})
  }

 /**
   * Like [[getConfig]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getConfigFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JConfigRetriever].getConfig(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object ConfigRetriever {
  def apply(asJava: JConfigRetriever) = new ConfigRetriever(asJava)  
  /**
    * Creates an instance of the default implementation of the [[io.vertx.scala.config.ConfigRetriever]].
    * @param vertx the vert.x instance
    * @param options the options, must not be `null`, must contain the list of configured store.see <a href="../../../../../../cheatsheet/ConfigRetrieverOptions.html">ConfigRetrieverOptions</a>
    * @return the created instance.
    */
  def create(vertx: Vertx, options: ConfigRetrieverOptions): ConfigRetriever = {
    ConfigRetriever(JConfigRetriever.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  /**
    * Creates an instance of the default implementation of the [[io.vertx.scala.config.ConfigRetriever]], using the default
    * settings (json file, system properties and environment variables).
    * @param vertx the vert.x instance
    * @return the created instance.
    */
  def create(vertx: Vertx): ConfigRetriever = {
    ConfigRetriever(JConfigRetriever.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Same as [[io.vertx.scala.config.ConfigRetriever#getConfigFuture]], but returning a  object. The result is a
    * .
    * @param retriever the config retrieve
    * @return the future completed when the configuration is retrieved
    */
  def getConfigAsFuture(retriever: ConfigRetriever): Future[io.vertx.core.json.JsonObject] = {
    Future[io.vertx.core.json.JsonObject](JConfigRetriever.getConfigAsFuture(retriever.asJava.asInstanceOf[JConfigRetriever]))
  }

}
