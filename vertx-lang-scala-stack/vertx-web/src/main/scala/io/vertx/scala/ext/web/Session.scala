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

import scala.reflect.runtime.universe._
import io.vertx.ext.web.{Session => JSession}
import scala.collection.JavaConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

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

class Session(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Put some data in a session   * @param key the key for the data
   * @param obj the data
   * @return a reference to this, so the API can be used fluently
   */
  
  def put(key: String, obj: AnyRef): Session = {
    asJava.asInstanceOf[JSession].put(key.asInstanceOf[java.lang.String], obj)
    this
  }


  /**
   * The short representation of the session to be added to the session cookie. By default is the session id.   * @return short representation string.
   */
  def value(): String = {
    asJava.asInstanceOf[JSession].value().asInstanceOf[String]
  }


  /**
   * @return The new unique ID of the session.
   */
  def regenerateId (): Session = {
    Session(asJava.asInstanceOf[JSession].regenerateId())
  }

  /**
   * @return The unique ID of the session. This is generated using a random secure UUID.
   */
  def id (): String = {
    asJava.asInstanceOf[JSession].id().asInstanceOf[String]
  }

  /**
   * Get some data from the session   * @param key the key of the data
   * @return the data
   */
  def get [T: TypeTag](key: String): T = {
    toScala[T](asJava.asInstanceOf[JSession].get[Object](key.asInstanceOf[java.lang.String]))
  }

  /**
   * Remove some data from the session   * @param key the key of the data
   * @return the data that was there or null if none there
   */
  def remove [T: TypeTag](key: String): T = {
    toScala[T](asJava.asInstanceOf[JSession].remove[Object](key.asInstanceOf[java.lang.String]))
  }

  /**
   * @return true if the session has data
   */
  def isEmpty (): Boolean = {
    asJava.asInstanceOf[JSession].isEmpty().asInstanceOf[Boolean]
  }

  /**
   * @return the time the session was last accessed
   */
  def lastAccessed (): Long = {
    asJava.asInstanceOf[JSession].lastAccessed().asInstanceOf[Long]
  }

  /**
   * Destroy the session
   */
  def destroy (): Unit = {
    asJava.asInstanceOf[JSession].destroy()
  }

  /**
   * @return has the session been destroyed?
   */
  def isDestroyed (): Boolean = {
    asJava.asInstanceOf[JSession].isDestroyed().asInstanceOf[Boolean]
  }

  /**
   * @return has the session been renewed?
   */
  def isRegenerated (): Boolean = {
    asJava.asInstanceOf[JSession].isRegenerated().asInstanceOf[Boolean]
  }

  /**
   * @return old ID if renewed
   */
  def oldId (): String = {
    asJava.asInstanceOf[JSession].oldId().asInstanceOf[String]
  }

  /**
   * @return the amount of time in ms, after which the session will expire, if not accessed.
   */
  def timeout (): Long = {
    asJava.asInstanceOf[JSession].timeout().asInstanceOf[Long]
  }

  /**
   * Mark the session as being accessed.
   */
  def setAccessed (): Unit = {
    asJava.asInstanceOf[JSession].setAccessed()
  }


}

object Session {
  def apply(asJava: JSession) = new Session(asJava)

}
