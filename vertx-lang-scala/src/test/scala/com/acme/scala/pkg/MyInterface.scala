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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import com.acme.pkg.sub.{SubInterface => JSubInterface}
import com.acme.pkg.{MyInterface => JMyInterface}
import com.acme.scala.pkg.sub.SubInterface
import io.vertx.codegen.testmodel.{TestInterface => JTestInterface}
import io.vertx.scala.codegen.testmodel.TestInterface

/**
  */
class MyInterface(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  def sub():SubInterface = {
    SubInterface(asJava.asInstanceOf[JMyInterface].sub())
  }

  def method():TestInterface = {
    TestInterface(asJava.asInstanceOf[JMyInterface].method())
  }

//future methods
}

  object MyInterface{
    def apply(asJava: Object) = new MyInterface(asJava)  
  //static methods
    def create():MyInterface = {
      MyInterface(JMyInterface.create())
    }

  }
