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
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.net.{NetClient => JNetClient}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * A TCP client.
  * 
  * Multiple connections to different servers can be made using the same instance.
  * 
  * This client supports a configurable number of connection attempts and a configurable
  * delay between attempts.
  */
class NetClient(private val _asJava: Object) 
    extends Measured {

  def asJava = _asJava

//cached methods
//fluent methods
  def connect(port: Int,host: String,connectHandler: Handler[AsyncResult[NetSocket]]):NetClient = {
    asJava.asInstanceOf[JNetClient].connect(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],{x: AsyncResult[JNetSocket] => connectHandler.handle(AsyncResultWrapper[JNetSocket,NetSocket](x, a => NetSocket(a)))})
    this
  }

//default methods
//basic methods
      override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JNetClient].isMetricsEnabled().asInstanceOf[Boolean]
  }

      def close():Unit = {
    asJava.asInstanceOf[JNetClient].close()
  }

//future methods
  def connectFuture(port: Int,host: String):scala.concurrent.Future[NetSocket] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetSocket, NetSocket](x => if (x == null) null.asInstanceOf[NetSocket] else NetSocket(x))
    asJava.asInstanceOf[JNetClient].connect(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object NetClient{
    def apply(asJava: JNetClient) = new NetClient(asJava)  
  //static methods
  }
