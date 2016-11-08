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

package com.acme.scala.pkg

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import com.acme.pkg.{MyInterface => JMyInterface}
import com.acme.pkg.sub.{SubInterface => JSubInterface}
import com.acme.scala.pkg.sub.SubInterface
import io.vertx.codegen.testmodel.{TestInterface => JTestInterface}
import io.vertx.scala.codegen.testmodel.TestInterface

/**
  */
class MyInterface(private val _asJava: JMyInterface) {

  def asJava: JMyInterface = _asJava

  def sub(): SubInterface = {
    SubInterface.apply(_asJava.sub())
  }

  def method(): TestInterface = {
    TestInterface.apply(_asJava.method())
  }

}

object MyInterface {

  def apply(_asJava: JMyInterface): MyInterface =
    new MyInterface(_asJava)

  def create(): MyInterface = {
    MyInterface.apply(com.acme.pkg.MyInterface.create())
  }

}
