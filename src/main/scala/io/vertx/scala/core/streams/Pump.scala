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

package io.vertx.scala.core.streams;


class Pump(private val _asJava: io.vertx.core.streams.Pump) {

  def asJava: java.lang.Object = _asJava

  def setWriteQueueMaxSize(maxSize: Int): io.vertx.scala.core.streams.Pump = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def start(): io.vertx.scala.core.streams.Pump = {
    _asJava.start()
    this
  }

  def stop(): io.vertx.scala.core.streams.Pump = {
    _asJava.stop()
    this
  }

  def numberPumped(): Int = {
    _asJava.numberPumped()
  }

}

object Pump {

  def apply(_asJava: io.vertx.core.streams.Pump): io.vertx.scala.core.streams.Pump =
    new io.vertx.scala.core.streams.Pump(_asJava)
  
    def pump[T](rs: io.vertx.scala.core.streams.ReadStream[T], ws: io.vertx.scala.core.streams.WriteStream[T]): io.vertx.scala.core.streams.Pump = {
      Pump.apply(io.vertx.core.streams.Pump.pump(rs.asJava.asInstanceOf[io.vertx.core.streams.ReadStream[T]], ws.asJava.asInstanceOf[io.vertx.core.streams.WriteStream[T]]))
    }
  
    def pump[T](rs: io.vertx.scala.core.streams.ReadStream[T], ws: io.vertx.scala.core.streams.WriteStream[T], writeQueueMaxSize: Int): io.vertx.scala.core.streams.Pump = {
      Pump.apply(io.vertx.core.streams.Pump.pump(rs.asJava.asInstanceOf[io.vertx.core.streams.ReadStream[T]], ws.asJava.asInstanceOf[io.vertx.core.streams.WriteStream[T]], writeQueueMaxSize))
    }
}
