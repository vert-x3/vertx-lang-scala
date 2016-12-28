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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.net.{NetServer => JNetServer}
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.net.{NetSocketStream => JNetSocketStream}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Represents a TCP server
  */
class NetServer(private val _asJava: Object) 
    extends Measured {

  def asJava = _asJava

//cached methods
//fluent methods
  def listen():NetServer = {
    asJava.asInstanceOf[JNetServer].listen()
    this
  }

  def listen(listenHandler: Handler[AsyncResult[NetServer]]):NetServer = {
    asJava.asInstanceOf[JNetServer].listen({x: AsyncResult[JNetServer] => listenHandler.handle(AsyncResultWrapper[JNetServer,NetServer](x, a => NetServer(a)))})
    this
  }

  def listen(port: Int,host: String):NetServer = {
    asJava.asInstanceOf[JNetServer].listen(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String])
    this
  }

  def listen(port: Int,host: String,listenHandler: Handler[AsyncResult[NetServer]]):NetServer = {
    asJava.asInstanceOf[JNetServer].listen(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],{x: AsyncResult[JNetServer] => listenHandler.handle(AsyncResultWrapper[JNetServer,NetServer](x, a => NetServer(a)))})
    this
  }

  def listen(port: Int):NetServer = {
    asJava.asInstanceOf[JNetServer].listen(port.asInstanceOf[java.lang.Integer])
    this
  }

  def listen(port: Int,listenHandler: Handler[AsyncResult[NetServer]]):NetServer = {
    asJava.asInstanceOf[JNetServer].listen(port.asInstanceOf[java.lang.Integer],{x: AsyncResult[JNetServer] => listenHandler.handle(AsyncResultWrapper[JNetServer,NetServer](x, a => NetServer(a)))})
    this
  }

//default methods
//basic methods
      override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JNetServer].isMetricsEnabled().asInstanceOf[Boolean]
  }

      def connectStream():NetSocketStream = {
    NetSocketStream(asJava.asInstanceOf[JNetServer].connectStream())
  }

      def connectHandler(handler: Handler[NetSocket]):NetServer = {
    NetServer(asJava.asInstanceOf[JNetServer].connectHandler({x: JNetSocket => handler.handle(NetSocket(x))}))
  }

      def close():Unit = {
    asJava.asInstanceOf[JNetServer].close()
  }

      def close(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JNetServer].close({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

      def actualPort():Int = {
    asJava.asInstanceOf[JNetServer].actualPort().asInstanceOf[Int]
  }

//future methods
  def listenFuture():scala.concurrent.Future[NetServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetServer, NetServer](x => if (x == null) null.asInstanceOf[NetServer] else NetServer(x))
    asJava.asInstanceOf[JNetServer].listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def listenFuture(port: Int,host: String):scala.concurrent.Future[NetServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetServer, NetServer](x => if (x == null) null.asInstanceOf[NetServer] else NetServer(x))
    asJava.asInstanceOf[JNetServer].listen(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def listenFuture(port: Int):scala.concurrent.Future[NetServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetServer, NetServer](x => if (x == null) null.asInstanceOf[NetServer] else NetServer(x))
    asJava.asInstanceOf[JNetServer].listen(port.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def closeFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JNetServer].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object NetServer{
    def apply(asJava: JNetServer) = new NetServer(asJava)  
  //static methods
  }
