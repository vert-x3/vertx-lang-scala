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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.shell.system.ExecStatus
import io.vertx.ext.shell.term.{Tty => JTty}
import io.vertx.scala.ext.shell.session.Session
import io.vertx.scala.ext.shell.term.Tty
import io.vertx.ext.shell.system.{Process => JProcess}
import io.vertx.ext.shell.system.{Job => JJob}
import io.vertx.core.Handler
import io.vertx.ext.shell.session.{Session => JSession}

/**
  * A job executed in a [[io.vertx.scala.ext.shell.system.JobController]], grouping one or several process.<p/>
  *
  * The job life cycle can be controlled with the [[io.vertx.scala.ext.shell.system.Job#run]], [[io.vertx.scala.ext.shell.system.Job#resume]] and [[io.vertx.scala.ext.shell.system.Job#suspend]] and [[io.vertx.scala.ext.shell.system.Job#interrupt]]
  * methods.
  */
class Job(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0: Process = _

  /**
    * @return the first process in the job
    */
  def process(): Process = {
    if(cached_0 == null) {
      val tmp = asJava.asInstanceOf[JJob].process()
      cached_0 = Process(tmp)
    }
    cached_0
  }

  /**
    * Set a tty on the job.
    * @param tty the tty to use
    * @return this object
    */
  def setTty(tty: Tty): Job = {
    asJava.asInstanceOf[JJob].setTty(tty.asJava.asInstanceOf[JTty])
    this
  }

  /**
    * Set a session on the job.
    * @param session the session to use
    * @return this object
    */
  def setSession(session: Session): Job = {
    asJava.asInstanceOf[JJob].setSession(session.asJava.asInstanceOf[JSession])
    this
  }

  /**
    * Set an handler called when the job terminates.
    * @param handler the terminate handler
    * @return this object
    */
  def statusUpdateHandler(handler: Handler[io.vertx.ext.shell.system.ExecStatus]): Job = {
    asJava.asInstanceOf[JJob].statusUpdateHandler({x: ExecStatus => handler.handle(x)})
    this
  }

  /**
    * Run the job, before running the job a  must be set.
    * @return this object
    */
  def run(): Job = {
    asJava.asInstanceOf[JJob].run()
    this
  }

  /**
    * Send the job to background.
    * @return this object
    */
  def toBackground(): Job = {
    asJava.asInstanceOf[JJob].toBackground()
    this
  }

  /**
    * Send the job to foreground.
    * @return this object
    */
  def toForeground(): Job = {
    asJava.asInstanceOf[JJob].toForeground()
    this
  }

  /**
    * Resume the job.
    * @param foreground true when the job is resumed in foreground
    */
  def resume(foreground: Boolean): Job = {
    asJava.asInstanceOf[JJob].resume(foreground.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Resume the job.
    * @return this object
    */
  def suspend(): Job = {
    asJava.asInstanceOf[JJob].suspend()
    this
  }

  /**
    * Resume the job to foreground.
    */
  def resume(): Job = {
    Job(asJava.asInstanceOf[JJob].resume())
  }

  /**
    * @return the job id
    */
  def id(): Int = {
    asJava.asInstanceOf[JJob].id().asInstanceOf[Int]
  }

  /**
    * @return the job exec status
    */
  def status(): io.vertx.ext.shell.system.ExecStatus = {
    asJava.asInstanceOf[JJob].status()
  }

  /**
    * @return when the job was last stopped
    */
  def lastStopped(): Long = {
    asJava.asInstanceOf[JJob].lastStopped().asInstanceOf[Long]
  }

  /**
    * @return the execution line of the job, i.e the shell command line that launched this job
    */
  def line(): String = {
    asJava.asInstanceOf[JJob].line().asInstanceOf[String]
  }

  /**
    * Attempt to interrupt the job.
    * @return true if the job is actually interrupted
    */
  def interrupt(): Boolean = {
    asJava.asInstanceOf[JJob].interrupt().asInstanceOf[Boolean]
  }

  /**
    * Terminate the job.
    */
  def terminate(): Unit = {
    asJava.asInstanceOf[JJob].terminate()
  }

}

object Job {
  def apply(asJava: JJob) = new Job(asJava)  
}
