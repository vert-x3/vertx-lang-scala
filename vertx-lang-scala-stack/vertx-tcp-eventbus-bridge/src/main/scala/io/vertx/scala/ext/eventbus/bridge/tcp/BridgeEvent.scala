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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.bridge.{BaseBridgeEvent => JBaseBridgeEvent}
import scala.reflect.runtime.universe._
import io.vertx.ext.eventbus.bridge.tcp.{BridgeEvent => JBridgeEvent}
import io.vertx.scala.core.Future
import io.vertx.lang.scala.Converter._
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.scala.core.net.NetSocket
import io.vertx.scala.ext.bridge.BaseBridgeEvent
import io.vertx.core.{Future => JFuture}
import io.vertx.ext.bridge.BridgeEventType
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * Represents an event that occurs on the event bus bridge.
  * 
  * Please consult the documentation for a full explanation.
  */

class BridgeEvent(private val _asJava: Object) extends BaseBridgeEvent (_asJava) {

  private var cached_0: Option[Handler[AsyncResult[Boolean]]] = None
  private var cached_1: Option[NetSocket] = None



  override def completer(): Handler[AsyncResult[Boolean]] = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JBridgeEvent].completer()
      cached_0 = Some(if (tmp == null) null else {x: AsyncResult[Boolean] => tmp.handle(AsyncResultWrapper[Boolean, java.lang.Boolean](x, a => a.asInstanceOf[java.lang.Boolean]))})
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



  override 
  def setHandler(arg0: Handler[AsyncResult[Boolean]]): Future[Boolean] = {
    asJava.asInstanceOf[JBridgeEvent].setHandler((if (arg0 == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.Boolean]]{def handle(x: AsyncResult[java.lang.Boolean]) {arg0.handle(AsyncResultWrapper[java.lang.Boolean, Boolean](x, a => a.asInstanceOf[Boolean]))}}))
    this
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



  override def compose[U: TypeTag](handler: Handler[Boolean], next: Future[U]): Future[U] = {
    Future[U](asJava.asInstanceOf[JBridgeEvent].compose[Object]((if (handler == null) null else new io.vertx.core.Handler[java.lang.Boolean]{def handle(x: java.lang.Boolean) {handler.handle(x.asInstanceOf[Boolean])}}), next.asJava.asInstanceOf[JFuture[Object]]))
  }


  override def compose[U: TypeTag](mapper: Boolean => Future[U]): Future[U] = {
    Future[U](asJava.asInstanceOf[JBridgeEvent].compose[Object]({x: java.lang.Boolean => mapper(x.asInstanceOf[Boolean]).asJava.asInstanceOf[JFuture[Object]]}))
  }


  override def map[U: TypeTag](mapper: Boolean => U): Future[U] = {
    Future[U](asJava.asInstanceOf[JBridgeEvent].map[Object]({x: java.lang.Boolean => toJava[U](mapper(x.asInstanceOf[Boolean]))}))
  }


  override def recover(mapper: Throwable => Future[Boolean]): Future[Boolean] = {
    Future[Boolean](asJava.asInstanceOf[JBridgeEvent].recover({x: Throwable => mapper(x).asJava.asInstanceOf[JFuture[java.lang.Boolean]]}))
  }


  override def otherwise(mapper: Throwable => Boolean): Future[Boolean] = {
    Future[Boolean](asJava.asInstanceOf[JBridgeEvent].otherwise({x: Throwable => mapper(x).asInstanceOf[java.lang.Boolean]}))
  }


  override def otherwise(value: Boolean): Future[Boolean] = {
    Future[Boolean](asJava.asInstanceOf[JBridgeEvent].otherwise(value.asInstanceOf[java.lang.Boolean]))
  }


  override def otherwiseEmpty(): Future[Boolean] = {
    Future[Boolean](asJava.asInstanceOf[JBridgeEvent].otherwiseEmpty())
  }



  override def complete (arg0: Boolean): Unit = {
    asJava.asInstanceOf[JBridgeEvent].complete(arg0.asInstanceOf[java.lang.Boolean])
  }


  override def tryComplete (arg0: Boolean): Boolean = {
    asJava.asInstanceOf[JBridgeEvent].tryComplete(arg0.asInstanceOf[java.lang.Boolean]).asInstanceOf[Boolean]
  }


  override def result (): Boolean = {
    asJava.asInstanceOf[JBridgeEvent].result().asInstanceOf[Boolean]
  }



  override def setFuture (): scala.concurrent.Future[Boolean] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JBridgeEvent].setHandler(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object BridgeEvent {
  def apply(asJava: JBridgeEvent) = new BridgeEvent(asJava)
  
}
