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

class Option(val java: io.vertx.core.cli.Option) {
  def setArgName(value:String) = {
    java.setArgName(value)
    this
  }
  def getArgName = {
    java.getArgName()
  }
  def addChoice(value:String) = {
    java.addChoice(value)
    this
  }
  def setChoices(value:Set[String]) = {
    java.setChoices(value)
    this
  }
  def getChoices = {
    java.getChoices()
  }
  def setDefaultValue(value:String) = {
    java.setDefaultValue(value)
    this
  }
  def getDefaultValue = {
    java.getDefaultValue()
  }
  def setDescription(value:String) = {
    java.setDescription(value)
    this
  }
  def getDescription = {
    java.getDescription()
  }
  def setFlag(value:Boolean) = {
    java.setFlag(value)
    this
  }
  def isFlag = {
    java.isFlag()
  }
  def setHelp(value:Boolean) = {
    java.setHelp(value)
    this
  }
  def isHelp = {
    java.isHelp()
  }
  def setHidden(value:Boolean) = {
    java.setHidden(value)
    this
  }
  def isHidden = {
    java.isHidden()
  }
  def setLongName(value:String) = {
    java.setLongName(value)
    this
  }
  def getLongName = {
    java.getLongName()
  }
  def setMultiValued(value:Boolean) = {
    java.setMultiValued(value)
    this
  }
  def isMultiValued = {
    java.isMultiValued()
  }
  def setRequired(value:Boolean) = {
    java.setRequired(value)
    this
  }
  def isRequired = {
    java.isRequired()
  }
  def setShortName(value:String) = {
    java.setShortName(value)
    this
  }
  def getShortName = {
    java.getShortName()
  }
  def setSingleValued(value:Boolean) = {
    java.setSingleValued(value)
    this
  }
  def isSingleValued = {
    java.isSingleValued()
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
