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

package io.vertx.scala.core

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Instances of this class are used to configure [[io.vertx.scala.core.Vertx]] instances.
  */

class VertxOptions(val asJava: io.vertx.core.VertxOptions) {

  /**
    * Sets the address resolver configuration to configure resolving DNS servers, cache TTL, etc...
    */
  def setAddressResolverOptions(value:io.vertx.scala.core.dns.AddressResolverOptions) = {
    asJava.setAddressResolverOptions(value.asJava)
    this
  }
  def getAddressResolverOptions = {
    asJava.getAddressResolverOptions()
  }

  /**
    * Sets the value of blocked thread check period, in ms.
    */
  def setBlockedThreadCheckInterval(value:Long) = {
    asJava.setBlockedThreadCheckInterval(value)
    this
  }
  def getBlockedThreadCheckInterval = {
    asJava.getBlockedThreadCheckInterval()
  }

  /**
    * Set the hostname to be used for clustering.
    */
  def setClusterHost(value:String) = {
    asJava.setClusterHost(value)
    this
  }
  def getClusterHost = {
    asJava.getClusterHost()
  }

  /**
    * Set the value of cluster ping interval, in ms.
    */
  def setClusterPingInterval(value:Long) = {
    asJava.setClusterPingInterval(value)
    this
  }
  def getClusterPingInterval = {
    asJava.getClusterPingInterval()
  }

  /**
    * Set the value of cluster ping reply interval, in ms.
    */
  def setClusterPingReplyInterval(value:Long) = {
    asJava.setClusterPingReplyInterval(value)
    this
  }
  def getClusterPingReplyInterval = {
    asJava.getClusterPingReplyInterval()
  }

  /**
    * Set the port to be used for clustering.
    */
  def setClusterPort(value:Int) = {
    asJava.setClusterPort(value)
    this
  }
  def getClusterPort = {
    asJava.getClusterPort()
  }

  /**
    * Set the public facing hostname to be used for clustering.
    * Sometimes, e.g. when running on certain clouds, the local address the server listens on for clustering is not the same
    * address that other nodes connect to it at, as the OS / cloud infrastructure does some kind of proxying.
    * If this is the case you can specify a public hostname which is different from the hostname the server listens at.
    * The default value is null which means use the same as the cluster hostname.
    */
  def setClusterPublicHost(value:String) = {
    asJava.setClusterPublicHost(value)
    this
  }
  def getClusterPublicHost = {
    asJava.getClusterPublicHost()
  }

  /**
    * See <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a> for an explanation.
    */
  def setClusterPublicPort(value:Int) = {
    asJava.setClusterPublicPort(value)
    this
  }
  def getClusterPublicPort = {
    asJava.getClusterPublicPort()
  }

  /**
    * Set whether or not the Vert.x instance will be clustered.
    */
  def setClustered(value:Boolean) = {
    asJava.setClustered(value)
    this
  }
  def isClustered = {
    asJava.isClustered()
  }

  /**
    * Sets the event bus configuration to configure the host, port, ssl...
    */
  def setEventBusOptions(value:io.vertx.scala.core.eventbus.EventBusOptions) = {
    asJava.setEventBusOptions(value.asJava)
    this
  }
  def getEventBusOptions = {
    asJava.getEventBusOptions()
  }

  /**
    * Set the number of event loop threads to be used by the Vert.x instance.
    */
  def setEventLoopPoolSize(value:Int) = {
    asJava.setEventLoopPoolSize(value)
    this
  }
  def getEventLoopPoolSize = {
    asJava.getEventLoopPoolSize()
  }

  /**
    * Set whether HA will be enabled on the Vert.x instance.
    */
  def setHAEnabled(value:Boolean) = {
    asJava.setHAEnabled(value)
    this
  }
  def isHAEnabled = {
    asJava.isHAEnabled()
  }

  /**
    * Set the HA group to be used when HA is enabled.
    */
  def setHAGroup(value:String) = {
    asJava.setHAGroup(value)
    this
  }
  def getHAGroup = {
    asJava.getHAGroup()
  }

  /**
    * Set the value of internal blocking pool size
    */
  def setInternalBlockingPoolSize(value:Int) = {
    asJava.setInternalBlockingPoolSize(value)
    this
  }
  def getInternalBlockingPoolSize = {
    asJava.getInternalBlockingPoolSize()
  }

  /**
    * Sets the value of max event loop execute time, in ns.
    */
  def setMaxEventLoopExecuteTime(value:Long) = {
    asJava.setMaxEventLoopExecuteTime(value)
    this
  }
  def getMaxEventLoopExecuteTime = {
    asJava.getMaxEventLoopExecuteTime()
  }

  /**
    * Sets the value of max worker execute time, in ns.
    */
  def setMaxWorkerExecuteTime(value:Long) = {
    asJava.setMaxWorkerExecuteTime(value)
    this
  }
  def getMaxWorkerExecuteTime = {
    asJava.getMaxWorkerExecuteTime()
  }

  /**
    * Set the metrics options
    */
  def setMetricsOptions(value:io.vertx.scala.core.metrics.MetricsOptions) = {
    asJava.setMetricsOptions(value.asJava)
    this
  }
  def getMetricsOptions = {
    asJava.getMetricsOptions()
  }

  /**
    * Set the quorum size to be used when HA is enabled.
    */
  def setQuorumSize(value:Int) = {
    asJava.setQuorumSize(value)
    this
  }
  def getQuorumSize = {
    asJava.getQuorumSize()
  }

  /**
    * Set the threshold value above this, the blocked warning contains a stack trace.
    */
  def setWarningExceptionTime(value:Long) = {
    asJava.setWarningExceptionTime(value)
    this
  }
  def getWarningExceptionTime = {
    asJava.getWarningExceptionTime()
  }

  /**
    * Set the maximum number of worker threads to be used by the Vert.x instance.
    */
  def setWorkerPoolSize(value:Int) = {
    asJava.setWorkerPoolSize(value)
    this
  }
  def getWorkerPoolSize = {
    asJava.getWorkerPoolSize()
  }
}

object VertxOptions {
  type VertxOptionsJava = io.vertx.core.VertxOptions
  
  def apply() = {
    new VertxOptions(new VertxOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
   
  }
  
  def apply(t: VertxOptionsJava) = {
    if(t != null)
      new VertxOptions(t)
    else
      null
   
  }
  
  def fromJson(json: JsonObject):VertxOptions = {
    if(json != null)
      new VertxOptions(new VertxOptionsJava(json))
    else
      null
  }
}
