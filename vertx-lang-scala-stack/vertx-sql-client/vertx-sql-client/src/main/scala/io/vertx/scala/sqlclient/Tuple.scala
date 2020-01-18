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

package io.vertx.scala.sqlclient

import io.vertx.core.buffer.Buffer
import scala.reflect.runtime.universe._
import io.vertx.sqlclient.{Tuple => JTuple}
import scala.collection.JavaConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A general purpose tuple.

  */

class Tuple(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Add a boolean value at the end of the tuple.   * @param value the value
   * @return a reference to this, so the API can be used fluently
   */
  
  def addBoolean(value: Boolean): Tuple = {
    asJava.asInstanceOf[JTuple].addBoolean(value.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Add an object value at the end of the tuple.   * @param value the value
   * @return a reference to this, so the API can be used fluently
   */
  
  def addValue(value: AnyRef): Tuple = {
    asJava.asInstanceOf[JTuple].addValue(value)
    this
  }

  /**
   * Add a short value at the end of the tuple.   * @param value the value
   * @return a reference to this, so the API can be used fluently
   */
  
  def addShort(value: Short): Tuple = {
    asJava.asInstanceOf[JTuple].addShort(value.asInstanceOf[java.lang.Short])
    this
  }

  /**
   * Add an integer value at the end of the tuple.   * @param value the value
   * @return a reference to this, so the API can be used fluently
   */
  
  def addInteger(value: Int): Tuple = {
    asJava.asInstanceOf[JTuple].addInteger(value.asInstanceOf[java.lang.Integer])
    this
  }

  /**
   * Add a long value at the end of the tuple.   * @param value the value
   * @return a reference to this, so the API can be used fluently
   */
  
  def addLong(value: Long): Tuple = {
    asJava.asInstanceOf[JTuple].addLong(value.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Add a float value at the end of the tuple.   * @param value the value
   * @return a reference to this, so the API can be used fluently
   */
  
  def addFloat(value: Float): Tuple = {
    asJava.asInstanceOf[JTuple].addFloat(value.asInstanceOf[java.lang.Float])
    this
  }

  /**
   * Add a double value at the end of the tuple.   * @param value the value
   * @return a reference to this, so the API can be used fluently
   */
  
  def addDouble(value: Double): Tuple = {
    asJava.asInstanceOf[JTuple].addDouble(value.asInstanceOf[java.lang.Double])
    this
  }

  /**
   * Add a string value at the end of the tuple.   * @param value the value
   * @return a reference to this, so the API can be used fluently
   */
  
  def addString(value: String): Tuple = {
    asJava.asInstanceOf[JTuple].addString(value.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Add a buffer value at the end of the tuple.   * @param value the value
   * @return a reference to this, so the API can be used fluently
   */
  
  def addBuffer(value: io.vertx.core.buffer.Buffer): Tuple = {
    asJava.asInstanceOf[JTuple].addBuffer(value)
    this
  }


  /**
   * Get a boolean value at `pos`.   * @param pos the position
   * @return the value or `null`
   */
  def getBoolean(pos: Int): Boolean = {
    asJava.asInstanceOf[JTuple].getBoolean(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Boolean]
  }

  /**
   * Get a short value at `pos`.   * @param pos the position
   * @return the value or `null`
   */
  def getShort(pos: Int): Short = {
    asJava.asInstanceOf[JTuple].getShort(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Short]
  }

  /**
   * Get an integer value at `pos`.   * @param pos the position
   * @return the value or `null`
   */
  def getInteger(pos: Int): Int = {
    asJava.asInstanceOf[JTuple].getInteger(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Int]
  }

  /**
   * Get a long value at `pos`.   * @param pos the position
   * @return the value or `null`
   */
  def getLong(pos: Int): Long = {
    asJava.asInstanceOf[JTuple].getLong(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Long]
  }

  /**
   * Get a float value at `pos`.   * @param pos the position
   * @return the value or `null`
   */
  def getFloat(pos: Int): Float = {
    asJava.asInstanceOf[JTuple].getFloat(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Float]
  }

  /**
   * Get a double value at `pos`.   * @param pos the position
   * @return the value or `null`
   */
  def getDouble(pos: Int): Double = {
    asJava.asInstanceOf[JTuple].getDouble(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Double]
  }

  /**
   * Get a string value at `pos`.   * @param pos the position
   * @return the value or `null`
   */
  def getString(pos: Int): String = {
    asJava.asInstanceOf[JTuple].getString(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[String]
  }

  /**
   * Get a buffer value at `pos`.   * @param pos the position
   * @return the value or `null`
   */
  def getBuffer(pos: Int): io.vertx.core.buffer.Buffer = {
    asJava.asInstanceOf[JTuple].getBuffer(pos.asInstanceOf[java.lang.Integer])
  }


  def get[T: TypeTag](`type`: Class[T], pos: Int): T = {
    toScala[T](asJava.asInstanceOf[JTuple].get[Object](toJavaClass(`type`), pos.asInstanceOf[java.lang.Integer]))
  }


  /**
   * Get an object value at `pos`.   * @param pos the position
   * @return the value or `null`
   */
  def getValue (pos: Int): AnyRef = {
    toScala[java.lang.Object](asJava.asInstanceOf[JTuple].getValue(pos.asInstanceOf[java.lang.Integer]))
  }

  /**
   * @return the tuple size
   */
  def size (): Int = {
    asJava.asInstanceOf[JTuple].size().asInstanceOf[Int]
  }


  def clear (): Unit = {
    asJava.asInstanceOf[JTuple].clear()
  }


}

object Tuple {
  def apply(asJava: JTuple) = new Tuple(asJava)

  /**
   * @return a new empty tuple
   */
  def tuple(): Tuple = {
    Tuple(JTuple.tuple())//2 tuple
  }

  /**
   * Wrap the provided `list` with a tuple.
   * <br/>
   * The list is not copied and is used as store for tuple elements.   * @return the list wrapped as a tuple
   */
  def wrap(list: scala.collection.mutable.Buffer[AnyRef]): Tuple = {
    Tuple(JTuple.wrap(list.map(x => x).asJava))//2 wrap
  }

  /**
   * Create a tuple of one element.   * @param elt1 the first value
   * @return the tuple
   */
  def of(elt1: AnyRef): Tuple = {
    Tuple((new io.vertx.sqlclient.impl.ArrayTuple(0)).addValue(elt1))
  }

  /**
   * Create a tuple of two elements.   * @param elt1 the first value
   * @param elt2 the second value
   * @return the tuple
   */
  def of(elt1: AnyRef,elt2: AnyRef): Tuple = {
    Tuple((new io.vertx.sqlclient.impl.ArrayTuple(0)).addValue(elt1).addValue(elt2))
  }

  /**
   * Create a tuple of three elements.   * @param elt1 the first value
   * @param elt2 the second value
   * @param elt3 the third value
   * @return the tuple
   */
  def of(elt1: AnyRef,elt2: AnyRef,elt3: AnyRef): Tuple = {
    Tuple((new io.vertx.sqlclient.impl.ArrayTuple(0)).addValue(elt1).addValue(elt2).addValue(elt3))
  }

  /**
   * Create a tuple of four elements.   * @param elt1 the first value
   * @param elt2 the second value
   * @param elt3 the third value
   * @param elt4 the fourth value
   * @return the tuple
   */
  def of(elt1: AnyRef,elt2: AnyRef,elt3: AnyRef,elt4: AnyRef): Tuple = {
    Tuple((new io.vertx.sqlclient.impl.ArrayTuple(0)).addValue(elt1).addValue(elt2).addValue(elt3).addValue(elt4))
  }

  /**
   * Create a tuple of five elements.   * @param elt1 the first value
   * @param elt2 the second value
   * @param elt3 the third value
   * @param elt4 the fourth value
   * @param elt5 the fifth value
   * @return the tuple
   */
  def of(elt1: AnyRef,elt2: AnyRef,elt3: AnyRef,elt4: AnyRef,elt5: AnyRef): Tuple = {
    Tuple((new io.vertx.sqlclient.impl.ArrayTuple(0)).addValue(elt1).addValue(elt2).addValue(elt3).addValue(elt4).addValue(elt5))
  }

  /**
   * Create a tuple of six elements.   * @param elt1 the first value
   * @param elt2 the second valueg
   * @param elt3 the third value
   * @param elt4 the fourth value
   * @param elt5 the fifth value
   * @param elt6 the sixth value
   * @return the tuple
   */
  def of(elt1: AnyRef,elt2: AnyRef,elt3: AnyRef,elt4: AnyRef,elt5: AnyRef,elt6: AnyRef): Tuple = {
    Tuple((new io.vertx.sqlclient.impl.ArrayTuple(0)).addValue(elt1).addValue(elt2).addValue(elt3).addValue(elt4).addValue(elt5).addValue(elt6))
  }

  /**
   * Create a tuple with the provided `elements` list.
   * <p/>
   * The `elements` list is not modified.   * @param elements the list of elements
   * @return the tuple
   */
  def tuple(elements: scala.collection.mutable.Buffer[AnyRef]): Tuple = {
    Tuple(JTuple.tuple(elements.map(x => x).asJava))//2 tuple
  }

}
