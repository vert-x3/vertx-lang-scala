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

/**
  */
class GenericRefedInterface[T](private val _asJava: io.vertx.codegen.testmodel.GenericRefedInterface[T]) {

  def asJava: io.vertx.codegen.testmodel.GenericRefedInterface[T] = _asJava

  def setValue(value: T): Unit = {
    _asJava.setValue(value)
  }

  def getValue(): T = {
    _asJava.getValue()
  }

}

object GenericRefedInterface {

  def apply[T](_asJava: io.vertx.codegen.testmodel.GenericRefedInterface[T]): GenericRefedInterface[T] =
    new GenericRefedInterface(_asJava)

}
