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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.shell.{ShellServiceOptions => JShellServiceOptions}
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.shell.{ShellServer => JShellServer}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.shell.{ShellService => JShellService}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * The shell service, provides a remotely accessible shell available via Telnet or SSH according to the
  * <a href="../../../../../../../cheatsheet/ShellServiceOptions.html">ShellServiceOptions</a> configuration.<p/>
  *
  * The shell service will expose commands using [[io.vertx.scala.ext.shell.command.CommandResolver]] on the classpath and
  * the shared command registry for the Vert.x instance.
  */
class ShellService(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Start the shell service, this is an asynchronous start.
    */
  def start(): Unit = {
    asJava.asInstanceOf[JShellService].start()
  }

  /**
    * Stop the shell service, this is an asynchronous stop.
    */
  def stop(): Unit = {
    asJava.asInstanceOf[JShellService].stop()
  }

  /**
    * Start the shell service, this is an asynchronous start.
    */
  def start(startHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JShellService].start({x: AsyncResult[Void] => startHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  /**
    * @return the shell server
    */
  def server(): ShellServer = {
    ShellServer(asJava.asInstanceOf[JShellService].server())
  }

  /**
    * Stop the shell service, this is an asynchronous start.
    */
  def stop(stopHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JShellService].stop({x: AsyncResult[Void] => stopHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

 /**
   * Start the shell service, this is an asynchronous start.
   * @return future for getting notified when service is started
   */
  def startFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JShellService].start(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Stop the shell service, this is an asynchronous start.
   * @return future for getting notified when service is stopped
   */
  def stopFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JShellService].stop(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object ShellService {
  def apply(asJava: JShellService) = new ShellService(asJava)  
  /**
    * Like [[io.vertx.scala.ext.shell.ShellService#create]], with default options.
    */
  def create(vertx: Vertx): ShellService = {
    ShellService(JShellService.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Create a new shell service.
    * @param vertx the Vert.x instance
    * @param options the service config optionssee <a href="../../../../../../../cheatsheet/ShellServiceOptions.html">ShellServiceOptions</a>
    * @return the shell service
    */
  def create(vertx: Vertx, options: ShellServiceOptions): ShellService = {
    ShellService(JShellService.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

}
