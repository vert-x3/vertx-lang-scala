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
import io.vertx.lang.scala.Converter._
import io.vertx.core.{MultiMap => JMultiMap}
import scala.collection.JavaConverters._

/**
  * This class represents a MultiMap of String keys to a List of String values.
  * 
  * It's useful in Vert.x to represent things in Vert.x like HTTP headers and HTTP parameters which allow
  * multiple values for keys.
  */
class MultiMap(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
 /**
   * Adds a new value with the specified name and value.
   * @param name The name
   * @param value The value being added
   * @return a reference to this, so the API can be used fluently
   */
  def add(name: String,value: String):MultiMap = {
    asJava.asInstanceOf[JMultiMap].add(name.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String])
    this
  }

 /**
   * Adds all the entries from another MultiMap to this one
   * @return a reference to this, so the API can be used fluently
   */
  def addAll(map: MultiMap):MultiMap = {
    asJava.asInstanceOf[JMultiMap].addAll(map.asJava.asInstanceOf[JMultiMap])
    this
  }

 /**
   * Sets a value under the specified name.
   * 
   * If there is an existing header with the same name, it is removed.
   * @param name The name
   * @param value The value
   * @return a reference to this, so the API can be used fluently
   */
  def set(name: String,value: String):MultiMap = {
    asJava.asInstanceOf[JMultiMap].set(name.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String])
    this
  }

 /**
   * Cleans this instance.
   * @return a reference to this, so the API can be used fluently
   */
  def setAll(map: MultiMap):MultiMap = {
    asJava.asInstanceOf[JMultiMap].setAll(map.asJava.asInstanceOf[JMultiMap])
    this
  }

 /**
   * Removes the value with the given name
   * @param name The name of the value to remove
   * @return a reference to this, so the API can be used fluently
   */
  def remove(name: String):MultiMap = {
    asJava.asInstanceOf[JMultiMap].remove(name.asInstanceOf[java.lang.String])
    this
  }

 /**
   * Removes all
   * @return a reference to this, so the API can be used fluently
   */
  def clear():MultiMap = {
    asJava.asInstanceOf[JMultiMap].clear()
    this
  }

//default methods
//basic methods
 /**
   * Returns the value of with the specified name.  If there are
   * more than one values for the specified name, the first value is returned.
   * @param name The name of the header to search
   * @return The first header value or `null` if there is no such entry
   */
  def get(name: String):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JMultiMap].get(name.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

 /**
   * Returns the values with the specified name
   * @param name The name to search
   * @return A immutable scala.collection.immutable.List of values which will be empty if no values are found
   */
  def getAll(name: String):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JMultiMap].getAll(name.asInstanceOf[java.lang.String]).asScala.map(x => x.asInstanceOf[String])
  }

 /**
   * Checks to see if there is a value with the specified name
   * @param name The name to search for
   * @return true if at least one entry is found
   */
  def contains(name: String):Boolean = {
    asJava.asInstanceOf[JMultiMap].contains(name.asInstanceOf[java.lang.String]).asInstanceOf[Boolean]
  }

 /**
   * Return true if empty
   */
  def isEmpty():Boolean = {
    asJava.asInstanceOf[JMultiMap].isEmpty().asInstanceOf[Boolean]
  }

 /**
   * Gets a immutable Set of all names
   * @return A scala.collection.immutable.Set of all names
   */
  def names():scala.collection.mutable.Set[String] = {
    asJava.asInstanceOf[JMultiMap].names().asScala.map(x => x.asInstanceOf[String])
  }

 /**
   * Return the number of keys.
   */
  def size():Int = {
    asJava.asInstanceOf[JMultiMap].size().asInstanceOf[Int]
  }

//future methods
}

object MultiMap{
  def apply(asJava: JMultiMap) = new MultiMap(asJava)  
  //static methods
 /**
   * Create a multi-map implementation with case insensitive keys, for instance it can be used to hold some HTTP headers.
   * @return the multi-map
   */
  def caseInsensitiveMultiMap():MultiMap = {
    MultiMap(JMultiMap.caseInsensitiveMultiMap())
  }

}
