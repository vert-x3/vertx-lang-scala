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

package io.vertx.scala.core.http

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.core.http.{RequestOptions => JRequestOptions}

/**
  * Options describing how an [[io.vertx.scala.core.http.HttpClient]] will make connect to make a request.
  */
class RequestOptions(private val _asJava: JRequestOptions) {

  def asJava = _asJava

  /**
    * Set the host name to be used by the client request.
    */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }
  def getHost: String = {
    asJava.getHost().asInstanceOf[String]
  }

  /**
    * Set the port to be used by the client request.
    */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }

  /**
    * Set whether SSL/TLS is enabled
    */
  def setSsl(value: Boolean) = {
    asJava.setSsl(value)
    this
  }
  def isSsl: Boolean = {
    asJava.isSsl().asInstanceOf[Boolean]
  }

  /**
    * Set the request relative URI
    */
  def setURI(value: String) = {
    asJava.setURI(value)
    this
  }
  def getURI: String = {
    asJava.getURI().asInstanceOf[String]
  }
}

object RequestOptions {
  
  def apply() = {
    new RequestOptions(new JRequestOptions(emptyObj()))
  }
  
  def apply(t: JRequestOptions) = {
    if (t != null) {
      new RequestOptions(t)
    } else {
      new RequestOptions(new JRequestOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): RequestOptions = {
    if (json != null) {
      new RequestOptions(new JRequestOptions(json))
    } else {
      new RequestOptions(new JRequestOptions(emptyObj()))
    }
  }
}
