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

package io.vertx.scala.core

import io.vertx.scala.core.datagram.DatagramSocket
import io.vertx.core.datagram.{DatagramSocket => JDatagramSocket}
import io.vertx.scala.core.http.HttpServer
import io.vertx.core.http.{HttpServer => JHttpServer}
import io.vertx.scala.core.Context
import io.vertx.core.{Context => JContext}
import io.vertx.scala.core.shareddata.SharedData
import io.vertx.core.shareddata.{SharedData => JSharedData}
import io.vertx.scala.core.WorkerExecutor
import io.vertx.core.{WorkerExecutor => JWorkerExecutor}
import io.vertx.scala.core.TimeoutStream
import io.vertx.core.{TimeoutStream => JTimeoutStream}
import io.vertx.scala.core.eventbus.EventBus
import io.vertx.core.eventbus.{EventBus => JEventBus}
import io.vertx.scala.core.http.HttpClientOptions
import io.vertx.core.http.{HttpClientOptions => JHttpClientOptions}
import io.vertx.scala.core.datagram.DatagramSocketOptions
import io.vertx.core.datagram.{DatagramSocketOptions => JDatagramSocketOptions}
import io.vertx.scala.core.net.NetClient
import io.vertx.core.net.{NetClient => JNetClient}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.VertxOptions
import io.vertx.core.{VertxOptions => JVertxOptions}
import io.vertx.scala.core.Future
import io.vertx.core.{Future => JFuture}
import io.vertx.scala.core.net.NetClientOptions
import io.vertx.core.net.{NetClientOptions => JNetClientOptions}
import io.vertx.scala.core.dns.DnsClient
import io.vertx.core.dns.{DnsClient => JDnsClient}
import io.vertx.scala.core.net.NetServerOptions
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.scala.core.net.NetServer
import io.vertx.core.net.{NetServer => JNetServer}
import io.vertx.scala.core.DeploymentOptions
import io.vertx.core.{DeploymentOptions => JDeploymentOptions}
import io.vertx.scala.core.file.FileSystem
import io.vertx.core.file.{FileSystem => JFileSystem}
import io.vertx.scala.core.http.HttpServerOptions
import io.vertx.core.http.{HttpServerOptions => JHttpServerOptions}
import io.vertx.scala.core.http.HttpClient
import io.vertx.core.http.{HttpClient => JHttpClient}

/**
  * The entry point into the Vert.x Core API.
  * 
  * You use an instance of this class for functionality including:
  * <ul>
  *   <li>Creating TCP clients and servers</li>
  *   <li>Creating HTTP clients and servers</li>
  *   <li>Creating DNS clients</li>
  *   <li>Creating Datagram sockets</li>
  *   <li>Setting and cancelling periodic and one-shot timers</li>
  *   <li>Getting a reference to the event bus API</li>
  *   <li>Getting a reference to the file system API</li>
  *   <li>Getting a reference to the shared data API</li>
  *   <li>Deploying and undeploying verticles</li>
  * </ul>
  * 
  * Most functionality in Vert.x core is fairly low level.
  * 
  * To create an instance of this class you can use the static factory methods: [[io.vertx.scala.core.Vertx#vertx]],
  * [[io.vertx.scala.core.Vertx#vertx]] and [[io.vertx.scala.core.Vertx#clusteredVertxFuture]].
  * 
  * Please see the user manual for more detailed usage information.
  */
class Vertx(private val _asJava: Object) 
    extends Measured(_asJava) {

  override def asJava = _asJava.asInstanceOf[JVertx]
//methods returning a future
  def close(completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.close( )
  }

  def deployVerticle(name: String,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[String]]):Unit = {
    asJava.deployVerticle( )
  }

  def deployVerticle(name: String,options: DeploymentOptions,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[String]]):Unit = {
    asJava.deployVerticle( )
  }

  def undeploy(deploymentID: String,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.undeploy( )
  }

  def executeBlocking(blockingCodeHandler: io.vertx.core.Handler[Future[T]],ordered: Boolean,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]):Unit = {
    asJava.executeBlocking( )
  }

  def executeBlocking(blockingCodeHandler: io.vertx.core.Handler[Future[T]],resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]):Unit = {
    asJava.executeBlocking( )
  }

