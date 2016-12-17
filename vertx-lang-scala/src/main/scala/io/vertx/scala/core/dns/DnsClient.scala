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

import io.vertx.core.dns.{DnsClient => JDnsClient}
import io.vertx.core.dns.{SrvRecord => JSrvRecord}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.core.dns.{MxRecord => JMxRecord}

/**
  * Provides a way to asynchronously lookup information from DNS servers.
  * 
  * Please consult the documentation for more information on DNS clients.
  */
class DnsClient(private val _asJava: Object) {

  def asJava = _asJava

//methods returning a future
//cached methods
//fluent methods
  def lookup(name: String,handler: Handler[AsyncResult[String]]):DnsClient = {
    DnsClient(asJava.asInstanceOf[JDnsClient].lookup(name,handler))
    this
  }

  def lookup4(name: String,handler: Handler[AsyncResult[String]]):DnsClient = {
    DnsClient(asJava.asInstanceOf[JDnsClient].lookup4(name,handler))
    this
  }

  def lookup6(name: String,handler: Handler[AsyncResult[String]]):DnsClient = {
    DnsClient(asJava.asInstanceOf[JDnsClient].lookup6(name,handler))
    this
  }

  def resolveA(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    DnsClient(asJava.asInstanceOf[JDnsClient].resolveA(name,handler))
    this
  }

  def resolveAAAA(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    DnsClient(asJava.asInstanceOf[JDnsClient].resolveAAAA(name,handler))
    this
  }

  def resolveCNAME(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    DnsClient(asJava.asInstanceOf[JDnsClient].resolveCNAME(name,handler))
    this
  }

  def resolveMX(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[MxRecord]]]):DnsClient = {
    DnsClient(asJava.asInstanceOf[JDnsClient].resolveMX(name,handler))
    this
  }

  def resolveTXT(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    DnsClient(asJava.asInstanceOf[JDnsClient].resolveTXT(name,handler))
    this
  }

  def resolvePTR(name: String,handler: Handler[AsyncResult[String]]):DnsClient = {
    DnsClient(asJava.asInstanceOf[JDnsClient].resolvePTR(name,handler))
    this
  }

  def resolveNS(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    DnsClient(asJava.asInstanceOf[JDnsClient].resolveNS(name,handler))
    this
  }

  def resolveSRV(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[SrvRecord]]]):DnsClient = {
    DnsClient(asJava.asInstanceOf[JDnsClient].resolveSRV(name,handler))
    this
  }

  def reverseLookup(ipaddress: String,handler: Handler[AsyncResult[String]]):DnsClient = {
    DnsClient(asJava.asInstanceOf[JDnsClient].reverseLookup(ipaddress,handler))
    this
  }

//basic methods
}

object DnsClient{
  def apply(asJava: JDnsClient) = new DnsClient(asJava)//static methods
}
