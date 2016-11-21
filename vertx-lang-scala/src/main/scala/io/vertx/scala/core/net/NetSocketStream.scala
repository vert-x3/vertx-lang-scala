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

package io.vertx.scala.core.net

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.net.{NetSocketStream => JNetSocketStream}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.net.{NetSocket => JNetSocket}

/**
  * A [[io.vertx.scala.core.streams.ReadStream]] of [[io.vertx.scala.core.net.NetSocket]], used for notifying
  * socket connections to a [[io.vertx.scala.core.net.NetServer]].
  */
class NetSocketStream(private val _asJava: JNetSocketStream) 
    extends ReadStream[NetSocket] {

  def asJava: JNetSocketStream = _asJava

  def exceptionHandler(handler: Throwable => Unit): NetSocketStream = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: NetSocket => Unit): NetSocketStream = {
    _asJava.handler(funcToMappedHandler(NetSocket.apply)(handler))
    this
  }

  def pause(): NetSocketStream = {
    _asJava.pause()
    this
  }

  def resume(): NetSocketStream = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: () => Unit): NetSocketStream = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => endHandler()))
    this
  }

}

object NetSocketStream {

  def apply(_asJava: JNetSocketStream): NetSocketStream =
    new NetSocketStream(_asJava)

}
