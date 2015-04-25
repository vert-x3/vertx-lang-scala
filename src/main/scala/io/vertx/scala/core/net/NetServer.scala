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

package io.vertx.scala.core.net;

import io.vertx.scala.core.metrics.Measured
import scala.util.Try
import io.vertx.core.Handler

class NetServer(private val _asJava: io.vertx.core.net.NetServer) 
    extends io.vertx.scala.core.metrics.Measured {

  def asJava: java.lang.Object = _asJava

  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  def connectStream(): io.vertx.scala.core.net.NetSocketStream = {
    NetSocketStream.apply(_asJava.connectStream())
  }

  def connectHandler(handler: io.vertx.scala.core.net.NetSocket => Unit): io.vertx.scala.core.net.NetServer = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    NetServer.apply(_asJava.connectHandler(funcToMappedHandler(NetSocket.apply)(handler)))
  }

  def listen(): io.vertx.scala.core.net.NetServer = {
    _asJava.listen()
    this
  }

  def listen(listenHandler: Try[io.vertx.scala.core.net.NetServer] => Unit): io.vertx.scala.core.net.NetServer = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.listen(funcToMappedAsyncResultHandler(NetServer.apply)(listenHandler))
    this
  }

  def listen(port: Int, host: String): io.vertx.scala.core.net.NetServer = {
    _asJava.listen(port, host)
    this
  }

  def listen(port: Int, host: String)(listenHandler: Try[io.vertx.scala.core.net.NetServer] => Unit): io.vertx.scala.core.net.NetServer = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.listen(port, host, funcToMappedAsyncResultHandler(NetServer.apply)(listenHandler))
    this
  }

  def listen(port: Int): io.vertx.scala.core.net.NetServer = {
    _asJava.listen(port)
    this
  }

  def listen(port: Int)(listenHandler: Try[io.vertx.scala.core.net.NetServer] => Unit): io.vertx.scala.core.net.NetServer = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.listen(port, funcToMappedAsyncResultHandler(NetServer.apply)(listenHandler))
    this
  }

  def close(): Unit = {
    _asJava.close()
  }

  def close(completionHandler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.close(funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(completionHandler))
  }

  def actualPort(): Int = {
    _asJava.actualPort()
  }

}

object NetServer {

  def apply(_asJava: io.vertx.core.net.NetServer): io.vertx.scala.core.net.NetServer =
    new io.vertx.scala.core.net.NetServer(_asJava)
}
