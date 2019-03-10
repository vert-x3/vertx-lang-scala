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

import io.vertx.redis.{Script => JScript}
import io.vertx.core
import io.vertx.redis.{RedisClient => JRedisClient}
import io.vertx.redis.op.BitOperation
import io.vertx.redis.op.ResetOptions
import io.vertx.redis.op.{ScanOptions => JScanOptions}
import io.vertx.redis.op.{GeoMember => JGeoMember}
import io.vertx.redis.op.ObjectCmd
import io.vertx.redis.op.{SetOptions => JSetOptions}
import io.vertx.redis.{RedisTransaction => JRedisTransaction}
import io.vertx.redis.op.{LimitOptions => JLimitOptions}
import io.vertx.redis.op
import io.vertx.redis.op.ClientReplyOptions
import io.vertx.redis.op.GeoUnit
import io.vertx.redis.op.{MigrateOptions => JMigrateOptions}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.redis.op.RangeOptions
import io.vertx.redis.op.InsertOptions
import io.vertx.redis.op.AggregateOptions
import io.vertx.redis.op.{BitFieldOptions => JBitFieldOptions}
import io.vertx.redis.op.ScriptDebugOptions
import io.vertx.redis.op.{GeoRadiusOptions => JGeoRadiusOptions}
import io.vertx.redis.op.FailoverOptions
import scala.collection.JavaConverters._
import io.vertx.redis.op.SlotCmd
import io.vertx.redis.op.BitFieldOverflowOptions
import io.vertx.core.{Vertx => JVertx}
import io.vertx.redis.op.{RangeLimitOptions => JRangeLimitOptions}
import io.vertx.core.json.JsonArray
import io.vertx.core.buffer.Buffer
import io.vertx.redis.op.{SortOptions => JSortOptions}
import io.vertx.redis.{RedisOptions => JRedisOptions}
import io.vertx.redis.op.{KillFilter => JKillFilter}
import io.vertx.core.Handler

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




  implicit class RedisClientScala(val asJava: io.vertx.redis.RedisClient) extends AnyVal {

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[append]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def appendFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.append(key, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[auth]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def authFuture(password: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.auth(password, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bgrewriteaof]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bgrewriteaofFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.bgrewriteaof({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bgsave]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bgsaveFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.bgsave({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitcountFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.bitcount(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitcountRange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitcountRangeFuture(key: java.lang.String,start: java.lang.Long,end: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.bitcountRange(key, start, end, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitopFuture(operation: io.vertx.redis.op.BitOperation,destkey: java.lang.String,keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.bitop(operation, destkey, keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitpos]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitposFuture(key: java.lang.String,bit: java.lang.Integer): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.bitpos(key, bit, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitposFrom]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitposFromFuture(key: java.lang.String,bit: java.lang.Integer,start: java.lang.Integer): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.bitposFrom(key, bit, start, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitposRange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitposRangeFuture(key: java.lang.String,bit: java.lang.Integer,start: java.lang.Integer,stop: java.lang.Integer): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.bitposRange(key, bit, start, stop, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[blpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def blpopFuture(key: java.lang.String,seconds: java.lang.Integer): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.blpop(key, seconds, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[blpopMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def blpopManyFuture(keys: java.util.List[java.lang.String],seconds: java.lang.Integer): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.blpopMany(keys, seconds, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[brpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def brpopFuture(key: java.lang.String,seconds: java.lang.Integer): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.brpop(key, seconds, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[brpopMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def brpopManyFuture(keys: java.util.List[java.lang.String],seconds: java.lang.Integer): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.brpopMany(keys, seconds, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[brpoplpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def brpoplpushFuture(key: java.lang.String,destkey: java.lang.String,seconds: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.brpoplpush(key, destkey, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientKill]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientKillFuture(filter: io.vertx.redis.op.KillFilter): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.clientKill(filter, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientList]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientListFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clientList({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientGetname]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientGetnameFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clientGetname({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientPause]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientPauseFuture(millis: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clientPause(millis, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientSetname]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientSetnameFuture(name: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clientSetname(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterAddslots]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterAddslotsFuture(slots: java.util.List[java.lang.Long]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterAddslots(slots, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterCountFailureReports]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterCountFailureReportsFuture(nodeId: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.clusterCountFailureReports(nodeId, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterCountkeysinslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterCountkeysinslotFuture(slot: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.clusterCountkeysinslot(slot, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterDelslots]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterDelslotsFuture(slot: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterDelslots(slot, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterDelslotsMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterDelslotsManyFuture(slots: java.util.List[java.lang.Long]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterDelslotsMany(slots, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterFailover]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterFailoverFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterFailover({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterFailOverWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterFailOverWithOptionsFuture(options: io.vertx.redis.op.FailoverOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterFailOverWithOptions(options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterForget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterForgetFuture(nodeId: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterForget(nodeId, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterGetkeysinslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterGetkeysinslotFuture(slot: java.lang.Long,count: java.lang.Long): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.clusterGetkeysinslot(slot, count, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterInfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterInfoFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.clusterInfo({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterKeyslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterKeyslotFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.clusterKeyslot(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterMeet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterMeetFuture(ip: java.lang.String,port: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterMeet(ip, port, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterNodes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterNodesFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.clusterNodes({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterReplicate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterReplicateFuture(nodeId: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterReplicate(nodeId, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterReset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterResetFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterReset({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterResetWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterResetWithOptionsFuture(options: io.vertx.redis.op.ResetOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterResetWithOptions(options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSaveconfig]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSaveconfigFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterSaveconfig({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSetConfigEpoch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSetConfigEpochFuture(epoch: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterSetConfigEpoch(epoch, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSetslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSetslotFuture(slot: java.lang.Long,subcommand: io.vertx.redis.op.SlotCmd): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterSetslot(slot, subcommand, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSetslotWithNode]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSetslotWithNodeFuture(slot: java.lang.Long,subcommand: io.vertx.redis.op.SlotCmd,nodeId: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterSetslotWithNode(slot, subcommand, nodeId, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSlaves]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSlavesFuture(nodeId: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.clusterSlaves(nodeId, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSlots]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSlotsFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.clusterSlots({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[command]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.command({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commandCount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandCountFuture(): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.commandCount({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commandGetkeys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandGetkeysFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.commandGetkeys({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commandInfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandInfoFuture(commands: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.commandInfo(commands, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configGetFuture(parameter: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.configGet(parameter, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configRewrite]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configRewriteFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.configRewrite({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configSet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configSetFuture(parameter: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.configSet(parameter, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configResetstat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configResetstatFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.configResetstat({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[dbsize]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def dbsizeFuture(): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.dbsize({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[debugObject]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def debugObjectFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.debugObject(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[debugSegfault]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def debugSegfaultFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.debugSegfault({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[decr]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def decrFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.decr(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[decrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def decrbyFuture(key: java.lang.String,decrement: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.decrby(key, decrement, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[del]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def delFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.del(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[delMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def delManyFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.delMany(keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[dump]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def dumpFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.dump(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[echo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def echoFuture(message: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.echo(message, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[eval]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def evalFuture(script: java.lang.String,keys: java.util.List[java.lang.String],args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.eval(script, keys, args, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[evalsha]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def evalshaFuture(sha1: java.lang.String,keys: java.util.List[java.lang.String],values: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.evalsha(sha1, keys, values, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[evalScript]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def evalScriptFuture(script: io.vertx.redis.Script,keys: java.util.List[java.lang.String],args: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.evalScript(script, keys, args, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[exists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def existsFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.exists(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[existsMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def existsManyFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.existsMany(keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[expire]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def expireFuture(key: java.lang.String,seconds: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.expire(key, seconds, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[expireat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def expireatFuture(key: java.lang.String,seconds: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.expireat(key, seconds, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[flushall]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def flushallFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.flushall({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[flushdb]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def flushdbFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.flushdb({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.get(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getBinary]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getBinaryFuture(key: java.lang.String): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = Promise[io.vertx.core.buffer.Buffer]()
      asJava.getBinary(key, {a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getbit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getbitFuture(key: java.lang.String,offset: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.getbit(key, offset, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getrangeFuture(key: java.lang.String,start: java.lang.Long,end: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.getrange(key, start, end, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getsetFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.getset(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hdel]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hdelFuture(key: java.lang.String,field: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hdel(key, field, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hdelMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hdelManyFuture(key: java.lang.String,fields: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hdelMany(key, fields, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hexists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hexistsFuture(key: java.lang.String,field: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hexists(key, field, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hgetFuture(key: java.lang.String,field: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hget(key, field, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hgetall]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hgetallFuture(key: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.hgetall(key, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hincrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hincrbyFuture(key: java.lang.String,field: java.lang.String,increment: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hincrby(key, field, increment, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hincrbyfloat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hincrbyfloatFuture(key: java.lang.String,field: java.lang.String,increment: java.lang.Double): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hincrbyfloat(key, field, increment, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hkeys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hkeysFuture(key: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.hkeys(key, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hlenFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hlen(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hmget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hmgetFuture(key: java.lang.String,fields: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.hmget(key, fields, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hmset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hmsetFuture(key: java.lang.String,values: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hmset(key, values, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hsetFuture(key: java.lang.String,field: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hset(key, field, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hsetnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hsetnxFuture(key: java.lang.String,field: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hsetnx(key, field, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hvals]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hvalsFuture(key: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.hvals(key, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incr]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.incr(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrbyFuture(key: java.lang.String,increment: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.incrby(key, increment, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incrbyfloat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrbyfloatFuture(key: java.lang.String,increment: java.lang.Double): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.incrbyfloat(key, increment, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[info]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def infoFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.info({a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[infoSection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def infoSectionFuture(section: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.infoSection(section, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[keys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def keysFuture(pattern: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.keys(pattern, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lastsave]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lastsaveFuture(): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.lastsave({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lindex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lindexFuture(key: java.lang.String,index: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lindex(key, index, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[linsert]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def linsertFuture(key: java.lang.String,option: io.vertx.redis.op.InsertOptions,pivot: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.linsert(key, option, pivot, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[llen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def llenFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.llen(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpopFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lpop(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpushMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpushManyFuture(key: java.lang.String,values: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.lpushMany(key, values, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpushFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.lpush(key, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpushx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpushxFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.lpushx(key, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lrangeFuture(key: java.lang.String,from: java.lang.Long,to: java.lang.Long): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.lrange(key, from, to, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lrem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lremFuture(key: java.lang.String,count: java.lang.Long,value: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.lrem(key, count, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lsetFuture(key: java.lang.String,index: java.lang.Long,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lset(key, index, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ltrim]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def ltrimFuture(key: java.lang.String,from: java.lang.Long,to: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.ltrim(key, from, to, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mgetFuture(key: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.mget(key, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mgetMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mgetManyFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.mgetMany(keys, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[migrate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def migrateFuture(host: java.lang.String,port: java.lang.Integer,key: java.lang.String,destdb: java.lang.Integer,timeout: java.lang.Long,options: io.vertx.redis.op.MigrateOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.migrate(host, port, key, destdb, timeout, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[monitor]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def monitorFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.monitor({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[move]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def moveFuture(key: java.lang.String,destdb: java.lang.Integer): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.move(key, destdb, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def msetFuture(keyvals: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.mset(keyvals, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[msetnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def msetnxFuture(keyvals: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.msetnx(keyvals, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[object]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def objectFuture(key: java.lang.String,cmd: io.vertx.redis.op.ObjectCmd): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.`object`(key, cmd, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[persist]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def persistFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.persist(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pexpire]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pexpireFuture(key: java.lang.String,millis: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pexpire(key, millis, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pexpireat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pexpireatFuture(key: java.lang.String,millis: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pexpireat(key, millis, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfaddFuture(key: java.lang.String,element: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pfadd(key, element, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfaddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfaddManyFuture(key: java.lang.String,elements: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pfaddMany(key, elements, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfcountFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pfcount(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfcountMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfcountManyFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pfcountMany(keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfmerge]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfmergeFuture(destkey: java.lang.String,keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.pfmerge(destkey, keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ping]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pingFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.ping({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psetex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psetexFuture(key: java.lang.String,millis: java.lang.Long,value: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.psetex(key, millis, value, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psubscribeFuture(pattern: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.psubscribe(pattern, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psubscribeMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psubscribeManyFuture(patterns: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.psubscribeMany(patterns, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pubsubChannels]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pubsubChannelsFuture(pattern: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.pubsubChannels(pattern, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pubsubNumsub]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pubsubNumsubFuture(channels: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.pubsubNumsub(channels, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pubsubNumpat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pubsubNumpatFuture(): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pubsubNumpat({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pttl]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pttlFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pttl(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[publish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def publishFuture(channel: java.lang.String,message: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.publish(channel, message, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[punsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def punsubscribeFuture(patterns: java.util.List[java.lang.String]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.punsubscribe(patterns, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[randomkey]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def randomkeyFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.randomkey({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rename]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def renameFuture(key: java.lang.String,newkey: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.rename(key, newkey, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[renamenx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def renamenxFuture(key: java.lang.String,newkey: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.renamenx(key, newkey, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[restore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def restoreFuture(key: java.lang.String,millis: java.lang.Long,serialized: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.restore(key, millis, serialized, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[role]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def roleFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.role({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpopFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.rpop(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpoplpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpoplpushFuture(key: java.lang.String,destkey: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.rpoplpush(key, destkey, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpushMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpushManyFuture(key: java.lang.String,values: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.rpushMany(key, values, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpushFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.rpush(key, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpushx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpushxFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.rpushx(key, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saddFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.sadd(key, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[saddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saddManyFuture(key: java.lang.String,members: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.saddMany(key, members, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[save]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saveFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.save({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scardFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.scard(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptExists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptExistsFuture(script: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.scriptExists(script, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptExistsMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptExistsManyFuture(scripts: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.scriptExistsMany(scripts, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptFlush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptFlushFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.scriptFlush({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptKill]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptKillFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.scriptKill({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptLoad]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptLoadFuture(script: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.scriptLoad(script, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sdiff]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sdiffFuture(key: java.lang.String,cmpkeys: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.sdiff(key, cmpkeys, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sdiffstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sdiffstoreFuture(destkey: java.lang.String,key: java.lang.String,cmpkeys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.sdiffstore(destkey, key, cmpkeys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[select]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def selectFuture(dbindex: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.select(dbindex, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[set]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.set(key, value, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setWithOptionsFuture(key: java.lang.String,value: java.lang.String,options: io.vertx.redis.op.SetOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.setWithOptions(key, value, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setBinary]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setBinaryFuture(key: java.lang.String,value: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.setBinary(key, value, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setBinaryWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setBinaryWithOptionsFuture(key: java.lang.String,value: io.vertx.core.buffer.Buffer,options: io.vertx.redis.op.SetOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.setBinaryWithOptions(key, value, options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setbit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setbitFuture(key: java.lang.String,offset: java.lang.Long,bit: java.lang.Integer): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.setbit(key, offset, bit, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setexFuture(key: java.lang.String,seconds: java.lang.Long,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.setex(key, seconds, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setnxFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.setnx(key, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setrangeFuture(key: java.lang.String,offset: java.lang.Integer,value: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.setrange(key, offset, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sinter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sinterFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.sinter(keys, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sinterstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sinterstoreFuture(destkey: java.lang.String,keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.sinterstore(destkey, keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sismember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sismemberFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.sismember(key, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slaveof]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slaveofFuture(host: java.lang.String,port: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.slaveof(host, port, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slaveofNoone]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slaveofNooneFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.slaveofNoone({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slowlogGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slowlogGetFuture(limit: java.lang.Integer): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.slowlogGet(limit, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slowlogLen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slowlogLenFuture(): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.slowlogLen({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slowlogReset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slowlogResetFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.slowlogReset({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[smembers]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def smembersFuture(key: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.smembers(key, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[smove]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def smoveFuture(key: java.lang.String,destkey: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.smove(key, destkey, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sort]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sortFuture(key: java.lang.String,options: io.vertx.redis.op.SortOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.sort(key, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[spop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def spopFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.spop(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[spopMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def spopManyFuture(key: java.lang.String,count: java.lang.Integer): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.spopMany(key, count, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[srandmember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def srandmemberFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.srandmember(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[srandmemberCount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def srandmemberCountFuture(key: java.lang.String,count: java.lang.Integer): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.srandmemberCount(key, count, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[srem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sremFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.srem(key, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sremMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sremManyFuture(key: java.lang.String,members: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.sremMany(key, members, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[strlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def strlenFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.strlen(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def subscribeFuture(channel: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.subscribe(channel, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[subscribeMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def subscribeManyFuture(channels: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.subscribeMany(channels, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sunion]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sunionFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.sunion(keys, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sunionstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sunionstoreFuture(destkey: java.lang.String,keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.sunionstore(destkey, keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sync]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def syncFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.sync({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[time]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def timeFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.time({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ttl]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def ttlFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.ttl(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[type]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def typeFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.`type`(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unsubscribeFuture(channels: java.util.List[java.lang.String]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.unsubscribe(channels, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[wait]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def waitFuture(numSlaves: java.lang.Long,timeout: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.wait(numSlaves, timeout, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zaddFuture(key: java.lang.String,score: java.lang.Double,member: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zadd(key, score, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zaddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zaddManyFuture(key: java.lang.String,members: java.util.Map[String, java.lang.Double]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zaddMany(key, members, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zcard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zcardFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zcard(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zcountFuture(key: java.lang.String,min: java.lang.Double,max: java.lang.Double): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zcount(key, min, max, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zincrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zincrbyFuture(key: java.lang.String,increment: java.lang.Double,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zincrby(key, increment, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zinterstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zinterstoreFuture(destkey: java.lang.String,sets: java.util.List[java.lang.String],options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zinterstore(destkey, sets, options, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zinterstoreWeighed]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zinterstoreWeighedFuture(destkey: java.lang.String,sets: java.util.Map[String, java.lang.Double],options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zinterstoreWeighed(destkey, sets, options, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zlexcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zlexcountFuture(key: java.lang.String,min: java.lang.String,max: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zlexcount(key, min, max, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangeFuture(key: java.lang.String,start: java.lang.Long,stop: java.lang.Long): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zrange(key, start, stop, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrangeWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangeWithOptionsFuture(key: java.lang.String,start: java.lang.Long,stop: java.lang.Long,options: io.vertx.redis.op.RangeOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zrangeWithOptions(key, start, stop, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangebylexFuture(key: java.lang.String,min: java.lang.String,max: java.lang.String,options: io.vertx.redis.op.LimitOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zrangebylex(key, min, max, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangebyscoreFuture(key: java.lang.String,min: java.lang.String,max: java.lang.String,options: io.vertx.redis.op.RangeLimitOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zrangebyscore(key, min, max, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrankFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zrank(key, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zrem(key, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremManyFuture(key: java.lang.String,members: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zremMany(key, members, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebylexFuture(key: java.lang.String,min: java.lang.String,max: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zremrangebylex(key, min, max, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebyrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebyrankFuture(key: java.lang.String,start: java.lang.Long,stop: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zremrangebyrank(key, start, stop, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebyscoreFuture(key: java.lang.String,min: java.lang.String,max: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zremrangebyscore(key, min, max, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangeFuture(key: java.lang.String,start: java.lang.Long,stop: java.lang.Long,options: io.vertx.redis.op.RangeOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zrevrange(key, start, stop, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangebylexFuture(key: java.lang.String,max: java.lang.String,min: java.lang.String,options: io.vertx.redis.op.LimitOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zrevrangebylex(key, max, min, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangebyscoreFuture(key: java.lang.String,max: java.lang.String,min: java.lang.String,options: io.vertx.redis.op.RangeLimitOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zrevrangebyscore(key, max, min, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrankFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zrevrank(key, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zscoreFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zscore(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zunionstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zunionstoreFuture(destkey: java.lang.String,sets: java.util.List[java.lang.String],options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zunionstore(destkey, sets, options, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zunionstoreWeighed]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zunionstoreWeighedFuture(key: java.lang.String,sets: java.util.Map[String, java.lang.Double],options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zunionstoreWeighed(key, sets, options, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scanFuture(cursor: java.lang.String,options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.scan(cursor, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sscanFuture(key: java.lang.String,cursor: java.lang.String,options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.sscan(key, cursor, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hscanFuture(key: java.lang.String,cursor: java.lang.String,options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.hscan(key, cursor, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zscanFuture(key: java.lang.String,cursor: java.lang.String,options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zscan(key, cursor, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geoadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoaddFuture(key: java.lang.String,longitude: java.lang.Double,latitude: java.lang.Double,member: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.geoadd(key, longitude, latitude, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geoaddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoaddManyFuture(key: java.lang.String,members: java.util.List[io.vertx.redis.op.GeoMember]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.geoaddMany(key, members, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geohash]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geohashFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.geohash(key, member, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geohashMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geohashManyFuture(key: java.lang.String,members: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.geohashMany(key, members, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geopos]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoposFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.geopos(key, member, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geoposMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoposManyFuture(key: java.lang.String,members: java.util.List[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.geoposMany(key, members, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geodist]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geodistFuture(key: java.lang.String,member1: java.lang.String,member2: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.geodist(key, member1, member2, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geodistWithUnit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geodistWithUnitFuture(key: java.lang.String,member1: java.lang.String,member2: java.lang.String,unit: io.vertx.redis.op.GeoUnit): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.geodistWithUnit(key, member1, member2, unit, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadius]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusFuture(key: java.lang.String,longitude: java.lang.Double,latitude: java.lang.Double,radius: java.lang.Double,unit: io.vertx.redis.op.GeoUnit): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.georadius(key, longitude, latitude, radius, unit, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusWithOptionsFuture(key: java.lang.String,longitude: java.lang.Double,latitude: java.lang.Double,radius: java.lang.Double,unit: io.vertx.redis.op.GeoUnit,options: io.vertx.redis.op.GeoRadiusOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.georadiusWithOptions(key, longitude, latitude, radius, unit, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusbymember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusbymemberFuture(key: java.lang.String,member: java.lang.String,radius: java.lang.Double,unit: io.vertx.redis.op.GeoUnit): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.georadiusbymember(key, member, radius, unit, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusbymemberWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusbymemberWithOptionsFuture(key: java.lang.String,member: java.lang.String,radius: java.lang.Double,unit: io.vertx.redis.op.GeoUnit,options: io.vertx.redis.op.GeoRadiusOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.georadiusbymemberWithOptions(key, member, radius, unit, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientReply]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientReplyFuture(options: io.vertx.redis.op.ClientReplyOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clientReply(options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hstrlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hstrlenFuture(key: java.lang.String,field: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hstrlen(key, field, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[touch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def touchFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.touch(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[touchMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def touchManyFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.touchMany(keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptDebug]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptDebugFuture(scriptDebugOptions: io.vertx.redis.op.ScriptDebugOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.scriptDebug(scriptDebugOptions, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitfield]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitfieldFuture(key: java.lang.String,bitFieldOptions: io.vertx.redis.op.BitFieldOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.bitfield(key, bitFieldOptions, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitfieldWithOverflow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitfieldWithOverflowFuture(key: java.lang.String,commands: io.vertx.redis.op.BitFieldOptions,overflow: io.vertx.redis.op.BitFieldOverflowOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.bitfieldWithOverflow(key, commands, overflow, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unlink]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlinkFuture(key: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.unlink(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unlinkMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlinkManyFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.unlinkMany(keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[swapdb]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def swapdbFuture(index1: java.lang.Integer,index2: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.swapdb(index1, index2, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  type RedisOptions = io.vertx.redis.RedisOptions

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


  /**
    * This Interface represents a TX

    */

  implicit class RedisTransactionScala(val asJava: io.vertx.redis.RedisTransaction) extends AnyVal {

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[append]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def appendFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.append(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[auth]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def authFuture(password: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.auth(password, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bgrewriteaof]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bgrewriteaofFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.bgrewriteaof({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bgsave]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bgsaveFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.bgsave({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitcountFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.bitcount(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitcountRange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitcountRangeFuture(key: java.lang.String,start: java.lang.Long,end: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.bitcountRange(key, start, end, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitopFuture(operation: io.vertx.redis.op.BitOperation,destkey: java.lang.String,keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.bitop(operation, destkey, keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitpos]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitposFuture(key: java.lang.String,bit: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.bitpos(key, bit, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitposFrom]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitposFromFuture(key: java.lang.String,bit: java.lang.Integer,start: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.bitposFrom(key, bit, start, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitposRange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitposRangeFuture(key: java.lang.String,bit: java.lang.Integer,start: java.lang.Integer,stop: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.bitposRange(key, bit, start, stop, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[blpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def blpopFuture(key: java.lang.String,seconds: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.blpop(key, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[blpopMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def blpopManyFuture(keys: java.util.List[java.lang.String],seconds: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.blpopMany(keys, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[brpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def brpopFuture(key: java.lang.String,seconds: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.brpop(key, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[brpopMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def brpopManyFuture(keys: java.util.List[java.lang.String],seconds: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.brpopMany(keys, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[brpoplpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def brpoplpushFuture(key: java.lang.String,destkey: java.lang.String,seconds: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.brpoplpush(key, destkey, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientKill]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientKillFuture(filter: io.vertx.redis.op.KillFilter): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clientKill(filter, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientList]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientListFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clientList({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientGetname]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientGetnameFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clientGetname({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientPause]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientPauseFuture(millis: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clientPause(millis, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientSetname]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientSetnameFuture(name: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clientSetname(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterAddslots]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterAddslotsFuture(slots: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterAddslots(slots, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterCountFailureReports]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterCountFailureReportsFuture(nodeId: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterCountFailureReports(nodeId, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterCountkeysinslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterCountkeysinslotFuture(slot: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterCountkeysinslot(slot, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterDelslots]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterDelslotsFuture(slot: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterDelslots(slot, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterDelslotsMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterDelslotsManyFuture(slots: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterDelslotsMany(slots, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterFailover]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterFailoverFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterFailover({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterFailOverWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterFailOverWithOptionsFuture(options: io.vertx.redis.op.FailoverOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterFailOverWithOptions(options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterForget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterForgetFuture(nodeId: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterForget(nodeId, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterGetkeysinslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterGetkeysinslotFuture(slot: java.lang.Long,count: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterGetkeysinslot(slot, count, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterInfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterInfoFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterInfo({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterKeyslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterKeyslotFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterKeyslot(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterMeet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterMeetFuture(ip: java.lang.String,port: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterMeet(ip, port, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterNodes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterNodesFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterNodes({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterReplicate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterReplicateFuture(nodeId: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterReplicate(nodeId, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterReset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterResetFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterReset({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterResetWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterResetWithOptionsFuture(options: io.vertx.redis.op.ResetOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterResetWithOptions(options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSaveconfig]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSaveconfigFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterSaveconfig({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSetConfigEpoch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSetConfigEpochFuture(epoch: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterSetConfigEpoch(epoch, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSetslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSetslotFuture(slot: java.lang.Long,subcommand: io.vertx.redis.op.SlotCmd): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterSetslot(slot, subcommand, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSetslotWithNode]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSetslotWithNodeFuture(slot: java.lang.Long,subcommand: io.vertx.redis.op.SlotCmd,nodeId: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterSetslotWithNode(slot, subcommand, nodeId, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSlaves]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSlavesFuture(nodeId: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterSlaves(nodeId, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSlots]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSlotsFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.clusterSlots({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[command]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.command({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commandCount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandCountFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.commandCount({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commandGetkeys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandGetkeysFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.commandGetkeys({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commandInfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandInfoFuture(commands: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.commandInfo(commands, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configGetFuture(parameter: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.configGet(parameter, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configRewrite]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configRewriteFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.configRewrite({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configSet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configSetFuture(parameter: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.configSet(parameter, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configResetstat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configResetstatFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.configResetstat({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[dbsize]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def dbsizeFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.dbsize({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[debugObject]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def debugObjectFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.debugObject(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[debugSegfault]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def debugSegfaultFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.debugSegfault({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[decr]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def decrFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.decr(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[decrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def decrbyFuture(key: java.lang.String,decrement: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.decrby(key, decrement, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[del]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def delFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.del(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[delMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def delManyFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.delMany(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[discard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def discardFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.discard({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[dump]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def dumpFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.dump(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[echo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def echoFuture(message: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.echo(message, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[eval]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def evalFuture(script: java.lang.String,keys: java.util.List[java.lang.String],args: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.eval(script, keys, args, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[evalsha]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def evalshaFuture(sha1: java.lang.String,keys: java.util.List[java.lang.String],values: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.evalsha(sha1, keys, values, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[exec]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def execFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.exec({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[exists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def existsFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.exists(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[existsMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def existsManyFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.existsMany(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[expire]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def expireFuture(key: java.lang.String,seconds: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.expire(key, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[expireat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def expireatFuture(key: java.lang.String,seconds: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.expireat(key, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[flushall]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def flushallFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.flushall({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[flushdb]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def flushdbFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.flushdb({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.get(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getBinary]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getBinaryFuture(key: java.lang.String): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = Promise[io.vertx.core.buffer.Buffer]()
      asJava.getBinary(key, {a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getbit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getbitFuture(key: java.lang.String,offset: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.getbit(key, offset, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getrangeFuture(key: java.lang.String,start: java.lang.Long,end: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.getrange(key, start, end, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getsetFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.getset(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hdel]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hdelFuture(key: java.lang.String,field: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hdel(key, field, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hdelMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hdelManyFuture(key: java.lang.String,fields: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hdelMany(key, fields, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hexists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hexistsFuture(key: java.lang.String,field: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hexists(key, field, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hgetFuture(key: java.lang.String,field: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hget(key, field, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hgetall]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hgetallFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hgetall(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hincrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hincrbyFuture(key: java.lang.String,field: java.lang.String,increment: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hincrby(key, field, increment, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hincrbyfloat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hincrbyfloatFuture(key: java.lang.String,field: java.lang.String,increment: java.lang.Double): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hincrbyfloat(key, field, increment, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hkeys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hkeysFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hkeys(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hlenFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hlen(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hmget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hmgetFuture(key: java.lang.String,fields: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hmget(key, fields, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hmset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hmsetFuture(key: java.lang.String,values: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hmset(key, values, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hsetFuture(key: java.lang.String,field: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hset(key, field, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hsetnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hsetnxFuture(key: java.lang.String,field: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hsetnx(key, field, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hvals]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hvalsFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hvals(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incr]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.incr(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrbyFuture(key: java.lang.String,increment: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.incrby(key, increment, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incrbyfloat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrbyfloatFuture(key: java.lang.String,increment: java.lang.Double): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.incrbyfloat(key, increment, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[info]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def infoFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.info({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[infoSection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def infoSectionFuture(section: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.infoSection(section, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[keys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def keysFuture(pattern: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.keys(pattern, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lastsave]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lastsaveFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lastsave({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lindex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lindexFuture(key: java.lang.String,index: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lindex(key, index, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[linsert]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def linsertFuture(key: java.lang.String,option: io.vertx.redis.op.InsertOptions,pivot: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.linsert(key, option, pivot, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[llen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def llenFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.llen(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpopFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lpop(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpushMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpushManyFuture(key: java.lang.String,values: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lpushMany(key, values, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpushFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lpush(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpushx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpushxFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lpushx(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lrangeFuture(key: java.lang.String,from: java.lang.Long,to: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lrange(key, from, to, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lrem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lremFuture(key: java.lang.String,count: java.lang.Long,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lrem(key, count, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lsetFuture(key: java.lang.String,index: java.lang.Long,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.lset(key, index, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ltrim]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def ltrimFuture(key: java.lang.String,from: java.lang.Long,to: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.ltrim(key, from, to, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mgetFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.mget(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mgetMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mgetManyFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.mgetMany(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[migrate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def migrateFuture(host: java.lang.String,port: java.lang.Integer,key: java.lang.String,destdb: java.lang.Integer,timeout: java.lang.Long,options: io.vertx.redis.op.MigrateOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.migrate(host, port, key, destdb, timeout, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[monitor]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def monitorFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.monitor({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[move]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def moveFuture(key: java.lang.String,destdb: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.move(key, destdb, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def msetFuture(keyvals: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.mset(keyvals, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[msetnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def msetnxFuture(keyvals: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.msetnx(keyvals, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[multi]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def multiFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.multi({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[object]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def objectFuture(key: java.lang.String,cmd: io.vertx.redis.op.ObjectCmd): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.`object`(key, cmd, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[persist]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def persistFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.persist(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pexpire]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pexpireFuture(key: java.lang.String,millis: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.pexpire(key, millis, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pexpireat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pexpireatFuture(key: java.lang.String,millis: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.pexpireat(key, millis, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfaddFuture(key: java.lang.String,element: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.pfadd(key, element, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfaddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfaddManyFuture(key: java.lang.String,elements: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.pfaddMany(key, elements, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfcountFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.pfcount(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfcountMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfcountManyFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.pfcountMany(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfmerge]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfmergeFuture(destkey: java.lang.String,keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.pfmerge(destkey, keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ping]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pingFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.ping({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psetex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psetexFuture(key: java.lang.String,millis: java.lang.Long,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.psetex(key, millis, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psubscribeFuture(pattern: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.psubscribe(pattern, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psubscribeMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psubscribeManyFuture(patterns: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.psubscribeMany(patterns, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pubsubChannels]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pubsubChannelsFuture(pattern: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.pubsubChannels(pattern, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pubsubNumsub]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pubsubNumsubFuture(channels: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.pubsubNumsub(channels, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pubsubNumpat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pubsubNumpatFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.pubsubNumpat({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pttl]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pttlFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.pttl(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[publish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def publishFuture(channel: java.lang.String,message: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.publish(channel, message, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[punsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def punsubscribeFuture(patterns: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.punsubscribe(patterns, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[randomkey]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def randomkeyFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.randomkey({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rename]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def renameFuture(key: java.lang.String,newkey: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.rename(key, newkey, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[renamenx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def renamenxFuture(key: java.lang.String,newkey: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.renamenx(key, newkey, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[restore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def restoreFuture(key: java.lang.String,millis: java.lang.Long,serialized: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.restore(key, millis, serialized, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[role]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def roleFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.role({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpopFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.rpop(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpoplpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpoplpushFuture(key: java.lang.String,destkey: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.rpoplpush(key, destkey, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpushMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpushManyFuture(key: java.lang.String,values: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.rpushMany(key, values, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpushFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.rpush(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpushx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpushxFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.rpushx(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saddFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.sadd(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[saddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saddManyFuture(key: java.lang.String,members: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.saddMany(key, members, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[save]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saveFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.save({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scardFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.scard(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptExists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptExistsFuture(script: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.scriptExists(script, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptExistsMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptExistsManyFuture(scripts: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.scriptExistsMany(scripts, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptFlush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptFlushFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.scriptFlush({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptKill]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptKillFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.scriptKill({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptLoad]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptLoadFuture(script: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.scriptLoad(script, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sdiff]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sdiffFuture(key: java.lang.String,cmpkeys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.sdiff(key, cmpkeys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sdiffstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sdiffstoreFuture(destkey: java.lang.String,key: java.lang.String,cmpkeys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.sdiffstore(destkey, key, cmpkeys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[select]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def selectFuture(dbindex: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.select(dbindex, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[set]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.set(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setWithOptionsFuture(key: java.lang.String,value: java.lang.String,options: io.vertx.redis.op.SetOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.setWithOptions(key, value, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setBinary]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setBinaryFuture(key: java.lang.String,value: io.vertx.core.buffer.Buffer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.setBinary(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setBinaryWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setBinaryWithOptionsFuture(key: java.lang.String,value: io.vertx.core.buffer.Buffer,options: io.vertx.redis.op.SetOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.setBinaryWithOptions(key, value, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setbit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setbitFuture(key: java.lang.String,offset: java.lang.Long,bit: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.setbit(key, offset, bit, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setexFuture(key: java.lang.String,seconds: java.lang.Long,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.setex(key, seconds, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setnxFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.setnx(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setrangeFuture(key: java.lang.String,offset: java.lang.Integer,value: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.setrange(key, offset, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sinter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sinterFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.sinter(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sinterstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sinterstoreFuture(destkey: java.lang.String,keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.sinterstore(destkey, keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sismember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sismemberFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.sismember(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slaveof]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slaveofFuture(host: java.lang.String,port: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.slaveof(host, port, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slaveofNoone]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slaveofNooneFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.slaveofNoone({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slowlogGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slowlogGetFuture(limit: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.slowlogGet(limit, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slowlogLen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slowlogLenFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.slowlogLen({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slowlogReset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slowlogResetFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.slowlogReset({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[smembers]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def smembersFuture(key: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.smembers(key, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[smove]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def smoveFuture(key: java.lang.String,destkey: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.smove(key, destkey, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sort]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sortFuture(key: java.lang.String,options: io.vertx.redis.op.SortOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.sort(key, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[spop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def spopFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.spop(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[spopMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def spopManyFuture(key: java.lang.String,count: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.spopMany(key, count, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[srandmember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def srandmemberFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.srandmember(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[srandmemberCount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def srandmemberCountFuture(key: java.lang.String,count: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.srandmemberCount(key, count, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[srem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sremFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.srem(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sremMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sremManyFuture(key: java.lang.String,members: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.sremMany(key, members, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[strlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def strlenFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.strlen(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def subscribeFuture(channel: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.subscribe(channel, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[subscribeMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def subscribeManyFuture(channels: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.subscribeMany(channels, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sunion]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sunionFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.sunion(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sunionstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sunionstoreFuture(destkey: java.lang.String,keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.sunionstore(destkey, keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sync]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def syncFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.sync({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[time]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def timeFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.time({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ttl]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def ttlFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.ttl(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[type]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def typeFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.`type`(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unsubscribeFuture(channels: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.unsubscribe(channels, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unwatch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unwatchFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.unwatch({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[wait]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def waitFuture(numSlaves: java.lang.Long,timeout: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.wait(numSlaves, timeout, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[watch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def watchFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.watch(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[watchMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def watchManyFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.watchMany(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zaddFuture(key: java.lang.String,score: java.lang.Double,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zadd(key, score, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zaddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zaddManyFuture(key: java.lang.String,members: java.util.Map[String, java.lang.Double]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zaddMany(key, members, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zcard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zcardFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zcard(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zcountFuture(key: java.lang.String,min: java.lang.Double,max: java.lang.Double): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zcount(key, min, max, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zincrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zincrbyFuture(key: java.lang.String,increment: java.lang.Double,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zincrby(key, increment, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zinterstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zinterstoreFuture(destkey: java.lang.String,sets: java.util.List[java.lang.String],options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zinterstore(destkey, sets, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zinterstoreWeighed]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zinterstoreWeighedFuture(destkey: java.lang.String,sets: java.util.Map[String, java.lang.Double],options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zinterstoreWeighed(destkey, sets, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zlexcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zlexcountFuture(key: java.lang.String,min: java.lang.String,max: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zlexcount(key, min, max, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangeFuture(key: java.lang.String,start: java.lang.Long,stop: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zrange(key, start, stop, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrangeWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangeWithOptionsFuture(key: java.lang.String,start: java.lang.Long,stop: java.lang.Long,options: io.vertx.redis.op.RangeOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zrangeWithOptions(key, start, stop, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangebylexFuture(key: java.lang.String,min: java.lang.String,max: java.lang.String,options: io.vertx.redis.op.LimitOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zrangebylex(key, min, max, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangebyscoreFuture(key: java.lang.String,min: java.lang.String,max: java.lang.String,options: io.vertx.redis.op.RangeLimitOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zrangebyscore(key, min, max, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrankFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zrank(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zrem(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremManyFuture(key: java.lang.String,members: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zremMany(key, members, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebylexFuture(key: java.lang.String,min: java.lang.String,max: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zremrangebylex(key, min, max, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebyrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebyrankFuture(key: java.lang.String,start: java.lang.Long,stop: java.lang.Long): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zremrangebyrank(key, start, stop, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebyscoreFuture(key: java.lang.String,min: java.lang.String,max: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zremrangebyscore(key, min, max, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangeFuture(key: java.lang.String,start: java.lang.Long,stop: java.lang.Long,options: io.vertx.redis.op.RangeOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zrevrange(key, start, stop, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangebylexFuture(key: java.lang.String,max: java.lang.String,min: java.lang.String,options: io.vertx.redis.op.LimitOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zrevrangebylex(key, max, min, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangebyscoreFuture(key: java.lang.String,max: java.lang.String,min: java.lang.String,options: io.vertx.redis.op.RangeLimitOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zrevrangebyscore(key, max, min, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrankFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zrevrank(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zscoreFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zscore(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zunionstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zunionstoreFuture(destkey: java.lang.String,sets: java.util.List[java.lang.String],options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zunionstore(destkey, sets, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zunionstoreWeighed]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zunionstoreWeighedFuture(key: java.lang.String,sets: java.util.Map[String, java.lang.Double],options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zunionstoreWeighed(key, sets, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scanFuture(cursor: java.lang.String,options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.scan(cursor, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sscanFuture(key: java.lang.String,cursor: java.lang.String,options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.sscan(key, cursor, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hscanFuture(key: java.lang.String,cursor: java.lang.String,options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.hscan(key, cursor, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zscanFuture(key: java.lang.String,cursor: java.lang.String,options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.zscan(key, cursor, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geoadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoaddFuture(key: java.lang.String,longitude: java.lang.Double,latitude: java.lang.Double,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.geoadd(key, longitude, latitude, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geoaddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoaddManyFuture(key: java.lang.String,members: java.util.List[io.vertx.redis.op.GeoMember]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.geoaddMany(key, members, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geohash]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geohashFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.geohash(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geohashMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geohashManyFuture(key: java.lang.String,members: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.geohashMany(key, members, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geopos]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoposFuture(key: java.lang.String,member: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.geopos(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geoposMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoposManyFuture(key: java.lang.String,members: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.geoposMany(key, members, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geodist]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geodistFuture(key: java.lang.String,member1: java.lang.String,member2: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.geodist(key, member1, member2, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geodistWithUnit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geodistWithUnitFuture(key: java.lang.String,member1: java.lang.String,member2: java.lang.String,unit: io.vertx.redis.op.GeoUnit): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.geodistWithUnit(key, member1, member2, unit, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadius]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusFuture(key: java.lang.String,longitude: java.lang.Double,latitude: java.lang.Double,radius: java.lang.Double,unit: io.vertx.redis.op.GeoUnit): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.georadius(key, longitude, latitude, radius, unit, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusWithOptionsFuture(key: java.lang.String,longitude: java.lang.Double,latitude: java.lang.Double,radius: java.lang.Double,unit: io.vertx.redis.op.GeoUnit,options: io.vertx.redis.op.GeoRadiusOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.georadiusWithOptions(key, longitude, latitude, radius, unit, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusbymember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusbymemberFuture(key: java.lang.String,member: java.lang.String,radius: java.lang.Double,unit: io.vertx.redis.op.GeoUnit): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.georadiusbymember(key, member, radius, unit, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusbymemberWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusbymemberWithOptionsFuture(key: java.lang.String,member: java.lang.String,radius: java.lang.Double,unit: io.vertx.redis.op.GeoUnit,options: io.vertx.redis.op.GeoRadiusOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.georadiusbymemberWithOptions(key, member, radius, unit, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unlink]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlinkFuture(key: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.unlink(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unlinkMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlinkManyFuture(keys: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.unlinkMany(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[swapdb]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def swapdbFuture(index1: java.lang.Integer,index2: java.lang.Integer): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.swapdb(index1, index2, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
