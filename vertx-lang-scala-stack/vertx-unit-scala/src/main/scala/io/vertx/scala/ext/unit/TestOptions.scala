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

package io.vertx.scala.ext.unit

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Test execution options:
  *
  * <ul>
  *   <li>the `timeout` in milliseconds, the default value is 2 minutes </li>
  *   <li>the `useEventLoop`</li> configures the event loop usage
  *     <ul>
  *       <li>`true` always runs with an event loop</li>
  *       <li>`false` never runs with an event loop</li>
  *       <li>`null` uses an event loop if there is one (provided by [[io.vertx.scala.core.Vertx]])
  *       otherwise run without</li>
  *     </ul>
  *   </li>
  *   <li>the `reporters` is an array of reporter configurations</li>
  * </ul>
  */

class TestOptions(val asJava: io.vertx.ext.unit.TestOptions) {

  /**
    * Replace the current list of reporters with a new one.
    */
  def addReporter(value:io.vertx.scala.ext.unit.report.ReportOptions) = {
    asJava.addReporter(value.asJava)
    this
  }
  def setReporters(value:scala.collection.mutable.Buffer[io.vertx.scala.ext.unit.report.ReportOptions]) = {
    asJava.setReporters(value.map(_.asJava))
    this
  }
  def getReporters = {
    asJava.getReporters()
  }

  /**
    * Set the test timeout.
    */
  def setTimeout(value:Long) = {
    asJava.setTimeout(value)
    this
  }
  def getTimeout = {
    asJava.getTimeout()
  }

  /**
    * Configure the execution to use an event loop when there is no one existing.
    */
  def setUseEventLoop(value:Boolean) = {
    asJava.setUseEventLoop(value)
    this
  }
  def isUseEventLoop = {
    asJava.isUseEventLoop()
  }
}

object TestOptions {
  type TestOptionsJava = io.vertx.ext.unit.TestOptions
  
  def apply(t: TestOptionsJava) = {
    if(t != null)
      new TestOptions(t)
    else
      null
   
  }
  
  def fromJson(json: JsonObject):TestOptions = {
    if(json != null)
      new TestOptions(new TestOptionsJava(json))
    else
      null
  }
}
