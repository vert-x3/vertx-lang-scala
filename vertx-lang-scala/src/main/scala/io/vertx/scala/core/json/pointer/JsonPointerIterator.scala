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

package io.vertx.scala.core.json.pointer

import scala.reflect.runtime.universe._
import io.vertx.core.json.pointer.{JsonPointerIterator => JJsonPointerIterator}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * The JsonPointerIterator is used by the read/write algorithms of the [[io.vertx.scala.core.json.pointer.JsonPointer]] to read/write the querying data structure <br/>
  *
  * Every method takes the currentValue as parameter, representing the actual value held by the query algorithm.<br/>
  *
  * Implementations of this interface should be stateless, so they can be reused<br/>
  *
  * You can implement this interface to query the structure you want using json pointers
  */

class JsonPointerIterator(private val _asJava: Object) {
  def asJava = _asJava





  /**
   * @return `true` if the current value is a queryable object
   */
  def isObject (currentValue: scala.Option[AnyRef]): Boolean = {
    asJava.asInstanceOf[JJsonPointerIterator].isObject(currentValue.orNull).asInstanceOf[Boolean]
  }

  /**
   * @return `true` if the current value is a queryable array
   */
  def isArray (currentValue: scala.Option[AnyRef]): Boolean = {
    asJava.asInstanceOf[JJsonPointerIterator].isArray(currentValue.orNull).asInstanceOf[Boolean]
  }

  /**
   * @return `true` if the current value is null/empty
   */
  def isNull (currentValue: scala.Option[AnyRef]): Boolean = {
    asJava.asInstanceOf[JJsonPointerIterator].isNull(currentValue.orNull).asInstanceOf[Boolean]
  }

  /**
   * @param key object key
   * @return `true` if current value is a queryable object that contains the specified key
   */
  def objectContainsKey (currentValue: scala.Option[AnyRef], key: String): Boolean = {
    asJava.asInstanceOf[JJsonPointerIterator].objectContainsKey(currentValue.orNull, key.asInstanceOf[java.lang.String]).asInstanceOf[Boolean]
  }

  /**
   * Returns the object parameter with specified key.   * @param key object key
   * @param createOnMissing If the current value is an object that doesn't contain the key, put an empty object at provided key
   * @return the requested object parameter, or null if the method was not able to find it
   */
  def getObjectParameter (currentValue: scala.Option[AnyRef], key: String, createOnMissing: Boolean): AnyRef = {
    toScala[java.lang.Object](asJava.asInstanceOf[JJsonPointerIterator].getObjectParameter(currentValue.orNull, key.asInstanceOf[java.lang.String], createOnMissing.asInstanceOf[java.lang.Boolean]))
  }

  /**
   * Move the iterator the the array element at specified index   * @param i array index
   * @return the request array element, or null if the method was not able to find it
   */
  def getArrayElement (currentValue: scala.Option[AnyRef], i: Int): AnyRef = {
    toScala[java.lang.Object](asJava.asInstanceOf[JJsonPointerIterator].getArrayElement(currentValue.orNull, i.asInstanceOf[java.lang.Integer]))
  }

  /**
   * Write object parameter at specified key   * @return true if the operation is successful
   */
  def writeObjectParameter (currentValue: scala.Option[AnyRef], key: String, value: scala.Option[AnyRef]): Boolean = {
    asJava.asInstanceOf[JJsonPointerIterator].writeObjectParameter(currentValue.orNull, key.asInstanceOf[java.lang.String], value.orNull).asInstanceOf[Boolean]
  }

  /**
   * Write array element at specified index   * @return true if the operation is successful
   */
  def writeArrayElement (currentValue: scala.Option[AnyRef], i: Int, value: scala.Option[AnyRef]): Boolean = {
    asJava.asInstanceOf[JJsonPointerIterator].writeArrayElement(currentValue.orNull, i.asInstanceOf[java.lang.Integer], value.orNull).asInstanceOf[Boolean]
  }

  /**
   * Append array element   * @return true if the operation is successful
   */
  def appendArrayElement (currentValue: scala.Option[AnyRef], value: scala.Option[AnyRef]): Boolean = {
    asJava.asInstanceOf[JJsonPointerIterator].appendArrayElement(currentValue.orNull, value.orNull).asInstanceOf[Boolean]
  }


}

object JsonPointerIterator {
  def apply(asJava: JJsonPointerIterator) = new JsonPointerIterator(asJava)

}
