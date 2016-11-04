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
import io.vertx.codegen.testmodel.DataObjectWithMaps
import io.vertx.codegen.testmodel.DataObjectWithOnlyJsonObjectConstructor
import io.vertx.codegen.testmodel.DataObjectWithLists
import io.vertx.codegen.testmodel.DataObjectWithNestedBuffer
import io.vertx.codegen.testmodel.DataObjectWithValues

/**
  * todo:
  * - Buffer support
  */
class DataObjectTCK(private val _asJava: io.vertx.codegen.testmodel.DataObjectTCK) {

  def asJava: io.vertx.codegen.testmodel.DataObjectTCK = _asJava

  def getDataObjectWithValues(): io.vertx.scala.codegen.testmodel.DataObjectWithValues = {
    io.vertx.scala.codegen.testmodel.DataObjectWithValues(_asJava.getDataObjectWithValues())
  }

  def setDataObjectWithValues(dataObject: io.vertx.scala.codegen.testmodel.DataObjectWithValues): Unit = {
    _asJava.setDataObjectWithValues(dataObject.asJava)
  }

  def getDataObjectWithLists(): io.vertx.scala.codegen.testmodel.DataObjectWithLists = {
    io.vertx.scala.codegen.testmodel.DataObjectWithLists(_asJava.getDataObjectWithLists())
  }

  def setDataObjectWithLists(dataObject: io.vertx.scala.codegen.testmodel.DataObjectWithLists): Unit = {
    _asJava.setDataObjectWithLists(dataObject.asJava)
  }

  def getDataObjectWithMaps(): io.vertx.scala.codegen.testmodel.DataObjectWithMaps = {
    io.vertx.scala.codegen.testmodel.DataObjectWithMaps(_asJava.getDataObjectWithMaps())
  }

  def setDataObjectWithMaps(dataObject: io.vertx.scala.codegen.testmodel.DataObjectWithMaps): Unit = {
    _asJava.setDataObjectWithMaps(dataObject.asJava)
  }

  def methodWithOnlyJsonObjectConstructorDataObject(dataObject: io.vertx.scala.codegen.testmodel.DataObjectWithOnlyJsonObjectConstructor): Unit = {
    _asJava.methodWithOnlyJsonObjectConstructorDataObject(dataObject.asJava)
  }

  def setDataObjectWithBuffer(dataObject: io.vertx.scala.codegen.testmodel.DataObjectWithNestedBuffer): Unit = {
    _asJava.setDataObjectWithBuffer(dataObject.asJava)
  }

}

object DataObjectTCK {

  def apply(_asJava: io.vertx.codegen.testmodel.DataObjectTCK): DataObjectTCK =
    new DataObjectTCK(_asJava)

}
