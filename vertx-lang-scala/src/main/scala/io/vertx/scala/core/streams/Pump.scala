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

package io.vertx.scala.core.streams

import io.vertx.core.streams.{Pump => JPump}
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Pumps data from a [[io.vertx.scala.core.streams.ReadStream]] to a [[io.vertx.scala.core.streams.WriteStream]] and performs flow control where necessary to
  * prevent the write stream buffer from getting overfull.
  * 
  * Instances of this class read items from a [[io.vertx.scala.core.streams.ReadStream]] and write them to a [[io.vertx.scala.core.streams.WriteStream]]. If data
  * can be read faster than it can be written this could result in the write queue of the [[io.vertx.scala.core.streams.WriteStream]] growing
  * without bound, eventually causing it to exhaust all available RAM.
  * 
  * To prevent this, after each write, instances of this class check whether the write queue of the [[io.vertx.scala.core.streams.WriteStream]] is full, and if so, the [[io.vertx.scala.core.streams.ReadStream]] is paused, and a `drainHandler` is set on the
  * [[io.vertx.scala.core.streams.WriteStream]].
  * 
  * When the [[io.vertx.scala.core.streams.WriteStream]] has processed half of its backlog, the `drainHandler` will be
  * called, which results in the pump resuming the [[io.vertx.scala.core.streams.ReadStream]].
  * 
  * This class can be used to pump from any [[io.vertx.scala.core.streams.ReadStream]] to any [[io.vertx.scala.core.streams.WriteStream]],
  * e.g. from an [[io.vertx.scala.core.http.HttpServerRequest]] to an [[io.vertx.scala.core.file.AsyncFile]],
  * or from [[io.vertx.scala.core.net.NetSocket]] to a [[io.vertx.scala.core.http.WebSocket]].
  * 
  * Please see the documentation for more information.
  */

class Pump(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Set the write queue max size to `maxSize`   * @param maxSize the max size
   * @return a reference to this, so the API can be used fluently
   */
  
  def setWriteQueueMaxSize(maxSize: Int): Pump = {
    asJava.asInstanceOf[JPump].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }

  /**
   * Start the Pump. The Pump can be started and stopped multiple times.   * @return a reference to this, so the API can be used fluently
   */
  
  def start(): Pump = {
    asJava.asInstanceOf[JPump].start()
    this
  }

  /**
   * Stop the Pump. The Pump can be started and stopped multiple times.   * @return a reference to this, so the API can be used fluently
   */
  
  def stop(): Pump = {
    asJava.asInstanceOf[JPump].stop()
    this
  }



  /**
   * Return the total number of items pumped by this pump.
   */
  def numberPumped (): Int = {
    asJava.asInstanceOf[JPump].numberPumped().asInstanceOf[Int]
  }


}

object Pump {
  def apply(asJava: JPump) = new Pump(asJava)
  
  /**
   * Create a new `Pump` with the given `ReadStream` and `WriteStream`   * @param rs the read stream
   * @param ws the write stream
   * @return the pump
   */
  def pump[T: TypeTag](rs: ReadStream[T],ws: WriteStream[T]): Pump = {
    Pump(JPump.pump[Object](rs.asJava.asInstanceOf[JReadStream[Object]], ws.asJava.asInstanceOf[JWriteStream[Object]]))
  }

  /**
   * Create a new `Pump` with the given `ReadStream` and `WriteStream` and
   * `writeQueueMaxSize`   * @param rs the read stream
   * @param ws the write stream
   * @param writeQueueMaxSize the max size of the write queue
   * @return the pump
   */
  def pump[T: TypeTag](rs: ReadStream[T],ws: WriteStream[T],writeQueueMaxSize: Int): Pump = {
    Pump(JPump.pump[Object](rs.asJava.asInstanceOf[JReadStream[Object]], ws.asJava.asInstanceOf[JWriteStream[Object]], writeQueueMaxSize.asInstanceOf[java.lang.Integer]))
  }

}
