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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.{Vertx => JVertx}
import io.vertx.core.datagram.{DatagramSocket => JDatagramSocket}
import io.vertx.scala.core.datagram.DatagramSocket
import io.vertx.core.http.{HttpServer => JHttpServer}
import io.vertx.scala.core.http.HttpServer
import io.vertx.core.{Context => JContext}
import io.vertx.core.shareddata.{SharedData => JSharedData}
import io.vertx.scala.core.shareddata.SharedData
import io.vertx.core.{WorkerExecutor => JWorkerExecutor}
import io.vertx.core.{TimeoutStream => JTimeoutStream}
import io.vertx.core.eventbus.{EventBus => JEventBus}
import io.vertx.scala.core.eventbus.EventBus
import io.vertx.core.http.{HttpClientOptions => JHttpClientOptions}
import io.vertx.scala.core.http.HttpClientOptions
import io.vertx.core.datagram.{DatagramSocketOptions => JDatagramSocketOptions}
import io.vertx.scala.core.datagram.DatagramSocketOptions
import io.vertx.core.net.{NetClient => JNetClient}
import io.vertx.scala.core.net.NetClient
import io.vertx.core.{VertxOptions => JVertxOptions}
import io.vertx.scala.core.VertxOptions
import io.vertx.core.{Future => JFuture}
import io.vertx.core.net.{NetClientOptions => JNetClientOptions}
import io.vertx.scala.core.net.NetClientOptions
import io.vertx.core.dns.{DnsClient => JDnsClient}
import io.vertx.scala.core.dns.DnsClient
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
import io.vertx.scala.core.net.NetServerOptions
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.net.{NetServer => JNetServer}
import io.vertx.scala.core.net.NetServer
import io.vertx.core.{DeploymentOptions => JDeploymentOptions}
import io.vertx.scala.core.DeploymentOptions
import io.vertx.core.file.{FileSystem => JFileSystem}
import io.vertx.scala.core.file.FileSystem
import io.vertx.core.http.{HttpServerOptions => JHttpServerOptions}
import io.vertx.scala.core.http.HttpServerOptions
import io.vertx.core.http.{HttpClient => JHttpClient}
import io.vertx.scala.core.http.HttpClient

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
  * [[io.vertx.scala.core.Vertx#vertx]] and [[io.vertx.scala.core.Vertx#clusteredVertx]].
  * 
  * Please see the user manual for more detailed usage information.
  */
class Vertx(private val _asJava: JVertx) 
    extends Measured {

  def asJava: JVertx = _asJava

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  /**
    * Gets the current context, or creates one if there isn't one
    * @return The current context (created if didn't exist)
    */
  def getOrCreateContext(): Context = {
    Context.apply(_asJava.getOrCreateContext())
  }

  /**
    * Create a TCP/SSL server using the specified options
    * @param options the options to usesee <a href="../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a>
    * @return the server
    */
  def createNetServer(options: NetServerOptions): NetServer = {
    NetServer.apply(_asJava.createNetServer(options.asJava))
  }

  /**
    * Create a TCP/SSL server using default options
    * @return the server
    */
  def createNetServer(): NetServer = {
    NetServer.apply(_asJava.createNetServer())
  }

  /**
    * Create a TCP/SSL client using the specified options
    * @param options the options to usesee <a href="../../../../../../cheatsheet/NetClientOptions.html">NetClientOptions</a>
    * @return the client
    */
  def createNetClient(options: NetClientOptions): NetClient = {
    NetClient.apply(_asJava.createNetClient(options.asJava))
  }

  /**
    * Create a TCP/SSL client using default options
    * @return the client
    */
  def createNetClient(): NetClient = {
    NetClient.apply(_asJava.createNetClient())
  }

  /**
    * Create an HTTP/HTTPS server using the specified options
    * @param options the options to usesee <a href="../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a>
    * @return the server
    */
  def createHttpServer(options: HttpServerOptions): HttpServer = {
    HttpServer.apply(_asJava.createHttpServer(options.asJava))
  }

  /**
    * Create an HTTP/HTTPS server using default options
    * @return the server
    */
  def createHttpServer(): HttpServer = {
    HttpServer.apply(_asJava.createHttpServer())
  }

  /**
    * Create a HTTP/HTTPS client using the specified options
    * @param options the options to usesee <a href="../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
    * @return the client
    */
  def createHttpClient(options: HttpClientOptions): HttpClient = {
    HttpClient.apply(_asJava.createHttpClient(options.asJava))
  }

  /**
    * Create a HTTP/HTTPS client using default options
    * @return the client
    */
  def createHttpClient(): HttpClient = {
    HttpClient.apply(_asJava.createHttpClient())
  }

  /**
    * Create a datagram socket using the specified options
    * @param options the options to usesee <a href="../../../../../../cheatsheet/DatagramSocketOptions.html">DatagramSocketOptions</a>
    * @return the socket
    */
  def createDatagramSocket(options: DatagramSocketOptions): DatagramSocket = {
    DatagramSocket.apply(_asJava.createDatagramSocket(options.asJava))
  }

  /**
    * Create a datagram socket using default options
    * @return the socket
    */
  def createDatagramSocket(): DatagramSocket = {
    DatagramSocket.apply(_asJava.createDatagramSocket())
  }

  /**
    * Get the filesystem object. There is a single instance of FileSystem per Vertx instance.
    * @return the filesystem object
    */
  def fileSystem(): FileSystem = {
    if (cached_0 == null) {
      cached_0=    FileSystem.apply(_asJava.fileSystem())
    }
    cached_0
  }

  /**
    * Get the event bus object. There is a single instance of EventBus per Vertx instance.
    * @return the event bus object
    */
  def eventBus(): EventBus = {
    if (cached_1 == null) {
      cached_1=    EventBus.apply(_asJava.eventBus())
    }
    cached_1
  }

  /**
    * Create a DNS client to connect to a DNS server at the specified host and port
    * @param port the port
    * @param host the host
    * @return the DNS client
    */
  def createDnsClient(port: Int, host: String): DnsClient = {
    DnsClient.apply(_asJava.createDnsClient(port, host))
  }

  /**
    * Get the shared data object. There is a single instance of SharedData per Vertx instance.
    * @return the shared data object
    */
  def sharedData(): SharedData = {
    if (cached_2 == null) {
      cached_2=    SharedData.apply(_asJava.sharedData())
    }
    cached_2
  }

  /**
    * Set a one-shot timer to fire after `delay` milliseconds, at which point `handler` will be called with
    * the id of the timer.
    * @param delay the delay in milliseconds, after which the timer will fire
    * @param handler the handler that will be called with the timer ID when the timer fires
    * @return the unique ID of the timer
    */
  def setTimer(delay: Long, handler: Long => Unit): Long = {
    _asJava.setTimer(delay, funcToMappedHandler[java.lang.Long, Long](x => x)(handler))
  }

  /**
    * Returns a one-shot timer as a read stream. The timer will be fired after `delay` milliseconds after
    * the  has been called.
    * @param delay the delay in milliseconds, after which the timer will fire
    * @return the timer stream
    */
  def timerStream(delay: Long): TimeoutStream = {
    TimeoutStream.apply(_asJava.timerStream(delay))
  }

  /**
    * Set a periodic timer to fire every `delay` milliseconds, at which point `handler` will be called with
    * the id of the timer.
    * @param delay the delay in milliseconds, after which the timer will fire
    * @param handler the handler that will be called with the timer ID when the timer fires
    * @return the unique ID of the timer
    */
  def setPeriodic(delay: Long, handler: Long => Unit): Long = {
    _asJava.setPeriodic(delay, funcToMappedHandler[java.lang.Long, Long](x => x)(handler))
  }

  /**
    * Returns a periodic timer as a read stream. The timer will be fired every `delay` milliseconds after
    * the  has been called.
    * @param delay the delay in milliseconds, after which the timer will fire
    * @return the periodic stream
    */
  def periodicStream(delay: Long): TimeoutStream = {
    TimeoutStream.apply(_asJava.periodicStream(delay))
  }

  /**
    * Cancels the timer with the specified `id`.
    * @param id The id of the timer to cancel
    * @return true if the timer was successfully cancelled, or false if the timer does not exist.
    */
  def cancelTimer(id: Long): Boolean = {
    _asJava.cancelTimer(id)
  }

  /**
    * Puts the handler on the event queue for the current context so it will be run asynchronously ASAP after all
    * preceeding events have been handled.
    * @param action - a handler representing the action to execute
    */
  def runOnContext(action: () => Unit): Unit = {
    _asJava.runOnContext(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => action()))
  }

  /**
    * Stop the the Vertx instance and release any resources held by it.
    * 
    * The instance cannot be used after it has been closed.
    * 
    * The actual close is asynchronous and may not complete until after the call has returned.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Like [[io.vertx.scala.core.Vertx#close]] but the completionHandler will be called when the close is complete
    * @return The future will be notified when the close is complete.
    */
  def closeFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Deploy a verticle instance given a name.
    * 
    * Given the name, Vert.x selects a  instance to use to instantiate the verticle.
    * 
    * For the rules on how factories are selected please consult the user manual.
    * @param name the name.
    */
  def deployVerticle(name: String): Unit = {
    _asJava.deployVerticle(name)
  }

  /**
    * Like [[io.vertx.scala.core.Vertx#deployVerticle]] but the completionHandler will be notified when the deployment is complete.
    * 
    * If the deployment is successful the result will contain a String representing the unique deployment ID of the
    * deployment.
    * 
    * This deployment ID can subsequently be used to undeploy the verticle.
    * @param name The identifier
    * @return a future which will be notified when the deployment is complete
    */
  def deployVerticleFuture(name: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.deployVerticle(name, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Like [[io.vertx.scala.core.Vertx#deployVerticle]] but <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a> are provided to configure the
    * deployment.
    * @param name the name
    * @param options the deployment options.see <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a>
    */
  def deployVerticle(name: String, options: DeploymentOptions): Unit = {
    _asJava.deployVerticle(name, options.asJava)
  }

  /**
    * Like [[io.vertx.scala.core.Vertx#deployVerticle]] but <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a> are provided to configure the
    * deployment.
    * @param name the name
    * @param options the deployment options.see <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a>
    * @return a future which will be notified when the deployment is complete
    */
  def deployVerticleFuture(name: String, options: DeploymentOptions): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.deployVerticle(name, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Undeploy a verticle deployment.
    * 
    * The actual undeployment happens asynchronously and may not complete until after the method has returned.
    * @param deploymentID the deployment ID
    */
  def undeploy(deploymentID: String): Unit = {
    _asJava.undeploy(deploymentID)
  }

  /**
    * Like [[io.vertx.scala.core.Vertx #undeploy(String)]] but the completionHandler will be notified when the undeployment is complete.
    * @param deploymentID the deployment ID
    * @return a future which will be notified when the undeployment is complete
    */
  def undeployFuture(deploymentID: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.undeploy(deploymentID, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return a Set of deployment IDs for the currently deployed deploymentIDs.
    * @return Set of deployment IDs
    */
  def deploymentIDs(): Set[String] = {
    _asJava.deploymentIDs().asScala.map(x => x:String).toSet
  }

  /**
    * Is this Vert.x instance clustered?
    * @return true if clustered
    */
  def isClustered(): Boolean = {
    _asJava.isClustered()
  }

  /**
    * Safely execute some blocking code.
    * 
    * Executes the blocking code in the handler `blockingCodeHandler` using a thread from the worker pool.
    * 
    * When the code is complete the handler `resultHandler` will be called with the result on the original context
    * (e.g. on the original event loop of the caller).
    * 
    * A `Future` instance is passed into `blockingCodeHandler`. When the blocking code successfully completes,
    * the handler should call the [[io.vertx.scala.core.Future#complete]] or [[io.vertx.scala.core.Future#complete]] method, or the [[io.vertx.scala.core.Future#fail]]
    * method if it failed.
    * 
    * In the `blockingCodeHandler` the current context remains the original context and therefore any task
    * scheduled in the `blockingCodeHandler` will be executed on the this context and not on the worker thread.
    * @param blockingCodeHandler handler representing the blocking code to run
    * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
    * @return future that will be called when the blocking code is complete
    */
  def executeBlockingFuture[T](blockingCodeHandler: Future[T] => Unit, ordered: Boolean): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T,T]((x => x))
    _asJava.executeBlocking(funcToMappedHandler(Future.apply[T])(blockingCodeHandler), ordered, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Like [[io.vertx.scala.core.Vertx#executeBlocking]] called with ordered = true.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def executeBlockingFuture[T](blockingCodeHandler: Future[T] => Unit): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T,T]((x => x))
    _asJava.executeBlocking(funcToMappedHandler(Future.apply[T])(blockingCodeHandler), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Like [[io.vertx.scala.core.Vertx#createSharedWorkerExecutor]] but with the <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a> `poolSize`.
    */
  def createSharedWorkerExecutor(name: String): WorkerExecutor = {
    WorkerExecutor.apply(_asJava.createSharedWorkerExecutor(name))
  }

  /**
    * Like [[io.vertx.scala.core.Vertx#createSharedWorkerExecutor]] but with the <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a> `maxExecuteTime`.
    */
  def createSharedWorkerExecutor(name: String, poolSize: Int): WorkerExecutor = {
    WorkerExecutor.apply(_asJava.createSharedWorkerExecutor(name, poolSize))
  }

  /**
    * Create a named worker executor, the executor should be closed when it's not needed anymore to release
    * resources.<p/>
    *
    * This method can be called mutiple times with the same `name`. Executors with the same name will share
    * the same worker pool. The worker pool size and max execute time are set when the worker pool is created and
    * won't change after.
    *
    * The worker pool is released when all the [[io.vertx.scala.core.WorkerExecutor]] sharing the same name are closed.
    * @param name the name of the worker executor
    * @param poolSize the size of the pool
    * @param maxExecuteTime the value of max worker execute time, in ms
    * @return the named worker executor
    */
  def createSharedWorkerExecutor(name: String, poolSize: Int, maxExecuteTime: Long): WorkerExecutor = {
    WorkerExecutor.apply(_asJava.createSharedWorkerExecutor(name, poolSize, maxExecuteTime))
  }

  /**
    * Set a default exception handler for [[io.vertx.scala.core.Context]], set on  at creation.
    * @param handler the exception handler
    * @return a reference to this, so the API can be used fluently
    */
  def exceptionHandler(handler: Throwable => Unit): Vertx = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  private var cached_0: FileSystem = _
  private var cached_1: EventBus = _
  private var cached_2: SharedData = _
}

object Vertx {

  def apply(_asJava: JVertx): Vertx =
    new Vertx(_asJava)

  def vertx(): Vertx = {
    Vertx.apply(io.vertx.core.Vertx.vertx())
  }

  def vertx(options: VertxOptions): Vertx = {
    Vertx.apply(io.vertx.core.Vertx.vertx(options.asJava))
  }

  def clusteredVertxFuture(options: VertxOptions): concurrent.Future[Vertx] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JVertx,Vertx]((x => if (x == null) null else Vertx.apply(x)))
    io.vertx.core.Vertx.clusteredVertx(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def currentContext(): scala.Option[Context] = {
        scala.Option(Context.apply(io.vertx.core.Vertx.currentContext()))
  }

}
