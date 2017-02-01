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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.circuitbreaker.{CircuitBreaker => JCircuitBreaker}
import io.vertx.circuitbreaker.CircuitBreakerState
import io.vertx.core.{Future => JFuture}
import io.vertx.scala.core.Future
import io.vertx.core.Handler
import io.vertx.circuitbreaker.{CircuitBreakerOptions => JCircuitBreakerOptions}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * An implementation of the circuit breaker pattern for Vert.x
  */
class CircuitBreaker(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0: String = _

  /**
    * @return the name of the circuit breaker.
    */
  def name(): String = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JCircuitBreaker].name()
      cached_0 = tmp.asInstanceOf[String]
    }
    cached_0
  }

  /**
    * Closes the circuit breaker. It stops sending events on its state on the event bus.
    * This method is not related to the `close` state of the circuit breaker. To set the circuit breaker in the
    * `close` state, use [[io.vertx.scala.circuitbreaker.CircuitBreaker#reset]].
    */
  def close(): CircuitBreaker = {
    asJava.asInstanceOf[JCircuitBreaker].close()
    this
  }

  /**
    * Sets a  invoked when the circuit breaker state switches to open.
    * @param handler the handler, must not be `null`
    * @return the current CircuitBreaker
    */
  def openHandler(handler: Handler[Unit]): CircuitBreaker = {
    asJava.asInstanceOf[JCircuitBreaker].openHandler({x: Void => handler.handle(x)})
    this
  }

  /**
    * Sets a  invoked when the circuit breaker state switches to half-open.
    * @param handler the handler, must not be `null`
    * @return the current CircuitBreaker
    */
  def halfOpenHandler(handler: Handler[Unit]): CircuitBreaker = {
    asJava.asInstanceOf[JCircuitBreaker].halfOpenHandler({x: Void => handler.handle(x)})
    this
  }

  /**
    * Sets a  invoked when the circuit breaker state switches to close.
    * @param handler the handler, must not be `null`
    * @return the current CircuitBreaker
    */
  def closeHandler(handler: Handler[Unit]): CircuitBreaker = {
    asJava.asInstanceOf[JCircuitBreaker].closeHandler({x: Void => handler.handle(x)})
    this
  }

  /**
    * Same as [[io.vertx.scala.circuitbreaker.CircuitBreaker#executeAndReportWithFallback]] but using the circuit breaker default
    * fallback.
    * @param resultFuture the future on which the operation result is reported
    * @param command the operation
    * @return the current CircuitBreaker
    */
  def executeAndReport[T: TypeTag](resultFuture: Future[T], command: Handler[Future[T]]): CircuitBreaker = {
    asJava.asInstanceOf[JCircuitBreaker].executeAndReport[Object](resultFuture.asJava.asInstanceOf[JFuture[Object]],{x: JFuture[Object] => command.handle(Future[T](x))})
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
    * @param command the operation
    * @param fallback the fallback function. It gets an exception as parameter and returns the <em>fallback</em> result
    * @return the current CircuitBreaker
    */
  def executeAndReportWithFallback[T: TypeTag](resultFuture: Future[T], command: Handler[Future[T]], fallback: Throwable => T): CircuitBreaker = {
    asJava.asInstanceOf[JCircuitBreaker].executeAndReportWithFallback[Object](resultFuture.asJava.asInstanceOf[JFuture[Object]],{x: JFuture[Object] => command.handle(Future[T](x))},{x: Throwable => toJava[T](fallback(x))})
    this
  }

  /**
    * Sets a <em>default</em>  invoked when the bridge is open to handle the "request", or on failure
    * if <a href="../../../../../../cheatsheet/CircuitBreakerOptions.html">CircuitBreakerOptions</a> is enabled.
    * 
    * The function gets the exception as parameter and returns the <em>fallback</em> result.
    * @param handler the handler
    * @return the current CircuitBreaker
    */
  def fallback[T: TypeTag](handler: Throwable => T): CircuitBreaker = {
    asJava.asInstanceOf[JCircuitBreaker].fallback[Object]({x: Throwable => toJava[T](handler(x))})
    this
  }

  /**
    * Resets the circuit breaker state (number of failure set to 0 and state set to closed).
    * @return the current CircuitBreaker
    */
  def reset(): CircuitBreaker = {
    asJava.asInstanceOf[JCircuitBreaker].reset()
    this
  }

  /**
    * Explicitly opens the circuit.
    * @return the current CircuitBreaker
    */
  def open(): CircuitBreaker = {
    asJava.asInstanceOf[JCircuitBreaker].open()
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
    * @param command the operation
    * @param fallback the fallback function. It gets an exception as parameter and returns the <em>fallback</em> result
    * @return a future object completed when the operation or its fallback completes
    */
  def executeWithFallback[T: TypeTag](command: Handler[Future[T]], fallback: Throwable => T): Future[T] = {
    Future[T](asJava.asInstanceOf[JCircuitBreaker].executeWithFallback[Object]({x: JFuture[Object] => command.handle(Future[T](x))},{x: Throwable => toJava[T](fallback(x))}))
  }

  /**
    * Same as [[io.vertx.scala.circuitbreaker.CircuitBreaker#executeWithFallback]] but using the circuit breaker default fallback.
    * @param command the operation
    * @return a future object completed when the operation or its fallback completes
    */
  def execute[T: TypeTag](command: Handler[Future[T]]): Future[T] = {
    Future[T](asJava.asInstanceOf[JCircuitBreaker].execute[Object]({x: JFuture[Object] => command.handle(Future[T](x))}))
  }

  /**
    * @return the current state.
    */
  def state(): io.vertx.circuitbreaker.CircuitBreakerState = {
    asJava.asInstanceOf[JCircuitBreaker].state()
  }

  /**
    * @return the current number of failures.
    */
  def failureCount(): Long = {
    asJava.asInstanceOf[JCircuitBreaker].failureCount().asInstanceOf[Long]
  }

}

object CircuitBreaker {
  def apply(asJava: JCircuitBreaker) = new CircuitBreaker(asJava)  
  /**
    * Creates a new instance of [[io.vertx.scala.circuitbreaker.CircuitBreaker]].
    * @param name the name
    * @param vertx the Vert.x instance
    * @param options the configuration optionsee <a href="../../../../../../cheatsheet/CircuitBreakerOptions.html">CircuitBreakerOptions</a>
    * @return the created instance
    */
  def create(name: String, vertx: Vertx, options: CircuitBreakerOptions): CircuitBreaker = {
    CircuitBreaker(JCircuitBreaker.create(name.asInstanceOf[java.lang.String],vertx.asJava.asInstanceOf[JVertx],options.asJava))
  }

  /**
    * Creates a new instance of [[io.vertx.scala.circuitbreaker.CircuitBreaker]], with default options.
    * @param name the name
    * @param vertx the Vert.x instance
    * @return the created instance
    */
  def create(name: String, vertx: Vertx): CircuitBreaker = {
    CircuitBreaker(JCircuitBreaker.create(name.asInstanceOf[java.lang.String],vertx.asJava.asInstanceOf[JVertx]))
  }

}
