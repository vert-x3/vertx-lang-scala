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

package io.vertx.scala

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core.buffer.Buffer
import io.vertx.redis.client.{Command => JCommand}
import io.vertx.redis.client.{Request => JRequest}

package object redis{

  object Command {
    /**
     * Creates a Redis Command from METADATA. The metadata comes from the REDIS command "COMMAND"
     * https://redis.io/commands/command
     *
     * Each top-level result contains six nested results. Each nested result is:
     *
     *     command name
     *     command arity specification
     *     nested Array reply of command flags
     *     position of first key in argument list
     *     position of last key in argument list
     *     step count for locating repeating keys     * @param command command name
     * @param arity arity
     * @param firstKey position of the first key
     * @param lastKey position of the last key
     * @param interval step count for locating repeating keys
     * @param readOnly readOnly flag extracted from the nested Array reply of command flags
     * @param movable movable flag extracted from the nested Array reply of command flags
     * @return a command instance
     */
def create(command: java.lang.String,arity: java.lang.Integer,firstKey: java.lang.Integer,lastKey: java.lang.Integer,interval: java.lang.Integer,readOnly: java.lang.Boolean,movable: java.lang.Boolean) = {
      io.vertx.redis.client.Command.create(command, arity, firstKey, lastKey, interval, readOnly, movable)
}
  }



  /**
    * A simple Redis client.

    */

  implicit class RedisScala(val asJava: io.vertx.redis.client.Redis) extends AnyVal {

    /**
     * Like connect from [[io.vertx.redis.client.Redis]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def connectFuture() : scala.concurrent.Future[io.vertx.redis.client.RedisConnection] = {
      val promise = concurrent.Promise[io.vertx.redis.client.RedisConnection]()
      asJava.connect(new Handler[AsyncResult[io.vertx.redis.client.RedisConnection]] { override def handle(event: AsyncResult[io.vertx.redis.client.RedisConnection]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like send from [[io.vertx.redis.client.Redis]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def sendFuture(command: io.vertx.redis.client.Request) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.send(command, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like batch from [[io.vertx.redis.client.Redis]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def batchFuture(commands: java.util.List[io.vertx.redis.client.Request]) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.redis.client.Response]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.redis.client.Response]]()
      asJava.batch(commands, new Handler[AsyncResult[java.util.List[io.vertx.redis.client.Response]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.redis.client.Response]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}

  }



  /**
    * <b>Auto generated</b> Redis API client wrapper.

    */

  implicit class RedisAPIScala(val asJava: io.vertx.redis.client.RedisAPI) extends AnyVal {

    /**
     * Like append from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def appendFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.append(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like asking from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def askingFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.asking(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like auth from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def authFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.auth(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like bgrewriteaof from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def bgrewriteaofFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.bgrewriteaof(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like bgsave from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def bgsaveFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.bgsave(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like bitcount from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def bitcountFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.bitcount(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like bitfield from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def bitfieldFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.bitfield(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like bitop from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def bitopFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.bitop(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like bitpos from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def bitposFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.bitpos(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like blpop from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def blpopFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.blpop(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like brpop from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def brpopFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.brpop(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like brpoplpush from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def brpoplpushFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.brpoplpush(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like bzpopmax from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def bzpopmaxFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.bzpopmax(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like bzpopmin from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def bzpopminFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.bzpopmin(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like client from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def clientFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.client(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like cluster from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def clusterFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.cluster(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like command from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def commandFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.command(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like config from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def configFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.config(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like dbsize from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def dbsizeFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.dbsize(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like debug from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def debugFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.debug(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like decr from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def decrFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.decr(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like decrby from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def decrbyFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.decrby(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like del from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def delFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.del(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like discard from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def discardFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.discard(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like dump from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def dumpFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.dump(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like echo from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def echoFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.echo(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like eval from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def evalFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.eval(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like evalsha from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def evalshaFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.evalsha(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like exec from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def execFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.exec(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like exists from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def existsFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.exists(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like expire from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def expireFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.expire(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like expireat from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def expireatFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.expireat(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like flushall from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def flushallFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.flushall(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like flushdb from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def flushdbFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.flushdb(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like geoadd from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def geoaddFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.geoadd(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like geodist from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def geodistFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.geodist(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like geohash from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def geohashFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.geohash(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like geopos from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def geoposFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.geopos(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like georadius from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def georadiusFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.georadius(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like georadiusRo from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def georadiusRoFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.georadiusRo(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like georadiusbymember from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def georadiusbymemberFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.georadiusbymember(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like georadiusbymemberRo from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def georadiusbymemberRoFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.georadiusbymemberRo(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like get from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.get(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like getbit from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getbitFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.getbit(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like getrange from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getrangeFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.getrange(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like getset from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getsetFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.getset(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hdel from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hdelFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hdel(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hexists from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hexistsFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hexists(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hget from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hgetFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hget(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hgetall from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hgetallFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hgetall(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hincrby from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hincrbyFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hincrby(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hincrbyfloat from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hincrbyfloatFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hincrbyfloat(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hkeys from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hkeysFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hkeys(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hlen from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hlenFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hlen(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hmget from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hmgetFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hmget(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hmset from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hmsetFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hmset(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like host from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hostFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.host(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hscan from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hscanFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hscan(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hset from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hsetFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hset(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hsetnx from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hsetnxFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hsetnx(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hstrlen from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hstrlenFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hstrlen(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like hvals from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def hvalsFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.hvals(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like incr from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def incrFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.incr(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like incrby from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def incrbyFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.incrby(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like incrbyfloat from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def incrbyfloatFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.incrbyfloat(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like info from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def infoFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.info(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like keys from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def keysFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.keys(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like lastsave from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def lastsaveFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.lastsave(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like latency from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def latencyFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.latency(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like lindex from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def lindexFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.lindex(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like linsert from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def linsertFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String,arg3: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.linsert(arg0, arg1, arg2, arg3, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like llen from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def llenFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.llen(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like lolwut from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def lolwutFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.lolwut(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like lpop from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def lpopFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.lpop(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like lpush from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def lpushFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.lpush(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like lpushx from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def lpushxFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.lpushx(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like lrange from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def lrangeFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.lrange(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like lrem from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def lremFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.lrem(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like lset from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def lsetFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.lset(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like ltrim from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def ltrimFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.ltrim(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like memory from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def memoryFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.memory(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like mget from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def mgetFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.mget(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like migrate from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def migrateFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.migrate(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like module from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def moduleFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.module(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like monitor from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def monitorFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.monitor(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like move from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def moveFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.move(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like mset from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def msetFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.mset(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like msetnx from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def msetnxFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.msetnx(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like multi from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def multiFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.multi(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like object from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def objectFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.`object`(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like persist from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def persistFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.persist(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like pexpire from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def pexpireFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.pexpire(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like pexpireat from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def pexpireatFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.pexpireat(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like pfadd from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def pfaddFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.pfadd(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like pfcount from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def pfcountFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.pfcount(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like pfdebug from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def pfdebugFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.pfdebug(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like pfmerge from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def pfmergeFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.pfmerge(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like pfselftest from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def pfselftestFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.pfselftest(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like ping from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def pingFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.ping(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like post from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def postFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.post(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like psetex from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def psetexFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.psetex(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like psubscribe from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def psubscribeFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.psubscribe(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like psync from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def psyncFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.psync(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like pttl from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def pttlFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.pttl(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like publish from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def publishFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.publish(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like pubsub from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def pubsubFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.pubsub(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like punsubscribe from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def punsubscribeFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.punsubscribe(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like randomkey from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def randomkeyFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.randomkey(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like readonly from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def readonlyFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.readonly(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like readwrite from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def readwriteFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.readwrite(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like rename from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def renameFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.rename(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like renamenx from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def renamenxFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.renamenx(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like replconf from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def replconfFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.replconf(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like replicaof from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def replicaofFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.replicaof(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like restore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def restoreFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.restore(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like restoreAsking from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def restoreAskingFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.restoreAsking(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like role from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def roleFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.role(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like rpop from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def rpopFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.rpop(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like rpoplpush from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def rpoplpushFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.rpoplpush(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like rpush from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def rpushFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.rpush(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like rpushx from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def rpushxFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.rpushx(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sadd from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def saddFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.sadd(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like save from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def saveFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.save(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like scan from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def scanFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.scan(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like scard from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def scardFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.scard(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like script from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def scriptFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.script(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sdiff from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def sdiffFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.sdiff(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sdiffstore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def sdiffstoreFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.sdiffstore(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like select from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def selectFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.select(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like set from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def setFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.set(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like setbit from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def setbitFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.setbit(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like setex from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def setexFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.setex(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like setnx from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def setnxFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.setnx(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like setrange from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def setrangeFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.setrange(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like shutdown from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def shutdownFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.shutdown(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sinter from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def sinterFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.sinter(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sinterstore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def sinterstoreFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.sinterstore(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sismember from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def sismemberFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.sismember(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like slaveof from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def slaveofFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.slaveof(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like slowlog from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def slowlogFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.slowlog(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like smembers from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def smembersFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.smembers(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like smove from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def smoveFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.smove(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sort from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def sortFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.sort(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like spop from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def spopFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.spop(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like srandmember from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def srandmemberFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.srandmember(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like srem from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def sremFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.srem(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sscan from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def sscanFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.sscan(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like strlen from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def strlenFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.strlen(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like subscribe from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def subscribeFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.subscribe(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like substr from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def substrFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.substr(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sunion from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def sunionFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.sunion(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sunionstore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def sunionstoreFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.sunionstore(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like swapdb from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def swapdbFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.swapdb(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like sync from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def syncFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.sync(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like time from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def timeFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.time(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like touch from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def touchFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.touch(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like ttl from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def ttlFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.ttl(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like type from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def typeFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.`type`(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like unlink from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def unlinkFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.unlink(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like unsubscribe from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def unsubscribeFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.unsubscribe(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like unwatch from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def unwatchFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.unwatch(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like wait from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def waitFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.wait(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like watch from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def watchFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.watch(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like xack from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def xackFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.xack(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like xadd from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def xaddFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.xadd(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like xclaim from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def xclaimFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.xclaim(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like xdel from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def xdelFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.xdel(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like xgroup from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def xgroupFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.xgroup(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like xinfo from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def xinfoFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.xinfo(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like xlen from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def xlenFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.xlen(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like xpending from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def xpendingFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.xpending(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like xrange from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def xrangeFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.xrange(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like xread from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def xreadFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.xread(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like xreadgroup from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def xreadgroupFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.xreadgroup(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like xrevrange from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def xrevrangeFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.xrevrange(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like xsetid from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def xsetidFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.xsetid(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like xtrim from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def xtrimFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.xtrim(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zadd from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zaddFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zadd(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zcard from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zcardFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zcard(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zcount from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zcountFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zcount(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zincrby from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zincrbyFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zincrby(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zinterstore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zinterstoreFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zinterstore(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zlexcount from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zlexcountFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zlexcount(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zpopmax from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zpopmaxFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zpopmax(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zpopmin from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zpopminFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zpopmin(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zrange from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zrangeFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zrange(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zrangebylex from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zrangebylexFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zrangebylex(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zrangebyscore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zrangebyscoreFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zrangebyscore(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zrank from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zrankFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zrank(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zrem from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zremFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zrem(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zremrangebylex from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zremrangebylexFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zremrangebylex(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zremrangebyrank from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zremrangebyrankFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zremrangebyrank(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zremrangebyscore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zremrangebyscoreFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zremrangebyscore(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zrevrange from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zrevrangeFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zrevrange(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zrevrangebylex from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zrevrangebylexFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zrevrangebylex(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zrevrangebyscore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zrevrangebyscoreFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zrevrangebyscore(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zrevrank from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zrevrankFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zrevrank(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zscan from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zscanFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zscan(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zscore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zscoreFuture(arg0: java.lang.String,arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zscore(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like zunionstore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def zunionstoreFuture(args: java.util.List[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.zunionstore(args, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }



  /**
    * A simple Redis client.

    */

  implicit class RedisConnectionScala(val asJava: io.vertx.redis.client.RedisConnection) extends AnyVal {


    /**
     * Like exceptionHandler from [[io.vertx.redis.client.RedisConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      scala.Option(asJava.exceptionHandler(handler.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]))
}


    /**
     * Like handler from [[io.vertx.redis.client.RedisConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def handler(handler: scala.Option[io.vertx.redis.client.Response => Unit]) = {
      scala.Option(asJava.handler(handler.asInstanceOf[io.vertx.core.Handler[io.vertx.redis.client.Response]]))
}


    /**
     * Like endHandler from [[io.vertx.redis.client.RedisConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def endHandler(endHandler: scala.Option[Void => Unit]) = {
      scala.Option(asJava.endHandler(endHandler.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]))
}

def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.redis.client.Response]) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like send from [[io.vertx.redis.client.RedisConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def sendFuture(command: io.vertx.redis.client.Request) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]()
      asJava.send(command, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like batch from [[io.vertx.redis.client.RedisConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def batchFuture(commands: java.util.List[io.vertx.redis.client.Request]) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.redis.client.Response]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.redis.client.Response]]()
      asJava.batch(commands, new Handler[AsyncResult[java.util.List[io.vertx.redis.client.Response]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.redis.client.Response]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}

  }



  type RedisOptions = io.vertx.redis.client.RedisOptions
  object RedisOptions {
    def apply() = new RedisOptions()
    def apply(json: JsonObject) = new RedisOptions(json)
  }



  object Request {
def cmd(command: io.vertx.redis.client.Command) = {
      io.vertx.redis.client.Request.cmd(command)
}
  }




}
