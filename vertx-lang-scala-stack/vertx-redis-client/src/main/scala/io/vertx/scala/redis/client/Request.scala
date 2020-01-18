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

import io.vertx.core.buffer.Buffer
import scala.reflect.runtime.universe._
import io.vertx.redis.client.{Command => JCommand}
import io.vertx.redis.client.{Request => JRequest}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Builder for REDIS requests that will be encoded according to the RESP protocol was introduced in Redis 1.2.
  * Which became the standard way for talking with the Redis server in Redis 2.0.
  *
  * Redis <a href="https://redis.io/topics/protocol">protocol documentation</a> states:
  *
  * <blockquote>
  *     Clients send commands to a Redis server as a RESP Array of Bulk Strings.
  * </blockquote>
  *
  * So all non String/Bulk types will be encoded to Bulk for convenience.
  */

class Request(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Adds a String argument using UTF8 character encoding   * @return self
   */
  
  def arg(arg: String): Request = {
    asJava.asInstanceOf[JRequest].arg(arg.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Adds a String using a specific character encoding argument   * @return self
   */
  
  def arg(arg: String, enc: String): Request = {
    asJava.asInstanceOf[JRequest].arg(arg.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Adds a String key argument   * @return self
   */
  
  def arg(arg: io.vertx.core.buffer.Buffer): Request = {
    asJava.asInstanceOf[JRequest].arg(arg)
    this
  }

  /**
   * Adds a long encoded to string   * @return self
   */
  
  def arg(arg: Long): Request = {
    asJava.asInstanceOf[JRequest].arg(arg.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Adds a boolean encoded to string   * @return self
   */
  
  def arg(arg: Boolean): Request = {
    asJava.asInstanceOf[JRequest].arg(arg.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Adds a NULL encoded string   * @return self
   */
  
  def nullArg(): Request = {
    asJava.asInstanceOf[JRequest].nullArg()
    this
  }



  /**
   * Get the Command that is to be used by this request.   * @return the command.
   */
  def command (): Command = {
    Command(asJava.asInstanceOf[JRequest].command())
  }


}

object Request {
  def apply(asJava: JRequest) = new Request(asJava)


  def cmd(command: Command): Request = {
    Request(JRequest.cmd(command.asJava.asInstanceOf[JCommand]))//2 cmd
  }

}
