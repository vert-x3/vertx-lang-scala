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

package io.vertx.scala.core.net

import java.util.concurrent.TimeUnit
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{ClientOptionsBase => JClientOptionsBase}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.scala.core.net.{TCPSSLOptions => ExtTCPSSLOptions}

/**
 * Base class for Client options
 */

abstract class ClientOptionsBase(private val _asJava: JClientOptionsBase) extends ExtTCPSSLOptions(_asJava) {

  /**
   * Set the connect timeout
   */
  def setConnectTimeout(value: Int): ClientOptionsBase

  def getConnectTimeout: Int

  /**
   * Set the local interface to bind for network connections. When the local address is null,
   * it will pick any local address, the default local address is null.
   */
  def setLocalAddress(value: String): ClientOptionsBase

  def getLocalAddress: String

  /**
   * Set the metrics name identifying the reported metrics, useful for grouping metrics
   * with the same name.
   */
  def setMetricsName(value: String): ClientOptionsBase

  def getMetricsName: String

  /**
   * Set proxy options for connections via CONNECT proxy (e.g. Squid) or a SOCKS proxy.
   */
  def setProxyOptions(value: ProxyOptions): ClientOptionsBase

  def getProxyOptions: ProxyOptions

  /**
   * Set whether all server certificates should be trusted
   */
  def setTrustAll(value: Boolean): ClientOptionsBase

  def isTrustAll: Boolean

}
