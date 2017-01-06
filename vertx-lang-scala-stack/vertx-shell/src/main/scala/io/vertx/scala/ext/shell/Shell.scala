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
import io.vertx.scala.ext.shell.session.Session
import io.vertx.scala.ext.shell.system.Job
import io.vertx.ext.shell.system.{JobController => JJobController}
import io.vertx.ext.shell.{Shell => JShell}
import scala.collection.JavaConverters._
import io.vertx.ext.shell.system.{Job => JJob}
import io.vertx.ext.shell.cli.{CliToken => JCliToken}
import io.vertx.scala.ext.shell.system.JobController
import io.vertx.ext.shell.session.{Session => JSession}
import io.vertx.scala.ext.shell.cli.CliToken

/**
  * An interactive session between a consumer and a shell.
  */
class Shell(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0:JobController = _
  private var cached_1:Session = _

  /**
    * @return the shell's job controller
    */
  def jobController():JobController = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JShell].jobController()
      cached_0 = JobController(tmp)
    }
    cached_0
  }

  /**
    * @return the current shell session
    */
  def session():Session = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JShell].session()
      cached_1 = Session(tmp)
    }
    cached_1
  }

  /**
    * Create a job, the created job should then be executed with the [[io.vertx.scala.ext.shell.system.Job#run]] method.
    * @param line the command line creating this job
    * @return the created job
    */
  def createJob(line: scala.collection.mutable.Buffer[CliToken]):Job = {
    Job(asJava.asInstanceOf[JShell].createJob(line.map(x => x.asJava.asInstanceOf[JCliToken]).asJava))
  }

  /**
    * See [[io.vertx.scala.ext.shell.Shell#createJob]]
    */
  def createJob(line: String):Job = {
    Job(asJava.asInstanceOf[JShell].createJob(line.asInstanceOf[java.lang.String]))
  }

  /**
    * Close the shell.
    */
  def close():Unit = {
    asJava.asInstanceOf[JShell].close()
  }

}

object Shell{
  def apply(asJava: JShell) = new Shell(asJava)  
}
