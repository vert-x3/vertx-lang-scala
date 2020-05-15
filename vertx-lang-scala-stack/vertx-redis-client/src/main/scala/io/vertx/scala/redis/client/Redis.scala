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

package io.vertx.scala.redis.client

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.redis.client.{RedisOptions => JRedisOptions}
import io.vertx.redis.client.{Redis => JRedis}
import scala.reflect.runtime.universe._
import io.vertx.redis.client.{RedisConnection => JRedisConnection}
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.redis.client.{Request => JRequest}
import io.vertx.lang.scala.Converter._
import io.vertx.redis.client.{Response => JResponse}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * A simple Redis client.

  */

class Redis(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Connects to the redis server.   * @param handler the async result handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def connect(handler: Handler[AsyncResult[RedisConnection]]): Redis = {
    asJava.asInstanceOf[JRedis].connect((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRedisConnection]]{def handle(x: AsyncResult[JRedisConnection]) {handler.handle(AsyncResultWrapper[JRedisConnection, RedisConnection](x, a => RedisConnection(a)))}}))
    this
  }

  /**
   * Send the given command to the redis server or cluster.   * @param command the command to send
   * @param onSend the asynchronous result handler.
   * @return fluent self.
   */
  
  def send(command: Request, onSend: Handler[AsyncResult[scala.Option[Response]]]): Redis = {
    asJava.asInstanceOf[JRedis].send(command.asJava.asInstanceOf[JRequest], (if (onSend == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {onSend.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Sends a list of commands in a single IO operation, this prevents any inter twinning to happen from other
   * client users.   * @param commands list of command to send
   * @param onSend the asynchronous result handler.
   * @return fluent self.
   */
  
  def batch(commands: scala.collection.mutable.Buffer[Request], onSend: Handler[AsyncResult[scala.collection.mutable.Buffer[scala.Option[Response]]]]): Redis = {
    asJava.asInstanceOf[JRedis].batch(commands.map(x => x.asJava.asInstanceOf[JRequest]).asJava, (if (onSend == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JResponse]]]{def handle(x: AsyncResult[java.util.List[JResponse]]) {onSend.handle(AsyncResultWrapper[java.util.List[JResponse], scala.collection.mutable.Buffer[scala.Option[Response]]](x, a => a.asScala.map(x => scala.Option(x).map(Response(_)))))}}))
    this
  }



  /**
   * Closes the client and terminates any connection.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JRedis].close()
  }


 /**
  * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def connectFuture (): scala.concurrent.Future[RedisConnection] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRedisConnection, RedisConnection](x => RedisConnection(x))
    asJava.asInstanceOf[JRedis].connect(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendFuture (command: Request): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedis].send(command.asJava.asInstanceOf[JRequest], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[batch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def batchFuture (commands: scala.collection.mutable.Buffer[Request]): scala.concurrent.Future[scala.collection.mutable.Buffer[scala.Option[Response]]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JResponse], scala.collection.mutable.Buffer[scala.Option[Response]]](x => x.asScala.map(x => scala.Option(x).map(Response(_))))
    asJava.asInstanceOf[JRedis].batch(commands.map(x => x.asJava.asInstanceOf[JRequest]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object Redis {
  def apply(asJava: JRedis) = new Redis(asJava)

  /**
   * Create a new redis client using the default client options.   * @param vertx the vertx instance
   * @return the client
   */
  def createClient(vertx: Vertx): Redis = {
    Redis(JRedis.createClient(vertx.asJava.asInstanceOf[JVertx]))//2 createClient
  }

  /**
   * Create a new redis client using the default client options. Does not support rediss (redis over ssl scheme) for now.   * @param vertx the vertx instance
   * @param connectionString a string URI following the scheme: redis://[username:password@][host][:port][/database]
   * @return the client
   */
  def createClient(vertx: Vertx,connectionString: String): Redis = {
    Redis(JRedis.createClient(vertx.asJava.asInstanceOf[JVertx], connectionString.asInstanceOf[java.lang.String]))//2 createClient
  }

  /**
   * Create a new redis client using the given client options.   * @param vertx the vertx instance
   * @param options the user provided options see <a href="../../../../../../../cheatsheet/RedisOptions.html">RedisOptions</a>
   * @return the client
   */
  def createClient(vertx: Vertx,options: RedisOptions): Redis = {
    Redis(JRedis.createClient(vertx.asJava.asInstanceOf[JVertx], options.asJava))//2 createClient
  }

}
