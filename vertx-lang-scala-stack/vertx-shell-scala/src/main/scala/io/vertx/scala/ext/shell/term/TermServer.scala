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
import io.vertx.ext.shell.term.TelnetTermOptions
import io.vertx.ext.shell.term.HttpTermOptions
import io.vertx.ext.shell.term.SSHTermOptions
import io.vertx.scala.core.Vertx
import io.vertx.scala.ext.web.Router
import io.vertx.core.Handler
import io.vertx.scala.ext.auth.AuthProvider

/**
  * A server for terminal based applications.
  */
class TermServer(private val _asJava: io.vertx.ext.shell.term.TermServer) {

  def asJava: io.vertx.ext.shell.term.TermServer = _asJava

  /**
    * Set the term handler that will receive incoming client connections. When a remote terminal connects
    * the `handler` will be called with the [[io.vertx.scala.ext.shell.term.Term]] which can be used to interact with the remote
    * terminal.
    * @param handler the term handler
    * @return this object
    */
  def termHandler(handler: io.vertx.scala.ext.shell.term.Term => Unit): io.vertx.scala.ext.shell.term.TermServer = {
    _asJava.termHandler(funcToMappedHandler(Term.apply)(handler))
    this
  }

  /**
    * Set an auth provider to use, any provider configured in options will override this provider. This should be used
    * when a custom auth provider should be used.
    * @param provider the auth to use
    * @return this object
    */
  def authProvider(provider: io.vertx.scala.ext.auth.AuthProvider): io.vertx.scala.ext.shell.term.TermServer = {
    _asJava.authProvider(provider.asJava.asInstanceOf[io.vertx.ext.auth.AuthProvider])
    this
  }

  /**
    * Bind the term server, the [[io.vertx.scala.ext.shell.term.TermServer#termHandler]] must be set before.
    * @return this object
    */
  def listen(): io.vertx.scala.ext.shell.term.TermServer = {
    _asJava.listen()
    this
  }

  /**
    * Bind the term server, the [[io.vertx.scala.ext.shell.term.TermServer#termHandler]] must be set before.
    * @return the listen future
    */
  def listenFuture(): concurrent.Future[io.vertx.scala.ext.shell.term.TermServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.shell.term.TermServer,io.vertx.scala.ext.shell.term.TermServer]((x => if (x == null) null else TermServer.apply(x)))
    _asJava.listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * The actual port the server is listening on. This is useful if you bound the server specifying 0 as port number
    * signifying an ephemeral port
    * @return the actual port the server is listening on.
    */
  def actualPort(): Int = {
    _asJava.actualPort()
  }

  /**
    * Close the server. This will close any currently open connections. The close may not complete until after this
    * method has returned.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Like [[io.vertx.scala.ext.shell.term.TermServer#close]] but supplying a handler that will be notified when close is complete.
    * @return the future to be notified when the term server is closed
    */
  def closeFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object TermServer {

  def apply(_asJava: io.vertx.ext.shell.term.TermServer): io.vertx.scala.ext.shell.term.TermServer =
    new io.vertx.scala.ext.shell.term.TermServer(_asJava)

  def createSSHTermServer(vertx: io.vertx.scala.core.Vertx): io.vertx.scala.ext.shell.term.TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createSSHTermServer(vertx.asJava.asInstanceOf[io.vertx.core.Vertx]))
  }

  def createSSHTermServer(vertx: io.vertx.scala.core.Vertx, options: io.vertx.scala.ext.shell.term.SSHTermOptions): io.vertx.scala.ext.shell.term.TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createSSHTermServer(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], options.asJava))
  }

  def createTelnetTermServer(vertx: io.vertx.scala.core.Vertx): io.vertx.scala.ext.shell.term.TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createTelnetTermServer(vertx.asJava.asInstanceOf[io.vertx.core.Vertx]))
  }

  def createTelnetTermServer(vertx: io.vertx.scala.core.Vertx, options: io.vertx.scala.ext.shell.term.TelnetTermOptions): io.vertx.scala.ext.shell.term.TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createTelnetTermServer(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], options.asJava))
  }

  def createHttpTermServer(vertx: io.vertx.scala.core.Vertx): io.vertx.scala.ext.shell.term.TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createHttpTermServer(vertx.asJava.asInstanceOf[io.vertx.core.Vertx]))
  }

  def createHttpTermServer(vertx: io.vertx.scala.core.Vertx, options: io.vertx.scala.ext.shell.term.HttpTermOptions): io.vertx.scala.ext.shell.term.TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createHttpTermServer(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], options.asJava))
  }

  def createHttpTermServer(vertx: io.vertx.scala.core.Vertx, router: io.vertx.scala.ext.web.Router): io.vertx.scala.ext.shell.term.TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createHttpTermServer(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], router.asJava.asInstanceOf[io.vertx.ext.web.Router]))
  }

  def createHttpTermServer(vertx: io.vertx.scala.core.Vertx, router: io.vertx.scala.ext.web.Router, options: io.vertx.scala.ext.shell.term.HttpTermOptions): io.vertx.scala.ext.shell.term.TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createHttpTermServer(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], router.asJava.asInstanceOf[io.vertx.ext.web.Router], options.asJava))
  }

}
