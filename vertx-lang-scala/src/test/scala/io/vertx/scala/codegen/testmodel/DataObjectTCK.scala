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
import io.vertx.codegen.testmodel.{DataObjectTCK => JDataObjectTCK}
import io.vertx.codegen.testmodel.{DataObjectWithMaps => JDataObjectWithMaps}
import io.vertx.scala.codegen.testmodel.DataObjectWithMaps
import io.vertx.codegen.testmodel.{DataObjectWithOnlyJsonObjectConstructor => JDataObjectWithOnlyJsonObjectConstructor}
import io.vertx.scala.codegen.testmodel.DataObjectWithOnlyJsonObjectConstructor
import io.vertx.codegen.testmodel.{DataObjectWithLists => JDataObjectWithLists}
import io.vertx.scala.codegen.testmodel.DataObjectWithLists
import io.vertx.codegen.testmodel.{DataObjectWithNestedBuffer => JDataObjectWithNestedBuffer}
import io.vertx.scala.codegen.testmodel.DataObjectWithNestedBuffer
import io.vertx.codegen.testmodel.{DataObjectWithValues => JDataObjectWithValues}
import io.vertx.scala.codegen.testmodel.DataObjectWithValues

/**
  * todo:
  * - Buffer support
  */
class DataObjectTCK(private val _asJava: JDataObjectTCK) {

  def asJava: JDataObjectTCK = _asJava

  def getDataObjectWithValues(): DataObjectWithValues = {
    DataObjectWithValues(_asJava.getDataObjectWithValues())
  }

  def setDataObjectWithValues(dataObject: DataObjectWithValues): Unit = {
    _asJava.setDataObjectWithValues(dataObject.asJava)
  }

  def getDataObjectWithLists(): DataObjectWithLists = {
    DataObjectWithLists(_asJava.getDataObjectWithLists())
  }

  def setDataObjectWithLists(dataObject: DataObjectWithLists): Unit = {
    _asJava.setDataObjectWithLists(dataObject.asJava)
  }

  def getDataObjectWithMaps(): DataObjectWithMaps = {
    DataObjectWithMaps(_asJava.getDataObjectWithMaps())
  }

  def setDataObjectWithMaps(dataObject: DataObjectWithMaps): Unit = {
    _asJava.setDataObjectWithMaps(dataObject.asJava)
  }

  def methodWithOnlyJsonObjectConstructorDataObject(dataObject: DataObjectWithOnlyJsonObjectConstructor): Unit = {
    _asJava.methodWithOnlyJsonObjectConstructorDataObject(dataObject.asJava)
  }

  def setDataObjectWithBuffer(dataObject: DataObjectWithNestedBuffer): Unit = {
    _asJava.setDataObjectWithBuffer(dataObject.asJava)
  }

}

object DataObjectTCK {

  def apply(_asJava: JDataObjectTCK): DataObjectTCK =
    new DataObjectTCK(_asJava)

}
