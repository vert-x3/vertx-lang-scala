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
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.{InterfaceWithApiArg => JInterfaceWithApiArg}
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}

/**
  */
class InterfaceWithApiArg(private val _asJava: Object) 
    extends GenericRefedInterface[RefedInterface1](_asJava) {


//cached methods
//fluent methods
  override def setValue(value: RefedInterface1):GenericRefedInterface[RefedInterface1] = {
    asJava.asInstanceOf[JInterfaceWithApiArg].setValue(value.asJava.asInstanceOf[JRefedInterface1])
    this
  }

//default methods
//basic methods
  override def getValue():RefedInterface1 = {
    RefedInterface1(asJava.asInstanceOf[JInterfaceWithApiArg].getValue())
  }

  def meth():Unit = {
    asJava.asInstanceOf[JInterfaceWithApiArg].meth()
  }

}

  object InterfaceWithApiArg{
    def apply(asJava: JInterfaceWithApiArg) = new InterfaceWithApiArg(asJava)  
  //static methods
  }
