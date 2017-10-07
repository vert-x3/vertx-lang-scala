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

package io.vertx.scala.ext.web.client

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.json.JsonArray
import io.vertx.ext.web.client.{HttpResponse => JHttpResponse}
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpVersion
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.MultiMap
import scala.collection.JavaConverters._

/**
  * An HTTP response.
  * 
  * The usual HTTP response attributes are available:
  * <ul>
  *   <li>[[io.vertx.scala.ext.web.client.HttpResponse#statusCode]] the HTTP status code</li>
  *   <li>[[io.vertx.scala.ext.web.client.HttpResponse#statusMessage]] the HTTP status message</li>
  *   <li>[[io.vertx.scala.ext.web.client.HttpResponse#headers]] the HTTP headers</li>
  *   <li>[[io.vertx.scala.ext.web.client.HttpResponse#version]] the HTTP version</li>
  * </ul>
  * 
  * The body of the response is returned by [[io.vertx.scala.ext.web.client.HttpResponse#body]] decoded as the format specified by the  that
  * built the response.
  * 
  * Keep in mind that using this `HttpResponse` impose to fully buffer the response body and should be used for payload
  * that can fit in memory.
  */
class HttpResponse[T: TypeTag](private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0: Option[io.vertx.core.http.HttpVersion] = None
  private var cached_1: Option[Int] = None
  private var cached_2: Option[String] = None
  private var cached_3: Option[MultiMap] = None
  private var cached_4: Option[MultiMap] = None
  private var cached_5: Option[scala.collection.mutable.Buffer[String]] = None
  private var cached_6: Option[scala.Option[T]] = None
  private var cached_7: Option[scala.Option[io.vertx.core.buffer.Buffer]] = None
  private var cached_8: Option[scala.Option[String]] = None
  private var cached_9: Option[scala.Option[io.vertx.core.json.JsonObject]] = None
  private var cached_10: Option[scala.Option[io.vertx.core.json.JsonArray]] = None

  /**
    * @return the version of the response
    */
  def version(): io.vertx.core.http.HttpVersion = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JHttpResponse[Object]].version()
      cached_0 = Some(tmp)
    }
    cached_0.get
  }

  /**
    * @return the status code of the response
    */
  def statusCode(): Int = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JHttpResponse[Object]].statusCode()
      cached_1 = Some(tmp.asInstanceOf[Int])
    }
    cached_1.get
  }

  /**
    * @return the status message of the response
    */
  def statusMessage(): String = {
    if (cached_2 == None) {
      val tmp = asJava.asInstanceOf[JHttpResponse[Object]].statusMessage()
      cached_2 = Some(tmp.asInstanceOf[String])
    }
    cached_2.get
  }

  /**
    * @return the headers
    */
  def headers(): MultiMap = {
    if (cached_3 == None) {
      val tmp = asJava.asInstanceOf[JHttpResponse[Object]].headers()
      cached_3 = Some(MultiMap(tmp))
    }
    cached_3.get
  }

  /**
    * @return the trailers
    */
  def trailers(): MultiMap = {
    if (cached_4 == None) {
      val tmp = asJava.asInstanceOf[JHttpResponse[Object]].trailers()
      cached_4 = Some(MultiMap(tmp))
    }
    cached_4.get
  }

  /**
    * @return the Set-Cookie headers (including trailers)
    */
  def cookies(): scala.collection.mutable.Buffer[String] = {
    if (cached_5 == None) {
      val tmp = asJava.asInstanceOf[JHttpResponse[Object]].cookies()
      cached_5 = Some(tmp.asScala.map(x => x.asInstanceOf[String]))
    }
    cached_5.get
  }

  /**
    * @return the response body in the format it was decoded.
    */
  def body(): scala.Option[T] = {
    if (cached_6 == None) {
      val tmp = asJava.asInstanceOf[JHttpResponse[Object]].body()
      cached_6 = Some(scala.Option(toScala[T](tmp)))
    }
    cached_6.get
  }

  /**
    * @return the response body decoded as a Buffer
    */
  def bodyAsBuffer(): scala.Option[io.vertx.core.buffer.Buffer] = {
    if (cached_7 == None) {
      val tmp = asJava.asInstanceOf[JHttpResponse[Object]].bodyAsBuffer()
      cached_7 = Some(scala.Option(tmp))
    }
    cached_7.get
  }

  /**
    * @return the response body decoded as a `String`
    */
  def bodyAsString(): scala.Option[String] = {
    if (cached_8 == None) {
      val tmp = asJava.asInstanceOf[JHttpResponse[Object]].bodyAsString()
      cached_8 = Some(scala.Option(tmp.asInstanceOf[String]))
    }
    cached_8.get
  }

  /**
    * @return the response body decoded as a json object
    */
  def bodyAsJsonObject(): scala.Option[io.vertx.core.json.JsonObject] = {
    if (cached_9 == None) {
      val tmp = asJava.asInstanceOf[JHttpResponse[Object]].bodyAsJsonObject()
      cached_9 = Some(scala.Option(tmp))
    }
    cached_9.get
  }

  /**
    * @return the response body decoded as a json array
    */
  def bodyAsJsonArray(): scala.Option[io.vertx.core.json.JsonArray] = {
    if (cached_10 == None) {
      val tmp = asJava.asInstanceOf[JHttpResponse[Object]].bodyAsJsonArray()
      cached_10 = Some(scala.Option(tmp))
    }
    cached_10.get
  }

  /**
    * @return the response body decoded as a `String` given a specific `encoding`
    */
  def bodyAsString(encoding: String): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpResponse[Object]].bodyAsString(encoding.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  /**
    * @return the response body decoded as the specified `type` with the Jackson mapper.
    */
  def bodyAsJson[R: TypeTag](`type`: Class[R]): scala.Option[R] = {
    scala.Option(toScala[R](asJava.asInstanceOf[JHttpResponse[Object]].bodyAsJson[Object](toJavaClass(`type`))))
  }

  /**
    * Return the first header value with the specified name
    * @param headerName the header name
    * @return the header value
    */
  def getHeader(headerName: String): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpResponse[Object]].getHeader(headerName.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  /**
    * Return the first trailer value with the specified name
    * @param trailerName the trailer name
    * @return the trailer value
    */
  def getTrailer(trailerName: String): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpResponse[Object]].getTrailer(trailerName.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

}

object HttpResponse {
  def apply[T: TypeTag](asJava: JHttpResponse[_]) = new HttpResponse[T](asJava)  
}
