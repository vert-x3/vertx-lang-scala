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

package io.vertx.scala.ext.web.client.predicate

import io.vertx.ext.web.client.predicate.{ResponsePredicateResult => JResponsePredicateResult}
import scala.reflect.runtime.universe._
import io.vertx.ext.web.client.predicate.{ErrorConverter => JErrorConverter}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Converts a [[io.vertx.scala.ext.web.client.predicate.ResponsePredicateResult]] to a `Throwable` describing the error.
  */

class ErrorConverter(private val _asJava: Object) {
  def asJava = _asJava




  /**
   * @return `true` when the converter wants to process the request body.
   */
  def requiresBody(): Boolean = {
    asJava.asInstanceOf[JErrorConverter].requiresBody().asInstanceOf[Boolean]
  }



  def apply (result: ResponsePredicateResult): Throwable = {
    asJava.asInstanceOf[JErrorConverter].apply(result.asJava.asInstanceOf[JResponsePredicateResult])
  }


}

object ErrorConverter {
  def apply(asJava: JErrorConverter) = new ErrorConverter(asJava)
  
  /**
   * Creates a full [[io.vertx.scala.ext.web.client.predicate.ErrorConverter]], that will passed a predicate result with the response body.
   *
   * The `converter` function will be invoked <em>after</em> the HTTP response body is received.   * @param converter a function creating a Throwable from a ResponsePredicateResult
   */
  def create(converter: ResponsePredicateResult => Throwable): ErrorConverter = {
    ErrorConverter(JErrorConverter.create({x: JResponsePredicateResult => converter(ResponsePredicateResult(x))}))
  }

  /**
   * Creates a full [[io.vertx.scala.ext.web.client.predicate.ErrorConverter]], that will passed a predicate result with the response body.
   *
   * The `converter` function will be invoked <em>after</em> the HTTP response body is received.   * @param converter a function creating a Throwable from a ResponsePredicateResult
   */
  def createFullBody(converter: ResponsePredicateResult => Throwable): ErrorConverter = {
    ErrorConverter(JErrorConverter.createFullBody({x: JResponsePredicateResult => converter(ResponsePredicateResult(x))}))
  }

}
