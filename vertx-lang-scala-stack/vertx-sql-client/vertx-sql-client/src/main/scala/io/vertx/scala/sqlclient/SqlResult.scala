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

import scala.reflect.runtime.universe._
import io.vertx.sqlclient.{SqlResult => JSqlResult}
import scala.collection.JavaConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Represents the result of an operation on database.
  */

class SqlResult[T: TypeTag](private val _asJava: Object) {
  def asJava = _asJava





  /**
   * Get the number of the affected rows in the operation to this PgResult.
   * <p/>
   * The meaning depends on the executed statement:
   * <ul>
   *   <li>INSERT: the number of rows inserted</li>
   *   <li>DELETE: the number of rows deleted</li>
   *   <li>UPDATE: the number of rows updated</li>
   *   <li>SELECT: the number of rows retrieved</li>
   * </ul>   * @return the count of affected rows.
   */
  def rowCount (): Int = {
    asJava.asInstanceOf[JSqlResult[Object]].rowCount().asInstanceOf[Int]
  }

  /**
   * Get the names of columns in the PgResult.   * @return the list of names of columns.
   */
  def columnsNames (): scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JSqlResult[Object]].columnsNames().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * Get the number of rows in the PgResult.   * @return the count of rows.
   */
  def size (): Int = {
    asJava.asInstanceOf[JSqlResult[Object]].size().asInstanceOf[Int]
  }

  /**
   * Get the result value.   * @return the result
   */
  def value (): T = {
    toScala[T](asJava.asInstanceOf[JSqlResult[Object]].value())
  }

  /**
   * Return the next available result or `null`, e.g for a simple query that executed multiple queries or for
   * a batch result.   * @return the next available result or `null` if none is available
   */
  def next (): SqlResult[T] = {
    SqlResult[T](asJava.asInstanceOf[JSqlResult[Object]].next())
  }


}

object SqlResult {
  def apply[T: TypeTag](asJava: JSqlResult[_]) = new SqlResult[T](asJava)
  
}
