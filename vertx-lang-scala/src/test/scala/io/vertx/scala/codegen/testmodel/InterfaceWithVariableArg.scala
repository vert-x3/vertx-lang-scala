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

package io.vertx.scala.codegen.testmodel

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import io.vertx.codegen.testmodel.{InterfaceWithVariableArg => JInterfaceWithVariableArg}
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}

/**
  */
class InterfaceWithVariableArg[T,U](private val _asJava: Object, private val _useTypeTags:Boolean = false) 
    extends GenericRefedInterface[U](_asJava) {


//cached methods
//fluent methods
  override def setValue(value: U):GenericRefedInterface[U] = {
    asJava.asInstanceOf[JInterfaceWithVariableArg[T,U]].setValue(value)
    this
  }

//default methods
//basic methods
  override def getValue():U = {
    asJava.asInstanceOf[JInterfaceWithVariableArg[T,U]].getValue()
  }

  def setOtherValue(value: T):Unit = {
    asJava.asInstanceOf[JInterfaceWithVariableArg[T,U]].setOtherValue(value)
  }

  def getOtherValue():T = {
    asJava.asInstanceOf[JInterfaceWithVariableArg[T,U]].getOtherValue()
  }

//future methods
}

  object InterfaceWithVariableArg{
    def apply[T,U](asJava: Object, useTypeTags:Boolean = false) = new InterfaceWithVariableArg[T,U](asJava, useTypeTags)  
  //static methods
  }
