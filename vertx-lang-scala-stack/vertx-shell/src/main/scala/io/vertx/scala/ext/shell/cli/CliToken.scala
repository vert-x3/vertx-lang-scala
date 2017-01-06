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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.shell.cli.{CliToken => JCliToken}
import scala.collection.JavaConverters._

/**
  * A parsed token in the command line interface.
  */
class CliToken(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * @return the token value
    */
  def value():String = {
    asJava.asInstanceOf[JCliToken].value().asInstanceOf[String]
  }

  /**
    * @return the raw token value, that may contain unescaped chars, for instance ` "ab\"cd"`
    */
  def raw():String = {
    asJava.asInstanceOf[JCliToken].raw().asInstanceOf[String]
  }

  /**
    * @return true when it's a text token
    */
  def isText():Boolean = {
    asJava.asInstanceOf[JCliToken].isText().asInstanceOf[Boolean]
  }

  /**
    * @return true when it's a blank token
    */
  def isBlank():Boolean = {
    asJava.asInstanceOf[JCliToken].isBlank().asInstanceOf[Boolean]
  }

}

object CliToken{
  def apply(asJava: JCliToken) = new CliToken(asJava)  
  /**
    * Create a text token.
    * @param text the text
    * @return the token
    */
  def createText(text: String):CliToken = {
    CliToken(JCliToken.createText(text.asInstanceOf[java.lang.String]))
  }

  /**
    * Create a new blank token.
    * @param blank the blank value
    * @return the token
    */
  def createBlank(blank: String):CliToken = {
    CliToken(JCliToken.createBlank(blank.asInstanceOf[java.lang.String]))
  }

  /**
    * Tokenize the string argument and return a list of tokens.
    * @param s the tokenized string
    * @return the tokens
    */
  def tokenize(s: String):scala.collection.mutable.Buffer[CliToken] = {
    JCliToken.tokenize(s.asInstanceOf[java.lang.String]).asScala.map(x => CliToken(x))
  }

}
