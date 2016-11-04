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

package io.vertx.scala.core.cli

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.cli.Option
import io.vertx.core.cli.{CommandLine => JCommandLine}
import io.vertx.core.cli.{CLI => JCLI}
import io.vertx.core.cli.Argument

/**
  * The parser transforms a CLI (a model) into an [[io.vertx.scala.core.cli.CommandLine]]. This [[io.vertx.scala.core.cli.CommandLine]]
  * has stored the argument and option values. Only  instance of parser should create
  * objects of this type.
  */
class CommandLine(private val _asJava: io.vertx.core.cli.CommandLine) {

  def asJava: io.vertx.core.cli.CommandLine = _asJava

  /**
    * @return the model of this command line object.
    */
  def cli(): CLI = {
    CLI.apply(_asJava.cli())
  }

  /**
    * @return the ordered list of arguments. Arguments are command line arguments not matching an option.
    */
  def allArguments(): scala.collection.mutable.Buffer[String] = {
    _asJava.allArguments().asScala.map(x => x:String)
  }

  /**
    * Gets the value of an option with the matching name (can be the long name, short name or arg name).
    * @param name the name
    * @return the value, `null` if not set
    */
  def getOptionValue[T](name: String): T = {
    _asJava.getOptionValue(name)
  }

  /**
    * Gets the value of an argument with the matching name (arg name).
    * @param name the name
    * @return the value, `null` if not set
    */
  def getArgumentValue[T](name: String): T = {
    _asJava.getArgumentValue(name)
  }

  /**
    * Gets the value of an argument with the given index.
    * @param index the index
    * @return the value, `null` if not set
    */
  def getArgumentValue[T](index: Int): T = {
    _asJava.getArgumentValue(index)
  }

  /**
    * Gets the value of an option marked as a flag.
    * <p/>
    * Calling this method an a non-flag option throws an IllegalStateException.
    * @param name the option name
    * @return `true` if the flag has been set in the command line, `false` otherwise.
    */
  def isFlagEnabled(name: String): Boolean = {
    _asJava.isFlagEnabled(name)
  }

  /**
    * Checks whether or not the given option has been assigned in the command line.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return `true` if the option has received a value, [[false]] otherwise.
    */
  def isOptionAssigned(option: io.vertx.scala.core.cli.Option): Boolean = {
    _asJava.isOptionAssigned(option.asJava)
  }

  /**
    * Gets the raw values of the given option. Raw values are simple "String", not converted to the option type.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return the list of values, empty if none
    */
  def getRawValues(option: io.vertx.scala.core.cli.Option): scala.collection.mutable.Buffer[String] = {
    _asJava.getRawValues(option.asJava).asScala.map(x => x:String)
  }

  /**
    * Gets the raw values of the given option. Raw values are simple "String", not converted to the option type.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return the list of values, empty if none
    */
  def getRawValuesForOption(option: io.vertx.scala.core.cli.Option): scala.collection.mutable.Buffer[String] = {
    _asJava.getRawValuesForOption(option.asJava).asScala.map(x => x:String)
  }

  /**
    * Gets the raw values of the given argument. Raw values are simple "String", not converted to the argument type.
    * @param argument the argumentsee <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    * @return the list of values, empty if none
    */
  def getRawValuesForArgument(argument: io.vertx.scala.core.cli.Argument): scala.collection.mutable.Buffer[String] = {
    _asJava.getRawValuesForArgument(argument.asJava).asScala.map(x => x:String)
  }

  /**
    * Gets the raw value of the given option. Raw values are the values as given in the user command line.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return the value, `null` if none.
    */
  def getRawValueForOption(option: io.vertx.scala.core.cli.Option): scala.Option[String] = {
        scala.Option(_asJava.getRawValueForOption(option.asJava))
  }

  /**
    * Checks whether or not the given option accept more values.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return [[true]] if the option accepts more values, [[false]] otherwise.
    */
  def acceptMoreValues(option: io.vertx.scala.core.cli.Option): Boolean = {
    _asJava.acceptMoreValues(option.asJava)
  }

  /**
    * Gets the raw value of the given argument. Raw values are the values as given in the user command line.
    * @param arg the argumentsee <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    * @return the value, `null` if none.
    */
  def getRawValueForArgument(arg: io.vertx.scala.core.cli.Argument): scala.Option[String] = {
        scala.Option(_asJava.getRawValueForArgument(arg.asJava))
  }

  /**
    * Checks whether or not the given argument has been assigned in the command line.
    * @param arg the argumentsee <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    * @return `true` if the argument has received a value, [[false]] otherwise.
    */
  def isArgumentAssigned(arg: io.vertx.scala.core.cli.Argument): Boolean = {
    _asJava.isArgumentAssigned(arg.asJava)
  }

  /**
    * Checks whether or not the given option has been seen in the user command line.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return `true` if the user command line has used the option
    */
  def isSeenInCommandLine(option: io.vertx.scala.core.cli.Option): Boolean = {
    _asJava.isSeenInCommandLine(option.asJava)
  }

  /**
    * Checks whether or not the command line is valid, i.e. all constraints from arguments and options have been
    * satisfied. This method is used when the parser validation is disabled.
    * @return `true` if the current [[CommandLine]] object is valid. [[false]] otherwise.
    */
  def isValid(): Boolean = {
    _asJava.isValid()
  }

  /**
    * Checks whether or not the user has passed a "help" option and is asking for help.
    * @return `true` if the user command line has enabled a "Help" option, [[false]] otherwise.
    */
  def isAskingForHelp(): Boolean = {
    _asJava.isAskingForHelp()
  }

}

object CommandLine {

  def apply(_asJava: io.vertx.core.cli.CommandLine): CommandLine =
    new CommandLine(_asJava)

  def create(cli: CLI): CommandLine = {
    CommandLine.apply(io.vertx.core.cli.CommandLine.create(cli.asJava.asInstanceOf[io.vertx.core.cli.CLI]))
  }

}
