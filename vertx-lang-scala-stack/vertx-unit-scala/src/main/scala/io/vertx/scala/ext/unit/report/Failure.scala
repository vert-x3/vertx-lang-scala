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
  * A failure provides the details of a failure that happened during the execution of a test case.<p/>
  *
  * The failure can be:
  * <ul>
  *   <li>an assertion failure: an assertion failed</li>
  *   <li>an error failure: an expected error occured</li>
  * </ul>
  */
class Failure(private val _asJava: io.vertx.ext.unit.report.Failure) {

  def asJava: io.vertx.ext.unit.report.Failure = _asJava

  /**
    * @return true if the failure is an error failure otherwise it is an assertion failure
    */
  def isError(): Boolean = {
    if(cached_0 == null) {
      cached_0=    _asJava.isError()
    }
    cached_0
  }

  /**
    * @return the error message
    */
  def message(): String = {
    if(cached_1 == null) {
      cached_1=    _asJava.message()
    }
    cached_1
  }

  /**
    * @return the stack trace
    */
  def stackTrace(): String = {
    if(cached_2 == null) {
      cached_2=    _asJava.stackTrace()
    }
    cached_2
  }

  private var cached_0: Boolean = _
  private var cached_1: String = _
  private var cached_2: String = _
}

object Failure {

  def apply(_asJava: io.vertx.ext.unit.report.Failure): io.vertx.scala.ext.unit.report.Failure =
    new io.vertx.scala.ext.unit.report.Failure(_asJava)

}
