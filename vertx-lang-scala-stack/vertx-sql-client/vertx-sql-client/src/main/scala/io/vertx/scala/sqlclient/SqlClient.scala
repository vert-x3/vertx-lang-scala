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
import io.vertx.sqlclient.{RowSet => JRowSet}
import io.vertx.sqlclient.{SqlClient => JSqlClient}
import io.vertx.sqlclient.{Query => JQuery}
import scala.reflect.runtime.universe._
import io.vertx.sqlclient.{PreparedQuery => JPreparedQuery}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Defines the client operations with a database server.
  */

class SqlClient(private val _asJava: Object) {
  def asJava = _asJava





  /**
   * Create a query, the [[io.vertx.scala.sqlclient.Query#execute]] method must be called to execute the query.   * @return the query
   */
  def query (sql: String): Query[RowSet[Row]] = {
    Query[RowSet[Row]](asJava.asInstanceOf[JSqlClient].query(sql.asInstanceOf[java.lang.String]))
  }

  /**
   * Create a prepared query, one of the [[io.vertx.scala.sqlclient.Query#execute]] or [[io.vertx.scala.sqlclient.PreparedQuery#executeBatch]]
   * methods must be called to execute the query.   * @return the prepared query
   */
  def preparedQuery (sql: String): PreparedQuery[RowSet[Row]] = {
    PreparedQuery[RowSet[Row]](asJava.asInstanceOf[JSqlClient].preparedQuery(sql.asInstanceOf[java.lang.String]))
  }

  /**
   * Close the client and release the associated resources.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JSqlClient].close()
  }


}

object SqlClient {
  def apply(asJava: JSqlClient) = new SqlClient(asJava)

}
