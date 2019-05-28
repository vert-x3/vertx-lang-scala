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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.web.sstore.{SessionStore => JSessionStore}
import scala.reflect.runtime.universe._
import io.vertx.ext.web.{Session => JSession}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.ext.web.Session
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A session store is used to store sessions for an Vert.x-Web web app
  */

class SessionStore(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Initialize this store.   * @param vertx the vertx instance
   * @param options optional Json with extra configuration options
   * @return self
   */
  
  def init(vertx: Vertx, options: io.vertx.core.json.JsonObject): SessionStore = {
    asJava.asInstanceOf[JSessionStore].init(vertx.asJava.asInstanceOf[JVertx], options)
    this
  }



  /**
   * The retry timeout value in milli seconds used by the session handler when it retrieves a value from the store.<p/>
   *
   * A non positive value means there is no retry at all.   * @return the timeout value, in ms
   */
  def retryTimeout (): Long = {
    asJava.asInstanceOf[JSessionStore].retryTimeout().asInstanceOf[Long]
  }

  /**
   * Create a new session using the default min length.   * @param timeout - the session timeout, in ms
   * @return the session
   */
  def createSession (timeout: Long): Session = {
    Session(asJava.asInstanceOf[JSessionStore].createSession(timeout.asInstanceOf[java.lang.Long]))
  }

  /**
   * Create a new session.   * @param timeout - the session timeout, in ms
   * @param length - the required length for the session id
   * @return the session
   */
  def createSession (timeout: Long, length: Int): Session = {
    Session(asJava.asInstanceOf[JSessionStore].createSession(timeout.asInstanceOf[java.lang.Long], length.asInstanceOf[java.lang.Integer]))
  }

  /**
   * Get the session with the specified ID.   * @param cookieValue the unique ID of the session
   * @param resultHandler will be called with a result holding the session, or a failure
   */
  def get (cookieValue: String, resultHandler: Handler[AsyncResult[scala.Option[Session]]]): Unit = {
    asJava.asInstanceOf[JSessionStore].get(cookieValue.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSession]]{def handle(x: AsyncResult[JSession]) {resultHandler.handle(AsyncResultWrapper[JSession, scala.Option[Session]](x, a => scala.Option(a).map(Session(_))))}}))
  }

  /**
   * Delete the session with the specified ID.   * @param id the session id
   * @param resultHandler will be called with a success or a failure
   */
  def delete (id: String, resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JSessionStore].delete(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Add a session with the specified ID.   * @param session the session
   * @param resultHandler will be called with a success or a failure
   */
  def put (session: Session, resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JSessionStore].put(session.asJava.asInstanceOf[JSession], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Remove all sessions from the store.   * @param resultHandler will be called with a success or a failure
   */
  def clear (resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JSessionStore].clear((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Get the number of sessions in the store.
   * 
   * Beware of the result which is just an estimate, in particular with distributed session stores.   * @param resultHandler will be called with the number, or a failure
   */
  def size (resultHandler: Handler[AsyncResult[Int]]): Unit = {
    asJava.asInstanceOf[JSessionStore].size((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.Integer]]{def handle(x: AsyncResult[java.lang.Integer]) {resultHandler.handle(AsyncResultWrapper[java.lang.Integer, Int](x, a => a.asInstanceOf[Int]))}}))
  }

  /**
   * Close the store
   */
  def close (): Unit = {
    asJava.asInstanceOf[JSessionStore].close()
  }


 /**
  * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getFuture (cookieValue: String): scala.concurrent.Future[scala.Option[Session]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSession, scala.Option[Session]](x => scala.Option(x).map(Session(_)))
    asJava.asInstanceOf[JSessionStore].get(cookieValue.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[delete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deleteFuture (id: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSessionStore].delete(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def putFuture (session: Session): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSessionStore].put(session.asJava.asInstanceOf[JSession], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[clear]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def clearFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSessionStore].clear(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[size]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sizeFuture (): scala.concurrent.Future[Int] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Integer, Int](x => x.asInstanceOf[Int])
    asJava.asInstanceOf[JSessionStore].size(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object SessionStore {
  def apply(asJava: JSessionStore) = new SessionStore(asJava)
  
  /**
   * Create a Session store given a backend and configuration JSON.   * @param vertx vertx instance
   * @return the store or runtime exception
   */
  def create(vertx: Vertx): SessionStore = {
    SessionStore(JSessionStore.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
   * Create a Session store given a backend and configuration JSON.   * @param vertx vertx instance
   * @param options extra options for initialization
   * @return the store or runtime exception
   */
  def create(vertx: Vertx,options: io.vertx.core.json.JsonObject): SessionStore = {
    SessionStore(JSessionStore.create(vertx.asJava.asInstanceOf[JVertx], options))
  }

}
