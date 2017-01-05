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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.codegen.testmodel.{ConcreteHandlerUserType => JConcreteHandlerUserType}
import io.vertx.codegen.testmodel.{AbstractHandlerUserType => JAbstractHandlerUserType}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.{ConcreteHandlerUserTypeExtension => JConcreteHandlerUserTypeExtension}
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.{Factory => JFactory}

/**
  */
class Factory(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
//future methods
}

  object Factory{
    def apply(asJava: JFactory) = new Factory(asJava)  
  //static methods
    def createConcreteHandlerUserType(handler: Handler[RefedInterface1]):ConcreteHandlerUserType = {
      ConcreteHandlerUserType(JFactory.createConcreteHandlerUserType({x: JRefedInterface1 => handler.handle(RefedInterface1(x))}))
    }

    def createAbstractHandlerUserType(handler: Handler[RefedInterface1]):AbstractHandlerUserType = {
      AbstractHandlerUserType(JFactory.createAbstractHandlerUserType({x: JRefedInterface1 => handler.handle(RefedInterface1(x))}))
    }

    def createConcreteHandlerUserTypeExtension(handler: Handler[RefedInterface1]):ConcreteHandlerUserTypeExtension = {
      ConcreteHandlerUserTypeExtension(JFactory.createConcreteHandlerUserTypeExtension({x: JRefedInterface1 => handler.handle(RefedInterface1(x))}))
    }

  }
