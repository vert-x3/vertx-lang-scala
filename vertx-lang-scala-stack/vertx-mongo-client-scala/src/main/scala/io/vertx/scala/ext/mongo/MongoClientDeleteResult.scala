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

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.mongo.{MongoClientDeleteResult => JMongoClientDeleteResult}

/**
  * Result propagated from mongodb driver delete result.
  */

class MongoClientDeleteResult(val asJava: JMongoClientDeleteResult) {

  /**
    * Get the number of removed documents
    */
}

object MongoClientDeleteResult {
  
  def apply() = {
    new MongoClientDeleteResult(new JMongoClientDeleteResult(emptyObj()))
  }
  
  def apply(t: JMongoClientDeleteResult) = {
    if(t != null)
      new MongoClientDeleteResult(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):MongoClientDeleteResult = {
    if(json != null)
      new MongoClientDeleteResult(new JMongoClientDeleteResult(json))
    else
      null
  }
}
