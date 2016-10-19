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
  * Configures a reporter consisting in a name `to`, an address `at` and an optional `format`.
  */

class ReportOptions(val asJava: io.vertx.ext.unit.report.ReportOptions) {

  /**
    * Set the current reporter format.
    */
  def setFormat(value:String) = {
    asJava.setFormat(value)
    this
  }
  def getFormat = {
    asJava.getFormat()
  }

  /**
    * Set the current reporter name.
    */
  def setTo(value:String) = {
    asJava.setTo(value)
    this
  }
  def getTo = {
    asJava.getTo()
  }
}

object ReportOptions {
  type ReportOptionsJava = io.vertx.ext.unit.report.ReportOptions
  
  def apply(t: ReportOptionsJava) = {
    if(t != null)
      new ReportOptions(t)
    else
      null
   
  }
  
  def fromJson(json: JsonObject):ReportOptions = {
    if(json != null)
      new ReportOptions(new ReportOptionsJava(json))
    else
      null
  }
}
