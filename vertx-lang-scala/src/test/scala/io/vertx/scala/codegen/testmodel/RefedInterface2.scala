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
import io.vertx.codegen.testmodel.{RefedInterface2 => JRefedInterface2}

/**
  */
trait RefedInterface2 {

  def asJava: java.lang.Object

  def getString(): String

  def setString(str: String): RefedInterface2

}

object RefedInterface2 {

  def apply(_asJava: io.vertx.codegen.testmodel.RefedInterface2): RefedInterface2 =
    new RefedInterface2Impl(_asJava)

  private class RefedInterface2Impl(private val _asJava: io.vertx.codegen.testmodel.RefedInterface2) extends RefedInterface2 {

    def asJava: io.vertx.codegen.testmodel.RefedInterface2 = _asJava

    def getString(): String = {
        _asJava.getString()
    }

    def setString(str: String): RefedInterface2 = {
        _asJava.setString(str)
      this
    }

  }

}
