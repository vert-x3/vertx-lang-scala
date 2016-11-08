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
import io.vertx.ext.shell.system.{Job => JJob}
import io.vertx.ext.shell.system.ExecStatus
import io.vertx.ext.shell.system.{Process => JProcess}
import io.vertx.ext.shell.term.{Tty => JTty}
import io.vertx.scala.ext.shell.term.Tty
import io.vertx.ext.shell.session.{Session => JSession}
import io.vertx.scala.ext.shell.session.Session

/**
  * A job executed in a [[io.vertx.scala.ext.shell.system.JobController]], grouping one or several process.<p/>
  *
  * The job life cycle can be controlled with the [[io.vertx.scala.ext.shell.system.Job#run]], [[io.vertx.scala.ext.shell.system.Job#resume]] and [[io.vertx.scala.ext.shell.system.Job#suspend]] and [[io.vertx.scala.ext.shell.system.Job#interrupt]]
  * methods.
  */
class Job(private val _asJava: JJob) {

  def asJava: JJob = _asJava

  /**
    * @return the job id
    */
  def id(): Int = {
    _asJava.id()
  }

  /**
    * @return the job exec status
    */
  def status(): io.vertx.ext.shell.system.ExecStatus = {
    _asJava.status()
  }

  /**
    * @return when the job was last stopped
    */
  def lastStopped(): Long = {
    _asJava.lastStopped()
  }

  /**
    * @return the execution line of the job, i.e the shell command line that launched this job
    */
  def line(): String = {
    _asJava.line()
  }

  /**
    * Set a tty on the job.
    * @param tty the tty to use
    * @return this object
    */
  def setTty(tty: Tty): Job = {
    _asJava.setTty(tty.asJava.asInstanceOf[JTty])
    this
  }

  /**
    * Set a session on the job.
    * @param session the session to use
    * @return this object
    */
  def setSession(session: Session): Job = {
    _asJava.setSession(session.asJava.asInstanceOf[JSession])
    this
  }

  /**
    * Set an handler called when the job terminates.
    * @param handler the terminate handler
    * @return this object
    */
  def statusUpdateHandler(handler: io.vertx.ext.shell.system.ExecStatus => Unit): Job = {
    _asJava.statusUpdateHandler(funcToHandler(handler))
    this
  }

  /**
    * Run the job, before running the job a  must be set.
    * @return this object
    */
  def run(): Job = {
    _asJava.run()
    this
  }

  /**
    * Attempt to interrupt the job.
    * @return true if the job is actually interrupted
    */
  def interrupt(): Boolean = {
    _asJava.interrupt()
  }

  /**
    * Resume the job to foreground.
    */
  def resume(): Job = {
    Job.apply(_asJava.resume())
  }

  /**
    * Send the job to background.
    * @return this object
    */
  def toBackground(): Job = {
    _asJava.toBackground()
    this
  }

  /**
    * Send the job to foreground.
    * @return this object
    */
  def toForeground(): Job = {
    _asJava.toForeground()
    this
  }

  /**
    * Resume the job.
    * @param foreground true when the job is resumed in foreground
    */
  def resume(foreground: Boolean): Job = {
    _asJava.resume(foreground)
    this
  }

  /**
    * Resume the job.
    * @return this object
    */
  def suspend(): Job = {
    _asJava.suspend()
    this
  }

  /**
    * Terminate the job.
    */
  def terminate(): Unit = {
    _asJava.terminate()
  }

  /**
    * @return the first process in the job
    */
  def process(): Process = {
    if (cached_0 == null) {
      cached_0=    Process.apply(_asJava.process())
    }
    cached_0
  }

  private var cached_0: Process = _
}

object Job {

  def apply(_asJava: JJob): Job =
    new Job(_asJava)

}
