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


  type BitFieldGetCommand = io.vertx.redis.op.BitFieldGetCommand

  object BitFieldGetCommand {
    def apply() = new BitFieldGetCommand()
    def apply(json: JsonObject) = new BitFieldGetCommand(json)
  }



  type BitFieldIncrbyCommand = io.vertx.redis.op.BitFieldIncrbyCommand

  object BitFieldIncrbyCommand {
    def apply() = new BitFieldIncrbyCommand()
    def apply(json: JsonObject) = new BitFieldIncrbyCommand(json)
  }



  type BitFieldOptions = io.vertx.redis.op.BitFieldOptions

  object BitFieldOptions {
    def apply() = new BitFieldOptions()
    def apply(json: JsonObject) = new BitFieldOptions(json)
  }



  type BitFieldSetCommand = io.vertx.redis.op.BitFieldSetCommand

  object BitFieldSetCommand {
    def apply() = new BitFieldSetCommand()
    def apply(json: JsonObject) = new BitFieldSetCommand(json)
  }




  type GeoMember = io.vertx.redis.op.GeoMember

  object GeoMember {
    def apply() = new GeoMember()
    def apply(json: JsonObject) = new GeoMember(json)
  }



  type GeoRadiusOptions = io.vertx.redis.op.GeoRadiusOptions

  object GeoRadiusOptions {
    def apply() = new GeoRadiusOptions()
    def apply(json: JsonObject) = new GeoRadiusOptions(json)
  }



  type KillFilter = io.vertx.redis.op.KillFilter

  object KillFilter {
    def apply() = new KillFilter()
    def apply(json: JsonObject) = new KillFilter(json)
  }



  type LimitOptions = io.vertx.redis.op.LimitOptions

  object LimitOptions {
    def apply() = new LimitOptions()
    def apply(json: JsonObject) = new LimitOptions(json)
  }



  type MigrateOptions = io.vertx.redis.op.MigrateOptions

  object MigrateOptions {
    def apply() = new MigrateOptions()
    def apply(json: JsonObject) = new MigrateOptions(json)
  }



  type RangeLimitOptions = io.vertx.redis.op.RangeLimitOptions

  object RangeLimitOptions {
    def apply() = new RangeLimitOptions()
    def apply(json: JsonObject) = new RangeLimitOptions(json)
  }



  /**
    * A simple Redis client.

    */

  implicit class RedisScala(val asJava: io.vertx.redis.client.Redis) extends AnyVal {


    /**
     * Like [[exceptionHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.redis.client.Redis = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    /**
     * Like [[handler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def handler(handler: scala.Option[io.vertx.redis.client.Response => Unit]): io.vertx.redis.client.Redis = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.redis.client.Response => t(p); case None => null})
    }


    /**
     * Like [[endHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.redis.client.Redis = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }

    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.redis.client.Response]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def connectFuture(): scala.concurrent.Future[io.vertx.redis.client.Redis] = {
      val promise = Promise[io.vertx.redis.client.Redis]()
      asJava.connect({a:AsyncResult[io.vertx.redis.client.Redis] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def sendFuture(command: io.vertx.redis.client.Request): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.send(command, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def batchFuture(commands: java.util.List[io.vertx.redis.client.Request]): scala.concurrent.Future[java.util.List[io.vertx.redis.client.Response]] = {
      val promise = Promise[java.util.List[io.vertx.redis.client.Response]]()
      asJava.batch(commands, {a:AsyncResult[java.util.List[io.vertx.redis.client.Response]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  /**
    * <b>Auto generated</b> Redis API client wrapper.

    */

  implicit class RedisAPIScala(val asJava: io.vertx.redis.client.RedisAPI) extends AnyVal {

    def appendFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.append(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def askingFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.asking({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def authFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.auth(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def bgrewriteaofFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bgrewriteaof({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def bgsaveFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bgsave(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def bitcountFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bitcount(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def bitfieldFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bitfield(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def bitopFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bitop(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def bitposFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bitpos(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def blpopFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.blpop(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def brpopFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.brpop(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def brpoplpushFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.brpoplpush(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def bzpopmaxFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bzpopmax(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def bzpopminFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.bzpopmin(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def clientFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.client(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def clusterFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.cluster(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def commandFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.command(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def configFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.config(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def dbsizeFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.dbsize({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def debugFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.debug(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def decrFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.decr(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def decrbyFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.decrby(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def delFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.del(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def discardFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.discard({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def dumpFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.dump(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def echoFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.echo(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def evalFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.eval(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def evalshaFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.evalsha(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def execFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.exec({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def existsFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.exists(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def expireFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.expire(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def expireatFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.expireat(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def flushallFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.flushall(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def flushdbFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.flushdb(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def geoaddFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.geoadd(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def geodistFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.geodist(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def geohashFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.geohash(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def geoposFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.geopos(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def georadiusFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.georadius(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def georadiusRoFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.georadiusRo(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def georadiusbymemberFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.georadiusbymember(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def georadiusbymemberRoFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.georadiusbymemberRo(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def getFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.get(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def getbitFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.getbit(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def getrangeFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.getrange(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def getsetFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.getset(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hdelFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hdel(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hexistsFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hexists(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hgetFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hget(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hgetallFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hgetall(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hincrbyFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hincrby(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hincrbyfloatFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hincrbyfloat(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hkeysFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hkeys(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hlenFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hlen(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hmgetFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hmget(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hmsetFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hmset(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hostFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.host(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hscanFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hscan(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hsetFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hset(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hsetnxFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hsetnx(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hstrlenFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hstrlen(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def hvalsFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.hvals(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def incrFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.incr(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def incrbyFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.incrby(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def incrbyfloatFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.incrbyfloat(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def infoFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.info(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def keysFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.keys(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def lastsaveFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lastsave({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def latencyFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.latency(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def lindexFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lindex(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def linsertFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String,arg3: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.linsert(arg0, arg1, arg2, arg3, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def llenFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.llen(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def lolwutFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lolwut(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def lpopFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lpop(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def lpushFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lpush(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def lpushxFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lpushx(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def lrangeFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lrange(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def lremFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lrem(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def lsetFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.lset(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def ltrimFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.ltrim(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def memoryFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.memory(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def mgetFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.mget(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def migrateFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.migrate(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def moduleFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.module(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def monitorFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.monitor({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def moveFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.move(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def msetFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.mset(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def msetnxFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.msetnx(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def multiFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.multi({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def objectFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.`object`(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def persistFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.persist(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def pexpireFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pexpire(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def pexpireatFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pexpireat(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def pfaddFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pfadd(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def pfcountFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pfcount(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def pfdebugFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pfdebug(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def pfmergeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pfmerge(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def pfselftestFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pfselftest({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def pingFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.ping(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def postFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.post(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def psetexFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.psetex(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def psubscribeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.psubscribe(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def psyncFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.psync(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def pttlFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pttl(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def publishFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.publish(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def pubsubFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.pubsub(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def punsubscribeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.punsubscribe(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def randomkeyFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.randomkey({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def readonlyFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.readonly({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def readwriteFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.readwrite({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def renameFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.rename(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def renamenxFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.renamenx(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def replconfFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.replconf(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def replicaofFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.replicaof(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def restoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.restore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def restoreAskingFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.restoreAsking(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def roleFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.role({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def rpopFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.rpop(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def rpoplpushFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.rpoplpush(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def rpushFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.rpush(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def rpushxFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.rpushx(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def saddFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sadd(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def saveFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.save({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def scanFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.scan(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def scardFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.scard(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def scriptFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.script(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def sdiffFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sdiff(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def sdiffstoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sdiffstore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def selectFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.select(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def setFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.set(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def setbitFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.setbit(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def setexFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.setex(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def setnxFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.setnx(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def setrangeFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.setrange(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def shutdownFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.shutdown(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def sinterFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sinter(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def sinterstoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sinterstore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def sismemberFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sismember(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def slaveofFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.slaveof(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def slowlogFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.slowlog(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def smembersFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.smembers(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def smoveFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.smove(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def sortFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sort(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def spopFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.spop(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def srandmemberFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.srandmember(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def sremFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.srem(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def sscanFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sscan(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def strlenFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.strlen(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def subscribeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.subscribe(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def substrFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.substr(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def sunionFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sunion(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def sunionstoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sunionstore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def swapdbFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.swapdb(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def syncFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.sync({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def timeFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.time({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def touchFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.touch(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def ttlFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.ttl(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def typeFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.`type`(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def unlinkFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.unlink(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def unsubscribeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.unsubscribe(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def unwatchFuture(): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.unwatch({a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def waitFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.wait(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def watchFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.watch(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def xackFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xack(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def xaddFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xadd(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def xclaimFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xclaim(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def xdelFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xdel(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def xgroupFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xgroup(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def xinfoFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xinfo(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def xlenFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xlen(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def xpendingFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xpending(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def xrangeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xrange(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def xreadFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xread(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def xreadgroupFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xreadgroup(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def xrevrangeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xrevrange(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def xsetidFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xsetid(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def xtrimFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.xtrim(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zaddFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zadd(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zcardFuture(arg0: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zcard(arg0, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zcountFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zcount(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zincrbyFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zincrby(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zinterstoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zinterstore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zlexcountFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zlexcount(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zpopmaxFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zpopmax(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zpopminFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zpopmin(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zrangeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrange(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zrangebylexFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrangebylex(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zrangebyscoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrangebyscore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zrankFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrank(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zremFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrem(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zremrangebylexFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zremrangebylex(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zremrangebyrankFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zremrangebyrank(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zremrangebyscoreFuture(arg0: java.lang.String,arg1: java.lang.String,arg2: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zremrangebyscore(arg0, arg1, arg2, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zrevrangeFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrevrange(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zrevrangebylexFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrevrangebylex(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zrevrangebyscoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrevrangebyscore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zrevrankFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zrevrank(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zscanFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zscan(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zscoreFuture(arg0: java.lang.String,arg1: java.lang.String): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zscore(arg0, arg1, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def zunionstoreFuture(args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = Promise[io.vertx.redis.client.Response]()
      asJava.zunionstore(args, {a:AsyncResult[io.vertx.redis.client.Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  type RedisOptions = io.vertx.redis.client.RedisOptions

  object RedisOptions {
    def apply() = new RedisOptions()
    def apply(json: JsonObject) = new RedisOptions(json)
  }



  /**
    * Interface for sentinel commands
    */

  implicit class RedisSentinelScala(val asJava: io.vertx.redis.sentinel.RedisSentinel) extends AnyVal {

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[masters]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mastersFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.masters({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[master]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def masterFuture(name: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.master(name, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slaves]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slavesFuture(name: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.slaves(name, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sentinels]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sentinelsFuture(name: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.sentinels(name, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getMasterAddrByName]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getMasterAddrByNameFuture(name: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.getMasterAddrByName(name, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[reset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def resetFuture(pattern: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.reset(pattern, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[failover]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def failoverFuture(name: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.failover(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ckquorum]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def ckquorumFuture(name: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.ckquorum(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[flushConfig]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def flushConfigFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.flushConfig({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }




  type ScanOptions = io.vertx.redis.op.ScanOptions

  object ScanOptions {
    def apply() = new ScanOptions()
    def apply(json: JsonObject) = new ScanOptions(json)
  }



  type SetOptions = io.vertx.redis.op.SetOptions

  object SetOptions {
    def apply() = new SetOptions()
    def apply(json: JsonObject) = new SetOptions(json)
  }



  type SortOptions = io.vertx.redis.op.SortOptions

  object SortOptions {
    def apply() = new SortOptions()
    def apply(json: JsonObject) = new SortOptions(json)
  }


}
