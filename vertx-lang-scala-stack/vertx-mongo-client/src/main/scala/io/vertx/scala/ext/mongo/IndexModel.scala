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

package io.vertx.scala.ext.mongo

import io.vertx.ext.mongo.{IndexModel => JIndexModel}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._


class IndexModel(private val _asJava: JIndexModel) {
  def asJava = _asJava
  /**
   * Get the index key
   */
  /**
   * Get the index options
   */
}


object IndexModel {
  
  def apply() = {
    new IndexModel(new JIndexModel(emptyObj()))
  }
  
  def apply(t: JIndexModel) = {
    if (t != null) {
      new IndexModel(t)
    } else {
      new IndexModel(new JIndexModel(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): IndexModel = {
    if (json != null) {
      new IndexModel(new JIndexModel(json))
    } else {
      new IndexModel(new JIndexModel(emptyObj()))
    }
  }
}

