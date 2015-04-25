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

package io.vertx.scala.core;

import java.util.Map.Entry

class MultiMap(private val _asJava: io.vertx.core.MultiMap) {

  def asJava: java.lang.Object = _asJava

  def get(name: String): String = {
    _asJava.get(name)
  }

  def getAll(name: String): List[String] = {
    import scala.collection.JavaConverters._
    _asJava.getAll(name).asScala.map(x => x:String).toList
  }

  def contains(name: String): Boolean = {
    _asJava.contains(name)
  }

  def isEmpty(): Boolean = {
    _asJava.isEmpty()
  }

  def names(): Set[String] = {
    import scala.collection.JavaConverters._
    _asJava.names().asScala.map(x => x:String).toSet
  }

  def add(name: String, value: String): io.vertx.scala.core.MultiMap = {
    _asJava.add(name, value)
    this
  }

  def addAll(map: io.vertx.scala.core.MultiMap): io.vertx.scala.core.MultiMap = {
    _asJava.addAll(map.asJava.asInstanceOf[io.vertx.core.MultiMap])
    this
  }

  def set(name: String, value: String): io.vertx.scala.core.MultiMap = {
    _asJava.set(name, value)
    this
  }

  def setAll(map: io.vertx.scala.core.MultiMap): io.vertx.scala.core.MultiMap = {
    _asJava.setAll(map.asJava.asInstanceOf[io.vertx.core.MultiMap])
    this
  }

  def remove(name: String): io.vertx.scala.core.MultiMap = {
    _asJava.remove(name)
    this
  }

  def clear(): io.vertx.scala.core.MultiMap = {
    _asJava.clear()
    this
  }

  def size(): Int = {
    _asJava.size()
  }

}

object MultiMap {

  def apply(_asJava: io.vertx.core.MultiMap): io.vertx.scala.core.MultiMap =
    new io.vertx.scala.core.MultiMap(_asJava)
}
