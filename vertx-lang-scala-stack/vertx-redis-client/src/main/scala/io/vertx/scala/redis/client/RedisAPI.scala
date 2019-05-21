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




  
  def append(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].append(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def asking(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].asking({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def auth(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].auth(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def bgrewriteaof(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bgrewriteaof({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def bgsave(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bgsave(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def bitcount(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bitcount(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def bitfield(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bitfield(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def bitop(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bitop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def bitpos(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bitpos(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def blpop(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].blpop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def brpop(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].brpop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def brpoplpush(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].brpoplpush(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def bzpopmax(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bzpopmax(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def bzpopmin(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].bzpopmin(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def client(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].client(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def cluster(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].cluster(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def command(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].command(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def config(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].config(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def dbsize(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].dbsize({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def debug(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].debug(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def decr(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].decr(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def decrby(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].decrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def del(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].del(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def discard(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].discard({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def dump(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].dump(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def echo(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].echo(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def eval(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].eval(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def evalsha(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].evalsha(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def exec(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].exec({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def exists(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].exists(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def expire(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].expire(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def expireat(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].expireat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def flushall(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].flushall(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def flushdb(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].flushdb(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def geoadd(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].geoadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def geodist(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].geodist(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def geohash(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].geohash(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def geopos(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].geopos(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def georadius(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].georadius(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def georadiusRo(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].georadiusRo(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def georadiusbymember(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].georadiusbymember(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def georadiusbymemberRo(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].georadiusbymemberRo(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def get(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].get(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def getbit(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].getbit(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def getrange(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].getrange(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def getset(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].getset(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hdel(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hdel(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hexists(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hexists(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hget(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hget(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hgetall(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hgetall(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hincrby(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hincrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hincrbyfloat(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hincrbyfloat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hkeys(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hkeys(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hlen(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hlen(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hmget(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hmget(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hmset(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hmset(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def host(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].host(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hscan(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hscan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hset(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hset(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hsetnx(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hsetnx(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hstrlen(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hstrlen(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def hvals(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].hvals(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def incr(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].incr(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def incrby(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].incrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def incrbyfloat(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].incrbyfloat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def info(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].info(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def keys(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].keys(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def lastsave(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lastsave({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def latency(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].latency(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def lindex(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lindex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def linsert(arg0: String, arg1: String, arg2: String, arg3: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].linsert(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], arg3.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def llen(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].llen(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def lolwut(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lolwut(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def lpop(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lpop(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def lpush(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lpush(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def lpushx(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lpushx(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def lrange(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lrange(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def lrem(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lrem(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def lset(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].lset(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def ltrim(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].ltrim(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def memory(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].memory(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def mget(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].mget(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def migrate(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].migrate(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def module(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].module(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def monitor(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].monitor({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def move(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].move(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def mset(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].mset(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def msetnx(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].msetnx(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def multi(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].multi({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def `object`(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].`object`(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def persist(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].persist(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def pexpire(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pexpire(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def pexpireat(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pexpireat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def pfadd(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pfadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def pfcount(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pfcount(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def pfdebug(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pfdebug(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def pfmerge(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pfmerge(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def pfselftest(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pfselftest({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def ping(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].ping(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def post(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].post(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def psetex(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].psetex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def psubscribe(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].psubscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def psync(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].psync(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def pttl(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pttl(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def publish(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].publish(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def pubsub(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].pubsub(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def punsubscribe(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].punsubscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def randomkey(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].randomkey({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def readonly(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].readonly({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def readwrite(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].readwrite({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def rename(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].rename(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def renamenx(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].renamenx(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def replconf(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].replconf(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def replicaof(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].replicaof(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def restore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].restore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def restoreAsking(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].restoreAsking(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def role(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].role({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def rpop(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].rpop(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def rpoplpush(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].rpoplpush(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def rpush(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].rpush(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def rpushx(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].rpushx(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def sadd(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def save(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].save({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def scan(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].scan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def scard(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].scard(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def script(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].script(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def sdiff(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sdiff(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def sdiffstore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sdiffstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def select(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].select(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def set(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].set(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def setbit(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].setbit(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def setex(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].setex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def setnx(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].setnx(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def setrange(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].setrange(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def shutdown(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].shutdown(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def sinter(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sinter(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def sinterstore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sinterstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def sismember(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sismember(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def slaveof(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].slaveof(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def slowlog(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].slowlog(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def smembers(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].smembers(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def smove(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].smove(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def sort(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sort(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def spop(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].spop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def srandmember(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].srandmember(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def srem(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].srem(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def sscan(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sscan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def strlen(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].strlen(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def subscribe(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].subscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def substr(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].substr(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def sunion(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sunion(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def sunionstore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sunionstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def swapdb(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].swapdb(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def sync(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].sync({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def time(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].time({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def touch(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].touch(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def ttl(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].ttl(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def `type`(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].`type`(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def unlink(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].unlink(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def unsubscribe(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].unsubscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def unwatch(handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].unwatch({x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def wait(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].wait(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def watch(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].watch(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def xack(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xack(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def xadd(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def xclaim(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xclaim(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def xdel(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xdel(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def xgroup(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xgroup(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def xinfo(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xinfo(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def xlen(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xlen(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def xpending(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xpending(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def xrange(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def xread(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xread(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def xreadgroup(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xreadgroup(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def xrevrange(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xrevrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def xsetid(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xsetid(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def xtrim(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].xtrim(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zadd(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zcard(arg0: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zcard(arg0.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zcount(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zcount(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zincrby(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zincrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zinterstore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zinterstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zlexcount(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zlexcount(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zpopmax(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zpopmax(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zpopmin(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zpopmin(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zrange(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zrangebylex(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrangebylex(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zrangebyscore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrangebyscore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zrank(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrank(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zrem(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrem(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zremrangebylex(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zremrangebylex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zremrangebyrank(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zremrangebyrank(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zremrangebyscore(arg0: String, arg1: String, arg2: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zremrangebyscore(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zrevrange(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrevrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zrevrangebylex(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrevrangebylex(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zrevrangebyscore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrevrangebyscore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zrevrank(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zrevrank(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zscan(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zscan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zscore(arg0: String, arg1: String, handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zscore(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }


  
  def zunionstore(args: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.Option[Response]]]): RedisAPI = {
    asJava.asInstanceOf[JRedisAPI].zunionstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JResponse] => handler.handle(AsyncResultWrapper[JResponse, scala.Option[Response]](x, a => scala.Option(a).map(Response(_))))})
    this
  }





  def appendFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].append(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def askingFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].asking(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def authFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].auth(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def bgrewriteaofFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bgrewriteaof(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def bgsaveFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bgsave(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def bitcountFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bitcount(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def bitfieldFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bitfield(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def bitopFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bitop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def bitposFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bitpos(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def blpopFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].blpop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def brpopFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].brpop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def brpoplpushFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].brpoplpush(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def bzpopmaxFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bzpopmax(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def bzpopminFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].bzpopmin(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def clientFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].client(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def clusterFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].cluster(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def commandFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].command(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def configFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].config(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def dbsizeFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].dbsize(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def debugFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].debug(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def decrFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].decr(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def decrbyFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].decrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def delFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].del(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def discardFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].discard(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def dumpFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].dump(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def echoFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].echo(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def evalFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].eval(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def evalshaFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].evalsha(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def execFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].exec(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def existsFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].exists(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def expireFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].expire(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def expireatFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].expireat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def flushallFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].flushall(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def flushdbFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].flushdb(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def geoaddFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].geoadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def geodistFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].geodist(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def geohashFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].geohash(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def geoposFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].geopos(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def georadiusFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].georadius(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def georadiusRoFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].georadiusRo(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def georadiusbymemberFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].georadiusbymember(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def georadiusbymemberRoFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].georadiusbymemberRo(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def getFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].get(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def getbitFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].getbit(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def getrangeFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].getrange(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def getsetFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].getset(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hdelFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hdel(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hexistsFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hexists(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hgetFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hget(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hgetallFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hgetall(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hincrbyFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hincrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hincrbyfloatFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hincrbyfloat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hkeysFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hkeys(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hlenFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hlen(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hmgetFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hmget(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hmsetFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hmset(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hostFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].host(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hscanFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hscan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hsetFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hset(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hsetnxFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hsetnx(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hstrlenFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hstrlen(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def hvalsFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].hvals(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def incrFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].incr(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def incrbyFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].incrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def incrbyfloatFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].incrbyfloat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def infoFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].info(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def keysFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].keys(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def lastsaveFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lastsave(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def latencyFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].latency(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def lindexFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lindex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def linsertFuture (arg0: String, arg1: String, arg2: String, arg3: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].linsert(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], arg3.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def llenFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].llen(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def lolwutFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lolwut(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def lpopFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lpop(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def lpushFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lpush(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def lpushxFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lpushx(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def lrangeFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lrange(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def lremFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lrem(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def lsetFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].lset(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def ltrimFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].ltrim(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def memoryFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].memory(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def mgetFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].mget(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def migrateFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].migrate(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def moduleFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].module(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def monitorFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].monitor(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def moveFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].move(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def msetFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].mset(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def msetnxFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].msetnx(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def multiFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].multi(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def objectFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].`object`(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def persistFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].persist(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def pexpireFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pexpire(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def pexpireatFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pexpireat(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def pfaddFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pfadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def pfcountFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pfcount(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def pfdebugFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pfdebug(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def pfmergeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pfmerge(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def pfselftestFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pfselftest(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def pingFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].ping(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def postFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].post(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def psetexFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].psetex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def psubscribeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].psubscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def psyncFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].psync(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def pttlFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pttl(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def publishFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].publish(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def pubsubFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].pubsub(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def punsubscribeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].punsubscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def randomkeyFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].randomkey(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def readonlyFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].readonly(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def readwriteFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].readwrite(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def renameFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].rename(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def renamenxFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].renamenx(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def replconfFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].replconf(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def replicaofFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].replicaof(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def restoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].restore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def restoreAskingFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].restoreAsking(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def roleFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].role(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def rpopFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].rpop(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def rpoplpushFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].rpoplpush(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def rpushFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].rpush(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def rpushxFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].rpushx(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def saddFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def saveFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].save(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def scanFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].scan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def scardFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].scard(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def scriptFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].script(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def sdiffFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sdiff(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def sdiffstoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sdiffstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def selectFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].select(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def setFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].set(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def setbitFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].setbit(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def setexFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].setex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def setnxFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].setnx(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def setrangeFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].setrange(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def shutdownFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].shutdown(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def sinterFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sinter(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def sinterstoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sinterstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def sismemberFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sismember(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def slaveofFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].slaveof(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def slowlogFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].slowlog(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def smembersFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].smembers(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def smoveFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].smove(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def sortFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sort(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def spopFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].spop(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def srandmemberFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].srandmember(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def sremFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].srem(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def sscanFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sscan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def strlenFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].strlen(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def subscribeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].subscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def substrFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].substr(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def sunionFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sunion(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def sunionstoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sunionstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def swapdbFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].swapdb(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def syncFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].sync(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def timeFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].time(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def touchFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].touch(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def ttlFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].ttl(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def typeFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].`type`(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def unlinkFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].unlink(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def unsubscribeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].unsubscribe(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def unwatchFuture (): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].unwatch(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def waitFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].wait(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def watchFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].watch(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def xackFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xack(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def xaddFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def xclaimFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xclaim(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def xdelFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xdel(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def xgroupFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xgroup(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def xinfoFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xinfo(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def xlenFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xlen(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def xpendingFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xpending(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def xrangeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def xreadFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xread(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def xreadgroupFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xreadgroup(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def xrevrangeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xrevrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def xsetidFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xsetid(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def xtrimFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].xtrim(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zaddFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zadd(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zcardFuture (arg0: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zcard(arg0.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zcountFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zcount(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zincrbyFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zincrby(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zinterstoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zinterstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zlexcountFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zlexcount(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zpopmaxFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zpopmax(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zpopminFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zpopmin(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zrangeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zrangebylexFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrangebylex(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zrangebyscoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrangebyscore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zrankFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrank(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zremFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrem(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zremrangebylexFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zremrangebylex(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zremrangebyrankFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zremrangebyrank(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zremrangebyscoreFuture (arg0: String, arg1: String, arg2: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zremrangebyscore(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], arg2.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zrevrangeFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrevrange(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zrevrangebylexFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrevrangebylex(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zrevrangebyscoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrevrangebyscore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zrevrankFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zrevrank(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zscanFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zscan(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zscoreFuture (arg0: String, arg1: String): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zscore(arg0.asInstanceOf[java.lang.String], arg1.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def zunionstoreFuture (args: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.Option[Response]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResponse, scala.Option[Response]](x => scala.Option(x).map(Response(_)))
    asJava.asInstanceOf[JRedisAPI].zunionstore(args.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object RedisAPI {
  def apply(asJava: JRedisAPI) = new RedisAPI(asJava)
  

  def api(client: Redis): RedisAPI = {
    RedisAPI(JRedisAPI.api(client.asJava.asInstanceOf[JRedis]))
  }

}
