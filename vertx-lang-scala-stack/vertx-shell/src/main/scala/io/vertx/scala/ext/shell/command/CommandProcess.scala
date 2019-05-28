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

import scala.reflect.runtime.universe._
import io.vertx.ext.shell.command.{CommandProcess => JCommandProcess}
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.ext.shell.session.{Session => JSession}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.ext.shell.cli.CliToken
import io.vertx.lang.scala.Converter._
import io.vertx.ext.shell.term.{Tty => JTty}
import io.vertx.scala.ext.shell.session.Session
import io.vertx.scala.core.cli.CommandLine
import io.vertx.core.cli.{CommandLine => JCommandLine}
import io.vertx.scala.ext.shell.term.Tty
import io.vertx.ext.shell.cli.{CliToken => JCliToken}
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * The command process provides interaction with the process of the command provided by Vert.x Shell.
  */

class CommandProcess(private val _asJava: Object) extends Tty (_asJava) {





  override 
  def stdinHandler(handler: Handler[String]): CommandProcess = {
    asJava.asInstanceOf[JCommandProcess].stdinHandler((if (handler == null) null else new io.vertx.core.Handler[java.lang.String]{def handle(x: java.lang.String) {handler.handle(x.asInstanceOf[String])}}))
    this
  }

  /**
   * Set an interrupt handler, this handler is called when the command is interrupted, for instance user
   * press <code>Ctrl-C</code>.   * @param handler the interrupt handler
   * @return this command
   */
  
  def interruptHandler(handler: Handler[Unit]): CommandProcess = {
    asJava.asInstanceOf[JCommandProcess].interruptHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }

  /**
   * Set a suspend handler, this handler is called when the command is suspended, for instance user
   * press <code>Ctrl-Z</code>.   * @param handler the interrupt handler
   * @return this command
   */
  
  def suspendHandler(handler: Handler[Unit]): CommandProcess = {
    asJava.asInstanceOf[JCommandProcess].suspendHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }

  /**
   * Set a resume handler, this handler is called when the command is resumed, for instance user
   * types <code>bg</code> or <code>fg</code> to resume the command.   * @param handler the interrupt handler
   * @return this command
   */
  
  def resumeHandler(handler: Handler[Unit]): CommandProcess = {
    asJava.asInstanceOf[JCommandProcess].resumeHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }

  /**
   * Set an end handler, this handler is called when the command is ended, for instance the command is running
   * and the shell closes.   * @param handler the end handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def endHandler(handler: Handler[Unit]): CommandProcess = {
    asJava.asInstanceOf[JCommandProcess].endHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }

  /**
   * Write some text to the standard output.   * @param data the text
   * @return a reference to this, so the API can be used fluently
   */
  override 
  def write(data: String): CommandProcess = {
    asJava.asInstanceOf[JCommandProcess].write(data.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Set a background handler, this handler is called when the command is running and put to background.   * @param handler the background handler
   * @return this command
   */
  
  def backgroundHandler(handler: Handler[Unit]): CommandProcess = {
    asJava.asInstanceOf[JCommandProcess].backgroundHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }

  /**
   * Set a foreground handler, this handler is called when the command is running and put to foreground.   * @param handler the foreground handler
   * @return this command
   */
  
  def foregroundHandler(handler: Handler[Unit]): CommandProcess = {
    asJava.asInstanceOf[JCommandProcess].foregroundHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }


  override 
  def resizehandler(handler: Handler[Unit]): CommandProcess = {
    asJava.asInstanceOf[JCommandProcess].resizehandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }



  /**
   * @return the current Vert.x instance
   */
  def vertx (): Vertx = {
    Vertx(asJava.asInstanceOf[JCommandProcess].vertx())
  }

  /**
   * @return the unparsed arguments tokens
   */
  def argsTokens (): scala.collection.mutable.Buffer[CliToken] = {
    asJava.asInstanceOf[JCommandProcess].argsTokens().asScala.map(x => CliToken(x))
  }

  /**
   * @return the actual string arguments of the command
   */
  def args (): scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JCommandProcess].args().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * @return the command line object or null
   */
  def commandLine (): CommandLine = {
    CommandLine(asJava.asInstanceOf[JCommandProcess].commandLine())
  }

  /**
   * @return the shell session
   */
  def session (): Session = {
    Session(asJava.asInstanceOf[JCommandProcess].session())
  }

  /**
   * @return true if the command is running in foreground
   */
  def isForeground (): Boolean = {
    asJava.asInstanceOf[JCommandProcess].isForeground().asInstanceOf[Boolean]
  }

  /**
   * End the process with the exit status 
   */
  def end (): Unit = {
    asJava.asInstanceOf[JCommandProcess].end()
  }

  /**
   * End the process.   * @param status the exit status.
   */
  def end (status: Int): Unit = {
    asJava.asInstanceOf[JCommandProcess].end(status.asInstanceOf[java.lang.Integer])
  }


}

object CommandProcess {
  def apply(asJava: JCommandProcess) = new CommandProcess(asJava)
  
}
