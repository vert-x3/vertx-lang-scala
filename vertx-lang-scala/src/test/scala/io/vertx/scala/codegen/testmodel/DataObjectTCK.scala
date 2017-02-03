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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.codegen.testmodel.{DataObjectWithValues => JDataObjectWithValues}
import io.vertx.codegen.testmodel.{DataObjectWithRecursion => JDataObjectWithRecursion}
import io.vertx.codegen.testmodel.{DataObjectWithMaps => JDataObjectWithMaps}
import io.vertx.codegen.testmodel.{DataObjectWithLists => JDataObjectWithLists}
import io.vertx.codegen.testmodel.{DataObjectWithMapAdders => JDataObjectWithMapAdders}
import io.vertx.codegen.testmodel.{DataObjectWithListAdders => JDataObjectWithListAdders}
import io.vertx.codegen.testmodel.{DataObjectWithOnlyJsonObjectConstructor => JDataObjectWithOnlyJsonObjectConstructor}
import io.vertx.codegen.testmodel.{DataObjectWithNestedBuffer => JDataObjectWithNestedBuffer}
import io.vertx.codegen.testmodel.{DataObjectTCK => JDataObjectTCK}

/**
  * todo:
  * - Buffer support
  */
class DataObjectTCK(private val _asJava: Object) {

  def asJava = _asJava

  def getDataObjectWithValues(): DataObjectWithValues = {
    DataObjectWithValues(asJava.asInstanceOf[JDataObjectTCK].getDataObjectWithValues())
  }

  def setDataObjectWithValues(dataObject: DataObjectWithValues): Unit = {
    asJava.asInstanceOf[JDataObjectTCK].setDataObjectWithValues(dataObject.asJava)
  }

  def getDataObjectWithLists(): DataObjectWithLists = {
    DataObjectWithLists(asJava.asInstanceOf[JDataObjectTCK].getDataObjectWithLists())
  }

  def setDataObjectWithLists(dataObject: DataObjectWithLists): Unit = {
    asJava.asInstanceOf[JDataObjectTCK].setDataObjectWithLists(dataObject.asJava)
  }

  def getDataObjectWithMaps(): DataObjectWithMaps = {
    DataObjectWithMaps(asJava.asInstanceOf[JDataObjectTCK].getDataObjectWithMaps())
  }

  def setDataObjectWithMaps(dataObject: DataObjectWithMaps): Unit = {
    asJava.asInstanceOf[JDataObjectTCK].setDataObjectWithMaps(dataObject.asJava)
  }

  def methodWithOnlyJsonObjectConstructorDataObject(dataObject: DataObjectWithOnlyJsonObjectConstructor): Unit = {
    asJava.asInstanceOf[JDataObjectTCK].methodWithOnlyJsonObjectConstructorDataObject(dataObject.asJava)
  }

  def setDataObjectWithBuffer(dataObject: DataObjectWithNestedBuffer): Unit = {
    asJava.asInstanceOf[JDataObjectTCK].setDataObjectWithBuffer(dataObject.asJava)
  }

  def setDataObjectWithListAdders(dataObject: DataObjectWithListAdders): Unit = {
    asJava.asInstanceOf[JDataObjectTCK].setDataObjectWithListAdders(dataObject.asJava)
  }

  def setDataObjectWithMapAdders(dataObject: DataObjectWithMapAdders): Unit = {
    asJava.asInstanceOf[JDataObjectTCK].setDataObjectWithMapAdders(dataObject.asJava)
  }

  def setDataObjectWithRecursion(dataObject: DataObjectWithRecursion): Unit = {
    asJava.asInstanceOf[JDataObjectTCK].setDataObjectWithRecursion(dataObject.asJava)
  }

}

object DataObjectTCK {
  def apply(asJava: JDataObjectTCK) = new DataObjectTCK(asJava)  
}
