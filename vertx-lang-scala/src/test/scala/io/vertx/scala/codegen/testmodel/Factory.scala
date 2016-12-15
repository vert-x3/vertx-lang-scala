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
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.codegen.testmodel.{Factory => JFactory}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.{ConcreteHandlerUserType => JConcreteHandlerUserType}
import io.vertx.codegen.testmodel.{AbstractHandlerUserType => JAbstractHandlerUserType}
import io.vertx.codegen.testmodel.{ConcreteHandlerUserTypeExtension => JConcreteHandlerUserTypeExtension}

/**
  */
class Factory(private val _asJava: Object) {

  def asJava: Object = _asJava

}

object Factory {

  def apply(_asJava: Object): Factory =
    new Factory(_asJava)

  def createConcreteHandlerUserType(handler: io.vertx.core.Handler[RefedInterface1]): ConcreteHandlerUserType = {
    ConcreteHandlerUserType.apply(io.vertx.codegen.testmodel.Factory.createConcreteHandlerUserType(funcToMappedHandler[JRefedInterface1, RefedInterface1](RefedInterface1.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.RefedInterface1]]))
  }

  def createAbstractHandlerUserType(handler: io.vertx.core.Handler[RefedInterface1]): AbstractHandlerUserType = {
    AbstractHandlerUserType.apply(io.vertx.codegen.testmodel.Factory.createAbstractHandlerUserType(funcToMappedHandler[JRefedInterface1, RefedInterface1](RefedInterface1.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.RefedInterface1]]))
  }

  def createConcreteHandlerUserTypeExtension(handler: io.vertx.core.Handler[RefedInterface1]): ConcreteHandlerUserTypeExtension = {
    ConcreteHandlerUserTypeExtension.apply(io.vertx.codegen.testmodel.Factory.createConcreteHandlerUserTypeExtension(funcToMappedHandler[JRefedInterface1, RefedInterface1](RefedInterface1.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.RefedInterface1]]))
  }

}
