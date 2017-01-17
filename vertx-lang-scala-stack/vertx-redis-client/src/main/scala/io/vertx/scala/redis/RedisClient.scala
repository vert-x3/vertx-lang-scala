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

package io.vertx.scala.redis

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.redis.op.KillFilter
import io.vertx.redis.{RedisClient => JRedisClient}
import io.vertx.redis.op.BitOperation
import io.vertx.redis.op.ResetOptions
import io.vertx.redis.op.{ScanOptions => JScanOptions}
import io.vertx.redis.op.{GeoMember => JGeoMember}
import io.vertx.redis.op.ObjectCmd
import io.vertx.redis.op.{SetOptions => JSetOptions}
import io.vertx.redis.{RedisTransaction => JRedisTransaction}
import io.vertx.scala.core.Vertx
import io.vertx.redis.op.{LimitOptions => JLimitOptions}
import io.vertx.redis.op.GeoUnit
import io.vertx.redis.op.{MigrateOptions => JMigrateOptions}
import io.vertx.core.json.JsonObject
import io.vertx.scala.redis.op.MigrateOptions
import io.vertx.core.AsyncResult
import io.vertx.redis.op.RangeOptions
import io.vertx.redis.op.InsertOptions
import io.vertx.redis.op.AggregateOptions
import io.vertx.scala.redis.op.GeoMember
import io.vertx.redis.op.{GeoRadiusOptions => JGeoRadiusOptions}
import io.vertx.redis.op.FailoverOptions
import io.vertx.scala.redis.op.GeoRadiusOptions
import scala.collection.JavaConverters._
import io.vertx.scala.redis.op.SortOptions
import io.vertx.redis.op.SlotCmd
import io.vertx.scala.redis.op.RangeLimitOptions
import io.vertx.core.{Vertx => JVertx}
import io.vertx.redis.op.{RangeLimitOptions => JRangeLimitOptions}
import io.vertx.core.json.JsonArray
import io.vertx.scala.redis.op.SetOptions
import io.vertx.scala.redis.op.ScanOptions
import io.vertx.core.buffer.Buffer
import io.vertx.redis.op.{SortOptions => JSortOptions}
import io.vertx.redis.{RedisOptions => JRedisOptions}
import io.vertx.scala.redis.op.LimitOptions
import io.vertx.redis.op.{KillFilter => JKillFilter}
import io.vertx.core.Handler

