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
import io.vertx.ext.web.client.{HttpResponse => JHttpResponse}
import io.vertx.core.buffer.Buffer
import scala.reflect.runtime.universe._
import io.vertx.scala.ext.web.client.HttpResponse
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Represents the outcome of a [[io.vertx.scala.ext.web.client.predicate.ResponsePredicate]] applied to an .
  */

class ResponsePredicateResult(private val _asJava: Object) {
  def asJava = _asJava





  /**
   * Whether the result is a success or failure.   * @return `true` if the ResponsePredicate was applied successfully, false otherwise
   */
  def succeeded (): Boolean = {
    asJava.asInstanceOf[JResponsePredicateResult].succeeded().asInstanceOf[Boolean]
  }

  /**
   * The failure message. May be `null`.
   */
  def message (): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JResponsePredicateResult].message().asInstanceOf[String])
  }

  /**
   * The  which has been tested.   * @return `null` after the result has been created, or the tested response for converters created with ErrorConverter#createFullBody(Function)
   */
  def response (): scala.Option[HttpResponse[io.vertx.core.buffer.Buffer]] = {
    scala.Option(asJava.asInstanceOf[JResponsePredicateResult].response()).map(HttpResponse[io.vertx.core.buffer.Buffer](_))
  }


}

object ResponsePredicateResult {
  def apply(asJava: JResponsePredicateResult) = new ResponsePredicateResult(asJava)
  
  /**
   * @return a successful result
   */
  def success(): ResponsePredicateResult = {
    ResponsePredicateResult(JResponsePredicateResult.success())
  }

  /**
   * Creates a failed result.   * @param message the failure description
   */
  def failure(message: String): ResponsePredicateResult = {
    ResponsePredicateResult(JResponsePredicateResult.failure(message.asInstanceOf[java.lang.String]))
  }

}
