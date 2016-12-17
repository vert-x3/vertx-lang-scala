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

import io.vertx.scala.core.cli.Option
import io.vertx.core.cli.{Option => JOption}
import io.vertx.core.cli.{CommandLine => JCommandLine}
import io.vertx.scala.core.cli.CLI
import io.vertx.core.cli.{CLI => JCLI}
import io.vertx.scala.core.cli.Argument
import io.vertx.core.cli.{Argument => JArgument}

/**
  * The parser transforms a CLI (a model) into an [[io.vertx.scala.core.cli.CommandLine]]. This [[io.vertx.scala.core.cli.CommandLine]]
  * has stored the argument and option values. Only  instance of parser should create
  * objects of this type.
  */
class CommandLine(private val _asJava: Object) {

def asJava = _asJava.asInstanceOf[JCommandLine]
//methods returning a future
//cached methods
//fluent methods
//basic methods
  def cli():CLI = {
    asJava.cli( )
  }

  def allArguments():scala.collection.mutable.Buffer[String] = {
    asJava.allArguments( )
  }

  def getOptionValue(name: String):T = {
    asJava.getOptionValue( )
  }

  def getArgumentValue(name: String):T = {
    asJava.getArgumentValue( )
  }

  def getArgumentValue(index: Int):T = {
    asJava.getArgumentValue( )
  }

  def isFlagEnabled(name: String):Boolean = {
    asJava.isFlagEnabled( )
  }

  def isOptionAssigned(option: Option):Boolean = {
    asJava.isOptionAssigned( )
  }

  def getRawValuesForOption(option: Option):scala.collection.mutable.Buffer[String] = {
    asJava.getRawValuesForOption( )
  }

  def getRawValuesForArgument(argument: Argument):scala.collection.mutable.Buffer[String] = {
    asJava.getRawValuesForArgument( )
  }

  def getRawValueForOption(option: Option):String = {
    asJava.getRawValueForOption( )
  }

  def acceptMoreValues(option: Option):Boolean = {
    asJava.acceptMoreValues( )
  }

  def getRawValueForArgument(arg: Argument):String = {
    asJava.getRawValueForArgument( )
  }

  def isArgumentAssigned(arg: Argument):Boolean = {
    asJava.isArgumentAssigned( )
  }

  def isSeenInCommandLine(option: Option):Boolean = {
    asJava.isSeenInCommandLine( )
  }

  def isValid():Boolean = {
    asJava.isValid( )
  }

  def isAskingForHelp():Boolean = {
    asJava.isAskingForHelp( )
  }

}

object CommandLine{
//in object!
//static methods
  def create(cli: CLI):CommandLine = {
    JCommandLine.create( )
  }

}
