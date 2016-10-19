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

/**
  * The result of a test.
  */
class TestResult(private val _asJava: io.vertx.ext.unit.report.TestResult) {

  def asJava: io.vertx.ext.unit.report.TestResult = _asJava

  /**
    * The test description, may be null if none was provided.
    */
  def name(): String = {
    if(cached_0 == null) {
      cached_0=    _asJava.name()
    }
    cached_0
  }

  /**
    * The time at which the test began in millis.
    */
  def beginTime(): Long = {
    if(cached_1 == null) {
      cached_1=    _asJava.beginTime()
    }
    cached_1
  }

  /**
    * How long the test lasted in millis.
    */
  def durationTime(): Long = {
    if(cached_2 == null) {
      cached_2=    _asJava.durationTime()
    }
    cached_2
  }

  /**
    * Did it succeed?
    */
  def succeeded(): Boolean = {
    if(cached_3 == null) {
      cached_3=    _asJava.succeeded()
    }
    cached_3
  }

  /**
    * Did it fail?
    */
  def failed(): Boolean = {
    if(cached_4 == null) {
      cached_4=    _asJava.failed()
    }
    cached_4
  }

  /**
    * An exception describing failure, null if the test succeeded.
    */
  def failure(): io.vertx.scala.ext.unit.report.Failure = {
    if(cached_5 == null) {
      cached_5=    Failure.apply(_asJava.failure())
    }
    cached_5
  }

  private var cached_0: String = _
  private var cached_1: Long = _
  private var cached_2: Long = _
  private var cached_3: Boolean = _
  private var cached_4: Boolean = _
  private var cached_5: io.vertx.scala.ext.unit.report.Failure = _
}

object TestResult {

  def apply(_asJava: io.vertx.ext.unit.report.TestResult): io.vertx.scala.ext.unit.report.TestResult =
    new io.vertx.scala.ext.unit.report.TestResult(_asJava)

}
