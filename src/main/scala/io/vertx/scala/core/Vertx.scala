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

package io.vertx.scala.core;

import io.vertx.scala.core.datagram.DatagramSocket
import io.vertx.scala.core.http.HttpServer
import io.vertx.scala.core.shareddata.SharedData
import io.vertx.scala.core.eventbus.EventBus
import scala.util.Try
import io.vertx.core.http.HttpClientOptions
import io.vertx.core.datagram.DatagramSocketOptions
import io.vertx.scala.core.net.NetClient
import io.vertx.core.VertxOptions
import io.vertx.core.net.NetClientOptions
import io.vertx.scala.core.dns.DnsClient
import io.vertx.core.net.NetServerOptions
import io.vertx.scala.core.metrics.Measured
import io.vertx.scala.core.net.NetServer
import io.vertx.core.DeploymentOptions
import io.vertx.scala.core.file.FileSystem
import io.vertx.core.http.HttpServerOptions
import io.vertx.core.Handler
import io.vertx.scala.core.http.HttpClient

class Vertx(private val _asJava: io.vertx.core.Vertx) 
    extends io.vertx.scala.core.metrics.Measured {

  def asJava: java.lang.Object = _asJava

  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  def getOrCreateContext(): io.vertx.scala.core.Context = {
    Context.apply(_asJava.getOrCreateContext())
  }

  def createNetServer(options: io.vertx.core.net.NetServerOptions): io.vertx.scala.core.net.NetServer = {
    NetServer.apply(_asJava.createNetServer(options))
  }

  def createNetServer(): io.vertx.scala.core.net.NetServer = {
    NetServer.apply(_asJava.createNetServer())
  }

  def createNetClient(options: io.vertx.core.net.NetClientOptions): io.vertx.scala.core.net.NetClient = {
    NetClient.apply(_asJava.createNetClient(options))
  }

  def createNetClient(): io.vertx.scala.core.net.NetClient = {
    NetClient.apply(_asJava.createNetClient())
  }

  def createHttpServer(options: io.vertx.core.http.HttpServerOptions): io.vertx.scala.core.http.HttpServer = {
    HttpServer.apply(_asJava.createHttpServer(options))
  }

  def createHttpServer(): io.vertx.scala.core.http.HttpServer = {
    HttpServer.apply(_asJava.createHttpServer())
  }

  def createHttpClient(options: io.vertx.core.http.HttpClientOptions): io.vertx.scala.core.http.HttpClient = {
    HttpClient.apply(_asJava.createHttpClient(options))
  }

  def createHttpClient(): io.vertx.scala.core.http.HttpClient = {
    HttpClient.apply(_asJava.createHttpClient())
  }

  def createDatagramSocket(options: io.vertx.core.datagram.DatagramSocketOptions): io.vertx.scala.core.datagram.DatagramSocket = {
    DatagramSocket.apply(_asJava.createDatagramSocket(options))
  }

  def createDatagramSocket(): io.vertx.scala.core.datagram.DatagramSocket = {
    DatagramSocket.apply(_asJava.createDatagramSocket())
  }

  def fileSystem(): io.vertx.scala.core.file.FileSystem = {
    FileSystem.apply(_asJava.fileSystem())
  }

  def eventBus(): io.vertx.scala.core.eventbus.EventBus = {
    EventBus.apply(_asJava.eventBus())
  }

  def createDnsClient(port: Int, host: String): io.vertx.scala.core.dns.DnsClient = {
    DnsClient.apply(_asJava.createDnsClient(port, host))
  }

  def sharedData(): io.vertx.scala.core.shareddata.SharedData = {
    SharedData.apply(_asJava.sharedData())
  }

  def setTimer(delay: Long)(handler: Long => Unit): Long = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.setTimer(delay, funcToMappedHandler[java.lang.Long, Long](x => x)(handler))
  }

  def timerStream(delay: Long): io.vertx.scala.core.TimeoutStream = {
    TimeoutStream.apply(_asJava.timerStream(delay))
  }

  def setPeriodic(delay: Long)(handler: Long => Unit): Long = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.setPeriodic(delay, funcToMappedHandler[java.lang.Long, Long](x => x)(handler))
  }

  def periodicStream(delay: Long): io.vertx.scala.core.TimeoutStream = {
    TimeoutStream.apply(_asJava.periodicStream(delay))
  }

  def cancelTimer(id: Long): Boolean = {
    _asJava.cancelTimer(id)
  }

  def runOnContext(action: => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.runOnContext(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>action))
  }

  def close(): Unit = {
    _asJava.close()
  }

  def close(completionHandler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.close(funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(completionHandler))
  }

  def deployVerticle(name: String): Unit = {
    _asJava.deployVerticle(name)
  }

  def deployVerticle(name: String)(completionHandler: Try[String] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.deployVerticle(name, funcToAsyncResultHandler[java.lang.String](completionHandler))
  }

  def deployVerticle(name: String, options: io.vertx.core.DeploymentOptions): Unit = {
    _asJava.deployVerticle(name, options)
  }

  def deployVerticle(name: String, options: io.vertx.core.DeploymentOptions)(completionHandler: Try[String] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.deployVerticle(name, options, funcToAsyncResultHandler[java.lang.String](completionHandler))
  }

  def undeploy(deploymentID: String): Unit = {
    _asJava.undeploy(deploymentID)
  }

  def undeploy(deploymentID: String)(completionHandler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.undeploy(deploymentID, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(completionHandler))
  }

  def deploymentIDs(): Set[String] = {
    import scala.collection.JavaConverters._
    _asJava.deploymentIDs().asScala.map(x => x:String).toSet
  }

  def isClustered(): Boolean = {
    _asJava.isClustered()
  }

  def executeBlocking[T](blockingCodeHandler: io.vertx.scala.core.Future[T] => Unit)(resultHandler: Try[T] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.executeBlocking(funcToMappedHandler(Future.apply[T])(blockingCodeHandler), funcToAsyncResultHandler(resultHandler))
  }

}

object Vertx {

  def apply(_asJava: io.vertx.core.Vertx): io.vertx.scala.core.Vertx =
    new io.vertx.scala.core.Vertx(_asJava)
  
    def vertx(): io.vertx.scala.core.Vertx = {
      Vertx.apply(io.vertx.core.Vertx.vertx())
    }
  
    def vertx(options: io.vertx.core.VertxOptions): io.vertx.scala.core.Vertx = {
      Vertx.apply(io.vertx.core.Vertx.vertx(options))
    }
  
    def clusteredVertx(options: io.vertx.core.VertxOptions)(resultHandler: Try[io.vertx.scala.core.Vertx] => Unit): Unit = {
      import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    io.vertx.core.Vertx.clusteredVertx(options, funcToMappedAsyncResultHandler(Vertx.apply)(resultHandler))
    }
  
    def currentContext(): io.vertx.scala.core.Context = {
      Context.apply(io.vertx.core.Vertx.currentContext())
    }
}
