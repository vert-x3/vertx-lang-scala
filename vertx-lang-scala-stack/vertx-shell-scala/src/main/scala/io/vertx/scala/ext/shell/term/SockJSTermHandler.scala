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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.ext.web.handler.sockjs.SockJSSocket
import io.vertx.scala.core.Vertx
import io.vertx.core.Handler

/**
  */
class SockJSTermHandler(private val _asJava: io.vertx.ext.shell.term.SockJSTermHandler) {

  def asJava: io.vertx.ext.shell.term.SockJSTermHandler = _asJava

  def handle(arg0: io.vertx.scala.ext.web.handler.sockjs.SockJSSocket): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[io.vertx.ext.web.handler.sockjs.SockJSSocket])
  }

  def termHandler(handler: io.vertx.scala.ext.shell.term.Term => Unit): io.vertx.scala.ext.shell.term.SockJSTermHandler = {
    _asJava.termHandler(funcToMappedHandler(Term.apply)(handler))
    this
  }

}

object SockJSTermHandler {

  def apply(_asJava: io.vertx.ext.shell.term.SockJSTermHandler): io.vertx.scala.ext.shell.term.SockJSTermHandler =
    new io.vertx.scala.ext.shell.term.SockJSTermHandler(_asJava)

  def create(vertx: io.vertx.scala.core.Vertx, charset: String): io.vertx.scala.ext.shell.term.SockJSTermHandler = {
    SockJSTermHandler.apply(io.vertx.ext.shell.term.SockJSTermHandler.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], charset))
  }

}
