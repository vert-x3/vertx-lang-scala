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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.circuitbreaker.{CircuitBreakerOptions => JCircuitBreakerOptions}

/**
  * Circuit breaker configuration options. All time are given in milliseconds.
  */
class CircuitBreakerOptions(private val _asJava: JCircuitBreakerOptions) {

  def asJava = _asJava

  /**
    * Sets whether or not the fallback is executed on failure, even when the circuit is closed.
    */
  def setFallbackOnFailure(value: Boolean) = {
    asJava.setFallbackOnFailure(value)
    this
  }
  def isFallbackOnFailure: Boolean = {
    asJava.isFallbackOnFailure().asInstanceOf[Boolean]
  }

  /**
    * Sets the maximum number of failures before opening the circuit.
    */
  def setMaxFailures(value: Int) = {
    asJava.setMaxFailures(value)
    this
  }
  def getMaxFailures: Int = {
    asJava.getMaxFailures().asInstanceOf[Int]
  }

  /**
    * Configures the number of times the circuit breaker tries to redo the operation before failing.
    */
  def setMaxRetries(value: Int) = {
    asJava.setMaxRetries(value)
    this
  }
  def getMaxRetries: Int = {
    asJava.getMaxRetries().asInstanceOf[Int]
  }

  /**
    * Sets the rolling window used for metrics.
    */
  def setMetricsRollingWindow(value: Long) = {
    asJava.setMetricsRollingWindow(value)
    this
  }
  def getMetricsRollingWindow: Long = {
    asJava.getMetricsRollingWindow().asInstanceOf[Long]
  }

  /**
    * Sets the event bus address on which the circuit breaker publish its state change.
    */
  def setNotificationAddress(value: String) = {
    asJava.setNotificationAddress(value)
    this
  }
  def getNotificationAddress: String = {
    asJava.getNotificationAddress().asInstanceOf[String]
  }

  /**
    * Configures the period in milliseconds where the circuit breaker send a notification on the event bus with its
    * current state.
    */
  def setNotificationPeriod(value: Long) = {
    asJava.setNotificationPeriod(value)
    this
  }
  def getNotificationPeriod: Long = {
    asJava.getNotificationPeriod().asInstanceOf[Long]
  }

  /**
    * Sets the time in ms before it attempts to re-close the circuit (by going to the hal-open state). If the cricuit
    * is closed when the timeout is reached, nothing happens. `-1` disables this feature.
    */
  def setResetTimeout(value: Long) = {
    asJava.setResetTimeout(value)
    this
  }
  def getResetTimeout: Long = {
    asJava.getResetTimeout().asInstanceOf[Long]
  }

  /**
    * Sets the timeout in milliseconds. If an action is not completed before this timeout, the action is considered as
    * a failure.
    */
  def setTimeout(value: Long) = {
    asJava.setTimeout(value)
    this
  }
  def getTimeout: Long = {
    asJava.getTimeout().asInstanceOf[Long]
  }
}

object CircuitBreakerOptions {
  
  def apply() = {
    new CircuitBreakerOptions(new JCircuitBreakerOptions(emptyObj()))
  }
  
  def apply(t: JCircuitBreakerOptions) = {
    if(t != null)
      new CircuitBreakerOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):CircuitBreakerOptions = {
    if(json != null)
      new CircuitBreakerOptions(new JCircuitBreakerOptions(json))
    else
      null
  }
}
