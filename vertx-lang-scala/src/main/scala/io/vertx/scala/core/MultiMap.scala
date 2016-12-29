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

package io.vertx.scala.core

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.core.{MultiMap => JMultiMap}
import scala.collection.JavaConverters._

/**
  * This class represents a MultiMap of String keys to a List of String values.
  * 
  * It's useful in Vert.x to represent things in Vert.x like HTTP headers and HTTP parameters which allow
  * multiple values for keys.
  */
class MultiMap(private val _asJava: Object, private val _useTypeTags:Boolean = false) {

  def asJava = _asJava

//cached methods
//fluent methods
  def add(name: String,value: String):MultiMap = {
    asJava.asInstanceOf[JMultiMap].add(name.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String])
    this
  }

  def addAll(map: MultiMap):MultiMap = {
    asJava.asInstanceOf[JMultiMap].addAll(map.asJava.asInstanceOf[JMultiMap])
    this
  }

  def set(name: String,value: String):MultiMap = {
    asJava.asInstanceOf[JMultiMap].set(name.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String])
    this
  }

  def setAll(map: MultiMap):MultiMap = {
    asJava.asInstanceOf[JMultiMap].setAll(map.asJava.asInstanceOf[JMultiMap])
    this
  }

  def remove(name: String):MultiMap = {
    asJava.asInstanceOf[JMultiMap].remove(name.asInstanceOf[java.lang.String])
    this
  }

  def clear():MultiMap = {
    asJava.asInstanceOf[JMultiMap].clear()
    this
  }

//default methods
//basic methods
  def get(name: String):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JMultiMap].get(name.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  def getAll(name: String):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JMultiMap].getAll(name.asInstanceOf[java.lang.String]).asScala.map(x => x.asInstanceOf[String])
  }

  def contains(name: String):Boolean = {
    asJava.asInstanceOf[JMultiMap].contains(name.asInstanceOf[java.lang.String]).asInstanceOf[Boolean]
  }

  def isEmpty():Boolean = {
    asJava.asInstanceOf[JMultiMap].isEmpty().asInstanceOf[Boolean]
  }

  def names():scala.collection.mutable.Set[String] = {
    asJava.asInstanceOf[JMultiMap].names().asScala.map(x => x.asInstanceOf[String])
  }

  def size():Int = {
    asJava.asInstanceOf[JMultiMap].size().asInstanceOf[Int]
  }

//future methods
}

  object MultiMap{
    def apply(asJava: Object, useTypeTags:Boolean = false) = new MultiMap(asJava, useTypeTags)  
  //static methods
    def caseInsensitiveMultiMap():MultiMap = {
      MultiMap(JMultiMap.caseInsensitiveMultiMap())
    }

  }
