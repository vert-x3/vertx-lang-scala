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

package io.vertx.scala.ext.shell

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.shell.ShellServerOptions
import io.vertx.scala.ext.shell.term.TermServer
import io.vertx.scala.core.Vertx
import io.vertx.core.Handler
import io.vertx.scala.ext.shell.command.CommandResolver
import io.vertx.scala.ext.shell.term.Term

/**
  * The shell server.<p/>
  *
  * A shell server is associated with a collection of : the [[io.vertx.scala.ext.shell.ShellServer#registerTermServer]]
  * method registers a term server. Term servers life cycle are managed by this server.<p/>
  *
  * When a  receives an incoming connection, a  instance is created and
  * associated with this connection.<p/>
  *
  * The [[io.vertx.scala.ext.shell.ShellServer#createShell]] method can be used to create  instance for testing purposes.
  */
class ShellServer(private val _asJava: io.vertx.ext.shell.ShellServer) {

  def asJava: io.vertx.ext.shell.ShellServer = _asJava

  /**
    * Register a command resolver for this server.
    * @param resolver the resolver
    * @return a reference to this, so the API can be used fluently
    */
  def registerCommandResolver(resolver: io.vertx.scala.ext.shell.command.CommandResolver): io.vertx.scala.ext.shell.ShellServer = {
    _asJava.registerCommandResolver(resolver.asJava.asInstanceOf[io.vertx.ext.shell.command.CommandResolver])
    this
  }

  /**
    * Register a term server to this shell server, the term server lifecycle methods are managed by this shell server.
    * @param termServer the term server to add
    * @return a reference to this, so the API can be used fluently
    */
  def registerTermServer(termServer: io.vertx.scala.ext.shell.term.TermServer): io.vertx.scala.ext.shell.ShellServer = {
    _asJava.registerTermServer(termServer.asJava.asInstanceOf[io.vertx.ext.shell.term.TermServer])
    this
  }

  /**
    * Create a new shell, the returned shell should be closed explicitely.
    * @param term the shell associated terminal
    * @return the created shell
    */
  def createShell(term: io.vertx.scala.ext.shell.term.Term): io.vertx.scala.ext.shell.Shell = {
    Shell.apply(_asJava.createShell(term.asJava.asInstanceOf[io.vertx.ext.shell.term.Term]))
  }

  /**
    * Create a new shell, the returned shell should be closed explicitely.
    * @return the created shell
    */
  def createShell(): io.vertx.scala.ext.shell.Shell = {
    Shell.apply(_asJava.createShell())
  }

  /**
    * Start the shell service, this is an asynchronous start.
    */
  def listen(): io.vertx.scala.ext.shell.ShellServer = {
    _asJava.listen()
    this
  }

  /**
    * Start the shell service, this is an asynchronous start.
    * @return future for getting notified when service is started
    */
  def listenFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Close the shell server, this is an asynchronous close.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Close the shell server, this is an asynchronous close.
    * @return future for getting notified when service is stopped
    */
  def closeFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object ShellServer {

  def apply(_asJava: io.vertx.ext.shell.ShellServer): io.vertx.scala.ext.shell.ShellServer =
    new io.vertx.scala.ext.shell.ShellServer(_asJava)

  def create(vertx: io.vertx.scala.core.Vertx, options: io.vertx.scala.ext.shell.ShellServerOptions): io.vertx.scala.ext.shell.ShellServer = {
    ShellServer.apply(io.vertx.ext.shell.ShellServer.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], options.asJava))
  }

  def create(vertx: io.vertx.scala.core.Vertx): io.vertx.scala.ext.shell.ShellServer = {
    ShellServer.apply(io.vertx.ext.shell.ShellServer.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx]))
  }

}
