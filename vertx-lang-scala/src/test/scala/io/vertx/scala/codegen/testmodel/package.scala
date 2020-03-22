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


package io.vertx.scala.codegen

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.codegen.testmodel.{ConcreteHandlerUserType => JConcreteHandlerUserType}
import io.vertx.codegen.testmodel.{AbstractHandlerUserType => JAbstractHandlerUserType}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.{ConcreteHandlerUserTypeExtension => JConcreteHandlerUserTypeExtension}
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.{TestInterface => JTestInterface}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.codegen.testmodel.{SuperInterface1 => JSuperInterface1}
import io.vertx.codegen.testmodel.{RefedInterface2 => JRefedInterface2}
import io.vertx.codegen.testmodel.{SuperInterface2 => JSuperInterface2}
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.TestGenEnum
package object testmodel{







  /**

    */

  implicit class CollectionTCKScala(val asJava: io.vertx.codegen.testmodel.CollectionTCK) extends AnyVal {


def methodWithHandlerAsyncResultListStringFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]()
      asJava.methodWithHandlerAsyncResultListString(new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultListIntegerFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Integer]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Integer]]()
      asJava.methodWithHandlerAsyncResultListInteger(new Handler[AsyncResult[java.util.List[java.lang.Integer]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Integer]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetStringFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.String]]()
      asJava.methodWithHandlerAsyncResultSetString(new Handler[AsyncResult[java.util.Set[java.lang.String]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetIntegerFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Integer]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Integer]]()
      asJava.methodWithHandlerAsyncResultSetInteger(new Handler[AsyncResult[java.util.Set[java.lang.Integer]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Integer]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultListVertxGenFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithHandlerAsyncResultListVertxGen(new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultListAbstractVertxGenFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.RefedInterface2]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.RefedInterface2]]()
      asJava.methodWithHandlerAsyncResultListAbstractVertxGen(new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface2]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface2]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultListJsonObjectFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]()
      asJava.methodWithHandlerAsyncResultListJsonObject(new Handler[AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultListComplexJsonObjectFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]()
      asJava.methodWithHandlerAsyncResultListComplexJsonObject(new Handler[AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultListJsonArrayFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]]()
      asJava.methodWithHandlerAsyncResultListJsonArray(new Handler[AsyncResult[java.util.List[io.vertx.core.json.JsonArray]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.core.json.JsonArray]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultListComplexJsonArrayFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]]()
      asJava.methodWithHandlerAsyncResultListComplexJsonArray(new Handler[AsyncResult[java.util.List[io.vertx.core.json.JsonArray]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.core.json.JsonArray]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultListDataObjectFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestDataObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestDataObject]]()
      asJava.methodWithHandlerAsyncResultListDataObject(new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultListEnumFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]()
      asJava.methodWithHandlerAsyncResultListEnum(new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetVertxGenFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithHandlerAsyncResultSetVertxGen(new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetAbstractVertxGenFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.RefedInterface2]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.RefedInterface2]]()
      asJava.methodWithHandlerAsyncResultSetAbstractVertxGen(new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface2]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface2]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetJsonObjectFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]]()
      asJava.methodWithHandlerAsyncResultSetJsonObject(new Handler[AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetComplexJsonObjectFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]]()
      asJava.methodWithHandlerAsyncResultSetComplexJsonObject(new Handler[AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetJsonArrayFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]]()
      asJava.methodWithHandlerAsyncResultSetJsonArray(new Handler[AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetComplexJsonArrayFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]]()
      asJava.methodWithHandlerAsyncResultSetComplexJsonArray(new Handler[AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetDataObjectFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestDataObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestDataObject]]()
      asJava.methodWithHandlerAsyncResultSetDataObject(new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetEnumFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]]()
      asJava.methodWithHandlerAsyncResultSetEnum(new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}  }











  type DataObjectWithBuffer = io.vertx.codegen.testmodel.DataObjectWithBuffer
  object DataObjectWithBuffer {
    def apply() = new DataObjectWithBuffer()
    def apply(json: JsonObject) = new DataObjectWithBuffer(json)
  }



  type DataObjectWithListAdders = io.vertx.codegen.testmodel.DataObjectWithListAdders
  object DataObjectWithListAdders {
    def apply() = new DataObjectWithListAdders()
    def apply(json: JsonObject) = new DataObjectWithListAdders(json)
  }



  type DataObjectWithLists = io.vertx.codegen.testmodel.DataObjectWithLists
  object DataObjectWithLists {
    def apply() = new DataObjectWithLists()
    def apply(json: JsonObject) = new DataObjectWithLists(json)
  }



  type DataObjectWithMapAdders = io.vertx.codegen.testmodel.DataObjectWithMapAdders
  object DataObjectWithMapAdders {
    def apply() = new DataObjectWithMapAdders()
    def apply(json: JsonObject) = new DataObjectWithMapAdders(json)
  }



  type DataObjectWithMaps = io.vertx.codegen.testmodel.DataObjectWithMaps
  object DataObjectWithMaps {
    def apply() = new DataObjectWithMaps()
    def apply(json: JsonObject) = new DataObjectWithMaps(json)
  }



  type DataObjectWithNestedBuffer = io.vertx.codegen.testmodel.DataObjectWithNestedBuffer
  object DataObjectWithNestedBuffer {
    def apply() = new DataObjectWithNestedBuffer()
    def apply(json: JsonObject) = new DataObjectWithNestedBuffer(json)
  }



  type DataObjectWithOnlyJsonObjectConstructor = io.vertx.codegen.testmodel.DataObjectWithOnlyJsonObjectConstructor
  object DataObjectWithOnlyJsonObjectConstructor {
    def apply(json: JsonObject) = new DataObjectWithOnlyJsonObjectConstructor(json)
  }



  type DataObjectWithRecursion = io.vertx.codegen.testmodel.DataObjectWithRecursion
  object DataObjectWithRecursion {
    def apply(json: JsonObject) = new DataObjectWithRecursion(json)
  }



  type DataObjectWithValues = io.vertx.codegen.testmodel.DataObjectWithValues
  object DataObjectWithValues {
    def apply() = new DataObjectWithValues()
    def apply(json: JsonObject) = new DataObjectWithValues(json)
  }



  object Factory {
def createConcreteHandlerUserType(handler: io.vertx.codegen.testmodel.RefedInterface1 => Unit) = {
      io.vertx.codegen.testmodel.Factory.createConcreteHandlerUserType(handler.asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.RefedInterface1]])
}
def createAbstractHandlerUserType(handler: io.vertx.codegen.testmodel.RefedInterface1 => Unit) = {
      io.vertx.codegen.testmodel.Factory.createAbstractHandlerUserType(handler.asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.RefedInterface1]])
}
def createConcreteHandlerUserTypeExtension(handler: io.vertx.codegen.testmodel.RefedInterface1 => Unit) = {
      io.vertx.codegen.testmodel.Factory.createConcreteHandlerUserTypeExtension(handler.asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.RefedInterface1]])
}  }





  /**

    */

  implicit class FutureTCKScala(val asJava: io.vertx.codegen.testmodel.FutureTCK) extends AnyVal {


def asyncMethodFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.asyncMethod(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }








  /**

    */

  implicit class GenericsTCKScala(val asJava: io.vertx.codegen.testmodel.GenericsTCK) extends AnyVal {

def methodWithClassTypeParam[U](`type`: Class[U],u: U) = {
      scala.Option(asJava.methodWithClassTypeParam[U](`type`, u))
}
def interfaceWithVariableArg[T, U](value1: T,`type`: Class[U],value2: U) = {
      scala.Option(asJava.interfaceWithVariableArg[T, U](value1, `type`, value2))
}
def methodWithHandlerAsyncResultByteParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Byte]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Byte]]()
      asJava.methodWithHandlerAsyncResultByteParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Byte]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Byte]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultShortParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Short]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Short]]()
      asJava.methodWithHandlerAsyncResultShortParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Short]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Short]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultIntegerParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Integer]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Integer]]()
      asJava.methodWithHandlerAsyncResultIntegerParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Integer]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Integer]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultLongParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Long]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Long]]()
      asJava.methodWithHandlerAsyncResultLongParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Long]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Long]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultFloatParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Float]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Float]]()
      asJava.methodWithHandlerAsyncResultFloatParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Float]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Float]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultDoubleParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Double]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Double]]()
      asJava.methodWithHandlerAsyncResultDoubleParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Double]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Double]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultBooleanParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Boolean]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Boolean]]()
      asJava.methodWithHandlerAsyncResultBooleanParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Boolean]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Boolean]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultCharacterParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Character]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Character]]()
      asJava.methodWithHandlerAsyncResultCharacterParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Character]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Character]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultStringParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.String]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.String]]()
      asJava.methodWithHandlerAsyncResultStringParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.String]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultJsonObjectParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonObject]]()
      asJava.methodWithHandlerAsyncResultJsonObjectParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonObject]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultJsonArrayParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonArray]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonArray]]()
      asJava.methodWithHandlerAsyncResultJsonArrayParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonArray]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonArray]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultDataObjectParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestDataObject]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestDataObject]]()
      asJava.methodWithHandlerAsyncResultDataObjectParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestDataObject]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestDataObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultEnumParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]()
      asJava.methodWithHandlerAsyncResultEnumParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultGenEnumParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]()
      asJava.methodWithHandlerAsyncResultGenEnumParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultUserTypeParameterizedFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithHandlerAsyncResultUserTypeParameterized(new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultClassTypeParameterizedFuture[U](`type`: Class[U]) : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[U]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[U]]()
      asJava.methodWithHandlerAsyncResultClassTypeParameterized[U](`type`, new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[U]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[U]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithClassTypeHandlerAsyncResultFuture[U](`type`: Class[U]) : scala.concurrent.Future[U] = {
      val promise = concurrent.Promise[U]()
      asJava.methodWithClassTypeHandlerAsyncResult[U](`type`, new Handler[AsyncResult[U]] { override def handle(event: AsyncResult[U]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultGenericNullableApiFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericNullableRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericNullableRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithHandlerAsyncResultGenericNullableApi(notNull, new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericNullableRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericNullableRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultParamInferedFuture[T](param: io.vertx.codegen.testmodel.GenericRefedInterface[T]) : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[T]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[T]]()
      asJava.methodWithHandlerAsyncResultParamInfered[T](param, new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[T]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[T]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }











  implicit class JsonMapperTCKScala(val asJava: io.vertx.codegen.testmodel.JsonMapperTCK) extends AnyVal {


def methodWithHandlerAsyncResultTypeToIntegerParamFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.MyPojoToInteger] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.MyPojoToInteger]()
      asJava.methodWithHandlerAsyncResultTypeToIntegerParam(new Handler[AsyncResult[io.vertx.codegen.testmodel.MyPojoToInteger]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.MyPojoToInteger]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultListOfTypeToIntegerParamFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.MyPojoToInteger]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.MyPojoToInteger]]()
      asJava.methodWithHandlerAsyncResultListOfTypeToIntegerParam(new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.MyPojoToInteger]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.MyPojoToInteger]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetOfTypeToIntegerParamFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.MyPojoToInteger]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.MyPojoToInteger]]()
      asJava.methodWithHandlerAsyncResultSetOfTypeToIntegerParam(new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.MyPojoToInteger]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.MyPojoToInteger]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultMapOfTypeToIntegerParamFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, io.vertx.codegen.testmodel.MyPojoToInteger]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, io.vertx.codegen.testmodel.MyPojoToInteger]]()
      asJava.methodWithHandlerAsyncResultMapOfTypeToIntegerParam(new Handler[AsyncResult[java.util.Map[java.lang.String,io.vertx.codegen.testmodel.MyPojoToInteger]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,io.vertx.codegen.testmodel.MyPojoToInteger]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultTypeToStringParamFuture() : scala.concurrent.Future[java.time.ZonedDateTime] = {
      val promise = concurrent.Promise[java.time.ZonedDateTime]()
      asJava.methodWithHandlerAsyncResultTypeToStringParam(new Handler[AsyncResult[java.time.ZonedDateTime]] { override def handle(event: AsyncResult[java.time.ZonedDateTime]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultListOfTypeToStringParamFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.time.ZonedDateTime]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.time.ZonedDateTime]]()
      asJava.methodWithHandlerAsyncResultListOfTypeToStringParam(new Handler[AsyncResult[java.util.List[java.time.ZonedDateTime]]] { override def handle(event: AsyncResult[java.util.List[java.time.ZonedDateTime]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetOfTypeToStringParamFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.time.ZonedDateTime]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.time.ZonedDateTime]]()
      asJava.methodWithHandlerAsyncResultSetOfTypeToStringParam(new Handler[AsyncResult[java.util.Set[java.time.ZonedDateTime]]] { override def handle(event: AsyncResult[java.util.Set[java.time.ZonedDateTime]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultMapOfTypeToStringParamFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, java.time.ZonedDateTime]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.time.ZonedDateTime]]()
      asJava.methodWithHandlerAsyncResultMapOfTypeToStringParam(new Handler[AsyncResult[java.util.Map[java.lang.String,java.time.ZonedDateTime]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.time.ZonedDateTime]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultTypeToJsonArrayParamFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.MyPojoToJsonArray] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.MyPojoToJsonArray]()
      asJava.methodWithHandlerAsyncResultTypeToJsonArrayParam(new Handler[AsyncResult[io.vertx.codegen.testmodel.MyPojoToJsonArray]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.MyPojoToJsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultListOfTypeToJsonArrayParamFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.MyPojoToJsonArray]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.MyPojoToJsonArray]]()
      asJava.methodWithHandlerAsyncResultListOfTypeToJsonArrayParam(new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.MyPojoToJsonArray]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.MyPojoToJsonArray]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetOfTypeToJsonArrayParamFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.MyPojoToJsonArray]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.MyPojoToJsonArray]]()
      asJava.methodWithHandlerAsyncResultSetOfTypeToJsonArrayParam(new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.MyPojoToJsonArray]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.MyPojoToJsonArray]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultMapOfTypeToJsonArrayParamFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, io.vertx.codegen.testmodel.MyPojoToJsonArray]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, io.vertx.codegen.testmodel.MyPojoToJsonArray]]()
      asJava.methodWithHandlerAsyncResultMapOfTypeToJsonArrayParam(new Handler[AsyncResult[java.util.Map[java.lang.String,io.vertx.codegen.testmodel.MyPojoToJsonArray]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,io.vertx.codegen.testmodel.MyPojoToJsonArray]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultTypeToJsonObjectParamFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.MyPojoToJsonObject] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.MyPojoToJsonObject]()
      asJava.methodWithHandlerAsyncResultTypeToJsonObjectParam(new Handler[AsyncResult[io.vertx.codegen.testmodel.MyPojoToJsonObject]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.MyPojoToJsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultListOfTypeToJsonObjectParamFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.MyPojoToJsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.MyPojoToJsonObject]]()
      asJava.methodWithHandlerAsyncResultListOfTypeToJsonObjectParam(new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.MyPojoToJsonObject]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.MyPojoToJsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetOfTypeToJsonObjectParamFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.MyPojoToJsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.MyPojoToJsonObject]]()
      asJava.methodWithHandlerAsyncResultSetOfTypeToJsonObjectParam(new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.MyPojoToJsonObject]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.MyPojoToJsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultMapOfTypeToJsonObjectParamFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, io.vertx.codegen.testmodel.MyPojoToJsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, io.vertx.codegen.testmodel.MyPojoToJsonObject]]()
      asJava.methodWithHandlerAsyncResultMapOfTypeToJsonObjectParam(new Handler[AsyncResult[java.util.Map[java.lang.String,io.vertx.codegen.testmodel.MyPojoToJsonObject]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,io.vertx.codegen.testmodel.MyPojoToJsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultFunctionMappedFuture() : scala.concurrent.Future[java.util.Locale] = {
      val promise = concurrent.Promise[java.util.Locale]()
      asJava.methodWithHandlerAsyncResultFunctionMapped(new Handler[AsyncResult[java.util.Locale]] { override def handle(event: AsyncResult[java.util.Locale]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultListOfFunctionMappedFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.util.Locale]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.util.Locale]]()
      asJava.methodWithHandlerAsyncResultListOfFunctionMapped(new Handler[AsyncResult[java.util.List[java.util.Locale]]] { override def handle(event: AsyncResult[java.util.List[java.util.Locale]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultSetOfFunctionMappedFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.util.Locale]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.util.Locale]]()
      asJava.methodWithHandlerAsyncResultSetOfFunctionMapped(new Handler[AsyncResult[java.util.Set[java.util.Locale]]] { override def handle(event: AsyncResult[java.util.Set[java.util.Locale]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithHandlerAsyncResultMapOfFunctionMappedFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, java.util.Locale]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.util.Locale]]()
      asJava.methodWithHandlerAsyncResultMapOfFunctionMapped(new Handler[AsyncResult[java.util.Map[java.lang.String,java.util.Locale]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.util.Locale]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}  }




  /**
    * The TCK for @Nullable.
    */

  implicit class NullableTCKScala(val asJava: io.vertx.codegen.testmodel.NullableTCK) extends AnyVal {

def methodWithNullableByteParam(expectNull: java.lang.Boolean,param: scala.Option[java.lang.Byte]) = {
      scala.Option(asJava.methodWithNullableByteParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableByteReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableByteReturn(notNull))
}
def methodWithNullableShortParam(expectNull: java.lang.Boolean,param: scala.Option[java.lang.Short]) = {
      scala.Option(asJava.methodWithNullableShortParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableShortReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableShortReturn(notNull))
}
def methodWithNullableIntegerParam(expectNull: java.lang.Boolean,param: scala.Option[java.lang.Integer]) = {
      scala.Option(asJava.methodWithNullableIntegerParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableIntegerReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableIntegerReturn(notNull))
}
def methodWithNullableLongParam(expectNull: java.lang.Boolean,param: scala.Option[java.lang.Long]) = {
      scala.Option(asJava.methodWithNullableLongParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableLongReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableLongReturn(notNull))
}
def methodWithNullableFloatParam(expectNull: java.lang.Boolean,param: scala.Option[java.lang.Float]) = {
      scala.Option(asJava.methodWithNullableFloatParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableFloatReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableFloatReturn(notNull))
}
def methodWithNullableDoubleParam(expectNull: java.lang.Boolean,param: scala.Option[java.lang.Double]) = {
      scala.Option(asJava.methodWithNullableDoubleParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableDoubleReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableDoubleReturn(notNull))
}
def methodWithNullableBooleanParam(expectNull: java.lang.Boolean,param: scala.Option[java.lang.Boolean]) = {
      scala.Option(asJava.methodWithNullableBooleanParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableBooleanReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableBooleanReturn(notNull))
}
def methodWithNullableStringParam(expectNull: java.lang.Boolean,param: scala.Option[java.lang.String]) = {
      scala.Option(asJava.methodWithNullableStringParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableStringReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableStringReturn(notNull))
}
def methodWithNullableCharParam(expectNull: java.lang.Boolean,param: scala.Option[java.lang.Character]) = {
      scala.Option(asJava.methodWithNullableCharParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableCharReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableCharReturn(notNull))
}
def methodWithNullableJsonObjectParam(expectNull: java.lang.Boolean,param: scala.Option[io.vertx.core.json.JsonObject]) = {
      scala.Option(asJava.methodWithNullableJsonObjectParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableJsonObjectReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableJsonObjectReturn(notNull))
}
def methodWithNullableJsonArrayParam(expectNull: java.lang.Boolean,param: scala.Option[io.vertx.core.json.JsonArray]) = {
      scala.Option(asJava.methodWithNullableJsonArrayParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableJsonArrayReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableJsonArrayReturn(notNull))
}
def methodWithNullableApiParam(expectNull: java.lang.Boolean,param: scala.Option[io.vertx.codegen.testmodel.RefedInterface1]) = {
      scala.Option(asJava.methodWithNullableApiParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableApiReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableApiReturn(notNull))
}
def methodWithNullableDataObjectParam(expectNull: java.lang.Boolean,param: scala.Option[io.vertx.codegen.testmodel.TestDataObject]) = {
      scala.Option(asJava.methodWithNullableDataObjectParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableDataObjectReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableDataObjectReturn(notNull))
}
def methodWithNullableEnumParam(expectNull: java.lang.Boolean,param: scala.Option[io.vertx.codegen.testmodel.TestEnum]) = {
      scala.Option(asJava.methodWithNullableEnumParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableEnumReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableEnumReturn(notNull))
}
def methodWithNullableGenEnumParam(expectNull: java.lang.Boolean,param: scala.Option[io.vertx.codegen.testmodel.TestGenEnum]) = {
      scala.Option(asJava.methodWithNullableGenEnumParam(expectNull, param.getOrElse(null)))
}
def methodWithNullableGenEnumReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableGenEnumReturn(notNull))
}
def methodWithNullableTypeVariableParam[T](expectNull: java.lang.Boolean,param: T) = {
      scala.Option(asJava.methodWithNullableTypeVariableParam[T](expectNull, param))
}
def methodWithNullableTypeVariableHandler[T](notNull: java.lang.Boolean,value: T,handler: T => Unit) = {
      scala.Option(asJava.methodWithNullableTypeVariableHandler[T](notNull, value, handler.asInstanceOf[io.vertx.core.Handler[T]]))
}
def methodWithNullableTypeVariableHandlerAsyncResult[T](notNull: java.lang.Boolean,value: T,handler: AsyncResult[T] => Unit) = {
      scala.Option(asJava.methodWithNullableTypeVariableHandlerAsyncResult[T](notNull, value, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]]))
}
def methodWithNullableTypeVariableReturnOption[T](notNull: java.lang.Boolean,value: T) = {
      scala.Option(asJava.methodWithNullableTypeVariableReturn[T](notNull, value))
}
def methodWithNullableObjectParam(expectNull: java.lang.Boolean,param: AnyRef) = {
      scala.Option(asJava.methodWithNullableObjectParam(expectNull, param))
}
def methodWithNullableListByteParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[java.lang.Byte]]) = {
      scala.Option(asJava.methodWithNullableListByteParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListByteReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListByteReturn(notNull))
}
def methodWithNullableListShortParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[java.lang.Short]]) = {
      scala.Option(asJava.methodWithNullableListShortParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListShortReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListShortReturn(notNull))
}
def methodWithNullableListIntegerParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[java.lang.Integer]]) = {
      scala.Option(asJava.methodWithNullableListIntegerParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListIntegerReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListIntegerReturn(notNull))
}
def methodWithNullableListLongParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[java.lang.Long]]) = {
      scala.Option(asJava.methodWithNullableListLongParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListLongReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListLongReturn(notNull))
}
def methodWithNullableListFloatParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[java.lang.Float]]) = {
      scala.Option(asJava.methodWithNullableListFloatParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListFloatReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListFloatReturn(notNull))
}
def methodWithNullableListDoubleParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[java.lang.Double]]) = {
      scala.Option(asJava.methodWithNullableListDoubleParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListDoubleReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListDoubleReturn(notNull))
}
def methodWithNullableListBooleanParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[java.lang.Boolean]]) = {
      scala.Option(asJava.methodWithNullableListBooleanParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListBooleanReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListBooleanReturn(notNull))
}
def methodWithNullableListStringParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[java.lang.String]]) = {
      scala.Option(asJava.methodWithNullableListStringParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListStringReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListStringReturn(notNull))
}
def methodWithNullableListCharParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[java.lang.Character]]) = {
      scala.Option(asJava.methodWithNullableListCharParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListCharReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListCharReturn(notNull))
}
def methodWithNullableListJsonObjectParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[io.vertx.core.json.JsonObject]]) = {
      scala.Option(asJava.methodWithNullableListJsonObjectParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListJsonObjectReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListJsonObjectReturn(notNull))
}
def methodWithNullableListJsonArrayParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[io.vertx.core.json.JsonArray]]) = {
      scala.Option(asJava.methodWithNullableListJsonArrayParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListJsonArrayReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListJsonArrayReturn(notNull))
}
def methodWithNullableListApiParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]) = {
      scala.Option(asJava.methodWithNullableListApiParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListApiReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListApiReturn(notNull))
}
def methodWithNullableListDataObjectParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]) = {
      scala.Option(asJava.methodWithNullableListDataObjectParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListDataObjectReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListDataObjectReturn(notNull))
}
def methodWithNullableListEnumParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[io.vertx.codegen.testmodel.TestEnum]]) = {
      scala.Option(asJava.methodWithNullableListEnumParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListEnumReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListEnumReturn(notNull))
}
def methodWithNullableListGenEnumParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]) = {
      scala.Option(asJava.methodWithNullableListGenEnumParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableListGenEnumReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableListGenEnumReturn(notNull))
}
def methodWithNullableSetByteParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[java.lang.Byte]]) = {
      scala.Option(asJava.methodWithNullableSetByteParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetByteReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetByteReturn(notNull))
}
def methodWithNullableSetShortParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[java.lang.Short]]) = {
      scala.Option(asJava.methodWithNullableSetShortParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetShortReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetShortReturn(notNull))
}
def methodWithNullableSetIntegerParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[java.lang.Integer]]) = {
      scala.Option(asJava.methodWithNullableSetIntegerParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetIntegerReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetIntegerReturn(notNull))
}
def methodWithNullableSetLongParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[java.lang.Long]]) = {
      scala.Option(asJava.methodWithNullableSetLongParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetLongReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetLongReturn(notNull))
}
def methodWithNullableSetFloatParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[java.lang.Float]]) = {
      scala.Option(asJava.methodWithNullableSetFloatParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetFloatReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetFloatReturn(notNull))
}
def methodWithNullableSetDoubleParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[java.lang.Double]]) = {
      scala.Option(asJava.methodWithNullableSetDoubleParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetDoubleReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetDoubleReturn(notNull))
}
def methodWithNullableSetBooleanParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[java.lang.Boolean]]) = {
      scala.Option(asJava.methodWithNullableSetBooleanParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetBooleanReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetBooleanReturn(notNull))
}
def methodWithNullableSetStringParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[java.lang.String]]) = {
      scala.Option(asJava.methodWithNullableSetStringParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetStringReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetStringReturn(notNull))
}
def methodWithNullableSetCharParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[java.lang.Character]]) = {
      scala.Option(asJava.methodWithNullableSetCharParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetCharReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetCharReturn(notNull))
}
def methodWithNullableSetJsonObjectParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[io.vertx.core.json.JsonObject]]) = {
      scala.Option(asJava.methodWithNullableSetJsonObjectParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetJsonObjectReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetJsonObjectReturn(notNull))
}
def methodWithNullableSetJsonArrayParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[io.vertx.core.json.JsonArray]]) = {
      scala.Option(asJava.methodWithNullableSetJsonArrayParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetJsonArrayReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetJsonArrayReturn(notNull))
}
def methodWithNullableSetApiParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]) = {
      scala.Option(asJava.methodWithNullableSetApiParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetApiReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetApiReturn(notNull))
}
def methodWithNullableSetDataObjectParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]) = {
      scala.Option(asJava.methodWithNullableSetDataObjectParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetDataObjectReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetDataObjectReturn(notNull))
}
def methodWithNullableSetEnumParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]) = {
      scala.Option(asJava.methodWithNullableSetEnumParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetEnumReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetEnumReturn(notNull))
}
def methodWithNullableSetGenEnumParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]) = {
      scala.Option(asJava.methodWithNullableSetGenEnumParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableSetGenEnumReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableSetGenEnumReturn(notNull))
}
def methodWithNullableMapByteParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Map[String, java.lang.Byte]]) = {
      scala.Option(asJava.methodWithNullableMapByteParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableMapByteReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableMapByteReturn(notNull))
}
def methodWithNullableMapShortParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Map[String, java.lang.Short]]) = {
      scala.Option(asJava.methodWithNullableMapShortParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableMapShortReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableMapShortReturn(notNull))
}
def methodWithNullableMapIntegerParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Map[String, java.lang.Integer]]) = {
      scala.Option(asJava.methodWithNullableMapIntegerParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableMapIntegerReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableMapIntegerReturn(notNull))
}
def methodWithNullableMapLongParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Map[String, java.lang.Long]]) = {
      scala.Option(asJava.methodWithNullableMapLongParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableMapLongReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableMapLongReturn(notNull))
}
def methodWithNullableMapFloatParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Map[String, java.lang.Float]]) = {
      scala.Option(asJava.methodWithNullableMapFloatParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableMapFloatReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableMapFloatReturn(notNull))
}
def methodWithNullableMapDoubleParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Map[String, java.lang.Double]]) = {
      scala.Option(asJava.methodWithNullableMapDoubleParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableMapDoubleReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableMapDoubleReturn(notNull))
}
def methodWithNullableMapBooleanParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Map[String, java.lang.Boolean]]) = {
      scala.Option(asJava.methodWithNullableMapBooleanParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableMapBooleanReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableMapBooleanReturn(notNull))
}
def methodWithNullableMapStringParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Map[String, java.lang.String]]) = {
      scala.Option(asJava.methodWithNullableMapStringParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableMapStringReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableMapStringReturn(notNull))
}
def methodWithNullableMapCharParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Map[String, java.lang.Character]]) = {
      scala.Option(asJava.methodWithNullableMapCharParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableMapCharReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableMapCharReturn(notNull))
}
def methodWithNullableMapJsonObjectParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Map[String, io.vertx.core.json.JsonObject]]) = {
      scala.Option(asJava.methodWithNullableMapJsonObjectParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableMapJsonObjectReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableMapJsonObjectReturn(notNull))
}
def methodWithNullableMapJsonArrayParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Map[String, io.vertx.core.json.JsonArray]]) = {
      scala.Option(asJava.methodWithNullableMapJsonArrayParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableMapJsonArrayReturnOption(notNull: java.lang.Boolean) = {
      scala.Option(asJava.methodWithNullableMapJsonArrayReturn(notNull))
}
def methodWithNullableMapApiParam(expectNull: java.lang.Boolean,param: scala.Option[java.util.Map[String, io.vertx.codegen.testmodel.RefedInterface1]]) = {
      scala.Option(asJava.methodWithNullableMapApiParam(expectNull, param.flatMap(res => Some(res)).orNull))
}
def methodWithNullableHandler(expectNull: java.lang.Boolean,handler: scala.Option[java.lang.String => Unit]) = {
      scala.Option(asJava.methodWithNullableHandler(expectNull, handler.asInstanceOf[io.vertx.core.Handler[java.lang.String]]))
}
def methodWithNullableHandlerAsyncResult(expectNull: java.lang.Boolean,handler: scala.Option[AsyncResult[java.lang.String] => Unit]) = {
      scala.Option(asJava.methodWithNullableHandlerAsyncResult(expectNull, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.String]]]))
}
def methodWithNullableByteHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[java.lang.Byte] = {
      val promise = concurrent.Promise[java.lang.Byte]()
      asJava.methodWithNullableByteHandlerAsyncResult(notNull, new Handler[AsyncResult[java.lang.Byte]] { override def handle(event: AsyncResult[java.lang.Byte]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableShortHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[java.lang.Short] = {
      val promise = concurrent.Promise[java.lang.Short]()
      asJava.methodWithNullableShortHandlerAsyncResult(notNull, new Handler[AsyncResult[java.lang.Short]] { override def handle(event: AsyncResult[java.lang.Short]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableIntegerHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[java.lang.Integer] = {
      val promise = concurrent.Promise[java.lang.Integer]()
      asJava.methodWithNullableIntegerHandlerAsyncResult(notNull, new Handler[AsyncResult[java.lang.Integer]] { override def handle(event: AsyncResult[java.lang.Integer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableLongHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]()
      asJava.methodWithNullableLongHandlerAsyncResult(notNull, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableFloatHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[java.lang.Float] = {
      val promise = concurrent.Promise[java.lang.Float]()
      asJava.methodWithNullableFloatHandlerAsyncResult(notNull, new Handler[AsyncResult[java.lang.Float]] { override def handle(event: AsyncResult[java.lang.Float]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableDoubleHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[java.lang.Double] = {
      val promise = concurrent.Promise[java.lang.Double]()
      asJava.methodWithNullableDoubleHandlerAsyncResult(notNull, new Handler[AsyncResult[java.lang.Double]] { override def handle(event: AsyncResult[java.lang.Double]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableBooleanHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]()
      asJava.methodWithNullableBooleanHandlerAsyncResult(notNull, new Handler[AsyncResult[java.lang.Boolean]] { override def handle(event: AsyncResult[java.lang.Boolean]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableStringHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.methodWithNullableStringHandlerAsyncResult(notNull, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableCharHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[java.lang.Character] = {
      val promise = concurrent.Promise[java.lang.Character]()
      asJava.methodWithNullableCharHandlerAsyncResult(notNull, new Handler[AsyncResult[java.lang.Character]] { override def handle(event: AsyncResult[java.lang.Character]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableJsonObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]()
      asJava.methodWithNullableJsonObjectHandlerAsyncResult(notNull, new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableJsonArrayHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.methodWithNullableJsonArrayHandlerAsyncResult(notNull, new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableApiHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[io.vertx.codegen.testmodel.RefedInterface1] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.RefedInterface1]()
      asJava.methodWithNullableApiHandlerAsyncResult(notNull, new Handler[AsyncResult[io.vertx.codegen.testmodel.RefedInterface1]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.RefedInterface1]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableDataObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[io.vertx.codegen.testmodel.TestDataObject] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.TestDataObject]()
      asJava.methodWithNullableDataObjectHandlerAsyncResult(notNull, new Handler[AsyncResult[io.vertx.codegen.testmodel.TestDataObject]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.TestDataObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[io.vertx.codegen.testmodel.TestEnum] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.TestEnum]()
      asJava.methodWithNullableEnumHandlerAsyncResult(notNull, new Handler[AsyncResult[io.vertx.codegen.testmodel.TestEnum]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.TestEnum]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableGenEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[io.vertx.codegen.testmodel.TestGenEnum] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.TestGenEnum]()
      asJava.methodWithNullableGenEnumHandlerAsyncResult(notNull, new Handler[AsyncResult[io.vertx.codegen.testmodel.TestGenEnum]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.TestGenEnum]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableTypeVariableHandlerAsyncResultFuture[T](notNull: java.lang.Boolean,value: T) : scala.concurrent.Future[T] = {
      val promise = concurrent.Promise[T]()
      asJava.methodWithNullableTypeVariableHandlerAsyncResult[T](notNull, value, new Handler[AsyncResult[T]] { override def handle(event: AsyncResult[T]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithNullableListByteHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Byte]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Byte]]()
      asJava.methodWithNullableListByteHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[java.lang.Byte]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Byte]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableListShortHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Short]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Short]]()
      asJava.methodWithNullableListShortHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[java.lang.Short]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Short]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableListIntegerHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Integer]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Integer]]()
      asJava.methodWithNullableListIntegerHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[java.lang.Integer]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Integer]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableListLongHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Long]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Long]]()
      asJava.methodWithNullableListLongHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[java.lang.Long]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Long]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableListFloatHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Float]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Float]]()
      asJava.methodWithNullableListFloatHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[java.lang.Float]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Float]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableListDoubleHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Double]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Double]]()
      asJava.methodWithNullableListDoubleHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[java.lang.Double]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Double]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableListBooleanHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Boolean]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Boolean]]()
      asJava.methodWithNullableListBooleanHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[java.lang.Boolean]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Boolean]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableListStringHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]()
      asJava.methodWithNullableListStringHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableListCharHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Character]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Character]]()
      asJava.methodWithNullableListCharHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[java.lang.Character]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Character]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableListJsonObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]()
      asJava.methodWithNullableListJsonObjectHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableListJsonArrayHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]]()
      asJava.methodWithNullableListJsonArrayHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[io.vertx.core.json.JsonArray]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.core.json.JsonArray]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableListApiHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithNullableListApiHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableListDataObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestDataObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestDataObject]]()
      asJava.methodWithNullableListDataObjectHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableListEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]()
      asJava.methodWithNullableListEnumHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableListGenEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]()
      asJava.methodWithNullableListGenEnumHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetByteHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Byte]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Byte]]()
      asJava.methodWithNullableSetByteHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[java.lang.Byte]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Byte]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetShortHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Short]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Short]]()
      asJava.methodWithNullableSetShortHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[java.lang.Short]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Short]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetIntegerHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Integer]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Integer]]()
      asJava.methodWithNullableSetIntegerHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[java.lang.Integer]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Integer]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetLongHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Long]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Long]]()
      asJava.methodWithNullableSetLongHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[java.lang.Long]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Long]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetFloatHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Float]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Float]]()
      asJava.methodWithNullableSetFloatHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[java.lang.Float]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Float]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetDoubleHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Double]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Double]]()
      asJava.methodWithNullableSetDoubleHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[java.lang.Double]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Double]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetBooleanHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Boolean]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Boolean]]()
      asJava.methodWithNullableSetBooleanHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[java.lang.Boolean]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Boolean]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetStringHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.String]]()
      asJava.methodWithNullableSetStringHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[java.lang.String]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetCharHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Character]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Character]]()
      asJava.methodWithNullableSetCharHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[java.lang.Character]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Character]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetJsonObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]]()
      asJava.methodWithNullableSetJsonObjectHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetJsonArrayHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]]()
      asJava.methodWithNullableSetJsonArrayHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetApiHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithNullableSetApiHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetDataObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestDataObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestDataObject]]()
      asJava.methodWithNullableSetDataObjectHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]]()
      asJava.methodWithNullableSetEnumHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableSetGenEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum]]()
      asJava.methodWithNullableSetGenEnumHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableMapByteHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Byte]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Byte]]()
      asJava.methodWithNullableMapByteHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Byte]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Byte]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableMapShortHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Short]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Short]]()
      asJava.methodWithNullableMapShortHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Short]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Short]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableMapIntegerHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Integer]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Integer]]()
      asJava.methodWithNullableMapIntegerHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Integer]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Integer]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableMapLongHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Long]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Long]]()
      asJava.methodWithNullableMapLongHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Long]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Long]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableMapFloatHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Float]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Float]]()
      asJava.methodWithNullableMapFloatHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Float]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Float]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableMapDoubleHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Double]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Double]]()
      asJava.methodWithNullableMapDoubleHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Double]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Double]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableMapBooleanHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Boolean]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Boolean]]()
      asJava.methodWithNullableMapBooleanHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Boolean]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Boolean]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableMapStringHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.String]]()
      asJava.methodWithNullableMapStringHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.String]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableMapCharHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Character]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Character]]()
      asJava.methodWithNullableMapCharHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Character]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Character]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableMapJsonObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Map[String, io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, io.vertx.core.json.JsonObject]]()
      asJava.methodWithNullableMapJsonObjectHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableMapJsonArrayHandlerAsyncResultFuture(notNull: java.lang.Boolean) : scala.concurrent.Future[scala.collection.mutable.Map[String, io.vertx.core.json.JsonArray]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, io.vertx.core.json.JsonArray]]()
      asJava.methodWithNullableMapJsonArrayHandlerAsyncResult(notNull, new Handler[AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableByteHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Byte]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Byte]]()
      asJava.methodWithListNullableByteHandlerAsyncResult(new Handler[AsyncResult[java.util.List[java.lang.Byte]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Byte]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableShortHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Short]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Short]]()
      asJava.methodWithListNullableShortHandlerAsyncResult(new Handler[AsyncResult[java.util.List[java.lang.Short]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Short]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableIntegerHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Integer]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Integer]]()
      asJava.methodWithListNullableIntegerHandlerAsyncResult(new Handler[AsyncResult[java.util.List[java.lang.Integer]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Integer]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableLongHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Long]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Long]]()
      asJava.methodWithListNullableLongHandlerAsyncResult(new Handler[AsyncResult[java.util.List[java.lang.Long]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Long]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableBooleanHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Boolean]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Boolean]]()
      asJava.methodWithListNullableBooleanHandlerAsyncResult(new Handler[AsyncResult[java.util.List[java.lang.Boolean]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Boolean]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableFloatHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Float]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Float]]()
      asJava.methodWithListNullableFloatHandlerAsyncResult(new Handler[AsyncResult[java.util.List[java.lang.Float]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Float]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableDoubleHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Double]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Double]]()
      asJava.methodWithListNullableDoubleHandlerAsyncResult(new Handler[AsyncResult[java.util.List[java.lang.Double]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Double]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableStringHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]()
      asJava.methodWithListNullableStringHandlerAsyncResult(new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableCharHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Character]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Character]]()
      asJava.methodWithListNullableCharHandlerAsyncResult(new Handler[AsyncResult[java.util.List[java.lang.Character]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Character]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableJsonObjectHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]()
      asJava.methodWithListNullableJsonObjectHandlerAsyncResult(new Handler[AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableJsonArrayHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]]()
      asJava.methodWithListNullableJsonArrayHandlerAsyncResult(new Handler[AsyncResult[java.util.List[io.vertx.core.json.JsonArray]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.core.json.JsonArray]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableApiHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithListNullableApiHandlerAsyncResult(new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableDataObjectHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestDataObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestDataObject]]()
      asJava.methodWithListNullableDataObjectHandlerAsyncResult(new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableEnumHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]()
      asJava.methodWithListNullableEnumHandlerAsyncResult(new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithListNullableGenEnumHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]()
      asJava.methodWithListNullableGenEnumHandlerAsyncResult(new Handler[AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableByteHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Byte]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Byte]]()
      asJava.methodWithSetNullableByteHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[java.lang.Byte]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Byte]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableShortHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Short]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Short]]()
      asJava.methodWithSetNullableShortHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[java.lang.Short]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Short]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableIntegerHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Integer]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Integer]]()
      asJava.methodWithSetNullableIntegerHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[java.lang.Integer]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Integer]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableLongHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Long]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Long]]()
      asJava.methodWithSetNullableLongHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[java.lang.Long]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Long]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableBooleanHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Boolean]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Boolean]]()
      asJava.methodWithSetNullableBooleanHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[java.lang.Boolean]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Boolean]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableFloatHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Float]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Float]]()
      asJava.methodWithSetNullableFloatHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[java.lang.Float]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Float]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableDoubleHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Double]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Double]]()
      asJava.methodWithSetNullableDoubleHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[java.lang.Double]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Double]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableStringHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.String]]()
      asJava.methodWithSetNullableStringHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[java.lang.String]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableCharHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.Character]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.Character]]()
      asJava.methodWithSetNullableCharHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[java.lang.Character]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.Character]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableJsonObjectHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]]()
      asJava.methodWithSetNullableJsonObjectHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableJsonArrayHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]]()
      asJava.methodWithSetNullableJsonArrayHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableApiHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithSetNullableApiHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableDataObjectHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestDataObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestDataObject]]()
      asJava.methodWithSetNullableDataObjectHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableEnumHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]]()
      asJava.methodWithSetNullableEnumHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithSetNullableGenEnumHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum]]()
      asJava.methodWithSetNullableGenEnumHandlerAsyncResult(new Handler[AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithMapNullableByteHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Byte]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Byte]]()
      asJava.methodWithMapNullableByteHandlerAsyncResult(new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Byte]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Byte]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithMapNullableShortHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Short]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Short]]()
      asJava.methodWithMapNullableShortHandlerAsyncResult(new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Short]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Short]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithMapNullableIntegerHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Integer]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Integer]]()
      asJava.methodWithMapNullableIntegerHandlerAsyncResult(new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Integer]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Integer]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithMapNullableLongHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Long]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Long]]()
      asJava.methodWithMapNullableLongHandlerAsyncResult(new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Long]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Long]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithMapNullableBooleanHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Boolean]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Boolean]]()
      asJava.methodWithMapNullableBooleanHandlerAsyncResult(new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Boolean]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Boolean]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithMapNullableFloatHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Float]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Float]]()
      asJava.methodWithMapNullableFloatHandlerAsyncResult(new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Float]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Float]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithMapNullableDoubleHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Double]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Double]]()
      asJava.methodWithMapNullableDoubleHandlerAsyncResult(new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Double]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Double]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithMapNullableStringHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.String]]()
      asJava.methodWithMapNullableStringHandlerAsyncResult(new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.String]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithMapNullableCharHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, java.lang.Character]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, java.lang.Character]]()
      asJava.methodWithMapNullableCharHandlerAsyncResult(new Handler[AsyncResult[java.util.Map[java.lang.String,java.lang.Character]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,java.lang.Character]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithMapNullableJsonObjectHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, io.vertx.core.json.JsonObject]]()
      asJava.methodWithMapNullableJsonObjectHandlerAsyncResult(new Handler[AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithMapNullableJsonArrayHandlerAsyncResultFuture() : scala.concurrent.Future[scala.collection.mutable.Map[String, io.vertx.core.json.JsonArray]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, io.vertx.core.json.JsonArray]]()
      asJava.methodWithMapNullableJsonArrayHandlerAsyncResult(new Handler[AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
def methodWithNullableHandlerAsyncResultFuture(expectNull: java.lang.Boolean) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.methodWithNullableHandlerAsyncResult(expectNull, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }











  type TestDataObject = io.vertx.codegen.testmodel.TestDataObject
  object TestDataObject {
    def apply() = new TestDataObject()
    def apply(json: JsonObject) = new TestDataObject(json)
  }




  /**

    */

  implicit class TestInterfaceScala(val asJava: io.vertx.codegen.testmodel.TestInterface) extends AnyVal {

def methodWithObjectParam(str: java.lang.String,obj: AnyRef) = {
      scala.Option(asJava.methodWithObjectParam(str, obj))
}
def methodWithHandlerGenericUserType[U](value: U,handler: io.vertx.codegen.testmodel.GenericRefedInterface[U] => Unit) = {
      scala.Option(asJava.methodWithHandlerGenericUserType[U](value, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[U]]]))
}
def methodWithHandlerAsyncResultGenericUserType[U](value: U,handler: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[U]] => Unit) = {
      scala.Option(asJava.methodWithHandlerAsyncResultGenericUserType[U](value, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[U]]]]))
}
def methodWithGenericUserTypeReturn[U](value: U) = {
      scala.Option(asJava.methodWithGenericUserTypeReturn[U](value))
}
def methodWithGenericParam[U](`type`: java.lang.String,u: U) = {
      scala.Option(asJava.methodWithGenericParam[U](`type`, u))
}
def methodWithNullJsonParams(jsonObject: scala.Option[io.vertx.core.json.JsonObject],jsonArray: scala.Option[io.vertx.core.json.JsonArray]) = {
      scala.Option(asJava.methodWithNullJsonParams(jsonObject.getOrElse(null), jsonArray.getOrElse(null)))
}
def methodWithHandlerAsyncResultByteFuture(sendFailure: java.lang.Boolean) : scala.concurrent.Future[java.lang.Byte] = {
      val promise = concurrent.Promise[java.lang.Byte]()
      asJava.methodWithHandlerAsyncResultByte(sendFailure, new Handler[AsyncResult[java.lang.Byte]] { override def handle(event: AsyncResult[java.lang.Byte]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultShortFuture(sendFailure: java.lang.Boolean) : scala.concurrent.Future[java.lang.Short] = {
      val promise = concurrent.Promise[java.lang.Short]()
      asJava.methodWithHandlerAsyncResultShort(sendFailure, new Handler[AsyncResult[java.lang.Short]] { override def handle(event: AsyncResult[java.lang.Short]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultIntegerFuture(sendFailure: java.lang.Boolean) : scala.concurrent.Future[java.lang.Integer] = {
      val promise = concurrent.Promise[java.lang.Integer]()
      asJava.methodWithHandlerAsyncResultInteger(sendFailure, new Handler[AsyncResult[java.lang.Integer]] { override def handle(event: AsyncResult[java.lang.Integer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultLongFuture(sendFailure: java.lang.Boolean) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]()
      asJava.methodWithHandlerAsyncResultLong(sendFailure, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultFloatFuture(sendFailure: java.lang.Boolean) : scala.concurrent.Future[java.lang.Float] = {
      val promise = concurrent.Promise[java.lang.Float]()
      asJava.methodWithHandlerAsyncResultFloat(sendFailure, new Handler[AsyncResult[java.lang.Float]] { override def handle(event: AsyncResult[java.lang.Float]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultDoubleFuture(sendFailure: java.lang.Boolean) : scala.concurrent.Future[java.lang.Double] = {
      val promise = concurrent.Promise[java.lang.Double]()
      asJava.methodWithHandlerAsyncResultDouble(sendFailure, new Handler[AsyncResult[java.lang.Double]] { override def handle(event: AsyncResult[java.lang.Double]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultBooleanFuture(sendFailure: java.lang.Boolean) : scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]()
      asJava.methodWithHandlerAsyncResultBoolean(sendFailure, new Handler[AsyncResult[java.lang.Boolean]] { override def handle(event: AsyncResult[java.lang.Boolean]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultCharacterFuture(sendFailure: java.lang.Boolean) : scala.concurrent.Future[java.lang.Character] = {
      val promise = concurrent.Promise[java.lang.Character]()
      asJava.methodWithHandlerAsyncResultCharacter(sendFailure, new Handler[AsyncResult[java.lang.Character]] { override def handle(event: AsyncResult[java.lang.Character]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultStringFuture(sendFailure: java.lang.Boolean) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.methodWithHandlerAsyncResultString(sendFailure, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultDataObjectFuture(sendFailure: java.lang.Boolean) : scala.concurrent.Future[io.vertx.codegen.testmodel.TestDataObject] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.TestDataObject]()
      asJava.methodWithHandlerAsyncResultDataObject(sendFailure, new Handler[AsyncResult[io.vertx.codegen.testmodel.TestDataObject]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.TestDataObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultUserTypesFuture() : scala.concurrent.Future[io.vertx.codegen.testmodel.RefedInterface1] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.RefedInterface1]()
      asJava.methodWithHandlerAsyncResultUserTypes(new Handler[AsyncResult[io.vertx.codegen.testmodel.RefedInterface1]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.RefedInterface1]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultVoidFuture(sendFailure: java.lang.Boolean) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.methodWithHandlerAsyncResultVoid(sendFailure, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultGenericUserTypeFuture[U](value: U) : scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[U]] = {
      val promise = concurrent.Promise[io.vertx.codegen.testmodel.GenericRefedInterface[U]]()
      asJava.methodWithHandlerAsyncResultGenericUserType[U](value, new Handler[AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[U]]] { override def handle(event: AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[U]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithGenericHandlerAsyncResultFuture[U](`type`: java.lang.String) : scala.concurrent.Future[U] = {
      val promise = concurrent.Promise[U]()
      asJava.methodWithGenericHandlerAsyncResult[U](`type`, new Handler[AsyncResult[U]] { override def handle(event: AsyncResult[U]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultJsonObjectFuture() : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]()
      asJava.methodWithHandlerAsyncResultJsonObject(new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultNullJsonObjectFuture() : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]()
      asJava.methodWithHandlerAsyncResultNullJsonObject(new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultComplexJsonObjectFuture() : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]()
      asJava.methodWithHandlerAsyncResultComplexJsonObject(new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultJsonArrayFuture() : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.methodWithHandlerAsyncResultJsonArray(new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultNullJsonArrayFuture() : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.methodWithHandlerAsyncResultNullJsonArray(new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def methodWithHandlerAsyncResultComplexJsonArrayFuture() : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.methodWithHandlerAsyncResultComplexJsonArray(new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }



}
