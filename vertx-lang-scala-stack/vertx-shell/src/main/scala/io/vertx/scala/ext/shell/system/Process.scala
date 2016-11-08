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

package io.vertx.scala.ext.shell.system

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.shell.system.{Process => JProcess}
import io.vertx.ext.shell.system.ExecStatus
import io.vertx.ext.shell.term.{Tty => JTty}
import io.vertx.scala.ext.shell.term.Tty
import io.vertx.ext.shell.session.{Session => JSession}
import io.vertx.scala.ext.shell.session.Session

/**
  * A process managed by the shell.
  */
class Process(private val _asJava: JProcess) {

  def asJava: JProcess = _asJava

  /**
    * @return the current process status
    */
  def status(): io.vertx.ext.shell.system.ExecStatus = {
    _asJava.status()
  }

  /**
    * @return the process exit code when the status is [[ExecStatus#TERMINATED]] otherwise `null`
    */
  def exitCode(): Int = {
    _asJava.exitCode()
  }

  /**
    * Set the process tty.
    * @param tty the process tty
    * @return this object
    */
  def setTty(tty: Tty): Process = {
    _asJava.setTty(tty.asJava.asInstanceOf[JTty])
    this
  }

  /**
    * @return the process tty
    */
  def getTty(): Tty = {
    if (cached_0 == null) {
      cached_0=    Tty.apply(_asJava.getTty())
    }
    cached_0
  }

  /**
    * Set the process session
    * @param session the process session
    * @return this object
    */
  def setSession(session: Session): Process = {
    _asJava.setSession(session.asJava.asInstanceOf[JSession])
    this
  }

  /**
    * @return the process session
    */
  def getSession(): Session = {
    if (cached_1 == null) {
      cached_1=    Session.apply(_asJava.getSession())
    }
    cached_1
  }

  /**
    * Set an handler for being notified when the process terminates.
    * @param handler the handler called when the process terminates.
    * @return this object
    */
  def terminatedHandler(handler: Int => Unit): Process = {
    _asJava.terminatedHandler(funcToMappedHandler[java.lang.Integer, Int](x => x)(handler))
    this
  }

  /**
    * Run the process.
    */
  def run(): Unit = {
    _asJava.run()
  }

  /**
    * Run the process.
    */
  def run(foreground: Boolean): Unit = {
    _asJava.run(foreground)
  }

  /**
    * Run the process.
    * @param completionHandler handler called after process callback
    */
  def run(completionHandler: () => Unit): Unit = {
    _asJava.run(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => completionHandler()))
  }

  /**
    * Run the process.
    * @param completionHandler handler called after process callback
    */
  def run(foregraound: Boolean, completionHandler: () => Unit): Unit = {
    _asJava.run(foregraound, funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => completionHandler()))
  }

  /**
    * Attempt to interrupt the process.
    * @return true if the process caught the signal
    */
  def interrupt(): Boolean = {
    _asJava.interrupt()
  }

  /**
    * Attempt to interrupt the process.
    * @param completionHandler handler called after interrupt callback
    * @return true if the process caught the signal
    */
  def interrupt(completionHandler: () => Unit): Boolean = {
    _asJava.interrupt(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => completionHandler()))
  }

  /**
    * Suspend the process.
    */
  def resume(): Unit = {
    _asJava.resume()
  }

  /**
    * Suspend the process.
    */
  def resume(foreground: Boolean): Unit = {
    _asJava.resume(foreground)
  }

  /**
    * Suspend the process.
    * @param completionHandler handler called after resume callback
    */
  def resume(completionHandler: () => Unit): Unit = {
    _asJava.resume(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => completionHandler()))
  }

  /**
    * Suspend the process.
    * @param completionHandler handler called after resume callback
    */
  def resume(foreground: Boolean, completionHandler: () => Unit): Unit = {
    _asJava.resume(foreground, funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => completionHandler()))
  }

  /**
    * Resume the process.
    */
  def suspend(): Unit = {
    _asJava.suspend()
  }

  /**
    * Resume the process.
    * @param completionHandler handler called after suspend callback
    */
  def suspend(completionHandler: () => Unit): Unit = {
    _asJava.suspend(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => completionHandler()))
  }

  /**
    * Terminate the process.
    */
  def terminate(): Unit = {
    _asJava.terminate()
  }

  /**
    * Terminate the process.
    * @param completionHandler handler called after end callback
    */
  def terminate(completionHandler: () => Unit): Unit = {
    _asJava.terminate(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => completionHandler()))
  }

  /**
    * Set the process in background.
    */
  def toBackground(): Unit = {
    _asJava.toBackground()
  }

  /**
    * Set the process in background.
    * @param completionHandler handler called after background callback
    */
  def toBackground(completionHandler: () => Unit): Unit = {
    _asJava.toBackground(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => completionHandler()))
  }

  /**
    * Set the process in foreground.
    */
  def toForeground(): Unit = {
    _asJava.toForeground()
  }

  /**
    * Set the process in foreground.
    * @param completionHandler handler called after foreground callback
    */
  def toForeground(completionHandler: () => Unit): Unit = {
    _asJava.toForeground(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => completionHandler()))
  }

  private var cached_0: Tty = _
  private var cached_1: Session = _
}

object Process {

  def apply(_asJava: JProcess): Process =
    new Process(_asJava)

}
