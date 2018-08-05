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

package io.vertx.scala.ext.auth.oauth2

import io.vertx.core.json.JsonArray
import io.vertx.core.buffer.Buffer
import scala.reflect.runtime.universe._
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.MultiMap
import io.vertx.ext.auth.oauth2.{OAuth2Response => JOAuth2Response}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A response from a fetch request.
  *
  * This class represents a secure response from a Oauth2 fetch call.
  *
  * A fetch is a simplified HTTP response from a protected resource.
  */

class OAuth2Response(private val _asJava: Object) {
  def asJava = _asJava





  /**
   * the returned status code from the HTTP layer.   * @return HTTP status code
   */
  def statusCode (): Int = {
    asJava.asInstanceOf[JOAuth2Response].statusCode().asInstanceOf[Int]
  }

  /**
   * The HTTP response headers from the HTTP layer.   * @return the HTTP headers
   */
  def headers (): scala.Option[MultiMap] = {
    scala.Option(asJava.asInstanceOf[JOAuth2Response].headers()).map(MultiMap(_))
  }

  /**
   * Looks up a HTTP response header by name, in case where the response is a list of headers,
   * the first one is returned.   * @param name of the header to look up
   * @return the single value for the header.
   */
  def getHeader (name: String): String = {
    asJava.asInstanceOf[JOAuth2Response].getHeader(name.asInstanceOf[java.lang.String]).asInstanceOf[String]
  }

  /**
   * The HTTP response body as a buffer   * @return a buffer with the HTTP response body
   */
  def body (): scala.Option[io.vertx.core.buffer.Buffer] = {
    scala.Option(asJava.asInstanceOf[JOAuth2Response].body())
  }

  /**
   * The HTTP response body as a JsonObject   * @return a JsonObject from the HTTP response body
   */
  def jsonObject (): scala.Option[io.vertx.core.json.JsonObject] = {
    scala.Option(asJava.asInstanceOf[JOAuth2Response].jsonObject())
  }

  /**
   * The HTTP response body as a JsonArray   * @return a JsonArray from the HTTP response body
   */
  def jsonArray (): scala.Option[io.vertx.core.json.JsonArray] = {
    scala.Option(asJava.asInstanceOf[JOAuth2Response].jsonArray())
  }

  /**
   * Helper to analize the response body. The test is performed against the header Content-Type,
   * the content of the body is not analyzed.   * @param contentType a content type to test, e.g.: application/json
   * @return true if the header matches
   */
  def is (contentType: String): Boolean = {
    asJava.asInstanceOf[JOAuth2Response].is(contentType.asInstanceOf[java.lang.String]).asInstanceOf[Boolean]
  }


}

object OAuth2Response {
  def apply(asJava: JOAuth2Response) = new OAuth2Response(asJava)
  
}
