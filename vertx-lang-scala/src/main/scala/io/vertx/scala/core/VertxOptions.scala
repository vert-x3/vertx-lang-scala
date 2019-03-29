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

import io.vertx.core.metrics.{MetricsOptions => JMetricsOptions}
import io.vertx.scala.core.eventbus.EventBusOptions
import io.vertx.core.eventbus.{EventBusOptions => JEventBusOptions}
import io.vertx.scala.core.metrics.MetricsOptions
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import java.util.concurrent.TimeUnit
import io.vertx.core.dns.{AddressResolverOptions => JAddressResolverOptions}
import io.vertx.scala.core.file.FileSystemOptions
import io.vertx.core.file.{FileSystemOptions => JFileSystemOptions}
import io.vertx.core.json.JsonObject
import io.vertx.core.{VertxOptions => JVertxOptions}
import io.vertx.scala.core.dns.AddressResolverOptions

/**
 * Instances of this class are used to configure [[io.vertx.scala.core.Vertx]] instances.
 */

class VertxOptions(private val _asJava: JVertxOptions) {
  def asJava = _asJava
  /**
   * Sets the address resolver configuration to configure resolving DNS servers, cache TTL, etc...
   */
  def setAddressResolverOptions(value: AddressResolverOptions) = {
    asJava.setAddressResolverOptions(value.asJava)
    this
  }

  def getAddressResolverOptions: AddressResolverOptions = {
    AddressResolverOptions(asJava.getAddressResolverOptions())
  }

  /**
   * Sets the value of blocked thread check period, in <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a>.
   * 
   * The default value of <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a> is 
   */
  def setBlockedThreadCheckInterval(value: Long) = {
    asJava.setBlockedThreadCheckInterval(value)
    this
  }

  def getBlockedThreadCheckInterval: Long = {
    asJava.getBlockedThreadCheckInterval().asInstanceOf[Long]
  }

  /**
   * Set the time unit of `blockedThreadCheckInterval`.
   */
  def setBlockedThreadCheckIntervalUnit(value: java.util.concurrent.TimeUnit) = {
    asJava.setBlockedThreadCheckIntervalUnit(value)
    this
  }

  def getBlockedThreadCheckIntervalUnit: java.util.concurrent.TimeUnit = {
    asJava.getBlockedThreadCheckIntervalUnit()
  }

  /**
   * Set the hostname to be used for clustering.
   */
  def setClusterHost(value: String) = {
    asJava.setClusterHost(value)
    this
  }

  def getClusterHost: String = {
    asJava.getClusterHost().asInstanceOf[String]
  }

  /**
   * Set the value of cluster ping interval, in ms.
   */
  def setClusterPingInterval(value: Long) = {
    asJava.setClusterPingInterval(value)
    this
  }

  def getClusterPingInterval: Long = {
    asJava.getClusterPingInterval().asInstanceOf[Long]
  }

  /**
   * Set the value of cluster ping reply interval, in ms.
   */
  def setClusterPingReplyInterval(value: Long) = {
    asJava.setClusterPingReplyInterval(value)
    this
  }

  def getClusterPingReplyInterval: Long = {
    asJava.getClusterPingReplyInterval().asInstanceOf[Long]
  }

  /**
   * Set the port to be used for clustering.
   */
  def setClusterPort(value: Int) = {
    asJava.setClusterPort(value)
    this
  }

  def getClusterPort: Int = {
    asJava.getClusterPort().asInstanceOf[Int]
  }

  /**
   * Set the public facing hostname to be used for clustering.
   * Sometimes, e.g. when running on certain clouds, the local address the server listens on for clustering is not the same
   * address that other nodes connect to it at, as the OS / cloud infrastructure does some kind of proxying.
   * If this is the case you can specify a public hostname which is different from the hostname the server listens at.
   * The default value is null which means use the same as the cluster hostname.
   */
  def setClusterPublicHost(value: String) = {
    asJava.setClusterPublicHost(value)
    this
  }

  def getClusterPublicHost: String = {
    asJava.getClusterPublicHost().asInstanceOf[String]
  }

  /**
   * See <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a> for an explanation.
   */
  def setClusterPublicPort(value: Int) = {
    asJava.setClusterPublicPort(value)
    this
  }

  def getClusterPublicPort: Int = {
    asJava.getClusterPublicPort().asInstanceOf[Int]
  }

  /**
   * Set whether or not the Vert.x instance will be clustered.
   */
  def setClustered(value: Boolean) = {
    asJava.setClustered(value)
    this
  }

  def isClustered: Boolean = {
    asJava.isClustered().asInstanceOf[Boolean]
  }

  /**
   * Sets the event bus configuration to configure the host, port, ssl...
   */
  def setEventBusOptions(value: EventBusOptions) = {
    asJava.setEventBusOptions(value.asJava)
    this
  }

  def getEventBusOptions: EventBusOptions = {
    EventBusOptions(asJava.getEventBusOptions())
  }

  /**
   * Set the number of event loop threads to be used by the Vert.x instance.
   */
  def setEventLoopPoolSize(value: Int) = {
    asJava.setEventLoopPoolSize(value)
    this
  }

  def getEventLoopPoolSize: Int = {
    asJava.getEventLoopPoolSize().asInstanceOf[Int]
  }

  /**
   * Set whether the Vert.x file resolver uses caching for classpath resources.
   */
  def setFileResolverCachingEnabled(value: Boolean) = {
    asJava.setFileResolverCachingEnabled(value)
    this
  }

