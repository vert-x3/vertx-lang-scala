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
import io.vertx.scala.core.dns.DnsClientOptions
import io.vertx.scala.core.net.NetClient
import io.vertx.core.{DeploymentOptions => JDeploymentOptions}
import io.vertx.scala.core.eventbus.EventBus
import scala.reflect.runtime.universe._
import io.vertx.scala.core.dns.DnsClient
import io.vertx.scala.core.datagram.DatagramSocket
import io.vertx.core.http.{HttpServerOptions => JHttpServerOptions}
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
import io.vertx.scala.core.http.HttpServerOptions
import io.vertx.core.datagram.{DatagramSocket => JDatagramSocket}
import io.vertx.core.dns.{DnsClientOptions => JDnsClientOptions}
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
import io.vertx.core.{Promise => JPromise}
import io.vertx.core.net.{NetClient => JNetClient}
import io.vertx.core.http.{HttpClientOptions => JHttpClientOptions}
import io.vertx.scala.core.datagram.DatagramSocketOptions
import io.vertx.core.{WorkerExecutor => JWorkerExecutor}
import io.vertx.scala.core.metrics.Measured
import scala.collection.JavaConverters._
import io.vertx.core.shareddata.{SharedData => JSharedData}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.shareddata.SharedData
import io.vertx.lang.scala.Converter._
import io.vertx.core.datagram.{DatagramSocketOptions => JDatagramSocketOptions}
import java.util.concurrent.TimeUnit
import io.vertx.core.http.{HttpClient => JHttpClient}
import io.vertx.core.{Context => JContext}
import io.vertx.scala.core.file.FileSystem
import io.vertx.scala.core.http.HttpClientOptions
import io.vertx.scala.core.net.NetServerOptions
import io.vertx.core.Handler
import io.vertx.lang.scala.ScalaVerticle
import io.vertx.core.{TimeoutStream => JTimeoutStream}
import io.vertx.lang.scala.HandlerOps._

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

class Vertx(private val _asJava: Object) extends Measured {
  def asJava = _asJava
  private var cached_0: Option[FileSystem] = None
  private var cached_1: Option[EventBus] = None
  private var cached_2: Option[SharedData] = None
  private var cached_3: Option[Boolean] = None

