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

package io.vertx.scala.ext.web.handler.sockjs

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.handler.sockjs.BridgeEventType
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.web.handler.sockjs.{SockJSSocket => JSockJSSocket}
import io.vertx.core.{Future => JFuture}
import io.vertx.ext.web.handler.sockjs.{BridgeEvent => JBridgeEvent}
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.Future
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Represents an event that occurs on the event bus bridge.
  * 
  * Please consult the documentation for a full explanation.
  */
class BridgeEvent(private val _asJava: Object) 
    extends Future[Boolean](_asJava) {

  private var cached_0:Handler[AsyncResult[Boolean]] = _
  private var cached_1:io.vertx.ext.web.handler.sockjs.BridgeEventType = _
  private var cached_2:io.vertx.core.json.JsonObject = _
  private var cached_3:SockJSSocket = _

  override def completer():Handler[AsyncResult[Boolean]] = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JBridgeEvent].completer()
      cached_0 = {x: AsyncResult[Boolean] => tmp.handle(AsyncResultWrapper[Boolean,java.lang.Boolean](x, a => a.asInstanceOf[java.lang.Boolean]))}
    }
    cached_0
  }

  /**
    * @return the type of the event
    */
  def `type`():io.vertx.ext.web.handler.sockjs.BridgeEventType = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JBridgeEvent].`type`()
      cached_1 = tmp
    }
    cached_1
  }

  /**
    * Use [[io.vertx.scala.ext.web.handler.sockjs.BridgeEvent#getRawMessage]] instead, will be removed in 3.3
    */
  def rawMessage():io.vertx.core.json.JsonObject = {
    if(cached_2 == null) {
      var tmp = asJava.asInstanceOf[JBridgeEvent].rawMessage()
      cached_2 = tmp
    }
    cached_2
  }

  /**
    * Get the SockJSSocket instance corresponding to the event
    * @return the SockJSSocket instance
    */
  def socket():SockJSSocket = {
    if(cached_3 == null) {
      var tmp = asJava.asInstanceOf[JBridgeEvent].socket()
      cached_3 = SockJSSocket(tmp)
    }
    cached_3
  }

//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Boolean>>
  override def setHandler(arg0: Handler[AsyncResult[Boolean]]):Future[Boolean] = {
    asJava.asInstanceOf[JBridgeEvent].setHandler({x: AsyncResult[java.lang.Boolean] => arg0.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a.asInstanceOf[Boolean]))})
    this
  }

  /**
    * Get the raw JSON message for the event. This will be null for SOCKET_CREATED or SOCKET_CLOSED events as there is
    * no message involved.
    * @param message the raw message
    * @return this reference, so it can be used fluently
    */
//io.vertx.core.json.JsonObject
  def setRawMessage(message: io.vertx.core.json.JsonObject):BridgeEvent = {
    asJava.asInstanceOf[JBridgeEvent].setRawMessage(message)
    this
  }

  override def compose[U:TypeTag](handler: Handler[Boolean],next: Future[U]):Future[U] = {
    Future[U](asJava.asInstanceOf[JBridgeEvent].compose[Object]({x: java.lang.Boolean => handler.handle(x.asInstanceOf[Boolean])},next.asJava.asInstanceOf[JFuture[Object]]))
  }

  override def compose[U:TypeTag](mapper: Boolean => Future[U]):Future[U] = {
    Future[U](asJava.asInstanceOf[JBridgeEvent].compose[Object]({x: java.lang.Boolean => mapper(x.asInstanceOf[Boolean]).asJava.asInstanceOf[JFuture[Object]]}))
  }

  override def map[U:TypeTag](mapper: Boolean => U):Future[U] = {
    Future[U](asJava.asInstanceOf[JBridgeEvent].map[Object]({x: java.lang.Boolean => toJava[U](mapper(x.asInstanceOf[Boolean]))}))
  }

  override def complete(arg0: Boolean):Unit = {
    asJava.asInstanceOf[JBridgeEvent].complete(arg0.asInstanceOf[java.lang.Boolean])
  }

  override def result():Boolean = {
    asJava.asInstanceOf[JBridgeEvent].result().asInstanceOf[Boolean]
  }

  /**
    * Get the raw JSON message for the event. This will be null for SOCKET_CREATED or SOCKET_CLOSED events as there is
    * no message involved. If the returned message is modified, [[io.vertx.scala.ext.web.handler.sockjs.BridgeEvent#setRawMessage]] should be called with the
    * new message.
    * @return the raw JSON message for the event
    */
  def getRawMessage():io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JBridgeEvent].getRawMessage()
  }

  override   def setFuture():scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JBridgeEvent].setHandler(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object BridgeEvent{
  def apply(asJava: JBridgeEvent) = new BridgeEvent(asJava)  
}
