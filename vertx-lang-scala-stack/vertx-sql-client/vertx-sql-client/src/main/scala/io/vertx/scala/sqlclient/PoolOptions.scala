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

package io.vertx.scala.sqlclient

import io.vertx.sqlclient.{PoolOptions => JPoolOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * The options for configuring a connection pool.
 */

class PoolOptions(private val _asJava: JPoolOptions) {
  def asJava = _asJava
  /**
   * Set the maximum pool size
   */
  def setMaxSize(value: Int) = {
    asJava.setMaxSize(value)
    this
  }

  def getMaxSize: Int = {
    asJava.getMaxSize().asInstanceOf[Int]
  }

  /**
   * Set the maximum connection request allowed in the wait queue, any requests beyond the max size will result in
   * an failure.  If the value is set to a negative number then the queue will be unbounded.
   */
  def setMaxWaitQueueSize(value: Int) = {
    asJava.setMaxWaitQueueSize(value)
    this
  }

  def getMaxWaitQueueSize: Int = {
    asJava.getMaxWaitQueueSize().asInstanceOf[Int]
  }

}


object PoolOptions {

  def apply() = {
    new PoolOptions(new JPoolOptions(emptyObj()))
  }

  def apply(t: JPoolOptions) = {
    if (t != null) {
      new PoolOptions(t)
    } else {
      new PoolOptions(new JPoolOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): PoolOptions = {
    if (json != null) {
      new PoolOptions(new JPoolOptions(json))
    } else {
      new PoolOptions(new JPoolOptions(emptyObj()))
    }
  }
}

