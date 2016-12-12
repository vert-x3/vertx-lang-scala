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
import io.vertx.codegen.testmodel.{FunctionParamTCK => JFunctionParamTCK}
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import java.util.function.{Function => JFunction}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.core.json.JsonObject

/**
  */
class FunctionParamTCK(private val _asJava: JFunctionParamTCK) {

  def asJava: JFunctionParamTCK = _asJava

  def methodWithBasicParam(byteFunc: java.lang.Byte => java.lang.String, shortFunc: java.lang.Short => java.lang.String, integerFunc: java.lang.Integer => java.lang.String, longFunc: java.lang.Long => java.lang.String, floatFunc: java.lang.Float => java.lang.String, doubleFunc: java.lang.Double => java.lang.String, booleanFunc: java.lang.Boolean => java.lang.String, charFunc: java.lang.Character => java.lang.String, stringFunc: java.lang.String => java.lang.String): scala.collection.mutable.Buffer[String] = {
    asJava.methodWithBasicParam(asJavaFunction(byteFunc).asInstanceOf[java.util.function.Function[java.lang.Byte,java.lang.String]], asJavaFunction(shortFunc).asInstanceOf[java.util.function.Function[java.lang.Short,java.lang.String]], asJavaFunction(integerFunc).asInstanceOf[java.util.function.Function[java.lang.Integer,java.lang.String]], asJavaFunction(longFunc).asInstanceOf[java.util.function.Function[java.lang.Long,java.lang.String]], asJavaFunction(floatFunc).asInstanceOf[java.util.function.Function[java.lang.Float,java.lang.String]], asJavaFunction(doubleFunc).asInstanceOf[java.util.function.Function[java.lang.Double,java.lang.String]], asJavaFunction(booleanFunc).asInstanceOf[java.util.function.Function[java.lang.Boolean,java.lang.String]], asJavaFunction(charFunc).asInstanceOf[java.util.function.Function[java.lang.Character,java.lang.String]], asJavaFunction(stringFunc).asInstanceOf[java.util.function.Function[java.lang.String,java.lang.String]]).asScala.map(x => x:String)
  }

  def methodWithJsonParam(objectFunc: JsonObject => java.lang.String, arrayFunc: JsonArray => java.lang.String): scala.collection.mutable.Buffer[String] = {
    asJava.methodWithJsonParam(asJavaFunction(objectFunc).asInstanceOf[java.util.function.Function[io.vertx.core.json.JsonObject,java.lang.String]], asJavaFunction(arrayFunc).asInstanceOf[java.util.function.Function[io.vertx.core.json.JsonArray,java.lang.String]]).asScala.map(x => x:String)
  }

  def methodWithVoidParam(func: java.lang.Void => java.lang.String): String = {
    asJava.methodWithVoidParam(asJavaFunction(func).asInstanceOf[java.util.function.Function[java.lang.Void,java.lang.String]])
  }

