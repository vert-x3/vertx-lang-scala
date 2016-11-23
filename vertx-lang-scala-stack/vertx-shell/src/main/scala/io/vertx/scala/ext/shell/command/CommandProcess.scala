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

package io.vertx.scala.ext.shell.command

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.shell.command.{CommandProcess => JCommandProcess}
import io.vertx.core.cli.{CommandLine => JCommandLine}
import io.vertx.scala.core.cli.CommandLine
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.ext.shell.cli.{CliToken => JCliToken}
import io.vertx.scala.ext.shell.cli.CliToken
import io.vertx.ext.shell.term.{Tty => JTty}
import io.vertx.scala.ext.shell.term.Tty
import io.vertx.ext.shell.session.{Session => JSession}
import io.vertx.scala.ext.shell.session.Session

/**
  * The command process provides interaction with the process of the command provided by Vert.x Shell.
  */
class CommandProcess(private val _asJava: JCommandProcess) {

  def asJava: JCommandProcess = _asJava

  /**
    * @return the current Vert.x instance
    */
  def vertx(): Vertx = {
    Vertx.apply(_asJava.vertx())
  }

  /**
    * @return the unparsed arguments tokens
    */
  def argsTokens(): scala.collection.mutable.Buffer[CliToken] = {
    _asJava.argsTokens().asScala.map(CliToken.apply)
  }

  /**
    * @return the actual string arguments of the command
    */
  def args(): scala.collection.mutable.Buffer[String] = {
    _asJava.args().asScala.map(x => x:String)
  }

  /**
    * @return the command line object or null
    */
  def commandLine(): CommandLine = {
    CommandLine.apply(_asJava.commandLine())
  }

  /**
    * @return the shell session
    */
  def session(): Session = {
    Session.apply(_asJava.session())
  }

  /**
    * @return true if the command is running in foreground
    */
  def isForeground(): Boolean = {
    _asJava.isForeground()
  }

  def stdinHandler(handler: io.vertx.core.Handler[String]): CommandProcess = {
    _asJava.stdinHandler((handler))
    this
  }

  /**
    * Set an interrupt handler, this handler is called when the command is interrupted, for instance user
    * press <code>Ctrl-C</code>.
    * @param handler the interrupt handler
    * @return this command
    */
  def interruptHandler(handler: io.vertx.core.Handler[Unit]): CommandProcess = {
    _asJava.interruptHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler.handle()))
    this
  }

  /**
    * Set a suspend handler, this handler is called when the command is suspended, for instance user
    * press <code>Ctrl-Z</code>.
    * @param handler the interrupt handler
    * @return this command
    */
  def suspendHandler(handler: io.vertx.core.Handler[Unit]): CommandProcess = {
    _asJava.suspendHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler.handle()))
    this
  }

  /**
    * Set a resume handler, this handler is called when the command is resumed, for instance user
    * types <code>bg</code> or <code>fg</code> to resume the command.
    * @param handler the interrupt handler
    * @return this command
    */
  def resumeHandler(handler: io.vertx.core.Handler[Unit]): CommandProcess = {
    _asJava.resumeHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler.handle()))
    this
  }

  /**
    * Set an end handler, this handler is called when the command is ended, for instance the command is running
    * and the shell closes.
    * @param handler the end handler
    * @return a reference to this, so the API can be used fluently
    */
  def endHandler(handler: io.vertx.core.Handler[Unit]): CommandProcess = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler.handle()))
    this
  }

  /**
    * Write some text to the standard output.
    * @param data the text
    * @return a reference to this, so the API can be used fluently
    */
  def write(data: String): CommandProcess = {
    _asJava.write(data)
    this
  }

  /**
    * Set a background handler, this handler is called when the command is running and put to background.
    * @param handler the background handler
    * @return this command
    */
  def backgroundHandler(handler: io.vertx.core.Handler[Unit]): CommandProcess = {
    _asJava.backgroundHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler.handle()))
    this
  }

  /**
    * Set a foreground handler, this handler is called when the command is running and put to foreground.
    * @param handler the foreground handler
    * @return this command
    */
  def foregroundHandler(handler: io.vertx.core.Handler[Unit]): CommandProcess = {
    _asJava.foregroundHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler.handle()))
    this
  }

  def resizehandler(handler: io.vertx.core.Handler[Unit]): CommandProcess = {
    _asJava.resizehandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler.handle()))
    this
  }

  /**
    * End the process with the exit status 
    */
  def end(): Unit = {
    _asJava.end()
  }

  /**
    * End the process.
    * @param status the exit status.
    */
  def end(status: Int): Unit = {
    _asJava.end(status)
  }

}

object CommandProcess {

  def apply(_asJava: JCommandProcess): CommandProcess =
    new CommandProcess(_asJava)

}
