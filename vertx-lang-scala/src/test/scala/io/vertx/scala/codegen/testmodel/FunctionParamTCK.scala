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
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.TestDataObject
import java.util.function.Function
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.core.json.JsonObject

/**
  */
class FunctionParamTCK(private val _asJava: io.vertx.codegen.testmodel.FunctionParamTCK) {

  def asJava: io.vertx.codegen.testmodel.FunctionParamTCK = _asJava

  def methodWithBasicParam(byteFunc: java.lang.Byte => java.lang.String, shortFunc: java.lang.Short => java.lang.String, integerFunc: java.lang.Integer => java.lang.String, longFunc: java.lang.Long => java.lang.String, floatFunc: java.lang.Float => java.lang.String, doubleFunc: java.lang.Double => java.lang.String, booleanFunc: java.lang.Boolean => java.lang.String, charFunc: java.lang.Character => java.lang.String, stringFunc: java.lang.String => java.lang.String): scala.collection.mutable.Buffer[String] = {
    _asJava.methodWithBasicParam(asJavaFunction(byteFunc), asJavaFunction(shortFunc), asJavaFunction(integerFunc), asJavaFunction(longFunc), asJavaFunction(floatFunc), asJavaFunction(doubleFunc), asJavaFunction(booleanFunc), asJavaFunction(charFunc), asJavaFunction(stringFunc)).asScala.map(x => x:String)
  }

  def methodWithJsonParam(objectFunc: io.vertx.core.json.JsonObject => java.lang.String, arrayFunc: io.vertx.core.json.JsonArray => java.lang.String): scala.collection.mutable.Buffer[String] = {
    _asJava.methodWithJsonParam(asJavaFunction(objectFunc), asJavaFunction(arrayFunc)).asScala.map(x => x:String)
  }

  def methodWithVoidParam(func: java.lang.Void => java.lang.String): String = {
    _asJava.methodWithVoidParam(asJavaFunction(func))
  }

  def methodWithUserTypeParam(arg: RefedInterface1, func: io.vertx.codegen.testmodel.RefedInterface1 => java.lang.String): String = {
    _asJava.methodWithUserTypeParam(arg.asJava.asInstanceOf[io.vertx.codegen.testmodel.RefedInterface1], asJavaFunction(func))
  }

  def methodWithObjectParam(arg: AnyRef, func: java.lang.Object => java.lang.String): String = {
    _asJava.methodWithObjectParam(arg, asJavaFunction(func))
  }

  def methodWithDataObjectParam(func: io.vertx.codegen.testmodel.TestDataObject => java.lang.String): String = {
    _asJava.methodWithDataObjectParam(asJavaFunction(func))
  }

  def methodWithEnumParam(func: io.vertx.codegen.testmodel.TestEnum => java.lang.String): String = {
    _asJava.methodWithEnumParam(asJavaFunction(func))
  }

  def methodWithListParam(stringFunc: java.util.List[java.lang.String] => java.lang.String): String = {
    _asJava.methodWithListParam(asJavaFunction(stringFunc))
  }

  def methodWithSetParam(func: java.util.Set[java.lang.String] => java.lang.String): String = {
    _asJava.methodWithSetParam(asJavaFunction(func))
  }

  def methodWithMapParam(func: java.util.Map[java.lang.String,java.lang.String] => java.lang.String): String = {
    _asJava.methodWithMapParam(asJavaFunction(func))
  }

  def methodWithGenericParam[T](t: T, func: T => java.lang.String): String = {
    _asJava.methodWithGenericParam(t, asJavaFunction(func))
  }

  def methodWithGenericUserTypeParam[T](t: T, func: io.vertx.codegen.testmodel.GenericRefedInterface[T] => java.lang.String): String = {
    _asJava.methodWithGenericUserTypeParam(t, asJavaFunction(func))
  }

  def methodWithBasicReturn(byteFunc: java.lang.String => java.lang.Byte, shortFunc: java.lang.String => java.lang.Short, integerFunc: java.lang.String => java.lang.Integer, longFunc: java.lang.String => java.lang.Long, floatFunc: java.lang.String => java.lang.Float, doubleFunc: java.lang.String => java.lang.Double, booleanFunc: java.lang.String => java.lang.Boolean, charFunc: java.lang.String => java.lang.Character, stringFunc: java.lang.String => java.lang.String): String = {
    _asJava.methodWithBasicReturn(asJavaFunction(byteFunc), asJavaFunction(shortFunc), asJavaFunction(integerFunc), asJavaFunction(longFunc), asJavaFunction(floatFunc), asJavaFunction(doubleFunc), asJavaFunction(booleanFunc), asJavaFunction(charFunc), asJavaFunction(stringFunc))
  }

  def methodWithJsonReturn(objectFunc: java.lang.String => io.vertx.core.json.JsonObject, arrayFunc: java.lang.String => io.vertx.core.json.JsonArray): String = {
    _asJava.methodWithJsonReturn(asJavaFunction(objectFunc), asJavaFunction(arrayFunc))
  }

  def methodWithObjectReturn(func: java.lang.Integer => java.lang.Object): String = {
    _asJava.methodWithObjectReturn(asJavaFunction(func))
  }

  def methodWithDataObjectReturn(func: java.lang.String => io.vertx.codegen.testmodel.TestDataObject): String = {
    _asJava.methodWithDataObjectReturn(asJavaFunction(func))
  }

  def methodWithEnumReturn(func: java.lang.String => io.vertx.codegen.testmodel.TestEnum): String = {
    _asJava.methodWithEnumReturn(asJavaFunction(func))
  }

  def methodWithListReturn(func: java.lang.String => java.util.List[java.lang.String]): String = {
    _asJava.methodWithListReturn(asJavaFunction(func))
  }

  def methodWithSetReturn(func: java.lang.String => java.util.Set[java.lang.String]): String = {
    _asJava.methodWithSetReturn(asJavaFunction(func))
  }

  def methodWithMapReturn(func: java.lang.String => java.util.Map[java.lang.String,java.lang.String]): String = {
    _asJava.methodWithMapReturn(asJavaFunction(func))
  }

  def methodWithGenericReturn[T](func: java.lang.Integer => T): String = {
    _asJava.methodWithGenericReturn(asJavaFunction(func))
  }

  def methodWithGenericUserTypeReturn[T](func: io.vertx.codegen.testmodel.GenericRefedInterface[T] => io.vertx.codegen.testmodel.GenericRefedInterface[T]): String = {
    _asJava.methodWithGenericUserTypeReturn(asJavaFunction(func))
  }

  def methodWithNullableListParam(func: java.util.List[java.lang.String] => java.lang.String): String = {
    _asJava.methodWithNullableListParam(asJavaFunction(func))
  }

  def methodWithNullableListReturn(func: java.lang.String => java.util.List[java.lang.String]): String = {
    _asJava.methodWithNullableListReturn(asJavaFunction(func))
  }

}

object FunctionParamTCK {

  def apply(_asJava: io.vertx.codegen.testmodel.FunctionParamTCK): FunctionParamTCK =
    new FunctionParamTCK(_asJava)

}
