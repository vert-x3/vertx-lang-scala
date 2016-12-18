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

//methods returning a future
//cached methods
//fluent methods
//basic methods
  def cli():CLI = {
    CLI(asJava.asInstanceOf[JCommandLine].cli())
  }

  def allArguments():scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JCommandLine].allArguments().map(x => x)
  }

  def getOptionValue[T](name: String):T = {
    asJava.asInstanceOf[JCommandLine].getOptionValue(name)
  }

  def getArgumentValue[T](name: String):T = {
    asJava.asInstanceOf[JCommandLine].getArgumentValue(name)
  }

  def getArgumentValue[T](index: Int):T = {
    asJava.asInstanceOf[JCommandLine].getArgumentValue(index)
  }

  def isFlagEnabled(name: String):Boolean = {
    asJava.asInstanceOf[JCommandLine].isFlagEnabled(name)
  }

  def isOptionAssigned(option: Option):Boolean = {
    asJava.asInstanceOf[JCommandLine].isOptionAssigned(option.asJava.asInstanceOf[JOption])
  }

  def getRawValuesForOption(option: Option):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JCommandLine].getRawValuesForOption(option.asJava.asInstanceOf[JOption]).map(x => x)
  }

  def getRawValuesForArgument(argument: Argument):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JCommandLine].getRawValuesForArgument(argument.asJava.asInstanceOf[JArgument]).map(x => x)
  }

  def getRawValueForOption(option: Option):String = {
    asJava.asInstanceOf[JCommandLine].getRawValueForOption(option.asJava.asInstanceOf[JOption])
  }

  def acceptMoreValues(option: Option):Boolean = {
    asJava.asInstanceOf[JCommandLine].acceptMoreValues(option.asJava.asInstanceOf[JOption])
  }

  def getRawValueForArgument(arg: Argument):String = {
    asJava.asInstanceOf[JCommandLine].getRawValueForArgument(arg.asJava.asInstanceOf[JArgument])
  }

  def isArgumentAssigned(arg: Argument):Boolean = {
    asJava.asInstanceOf[JCommandLine].isArgumentAssigned(arg.asJava.asInstanceOf[JArgument])
  }

  def isSeenInCommandLine(option: Option):Boolean = {
    asJava.asInstanceOf[JCommandLine].isSeenInCommandLine(option.asJava.asInstanceOf[JOption])
  }

  def isValid():Boolean = {
    asJava.asInstanceOf[JCommandLine].isValid()
  }

  def isAskingForHelp():Boolean = {
    asJava.asInstanceOf[JCommandLine].isAskingForHelp()
  }

}

object CommandLine{
  def apply(asJava: JCommandLine) = new CommandLine(asJava)
//static methods
  def create(cli: CLI):CommandLine = {
    CommandLine(JCommandLine.create(cli.asJava.asInstanceOf[JCLI]))
  }

}
