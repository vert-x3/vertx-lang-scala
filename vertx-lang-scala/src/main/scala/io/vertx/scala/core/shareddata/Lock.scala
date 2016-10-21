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

package io.vertx.scala.core.shareddata

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._

/**
  * An asynchronous exclusive lock which can be obtained from any node in the cluster.
  * 
  * When the lock is obtained, no-one else in the cluster can obtain the lock with the same name until the lock
  * is released.
  */
class Lock(private val _asJava: io.vertx.core.shareddata.Lock) {

  def asJava: io.vertx.core.shareddata.Lock = _asJava

  /**
    * Release the lock. Once the lock is released another will be able to obtain the lock.
    */
  def release(): Unit = {
    _asJava.release()
  }

}

object Lock {

  def apply(_asJava: io.vertx.core.shareddata.Lock): io.vertx.scala.core.shareddata.Lock =
    new io.vertx.scala.core.shareddata.Lock(_asJava)

}
