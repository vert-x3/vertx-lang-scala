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

import io.vertx.sqlclient.{RowIterator => JRowIterator}
import io.vertx.sqlclient.{RowSet => JRowSet}
import scala.reflect.runtime.universe._
import io.vertx.sqlclient.{SqlResult => JSqlResult}
import scala.collection.JavaConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A set of rows.

  */

class RowSet[R: TypeTag](private val _asJava: Object) extends SqlResult[RowSet[R]] (_asJava) {






  /**
   * Get the result value.   * @return the result
   */
  override def value (): RowSet[R] = {
    RowSet[R](asJava.asInstanceOf[JRowSet[Object]].value())
  }


  def iterator (): RowIterator[R] = {
    RowIterator[R](asJava.asInstanceOf[JRowSet[Object]].iterator())
  }


  override def next (): RowSet[R] = {
    RowSet[R](asJava.asInstanceOf[JRowSet[Object]].next())
  }


}

object RowSet {
  def apply[R: TypeTag](asJava: JRowSet[_]) = new RowSet[R](asJava)

}
