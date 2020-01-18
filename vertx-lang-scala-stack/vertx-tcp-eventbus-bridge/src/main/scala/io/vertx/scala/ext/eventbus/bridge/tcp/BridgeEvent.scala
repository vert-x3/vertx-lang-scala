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

package io.vertx.scala.ext.eventbus.bridge.tcp

import io.vertx.ext.bridge.{BaseBridgeEvent => JBaseBridgeEvent}
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.scala.core.net.NetSocket
import scala.reflect.runtime.universe._
import io.vertx.scala.ext.bridge.BaseBridgeEvent
import io.vertx.ext.eventbus.bridge.tcp.{BridgeEvent => JBridgeEvent}
import io.vertx.core.{Future => JFuture}
import io.vertx.ext.bridge.BridgeEventType
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.Future
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Represents an event that occurs on the event bus bridge.
  * 
  * Please consult the documentation for a full explanation.
  */

class BridgeEvent(private val _asJava: Object) extends BaseBridgeEvent (_asJava) {

  private var cached_0: Option[Future[Boolean]] = None
  private var cached_1: Option[NetSocket] = None



  override def future(): Future[Boolean] = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JBridgeEvent].future()
      cached_0 = Some(Future[Boolean](tmp))
    }
    cached_0.get
  }

  /**
   * Get the SockJSSocket instance corresponding to the event   * @return the SockJSSocket instance
   */
  def socket(): NetSocket = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JBridgeEvent].socket()
      cached_1 = Some(NetSocket(tmp))
    }
    cached_1.get
  }


  /**
   * Get the raw JSON message for the event. This will be null for SOCKET_CREATED or SOCKET_CLOSED events as there is
   * no message involved.   * @param message the raw message
   * @return this reference, so it can be used fluently
   */
  override 
  def setRawMessage(message: io.vertx.core.json.JsonObject): BridgeEvent = {
    asJava.asInstanceOf[JBridgeEvent].setRawMessage(message)
    this
  }




  override def complete (arg0: Boolean): Unit = {
    asJava.asInstanceOf[JBridgeEvent].complete(arg0.asInstanceOf[java.lang.Boolean])
  }


  override def tryComplete (arg0: Boolean): Boolean = {
    asJava.asInstanceOf[JBridgeEvent].tryComplete(arg0.asInstanceOf[java.lang.Boolean]).asInstanceOf[Boolean]
  }


}

object BridgeEvent {
  def apply(asJava: JBridgeEvent) = new BridgeEvent(asJava)

}
