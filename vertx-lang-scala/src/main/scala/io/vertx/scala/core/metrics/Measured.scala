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

import io.vertx.core.metrics.{Measured => JMeasured}

/**
  */
trait Measured {

  def isMetricsEnabled():Boolean

}
object Measured{
  def apply(asJava: JMeasured) = new MeasuredImpl(asJava)  
    private class MeasuredImpl(private val _asJava: JMeasured) extends Measured {

      def asJava = _asJava

//cached methods
//fluent methods
//basic methods
  def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JMeasured].isMetricsEnabled()
  }

}

object Measured{
  def apply(asJava: JMeasured) = new Measured(asJava)
//static methods
    }

}
}
