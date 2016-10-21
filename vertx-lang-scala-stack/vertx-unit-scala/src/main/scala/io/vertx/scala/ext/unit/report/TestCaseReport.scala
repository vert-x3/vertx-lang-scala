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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.Handler

/**
  * Report the execution of a test case.
  */
class TestCaseReport(private val _asJava: io.vertx.ext.unit.report.TestCaseReport) {

  def asJava: io.vertx.ext.unit.report.TestCaseReport = _asJava

  /**
    * @return the test case name
    */
  def name(): String = {
    if(cached_0 == null) {
      cached_0=    _asJava.name()
    }
    cached_0
  }

  /**
    * Set a callback for completion, the specified `handler` is invoked when the test exec has completed.
    * @param handler the completion handler
    * @return a reference to this, so the API can be used fluently
    */
  def endHandler(handler: io.vertx.scala.ext.unit.report.TestResult => Unit): io.vertx.scala.ext.unit.report.TestCaseReport = {
    _asJava.endHandler(funcToMappedHandler(TestResult.apply)(handler))
    this
  }

  private var cached_0: String = _
}

object TestCaseReport {

  def apply(_asJava: io.vertx.ext.unit.report.TestCaseReport): io.vertx.scala.ext.unit.report.TestCaseReport =
    new io.vertx.scala.ext.unit.report.TestCaseReport(_asJava)

}
