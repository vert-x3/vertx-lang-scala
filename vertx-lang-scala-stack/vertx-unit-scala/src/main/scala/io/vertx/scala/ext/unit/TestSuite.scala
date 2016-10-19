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
import io.vertx.ext.unit.TestOptions
import io.vertx.scala.core.Vertx
import io.vertx.core.Handler

/**
  * A named suite of test cases that are executed altogether. The suite suite is created with
  * the [[io.vertx.scala.ext.unit.TestSuite#create]] and the returned suite contains initially no tests.<p/>
  *
  * The suite can declare a callback before the suite with [[io.vertx.scala.ext.unit.TestSuite#before]] or after
  * the suite with [[io.vertx.scala.ext.unit.TestSuite#after]].<p/>
  *
  * The suite can declare a callback before each test with [[io.vertx.scala.ext.unit.TestSuite#beforeEach]] or after
  * each test with [[io.vertx.scala.ext.unit.TestSuite#afterEach]].<p/>
  *
  * Each test case of the suite is declared by calling the [[io.vertx.scala.ext.unit.TestSuite#test]] method.
  */
class TestSuite(private val _asJava: io.vertx.ext.unit.TestSuite) {

  def asJava: io.vertx.ext.unit.TestSuite = _asJava

  /**
    * Set a callback executed before the tests.
    * @param callback the callback
    * @return a reference to this, so the API can be used fluently
    */
  def before(callback: io.vertx.scala.ext.unit.TestContext => Unit): io.vertx.scala.ext.unit.TestSuite = {
    _asJava.before(funcToMappedHandler(TestContext.apply)(callback))
    this
  }

  /**
    * Set a callback executed before each test and after the suite `before` callback.
    * @param callback the callback
    * @return a reference to this, so the API can be used fluently
    */
  def beforeEach(callback: io.vertx.scala.ext.unit.TestContext => Unit): io.vertx.scala.ext.unit.TestSuite = {
    _asJava.beforeEach(funcToMappedHandler(TestContext.apply)(callback))
    this
  }

  /**
    * Set a callback executed after the tests.
    * @param callback the callback
    * @return a reference to this, so the API can be used fluently
    */
  def after(callback: io.vertx.scala.ext.unit.TestContext => Unit): io.vertx.scala.ext.unit.TestSuite = {
    _asJava.after(funcToMappedHandler(TestContext.apply)(callback))
    this
  }

  /**
    * Set a callback executed after each test and before the suite `after` callback.
    * @param callback the callback
    * @return a reference to this, so the API can be used fluently
    */
  def afterEach(callback: io.vertx.scala.ext.unit.TestContext => Unit): io.vertx.scala.ext.unit.TestSuite = {
    _asJava.afterEach(funcToMappedHandler(TestContext.apply)(callback))
    this
  }

  /**
    * Add a new test case to the suite.
    * @param name the test case name
    * @param testCase the test case
    * @return a reference to this, so the API can be used fluently
    */
  def test(name: String, testCase: io.vertx.scala.ext.unit.TestContext => Unit): io.vertx.scala.ext.unit.TestSuite = {
    _asJava.test(name, funcToMappedHandler(TestContext.apply)(testCase))
    this
  }

  /**
    * Add a new test case to the suite.
    * @param name the test case name
    * @param repeat the number of times the test should be repeated
    * @param testCase the test case
    * @return a reference to this, so the API can be used fluently
    */
  def test(name: String, repeat: Int, testCase: io.vertx.scala.ext.unit.TestContext => Unit): io.vertx.scala.ext.unit.TestSuite = {
    _asJava.test(name, repeat, funcToMappedHandler(TestContext.apply)(testCase))
    this
  }

  /**
    * Run the testsuite with the default options.<p/>
    *
    * When the test suite is executed in a Vertx context (i.e `Vertx.currentContext()` returns a context) this
    * context's event loop is used for running the test suite. Otherwise it is executed in the current thread.<p/>
    *
    * The returned [[io.vertx.scala.ext.unit.Completion]] object can be used to get a completion callback.
    * @return the related test completion
    */
  def run(): io.vertx.scala.ext.unit.TestCompletion = {
    TestCompletion.apply(_asJava.run())
  }

  /**
    * Run the testsuite with the specified `options`.<p/>
    *
    * When the test suite is executed in a Vertx context (i.e `Vertx.currentContext()` returns a context) this
    * context's event loop is used for running the test suite unless the <a href="../../../../../../../cheatsheet/TestOptions.html">TestOptions</a>
    * is set to `false`. In this case it is executed by the current thread.<p/>
    *
    * Otherwise, the test suite will be executed in the current thread when <a href="../../../../../../../cheatsheet/TestOptions.html">TestOptions</a> is
    * set to `false` or `null`. If the value is `true`, this methods throws an `IllegalStateException`.<p/>
    *
    * The returned [[io.vertx.scala.ext.unit.Completion]] object can be used to get a completion callback.
    * @param options the test optionssee <a href="../../../../../../../cheatsheet/TestOptions.html">TestOptions</a>
    * @return the related test completion
    */
  def run(options: io.vertx.scala.ext.unit.TestOptions): io.vertx.scala.ext.unit.TestCompletion = {
    TestCompletion.apply(_asJava.run(options.asJava))
  }

  /**
    * Run the testsuite with the default options and the specified `vertx` instance.<p/>
    *
    * The test suite will be executed on the event loop provided by the `vertx` argument. The returned
    * [[io.vertx.scala.ext.unit.Completion]] object can be used to get a completion callback.<p/>
    * @param vertx the vertx instance
    * @return the related test completion
    */
  def run(vertx: io.vertx.scala.core.Vertx): io.vertx.scala.ext.unit.TestCompletion = {
    TestCompletion.apply(_asJava.run(vertx.asJava.asInstanceOf[io.vertx.core.Vertx]))
  }

  /**
    * Run the testsuite with the specified `options` and the specified `vertx` instance.<p/>
    *
    * The test suite will be executed on the event loop provided by the `vertx` argument when
    * <a href="../../../../../../../cheatsheet/TestOptions.html">TestOptions</a> is not set to `false`. The returned
    * [[io.vertx.scala.ext.unit.Completion]] object can be used to get a completion callback.
    * @param vertx the vertx instance
    * @param options the test optionssee <a href="../../../../../../../cheatsheet/TestOptions.html">TestOptions</a>
    * @return the related test completion
    */
  def run(vertx: io.vertx.scala.core.Vertx, options: io.vertx.scala.ext.unit.TestOptions): io.vertx.scala.ext.unit.TestCompletion = {
    TestCompletion.apply(_asJava.run(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], options.asJava))
  }

}

object TestSuite {

  def apply(_asJava: io.vertx.ext.unit.TestSuite): io.vertx.scala.ext.unit.TestSuite =
    new io.vertx.scala.ext.unit.TestSuite(_asJava)

  def create(name: String): io.vertx.scala.ext.unit.TestSuite = {
    TestSuite.apply(io.vertx.ext.unit.TestSuite.create(name))
  }

}
