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


package io.vertx.scala.ext

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.shell.term.{Tty => JTty}
import io.vertx.core.Handler
package object shell{


  object CliToken {
    /**
     * Like createText from [[io.vertx.ext.shell.cli.CliToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createText(text: java.lang.String) = {
      io.vertx.ext.shell.cli.CliToken.createText(text)
  }

    /**
     * Like createBlank from [[io.vertx.ext.shell.cli.CliToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createBlank(blank: java.lang.String) = {
      io.vertx.ext.shell.cli.CliToken.createBlank(blank)
  }

    /**
     * Like tokenize from [[io.vertx.ext.shell.cli.CliToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def tokenize(s: java.lang.String) = {
      io.vertx.ext.shell.cli.CliToken.tokenize(s)
  }
  }




  object CommandBuilder {
    /**
     * Like command from [[io.vertx.ext.shell.command.CommandBuilder]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def command(name: java.lang.String) = {
      io.vertx.ext.shell.command.CommandBuilder.command(name)
  }

    /**
     * Like command from [[io.vertx.ext.shell.command.CommandBuilder]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def command(cli: io.vertx.core.cli.CLI) = {
      io.vertx.ext.shell.command.CommandBuilder.command(cli)
  }
  }





  /**
    * A registry that contains the commands known by a shell.<p/>
    *
    * It is a mutable command resolver.
    */

  implicit class CommandRegistryScala(val asJava: io.vertx.ext.shell.command.CommandRegistry) extends AnyVal {


    /**
     * Like registerCommand from [[io.vertx.ext.shell.command.CommandRegistry]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def registerCommandFuture(command: io.vertx.ext.shell.command.Command) : scala.concurrent.Future[io.vertx.ext.shell.command.Command] = {
      val promise = concurrent.Promise[io.vertx.ext.shell.command.Command]()
      asJava.registerCommand(command, new Handler[AsyncResult[io.vertx.ext.shell.command.Command]] { override def handle(event: AsyncResult[io.vertx.ext.shell.command.Command]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like registerCommands from [[io.vertx.ext.shell.command.CommandRegistry]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def registerCommandsFuture(commands: scala.collection.mutable.Buffer[io.vertx.ext.shell.command.Command]) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.ext.shell.command.Command]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.ext.shell.command.Command]]()
      asJava.registerCommands(commands.asJava, new Handler[AsyncResult[java.util.List[io.vertx.ext.shell.command.Command]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.ext.shell.command.Command]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like unregisterCommand from [[io.vertx.ext.shell.command.CommandRegistry]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def unregisterCommandFuture(commandName: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.unregisterCommand(commandName, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object CommandResolver {
    /**
     * Like baseCommands from [[io.vertx.ext.shell.command.CommandResolver]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def baseCommands(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.shell.command.CommandResolver.baseCommands(vertx)
  }
  }




  type HttpTermOptions = io.vertx.ext.shell.term.HttpTermOptions
  object HttpTermOptions {
    def apply() = new HttpTermOptions()
    def apply(json: JsonObject) = new HttpTermOptions(json)
  }









  object Pty {
    /**
     * Like create from [[io.vertx.ext.shell.term.Pty]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create() = {
      io.vertx.ext.shell.term.Pty.create()
  }

    /**
     * Like create from [[io.vertx.ext.shell.term.Pty]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(terminalType: java.lang.String) = {
      io.vertx.ext.shell.term.Pty.create(terminalType)
  }
  }


  type SSHTermOptions = io.vertx.ext.shell.term.SSHTermOptions
  object SSHTermOptions {
    def apply() = new SSHTermOptions()
    def apply(json: JsonObject) = new SSHTermOptions(json)
  }



  object Session {
    /**
     * Like create from [[io.vertx.ext.shell.session.Session]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create() = {
      io.vertx.ext.shell.session.Session.create()
  }
  }





  /**
    * The shell server.<p/>
    *
    * A shell server is associated with a collection of : the [[io.vertx.ext.shell.ShellServer#registerTermServer]]
    * method registers a term server. Term servers life cycle are managed by this server.<p/>
    *
    * When a  receives an incoming connection, a  instance is created and
    * associated with this connection.<p/>
    *
    * The [[io.vertx.ext.shell.ShellServer#createShell]] method can be used to create  instance for testing purposes.
    */

  implicit class ShellServerScala(val asJava: io.vertx.ext.shell.ShellServer) extends AnyVal {


    /**
     * Like listen from [[io.vertx.ext.shell.ShellServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.listen(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.ext.shell.ShellServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type ShellServerOptions = io.vertx.ext.shell.ShellServerOptions
  object ShellServerOptions {
    def apply() = new ShellServerOptions()
    def apply(json: JsonObject) = new ShellServerOptions(json)
  }




  /**
    * The shell service, provides a remotely accessible shell available via Telnet or SSH according to the
    * <a href="../../../../../../../cheatsheet/ShellServiceOptions.html">ShellServiceOptions</a> configuration.<p/>
    *
    * The shell service will expose commands using [[io.vertx.ext.shell.command.CommandResolver]] on the classpath and
    * the shared command registry for the Vert.x instance.
    */

  implicit class ShellServiceScala(val asJava: io.vertx.ext.shell.ShellService) extends AnyVal {


    /**
     * Like start from [[io.vertx.ext.shell.ShellService]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def startFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.start(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like stop from [[io.vertx.ext.shell.ShellService]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def stopFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.stop(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type ShellServiceOptions = io.vertx.ext.shell.ShellServiceOptions
  object ShellServiceOptions {
    def apply() = new ShellServiceOptions()
    def apply(json: JsonObject) = new ShellServiceOptions(json)
  }







  type TelnetTermOptions = io.vertx.ext.shell.term.TelnetTermOptions
  object TelnetTermOptions {
    def apply() = new TelnetTermOptions()
    def apply(json: JsonObject) = new TelnetTermOptions(json)
  }






  /**
    * A server for terminal based applications.
    */

  implicit class TermServerScala(val asJava: io.vertx.ext.shell.term.TermServer) extends AnyVal {


    /**
     * Like listen from [[io.vertx.ext.shell.term.TermServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listenFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.listen(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.ext.shell.term.TermServer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }





}
