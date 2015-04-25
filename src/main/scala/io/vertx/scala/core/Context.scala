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

import io.vertx.core.json.JsonObject
import io.vertx.core.Handler

class Context(private val _asJava: io.vertx.core.Context) {

  def asJava: java.lang.Object = _asJava

  def runOnContext(action: => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.runOnContext(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>action))
  }

  def deploymentID(): String = {
    _asJava.deploymentID()
  }

  def config(): io.vertx.core.json.JsonObject = {
    _asJava.config()
  }

  def processArgs(): List[String] = {
    import scala.collection.JavaConverters._
    _asJava.processArgs().asScala.map(x => x:String).toList
  }

  def isEventLoopContext(): Boolean = {
    _asJava.isEventLoopContext()
  }

  def isWorker(): Boolean = {
    _asJava.isWorker()
  }

  def isMultiThreaded(): Boolean = {
    _asJava.isMultiThreaded()
  }

  def get[T](key: String): T = {
    _asJava.get(key)
  }

  def put(key: String, value: AnyRef): Unit = {
    _asJava.put(key, value)
  }

  def remove(key: String): Boolean = {
    _asJava.remove(key)
  }

}

object Context {

  def apply(_asJava: io.vertx.core.Context): io.vertx.scala.core.Context =
    new io.vertx.scala.core.Context(_asJava)
}
