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

package io.vertx.scala.ext.shell.command

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.shell.command.{CommandBuilder => JCommandBuilder}
import io.vertx.ext.shell.command.{Command => JCommand}
import io.vertx.ext.shell.cli.{Completion => JCompletion}
import io.vertx.scala.ext.shell.cli.Completion
import io.vertx.core.cli.{CLI => JCLI}
import io.vertx.scala.core.cli.CLI
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.ext.shell.command.{CommandProcess => JCommandProcess}

/**
  * A build for Vert.x Shell command.
  */
class CommandBuilder(private val _asJava: JCommandBuilder) {

  def asJava: JCommandBuilder = _asJava

  /**
    * Set the command process handler, the process handler is called when the command is executed.
    * @param handler the process handler
    * @return this command object
    */
  def processHandler(handler: CommandProcess => Unit): CommandBuilder = {
    _asJava.processHandler(funcToMappedHandler(CommandProcess.apply)(handler))
    this
  }

  /**
    * Set the command completion handler, the completion handler when the user asks for contextual command line
    * completion, usually hitting the <i>tab</i> key.
    * @param handler the completion handler
    * @return this command object
    */
  def completionHandler(handler: Completion => Unit): CommandBuilder = {
    _asJava.completionHandler(funcToMappedHandler(Completion.apply)(handler))
    this
  }

  /**
    * Build the command
    * @param vertx the vertx instance
    * @return the built command
    */
  def build(vertx: Vertx): Command = {
    Command.apply(_asJava.build(vertx.asJava.asInstanceOf[JVertx]))
  }

}

object CommandBuilder {

  def apply(_asJava: JCommandBuilder): CommandBuilder =
    new CommandBuilder(_asJava)

  def command(name: String): CommandBuilder = {
    CommandBuilder.apply(io.vertx.ext.shell.command.CommandBuilder.command(name))
  }

  def command(cli: CLI): CommandBuilder = {
    CommandBuilder.apply(io.vertx.ext.shell.command.CommandBuilder.command(cli.asJava.asInstanceOf[JCLI]))
  }

}
