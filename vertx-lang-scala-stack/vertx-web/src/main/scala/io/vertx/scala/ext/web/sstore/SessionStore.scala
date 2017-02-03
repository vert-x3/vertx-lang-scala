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

import io.vertx.lang.scala.HandlerOps._
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

  /**
    * The retry timeout value in milli seconds used by the session handler when it retrieves a value from the store.<p/>
    *
    * A non positive value means there is no retry at all.
    * @return the timeout value, in ms
    */
  def retryTimeout(): Long = {
    asJava.asInstanceOf[JSessionStore].retryTimeout().asInstanceOf[Long]
  }

  /**
    * Create a new session using the default min length.
    * @param timeout - the session timeout, in ms
    * @return the session
    */
  def createSession(timeout: Long): Session = {
    Session(asJava.asInstanceOf[JSessionStore].createSession(timeout.asInstanceOf[java.lang.Long]))
  }

  /**
    * Create a new session
    * @param timeout - the session timeout, in ms
    * @param length - the required length for the session id
    * @return the session
    */
  def createSession(timeout: Long, length: Int): Session = {
    Session(asJava.asInstanceOf[JSessionStore].createSession(timeout.asInstanceOf[java.lang.Long], length.asInstanceOf[java.lang.Integer]))
  }

  /**
    * Get the session with the specified ID
    * @param id the unique ID of the session
    */
  def get(id: String, resultHandler: Handler[AsyncResult[Session]]): Unit = {
    asJava.asInstanceOf[JSessionStore].get(id.asInstanceOf[java.lang.String], {x: AsyncResult[JSession] => resultHandler.handle(AsyncResultWrapper[JSession, Session](x, a => Session(a)))})
  }

  /**
    * Delete the session with the specified ID
    * @param id the unique ID of the session
    */
  def delete(id: String, resultHandler: Handler[AsyncResult[Boolean]]): Unit = {
    asJava.asInstanceOf[JSessionStore].delete(id.asInstanceOf[java.lang.String], {x: AsyncResult[java.lang.Boolean] => resultHandler.handle(AsyncResultWrapper[java.lang.Boolean, Boolean](x, a => a.asInstanceOf[Boolean]))})
  }

  /**
    * Add a session with the specified ID
    * @param session the session
    */
  def put(session: Session, resultHandler: Handler[AsyncResult[Boolean]]): Unit = {
    asJava.asInstanceOf[JSessionStore].put(session.asJava.asInstanceOf[JSession], {x: AsyncResult[java.lang.Boolean] => resultHandler.handle(AsyncResultWrapper[java.lang.Boolean, Boolean](x, a => a.asInstanceOf[Boolean]))})
  }

  /**
    * Remove all sessions from the store
    */
  def clear(resultHandler: Handler[AsyncResult[Boolean]]): Unit = {
    asJava.asInstanceOf[JSessionStore].clear({x: AsyncResult[java.lang.Boolean] => resultHandler.handle(AsyncResultWrapper[java.lang.Boolean, Boolean](x, a => a.asInstanceOf[Boolean]))})
  }

  /**
    * Get the number of sessions in the store
    */
  def size(resultHandler: Handler[AsyncResult[Int]]): Unit = {
    asJava.asInstanceOf[JSessionStore].size({x: AsyncResult[java.lang.Integer] => resultHandler.handle(AsyncResultWrapper[java.lang.Integer, Int](x, a => a.asInstanceOf[Int]))})
  }

  /**
    * Close the store
    */
  def close(): Unit = {
    asJava.asInstanceOf[JSessionStore].close()
  }

 /**
   * Get the session with the specified ID
   * @param id the unique ID of the session
   * @return will be called with a result holding the session, or a failure
   */
  def getFuture(id: String): scala.concurrent.Future[Session] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSession, Session](x => Session(x))
    asJava.asInstanceOf[JSessionStore].get(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Delete the session with the specified ID
   * @param id the unique ID of the session
   * @return will be called with a result true/false, or a failure
   */
  def deleteFuture(id: String): scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JSessionStore].delete(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Add a session with the specified ID
   * @param session the session
   * @return will be called with a result true/false, or a failure
   */
  def putFuture(session: Session): scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JSessionStore].put(session.asJava.asInstanceOf[JSession], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove all sessions from the store
   * @return will be called with a result true/false, or a failure
   */
  def clearFuture(): scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JSessionStore].clear(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the number of sessions in the store
   * @return will be called with the number, or a failure
   */
  def sizeFuture(): scala.concurrent.Future[Int] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Integer, Int](x => x.asInstanceOf[Int])
    asJava.asInstanceOf[JSessionStore].size(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object SessionStore {
  def apply(asJava: JSessionStore) = new SessionStore(asJava)  
}
