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

package io.vertx.scala.ext.shell.cli

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.shell.cli.{CliToken => JCliToken}

/**
  * A parsed token in the command line interface.
  */
class CliToken(private val _asJava: JCliToken) {

  def asJava: JCliToken = _asJava

  /**
    * @return the token value
    */
  def value(): String = {
    _asJava.value()
  }

  /**
    * @return the raw token value, that may contain unescaped chars, for instance ` "ab\"cd"`
    */
  def raw(): String = {
    _asJava.raw()
  }

  /**
    * @return true when it's a text token
    */
  def isText(): Boolean = {
    _asJava.isText()
  }

  /**
    * @return true when it's a blank token
    */
  def isBlank(): Boolean = {
    _asJava.isBlank()
  }

}

object CliToken {

  def apply(_asJava: JCliToken): CliToken =
    new CliToken(_asJava)

  def createText(text: String): CliToken = {
    CliToken.apply(io.vertx.ext.shell.cli.CliToken.createText(text))
  }

  def createBlank(blank: String): CliToken = {
    CliToken.apply(io.vertx.ext.shell.cli.CliToken.createBlank(blank))
  }

  def tokenize(s: String): scala.collection.mutable.Buffer[CliToken] = {
    io.vertx.ext.shell.cli.CliToken.tokenize(s).asScala.map(CliToken.apply)
  }

}
