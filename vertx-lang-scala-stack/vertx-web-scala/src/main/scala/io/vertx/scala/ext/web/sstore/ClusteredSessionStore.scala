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
import io.vertx.ext.web.sstore.{ClusteredSessionStore => JClusteredSessionStore}
import io.vertx.ext.web.{Session => JSession}
import io.vertx.scala.ext.web.Session
import io.vertx.ext.web.sstore.{SessionStore => JSessionStore}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx

/**
  * A session store which stores sessions in a distributed map so they are available across the cluster.
  */
class ClusteredSessionStore(private val _asJava: JClusteredSessionStore) 
    extends  {

  def asJava: JClusteredSessionStore = _asJava

}

object ClusteredSessionStore {

  def apply(_asJava: JClusteredSessionStore): ClusteredSessionStore =
    new ClusteredSessionStore(_asJava)

  def create(vertx: Vertx, sessionMapName: String): ClusteredSessionStore = {
    ClusteredSessionStore.apply(io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx.asJava.asInstanceOf[JVertx], sessionMapName))
  }

  def create(vertx: Vertx, sessionMapName: String, retryTimeout: Long): ClusteredSessionStore = {
    ClusteredSessionStore.apply(io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx.asJava.asInstanceOf[JVertx], sessionMapName, retryTimeout))
  }

  def create(vertx: Vertx): ClusteredSessionStore = {
    ClusteredSessionStore.apply(io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  def create(vertx: Vertx, retryTimeout: Long): ClusteredSessionStore = {
    ClusteredSessionStore.apply(io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx.asJava.asInstanceOf[JVertx], retryTimeout))
  }

}
