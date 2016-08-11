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
  def setAddressResolverOptions(value:io.vertx.scala.core.dns.AddressResolverOptions) = {
    asJava.setAddressResolverOptions(value.asJava)
    this
  }
  def getAddressResolverOptions = {
    asJava.getAddressResolverOptions()
  }
  def setBlockedThreadCheckInterval(value:Long) = {
    asJava.setBlockedThreadCheckInterval(value)
    this
  }
  def getBlockedThreadCheckInterval = {
    asJava.getBlockedThreadCheckInterval()
  }
  def setClusterHost(value:String) = {
    asJava.setClusterHost(value)
    this
  }
  def getClusterHost = {
    asJava.getClusterHost()
  }
  def setClusterPingInterval(value:Long) = {
    asJava.setClusterPingInterval(value)
    this
  }
  def getClusterPingInterval = {
    asJava.getClusterPingInterval()
  }
  def setClusterPingReplyInterval(value:Long) = {
    asJava.setClusterPingReplyInterval(value)
    this
  }
  def getClusterPingReplyInterval = {
    asJava.getClusterPingReplyInterval()
  }
  def setClusterPort(value:Int) = {
    asJava.setClusterPort(value)
    this
  }
  def getClusterPort = {
    asJava.getClusterPort()
  }
  def setClusterPublicHost(value:String) = {
    asJava.setClusterPublicHost(value)
    this
  }
  def getClusterPublicHost = {
    asJava.getClusterPublicHost()
  }
  def setClusterPublicPort(value:Int) = {
    asJava.setClusterPublicPort(value)
    this
  }
  def getClusterPublicPort = {
    asJava.getClusterPublicPort()
  }
  def setClustered(value:Boolean) = {
    asJava.setClustered(value)
    this
  }
  def isClustered = {
    asJava.isClustered()
  }
  def setEventBusOptions(value:io.vertx.scala.core.eventbus.EventBusOptions) = {
    asJava.setEventBusOptions(value.asJava)
    this
  }
  def getEventBusOptions = {
    asJava.getEventBusOptions()
  }
  def setEventLoopPoolSize(value:Int) = {
    asJava.setEventLoopPoolSize(value)
    this
  }
  def getEventLoopPoolSize = {
    asJava.getEventLoopPoolSize()
  }
  def setHAEnabled(value:Boolean) = {
    asJava.setHAEnabled(value)
    this
  }
  def isHAEnabled = {
    asJava.isHAEnabled()
  }
  def setHAGroup(value:String) = {
    asJava.setHAGroup(value)
    this
  }
  def getHAGroup = {
    asJava.getHAGroup()
  }
  def setInternalBlockingPoolSize(value:Int) = {
    asJava.setInternalBlockingPoolSize(value)
    this
  }
  def getInternalBlockingPoolSize = {
    asJava.getInternalBlockingPoolSize()
  }
  def setMaxEventLoopExecuteTime(value:Long) = {
    asJava.setMaxEventLoopExecuteTime(value)
    this
  }
  def getMaxEventLoopExecuteTime = {
    asJava.getMaxEventLoopExecuteTime()
  }
  def setMaxWorkerExecuteTime(value:Long) = {
    asJava.setMaxWorkerExecuteTime(value)
    this
  }
  def getMaxWorkerExecuteTime = {
    asJava.getMaxWorkerExecuteTime()
  }
  def setMetricsOptions(value:io.vertx.scala.core.metrics.MetricsOptions) = {
    asJava.setMetricsOptions(value.asJava)
    this
  }
  def getMetricsOptions = {
    asJava.getMetricsOptions()
  }
  def setQuorumSize(value:Int) = {
    asJava.setQuorumSize(value)
    this
  }
  def getQuorumSize = {
    asJava.getQuorumSize()
  }
  def setWarningExceptionTime(value:Long) = {
    asJava.setWarningExceptionTime(value)
    this
  }
  def getWarningExceptionTime = {
    asJava.getWarningExceptionTime()
  }
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
