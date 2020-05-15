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

import io.vertx.sqlclient.{Row => JRow}
import io.vertx.core.buffer.Buffer
import scala.reflect.runtime.universe._
import io.vertx.sqlclient.{Tuple => JTuple}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Represents single row of the result set.

  */

class Row(private val _asJava: Object) extends Tuple (_asJava) {





  /**
   * Get an object value at `pos`.   * @param name the column
   * @return the value or `null`
   */
  def getValue(name: String): AnyRef = {
    toScala[java.lang.Object](asJava.asInstanceOf[JRow].getValue(name.asInstanceOf[java.lang.String]))
  }

  /**
   * Get a boolean value at `pos`.   * @param name the column
   * @return the value or `null`
   */
  def getBoolean(name: String): Boolean = {
    asJava.asInstanceOf[JRow].getBoolean(name.asInstanceOf[java.lang.String]).asInstanceOf[Boolean]
  }

  /**
   * Get a short value at `pos`.   * @param name the column
   * @return the value or `null`
   */
  def getShort(name: String): Short = {
    asJava.asInstanceOf[JRow].getShort(name.asInstanceOf[java.lang.String]).asInstanceOf[Short]
  }

  /**
   * Get an integer value at `pos`.   * @param name the column
   * @return the value or `null`
   */
  def getInteger(name: String): Int = {
    asJava.asInstanceOf[JRow].getInteger(name.asInstanceOf[java.lang.String]).asInstanceOf[Int]
  }

  /**
   * Get a long value at `pos`.   * @param name the column
   * @return the value or `null`
   */
  def getLong(name: String): Long = {
    asJava.asInstanceOf[JRow].getLong(name.asInstanceOf[java.lang.String]).asInstanceOf[Long]
  }

  /**
   * Get a float value at `pos`.   * @param name the column
   * @return the value or `null`
   */
  def getFloat(name: String): Float = {
    asJava.asInstanceOf[JRow].getFloat(name.asInstanceOf[java.lang.String]).asInstanceOf[Float]
  }

  /**
   * Get a double value at `pos`.   * @param name the column
   * @return the value or `null`
   */
  def getDouble(name: String): Double = {
    asJava.asInstanceOf[JRow].getDouble(name.asInstanceOf[java.lang.String]).asInstanceOf[Double]
  }

  /**
   * Get a string value at `pos`.   * @param name the column
   * @return the value or `null`
   */
  def getString(name: String): String = {
    asJava.asInstanceOf[JRow].getString(name.asInstanceOf[java.lang.String]).asInstanceOf[String]
  }

  /**
   * Get a buffer value at `pos`.   * @param name the column
   * @return the value or `null`
   */
  def getBuffer(name: String): io.vertx.core.buffer.Buffer = {
    asJava.asInstanceOf[JRow].getBuffer(name.asInstanceOf[java.lang.String])
  }


  /**
   * Get a column name at `pos`.   * @param pos the column position
   * @return the column name or `null`
   */
  def getColumnName (pos: Int): String = {
    asJava.asInstanceOf[JRow].getColumnName(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[String]
  }

  /**
   * Get a column position for the given column `name`.   * @param name the column name
   * @return the column name or `-1` if not found
   */
  def getColumnIndex (name: String): Int = {
    asJava.asInstanceOf[JRow].getColumnIndex(name.asInstanceOf[java.lang.String]).asInstanceOf[Int]
  }


}

object Row {
  def apply(asJava: JRow) = new Row(asJava)

}
