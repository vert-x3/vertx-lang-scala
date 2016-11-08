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
import io.vertx.ext.shell.command.{CommandResolver => JCommandResolver}
import io.vertx.ext.shell.command.{Command => JCommand}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx

/**
  * A resolver for commands, so the shell can discover commands.
  */
class CommandResolver(private val _asJava: JCommandResolver) {

  def asJava: JCommandResolver = _asJava

  /**
    * @return the current commands
    */
  def commands(): scala.collection.mutable.Buffer[Command] = {
    _asJava.commands().asScala.map(Command.apply)
  }

  /**
    * Returns a single command by its name.
    * @param name the command name
    * @return the commad or null
    */
  def getCommand(name: String): Command = {
    Command.apply(_asJava.getCommand(name))
  }

}

object CommandResolver {

  def apply(_asJava: JCommandResolver): CommandResolver =
    new CommandResolver(_asJava)

  def baseCommands(vertx: Vertx): CommandResolver = {
    CommandResolver.apply(io.vertx.ext.shell.command.CommandResolver.baseCommands(vertx.asJava.asInstanceOf[JVertx]))
  }

}
