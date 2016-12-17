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

import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.net.{NetServer => JNetServer}
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.net.{NetSocketStream => JNetSocketStream}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Represents a TCP server
  */
class NetServer(private val _asJava: Object) 
    extends Measured(_asJava) {


//methods returning a future
  def close(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JNetServer].close(completionHandler)
  }

//cached methods
//fluent methods
  def listen():NetServer = {
    NetServer(asJava.asInstanceOf[JNetServer].listen())
    this
  }

  def listen(listenHandler: Handler[AsyncResult[NetServer]]):NetServer = {
    NetServer(asJava.asInstanceOf[JNetServer].listen(listenHandler))
    this
  }

  def listen(port: Int,host: String):NetServer = {
    NetServer(asJava.asInstanceOf[JNetServer].listen(port,host))
    this
  }

  def listen(port: Int,host: String,listenHandler: Handler[AsyncResult[NetServer]]):NetServer = {
    NetServer(asJava.asInstanceOf[JNetServer].listen(port,host,listenHandler))
    this
  }

  def listen(port: Int):NetServer = {
    NetServer(asJava.asInstanceOf[JNetServer].listen(port))
    this
  }

  def listen(port: Int,listenHandler: Handler[AsyncResult[NetServer]]):NetServer = {
    NetServer(asJava.asInstanceOf[JNetServer].listen(port,listenHandler))
    this
  }

//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JNetServer].isMetricsEnabled()
  }

  def connectStream():NetSocketStream = {
    NetSocketStream(asJava.asInstanceOf[JNetServer].connectStream())
  }

  def connectHandler(handler: Handler[NetSocket]):NetServer = {
    NetServer(asJava.asInstanceOf[JNetServer].connectHandler(handler))
  }

  def close():Unit = {
    asJava.asInstanceOf[JNetServer].close()
  }

  def close(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JNetServer].close(completionHandler)
  }

  def actualPort():Int = {
    asJava.asInstanceOf[JNetServer].actualPort()
  }

}

object NetServer{
  def apply(asJava: JNetServer) = new NetServer(asJava)//static methods
}
