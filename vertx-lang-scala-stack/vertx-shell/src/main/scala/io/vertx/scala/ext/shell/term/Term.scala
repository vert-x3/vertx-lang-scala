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
import io.vertx.ext.shell.term.{Term => JTerm}
import io.vertx.ext.shell.cli.{Completion => JCompletion}
import io.vertx.scala.ext.shell.cli.Completion
import io.vertx.ext.shell.term.{SignalHandler => JSignalHandler}
import io.vertx.ext.shell.term.{Tty => JTty}
import io.vertx.ext.shell.session.{Session => JSession}
import io.vertx.scala.ext.shell.session.Session

/**
  * The terminal.
  */
class Term(private val _asJava: JTerm) 
    extends  {

  def asJava: JTerm = _asJava

  def resizehandler(handler: () => Unit): Term = {
    _asJava.resizehandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  def stdinHandler(handler: String => Unit): Term = {
    _asJava.stdinHandler(funcToHandler[java.lang.String](handler))
    this
  }

  def write(data: String): Term = {
    _asJava.write(data)
    this
  }

  /**
    * @return the last time this term received input
    */
  def lastAccessedTime(): Long = {
    _asJava.lastAccessedTime()
  }

  /**
    * Echo some text in the terminal, escaped if necessary.<p/>
    * @param text the text to echo
    * @return a reference to this, so the API can be used fluently
    */
  def echo(text: String): Term = {
    _asJava.echo(text)
    this
  }

  /**
    * Associate the term with a session.
    * @param session the session to set
    * @return a reference to this, so the API can be used fluently
    */
  def setSession(session: Session): Term = {
    Term.apply(_asJava.setSession(session.asJava.asInstanceOf[JSession]))
  }

  /**
    * Set an interrupt signal handler on the term.
    * @param handler the interrupt handler
    * @return a reference to this, so the API can be used fluently
    */
  def interruptHandler(handler: SignalHandler): Term = {
    _asJava.interruptHandler(handler.asJava.asInstanceOf[JSignalHandler])
    this
  }

  /**
    * Set a suspend signal handler on the term.
    * @param handler the suspend handler
    * @return a reference to this, so the API can be used fluently
    */
  def suspendHandler(handler: SignalHandler): Term = {
    _asJava.suspendHandler(handler.asJava.asInstanceOf[JSignalHandler])
    this
  }

  /**
    * Prompt the user a line of text.
    * @param prompt the displayed prompt
    * @param lineHandler the line handler called with the line
    */
  def readline(prompt: String, lineHandler: String => Unit): Unit = {
    _asJava.readline(prompt, funcToHandler[java.lang.String](lineHandler))
  }

  /**
    * Prompt the user a line of text, providing a completion handler to handle user's completion.
    * @param prompt the displayed prompt
    * @param lineHandler the line handler called with the line
    * @param completionHandler the completion handler
    */
  def readline(prompt: String, lineHandler: String => Unit, completionHandler: Completion => Unit): Unit = {
    _asJava.readline(prompt, funcToHandler[java.lang.String](lineHandler), funcToMappedHandler(Completion.apply)(completionHandler))
  }

  /**
    * Set a handler that will be called when the terminal is closed.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def closeHandler(handler: () => Unit): Term = {
    _asJava.closeHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  /**
    * Close the connection to terminal.
    */
  def close(): Unit = {
    _asJava.close()
  }

}

object Term {

  def apply(_asJava: JTerm): Term =
    new Term(_asJava)

}
