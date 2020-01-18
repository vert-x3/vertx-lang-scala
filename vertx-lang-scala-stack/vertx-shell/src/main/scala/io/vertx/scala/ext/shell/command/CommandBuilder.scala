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

import scala.reflect.runtime.universe._
import io.vertx.ext.shell.command.{CommandProcess => JCommandProcess}
import io.vertx.ext.shell.cli.{Completion => JCompletion}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.ext.shell.cli.Completion
import io.vertx.core.cli.{CLI => JCLI}
import io.vertx.ext.shell.command.{Command => JCommand}
import io.vertx.ext.shell.command.{CommandBuilder => JCommandBuilder}
import io.vertx.core.Handler
import io.vertx.scala.core.cli.CLI
import io.vertx.lang.scala.HandlerOps._

/**
  * A build for Vert.x Shell command.
  */

class CommandBuilder(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Set the command process handler, the process handler is called when the command is executed.   * @param handler the process handler
   * @return this command object
   */
  
  def processHandler(handler: Handler[CommandProcess]): CommandBuilder = {
    asJava.asInstanceOf[JCommandBuilder].processHandler((if (handler == null) null else new io.vertx.core.Handler[JCommandProcess]{def handle(x: JCommandProcess) {handler.handle(CommandProcess(x))}}))
    this
  }

  /**
   * Set the command completion handler, the completion handler when the user asks for contextual command line
   * completion, usually hitting the <i>tab</i> key.   * @param handler the completion handler
   * @return this command object
   */
  
  def completionHandler(handler: Handler[Completion]): CommandBuilder = {
    asJava.asInstanceOf[JCommandBuilder].completionHandler((if (handler == null) null else new io.vertx.core.Handler[JCompletion]{def handle(x: JCompletion) {handler.handle(Completion(x))}}))
    this
  }



  /**
   * Build the command   * @param vertx the vertx instance
   * @return the built command
   */
  def build (vertx: Vertx): Command = {
    Command(asJava.asInstanceOf[JCommandBuilder].build(vertx.asJava.asInstanceOf[JVertx]))
  }


}

object CommandBuilder {
  def apply(asJava: JCommandBuilder) = new CommandBuilder(asJava)

  /**
   * Create a new commmand builder, the command is responsible for managing the options and arguments via the
   * [[io.vertx.scala.ext.shell.command.CommandProcess]].   * @param name the command name
   * @return the command
   */
  def command(name: String): CommandBuilder = {
    CommandBuilder(JCommandBuilder.command(name.asInstanceOf[java.lang.String]))//2 command
  }

  /**
   * Create a new commmand with its [[io.vertx.scala.core.cli.CLI]] descriptor. This command can then retrieve the parsed
   * [[io.vertx.scala.ext.shell.command.CommandProcess#commandLine]] when it executes to know get the command arguments and options.   * @param cli the cli to use
   * @return the command
   */
  def command(cli: CLI): CommandBuilder = {
    CommandBuilder(JCommandBuilder.command(cli.asJava.asInstanceOf[JCLI]))//2 command
  }

}
