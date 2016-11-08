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
import io.vertx.ext.shell.cli.{Completion => JCompletion}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.ext.shell.cli.{CliToken => JCliToken}
import io.vertx.ext.shell.session.{Session => JSession}
import io.vertx.scala.ext.shell.session.Session

/**
  * The completion object
  */
class Completion(private val _asJava: JCompletion) {

  def asJava: JCompletion = _asJava

  /**
    * @return the current Vert.x instance
    */
  def vertx(): Vertx = {
    Vertx.apply(_asJava.vertx())
  }

  /**
    * @return the shell current session, useful for accessing data like the current path for file completion, etc...
    */
  def session(): Session = {
    Session.apply(_asJava.session())
  }

  /**
    * @return the current line being completed in raw format, i.e without any char escape performed
    */
  def rawLine(): String = {
    _asJava.rawLine()
  }

  /**
    * @return the current line being completed as preparsed tokens
    */
  def lineTokens(): scala.collection.mutable.Buffer[CliToken] = {
    _asJava.lineTokens().asScala.map(CliToken.apply)
  }

  /**
    * End the completion with a list of candidates, these candidates will be displayed by the shell on the console.
    * @param candidates the candidates
    */
  def complete(candidates: scala.collection.mutable.Buffer[String]): Unit = {
    _asJava.complete(candidates.map(x => if (x == null) null else x:java.lang.String).asJava)
  }

  /**
    * End the completion with a value that will be inserted to complete the line.
    * @param value the value to complete with
    * @param terminal true if the value is terminal, i.e can be further completed
    */
  def complete(value: String, terminal: Boolean): Unit = {
    _asJava.complete(value, terminal)
  }

}

object Completion {

  def apply(_asJava: JCompletion): Completion =
    new Completion(_asJava)

}
