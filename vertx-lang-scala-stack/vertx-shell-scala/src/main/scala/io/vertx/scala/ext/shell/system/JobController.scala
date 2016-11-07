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
import io.vertx.ext.shell.system.{JobController => JJobController}
import io.vertx.ext.shell.system.{Job => JJob}
import io.vertx.ext.shell.system.{Process => JProcess}

/**
  * The job controller.<p/>
  */
class JobController(private val _asJava: JJobController) {

  def asJava: JJobController = _asJava

  /**
    * @return the current foreground job
    */
  def foregroundJob(): Job = {
    Job.apply(_asJava.foregroundJob())
  }

  /**
    * @return the active jobs
    */
  def jobs(): Set[Job] = {
    _asJava.jobs().asScala.map(Job.apply).toSet
  }

  /**
    * Returns an active job in this session by its .
    * @param id the job id
    * @return the job of ` null` when not found
    */
  def getJob(id: Int): Job = {
    Job.apply(_asJava.getJob(id))
  }

  /**
    * Create a job wrapping a process.
    * @param process the process
    * @param line the line
    * @return the created job
    */
  def createJob(process: Process, line: String): Job = {
    Job.apply(_asJava.createJob(process.asJava.asInstanceOf[JProcess], line))
  }

  /**
    * Close the controller and terminate all the underlying jobs, a closed controller does not accept anymore jobs.
    */
  def close(completionHandler: () => Unit): Unit = {
    _asJava.close(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => completionHandler()))
  }

  /**
    * Close the shell session and terminate all the underlying jobs.
    */
  def close(): Unit = {
    _asJava.close()
  }

}

object JobController {

  def apply(_asJava: JJobController): JobController =
    new JobController(_asJava)

}
