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

package io.vertx.scala.circuitbreaker

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.circuitbreaker.{CircuitBreaker => JCircuitBreaker}
import io.vertx.circuitbreaker.{CircuitBreakerOptions => JCircuitBreakerOptions}
import io.vertx.scala.circuitbreaker.CircuitBreakerOptions
import io.vertx.circuitbreaker.CircuitBreakerState
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Future => JFuture}
import io.vertx.scala.core.Future
import java.util.function.{Function => JFunction}

/**
  * An implementation of the circuit breaker pattern for Vert.x
  */
class CircuitBreaker(private val _asJava: JCircuitBreaker) {

  def asJava: JCircuitBreaker = _asJava

  /**
    * Closes the circuit breaker. It stops sending events on its state on the event bus.
    * This method is not related to the `close` state of the circuit breaker. To set the circuit breaker in the
    * `close` state, use [[io.vertx.scala.circuitbreaker.CircuitBreaker#reset]].
    */
  def close(): CircuitBreaker = {
    _asJava.close()
    this
  }

  /**
    * Sets a  invoked when the circuit breaker state switches to open.
    * @param handler the handler, must not be `null`
    * @return the current [[CircuitBreaker]]
    */
  def openHandler(handler: () => Unit): CircuitBreaker = {
    _asJava.openHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  /**
    * Sets a  invoked when the circuit breaker state switches to half-open.
    * @param handler the handler, must not be `null`
    * @return the current [[CircuitBreaker]]
    */
  def halfOpenHandler(handler: () => Unit): CircuitBreaker = {
    _asJava.halfOpenHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  /**
    * Sets a  invoked when the circuit breaker state switches to close.
    * @param handler the handler, must not be `null`
    * @return the current [[CircuitBreaker]]
    */
  def closeHandler(handler: () => Unit): CircuitBreaker = {
    _asJava.closeHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  /**
    * Executes the given operation with the circuit breaker control. The operation is generally calling an
    * <em>external</em> system. The operation receives a  object as parameter and <strong>must</strong>
    * call  when the operation has terminated successfully. The operation must also
    * call  in case of failure.
    * 
    * The operation is not invoked if the circuit breaker is open, and the given fallback is called immediately. The
    * circuit breaker also monitor the completion of the operation before a configure timeout. The operation is
    * considered as failed if it does not terminate in time.
    * 
    * This method returns a  object to retrieve the status and result of the operation, with the status
    * being a success or a failure. If the fallback is called, the returned future is successfully completed with the
    * value returned from the fallback. If the fallback throws an exception, the returned future is marked as failed.
    * @param operation the operation
    * @param fallback the fallback function. It gets an exception as parameter and returns the <em>fallback</em> result
    * @return a future object completed when the operation or its fallback completes
    */
  def executeWithFallback[T](operation: Future[T] => Unit, fallback: java.lang.Throwable => T): Future[T] = {
    Future.apply[T](_asJava.executeWithFallback(funcToMappedHandler(Future.apply[T])(operation), asJavaFunction(fallback)))
  }

  /**
    * Same as [[io.vertx.scala.circuitbreaker.CircuitBreaker#executeWithFallback]] but using the circuit breaker default fallback.
    * @param operation the operation
    * @return a future object completed when the operation or its fallback completes
    */
  def execute[T](operation: Future[T] => Unit): Future[T] = {
    Future.apply[T](_asJava.execute(funcToMappedHandler(Future.apply[T])(operation)))
  }

  /**
    * Same as [[io.vertx.scala.circuitbreaker.CircuitBreaker#executeAndReportWithFallback]] but using the circuit breaker default
    * fallback.
    * @param resultFuture the future on which the operation result is reported
    * @param operation the operation
    * @return the current [[CircuitBreaker]]
    */
  def executeAndReport[T](resultFuture: Future[T], operation: Future[T] => Unit): CircuitBreaker = {
    _asJava.executeAndReport(resultFuture.asJava.asInstanceOf[JFuture[T]], funcToMappedHandler(Future.apply[T])(operation))
    this
  }

  /**
    * Executes the given operation with the circuit breaker control. The operation is generally calling an
    * <em>external</em> system. The operation receives a  object as parameter and <strong>must</strong>
    * call  when the operation has terminated successfully. The operation must also
    * call  in case of failure.
    * 
    * The operation is not invoked if the circuit breaker is open, and the given fallback is called immediately. The
    * circuit breaker also monitor the completion of the operation before a configure timeout. The operation is
    * considered as failed if it does not terminate in time.
    * 
    * Unlike [[io.vertx.scala.circuitbreaker.CircuitBreaker#executeWithFallback]],  this method does return a  object, but
    * let the caller pass a  object on which the result is reported. If the fallback is called, the future
    * is successfully completed with the value returned by the fallback function. If the fallback throws an exception,
    * the future is marked as failed.
    * @param resultFuture the future on which the operation result is reported
    * @param operation the operation
    * @param fallback the fallback function. It gets an exception as parameter and returns the <em>fallback</em> result
    * @return the current [[CircuitBreaker]]
    */
  def executeAndReportWithFallback[T](resultFuture: Future[T], operation: Future[T] => Unit, fallback: java.lang.Throwable => T): CircuitBreaker = {
    _asJava.executeAndReportWithFallback(resultFuture.asJava.asInstanceOf[JFuture[T]], funcToMappedHandler(Future.apply[T])(operation), asJavaFunction(fallback))
    this
  }

  /**
    * Sets a <em>default</em>  invoked when the bridge is open to handle the "request", or on failure
    * if <a href="../../../../../../cheatsheet/CircuitBreakerOptions.html">CircuitBreakerOptions</a> is enabled.
    * 
    * The function gets the exception as parameter and returns the <em>fallback</em> result.
    * @param handler the handler
    * @return the current [[CircuitBreaker]]
    */
  def fallback[T](handler: java.lang.Throwable => T): CircuitBreaker = {
    _asJava.fallback(asJavaFunction(handler))
    this
  }

  /**
    * Resets the circuit breaker state (number of failure set to 0 and state set to closed).
    * @return the current [[CircuitBreaker]]
    */
  def reset(): CircuitBreaker = {
    _asJava.reset()
    this
  }

  /**
    * Explicitly opens the circuit.
    * @return the current [[CircuitBreaker]]
    */
  def open(): CircuitBreaker = {
    _asJava.open()
    this
  }

  /**
    * @return the current state.
    */
  def state(): io.vertx.circuitbreaker.CircuitBreakerState = {
    _asJava.state()
  }

  /**
    * @return the current number of failures.
    */
  def failureCount(): Long = {
    _asJava.failureCount()
  }

  /**
    * @return the name of the circuit breaker.
    */
  def name(): String = {
    if (cached_0 == null) {
      cached_0=    _asJava.name()
    }
    cached_0
  }

  private var cached_0: String = _
}

object CircuitBreaker {

  def apply(_asJava: JCircuitBreaker): CircuitBreaker =
    new CircuitBreaker(_asJava)

  def create(name: String, vertx: Vertx, options: CircuitBreakerOptions): CircuitBreaker = {
    CircuitBreaker.apply(io.vertx.circuitbreaker.CircuitBreaker.create(name, vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  def create(name: String, vertx: Vertx): CircuitBreaker = {
    CircuitBreaker.apply(io.vertx.circuitbreaker.CircuitBreaker.create(name, vertx.asJava.asInstanceOf[JVertx]))
  }

}
