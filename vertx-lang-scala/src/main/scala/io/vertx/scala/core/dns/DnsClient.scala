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
import io.vertx.scala.core.dns.MxRecord
import io.vertx.core.dns.{MxRecord => JMxRecord}
import io.vertx.scala.core.dns.SrvRecord
import io.vertx.core.dns.{SrvRecord => JSrvRecord}

/**
  * Provides a way to asynchronously lookup information from DNS servers.
  * 
  * Please consult the documentation for more information on DNS clients.
  */
class DnsClient(private val _asJava: Object) {

def asJava = _asJava.asInstanceOf[JDnsClient]
//methods returning a future
//cached methods
//fluent methods
  def lookup(name: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[String]]):DnsClient = {
    asJava.lookup( )
    this
  }

  def lookup4(name: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[String]]):DnsClient = {
    asJava.lookup4( )
    this
  }

  def lookup6(name: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[String]]):DnsClient = {
    asJava.lookup6( )
    this
  }

  def resolveA(name: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.resolveA( )
    this
  }

  def resolveAAAA(name: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.resolveAAAA( )
    this
  }

  def resolveCNAME(name: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.resolveCNAME( )
    this
  }

  def resolveMX(name: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[scala.collection.mutable.Buffer[MxRecord]]]):DnsClient = {
    asJava.resolveMX( )
    this
  }

  def resolveTXT(name: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.resolveTXT( )
    this
  }

  def resolvePTR(name: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[String]]):DnsClient = {
    asJava.resolvePTR( )
    this
  }

  def resolveNS(name: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[scala.collection.mutable.Buffer[String]]]):DnsClient = {
    asJava.resolveNS( )
    this
  }

  def resolveSRV(name: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[scala.collection.mutable.Buffer[SrvRecord]]]):DnsClient = {
    asJava.resolveSRV( )
    this
  }

  def reverseLookup(ipaddress: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[String]]):DnsClient = {
    asJava.reverseLookup( )
    this
  }

//basic methods
}

object DnsClient{
//in object!
//static methods
}
