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

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Models command line options. Options are values passed to a command line interface using -x or --x. Supported
  * syntaxes depend on the parser.
  * <p/>
  * Short name is generally used with a single dash, while long name requires a double-dash.
  */

class Option(val asJava: io.vertx.core.cli.Option) {
  def setArgName(value:String) = {
    asJava.setArgName(value)
    this
  }
  def getArgName = {
    asJava.getArgName()
  }
  def addChoice(value:String) = {
    asJava.addChoice(value)
    this
  }
  def setChoices(value:Set[String]) = {
    asJava.setChoices(value)
    this
  }
  def getChoices = {
    asJava.getChoices()
  }
  def setDefaultValue(value:String) = {
    asJava.setDefaultValue(value)
    this
  }
  def getDefaultValue = {
    asJava.getDefaultValue()
  }
  def setDescription(value:String) = {
    asJava.setDescription(value)
    this
  }
  def getDescription = {
    asJava.getDescription()
  }
  def setFlag(value:Boolean) = {
    asJava.setFlag(value)
    this
  }
  def isFlag = {
    asJava.isFlag()
  }
  def setHelp(value:Boolean) = {
    asJava.setHelp(value)
    this
  }
  def isHelp = {
    asJava.isHelp()
  }
  def setHidden(value:Boolean) = {
    asJava.setHidden(value)
    this
  }
  def isHidden = {
    asJava.isHidden()
  }
  def setLongName(value:String) = {
    asJava.setLongName(value)
    this
  }
  def getLongName = {
    asJava.getLongName()
  }
  def setMultiValued(value:Boolean) = {
    asJava.setMultiValued(value)
    this
  }
  def isMultiValued = {
    asJava.isMultiValued()
  }
  def setRequired(value:Boolean) = {
    asJava.setRequired(value)
    this
  }
  def isRequired = {
    asJava.isRequired()
  }
  def setShortName(value:String) = {
    asJava.setShortName(value)
    this
  }
  def getShortName = {
    asJava.getShortName()
  }
  def setSingleValued(value:Boolean) = {
    asJava.setSingleValued(value)
    this
  }
  def isSingleValued = {
    asJava.isSingleValued()
  }
}

object Option {
  type OptionJava = io.vertx.core.cli.Option
  
  def apply(t: OptionJava) = {
    if(t != null)
      new Option(t)
    else
      null
   
  }
  
  def fromJson(json: JsonObject):Option = {
    if(json != null)
      new Option(new OptionJava(json))
    else
      null
  }
}