class RedisClient(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Append a value to a key
    * @param key Key string
    * @param value Value to append
    */
  def append(key: String,value: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].append(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Authenticate to the server
    * @param password Password for authentication
    */
  def auth(password: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].auth(password.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Asynchronously rewrite the append-only file
    */
  def bgrewriteaof(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].bgrewriteaof({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Asynchronously save the dataset to disk
    */
  def bgsave(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].bgsave({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Count set bits in a string
    * @param key Key string
    */
  def bitcount(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].bitcount(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Count set bits in a string
    * @param key Key string
    * @param start Start index
    * @param end End index
    */
  def bitcountRange(key: String,start: Long,end: Long,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].bitcountRange(key.asInstanceOf[java.lang.String],start.asInstanceOf[java.lang.Long],end.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Perform bitwise operations between strings
    * @param operation Bitwise operation to perform
    * @param destkey Destination key where result is stored
    * @param keys List of keys on which to perform the operation
    */
  def bitop(operation: io.vertx.redis.op.BitOperation,destkey: String,keys: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].bitop(operation,destkey.asInstanceOf[java.lang.String],keys.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Find first bit set or clear in a string
    * @param key Key string
    * @param bit What bit value to look for - must be 1, or 0
    */
  def bitpos(key: String,bit: Int,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].bitpos(key.asInstanceOf[java.lang.String],bit.asInstanceOf[java.lang.Integer],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Find first bit set or clear in a string
    *
    * See also bitposRange() method, which takes start, and stop offset.
    * @param key Key string
    * @param bit What bit value to look for - must be 1, or 0
    * @param start Start offset
    */
  def bitposFrom(key: String,bit: Int,start: Int,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].bitposFrom(key.asInstanceOf[java.lang.String],bit.asInstanceOf[java.lang.Integer],start.asInstanceOf[java.lang.Integer],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Find first bit set or clear in a string
    *
    * Note: when both start, and stop offsets are specified,
    * behaviour is slightly different than if only start is specified
    * @param key Key string
    * @param bit What bit value to look for - must be 1, or 0
    * @param start Start offset
    * @param stop End offset - inclusive
    */
  def bitposRange(key: String,bit: Int,start: Int,stop: Int,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].bitposRange(key.asInstanceOf[java.lang.String],bit.asInstanceOf[java.lang.Integer],start.asInstanceOf[java.lang.Integer],stop.asInstanceOf[java.lang.Integer],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Remove and get the first element in a list, or block until one is available
    * @param key Key string identifying a list to watch
    * @param seconds Timeout in seconds
    */
  def blpop(key: String,seconds: Int,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].blpop(key.asInstanceOf[java.lang.String],seconds.asInstanceOf[java.lang.Integer],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Remove and get the first element in any of the lists, or block until one is available
    * @param keys List of key strings identifying lists to watch
    * @param seconds Timeout in seconds
    */
  def blpopMany(keys: scala.collection.mutable.Buffer[String],seconds: Int,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].blpopMany(keys.map(x => x.asInstanceOf[java.lang.String]).asJava,seconds.asInstanceOf[java.lang.Integer],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Remove and get the last element in a list, or block until one is available
    * @param key Key string identifying a list to watch
    * @param seconds Timeout in seconds
    */
  def brpop(key: String,seconds: Int,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].brpop(key.asInstanceOf[java.lang.String],seconds.asInstanceOf[java.lang.Integer],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Remove and get the last element in any of the lists, or block until one is available
    * @param keys List of key strings identifying lists to watch
    * @param seconds Timeout in seconds
    */
  def brpopMany(keys: scala.collection.mutable.Buffer[String],seconds: Int,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].brpopMany(keys.map(x => x.asInstanceOf[java.lang.String]).asJava,seconds.asInstanceOf[java.lang.Integer],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Pop a value from a list, push it to another list and return it; or block until one is available
    * @param key Key string identifying the source list
    * @param destkey Key string identifying the destination list
    * @param seconds Timeout in seconds
    */
  def brpoplpush(key: String,destkey: String,seconds: Int,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].brpoplpush(key.asInstanceOf[java.lang.String],destkey.asInstanceOf[java.lang.String],seconds.asInstanceOf[java.lang.Integer],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Kill the connection of a client
    * @param filter Filter optionssee <a href="../../../../../../cheatsheet/KillFilter.html">KillFilter</a>
    */
  def clientKill(filter: KillFilter,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clientKill(filter.asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Get the list of client connections
    */
  def clientList(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clientList({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Get the current connection name
    */
  def clientGetname(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clientGetname({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Stop processing commands from clients for some time
    * @param millis Pause time in milliseconds
    */
  def clientPause(millis: Long,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clientPause(millis.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Set the current connection name
    * @param name New name for current connection
    */
  def clientSetname(name: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clientSetname(name.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Assign new hash slots to receiving node.
    */
  def clusterAddslots(slots: scala.collection.mutable.Buffer[Long],handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterAddslots(slots.map(x => x.asInstanceOf[java.lang.Long]).asJava,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Return the number of failure reports active for a given node.
    */
  def clusterCountFailureReports(nodeId: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterCountFailureReports(nodeId.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Return the number of local keys in the specified hash slot.
    */
  def clusterCountkeysinslot(slot: Long,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterCountkeysinslot(slot.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Set hash slots as unbound in receiving node.
    */
  def clusterDelslots(slot: Long,handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterDelslots(slot.asInstanceOf[java.lang.Long],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Set hash slots as unbound in receiving node.
    */
  def clusterDelslotsMany(slots: scala.collection.mutable.Buffer[Long],handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterDelslotsMany(slots.map(x => x.asInstanceOf[java.lang.Long]).asJava,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Forces a slave to perform a manual failover of its master.
    */
  def clusterFailover(handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterFailover({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Forces a slave to perform a manual failover of its master.
    */
  def clusterFailOverWithOptions(options: io.vertx.redis.op.FailoverOptions,handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterFailOverWithOptions(options,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Remove a node from the nodes table.
    */
  def clusterForget(nodeId: String,handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterForget(nodeId.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Return local key names in the specified hash slot.
    */
  def clusterGetkeysinslot(slot: Long,count: Long,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterGetkeysinslot(slot.asInstanceOf[java.lang.Long],count.asInstanceOf[java.lang.Long],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Provides info about Redis Cluster node state.
    */
  def clusterInfo(handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterInfo({x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Returns the hash slot of the specified key.
    */
  def clusterKeyslot(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterKeyslot(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Force a node cluster to handshake with another node.
    */
  def clusterMeet(ip: String,port: Long,handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterMeet(ip.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Long],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Get Cluster config for the node.
    */
  def clusterNodes(handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterNodes({x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Reconfigure a node as a slave of the specified master node.
    */
  def clusterReplicate(nodeId: String,handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterReplicate(nodeId.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Reset a Redis Cluster node.
    */
  def clusterReset(handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterReset({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Reset a Redis Cluster node.
    */
  def clusterResetWithOptions(options: io.vertx.redis.op.ResetOptions,handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterResetWithOptions(options,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Forces the node to save cluster state on disk.
    */
  def clusterSaveconfig(handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterSaveconfig({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Set the configuration epoch in a new node.
    */
  def clusterSetConfigEpoch(epoch: Long,handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterSetConfigEpoch(epoch.asInstanceOf[java.lang.Long],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Bind an hash slot to a specific node.
    */
  def clusterSetslot(slot: Long,subcommand: io.vertx.redis.op.SlotCmd,handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterSetslot(slot.asInstanceOf[java.lang.Long],subcommand,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Bind an hash slot to a specific node.
    */
  def clusterSetslotWithNode(slot: Long,subcommand: io.vertx.redis.op.SlotCmd,nodeId: String,handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterSetslotWithNode(slot.asInstanceOf[java.lang.Long],subcommand,nodeId.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * List slave nodes of the specified master node.
    */
  def clusterSlaves(nodeId: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterSlaves(nodeId.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Get array of Cluster slot to node mappings
    */
  def clusterSlots(handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].clusterSlots({x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Get array of Redis command details
    */
  def command(handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].command({x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Get total number of Redis commands
    */
  def commandCount(handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].commandCount({x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Extract keys given a full Redis command
    */
  def commandGetkeys(handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].commandGetkeys({x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Get array of specific Redis command details
    * @param commands List of commands to get info for
    */
  def commandInfo(commands: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].commandInfo(commands.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Get the value of a configuration parameter
    * @param parameter Configuration parameter
    */
  def configGet(parameter: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].configGet(parameter.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Rewrite the configuration file with the in memory configuration
    */
  def configRewrite(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].configRewrite({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Set a configuration parameter to the given value
    * @param parameter Configuration parameter
    * @param value New value
    */
  def configSet(parameter: String,value: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].configSet(parameter.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Reset the stats returned by INFO
    */
  def configResetstat(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].configResetstat({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Return the number of keys in the selected database
    */
  def dbsize(handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].dbsize({x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Get debugging information about a key
    * @param key Key string
    */
  def debugObject(key: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].debugObject(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Make the server crash
    */
  def debugSegfault(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].debugSegfault({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Decrement the integer value of a key by one
    * @param key Key string
    */
  def decr(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].decr(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Decrement the integer value of a key by the given number
    * @param key Key string
    * @param decrement Value by which to decrement
    */
  def decrby(key: String,decrement: Long,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].decrby(key.asInstanceOf[java.lang.String],decrement.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Delete a key
    * @param key Keys to delete
    */
  def del(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].del(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Delete many keys
    * @param keys List of keys to delete
    */
  def delMany(keys: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].delMany(keys.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Return a serialized version of the value stored at the specified key.
    * @param key Key string
    */
  def dump(key: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].dump(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Echo the given string
    * @param message String to echo
    */
  def echo(message: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].echo(message.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Execute a Lua script server side. Due to the dynamic nature of this command any response type could be returned
    * for This reason and to ensure type safety the reply is always guaranteed to be a JsonArray.
    *
    * When a reply if for example a String the handler will be called with a JsonArray with a single element containing
    * the String.
    * @param script Lua script to evaluate
    * @param keys List of keys
    * @param args List of argument values
    */
  def eval(script: String,keys: scala.collection.mutable.Buffer[String],args: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].eval(script.asInstanceOf[java.lang.String],keys.map(x => x.asInstanceOf[java.lang.String]).asJava,args.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Execute a Lua script server side. Due to the dynamic nature of this command any response type could be returned
    * for This reason and to ensure type safety the reply is always guaranteed to be a JsonArray.
    *
    * When a reply if for example a String the handler will be called with a JsonArray with a single element containing
    * the String.
    * @param sha1 SHA1 digest of the script cached on the server
    * @param keys List of keys
    * @param values List of values
    */
  def evalsha(sha1: String,keys: scala.collection.mutable.Buffer[String],values: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].evalsha(sha1.asInstanceOf[java.lang.String],keys.map(x => x.asInstanceOf[java.lang.String]).asJava,values.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Determine if a key exists
    * @param key Key string
    */
  def exists(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].exists(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Set a key's time to live in seconds
    * @param key Key string
    * @param seconds Time to live in seconds
    */
  def expire(key: String,seconds: Int,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].expire(key.asInstanceOf[java.lang.String],seconds.asInstanceOf[java.lang.Integer],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Set the expiration for a key as a UNIX timestamp
    * @param key Key string
    * @param seconds Expiry time as Unix timestamp in seconds
    */
  def expireat(key: String,seconds: Long,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].expireat(key.asInstanceOf[java.lang.String],seconds.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Remove all keys from all databases
    */
  def flushall(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].flushall({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Remove all keys from the current database
    */
  def flushdb(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].flushdb({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Get the value of a key
    * @param key Key string
    */
  def get(key: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].get(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Get the value of a key - without decoding as utf-8
    * @param key Key string
    */
  def getBinary(key: String,handler: Handler[AsyncResult[io.vertx.core.buffer.Buffer]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].getBinary(key.asInstanceOf[java.lang.String],{x: AsyncResult[Buffer] => handler.handle(AsyncResultWrapper[Buffer,io.vertx.core.buffer.Buffer](x, a => a))})
    this
  }

  /**
    * Returns the bit value at offset in the string value stored at key
    * @param key Key string
    * @param offset Offset in bits
    */
  def getbit(key: String,offset: Long,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].getbit(key.asInstanceOf[java.lang.String],offset.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Get a substring of the string stored at a key
    * @param key Key string
    * @param start Start offset
    * @param end End offset - inclusive
    */
  def getrange(key: String,start: Long,end: Long,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].getrange(key.asInstanceOf[java.lang.String],start.asInstanceOf[java.lang.Long],end.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Set the string value of a key and return its old value
    * @param key Key of which value to set
    * @param value New value for the key
    */
  def getset(key: String,value: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].getset(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Delete one or more hash fields
    * @param key Key string
    * @param field Field name
    */
  def hdel(key: String,field: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hdel(key.asInstanceOf[java.lang.String],field.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Delete one or more hash fields
    * @param key Key string
    * @param fields Field names
    */
  def hdelMany(key: String,fields: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hdelMany(key.asInstanceOf[java.lang.String],fields.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Determine if a hash field exists
    * @param key Key string
    * @param field Field name
    */
  def hexists(key: String,field: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hexists(key.asInstanceOf[java.lang.String],field.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Get the value of a hash field
    * @param key Key string
    * @param field Field name
    */
  def hget(key: String,field: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hget(key.asInstanceOf[java.lang.String],field.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Get all the fields and values in a hash
    * @param key Key string
    */
  def hgetall(key: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hgetall(key.asInstanceOf[java.lang.String],{x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Increment the integer value of a hash field by the given number
    * @param key Key string
    * @param field Field name
    * @param increment Value by which to increment
    */
  def hincrby(key: String,field: String,increment: Long,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hincrby(key.asInstanceOf[java.lang.String],field.asInstanceOf[java.lang.String],increment.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Increment the float value of a hash field by the given amount
    * @param key Key string
    * @param field Field name
    * @param increment Value by which to increment
    */
  def hincrbyfloat(key: String,field: String,increment: Double,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hincrbyfloat(key.asInstanceOf[java.lang.String],field.asInstanceOf[java.lang.String],increment.asInstanceOf[java.lang.Double],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Get all the fields in a hash
    * @param key Key string
    */
  def hkeys(key: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hkeys(key.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Get the number of fields in a hash
    * @param key Key string
    */
  def hlen(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hlen(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Get the values of all the given hash fields
    * @param key Key string
    * @param fields Field names
    */
  def hmget(key: String,fields: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hmget(key.asInstanceOf[java.lang.String],fields.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Set multiple hash fields to multiple values
    * @param key Key string
    * @param values Map of field:value pairs
    */
  def hmset(key: String,values: io.vertx.core.json.JsonObject,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hmset(key.asInstanceOf[java.lang.String],values,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Set the string value of a hash field
    * @param key Key string
    * @param field Field name
    * @param value New value
    */
  def hset(key: String,field: String,value: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hset(key.asInstanceOf[java.lang.String],field.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Set the value of a hash field, only if the field does not exist
    * @param key Key string
    * @param field Field name
    * @param value New value
    */
  def hsetnx(key: String,field: String,value: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hsetnx(key.asInstanceOf[java.lang.String],field.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Get all the values in a hash
    * @param key Key string
    */
  def hvals(key: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hvals(key.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Increment the integer value of a key by one
    * @param key Key string
    */
  def incr(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].incr(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Increment the integer value of a key by the given amount
    * @param key Key string
    * @param increment Value by which to increment
    */
  def incrby(key: String,increment: Long,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].incrby(key.asInstanceOf[java.lang.String],increment.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Increment the float value of a key by the given amount
    * @param key Key string
    * @param increment Value by which to increment
    */
  def incrbyfloat(key: String,increment: Double,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].incrbyfloat(key.asInstanceOf[java.lang.String],increment.asInstanceOf[java.lang.Double],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Get information and statistics about the server
    */
  def info(handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].info({x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Get information and statistics about the server
    * @param section Specific section of information to return
    */
  def infoSection(section: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].infoSection(section.asInstanceOf[java.lang.String],{x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find all keys matching the given pattern
    * @param pattern Pattern to limit the keys returned
    */
  def keys(pattern: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].keys(pattern.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Get the UNIX time stamp of the last successful save to disk
    */
  def lastsave(handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].lastsave({x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Get an element from a list by its index
    * @param key Key string
    * @param index Index of list element to get
    */
  def lindex(key: String,index: Int,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].lindex(key.asInstanceOf[java.lang.String],index.asInstanceOf[java.lang.Integer],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Insert an element before or after another element in a list
    * @param key Key string
    * @param option BEFORE or AFTER
    * @param pivot Key to use as a pivot
    * @param value Value to be inserted before or after the pivot
    */
  def linsert(key: String,option: io.vertx.redis.op.InsertOptions,pivot: String,value: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].linsert(key.asInstanceOf[java.lang.String],option,pivot.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Get the length of a list
    * @param key String key
    */
  def llen(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].llen(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Remove and get the first element in a list
    * @param key String key
    */
  def lpop(key: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].lpop(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Prepend one or multiple values to a list
    * @param key Key string
    * @param values Values to be added at the beginning of the list, one by one
    */
  def lpushMany(key: String,values: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].lpushMany(key.asInstanceOf[java.lang.String],values.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Prepend one value to a list
    * @param key Key string
    * @param value Value to be added at the beginning of the list
    */
  def lpush(key: String,value: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].lpush(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Prepend a value to a list, only if the list exists
    * @param key Key string
    * @param value Value to add at the beginning of the list
    */
  def lpushx(key: String,value: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].lpushx(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Get a range of elements from a list
    * @param key Key string
    * @param from Start index
    * @param to Stop index
    */
  def lrange(key: String,from: Long,to: Long,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].lrange(key.asInstanceOf[java.lang.String],from.asInstanceOf[java.lang.Long],to.asInstanceOf[java.lang.Long],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Remove elements from a list
    * @param key Key string
    * @param count Number of first found occurrences equal to $value to remove from the list
    * @param value Value to be removed
    */
  def lrem(key: String,count: Long,value: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].lrem(key.asInstanceOf[java.lang.String],count.asInstanceOf[java.lang.Long],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Set the value of an element in a list by its index
    * @param key Key string
    * @param index Position within list
    * @param value New value
    */
  def lset(key: String,index: Long,value: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].lset(key.asInstanceOf[java.lang.String],index.asInstanceOf[java.lang.Long],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Trim a list to the specified range
    * @param key Key string
    * @param from Start index
    * @param to Stop index
    */
  def ltrim(key: String,from: Long,to: Long,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].ltrim(key.asInstanceOf[java.lang.String],from.asInstanceOf[java.lang.Long],to.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Get the value of the given key
    * @param key Key string
    */
  def mget(key: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].mget(key.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Get the values of all the given keys
    * @param keys List of keys to get
    */
  def mgetMany(keys: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].mgetMany(keys.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Atomically transfer a key from a Redis instance to another one.
    * @param host Destination host
    * @param port Destination port
    * @param key Key to migrate
    * @param destdb Destination database index
    * @param options Migrate optionssee <a href="../../../../../../cheatsheet/MigrateOptions.html">MigrateOptions</a>
    */
  def migrate(host: String,port: Int,key: String,destdb: Int,timeout: Long,options: MigrateOptions,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].migrate(host.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],key.asInstanceOf[java.lang.String],destdb.asInstanceOf[java.lang.Integer],timeout.asInstanceOf[java.lang.Long],options.asJava,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Listen for all requests received by the server in real time
    */
  def monitor(handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].monitor({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Move a key to another database
    * @param key Key to migrate
    * @param destdb Destination database index
    */
  def move(key: String,destdb: Int,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].move(key.asInstanceOf[java.lang.String],destdb.asInstanceOf[java.lang.Integer],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Set multiple keys to multiple values
    * @param keyvals Key value pairs to set
    */
  def mset(keyvals: io.vertx.core.json.JsonObject,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].mset(keyvals,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Set multiple keys to multiple values, only if none of the keys exist
    * @param keyvals Key value pairs to set
    */
  def msetnx(keyvals: io.vertx.core.json.JsonObject,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].msetnx(keyvals,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Inspect the internals of Redis objects
    * @param key Key string
    * @param cmd Object sub command
    */
  def `object`(key: String,cmd: io.vertx.redis.op.ObjectCmd,handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].`object`(key.asInstanceOf[java.lang.String],cmd,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Remove the expiration from a key
    * @param key Key string
    */
  def persist(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].persist(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Set a key's time to live in milliseconds
    * @param key String key
    * @param millis Time to live in milliseconds
    */
  def pexpire(key: String,millis: Long,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].pexpire(key.asInstanceOf[java.lang.String],millis.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Set the expiration for a key as a UNIX timestamp specified in milliseconds
    * @param key Key string
    * @param millis Expiry time as Unix timestamp in milliseconds
    */
  def pexpireat(key: String,millis: Long,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].pexpireat(key.asInstanceOf[java.lang.String],millis.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Adds the specified element to the specified HyperLogLog.
    * @param key Key string
    * @param element Element to add
    */
  def pfadd(key: String,element: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].pfadd(key.asInstanceOf[java.lang.String],element.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Adds the specified elements to the specified HyperLogLog.
    * @param key Key string
    * @param elements Elementa to add
    */
  def pfaddMany(key: String,elements: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].pfaddMany(key.asInstanceOf[java.lang.String],elements.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Return the approximated cardinality of the set observed by the HyperLogLog at key.
    * @param key Key string
    */
  def pfcount(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].pfcount(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Return the approximated cardinality of the set(s) observed by the HyperLogLog at key(s).
    * @param keys List of keys
    */
  def pfcountMany(keys: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].pfcountMany(keys.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Merge N different HyperLogLogs into a single one.
    * @param destkey Destination key
    * @param keys List of source keys
    */
  def pfmerge(destkey: String,keys: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].pfmerge(destkey.asInstanceOf[java.lang.String],keys.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Ping the server
    */
  def ping(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].ping({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Set the value and expiration in milliseconds of a key
    * @param key Key string
    * @param millis Number of milliseconds until the key expires
    * @param value New value for key
    */
  def psetex(key: String,millis: Long,value: String,handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].psetex(key.asInstanceOf[java.lang.String],millis.asInstanceOf[java.lang.Long],value.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Listen for messages published to channels matching the given pattern
    * @param pattern Pattern string
    */
  def psubscribe(pattern: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].psubscribe(pattern.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Listen for messages published to channels matching the given patterns
    * @param patterns List of patterns
    */
  def psubscribeMany(patterns: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].psubscribeMany(patterns.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Lists the currently active channels - only those matching the pattern
    * @param pattern A glob-style pattern - an empty string means no pattern
    */
  def pubsubChannels(pattern: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].pubsubChannels(pattern.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Returns the number of subscribers (not counting clients subscribed to patterns) for the specified channels
    * @param channels List of channels
    */
  def pubsubNumsub(channels: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].pubsubNumsub(channels.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Returns the number of subscriptions to patterns (that are performed using the PSUBSCRIBE command)
    */
  def pubsubNumpat(handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].pubsubNumpat({x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Get the time to live for a key in milliseconds
    * @param key Key string
    */
  def pttl(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].pttl(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Post a message to a channel
    * @param channel Channel key
    * @param message Message to send to channel
    */
  def publish(channel: String,message: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].publish(channel.asInstanceOf[java.lang.String],message.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Stop listening for messages posted to channels matching the given patterns
    * @param patterns List of patterns to match against
    */
  def punsubscribe(patterns: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].punsubscribe(patterns.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Return a random key from the keyspace
    */
  def randomkey(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].randomkey({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Rename a key
    * @param key Key string to be renamed
    * @param newkey New key string
    */
  def rename(key: String,newkey: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].rename(key.asInstanceOf[java.lang.String],newkey.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Rename a key, only if the new key does not exist
    * @param key Key string to be renamed
    * @param newkey New key string
    */
  def renamenx(key: String,newkey: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].renamenx(key.asInstanceOf[java.lang.String],newkey.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Create a key using the provided serialized value, previously obtained using DUMP.
    * @param key Key string
    * @param millis Expiry time in milliseconds to set on the key
    * @param serialized Serialized form of the key value as obtained using DUMP
    */
  def restore(key: String,millis: Long,serialized: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].restore(key.asInstanceOf[java.lang.String],millis.asInstanceOf[java.lang.Long],serialized.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Return the role of the instance in the context of replication
    */
  def role(handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].role({x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Remove and get the last element in a list
    * @param key Key string
    */
  def rpop(key: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].rpop(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Remove the last element in a list, append it to another list and return it
    * @param key Key string identifying source list
    * @param destkey Key string identifying destination list
    */
  def rpoplpush(key: String,destkey: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].rpoplpush(key.asInstanceOf[java.lang.String],destkey.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Append one or multiple values to a list
    * @param key Key string
    * @param values List of values to add to the end of the list
    */
  def rpushMany(key: String,values: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].rpushMany(key.asInstanceOf[java.lang.String],values.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Append one or multiple values to a list
    * @param key Key string
    * @param value Value to be added to the end of the list
    */
  def rpush(key: String,value: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].rpush(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Append a value to a list, only if the list exists
    * @param key Key string
    * @param value Value to be added to the end of the list
    */
  def rpushx(key: String,value: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].rpushx(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Add a member to a set
    * @param key Key string
    * @param member Value to be added to the set
    */
  def sadd(key: String,member: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].sadd(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Add one or more members to a set
    * @param key Key string
    * @param members Values to be added to the set
    */
  def saddMany(key: String,members: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].saddMany(key.asInstanceOf[java.lang.String],members.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Synchronously save the dataset to disk
    */
  def save(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].save({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Get the number of members in a set
    * @param key Key string
    */
  def scard(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].scard(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Check existence of script in the script cache.
    * @param script SHA1 digest identifying a script in the script cache
    */
  def scriptExists(script: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].scriptExists(script.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Check existence of scripts in the script cache.
    * @param scripts List of SHA1 digests identifying scripts in the script cache
    */
  def scriptExistsMany(scripts: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].scriptExistsMany(scripts.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Remove all the scripts from the script cache.
    */
  def scriptFlush(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].scriptFlush({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Kill the script currently in execution.
    */
  def scriptKill(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].scriptKill({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Load the specified Lua script into the script cache.
    * @param script Lua script
    */
  def scriptLoad(script: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].scriptLoad(script.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Subtract multiple sets
    * @param key Key identifying the set to compare with all other sets combined
    * @param cmpkeys List of keys identifying sets to subtract from the key set
    */
  def sdiff(key: String,cmpkeys: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].sdiff(key.asInstanceOf[java.lang.String],cmpkeys.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Subtract multiple sets and store the resulting set in a key
    * @param destkey Destination key where the result should be stored
    * @param key Key identifying the set to compare with all other sets combined
    * @param cmpkeys List of keys identifying sets to subtract from the key set
    */
  def sdiffstore(destkey: String,key: String,cmpkeys: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].sdiffstore(destkey.asInstanceOf[java.lang.String],key.asInstanceOf[java.lang.String],cmpkeys.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Change the selected database for the current connection
    * @param dbindex Index identifying the new active database
    */
  def select(dbindex: Int,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].select(dbindex.asInstanceOf[java.lang.Integer],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Set the string value of a key
    * @param key Key of which value to set
    * @param value New value for the key
    */
  def set(key: String,value: String,handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].set(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Set the string value of a key
    * @param key Key of which value to set
    * @param value New value for the key
    * @param options Set optionssee <a href="../../../../../../cheatsheet/SetOptions.html">SetOptions</a>
    */
  def setWithOptions(key: String,value: String,options: SetOptions,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].setWithOptions(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],options.asJava,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Set the binary string value of a key - without encoding as utf-8
    * @param key Key of which value to set
    * @param value New value for the key
    */
  def setBinary(key: String,value: io.vertx.core.buffer.Buffer,handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].setBinary(key.asInstanceOf[java.lang.String],value,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Set the string value of a key
    * @param key Key of which value to set
    * @param value New value for the key
    * @param options Set optionssee <a href="../../../../../../cheatsheet/SetOptions.html">SetOptions</a>
    */
  def setBinaryWithOptions(key: String,value: io.vertx.core.buffer.Buffer,options: SetOptions,handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].setBinaryWithOptions(key.asInstanceOf[java.lang.String],value,options.asJava,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Sets or clears the bit at offset in the string value stored at key
    * @param key Key string
    * @param offset Bit offset
    * @param bit New value - must be 1 or 0
    */
  def setbit(key: String,offset: Long,bit: Int,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].setbit(key.asInstanceOf[java.lang.String],offset.asInstanceOf[java.lang.Long],bit.asInstanceOf[java.lang.Integer],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Set the value and expiration of a key
    * @param key Key string
    * @param seconds Number of seconds until the key expires
    * @param value New value for key
    */
  def setex(key: String,seconds: Long,value: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].setex(key.asInstanceOf[java.lang.String],seconds.asInstanceOf[java.lang.Long],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Set the value of a key, only if the key does not exist
    * @param key Key of which value to set
    * @param value New value for the key
    */
  def setnx(key: String,value: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].setnx(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Overwrite part of a string at key starting at the specified offset
    * @param key Key string
    * @param offset Offset - the maximum offset that you can set is 2^29 -1 (536870911), as Redis Strings are limited to 512 megabytes
    * @param value Value to overwrite with
    */
  def setrange(key: String,offset: Int,value: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].setrange(key.asInstanceOf[java.lang.String],offset.asInstanceOf[java.lang.Integer],value.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Intersect multiple sets
    * @param keys List of keys to perform intersection on
    */
  def sinter(keys: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].sinter(keys.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Intersect multiple sets and store the resulting set in a key
    * @param destkey Key where to store the results
    * @param keys List of keys to perform intersection on
    */
  def sinterstore(destkey: String,keys: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].sinterstore(destkey.asInstanceOf[java.lang.String],keys.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Determine if a given value is a member of a set
    * @param key Key string
    * @param member Member to look for
    */
  def sismember(key: String,member: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].sismember(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Make the server a slave of another instance
    * @param host Host to become this server's master
    * @param port Port of our new master
    */
  def slaveof(host: String,port: Int,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].slaveof(host.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Make this server a master
    */
  def slaveofNoone(handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].slaveofNoone({x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Read the Redis slow queries log
    * @param limit Number of log entries to return. If value is less than zero all entries are returned
    */
  def slowlogGet(limit: Int,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].slowlogGet(limit.asInstanceOf[java.lang.Integer],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Get the length of the Redis slow queries log
    */
  def slowlogLen(handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].slowlogLen({x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Reset the Redis slow queries log
    */
  def slowlogReset(handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].slowlogReset({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Get all the members in a set
    * @param key Key string
    */
  def smembers(key: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].smembers(key.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Move a member from one set to another
    * @param key Key of source set currently containing the member
    * @param destkey Key identifying the destination set
    * @param member Member to move
    */
  def smove(key: String,destkey: String,member: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].smove(key.asInstanceOf[java.lang.String],destkey.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Sort the elements in a list, set or sorted set
    * @param key Key string
    * @param options Sort optionssee <a href="../../../../../../cheatsheet/SortOptions.html">SortOptions</a>
    */
  def sort(key: String,options: SortOptions,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].sort(key.asInstanceOf[java.lang.String],options.asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Remove and return a random member from a set
    * @param key Key string
    */
  def spop(key: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].spop(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Remove and return random members from a set
    * @param key Key string
    * @param count Number of members to remove
    */
  def spopMany(key: String,count: Int,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].spopMany(key.asInstanceOf[java.lang.String],count.asInstanceOf[java.lang.Integer],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Get one or multiple random members from a set
    * @param key Key string
    */
  def srandmember(key: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].srandmember(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Get one or multiple random members from a set
    * @param key Key string
    * @param count Number of members to get
    */
  def srandmemberCount(key: String,count: Int,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].srandmemberCount(key.asInstanceOf[java.lang.String],count.asInstanceOf[java.lang.Integer],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Remove one member from a set
    * @param key Key string
    * @param member Member to remove
    */
  def srem(key: String,member: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].srem(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Remove one or more members from a set
    * @param key Key string
    * @param members Members to remove
    */
  def sremMany(key: String,members: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].sremMany(key.asInstanceOf[java.lang.String],members.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Get the length of the value stored in a key
    * @param key Key string
    */
  def strlen(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].strlen(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Listen for messages published to the given channels
    * @param channel Channel to subscribe to
    */
  def subscribe(channel: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].subscribe(channel.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Listen for messages published to the given channels
    * @param channels List of channels to subscribe to
    */
  def subscribeMany(channels: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].subscribeMany(channels.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Add multiple sets
    * @param keys List of keys identifying sets to add up
    */
  def sunion(keys: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].sunion(keys.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Add multiple sets and store the resulting set in a key
    * @param destkey Destination key
    * @param keys List of keys identifying sets to add up
    */
  def sunionstore(destkey: String,keys: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].sunionstore(destkey.asInstanceOf[java.lang.String],keys.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Internal command used for replication
    */
  def sync(handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].sync({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Return the current server time
    */
  def time(handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].time({x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Get the time to live for a key
    * @param key Key string
    */
  def ttl(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].ttl(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Determine the type stored at key
    * @param key Key string
    */
  def `type`(key: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].`type`(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Stop listening for messages posted to the given channels
    * @param channels List of channels to subscribe to
    */
  def unsubscribe(channels: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Unit]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].unsubscribe(channels.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Wait for the synchronous replication of all the write commands sent in the context of the current connection.
    */
  def wait(numSlaves: Long,timeout: Long,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].wait(numSlaves.asInstanceOf[java.lang.Long],timeout.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Add one or more members to a sorted set, or update its score if it already exists
    * @param key Key string
    * @param score Score used for sorting
    * @param member New member key
    */
  def zadd(key: String,score: Double,member: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zadd(key.asInstanceOf[java.lang.String],score.asInstanceOf[java.lang.Double],member.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Add one or more members to a sorted set, or update its score if it already exists
    * @param key Key string
    * @param members New member keys and their scores
    */
  def zaddMany(key: String,members: scala.collection.mutable.Map[String, Double],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zaddMany(key.asInstanceOf[java.lang.String],members.mapValues(x => x.asInstanceOf[java.lang.Double]).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Get the number of members in a sorted set
    * @param key Key string
    */
  def zcard(key: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zcard(key.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Count the members in a sorted set with scores within the given values
    * @param key Key string
    * @param min Minimum score
    * @param max Maximum score
    */
  def zcount(key: String,min: Double,max: Double,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zcount(key.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.Double],max.asInstanceOf[java.lang.Double],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Increment the score of a member in a sorted set
    * @param key Key string
    * @param increment Increment amount
    * @param member Member key
    */
  def zincrby(key: String,increment: Double,member: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zincrby(key.asInstanceOf[java.lang.String],increment.asInstanceOf[java.lang.Double],member.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Intersect multiple sorted sets and store the resulting sorted set in a new key
    * @param destkey Destination key
    * @param sets List of keys identifying sorted sets to intersect
    * @param options Aggregation options
    */
  def zinterstore(destkey: String,sets: scala.collection.mutable.Buffer[String],options: io.vertx.redis.op.AggregateOptions,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zinterstore(destkey.asInstanceOf[java.lang.String],sets.map(x => x.asInstanceOf[java.lang.String]).asJava,options,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Intersect multiple sorted sets and store the resulting sorted set in a new key using weights for scoring
    * @param destkey Destination key
    * @param sets List of keys identifying sorted sets to intersect
    * @param options Aggregation options
    */
  def zinterstoreWeighed(destkey: String,sets: scala.collection.mutable.Map[String, Double],options: io.vertx.redis.op.AggregateOptions,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zinterstoreWeighed(destkey.asInstanceOf[java.lang.String],sets.mapValues(x => x.asInstanceOf[java.lang.Double]).asJava,options,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Count the number of members in a sorted set between a given lexicographical range
    * @param key Key string
    * @param min Pattern to compare against for minimum value
    * @param max Pattern to compare against for maximum value
    */
  def zlexcount(key: String,min: String,max: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zlexcount(key.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.String],max.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Return a range of members in a sorted set, by index
    * @param key Key string
    * @param start Start index for the range
    * @param stop Stop index for the range - inclusive
    */
  def zrange(key: String,start: Long,stop: Long,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zrange(key.asInstanceOf[java.lang.String],start.asInstanceOf[java.lang.Long],stop.asInstanceOf[java.lang.Long],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Return a range of members in a sorted set, by index
    * @param key Key string
    * @param start Start index for the range
    * @param stop Stop index for the range - inclusive
    * @param options Range options
    */
  def zrangeWithOptions(key: String,start: Long,stop: Long,options: io.vertx.redis.op.RangeOptions,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zrangeWithOptions(key.asInstanceOf[java.lang.String],start.asInstanceOf[java.lang.Long],stop.asInstanceOf[java.lang.Long],options,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Return a range of members in a sorted set, by lexicographical range
    * @param key Key string
    * @param min Pattern representing a minimum allowed value
    * @param max Pattern representing a maximum allowed value
    * @param options Limit options where limit can be specifiedsee <a href="../../../../../../cheatsheet/LimitOptions.html">LimitOptions</a>
    */
  def zrangebylex(key: String,min: String,max: String,options: LimitOptions,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zrangebylex(key.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.String],max.asInstanceOf[java.lang.String],options.asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Return a range of members in a sorted set, by score
    * @param key Key string
    * @param min Pattern defining a minimum value
    * @param max Pattern defining a maximum value
    * @param options Range and limit optionssee <a href="../../../../../../cheatsheet/RangeLimitOptions.html">RangeLimitOptions</a>
    */
  def zrangebyscore(key: String,min: String,max: String,options: RangeLimitOptions,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zrangebyscore(key.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.String],max.asInstanceOf[java.lang.String],options.asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Determine the index of a member in a sorted set
    * @param key Key string
    * @param member Member in the sorted set identified by key
    */
  def zrank(key: String,member: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zrank(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Remove one member from a sorted set
    * @param key Key string
    * @param member Member in the sorted set identified by key
    */
  def zrem(key: String,member: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zrem(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Remove one or more members from a sorted set
    * @param key Key string
    * @param members Members in the sorted set identified by key
    */
  def zremMany(key: String,members: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zremMany(key.asInstanceOf[java.lang.String],members.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Remove all members in a sorted set between the given lexicographical range
    * @param key Key string
    * @param min Pattern defining a minimum value
    * @param max Pattern defining a maximum value
    */
  def zremrangebylex(key: String,min: String,max: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zremrangebylex(key.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.String],max.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Remove all members in a sorted set within the given indexes
    * @param key Key string
    * @param start Start index
    * @param stop Stop index
    */
  def zremrangebyrank(key: String,start: Long,stop: Long,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zremrangebyrank(key.asInstanceOf[java.lang.String],start.asInstanceOf[java.lang.Long],stop.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Remove all members in a sorted set within the given scores
    * @param key Key string
    * @param min Pattern defining a minimum value
    * @param max Pattern defining a maximum value
    */
  def zremrangebyscore(key: String,min: String,max: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zremrangebyscore(key.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.String],max.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Return a range of members in a sorted set, by index, with scores ordered from high to low
    * @param key Key string
    * @param start Start index for the range
    * @param stop Stop index for the range - inclusive
    * @param options Range options
    */
  def zrevrange(key: String,start: Long,stop: Long,options: io.vertx.redis.op.RangeOptions,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zrevrange(key.asInstanceOf[java.lang.String],start.asInstanceOf[java.lang.Long],stop.asInstanceOf[java.lang.Long],options,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Return a range of members in a sorted set, by score, between the given lexicographical range with scores ordered from high to low
    * @param key Key string
    * @param max Pattern defining a maximum value
    * @param min Pattern defining a minimum value
    * @param options Limit optionssee <a href="../../../../../../cheatsheet/LimitOptions.html">LimitOptions</a>
    */
  def zrevrangebylex(key: String,max: String,min: String,options: LimitOptions,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zrevrangebylex(key.asInstanceOf[java.lang.String],max.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.String],options.asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Return a range of members in a sorted set, by score, with scores ordered from high to low
    * @param key Key string
    * @param max Pattern defining a maximum value
    * @param min Pattern defining a minimum value
    * @param options Range and limit optionssee <a href="../../../../../../cheatsheet/RangeLimitOptions.html">RangeLimitOptions</a>
    */
  def zrevrangebyscore(key: String,max: String,min: String,options: RangeLimitOptions,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zrevrangebyscore(key.asInstanceOf[java.lang.String],max.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.String],options.asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Determine the index of a member in a sorted set, with scores ordered from high to low
    * @param key Key string
    * @param member Member in the sorted set identified by key
    */
  def zrevrank(key: String,member: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zrevrank(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Get the score associated with the given member in a sorted set
    * @param key Key string
    * @param member Member in the sorted set identified by key
    */
  def zscore(key: String,member: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zscore(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Add multiple sorted sets and store the resulting sorted set in a new key
    * @param destkey Destination key
    * @param sets List of keys identifying sorted sets
    * @param options Aggregation options
    */
  def zunionstore(destkey: String,sets: scala.collection.mutable.Buffer[String],options: io.vertx.redis.op.AggregateOptions,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zunionstore(destkey.asInstanceOf[java.lang.String],sets.map(x => x.asInstanceOf[java.lang.String]).asJava,options,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Add multiple sorted sets using weights, and store the resulting sorted set in a new key
    * @param key Destination key
    * @param sets Map containing set-key:weight pairs
    * @param options Aggregation options
    */
  def zunionstoreWeighed(key: String,sets: scala.collection.mutable.Map[String, Double],options: io.vertx.redis.op.AggregateOptions,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zunionstoreWeighed(key.asInstanceOf[java.lang.String],sets.mapValues(x => x.asInstanceOf[java.lang.Double]).asJava,options,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Incrementally iterate the keys space
    * @param cursor Cursor id
    * @param options Scan optionssee <a href="../../../../../../cheatsheet/ScanOptions.html">ScanOptions</a>
    */
  def scan(cursor: String,options: ScanOptions,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].scan(cursor.asInstanceOf[java.lang.String],options.asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Incrementally iterate Set elements
    * @param key Key string
    * @param cursor Cursor id
    * @param options Scan optionssee <a href="../../../../../../cheatsheet/ScanOptions.html">ScanOptions</a>
    */
  def sscan(key: String,cursor: String,options: ScanOptions,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].sscan(key.asInstanceOf[java.lang.String],cursor.asInstanceOf[java.lang.String],options.asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Incrementally iterate hash fields and associated values
    * @param key Key string
    * @param cursor Cursor id
    * @param options Scan optionssee <a href="../../../../../../cheatsheet/ScanOptions.html">ScanOptions</a>
    */
  def hscan(key: String,cursor: String,options: ScanOptions,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].hscan(key.asInstanceOf[java.lang.String],cursor.asInstanceOf[java.lang.String],options.asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Incrementally iterate sorted sets elements and associated scores
    * @param key Key string
    * @param cursor Cursor id
    * @param options Scan optionssee <a href="../../../../../../cheatsheet/ScanOptions.html">ScanOptions</a>
    */
  def zscan(key: String,cursor: String,options: ScanOptions,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].zscan(key.asInstanceOf[java.lang.String],cursor.asInstanceOf[java.lang.String],options.asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Add one or more geospatial items in the geospatial index represented using a sorted set.
    * @param key Key string
    * @param longitude longitude
    * @param latitude latitude
    * @param member member
    */
  def geoadd(key: String,longitude: Double,latitude: Double,member: String,handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].geoadd(key.asInstanceOf[java.lang.String],longitude.asInstanceOf[java.lang.Double],latitude.asInstanceOf[java.lang.Double],member.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Add one or more geospatial items in the geospatial index represented using a sorted set.
    * @param key Key string
    * @param members list of &lt;lon, lat, member&gt;
    */
  def geoaddMany(key: String,members: scala.collection.mutable.Buffer[GeoMember],handler: Handler[AsyncResult[Long]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].geoaddMany(key.asInstanceOf[java.lang.String],members.map(x => x.asJava).asJava,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Return valid Geohash strings representing the position of one or more elements in a sorted set value representing
    * a geospatial index (where elements were added using GEOADD).
    * @param key Key string
    * @param member member
    */
  def geohash(key: String,member: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].geohash(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Return valid Geohash strings representing the position of one or more elements in a sorted set value representing
    * a geospatial index (where elements were added using GEOADD).
    * @param key Key string
    * @param members list of members
    */
  def geohashMany(key: String,members: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].geohashMany(key.asInstanceOf[java.lang.String],members.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Return the positions (longitude,latitude) of all the specified members of the geospatial index represented by the
    * sorted set at key.
    * @param key Key string
    * @param member member
    */
  def geopos(key: String,member: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].geopos(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Return the positions (longitude,latitude) of all the specified members of the geospatial index represented by the
    * sorted set at key.
    * @param key Key string
    * @param members list of members
    */
  def geoposMany(key: String,members: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].geoposMany(key.asInstanceOf[java.lang.String],members.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Return the distance between two members in the geospatial index represented by the sorted set.
    * @param key Key string
    * @param member1 member 1
    * @param member2 member 2
    */
  def geodist(key: String,member1: String,member2: String,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].geodist(key.asInstanceOf[java.lang.String],member1.asInstanceOf[java.lang.String],member2.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Return the distance between two members in the geospatial index represented by the sorted set.
    * @param key Key string
    * @param member1 member 1
    * @param member2 member 2
    * @param unit geo unit
    */
  def geodistWithUnit(key: String,member1: String,member2: String,unit: io.vertx.redis.op.GeoUnit,handler: Handler[AsyncResult[String]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].geodistWithUnit(key.asInstanceOf[java.lang.String],member1.asInstanceOf[java.lang.String],member2.asInstanceOf[java.lang.String],unit,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Return the members of a sorted set populated with geospatial information using GEOADD, which are within the borders
    * of the area specified with the center location and the maximum distance from the center (the radius).
    * @param key Key string
    * @param longitude longitude
    * @param latitude latitude
    * @param radius radius
    * @param unit geo unit
    */
  def georadius(key: String,longitude: Double,latitude: Double,radius: Double,unit: io.vertx.redis.op.GeoUnit,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].georadius(key.asInstanceOf[java.lang.String],longitude.asInstanceOf[java.lang.Double],latitude.asInstanceOf[java.lang.Double],radius.asInstanceOf[java.lang.Double],unit,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Return the members of a sorted set populated with geospatial information using GEOADD, which are within the borders
    * of the area specified with the center location and the maximum distance from the center (the radius).
    * @param key Key string
    * @param longitude longitude
    * @param latitude latitude
    * @param radius radius
    * @param unit geo unit
    * @param options geo radius optionssee <a href="../../../../../../cheatsheet/GeoRadiusOptions.html">GeoRadiusOptions</a>
    */
  def georadiusWithOptions(key: String,longitude: Double,latitude: Double,radius: Double,unit: io.vertx.redis.op.GeoUnit,options: GeoRadiusOptions,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].georadiusWithOptions(key.asInstanceOf[java.lang.String],longitude.asInstanceOf[java.lang.Double],latitude.asInstanceOf[java.lang.Double],radius.asInstanceOf[java.lang.Double],unit,options.asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * This command is exactly like GEORADIUS with the sole difference that instead of taking, as the center of the area
    * to query, a longitude and latitude value, it takes the name of a member already existing inside the geospatial
    * index represented by the sorted set.
    * @param key Key string
    * @param member member
    * @param radius radius
    * @param unit geo unit
    */
  def georadiusbymember(key: String,member: String,radius: Double,unit: io.vertx.redis.op.GeoUnit,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].georadiusbymember(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],radius.asInstanceOf[java.lang.Double],unit,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * This command is exactly like GEORADIUS with the sole difference that instead of taking, as the center of the area
    * to query, a longitude and latitude value, it takes the name of a member already existing inside the geospatial
    * index represented by the sorted set.
    * @param key Key string
    * @param member member
    * @param radius radius
    * @param unit geo unit
    * @param options geo radius optionssee <a href="../../../../../../cheatsheet/GeoRadiusOptions.html">GeoRadiusOptions</a>
    */
  def georadiusbymemberWithOptions(key: String,member: String,radius: Double,unit: io.vertx.redis.op.GeoUnit,options: GeoRadiusOptions,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):RedisClient = {
    asJava.asInstanceOf[JRedisClient].georadiusbymemberWithOptions(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],radius.asInstanceOf[java.lang.Double],unit,options.asJava,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Close the client - when it is fully closed the handler will be called.
    */
  def close(handler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JRedisClient].close({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  /**
    * Return a RedisTransaction instance
    * @return transaction instance
    */
  def transaction():RedisTransaction = {
    RedisTransaction(asJava.asInstanceOf[JRedisClient].transaction())
  }

 /**
   * Close the client - when it is fully closed the handler will be called.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def closeFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Append a value to a key
   * @param key Key string
   * @param value Value to append
   * @return Handler for the result of this call.
   */
  def appendFuture(key: String,value: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].append(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Authenticate to the server
   * @param password Password for authentication
   * @return Handler for the result of this call.
   */
  def authFuture(password: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].auth(password.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Asynchronously rewrite the append-only file
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def bgrewriteaofFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].bgrewriteaof(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Asynchronously save the dataset to disk
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def bgsaveFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].bgsave(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Count set bits in a string
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def bitcountFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].bitcount(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Count set bits in a string
   * @param key Key string
   * @param start Start index
   * @param end End index
   * @return Handler for the result of this call.
   */
  def bitcountRangeFuture(key: String,start: Long,end: Long):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].bitcountRange(key.asInstanceOf[java.lang.String],start.asInstanceOf[java.lang.Long],end.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Perform bitwise operations between strings
   * @param operation Bitwise operation to perform
   * @param destkey Destination key where result is stored
   * @param keys List of keys on which to perform the operation
   * @return Handler for the result of this call.
   */
  def bitopFuture(operation: io.vertx.redis.op.BitOperation,destkey: String,keys: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].bitop(operation,destkey.asInstanceOf[java.lang.String],keys.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Find first bit set or clear in a string
   * @param key Key string
   * @param bit What bit value to look for - must be 1, or 0
   * @return Handler for the result of this call.
   */
  def bitposFuture(key: String,bit: Int):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].bitpos(key.asInstanceOf[java.lang.String],bit.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Find first bit set or clear in a string
   *
   * See also bitposRange() method, which takes start, and stop offset.
   * @param key Key string
   * @param bit What bit value to look for - must be 1, or 0
   * @param start Start offset
   * @return Handler for the result of this call.
   */
  def bitposFromFuture(key: String,bit: Int,start: Int):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].bitposFrom(key.asInstanceOf[java.lang.String],bit.asInstanceOf[java.lang.Integer],start.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Find first bit set or clear in a string
   *
   * Note: when both start, and stop offsets are specified,
   * behaviour is slightly different than if only start is specified
   * @param key Key string
   * @param bit What bit value to look for - must be 1, or 0
   * @param start Start offset
   * @param stop End offset - inclusive
   * @return Handler for the result of this call.
   */
  def bitposRangeFuture(key: String,bit: Int,start: Int,stop: Int):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].bitposRange(key.asInstanceOf[java.lang.String],bit.asInstanceOf[java.lang.Integer],start.asInstanceOf[java.lang.Integer],stop.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove and get the first element in a list, or block until one is available
   * @param key Key string identifying a list to watch
   * @param seconds Timeout in seconds
   * @return Handler for the result of this call.
   */
  def blpopFuture(key: String,seconds: Int):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].blpop(key.asInstanceOf[java.lang.String],seconds.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove and get the first element in any of the lists, or block until one is available
   * @param keys List of key strings identifying lists to watch
   * @param seconds Timeout in seconds
   * @return Handler for the result of this call.
   */
  def blpopManyFuture(keys: scala.collection.mutable.Buffer[String],seconds: Int):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].blpopMany(keys.map(x => x.asInstanceOf[java.lang.String]).asJava,seconds.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove and get the last element in a list, or block until one is available
   * @param key Key string identifying a list to watch
   * @param seconds Timeout in seconds
   * @return Handler for the result of this call.
   */
  def brpopFuture(key: String,seconds: Int):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].brpop(key.asInstanceOf[java.lang.String],seconds.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove and get the last element in any of the lists, or block until one is available
   * @param keys List of key strings identifying lists to watch
   * @param seconds Timeout in seconds
   * @return Handler for the result of this call.
   */
  def brpopManyFuture(keys: scala.collection.mutable.Buffer[String],seconds: Int):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].brpopMany(keys.map(x => x.asInstanceOf[java.lang.String]).asJava,seconds.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Pop a value from a list, push it to another list and return it; or block until one is available
   * @param key Key string identifying the source list
   * @param destkey Key string identifying the destination list
   * @param seconds Timeout in seconds
   * @return Handler for the result of this call.
   */
  def brpoplpushFuture(key: String,destkey: String,seconds: Int):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].brpoplpush(key.asInstanceOf[java.lang.String],destkey.asInstanceOf[java.lang.String],seconds.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Kill the connection of a client
   * @param filter Filter optionssee <a href="../../../../../../cheatsheet/KillFilter.html">KillFilter</a>
   * @return Handler for the result of this call.
   */
  def clientKillFuture(filter: KillFilter):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].clientKill(filter.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the list of client connections
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def clientListFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].clientList(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the current connection name
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def clientGetnameFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].clientGetname(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Stop processing commands from clients for some time
   * @param millis Pause time in milliseconds
   * @return Handler for the result of this call.
   */
  def clientPauseFuture(millis: Long):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].clientPause(millis.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the current connection name
   * @param name New name for current connection
   * @return Handler for the result of this call.
   */
  def clientSetnameFuture(name: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].clientSetname(name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Assign new hash slots to receiving node.
   * @return Handler for the result of this call.
   */
  def clusterAddslotsFuture(slots: scala.collection.mutable.Buffer[Long]):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].clusterAddslots(slots.map(x => x.asInstanceOf[java.lang.Long]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return the number of failure reports active for a given node.
   * @return Handler for the result of this call.
   */
  def clusterCountFailureReportsFuture(nodeId: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].clusterCountFailureReports(nodeId.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return the number of local keys in the specified hash slot.
   * @return Handler for the result of this call.
   */
  def clusterCountkeysinslotFuture(slot: Long):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].clusterCountkeysinslot(slot.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set hash slots as unbound in receiving node.
   * @return Handler for the result of this call.
   */
  def clusterDelslotsFuture(slot: Long):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].clusterDelslots(slot.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set hash slots as unbound in receiving node.
   * @return Handler for the result of this call.
   */
  def clusterDelslotsManyFuture(slots: scala.collection.mutable.Buffer[Long]):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].clusterDelslotsMany(slots.map(x => x.asInstanceOf[java.lang.Long]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Forces a slave to perform a manual failover of its master.
   * @return Handler for the result of this call.
   */
  def clusterFailoverFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].clusterFailover(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Forces a slave to perform a manual failover of its master.
   * @return Handler for the result of this call.
   */
  def clusterFailOverWithOptionsFuture(options: io.vertx.redis.op.FailoverOptions):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].clusterFailOverWithOptions(options,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove a node from the nodes table.
   * @return Handler for the result of this call.
   */
  def clusterForgetFuture(nodeId: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].clusterForget(nodeId.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return local key names in the specified hash slot.
   * @return Handler for the result of this call.
   */
  def clusterGetkeysinslotFuture(slot: Long,count: Long):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].clusterGetkeysinslot(slot.asInstanceOf[java.lang.Long],count.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Provides info about Redis Cluster node state.
   * @return Handler for the result of this call.
   */
  def clusterInfoFuture():scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].clusterInfo(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Returns the hash slot of the specified key.
   * @return Handler for the result of this call.
   */
  def clusterKeyslotFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].clusterKeyslot(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Force a node cluster to handshake with another node.
   * @return Handler for the result of this call.
   */
  def clusterMeetFuture(ip: String,port: Long):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].clusterMeet(ip.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get Cluster config for the node.
   * @return Handler for the result of this call.
   */
  def clusterNodesFuture():scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].clusterNodes(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Reconfigure a node as a slave of the specified master node.
   * @return Handler for the result of this call.
   */
  def clusterReplicateFuture(nodeId: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].clusterReplicate(nodeId.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Reset a Redis Cluster node.
   * @return Handler for the result of this call.
   */
  def clusterResetFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].clusterReset(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Reset a Redis Cluster node.
   * @return Handler for the result of this call.
   */
  def clusterResetWithOptionsFuture(options: io.vertx.redis.op.ResetOptions):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].clusterResetWithOptions(options,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Forces the node to save cluster state on disk.
   * @return Handler for the result of this call.
   */
  def clusterSaveconfigFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].clusterSaveconfig(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the configuration epoch in a new node.
   * @return Handler for the result of this call.
   */
  def clusterSetConfigEpochFuture(epoch: Long):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].clusterSetConfigEpoch(epoch.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Bind an hash slot to a specific node.
   * @return Handler for the result of this call.
   */
  def clusterSetslotFuture(slot: Long,subcommand: io.vertx.redis.op.SlotCmd):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].clusterSetslot(slot.asInstanceOf[java.lang.Long],subcommand,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Bind an hash slot to a specific node.
   * @return Handler for the result of this call.
   */
  def clusterSetslotWithNodeFuture(slot: Long,subcommand: io.vertx.redis.op.SlotCmd,nodeId: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].clusterSetslotWithNode(slot.asInstanceOf[java.lang.Long],subcommand,nodeId.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * List slave nodes of the specified master node.
   * @return Handler for the result of this call.
   */
  def clusterSlavesFuture(nodeId: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].clusterSlaves(nodeId.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get array of Cluster slot to node mappings
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def clusterSlotsFuture():scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].clusterSlots(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get array of Redis command details
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def commandFuture():scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].command(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get total number of Redis commands
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def commandCountFuture():scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].commandCount(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Extract keys given a full Redis command
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def commandGetkeysFuture():scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].commandGetkeys(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get array of specific Redis command details
   * @param commands List of commands to get info for
   * @return Handler for the result of this call.
   */
  def commandInfoFuture(commands: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].commandInfo(commands.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the value of a configuration parameter
   * @param parameter Configuration parameter
   * @return Handler for the result of this call.
   */
  def configGetFuture(parameter: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].configGet(parameter.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Rewrite the configuration file with the in memory configuration
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def configRewriteFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].configRewrite(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set a configuration parameter to the given value
   * @param parameter Configuration parameter
   * @param value New value
   * @return Handler for the result of this call.
   */
  def configSetFuture(parameter: String,value: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].configSet(parameter.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Reset the stats returned by INFO
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def configResetstatFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].configResetstat(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return the number of keys in the selected database
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def dbsizeFuture():scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].dbsize(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get debugging information about a key
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def debugObjectFuture(key: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].debugObject(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Make the server crash
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def debugSegfaultFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].debugSegfault(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Decrement the integer value of a key by one
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def decrFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].decr(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Decrement the integer value of a key by the given number
   * @param key Key string
   * @param decrement Value by which to decrement
   * @return Handler for the result of this call.
   */
  def decrbyFuture(key: String,decrement: Long):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].decrby(key.asInstanceOf[java.lang.String],decrement.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Delete a key
   * @param key Keys to delete
   * @return Handler for the result of this call.
   */
  def delFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].del(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Delete many keys
   * @param keys List of keys to delete
   * @return Handler for the result of this call.
   */
  def delManyFuture(keys: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].delMany(keys.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return a serialized version of the value stored at the specified key.
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def dumpFuture(key: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].dump(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Echo the given string
   * @param message String to echo
   * @return Handler for the result of this call.
   */
  def echoFuture(message: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].echo(message.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Execute a Lua script server side. Due to the dynamic nature of this command any response type could be returned
   * for This reason and to ensure type safety the reply is always guaranteed to be a JsonArray.
   *
   * When a reply if for example a String the handler will be called with a JsonArray with a single element containing
   * the String.
   * @param script Lua script to evaluate
   * @param keys List of keys
   * @param args List of argument values
   * @return Handler for the result of this call.
   */
  def evalFuture(script: String,keys: scala.collection.mutable.Buffer[String],args: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].eval(script.asInstanceOf[java.lang.String],keys.map(x => x.asInstanceOf[java.lang.String]).asJava,args.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Execute a Lua script server side. Due to the dynamic nature of this command any response type could be returned
   * for This reason and to ensure type safety the reply is always guaranteed to be a JsonArray.
   *
   * When a reply if for example a String the handler will be called with a JsonArray with a single element containing
   * the String.
   * @param sha1 SHA1 digest of the script cached on the server
   * @param keys List of keys
   * @param values List of values
   * @return Handler for the result of this call.
   */
  def evalshaFuture(sha1: String,keys: scala.collection.mutable.Buffer[String],values: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].evalsha(sha1.asInstanceOf[java.lang.String],keys.map(x => x.asInstanceOf[java.lang.String]).asJava,values.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Determine if a key exists
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def existsFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].exists(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set a key's time to live in seconds
   * @param key Key string
   * @param seconds Time to live in seconds
   * @return Handler for the result of this call.
   */
  def expireFuture(key: String,seconds: Int):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].expire(key.asInstanceOf[java.lang.String],seconds.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the expiration for a key as a UNIX timestamp
   * @param key Key string
   * @param seconds Expiry time as Unix timestamp in seconds
   * @return Handler for the result of this call.
   */
  def expireatFuture(key: String,seconds: Long):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].expireat(key.asInstanceOf[java.lang.String],seconds.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove all keys from all databases
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def flushallFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].flushall(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove all keys from the current database
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def flushdbFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].flushdb(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the value of a key
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def getFuture(key: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].get(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the value of a key - without decoding as utf-8
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def getBinaryFuture(key: String):scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Buffer, io.vertx.core.buffer.Buffer](x => x)
    asJava.asInstanceOf[JRedisClient].getBinary(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Returns the bit value at offset in the string value stored at key
   * @param key Key string
   * @param offset Offset in bits
   * @return Handler for the result of this call.
   */
  def getbitFuture(key: String,offset: Long):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].getbit(key.asInstanceOf[java.lang.String],offset.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get a substring of the string stored at a key
   * @param key Key string
   * @param start Start offset
   * @param end End offset - inclusive
   * @return Handler for the result of this call.
   */
  def getrangeFuture(key: String,start: Long,end: Long):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].getrange(key.asInstanceOf[java.lang.String],start.asInstanceOf[java.lang.Long],end.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the string value of a key and return its old value
   * @param key Key of which value to set
   * @param value New value for the key
   * @return Handler for the result of this call.
   */
  def getsetFuture(key: String,value: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].getset(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Delete one or more hash fields
   * @param key Key string
   * @param field Field name
   * @return Handler for the result of this call.
   */
  def hdelFuture(key: String,field: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].hdel(key.asInstanceOf[java.lang.String],field.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Delete one or more hash fields
   * @param key Key string
   * @param fields Field names
   * @return Handler for the result of this call.
   */
  def hdelManyFuture(key: String,fields: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].hdelMany(key.asInstanceOf[java.lang.String],fields.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Determine if a hash field exists
   * @param key Key string
   * @param field Field name
   * @return Handler for the result of this call.
   */
  def hexistsFuture(key: String,field: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].hexists(key.asInstanceOf[java.lang.String],field.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the value of a hash field
   * @param key Key string
   * @param field Field name
   * @return Handler for the result of this call.
   */
  def hgetFuture(key: String,field: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].hget(key.asInstanceOf[java.lang.String],field.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get all the fields and values in a hash
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def hgetallFuture(key: String):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JRedisClient].hgetall(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Increment the integer value of a hash field by the given number
   * @param key Key string
   * @param field Field name
   * @param increment Value by which to increment
   * @return Handler for the result of this call.
   */
  def hincrbyFuture(key: String,field: String,increment: Long):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].hincrby(key.asInstanceOf[java.lang.String],field.asInstanceOf[java.lang.String],increment.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Increment the float value of a hash field by the given amount
   * @param key Key string
   * @param field Field name
   * @param increment Value by which to increment
   * @return Handler for the result of this call.
   */
  def hincrbyfloatFuture(key: String,field: String,increment: Double):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].hincrbyfloat(key.asInstanceOf[java.lang.String],field.asInstanceOf[java.lang.String],increment.asInstanceOf[java.lang.Double],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get all the fields in a hash
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def hkeysFuture(key: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].hkeys(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the number of fields in a hash
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def hlenFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].hlen(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the values of all the given hash fields
   * @param key Key string
   * @param fields Field names
   * @return Handler for the result of this call.
   */
  def hmgetFuture(key: String,fields: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].hmget(key.asInstanceOf[java.lang.String],fields.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set multiple hash fields to multiple values
   * @param key Key string
   * @param values Map of field:value pairs
   * @return Handler for the result of this call.
   */
  def hmsetFuture(key: String,values: io.vertx.core.json.JsonObject):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].hmset(key.asInstanceOf[java.lang.String],values,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the string value of a hash field
   * @param key Key string
   * @param field Field name
   * @param value New value
   * @return Handler for the result of this call.
   */
  def hsetFuture(key: String,field: String,value: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].hset(key.asInstanceOf[java.lang.String],field.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the value of a hash field, only if the field does not exist
   * @param key Key string
   * @param field Field name
   * @param value New value
   * @return Handler for the result of this call.
   */
  def hsetnxFuture(key: String,field: String,value: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].hsetnx(key.asInstanceOf[java.lang.String],field.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get all the values in a hash
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def hvalsFuture(key: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].hvals(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Increment the integer value of a key by one
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def incrFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].incr(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Increment the integer value of a key by the given amount
   * @param key Key string
   * @param increment Value by which to increment
   * @return Handler for the result of this call.
   */
  def incrbyFuture(key: String,increment: Long):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].incrby(key.asInstanceOf[java.lang.String],increment.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Increment the float value of a key by the given amount
   * @param key Key string
   * @param increment Value by which to increment
   * @return Handler for the result of this call.
   */
  def incrbyfloatFuture(key: String,increment: Double):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].incrbyfloat(key.asInstanceOf[java.lang.String],increment.asInstanceOf[java.lang.Double],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get information and statistics about the server
   * @return Handler for the result of this call.
   */
  def infoFuture():scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JRedisClient].info(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get information and statistics about the server
   * @param section Specific section of information to return
   * @return Handler for the result of this call.
   */
  def infoSectionFuture(section: String):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JRedisClient].infoSection(section.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Find all keys matching the given pattern
   * @param pattern Pattern to limit the keys returned
   * @return Handler for the result of this call.
   */
  def keysFuture(pattern: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].keys(pattern.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the UNIX time stamp of the last successful save to disk
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def lastsaveFuture():scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].lastsave(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get an element from a list by its index
   * @param key Key string
   * @param index Index of list element to get
   * @return Handler for the result of this call.
   */
  def lindexFuture(key: String,index: Int):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].lindex(key.asInstanceOf[java.lang.String],index.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Insert an element before or after another element in a list
   * @param key Key string
   * @param option BEFORE or AFTER
   * @param pivot Key to use as a pivot
   * @param value Value to be inserted before or after the pivot
   * @return Handler for the result of this call.
   */
  def linsertFuture(key: String,option: io.vertx.redis.op.InsertOptions,pivot: String,value: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].linsert(key.asInstanceOf[java.lang.String],option,pivot.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the length of a list
   * @param key String key
   * @return Handler for the result of this call.
   */
  def llenFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].llen(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove and get the first element in a list
   * @param key String key
   * @return Handler for the result of this call.
   */
  def lpopFuture(key: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].lpop(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Prepend one or multiple values to a list
   * @param key Key string
   * @param values Values to be added at the beginning of the list, one by one
   * @return Handler for the result of this call.
   */
  def lpushManyFuture(key: String,values: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].lpushMany(key.asInstanceOf[java.lang.String],values.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Prepend one value to a list
   * @param key Key string
   * @param value Value to be added at the beginning of the list
   * @return Handler for the result of this call.
   */
  def lpushFuture(key: String,value: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].lpush(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Prepend a value to a list, only if the list exists
   * @param key Key string
   * @param value Value to add at the beginning of the list
   * @return Handler for the result of this call.
   */
  def lpushxFuture(key: String,value: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].lpushx(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get a range of elements from a list
   * @param key Key string
   * @param from Start index
   * @param to Stop index
   * @return Handler for the result of this call.
   */
  def lrangeFuture(key: String,from: Long,to: Long):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].lrange(key.asInstanceOf[java.lang.String],from.asInstanceOf[java.lang.Long],to.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove elements from a list
   * @param key Key string
   * @param count Number of first found occurrences equal to $value to remove from the list
   * @param value Value to be removed
   * @return Handler for the result of this call.
   */
  def lremFuture(key: String,count: Long,value: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].lrem(key.asInstanceOf[java.lang.String],count.asInstanceOf[java.lang.Long],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the value of an element in a list by its index
   * @param key Key string
   * @param index Position within list
   * @param value New value
   * @return Handler for the result of this call.
   */
  def lsetFuture(key: String,index: Long,value: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].lset(key.asInstanceOf[java.lang.String],index.asInstanceOf[java.lang.Long],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Trim a list to the specified range
   * @param key Key string
   * @param from Start index
   * @param to Stop index
   * @return Handler for the result of this call.
   */
  def ltrimFuture(key: String,from: Long,to: Long):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].ltrim(key.asInstanceOf[java.lang.String],from.asInstanceOf[java.lang.Long],to.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the value of the given key
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def mgetFuture(key: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].mget(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the values of all the given keys
   * @param keys List of keys to get
   * @return Handler for the result of this call.
   */
  def mgetManyFuture(keys: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].mgetMany(keys.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Atomically transfer a key from a Redis instance to another one.
   * @param host Destination host
   * @param port Destination port
   * @param key Key to migrate
   * @param destdb Destination database index
   * @param options Migrate optionssee <a href="../../../../../../cheatsheet/MigrateOptions.html">MigrateOptions</a>
   * @return Handler for the result of this call.
   */
  def migrateFuture(host: String,port: Int,key: String,destdb: Int,timeout: Long,options: MigrateOptions):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].migrate(host.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],key.asInstanceOf[java.lang.String],destdb.asInstanceOf[java.lang.Integer],timeout.asInstanceOf[java.lang.Long],options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Listen for all requests received by the server in real time
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def monitorFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].monitor(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Move a key to another database
   * @param key Key to migrate
   * @param destdb Destination database index
   * @return Handler for the result of this call.
   */
  def moveFuture(key: String,destdb: Int):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].move(key.asInstanceOf[java.lang.String],destdb.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set multiple keys to multiple values
   * @param keyvals Key value pairs to set
   * @return Handler for the result of this call.
   */
  def msetFuture(keyvals: io.vertx.core.json.JsonObject):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].mset(keyvals,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set multiple keys to multiple values, only if none of the keys exist
   * @param keyvals Key value pairs to set
   * @return Handler for the result of this call.
   */
  def msetnxFuture(keyvals: io.vertx.core.json.JsonObject):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].msetnx(keyvals,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Inspect the internals of Redis objects
   * @param key Key string
   * @param cmd Object sub command
   * @return Handler for the result of this call.
   */
  def objectFuture(key: String,cmd: io.vertx.redis.op.ObjectCmd):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].`object`(key.asInstanceOf[java.lang.String],cmd,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove the expiration from a key
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def persistFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].persist(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set a key's time to live in milliseconds
   * @param key String key
   * @param millis Time to live in milliseconds
   * @return Handler for the result of this call.
   */
  def pexpireFuture(key: String,millis: Long):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].pexpire(key.asInstanceOf[java.lang.String],millis.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the expiration for a key as a UNIX timestamp specified in milliseconds
   * @param key Key string
   * @param millis Expiry time as Unix timestamp in milliseconds
   * @return Handler for the result of this call.
   */
  def pexpireatFuture(key: String,millis: Long):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].pexpireat(key.asInstanceOf[java.lang.String],millis.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Adds the specified element to the specified HyperLogLog.
   * @param key Key string
   * @param element Element to add
   * @return Handler for the result of this call.
   */
  def pfaddFuture(key: String,element: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].pfadd(key.asInstanceOf[java.lang.String],element.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Adds the specified elements to the specified HyperLogLog.
   * @param key Key string
   * @param elements Elementa to add
   * @return Handler for the result of this call.
   */
  def pfaddManyFuture(key: String,elements: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].pfaddMany(key.asInstanceOf[java.lang.String],elements.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return the approximated cardinality of the set observed by the HyperLogLog at key.
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def pfcountFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].pfcount(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return the approximated cardinality of the set(s) observed by the HyperLogLog at key(s).
   * @param keys List of keys
   * @return Handler for the result of this call.
   */
  def pfcountManyFuture(keys: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].pfcountMany(keys.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Merge N different HyperLogLogs into a single one.
   * @param destkey Destination key
   * @param keys List of source keys
   * @return Handler for the result of this call.
   */
  def pfmergeFuture(destkey: String,keys: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].pfmerge(destkey.asInstanceOf[java.lang.String],keys.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Ping the server
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def pingFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].ping(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the value and expiration in milliseconds of a key
   * @param key Key string
   * @param millis Number of milliseconds until the key expires
   * @param value New value for key
   * @return Handler for the result of this call.
   */
  def psetexFuture(key: String,millis: Long,value: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].psetex(key.asInstanceOf[java.lang.String],millis.asInstanceOf[java.lang.Long],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Listen for messages published to channels matching the given pattern
   * @param pattern Pattern string
   * @return Handler for the result of this call.
   */
  def psubscribeFuture(pattern: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].psubscribe(pattern.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Listen for messages published to channels matching the given patterns
   * @param patterns List of patterns
   * @return Handler for the result of this call.
   */
  def psubscribeManyFuture(patterns: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].psubscribeMany(patterns.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Lists the currently active channels - only those matching the pattern
   * @param pattern A glob-style pattern - an empty string means no pattern
   * @return Handler for the result of this call.
   */
  def pubsubChannelsFuture(pattern: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].pubsubChannels(pattern.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Returns the number of subscribers (not counting clients subscribed to patterns) for the specified channels
   * @param channels List of channels
   * @return Handler for the result of this call.
   */
  def pubsubNumsubFuture(channels: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].pubsubNumsub(channels.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Returns the number of subscriptions to patterns (that are performed using the PSUBSCRIBE command)
   * @return Handler for the result of this call.
   */
  def pubsubNumpatFuture():scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].pubsubNumpat(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the time to live for a key in milliseconds
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def pttlFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].pttl(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Post a message to a channel
   * @param channel Channel key
   * @param message Message to send to channel
   * @return Handler for the result of this call.
   */
  def publishFuture(channel: String,message: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].publish(channel.asInstanceOf[java.lang.String],message.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Stop listening for messages posted to channels matching the given patterns
   * @param patterns List of patterns to match against
   * @return Handler for the result of this call.
   */
  def punsubscribeFuture(patterns: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].punsubscribe(patterns.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return a random key from the keyspace
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def randomkeyFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].randomkey(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Rename a key
   * @param key Key string to be renamed
   * @param newkey New key string
   * @return Handler for the result of this call.
   */
  def renameFuture(key: String,newkey: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].rename(key.asInstanceOf[java.lang.String],newkey.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Rename a key, only if the new key does not exist
   * @param key Key string to be renamed
   * @param newkey New key string
   * @return Handler for the result of this call.
   */
  def renamenxFuture(key: String,newkey: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].renamenx(key.asInstanceOf[java.lang.String],newkey.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Create a key using the provided serialized value, previously obtained using DUMP.
   * @param key Key string
   * @param millis Expiry time in milliseconds to set on the key
   * @param serialized Serialized form of the key value as obtained using DUMP
   * @return Handler for the result of this call.
   */
  def restoreFuture(key: String,millis: Long,serialized: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].restore(key.asInstanceOf[java.lang.String],millis.asInstanceOf[java.lang.Long],serialized.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return the role of the instance in the context of replication
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def roleFuture():scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].role(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove and get the last element in a list
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def rpopFuture(key: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].rpop(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove the last element in a list, append it to another list and return it
   * @param key Key string identifying source list
   * @param destkey Key string identifying destination list
   * @return Handler for the result of this call.
   */
  def rpoplpushFuture(key: String,destkey: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].rpoplpush(key.asInstanceOf[java.lang.String],destkey.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Append one or multiple values to a list
   * @param key Key string
   * @param values List of values to add to the end of the list
   * @return Handler for the result of this call.
   */
  def rpushManyFuture(key: String,values: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].rpushMany(key.asInstanceOf[java.lang.String],values.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Append one or multiple values to a list
   * @param key Key string
   * @param value Value to be added to the end of the list
   * @return Handler for the result of this call.
   */
  def rpushFuture(key: String,value: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].rpush(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Append a value to a list, only if the list exists
   * @param key Key string
   * @param value Value to be added to the end of the list
   * @return Handler for the result of this call.
   */
  def rpushxFuture(key: String,value: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].rpushx(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Add a member to a set
   * @param key Key string
   * @param member Value to be added to the set
   * @return Handler for the result of this call.
   */
  def saddFuture(key: String,member: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].sadd(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Add one or more members to a set
   * @param key Key string
   * @param members Values to be added to the set
   * @return Handler for the result of this call.
   */
  def saddManyFuture(key: String,members: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].saddMany(key.asInstanceOf[java.lang.String],members.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Synchronously save the dataset to disk
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def saveFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].save(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the number of members in a set
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def scardFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].scard(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Check existence of script in the script cache.
   * @param script SHA1 digest identifying a script in the script cache
   * @return Handler for the result of this call.
   */
  def scriptExistsFuture(script: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].scriptExists(script.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Check existence of scripts in the script cache.
   * @param scripts List of SHA1 digests identifying scripts in the script cache
   * @return Handler for the result of this call.
   */
  def scriptExistsManyFuture(scripts: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].scriptExistsMany(scripts.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove all the scripts from the script cache.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def scriptFlushFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].scriptFlush(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Kill the script currently in execution.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def scriptKillFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].scriptKill(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Load the specified Lua script into the script cache.
   * @param script Lua script
   * @return Handler for the result of this call.
   */
  def scriptLoadFuture(script: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].scriptLoad(script.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Subtract multiple sets
   * @param key Key identifying the set to compare with all other sets combined
   * @param cmpkeys List of keys identifying sets to subtract from the key set
   * @return Handler for the result of this call.
   */
  def sdiffFuture(key: String,cmpkeys: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].sdiff(key.asInstanceOf[java.lang.String],cmpkeys.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Subtract multiple sets and store the resulting set in a key
   * @param destkey Destination key where the result should be stored
   * @param key Key identifying the set to compare with all other sets combined
   * @param cmpkeys List of keys identifying sets to subtract from the key set
   * @return Handler for the result of this call.
   */
  def sdiffstoreFuture(destkey: String,key: String,cmpkeys: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].sdiffstore(destkey.asInstanceOf[java.lang.String],key.asInstanceOf[java.lang.String],cmpkeys.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Change the selected database for the current connection
   * @param dbindex Index identifying the new active database
   * @return Handler for the result of this call.
   */
  def selectFuture(dbindex: Int):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].select(dbindex.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the string value of a key
   * @param key Key of which value to set
   * @param value New value for the key
   * @return Handler for the result of this call.
   */
  def setFuture(key: String,value: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].set(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the string value of a key
   * @param key Key of which value to set
   * @param value New value for the key
   * @param options Set optionssee <a href="../../../../../../cheatsheet/SetOptions.html">SetOptions</a>
   * @return Handler for the result of this call.
   */
  def setWithOptionsFuture(key: String,value: String,options: SetOptions):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].setWithOptions(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the binary string value of a key - without encoding as utf-8
   * @param key Key of which value to set
   * @param value New value for the key
   * @return Handler for the result of this call.
   */
  def setBinaryFuture(key: String,value: io.vertx.core.buffer.Buffer):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].setBinary(key.asInstanceOf[java.lang.String],value,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the string value of a key
   * @param key Key of which value to set
   * @param value New value for the key
   * @param options Set optionssee <a href="../../../../../../cheatsheet/SetOptions.html">SetOptions</a>
   * @return Handler for the result of this call.
   */
  def setBinaryWithOptionsFuture(key: String,value: io.vertx.core.buffer.Buffer,options: SetOptions):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].setBinaryWithOptions(key.asInstanceOf[java.lang.String],value,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Sets or clears the bit at offset in the string value stored at key
   * @param key Key string
   * @param offset Bit offset
   * @param bit New value - must be 1 or 0
   * @return Handler for the result of this call.
   */
  def setbitFuture(key: String,offset: Long,bit: Int):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].setbit(key.asInstanceOf[java.lang.String],offset.asInstanceOf[java.lang.Long],bit.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the value and expiration of a key
   * @param key Key string
   * @param seconds Number of seconds until the key expires
   * @param value New value for key
   * @return Handler for the result of this call.
   */
  def setexFuture(key: String,seconds: Long,value: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].setex(key.asInstanceOf[java.lang.String],seconds.asInstanceOf[java.lang.Long],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Set the value of a key, only if the key does not exist
   * @param key Key of which value to set
   * @param value New value for the key
   * @return Handler for the result of this call.
   */
  def setnxFuture(key: String,value: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].setnx(key.asInstanceOf[java.lang.String],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Overwrite part of a string at key starting at the specified offset
   * @param key Key string
   * @param offset Offset - the maximum offset that you can set is 2^29 -1 (536870911), as Redis Strings are limited to 512 megabytes
   * @param value Value to overwrite with
   * @return Handler for the result of this call.
   */
  def setrangeFuture(key: String,offset: Int,value: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].setrange(key.asInstanceOf[java.lang.String],offset.asInstanceOf[java.lang.Integer],value.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Intersect multiple sets
   * @param keys List of keys to perform intersection on
   * @return Handler for the result of this call.
   */
  def sinterFuture(keys: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].sinter(keys.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Intersect multiple sets and store the resulting set in a key
   * @param destkey Key where to store the results
   * @param keys List of keys to perform intersection on
   * @return Handler for the result of this call.
   */
  def sinterstoreFuture(destkey: String,keys: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].sinterstore(destkey.asInstanceOf[java.lang.String],keys.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Determine if a given value is a member of a set
   * @param key Key string
   * @param member Member to look for
   * @return Handler for the result of this call.
   */
  def sismemberFuture(key: String,member: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].sismember(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Make the server a slave of another instance
   * @param host Host to become this server's master
   * @param port Port of our new master
   * @return Handler for the result of this call.
   */
  def slaveofFuture(host: String,port: Int):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].slaveof(host.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Make this server a master
   * @return Handler for the result of this call.
   */
  def slaveofNooneFuture():scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].slaveofNoone(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Read the Redis slow queries log
   * @param limit Number of log entries to return. If value is less than zero all entries are returned
   * @return Handler for the result of this call.
   */
  def slowlogGetFuture(limit: Int):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].slowlogGet(limit.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the length of the Redis slow queries log
   * @return Handler for the result of this call.
   */
  def slowlogLenFuture():scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].slowlogLen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Reset the Redis slow queries log
   * @return Handler for the result of this call.
   */
  def slowlogResetFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].slowlogReset(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get all the members in a set
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def smembersFuture(key: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].smembers(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Move a member from one set to another
   * @param key Key of source set currently containing the member
   * @param destkey Key identifying the destination set
   * @param member Member to move
   * @return Handler for the result of this call.
   */
  def smoveFuture(key: String,destkey: String,member: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].smove(key.asInstanceOf[java.lang.String],destkey.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Sort the elements in a list, set or sorted set
   * @param key Key string
   * @param options Sort optionssee <a href="../../../../../../cheatsheet/SortOptions.html">SortOptions</a>
   * @return Handler for the result of this call.
   */
  def sortFuture(key: String,options: SortOptions):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].sort(key.asInstanceOf[java.lang.String],options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove and return a random member from a set
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def spopFuture(key: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].spop(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove and return random members from a set
   * @param key Key string
   * @param count Number of members to remove
   * @return Handler for the result of this call.
   */
  def spopManyFuture(key: String,count: Int):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].spopMany(key.asInstanceOf[java.lang.String],count.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get one or multiple random members from a set
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def srandmemberFuture(key: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].srandmember(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get one or multiple random members from a set
   * @param key Key string
   * @param count Number of members to get
   * @return Handler for the result of this call.
   */
  def srandmemberCountFuture(key: String,count: Int):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].srandmemberCount(key.asInstanceOf[java.lang.String],count.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove one member from a set
   * @param key Key string
   * @param member Member to remove
   * @return Handler for the result of this call.
   */
  def sremFuture(key: String,member: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].srem(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove one or more members from a set
   * @param key Key string
   * @param members Members to remove
   * @return Handler for the result of this call.
   */
  def sremManyFuture(key: String,members: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].sremMany(key.asInstanceOf[java.lang.String],members.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the length of the value stored in a key
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def strlenFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].strlen(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Listen for messages published to the given channels
   * @param channel Channel to subscribe to
   * @return Handler for the result of this call.
   */
  def subscribeFuture(channel: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].subscribe(channel.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Listen for messages published to the given channels
   * @param channels List of channels to subscribe to
   * @return Handler for the result of this call.
   */
  def subscribeManyFuture(channels: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].subscribeMany(channels.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Add multiple sets
   * @param keys List of keys identifying sets to add up
   * @return Handler for the result of this call.
   */
  def sunionFuture(keys: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].sunion(keys.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Add multiple sets and store the resulting set in a key
   * @param destkey Destination key
   * @param keys List of keys identifying sets to add up
   * @return Handler for the result of this call.
   */
  def sunionstoreFuture(destkey: String,keys: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].sunionstore(destkey.asInstanceOf[java.lang.String],keys.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Internal command used for replication
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def syncFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].sync(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return the current server time
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def timeFuture():scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].time(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the time to live for a key
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def ttlFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].ttl(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Determine the type stored at key
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def typeFuture(key: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].`type`(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Stop listening for messages posted to the given channels
   * @param channels List of channels to subscribe to
   * @return Handler for the result of this call.
   */
  def unsubscribeFuture(channels: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRedisClient].unsubscribe(channels.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Wait for the synchronous replication of all the write commands sent in the context of the current connection.
   * @return Handler for the result of this call.
   */
  def waitFuture(numSlaves: Long,timeout: Long):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].wait(numSlaves.asInstanceOf[java.lang.Long],timeout.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Add one or more members to a sorted set, or update its score if it already exists
   * @param key Key string
   * @param score Score used for sorting
   * @param member New member key
   * @return Handler for the result of this call.
   */
  def zaddFuture(key: String,score: Double,member: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zadd(key.asInstanceOf[java.lang.String],score.asInstanceOf[java.lang.Double],member.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Add one or more members to a sorted set, or update its score if it already exists
   * @param key Key string
   * @param members New member keys and their scores
   * @return Handler for the result of this call.
   */
  def zaddManyFuture(key: String,members: scala.collection.mutable.Map[String, Double]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zaddMany(key.asInstanceOf[java.lang.String],members.mapValues(x => x.asInstanceOf[java.lang.Double]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the number of members in a sorted set
   * @param key Key string
   * @return Handler for the result of this call.
   */
  def zcardFuture(key: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zcard(key.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Count the members in a sorted set with scores within the given values
   * @param key Key string
   * @param min Minimum score
   * @param max Maximum score
   * @return Handler for the result of this call.
   */
  def zcountFuture(key: String,min: Double,max: Double):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zcount(key.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.Double],max.asInstanceOf[java.lang.Double],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Increment the score of a member in a sorted set
   * @param key Key string
   * @param increment Increment amount
   * @param member Member key
   * @return Handler for the result of this call.
   */
  def zincrbyFuture(key: String,increment: Double,member: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].zincrby(key.asInstanceOf[java.lang.String],increment.asInstanceOf[java.lang.Double],member.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Intersect multiple sorted sets and store the resulting sorted set in a new key
   * @param destkey Destination key
   * @param sets List of keys identifying sorted sets to intersect
   * @param options Aggregation options
   * @return Handler for the result of this call.
   */
  def zinterstoreFuture(destkey: String,sets: scala.collection.mutable.Buffer[String],options: io.vertx.redis.op.AggregateOptions):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zinterstore(destkey.asInstanceOf[java.lang.String],sets.map(x => x.asInstanceOf[java.lang.String]).asJava,options,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Intersect multiple sorted sets and store the resulting sorted set in a new key using weights for scoring
   * @param destkey Destination key
   * @param sets List of keys identifying sorted sets to intersect
   * @param options Aggregation options
   * @return Handler for the result of this call.
   */
  def zinterstoreWeighedFuture(destkey: String,sets: scala.collection.mutable.Map[String, Double],options: io.vertx.redis.op.AggregateOptions):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zinterstoreWeighed(destkey.asInstanceOf[java.lang.String],sets.mapValues(x => x.asInstanceOf[java.lang.Double]).asJava,options,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Count the number of members in a sorted set between a given lexicographical range
   * @param key Key string
   * @param min Pattern to compare against for minimum value
   * @param max Pattern to compare against for maximum value
   * @return Handler for the result of this call.
   */
  def zlexcountFuture(key: String,min: String,max: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zlexcount(key.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.String],max.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return a range of members in a sorted set, by index
   * @param key Key string
   * @param start Start index for the range
   * @param stop Stop index for the range - inclusive
   * @return Handler for the result of this call.
   */
  def zrangeFuture(key: String,start: Long,stop: Long):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].zrange(key.asInstanceOf[java.lang.String],start.asInstanceOf[java.lang.Long],stop.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return a range of members in a sorted set, by index
   * @param key Key string
   * @param start Start index for the range
   * @param stop Stop index for the range - inclusive
   * @param options Range options
   * @return Handler for the result of this call.
   */
  def zrangeWithOptionsFuture(key: String,start: Long,stop: Long,options: io.vertx.redis.op.RangeOptions):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].zrangeWithOptions(key.asInstanceOf[java.lang.String],start.asInstanceOf[java.lang.Long],stop.asInstanceOf[java.lang.Long],options,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return a range of members in a sorted set, by lexicographical range
   * @param key Key string
   * @param min Pattern representing a minimum allowed value
   * @param max Pattern representing a maximum allowed value
   * @param options Limit options where limit can be specifiedsee <a href="../../../../../../cheatsheet/LimitOptions.html">LimitOptions</a>
   * @return Handler for the result of this call.
   */
  def zrangebylexFuture(key: String,min: String,max: String,options: LimitOptions):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].zrangebylex(key.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.String],max.asInstanceOf[java.lang.String],options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return a range of members in a sorted set, by score
   * @param key Key string
   * @param min Pattern defining a minimum value
   * @param max Pattern defining a maximum value
   * @param options Range and limit optionssee <a href="../../../../../../cheatsheet/RangeLimitOptions.html">RangeLimitOptions</a>
   * @return Handler for the result of this call.
   */
  def zrangebyscoreFuture(key: String,min: String,max: String,options: RangeLimitOptions):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].zrangebyscore(key.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.String],max.asInstanceOf[java.lang.String],options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Determine the index of a member in a sorted set
   * @param key Key string
   * @param member Member in the sorted set identified by key
   * @return Handler for the result of this call.
   */
  def zrankFuture(key: String,member: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zrank(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove one member from a sorted set
   * @param key Key string
   * @param member Member in the sorted set identified by key
   * @return Handler for the result of this call.
   */
  def zremFuture(key: String,member: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zrem(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove one or more members from a sorted set
   * @param key Key string
   * @param members Members in the sorted set identified by key
   * @return Handler for the result of this call.
   */
  def zremManyFuture(key: String,members: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zremMany(key.asInstanceOf[java.lang.String],members.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove all members in a sorted set between the given lexicographical range
   * @param key Key string
   * @param min Pattern defining a minimum value
   * @param max Pattern defining a maximum value
   * @return Handler for the result of this call.
   */
  def zremrangebylexFuture(key: String,min: String,max: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zremrangebylex(key.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.String],max.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove all members in a sorted set within the given indexes
   * @param key Key string
   * @param start Start index
   * @param stop Stop index
   * @return Handler for the result of this call.
   */
  def zremrangebyrankFuture(key: String,start: Long,stop: Long):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zremrangebyrank(key.asInstanceOf[java.lang.String],start.asInstanceOf[java.lang.Long],stop.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove all members in a sorted set within the given scores
   * @param key Key string
   * @param min Pattern defining a minimum value
   * @param max Pattern defining a maximum value
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def zremrangebyscoreFuture(key: String,min: String,max: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zremrangebyscore(key.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.String],max.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return a range of members in a sorted set, by index, with scores ordered from high to low
   * @param key Key string
   * @param start Start index for the range
   * @param stop Stop index for the range - inclusive
   * @param options Range options
   * @return Handler for the result of this call.
   */
  def zrevrangeFuture(key: String,start: Long,stop: Long,options: io.vertx.redis.op.RangeOptions):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].zrevrange(key.asInstanceOf[java.lang.String],start.asInstanceOf[java.lang.Long],stop.asInstanceOf[java.lang.Long],options,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return a range of members in a sorted set, by score, between the given lexicographical range with scores ordered from high to low
   * @param key Key string
   * @param max Pattern defining a maximum value
   * @param min Pattern defining a minimum value
   * @param options Limit optionssee <a href="../../../../../../cheatsheet/LimitOptions.html">LimitOptions</a>
   * @return Handler for the result of this call.
   */
  def zrevrangebylexFuture(key: String,max: String,min: String,options: LimitOptions):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].zrevrangebylex(key.asInstanceOf[java.lang.String],max.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.String],options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return a range of members in a sorted set, by score, with scores ordered from high to low
   * @param key Key string
   * @param max Pattern defining a maximum value
   * @param min Pattern defining a minimum value
   * @param options Range and limit optionssee <a href="../../../../../../cheatsheet/RangeLimitOptions.html">RangeLimitOptions</a>
   * @return Handler for the result of this call.
   */
  def zrevrangebyscoreFuture(key: String,max: String,min: String,options: RangeLimitOptions):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].zrevrangebyscore(key.asInstanceOf[java.lang.String],max.asInstanceOf[java.lang.String],min.asInstanceOf[java.lang.String],options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Determine the index of a member in a sorted set, with scores ordered from high to low
   * @param key Key string
   * @param member Member in the sorted set identified by key
   * @return Handler for the result of this call.
   */
  def zrevrankFuture(key: String,member: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zrevrank(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get the score associated with the given member in a sorted set
   * @param key Key string
   * @param member Member in the sorted set identified by key
   * @return Handler for the result of this call.
   */
  def zscoreFuture(key: String,member: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].zscore(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Add multiple sorted sets and store the resulting sorted set in a new key
   * @param destkey Destination key
   * @param sets List of keys identifying sorted sets
   * @param options Aggregation options
   * @return Handler for the result of this call.
   */
  def zunionstoreFuture(destkey: String,sets: scala.collection.mutable.Buffer[String],options: io.vertx.redis.op.AggregateOptions):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zunionstore(destkey.asInstanceOf[java.lang.String],sets.map(x => x.asInstanceOf[java.lang.String]).asJava,options,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Add multiple sorted sets using weights, and store the resulting sorted set in a new key
   * @param key Destination key
   * @param sets Map containing set-key:weight pairs
   * @param options Aggregation options
   * @return Handler for the result of this call.
   */
  def zunionstoreWeighedFuture(key: String,sets: scala.collection.mutable.Map[String, Double],options: io.vertx.redis.op.AggregateOptions):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].zunionstoreWeighed(key.asInstanceOf[java.lang.String],sets.mapValues(x => x.asInstanceOf[java.lang.Double]).asJava,options,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Incrementally iterate the keys space
   * @param cursor Cursor id
   * @param options Scan optionssee <a href="../../../../../../cheatsheet/ScanOptions.html">ScanOptions</a>
   * @return Handler for the result of this call.
   */
  def scanFuture(cursor: String,options: ScanOptions):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].scan(cursor.asInstanceOf[java.lang.String],options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Incrementally iterate Set elements
   * @param key Key string
   * @param cursor Cursor id
   * @param options Scan optionssee <a href="../../../../../../cheatsheet/ScanOptions.html">ScanOptions</a>
   * @return Handler for the result of this call.
   */
  def sscanFuture(key: String,cursor: String,options: ScanOptions):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].sscan(key.asInstanceOf[java.lang.String],cursor.asInstanceOf[java.lang.String],options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Incrementally iterate hash fields and associated values
   * @param key Key string
   * @param cursor Cursor id
   * @param options Scan optionssee <a href="../../../../../../cheatsheet/ScanOptions.html">ScanOptions</a>
   * @return Handler for the result of this call.
   */
  def hscanFuture(key: String,cursor: String,options: ScanOptions):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].hscan(key.asInstanceOf[java.lang.String],cursor.asInstanceOf[java.lang.String],options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Incrementally iterate sorted sets elements and associated scores
   * @param key Key string
   * @param cursor Cursor id
   * @param options Scan optionssee <a href="../../../../../../cheatsheet/ScanOptions.html">ScanOptions</a>
   * @return Handler for the result of this call.
   */
  def zscanFuture(key: String,cursor: String,options: ScanOptions):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].zscan(key.asInstanceOf[java.lang.String],cursor.asInstanceOf[java.lang.String],options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Add one or more geospatial items in the geospatial index represented using a sorted set.
   * @param key Key string
   * @param longitude longitude
   * @param latitude latitude
   * @param member member
   * @return Handler for the result of this call.
   */
  def geoaddFuture(key: String,longitude: Double,latitude: Double,member: String):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].geoadd(key.asInstanceOf[java.lang.String],longitude.asInstanceOf[java.lang.Double],latitude.asInstanceOf[java.lang.Double],member.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Add one or more geospatial items in the geospatial index represented using a sorted set.
   * @param key Key string
   * @param members list of &lt;lon, lat, member&gt;
   * @return Handler for the result of this call.
   */
  def geoaddManyFuture(key: String,members: scala.collection.mutable.Buffer[GeoMember]):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JRedisClient].geoaddMany(key.asInstanceOf[java.lang.String],members.map(x => x.asJava).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return valid Geohash strings representing the position of one or more elements in a sorted set value representing
   * a geospatial index (where elements were added using GEOADD).
   * @param key Key string
   * @param member member
   * @return Handler for the result of this call.
   */
  def geohashFuture(key: String,member: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].geohash(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return valid Geohash strings representing the position of one or more elements in a sorted set value representing
   * a geospatial index (where elements were added using GEOADD).
   * @param key Key string
   * @param members list of members
   * @return Handler for the result of this call.
   */
  def geohashManyFuture(key: String,members: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].geohashMany(key.asInstanceOf[java.lang.String],members.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return the positions (longitude,latitude) of all the specified members of the geospatial index represented by the
   * sorted set at key.
   * @param key Key string
   * @param member member
   * @return Handler for the result of this call.
   */
  def geoposFuture(key: String,member: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].geopos(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return the positions (longitude,latitude) of all the specified members of the geospatial index represented by the
   * sorted set at key.
   * @param key Key string
   * @param members list of members
   * @return Handler for the result of this call.
   */
  def geoposManyFuture(key: String,members: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].geoposMany(key.asInstanceOf[java.lang.String],members.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return the distance between two members in the geospatial index represented by the sorted set.
   * @param key Key string
   * @param member1 member 1
   * @param member2 member 2
   * @return Handler for the result of this call.
   */
  def geodistFuture(key: String,member1: String,member2: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].geodist(key.asInstanceOf[java.lang.String],member1.asInstanceOf[java.lang.String],member2.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return the distance between two members in the geospatial index represented by the sorted set.
   * @param key Key string
   * @param member1 member 1
   * @param member2 member 2
   * @param unit geo unit
   * @return Handler for the result of this call.
   */
  def geodistWithUnitFuture(key: String,member1: String,member2: String,unit: io.vertx.redis.op.GeoUnit):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JRedisClient].geodistWithUnit(key.asInstanceOf[java.lang.String],member1.asInstanceOf[java.lang.String],member2.asInstanceOf[java.lang.String],unit,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return the members of a sorted set populated with geospatial information using GEOADD, which are within the borders
   * of the area specified with the center location and the maximum distance from the center (the radius).
   * @param key Key string
   * @param longitude longitude
   * @param latitude latitude
   * @param radius radius
   * @param unit geo unit
   * @return Handler for the result of this call.
   */
  def georadiusFuture(key: String,longitude: Double,latitude: Double,radius: Double,unit: io.vertx.redis.op.GeoUnit):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].georadius(key.asInstanceOf[java.lang.String],longitude.asInstanceOf[java.lang.Double],latitude.asInstanceOf[java.lang.Double],radius.asInstanceOf[java.lang.Double],unit,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Return the members of a sorted set populated with geospatial information using GEOADD, which are within the borders
   * of the area specified with the center location and the maximum distance from the center (the radius).
   * @param key Key string
   * @param longitude longitude
   * @param latitude latitude
   * @param radius radius
   * @param unit geo unit
   * @param options geo radius optionssee <a href="../../../../../../cheatsheet/GeoRadiusOptions.html">GeoRadiusOptions</a>
   * @return Handler for the result of this call.
   */
  def georadiusWithOptionsFuture(key: String,longitude: Double,latitude: Double,radius: Double,unit: io.vertx.redis.op.GeoUnit,options: GeoRadiusOptions):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].georadiusWithOptions(key.asInstanceOf[java.lang.String],longitude.asInstanceOf[java.lang.Double],latitude.asInstanceOf[java.lang.Double],radius.asInstanceOf[java.lang.Double],unit,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * This command is exactly like GEORADIUS with the sole difference that instead of taking, as the center of the area
   * to query, a longitude and latitude value, it takes the name of a member already existing inside the geospatial
   * index represented by the sorted set.
   * @param key Key string
   * @param member member
   * @param radius radius
   * @param unit geo unit
   * @return Handler for the result of this call.
   */
  def georadiusbymemberFuture(key: String,member: String,radius: Double,unit: io.vertx.redis.op.GeoUnit):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].georadiusbymember(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],radius.asInstanceOf[java.lang.Double],unit,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * This command is exactly like GEORADIUS with the sole difference that instead of taking, as the center of the area
   * to query, a longitude and latitude value, it takes the name of a member already existing inside the geospatial
   * index represented by the sorted set.
   * @param key Key string
   * @param member member
   * @param radius radius
   * @param unit geo unit
   * @param options geo radius optionssee <a href="../../../../../../cheatsheet/GeoRadiusOptions.html">GeoRadiusOptions</a>
   * @return Handler for the result of this call.
   */
  def georadiusbymemberWithOptionsFuture(key: String,member: String,radius: Double,unit: io.vertx.redis.op.GeoUnit,options: GeoRadiusOptions):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JRedisClient].georadiusbymemberWithOptions(key.asInstanceOf[java.lang.String],member.asInstanceOf[java.lang.String],radius.asInstanceOf[java.lang.Double],unit,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object RedisClient{
  def apply(asJava: JRedisClient) = new RedisClient(asJava)  
  def create(vertx: Vertx):RedisClient = {
    RedisClient(JRedisClient.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  def create(vertx: Vertx,config: RedisOptions):RedisClient = {
    RedisClient(JRedisClient.create(vertx.asJava.asInstanceOf[JVertx],config.asJava))
  }

}
