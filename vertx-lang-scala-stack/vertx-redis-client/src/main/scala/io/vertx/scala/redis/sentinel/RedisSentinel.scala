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

package io.vertx.scala.redis.sentinel

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.json.JsonArray
import scala.reflect.runtime.universe._
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.redis.sentinel.{RedisSentinel => JRedisSentinel}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Interface for sentinel commands

  */

class RedisSentinel(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Show a list of monitored masters and their state   * @param handler Handler for the result of this call
   */
  
  def masters(handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): RedisSentinel = {
    asJava.asInstanceOf[JRedisSentinel].masters((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JsonArray]]{def handle(x: AsyncResult[JsonArray]) {handler.handle(AsyncResultWrapper[JsonArray, io.vertx.core.json.JsonArray](x, a => a))}}))
    this
  }

  /**
   * Show the state and info of the specified master   * @param name master name
   * @param handler Handler for the result of this call
   */
  
  def master(name: String, handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): RedisSentinel = {
    asJava.asInstanceOf[JRedisSentinel].master(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JsonArray]]{def handle(x: AsyncResult[JsonArray]) {handler.handle(AsyncResultWrapper[JsonArray, io.vertx.core.json.JsonArray](x, a => a))}}))
    this
  }

  /**
   * Show a list of slaves for this master, and their state   * @param name master name
   * @param handler Handler for the result of this call
   */
  
  def slaves(name: String, handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): RedisSentinel = {
    asJava.asInstanceOf[JRedisSentinel].slaves(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JsonArray]]{def handle(x: AsyncResult[JsonArray]) {handler.handle(AsyncResultWrapper[JsonArray, io.vertx.core.json.JsonArray](x, a => a))}}))
    this
  }

  /**
   * Show a list of sentinel instances for this master, and their state   * @param name master name
   * @param handler Handler for the result of this call
   */
  
  def sentinels(name: String, handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): RedisSentinel = {
    asJava.asInstanceOf[JRedisSentinel].sentinels(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JsonArray]]{def handle(x: AsyncResult[JsonArray]) {handler.handle(AsyncResultWrapper[JsonArray, io.vertx.core.json.JsonArray](x, a => a))}}))
    this
  }

  /**
   * Return the ip and port number of the master with that name.
   * If a failover is in progress or terminated successfully for this master
   * it returns the address and port of the promoted slave   * @param name master name
   * @param handler Handler for the result of this call
   */
  
  def getMasterAddrByName(name: String, handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): RedisSentinel = {
    asJava.asInstanceOf[JRedisSentinel].getMasterAddrByName(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JsonArray]]{def handle(x: AsyncResult[JsonArray]) {handler.handle(AsyncResultWrapper[JsonArray, io.vertx.core.json.JsonArray](x, a => a))}}))
    this
  }

  /**
   * Reset all the masters with matching name.
   * The pattern argument is a glob-style pattern.
   * The reset process clears any previous state in a master (including a failover in pro   * @param pattern pattern String
   * @param handler Handler for the result of this call
   */
  
  def reset(pattern: String, handler: Handler[AsyncResult[Unit]]): RedisSentinel = {
    asJava.asInstanceOf[JRedisSentinel].reset(pattern.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Force a failover as if the master was not reachable, and without asking for agreement to other Sentinels
   * (however a new version of the configuration will be published so that the other Sentinels
   * will update their configurations)   * @param name master name
   * @param handler Handler for the result of this call
   */
  
  def failover(name: String, handler: Handler[AsyncResult[String]]): RedisSentinel = {
    asJava.asInstanceOf[JRedisSentinel].failover(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {handler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }

  /**
   * Check if the current Sentinel configuration is able to reach the quorum needed to failover a master,
   * and the majority needed to authorize the failover. This command should be used in monitoring systems
   * to check if a Sentinel deployment is ok.   * @param name master name
   * @param handler Handler for the result of this call
   */
  
  def ckquorum(name: String, handler: Handler[AsyncResult[String]]): RedisSentinel = {
    asJava.asInstanceOf[JRedisSentinel].ckquorum(name.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {handler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }

  /**
   * Force Sentinel to rewrite its configuration on disk, including the current Sentinel state.
   * Normally Sentinel rewrites the configuration every time something changes in its state
   * (in the context of the subset of the state which is persisted on disk across restart).
   * However sometimes it is possible that the configuration file is lost because of operation errors,
   * disk failures, package upgrade scripts or configuration managers. In those cases a way to to force Sentinel to
   * rewrite the configuration file is handy. This command works even if the previous configuration file
   * is completely missing.   * @param handler Handler for the result of this call
   */
  
  def flushConfig(handler: Handler[AsyncResult[Unit]]): RedisSentinel = {
    asJava.asInstanceOf[JRedisSentinel].flushConfig((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }



  /**
   * Close the client - when it is fully closed the handler will be called.   */
  def close (handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRedisSentinel].close((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisSentinel].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[masters]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def mastersFuture (): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisSentinel].masters(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[master]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def masterFuture (name: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisSentinel].master(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[slaves]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def slavesFuture (name: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisSentinel].slaves(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sentinels]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sentinelsFuture (name: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisSentinel].sentinels(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getMasterAddrByName]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getMasterAddrByNameFuture (name: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisSentinel].getMasterAddrByName(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[reset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def resetFuture (pattern: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisSentinel].reset(pattern.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[failover]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def failoverFuture (name: String): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisSentinel].failover(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[ckquorum]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def ckquorumFuture (name: String): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisSentinel].ckquorum(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[flushConfig]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def flushConfigFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisSentinel].flushConfig(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object RedisSentinel {
  def apply(asJava: JRedisSentinel) = new RedisSentinel(asJava)
  

  def create(vertx: Vertx): RedisSentinel = {
    RedisSentinel(JRedisSentinel.create(vertx.asJava.asInstanceOf[JVertx]))
  }


  def create(vertx: Vertx,config: io.vertx.core.json.JsonObject): RedisSentinel = {
    RedisSentinel(JRedisSentinel.create(vertx.asJava.asInstanceOf[JVertx], config))
  }

}
