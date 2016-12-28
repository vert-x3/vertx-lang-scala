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
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.{FunctionParamTCK => JFunctionParamTCK}

/**
  */
class FunctionParamTCK(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  def methodWithBasicParam(byteFunc: Byte => String,shortFunc: Short => String,integerFunc: Int => String,longFunc: Long => String,floatFunc: Float => String,doubleFunc: Double => String,booleanFunc: Boolean => String,charFunc: Char => String,stringFunc: String => String):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithBasicParam({x:java.lang.Byte=> byteFunc(x).asInstanceOf[java.lang.String]},{x:java.lang.Short=> shortFunc(x).asInstanceOf[java.lang.String]},{x:java.lang.Integer=> integerFunc(x).asInstanceOf[java.lang.String]},{x:java.lang.Long=> longFunc(x).asInstanceOf[java.lang.String]},{x:java.lang.Float=> floatFunc(x).asInstanceOf[java.lang.String]},{x:java.lang.Double=> doubleFunc(x).asInstanceOf[java.lang.String]},{x:java.lang.Boolean=> booleanFunc(x).asInstanceOf[java.lang.String]},{x:java.lang.Character=> charFunc(x).asInstanceOf[java.lang.String]},{x:java.lang.String=> stringFunc(x).asInstanceOf[java.lang.String]}).asScala.map(x => x)
  }

  def methodWithJsonParam(objectFunc: io.vertx.core.json.JsonObject => String,arrayFunc: io.vertx.core.json.JsonArray => String):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithJsonParam({x:JsonObject=> objectFunc(x).asInstanceOf[java.lang.String]},{x:JsonArray=> arrayFunc(x).asInstanceOf[java.lang.String]}).asScala.map(x => x)
  }

  def methodWithVoidParam(func: () => String):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithVoidParam({x:Void=> func(x).asInstanceOf[java.lang.String]})
  }

  def methodWithUserTypeParam(arg: RefedInterface1,func: RefedInterface1 => String):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithUserTypeParam(arg.asJava.asInstanceOf[JRefedInterface1],{x:JRefedInterface1=> func(RefedInterface1(x)).asInstanceOf[java.lang.String]})
  }

  def methodWithObjectParam(arg: AnyRef,func: AnyRef => String):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithObjectParam(arg,{x:Object=> func(x).asInstanceOf[java.lang.String]})
  }

  def methodWithDataObjectParam(func: TestDataObject => String):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithDataObjectParam({x:JTestDataObject=> func(TestDataObject(x)).asInstanceOf[java.lang.String]})
  }

  def methodWithEnumParam(func: io.vertx.codegen.testmodel.TestEnum => String):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithEnumParam({x:TestEnum=> func(x).asInstanceOf[java.lang.String]})
  }

  def methodWithListParam(stringFunc: scala.collection.mutable.Buffer[String] => String):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithListParam({x:java.util.List[java.lang.String]=> stringFunc(x.asScala.map(x => x)).asInstanceOf[java.lang.String]})
  }

  def methodWithSetParam(func: scala.collection.mutable.Set[String] => String):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithSetParam({x:java.util.Set[java.lang.String]=> func(x.asScala.map(x => x)).asInstanceOf[java.lang.String]})
  }

  def methodWithMapParam(func: scala.collection.mutable.Map[String, String] => String):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithMapParam({x:java.util.Map[String, java.lang.String]=> func(x.asScala.mapValues(x => x)).asInstanceOf[java.lang.String]})
  }

  def methodWithGenericParam[T](t: T,func: T => String):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithGenericParam[T](t,{x:T=> func(x).asInstanceOf[java.lang.String]})
  }

  def methodWithGenericUserTypeParam[T](t: T,func: GenericRefedInterface[T] => String):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithGenericUserTypeParam[T](t,{x:JGenericRefedInterface[T]=> func(GenericRefedInterface[T](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithBasicReturn(byteFunc: String => Byte,shortFunc: String => Short,integerFunc: String => Int,longFunc: String => Long,floatFunc: String => Float,doubleFunc: String => Double,booleanFunc: String => Boolean,charFunc: String => Char,stringFunc: String => String):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithBasicReturn({x:java.lang.String=> byteFunc(x).asInstanceOf[java.lang.Byte]},{x:java.lang.String=> shortFunc(x).asInstanceOf[java.lang.Short]},{x:java.lang.String=> integerFunc(x).asInstanceOf[java.lang.Integer]},{x:java.lang.String=> longFunc(x).asInstanceOf[java.lang.Long]},{x:java.lang.String=> floatFunc(x).asInstanceOf[java.lang.Float]},{x:java.lang.String=> doubleFunc(x).asInstanceOf[java.lang.Double]},{x:java.lang.String=> booleanFunc(x).asInstanceOf[java.lang.Boolean]},{x:java.lang.String=> charFunc(x).asInstanceOf[java.lang.Character]},{x:java.lang.String=> stringFunc(x).asInstanceOf[java.lang.String]})
  }

  def methodWithJsonReturn(objectFunc: String => io.vertx.core.json.JsonObject,arrayFunc: String => io.vertx.core.json.JsonArray):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithJsonReturn({x:java.lang.String=> objectFunc(x)},{x:java.lang.String=> arrayFunc(x)})
  }

  def methodWithObjectReturn(func: Int => AnyRef):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithObjectReturn({x:java.lang.Integer=> func(x)})
  }

  def methodWithDataObjectReturn(func: String => TestDataObject):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithDataObjectReturn({x:java.lang.String=> func(x).asJava})
  }

  def methodWithEnumReturn(func: String => io.vertx.codegen.testmodel.TestEnum):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithEnumReturn({x:java.lang.String=> func(x)})
  }

  def methodWithListReturn(func: String => scala.collection.mutable.Buffer[String]):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithListReturn({x:java.lang.String=> func(x).map(x => x.asInstanceOf[java.lang.String]).asJava})
  }

  def methodWithSetReturn(func: String => scala.collection.mutable.Set[String]):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithSetReturn({x:java.lang.String=> func(x).map(x => x.asInstanceOf[java.lang.String]).asJava})
  }

  def methodWithMapReturn(func: String => scala.collection.mutable.Map[String, String]):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithMapReturn({x:java.lang.String=> func(x).mapValues(x => x.asInstanceOf[java.lang.String]).asJava})
  }

  def methodWithGenericReturn[T](func: Int => T):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithGenericReturn[T]({x:java.lang.Integer=> func(x)})
  }

  def methodWithGenericUserTypeReturn[T](func: GenericRefedInterface[T] => GenericRefedInterface[T]):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithGenericUserTypeReturn[T]({x:JGenericRefedInterface[T]=> func(GenericRefedInterface[T](x)).asJava.asInstanceOf[JGenericRefedInterface[T]]})
  }

  def methodWithNullableListParam(func: scala.collection.mutable.Buffer[String] => String):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithNullableListParam({x:java.util.List[java.lang.String]=> func(x.asScala.map(x => x)).asInstanceOf[java.lang.String]})
  }

  def methodWithNullableListReturn(func: String => scala.collection.mutable.Buffer[String]):String = {
    asJava.asInstanceOf[JFunctionParamTCK].methodWithNullableListReturn({x:java.lang.String=> func(x).map(x => x.asInstanceOf[java.lang.String]).asJava})
  }

//future methods
}

  object FunctionParamTCK{
    def apply(asJava: JFunctionParamTCK) = new FunctionParamTCK(asJava)  
  //static methods
  }
