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

class DeploymentOptions(val java: io.vertx.core.DeploymentOptions) {
  def setConfig(value:io.vertx.core.json.JsonObject) = {
    java.setConfig(value)
    this
  }
  def getConfig = {
    java.getConfig()
  }
  def setExtraClasspath(value:scala.collection.mutable.Buffer[String]) = {
    java.setExtraClasspath(value)
    this
  }
  def getExtraClasspath = {
    java.getExtraClasspath()
  }
  def setHa(value:Boolean) = {
    java.setHa(value)
    this
  }
  def isHa = {
    java.isHa()
  }
  def setInstances(value:Int) = {
    java.setInstances(value)
    this
  }
  def getInstances = {
    java.getInstances()
  }
  def setIsolatedClasses(value:scala.collection.mutable.Buffer[String]) = {
    java.setIsolatedClasses(value)
    this
  }
  def getIsolatedClasses = {
    java.getIsolatedClasses()
  }
  def setIsolationGroup(value:String) = {
    java.setIsolationGroup(value)
    this
  }
  def getIsolationGroup = {
    java.getIsolationGroup()
  }
  def setMaxWorkerExecuteTime(value:Long) = {
    java.setMaxWorkerExecuteTime(value)
    this
  }
  def getMaxWorkerExecuteTime = {
    java.getMaxWorkerExecuteTime()
  }
  def setMultiThreaded(value:Boolean) = {
    java.setMultiThreaded(value)
    this
  }
  def isMultiThreaded = {
    java.isMultiThreaded()
  }
  def setWorker(value:Boolean) = {
    java.setWorker(value)
    this
  }
  def isWorker = {
    java.isWorker()
  }
  def setWorkerPoolName(value:String) = {
    java.setWorkerPoolName(value)
    this
  }
  def getWorkerPoolName = {
    java.getWorkerPoolName()
  }
  def setWorkerPoolSize(value:Int) = {
    java.setWorkerPoolSize(value)
    this
  }
  def getWorkerPoolSize = {
    java.getWorkerPoolSize()
  }
}

object DeploymentOptions {
  type DeploymentOptionsJava = io.vertx.core.DeploymentOptions
  
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
