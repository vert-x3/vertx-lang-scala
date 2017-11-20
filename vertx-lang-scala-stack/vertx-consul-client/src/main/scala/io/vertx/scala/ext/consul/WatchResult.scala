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

package io.vertx.scala.ext.consul

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.consul.{WatchResult => JWatchResult}

class WatchResult[T: TypeTag](private val _asJava: Object) {

  def asJava = _asJava


  /**
    * The previous result of the operation.
    * @return the previous result.
    */
  def prevResult(): T = {
    toScala[T](asJava.asInstanceOf[JWatchResult[Object]].prevResult())
  }

  /**
    * The next result of the operation. This will be null if the operation failed.
    * @return the next result or null if the operation failed.
    */
  def nextResult(): T = {
    toScala[T](asJava.asInstanceOf[JWatchResult[Object]].nextResult())
  }

  /**
    * A Throwable describing failure. This will be null if the operation succeeded.
    * @return the cause or null if the operation succeeded.
    */
  def cause(): Throwable = {
    asJava.asInstanceOf[JWatchResult[Object]].cause()
  }

  /**
    * Did it succeed?
    * @return true if it succeded or false otherwise
    */
  def succeeded(): Boolean = {
    asJava.asInstanceOf[JWatchResult[Object]].succeeded().asInstanceOf[Boolean]
  }

  /**
    * Did it fail?
    * @return true if it failed or false otherwise
    */
  def failed(): Boolean = {
    asJava.asInstanceOf[JWatchResult[Object]].failed().asInstanceOf[Boolean]
  }

}

object WatchResult {
  def apply[T: TypeTag](asJava: JWatchResult[_]) = new WatchResult[T](asJava)  
}