  def isFileResolverCachingEnabled: Boolean = {
    asJava.isFileResolverCachingEnabled().asInstanceOf[Boolean]
  }

  /**
   * Set the file system options
   */
  def setFileSystemOptions(value: FileSystemOptions) = {
    asJava.setFileSystemOptions(value.asJava)
    this
  }

  def getFileSystemOptions: FileSystemOptions = {
    FileSystemOptions(asJava.getFileSystemOptions())
  }

  /**
   * Set whether HA will be enabled on the Vert.x instance.
   */
  def setHAEnabled(value: Boolean) = {
    asJava.setHAEnabled(value)
    this
  }

  def isHAEnabled: Boolean = {
    asJava.isHAEnabled().asInstanceOf[Boolean]
  }

  /**
   * Set the HA group to be used when HA is enabled.
   */
  def setHAGroup(value: String) = {
    asJava.setHAGroup(value)
    this
  }

  def getHAGroup: String = {
    asJava.getHAGroup().asInstanceOf[String]
  }

  /**
   * Set the value of internal blocking pool size
   */
  def setInternalBlockingPoolSize(value: Int) = {
    asJava.setInternalBlockingPoolSize(value)
    this
  }

  def getInternalBlockingPoolSize: Int = {
    asJava.getInternalBlockingPoolSize().asInstanceOf[Int]
  }

  /**
   * Sets the value of max event loop execute time, in <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a>.
   * 
   * The default value of <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a>is 
   */
  def setMaxEventLoopExecuteTime(value: Long) = {
    asJava.setMaxEventLoopExecuteTime(value)
    this
  }

  def getMaxEventLoopExecuteTime: Long = {
    asJava.getMaxEventLoopExecuteTime().asInstanceOf[Long]
  }

  /**
   * Set the time unit of `maxEventLoopExecuteTime`.
   */
  def setMaxEventLoopExecuteTimeUnit(value: java.util.concurrent.TimeUnit) = {
    asJava.setMaxEventLoopExecuteTimeUnit(value)
    this
  }

  def getMaxEventLoopExecuteTimeUnit: java.util.concurrent.TimeUnit = {
    asJava.getMaxEventLoopExecuteTimeUnit()
  }

  /**
   * Sets the value of max worker execute time, in <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a>.
   * 
   * The default value of <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a> is 
   */
  def setMaxWorkerExecuteTime(value: Long) = {
    asJava.setMaxWorkerExecuteTime(value)
    this
  }

  def getMaxWorkerExecuteTime: Long = {
    asJava.getMaxWorkerExecuteTime().asInstanceOf[Long]
  }

  /**
   * Set the time unit of `maxWorkerExecuteTime`.
   */
  def setMaxWorkerExecuteTimeUnit(value: java.util.concurrent.TimeUnit) = {
    asJava.setMaxWorkerExecuteTimeUnit(value)
    this
  }

  def getMaxWorkerExecuteTimeUnit: java.util.concurrent.TimeUnit = {
    asJava.getMaxWorkerExecuteTimeUnit()
  }

  /**
   * Set the metrics options
   */
  def setMetricsOptions(value: MetricsOptions) = {
    asJava.setMetricsOptions(value.asJava)
    this
  }

  def getMetricsOptions: MetricsOptions = {
    MetricsOptions(asJava.getMetricsOptions())
  }

  /**
   * Set wether to prefer the native transport to the JDK transport.
   */
  def setPreferNativeTransport(value: Boolean) = {
    asJava.setPreferNativeTransport(value)
    this
  }

  def getPreferNativeTransport: Boolean = {
    asJava.getPreferNativeTransport().asInstanceOf[Boolean]
  }

  /**
   * Set the quorum size to be used when HA is enabled.
   */
  def setQuorumSize(value: Int) = {
    asJava.setQuorumSize(value)
    this
  }

  def getQuorumSize: Int = {
    asJava.getQuorumSize().asInstanceOf[Int]
  }

  /**
   * Set the threshold value above this, the blocked warning contains a stack trace. in <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a>.
   * The default value of <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a> is 
   */
  def setWarningExceptionTime(value: Long) = {
    asJava.setWarningExceptionTime(value)
    this
  }

  def getWarningExceptionTime: Long = {
    asJava.getWarningExceptionTime().asInstanceOf[Long]
  }

  /**
   * Set the time unit of `warningExceptionTime`.
   */
  def setWarningExceptionTimeUnit(value: java.util.concurrent.TimeUnit) = {
    asJava.setWarningExceptionTimeUnit(value)
    this
  }

  def getWarningExceptionTimeUnit: java.util.concurrent.TimeUnit = {
    asJava.getWarningExceptionTimeUnit()
  }

  /**
   * Set the maximum number of worker threads to be used by the Vert.x instance.
   */
  def setWorkerPoolSize(value: Int) = {
    asJava.setWorkerPoolSize(value)
    this
  }

  def getWorkerPoolSize: Int = {
    asJava.getWorkerPoolSize().asInstanceOf[Int]
  }

}


object VertxOptions {
  
  def apply() = {
    new VertxOptions(new JVertxOptions(emptyObj()))
  }
  
  def apply(t: JVertxOptions) = {
    if (t != null) {
      new VertxOptions(t)
    } else {
      new VertxOptions(new JVertxOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): VertxOptions = {
    if (json != null) {
      new VertxOptions(new JVertxOptions(json))
    } else {
      new VertxOptions(new JVertxOptions(emptyObj()))
    }
  }
}