  def methodWithUserTypeParam(arg: RefedInterface1, func: JRefedInterface1 => java.lang.String): String = {
    asJava.methodWithUserTypeParam(arg.asJava.asInstanceOf[JRefedInterface1], asJavaFunction(func).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.RefedInterface1,java.lang.String]])
  }

  def methodWithObjectParam(arg: AnyRef, func: java.lang.Object => java.lang.String): String = {
    asJava.methodWithObjectParam(toJava[java.lang.Object](arg).asInstanceOf[Object], asJavaFunction(func).asInstanceOf[java.util.function.Function[Object,java.lang.String]])
  }

  def methodWithDataObjectParam(func: JTestDataObject => java.lang.String): String = {
    asJava.methodWithDataObjectParam(asJavaFunction(func).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.TestDataObject,java.lang.String]])
  }

  def methodWithEnumParam(func: TestEnum => java.lang.String): String = {
    asJava.methodWithEnumParam(asJavaFunction(func).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.TestEnum,java.lang.String]])
  }

  def methodWithListParam(stringFunc: java.util.List[java.lang.String] => java.lang.String): String = {
    asJava.methodWithListParam(asJavaFunction(stringFunc).asInstanceOf[java.util.function.Function[java.util.List[java.lang.String],java.lang.String]])
  }

  def methodWithSetParam(func: java.util.Set[java.lang.String] => java.lang.String): String = {
    asJava.methodWithSetParam(asJavaFunction(func).asInstanceOf[java.util.function.Function[java.util.Set[java.lang.String],java.lang.String]])
  }

  def methodWithMapParam(func: java.util.Map[java.lang.String,java.lang.String] => java.lang.String): String = {
    asJava.methodWithMapParam(asJavaFunction(func).asInstanceOf[java.util.function.Function[java.util.Map[java.lang.String,java.lang.String],java.lang.String]])
  }

  def methodWithGenericParam[T: TypeTag](t: T, func: T => java.lang.String): String = {
    asJava.methodWithGenericParam(toJava[T](t).asInstanceOf[Object], asJavaFunction(func).asInstanceOf[java.util.function.Function[Object,java.lang.String]])
  }

  def methodWithGenericUserTypeParam[T: TypeTag](t: T, func: JGenericRefedInterface[T] => java.lang.String): String = {
    asJava.methodWithGenericUserTypeParam(toJava[T](t).asInstanceOf[Object], asJavaFunction(func).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[Object],java.lang.String]])
  }

  def methodWithBasicReturn(byteFunc: java.lang.String => java.lang.Byte, shortFunc: java.lang.String => java.lang.Short, integerFunc: java.lang.String => java.lang.Integer, longFunc: java.lang.String => java.lang.Long, floatFunc: java.lang.String => java.lang.Float, doubleFunc: java.lang.String => java.lang.Double, booleanFunc: java.lang.String => java.lang.Boolean, charFunc: java.lang.String => java.lang.Character, stringFunc: java.lang.String => java.lang.String): String = {
    asJava.methodWithBasicReturn(asJavaFunction(byteFunc).asInstanceOf[java.util.function.Function[java.lang.String,java.lang.Byte]], asJavaFunction(shortFunc).asInstanceOf[java.util.function.Function[java.lang.String,java.lang.Short]], asJavaFunction(integerFunc).asInstanceOf[java.util.function.Function[java.lang.String,java.lang.Integer]], asJavaFunction(longFunc).asInstanceOf[java.util.function.Function[java.lang.String,java.lang.Long]], asJavaFunction(floatFunc).asInstanceOf[java.util.function.Function[java.lang.String,java.lang.Float]], asJavaFunction(doubleFunc).asInstanceOf[java.util.function.Function[java.lang.String,java.lang.Double]], asJavaFunction(booleanFunc).asInstanceOf[java.util.function.Function[java.lang.String,java.lang.Boolean]], asJavaFunction(charFunc).asInstanceOf[java.util.function.Function[java.lang.String,java.lang.Character]], asJavaFunction(stringFunc).asInstanceOf[java.util.function.Function[java.lang.String,java.lang.String]])
  }

  def methodWithJsonReturn(objectFunc: java.lang.String => JsonObject, arrayFunc: java.lang.String => JsonArray): String = {
    asJava.methodWithJsonReturn(asJavaFunction(objectFunc).asInstanceOf[java.util.function.Function[java.lang.String,io.vertx.core.json.JsonObject]], asJavaFunction(arrayFunc).asInstanceOf[java.util.function.Function[java.lang.String,io.vertx.core.json.JsonArray]])
  }

  def methodWithObjectReturn(func: java.lang.Integer => java.lang.Object): String = {
    asJava.methodWithObjectReturn(asJavaFunction(func).asInstanceOf[java.util.function.Function[java.lang.Integer,Object]])
  }

  def methodWithDataObjectReturn(func: java.lang.String => JTestDataObject): String = {
    asJava.methodWithDataObjectReturn(asJavaFunction(func).asInstanceOf[java.util.function.Function[java.lang.String,io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithEnumReturn(func: java.lang.String => TestEnum): String = {
    asJava.methodWithEnumReturn(asJavaFunction(func).asInstanceOf[java.util.function.Function[java.lang.String,io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithListReturn(func: java.lang.String => java.util.List[java.lang.String]): String = {
    asJava.methodWithListReturn(asJavaFunction(func).asInstanceOf[java.util.function.Function[java.lang.String,java.util.List[java.lang.String]]])
  }

  def methodWithSetReturn(func: java.lang.String => java.util.Set[java.lang.String]): String = {
    asJava.methodWithSetReturn(asJavaFunction(func).asInstanceOf[java.util.function.Function[java.lang.String,java.util.Set[java.lang.String]]])
  }

  def methodWithMapReturn(func: java.lang.String => java.util.Map[java.lang.String,java.lang.String]): String = {
    asJava.methodWithMapReturn(asJavaFunction(func).asInstanceOf[java.util.function.Function[java.lang.String,java.util.Map[java.lang.String,java.lang.String]]])
  }

  def methodWithGenericReturn[T: TypeTag](func: java.lang.Integer => T): String = {
    asJava.methodWithGenericReturn(asJavaFunction(func).asInstanceOf[java.util.function.Function[java.lang.Integer,Object]])
  }

  def methodWithGenericUserTypeReturn[T: TypeTag](func: JGenericRefedInterface[T] => JGenericRefedInterface[T]): String = {
    asJava.methodWithGenericUserTypeReturn(asJavaFunction(func).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[Object],io.vertx.codegen.testmodel.GenericRefedInterface[Object]]])
  }

  def methodWithNullableListParam(func: java.util.List[java.lang.String] => java.lang.String): String = {
    asJava.methodWithNullableListParam(asJavaFunction(func).asInstanceOf[java.util.function.Function[java.util.List[java.lang.String],java.lang.String]])
  }

  def methodWithNullableListReturn(func: java.lang.String => java.util.List[java.lang.String]): String = {
    asJava.methodWithNullableListReturn(asJavaFunction(func).asInstanceOf[java.util.function.Function[java.lang.String,java.util.List[java.lang.String]]])
  }

}

object FunctionParamTCK {

  def apply(_asJava: JFunctionParamTCK): FunctionParamTCK =
    new FunctionParamTCK(_asJava)

}
