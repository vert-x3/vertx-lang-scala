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

package io.vertx.scala.ext.shell

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * The configurations options for the shell server.
  */

class ShellServerOptions(val asJava: io.vertx.ext.shell.ShellServerOptions) {

  /**
    * Set the repear interval, i.e the period at which session eviction is performed.
    */
  def setReaperInterval(value:Long) = {
    asJava.setReaperInterval(value)
    this
  }
  def getReaperInterval = {
    asJava.getReaperInterval()
  }

  /**
    * Set the session timeout.
    */
  def setSessionTimeout(value:Long) = {
    asJava.setSessionTimeout(value)
    this
  }
  def getSessionTimeout = {
    asJava.getSessionTimeout()
  }

  /**
    * Set the shell welcome message, i.e the message displayed in the user console when he connects to the shell.
    */
  def setWelcomeMessage(value:String) = {
    asJava.setWelcomeMessage(value)
    this
  }
  def getWelcomeMessage = {
    asJava.getWelcomeMessage()
  }
}

object ShellServerOptions {
  type ShellServerOptionsJava = io.vertx.ext.shell.ShellServerOptions
  
  def apply() = {
    new ShellServerOptions(new ShellServerOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: ShellServerOptionsJava) = {
    if(t != null)
      new ShellServerOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):ShellServerOptions = {
    if(json != null)
      new ShellServerOptions(new ShellServerOptionsJava(json))
    else
      null
  }
}
