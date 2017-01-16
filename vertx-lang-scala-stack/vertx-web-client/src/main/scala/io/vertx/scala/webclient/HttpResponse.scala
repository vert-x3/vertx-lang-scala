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

package io.vertx.scala.webclient

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpVersion
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.MultiMap
import io.vertx.webclient.{HttpResponse => JHttpResponse}
import scala.collection.JavaConverters._

/**
  * An HTTP response.
  * 
  * The usual HTTP response attributes are available:
  * <ul>
  *   <li>[[io.vertx.scala.webclient.HttpResponse#statusCode]] the HTTP status code</li>
  *   <li>[[io.vertx.scala.webclient.HttpResponse#statusMessage]] the HTTP status message</li>
  *   <li>[[io.vertx.scala.webclient.HttpResponse#headers]] the HTTP headers</li>
  *   <li>[[io.vertx.scala.webclient.HttpResponse#version]] the HTTP version</li>
  * </ul>
  * 
  * The body of the response is returned by [[io.vertx.scala.webclient.HttpResponse#body]] decoded as the format specified by the [[io.vertx.scala.webclient.BodyCodec]] that
  * built the response.
  * 
  * Keep in mind that using this `HttpResponse` impose to fully buffer the response body and should be used for payload
  * that can fit in memory.
  */
class HttpResponse[T:TypeTag](private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0:io.vertx.core.http.HttpVersion = _
  private var cached_1:Int = _
  private var cached_2:String = _
  private var cached_3:MultiMap = _
  private var cached_4:MultiMap = _
  private var cached_5:scala.collection.mutable.Buffer[String] = _
  private var cached_6:T = _
  private var cached_7:scala.Option[io.vertx.core.buffer.Buffer] = _
  private var cached_8:scala.Option[String] = _
  private var cached_9:scala.Option[io.vertx.core.json.JsonObject] = _

  /**
    * @return the version of the response
    */
  def version():io.vertx.core.http.HttpVersion = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JHttpResponse[Object]].version()
      cached_0 = tmp
    }
    cached_0
  }

  /**
    * @return the status code of the response
    */
  def statusCode():Int = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JHttpResponse[Object]].statusCode()
      cached_1 = tmp.asInstanceOf[Int]
    }
    cached_1
  }

  /**
    * @return the status message of the response
    */
  def statusMessage():String = {
    if(cached_2 == null) {
      var tmp = asJava.asInstanceOf[JHttpResponse[Object]].statusMessage()
      cached_2 = tmp.asInstanceOf[String]
    }
    cached_2
  }

  /**
    * @return the headers
    */
  def headers():MultiMap = {
    if(cached_3 == null) {
      var tmp = asJava.asInstanceOf[JHttpResponse[Object]].headers()
      cached_3 = MultiMap(tmp)
    }
    cached_3
  }

  /**
    * @return the trailers
    */
  def trailers():MultiMap = {
    if(cached_4 == null) {
      var tmp = asJava.asInstanceOf[JHttpResponse[Object]].trailers()
      cached_4 = MultiMap(tmp)
    }
    cached_4
  }

  /**
    * @return the Set-Cookie headers (including trailers)
    */
  def cookies():scala.collection.mutable.Buffer[String] = {
    if(cached_5 == null) {
      var tmp = asJava.asInstanceOf[JHttpResponse[Object]].cookies()
      cached_5 = tmp.asScala.map(x => x.asInstanceOf[String])
    }
    cached_5
  }

  /**
    * @return the response body in the format it was decoded.
    */
  def body():T = {
    if(cached_6 == null) {
      var tmp = asJava.asInstanceOf[JHttpResponse[Object]].body()
      cached_6 = toScala[T](tmp)
    }
    cached_6
  }

  /**
    * @return the response body decoded as a Buffer
    */
  def bodyAsBuffer():scala.Option[io.vertx.core.buffer.Buffer] = {
    if(cached_7 == null) {
      var tmp = asJava.asInstanceOf[JHttpResponse[Object]].bodyAsBuffer()
      cached_7 = scala.Option(tmp)
    }
    cached_7
  }

  /**
    * @return the response body decoded as a `String`
    */
  def bodyAsString():scala.Option[String] = {
    if(cached_8 == null) {
      var tmp = asJava.asInstanceOf[JHttpResponse[Object]].bodyAsString()
      cached_8 = scala.Option(tmp.asInstanceOf[String])
    }
    cached_8
  }

  /**
    * @return the response body decoded as a json object
    */
  def bodyAsJsonObject():scala.Option[io.vertx.core.json.JsonObject] = {
    if(cached_9 == null) {
      var tmp = asJava.asInstanceOf[JHttpResponse[Object]].bodyAsJsonObject()
      cached_9 = scala.Option(tmp)
    }
    cached_9
  }

  /**
    * Return the first header value with the specified name
    * @param headerName the header name
    * @return the header value
    */
  def getHeader(headerName: String):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpResponse[Object]].getHeader(headerName.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  /**
    * Return the first trailer value with the specified name
    * @param trailerName the trailer name
    * @return the trailer value
    */
  def getTrailer(trailerName: String):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpResponse[Object]].getTrailer(trailerName.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  /**
    * @return the response body decoded as a `String` given a specific `encoding`
    */
  def bodyAsString(encoding: String):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpResponse[Object]].bodyAsString(encoding.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  /**
    * @return the response body decoded as the specified `type` with the Jackson mapper.
    */
  def bodyAsJson[R:TypeTag](`type`: Class[R]):R = {
    toScala[R](asJava.asInstanceOf[JHttpResponse[Object]].bodyAsJson[Object](toJavaClass(`type`)))
  }

}

object HttpResponse{
  def apply[T:TypeTag](asJava: JHttpResponse[_]) = new HttpResponse[T](asJava)  
}
