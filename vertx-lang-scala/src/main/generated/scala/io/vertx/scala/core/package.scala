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

import io.vertx.core.http.{HttpMethod => JHttpMethod}
package object core{


  import io.vertx.core.json.{JsonObject => JJsonObject}
  import io.vertx.core.json.{JsonArray => JJsonArray}

  type JsonObject = JJsonObject
  type JsonArray = JJsonArray

  object JsonObject {
    def apply(): JsonObject = new JJsonObject()
    def apply(json: String): JsonObject = new JJsonObject(json)
    def apply(fields: (String, Any)*): JsonObject = {
      val o = new JsonObject()
      fields.foreach {
        case (key, l: Array[_]) => o.put(key, listToJsArr(l))
        case (key, l: Seq[_]) => o.put(key, listToJsArr(l))
        case (key, value) => o.put(key, value)
      }
      o
    }
  }

  object JsonArray {
    def apply(): JsonArray = new JJsonArray()
    def apply(json: String): JsonArray = new JJsonArray(json)
    def apply(fields: Any*): JsonArray = {
      val a = new JsonArray()
      fields.foreach {
        case array: Array[_] => a.add(listToJsArr(array))
        case seq: Seq[_] => a.add(listToJsArr(seq))
        case f => a.add(f)
      }
      a
    }
  }

  private def listToJsArr(a: Seq[_]) = JsonArray(a: _*)


  type AddressResolverOptions = io.vertx.core.dns.AddressResolverOptions
  object AddressResolverOptions {
    def apply() = new AddressResolverOptions()
    def apply(json: JsonObject) = new AddressResolverOptions(json)
  }



  type Argument = io.vertx.core.cli.Argument
  object Argument {
    def apply() = new Argument()
    def apply(json: JsonObject) = new Argument(json)
  }






  type CopyOptions = io.vertx.core.file.CopyOptions
  object CopyOptions {
    def apply() = new CopyOptions()
    def apply(json: JsonObject) = new CopyOptions(json)
  }



  type DatagramSocketOptions = io.vertx.core.datagram.DatagramSocketOptions
  object DatagramSocketOptions {
    def apply() = new DatagramSocketOptions()
    def apply(json: JsonObject) = new DatagramSocketOptions(json)
  }



  type DeliveryOptions = io.vertx.core.eventbus.DeliveryOptions
  object DeliveryOptions {
    def apply() = new DeliveryOptions()
    def apply(json: JsonObject) = new DeliveryOptions(json)
  }



  type DeploymentOptions = io.vertx.core.DeploymentOptions
  object DeploymentOptions {
    def apply() = new DeploymentOptions()
    def apply(json: JsonObject) = new DeploymentOptions(json)
  }



  type DnsClientOptions = io.vertx.core.dns.DnsClientOptions
  object DnsClientOptions {
    def apply() = new DnsClientOptions()
    def apply(json: JsonObject) = new DnsClientOptions(json)
  }



  type EventBusOptions = io.vertx.core.eventbus.EventBusOptions
  object EventBusOptions {
    def apply() = new EventBusOptions()
    def apply(json: JsonObject) = new EventBusOptions(json)
  }



  type FileSystemOptions = io.vertx.core.file.FileSystemOptions
  object FileSystemOptions {
    def apply() = new FileSystemOptions()
    def apply(json: JsonObject) = new FileSystemOptions(json)
  }



  type GoAway = io.vertx.core.http.GoAway
  object GoAway {
    def apply() = new GoAway()
    def apply(json: JsonObject) = new GoAway(json)
  }



  type Http2Settings = io.vertx.core.http.Http2Settings
  object Http2Settings {
    def apply() = new Http2Settings()
    def apply(json: JsonObject) = new Http2Settings(json)
  }



  type HttpClientOptions = io.vertx.core.http.HttpClientOptions
  object HttpClientOptions {
    def apply() = new HttpClientOptions()
    def apply(json: JsonObject) = new HttpClientOptions(json)
  }



  type HttpMethod = io.vertx.core.http.HttpMethod
  object HttpMethod {
    def apply(str: String) = new HttpMethod(str)
  }



  type HttpServerOptions = io.vertx.core.http.HttpServerOptions
  object HttpServerOptions {
    def apply() = new HttpServerOptions()
    def apply(json: JsonObject) = new HttpServerOptions(json)
  }



  type JdkSSLEngineOptions = io.vertx.core.net.JdkSSLEngineOptions
  object JdkSSLEngineOptions {
    def apply() = new JdkSSLEngineOptions()
    def apply(json: JsonObject) = new JdkSSLEngineOptions(json)
  }



  type JksOptions = io.vertx.core.net.JksOptions
  object JksOptions {
    def apply() = new JksOptions()
    def apply(json: JsonObject) = new JksOptions(json)
  }



  type KeyStoreOptions = io.vertx.core.net.KeyStoreOptions
  object KeyStoreOptions {
    def apply() = new KeyStoreOptions()
    def apply(json: JsonObject) = new KeyStoreOptions(json)
  }



  type MetricsOptions = io.vertx.core.metrics.MetricsOptions
  object MetricsOptions {
    def apply() = new MetricsOptions()
    def apply(json: JsonObject) = new MetricsOptions(json)
  }



  type NetClientOptions = io.vertx.core.net.NetClientOptions
  object NetClientOptions {
    def apply() = new NetClientOptions()
    def apply(json: JsonObject) = new NetClientOptions(json)
  }



  type NetServerOptions = io.vertx.core.net.NetServerOptions
  object NetServerOptions {
    def apply() = new NetServerOptions()
    def apply(json: JsonObject) = new NetServerOptions(json)
  }






  type OpenOptions = io.vertx.core.file.OpenOptions
  object OpenOptions {
    def apply() = new OpenOptions()
    def apply(json: JsonObject) = new OpenOptions(json)
  }



  type OpenSSLEngineOptions = io.vertx.core.net.OpenSSLEngineOptions
  object OpenSSLEngineOptions {
    def apply() = new OpenSSLEngineOptions()
    def apply(json: JsonObject) = new OpenSSLEngineOptions(json)
  }



  type Option = io.vertx.core.cli.Option
  object Option {
    def apply() = new Option()
    def apply(json: JsonObject) = new Option(json)
  }



  type PemKeyCertOptions = io.vertx.core.net.PemKeyCertOptions
  object PemKeyCertOptions {
    def apply() = new PemKeyCertOptions()
    def apply(json: JsonObject) = new PemKeyCertOptions(json)
  }



  type PemTrustOptions = io.vertx.core.net.PemTrustOptions
  object PemTrustOptions {
    def apply() = new PemTrustOptions()
    def apply(json: JsonObject) = new PemTrustOptions(json)
  }



  type PfxOptions = io.vertx.core.net.PfxOptions
  object PfxOptions {
    def apply() = new PfxOptions()
    def apply(json: JsonObject) = new PfxOptions(json)
  }



  type ProxyOptions = io.vertx.core.net.ProxyOptions
  object ProxyOptions {
    def apply() = new ProxyOptions()
    def apply(json: JsonObject) = new ProxyOptions(json)
  }



  type RequestOptions = io.vertx.core.http.RequestOptions
  object RequestOptions {
    def apply() = new RequestOptions()
    def apply(json: JsonObject) = new RequestOptions(json)
  }



  type StreamPriority = io.vertx.core.http.StreamPriority
  object StreamPriority {
    def apply() = new StreamPriority()
    def apply(json: JsonObject) = new StreamPriority(json)
  }






  type TracingOptions = io.vertx.core.tracing.TracingOptions
  object TracingOptions {
    def apply() = new TracingOptions()
    def apply(json: JsonObject) = new TracingOptions(json)
  }



  type VertxOptions = io.vertx.core.VertxOptions
  object VertxOptions {
    def apply() = new VertxOptions()
    def apply(json: JsonObject) = new VertxOptions(json)
  }



  type WebSocketConnectOptions = io.vertx.core.http.WebSocketConnectOptions
  object WebSocketConnectOptions {
    def apply() = new WebSocketConnectOptions()
    def apply(json: JsonObject) = new WebSocketConnectOptions(json)
  }



}
