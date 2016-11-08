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

package io.vertx.scala.core.metrics

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.metrics.{Measured => JMeasured}

/**
  */
trait Measured {

  def asJava: java.lang.Object

  /**
  * Whether the metrics are enabled for this measured object
  * @return true if the metrics are enabled
  */
def isMetricsEnabled(): Boolean

}

object Measured {

  def apply(_asJava: JMeasured): Measured =
    new MeasuredImpl(_asJava)

  private class MeasuredImpl(private val _asJava: JMeasured) extends Measured {

    def asJava: JMeasured = _asJava

    /**
      * Whether the metrics are enabled for this measured object
      * @return true if the metrics are enabled
      */
    def isMetricsEnabled(): Boolean = {
        _asJava.isMetricsEnabled()
    }

  }

}
