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

package io.vertx.scala.ext.bridge

import io.vertx.ext.bridge.{BaseBridgeEvent => JBaseBridgeEvent}
import io.vertx.core.{Promise => JPromise}
import scala.reflect.runtime.universe._
import io.vertx.core.{Future => JFuture}
import io.vertx.ext.bridge.BridgeEventType
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.Future
import io.vertx.scala.core.Promise
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Represents an event that occurs on the event bus bridge.
  * 
  * Please consult the documentation for a full explanation.
  */

class BaseBridgeEvent(private val _asJava: Object) extends Promise[Boolean] (_asJava) {

  private var cached_0: Option[Future[Boolean]] = None
  private var cached_1: Option[io.vertx.ext.bridge.BridgeEventType] = None



  override def future(): Future[Boolean] = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JBaseBridgeEvent].future()
      cached_0 = Some(Future[Boolean](tmp))
    }
    cached_0.get
  }

  /**
   * @return the type of the event
   */
  def `type`(): io.vertx.ext.bridge.BridgeEventType = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JBaseBridgeEvent].`type`()
      cached_1 = Some(tmp)
    }
    cached_1.get
  }


  /**
   * Get the raw JSON message for the event. This will be null for SOCKET_CREATED or SOCKET_CLOSED events as there is
   * no message involved.   * @param message the raw message
   * @return this reference, so it can be used fluently
   */
  
  def setRawMessage(message: io.vertx.core.json.JsonObject): BaseBridgeEvent = {
    asJava.asInstanceOf[JBaseBridgeEvent].setRawMessage(message)
    this
  }




  override def complete (arg0: Boolean): Unit = {
    asJava.asInstanceOf[JBaseBridgeEvent].complete(arg0.asInstanceOf[java.lang.Boolean])
  }


  override def tryComplete (arg0: Boolean): Boolean = {
    asJava.asInstanceOf[JBaseBridgeEvent].tryComplete(arg0.asInstanceOf[java.lang.Boolean]).asInstanceOf[Boolean]
  }

  /**
   * Get the raw JSON message for the event. This will be null for SOCKET_CREATED or SOCKET_CLOSED events as there is
   * no message involved. If the returned message is modified, [[io.vertx.scala.ext.bridge.BaseBridgeEvent#setRawMessage]] should be called with the
   * new message.   * @return the raw JSON message for the event
   */
  def getRawMessage (): io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JBaseBridgeEvent].getRawMessage()
  }


}

object BaseBridgeEvent {
  def apply(asJava: JBaseBridgeEvent) = new BaseBridgeEvent(asJava)

}
