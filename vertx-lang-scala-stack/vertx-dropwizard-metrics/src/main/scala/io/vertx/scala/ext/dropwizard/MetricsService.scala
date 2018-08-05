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

package io.vertx.scala.ext.dropwizard

import io.vertx.core.metrics.{Measured => JMeasured}
import scala.reflect.runtime.universe._
import io.vertx.ext.dropwizard.{MetricsService => JMetricsService}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * The metrics service mainly allows to return a snapshot of measured objects.
  */

class MetricsService(private val _asJava: Object) {
  def asJava = _asJava





  /**
   * @param measured the measure object
   * @return the base name of the measured object
   */
  def getBaseName (measured: Measured): String = {
    asJava.asInstanceOf[JMetricsService].getBaseName(measured.asJava.asInstanceOf[JMeasured]).asInstanceOf[String]
  }

  /**
   * @return the known metrics names by this service
   */
  def metricsNames (): scala.collection.mutable.Set[String] = {
    asJava.asInstanceOf[JMetricsService].metricsNames().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * Will return the metrics that correspond with the `measured` object, null if no metrics is available.<p/>
   *
   * Note: in the case of scaled servers, the JsonObject returns an aggregation of the metrics as the
   * dropwizard backend reports to a single server.   * @return the map of metrics where the key is the name of the metric (excluding the base name unless for the Vert.x object) and the value is the json data representing that metric
   */
  def getMetricsSnapshot (measured: Measured): io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JMetricsService].getMetricsSnapshot(measured.asJava.asInstanceOf[JMeasured])
  }

  /**
   * Will return the metrics that begins with the `baseName`, null if no metrics is available.<p/>
   *
   * Note: in the case of scaled servers, the JsonObject returns an aggregation of the metrics as the
   * dropwizard backend reports to a single server.   * @return the map of metrics where the key is the name of the metric and the value is the json data representing that metric
   */
  def getMetricsSnapshot (baseName: String): io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JMetricsService].getMetricsSnapshot(baseName.asInstanceOf[java.lang.String])
  }


}

object MetricsService {
  def apply(asJava: JMetricsService) = new MetricsService(asJava)
  
  /**
   * Creates a metric service for a given [[io.vertx.scala.core.Vertx]] instance.   * @param vertx the vertx instance
   * @return the metrics service
   */
  def create(vertx: Vertx): MetricsService = {
    MetricsService(JMetricsService.create(vertx.asJava.asInstanceOf[JVertx]))
  }

}
