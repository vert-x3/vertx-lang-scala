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
  * The test context is used for performing test assertions and manage the completion of the test. This context
  * is provided by <i>vertx-unit</i> as argument of the test case.
  */
class TestContext(private val _asJava: io.vertx.ext.unit.TestContext) {

  def asJava: io.vertx.ext.unit.TestContext = _asJava

  /**
    * Get some data from the context.
    * @param key the key of the data
    * @return the data
    */
  def get[T](key: String): T = {
    _asJava.get(key)
  }

  /**
    * Put some data in the context.
    * 
    * This can be used to share data between different tests and before/after phases.
    * @param key the key of the data
    * @param value the data
    * @return the previous object when it exists
    */
  def put[T](key: String, value: AnyRef): T = {
    _asJava.put(key, value)
  }

  /**
    * Remove some data from the context.
    * @param key the key to remove
    * @return the removed object when it exists
    */
  def remove[T](key: String): T = {
    _asJava.remove(key)
  }

  /**
    * Assert the `expected` argument is `null`. If the argument is not, an assertion error is thrown
    * otherwise the execution continue.
    * @param expected the argument being asserted to be null
    * @return a reference to this, so the API can be used fluently
    */
  def assertNull(expected: AnyRef): io.vertx.scala.ext.unit.TestContext = {
    _asJava.assertNull(expected)
    this
  }

  /**
    * Assert the `expected` argument is `null`. If the argument is not, an assertion error is thrown
    * otherwise the execution continue.
    * @param expected the argument being asserted to be null
    * @param message the failure message
    * @return a reference to this, so the API can be used fluently
    */
  def assertNull(expected: AnyRef, message: String): io.vertx.scala.ext.unit.TestContext = {
    _asJava.assertNull(expected, message)
    this
  }

  /**
    * Assert the `expected` argument is not `null`. If the argument is `null`, an assertion error is thrown
    * otherwise the execution continue.
    * @param expected the argument being asserted to be not null
    * @return a reference to this, so the API can be used fluently
    */
  def assertNotNull(expected: AnyRef): io.vertx.scala.ext.unit.TestContext = {
    _asJava.assertNotNull(expected)
    this
  }

  /**
    * Assert the `expected` argument is not `null`. If the argument is `null`, an assertion error is thrown
    * otherwise the execution continue.
    * @param expected the argument being asserted to be not null
    * @param message the failure message
    * @return a reference to this, so the API can be used fluently
    */
  def assertNotNull(expected: AnyRef, message: String): io.vertx.scala.ext.unit.TestContext = {
    _asJava.assertNotNull(expected, message)
    this
  }

  /**
    * Assert the specified `condition` is `true`. If the condition is `false`, an assertion error is thrown
    * otherwise the execution continue.
    * @param condition the condition to assert
    * @return a reference to this, so the API can be used fluently
    */
  def assertTrue(condition: Boolean): io.vertx.scala.ext.unit.TestContext = {
    _asJava.assertTrue(condition)
    this
  }

  /**
    * Assert the specified `condition` is `true`. If the condition is `false`, an assertion error is thrown
    * otherwise the execution continue.
    * @param condition the condition to assert
    * @param message the failure message
    * @return a reference to this, so the API can be used fluently
    */
  def assertTrue(condition: Boolean, message: String): io.vertx.scala.ext.unit.TestContext = {
    _asJava.assertTrue(condition, message)
    this
  }

  /**
    * Assert the specified `condition` is `false`. If the condition is `true`, an assertion error is thrown
    * otherwise the execution continue.
    * @param condition the condition to assert
    * @return a reference to this, so the API can be used fluently
    */
  def assertFalse(condition: Boolean): io.vertx.scala.ext.unit.TestContext = {
    _asJava.assertFalse(condition)
    this
  }

