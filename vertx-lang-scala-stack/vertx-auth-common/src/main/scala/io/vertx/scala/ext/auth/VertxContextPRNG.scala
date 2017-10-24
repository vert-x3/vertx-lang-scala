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

package io.vertx.scala.ext.auth

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.auth.{VertxContextPRNG => JVertxContextPRNG}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * A secure non blocking random number generator isolated to the current context. The PRNG is bound to the vert.x
  * context and setup to close when the context shuts down.
  * 
  * When applicable, use of VertxContextPRNG rather than create new PRNG objects is helpful to keep the system entropy
  * usage to the minimum avoiding potential blocking across the application.
  * 
  * The use of VertxContextPRNG is particularly appropriate when multiple handlers use random numbers.
  */
class VertxContextPRNG(private val _asJava: Object) {

  def asJava = _asJava


  /**
    * Returns a Base64 mime encoded String of random data with the given length. The length parameter refers to the length
    * of the String before the encoding step.
    * @param length the desired string length before Base64 encoding.
    * @return A base 64 encoded string.
    */
  def nextString(length: Int): String = {
    asJava.asInstanceOf[JVertxContextPRNG].nextString(length.asInstanceOf[java.lang.Integer]).asInstanceOf[String]
  }

  /**
    * Returns a secure random int
    * @return random int.
    */
  def nextInt(): Int = {
    asJava.asInstanceOf[JVertxContextPRNG].nextInt().asInstanceOf[Int]
  }

}

object VertxContextPRNG {
  def apply(asJava: JVertxContextPRNG) = new VertxContextPRNG(asJava)  
  /**
    * Get or create a secure non blocking random number generator using the current vert.x context. If there is no
    * current context (i.e.: not running on the eventloop) then a IllegalStateException is thrown.
    * @return A secure non blocking random number generator.
    */
  def current(): VertxContextPRNG = {
    VertxContextPRNG(JVertxContextPRNG.current())
  }

  /**
    * Get or create a secure non blocking random number generator using the current vert.x instance. Since the context
    * might be different this method will attempt to use the current context first if available and then fall back to
    * create a new instance of the PRNG.
    * @param vertx a Vert.x instance.
    * @return A secure non blocking random number generator.
    */
  def current(vertx: Vertx): VertxContextPRNG = {
    VertxContextPRNG(JVertxContextPRNG.current(vertx.asJava.asInstanceOf[JVertx]))
  }

}
