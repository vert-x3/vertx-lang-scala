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

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.shell.term.{Tty => JTty}
import io.vertx.core.Handler

package object shell{






  /**
    * A registry that contains the commands known by a shell.<p/>
    *
    * It is a mutable command resolver.
    */

  implicit class CommandRegistryScala(val asJava: io.vertx.ext.shell.command.CommandRegistry) extends AnyVal {

    /**
     * Like [[registerCommand]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def registerCommandFuture(command: io.vertx.ext.shell.command.Command): scala.concurrent.Future[io.vertx.ext.shell.command.Command] = {
      val promise = Promise[io.vertx.ext.shell.command.Command]()
      asJava.registerCommand(command, {a:AsyncResult[io.vertx.ext.shell.command.Command] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[registerCommands]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def registerCommandsFuture(commands: java.util.List[io.vertx.ext.shell.command.Command]): scala.concurrent.Future[java.util.List[io.vertx.ext.shell.command.Command]] = {
      val promise = Promise[java.util.List[io.vertx.ext.shell.command.Command]]()
      asJava.registerCommands(commands, {a:AsyncResult[java.util.List[io.vertx.ext.shell.command.Command]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unregisterCommand]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unregisterCommandFuture(commandName: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.unregisterCommand(commandName, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }




  type HttpTermOptions = io.vertx.ext.shell.term.HttpTermOptions

  object HttpTermOptions {
    def apply() = new HttpTermOptions()
    def apply(json: JsonObject) = new HttpTermOptions(json)
  }







  type SSHTermOptions = io.vertx.ext.shell.term.SSHTermOptions

  object SSHTermOptions {
    def apply() = new SSHTermOptions()
    def apply(json: JsonObject) = new SSHTermOptions(json)
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
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.listen({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[start]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def startFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.start({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[stop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def stopFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.stop({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(): scala.concurrent.Future[io.vertx.ext.shell.term.TermServer] = {
      val promise = Promise[io.vertx.ext.shell.term.TermServer]()
      asJava.listen({a:AsyncResult[io.vertx.ext.shell.term.TermServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


}
