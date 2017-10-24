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
import io.vertx.scala.ext.shell.cli.Completion
import io.vertx.core.cli.{CLI => JCLI}
import io.vertx.scala.ext.shell.system.Process
import io.vertx.ext.shell.system.{Process => JProcess}
import io.vertx.ext.shell.command.{Command => JCommand}
import scala.collection.JavaConverters._
import io.vertx.ext.shell.cli.{CliToken => JCliToken}
import io.vertx.ext.shell.cli.{Completion => JCompletion}
import io.vertx.scala.core.cli.CLI
import io.vertx.scala.ext.shell.cli.CliToken

/**
  * A Vert.x Shell command, it can be created from any language using the [[io.vertx.scala.ext.shell.command.CommandBuilder#command]] or from a
  * Java class using [[io.vertx.scala.ext.shell.command.Command#create]]
  */
class Command(private val _asJava: Object) {

  def asJava = _asJava


  /**
    * @return the command name
    */
  def name(): String = {
    asJava.asInstanceOf[JCommand].name().asInstanceOf[String]
  }

  /**
    * @return the command line interface, can be null
    */
  def cli(): CLI = {
    CLI(asJava.asInstanceOf[JCommand].cli())
  }

  /**
    * Create a new process with empty arguments.
    * @return the process
    */
  def createProcess(): Process = {
    Process(asJava.asInstanceOf[JCommand].createProcess())
  }

  /**
    * Perform command completion, when the command is done completing it should call 
    * or  )` method to signal completion is done.
    * @param completion the completion object
    */
  def complete(completion: Completion): Unit = {
    asJava.asInstanceOf[JCommand].complete(completion.asJava.asInstanceOf[JCompletion])
  }

  /**
    * Create a new process with the passed arguments.
    * @param args the process arguments
    * @return the process
    */
  def createProcess(args: scala.collection.mutable.Buffer[CliToken]): Process = {
    Process(asJava.asInstanceOf[JCommand].createProcess(args.map(x => x.asJava.asInstanceOf[JCliToken]).asJava))
  }

}

object Command {
  def apply(asJava: JCommand) = new Command(asJava)  
}
