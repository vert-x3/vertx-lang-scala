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

package io.vertx.scala.ext.web.sstore

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.ext.web.Session
import io.vertx.scala.core.Vertx
import io.vertx.core.Handler

/**
  * A session store which stores sessions in a distributed map so they are available across the cluster.
  */
class ClusteredSessionStore(private val _asJava: io.vertx.ext.web.sstore.ClusteredSessionStore) {

  def asJava: io.vertx.ext.web.sstore.ClusteredSessionStore = _asJava

}

object ClusteredSessionStore {

  def apply(_asJava: io.vertx.ext.web.sstore.ClusteredSessionStore): io.vertx.scala.ext.web.sstore.ClusteredSessionStore =
    new io.vertx.scala.ext.web.sstore.ClusteredSessionStore(_asJava)

  def create(vertx: io.vertx.scala.core.Vertx, sessionMapName: String): io.vertx.scala.ext.web.sstore.ClusteredSessionStore = {
    ClusteredSessionStore.apply(io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], sessionMapName))
  }

  def create(vertx: io.vertx.scala.core.Vertx, sessionMapName: String, retryTimeout: Long): io.vertx.scala.ext.web.sstore.ClusteredSessionStore = {
    ClusteredSessionStore.apply(io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], sessionMapName, retryTimeout))
  }

  def create(vertx: io.vertx.scala.core.Vertx): io.vertx.scala.ext.web.sstore.ClusteredSessionStore = {
    ClusteredSessionStore.apply(io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx]))
  }

  def create(vertx: io.vertx.scala.core.Vertx, retryTimeout: Long): io.vertx.scala.ext.web.sstore.ClusteredSessionStore = {
    ClusteredSessionStore.apply(io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], retryTimeout))
  }

}
