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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.cli.{Argument => JArgument}
import io.vertx.core.cli.{Option => JOption}
import io.vertx.core.cli.{CLI => JCLI}
import io.vertx.core.cli.{CommandLine => JCommandLine}
import scala.collection.JavaConverters._

/**
  * The parser transforms a CLI (a model) into an [[io.vertx.scala.core.cli.CommandLine]]. This [[io.vertx.scala.core.cli.CommandLine]]
  * has stored the argument and option values. Only  instance of parser should create
  * objects of this type.
  */
class CommandLine(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Gets the raw values of the given option. Raw values are simple "String", not converted to the option type.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return the list of values, empty if none
    */
  def getRawValues(option: Option): scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JCommandLine].getRawValues(option.asJava).asScala.map(x => x.asInstanceOf[String])
  }

  /**
    * @return the model of this command line object.
    */
  def cli(): CLI = {
    CLI(asJava.asInstanceOf[JCommandLine].cli())
  }

  /**
    * @return the ordered list of arguments. Arguments are command line arguments not matching an option.
    */
  def allArguments(): scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JCommandLine].allArguments().asScala.map(x => x.asInstanceOf[String])
  }

  /**
    * Gets the value of an option with the matching name (can be the long name, short name or arg name).
    * @param name the name
    * @return the value, `null` if not set
    */
  def getOptionValue[T: TypeTag](name: String): scala.Option[T] = {
    scala.Option(toScala[T](asJava.asInstanceOf[JCommandLine].getOptionValue[Object](name.asInstanceOf[java.lang.String])))
  }

  /**
    * Gets the value of an argument with the matching name (arg name).
    * @param name the name
    * @return the value, `null` if not set
    */
  def getArgumentValue[T: TypeTag](name: String): scala.Option[T] = {
    scala.Option(toScala[T](asJava.asInstanceOf[JCommandLine].getArgumentValue[Object](name.asInstanceOf[java.lang.String])))
  }

  /**
    * Gets the value of an argument with the given index.
    * @param index the index
    * @return the value, `null` if not set
    */
  def getArgumentValue[T: TypeTag](index: Int): scala.Option[T] = {
    scala.Option(toScala[T](asJava.asInstanceOf[JCommandLine].getArgumentValue[Object](index.asInstanceOf[java.lang.Integer])))
  }

  /**
    * Gets the value of an option marked as a flag.
    * <p/>
    * Calling this method an a non-flag option throws an IllegalStateException.
    * @param name the option name
    * @return `true` if the flag has been set in the command line, `false` otherwise.
    */
  def isFlagEnabled(name: String): Boolean = {
    asJava.asInstanceOf[JCommandLine].isFlagEnabled(name.asInstanceOf[java.lang.String]).asInstanceOf[Boolean]
  }

  /**
    * Checks whether or not the given option has been assigned in the command line.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return `true` if the option has received a value, false otherwise.
    */
  def isOptionAssigned(option: Option): Boolean = {
    asJava.asInstanceOf[JCommandLine].isOptionAssigned(option.asJava).asInstanceOf[Boolean]
  }

  /**
    * Gets the raw values of the given option. Raw values are simple "String", not converted to the option type.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return the list of values, empty if none
    */
  def getRawValuesForOption(option: Option): scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JCommandLine].getRawValuesForOption(option.asJava).asScala.map(x => x.asInstanceOf[String])
  }

  /**
    * Gets the raw values of the given argument. Raw values are simple "String", not converted to the argument type.
    * @param argument the argumentsee <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    * @return the list of values, empty if none
    */
  def getRawValuesForArgument(argument: Argument): scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JCommandLine].getRawValuesForArgument(argument.asJava).asScala.map(x => x.asInstanceOf[String])
  }

  /**
    * Gets the raw value of the given option. Raw values are the values as given in the user command line.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return the value, `null` if none.
    */
  def getRawValueForOption(option: Option): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JCommandLine].getRawValueForOption(option.asJava).asInstanceOf[String])
  }

  /**
    * Checks whether or not the given option accept more values.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return true if the option accepts more values, false otherwise.
    */
  def acceptMoreValues(option: Option): Boolean = {
    asJava.asInstanceOf[JCommandLine].acceptMoreValues(option.asJava).asInstanceOf[Boolean]
  }

  /**
    * Gets the raw value of the given argument. Raw values are the values as given in the user command line.
    * @param arg the argumentsee <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    * @return the value, `null` if none.
    */
  def getRawValueForArgument(arg: Argument): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JCommandLine].getRawValueForArgument(arg.asJava).asInstanceOf[String])
  }

  /**
    * Checks whether or not the given argument has been assigned in the command line.
    * @param arg the argumentsee <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    * @return `true` if the argument has received a value, false otherwise.
    */
  def isArgumentAssigned(arg: Argument): Boolean = {
    asJava.asInstanceOf[JCommandLine].isArgumentAssigned(arg.asJava).asInstanceOf[Boolean]
  }

  /**
    * Checks whether or not the given option has been seen in the user command line.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return `true` if the user command line has used the option
    */
  def isSeenInCommandLine(option: Option): Boolean = {
    asJava.asInstanceOf[JCommandLine].isSeenInCommandLine(option.asJava).asInstanceOf[Boolean]
  }

  /**
    * Checks whether or not the command line is valid, i.e. all constraints from arguments and options have been
    * satisfied. This method is used when the parser validation is disabled.
    * @return `true` if the current CommandLine object is valid. false otherwise.
    */
  def isValid(): Boolean = {
    asJava.asInstanceOf[JCommandLine].isValid().asInstanceOf[Boolean]
  }

  /**
    * Checks whether or not the user has passed a "help" option and is asking for help.
    * @return `true` if the user command line has enabled a "Help" option, false otherwise.
    */
  def isAskingForHelp(): Boolean = {
    asJava.asInstanceOf[JCommandLine].isAskingForHelp().asInstanceOf[Boolean]
  }

}

object CommandLine {
  def apply(asJava: JCommandLine) = new CommandLine(asJava)  
  /**
    * Creates a command line object from the [[io.vertx.scala.core.cli.CLI]]. This object is intended to be used by
    * the parser to set the argument and option values.
    * @param cli the CLI definition
    * @return the command line object
    */
  def create(cli: CLI): CommandLine = {
    CommandLine(JCommandLine.create(cli.asJava.asInstanceOf[JCLI]))
  }

}
