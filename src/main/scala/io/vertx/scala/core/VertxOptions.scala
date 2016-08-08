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

class VertxOptions(val java: io.vertx.core.VertxOptions) {
          def setAddressResolverOptions(value:io.vertx.scala.core.dns.AddressResolverOptions) = {
          java.setAddressResolverOptions(value.java)
          this
  }
            def getAddressResolverOptions = {
    java.getAddressResolverOptions()
  }
            def setBlockedThreadCheckInterval(value:Long) = {
          java.setBlockedThreadCheckInterval(value)
          this
  }
            def getBlockedThreadCheckInterval = {
    java.getBlockedThreadCheckInterval()
  }
            def setClusterHost(value:String) = {
          java.setClusterHost(value)
          this
  }
            def getClusterHost = {
    java.getClusterHost()
  }
            def setClusterPingInterval(value:Long) = {
          java.setClusterPingInterval(value)
          this
  }
            def getClusterPingInterval = {
    java.getClusterPingInterval()
  }
            def setClusterPingReplyInterval(value:Long) = {
          java.setClusterPingReplyInterval(value)
          this
  }
            def getClusterPingReplyInterval = {
    java.getClusterPingReplyInterval()
  }
            def setClusterPort(value:Int) = {
          java.setClusterPort(value)
          this
  }
            def getClusterPort = {
    java.getClusterPort()
  }
            def setClusterPublicHost(value:String) = {
          java.setClusterPublicHost(value)
          this
  }
            def getClusterPublicHost = {
    java.getClusterPublicHost()
  }
            def setClusterPublicPort(value:Int) = {
          java.setClusterPublicPort(value)
          this
  }
            def getClusterPublicPort = {
    java.getClusterPublicPort()
  }
            def setClustered(value:Boolean) = {
          java.setClustered(value)
          this
  }
            def isClustered = {
    java.isClustered()
  }
            def setEventBusOptions(value:io.vertx.scala.core.eventbus.EventBusOptions) = {
          java.setEventBusOptions(value.java)
          this
  }
            def getEventBusOptions = {
    java.getEventBusOptions()
  }
            def setEventLoopPoolSize(value:Int) = {
          java.setEventLoopPoolSize(value)
          this
  }
            def getEventLoopPoolSize = {
    java.getEventLoopPoolSize()
  }
            def setHAEnabled(value:Boolean) = {
          java.setHAEnabled(value)
          this
  }
            def isHAEnabled = {
    java.isHAEnabled()
  }
            def setHAGroup(value:String) = {
          java.setHAGroup(value)
          this
  }
            def getHAGroup = {
    java.getHAGroup()
  }
            def setInternalBlockingPoolSize(value:Int) = {
          java.setInternalBlockingPoolSize(value)
          this
  }
            def getInternalBlockingPoolSize = {
    java.getInternalBlockingPoolSize()
  }
            def setMaxEventLoopExecuteTime(value:Long) = {
          java.setMaxEventLoopExecuteTime(value)
          this
  }
            def getMaxEventLoopExecuteTime = {
    java.getMaxEventLoopExecuteTime()
  }
            def setMaxWorkerExecuteTime(value:Long) = {
          java.setMaxWorkerExecuteTime(value)
          this
  }
            def getMaxWorkerExecuteTime = {
    java.getMaxWorkerExecuteTime()
  }
            def setMetricsOptions(value:io.vertx.scala.core.metrics.MetricsOptions) = {
          java.setMetricsOptions(value.java)
          this
  }
            def getMetricsOptions = {
    java.getMetricsOptions()
  }
            def setQuorumSize(value:Int) = {
          java.setQuorumSize(value)
          this
  }
            def getQuorumSize = {
    java.getQuorumSize()
  }
            def setWarningExceptionTime(value:Long) = {
          java.setWarningExceptionTime(value)
          this
  }
            def getWarningExceptionTime = {
    java.getWarningExceptionTime()
  }
            def setWorkerPoolSize(value:Int) = {
          java.setWorkerPoolSize(value)
          this
  }
            def getWorkerPoolSize = {
    java.getWorkerPoolSize()
  }
  }
object VertxOptions {
  type VertxOptionsJava = io.vertx.core.VertxOptions
  def fromJson(json: JsonObject):VertxOptions = {
    new VertxOptions(new VertxOptionsJava(json))
  }
}
