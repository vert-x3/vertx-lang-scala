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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.redis.{RedisClient => JRedisClient}
    import io.vertx.redis.op.BitOperation
  import io.vertx.redis.op.ResetOptions
  import io.vertx.redis.op.ObjectCmd
  import io.vertx.redis.op.{KillFilter => JKillFilter}
import io.vertx.scala.redis.op.KillFilter
      import io.vertx.redis.op.GeoUnit
  import io.vertx.redis.{RedisClient => JRedisClient}
  import io.vertx.core.json.JsonObject
      import io.vertx.redis.op.RangeOptions
  import io.vertx.redis.op.{GeoMember => JGeoMember}
import io.vertx.scala.redis.op.GeoMember
  import io.vertx.redis.op.{GeoRadiusOptions => JGeoRadiusOptions}
import io.vertx.scala.redis.op.GeoRadiusOptions
  import io.vertx.redis.op.InsertOptions
  import io.vertx.redis.op.AggregateOptions
    import io.vertx.redis.op.{SetOptions => JSetOptions}
import io.vertx.scala.redis.op.SetOptions
  import io.vertx.redis.op.{SortOptions => JSortOptions}
import io.vertx.scala.redis.op.SortOptions
  import io.vertx.redis.{RedisTransaction => JRedisTransaction}
  import io.vertx.redis.op.{MigrateOptions => JMigrateOptions}
import io.vertx.scala.redis.op.MigrateOptions
  import io.vertx.redis.op.{ScanOptions => JScanOptions}
import io.vertx.scala.redis.op.ScanOptions
  import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
  import io.vertx.redis.op.FailoverOptions
  import io.vertx.redis.op.SlotCmd
  import io.vertx.redis.op.{RangeLimitOptions => JRangeLimitOptions}
import io.vertx.scala.redis.op.RangeLimitOptions
  import io.vertx.redis.op.{LimitOptions => JLimitOptions}
import io.vertx.scala.redis.op.LimitOptions
  import io.vertx.core.json.JsonArray
    import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
  import io.vertx.redis.{RedisOptions => JRedisOptions}
  
class RedisClient(private val _asJava: JRedisClient) {

  def asJava: JRedisClient = _asJava

