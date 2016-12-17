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

import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.net.{NetSocketStream => JNetSocketStream}
import io.vertx.core.Handler

/**
  * A [[io.vertx.scala.core.streams.ReadStream]] of [[io.vertx.scala.core.net.NetSocket]], used for notifying
  * socket connections to a [[io.vertx.scala.core.net.NetServer]].
  */
class NetSocketStream(private val _asJava: Object) 
    extends ReadStream[NetSocket](_asJava) {


//methods returning a future
//cached methods
//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):NetSocketStream = {
    NetSocketStream(asJava.asInstanceOf[JNetSocketStream].exceptionHandler(handler))
    this
  }

  override def handler(handler: Handler[NetSocket]):NetSocketStream = {
    NetSocketStream(asJava.asInstanceOf[JNetSocketStream].handler(handler))
    this
  }

  override def pause():NetSocketStream = {
    NetSocketStream(asJava.asInstanceOf[JNetSocketStream].pause())
    this
  }

  override def resume():NetSocketStream = {
    NetSocketStream(asJava.asInstanceOf[JNetSocketStream].resume())
    this
  }

  override def endHandler(endHandler: Handler[Unit]):NetSocketStream = {
    NetSocketStream(asJava.asInstanceOf[JNetSocketStream].endHandler(endHandler))
    this
  }

//basic methods
}

object NetSocketStream{
  def apply(asJava: JNetSocketStream) = new NetSocketStream(asJava)//static methods
}
