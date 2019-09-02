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

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core.buffer.Buffer
import io.vertx.redis.client.{Command => JCommand}
import io.vertx.redis.client.{Request => JRequest}

package object redis{



  /**
    * A simple Redis client.

    */

  implicit class RedisScala(val asJava: io.vertx.redis.client.Redis) extends AnyVal {

    /**
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(): scala.concurrent.Future[io.vertx.redis.client.RedisConnection] = {
      val promise = Promise[io.vertx.redis.client.RedisConnection]()
      asJava.connect({a:AsyncResult[io.vertx.redis.client.RedisConnection] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  /**
    * <b>Auto generated</b> Redis API client wrapper.

    */

  implicit class RedisAPIScala(val asJava: io.vertx.redis.client.RedisAPI) extends AnyVal {

    /**
     * Like [[append]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def appendFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.append(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[asking]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def askingFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.asking({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[auth]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def authFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.auth(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bgrewriteaof]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bgrewriteaofFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bgrewriteaof({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bgsave]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bgsaveFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bgsave(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitcountFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bitcount(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitfield]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitfieldFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bitfield(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitopFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bitop(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitpos]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitposFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bitpos(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[blpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def blpopFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.blpop(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[brpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def brpopFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.brpop(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[brpoplpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def brpoplpushFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.brpoplpush(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bzpopmax]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bzpopmaxFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bzpopmax(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bzpopmin]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bzpopminFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bzpopmin(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[client]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.client(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[cluster]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.cluster(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[command]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.command({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[config]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.config(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[dbsize]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def dbsizeFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.dbsize({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[debug]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def debugFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.debug(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[decr]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def decrFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.decr(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[decrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def decrbyFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.decrby(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[del]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def delFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.del(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[discard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def discardFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.discard({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[dump]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def dumpFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.dump(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[echo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def echoFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.echo(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[eval]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def evalFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.eval(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[evalsha]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def evalshaFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.evalsha(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[exec]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def execFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.exec({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[exists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def existsFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.exists(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[expire]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def expireFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.expire(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[expireat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def expireatFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.expireat(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[flushall]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def flushallFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.flushall(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[flushdb]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def flushdbFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.flushdb(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geoadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoaddFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.geoadd(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geodist]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geodistFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.geodist(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geohash]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geohashFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.geohash(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geopos]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoposFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.geopos(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadius]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.georadius(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusRo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusRoFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.georadiusRo(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusbymember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusbymemberFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.georadiusbymember(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusbymemberRo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusbymemberRoFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.georadiusbymemberRo(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.get(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getbit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getbitFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.getbit(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getrangeFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.getrange(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getsetFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.getset(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hdel]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hdelFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hdel(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hexists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hexistsFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hexists(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hgetFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hget(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hgetall]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hgetallFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hgetall(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hincrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hincrbyFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hincrby(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hincrbyfloat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hincrbyfloatFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hincrbyfloat(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hkeys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hkeysFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hkeys(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hlenFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hlen(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hmget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hmgetFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hmget(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hmset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hmsetFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hmset(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[host]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hostFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.host(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hscanFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hscan(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hsetFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hset(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hsetnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hsetnxFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hsetnx(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hstrlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hstrlenFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hstrlen(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hvals]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hvalsFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hvals(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incr]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.incr(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrbyFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.incrby(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incrbyfloat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrbyfloatFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.incrbyfloat(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[info]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def infoFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.info(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[keys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def keysFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.keys(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lastsave]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lastsaveFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lastsave({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[latency]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def latencyFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.latency(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lindex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lindexFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lindex(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[linsert]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def linsertFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String,arg3: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.linsert(arg0, arg1, arg2, arg3, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[llen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def llenFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.llen(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lolwut]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lolwutFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lolwut(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpopFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lpop(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpushFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lpush(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpushx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpushxFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lpushx(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lrangeFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lrange(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lrem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lremFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lrem(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lsetFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lset(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ltrim]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def ltrimFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.ltrim(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[memory]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def memoryFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.memory(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mgetFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.mget(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[migrate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def migrateFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.migrate(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[module]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def moduleFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.module(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[monitor]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def monitorFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.monitor({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[move]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def moveFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.move(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def msetFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.mset(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[msetnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def msetnxFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.msetnx(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[multi]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def multiFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.multi({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[object]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def objectFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.`object`(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[persist]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def persistFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.persist(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pexpire]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pexpireFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pexpire(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pexpireat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pexpireatFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pexpireat(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfaddFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pfadd(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfcountFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pfcount(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfdebug]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfdebugFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pfdebug(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfmerge]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfmergeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pfmerge(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfselftest]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfselftestFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pfselftest({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ping]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pingFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.ping(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[post]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def postFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.post(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psetex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psetexFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.psetex(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psubscribeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.psubscribe(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psync]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psyncFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.psync(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pttl]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pttlFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pttl(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[publish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def publishFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.publish(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pubsub]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pubsubFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pubsub(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[punsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def punsubscribeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.punsubscribe(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[randomkey]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def randomkeyFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.randomkey({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[readonly]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def readonlyFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.readonly({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[readwrite]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def readwriteFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.readwrite({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rename]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def renameFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.rename(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[renamenx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def renamenxFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.renamenx(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[replconf]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replconfFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.replconf(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[replicaof]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replicaofFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.replicaof(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[restore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def restoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.restore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[restoreAsking]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def restoreAskingFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.restoreAsking(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[role]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def roleFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.role({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpopFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.rpop(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpoplpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpoplpushFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.rpoplpush(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpushFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.rpush(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpushx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpushxFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.rpushx(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saddFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sadd(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[save]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saveFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.save({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scanFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.scan(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scardFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.scard(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[script]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.script(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sdiff]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sdiffFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sdiff(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sdiffstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sdiffstoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sdiffstore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[select]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def selectFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.select(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[set]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.set(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setbit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setbitFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.setbit(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setexFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.setex(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setnxFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.setnx(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setrangeFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.setrange(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[shutdown]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def shutdownFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.shutdown(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sinter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sinterFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sinter(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sinterstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sinterstoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sinterstore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sismember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sismemberFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sismember(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slaveof]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slaveofFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.slaveof(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slowlog]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slowlogFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.slowlog(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[smembers]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def smembersFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.smembers(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[smove]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def smoveFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.smove(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sort]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sortFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sort(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[spop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def spopFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.spop(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[srandmember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def srandmemberFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.srandmember(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[srem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sremFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.srem(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sscanFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sscan(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[strlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def strlenFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.strlen(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def subscribeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.subscribe(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[substr]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def substrFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.substr(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sunion]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sunionFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sunion(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sunionstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sunionstoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sunionstore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[swapdb]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def swapdbFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.swapdb(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sync]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def syncFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sync({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[time]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def timeFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.time({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[touch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def touchFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.touch(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ttl]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def ttlFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.ttl(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[type]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def typeFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.`type`(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unlink]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlinkFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.unlink(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unsubscribeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.unsubscribe(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unwatch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unwatchFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.unwatch({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[wait]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def waitFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.wait(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[watch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def watchFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.watch(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[xack]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def xackFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xack(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[xadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def xaddFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xadd(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[xclaim]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def xclaimFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xclaim(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[xdel]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def xdelFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xdel(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[xgroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def xgroupFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xgroup(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[xinfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def xinfoFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xinfo(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[xlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def xlenFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xlen(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[xpending]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def xpendingFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xpending(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[xrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def xrangeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xrange(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[xread]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def xreadFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xread(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[xreadgroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def xreadgroupFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xreadgroup(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[xrevrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def xrevrangeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xrevrange(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[xsetid]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def xsetidFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xsetid(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[xtrim]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def xtrimFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xtrim(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zaddFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zadd(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zcard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zcardFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zcard(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zcountFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zcount(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zincrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zincrbyFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zincrby(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zinterstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zinterstoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zinterstore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zlexcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zlexcountFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zlexcount(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zpopmax]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zpopmaxFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zpopmax(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zpopmin]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zpopminFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zpopmin(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrange(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangebylexFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrangebylex(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangebyscoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrangebyscore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrankFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrank(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrem(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebylexFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zremrangebylex(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebyrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebyrankFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zremrangebyrank(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebyscoreFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zremrangebyscore(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrevrange(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangebylexFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrevrangebylex(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangebyscoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrevrangebyscore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrankFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrevrank(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zscanFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zscan(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zscoreFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zscore(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zunionstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zunionstoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zunionstore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  /**
    * A simple Redis client.

    */

  implicit class RedisConnectionScala(val asJava: io.vertx.redis.client.RedisConnection) extends AnyVal {


    /**
     * Like [[exceptionHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.redis.client.RedisConnection = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    /**
     * Like [[handler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def handler(handler: scala.Option[io.vertx.redis.client.Response => Unit]): io.vertx.redis.client.RedisConnection = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.redis.client.Response => t(p); case None => null})
    }


    /**
     * Like [[endHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.redis.client.RedisConnection = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }

    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.redis.client.Response]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture(command: io.vertx.redis.client.Request): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.send(command, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[batch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def batchFuture(commands: java.util.List[io.vertx.redis.client.Request]): scala.concurrent.Future[java.util.List[io.vertx.redis.client.Response]] = {
      val promise = Promise[java.util.List[io.vertx.redis.client.Response]]()
      asJava.batch(commands, {a:AsyncResult[java.util.List[io.vertx.redis.client.Response]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  type RedisOptions = io.vertx.redis.client.RedisOptions

  object RedisOptions {
    def apply() = new RedisOptions()
    def apply(json: JsonObject) = new RedisOptions(json)
  }




}
