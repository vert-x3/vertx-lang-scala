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

package io.vertx.scala.ext.unit

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.Handler

/**
  * A test case object can be used to create a single test.
  */
class TestCase(private val _asJava: io.vertx.ext.unit.TestCase) {

  def asJava: io.vertx.ext.unit.TestCase = _asJava

}

object TestCase {

  def apply(_asJava: io.vertx.ext.unit.TestCase): io.vertx.scala.ext.unit.TestCase =
    new io.vertx.scala.ext.unit.TestCase(_asJava)

  def create(name: String, testCase: io.vertx.scala.ext.unit.TestContext => Unit): io.vertx.scala.ext.unit.TestCase = {
    TestCase.apply(io.vertx.ext.unit.TestCase.create(name, funcToMappedHandler(TestContext.apply)(testCase)))
  }

}
