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
import io.vertx.scala.ext.web.handler.sockjs.SockJSSocket
import io.vertx.ext.web.handler.sockjs.{SockJSSocket => JSockJSSocket}
import io.vertx.ext.shell.term.{SockJSTermHandler => JSockJSTermHandler}
import io.vertx.core.Handler
import io.vertx.scala.core.Vertx
import io.vertx.ext.shell.term.{Term => JTerm}
import io.vertx.core.{Vertx => JVertx}

/**
  */
class SockJSTermHandler(private val _asJava: Object)
    extends io.vertx.core.Handler[SockJSSocket] {

  def asJava = _asJava

  def termHandler(handler: Handler[Term]): SockJSTermHandler = {
    asJava.asInstanceOf[JSockJSTermHandler].termHandler({x: JTerm => handler.handle(Term(x))})
    this
  }

  override def handle(arg0: SockJSSocket): Unit = {
    asJava.asInstanceOf[JSockJSTermHandler].handle(arg0.asJava.asInstanceOf[JSockJSSocket])
  }

}

object SockJSTermHandler{
  def apply(asJava: JSockJSTermHandler) = new SockJSTermHandler(asJava)  
  def create(vertx: Vertx,charset: String): SockJSTermHandler = {
    SockJSTermHandler(JSockJSTermHandler.create(vertx.asJava.asInstanceOf[JVertx],charset.asInstanceOf[java.lang.String]))
  }

}
