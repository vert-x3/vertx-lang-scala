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

package io.vertx.scala.core.dns

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.core.dns.{DnsClientOptions => JDnsClientOptions}

/**
  * Configuration options for Vert.x DNS client.
  */
class DnsClientOptions(private val _asJava: JDnsClientOptions) {

  def asJava = _asJava

  /**
    * Set the host name to be used by this client in requests.
    */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }
  def getHost: String = {
    asJava.getHost().asInstanceOf[String]
  }

  /**
    * Set the port to be used by this client in requests.
    */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }

  /**
    * Set the query timeout in milliseconds, i.e the amount of time after a query is considered to be failed.
    */
  def setQueryTimeout(value: Long) = {
    asJava.setQueryTimeout(value)
    this
  }
  def getQueryTimeout: Long = {
    asJava.getQueryTimeout().asInstanceOf[Long]
  }
}

object DnsClientOptions {
  
  def apply() = {
    new DnsClientOptions(new JDnsClientOptions(emptyObj()))
  }
  
  def apply(t: JDnsClientOptions) = {
    if (t != null) {
      new DnsClientOptions(t)
    } else {
      new DnsClientOptions(new JDnsClientOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): DnsClientOptions = {
    if (json != null) {
      new DnsClientOptions(new JDnsClientOptions(json))
    } else {
      new DnsClientOptions(new JDnsClientOptions(emptyObj()))
    }
  }
}
