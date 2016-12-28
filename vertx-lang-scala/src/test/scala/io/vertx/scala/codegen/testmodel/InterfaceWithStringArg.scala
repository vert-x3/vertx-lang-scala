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
import io.vertx.codegen.testmodel.{InterfaceWithStringArg => JInterfaceWithStringArg}
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}

/**
  */
class InterfaceWithStringArg(private val _asJava: Object) 
    extends GenericRefedInterface[String](_asJava) {


//cached methods
//fluent methods
  override def setValue(value: String):GenericRefedInterface[String] = {
    asJava.asInstanceOf[JInterfaceWithStringArg].setValue(value)
    this
  }

//default methods
//basic methods
  override def getValue():String = {
    asJava.asInstanceOf[JInterfaceWithStringArg].getValue()
  }

  def meth():Unit = {
    asJava.asInstanceOf[JInterfaceWithStringArg].meth()
  }

//future methods
}

  object InterfaceWithStringArg{
    def apply(asJava: JInterfaceWithStringArg) = new InterfaceWithStringArg(asJava)  
  //static methods
  }
