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

package io.vertx.scala.ext.web

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.web.{Session => JSession}
  import io.vertx.ext.web.{Session => JSession}
    
/**
  * Represents a browser session.
  * 
  * Sessions persist between HTTP requests for a single browser session. They are deleted when the browser is closed, or
  * they time-out. Session cookies are used to maintain sessions using a secure UUID.
  * 
  * Sessions can be used to maintain data for a browser session, e.g. a shopping basket.
  * 
  * The context must have first been routed to a [[io.vertx.scala.ext.web.handler.SessionHandler]]
  * for sessions to be available.
  */
class Session(private val _asJava: JSession) {

  def asJava: JSession = _asJava

  /**
    * @return The unique ID of the session. This is generated using a random secure UUID.
    */
  def id(): String = {
    _asJava.id()
  }

  /**
    * Put some data in a session
    * @param key the key for the data
    * @param obj the data
    * @return a reference to this, so the API can be used fluently
    */
  def put(key: String, obj: AnyRef): Session = {
    _asJava.put(key, obj)
    this
  }

  /**
    * Get some data from the session
    * @param key the key of the data
    * @return the data
    */
  def get[T](key: String): T = {
    _asJava.get(key)
  }

  /**
    * Remove some data from the session
    * @param key the key of the data
    * @return the data that was there or null if none there
    */
  def remove[T](key: String): T = {
    _asJava.remove(key)
  }

  /**
    * @return the time the session was last accessed
    */
  def lastAccessed(): Long = {
    _asJava.lastAccessed()
  }

  /**
    * Destroy the session
    */
  def destroy(): Unit = {
    _asJava.destroy()
  }

  /**
    * @return has the session been destroyed?
    */
  def isDestroyed(): Boolean = {
    _asJava.isDestroyed()
  }

  /**
    * @return the amount of time in ms, after which the session will expire, if not accessed.
    */
  def timeout(): Long = {
    _asJava.timeout()
  }

  /**
    * Mark the session as being accessed.
    */
  def setAccessed(): Unit = {
    _asJava.setAccessed()
  }

}

object Session {

  def apply(_asJava: JSession): Session =
    new Session(_asJava)

}
