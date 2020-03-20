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

import scala.collection.JavaConverters._
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
     * Create a session store     * @param vertx the Vert.x instance
     * @param sessionMapName the session map name
     * @return the session store
     */
    def create(vertx: io.vertx.core.Vertx,sessionMapName: java.lang.String) = {
      io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx, sessionMapName)
    }
    /**
     * Create a session store.<p/>
     *
     * The retry timeout value, configures how long the session handler will retry to get a session from the store
     * when it is not found.     * @param vertx the Vert.x instance
     * @param sessionMapName the session map name
     * @param retryTimeout the store retry timeout, in ms
     * @return the session store
     */
    def create(vertx: io.vertx.core.Vertx,sessionMapName: java.lang.String,retryTimeout: java.lang.Long) = {
      io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx, sessionMapName, retryTimeout)
    }
    /**
     * Create a session store     * @param vertx the Vert.x instance
     * @return the session store
     */
    def create(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx)
    }
    /**
     * Create a session store.<p/>
     *
     * The retry timeout value, configures how long the session handler will retry to get a session from the store
     * when it is not found.     * @param vertx the Vert.x instance
     * @param retryTimeout the store retry timeout, in ms
     * @return the session store
     */
    def create(vertx: io.vertx.core.Vertx,retryTimeout: java.lang.Long) = {
      io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx, retryTimeout)
    }
  }















  type Http2PushMapping = io.vertx.ext.web.Http2PushMapping
  object Http2PushMapping {
    def apply() = new Http2PushMapping()
    def apply(json: JsonObject) = new Http2PushMapping(json)
  }







  object LocalSessionStore {
    /**
     * Create a session store     * @param vertx the Vert.x instance
     * @return the session store
     */
    def create(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.web.sstore.LocalSessionStore.create(vertx)
    }
    /**
     * Create a session store     * @param vertx the Vert.x instance
     * @param sessionMapName name for map used to store sessions
     * @return the session store
     */
    def create(vertx: io.vertx.core.Vertx,sessionMapName: java.lang.String) = {
      io.vertx.ext.web.sstore.LocalSessionStore.create(vertx, sessionMapName)
    }
    /**
     * Create a session store     * @param vertx the Vert.x instance
     * @param sessionMapName name for map used to store sessions
     * @param reaperInterval how often, in ms, to check for expired sessions
     * @return the session store
     */
    def create(vertx: io.vertx.core.Vertx,sessionMapName: java.lang.String,reaperInterval: java.lang.Long) = {
      io.vertx.ext.web.sstore.LocalSessionStore.create(vertx, sessionMapName, reaperInterval)
    }
  }
























  object Router {
    /**
     * Create a router     * @param vertx the Vert.x instance
     * @return the router
     */
    def router(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.web.Router.router(vertx)
    }
  }









  /**
    * A session store is used to store sessions for an Vert.x-Web web app
    */

  implicit class SessionStoreScala(val asJava: io.vertx.ext.web.sstore.SessionStore) extends AnyVal {

    /**
     * Like get from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def getFuture(cookieValue: java.lang.String): scala.concurrent.Future[io.vertx.ext.web.Session] = {
      val promise = concurrent.Promise[io.vertx.ext.web.Session]()
      asJava.get(cookieValue, {a:AsyncResult[io.vertx.ext.web.Session] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like delete from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deleteFuture(id: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.delete(id, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like put from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def putFuture(session: io.vertx.ext.web.Session): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.put(session, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like clear from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def clearFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.clear({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like size from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def sizeFuture(): scala.concurrent.Future[java.lang.Integer] = {
      val promise = concurrent.Promise[java.lang.Integer]()
      asJava.size({a:AsyncResult[java.lang.Integer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }





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


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.ext.web.handler.sockjs.SockJSSocket = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): io.vertx.ext.web.handler.sockjs.SockJSSocket = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.core.buffer.Buffer => t(p); case None => null})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.ext.web.handler.sockjs.SockJSSocket = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }


    def drainHandler(handler: scala.Option[Void => Unit]): io.vertx.ext.web.handler.sockjs.SockJSSocket = {
      asJava.drainHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }


    /**
     * Like webSession from [[io.vertx.ext.web.handler.sockjs.SockJSSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def webSessionOption(): scala.Option[io.vertx.ext.web.Session] = {
      scala.Option(asJava.webSession())
    }


    /**
     * Like webUser from [[io.vertx.ext.web.handler.sockjs.SockJSSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def webUserOption(): scala.Option[io.vertx.ext.auth.User] = {
      scala.Option(asJava.webUser())
    }

    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def endFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.end({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def endFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.end(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def writeFuture(data: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.write(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def writeFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.write(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }














}
