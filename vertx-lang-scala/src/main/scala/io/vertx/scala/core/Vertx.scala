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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.net.{NetServer => JNetServer}
import io.vertx.scala.core.http.HttpClient
import io.vertx.scala.core.net.NetClient
import io.vertx.core.{DeploymentOptions => JDeploymentOptions}
import io.vertx.scala.core.eventbus.EventBus
import io.vertx.scala.core.dns.DnsClient
import io.vertx.scala.core.datagram.DatagramSocket
import io.vertx.core.http.{HttpServerOptions => JHttpServerOptions}
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
import io.vertx.scala.core.http.HttpServerOptions
import io.vertx.core.datagram.{DatagramSocket => JDatagramSocket}
import io.vertx.core.dns.{DnsClient => JDnsClient}
import io.vertx.scala.core.http.HttpServer
import io.vertx.core.net.{NetClientOptions => JNetClientOptions}
import io.vertx.scala.core.net.NetClientOptions
import io.vertx.core.AsyncResult
import io.vertx.scala.core.net.NetServer
import io.vertx.core.{VertxOptions => JVertxOptions}
import io.vertx.core.eventbus.{EventBus => JEventBus}
import io.vertx.core.http.{HttpServer => JHttpServer}
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.file.{FileSystem => JFileSystem}
import io.vertx.core.net.{NetClient => JNetClient}
import io.vertx.core.http.{HttpClientOptions => JHttpClientOptions}
import io.vertx.scala.core.datagram.DatagramSocketOptions
import io.vertx.core.{WorkerExecutor => JWorkerExecutor}
import io.vertx.scala.core.metrics.Measured
import scala.collection.JavaConverters._
import io.vertx.core.shareddata.{SharedData => JSharedData}
import io.vertx.scala.core.shareddata.SharedData
import io.vertx.core.{Vertx => JVertx}
import io.vertx.core.datagram.{DatagramSocketOptions => JDatagramSocketOptions}
import io.vertx.core.http.{HttpClient => JHttpClient}
import io.vertx.core.{Context => JContext}
import io.vertx.core.{Future => JFuture}
import io.vertx.scala.core.file.FileSystem
import io.vertx.scala.core.http.HttpClientOptions
import io.vertx.scala.core.net.NetServerOptions
import io.vertx.core.Handler
import io.vertx.core.{TimeoutStream => JTimeoutStream}

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

  private var cached_0:FileSystem = _
    private var cached_1:EventBus = _
    private var cached_2:SharedData = _
  
//methods returning a future
  def close(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JVertx].close(x => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a)))
  }

  def deployVerticle(name: String,completionHandler: Handler[AsyncResult[String]]):Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(name,x => completionHandler.handle(AsyncResultWrapper[String,String](x, a => a)))
  }

  def deployVerticle(name: String,options: DeploymentOptions,completionHandler: Handler[AsyncResult[String]]):Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(name,options.asJava.asInstanceOf[JDeploymentOptions],x => completionHandler.handle(AsyncResultWrapper[String,String](x, a => a)))
  }

  def undeploy(deploymentID: String,completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JVertx].undeploy(deploymentID,x => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a)))
  }

  def executeBlocking[T](blockingCodeHandler: Handler[Future[T]],ordered: Boolean,resultHandler: Handler[AsyncResult[T]]):Unit = {
    asJava.asInstanceOf[JVertx].executeBlocking(x => blockingCodeHandler.handle(x.asJava.asInstanceOf[JFuture[T]]),ordered,x => resultHandler.handle(AsyncResultWrapper[T,T](x, a => a)))
  }

  def executeBlocking[T](blockingCodeHandler: Handler[Future[T]],resultHandler: Handler[AsyncResult[T]]):Unit = {
    asJava.asInstanceOf[JVertx].executeBlocking(x => blockingCodeHandler.handle(x.asJava.asInstanceOf[JFuture[T]]),x => resultHandler.handle(AsyncResultWrapper[T,T](x, a => a)))
  }

//cached methods
  def fileSystem():FileSystem = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JVertx].fileSystem()
      cached_0 = FileSystem(tmp)
    }
    return cached_0
  }

  def eventBus():EventBus = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JVertx].eventBus()
      cached_1 = EventBus(tmp)
    }
    return cached_1
  }

  def sharedData():SharedData = {
    if(cached_2 == null) {
      var tmp = asJava.asInstanceOf[JVertx].sharedData()
      cached_2 = SharedData(tmp)
    }
    return cached_2
  }

//fluent methods
  def exceptionHandler(handler: Handler[Throwable]):Vertx = {
    asJava.asInstanceOf[JVertx].exceptionHandler(x => handler.handle(x))
    this
  }

