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

package io.vertx.scala.ext.hawkular

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.ext.hawkular.{MetricTagsMatch => JMetricTagsMatch}
import io.vertx.ext.hawkular.MetricTagsMatch.MatchType
import io.vertx.core.json.JsonObject

/**
  * Tags to apply to any metric which name matches the criteria.
  */
class MetricTagsMatch(private val _asJava: JMetricTagsMatch) {

  def asJava = _asJava

  /**
    * Set the tags to apply if metric name matches the criteria.
    */
  def setTags(value: io.vertx.core.json.JsonObject) = {
    asJava.setTags(value)
    this
  }
  def getTags: io.vertx.core.json.JsonObject = {
    asJava.getTags()
  }

  /**
    * Set the type of matching to apply.
    */
  def setType(value: io.vertx.ext.hawkular.MetricTagsMatch.MatchType) = {
    asJava.setType(value)
    this
  }
  def getType: io.vertx.ext.hawkular.MetricTagsMatch.MatchType = {
    asJava.getType()
  }

  /**
    * Set the matched value.
    */
  def setValue(value: String) = {
    asJava.setValue(value)
    this
  }
  def getValue: String = {
    asJava.getValue().asInstanceOf[String]
  }
}

object MetricTagsMatch {
  
  def apply() = {
    new MetricTagsMatch(new JMetricTagsMatch(emptyObj()))
  }
  
  def apply(t: JMetricTagsMatch) = {
    if (t != null) {
      new MetricTagsMatch(t)
    } else {
      new MetricTagsMatch(new JMetricTagsMatch(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): MetricTagsMatch = {
    if (json != null) {
      new MetricTagsMatch(new JMetricTagsMatch(json))
    } else {
      new MetricTagsMatch(new JMetricTagsMatch(emptyObj()))
    }
  }
}
