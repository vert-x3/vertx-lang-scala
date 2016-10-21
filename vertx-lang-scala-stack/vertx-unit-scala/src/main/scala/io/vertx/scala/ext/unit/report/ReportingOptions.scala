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

package io.vertx.scala.ext.unit.report

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Reporting options:
  *
  * <ul>
  *   <li>the `reporters` is an array of reporter configurations</li>
  * </ul>
  */

class ReportingOptions(val asJava: io.vertx.ext.unit.report.ReportingOptions) {

  /**
    * Replace the current list of reporters with a new one.
    */
  def addReporter(value:io.vertx.scala.ext.unit.report.ReportOptions) = {
    asJava.addReporter(value.asJava)
    this
  }
  def setReporters(value:scala.collection.mutable.Buffer[io.vertx.scala.ext.unit.report.ReportOptions]) = {
    asJava.setReporters(value.map(_.asJava))
    this
  }
  def getReporters = {
    asJava.getReporters()
  }
}

object ReportingOptions {
  type ReportingOptionsJava = io.vertx.ext.unit.report.ReportingOptions
  
  def apply(t: ReportingOptionsJava) = {
    if(t != null)
      new ReportingOptions(t)
    else
      null
   
  }
  
  def fromJson(json: JsonObject):ReportingOptions = {
    if(json != null)
      new ReportingOptions(new ReportingOptionsJava(json))
    else
      null
  }
}
