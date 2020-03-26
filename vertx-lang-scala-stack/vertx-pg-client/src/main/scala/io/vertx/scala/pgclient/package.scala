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
     * Like handler from [[io.vertx.pgclient.pubsub.PgChannel]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def handler(handler: scala.Option[java.lang.String => Unit]) = {
      asJava.handler(handler.asInstanceOf[io.vertx.core.Handler[java.lang.String]])
  }

    /**
     * Like endHandler from [[io.vertx.pgclient.pubsub.PgChannel]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
  }

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
  }

  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[java.lang.String]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
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
    * <P>
    *   The connection object supports all the operations defined in the  interface,
    *   it also provides additional support:
    *   <ul>
    *     <li>Notification</li>
    *     <li>Request Cancellation</li>
    *   </ul>
    * </P>
    */

  implicit class PgConnectionScala(val asJava: io.vertx.pgclient.PgConnection) extends AnyVal {


    /**
     * Like cancelRequest from [[io.vertx.pgclient.PgConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def cancelRequestFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.cancelRequest(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like prepare from [[io.vertx.pgclient.PgConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def prepareFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.PreparedStatement] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.PreparedStatement]()
      asJava.prepare(sql, new Handler[AsyncResult[io.vertx.sqlclient.PreparedStatement]] { override def handle(event: AsyncResult[io.vertx.sqlclient.PreparedStatement]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type PgNotification = io.vertx.pgclient.PgNotification
  object PgNotification {
    def apply() = new PgNotification()
    def apply(json: JsonObject) = new PgNotification(json)
  }



  object PgPool {
    /**
     * Like pool from [[io.vertx.pgclient.PgPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool() = {
      io.vertx.pgclient.PgPool.pool()
  }

    /**
     * Like pool from [[io.vertx.pgclient.PgPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool(poolOptions: io.vertx.sqlclient.PoolOptions) = {
      io.vertx.pgclient.PgPool.pool(poolOptions)
  }

    /**
     * Like pool from [[io.vertx.pgclient.PgPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool(connectionUri: java.lang.String) = {
      io.vertx.pgclient.PgPool.pool(connectionUri)
  }

    /**
     * Like pool from [[io.vertx.pgclient.PgPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool(connectionUri: java.lang.String, poolOptions: io.vertx.sqlclient.PoolOptions) = {
      io.vertx.pgclient.PgPool.pool(connectionUri, poolOptions)
  }

    /**
     * Like pool from [[io.vertx.pgclient.PgPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool(vertx: io.vertx.core.Vertx, connectionUri: java.lang.String) = {
      io.vertx.pgclient.PgPool.pool(vertx, connectionUri)
  }

    /**
     * Like pool from [[io.vertx.pgclient.PgPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool(vertx: io.vertx.core.Vertx, poolOptions: io.vertx.sqlclient.PoolOptions) = {
      io.vertx.pgclient.PgPool.pool(vertx, poolOptions)
  }

    /**
     * Like pool from [[io.vertx.pgclient.PgPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool(vertx: io.vertx.core.Vertx, connectionUri: java.lang.String, poolOptions: io.vertx.sqlclient.PoolOptions) = {
      io.vertx.pgclient.PgPool.pool(vertx, connectionUri, poolOptions)
  }

    /**
     * Like pool from [[io.vertx.pgclient.PgPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool(connectOptions: io.vertx.pgclient.PgConnectOptions, poolOptions: io.vertx.sqlclient.PoolOptions) = {
      io.vertx.pgclient.PgPool.pool(connectOptions, poolOptions)
  }

    /**
     * Like pool from [[io.vertx.pgclient.PgPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool(vertx: io.vertx.core.Vertx, connectOptions: io.vertx.pgclient.PgConnectOptions, poolOptions: io.vertx.sqlclient.PoolOptions) = {
      io.vertx.pgclient.PgPool.pool(vertx, connectOptions, poolOptions)
  }
  }



  /**
    * A class for managing subscriptions using `LISTEN/UNLISTEN` to Postgres channels.
    * <p/>
    * The subscriber manages a single connection to Postgres.

    */

  implicit class PgSubscriberScala(val asJava: io.vertx.pgclient.pubsub.PgSubscriber) extends AnyVal {


    /**
     * Like connect from [[io.vertx.pgclient.pubsub.PgSubscriber]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def connectFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.connect(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
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
