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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.shell.term.{Tty => JTty}

/**
  * Provide interactions with the Shell TTY.
  */
class Tty(private val _asJava: JTty) {

  def asJava: JTty = _asJava

  /**
    * @return the declared tty type, for instance ` vt100`, ` xterm-256`, etc... it can be null when the tty does not have declared its type.
    */
  def `type`(): String = {
    _asJava.`type`()
  }

  /**
    * @return the current width, i.e the number of rows or ` -1` if unknown
    */
  def width(): Int = {
    _asJava.width()
  }

  /**
    * @return the current height, i.e the number of columns or ` -1` if unknown
    */
  def height(): Int = {
    _asJava.height()
  }

  /**
    * Set a stream handler on the standard input to read the data.
    * @param handler the standard input
    * @return this object
    */
  def stdinHandler(handler: String => Unit): Tty = {
    _asJava.stdinHandler(funcToHandler[java.lang.String](handler))
    this
  }

  /**
    * Write data to the standard output.
    * @param data the data to write
    * @return this object
    */
  def write(data: String): Tty = {
    _asJava.write(data)
    this
  }

  /**
    * Set a resize handler, the handler is called when the tty size changes.
    * @param handler the resize handler
    * @return this object
    */
  def resizehandler(handler: () => Unit): Tty = {
    _asJava.resizehandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

}

object Tty {

  def apply(_asJava: JTty): Tty =
    new Tty(_asJava)

}
