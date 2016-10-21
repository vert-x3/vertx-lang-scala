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
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.Handler

/**
  * The test suite reports is basically a stream of events reporting the test suite execution.
  */
class TestSuiteReport(private val _asJava: io.vertx.ext.unit.report.TestSuiteReport) 
    extends io.vertx.scala.core.streams.ReadStream[io.vertx.scala.ext.unit.report.TestCaseReport] {

  def asJava: io.vertx.ext.unit.report.TestSuiteReport = _asJava

  /**
    * @return the test suite name
    */
  def name(): String = {
    if(cached_0 == null) {
      cached_0=    _asJava.name()
    }
    cached_0
  }

  /**
    * Set an exception handler, the exception handler reports the test suite errors, it can be called mulitple
    * times before the test ends.
    * @param handler the exception handler
    * @return a reference to this, so the API can be used fluently
    */
  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.ext.unit.report.TestSuiteReport = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: io.vertx.scala.ext.unit.report.TestCaseReport => Unit): io.vertx.scala.ext.unit.report.TestSuiteReport = {
    _asJava.handler(funcToMappedHandler(TestCaseReport.apply)(handler))
    this
  }

  def pause(): io.vertx.scala.ext.unit.report.TestSuiteReport = {
    _asJava.pause()
    this
  }

  def resume(): io.vertx.scala.ext.unit.report.TestSuiteReport = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: () => Unit): io.vertx.scala.ext.unit.report.TestSuiteReport = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => endHandler()))
    this
  }

  private var cached_0: String = _
}

object TestSuiteReport {

  def apply(_asJava: io.vertx.ext.unit.report.TestSuiteReport): io.vertx.scala.ext.unit.report.TestSuiteReport =
    new io.vertx.scala.ext.unit.report.TestSuiteReport(_asJava)

}
