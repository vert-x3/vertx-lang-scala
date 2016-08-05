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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.Handler

/**
  * Provides a way to asynchronously lookup information from DNS servers.
  * 
  * Please consult the documentation for more information on DNS clients.
  */
class DnsClient(private val _asJava: io.vertx.core.dns.DnsClient) {

  def asJava: io.vertx.core.dns.DnsClient = _asJava

  /**
    * Try to lookup the A (ipv4) or AAAA (ipv6) record for the given name. The first found will be used.
    * @param name the name to resolve
    * @param handler the scala-function to notify with the [[io.vertx.scala.core.AsyncResult]]. The handler will get notified with the resolved address if a record was found. If non was found it will get notifed with `null`. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently
    */
  def lookup(name: String, handler: io.vertx.core.AsyncResult [String] => Unit): io.vertx.scala.core.dns.DnsClient = {
    _asJava.lookup(name, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.String], io.vertx.core.AsyncResult [String]](x => io.vertx.lang.scala.AsyncResult[java.lang.String, String](x,(x => x.asInstanceOf[String])))(handler))
    this
  }

  /**
    * Try to lookup the A (ipv4) record for the given name. The first found will be used.
    * @param name the name to resolve
    * @param handler the scala-function to notify with the [[io.vertx.scala.core.AsyncResult]]. The handler will get notified with the resolved [[java.net.Inet4Address]] if a record was found. If non was found it will get notifed with `null`. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently
    */
  def lookup4(name: String, handler: io.vertx.core.AsyncResult [String] => Unit): io.vertx.scala.core.dns.DnsClient = {
    _asJava.lookup4(name, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.String], io.vertx.core.AsyncResult [String]](x => io.vertx.lang.scala.AsyncResult[java.lang.String, String](x,(x => x.asInstanceOf[String])))(handler))
    this
  }

  /**
    * Try to lookup the AAAA (ipv6) record for the given name. The first found will be used.
    * @param name the name to resolve
    * @param handler the scala-function to notify with the [[AsyncResult]]. The handler will get notified with the resolved [[java.net.Inet6Address]] if a record was found. If non was found it will get notifed with `null`. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently
    */
  def lookup6(name: String, handler: io.vertx.core.AsyncResult [String] => Unit): io.vertx.scala.core.dns.DnsClient = {
    _asJava.lookup6(name, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.String], io.vertx.core.AsyncResult [String]](x => io.vertx.lang.scala.AsyncResult[java.lang.String, String](x,(x => x.asInstanceOf[String])))(handler))
    this
  }

  /**
    * Try to resolve all A (ipv4) records for the given name.
    * @param name the name to resolve
    * @param handler the scala-function to notify with the [[io.vertx.scala.core.AsyncResult]]. The handler will get notified with a [[scala.collection.immutable.List]] that contains all the resolved [[java.net.Inet4Address]]es. If none was found an empty [[scala.collection.immutable.List]] will be used. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently
    */
  def resolveA(name: String, handler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[String]] => Unit): io.vertx.scala.core.dns.DnsClient = {
    _asJava.resolveA(name, funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[String]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x,x => if (x == null) null else x.asScala))(handler))
    this
  }

  /**
    * Try to resolve all AAAA (ipv6) records for the given name.
    * @param name the name to resolve
    * @param handler the scala-function to notify with the [[io.vertx.scala.core.AsyncResult]]. The handler will get notified with a [[scala.collection.immutable.List]] that contains all the resolved [[java.net.Inet6Address]]es. If none was found an empty [[scala.collection.immutable.List]] will be used. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently
    */
  def resolveAAAA(name: String, handler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[String]] => Unit): io.vertx.scala.core.dns.DnsClient = {
    _asJava.resolveAAAA(name, funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[String]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x,x => if (x == null) null else x.asScala))(handler))
    this
  }

  /**
    * Try to resolve the CNAME record for the given name.
    * @param name the name to resolve the CNAME for
    * @param handler the scala-function to notify with the [[AsyncResult]]. The handler will get notified with the resolved [[String]] if a record was found. If none was found it will get notified with `null`. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently.
    */
  def resolveCNAME(name: String, handler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[String]] => Unit): io.vertx.scala.core.dns.DnsClient = {
    _asJava.resolveCNAME(name, funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[String]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x,x => if (x == null) null else x.asScala))(handler))
    this
  }

  /**
    * Try to resolve the MX records for the given name.
    * @param name the name for which the MX records should be resolved
    * @param handler the scala-function to notify with the [[io.vertx.scala.core.AsyncResult]]. The handler will get notified with a List that contains all resolved [[MxRecord]]s, sorted by their [[MxRecord#priority()]]. If non was found it will get notified with an empty [[scala.collection.immutable.List]]. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently.
    */
  def resolveMX(name: String, handler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[io.vertx.scala.core.dns.MxRecord]] => Unit): io.vertx.scala.core.dns.DnsClient = {
    _asJava.resolveMX(name, funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.dns.MxRecord]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[io.vertx.scala.core.dns.MxRecord]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[io.vertx.core.dns.MxRecord], scala.collection.mutable.Buffer[io.vertx.scala.core.dns.MxRecord]](x,x => if (x == null) null else x.asScala.map(MxRecord.apply)))(handler))
    this
  }

  /**
    * Try to resolve the TXT records for the given name.
    * @param name the name for which the TXT records should be resolved
    * @param handler the scala-function to notify with the [[AsyncResult]]. The handler will get notified with a List that contains all resolved [[String]]s. If none was found it will get notified with an empty [[scala.collection.immutable.List]]. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently.
    */
  def resolveTXT(name: String, handler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[String]] => Unit): io.vertx.scala.core.dns.DnsClient = {
    _asJava.resolveTXT(name, funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[String]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x,x => if (x == null) null else x.asScala))(handler))
    this
  }

  /**
    * Try to resolve the PTR record for the given name.
    * @param name the name to resolve the PTR for
    * @param handler the scala-function to notify with the [[AsyncResult]]. The handler will get notified with the resolved [[String]] if a record was found. If none was found it will get notified with `null`. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently.
    */
  def resolvePTR(name: String, handler: io.vertx.core.AsyncResult [String] => Unit): io.vertx.scala.core.dns.DnsClient = {
    _asJava.resolvePTR(name, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.String], io.vertx.core.AsyncResult [String]](x => io.vertx.lang.scala.AsyncResult[java.lang.String, String](x,(x => x.asInstanceOf[String])))(handler))
    this
  }

  /**
    * Try to resolve the NS records for the given name.
    * @param name the name for which the NS records should be resolved
    * @param handler the scala-function to notify with the [[AsyncResult]]. The handler will get notified with a List that contains all resolved [[String]]s. If none was found it will get notified with an empty [[scala.collection.immutable.List]]. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently.
    */
  def resolveNS(name: String, handler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[String]] => Unit): io.vertx.scala.core.dns.DnsClient = {
    _asJava.resolveNS(name, funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[String]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x,x => if (x == null) null else x.asScala))(handler))
    this
  }

  /**
    * Try to resolve the SRV records for the given name.
    * @param name the name for which the SRV records should be resolved
    * @param handler the scala-function to notify with the [[AsyncResult]]. The handler will get notified with a List that contains all resolved [[SrvRecord]]s. If none was found it will get notified with an empty [[scala.collection.immutable.List]]. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently.
    */
  def resolveSRV(name: String, handler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[io.vertx.scala.core.dns.SrvRecord]] => Unit): io.vertx.scala.core.dns.DnsClient = {
    _asJava.resolveSRV(name, funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.dns.SrvRecord]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[io.vertx.scala.core.dns.SrvRecord]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[io.vertx.core.dns.SrvRecord], scala.collection.mutable.Buffer[io.vertx.scala.core.dns.SrvRecord]](x,x => if (x == null) null else x.asScala.map(SrvRecord.apply)))(handler))
    this
  }

  /**
    * Try to do a reverse lookup of an IP address. This is basically the same as doing trying to resolve a PTR record
    * but allows you to just pass in the IP address and not a valid ptr query string.
    * @param ipaddress the IP address to resolve the PTR for
    * @param handler the scala-function to notify with the [[AsyncResult]]. The handler will get notified with the resolved [[String]] if a record was found. If none was found it will get notified with `null`. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently.
    */
  def reverseLookup(ipaddress: String, handler: io.vertx.core.AsyncResult [String] => Unit): io.vertx.scala.core.dns.DnsClient = {
    _asJava.reverseLookup(ipaddress, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.String], io.vertx.core.AsyncResult [String]](x => io.vertx.lang.scala.AsyncResult[java.lang.String, String](x,(x => x.asInstanceOf[String])))(handler))
    this
  }

}

object DnsClient {

  def apply(_asJava: io.vertx.core.dns.DnsClient): io.vertx.scala.core.dns.DnsClient =
    new io.vertx.scala.core.dns.DnsClient(_asJava)
}
