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

class NetClient(private val _asJava: io.vertx.core.net.NetClient) 
    extends io.vertx.scala.core.metrics.Measured {

  def asJava: java.lang.Object = _asJava

  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  def connect(port: Int, host: String)(connectHandler: Try[io.vertx.scala.core.net.NetSocket] => Unit): io.vertx.scala.core.net.NetClient = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.connect(port, host, funcToMappedAsyncResultHandler(NetSocket.apply)(connectHandler))
    this
  }

  def close(): Unit = {
    _asJava.close()
  }

}

object NetClient {

  def apply(_asJava: io.vertx.core.net.NetClient): io.vertx.scala.core.net.NetClient =
    new io.vertx.scala.core.net.NetClient(_asJava)
}
