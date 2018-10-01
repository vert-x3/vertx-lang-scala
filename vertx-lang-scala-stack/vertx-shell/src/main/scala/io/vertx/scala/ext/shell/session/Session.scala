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

package io.vertx.scala.ext.shell.session

import scala.reflect.runtime.universe._
import io.vertx.ext.shell.session.{Session => JSession}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A shell session.
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


}

object Session {
  def apply(asJava: JSession) = new Session(asJava)
  
  /**
   * Create a new empty session.   * @return the created session
   */
  def create(): Session = {
    Session(JSession.create())
  }

}
