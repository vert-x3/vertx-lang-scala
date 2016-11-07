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
import io.vertx.ext.mongo.{IndexOptions => JIndexOptions}
import io.vertx.core.json.JsonObject

/**
  * Options used to configure index.
  */

class IndexOptions(val asJava: JIndexOptions) {

  /**
    * Create the index in the background
    */

  /**
    * Gets the number of precision of the stored geohash value of the location data in 2d indexes.
    */

  /**
    * Gets the specified the number of units within which to group the location values for geoHaystack Indexes
    */

  /**
    * Gets the language for a text index.
    *
    * The language that determines the list of stop words and the rules for the stemmer and tokenizer.</p>
    */

  /**
    * Gets the name of the field that contains the language string.
    *
    * For text indexes, the name of the field, in the collection's documents, that contains the override language for the document.</p>
    */

  /**
    * Gets the upper inclusive boundary for the longitude and latitude values for 2d indexes..
    */

  /**
    * Gets the lower inclusive boundary for the longitude and latitude values for 2d indexes..
    */

  /**
    * Gets the name of the index.
    */

  /**
    * Get the filter expression for the documents to be included in the index or null if not set
    */

  /**
    * If true, the index only references documents with the specified field
    */

  /**
    * Gets the 2dsphere index version number.
    */

  /**
    * Gets the storage engine options document for this index.
    */

  /**
    * The text index version number.
    */

  /**
    * Gets if the index should be unique.
    */

  /**
    * Gets the index version number.
    */

  /**
    * Gets the weighting object for use with a text index
    *
    * A document that represents field and weight pairs. The weight is an integer ranging from 1 to 99,999 and denotes the significance
    * of the field relative to the other indexed fields in terms of the score.</p>
    */
}

object IndexOptions {
  
  def apply() = {
    new IndexOptions(new JIndexOptions(emptyObj()))
  }
  
  def apply(t: JIndexOptions) = {
    if(t != null)
      new IndexOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):IndexOptions = {
    if(json != null)
      new IndexOptions(new JIndexOptions(json))
    else
      null
  }
}
