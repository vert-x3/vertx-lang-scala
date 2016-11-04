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
import io.vertx.core.cli.{Argument => JArgument}

/**
  * Defines a command line argument. Unlike options, argument don't have names and are identified using an index. The
  * first index is 0 (because we are in the computer world).
  */

class Argument(val asJava: JArgument) {

  /**
    * Sets the argument name of this <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>.
    */
  def setArgName(value:String) = {
    asJava.setArgName(value)
    this
  }
  def getArgName = {
    asJava.getArgName()
  }

  /**
    * Sets the default value of this <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>.
    */
  def setDefaultValue(value:String) = {
    asJava.setDefaultValue(value)
    this
  }
  def getDefaultValue = {
    asJava.getDefaultValue()
  }

  /**
    * Sets the description of the <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>.
    */
  def setDescription(value:String) = {
    asJava.setDescription(value)
    this
  }
  def getDescription = {
    asJava.getDescription()
  }

  /**
    * Sets whether or not the current <a href="../../../../../../../cheatsheet/Argument.html">Argument</a> is hidden.
    */
  def setHidden(value:Boolean) = {
    asJava.setHidden(value)
    this
  }
  def isHidden = {
    asJava.isHidden()
  }

  /**
    * Sets the argument index.
    */
  def setIndex(value:Int) = {
    asJava.setIndex(value)
    this
  }
  def getIndex = {
    asJava.getIndex()
  }

  /**
    * Sets whether or not the argument can receive several values. Only the last argument can receive several values.
    */
  def setMultiValued(value:Boolean) = {
    asJava.setMultiValued(value)
    this
  }
  def isMultiValued = {
    asJava.isMultiValued()
  }

  /**
    * Sets whether or not the current <a href="../../../../../../../cheatsheet/Argument.html">Argument</a> is required.
    */
  def setRequired(value:Boolean) = {
    asJava.setRequired(value)
    this
  }
  def isRequired = {
    asJava.isRequired()
  }
}

object Argument {
  
  def apply() = {
    new Argument(new JArgument(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: JArgument) = {
    if(t != null)
      new Argument(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):Argument = {
    if(json != null)
      new Argument(new JArgument(json))
    else
      null
  }
}
