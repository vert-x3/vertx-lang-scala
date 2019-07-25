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

import io.vertx.core.net.{NetworkOptions => JNetworkOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**

 */

abstract class NetworkOptions(private val _asJava: JNetworkOptions) {

  /**
   * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
   */
  def setLogActivity(value: Boolean): NetworkOptions

  def getLogActivity: Boolean

  /**
   * Set the TCP receive buffer size
   */
  def setReceiveBufferSize(value: Int): NetworkOptions

  def getReceiveBufferSize: Int

  /**
   * Set the value of reuse address
   */
  def setReuseAddress(value: Boolean): NetworkOptions

  def isReuseAddress: Boolean

  /**
   * Set the value of reuse port.
   * <p/>
   * This is only supported by native transports.
   */
  def setReusePort(value: Boolean): NetworkOptions

  def isReusePort: Boolean

  /**
   * Set the TCP send buffer size
   */
  def setSendBufferSize(value: Int): NetworkOptions

  def getSendBufferSize: Int

  /**
   * Set the value of traffic class
   */
  def setTrafficClass(value: Int): NetworkOptions

  def getTrafficClass: Int

}
