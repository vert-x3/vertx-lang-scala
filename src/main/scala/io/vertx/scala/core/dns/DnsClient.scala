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

package io.vertx.scala.core.dns;

import scala.util.Try
import io.vertx.core.Handler

class DnsClient(private val _asJava: io.vertx.core.dns.DnsClient) {

  def asJava: java.lang.Object = _asJava

  def lookup(name: String)(handler: Try[String] => Unit): io.vertx.scala.core.dns.DnsClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.lookup(name, funcToAsyncResultHandler[java.lang.String](handler))
    this
  }

  def lookup4(name: String)(handler: Try[String] => Unit): io.vertx.scala.core.dns.DnsClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.lookup4(name, funcToAsyncResultHandler[java.lang.String](handler))
    this
  }

  def lookup6(name: String)(handler: Try[String] => Unit): io.vertx.scala.core.dns.DnsClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.lookup6(name, funcToAsyncResultHandler[java.lang.String](handler))
    this
  }

  def resolveA(name: String)(handler: Try[List[String]] => Unit): io.vertx.scala.core.dns.DnsClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.resolveA(name, funcToMappedAsyncResultHandler[java.util.List[java.lang.String], List[String]](x => x.asScala.toList)(handler))
    this
  }

  def resolveAAAA(name: String)(handler: Try[List[String]] => Unit): io.vertx.scala.core.dns.DnsClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.resolveAAAA(name, funcToMappedAsyncResultHandler[java.util.List[java.lang.String], List[String]](x => x.asScala.toList)(handler))
    this
  }

  def resolveCNAME(name: String)(handler: Try[List[String]] => Unit): io.vertx.scala.core.dns.DnsClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.resolveCNAME(name, funcToMappedAsyncResultHandler[java.util.List[java.lang.String], List[String]](x => x.asScala.toList)(handler))
    this
  }

  def resolveMX(name: String)(handler: Try[List[io.vertx.scala.core.dns.MxRecord]] => Unit): io.vertx.scala.core.dns.DnsClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.resolveMX(name, funcToMappedAsyncResultHandler[java.util.List[io.vertx.core.dns.MxRecord], List[io.vertx.scala.core.dns.MxRecord]](x => x.asScala.map(MxRecord.apply).toList)(handler))
    this
  }

  def resolveTXT(name: String)(handler: Try[List[String]] => Unit): io.vertx.scala.core.dns.DnsClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.resolveTXT(name, funcToMappedAsyncResultHandler[java.util.List[java.lang.String], List[String]](x => x.asScala.toList)(handler))
    this
  }

  def resolvePTR(name: String)(handler: Try[String] => Unit): io.vertx.scala.core.dns.DnsClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.resolvePTR(name, funcToAsyncResultHandler[java.lang.String](handler))
    this
  }

  def resolveNS(name: String)(handler: Try[List[String]] => Unit): io.vertx.scala.core.dns.DnsClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.resolveNS(name, funcToMappedAsyncResultHandler[java.util.List[java.lang.String], List[String]](x => x.asScala.toList)(handler))
    this
  }

  def resolveSRV(name: String)(handler: Try[List[io.vertx.scala.core.dns.SrvRecord]] => Unit): io.vertx.scala.core.dns.DnsClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.resolveSRV(name, funcToMappedAsyncResultHandler[java.util.List[io.vertx.core.dns.SrvRecord], List[io.vertx.scala.core.dns.SrvRecord]](x => x.asScala.map(SrvRecord.apply).toList)(handler))
    this
  }

  def reverseLookup(ipaddress: String)(handler: Try[String] => Unit): io.vertx.scala.core.dns.DnsClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.reverseLookup(ipaddress, funcToAsyncResultHandler[java.lang.String](handler))
    this
  }

}

object DnsClient {

  def apply(_asJava: io.vertx.core.dns.DnsClient): io.vertx.scala.core.dns.DnsClient =
    new io.vertx.scala.core.dns.DnsClient(_asJava)
}
