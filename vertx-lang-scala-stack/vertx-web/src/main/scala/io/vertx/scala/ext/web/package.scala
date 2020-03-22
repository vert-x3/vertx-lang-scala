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


package io.vertx.scala.ext

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.web
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.auth.authorization.{Authorization => JAuthorization}
import io.vertx.ext.auth.authorization
import io.vertx.ext.web.handler.{AuthorizationHandler => JAuthorizationHandler}
import io.vertx.core.Handler
import io.vertx.ext.auth.authorization.{AuthorizationProvider => JAuthorizationProvider}
package object web{




















  type BridgeOptions = io.vertx.ext.web.handler.sockjs.BridgeOptions
  object BridgeOptions {
    def apply() = new BridgeOptions()
    def apply(json: JsonObject) = new BridgeOptions(json)
  }










  object ClusteredSessionStore {
    /**
     * Like create from [[io.vertx.ext.web.sstore.ClusteredSessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(vertx: io.vertx.core.Vertx,sessionMapName: java.lang.String) = {
      io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx, sessionMapName)
}
    /**
     * Like create from [[io.vertx.ext.web.sstore.ClusteredSessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(vertx: io.vertx.core.Vertx,sessionMapName: java.lang.String,retryTimeout: java.lang.Long) = {
      io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx, sessionMapName, retryTimeout)
}
    /**
     * Like create from [[io.vertx.ext.web.sstore.ClusteredSessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx)
}
    /**
     * Like create from [[io.vertx.ext.web.sstore.ClusteredSessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(vertx: io.vertx.core.Vertx,retryTimeout: java.lang.Long) = {
      io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx, retryTimeout)
}  }





















  type Http2PushMapping = io.vertx.ext.web.Http2PushMapping
  object Http2PushMapping {
    def apply() = new Http2PushMapping()
    def apply(json: JsonObject) = new Http2PushMapping(json)
  }










  object LocalSessionStore {
    /**
     * Like create from [[io.vertx.ext.web.sstore.LocalSessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.web.sstore.LocalSessionStore.create(vertx)
}
    /**
     * Like create from [[io.vertx.ext.web.sstore.LocalSessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(vertx: io.vertx.core.Vertx,sessionMapName: java.lang.String) = {
      io.vertx.ext.web.sstore.LocalSessionStore.create(vertx, sessionMapName)
}
    /**
     * Like create from [[io.vertx.ext.web.sstore.LocalSessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(vertx: io.vertx.core.Vertx,sessionMapName: java.lang.String,reaperInterval: java.lang.Long) = {
      io.vertx.ext.web.sstore.LocalSessionStore.create(vertx, sessionMapName, reaperInterval)
}  }




































  object Router {
    /**
     * Like router from [[io.vertx.ext.web.Router]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def router(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.web.Router.router(vertx)
}  }













  /**
    * A session store is used to store sessions for an Vert.x-Web web app
    */

  implicit class SessionStoreScala(val asJava: io.vertx.ext.web.sstore.SessionStore) extends AnyVal {


    /**
     * Like get from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getFuture(cookieValue: java.lang.String) : scala.concurrent.Future[io.vertx.ext.web.Session] = {
      val promise = concurrent.Promise[io.vertx.ext.web.Session]()
      asJava.get(cookieValue, new Handler[AsyncResult[io.vertx.ext.web.Session]] { override def handle(event: AsyncResult[io.vertx.ext.web.Session]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like delete from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def deleteFuture(id: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.delete(id, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like put from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def putFuture(session: io.vertx.ext.web.Session) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.put(session, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like clear from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def clearFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.clear(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like size from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def sizeFuture() : scala.concurrent.Future[java.lang.Integer] = {
      val promise = concurrent.Promise[java.lang.Integer]()
      asJava.size(new Handler[AsyncResult[java.lang.Integer]] { override def handle(event: AsyncResult[java.lang.Integer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }







  type SockJSHandlerOptions = io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions
  object SockJSHandlerOptions {
    def apply() = new SockJSHandlerOptions()
    def apply(json: JsonObject) = new SockJSHandlerOptions(json)
  }





  /**
    *
    * You interact with SockJS clients through instances of SockJS socket.
    * 
    * The API is very similar to [[io.vertx.core.http.WebSocket]].
    * It implements both  and 
    * so it can be used with
    * [[io.vertx.core.streams.Pump]] to pump data with flow control.
    */

  implicit class SockJSSocketScala(val asJava: io.vertx.ext.web.handler.sockjs.SockJSSocket) extends AnyVal {

def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      scala.Option(asJava.exceptionHandler(handler.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]))
}
def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      scala.Option(asJava.handler(handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]))
}
def endHandler(endHandler: scala.Option[Void => Unit]) = {
      scala.Option(asJava.endHandler(endHandler.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]))
}
def drainHandler(handler: scala.Option[Void => Unit]) = {
      scala.Option(asJava.drainHandler(handler.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]))
}
    /**
     * Like webSession from [[io.vertx.ext.web.handler.sockjs.SockJSSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def webSessionOption() = {
      scala.Option(asJava.webSession())
}
    /**
     * Like webUser from [[io.vertx.ext.web.handler.sockjs.SockJSSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def webUserOption() = {
      scala.Option(asJava.webUser())
}
def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def endFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.end(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def endFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.end(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def writeFuture(data: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.write(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def writeFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.write(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }





















}

