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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.shell.term.{SignalHandler => JSignalHandler}
import io.vertx.scala.ext.shell.cli.Completion
import io.vertx.ext.shell.term.{Tty => JTty}
import io.vertx.scala.ext.shell.session.Session
import io.vertx.core.Handler
import io.vertx.ext.shell.term.{Term => JTerm}
import io.vertx.ext.shell.cli.{Completion => JCompletion}
import io.vertx.ext.shell.session.{Session => JSession}

/**
  * The terminal.
  */
class Term(private val _asJava: Object) 
    extends Tty(_asJava)  {


//io.vertx.core.Handler<java.lang.Void>
  override def resizehandler(handler: Handler[Unit]):Term = {
    asJava.asInstanceOf[JTerm].resizehandler({x: Void => handler.handle(x)})
    this
  }

//io.vertx.core.Handler<java.lang.String>
  override def stdinHandler(handler: Handler[String]):Term = {
    asJava.asInstanceOf[JTerm].stdinHandler({x: java.lang.String => handler.handle(x.asInstanceOf[String])})
    this
  }

//java.lang.String
  override def write(data: String):Term = {
    asJava.asInstanceOf[JTerm].write(data.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Echo some text in the terminal, escaped if necessary.<p/>
    * @param text the text to echo
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
  def echo(text: String):Term = {
    asJava.asInstanceOf[JTerm].echo(text.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set an interrupt signal handler on the term.
    * @param handler the interrupt handler
    * @return a reference to this, so the API can be used fluently
    */
//io.vertx.ext.shell.term.SignalHandler
  def interruptHandler(handler: SignalHandler):Term = {
    asJava.asInstanceOf[JTerm].interruptHandler(handler.asJava.asInstanceOf[JSignalHandler])
    this
  }

  /**
    * Set a suspend signal handler on the term.
    * @param handler the suspend handler
    * @return a reference to this, so the API can be used fluently
    */
//io.vertx.ext.shell.term.SignalHandler
  def suspendHandler(handler: SignalHandler):Term = {
    asJava.asInstanceOf[JTerm].suspendHandler(handler.asJava.asInstanceOf[JSignalHandler])
    this
  }

  /**
    * Set a handler that will be called when the terminal is closed.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
//io.vertx.core.Handler<java.lang.Void>
  def closeHandler(handler: Handler[Unit]):Term = {
    asJava.asInstanceOf[JTerm].closeHandler({x: Void => handler.handle(x)})
    this
  }

  /**
    * @return the last time this term received input
    */
  def lastAccessedTime():Long = {
    asJava.asInstanceOf[JTerm].lastAccessedTime().asInstanceOf[Long]
  }

  /**
    * Associate the term with a session.
    * @param session the session to set
    * @return a reference to this, so the API can be used fluently
    */
  def setSession(session: Session):Term = {
    Term(asJava.asInstanceOf[JTerm].setSession(session.asJava.asInstanceOf[JSession]))
  }

  /**
    * Prompt the user a line of text.
    * @param prompt the displayed prompt
    * @param lineHandler the line handler called with the line
    */
  def readline(prompt: String,lineHandler: Handler[String]):Unit = {
    asJava.asInstanceOf[JTerm].readline(prompt.asInstanceOf[java.lang.String],{x: java.lang.String => lineHandler.handle(x.asInstanceOf[String])})
  }

  /**
    * Prompt the user a line of text, providing a completion handler to handle user's completion.
    * @param prompt the displayed prompt
    * @param lineHandler the line handler called with the line
    * @param completionHandler the completion handler
    */
  def readline(prompt: String,lineHandler: Handler[String],completionHandler: Handler[Completion]):Unit = {
    asJava.asInstanceOf[JTerm].readline(prompt.asInstanceOf[java.lang.String],{x: java.lang.String => lineHandler.handle(x.asInstanceOf[String])},{x: JCompletion => completionHandler.handle(Completion(x))})
  }

  /**
    * Close the connection to terminal.
    */
  def close():Unit = {
    asJava.asInstanceOf[JTerm].close()
  }

}

object Term{
  def apply(asJava: JTerm) = new Term(asJava)  
}
