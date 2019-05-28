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

package io.vertx.scala.ext.shell.term

import io.vertx.ext.shell.term.{Tty => JTty}
import scala.reflect.runtime.universe._
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Provide interactions with the Shell TTY.
  */

class Tty(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Set a stream handler on the standard input to read the data.   * @param handler the standard input
   * @return this object
   */
  
  def stdinHandler(handler: Handler[String]): Tty = {
    asJava.asInstanceOf[JTty].stdinHandler((if (handler == null) null else new io.vertx.core.Handler[java.lang.String]{def handle(x: java.lang.String) {handler.handle(x.asInstanceOf[String])}}))
    this
  }

  /**
   * Write data to the standard output.   * @param data the data to write
   * @return this object
   */
  
  def write(data: String): Tty = {
    asJava.asInstanceOf[JTty].write(data.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Set a resize handler, the handler is called when the tty size changes.   * @param handler the resize handler
   * @return this object
   */
  
  def resizehandler(handler: Handler[Unit]): Tty = {
    asJava.asInstanceOf[JTty].resizehandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }



  /**
   * @return the declared tty type, for instance ` vt100`, ` xterm-256`, etc... it can be null when the tty does not have declared its type.
   */
  def `type` (): String = {
    asJava.asInstanceOf[JTty].`type`().asInstanceOf[String]
  }

  /**
   * @return the current width, i.e the number of rows or ` -1` if unknown
   */
  def width (): Int = {
    asJava.asInstanceOf[JTty].width().asInstanceOf[Int]
  }

  /**
   * @return the current height, i.e the number of columns or ` -1` if unknown
   */
  def height (): Int = {
    asJava.asInstanceOf[JTty].height().asInstanceOf[Int]
  }


}

object Tty {
  def apply(asJava: JTty) = new Tty(asJava)
  
}
