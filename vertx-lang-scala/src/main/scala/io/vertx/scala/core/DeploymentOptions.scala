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

import java.util.concurrent.TimeUnit
import io.vertx.core.{DeploymentOptions => JDeploymentOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Options for configuring a verticle deployment.
 * 
 */

class DeploymentOptions(private val _asJava: JDeploymentOptions) {
  def asJava = _asJava
  /**
   * Set the JSON configuration that will be passed to the verticle(s) when it's deployed
   */
  def setConfig(value: io.vertx.core.json.JsonObject) = {
    asJava.setConfig(value)
    this
  }

  def getConfig: io.vertx.core.json.JsonObject = {
    asJava.getConfig()
  }

  /**
   * Set any extra classpath to be used when deploying the verticle.
   * 
   * Ignored if no isolation group is set.
   */
  def setExtraClasspath(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setExtraClasspath(value.asJava)
    this
  }

  def getExtraClasspath: scala.collection.mutable.Buffer[String] = {
    asJava.getExtraClasspath().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * Set whether the verticle(s) will be deployed as HA.
   */
  def setHa(value: Boolean) = {
    asJava.setHa(value)
    this
  }

  def isHa: Boolean = {
    asJava.isHa().asInstanceOf[Boolean]
  }

  /**
   * Set the number of instances that should be deployed.
   */
  def setInstances(value: Int) = {
    asJava.setInstances(value)
    this
  }

  def getInstances: Int = {
    asJava.getInstances().asInstanceOf[Int]
  }

  /**
   * Set the isolated class names.
   */
  def setIsolatedClasses(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setIsolatedClasses(value.asJava)
    this
  }

  def getIsolatedClasses: scala.collection.mutable.Buffer[String] = {
    asJava.getIsolatedClasses().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * Set the isolation group that will be used when deploying the verticle(s)
   */
  def setIsolationGroup(value: String) = {
    asJava.setIsolationGroup(value)
    this
  }

  def getIsolationGroup: String = {
    asJava.getIsolationGroup().asInstanceOf[String]
  }

  /**
   * Sets the value of max worker execute time, in <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a>.
   * 
   * The default value of <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a> is 
   */
  def setMaxWorkerExecuteTime(value: Long) = {
    asJava.setMaxWorkerExecuteTime(value)
    this
  }

  def getMaxWorkerExecuteTime: Long = {
    asJava.getMaxWorkerExecuteTime().asInstanceOf[Long]
  }

  /**
   * Set the time unit of `maxWorkerExecuteTime`
   */
  def setMaxWorkerExecuteTimeUnit(value: java.util.concurrent.TimeUnit) = {
    asJava.setMaxWorkerExecuteTimeUnit(value)
    this
  }

  def getMaxWorkerExecuteTimeUnit: java.util.concurrent.TimeUnit = {
    asJava.getMaxWorkerExecuteTimeUnit()
  }

  /**
   * Set whether the verticle(s) should be deployed as a multi-threaded worker verticle.
   * 
   * <strong>WARNING</strong>: Multi-threaded worker verticles are a deprecated feature.
   * 
   * Most applications will have no need for them. Because of the concurrency in these verticles you have to be
   * very careful to keep the verticle in a consistent state using standard Java techniques for multi-threaded
   * programming.
   * 
   * You can read the documentation that explains how you can replace this feature by the usage of custom worker
   * pools or `executeBlocking` calls.
   */
  def setMultiThreaded(value: Boolean) = {
    asJava.setMultiThreaded(value)
    this
  }

  def isMultiThreaded: Boolean = {
    asJava.isMultiThreaded().asInstanceOf[Boolean]
  }

  /**
   * Set whether the verticle(s) should be deployed as a worker verticle
   */
  def setWorker(value: Boolean) = {
    asJava.setWorker(value)
    this
  }

  def isWorker: Boolean = {
    asJava.isWorker().asInstanceOf[Boolean]
  }

  /**
   * Set the worker pool name to use for this verticle. When no name is set, the Vert.x
   * worker pool will be used, when a name is set, the verticle will use a named worker pool.
   */
  def setWorkerPoolName(value: String) = {
    asJava.setWorkerPoolName(value)
    this
  }

  def getWorkerPoolName: String = {
    asJava.getWorkerPoolName().asInstanceOf[String]
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


object DeploymentOptions {
  
  def apply() = {
    new DeploymentOptions(new JDeploymentOptions(emptyObj()))
  }
  
  def apply(t: JDeploymentOptions) = {
    if (t != null) {
      new DeploymentOptions(t)
    } else {
      new DeploymentOptions(new JDeploymentOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): DeploymentOptions = {
    if (json != null) {
      new DeploymentOptions(new JDeploymentOptions(json))
    } else {
      new DeploymentOptions(new JDeploymentOptions(emptyObj()))
    }
  }
}

