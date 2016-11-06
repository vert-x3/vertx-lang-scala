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

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.redis.{RedisOptions => JRedisOptions}

/**
  * This object controls the connection setting to the Redis Server. There is no need to specify most of the settings
  * since it has built the following sensible defaults:
  *
  * * `encoding`: `UTF-8`
  * * `host`: `localhost`
  * * `port`: 6379
  * * `tcpKeepAlive`: true
  * * `tcpNoDelay`: true
  * * `binary`: false
  *
  * However there are two extra properties that have no defaults since they are optional:
  *
  * * `auth`
  * * `select`
  *
  * The usage of this two extra properties is to setup required authentication and optionally the selection of the active
  * database at connection time. If you define this extra properties on every connection to Redis server this client
  * will perform the authentication handshake and database selection, however if you don't do this and call [[io.vertx.scala.redis.RedisClient]]
  * yourself in case of connection failure the client will not be able to perform the correct authentication handshake.
  */

class RedisOptions(val asJava: JRedisOptions) {

  /**
    * Set the eventbus address prefix for `PUB/SUB`.
    */
  def setAddress(value: String) = {
    asJava.setAddress(value)
    this
  }
  def getAddress = {
    asJava.getAddress()
  }

  /**
    * Set the password for authentication at connection time.
    */
  def setAuth(value: String) = {
    asJava.setAuth(value)
    this
  }
  def getAuth = {
    asJava.getAuth()
  }

  /**
    * Set the user defined character encoding, e.g.: `iso-8859-1`.
    */
  def setBinary(value: Boolean) = {
    asJava.setBinary(value)
    this
  }
  def isBinary = {
    asJava.isBinary()
  }

  /**
    * Set the user defined character encoding, e.g.: `iso-8859-1`.
    */
  def setEncoding(value: String) = {
    asJava.setEncoding(value)
    this
  }
  def getEncoding = {
    asJava.getEncoding()
  }

  /**
    * Set the host name where the Redis server is listening.
    */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }
  def getHost = {
    asJava.getHost()
  }

  /**
    * Set the tcp port where the Redis server is listening.
    */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  def getPort = {
    asJava.getPort()
  }

  /**
    * Set the database to select at connection time.
    */
  def setSelect(value: Int) = {
    asJava.setSelect(value)
    this
  }
  def getSelect = {
    asJava.getSelect()
  }

  /**
    * Set the TCP KeepAlive option
    */
  def setTcpKeepAlive(value: Boolean) = {
    asJava.setTcpKeepAlive(value)
    this
  }
  def isTcpKeepAlive = {
    asJava.isTcpKeepAlive()
  }

  /**
    * Set the TCP NoDelay at the socket level.
    */
  def setTcpNoDelay(value: Boolean) = {
    asJava.setTcpNoDelay(value)
    this
  }
  def isTcpNoDelay = {
    asJava.isTcpNoDelay()
  }
}

object RedisOptions {
  
  def apply() = {
    new RedisOptions(new JRedisOptions(emptyObj()))
  }
  
  def apply(t: JRedisOptions) = {
    if(t != null)
      new RedisOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):RedisOptions = {
    if(json != null)
      new RedisOptions(new JRedisOptions(json))
    else
      null
  }
}
