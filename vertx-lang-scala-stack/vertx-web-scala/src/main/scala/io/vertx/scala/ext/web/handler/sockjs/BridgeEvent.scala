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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.web.handler.sockjs.{BridgeEvent => JBridgeEvent}
    import io.vertx.ext.web.handler.sockjs.BridgeEventType
  import io.vertx.ext.web.handler.sockjs.{SockJSSocket => JSockJSSocket}
    import io.vertx.core.json.JsonObject
      import io.vertx.ext.web.handler.sockjs.{BridgeEvent => JBridgeEvent}
    import io.vertx.core.{Future => JFuture}
import io.vertx.scala.core.Future
import io.vertx.core.{Future => JFuture}
  import java.util.function.{Function => JFunction}
import java.util.function.Function

/**
  * Represents an event that occurs on the event bus bridge.
  * 
  * Please consult the documentation for a full explanation.
  */
class BridgeEvent(private val _asJava: JBridgeEvent) {

  def asJava: JBridgeEvent = _asJava

  def setFuture(): concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean,Boolean]((x => x))
    _asJava.setHandler(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def complete(arg0: Boolean): Unit = {
    _asJava.complete(arg0)
  }

  def result(): Boolean = {
    _asJava.result()
  }

  def compose[U](handler: Boolean => Unit, next: Future[U]): Future[U] = {
    Future.apply[U](_asJava.compose(funcToMappedHandler[java.lang.Boolean, Boolean](x => x)(handler), next.asJava.asInstanceOf[JFuture[U]]))
  }

  def compose[U](mapper: java.lang.Boolean => JFuture[U]): Future[U] = {
    Future.apply[U](_asJava.compose(asJavaFunction(mapper)))
  }

  def map[U](mapper: java.lang.Boolean => U): Future[U] = {
    Future.apply[U](_asJava.map(asJavaFunction(mapper)))
  }

  def completer(): io.vertx.core.AsyncResult [Boolean] => Unit = {
    if (cached_0 == null) {
      cached_0=    handlerToMappedFunction[io.vertx.core.AsyncResult[java.lang.Boolean], io.vertx.core.AsyncResult[Boolean]](s => if (s.failed()) io.vertx.lang.scala.ScalaAsyncResult(cause = s.cause()) else io.vertx.lang.scala.ScalaAsyncResult(result = s.result)) (_asJava.completer())
    }
    cached_0
  }

  /**
    * @return the type of the event
    */
  def `type`(): io.vertx.ext.web.handler.sockjs.BridgeEventType = {
    if (cached_1 == null) {
      cached_1=    _asJava.`type`()
    }
    cached_1
  }

  /**
    * Use [[io.vertx.scala.ext.web.handler.sockjs.BridgeEvent#getRawMessage]] instead, will be removed in 3.3
    */
  def rawMessage(): JsonObject = {
    if (cached_2 == null) {
      cached_2=    _asJava.rawMessage()
    }
    cached_2
  }

  /**
    * Get the raw JSON message for the event. This will be null for SOCKET_CREATED or SOCKET_CLOSED events as there is
    * no message involved. If the returned message is modified, [[io.vertx.scala.ext.web.handler.sockjs.BridgeEvent#setRawMessage]] should be called with the
    * new message.
    * @return the raw JSON message for the event
    */
  def getRawMessage(): JsonObject = {
    _asJava.getRawMessage()
  }

  /**
    * Get the raw JSON message for the event. This will be null for SOCKET_CREATED or SOCKET_CLOSED events as there is
    * no message involved.
    * @param message the raw message
    * @return this reference, so it can be used fluently
    */
  def setRawMessage(message: JsonObject): BridgeEvent = {
    _asJava.setRawMessage(message)
    this
  }

  /**
    * Get the SockJSSocket instance corresponding to the event
    * @return the SockJSSocket instance
    */
  def socket(): SockJSSocket = {
    if (cached_3 == null) {
      cached_3=    SockJSSocket.apply(_asJava.socket())
    }
    cached_3
  }

  private var cached_0: io.vertx.core.AsyncResult [Boolean] => Unit = _
  private var cached_1: io.vertx.ext.web.handler.sockjs.BridgeEventType = _
  private var cached_2: JsonObject = _
  private var cached_3: SockJSSocket = _
}

object BridgeEvent {

  def apply(_asJava: JBridgeEvent): BridgeEvent =
    new BridgeEvent(_asJava)

}
