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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.shell.command.{CommandResolver => JCommandResolver}
import scala.reflect.runtime.universe._
import io.vertx.ext.shell.command.{Command => JCommand}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.ext.shell.command.{CommandRegistry => JCommandRegistry}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A registry that contains the commands known by a shell.<p/>
  *
  * It is a mutable command resolver.
  */

class CommandRegistry(private val _asJava: Object) extends CommandResolver (_asJava) {




  /**
   * Like [[io.vertx.scala.ext.shell.command.CommandRegistry#registerCommand]], without a completion handler.
   */
  
  def registerCommand(command: Command): CommandRegistry = {
    asJava.asInstanceOf[JCommandRegistry].registerCommand(command.asJava.asInstanceOf[JCommand])
    this
  }

  /**
   * Register a command   * @param command the command to register
   * @param completionHandler notified when the command is registered
   * @return a reference to this, so the API can be used fluently
   */
  
  def registerCommand(command: Command, completionHandler: Handler[AsyncResult[Command]]): CommandRegistry = {
    asJava.asInstanceOf[JCommandRegistry].registerCommand(command.asJava.asInstanceOf[JCommand], (if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[JCommand]]{def handle(x: AsyncResult[JCommand]) {completionHandler.handle(AsyncResultWrapper[JCommand, Command](x, a => Command(a)))}}))
    this
  }

  /**
   * Like [[io.vertx.scala.ext.shell.command.CommandRegistry#registerCommands]], without a completion handler.
   */
  
  def registerCommands(commands: scala.collection.mutable.Buffer[Command]): CommandRegistry = {
    asJava.asInstanceOf[JCommandRegistry].registerCommands(commands.map(x => x.asJava.asInstanceOf[JCommand]).asJava)
    this
  }

  /**
   * Register a list of commands.   * @param commands the commands to register
   * @param completionHandler notified when the command is registered
   * @return a reference to this, so the API can be used fluently
   */
  
  def registerCommands(commands: scala.collection.mutable.Buffer[Command], completionHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[Command]]]): CommandRegistry = {
    asJava.asInstanceOf[JCommandRegistry].registerCommands(commands.map(x => x.asJava.asInstanceOf[JCommand]).asJava, (if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JCommand]]]{def handle(x: AsyncResult[java.util.List[JCommand]]) {completionHandler.handle(AsyncResultWrapper[java.util.List[JCommand], scala.collection.mutable.Buffer[Command]](x, a => a.asScala.map(x => Command(x))))}}))
    this
  }

  /**
   * Like [[io.vertx.scala.ext.shell.command.CommandRegistry#unregisterCommand]], without a completion handler.
   */
  
  def unregisterCommand(commandName: String): CommandRegistry = {
    asJava.asInstanceOf[JCommandRegistry].unregisterCommand(commandName.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Unregister a command.   * @param commandName the command name
   * @param completionHandler notified when the command is unregistered
   * @return a reference to this, so the API can be used fluently
   */
  
  def unregisterCommand(commandName: String, completionHandler: Handler[AsyncResult[Unit]]): CommandRegistry = {
    asJava.asInstanceOf[JCommandRegistry].unregisterCommand(commandName.asInstanceOf[java.lang.String], (if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }




 /**
  * Like [[registerCommand]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def registerCommandFuture (command: Command): scala.concurrent.Future[Command] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCommand, Command](x => Command(x))
    asJava.asInstanceOf[JCommandRegistry].registerCommand(command.asJava.asInstanceOf[JCommand], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[registerCommands]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def registerCommandsFuture (commands: scala.collection.mutable.Buffer[Command]): scala.concurrent.Future[scala.collection.mutable.Buffer[Command]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JCommand], scala.collection.mutable.Buffer[Command]](x => x.asScala.map(x => Command(x)))
    asJava.asInstanceOf[JCommandRegistry].registerCommands(commands.map(x => x.asJava.asInstanceOf[JCommand]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[unregisterCommand]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def unregisterCommandFuture (commandName: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JCommandRegistry].unregisterCommand(commandName.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object CommandRegistry {
  def apply(asJava: JCommandRegistry) = new CommandRegistry(asJava)

  /**
   * Get the shared registry for the Vert.x instance.   * @param vertx the vertx instance
   * @return the shared registry
   */
  def getShared(vertx: Vertx): CommandRegistry = {
    CommandRegistry(JCommandRegistry.getShared(vertx.asJava.asInstanceOf[JVertx]))//2 getShared
  }

  /**
   * Create a new registry.   * @param vertx the vertx instance
   * @return the created registry
   */
  def create(vertx: Vertx): CommandRegistry = {
    CommandRegistry(JCommandRegistry.create(vertx.asJava.asInstanceOf[JVertx]))//2 create
  }

}