  /**
    * Assert the specified `condition` is `false`. If the condition is `true`, an assertion error is thrown
    * otherwise the execution continue.
    * @param condition the condition to assert
    * @param message the failure message
    * @return a reference to this, so the API can be used fluently
    */
  def assertFalse(condition: Boolean, message: String): io.vertx.scala.ext.unit.TestContext = {
    _asJava.assertFalse(condition, message)
    this
  }

  /**
    * Assert the `expected` argument is equals to the `actual` argument. If the arguments are not equals
    * an assertion error is thrown otherwise the execution continue.
    * @param expected the object the actual object is supposedly equals to
    * @param actual the actual object to test
    * @return a reference to this, so the API can be used fluently
    */
  def assertEquals(expected: AnyRef, actual: AnyRef): io.vertx.scala.ext.unit.TestContext = {
    _asJava.assertEquals(expected, actual)
    this
  }

  /**
    * Assert the `expected` argument is equals to the `actual` argument. If the arguments are not equals
    * an assertion error is thrown otherwise the execution continue.
    * @param expected the object the actual object is supposedly equals to
    * @param actual the actual object to test
    * @param message the failure message
    * @return a reference to this, so the API can be used fluently
    */
  def assertEquals(expected: AnyRef, actual: AnyRef, message: String): io.vertx.scala.ext.unit.TestContext = {
    _asJava.assertEquals(expected, actual, message)
    this
  }

  /**
    * Asserts that the `expected` double argument is equals to the `actual` double argument
    * within a positive delta. If the arguments do not satisfy this, an assertion error is thrown otherwise
    * the execution continue.
    * @param expected the object the actual object is supposedly equals to
    * @param actual the actual object to test
    * @param delta the maximum delta
    * @return a reference to this, so the API can be used fluently
    */
  def assertInRange(expected: Double, actual: Double, delta: Double): io.vertx.scala.ext.unit.TestContext = {
    _asJava.assertInRange(expected, actual, delta)
    this
  }

  /**
    * Asserts that the `expected` double argument is equals to the `actual` double argument
    * within a positive delta. If the arguments do not satisfy this, an assertion error is thrown otherwise
    * the execution continue.
    * @param expected the object the actual object is supposedly equals to
    * @param actual the actual object to test
    * @param delta the maximum delta
    * @param message the failure message
    * @return a reference to this, so the API can be used fluently
    */
  def assertInRange(expected: Double, actual: Double, delta: Double, message: String): io.vertx.scala.ext.unit.TestContext = {
    _asJava.assertInRange(expected, actual, delta, message)
    this
  }

  /**
    * Assert the `first` argument is not equals to the `second` argument. If the arguments are equals
    * an assertion error is thrown otherwise the execution continue.
    * @param first the first object to test
    * @param second the second object to test
    * @return a reference to this, so the API can be used fluently
    */
  def assertNotEquals(first: AnyRef, second: AnyRef): io.vertx.scala.ext.unit.TestContext = {
    _asJava.assertNotEquals(first, second)
    this
  }

  /**
    * Assert the `first` argument is not equals to the `second` argument. If the arguments are equals
    * an assertion error is thrown otherwise the execution continue.
    * @param first the first object to test
    * @param second the second object to test
    * @param message the failure message
    * @return a reference to this, so the API can be used fluently
    */
  def assertNotEquals(first: AnyRef, second: AnyRef, message: String): io.vertx.scala.ext.unit.TestContext = {
    _asJava.assertNotEquals(first, second, message)
    this
  }

  /**
    * Throw a failure.
    */
  def fail(): Unit = {
    _asJava.fail()
  }

  /**
    * Throw a failure with the specified failure `message`.
    * @param message the failure message
    */
  def fail(message: String): Unit = {
    _asJava.fail(message)
  }

  /**
    * Throw a failure with the specified failure `cause`.
    * @param cause the failure cause
    */
  def fail(cause: Throwable): Unit = {
    _asJava.fail(cause)
  }

