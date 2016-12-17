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

import io.vertx.core.net.{NetSocketStream => JNetSocketStream}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.net.NetSocket
import io.vertx.core.net.{NetSocket => JNetSocket}

/**
  * A [[io.vertx.scala.core.streams.ReadStream]] of [[io.vertx.scala.core.net.NetSocket]], used for notifying
  * socket connections to a [[io.vertx.scala.core.net.NetServer]].
  */
class NetSocketStream(private val _asJava: Object) 
    extends ReadStream[NetSocket](_asJava) {

  override def asJava = _asJava.asInstanceOf[JNetSocketStream]
//methods returning a future
//cached methods
//fluent methods
  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):NetSocketStream = {
    asJava.exceptionHandler( )
    this
  }

  override def handler(handler: io.vertx.core.Handler[NetSocket]):NetSocketStream = {
    asJava.handler( )
    this
  }

  override def pause():NetSocketStream = {
    asJava.pause( )
    this
  }

  override def resume():NetSocketStream = {
    asJava.resume( )
    this
  }

  override def endHandler(endHandler: io.vertx.core.Handler[Unit]):NetSocketStream = {
    asJava.endHandler( )
    this
  }

//basic methods
}

object NetSocketStream{
//in object!
//static methods
}
