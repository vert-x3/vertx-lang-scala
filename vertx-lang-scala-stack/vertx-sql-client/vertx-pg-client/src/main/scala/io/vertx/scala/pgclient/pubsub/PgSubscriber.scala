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

package io.vertx.scala.pgclient.pubsub

import io.vertx.lang.scala.AsyncResultWrapper
import scala.reflect.runtime.universe._
import io.vertx.pgclient.{PgConnection => JPgConnection}
import io.vertx.scala.pgclient.PgConnection
import io.vertx.scala.core.Vertx
import io.vertx.pgclient.pubsub.{PgChannel => JPgChannel}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.Converter._
import io.vertx.pgclient.pubsub.{PgSubscriber => JPgSubscriber}
import io.vertx.scala.pgclient.PgConnectOptions
import io.vertx.pgclient.{PgConnectOptions => JPgConnectOptions}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * A class for managing subscriptions using `LISTEN/UNLISTEN` to Postgres channels.
  * <p/>
  * The subscriber manages a single connection to Postgres.

  */

class PgSubscriber(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Connect the subscriber to Postgres.   * @param handler the handler notified of the connection success or failure
   * @return a reference to this, so the API can be used fluently
   */
  
  def connect(handler: Handler[AsyncResult[Unit]]): PgSubscriber = {
    asJava.asInstanceOf[JPgSubscriber].connect((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Set the reconnect policy that is executed when the subscriber is disconnected.
   * <p/>
   * When the subscriber is disconnected, the `policy` function is called with the actual
   * number of retries and returns an `amountOfTime` value:
   * <ul>
   *   <li>when `amountOfTime < 0`: the subscriber is closed and there is no retry</li>
   *   <li>when `amountOfTime == 0`: the subscriber retries to connect immediately</li>
   *   <li>when `amountOfTime > 0`: the subscriber retries after `amountOfTime` milliseconds</li>
   * </ul>
   * <p/>
   * The default policy does not perform any retries.   * @param policy the policy to set
   * @return a reference to this, so the API can be used fluently
   */
  
  def reconnectPolicy(policy: Int => Long): PgSubscriber = {
    asJava.asInstanceOf[JPgSubscriber].reconnectPolicy({x: java.lang.Integer => policy(x.asInstanceOf[Int]).asInstanceOf[java.lang.Long]})
    this
  }

  /**
   * Set an handler called when the subscriber is closed.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def closeHandler(handler: Handler[Unit]): PgSubscriber = {
    asJava.asInstanceOf[JPgSubscriber].closeHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }



  /**
   * Return a channel for the given `name`.   * @param name the channel name <p/> This will be the name of the channel exactly as held by Postgres for sending notifications. Internally this name will be truncated to the Postgres identifier maxiumum length of `(NAMEDATALEN = 64) - 1 == 63` characters, and prepared as a quoted identifier without unicode escape sequence support for use in `LISTEN/UNLISTEN` commands. Examples of channel names and corresponding `NOTIFY` commands: <ul> <li>when `name == "the_channel"`: `NOTIFY the_channel, 'msg'`, `NOTIFY The_Channel, 'msg'`, or `NOTIFY "the_channel", 'msg'` succeed in delivering a message to the created channel </li> <li>when `name == "The_Channel"`: `NOTIFY "The_Channel", 'msg'`, succeeds in delivering a message to the created channel </li> <li></li> </ul>
   * @return the channel
   */
  def channel (name: String): PgChannel = {
    PgChannel(asJava.asInstanceOf[JPgSubscriber].channel(name.asInstanceOf[java.lang.String]))
  }

  /**
   * @return the actual connection to Postgres, it might be `null`
   */
  def actualConnection (): PgConnection = {
    PgConnection(asJava.asInstanceOf[JPgSubscriber].actualConnection())
  }

  /**
   * @return whether the subscriber is closed
   */
  def closed (): Boolean = {
    asJava.asInstanceOf[JPgSubscriber].closed().asInstanceOf[Boolean]
  }

  /**
   * Close the subscriber, the retry policy will not be invoked.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JPgSubscriber].close()
  }


 /**
  * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def connectFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JPgSubscriber].connect(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object PgSubscriber {
  def apply(asJava: JPgSubscriber) = new PgSubscriber(asJava)
  
  /**
   * Create a subscriber.   * @param vertx the vertx instance
   * @param options the connect options see <a href="../../../../../../../cheatsheet/PgConnectOptions.html">PgConnectOptions</a>
   * @return the subscriber
   */
  def subscriber(vertx: Vertx,options: PgConnectOptions): PgSubscriber = {
    PgSubscriber(JPgSubscriber.subscriber(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

}
