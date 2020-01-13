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

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core.streams
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core
import io.vertx.core.{Future => JFuture}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.pgclient.pubsub.{PgChannel => JPgChannel}

package object pgclient{


  type Box = io.vertx.pgclient.data.Box
  object Box {
    def apply() = new Box()
    def apply(json: JsonObject) = new Box(json)
  }




  type Circle = io.vertx.pgclient.data.Circle
  object Circle {
    def apply() = new Circle()
    def apply(json: JsonObject) = new Circle(json)
  }




  type Interval = io.vertx.pgclient.data.Interval
  object Interval {
    def apply() = new Interval()
    def apply(json: JsonObject) = new Interval(json)
  }




  type Line = io.vertx.pgclient.data.Line
  object Line {
    def apply() = new Line()
    def apply(json: JsonObject) = new Line(json)
  }




  type LineSegment = io.vertx.pgclient.data.LineSegment
  object LineSegment {
    def apply() = new LineSegment()
    def apply(json: JsonObject) = new LineSegment(json)
  }




  type Path = io.vertx.pgclient.data.Path
  object Path {
    def apply() = new Path()
    def apply(json: JsonObject) = new Path(json)
  }




  /**
    * A channel to Postgres that tracks the subscription to a given Postgres channel using the `LISTEN/UNLISTEN` commands.
    * <p/>
    * When paused the channel discards the messages.

    */

  implicit class PgChannelScala(val asJava: io.vertx.pgclient.pubsub.PgChannel) extends AnyVal {


    /**
     * Like [[handler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def handler(handler: scala.Option[java.lang.String => Unit]): io.vertx.pgclient.pubsub.PgChannel = {
      asJava.handler(handler match {case Some(t) => p:java.lang.String => t(p); case None => null})
    }


    /**
     * Like [[endHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.pgclient.pubsub.PgChannel = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.pgclient.pubsub.PgChannel = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }

    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[java.lang.String]): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type PgConnectOptions = io.vertx.pgclient.PgConnectOptions
  object PgConnectOptions {
    def apply() = new PgConnectOptions()
    def apply(json: JsonObject) = new PgConnectOptions(json)
  }




  /**
    * A connection to Postgres.
    */

  implicit class PgConnectionScala(val asJava: io.vertx.pgclient.PgConnection) extends AnyVal {

    /**
     * Like [[cancelRequest]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def cancelRequestFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.cancelRequest({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def prepareFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.PreparedQuery] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.PreparedQuery]()
      asJava.prepare(sql, {a:AsyncResult[io.vertx.sqlclient.PreparedQuery] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def preparedQueryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def queryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.query(sql, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def preparedQueryFuture(sql: java.lang.String,arguments: io.vertx.sqlclient.Tuple): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, arguments, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def preparedBatchFuture(sql: java.lang.String,batch: java.util.List[io.vertx.sqlclient.Tuple]): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedBatch(sql, batch, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type PgNotification = io.vertx.pgclient.PgNotification
  object PgNotification {
    def apply() = new PgNotification()
    def apply(json: JsonObject) = new PgNotification(json)
  }




  /**
    * A pool of PostgreSQL connections.
    */

  implicit class PgPoolScala(val asJava: io.vertx.pgclient.PgPool) extends AnyVal {

    def preparedQueryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def queryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.query(sql, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def preparedQueryFuture(sql: java.lang.String,arguments: io.vertx.sqlclient.Tuple): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, arguments, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def preparedBatchFuture(sql: java.lang.String,batch: java.util.List[io.vertx.sqlclient.Tuple]): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedBatch(sql, batch, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  /**
    * A class for managing subscriptions using `LISTEN/UNLISTEN` to Postgres channels.
    * <p/>
    * The subscriber manages a single connection to Postgres.

    */

  implicit class PgSubscriberScala(val asJava: io.vertx.pgclient.pubsub.PgSubscriber) extends AnyVal {

    /**
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.connect({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type Point = io.vertx.pgclient.data.Point
  object Point {
    def apply() = new Point()
    def apply(json: JsonObject) = new Point(json)
  }




  type Polygon = io.vertx.pgclient.data.Polygon
  object Polygon {
    def apply() = new Polygon()
    def apply(json: JsonObject) = new Polygon(json)
  }



}
