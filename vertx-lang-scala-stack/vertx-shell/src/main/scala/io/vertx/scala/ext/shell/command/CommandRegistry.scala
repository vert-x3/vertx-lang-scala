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
import io.vertx.ext.shell.command.{CommandRegistry => JCommandRegistry}
import io.vertx.ext.shell.command.{Command => JCommand}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.ext.shell.command.{CommandResolver => JCommandResolver}

/**
  * A registry that contains the commands known by a shell.<p/>
  *
  * It is a mutable command resolver.
  */
class CommandRegistry(private val _asJava: JCommandRegistry) 
    extends  {

  def asJava: JCommandRegistry = _asJava

  /**
    * Like [[io.vertx.scala.ext.shell.command.CommandRegistry#registerCommand]], without a completion handler.
    */
  def registerCommand(command: Command): CommandRegistry = {
    _asJava.registerCommand(command.asJava.asInstanceOf[JCommand])
    this
  }

  /**
    * Register a command
    * @param command the command to register
    * @return notified when the command is registered
    */
  def registerCommandFuture(command: Command): concurrent.Future[Command] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCommand,Command]((x => if (x == null) null else Command.apply(x)))
    _asJava.registerCommand(command.asJava.asInstanceOf[JCommand], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Like [[io.vertx.scala.ext.shell.command.CommandRegistry#registerCommands]], without a completion handler.
    */
  def registerCommands(commands: scala.collection.mutable.Buffer[Command]): CommandRegistry = {
    _asJava.registerCommands(commands.map(x => if (x == null) null else x.asJava).asJava)
    this
  }

  /**
    * Register a list of commands.
    * @param commands the commands to register
    * @return notified when the command is registered
    */
  def registerCommandsFuture(commands: scala.collection.mutable.Buffer[Command]): concurrent.Future[scala.collection.mutable.Buffer[Command]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.ext.shell.command.Command],scala.collection.mutable.Buffer[Command]]((x => if (x == null) null else x.asScala.map(Command.apply)))
    _asJava.registerCommands(commands.map(x => if (x == null) null else x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Like [[io.vertx.scala.ext.shell.command.CommandRegistry#unregisterCommand]], without a completion handler.
    */
  def unregisterCommand(commandName: String): CommandRegistry = {
    _asJava.unregisterCommand(commandName)
    this
  }

  /**
    * Unregister a command.
    * @param commandName the command name
    * @return notified when the command is unregistered
    */
  def unregisterCommandFuture(commandName: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.unregisterCommand(commandName, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object CommandRegistry {

  def apply(_asJava: JCommandRegistry): CommandRegistry =
    new CommandRegistry(_asJava)

  def getShared(vertx: Vertx): CommandRegistry = {
    CommandRegistry.apply(io.vertx.ext.shell.command.CommandRegistry.getShared(vertx.asJava.asInstanceOf[JVertx]))
  }

  def create(vertx: Vertx): CommandRegistry = {
    CommandRegistry.apply(io.vertx.ext.shell.command.CommandRegistry.create(vertx.asJava.asInstanceOf[JVertx]))
  }

}
