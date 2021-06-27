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

import scala.jdk.CollectionConverters._
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
  }



  type ReportingOptions = io.vertx.ext.unit.report.ReportingOptions
  object ReportingOptions {
    def apply() = new ReportingOptions()
    def apply(json: JsonObject) = new ReportingOptions(json)
  }



  type TestOptions = io.vertx.ext.unit.TestOptions
  object TestOptions {
    def apply() = new TestOptions()
    def apply(json: JsonObject) = new TestOptions(json)
  }



}
