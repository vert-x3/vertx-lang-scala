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
import io.vertx.core.Handler

/**
  */
class Factory(private val _asJava: io.vertx.codegen.testmodel.Factory) {

  def asJava: io.vertx.codegen.testmodel.Factory = _asJava

}

object Factory {

  def apply(_asJava: io.vertx.codegen.testmodel.Factory): io.vertx.scala.codegen.testmodel.Factory =
    new io.vertx.scala.codegen.testmodel.Factory(_asJava)

  def createConcreteHandlerUserType(handler: io.vertx.scala.codegen.testmodel.RefedInterface1 => Unit): io.vertx.scala.codegen.testmodel.ConcreteHandlerUserType = {
    ConcreteHandlerUserType.apply(io.vertx.codegen.testmodel.Factory.createConcreteHandlerUserType(funcToMappedHandler(RefedInterface1.apply)(handler)))
  }

  def createAbstractHandlerUserType(handler: io.vertx.scala.codegen.testmodel.RefedInterface1 => Unit): io.vertx.scala.codegen.testmodel.AbstractHandlerUserType = {
    AbstractHandlerUserType.apply(io.vertx.codegen.testmodel.Factory.createAbstractHandlerUserType(funcToMappedHandler(RefedInterface1.apply)(handler)))
  }

  def createConcreteHandlerUserTypeExtension(handler: io.vertx.scala.codegen.testmodel.RefedInterface1 => Unit): io.vertx.scala.codegen.testmodel.ConcreteHandlerUserTypeExtension = {
    ConcreteHandlerUserTypeExtension.apply(io.vertx.codegen.testmodel.Factory.createConcreteHandlerUserTypeExtension(funcToMappedHandler(RefedInterface1.apply)(handler)))
  }

}
