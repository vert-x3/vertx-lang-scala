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

  def asJava = _asJava

//cached methods
//fluent methods
  def setName(name: String):CLI = {
    asJava.asInstanceOf[JCLI].setName(name)
    this
  }

  def setDescription(desc: String):CLI = {
    asJava.asInstanceOf[JCLI].setDescription(desc)
    this
  }

  def setSummary(summary: String):CLI = {
    asJava.asInstanceOf[JCLI].setSummary(summary)
    this
  }

  def setHidden(hidden: Boolean):CLI = {
    asJava.asInstanceOf[JCLI].setHidden(hidden)
    this
  }

  def addOption(option: Option):CLI = {
    asJava.asInstanceOf[JCLI].addOption(option.asJava)
    this
  }

  def addOptions(options: scala.collection.mutable.Buffer[Option]):CLI = {
    asJava.asInstanceOf[JCLI].addOptions(options.map(x => x.asJava).asJava)
    this
  }

  def setOptions(options: scala.collection.mutable.Buffer[Option]):CLI = {
    asJava.asInstanceOf[JCLI].setOptions(options.map(x => x.asJava).asJava)
    this
  }

  def addArgument(arg: Argument):CLI = {
    asJava.asInstanceOf[JCLI].addArgument(arg.asJava)
    this
  }

  def addArguments(args: scala.collection.mutable.Buffer[Argument]):CLI = {
    asJava.asInstanceOf[JCLI].addArguments(args.map(x => x.asJava).asJava)
    this
  }

  def setArguments(args: scala.collection.mutable.Buffer[Argument]):CLI = {
    asJava.asInstanceOf[JCLI].setArguments(args.map(x => x.asJava).asJava)
    this
  }

  def removeOption(name: String):CLI = {
    asJava.asInstanceOf[JCLI].removeOption(name)
    this
  }

  def removeArgument(index: Int):CLI = {
    asJava.asInstanceOf[JCLI].removeArgument(index)
    this
  }

//basic methods
  def parse(arguments: scala.collection.mutable.Buffer[String]):CommandLine = {
    CommandLine(asJava.asInstanceOf[JCLI].parse(arguments.map(x => x).asJava))
  }

  def parse(arguments: scala.collection.mutable.Buffer[String],validate: Boolean):CommandLine = {
    CommandLine(asJava.asInstanceOf[JCLI].parse(arguments.map(x => x).asJava,validate))
  }

  def getName():String = {
    asJava.asInstanceOf[JCLI].getName()
  }

  def getDescription():String = {
    asJava.asInstanceOf[JCLI].getDescription()
  }

  def getSummary():String = {
    asJava.asInstanceOf[JCLI].getSummary()
  }

  def isHidden():Boolean = {
    asJava.asInstanceOf[JCLI].isHidden()
  }

  def getOptions():scala.collection.mutable.Buffer[Option] = {
    asJava.asInstanceOf[JCLI].getOptions().asScala.map(x => Option(x))
  }

  def getArguments():scala.collection.mutable.Buffer[Argument] = {
    asJava.asInstanceOf[JCLI].getArguments().asScala.map(x => Argument(x))
  }

  def getOption(name: String):Option = {
    Option(asJava.asInstanceOf[JCLI].getOption(name))
  }

  def getArgument(name: String):Argument = {
    Argument(asJava.asInstanceOf[JCLI].getArgument(name))
  }

  def getArgument(index: Int):Argument = {
    Argument(asJava.asInstanceOf[JCLI].getArgument(index))
  }

}

object CLI{
  def apply(asJava: JCLI) = new CLI(asJava)
//static methods
  def create(name: String):CLI = {
    CLI(JCLI.create(name))
  }

}
