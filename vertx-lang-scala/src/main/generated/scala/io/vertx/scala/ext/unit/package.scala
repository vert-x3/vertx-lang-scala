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


package io.vertx.scala.ext

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.unit.report.{ReportOptions => JReportOptions}
package object unit{


  type ReportOptions = io.vertx.ext.unit.report.ReportOptions
  object ReportOptions {
    def apply() = new ReportOptions()
    def apply(json: JsonObject) = new ReportOptions(json)
    def apply( format: java.lang.String = null, to: java.lang.String = null): ReportOptions = {
      val ret = new ReportOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (format != null) ret.setFormat(format) 
      if (to != null) ret.setTo(to) 
      ret
    }
  }



  type ReportingOptions = io.vertx.ext.unit.report.ReportingOptions
  object ReportingOptions {
    def apply() = new ReportingOptions()
    def apply(json: JsonObject) = new ReportingOptions(json)
    def apply( reporters: scala.collection.immutable.List[io.vertx.ext.unit.report.ReportOptions] = null): ReportingOptions = {
      val ret = new ReportingOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (reporters != null) ret.setReporters(reporters.asJava) 
      ret
    }
  }



  type TestOptions = io.vertx.ext.unit.TestOptions
  object TestOptions {
    def apply() = new TestOptions()
    def apply(json: JsonObject) = new TestOptions(json)
    def apply( reporters: scala.collection.immutable.List[io.vertx.ext.unit.report.ReportOptions] = null, timeout: java.lang.Long = null, useEventLoop: java.lang.Boolean = null): TestOptions = {
      val ret = new TestOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (reporters != null) ret.setReporters(reporters.asJava) 
      if (timeout != null) ret.setTimeout(timeout) 
      if (useEventLoop != null) ret.setUseEventLoop(useEventLoop) 
      ret
    }
  }



}
