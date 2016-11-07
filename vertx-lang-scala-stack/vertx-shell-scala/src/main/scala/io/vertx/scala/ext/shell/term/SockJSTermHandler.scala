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
import io.vertx.ext.shell.term.{SockJSTermHandler => JSockJSTermHandler}
import io.vertx.ext.web.handler.sockjs.{SockJSSocket => JSockJSSocket}
import io.vertx.scala.ext.web.handler.sockjs.SockJSSocket
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.ext.shell.term.{Term => JTerm}

/**
  */
class SockJSTermHandler(private val _asJava: JSockJSTermHandler) {

  def asJava: JSockJSTermHandler = _asJava

  def handle(arg0: SockJSSocket): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[JSockJSSocket])
  }

  def termHandler(handler: Term => Unit): SockJSTermHandler = {
    _asJava.termHandler(funcToMappedHandler(Term.apply)(handler))
    this
  }

}

object SockJSTermHandler {

  def apply(_asJava: JSockJSTermHandler): SockJSTermHandler =
    new SockJSTermHandler(_asJava)

  def create(vertx: Vertx, charset: String): SockJSTermHandler = {
    SockJSTermHandler.apply(io.vertx.ext.shell.term.SockJSTermHandler.create(vertx.asJava.asInstanceOf[JVertx], charset))
  }

}
