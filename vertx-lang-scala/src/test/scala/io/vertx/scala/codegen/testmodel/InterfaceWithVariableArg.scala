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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.codegen.testmodel.{InterfaceWithVariableArg => JInterfaceWithVariableArg}
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}

/**
  */
class InterfaceWithVariableArg[T, U](private val _asJava: JInterfaceWithVariableArg[T, U]) 
    extends  {

  def asJava: JInterfaceWithVariableArg[T, U] = _asJava

  def setValue(value: U): GenericRefedInterface[U] = {
    _asJava.setValue(value)
    this
  }

  def getValue(): U = {
    _asJava.getValue()
  }

  def setOtherValue(value: T): Unit = {
    _asJava.setOtherValue(value)
  }

  def getOtherValue(): T = {
    _asJava.getOtherValue()
  }

}

object InterfaceWithVariableArg {

  def apply[T, U](_asJava: JInterfaceWithVariableArg[T, U]): InterfaceWithVariableArg[T, U] =
    new InterfaceWithVariableArg(_asJava)

}