  /**
    * Close the client - when it is fully closed the handler will be called.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def closeFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Append a value to a key
    * @param key Key string
    * @param value Value to append
    * @return Handler for the result of this call.
    */
  def appendFuture(key: String, value: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.append(key, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Authenticate to the server
    * @param password Password for authentication
    * @return Handler for the result of this call.
    */
  def authFuture(password: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.auth(password, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Asynchronously rewrite the append-only file
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def bgrewriteaofFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.bgrewriteaof(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Asynchronously save the dataset to disk
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def bgsaveFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.bgsave(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Count set bits in a string
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def bitcountFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.bitcount(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Count set bits in a string
    * @param key Key string
    * @param start Start index
    * @param end End index
    * @return Handler for the result of this call.
    */
  def bitcountRangeFuture(key: String, start: Long, end: Long): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.bitcountRange(key, start, end, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Perform bitwise operations between strings
    * @param operation Bitwise operation to perform
    * @param destkey Destination key where result is stored
    * @param keys List of keys on which to perform the operation
    * @return Handler for the result of this call.
    */
  def bitopFuture(operation: io.vertx.redis.op.BitOperation, destkey: String, keys: scala.collection.mutable.Buffer[String]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.bitop(operation, destkey, keys.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Find first bit set or clear in a string
    * @param key Key string
    * @param bit What bit value to look for - must be 1, or 0
    * @return Handler for the result of this call.
    */
  def bitposFuture(key: String, bit: Int): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.bitpos(key, bit, promiseAndHandler._1)
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
  def bitposFromFuture(key: String, bit: Int, start: Int): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.bitposFrom(key, bit, start, promiseAndHandler._1)
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
  def bitposRangeFuture(key: String, bit: Int, start: Int, stop: Int): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.bitposRange(key, bit, start, stop, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove and get the first element in a list, or block until one is available
    * @param key Key string identifying a list to watch
    * @param seconds Timeout in seconds
    * @return Handler for the result of this call.
    */
  def blpopFuture(key: String, seconds: Int): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.blpop(key, seconds, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove and get the first element in any of the lists, or block until one is available
    * @param keys List of key strings identifying lists to watch
    * @param seconds Timeout in seconds
    * @return Handler for the result of this call.
    */
  def blpopManyFuture(keys: scala.collection.mutable.Buffer[String], seconds: Int): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.blpopMany(keys.map(x => if (x == null) null else x:java.lang.String).asJava, seconds, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove and get the last element in a list, or block until one is available
    * @param key Key string identifying a list to watch
    * @param seconds Timeout in seconds
    * @return Handler for the result of this call.
    */
  def brpopFuture(key: String, seconds: Int): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.brpop(key, seconds, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove and get the last element in any of the lists, or block until one is available
    * @param keys List of key strings identifying lists to watch
    * @param seconds Timeout in seconds
    * @return Handler for the result of this call.
    */
  def brpopManyFuture(keys: scala.collection.mutable.Buffer[String], seconds: Int): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.brpopMany(keys.map(x => if (x == null) null else x:java.lang.String).asJava, seconds, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Pop a value from a list, push it to another list and return it; or block until one is available
    * @param key Key string identifying the source list
    * @param destkey Key string identifying the destination list
    * @param seconds Timeout in seconds
    * @return Handler for the result of this call.
    */
  def brpoplpushFuture(key: String, destkey: String, seconds: Int): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.brpoplpush(key, destkey, seconds, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Kill the connection of a client
    * @param filter Filter optionssee <a href="../../../../../../cheatsheet/KillFilter.html">KillFilter</a>
    * @return Handler for the result of this call.
    */
  def clientKillFuture(filter: KillFilter): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.clientKill(filter.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the list of client connections
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def clientListFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.clientList(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the current connection name
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def clientGetnameFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.clientGetname(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Stop processing commands from clients for some time
    * @param millis Pause time in milliseconds
    * @return Handler for the result of this call.
    */
  def clientPauseFuture(millis: Long): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.clientPause(millis, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the current connection name
    * @param name New name for current connection
    * @return Handler for the result of this call.
    */
  def clientSetnameFuture(name: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.clientSetname(name, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Assign new hash slots to receiving node.
    * @return Handler for the result of this call.
    */
  def clusterAddslotsFuture(slots: scala.collection.mutable.Buffer[Long]): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clusterAddslots(slots.map(x => if (x == null) null else x:java.lang.Long).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return the number of failure reports active for a given node.
    * @return Handler for the result of this call.
    */
  def clusterCountFailureReportsFuture(nodeId: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.clusterCountFailureReports(nodeId, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return the number of local keys in the specified hash slot.
    * @return Handler for the result of this call.
    */
  def clusterCountkeysinslotFuture(slot: Long): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.clusterCountkeysinslot(slot, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set hash slots as unbound in receiving node.
    * @return Handler for the result of this call.
    */
  def clusterDelslotsFuture(slot: Long): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clusterDelslots(slot, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set hash slots as unbound in receiving node.
    * @return Handler for the result of this call.
    */
  def clusterDelslotsManyFuture(slots: scala.collection.mutable.Buffer[Long]): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clusterDelslotsMany(slots.map(x => if (x == null) null else x:java.lang.Long).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Forces a slave to perform a manual failover of its master.
    * @return Handler for the result of this call.
    */
  def clusterFailoverFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clusterFailover(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Forces a slave to perform a manual failover of its master.
    * @return Handler for the result of this call.
    */
  def clusterFailOverWithOptionsFuture(options: io.vertx.redis.op.FailoverOptions): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clusterFailOverWithOptions(options, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove a node from the nodes table.
    * @return Handler for the result of this call.
    */
  def clusterForgetFuture(nodeId: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clusterForget(nodeId, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return local key names in the specified hash slot.
    * @return Handler for the result of this call.
    */
  def clusterGetkeysinslotFuture(slot: Long, count: Long): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.clusterGetkeysinslot(slot, count, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Provides info about Redis Cluster node state.
    * @return Handler for the result of this call.
    */
  def clusterInfoFuture(): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.clusterInfo(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Returns the hash slot of the specified key.
    * @return Handler for the result of this call.
    */
  def clusterKeyslotFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.clusterKeyslot(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Force a node cluster to handshake with another node.
    * @return Handler for the result of this call.
    */
  def clusterMeetFuture(ip: String, port: Long): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clusterMeet(ip, port, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get Cluster config for the node.
    * @return Handler for the result of this call.
    */
  def clusterNodesFuture(): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.clusterNodes(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Reconfigure a node as a slave of the specified master node.
    * @return Handler for the result of this call.
    */
  def clusterReplicateFuture(nodeId: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clusterReplicate(nodeId, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Reset a Redis Cluster node.
    * @return Handler for the result of this call.
    */
  def clusterResetFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clusterReset(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Reset a Redis Cluster node.
    * @return Handler for the result of this call.
    */
  def clusterResetWithOptionsFuture(options: io.vertx.redis.op.ResetOptions): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clusterResetWithOptions(options, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Forces the node to save cluster state on disk.
    * @return Handler for the result of this call.
    */
  def clusterSaveconfigFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clusterSaveconfig(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the configuration epoch in a new node.
    * @return Handler for the result of this call.
    */
  def clusterSetConfigEpochFuture(epoch: Long): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clusterSetConfigEpoch(epoch, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Bind an hash slot to a specific node.
    * @return Handler for the result of this call.
    */
  def clusterSetslotFuture(slot: Long, subcommand: io.vertx.redis.op.SlotCmd): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clusterSetslot(slot, subcommand, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Bind an hash slot to a specific node.
    * @return Handler for the result of this call.
    */
  def clusterSetslotWithNodeFuture(slot: Long, subcommand: io.vertx.redis.op.SlotCmd, nodeId: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clusterSetslotWithNode(slot, subcommand, nodeId, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * List slave nodes of the specified master node.
    * @return Handler for the result of this call.
    */
  def clusterSlavesFuture(nodeId: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.clusterSlaves(nodeId, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get array of Cluster slot to node mappings
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def clusterSlotsFuture(): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.clusterSlots(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get array of Redis command details
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def commandFuture(): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.command(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get total number of Redis commands
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def commandCountFuture(): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.commandCount(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Extract keys given a full Redis command
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def commandGetkeysFuture(): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.commandGetkeys(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get array of specific Redis command details
    * @param commands List of commands to get info for
    * @return Handler for the result of this call.
    */
  def commandInfoFuture(commands: scala.collection.mutable.Buffer[String]): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.commandInfo(commands.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the value of a configuration parameter
    * @param parameter Configuration parameter
    * @return Handler for the result of this call.
    */
  def configGetFuture(parameter: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.configGet(parameter, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Rewrite the configuration file with the in memory configuration
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def configRewriteFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.configRewrite(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set a configuration parameter to the given value
    * @param parameter Configuration parameter
    * @param value New value
    * @return Handler for the result of this call.
    */
  def configSetFuture(parameter: String, value: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.configSet(parameter, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Reset the stats returned by INFO
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def configResetstatFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.configResetstat(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return the number of keys in the selected database
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def dbsizeFuture(): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.dbsize(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get debugging information about a key
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def debugObjectFuture(key: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.debugObject(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Make the server crash
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def debugSegfaultFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.debugSegfault(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Decrement the integer value of a key by one
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def decrFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.decr(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Decrement the integer value of a key by the given number
    * @param key Key string
    * @param decrement Value by which to decrement
    * @return Handler for the result of this call.
    */
  def decrbyFuture(key: String, decrement: Long): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.decrby(key, decrement, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Delete a key
    * @param key Keys to delete
    * @return Handler for the result of this call.
    */
  def delFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.del(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Delete many keys
    * @param keys List of keys to delete
    * @return Handler for the result of this call.
    */
  def delManyFuture(keys: scala.collection.mutable.Buffer[String]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.delMany(keys.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return a serialized version of the value stored at the specified key.
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def dumpFuture(key: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.dump(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Echo the given string
    * @param message String to echo
    * @return Handler for the result of this call.
    */
  def echoFuture(message: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.echo(message, promiseAndHandler._1)
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
  def evalFuture(script: String, keys: scala.collection.mutable.Buffer[String], args: scala.collection.mutable.Buffer[String]): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.eval(script, keys.map(x => if (x == null) null else x:java.lang.String).asJava, args.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
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
  def evalshaFuture(sha1: String, keys: scala.collection.mutable.Buffer[String], values: scala.collection.mutable.Buffer[String]): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.evalsha(sha1, keys.map(x => if (x == null) null else x:java.lang.String).asJava, values.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Determine if a key exists
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def existsFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.exists(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set a key's time to live in seconds
    * @param key Key string
    * @param seconds Time to live in seconds
    * @return Handler for the result of this call.
    */
  def expireFuture(key: String, seconds: Int): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.expire(key, seconds, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the expiration for a key as a UNIX timestamp
    * @param key Key string
    * @param seconds Expiry time as Unix timestamp in seconds
    * @return Handler for the result of this call.
    */
  def expireatFuture(key: String, seconds: Long): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.expireat(key, seconds, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove all keys from all databases
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def flushallFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.flushall(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove all keys from the current database
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def flushdbFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.flushdb(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the value of a key
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def getFuture(key: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.get(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the value of a key - without decoding as utf-8
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def getBinaryFuture(key: String): concurrent.Future[Buffer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JBuffer,Buffer]((x => if (x == null) null else Buffer.apply(x)))
    _asJava.getBinary(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Returns the bit value at offset in the string value stored at key
    * @param key Key string
    * @param offset Offset in bits
    * @return Handler for the result of this call.
    */
  def getbitFuture(key: String, offset: Long): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.getbit(key, offset, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get a substring of the string stored at a key
    * @param key Key string
    * @param start Start offset
    * @param end End offset - inclusive
    * @return Handler for the result of this call.
    */
  def getrangeFuture(key: String, start: Long, end: Long): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.getrange(key, start, end, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the string value of a key and return its old value
    * @param key Key of which value to set
    * @param value New value for the key
    * @return Handler for the result of this call.
    */
  def getsetFuture(key: String, value: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.getset(key, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Delete one or more hash fields
    * @param key Key string
    * @param field Field name
    * @return Handler for the result of this call.
    */
  def hdelFuture(key: String, field: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.hdel(key, field, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Delete one or more hash fields
    * @param key Key string
    * @param fields Field names
    * @return Handler for the result of this call.
    */
  def hdelManyFuture(key: String, fields: scala.collection.mutable.Buffer[String]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.hdelMany(key, fields.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Determine if a hash field exists
    * @param key Key string
    * @param field Field name
    * @return Handler for the result of this call.
    */
  def hexistsFuture(key: String, field: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.hexists(key, field, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the value of a hash field
    * @param key Key string
    * @param field Field name
    * @return Handler for the result of this call.
    */
  def hgetFuture(key: String, field: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.hget(key, field, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get all the fields and values in a hash
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def hgetallFuture(key: String): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.hgetall(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Increment the integer value of a hash field by the given number
    * @param key Key string
    * @param field Field name
    * @param increment Value by which to increment
    * @return Handler for the result of this call.
    */
  def hincrbyFuture(key: String, field: String, increment: Long): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.hincrby(key, field, increment, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Increment the float value of a hash field by the given amount
    * @param key Key string
    * @param field Field name
    * @param increment Value by which to increment
    * @return Handler for the result of this call.
    */
  def hincrbyfloatFuture(key: String, field: String, increment: Double): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.hincrbyfloat(key, field, increment, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get all the fields in a hash
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def hkeysFuture(key: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.hkeys(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the number of fields in a hash
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def hlenFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.hlen(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the values of all the given hash fields
    * @param key Key string
    * @param fields Field names
    * @return Handler for the result of this call.
    */
  def hmgetFuture(key: String, fields: scala.collection.mutable.Buffer[String]): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.hmget(key, fields.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set multiple hash fields to multiple values
    * @param key Key string
    * @param values Map of field:value pairs
    * @return Handler for the result of this call.
    */
  def hmsetFuture(key: String, values: JsonObject): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.hmset(key, values, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the string value of a hash field
    * @param key Key string
    * @param field Field name
    * @param value New value
    * @return Handler for the result of this call.
    */
  def hsetFuture(key: String, field: String, value: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.hset(key, field, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the value of a hash field, only if the field does not exist
    * @param key Key string
    * @param field Field name
    * @param value New value
    * @return Handler for the result of this call.
    */
  def hsetnxFuture(key: String, field: String, value: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.hsetnx(key, field, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get all the values in a hash
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def hvalsFuture(key: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.hvals(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Increment the integer value of a key by one
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def incrFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.incr(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Increment the integer value of a key by the given amount
    * @param key Key string
    * @param increment Value by which to increment
    * @return Handler for the result of this call.
    */
  def incrbyFuture(key: String, increment: Long): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.incrby(key, increment, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Increment the float value of a key by the given amount
    * @param key Key string
    * @param increment Value by which to increment
    * @return Handler for the result of this call.
    */
  def incrbyfloatFuture(key: String, increment: Double): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.incrbyfloat(key, increment, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get information and statistics about the server
    * @return Handler for the result of this call.
    */
  def infoFuture(): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.info(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get information and statistics about the server
    * @param section Specific section of information to return
    * @return Handler for the result of this call.
    */
  def infoSectionFuture(section: String): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.infoSection(section, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Find all keys matching the given pattern
    * @param pattern Pattern to limit the keys returned
    * @return Handler for the result of this call.
    */
  def keysFuture(pattern: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.keys(pattern, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the UNIX time stamp of the last successful save to disk
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def lastsaveFuture(): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.lastsave(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get an element from a list by its index
    * @param key Key string
    * @param index Index of list element to get
    * @return Handler for the result of this call.
    */
  def lindexFuture(key: String, index: Int): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.lindex(key, index, promiseAndHandler._1)
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
  def linsertFuture(key: String, option: io.vertx.redis.op.InsertOptions, pivot: String, value: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.linsert(key, option, pivot, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the length of a list
    * @param key String key
    * @return Handler for the result of this call.
    */
  def llenFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.llen(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove and get the first element in a list
    * @param key String key
    * @return Handler for the result of this call.
    */
  def lpopFuture(key: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.lpop(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Prepend one or multiple values to a list
    * @param key Key string
    * @param values Values to be added at the beginning of the list, one by one
    * @return Handler for the result of this call.
    */
  def lpushManyFuture(key: String, values: scala.collection.mutable.Buffer[String]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.lpushMany(key, values.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Prepend one value to a list
    * @param key Key string
    * @param value Value to be added at the beginning of the list
    * @return Handler for the result of this call.
    */
  def lpushFuture(key: String, value: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.lpush(key, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Prepend a value to a list, only if the list exists
    * @param key Key string
    * @param value Value to add at the beginning of the list
    * @return Handler for the result of this call.
    */
  def lpushxFuture(key: String, value: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.lpushx(key, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get a range of elements from a list
    * @param key Key string
    * @param from Start index
    * @param to Stop index
    * @return Handler for the result of this call.
    */
  def lrangeFuture(key: String, from: Long, to: Long): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.lrange(key, from, to, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove elements from a list
    * @param key Key string
    * @param count Number of first found occurrences equal to $value to remove from the list
    * @param value Value to be removed
    * @return Handler for the result of this call.
    */
  def lremFuture(key: String, count: Long, value: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.lrem(key, count, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the value of an element in a list by its index
    * @param key Key string
    * @param index Position within list
    * @param value New value
    * @return Handler for the result of this call.
    */
  def lsetFuture(key: String, index: Long, value: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.lset(key, index, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Trim a list to the specified range
    * @param key Key string
    * @param from Start index
    * @param to Stop index
    * @return Handler for the result of this call.
    */
  def ltrimFuture(key: String, from: Long, to: Long): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.ltrim(key, from, to, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the value of the given key
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def mgetFuture(key: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.mget(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the values of all the given keys
    * @param keys List of keys to get
    * @return Handler for the result of this call.
    */
  def mgetManyFuture(keys: scala.collection.mutable.Buffer[String]): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.mgetMany(keys.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
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
  def migrateFuture(host: String, port: Int, key: String, destdb: Int, timeout: Long, options: MigrateOptions): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.migrate(host, port, key, destdb, timeout, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Listen for all requests received by the server in real time
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def monitorFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.monitor(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Move a key to another database
    * @param key Key to migrate
    * @param destdb Destination database index
    * @return Handler for the result of this call.
    */
  def moveFuture(key: String, destdb: Int): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.move(key, destdb, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set multiple keys to multiple values
    * @param keyvals Key value pairs to set
    * @return Handler for the result of this call.
    */
  def msetFuture(keyvals: JsonObject): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.mset(keyvals, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set multiple keys to multiple values, only if none of the keys exist
    * @param keyvals Key value pairs to set
    * @return Handler for the result of this call.
    */
  def msetnxFuture(keyvals: JsonObject): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.msetnx(keyvals, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Inspect the internals of Redis objects
    * @param key Key string
    * @param cmd Object sub command
    * @return Handler for the result of this call.
    */
  def objectFuture(key: String, cmd: io.vertx.redis.op.ObjectCmd): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.`object`(key, cmd, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove the expiration from a key
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def persistFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.persist(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set a key's time to live in milliseconds
    * @param key String key
    * @param millis Time to live in milliseconds
    * @return Handler for the result of this call.
    */
  def pexpireFuture(key: String, millis: Long): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.pexpire(key, millis, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the expiration for a key as a UNIX timestamp specified in milliseconds
    * @param key Key string
    * @param millis Expiry time as Unix timestamp in milliseconds
    * @return Handler for the result of this call.
    */
  def pexpireatFuture(key: String, millis: Long): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.pexpireat(key, millis, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Adds the specified element to the specified HyperLogLog.
    * @param key Key string
    * @param element Element to add
    * @return Handler for the result of this call.
    */
  def pfaddFuture(key: String, element: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.pfadd(key, element, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Adds the specified elements to the specified HyperLogLog.
    * @param key Key string
    * @param elements Elementa to add
    * @return Handler for the result of this call.
    */
  def pfaddManyFuture(key: String, elements: scala.collection.mutable.Buffer[String]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.pfaddMany(key, elements.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return the approximated cardinality of the set observed by the HyperLogLog at key.
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def pfcountFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.pfcount(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return the approximated cardinality of the set(s) observed by the HyperLogLog at key(s).
    * @param keys List of keys
    * @return Handler for the result of this call.
    */
  def pfcountManyFuture(keys: scala.collection.mutable.Buffer[String]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.pfcountMany(keys.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Merge N different HyperLogLogs into a single one.
    * @param destkey Destination key
    * @param keys List of source keys
    * @return Handler for the result of this call.
    */
  def pfmergeFuture(destkey: String, keys: scala.collection.mutable.Buffer[String]): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.pfmerge(destkey, keys.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Ping the server
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def pingFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.ping(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the value and expiration in milliseconds of a key
    * @param key Key string
    * @param millis Number of milliseconds until the key expires
    * @param value New value for key
    * @return Handler for the result of this call.
    */
  def psetexFuture(key: String, millis: Long, value: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.psetex(key, millis, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Listen for messages published to channels matching the given pattern
    * @param pattern Pattern string
    * @return Handler for the result of this call.
    */
  def psubscribeFuture(pattern: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.psubscribe(pattern, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Listen for messages published to channels matching the given patterns
    * @param patterns List of patterns
    * @return Handler for the result of this call.
    */
  def psubscribeManyFuture(patterns: scala.collection.mutable.Buffer[String]): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.psubscribeMany(patterns.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Lists the currently active channels - only those matching the pattern
    * @param pattern A glob-style pattern - an empty string means no pattern
    * @return Handler for the result of this call.
    */
  def pubsubChannelsFuture(pattern: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.pubsubChannels(pattern, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Returns the number of subscribers (not counting clients subscribed to patterns) for the specified channels
    * @param channels List of channels
    * @return Handler for the result of this call.
    */
  def pubsubNumsubFuture(channels: scala.collection.mutable.Buffer[String]): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.pubsubNumsub(channels.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Returns the number of subscriptions to patterns (that are performed using the PSUBSCRIBE command)
    * @return Handler for the result of this call.
    */
  def pubsubNumpatFuture(): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.pubsubNumpat(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the time to live for a key in milliseconds
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def pttlFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.pttl(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Post a message to a channel
    * @param channel Channel key
    * @param message Message to send to channel
    * @return Handler for the result of this call.
    */
  def publishFuture(channel: String, message: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.publish(channel, message, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Stop listening for messages posted to channels matching the given patterns
    * @param patterns List of patterns to match against
    * @return Handler for the result of this call.
    */
  def punsubscribeFuture(patterns: scala.collection.mutable.Buffer[String]): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.punsubscribe(patterns.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return a random key from the keyspace
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def randomkeyFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.randomkey(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Rename a key
    * @param key Key string to be renamed
    * @param newkey New key string
    * @return Handler for the result of this call.
    */
  def renameFuture(key: String, newkey: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.rename(key, newkey, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Rename a key, only if the new key does not exist
    * @param key Key string to be renamed
    * @param newkey New key string
    * @return Handler for the result of this call.
    */
  def renamenxFuture(key: String, newkey: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.renamenx(key, newkey, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Create a key using the provided serialized value, previously obtained using DUMP.
    * @param key Key string
    * @param millis Expiry time in milliseconds to set on the key
    * @param serialized Serialized form of the key value as obtained using DUMP
    * @return Handler for the result of this call.
    */
  def restoreFuture(key: String, millis: Long, serialized: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.restore(key, millis, serialized, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return the role of the instance in the context of replication
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def roleFuture(): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.role(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove and get the last element in a list
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def rpopFuture(key: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.rpop(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove the last element in a list, append it to another list and return it
    * @param key Key string identifying source list
    * @param destkey Key string identifying destination list
    * @return Handler for the result of this call.
    */
  def rpoplpushFuture(key: String, destkey: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.rpoplpush(key, destkey, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Append one or multiple values to a list
    * @param key Key string
    * @param values List of values to add to the end of the list
    * @return Handler for the result of this call.
    */
  def rpushManyFuture(key: String, values: scala.collection.mutable.Buffer[String]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.rpushMany(key, values.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Append one or multiple values to a list
    * @param key Key string
    * @param value Value to be added to the end of the list
    * @return Handler for the result of this call.
    */
  def rpushFuture(key: String, value: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.rpush(key, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Append a value to a list, only if the list exists
    * @param key Key string
    * @param value Value to be added to the end of the list
    * @return Handler for the result of this call.
    */
  def rpushxFuture(key: String, value: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.rpushx(key, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Add a member to a set
    * @param key Key string
    * @param member Value to be added to the set
    * @return Handler for the result of this call.
    */
  def saddFuture(key: String, member: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.sadd(key, member, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Add one or more members to a set
    * @param key Key string
    * @param members Values to be added to the set
    * @return Handler for the result of this call.
    */
  def saddManyFuture(key: String, members: scala.collection.mutable.Buffer[String]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.saddMany(key, members.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Synchronously save the dataset to disk
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def saveFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.save(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the number of members in a set
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def scardFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.scard(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Check existence of script in the script cache.
    * @param script SHA1 digest identifying a script in the script cache
    * @return Handler for the result of this call.
    */
  def scriptExistsFuture(script: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.scriptExists(script, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Check existence of scripts in the script cache.
    * @param scripts List of SHA1 digests identifying scripts in the script cache
    * @return Handler for the result of this call.
    */
  def scriptExistsManyFuture(scripts: scala.collection.mutable.Buffer[String]): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.scriptExistsMany(scripts.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove all the scripts from the script cache.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def scriptFlushFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.scriptFlush(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Kill the script currently in execution.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def scriptKillFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.scriptKill(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Load the specified Lua script into the script cache.
    * @param script Lua script
    * @return Handler for the result of this call.
    */
  def scriptLoadFuture(script: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.scriptLoad(script, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Subtract multiple sets
    * @param key Key identifying the set to compare with all other sets combined
    * @param cmpkeys List of keys identifying sets to subtract from the key set
    * @return Handler for the result of this call.
    */
  def sdiffFuture(key: String, cmpkeys: scala.collection.mutable.Buffer[String]): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.sdiff(key, cmpkeys.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Subtract multiple sets and store the resulting set in a key
    * @param destkey Destination key where the result should be stored
    * @param key Key identifying the set to compare with all other sets combined
    * @param cmpkeys List of keys identifying sets to subtract from the key set
    * @return Handler for the result of this call.
    */
  def sdiffstoreFuture(destkey: String, key: String, cmpkeys: scala.collection.mutable.Buffer[String]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.sdiffstore(destkey, key, cmpkeys.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Change the selected database for the current connection
    * @param dbindex Index identifying the new active database
    * @return Handler for the result of this call.
    */
  def selectFuture(dbindex: Int): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.select(dbindex, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the string value of a key
    * @param key Key of which value to set
    * @param value New value for the key
    * @return Handler for the result of this call.
    */
  def setFuture(key: String, value: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.set(key, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the string value of a key
    * @param key Key of which value to set
    * @param value New value for the key
    * @param options Set optionssee <a href="../../../../../../cheatsheet/SetOptions.html">SetOptions</a>
    * @return Handler for the result of this call.
    */
  def setWithOptionsFuture(key: String, value: String, options: SetOptions): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.setWithOptions(key, value, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the binary string value of a key - without encoding as utf-8
    * @param key Key of which value to set
    * @param value New value for the key
    * @return Handler for the result of this call.
    */
  def setBinaryFuture(key: String, value: Buffer): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.setBinary(key, value.asJava.asInstanceOf[JBuffer], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the string value of a key
    * @param key Key of which value to set
    * @param value New value for the key
    * @param options Set optionssee <a href="../../../../../../cheatsheet/SetOptions.html">SetOptions</a>
    * @return Handler for the result of this call.
    */
  def setBinaryWithOptionsFuture(key: String, value: Buffer, options: SetOptions): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.setBinaryWithOptions(key, value.asJava.asInstanceOf[JBuffer], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Sets or clears the bit at offset in the string value stored at key
    * @param key Key string
    * @param offset Bit offset
    * @param bit New value - must be 1 or 0
    * @return Handler for the result of this call.
    */
  def setbitFuture(key: String, offset: Long, bit: Int): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.setbit(key, offset, bit, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the value and expiration of a key
    * @param key Key string
    * @param seconds Number of seconds until the key expires
    * @param value New value for key
    * @return Handler for the result of this call.
    */
  def setexFuture(key: String, seconds: Long, value: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.setex(key, seconds, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the value of a key, only if the key does not exist
    * @param key Key of which value to set
    * @param value New value for the key
    * @return Handler for the result of this call.
    */
  def setnxFuture(key: String, value: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.setnx(key, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Overwrite part of a string at key starting at the specified offset
    * @param key Key string
    * @param offset Offset - the maximum offset that you can set is 2^29 -1 (536870911), as Redis Strings are limited to 512 megabytes
    * @param value Value to overwrite with
    * @return Handler for the result of this call.
    */
  def setrangeFuture(key: String, offset: Int, value: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.setrange(key, offset, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Intersect multiple sets
    * @param keys List of keys to perform intersection on
    * @return Handler for the result of this call.
    */
  def sinterFuture(keys: scala.collection.mutable.Buffer[String]): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.sinter(keys.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Intersect multiple sets and store the resulting set in a key
    * @param destkey Key where to store the results
    * @param keys List of keys to perform intersection on
    * @return Handler for the result of this call.
    */
  def sinterstoreFuture(destkey: String, keys: scala.collection.mutable.Buffer[String]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.sinterstore(destkey, keys.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Determine if a given value is a member of a set
    * @param key Key string
    * @param member Member to look for
    * @return Handler for the result of this call.
    */
  def sismemberFuture(key: String, member: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.sismember(key, member, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Make the server a slave of another instance
    * @param host Host to become this server's master
    * @param port Port of our new master
    * @return Handler for the result of this call.
    */
  def slaveofFuture(host: String, port: Int): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.slaveof(host, port, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Make this server a master
    * @return Handler for the result of this call.
    */
  def slaveofNooneFuture(): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.slaveofNoone(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Read the Redis slow queries log
    * @param limit Number of log entries to return. If value is less than zero all entries are returned
    * @return Handler for the result of this call.
    */
  def slowlogGetFuture(limit: Int): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.slowlogGet(limit, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the length of the Redis slow queries log
    * @return Handler for the result of this call.
    */
  def slowlogLenFuture(): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.slowlogLen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Reset the Redis slow queries log
    * @return Handler for the result of this call.
    */
  def slowlogResetFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.slowlogReset(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get all the members in a set
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def smembersFuture(key: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.smembers(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Move a member from one set to another
    * @param key Key of source set currently containing the member
    * @param destkey Key identifying the destination set
    * @param member Member to move
    * @return Handler for the result of this call.
    */
  def smoveFuture(key: String, destkey: String, member: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.smove(key, destkey, member, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Sort the elements in a list, set or sorted set
    * @param key Key string
    * @param options Sort optionssee <a href="../../../../../../cheatsheet/SortOptions.html">SortOptions</a>
    * @return Handler for the result of this call.
    */
  def sortFuture(key: String, options: SortOptions): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.sort(key, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove and return a random member from a set
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def spopFuture(key: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.spop(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove and return random members from a set
    * @param key Key string
    * @param count Number of members to remove
    * @return Handler for the result of this call.
    */
  def spopManyFuture(key: String, count: Int): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.spopMany(key, count, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get one or multiple random members from a set
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def srandmemberFuture(key: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.srandmember(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get one or multiple random members from a set
    * @param key Key string
    * @param count Number of members to get
    * @return Handler for the result of this call.
    */
  def srandmemberCountFuture(key: String, count: Int): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.srandmemberCount(key, count, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove one member from a set
    * @param key Key string
    * @param member Member to remove
    * @return Handler for the result of this call.
    */
  def sremFuture(key: String, member: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.srem(key, member, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove one or more members from a set
    * @param key Key string
    * @param members Members to remove
    * @return Handler for the result of this call.
    */
  def sremManyFuture(key: String, members: scala.collection.mutable.Buffer[String]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.sremMany(key, members.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the length of the value stored in a key
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def strlenFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.strlen(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Listen for messages published to the given channels
    * @param channel Channel to subscribe to
    * @return Handler for the result of this call.
    */
  def subscribeFuture(channel: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.subscribe(channel, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Listen for messages published to the given channels
    * @param channels List of channels to subscribe to
    * @return Handler for the result of this call.
    */
  def subscribeManyFuture(channels: scala.collection.mutable.Buffer[String]): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.subscribeMany(channels.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Add multiple sets
    * @param keys List of keys identifying sets to add up
    * @return Handler for the result of this call.
    */
  def sunionFuture(keys: scala.collection.mutable.Buffer[String]): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.sunion(keys.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Add multiple sets and store the resulting set in a key
    * @param destkey Destination key
    * @param keys List of keys identifying sets to add up
    * @return Handler for the result of this call.
    */
  def sunionstoreFuture(destkey: String, keys: scala.collection.mutable.Buffer[String]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.sunionstore(destkey, keys.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Internal command used for replication
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def syncFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.sync(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return the current server time
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def timeFuture(): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.time(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return a RedisTransaction instance
    * @return transaction instance
    */
  def transaction(): RedisTransaction = {
    RedisTransaction.apply(_asJava.transaction())
  }

  /**
    * Get the time to live for a key
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def ttlFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.ttl(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Determine the type stored at key
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def typeFuture(key: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.`type`(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Stop listening for messages posted to the given channels
    * @param channels List of channels to subscribe to
    * @return Handler for the result of this call.
    */
  def unsubscribeFuture(channels: scala.collection.mutable.Buffer[String]): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.unsubscribe(channels.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Wait for the synchronous replication of all the write commands sent in the context of the current connection.
    * @return Handler for the result of this call.
    */
  def waitFuture(numSlaves: Long, timeout: Long): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.wait(numSlaves, timeout, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Add one or more members to a sorted set, or update its score if it already exists
    * @param key Key string
    * @param score Score used for sorting
    * @param member New member key
    * @return Handler for the result of this call.
    */
  def zaddFuture(key: String, score: Double, member: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zadd(key, score, member, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Add one or more members to a sorted set, or update its score if it already exists
    * @param key Key string
    * @param members New member keys and their scores
    * @return Handler for the result of this call.
    */
  def zaddManyFuture(key: String, members: Map[String, Double]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zaddMany(key, members.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Double)).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the number of members in a sorted set
    * @param key Key string
    * @return Handler for the result of this call.
    */
  def zcardFuture(key: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zcard(key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Count the members in a sorted set with scores within the given values
    * @param key Key string
    * @param min Minimum score
    * @param max Maximum score
    * @return Handler for the result of this call.
    */
  def zcountFuture(key: String, min: Double, max: Double): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zcount(key, min, max, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Increment the score of a member in a sorted set
    * @param key Key string
    * @param increment Increment amount
    * @param member Member key
    * @return Handler for the result of this call.
    */
  def zincrbyFuture(key: String, increment: Double, member: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.zincrby(key, increment, member, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Intersect multiple sorted sets and store the resulting sorted set in a new key
    * @param destkey Destination key
    * @param sets List of keys identifying sorted sets to intersect
    * @param options Aggregation options
    * @return Handler for the result of this call.
    */
  def zinterstoreFuture(destkey: String, sets: scala.collection.mutable.Buffer[String], options: io.vertx.redis.op.AggregateOptions): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zinterstore(destkey, sets.map(x => if (x == null) null else x:java.lang.String).asJava, options, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Intersect multiple sorted sets and store the resulting sorted set in a new key using weights for scoring
    * @param destkey Destination key
    * @param sets List of keys identifying sorted sets to intersect
    * @param options Aggregation options
    * @return Handler for the result of this call.
    */
  def zinterstoreWeighedFuture(destkey: String, sets: Map[String, Double], options: io.vertx.redis.op.AggregateOptions): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zinterstoreWeighed(destkey, sets.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Double)).asJava, options, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Count the number of members in a sorted set between a given lexicographical range
    * @param key Key string
    * @param min Pattern to compare against for minimum value
    * @param max Pattern to compare against for maximum value
    * @return Handler for the result of this call.
    */
  def zlexcountFuture(key: String, min: String, max: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zlexcount(key, min, max, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return a range of members in a sorted set, by index
    * @param key Key string
    * @param start Start index for the range
    * @param stop Stop index for the range - inclusive
    * @return Handler for the result of this call.
    */
  def zrangeFuture(key: String, start: Long, stop: Long): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.zrange(key, start, stop, promiseAndHandler._1)
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
  def zrangeWithOptionsFuture(key: String, start: Long, stop: Long, options: io.vertx.redis.op.RangeOptions): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.zrangeWithOptions(key, start, stop, options, promiseAndHandler._1)
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
  def zrangebylexFuture(key: String, min: String, max: String, options: LimitOptions): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.zrangebylex(key, min, max, options.asJava, promiseAndHandler._1)
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
  def zrangebyscoreFuture(key: String, min: String, max: String, options: RangeLimitOptions): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.zrangebyscore(key, min, max, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Determine the index of a member in a sorted set
    * @param key Key string
    * @param member Member in the sorted set identified by key
    * @return Handler for the result of this call.
    */
  def zrankFuture(key: String, member: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zrank(key, member, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove one member from a sorted set
    * @param key Key string
    * @param member Member in the sorted set identified by key
    * @return Handler for the result of this call.
    */
  def zremFuture(key: String, member: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zrem(key, member, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove one or more members from a sorted set
    * @param key Key string
    * @param members Members in the sorted set identified by key
    * @return Handler for the result of this call.
    */
  def zremManyFuture(key: String, members: scala.collection.mutable.Buffer[String]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zremMany(key, members.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove all members in a sorted set between the given lexicographical range
    * @param key Key string
    * @param min Pattern defining a minimum value
    * @param max Pattern defining a maximum value
    * @return Handler for the result of this call.
    */
  def zremrangebylexFuture(key: String, min: String, max: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zremrangebylex(key, min, max, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove all members in a sorted set within the given indexes
    * @param key Key string
    * @param start Start index
    * @param stop Stop index
    * @return Handler for the result of this call.
    */
  def zremrangebyrankFuture(key: String, start: Long, stop: Long): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zremrangebyrank(key, start, stop, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove all members in a sorted set within the given scores
    * @param key Key string
    * @param min Pattern defining a minimum value
    * @param max Pattern defining a maximum value
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def zremrangebyscoreFuture(key: String, min: String, max: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zremrangebyscore(key, min, max, promiseAndHandler._1)
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
  def zrevrangeFuture(key: String, start: Long, stop: Long, options: io.vertx.redis.op.RangeOptions): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.zrevrange(key, start, stop, options, promiseAndHandler._1)
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
  def zrevrangebylexFuture(key: String, max: String, min: String, options: LimitOptions): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.zrevrangebylex(key, max, min, options.asJava, promiseAndHandler._1)
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
  def zrevrangebyscoreFuture(key: String, max: String, min: String, options: RangeLimitOptions): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.zrevrangebyscore(key, max, min, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Determine the index of a member in a sorted set, with scores ordered from high to low
    * @param key Key string
    * @param member Member in the sorted set identified by key
    * @return Handler for the result of this call.
    */
  def zrevrankFuture(key: String, member: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zrevrank(key, member, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the score associated with the given member in a sorted set
    * @param key Key string
    * @param member Member in the sorted set identified by key
    * @return Handler for the result of this call.
    */
  def zscoreFuture(key: String, member: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.zscore(key, member, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Add multiple sorted sets and store the resulting sorted set in a new key
    * @param destkey Destination key
    * @param sets List of keys identifying sorted sets
    * @param options Aggregation options
    * @return Handler for the result of this call.
    */
  def zunionstoreFuture(destkey: String, sets: scala.collection.mutable.Buffer[String], options: io.vertx.redis.op.AggregateOptions): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zunionstore(destkey, sets.map(x => if (x == null) null else x:java.lang.String).asJava, options, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Add multiple sorted sets using weights, and store the resulting sorted set in a new key
    * @param key Destination key
    * @param sets Map containing set-key:weight pairs
    * @param options Aggregation options
    * @return Handler for the result of this call.
    */
  def zunionstoreWeighedFuture(key: String, sets: Map[String, Double], options: io.vertx.redis.op.AggregateOptions): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.zunionstoreWeighed(key, sets.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Double)).asJava, options, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Incrementally iterate the keys space
    * @param cursor Cursor id
    * @param options Scan optionssee <a href="../../../../../../cheatsheet/ScanOptions.html">ScanOptions</a>
    * @return Handler for the result of this call.
    */
  def scanFuture(cursor: String, options: ScanOptions): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.scan(cursor, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Incrementally iterate Set elements
    * @param key Key string
    * @param cursor Cursor id
    * @param options Scan optionssee <a href="../../../../../../cheatsheet/ScanOptions.html">ScanOptions</a>
    * @return Handler for the result of this call.
    */
  def sscanFuture(key: String, cursor: String, options: ScanOptions): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.sscan(key, cursor, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Incrementally iterate hash fields and associated values
    * @param key Key string
    * @param cursor Cursor id
    * @param options Scan optionssee <a href="../../../../../../cheatsheet/ScanOptions.html">ScanOptions</a>
    * @return Handler for the result of this call.
    */
  def hscanFuture(key: String, cursor: String, options: ScanOptions): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.hscan(key, cursor, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Incrementally iterate sorted sets elements and associated scores
    * @param key Key string
    * @param cursor Cursor id
    * @param options Scan optionssee <a href="../../../../../../cheatsheet/ScanOptions.html">ScanOptions</a>
    * @return Handler for the result of this call.
    */
  def zscanFuture(key: String, cursor: String, options: ScanOptions): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.zscan(key, cursor, options.asJava, promiseAndHandler._1)
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
  def geoaddFuture(key: String, longitude: Double, latitude: Double, member: String): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.geoadd(key, longitude, latitude, member, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Add one or more geospatial items in the geospatial index represented using a sorted set.
    * @param key Key string
    * @param members list of &lt;lon, lat, member&gt;
    * @return Handler for the result of this call.
    */
  def geoaddManyFuture(key: String, members: scala.collection.mutable.Buffer[GeoMember]): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.geoaddMany(key, members.map(x => if (x == null) null else x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return valid Geohash strings representing the position of one or more elements in a sorted set value representing
    * a geospatial index (where elements were added using GEOADD).
    * @param key Key string
    * @param member member
    * @return Handler for the result of this call.
    */
  def geohashFuture(key: String, member: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.geohash(key, member, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return valid Geohash strings representing the position of one or more elements in a sorted set value representing
    * a geospatial index (where elements were added using GEOADD).
    * @param key Key string
    * @param members list of members
    * @return Handler for the result of this call.
    */
  def geohashManyFuture(key: String, members: scala.collection.mutable.Buffer[String]): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.geohashMany(key, members.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return the positions (longitude,latitude) of all the specified members of the geospatial index represented by the
    * sorted set at key.
    * @param key Key string
    * @param member member
    * @return Handler for the result of this call.
    */
  def geoposFuture(key: String, member: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.geopos(key, member, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return the positions (longitude,latitude) of all the specified members of the geospatial index represented by the
    * sorted set at key.
    * @param key Key string
    * @param members list of members
    * @return Handler for the result of this call.
    */
  def geoposManyFuture(key: String, members: scala.collection.mutable.Buffer[String]): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.geoposMany(key, members.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return the distance between two members in the geospatial index represented by the sorted set.
    * @param key Key string
    * @param member1 member 1
    * @param member2 member 2
    * @return Handler for the result of this call.
    */
  def geodistFuture(key: String, member1: String, member2: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.geodist(key, member1, member2, promiseAndHandler._1)
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
  def geodistWithUnitFuture(key: String, member1: String, member2: String, unit: io.vertx.redis.op.GeoUnit): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.geodistWithUnit(key, member1, member2, unit, promiseAndHandler._1)
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
  def georadiusFuture(key: String, longitude: Double, latitude: Double, radius: Double, unit: io.vertx.redis.op.GeoUnit): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.georadius(key, longitude, latitude, radius, unit, promiseAndHandler._1)
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
  def georadiusWithOptionsFuture(key: String, longitude: Double, latitude: Double, radius: Double, unit: io.vertx.redis.op.GeoUnit, options: GeoRadiusOptions): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.georadiusWithOptions(key, longitude, latitude, radius, unit, options.asJava, promiseAndHandler._1)
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
  def georadiusbymemberFuture(key: String, member: String, radius: Double, unit: io.vertx.redis.op.GeoUnit): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.georadiusbymember(key, member, radius, unit, promiseAndHandler._1)
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
  def georadiusbymemberWithOptionsFuture(key: String, member: String, radius: Double, unit: io.vertx.redis.op.GeoUnit, options: GeoRadiusOptions): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.georadiusbymemberWithOptions(key, member, radius, unit, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object RedisClient {

  def apply(_asJava: JRedisClient): RedisClient =
    new RedisClient(_asJava)

  def create(vertx: Vertx): RedisClient = {
    RedisClient.apply(io.vertx.redis.RedisClient.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  def create(vertx: Vertx, config: RedisOptions): RedisClient = {
    RedisClient.apply(io.vertx.redis.RedisClient.create(vertx.asJava.asInstanceOf[JVertx], config.asJava))
  }

}