  /**
    * Deploy a verticle instance that you have created yourself.
    * <p>
    * Vert.x will assign the verticle a context and start the verticle.
    * <p>
    * The actual deploy happens asynchronously and may not complete until after the call has returned.
    *
    * @param verticle the verticle instance to deploy.
    */
  def deployVerticle(verticle: ScalaVerticle): Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(verticle.asJava)
  }

  /**
    * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
    */
  def deployVerticleFuture(verticle: ScalaVerticle): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JVertx].deployVerticle(verticle.asJava(), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Like {@link #deployVerticle(Verticle)} but {@link io.vertx.core.DeploymentOptions} are provided to configure the
    * deployment.
    *
    * @param verticle the verticle instance to deploy
    * @param options  the deployment options.
    */
  def deployVerticle(verticle: ScalaVerticle, options: DeploymentOptions): Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(verticle.asJava, options.asJava)
  }

  /**
    * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
    */
  def deployVerticleFuture(verticle: ScalaVerticle, options: DeploymentOptions): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JVertx].deployVerticle(verticle.asJava(), options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
   * Get the filesystem object. There is a single instance of FileSystem per Vertx instance.   * @return the filesystem object
   */
  def fileSystem(): FileSystem = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JVertx].fileSystem()
      cached_0 = Some(FileSystem(tmp))
    }
    cached_0.get
  }

  /**
   * Get the event bus object. There is a single instance of EventBus per Vertx instance.   * @return the event bus object
   */
  def eventBus(): EventBus = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JVertx].eventBus()
      cached_1 = Some(EventBus(tmp))
    }
    cached_1.get
  }

  /**
   * Get the shared data object. There is a single instance of SharedData per Vertx instance.   * @return the shared data object
   */
  def sharedData(): SharedData = {
    if (cached_2 == None) {
      val tmp = asJava.asInstanceOf[JVertx].sharedData()
      cached_2 = Some(SharedData(tmp))
    }
    cached_2.get
  }

  /**
   * @return whether the native transport is used
   */
  def isNativeTransportEnabled(): Boolean = {
    if (cached_3 == None) {
      val tmp = asJava.asInstanceOf[JVertx].isNativeTransportEnabled()
      cached_3 = Some(tmp.asInstanceOf[Boolean])
    }
    cached_3.get
  }


  /**
   * Set a default exception handler for [[io.vertx.scala.core.Context]], set on  at creation.   * @param handler the exception handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def exceptionHandler(handler: Handler[Throwable]): Vertx = {
    asJava.asInstanceOf[JVertx].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }


  /**
   * Whether the metrics are enabled for this measured object   * @return `true` if metrics are enabled
   */
  override def isMetricsEnabled(): Boolean = {
    asJava.asInstanceOf[JVertx].isMetricsEnabled().asInstanceOf[Boolean]
  }


  /**
   * Gets the current context, or creates one if there isn't one   * @return The current context (created if didn't exist)
   */
  def getOrCreateContext (): Context = {
    Context(asJava.asInstanceOf[JVertx].getOrCreateContext())
  }

  /**
   * Create a TCP/SSL server using the specified options   * @param options the options to use see <a href="../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a>
   * @return the server
   */
  def createNetServer (options: NetServerOptions): NetServer = {
    NetServer(asJava.asInstanceOf[JVertx].createNetServer(options.asJava))
  }

  /**
   * Create a TCP/SSL server using default options   * @return the server
   */
  def createNetServer (): NetServer = {
    NetServer(asJava.asInstanceOf[JVertx].createNetServer())
  }

  /**
   * Create a TCP/SSL client using the specified options   * @param options the options to use see <a href="../../../../../../cheatsheet/NetClientOptions.html">NetClientOptions</a>
   * @return the client
   */
  def createNetClient (options: NetClientOptions): NetClient = {
    NetClient(asJava.asInstanceOf[JVertx].createNetClient(options.asJava))
  }

  /**
   * Create a TCP/SSL client using default options   * @return the client
   */
  def createNetClient (): NetClient = {
    NetClient(asJava.asInstanceOf[JVertx].createNetClient())
  }

  /**
   * Create an HTTP/HTTPS server using the specified options   * @param options the options to use see <a href="../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a>
   * @return the server
   */
  def createHttpServer (options: HttpServerOptions): HttpServer = {
    HttpServer(asJava.asInstanceOf[JVertx].createHttpServer(options.asJava))
  }

  /**
   * Create an HTTP/HTTPS server using default options   * @return the server
   */
  def createHttpServer (): HttpServer = {
    HttpServer(asJava.asInstanceOf[JVertx].createHttpServer())
  }

  /**
   * Create a HTTP/HTTPS client using the specified options   * @param options the options to use see <a href="../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
   * @return the client
   */
  def createHttpClient (options: HttpClientOptions): HttpClient = {
    HttpClient(asJava.asInstanceOf[JVertx].createHttpClient(options.asJava))
  }

  /**
   * Create a HTTP/HTTPS client using default options   * @return the client
   */
  def createHttpClient (): HttpClient = {
    HttpClient(asJava.asInstanceOf[JVertx].createHttpClient())
  }

  /**
   * Create a datagram socket using the specified options   * @param options the options to use see <a href="../../../../../../cheatsheet/DatagramSocketOptions.html">DatagramSocketOptions</a>
   * @return the socket
   */
  def createDatagramSocket (options: DatagramSocketOptions): DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JVertx].createDatagramSocket(options.asJava))
  }

  /**
   * Create a datagram socket using default options   * @return the socket
   */
  def createDatagramSocket (): DatagramSocket = {
    DatagramSocket(asJava.asInstanceOf[JVertx].createDatagramSocket())
  }

  /**
   * Create a DNS client to connect to a DNS server at the specified host and port, with the default query timeout (5 seconds)
   * <p/>   * @param port the port
   * @param host the host
   * @return the DNS client
   */
  def createDnsClient (port: Int, host: String): DnsClient = {
    DnsClient(asJava.asInstanceOf[JVertx].createDnsClient(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String]))
  }

  /**
   * Create a DNS client to connect to the DNS server configured by <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a>
   * 
   * DNS client takes the first configured resolver address provided by `   * @return the DNS client
   */
  def createDnsClient (): DnsClient = {
    DnsClient(asJava.asInstanceOf[JVertx].createDnsClient())
  }

  /**
   * Create a DNS client to connect to a DNS server   * @param options the client options see <a href="../../../../../../cheatsheet/DnsClientOptions.html">DnsClientOptions</a>
   * @return the DNS client
   */
  def createDnsClient (options: DnsClientOptions): DnsClient = {
    DnsClient(asJava.asInstanceOf[JVertx].createDnsClient(options.asJava))
  }

  /**
   * Set a one-shot timer to fire after `delay` milliseconds, at which point `handler` will be called with
   * the id of the timer.   * @param delay the delay in milliseconds, after which the timer will fire
   * @param handler the handler that will be called with the timer ID when the timer fires
   * @return the unique ID of the timer
   */
  def setTimer (delay: Long, handler: Handler[Long]): Long = {
    asJava.asInstanceOf[JVertx].setTimer(delay.asInstanceOf[java.lang.Long], (if (handler == null) null else new io.vertx.core.Handler[java.lang.Long]{def handle(x: java.lang.Long) {handler.handle(x.asInstanceOf[Long])}})).asInstanceOf[Long]
  }

  /**
   * Returns a one-shot timer as a read stream. The timer will be fired after `delay` milliseconds after
   * the  has been called.   * @param delay the delay in milliseconds, after which the timer will fire
   * @return the timer stream
   */
  def timerStream (delay: Long): TimeoutStream = {
    TimeoutStream(asJava.asInstanceOf[JVertx].timerStream(delay.asInstanceOf[java.lang.Long]))
  }

  /**
   * Set a periodic timer to fire every `delay` milliseconds, at which point `handler` will be called with
   * the id of the timer.   * @param delay the delay in milliseconds, after which the timer will fire
   * @param handler the handler that will be called with the timer ID when the timer fires
   * @return the unique ID of the timer
   */
  def setPeriodic (delay: Long, handler: Handler[Long]): Long = {
    asJava.asInstanceOf[JVertx].setPeriodic(delay.asInstanceOf[java.lang.Long], (if (handler == null) null else new io.vertx.core.Handler[java.lang.Long]{def handle(x: java.lang.Long) {handler.handle(x.asInstanceOf[Long])}})).asInstanceOf[Long]
  }

  /**
   * Returns a periodic timer as a read stream. The timer will be fired every `delay` milliseconds after
   * the  has been called.   * @param delay the delay in milliseconds, after which the timer will fire
   * @return the periodic stream
   */
  def periodicStream (delay: Long): TimeoutStream = {
    TimeoutStream(asJava.asInstanceOf[JVertx].periodicStream(delay.asInstanceOf[java.lang.Long]))
  }

  /**
   * Cancels the timer with the specified `id`.   * @param id The id of the timer to cancel
   * @return true if the timer was successfully cancelled, or false if the timer does not exist.
   */
  def cancelTimer (id: Long): Boolean = {
    asJava.asInstanceOf[JVertx].cancelTimer(id.asInstanceOf[java.lang.Long]).asInstanceOf[Boolean]
  }

  /**
   * Puts the handler on the event queue for the current context so it will be run asynchronously ASAP after all
   * preceeding events have been handled.   * @param action - a handler representing the action to execute
   */
  def runOnContext (action: Handler[Unit]): Unit = {
    asJava.asInstanceOf[JVertx].runOnContext((if (action == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {action.handle(x)}}))
  }

  /**
   * Stop the the Vertx instance and release any resources held by it.
   * 
   * The instance cannot be used after it has been closed.
   * 
   * The actual close is asynchronous and may not complete until after the call has returned.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JVertx].close()
  }

  /**
   * Like [[io.vertx.scala.core.Vertx#close]] but the completionHandler will be called when the close is complete   * @param completionHandler The handler will be notified when the close is complete.
   */
  def close (completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JVertx].close((if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Deploy a verticle instance given a name.
   * 
   * Given the name, Vert.x selects a  instance to use to instantiate the verticle.
   * 
   * For the rules on how factories are selected please consult the user manual.   * @param name the name.
   */
  def deployVerticle (name: String): Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(name.asInstanceOf[java.lang.String])
  }

  /**
   * Like [[io.vertx.scala.core.Vertx#deployVerticle]] but the completionHandler will be notified when the deployment is complete.
   * 
   * If the deployment is successful the result will contain a String representing the unique deployment ID of the
   * deployment.
   * 
   * This deployment ID can subsequently be used to undeploy the verticle.   * @param name The identifier
   * @param completionHandler a handler which will be notified when the deployment is complete
   */
  def deployVerticle (name: String, completionHandler: Handler[AsyncResult[String]]): Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(name.asInstanceOf[java.lang.String], (if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {completionHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
  }

  /**
   * Like [[io.vertx.scala.core.Vertx#deployVerticle]] but <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a> are provided to configure the
   * deployment.   * @param name the name
   * @param options the deployment options. see <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a>
   */
  def deployVerticle (name: String, options: DeploymentOptions): Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(name.asInstanceOf[java.lang.String], options.asJava)
  }

  /**
   * Like [[io.vertx.scala.core.Vertx#deployVerticle]] but <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a> are provided to configure the
   * deployment.   * @param name the name
   * @param options the deployment options. see <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a>
   * @param completionHandler a handler which will be notified when the deployment is complete
   */
  def deployVerticle (name: String, options: DeploymentOptions, completionHandler: Handler[AsyncResult[String]]): Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(name.asInstanceOf[java.lang.String], options.asJava, (if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {completionHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
  }

  /**
   * Undeploy a verticle deployment.
   * 
   * The actual undeployment happens asynchronously and may not complete until after the method has returned.   * @param deploymentID the deployment ID
   */
  def undeploy (deploymentID: String): Unit = {
    asJava.asInstanceOf[JVertx].undeploy(deploymentID.asInstanceOf[java.lang.String])
  }

  /**
   * Like [[io.vertx.scala.core.Vertx]] but the completionHandler will be notified when the undeployment is complete.   * @param deploymentID the deployment ID
   * @param completionHandler a handler which will be notified when the undeployment is complete
   */
  def undeploy (deploymentID: String, completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JVertx].undeploy(deploymentID.asInstanceOf[java.lang.String], (if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Return a Set of deployment IDs for the currently deployed deploymentIDs.   * @return Set of deployment IDs
   */
  def deploymentIDs (): scala.collection.mutable.Set[String] = {
    asJava.asInstanceOf[JVertx].deploymentIDs().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * Is this Vert.x instance clustered?   * @return true if clustered
   */
  def isClustered (): Boolean = {
    asJava.asInstanceOf[JVertx].isClustered().asInstanceOf[Boolean]
  }

  /**
   * Safely execute some blocking code.
   *
   * Executes the blocking code in the handler `blockingCodeHandler` using a thread from the worker pool.
   *
   * When the code is complete the returned Future will be completed with the result.
   *
   * @param blockingFunction function containing blocking code
   * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
   * @return a Future representing the result of the blocking operation
   */
  def executeBlocking[T](blockingFunction: () => T, ordered: Boolean = true): concurrent.Future[T] = {
    val promise = concurrent.Promise[T]
    val h: Handler[io.vertx.core.Promise[T]] = {f => util.Try(blockingFunction()) match {
      case util.Success(s) => f.complete(s)
      case util.Failure(t) => f.fail(t)
    }}
    asJava.asInstanceOf[JVertx].executeBlocking[T](h, ordered, {h:AsyncResult[T] => {if (h.succeeded()) promise.success(h.result()) else promise.failure(h.cause());()} })
    promise.future
  }

  /**
   * Like [[io.vertx.scala.core.Vertx#createSharedWorkerExecutor]] but with the <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a> `poolSize`.
   */
  def createSharedWorkerExecutor (name: String): WorkerExecutor = {
    WorkerExecutor(asJava.asInstanceOf[JVertx].createSharedWorkerExecutor(name.asInstanceOf[java.lang.String]))
  }

  /**
   * Like [[io.vertx.scala.core.Vertx#createSharedWorkerExecutor]] but with the <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a> `maxExecuteTime`.
   */
  def createSharedWorkerExecutor (name: String, poolSize: Int): WorkerExecutor = {
    WorkerExecutor(asJava.asInstanceOf[JVertx].createSharedWorkerExecutor(name.asInstanceOf[java.lang.String], poolSize.asInstanceOf[java.lang.Integer]))
  }

  /**
   * Like [[io.vertx.scala.core.Vertx#createSharedWorkerExecutor]] but with the .
   */
  def createSharedWorkerExecutor (name: String, poolSize: Int, maxExecuteTime: Long): WorkerExecutor = {
    WorkerExecutor(asJava.asInstanceOf[JVertx].createSharedWorkerExecutor(name.asInstanceOf[java.lang.String], poolSize.asInstanceOf[java.lang.Integer], maxExecuteTime.asInstanceOf[java.lang.Long]))
  }

  /**
   * Create a named worker executor, the executor should be closed when it's not needed anymore to release
   * resources.<p/>
   *
   * This method can be called mutiple times with the same `name`. Executors with the same name will share
   * the same worker pool. The worker pool size , max execute time and unit of max execute time are set when the worker pool is created and
   * won't change after.
   *
   * The worker pool is released when all the [[io.vertx.scala.core.WorkerExecutor]] sharing the same name are closed.   * @param name the name of the worker executor
   * @param poolSize the size of the pool
   * @param maxExecuteTime the value of max worker execute time
   * @param maxExecuteTimeUnit the value of unit of max worker execute time
   * @return the named worker executor
   */
  def createSharedWorkerExecutor (name: String, poolSize: Int, maxExecuteTime: Long, maxExecuteTimeUnit: java.util.concurrent.TimeUnit): WorkerExecutor = {
    WorkerExecutor(asJava.asInstanceOf[JVertx].createSharedWorkerExecutor(name.asInstanceOf[java.lang.String], poolSize.asInstanceOf[java.lang.Integer], maxExecuteTime.asInstanceOf[java.lang.Long], maxExecuteTimeUnit))
  }


 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JVertx].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deployVerticleFuture (name: String): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JVertx].deployVerticle(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deployVerticleFuture (name: String, options: DeploymentOptions): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JVertx].deployVerticle(name.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[undeploy]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def undeployFuture (deploymentID: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JVertx].undeploy(deploymentID.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object Vertx {
  def apply(asJava: JVertx) = new Vertx(asJava)
  
  /**
   * Creates a non clustered instance using default options.   * @return the instance
   */
  def vertx(): Vertx = {
    Vertx(JVertx.vertx())
  }

  /**
   * Creates a non clustered instance using the specified options   * @param options the options to use see <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a>
   * @return the instance
   */
  def vertx(options: VertxOptions): Vertx = {
    Vertx(JVertx.vertx(options.asJava))
  }

  /**
   * Creates a clustered instance using the specified options.
   * 
   * The instance is created asynchronously and the resultHandler is called with the result when it is ready.   * @param options the options to use see <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a>
   * @param resultHandler the result handler that will receive the result
   */
  def clusteredVertx(options: VertxOptions,resultHandler: Handler[AsyncResult[Vertx]]): Unit = {
    JVertx.clusteredVertx(options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JVertx]]{def handle(x: AsyncResult[JVertx]) {resultHandler.handle(AsyncResultWrapper[JVertx, Vertx](x, a => Vertx(a)))}}))
  }

  /**
   * Gets the current context   * @return The current context or null if no current context
   */
  def currentContext(): scala.Option[Context] = {
    scala.Option(JVertx.currentContext()).map(Context(_))
  }

}