//cached methods
  def fileSystem():FileSystem = {
    asJava.fileSystem( )
  }

  def eventBus():EventBus = {
    asJava.eventBus( )
  }

  def sharedData():SharedData = {
    asJava.sharedData( )
  }

//fluent methods
  def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):Vertx = {
    asJava.exceptionHandler( )
    this
  }

//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.isMetricsEnabled( )
  }

  def getOrCreateContext():Context = {
    asJava.getOrCreateContext( )
  }

  def createNetServer(options: NetServerOptions):NetServer = {
    asJava.createNetServer( )
  }

  def createNetServer():NetServer = {
    asJava.createNetServer( )
  }

  def createNetClient(options: NetClientOptions):NetClient = {
    asJava.createNetClient( )
  }

  def createNetClient():NetClient = {
    asJava.createNetClient( )
  }

  def createHttpServer(options: HttpServerOptions):HttpServer = {
    asJava.createHttpServer( )
  }

  def createHttpServer():HttpServer = {
    asJava.createHttpServer( )
  }

  def createHttpClient(options: HttpClientOptions):HttpClient = {
    asJava.createHttpClient( )
  }

  def createHttpClient():HttpClient = {
    asJava.createHttpClient( )
  }

  def createDatagramSocket(options: DatagramSocketOptions):DatagramSocket = {
    asJava.createDatagramSocket( )
  }

  def createDatagramSocket():DatagramSocket = {
    asJava.createDatagramSocket( )
  }

  def createDnsClient(port: Int,host: String):DnsClient = {
    asJava.createDnsClient( )
  }

  def setTimer(delay: Long,handler: io.vertx.core.Handler[Long]):Long = {
    asJava.setTimer( )
  }

  def timerStream(delay: Long):TimeoutStream = {
    asJava.timerStream( )
  }

  def setPeriodic(delay: Long,handler: io.vertx.core.Handler[Long]):Long = {
    asJava.setPeriodic( )
  }

  def periodicStream(delay: Long):TimeoutStream = {
    asJava.periodicStream( )
  }

  def cancelTimer(id: Long):Boolean = {
    asJava.cancelTimer( )
  }

  def runOnContext(action: io.vertx.core.Handler[Unit]):Unit = {
    asJava.runOnContext( )
  }

  def close():Unit = {
    asJava.close( )
  }

  def close(completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.close( )
  }

  def deployVerticle(name: String):Unit = {
    asJava.deployVerticle( )
  }

  def deployVerticle(name: String,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[String]]):Unit = {
    asJava.deployVerticle( )
  }

  def deployVerticle(name: String,options: DeploymentOptions):Unit = {
    asJava.deployVerticle( )
  }

  def deployVerticle(name: String,options: DeploymentOptions,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[String]]):Unit = {
    asJava.deployVerticle( )
  }

  def undeploy(deploymentID: String):Unit = {
    asJava.undeploy( )
  }

  def undeploy(deploymentID: String,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.undeploy( )
  }

  def deploymentIDs():Set[String] = {
    asJava.deploymentIDs( )
  }

  def isClustered():Boolean = {
    asJava.isClustered( )
  }

  def executeBlocking(blockingCodeHandler: io.vertx.core.Handler[Future[T]],ordered: Boolean,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]):Unit = {
    asJava.executeBlocking( )
  }

  def executeBlocking(blockingCodeHandler: io.vertx.core.Handler[Future[T]],resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]):Unit = {
    asJava.executeBlocking( )
  }

  def createSharedWorkerExecutor(name: String):WorkerExecutor = {
    asJava.createSharedWorkerExecutor( )
  }

  def createSharedWorkerExecutor(name: String,poolSize: Int):WorkerExecutor = {
    asJava.createSharedWorkerExecutor( )
  }

  def createSharedWorkerExecutor(name: String,poolSize: Int,maxExecuteTime: Long):WorkerExecutor = {
    asJava.createSharedWorkerExecutor( )
  }

}

object Vertx{
//in object!
//static methods
  def vertx():Vertx = {
    JVertx.vertx( )
  }

  def vertx(options: VertxOptions):Vertx = {
    JVertx.vertx( )
  }

  def clusteredVertx(options: VertxOptions,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Vertx]]):Unit = {
    JVertx.clusteredVertx( )
  }

  def currentContext():Context = {
    JVertx.currentContext( )
  }

}
