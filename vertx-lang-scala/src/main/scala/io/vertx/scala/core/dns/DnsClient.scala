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
import scala.reflect.runtime.universe._
import io.vertx.core.dns.{SrvRecord => JSrvRecord}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.core.dns.{MxRecord => JMxRecord}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Provides a way to asynchronously lookup information from DNS servers.
  * 
  * Please consult the documentation for more information on DNS clients.
  */

class DnsClient(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Try to lookup the A (ipv4) or AAAA (ipv6) record for the given name. The first found will be used.   * @param name the name to resolve
   * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with the resolved address if a record was found. If non was found it will get notifed with `null`. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently
   */
  
  def lookup(name: String, handler: Handler[AsyncResult[scala.Option[String]]]): DnsClient = {
    asJava.asInstanceOf[JDnsClient].lookup(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {handler.handle(AsyncResultWrapper[java.lang.String, scala.Option[String]](x, a => scala.Option(a.asInstanceOf[String])))}}))
    this
  }

  /**
   * Try to lookup the A (ipv4) record for the given name. The first found will be used.   * @param name the name to resolve
   * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with the resolved java.net.Inet4Address if a record was found. If non was found it will get notifed with `null`. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently
   */
  
  def lookup4(name: String, handler: Handler[AsyncResult[scala.Option[String]]]): DnsClient = {
    asJava.asInstanceOf[JDnsClient].lookup4(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {handler.handle(AsyncResultWrapper[java.lang.String, scala.Option[String]](x, a => scala.Option(a.asInstanceOf[String])))}}))
    this
  }

  /**
   * Try to lookup the AAAA (ipv6) record for the given name. The first found will be used.   * @param name the name to resolve
   * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with the resolved java.net.Inet6Address if a record was found. If non was found it will get notifed with `null`. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently
   */
  
  def lookup6(name: String, handler: Handler[AsyncResult[scala.Option[String]]]): DnsClient = {
    asJava.asInstanceOf[JDnsClient].lookup6(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {handler.handle(AsyncResultWrapper[java.lang.String, scala.Option[String]](x, a => scala.Option(a.asInstanceOf[String])))}}))
    this
  }

  /**
   * Try to resolve all A (ipv4) records for the given name.   * @param name the name to resolve
   * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with a scala.collection.immutable.List that contains all the resolved java.net.Inet4Addresses. If none was found an empty scala.collection.immutable.List will be used. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently
   */
  
  def resolveA(name: String, handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveA(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.String]]]{def handle(x: AsyncResult[java.util.List[java.lang.String]]) {handler.handle(AsyncResultWrapper[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))}}))
    this
  }

  /**
   * Try to resolve all AAAA (ipv6) records for the given name.   * @param name the name to resolve
   * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with a scala.collection.immutable.List that contains all the resolved java.net.Inet6Addresses. If none was found an empty scala.collection.immutable.List will be used. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently
   */
  
  def resolveAAAA(name: String, handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveAAAA(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.String]]]{def handle(x: AsyncResult[java.util.List[java.lang.String]]) {handler.handle(AsyncResultWrapper[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))}}))
    this
  }

  /**
   * Try to resolve the CNAME record for the given name.   * @param name the name to resolve the CNAME for
   * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with the resolved String if a record was found. If none was found it will get notified with `null`. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently.
   */
  
  def resolveCNAME(name: String, handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveCNAME(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.String]]]{def handle(x: AsyncResult[java.util.List[java.lang.String]]) {handler.handle(AsyncResultWrapper[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))}}))
    this
  }

  /**
   * Try to resolve the MX records for the given name.   * @param name the name for which the MX records should be resolved
   * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with a List that contains all resolved MxRecords, sorted by their MxRecord#priority(). If non was found it will get notified with an empty scala.collection.immutable.List. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently.
   */
  
  def resolveMX(name: String, handler: Handler[AsyncResult[scala.collection.mutable.Buffer[MxRecord]]]): DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveMX(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JMxRecord]]]{def handle(x: AsyncResult[java.util.List[JMxRecord]]) {handler.handle(AsyncResultWrapper[java.util.List[JMxRecord], scala.collection.mutable.Buffer[MxRecord]](x, a => a.asScala.map(x => MxRecord(x))))}}))
    this
  }

  /**
   * Try to resolve the TXT records for the given name.   * @param name the name for which the TXT records should be resolved
   * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with a List that contains all resolved Strings. If none was found it will get notified with an empty scala.collection.immutable.List. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently.
   */
  
  def resolveTXT(name: String, handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveTXT(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.String]]]{def handle(x: AsyncResult[java.util.List[java.lang.String]]) {handler.handle(AsyncResultWrapper[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))}}))
    this
  }

  /**
   * Try to resolve the PTR record for the given name.   * @param name the name to resolve the PTR for
   * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with the resolved String if a record was found. If none was found it will get notified with `null`. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently.
   */
  
  def resolvePTR(name: String, handler: Handler[AsyncResult[scala.Option[String]]]): DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolvePTR(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {handler.handle(AsyncResultWrapper[java.lang.String, scala.Option[String]](x, a => scala.Option(a.asInstanceOf[String])))}}))
    this
  }

  /**
   * Try to resolve the NS records for the given name.   * @param name the name for which the NS records should be resolved
   * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with a List that contains all resolved Strings. If none was found it will get notified with an empty scala.collection.immutable.List. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently.
   */
  
  def resolveNS(name: String, handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveNS(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.String]]]{def handle(x: AsyncResult[java.util.List[java.lang.String]]) {handler.handle(AsyncResultWrapper[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))}}))
    this
  }

  /**
   * Try to resolve the SRV records for the given name.   * @param name the name for which the SRV records should be resolved
   * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with a List that contains all resolved SrvRecords. If none was found it will get notified with an empty scala.collection.immutable.List. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently.
   */
  
  def resolveSRV(name: String, handler: Handler[AsyncResult[scala.collection.mutable.Buffer[SrvRecord]]]): DnsClient = {
    asJava.asInstanceOf[JDnsClient].resolveSRV(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JSrvRecord]]]{def handle(x: AsyncResult[java.util.List[JSrvRecord]]) {handler.handle(AsyncResultWrapper[java.util.List[JSrvRecord], scala.collection.mutable.Buffer[SrvRecord]](x, a => a.asScala.map(x => SrvRecord(x))))}}))
    this
  }

  /**
   * Try to do a reverse lookup of an IP address. This is basically the same as doing trying to resolve a PTR record
   * but allows you to just pass in the IP address and not a valid ptr query string.   * @param ipaddress the IP address to resolve the PTR for
   * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with the resolved String if a record was found. If none was found it will get notified with `null`. If an error accours it will get failed.
   * @return a reference to this, so the API can be used fluently.
   */
  
  def reverseLookup(ipaddress: String, handler: Handler[AsyncResult[scala.Option[String]]]): DnsClient = {
    asJava.asInstanceOf[JDnsClient].reverseLookup(ipaddress.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {handler.handle(AsyncResultWrapper[java.lang.String, scala.Option[String]](x, a => scala.Option(a.asInstanceOf[String])))}}))
    this
  }




 /**
  * Like [[lookup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def lookupFuture (name: String): scala.concurrent.Future[scala.Option[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, scala.Option[String]](x => scala.Option(x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].lookup(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[lookup4]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def lookup4Future (name: String): scala.concurrent.Future[scala.Option[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, scala.Option[String]](x => scala.Option(x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].lookup4(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[lookup6]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def lookup6Future (name: String): scala.concurrent.Future[scala.Option[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, scala.Option[String]](x => scala.Option(x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].lookup6(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[resolveA]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def resolveAFuture (name: String): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].resolveA(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[resolveAAAA]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def resolveAAAAFuture (name: String): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].resolveAAAA(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[resolveCNAME]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def resolveCNAMEFuture (name: String): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].resolveCNAME(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[resolveMX]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def resolveMXFuture (name: String): scala.concurrent.Future[scala.collection.mutable.Buffer[MxRecord]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JMxRecord], scala.collection.mutable.Buffer[MxRecord]](x => x.asScala.map(x => MxRecord(x)))
    asJava.asInstanceOf[JDnsClient].resolveMX(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[resolveTXT]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def resolveTXTFuture (name: String): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].resolveTXT(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[resolvePTR]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def resolvePTRFuture (name: String): scala.concurrent.Future[scala.Option[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, scala.Option[String]](x => scala.Option(x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].resolvePTR(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[resolveNS]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def resolveNSFuture (name: String): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].resolveNS(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[resolveSRV]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def resolveSRVFuture (name: String): scala.concurrent.Future[scala.collection.mutable.Buffer[SrvRecord]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JSrvRecord], scala.collection.mutable.Buffer[SrvRecord]](x => x.asScala.map(x => SrvRecord(x)))
    asJava.asInstanceOf[JDnsClient].resolveSRV(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[reverseLookup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def reverseLookupFuture (ipaddress: String): scala.concurrent.Future[scala.Option[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, scala.Option[String]](x => scala.Option(x.asInstanceOf[String]))
    asJava.asInstanceOf[JDnsClient].reverseLookup(ipaddress.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object DnsClient {
  def apply(asJava: JDnsClient) = new DnsClient(asJava)

}
