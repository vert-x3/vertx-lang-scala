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

package io.vertx.scala.redis.client

import scala.reflect.runtime.universe._
import io.vertx.redis.client.{Command => JCommand}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * <b>Auto generated</b> API Commands to interact with REDIS.
  */

class Command(private val _asJava: Object) {
  def asJava = _asJava






  def getArity (): Int = {
    asJava.asInstanceOf[JCommand].getArity().asInstanceOf[Int]
  }


  def isMultiKey (): Boolean = {
    asJava.asInstanceOf[JCommand].isMultiKey().asInstanceOf[Boolean]
  }


  def getFirstKey (): Int = {
    asJava.asInstanceOf[JCommand].getFirstKey().asInstanceOf[Int]
  }


  def getLastKey (): Int = {
    asJava.asInstanceOf[JCommand].getLastKey().asInstanceOf[Int]
  }


  def getInterval (): Int = {
    asJava.asInstanceOf[JCommand].getInterval().asInstanceOf[Int]
  }


  def isKeyless (): Boolean = {
    asJava.asInstanceOf[JCommand].isKeyless().asInstanceOf[Boolean]
  }


  def isReadOnly (): Boolean = {
    asJava.asInstanceOf[JCommand].isReadOnly().asInstanceOf[Boolean]
  }


  def isMovable (): Boolean = {
    asJava.asInstanceOf[JCommand].isMovable().asInstanceOf[Boolean]
  }


}

object Command {
  def apply(asJava: JCommand) = new Command(asJava)

  /**
   * Creates a Redis Command from METADATA. The metadata comes from the REDIS command "COMMAND"
   * https://redis.io/commands/command
   *
   * Each top-level result contains six nested results. Each nested result is:
   *
   *     command name
   *     command arity specification
   *     nested Array reply of command flags
   *     position of first key in argument list
   *     position of last key in argument list
   *     step count for locating repeating keys   * @param command command name
   * @param arity arity
   * @param firstKey position of the first key
   * @param lastKey position of the last key
   * @param interval step count for locating repeating keys
   * @param readOnly readOnly flag extracted from the nested Array reply of command flags
   * @param movable movable flag extracted from the nested Array reply of command flags
   * @return a command instance
   */
  def create(command: String,arity: Int,firstKey: Int,lastKey: Int,interval: Int,readOnly: Boolean,movable: Boolean): Command = {
    Command(JCommand.create(command.asInstanceOf[java.lang.String], arity.asInstanceOf[java.lang.Integer], firstKey.asInstanceOf[java.lang.Integer], lastKey.asInstanceOf[java.lang.Integer], interval.asInstanceOf[java.lang.Integer], readOnly.asInstanceOf[java.lang.Boolean], movable.asInstanceOf[java.lang.Boolean]))//2 create
  }

}
