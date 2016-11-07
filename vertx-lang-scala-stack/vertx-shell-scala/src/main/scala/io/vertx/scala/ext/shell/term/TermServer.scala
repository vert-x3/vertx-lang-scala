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
import io.vertx.ext.shell.term.{TermServer => JTermServer}
import io.vertx.ext.shell.term.{TelnetTermOptions => JTelnetTermOptions}
import io.vertx.scala.ext.shell.term.TelnetTermOptions
import io.vertx.ext.shell.term.{HttpTermOptions => JHttpTermOptions}
import io.vertx.scala.ext.shell.term.HttpTermOptions
import io.vertx.ext.shell.term.{SSHTermOptions => JSSHTermOptions}
import io.vertx.scala.ext.shell.term.SSHTermOptions
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.ext.web.{Router => JRouter}
import io.vertx.scala.ext.web.Router
import io.vertx.ext.shell.term.{Term => JTerm}
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.scala.ext.auth.AuthProvider

/**
  * A server for terminal based applications.
  */
class TermServer(private val _asJava: JTermServer) {

  def asJava: JTermServer = _asJava

  /**
    * Set the term handler that will receive incoming client connections. When a remote terminal connects
    * the `handler` will be called with the [[io.vertx.scala.ext.shell.term.Term]] which can be used to interact with the remote
    * terminal.
    * @param handler the term handler
    * @return this object
    */
  def termHandler(handler: Term => Unit): TermServer = {
    _asJava.termHandler(funcToMappedHandler(Term.apply)(handler))
    this
  }

  /**
    * Set an auth provider to use, any provider configured in options will override this provider. This should be used
    * when a custom auth provider should be used.
    * @param provider the auth to use
    * @return this object
    */
  def authProvider(provider: AuthProvider): TermServer = {
    _asJava.authProvider(provider.asJava.asInstanceOf[JAuthProvider])
    this
  }

  /**
    * Bind the term server, the [[io.vertx.scala.ext.shell.term.TermServer#termHandler]] must be set before.
    * @return this object
    */
  def listen(): TermServer = {
    _asJava.listen()
    this
  }

  /**
    * Bind the term server, the [[io.vertx.scala.ext.shell.term.TermServer#termHandler]] must be set before.
    * @return the listen future
    */
  def listenFuture(): concurrent.Future[TermServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JTermServer,TermServer]((x => if (x == null) null else TermServer.apply(x)))
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

  def apply(_asJava: JTermServer): TermServer =
    new TermServer(_asJava)

  def createSSHTermServer(vertx: Vertx): TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createSSHTermServer(vertx.asJava.asInstanceOf[JVertx]))
  }

  def createSSHTermServer(vertx: Vertx, options: SSHTermOptions): TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createSSHTermServer(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  def createTelnetTermServer(vertx: Vertx): TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createTelnetTermServer(vertx.asJava.asInstanceOf[JVertx]))
  }

  def createTelnetTermServer(vertx: Vertx, options: TelnetTermOptions): TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createTelnetTermServer(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  def createHttpTermServer(vertx: Vertx): TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createHttpTermServer(vertx.asJava.asInstanceOf[JVertx]))
  }

  def createHttpTermServer(vertx: Vertx, options: HttpTermOptions): TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createHttpTermServer(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  def createHttpTermServer(vertx: Vertx, router: Router): TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createHttpTermServer(vertx.asJava.asInstanceOf[JVertx], router.asJava.asInstanceOf[JRouter]))
  }

  def createHttpTermServer(vertx: Vertx, router: Router, options: HttpTermOptions): TermServer = {
    TermServer.apply(io.vertx.ext.shell.term.TermServer.createHttpTermServer(vertx.asJava.asInstanceOf[JVertx], router.asJava.asInstanceOf[JRouter], options.asJava))
  }

}
