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
  * Defines a command line argument. Unlike options, argument don't have names and are identified using an index. The
  * first index is 0 (because we are in the computer world).
  */

class Argument(val java: io.vertx.core.cli.Argument) {
          def setArgName(value:String) = {
          java.setArgName(value)
          this
  }
            def getArgName = {
    java.getArgName()
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
            def setHidden(value:Boolean) = {
          java.setHidden(value)
          this
  }
            def isHidden = {
    java.isHidden()
  }
            def setIndex(value:Int) = {
          java.setIndex(value)
          this
  }
            def getIndex = {
    java.getIndex()
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
  }
object Argument {
  type ArgumentJava = io.vertx.core.cli.Argument
  
  def apply(t: ArgumentJava) = {
    if(t != null)
      new Argument(t)
    else
      null
   
  }
  
  def fromJson(json: JsonObject):Argument = {
    if(json != null)
      new Argument(new ArgumentJava(json))
    else
      null
  }
}
