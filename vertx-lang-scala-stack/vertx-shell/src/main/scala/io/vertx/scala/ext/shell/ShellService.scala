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
import io.vertx.ext.shell.{ShellService => JShellService}
import io.vertx.ext.shell.{ShellServer => JShellServer}
import io.vertx.ext.shell.{ShellServiceOptions => JShellServiceOptions}
import io.vertx.scala.ext.shell.ShellServiceOptions
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx

/**
  * The shell service, provides a remotely accessible shell available via Telnet or SSH according to the
  * <a href="../../../../../../../cheatsheet/ShellServiceOptions.html">ShellServiceOptions</a> configuration.<p/>
  *
  * The shell service will expose commands using [[io.vertx.scala.ext.shell.command.CommandResolver]] on the classpath and
  * the shared command registry for the Vert.x instance.
  */
class ShellService(private val _asJava: JShellService) {

  def asJava: JShellService = _asJava

  /**
    * Start the shell service, this is an asynchronous start.
    */
  def start(): Unit = {
    _asJava.start()
  }

  /**
    * Start the shell service, this is an asynchronous start.
    * @return future for getting notified when service is started
    */
  def startFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.start(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * @return the shell server
    */
  def server(): ShellServer = {
    ShellServer.apply(_asJava.server())
  }

  /**
    * Stop the shell service, this is an asynchronous stop.
    */
  def stop(): Unit = {
    _asJava.stop()
  }

  /**
    * Stop the shell service, this is an asynchronous start.
    * @return future for getting notified when service is stopped
    */
  def stopFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.stop(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object ShellService {

  def apply(_asJava: JShellService): ShellService =
    new ShellService(_asJava)

  def create(vertx: Vertx): ShellService = {
    ShellService.apply(io.vertx.ext.shell.ShellService.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  def create(vertx: Vertx, options: ShellServiceOptions): ShellService = {
    ShellService.apply(io.vertx.ext.shell.ShellService.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

}
