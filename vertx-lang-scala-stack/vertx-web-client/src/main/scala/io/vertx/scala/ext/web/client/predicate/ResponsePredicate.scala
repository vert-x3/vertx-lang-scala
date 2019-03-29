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

import io.vertx.ext.web.client.{HttpResponse => JHttpResponse}
import io.vertx.ext.web.client.predicate.{ResponsePredicateResult => JResponsePredicateResult}
import scala.reflect.runtime.universe._
import io.vertx.ext.web.client.predicate.{ErrorConverter => JErrorConverter}
import io.vertx.ext.web.client.predicate.{ResponsePredicate => JResponsePredicate}
import io.vertx.scala.ext.web.client.HttpResponse
import scala.collection.JavaConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A predicate on .
  * 
  * By default, a Vert.x Web Client request ends with an error only if something wrong happens at the network level.
  * In other words, a `404 Not Found` response, or a response with the wrong content type, are <em>NOT</em> considered as failures.
  * 
  * [[io.vertx.scala.ext.web.client.predicate.ResponsePredicate]] can fail a request when the response does not match some criteria.
  * 
  * Custom predicate instances can be used with .
  * 
  * As a convenience, a few predicates for common uses cases are predefined. For example:
  * <ul>
  * <li>[[io.vertx.scala.ext.web.client.predicate.ResponsePredicate]] to verify that the response has a `2xx` code, or</li>
  * <li>[[io.vertx.scala.ext.web.client.predicate.ResponsePredicate]] to verify that the response body contains JSON data.</li>
  * <li>...</li>
  * </ul>
  * Predefined predicates use the default error converter (discarding the body).
  * 
  * However, you can create a new [[io.vertx.scala.ext.web.client.predicate.ResponsePredicate]] instance from an existing one using [[io.vertx.scala.ext.web.client.predicate.ResponsePredicate#create]] or
  * [[io.vertx.scala.ext.web.client.predicate.ResponsePredicate#create]] when the body is required to build the validation failure.

  */

class ResponsePredicate(private val _asJava: Object) {
  def asJava = _asJava




  /**
   * @return the error converter currently used
   */
  def errorConverter(): ErrorConverter = {
    ErrorConverter(asJava.asInstanceOf[JResponsePredicate].errorConverter())
  }



}

object ResponsePredicate {
  def apply(asJava: JResponsePredicate) = new ResponsePredicate(asJava)
  
  /**
   * Creates a predicate asserting that the status response code is equal to `statusCode`.   * @param statusCode the expected status code
   */
  def status(statusCode: Int): ResponsePredicate = {
    ResponsePredicate(JResponsePredicate.status(statusCode.asInstanceOf[java.lang.Integer]))
  }

  /**
   * Creates a predicate asserting that the status response code is in the `[min,max[` range.   * @param min the lower (inclusive) accepted status code
   * @param max the highest (exclusive) accepted status code
   */
  def status(min: Int,max: Int): ResponsePredicate = {
    ResponsePredicate(JResponsePredicate.status(min.asInstanceOf[java.lang.Integer], max.asInstanceOf[java.lang.Integer]))
  }

  /**
   * Creates a predicate validating the response has a `content-type` header matching the `mimeType`.   * @param mimeType the mime type
   */
  def contentType(mimeType: String): ResponsePredicate = {
    ResponsePredicate(JResponsePredicate.contentType(mimeType.asInstanceOf[java.lang.String]))
  }

  /**
   * Creates a predicate validating the response has a `content-type` header matching one of the `mimeTypes`.   * @param mimeTypes the list of mime types
   */
  def contentType(mimeTypes: scala.collection.mutable.Buffer[String]): ResponsePredicate = {
    ResponsePredicate(JResponsePredicate.contentType(mimeTypes.map(x => x.asInstanceOf[java.lang.String]).asJava))
  }

  /**
   * Creates a new [[io.vertx.scala.ext.web.client.predicate.ResponsePredicate]]. The default error converter will be used (discarding the body).   * @param test the function to invoke when the response is received
   */
  def create(test: HttpResponse[Unit] => ResponsePredicateResult): ResponsePredicate = {
    ResponsePredicate(JResponsePredicate.create({x: JHttpResponse[Void] => test(HttpResponse[Unit](x)).asJava.asInstanceOf[JResponsePredicateResult]}))
  }

  /**
   * Creates a new [[io.vertx.scala.ext.web.client.predicate.ResponsePredicate]], using a custom `errorConverter`.   * @param test the function to invoke when the response is received
   * @param errorConverter converts the result of the `test` function to a Throwable
   */
  def create(test: HttpResponse[Unit] => ResponsePredicateResult,errorConverter: ErrorConverter): ResponsePredicate = {
    ResponsePredicate(JResponsePredicate.create({x: JHttpResponse[Void] => test(HttpResponse[Unit](x)).asJava.asInstanceOf[JResponsePredicateResult]}, errorConverter.asJava.asInstanceOf[JErrorConverter]))
  }

}