  /**
    * Create and returns a new async object, the returned async controls the completion of the test. Calling the
    * [[io.vertx.scala.ext.unit.Async#complete]] completes the async operation.<p/>
    *
    * The test case will complete when all the async objects have their [[io.vertx.scala.ext.unit.Async#complete]]
    * method called at least once.<p/>
    *
    * This method shall be used for creating asynchronous exit points for the executed test.
    * @return the async instance
    */
  def async(): io.vertx.scala.ext.unit.Async = {
    Async.apply(_asJava.async())
  }

  /**
    * Create and returns a new async object, the returned async controls the completion of the test. This async operation
    * completes when the [[io.vertx.scala.ext.unit.Async#complete]] is called `count` times.<p/>
    *
    * The test case will complete when all the async objects have their [[io.vertx.scala.ext.unit.Async#complete]]
    * method called at least once.<p/>
    *
    * This method shall be used for creating asynchronous exit points for the executed test.<p/>
    * @return the async instance
    */
  def async(count: Int): io.vertx.scala.ext.unit.Async = {
    Async.apply(_asJava.async(count))
  }

  /**
    * Creates and returns a new async handler, the returned handler controls the completion of the test.<p/>
    *
    * When the returned handler is called back with a succeeded result it completes the async operation.<p/>
    *
    * When the returned handler is called back with a failed result it fails the test with the cause of the failure.<p/>
    * @return the async result handler
    */
  def asyncAssertSuccess[T](): io.vertx.core.AsyncResult [T] => Unit = {
    handlerToFunc[io.vertx.core.AsyncResult[T]](_asJava.asyncAssertSuccess())
  }

  /**
    * Creates and returns a new async handler, the returned handler controls the completion of the test.<p/>
    *
    * When the returned handler is called back with a succeeded result it invokes the `resultHandler` argument
    * with the async result. The test completes after the result handler is invoked and does not fails.<p/>
    *
    * When the returned handler is called back with a failed result it fails the test with the cause of the failure.<p/>
    *
    * Note that the result handler can create other async objects during its invocation that would postpone
    * the completion of the test case until those objects are resolved.
    * @param resultHandler the result handler
    * @return the async result handler
    */
  def asyncAssertSuccess[T](resultHandler: T => Unit): io.vertx.core.AsyncResult [T] => Unit = {
    handlerToFunc[io.vertx.core.AsyncResult[T]](_asJava.asyncAssertSuccess(funcToHandler(resultHandler)))
  }

  /**
    * Creates and returns a new async handler, the returned handler controls the completion of the test.<p/>
    *
    * When the returned handler is called back with a failed result it completes the async operation.<p/>
    *
    * When the returned handler is called back with a succeeded result it fails the test.<p/>
    * @return the async result handler
    */
  def asyncAssertFailure[T](): io.vertx.core.AsyncResult [T] => Unit = {
    handlerToFunc[io.vertx.core.AsyncResult[T]](_asJava.asyncAssertFailure())
  }

  /**
    * Creates and returns a new async handler, the returned handler controls the completion of the test.<p/>
    *
    * When the returned handler is called back with a failed result it completes the async operation.<p/>
    *
    * When the returned handler is called back with a succeeded result it fails the test.<p/>
    * @param causeHandler the cause handler
    * @return the async result handler
    */
  def asyncAssertFailure[T](causeHandler: Throwable => Unit): io.vertx.core.AsyncResult [T] => Unit = {
    handlerToFunc[io.vertx.core.AsyncResult[T]](_asJava.asyncAssertFailure(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(causeHandler)))
  }

  /**
    * @return an exception handler that will fail this context
    */
  def exceptionHandler(): Throwable => Unit = {
    handlerToFunc[Throwable](_asJava.exceptionHandler())
  }

}

object TestContext {

  def apply(_asJava: io.vertx.ext.unit.TestContext): io.vertx.scala.ext.unit.TestContext =
    new io.vertx.scala.ext.unit.TestContext(_asJava)

}
