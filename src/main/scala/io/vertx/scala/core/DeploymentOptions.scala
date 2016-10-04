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
  * Options for configuring a verticle deployment.
  * 
  */

class DeploymentOptions(val asJava: io.vertx.core.DeploymentOptions) {

  /**
    * Set the JSON configuration that will be passed to the verticle(s) when it's deployed
    */
  def setConfig(value:io.vertx.core.json.JsonObject) = {
    asJava.setConfig(value)
    this
  }
  def getConfig = {
    asJava.getConfig()
  }

  /**
    * Set any extra classpath to be used when deploying the verticle.
    * 
    * Ignored if no isolation group is set.
    */
  def setExtraClasspath(value:scala.collection.mutable.Buffer[String]) = {
    asJava.setExtraClasspath(value)
    this
  }
  def getExtraClasspath = {
    asJava.getExtraClasspath()
  }

  /**
    * Set whether the verticle(s) will be deployed as HA.
    */
  def setHa(value:Boolean) = {
    asJava.setHa(value)
    this
  }
  def isHa = {
    asJava.isHa()
  }

  /**
    * Set the number of instances that should be deployed.
    */
  def setInstances(value:Int) = {
    asJava.setInstances(value)
    this
  }
  def getInstances = {
    asJava.getInstances()
  }

  /**
    * Set the isolated class names.
    */
  def setIsolatedClasses(value:scala.collection.mutable.Buffer[String]) = {
    asJava.setIsolatedClasses(value)
    this
  }
  def getIsolatedClasses = {
    asJava.getIsolatedClasses()
  }

  /**
    * Set the isolation group that will be used when deploying the verticle(s)
    */
  def setIsolationGroup(value:String) = {
    asJava.setIsolationGroup(value)
    this
  }
  def getIsolationGroup = {
    asJava.getIsolationGroup()
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
    * Set whether the verticle(s) should be deployed as a multi-threaded worker verticle
    */
  def setMultiThreaded(value:Boolean) = {
    asJava.setMultiThreaded(value)
    this
  }
  def isMultiThreaded = {
    asJava.isMultiThreaded()
  }

  /**
    * Set whether the verticle(s) should be deployed as a worker verticle
    */
  def setWorker(value:Boolean) = {
    asJava.setWorker(value)
    this
  }
  def isWorker = {
    asJava.isWorker()
  }

  /**
    * Set the worker pool name to use for this verticle. When no name is set, the Vert.x
    * worker pool will be used, when a name is set, the verticle will use a named worker pool.
    */
  def setWorkerPoolName(value:String) = {
    asJava.setWorkerPoolName(value)
    this
  }
  def getWorkerPoolName = {
    asJava.getWorkerPoolName()
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

object DeploymentOptions {
  type DeploymentOptionsJava = io.vertx.core.DeploymentOptions
  
  def apply() = {
    new DeploymentOptions(new DeploymentOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
   
  }
  
  def apply(t: DeploymentOptionsJava) = {
    if(t != null)
      new DeploymentOptions(t)
    else
      null
   
  }
  
  def fromJson(json: JsonObject):DeploymentOptions = {
    if(json != null)
      new DeploymentOptions(new DeploymentOptionsJava(json))
    else
      null
  }
}
