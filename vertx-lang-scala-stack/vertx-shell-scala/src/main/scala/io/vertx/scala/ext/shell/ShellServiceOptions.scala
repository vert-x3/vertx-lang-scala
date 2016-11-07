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
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.shell.{ShellServiceOptions => JShellServiceOptions}
import io.vertx.ext.shell.term.{HttpTermOptions => JHttpTermOptions}
import io.vertx.scala.ext.shell.term.HttpTermOptions
import io.vertx.ext.shell.term.{SSHTermOptions => JSSHTermOptions}
import io.vertx.scala.ext.shell.term.SSHTermOptions
import io.vertx.ext.shell.term.{TelnetTermOptions => JTelnetTermOptions}
import io.vertx.scala.ext.shell.term.TelnetTermOptions

/**
  * The configurations options for the shell service, the shell connectors can be configured
  * with ,  and .
  */

class ShellServiceOptions(val asJava: JShellServiceOptions) {
  def setHttpOptions(value: HttpTermOptions) = {
    asJava.setHttpOptions(value.asJava)
    this
  }
  def getHttpOptions = {
    asJava.getHttpOptions()
  }

  /**
    * Set the repear interval, i.e the period at which session eviction is performed.
    */
  def setReaperInterval(value: Long) = {
    asJava.setReaperInterval(value)
    this
  }
  def getReaperInterval = {
    asJava.getReaperInterval()
  }

  /**
    * Set the session timeout.
    */
  def setSessionTimeout(value: Long) = {
    asJava.setSessionTimeout(value)
    this
  }
  def getSessionTimeout = {
    asJava.getSessionTimeout()
  }

  /**
    * Set the SSH options, if the option is null, SSH will not be started.
    */
  def setSSHOptions(value: SSHTermOptions) = {
    asJava.setSSHOptions(value.asJava)
    this
  }
  def getSSHOptions = {
    asJava.getSSHOptions()
  }

  /**
    * Set the Telnet options, if the option is null, Telnet will not be started.
    */
  def setTelnetOptions(value: TelnetTermOptions) = {
    asJava.setTelnetOptions(value.asJava)
    this
  }
  def getTelnetOptions = {
    asJava.getTelnetOptions()
  }

  /**
    * Set the shell welcome message, i.e the message displayed in the user console when he connects to the shell.
    */
  def setWelcomeMessage(value: String) = {
    asJava.setWelcomeMessage(value)
    this
  }
  def getWelcomeMessage = {
    asJava.getWelcomeMessage()
  }
}

object ShellServiceOptions {
  
  def apply() = {
    new ShellServiceOptions(new JShellServiceOptions(emptyObj()))
  }
  
  def apply(t: JShellServiceOptions) = {
    if(t != null)
      new ShellServiceOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):ShellServiceOptions = {
    if(json != null)
      new ShellServiceOptions(new JShellServiceOptions(json))
    else
      null
  }
}
