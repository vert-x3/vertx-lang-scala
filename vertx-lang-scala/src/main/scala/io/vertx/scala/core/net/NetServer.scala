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

import io.vertx.scala.core.net.NetSocketStream
import io.vertx.core.net.{NetSocketStream => JNetSocketStream}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.net.{NetServer => JNetServer}
import io.vertx.scala.core.net.NetSocket
import io.vertx.core.net.{NetSocket => JNetSocket}

/**
  * Represents a TCP server
  */
class NetServer(private val _asJava: Object) 
    extends Measured(_asJava) {

  override def asJava = _asJava.asInstanceOf[JNetServer]
//methods returning a future
  def close(completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.close( )
  }

//cached methods
//fluent methods
  def listen():NetServer = {
    asJava.listen( )
    this
  }

  def listen(listenHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[NetServer]]):NetServer = {
    asJava.listen( )
    this
  }

  def listen(port: Int,host: String):NetServer = {
    asJava.listen( )
    this
  }

  def listen(port: Int,host: String,listenHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[NetServer]]):NetServer = {
    asJava.listen( )
    this
  }

  def listen(port: Int):NetServer = {
    asJava.listen( )
    this
  }

  def listen(port: Int,listenHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[NetServer]]):NetServer = {
    asJava.listen( )
    this
  }

//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.isMetricsEnabled( )
  }

  def connectStream():NetSocketStream = {
    asJava.connectStream( )
  }

  def connectHandler(handler: io.vertx.core.Handler[NetSocket]):NetServer = {
    asJava.connectHandler( )
  }

  def close():Unit = {
    asJava.close( )
  }

  def close(completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.close( )
  }

  def actualPort():Int = {
    asJava.actualPort( )
  }

}

object NetServer{
//in object!
//static methods
}
