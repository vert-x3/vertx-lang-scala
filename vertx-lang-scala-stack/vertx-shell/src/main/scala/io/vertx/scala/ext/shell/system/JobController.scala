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
import io.vertx.ext.shell.system.{JobController => JJobController}
import io.vertx.ext.shell.system.{Process => JProcess}
import io.vertx.ext.shell.system.{Job => JJob}
import scala.collection.JavaConverters._
import io.vertx.core.Handler

/**
  * The job controller.<p/>
  */
class JobController(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * @return the current foreground job
    */
  def foregroundJob(): Job = {
    Job(asJava.asInstanceOf[JJobController].foregroundJob())
  }

  /**
    * @return the active jobs
    */
  def jobs(): scala.collection.mutable.Set[Job] = {
    asJava.asInstanceOf[JJobController].jobs().asScala.map(x => Job(x))
  }

  /**
    * Returns an active job in this session by its .
    * @param id the job id
    * @return the job of ` null` when not found
    */
  def getJob(id: Int): Job = {
    Job(asJava.asInstanceOf[JJobController].getJob(id.asInstanceOf[java.lang.Integer]))
  }

  /**
    * Create a job wrapping a process.
    * @param process the process
    * @param line the line
    * @return the created job
    */
  def createJob(process: Process, line: String): Job = {
    Job(asJava.asInstanceOf[JJobController].createJob(process.asJava.asInstanceOf[JProcess], line.asInstanceOf[java.lang.String]))
  }

  /**
    * Close the controller and terminate all the underlying jobs, a closed controller does not accept anymore jobs.
    */
  def close(completionHandler: Handler[Unit]): Unit = {
    asJava.asInstanceOf[JJobController].close({x: Void => completionHandler.handle(x)})
  }

  /**
    * Close the shell session and terminate all the underlying jobs.
    */
  def close(): Unit = {
    asJava.asInstanceOf[JJobController].close()
  }

}

object JobController {
  def apply(asJava: JJobController) = new JobController(asJava)  
}
