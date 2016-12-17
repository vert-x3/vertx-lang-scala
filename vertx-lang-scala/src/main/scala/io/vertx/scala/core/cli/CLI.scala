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
import io.vertx.scala.core.cli.CommandLine
import io.vertx.core.cli.{CommandLine => JCommandLine}
import io.vertx.core.cli.{CLI => JCLI}
import io.vertx.scala.core.cli.Argument
import io.vertx.core.cli.{Argument => JArgument}

/**
  * Interface defining a command-line interface (in other words a command such as 'run', 'ls'...).
  * This interface is polyglot to ease reuse such as in Vert.x Shell.
  * <p/>
  * A command line interface has a name, and defines a set of options and arguments. Options are key-value pair such
  * as `-foo=bar` or `-flag`. The supported formats depend on the used parser. Arguments are unlike
  * options raw values. Options are defined using
  * <a href="../../../../../../../cheatsheet/Option.html">Option</a>, while argument are defined using <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>.
  * <p/>
  * Command line interfaces also define a summary and a description. These attributes are used in the usage generation
  * . To disable the help generation, set the `hidden` attribute to `true`.
  * <p/>
  * Command Line Interface object does not contains "value", it's a model. It must be evaluated by a
  * parser that returns a [[io.vertx.scala.core.cli.CommandLine]] object containing the argument and option values.
  */
class CLI(private val _asJava: Object) {

def asJava = _asJava.asInstanceOf[JCLI]
//methods returning a future
//cached methods
//fluent methods
  def setName(name: String):CLI = {
    asJava.setName( )
    this
  }

  def setDescription(desc: String):CLI = {
    asJava.setDescription( )
    this
  }

  def setSummary(summary: String):CLI = {
    asJava.setSummary( )
    this
  }

  def setHidden(hidden: Boolean):CLI = {
    asJava.setHidden( )
    this
  }

  def addOption(option: Option):CLI = {
    asJava.addOption( )
    this
  }

  def addOptions(options: scala.collection.mutable.Buffer[Option]):CLI = {
    asJava.addOptions( )
    this
  }

  def setOptions(options: scala.collection.mutable.Buffer[Option]):CLI = {
    asJava.setOptions( )
    this
  }

  def addArgument(arg: Argument):CLI = {
    asJava.addArgument( )
    this
  }

  def addArguments(args: scala.collection.mutable.Buffer[Argument]):CLI = {
    asJava.addArguments( )
    this
  }

  def setArguments(args: scala.collection.mutable.Buffer[Argument]):CLI = {
    asJava.setArguments( )
    this
  }

  def removeOption(name: String):CLI = {
    asJava.removeOption( )
    this
  }

  def removeArgument(index: Int):CLI = {
    asJava.removeArgument( )
    this
  }

//basic methods
  def parse(arguments: scala.collection.mutable.Buffer[String]):CommandLine = {
    asJava.parse( )
  }

  def parse(arguments: scala.collection.mutable.Buffer[String],validate: Boolean):CommandLine = {
    asJava.parse( )
  }

  def getName():String = {
    asJava.getName( )
  }

  def getDescription():String = {
    asJava.getDescription( )
  }

  def getSummary():String = {
    asJava.getSummary( )
  }

  def isHidden():Boolean = {
    asJava.isHidden( )
  }

  def getOptions():scala.collection.mutable.Buffer[Option] = {
    asJava.getOptions( )
  }

  def getArguments():scala.collection.mutable.Buffer[Argument] = {
    asJava.getArguments( )
  }

  def getOption(name: String):Option = {
    asJava.getOption( )
  }

  def getArgument(name: String):Argument = {
    asJava.getArgument( )
  }

  def getArgument(index: Int):Argument = {
    asJava.getArgument( )
  }

}

object CLI{
//in object!
//static methods
  def create(name: String):CLI = {
    JCLI.create( )
  }

}
