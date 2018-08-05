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

import io.vertx.ext.shell.term.{Pty => JPty}
import io.vertx.ext.shell.term.{Tty => JTty}
import scala.reflect.runtime.universe._
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A pseudo terminal used for controlling a [[io.vertx.scala.ext.shell.term.Tty]]. This interface acts as a pseudo
  * terminal master, [[io.vertx.scala.ext.shell.term.Pty#slave]] returns the assocated slave pseudo terminal.
  */

class Pty(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Set the standard out handler of the pseudo terminal.   * @param handler the standard output
   * @return this current object
   */
  
  def stdoutHandler(handler: Handler[String]): Pty = {
    asJava.asInstanceOf[JPty].stdoutHandler({x: java.lang.String => handler.handle(x.asInstanceOf[String])})
    this
  }

  /**
   * Write data to the slave standard input of the pseudo terminal.   * @param data the data to write
   * @return this current object
   */
  
  def write(data: String): Pty = {
    asJava.asInstanceOf[JPty].write(data.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Resize the terminal.   * @return this current object
   */
  
  def setSize(width: Int, height: Int): Pty = {
    asJava.asInstanceOf[JPty].setSize(width.asInstanceOf[java.lang.Integer], height.asInstanceOf[java.lang.Integer])
    this
  }



  /**
   * @return the pseudo terminal slave
   */
  def slave (): Tty = {
    Tty(asJava.asInstanceOf[JPty].slave())
  }


}

object Pty {
  def apply(asJava: JPty) = new Pty(asJava)
  
  /**
   * Create a new pseudo terminal with no terminal type.   */
  def create(): Pty = {
    Pty(JPty.create())
  }

  /**
   * Create a new pseudo terminal.   * @param terminalType the terminal type, for instance ` vt100`
   * @return the created pseudo terminal
   */
  def create(terminalType: String): Pty = {
    Pty(JPty.create(terminalType.asInstanceOf[java.lang.String]))
  }

}
