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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
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
    asJava.asInstanceOf[JDnsClient].lookup(name.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  def lookup4(name: String,handler: Handler[AsyncResult[String]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].lookup4(name.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  def lookup6(name: String,handler: Handler[AsyncResult[String]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].lookup6(name.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  def resolveA(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveA(name.asInstanceOf[java.lang.String],{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  def resolveAAAA(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveAAAA(name.asInstanceOf[java.lang.String],{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  def resolveCNAME(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveCNAME(name.asInstanceOf[java.lang.String],{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  def resolveMX(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[MxRecord]]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveMX(name.asInstanceOf[java.lang.String],{x: AsyncResult[java.util.List[JMxRecord]] => handler.handle(AsyncResultWrapper[java.util.List[JMxRecord],scala.collection.mutable.Buffer[MxRecord]](x, a => a.asScala.map(x => MxRecord(x))))})
    this
  }

  def resolveTXT(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveTXT(name.asInstanceOf[java.lang.String],{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  def resolvePTR(name: String,handler: Handler[AsyncResult[String]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolvePTR(name.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  def resolveNS(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveNS(name.asInstanceOf[java.lang.String],{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  def resolveSRV(name: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[SrvRecord]]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveSRV(name.asInstanceOf[java.lang.String],{x: AsyncResult[java.util.List[JSrvRecord]] => handler.handle(AsyncResultWrapper[java.util.List[JSrvRecord],scala.collection.mutable.Buffer[SrvRecord]](x, a => a.asScala.map(x => SrvRecord(x))))})
    this
  }

  def reverseLookup(ipaddress: String,handler: Handler[AsyncResult[String]]):DnsClient = {
    asJava.asInstanceOf[JDnsClient].reverseLookup(ipaddress.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

//default methods
//basic methods
//future methods
  def lookupFuture(name: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => if (x == null) null.asInstanceOf[String] else x.asInstanceOf[String])
    asJava.asInstanceOf[JDnsClient].lookup(name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def lookup4Future(name: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => if (x == null) null.asInstanceOf[String] else x.asInstanceOf[String])
    asJava.asInstanceOf[JDnsClient].lookup4(name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def lookup6Future(name: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => if (x == null) null.asInstanceOf[String] else x.asInstanceOf[String])
    asJava.asInstanceOf[JDnsClient].lookup6(name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def resolveAFuture(name: String):scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => if (x == null) null.asInstanceOf[scala.collection.mutable.Buffer[String]] else x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].resolveA(name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def resolveAAAAFuture(name: String):scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => if (x == null) null.asInstanceOf[scala.collection.mutable.Buffer[String]] else x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].resolveAAAA(name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def resolveCNAMEFuture(name: String):scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => if (x == null) null.asInstanceOf[scala.collection.mutable.Buffer[String]] else x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].resolveCNAME(name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def resolveMXFuture(name: String):scala.concurrent.Future[scala.collection.mutable.Buffer[MxRecord]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JMxRecord], scala.collection.mutable.Buffer[MxRecord]](x => if (x == null) null.asInstanceOf[scala.collection.mutable.Buffer[MxRecord]] else x.asScala.map(x => MxRecord(x)))
    asJava.asInstanceOf[JDnsClient].resolveMX(name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def resolveTXTFuture(name: String):scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => if (x == null) null.asInstanceOf[scala.collection.mutable.Buffer[String]] else x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].resolveTXT(name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def resolvePTRFuture(name: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => if (x == null) null.asInstanceOf[String] else x.asInstanceOf[String])
    asJava.asInstanceOf[JDnsClient].resolvePTR(name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def resolveNSFuture(name: String):scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => if (x == null) null.asInstanceOf[scala.collection.mutable.Buffer[String]] else x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].resolveNS(name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def resolveSRVFuture(name: String):scala.concurrent.Future[scala.collection.mutable.Buffer[SrvRecord]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JSrvRecord], scala.collection.mutable.Buffer[SrvRecord]](x => if (x == null) null.asInstanceOf[scala.collection.mutable.Buffer[SrvRecord]] else x.asScala.map(x => SrvRecord(x)))
    asJava.asInstanceOf[JDnsClient].resolveSRV(name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def reverseLookupFuture(ipaddress: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => if (x == null) null.asInstanceOf[String] else x.asInstanceOf[String])
    asJava.asInstanceOf[JDnsClient].reverseLookup(ipaddress.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object DnsClient{
    def apply(asJava: JDnsClient) = new DnsClient(asJava)  
  //static methods
  }
