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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.config.{ConfigRetrieverOptions => JConfigRetrieverOptions}

/**
  */
class ConfigRetrieverOptions(private val _asJava: JConfigRetrieverOptions) {

  def asJava = _asJava
  def setScanPeriod(value: Long) = {
    asJava.setScanPeriod(value)
    this
  }
  def getScanPeriod: Long = {
    asJava.getScanPeriod().asInstanceOf[Long]
  }
  def addStore(value: ConfigStoreOptions) = {
    asJava.addStore(value.asJava)
    this
  }
  def setStores(value: scala.collection.mutable.Buffer[ConfigStoreOptions]) = {
    asJava.setStores(value.map(_.asJava).asJava)
    this
  }
  def getStores: scala.collection.mutable.Buffer[ConfigStoreOptions] = {
    asJava.getStores().asScala.map(x => ConfigStoreOptions(x))
  }
}

object ConfigRetrieverOptions {
  
  def apply() = {
    new ConfigRetrieverOptions(new JConfigRetrieverOptions(emptyObj()))
  }
  
  def apply(t: JConfigRetrieverOptions) = {
    if (t != null) {
      new ConfigRetrieverOptions(t)
    } else {
      new ConfigRetrieverOptions(new JConfigRetrieverOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): ConfigRetrieverOptions = {
    if (json != null) {
      new ConfigRetrieverOptions(new JConfigRetrieverOptions(json))
    } else {
      new ConfigRetrieverOptions(new JConfigRetrieverOptions(emptyObj()))
    }
  }
}
