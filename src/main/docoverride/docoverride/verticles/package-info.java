/*
 * Copyright 2014 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

/**
 * === Writing Verticles
 *
 * There are two alternatives to create verticles in Scala:
 *
 *  * a Scala class extending the {@link io.vertx.lang.scala.ScalaVerticle} class
 *  * a Scala class implementing the {@link io.vertx.core.Verticle} interface or extending the {@link io.vertx.core.AbstractVerticle} class
 *
 *  We will not cover the third case in this manual, as it is a plain Java class and instead you should read the
 *  Vert.x manual for Java.
 *
 *
 * Alternatively, you can extend the {@link io.vertx.lang.scala.ScalaVerticle} class and implement the `start` and
 * `stop` methods:
 *
 * [source, scala]
 * ----
 * import io.vertx.lang.scala.ScalaVerticle;
 *
 * class HelloWorldHttpVerticle extends ScalaVerticle {
 *
 *  override def start(): Unit = {
 *    println("Starting")
 *  }
 *
 *  override def stop(): Unit = {
 *    println("Stopping")
 *  }
 * ----
 *
 * As in Java, vert.x creates a new instance of the class automatically.  When Vert.x deploys the verticle it will call
 * the `start` method, and when the method has completed the verticle will be considered started.
 *
 * You can also optionally override the `stop` method. This will be called by Vert.x when the verticle is undeployed
 * and when the method has completed the verticle will be considered stopped.
 *
 * === Accessing the vertx instance from a verticle
 *
 * Regardless the way you use to implement your verticle, you access the vert.x instance using the `vertx` field.
 *
 * Access to the vert.x instance in a ScalaVerticle class
 * [source, scala]
 * ----
 * import io.vertx.lang.scala.ScalaVerticle;
 *
 * public class HelloWorldVerticle extends ScalaVerticle {
 *
 *    override def start(startFuture: Future[Void]): Unit = {
 *      vertx.deployVerticle("another_verticle.js")
 *    }
 * }
 * ----
 *
 * === Asynchronous Verticle start and stop
 *
 * Sometimes you want to do something in your verticle start-up which takes some time and you don't want the verticle to
 * be considered deployed until that happens. For example you might want to deploy other verticles in the start method.
 *
 * You can't block waiting for the other verticles to deploy in your start method as that would break the <<golden_rule, Golden Rule>>.
 *
 * So how can you do this?
 *
 * The way to do it is to implement the *asynchronous* start method. This version of the method takes a Future as a parameter.When the method returns the verticle will *not* be considered deployed.
 *
 * Some time later, after you've done everything you need to do (e.g. start other verticles), you can call complete
 * on the Future (or fail) to signal that you're done. Similarly, there is an asynchronous version of the stop method too.
 * You use this if you want to do some verticle cleanup that takes some time.
 *
 * If your verticle extends {@link io.vertx.lang.scala.ScalaVerticle}, you override the
 * {@link io.vertx.lang.scala.ScalaVerticle#start(io.vertx.core.Future)} and
 * {@link io.vertx.lang.scala.ScalaVerticle#stop(io.vertx.core.Future)} methods:
 *
 * [source, scala]
 * ----
 * import io.vertx.core.Future
 * import io.vertx.lang.scala.ScalaVerticle
 *
 * public class HelloWorldVerticle extends ScalaVerticle {
 *  public void start(future: Future[Void]) {
 *   println "starting"
 *   vertx.deployVerticleFuture("v.rb").onComplete{
 *    case Success(deploymentId) => startFuture.complete()
 *    case Failure(throwable) => startFuture.fail(throwable)
 *   }
 *  }
 *
 *  public void stop(future: Future[Void]) {
 *   println("stopping")
 *   future.complete()
 *  }
 * }
 * ----
 *
 * NOTE: You don't need to manually undeploy child verticles started by a verticle, in the verticle's stop method.
 * Vert.x will automatically undeploy any child verticles when the parent is undeployed.
 */
@Document(fileName = "override/verticles.adoc")
package docoverride.verticles;

import io.vertx.docgen.Document;
