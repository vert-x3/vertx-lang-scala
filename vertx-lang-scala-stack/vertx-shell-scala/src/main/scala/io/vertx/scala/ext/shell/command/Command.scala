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
import io.vertx.scala.ext.shell.cli.Completion
import io.vertx.scala.core.cli.CLI
import io.vertx.scala.ext.shell.cli.CliToken
import io.vertx.scala.ext.shell.system.Process

/**
  * A Vert.x Shell command, it can be created from any language using the [[io.vertx.scala.ext.shell.command.CommandBuilder#command]] or from a
  * Java class using [[io.vertx.scala.ext.shell.command.Command#create]]
  */
class Command(private val _asJava: io.vertx.ext.shell.command.Command) {

  def asJava: io.vertx.ext.shell.command.Command = _asJava

  /**
    * @return the command name
    */
  def name(): String = {
    _asJava.name()
  }

  /**
    * @return the command line interface, can be null
    */
  def cli(): io.vertx.scala.core.cli.CLI = {
    CLI.apply(_asJava.cli())
  }

  /**
    * Create a new process with empty arguments.
    * @return the process
    */
  def createProcess(): io.vertx.scala.ext.shell.system.Process = {
    Process.apply(_asJava.createProcess())
  }

  /**
    * Create a new process with the passed arguments.
    * @param args the process arguments
    * @return the process
    */
  def createProcess(args: scala.collection.mutable.Buffer[io.vertx.scala.ext.shell.cli.CliToken]): io.vertx.scala.ext.shell.system.Process = {
    Process.apply(_asJava.createProcess(args.map(x => if (x == null) null else x.asJava).asJava))
  }

  /**
    * Perform command completion, when the command is done completing it should call 
    * or  )` method to signal completion is done.
    * @param completion the completion object
    */
  def complete(completion: io.vertx.scala.ext.shell.cli.Completion): Unit = {
    _asJava.complete(completion.asJava.asInstanceOf[io.vertx.ext.shell.cli.Completion])
  }

}

object Command {

  def apply(_asJava: io.vertx.ext.shell.command.Command): io.vertx.scala.ext.shell.command.Command =
    new io.vertx.scala.ext.shell.command.Command(_asJava)

}
