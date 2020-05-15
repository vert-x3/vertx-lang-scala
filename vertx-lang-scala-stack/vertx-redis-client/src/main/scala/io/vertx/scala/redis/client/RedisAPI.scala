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
import io.vertx.redis.client.{Response => JResponse}
import io.vertx.redis.client.{RedisAPI => JRedisAPI}
import io.vertx.redis.client.{Redis => JRedis}
import scala.reflect.runtime.universe._
import io.vertx.redis.client.{RedisConnection => JRedisConnection}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * <b>Auto generated</b> Redis API client wrapper.

  */

class RedisAPI(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Redis command <a href="https://redis.io/commands/append">append</a>.   * @return fluent self
   */
  
  def append(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].append(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/asking">asking</a>.   * @return fluent self
   */
  
  def asking(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].asking((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/auth">auth</a>.   * @return fluent self
   */
  
  def auth(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].auth(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/bgrewriteaof">bgrewriteaof</a>.   * @return fluent self
   */
  
  def bgrewriteaof(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bgrewriteaof((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/bgsave">bgsave</a>.   * @return fluent self
   */
  
  def bgsave(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bgsave(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/bitcount">bitcount</a>.   * @return fluent self
   */
  
  def bitcount(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bitcount(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/bitfield">bitfield</a>.   * @return fluent self
   */
  
  def bitfield(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bitfield(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/bitop">bitop</a>.   * @return fluent self
   */
  
  def bitop(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bitop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/bitpos">bitpos</a>.   * @return fluent self
   */
  
  def bitpos(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bitpos(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/blpop">blpop</a>.   * @return fluent self
   */
  
  def blpop(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].blpop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/brpop">brpop</a>.   * @return fluent self
   */
  
  def brpop(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].brpop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/brpoplpush">brpoplpush</a>.   * @return fluent self
   */
  
  def brpoplpush(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].brpoplpush(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/bzpopmax">bzpopmax</a>.   * @return fluent self
   */
  
  def bzpopmax(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bzpopmax(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/bzpopmin">bzpopmin</a>.   * @return fluent self
   */
  
  def bzpopmin(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bzpopmin(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/client">client</a>.   * @return fluent self
   */
  
  def client(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].client(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/cluster">cluster</a>.   * @return fluent self
   */
  
  def cluster(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].cluster(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/command">command</a>.   * @return fluent self
   */
  
  def command(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].command((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/config">config</a>.   * @return fluent self
   */
  
  def config(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].config(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/dbsize">dbsize</a>.   * @return fluent self
   */
  
  def dbsize(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].dbsize((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/debug">debug</a>.   * @return fluent self
   */
  
  def debug(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].debug(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/decr">decr</a>.   * @return fluent self
   */
  
  def decr(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].decr(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/decrby">decrby</a>.   * @return fluent self
   */
  
  def decrby(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].decrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/del">del</a>.   * @return fluent self
   */
  
  def del(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].del(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/discard">discard</a>.   * @return fluent self
   */
  
  def discard(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].discard((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/dump">dump</a>.   * @return fluent self
   */
  
  def dump(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].dump(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/echo">echo</a>.   * @return fluent self
   */
  
  def echo(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].echo(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/eval">eval</a>.   * @return fluent self
   */
  
  def eval(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].eval(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/evalsha">evalsha</a>.   * @return fluent self
   */
  
  def evalsha(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].evalsha(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/exec">exec</a>.   * @return fluent self
   */
  
  def exec(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].exec((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/exists">exists</a>.   * @return fluent self
   */
  
  def exists(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].exists(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/expire">expire</a>.   * @return fluent self
   */
  
  def expire(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].expire(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/expireat">expireat</a>.   * @return fluent self
   */
  
  def expireat(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].expireat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/flushall">flushall</a>.   * @return fluent self
   */
  
  def flushall(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].flushall(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/flushdb">flushdb</a>.   * @return fluent self
   */
  
  def flushdb(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].flushdb(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/geoadd">geoadd</a>.   * @return fluent self
   */
  
  def geoadd(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].geoadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/geodist">geodist</a>.   * @return fluent self
   */
  
  def geodist(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].geodist(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/geohash">geohash</a>.   * @return fluent self
   */
  
  def geohash(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].geohash(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/geopos">geopos</a>.   * @return fluent self
   */
  
  def geopos(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].geopos(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/georadius">georadius</a>.   * @return fluent self
   */
  
  def georadius(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].georadius(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/georadius_ro">georadiusRo</a>.   * @return fluent self
   */
  
  def georadiusRo(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].georadiusRo(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/georadiusbymember">georadiusbymember</a>.   * @return fluent self
   */
  
  def georadiusbymember(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].georadiusbymember(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/georadiusbymember_ro">georadiusbymemberRo</a>.   * @return fluent self
   */
  
  def georadiusbymemberRo(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].georadiusbymemberRo(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/get">get</a>.   * @return fluent self
   */
  
  def get(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].get(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/getbit">getbit</a>.   * @return fluent self
   */
  
  def getbit(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].getbit(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/getrange">getrange</a>.   * @return fluent self
   */
  
  def getrange(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].getrange(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/getset">getset</a>.   * @return fluent self
   */
  
  def getset(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].getset(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hdel">hdel</a>.   * @return fluent self
   */
  
  def hdel(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hdel(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hexists">hexists</a>.   * @return fluent self
   */
  
  def hexists(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hexists(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hget">hget</a>.   * @return fluent self
   */
  
  def hget(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hget(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hgetall">hgetall</a>.   * @return fluent self
   */
  
  def hgetall(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hgetall(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hincrby">hincrby</a>.   * @return fluent self
   */
  
  def hincrby(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hincrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hincrbyfloat">hincrbyfloat</a>.   * @return fluent self
   */
  
  def hincrbyfloat(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hincrbyfloat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hkeys">hkeys</a>.   * @return fluent self
   */
  
  def hkeys(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hkeys(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hlen">hlen</a>.   * @return fluent self
   */
  
  def hlen(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hlen(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hmget">hmget</a>.   * @return fluent self
   */
  
  def hmget(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hmget(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hmset">hmset</a>.   * @return fluent self
   */
  
  def hmset(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hmset(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/host:">host</a>.   * @return fluent self
   */
  
  def host(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].host(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hscan">hscan</a>.   * @return fluent self
   */
  
  def hscan(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hscan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hset">hset</a>.   * @return fluent self
   */
  
  def hset(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hset(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hsetnx">hsetnx</a>.   * @return fluent self
   */
  
  def hsetnx(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hsetnx(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hstrlen">hstrlen</a>.   * @return fluent self
   */
  
  def hstrlen(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hstrlen(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/hvals">hvals</a>.   * @return fluent self
   */
  
  def hvals(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hvals(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/incr">incr</a>.   * @return fluent self
   */
  
  def incr(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].incr(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/incrby">incrby</a>.   * @return fluent self
   */
  
  def incrby(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].incrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/incrbyfloat">incrbyfloat</a>.   * @return fluent self
   */
  
  def incrbyfloat(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].incrbyfloat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/info">info</a>.   * @return fluent self
   */
  
  def info(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].info(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/keys">keys</a>.   * @return fluent self
   */
  
  def keys(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].keys(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/lastsave">lastsave</a>.   * @return fluent self
   */
  
  def lastsave(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lastsave((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/latency">latency</a>.   * @return fluent self
   */
  
  def latency(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].latency(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/lindex">lindex</a>.   * @return fluent self
   */
  
  def lindex(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lindex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/linsert">linsert</a>.   * @return fluent self
   */
  
  def linsert(arg0: String, arg1: String, arg2: String, arg3: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].linsert(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], arg3.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/llen">llen</a>.   * @return fluent self
   */
  
  def llen(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].llen(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/lolwut">lolwut</a>.   * @return fluent self
   */
  
  def lolwut(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lolwut(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/lpop">lpop</a>.   * @return fluent self
   */
  
  def lpop(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lpop(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/lpush">lpush</a>.   * @return fluent self
   */
  
  def lpush(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lpush(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/lpushx">lpushx</a>.   * @return fluent self
   */
  
  def lpushx(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lpushx(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/lrange">lrange</a>.   * @return fluent self
   */
  
  def lrange(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lrange(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/lrem">lrem</a>.   * @return fluent self
   */
  
  def lrem(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lrem(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/lset">lset</a>.   * @return fluent self
   */
  
  def lset(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lset(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/ltrim">ltrim</a>.   * @return fluent self
   */
  
  def ltrim(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].ltrim(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/memory">memory</a>.   * @return fluent self
   */
  
  def memory(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].memory(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/mget">mget</a>.   * @return fluent self
   */
  
  def mget(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].mget(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/migrate">migrate</a>.   * @return fluent self
   */
  
  def migrate(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].migrate(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/module">module</a>.   * @return fluent self
   */
  
  def module(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].module(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/monitor">monitor</a>.   * @return fluent self
   */
  
  def monitor(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].monitor((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/move">move</a>.   * @return fluent self
   */
  
  def move(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].move(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/mset">mset</a>.   * @return fluent self
   */
  
  def mset(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].mset(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/msetnx">msetnx</a>.   * @return fluent self
   */
  
  def msetnx(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].msetnx(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/multi">multi</a>.   * @return fluent self
   */
  
  def multi(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].multi((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/object">object</a>.   * @return fluent self
   */
  
  def `object`(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].`object`(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/persist">persist</a>.   * @return fluent self
   */
  
  def persist(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].persist(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/pexpire">pexpire</a>.   * @return fluent self
   */
  
  def pexpire(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pexpire(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/pexpireat">pexpireat</a>.   * @return fluent self
   */
  
  def pexpireat(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pexpireat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/pfadd">pfadd</a>.   * @return fluent self
   */
  
  def pfadd(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pfadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/pfcount">pfcount</a>.   * @return fluent self
   */
  
  def pfcount(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pfcount(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/pfdebug">pfdebug</a>.   * @return fluent self
   */
  
  def pfdebug(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pfdebug(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/pfmerge">pfmerge</a>.   * @return fluent self
   */
  
  def pfmerge(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pfmerge(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/pfselftest">pfselftest</a>.   * @return fluent self
   */
  
  def pfselftest(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pfselftest((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/ping">ping</a>.   * @return fluent self
   */
  
  def ping(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].ping(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/post">post</a>.   * @return fluent self
   */
  
  def post(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].post(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/psetex">psetex</a>.   * @return fluent self
   */
  
  def psetex(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].psetex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/psubscribe">psubscribe</a>.   * @return fluent self
   */
  
  def psubscribe(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].psubscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/psync">psync</a>.   * @return fluent self
   */
  
  def psync(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].psync(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/pttl">pttl</a>.   * @return fluent self
   */
  
  def pttl(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pttl(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/publish">publish</a>.   * @return fluent self
   */
  
  def publish(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].publish(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/pubsub">pubsub</a>.   * @return fluent self
   */
  
  def pubsub(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pubsub(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/punsubscribe">punsubscribe</a>.   * @return fluent self
   */
  
  def punsubscribe(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].punsubscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/randomkey">randomkey</a>.   * @return fluent self
   */
  
  def randomkey(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].randomkey((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/readonly">readonly</a>.   * @return fluent self
   */
  
  def readonly(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].readonly((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/readwrite">readwrite</a>.   * @return fluent self
   */
  
  def readwrite(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].readwrite((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/rename">rename</a>.   * @return fluent self
   */
  
  def rename(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].rename(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/renamenx">renamenx</a>.   * @return fluent self
   */
  
  def renamenx(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].renamenx(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/replconf">replconf</a>.   * @return fluent self
   */
  
  def replconf(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].replconf(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/replicaof">replicaof</a>.   * @return fluent self
   */
  
  def replicaof(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].replicaof(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/restore">restore</a>.   * @return fluent self
   */
  
  def restore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].restore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/restore-asking">restoreAsking</a>.   * @return fluent self
   */
  
  def restoreAsking(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].restoreAsking(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/role">role</a>.   * @return fluent self
   */
  
  def role(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].role((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/rpop">rpop</a>.   * @return fluent self
   */
  
  def rpop(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].rpop(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/rpoplpush">rpoplpush</a>.   * @return fluent self
   */
  
  def rpoplpush(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].rpoplpush(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/rpush">rpush</a>.   * @return fluent self
   */
  
  def rpush(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].rpush(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/rpushx">rpushx</a>.   * @return fluent self
   */
  
  def rpushx(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].rpushx(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/sadd">sadd</a>.   * @return fluent self
   */
  
  def sadd(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/save">save</a>.   * @return fluent self
   */
  
  def save(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].save((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/scan">scan</a>.   * @return fluent self
   */
  
  def scan(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].scan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/scard">scard</a>.   * @return fluent self
   */
  
  def scard(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].scard(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/script">script</a>.   * @return fluent self
   */
  
  def script(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].script(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/sdiff">sdiff</a>.   * @return fluent self
   */
  
  def sdiff(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sdiff(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/sdiffstore">sdiffstore</a>.   * @return fluent self
   */
  
  def sdiffstore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sdiffstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/select">select</a>.   * @return fluent self
   */
  
  def select(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].select(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/set">set</a>.   * @return fluent self
   */
  
  def set(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].set(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/setbit">setbit</a>.   * @return fluent self
   */
  
  def setbit(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].setbit(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/setex">setex</a>.   * @return fluent self
   */
  
  def setex(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].setex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/setnx">setnx</a>.   * @return fluent self
   */
  
  def setnx(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].setnx(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/setrange">setrange</a>.   * @return fluent self
   */
  
  def setrange(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].setrange(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/shutdown">shutdown</a>.   * @return fluent self
   */
  
  def shutdown(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].shutdown(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/sinter">sinter</a>.   * @return fluent self
   */
  
  def sinter(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sinter(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/sinterstore">sinterstore</a>.   * @return fluent self
   */
  
  def sinterstore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sinterstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/sismember">sismember</a>.   * @return fluent self
   */
  
  def sismember(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sismember(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/slaveof">slaveof</a>.   * @return fluent self
   */
  
  def slaveof(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].slaveof(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/slowlog">slowlog</a>.   * @return fluent self
   */
  
  def slowlog(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].slowlog(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/smembers">smembers</a>.   * @return fluent self
   */
  
  def smembers(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].smembers(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/smove">smove</a>.   * @return fluent self
   */
  
  def smove(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].smove(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/sort">sort</a>.   * @return fluent self
   */
  
  def sort(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sort(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/spop">spop</a>.   * @return fluent self
   */
  
  def spop(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].spop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/srandmember">srandmember</a>.   * @return fluent self
   */
  
  def srandmember(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].srandmember(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/srem">srem</a>.   * @return fluent self
   */
  
  def srem(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].srem(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/sscan">sscan</a>.   * @return fluent self
   */
  
  def sscan(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sscan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/strlen">strlen</a>.   * @return fluent self
   */
  
  def strlen(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].strlen(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/subscribe">subscribe</a>.   * @return fluent self
   */
  
  def subscribe(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].subscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/substr">substr</a>.   * @return fluent self
   */
  
  def substr(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].substr(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/sunion">sunion</a>.   * @return fluent self
   */
  
  def sunion(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sunion(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/sunionstore">sunionstore</a>.   * @return fluent self
   */
  
  def sunionstore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sunionstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/swapdb">swapdb</a>.   * @return fluent self
   */
  
  def swapdb(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].swapdb(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/sync">sync</a>.   * @return fluent self
   */
  
  def sync(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sync((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/time">time</a>.   * @return fluent self
   */
  
  def time(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].time((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/touch">touch</a>.   * @return fluent self
   */
  
  def touch(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].touch(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/ttl">ttl</a>.   * @return fluent self
   */
  
  def ttl(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].ttl(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/type">type</a>.   * @return fluent self
   */
  
  def `type`(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].`type`(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/unlink">unlink</a>.   * @return fluent self
   */
  
  def unlink(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].unlink(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/unsubscribe">unsubscribe</a>.   * @return fluent self
   */
  
  def unsubscribe(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].unsubscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/unwatch">unwatch</a>.   * @return fluent self
   */
  
  def unwatch(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].unwatch((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/wait">wait</a>.   * @return fluent self
   */
  
  def wait(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].wait(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/watch">watch</a>.   * @return fluent self
   */
  
  def watch(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].watch(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/xack">xack</a>.   * @return fluent self
   */
  
  def xack(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xack(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/xadd">xadd</a>.   * @return fluent self
   */
  
  def xadd(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/xclaim">xclaim</a>.   * @return fluent self
   */
  
  def xclaim(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xclaim(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/xdel">xdel</a>.   * @return fluent self
   */
  
  def xdel(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xdel(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/xgroup">xgroup</a>.   * @return fluent self
   */
  
  def xgroup(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xgroup(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/xinfo">xinfo</a>.   * @return fluent self
   */
  
  def xinfo(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xinfo(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/xlen">xlen</a>.   * @return fluent self
   */
  
  def xlen(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xlen(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/xpending">xpending</a>.   * @return fluent self
   */
  
  def xpending(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xpending(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/xrange">xrange</a>.   * @return fluent self
   */
  
  def xrange(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/xread">xread</a>.   * @return fluent self
   */
  
  def xread(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xread(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/xreadgroup">xreadgroup</a>.   * @return fluent self
   */
  
  def xreadgroup(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xreadgroup(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/xrevrange">xrevrange</a>.   * @return fluent self
   */
  
  def xrevrange(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xrevrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/xsetid">xsetid</a>.   * @return fluent self
   */
  
  def xsetid(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xsetid(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/xtrim">xtrim</a>.   * @return fluent self
   */
  
  def xtrim(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xtrim(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zadd">zadd</a>.   * @return fluent self
   */
  
  def zadd(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zcard">zcard</a>.   * @return fluent self
   */
  
  def zcard(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zcard(arg0.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zcount">zcount</a>.   * @return fluent self
   */
  
  def zcount(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zcount(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zincrby">zincrby</a>.   * @return fluent self
   */
  
  def zincrby(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zincrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zinterstore">zinterstore</a>.   * @return fluent self
   */
  
  def zinterstore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zinterstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zlexcount">zlexcount</a>.   * @return fluent self
   */
  
  def zlexcount(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zlexcount(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zpopmax">zpopmax</a>.   * @return fluent self
   */
  
  def zpopmax(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zpopmax(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zpopmin">zpopmin</a>.   * @return fluent self
   */
  
  def zpopmin(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zpopmin(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zrange">zrange</a>.   * @return fluent self
   */
  
  def zrange(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zrangebylex">zrangebylex</a>.   * @return fluent self
   */
  
  def zrangebylex(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrangebylex(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zrangebyscore">zrangebyscore</a>.   * @return fluent self
   */
  
  def zrangebyscore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrangebyscore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zrank">zrank</a>.   * @return fluent self
   */
  
  def zrank(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrank(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zrem">zrem</a>.   * @return fluent self
   */
  
  def zrem(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrem(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zremrangebylex">zremrangebylex</a>.   * @return fluent self
   */
  
  def zremrangebylex(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zremrangebylex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zremrangebyrank">zremrangebyrank</a>.   * @return fluent self
   */
  
  def zremrangebyrank(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zremrangebyrank(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zremrangebyscore">zremrangebyscore</a>.   * @return fluent self
   */
  
  def zremrangebyscore(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zremrangebyscore(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zrevrange">zrevrange</a>.   * @return fluent self
   */
  
  def zrevrange(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrevrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zrevrangebylex">zrevrangebylex</a>.   * @return fluent self
   */
  
  def zrevrangebylex(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrevrangebylex(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zrevrangebyscore">zrevrangebyscore</a>.   * @return fluent self
   */
  
  def zrevrangebyscore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrevrangebyscore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zrevrank">zrevrank</a>.   * @return fluent self
   */
  
  def zrevrank(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrevrank(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zscan">zscan</a>.   * @return fluent self
   */
  
  def zscan(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zscan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zscore">zscore</a>.   * @return fluent self
   */
  
  def zscore(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zscore(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }

  /**
   * Redis command <a href="https://redis.io/commands/zunionstore">zunionstore</a>.   * @return fluent self
   */
  
  def zunionstore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zunionstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JResponse]]{def handle(x: AsyncResult[JResponse]) {handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))}}))
    this
  }




  def close (): Unit = {
    asJava.asInstanceOf[JRedisAPI].close()
  }


 /**
  * Like [[append]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def appendFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].append(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[asking]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def askingFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].asking(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[auth]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def authFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].auth(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[bgrewriteaof]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def bgrewriteaofFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bgrewriteaof(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[bgsave]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def bgsaveFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bgsave(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[bitcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def bitcountFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bitcount(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[bitfield]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def bitfieldFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bitfield(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[bitop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def bitopFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bitop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[bitpos]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def bitposFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bitpos(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[blpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def blpopFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].blpop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[brpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def brpopFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].brpop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[brpoplpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def brpoplpushFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].brpoplpush(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[bzpopmax]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def bzpopmaxFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bzpopmax(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[bzpopmin]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def bzpopminFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bzpopmin(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[client]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def clientFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].client(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[cluster]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def clusterFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].cluster(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[command]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def commandFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].command(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[config]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def configFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].config(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[dbsize]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def dbsizeFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].dbsize(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[debug]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def debugFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].debug(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[decr]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def decrFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].decr(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[decrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def decrbyFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].decrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[del]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def delFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].del(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[discard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def discardFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].discard(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[dump]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def dumpFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].dump(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[echo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def echoFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].echo(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[eval]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def evalFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].eval(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[evalsha]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def evalshaFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].evalsha(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[exec]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def execFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].exec(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[exists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def existsFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].exists(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[expire]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def expireFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].expire(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[expireat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def expireatFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].expireat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[flushall]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def flushallFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].flushall(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[flushdb]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def flushdbFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].flushdb(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[geoadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def geoaddFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].geoadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[geodist]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def geodistFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].geodist(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[geohash]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def geohashFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].geohash(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[geopos]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def geoposFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].geopos(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[georadius]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def georadiusFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].georadius(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[georadiusRo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def georadiusRoFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].georadiusRo(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[georadiusbymember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def georadiusbymemberFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].georadiusbymember(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[georadiusbymemberRo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def georadiusbymemberRoFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].georadiusbymemberRo(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].get(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getbit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getbitFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].getbit(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getrangeFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].getrange(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getsetFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].getset(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hdel]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hdelFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hdel(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hexists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hexistsFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hexists(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hgetFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hget(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hgetall]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hgetallFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hgetall(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hincrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hincrbyFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hincrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hincrbyfloat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hincrbyfloatFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hincrbyfloat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hkeys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hkeysFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hkeys(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hlenFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hlen(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hmget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hmgetFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hmget(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hmset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hmsetFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hmset(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[host]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hostFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].host(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hscanFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hscan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hsetFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hset(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hsetnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hsetnxFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hsetnx(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hstrlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hstrlenFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hstrlen(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[hvals]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def hvalsFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hvals(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[incr]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def incrFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].incr(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[incrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def incrbyFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].incrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[incrbyfloat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def incrbyfloatFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].incrbyfloat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[info]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def infoFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].info(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[keys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def keysFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].keys(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[lastsave]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def lastsaveFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lastsave(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[latency]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def latencyFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].latency(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[lindex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def lindexFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lindex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[linsert]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def linsertFuture (arg0: String, arg1: String, arg2: String, arg3: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].linsert(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], arg3.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[llen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def llenFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].llen(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[lolwut]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def lolwutFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lolwut(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[lpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def lpopFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lpop(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[lpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def lpushFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lpush(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[lpushx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def lpushxFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lpushx(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[lrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def lrangeFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lrange(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[lrem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def lremFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lrem(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[lset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def lsetFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lset(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[ltrim]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def ltrimFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].ltrim(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[memory]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def memoryFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].memory(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[mget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def mgetFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].mget(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[migrate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def migrateFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].migrate(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[module]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def moduleFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].module(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[monitor]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def monitorFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].monitor(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[move]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def moveFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].move(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[mset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def msetFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].mset(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[msetnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def msetnxFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].msetnx(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[multi]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def multiFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].multi(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[object]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def objectFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].`object`(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[persist]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def persistFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].persist(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[pexpire]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pexpireFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pexpire(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[pexpireat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pexpireatFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pexpireat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[pfadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pfaddFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pfadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[pfcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pfcountFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pfcount(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[pfdebug]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pfdebugFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pfdebug(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[pfmerge]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pfmergeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pfmerge(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[pfselftest]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pfselftestFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pfselftest(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[ping]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pingFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].ping(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[post]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def postFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].post(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[psetex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def psetexFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].psetex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[psubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def psubscribeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].psubscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[psync]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def psyncFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].psync(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[pttl]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pttlFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pttl(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[publish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def publishFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].publish(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[pubsub]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pubsubFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pubsub(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[punsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def punsubscribeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].punsubscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[randomkey]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def randomkeyFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].randomkey(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[readonly]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def readonlyFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].readonly(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[readwrite]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def readwriteFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].readwrite(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[rename]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def renameFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].rename(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[renamenx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def renamenxFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].renamenx(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[replconf]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def replconfFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].replconf(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[replicaof]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def replicaofFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].replicaof(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[restore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def restoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].restore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[restoreAsking]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def restoreAskingFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].restoreAsking(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[role]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def roleFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].role(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[rpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def rpopFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].rpop(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[rpoplpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def rpoplpushFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].rpoplpush(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[rpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def rpushFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].rpush(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[rpushx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def rpushxFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].rpushx(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def saddFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[save]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def saveFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].save(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[scan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def scanFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].scan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[scard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def scardFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].scard(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[script]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def scriptFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].script(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sdiff]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sdiffFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sdiff(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sdiffstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sdiffstoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sdiffstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[select]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def selectFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].select(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[set]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def setFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].set(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[setbit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def setbitFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].setbit(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[setex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def setexFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].setex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[setnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def setnxFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].setnx(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[setrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def setrangeFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].setrange(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[shutdown]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def shutdownFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].shutdown(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sinter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sinterFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sinter(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sinterstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sinterstoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sinterstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sismember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sismemberFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sismember(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[slaveof]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def slaveofFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].slaveof(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[slowlog]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def slowlogFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].slowlog(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[smembers]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def smembersFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].smembers(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[smove]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def smoveFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].smove(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sort]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sortFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sort(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[spop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def spopFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].spop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[srandmember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def srandmemberFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].srandmember(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[srem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sremFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].srem(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sscanFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sscan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[strlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def strlenFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].strlen(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def subscribeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].subscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[substr]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def substrFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].substr(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sunion]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sunionFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sunion(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sunionstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sunionstoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sunionstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[swapdb]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def swapdbFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].swapdb(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sync]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def syncFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sync(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[time]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def timeFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].time(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[touch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def touchFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].touch(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[ttl]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def ttlFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].ttl(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[type]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def typeFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].`type`(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[unlink]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def unlinkFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].unlink(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[unsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def unsubscribeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].unsubscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[unwatch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def unwatchFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].unwatch(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[wait]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def waitFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].wait(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[watch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def watchFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].watch(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[xack]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def xackFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xack(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[xadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def xaddFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[xclaim]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def xclaimFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xclaim(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[xdel]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def xdelFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xdel(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[xgroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def xgroupFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xgroup(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[xinfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def xinfoFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xinfo(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[xlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def xlenFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xlen(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[xpending]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def xpendingFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xpending(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[xrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def xrangeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[xread]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def xreadFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xread(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[xreadgroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def xreadgroupFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xreadgroup(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[xrevrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def xrevrangeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xrevrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[xsetid]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def xsetidFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xsetid(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[xtrim]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def xtrimFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xtrim(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zaddFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zcard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zcardFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zcard(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zcountFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zcount(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zincrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zincrbyFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zincrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zinterstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zinterstoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zinterstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zlexcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zlexcountFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zlexcount(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zpopmax]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zpopmaxFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zpopmax(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zpopmin]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zpopminFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zpopmin(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zrangeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zrangebylexFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrangebylex(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zrangebyscoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrangebyscore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zrankFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrank(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zrem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zremFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrem(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zremrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zremrangebylexFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zremrangebylex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zremrangebyrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zremrangebyrankFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zremrangebyrank(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zremrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zremrangebyscoreFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zremrangebyscore(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zrevrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zrevrangeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrevrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zrevrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zrevrangebylexFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrevrangebylex(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zrevrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zrevrangebyscoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrevrangebyscore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zrevrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zrevrankFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrevrank(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zscanFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zscan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zscoreFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zscore(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[zunionstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def zunionstoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zunionstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object RedisAPI {
  def apply(asJava: JRedisAPI) = new RedisAPI(asJava)

}
