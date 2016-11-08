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
import io.vertx.ext.shell.{ShellServer => JShellServer}
import io.vertx.ext.shell.{ShellServerOptions => JShellServerOptions}
import io.vertx.scala.ext.shell.ShellServerOptions
import io.vertx.ext.shell.term.{TermServer => JTermServer}
import io.vertx.scala.ext.shell.term.TermServer
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.ext.shell.{Shell => JShell}
import io.vertx.ext.shell.command.{CommandResolver => JCommandResolver}
import io.vertx.scala.ext.shell.command.CommandResolver
import io.vertx.ext.shell.term.{Term => JTerm}
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
class ShellServer(private val _asJava: JShellServer) {

  def asJava: JShellServer = _asJava

  /**
    * Register a command resolver for this server.
    * @param resolver the resolver
    * @return a reference to this, so the API can be used fluently
    */
  def registerCommandResolver(resolver: CommandResolver): ShellServer = {
    _asJava.registerCommandResolver(resolver.asJava.asInstanceOf[JCommandResolver])
    this
  }

  /**
    * Register a term server to this shell server, the term server lifecycle methods are managed by this shell server.
    * @param termServer the term server to add
    * @return a reference to this, so the API can be used fluently
    */
  def registerTermServer(termServer: TermServer): ShellServer = {
    _asJava.registerTermServer(termServer.asJava.asInstanceOf[JTermServer])
    this
  }

  /**
    * Create a new shell, the returned shell should be closed explicitely.
    * @param term the shell associated terminal
    * @return the created shell
    */
  def createShell(term: Term): Shell = {
    Shell.apply(_asJava.createShell(term.asJava.asInstanceOf[JTerm]))
  }

  /**
    * Create a new shell, the returned shell should be closed explicitely.
    * @return the created shell
    */
  def createShell(): Shell = {
    Shell.apply(_asJava.createShell())
  }

  /**
    * Start the shell service, this is an asynchronous start.
    */
  def listen(): ShellServer = {
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

  def apply(_asJava: JShellServer): ShellServer =
    new ShellServer(_asJava)

  def create(vertx: Vertx, options: ShellServerOptions): ShellServer = {
    ShellServer.apply(io.vertx.ext.shell.ShellServer.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  def create(vertx: Vertx): ShellServer = {
    ShellServer.apply(io.vertx.ext.shell.ShellServer.create(vertx.asJava.asInstanceOf[JVertx]))
  }

}
