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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.handler.sockjs.{SockJSHandler => JSockJSHandler}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.web.handler.sockjs.{SockJSHandlerOptions => JSockJSHandlerOptions}
import io.vertx.ext.web.handler.sockjs.{SockJSSocket => JSockJSSocket}
import io.vertx.ext.web.handler.sockjs.{BridgeOptions => JBridgeOptions}
import io.vertx.ext.web.handler.sockjs.{BridgeEvent => JBridgeEvent}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.scala.ext.web.Router
import io.vertx.core.Handler
import io.vertx.ext.web.{Router => JRouter}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  *
  * A handler that allows you to handle SockJS connections from clients.
  * 
  * We currently support version 0.3.3 of the SockJS protocol, which can be found in
  * <a href="https://github.com/sockjs/sockjs-protocol/tree/v0.3.3">this tag:</a>
  */
class SockJSHandler(private val _asJava: Object) 
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava = _asJava

  /**
    * Set a SockJS socket handler. This handler will be called with a SockJS socket whenever a SockJS connection
    * is made from a client
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def socketHandler(handler: Handler[SockJSSocket]):SockJSHandler = {
    asJava.asInstanceOf[JSockJSHandler].socketHandler({x: JSockJSSocket => handler.handle(SockJSSocket(x))})
    this
  }

  /**
    * Bridge the SockJS handler to the Vert.x event bus. This basically installs a built-in SockJS socket handler
    * which takes SockJS traffic and bridges it to the event bus, thus allowing you to extend the server-side
    * Vert.x event bus to browsers
    * @param bridgeOptions options to configure the bridge withsee <a href="../../../../../../../../../cheatsheet/BridgeOptions.html">BridgeOptions</a>
    * @return a reference to this, so the API can be used fluently
    */
  def bridge(bridgeOptions: BridgeOptions):SockJSHandler = {
    asJava.asInstanceOf[JSockJSHandler].bridge(bridgeOptions.asJava)
    this
  }

  /**
    * Like [[io.vertx.scala.ext.web.handler.sockjs.SockJSHandler#bridge]] but specifying a handler
    * that will receive bridge events.
    * @param bridgeOptions options to configure the bridge withsee <a href="../../../../../../../../../cheatsheet/BridgeOptions.html">BridgeOptions</a>
    * @param bridgeEventHandler handler to receive bridge events
    * @return a reference to this, so the API can be used fluently
    */
  def bridge(bridgeOptions: BridgeOptions,bridgeEventHandler: Handler[BridgeEvent]):SockJSHandler = {
    asJava.asInstanceOf[JSockJSHandler].bridge(bridgeOptions.asJava,{x: JBridgeEvent => bridgeEventHandler.handle(BridgeEvent(x))})
    this
  }

  override def handle(arg0: RoutingContext):Unit = {
    asJava.asInstanceOf[JSockJSHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object SockJSHandler{
  def apply(asJava: JSockJSHandler) = new SockJSHandler(asJava)  
  /**
    * Create a SockJS handler
    * @param vertx the Vert.x instance
    * @return the handler
    */
  def create(vertx: Vertx):SockJSHandler = {
    SockJSHandler(JSockJSHandler.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Create a SockJS handler
    * @param vertx the Vert.x instance
    * @param options options to configure the handlersee <a href="../../../../../../../../../cheatsheet/SockJSHandlerOptions.html">SockJSHandlerOptions</a>
    * @return the handler
    */
  def create(vertx: Vertx,options: SockJSHandlerOptions):SockJSHandler = {
    SockJSHandler(JSockJSHandler.create(vertx.asJava.asInstanceOf[JVertx],options.asJava))
  }

  /**
    * Install SockJS test applications on a router - used when running the SockJS test suite
    * @param router the router to install on
    * @param vertx the Vert.x instance
    */
  def installTestApplications(router: Router,vertx: Vertx):Unit = {
    JSockJSHandler.installTestApplications(router.asJava.asInstanceOf[JRouter],vertx.asJava.asInstanceOf[JVertx])
  }

}
