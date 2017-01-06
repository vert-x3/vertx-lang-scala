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

package io.vertx.scala.ext.shell.term

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.shell.term.{SignalHandler => JSignalHandler}

/**
  */
class SignalHandler(private val _asJava: Object) {

  def asJava = _asJava

  def deliver(key: Int):Boolean = {
    asJava.asInstanceOf[JSignalHandler].deliver(key.asInstanceOf[java.lang.Integer]).asInstanceOf[Boolean]
  }

}

object SignalHandler{
  def apply(asJava: JSignalHandler) = new SignalHandler(asJava)  
}
