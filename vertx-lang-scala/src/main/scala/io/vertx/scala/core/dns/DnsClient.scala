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

import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.dns.{DnsClient => JDnsClient}
import io.vertx.core.dns.{MxRecord => JMxRecord}
import io.vertx.core.dns.{SrvRecord => JSrvRecord}

/**
  * Provides a way to asynchronously lookup information from DNS servers.
  * 
  * Please consult the documentation for more information on DNS clients.
  */
class DnsClient(private val _asJava: Object) {

  def asJava: Object = _asJava

  /**
    * Try to lookup the A (ipv4) or AAAA (ipv6) record for the given name. The first found will be used.
    * @param name the name to resolve
    * @return the [[scala.concurrent.Future]] to complete with the io.vertx.lang.scala.AsyncResult. The future will get notified with the resolved address if a record was found. If non was found it will get notifed with `null`. If an error accours it will get failed.
    */
  def lookupFuture(name: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[String]((x => x.asInstanceOf))
    asJava.asInstanceOf[JDnsClient].lookup(name, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.String]]])
    promiseAndHandler._2.future
  }

  /**
    * Try to lookup the A (ipv4) record for the given name. The first found will be used.
    * @param name the name to resolve
    * @return the [[scala.concurrent.Future]] to complete with the io.vertx.lang.scala.AsyncResult. The future will get notified with the resolved java.net.Inet4Address if a record was found. If non was found it will get notifed with `null`. If an error accours it will get failed.
    */
  def lookup4Future(name: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[String]((x => x.asInstanceOf))
    asJava.asInstanceOf[JDnsClient].lookup4(name, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.String]]])
    promiseAndHandler._2.future
  }

  /**
    * Try to lookup the AAAA (ipv6) record for the given name. The first found will be used.
    * @param name the name to resolve
    * @return the [[scala.concurrent.Future]] to complete with the io.vertx.lang.scala.AsyncResult. The future will get notified with the resolved java.net.Inet6Address if a record was found. If non was found it will get notifed with `null`. If an error accours it will get failed.
    */
  def lookup6Future(name: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[String]((x => x.asInstanceOf))
    asJava.asInstanceOf[JDnsClient].lookup6(name, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.String]]])
    promiseAndHandler._2.future
  }

  /**
    * Try to resolve all A (ipv4) records for the given name.
    * @param name the name to resolve
    * @return the [[scala.concurrent.Future]] to complete with the io.vertx.lang.scala.AsyncResult. The future will get notified with a scala.collection.immutable.List that contains all the resolved java.net.Inet4Addresses. If none was found an empty scala.collection.immutable.List will be used. If an error accours it will get failed.
    */
  def resolveAFuture(name: String): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.String]].asScala))
    asJava.asInstanceOf[JDnsClient].resolveA(name, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  /**
    * Try to resolve all AAAA (ipv6) records for the given name.
    * @param name the name to resolve
    * @return the [[scala.concurrent.Future]] to complete with the io.vertx.lang.scala.AsyncResult. The future will get notified with a scala.collection.immutable.List that contains all the resolved java.net.Inet6Addresses. If none was found an empty scala.collection.immutable.List will be used. If an error accours it will get failed.
    */
  def resolveAAAAFuture(name: String): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.String]].asScala))
    asJava.asInstanceOf[JDnsClient].resolveAAAA(name, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  /**
    * Try to resolve the CNAME record for the given name.
    * @param name the name to resolve the CNAME for
    * @return the [[scala.concurrent.Future]] to complete with the io.vertx.lang.scala.AsyncResult. The future will get notified with the resolved String if a record was found. If none was found it will get notified with `null`. If an error accours it will get failed.
    */
  def resolveCNAMEFuture(name: String): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.String]].asScala))
    asJava.asInstanceOf[JDnsClient].resolveCNAME(name, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  /**
    * Try to resolve the MX records for the given name.
    * @param name the name for which the MX records should be resolved
    * @return the [[scala.concurrent.Future]] to complete with the io.vertx.lang.scala.AsyncResult. The future will get notified with a List that contains all resolved MxRecords, sorted by their MxRecord#priority(). If non was found it will get notified with an empty scala.collection.immutable.List. If an error accours it will get failed.
    */
  def resolveMXFuture(name: String): concurrent.Future[scala.collection.mutable.Buffer[MxRecord]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[MxRecord]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.core.dns.MxRecord]].asScala.map(MxRecord.apply)))
    asJava.asInstanceOf[JDnsClient].resolveMX(name, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.dns.MxRecord]]]])
    promiseAndHandler._2.future
  }

  /**
    * Try to resolve the TXT records for the given name.
    * @param name the name for which the TXT records should be resolved
    * @return the [[scala.concurrent.Future]] to complete with the io.vertx.lang.scala.AsyncResult. The future will get notified with a List that contains all resolved Strings. If none was found it will get notified with an empty scala.collection.immutable.List. If an error accours it will get failed.
    */
  def resolveTXTFuture(name: String): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.String]].asScala))
    asJava.asInstanceOf[JDnsClient].resolveTXT(name, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  /**
    * Try to resolve the PTR record for the given name.
    * @param name the name to resolve the PTR for
    * @return the [[scala.concurrent.Future]] to complete with the io.vertx.lang.scala.AsyncResult. The future will get notified with the resolved String if a record was found. If none was found it will get notified with `null`. If an error accours it will get failed.
    */
  def resolvePTRFuture(name: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[String]((x => x.asInstanceOf))
    asJava.asInstanceOf[JDnsClient].resolvePTR(name, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.String]]])
    promiseAndHandler._2.future
  }

  /**
    * Try to resolve the NS records for the given name.
    * @param name the name for which the NS records should be resolved
    * @return the [[scala.concurrent.Future]] to complete with the io.vertx.lang.scala.AsyncResult. The future will get notified with a List that contains all resolved Strings. If none was found it will get notified with an empty scala.collection.immutable.List. If an error accours it will get failed.
    */
  def resolveNSFuture(name: String): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.String]].asScala))
    asJava.asInstanceOf[JDnsClient].resolveNS(name, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  /**
    * Try to resolve the SRV records for the given name.
    * @param name the name for which the SRV records should be resolved
    * @return the [[scala.concurrent.Future]] to complete with the io.vertx.lang.scala.AsyncResult. The future will get notified with a List that contains all resolved SrvRecords. If none was found it will get notified with an empty scala.collection.immutable.List. If an error accours it will get failed.
    */
  def resolveSRVFuture(name: String): concurrent.Future[scala.collection.mutable.Buffer[SrvRecord]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[SrvRecord]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.core.dns.SrvRecord]].asScala.map(SrvRecord.apply)))
    asJava.asInstanceOf[JDnsClient].resolveSRV(name, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.dns.SrvRecord]]]])
    promiseAndHandler._2.future
  }

  /**
    * Try to do a reverse lookup of an IP address. This is basically the same as doing trying to resolve a PTR record
    * but allows you to just pass in the IP address and not a valid ptr query string.
    * @param ipaddress the IP address to resolve the PTR for
    * @return the [[scala.concurrent.Future]] to complete with the io.vertx.lang.scala.AsyncResult. The future will get notified with the resolved String if a record was found. If none was found it will get notified with `null`. If an error accours it will get failed.
    */
  def reverseLookupFuture(ipaddress: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[String]((x => x.asInstanceOf))
    asJava.asInstanceOf[JDnsClient].reverseLookup(ipaddress, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.String]]])
    promiseAndHandler._2.future
  }

}

object DnsClient {

  def apply(_asJava: Object): DnsClient =
    new DnsClient(_asJava)

}
