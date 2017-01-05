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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
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

//cached methods
//fluent methods
//default methods
  //io.vertx.core.cli.CommandLine
  def getRawValues(option: Option):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JCommandLine].getRawValues(option.asJava).asScala.map(x => x.asInstanceOf[String])
  }

//basic methods
  def cli():CLI = {
    CLI(asJava.asInstanceOf[JCommandLine].cli())
  }

  def allArguments():scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JCommandLine].allArguments().asScala.map(x => x.asInstanceOf[String])
  }

  def getOptionValue[T:TypeTag](name: String):T = {
    toScala[T](asJava.asInstanceOf[JCommandLine].getOptionValue[Object](name.asInstanceOf[java.lang.String]))
  }

  def getArgumentValue[T:TypeTag](name: String):T = {
    toScala[T](asJava.asInstanceOf[JCommandLine].getArgumentValue[Object](name.asInstanceOf[java.lang.String]))
  }

  def getArgumentValue[T:TypeTag](index: Int):T = {
    toScala[T](asJava.asInstanceOf[JCommandLine].getArgumentValue[Object](index.asInstanceOf[java.lang.Integer]))
  }

  def isFlagEnabled(name: String):Boolean = {
    asJava.asInstanceOf[JCommandLine].isFlagEnabled(name.asInstanceOf[java.lang.String]).asInstanceOf[Boolean]
  }

  def isOptionAssigned(option: Option):Boolean = {
    asJava.asInstanceOf[JCommandLine].isOptionAssigned(option.asJava).asInstanceOf[Boolean]
  }

  def getRawValuesForOption(option: Option):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JCommandLine].getRawValuesForOption(option.asJava).asScala.map(x => x.asInstanceOf[String])
  }

  def getRawValuesForArgument(argument: Argument):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JCommandLine].getRawValuesForArgument(argument.asJava).asScala.map(x => x.asInstanceOf[String])
  }

  def getRawValueForOption(option: Option):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JCommandLine].getRawValueForOption(option.asJava).asInstanceOf[String])
  }

  def acceptMoreValues(option: Option):Boolean = {
    asJava.asInstanceOf[JCommandLine].acceptMoreValues(option.asJava).asInstanceOf[Boolean]
  }

  def getRawValueForArgument(arg: Argument):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JCommandLine].getRawValueForArgument(arg.asJava).asInstanceOf[String])
  }

  def isArgumentAssigned(arg: Argument):Boolean = {
    asJava.asInstanceOf[JCommandLine].isArgumentAssigned(arg.asJava).asInstanceOf[Boolean]
  }

  def isSeenInCommandLine(option: Option):Boolean = {
    asJava.asInstanceOf[JCommandLine].isSeenInCommandLine(option.asJava).asInstanceOf[Boolean]
  }

  def isValid():Boolean = {
    asJava.asInstanceOf[JCommandLine].isValid().asInstanceOf[Boolean]
  }

  def isAskingForHelp():Boolean = {
    asJava.asInstanceOf[JCommandLine].isAskingForHelp().asInstanceOf[Boolean]
  }

//future methods
}

  object CommandLine{
    def apply(asJava: JCommandLine) = new CommandLine(asJava)  
  //static methods
    def create(cli: CLI):CommandLine = {
      CommandLine(JCommandLine.create(cli.asJava.asInstanceOf[JCLI]))
    }

  }
