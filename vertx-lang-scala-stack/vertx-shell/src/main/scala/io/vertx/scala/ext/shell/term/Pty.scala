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
import io.vertx.ext.shell.term.{Pty => JPty}
import io.vertx.ext.shell.term.{Tty => JTty}

/**
  * A pseudo terminal used for controlling a [[io.vertx.scala.ext.shell.term.Tty]]. This interface acts as a pseudo
  * terminal master, [[io.vertx.scala.ext.shell.term.Pty#slave]] returns the assocated slave pseudo terminal.
  */
class Pty(private val _asJava: JPty) {

  def asJava: JPty = _asJava

  /**
    * Set the standard out handler of the pseudo terminal.
    * @param handler the standard output
    * @return this current object
    */
  def stdoutHandler(handler: String => Unit): Pty = {
    _asJava.stdoutHandler(funcToHandler[java.lang.String](handler))
    this
  }

  /**
    * Write data to the slave standard input of the pseudo terminal.
    * @param data the data to write
    * @return this current object
    */
  def write(data: String): Pty = {
    _asJava.write(data)
    this
  }

  /**
    * Resize the terminal.
    * @return this current object
    */
  def setSize(width: Int, height: Int): Pty = {
    _asJava.setSize(width, height)
    this
  }

  /**
    * @return the pseudo terminal slave
    */
  def slave(): Tty = {
    Tty.apply(_asJava.slave())
  }

}

object Pty {

  def apply(_asJava: JPty): Pty =
    new Pty(_asJava)

  def create(): Pty = {
    Pty.apply(io.vertx.ext.shell.term.Pty.create())
  }

  def create(terminalType: String): Pty = {
    Pty.apply(io.vertx.ext.shell.term.Pty.create(terminalType))
  }

}
