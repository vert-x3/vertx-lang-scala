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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._

/**
  * A shell session.
  */
class Session(private val _asJava: io.vertx.ext.shell.session.Session) {

  def asJava: io.vertx.ext.shell.session.Session = _asJava

  /**
    * Put some data in a session
    * @param key the key for the data
    * @param obj the data
    * @return a reference to this, so the API can be used fluently
    */
  def put(key: String, obj: AnyRef): io.vertx.scala.ext.shell.session.Session = {
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

}

object Session {

  def apply(_asJava: io.vertx.ext.shell.session.Session): io.vertx.scala.ext.shell.session.Session =
    new io.vertx.scala.ext.shell.session.Session(_asJava)

  def create(): io.vertx.scala.ext.shell.session.Session = {
    Session.apply(io.vertx.ext.shell.session.Session.create())
  }

}