//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JVertx].isMetricsEnabled()
  }

  def getOrCreateContext():Context = {
    Context(asJava.asInstanceOf[JVertx].getOrCreateContext())
  }

  def createNetServer(options: NetServerOptions):NetServer = {
    NetServer(asJava.asInstanceOf[JVertx].createNetServer(options.asJava.asInstanceOf[JNetServerOptions]))
  }

  def createNetServer():NetServer = {
    NetServer(asJava.asInstanceOf[JVertx].createNetServer())
  }

  def createNetClient(options: NetClientOptions):NetClient = {
    NetClient(asJava.asInstanceOf[JVertx].createNetClient(options.asJava.asInstanceOf[JNetClientOptions]))
  }

  def createNetClient():NetClient = {
    NetClient(asJava.asInstanceOf[JVertx].createNetClient())
  }

  def createHttpServer(options: HttpServerOptions):HttpServer = {
    HttpServer(asJava.asInstanceOf[JVertx].createHttpServer(options.asJava.asInstanceOf[JHttpServerOptions]))
  }

  def createHttpServer():HttpServer = {
    HttpServer(asJava.asInstanceOf[JVertx].createHttpServer())
  }

  def createHttpClient(options: HttpClientOptions):HttpClient = {
    HttpClient(asJava.asInstanceOf[JVertx].createHttpClient(options.asJava.asInstanceOf[JHttpClientOptions]))
  }

  def createHttpClient():HttpClient = {
    HttpClient(asJava.asInstanceOf[JVertx].createHttpClient())
  }

  def createDatagramSocket(options: DatagramSocketOptions):DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JVertx].createDatagramSocket(options.asJava.asInstanceOf[JDatagramSocketOptions]))
  }

  def createDatagramSocket():DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JVertx].createDatagramSocket())
  }

  def createDnsClient(port: Int,host: String):DnsClient = {
    DnsClient(asJava.asInstanceOf[JVertx].createDnsClient(port,host))
  }

  def setTimer(delay: Long,handler: Handler[Long]):Long = {
    asJava.asInstanceOf[JVertx].setTimer(delay,x => handler.handle(x))
  }

  def timerStream(delay: Long):TimeoutStream = {
    TimeoutStream(asJava.asInstanceOf[JVertx].timerStream(delay))
  }

  def setPeriodic(delay: Long,handler: Handler[Long]):Long = {
    asJava.asInstanceOf[JVertx].setPeriodic(delay,x => handler.handle(x))
  }

  def periodicStream(delay: Long):TimeoutStream = {
    TimeoutStream(asJava.asInstanceOf[JVertx].periodicStream(delay))
  }

  def cancelTimer(id: Long):Boolean = {
    asJava.asInstanceOf[JVertx].cancelTimer(id)
  }

  def runOnContext(action: Handler[Unit]):Unit = {
    asJava.asInstanceOf[JVertx].runOnContext(x => action.handle(x))
  }

  def close():Unit = {
    asJava.asInstanceOf[JVertx].close()
  }

  def close(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JVertx].close(x => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a)))
  }

  def deployVerticle(name: String):Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(name)
  }

  def deployVerticle(name: String,completionHandler: Handler[AsyncResult[String]]):Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(name,x => completionHandler.handle(AsyncResultWrapper[String,String](x, a => a)))
  }

  def deployVerticle(name: String,options: DeploymentOptions):Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(name,options.asJava.asInstanceOf[JDeploymentOptions])
  }

  def deployVerticle(name: String,options: DeploymentOptions,completionHandler: Handler[AsyncResult[String]]):Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(name,options.asJava.asInstanceOf[JDeploymentOptions],x => completionHandler.handle(AsyncResultWrapper[String,String](x, a => a)))
  }

  def undeploy(deploymentID: String):Unit = {
    asJava.asInstanceOf[JVertx].undeploy(deploymentID)
  }

  def undeploy(deploymentID: String,completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JVertx].undeploy(deploymentID,x => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a)))
  }

  def deploymentIDs():Set[String] = {
    asJava.asInstanceOf[JVertx].deploymentIDs().map(x => x)
  }

  def isClustered():Boolean = {
    asJava.asInstanceOf[JVertx].isClustered()
  }

  def executeBlocking[T](blockingCodeHandler: Handler[Future[T]],ordered: Boolean,resultHandler: Handler[AsyncResult[T]]):Unit = {
    asJava.asInstanceOf[JVertx].executeBlocking(x => blockingCodeHandler.handle(x.asJava.asInstanceOf[JFuture[T]]),ordered,x => resultHandler.handle(AsyncResultWrapper[T,T](x, a => a)))
  }

  def executeBlocking[T](blockingCodeHandler: Handler[Future[T]],resultHandler: Handler[AsyncResult[T]]):Unit = {
    asJava.asInstanceOf[JVertx].executeBlocking(x => blockingCodeHandler.handle(x.asJava.asInstanceOf[JFuture[T]]),x => resultHandler.handle(AsyncResultWrapper[T,T](x, a => a)))
  }

  def createSharedWorkerExecutor(name: String):WorkerExecutor = {
    WorkerExecutor(asJava.asInstanceOf[JVertx].createSharedWorkerExecutor(name))
  }

  def createSharedWorkerExecutor(name: String,poolSize: Int):WorkerExecutor = {
    WorkerExecutor(asJava.asInstanceOf[JVertx].createSharedWorkerExecutor(name,poolSize))
  }

  def createSharedWorkerExecutor(name: String,poolSize: Int,maxExecuteTime: Long):WorkerExecutor = {
    WorkerExecutor(asJava.asInstanceOf[JVertx].createSharedWorkerExecutor(name,poolSize,maxExecuteTime))
  }

}

object Vertx{
  def apply(asJava: JVertx) = new Vertx(asJava)
//static methods
  def vertx():Vertx = {
    Vertx(JVertx.vertx())
  }

  def vertx(options: VertxOptions):Vertx = {
    Vertx(JVertx.vertx(options.asJava.asInstanceOf[JVertxOptions]))
  }

  def clusteredVertx(options: VertxOptions,resultHandler: Handler[AsyncResult[Vertx]]):Unit = {
    JVertx.clusteredVertx(options.asJava.asInstanceOf[JVertxOptions],x => resultHandler.handle(AsyncResultWrapper[JVertx,Vertx](x, a => Vertx(a))))
  }

  def currentContext():Context = {
    Context(JVertx.currentContext())
  }

}
