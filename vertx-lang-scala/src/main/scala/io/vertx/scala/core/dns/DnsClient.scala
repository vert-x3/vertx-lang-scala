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

import io.vertx.lang.scala.AsyncResultWrapper
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

//cached methods
//fluent methods
  def lookup(name: String,handler: Handler[AsyncResult[String]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].lookup(name,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a))})
    this
  }

  def lookup4(name: String,handler: Handler[AsyncResult[String]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].lookup4(name,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a))})
    this
  }

  def lookup6(name: String,handler: Handler[AsyncResult[String]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].lookup6(name,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a))})
    this
  }

  def resolveA(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveA(name,{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x)))})
    this
  }

  def resolveAAAA(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveAAAA(name,{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x)))})
    this
  }

  def resolveCNAME(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveCNAME(name,{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x)))})
    this
  }

  def resolveMX(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[MxRecord]]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveMX(name,{x: AsyncResult[java.util.List[JMxRecord]] => handler.handle(AsyncResultWrapper[java.util.List[JMxRecord],scala.collection.mutable.Buffer[MxRecord]](x, a => a.asScala.map(x => MxRecord(x))))})
    this
  }

  def resolveTXT(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveTXT(name,{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x)))})
    this
  }

  def resolvePTR(name: String,handler: Handler[AsyncResult[String]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolvePTR(name,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a))})
    this
  }

  def resolveNS(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveNS(name,{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x)))})
    this
  }

  def resolveSRV(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[SrvRecord]]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveSRV(name,{x: AsyncResult[java.util.List[JSrvRecord]] => handler.handle(AsyncResultWrapper[java.util.List[JSrvRecord],scala.collection.mutable.Buffer[SrvRecord]](x, a => a.asScala.map(x => SrvRecord(x))))})
    this
  }

  def reverseLookup(ipaddress: String,handler: Handler[AsyncResult[String]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].reverseLookup(ipaddress,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a))})
    this
  }

//basic methods
}

object DnsClient{
  def apply(asJava: JDnsClient) = new DnsClient(asJava)
//static methods
}
