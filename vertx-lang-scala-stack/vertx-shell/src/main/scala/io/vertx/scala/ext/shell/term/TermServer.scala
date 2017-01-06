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
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.shell.term.{TelnetTermOptions => JTelnetTermOptions}
import io.vertx.ext.shell.term.{TermServer => JTermServer}
import io.vertx.ext.web.{Router => JRouter}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.shell.term.{SSHTermOptions => JSSHTermOptions}
import io.vertx.ext.shell.term.{HttpTermOptions => JHttpTermOptions}
import io.vertx.core.AsyncResult
import io.vertx.scala.ext.web.Router
import io.vertx.core.Handler
import io.vertx.ext.shell.term.{Term => JTerm}

/**
  * A server for terminal based applications.
  */
class TermServer(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Set the term handler that will receive incoming client connections. When a remote terminal connects
    * the `handler` will be called with the [[io.vertx.scala.ext.shell.term.Term]] which can be used to interact with the remote
    * terminal.
    * @param handler the term handler
    * @return this object
    */
//io.vertx.core.Handler<io.vertx.ext.shell.term.Term>
  def termHandler(handler: Handler[Term]):TermServer = {
    asJava.asInstanceOf[JTermServer].termHandler({x: JTerm => handler.handle(Term(x))})
    this
  }

  /**
    * Set an auth provider to use, any provider configured in options will override this provider. This should be used
    * when a custom auth provider should be used.
    * @param provider the auth to use
    * @return this object
    */
//io.vertx.ext.auth.AuthProvider
  def authProvider(provider: AuthProvider):TermServer = {
    asJava.asInstanceOf[JTermServer].authProvider(provider.asJava.asInstanceOf[JAuthProvider])
    this
  }

  /**
    * Bind the term server, the [[io.vertx.scala.ext.shell.term.TermServer#termHandler]] must be set before.
    * @return this object
    */
  def listen():TermServer = {
    asJava.asInstanceOf[JTermServer].listen()
    this
  }

  /**
    * Bind the term server, the [[io.vertx.scala.ext.shell.term.TermServer#termHandler]] must be set before.
    * @return this object
    */
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.ext.shell.term.TermServer>>
  def listen(listenHandler: Handler[AsyncResult[TermServer]]):TermServer = {
    asJava.asInstanceOf[JTermServer].listen({x: AsyncResult[JTermServer] => listenHandler.handle(AsyncResultWrapper[JTermServer,TermServer](x, a => TermServer(a)))})
    this
  }

  /**
    * The actual port the server is listening on. This is useful if you bound the server specifying 0 as port number
    * signifying an ephemeral port
    * @return the actual port the server is listening on.
    */
  def actualPort():Int = {
    asJava.asInstanceOf[JTermServer].actualPort().asInstanceOf[Int]
  }

  /**
    * Close the server. This will close any currently open connections. The close may not complete until after this
    * method has returned.
    */
  def close():Unit = {
    asJava.asInstanceOf[JTermServer].close()
  }

  /**
    * Like [[io.vertx.scala.ext.shell.term.TermServer#close]] but supplying a handler that will be notified when close is complete.
    */
  def close(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JTermServer].close({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

 /**
   * Bind the term server, the [[io.vertx.scala.ext.shell.term.TermServer#termHandler]] must be set before.
   * @return the listen future
   */
    def listenFuture():scala.concurrent.Future[TermServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JTermServer, TermServer](x => TermServer(x))
    asJava.asInstanceOf[JTermServer].listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.ext.shell.term.TermServer#close]] but supplying a handler that will be notified when close is complete.
   * @return the future to be notified when the term server is closed
   */
    def closeFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JTermServer].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object TermServer{
  def apply(asJava: JTermServer) = new TermServer(asJava)  
  /**
    * Create a term server for the SSH protocol.
    * @param vertx the vertx instance
    * @return the term server
    */
  def createSSHTermServer(vertx: Vertx):TermServer = {
    TermServer(JTermServer.createSSHTermServer(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Create a term server for the SSH protocol.
    * @param vertx the vertx instance
    * @param options the ssh optionssee <a href="../../../../../../../../cheatsheet/SSHTermOptions.html">SSHTermOptions</a>
    * @return the term server
    */
  def createSSHTermServer(vertx: Vertx,options: SSHTermOptions):TermServer = {
    TermServer(JTermServer.createSSHTermServer(vertx.asJava.asInstanceOf[JVertx],options.asJava))
  }

  /**
    * Create a term server for the Telnet protocol.
    * @param vertx the vertx instance
    * @return the term server
    */
  def createTelnetTermServer(vertx: Vertx):TermServer = {
    TermServer(JTermServer.createTelnetTermServer(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Create a term server for the Telnet protocol.
    * @param vertx the vertx instance
    * @param options the term optionssee <a href="../../../../../../../../cheatsheet/TelnetTermOptions.html">TelnetTermOptions</a>
    * @return the term server
    */
  def createTelnetTermServer(vertx: Vertx,options: TelnetTermOptions):TermServer = {
    TermServer(JTermServer.createTelnetTermServer(vertx.asJava.asInstanceOf[JVertx],options.asJava))
  }

  /**
    * Create a term server for the HTTP protocol.
    * @param vertx the vertx instance
    * @return the term server
    */
  def createHttpTermServer(vertx: Vertx):TermServer = {
    TermServer(JTermServer.createHttpTermServer(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Create a term server for the HTTP protocol.
    * @param vertx the vertx instance
    * @param options the term optionssee <a href="../../../../../../../../cheatsheet/HttpTermOptions.html">HttpTermOptions</a>
    * @return the term server
    */
  def createHttpTermServer(vertx: Vertx,options: HttpTermOptions):TermServer = {
    TermServer(JTermServer.createHttpTermServer(vertx.asJava.asInstanceOf[JVertx],options.asJava))
  }

  /**
    * Create a term server for the HTTP protocol, using an existing router.
    * @param vertx the vertx instance
    * @param router the router
    * @return the term server
    */
  def createHttpTermServer(vertx: Vertx,router: Router):TermServer = {
    TermServer(JTermServer.createHttpTermServer(vertx.asJava.asInstanceOf[JVertx],router.asJava.asInstanceOf[JRouter]))
  }

  /**
    * Create a term server for the HTTP protocol, using an existing router.
    * @param vertx the vertx instance
    * @param router the router
    * @param options the term optionssee <a href="../../../../../../../../cheatsheet/HttpTermOptions.html">HttpTermOptions</a>
    * @return the term server
    */
  def createHttpTermServer(vertx: Vertx,router: Router,options: HttpTermOptions):TermServer = {
    TermServer(JTermServer.createHttpTermServer(vertx.asJava.asInstanceOf[JVertx],router.asJava.asInstanceOf[JRouter],options.asJava))
  }

}
