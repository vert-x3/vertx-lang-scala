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


package io.vertx.scala

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.sqlclient
import io.vertx.sqlclient.{PropertyKind => JPropertyKind}
import io.vertx.mysqlclient.{MySQLClient => JMySQLClient}
package object mysqlclient{





  type GeometryCollection = io.vertx.mysqlclient.data.spatial.GeometryCollection
  object GeometryCollection {
    def apply() = new GeometryCollection()
    def apply(json: JsonObject) = new GeometryCollection(json)
  }



  type LineString = io.vertx.mysqlclient.data.spatial.LineString
  object LineString {
    def apply() = new LineString()
    def apply(json: JsonObject) = new LineString(json)
  }



  type MultiLineString = io.vertx.mysqlclient.data.spatial.MultiLineString
  object MultiLineString {
    def apply() = new MultiLineString()
    def apply(json: JsonObject) = new MultiLineString(json)
  }



  type MultiPoint = io.vertx.mysqlclient.data.spatial.MultiPoint
  object MultiPoint {
    def apply() = new MultiPoint()
    def apply(json: JsonObject) = new MultiPoint(json)
  }



  type MultiPolygon = io.vertx.mysqlclient.data.spatial.MultiPolygon
  object MultiPolygon {
    def apply() = new MultiPolygon()
    def apply(json: JsonObject) = new MultiPolygon(json)
  }



  type MySQLAuthOptions = io.vertx.mysqlclient.MySQLAuthOptions
  object MySQLAuthOptions {
    def apply() = new MySQLAuthOptions()
    def apply(json: JsonObject) = new MySQLAuthOptions(json)
  }





  type MySQLConnectOptions = io.vertx.mysqlclient.MySQLConnectOptions
  object MySQLConnectOptions {
    def apply() = new MySQLConnectOptions()
    def apply(json: JsonObject) = new MySQLConnectOptions(json)
  }




  /**
    * An interface which represents a connection to MySQL server.
    * <P>
    *   The connection object supports all the operations defined in the  interface,
    *   in addition it provides MySQL utility command support:
    *   <ul>
    *     <li>COM_PING</li>
    *     <li>COM_CHANGE_USER</li>
    *     <li>COM_RESET_CONNECTION</li>
    *     <li>COM_DEBUG</li>
    *     <li>COM_INIT_DB</li>
    *     <li>COM_STATISTICS</li>
    *     <li>COM_SET_OPTION</li>
    *   </ul>
    * </P>

    */

  implicit class MySQLConnectionScala(val asJava: io.vertx.mysqlclient.MySQLConnection) extends AnyVal {


    /**
     * Like prepare from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def prepareFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.PreparedQuery] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.PreparedQuery]()
      asJava.prepare(sql, new Handler[AsyncResult[io.vertx.sqlclient.PreparedQuery]] { override def handle(event: AsyncResult[io.vertx.sqlclient.PreparedQuery]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like preparedQuery from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def preparedQueryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like query from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.query(sql, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like preparedQuery from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def preparedQueryFuture(sql: java.lang.String,arguments: io.vertx.sqlclient.Tuple) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, arguments, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like preparedBatch from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def preparedBatchFuture(sql: java.lang.String,batch: java.util.List[io.vertx.sqlclient.Tuple]) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedBatch(sql, batch, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like ping from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def pingFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.ping(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like specifySchema from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def specifySchemaFuture(schemaName: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.specifySchema(schemaName, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like getInternalStatistics from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getInternalStatisticsFuture() : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.getInternalStatistics(new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like setOption from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def setOptionFuture(option: io.vertx.mysqlclient.MySQLSetOption) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.setOption(option, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like resetConnection from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def resetConnectionFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.resetConnection(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like debug from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def debugFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.debug(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like changeUser from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def changeUserFuture(options: io.vertx.mysqlclient.MySQLAuthOptions) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.changeUser(options, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }




  /**
    * A  of [[io.vertx.mysqlclient.MySQLConnection]].

    */

  implicit class MySQLPoolScala(val asJava: io.vertx.mysqlclient.MySQLPool) extends AnyVal {


    /**
     * Like preparedQuery from [[io.vertx.mysqlclient.MySQLPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def preparedQueryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like query from [[io.vertx.mysqlclient.MySQLPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.query(sql, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like preparedQuery from [[io.vertx.mysqlclient.MySQLPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def preparedQueryFuture(sql: java.lang.String,arguments: io.vertx.sqlclient.Tuple) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, arguments, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like preparedBatch from [[io.vertx.mysqlclient.MySQLPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def preparedBatchFuture(sql: java.lang.String,batch: java.util.List[io.vertx.sqlclient.Tuple]) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedBatch(sql, batch, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }



  type Point = io.vertx.mysqlclient.data.spatial.Point
  object Point {
    def apply() = new Point()
    def apply(json: JsonObject) = new Point(json)
  }



  type Polygon = io.vertx.mysqlclient.data.spatial.Polygon
  object Polygon {
    def apply() = new Polygon()
    def apply(json: JsonObject) = new Polygon(json)
  }



}
