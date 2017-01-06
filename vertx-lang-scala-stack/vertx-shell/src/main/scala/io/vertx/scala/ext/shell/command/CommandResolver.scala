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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.shell.command.{CommandResolver => JCommandResolver}
import io.vertx.ext.shell.command.{Command => JCommand}
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * A resolver for commands, so the shell can discover commands.
  */
class CommandResolver(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Returns a single command by its name.
    * @param name the command name
    * @return the commad or null
    */
  def getCommand(name: String):Command = {
    Command(asJava.asInstanceOf[JCommandResolver].getCommand(name.asInstanceOf[java.lang.String]))
  }

  /**
    * @return the current commands
    */
  def commands():scala.collection.mutable.Buffer[Command] = {
    asJava.asInstanceOf[JCommandResolver].commands().asScala.map(x => Command(x))
  }

}

object CommandResolver{
  def apply(asJava: JCommandResolver) = new CommandResolver(asJava)  
  /**
    * @return the base commands of Vert.x Shell.
    */
  def baseCommands(vertx: Vertx):CommandResolver = {
    CommandResolver(JCommandResolver.baseCommands(vertx.asJava.asInstanceOf[JVertx]))
  }

}
