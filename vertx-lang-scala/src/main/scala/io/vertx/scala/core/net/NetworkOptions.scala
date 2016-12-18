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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.net.{NetworkOptions => JNetworkOptions}

/**
  */
trait NetworkOptions {


  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
  def setLogActivity(value: Boolean):NetworkOptions

  /**
    * Set the TCP receive buffer size
    */
  def setReceiveBufferSize(value: Int):NetworkOptions

  /**
    * Set the value of reuse address
    */
  def setReuseAddress(value: Boolean):NetworkOptions

  /**
    * Set the TCP send buffer size
    */
  def setSendBufferSize(value: Int):NetworkOptions

  /**
    * Set the value of traffic class
    */
  def setTrafficClass(value: Int):NetworkOptions
}

