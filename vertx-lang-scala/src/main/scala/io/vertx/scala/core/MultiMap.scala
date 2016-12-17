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

import io.vertx.core.{MultiMap => JMultiMap}

/**
  * This class represents a MultiMap of String keys to a List of String values.
  * 
  * It's useful in Vert.x to represent things in Vert.x like HTTP headers and HTTP parameters which allow
  * multiple values for keys.
  */
class MultiMap(private val _asJava: Object) {

def asJava = _asJava.asInstanceOf[JMultiMap]
//methods returning a future
//cached methods
//fluent methods
  def add(name: String,value: String):MultiMap = {
    asJava.add( )
    this
  }

  def addAll(map: MultiMap):MultiMap = {
    asJava.addAll( )
    this
  }

  def set(name: String,value: String):MultiMap = {
    asJava.set( )
    this
  }

  def setAll(map: MultiMap):MultiMap = {
    asJava.setAll( )
    this
  }

  def remove(name: String):MultiMap = {
    asJava.remove( )
    this
  }

  def clear():MultiMap = {
    asJava.clear( )
    this
  }

//basic methods
  def get(name: String):String = {
    asJava.get( )
  }

  def getAll(name: String):scala.collection.mutable.Buffer[String] = {
    asJava.getAll( )
  }

  def contains(name: String):Boolean = {
    asJava.contains( )
  }

  def isEmpty():Boolean = {
    asJava.isEmpty( )
  }

  def names():Set[String] = {
    asJava.names( )
  }

  def size():Int = {
    asJava.size( )
  }

}

object MultiMap{
//in object!
//static methods
  def caseInsensitiveMultiMap():MultiMap = {
    JMultiMap.caseInsensitiveMultiMap( )
  }

}
