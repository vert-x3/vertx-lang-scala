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

import io.vertx.sqlclient
import io.vertx.db2client.{DB2ConnectOptions => JDB2ConnectOptions}
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.net
import java.util.concurrent.TimeUnit
import io.vertx.sqlclient.{SqlConnectOptions => JSqlConnectOptions}
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.core.tracing.TracingPolicy
import io.vertx.core.net.{JksOptions => JJksOptions}
package object db2client{


  type DB2ConnectOptions = io.vertx.db2client.DB2ConnectOptions
  object DB2ConnectOptions {
    def apply() = new DB2ConnectOptions()
    def apply(json: JsonObject) = new DB2ConnectOptions(json)
  }



}
