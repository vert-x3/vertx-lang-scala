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

package io.vertx.scala.ext.web.sstore

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.web.sstore.{SessionStore => JSessionStore}
import io.vertx.ext.web.{Session => JSession}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.ext.web.Session

/**
  * A session store is used to store sessions for an Vert.x-Web web app
  */
class SessionStore(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  def retryTimeout():Long = {
    asJava.asInstanceOf[JSessionStore].retryTimeout().asInstanceOf[Long]
  }

  def createSession(timeout: Long):Session = {
    Session(asJava.asInstanceOf[JSessionStore].createSession(timeout.asInstanceOf[java.lang.Long]))
  }

  def createSession(timeout: Long,length: Int):Session = {
    Session(asJava.asInstanceOf[JSessionStore].createSession(timeout.asInstanceOf[java.lang.Long],length.asInstanceOf[java.lang.Integer]))
  }

  def get(id: String,resultHandler: Handler[AsyncResult[Session]]):Unit = {
    asJava.asInstanceOf[JSessionStore].get(id.asInstanceOf[java.lang.String],{x: AsyncResult[JSession] => resultHandler.handle(AsyncResultWrapper[JSession,Session](x, a => Session(a)))})
  }

  def delete(id: String,resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JSessionStore].delete(id.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Boolean] => resultHandler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a.asInstanceOf[Boolean]))})
  }

  def put(session: Session,resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JSessionStore].put(session.asJava.asInstanceOf[JSession],{x: AsyncResult[java.lang.Boolean] => resultHandler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a.asInstanceOf[Boolean]))})
  }

  def clear(resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JSessionStore].clear({x: AsyncResult[java.lang.Boolean] => resultHandler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a.asInstanceOf[Boolean]))})
  }

  def size(resultHandler: Handler[AsyncResult[Int]]):Unit = {
    asJava.asInstanceOf[JSessionStore].size({x: AsyncResult[java.lang.Integer] => resultHandler.handle(AsyncResultWrapper[java.lang.Integer,Int](x, a => a.asInstanceOf[Int]))})
  }

  def close():Unit = {
    asJava.asInstanceOf[JSessionStore].close()
  }

//future methods
    def getFuture(id: String):scala.concurrent.Future[Session] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSession, Session](x => if (x == null) null.asInstanceOf[Session] else Session(x))
    asJava.asInstanceOf[JSessionStore].get(id.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def deleteFuture(id: String):scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => if (x == null) null.asInstanceOf[Boolean] else x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JSessionStore].delete(id.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def putFuture(session: Session):scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => if (x == null) null.asInstanceOf[Boolean] else x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JSessionStore].put(session.asJava.asInstanceOf[JSession],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def clearFuture():scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => if (x == null) null.asInstanceOf[Boolean] else x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JSessionStore].clear(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def sizeFuture():scala.concurrent.Future[Int] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Integer, Int](x => if (x == null) null.asInstanceOf[Int] else x.asInstanceOf[Int])
    asJava.asInstanceOf[JSessionStore].size(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object SessionStore{
    def apply(asJava: JSessionStore) = new SessionStore(asJava)  
  //static methods
  }
