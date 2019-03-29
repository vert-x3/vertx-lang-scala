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

package io.vertx.scala.ext.web.common

import scala.reflect.runtime.universe._
import io.vertx.ext.web.common.{WebEnvironment => JWebEnvironment}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Utility API to verify which environment is the web application running.
  *
  * The utility will check initially for the existence of a system property under the name `vertx.mode`,
  * if there is no such property then it will look under the environment variables under the name `VERTX_MODE`.
  *
  * This value will be then used when the API is invoked. By itself this utility will not
  * affect the behavior of your application, however you can use it to simplify your handlers, e.g.:
  *
  * When the development mode is active you can log more information or disable caches.
  */

class WebEnvironment(private val _asJava: Object) {
  def asJava = _asJava






}

object WebEnvironment {
  def apply(asJava: JWebEnvironment) = new WebEnvironment(asJava)
  
  /**
   * Will return true if the mode is not null and equals ignoring case the string "dev"   * @return always boolean
   */
  def development(): Boolean = {
    JWebEnvironment.development().asInstanceOf[Boolean]
  }

  /**
   * The current mode from the system properties with fallback to environment variables   * @return String with mode value or null
   */
  def mode(): scala.Option[String] = {
    scala.Option(JWebEnvironment.mode().asInstanceOf[String])
  }

}
