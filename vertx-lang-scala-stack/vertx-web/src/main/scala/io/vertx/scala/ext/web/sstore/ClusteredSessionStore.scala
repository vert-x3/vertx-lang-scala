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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.web.sstore.{SessionStore => JSessionStore}
import io.vertx.ext.web.{Session => JSession}
import io.vertx.core.AsyncResult
import io.vertx.ext.web.sstore.{ClusteredSessionStore => JClusteredSessionStore}
import io.vertx.core.Handler
import io.vertx.scala.ext.web.Session
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * A session store which stores sessions in a distributed map so they are available across the cluster.
  */
class ClusteredSessionStore(private val _asJava: Object) 
    extends SessionStore(_asJava) {


}

object ClusteredSessionStore{
  def apply(asJava: JClusteredSessionStore) = new ClusteredSessionStore(asJava)  
  /**
    * Create a session store
    * @param vertx the Vert.x instance
    * @param sessionMapName the session map name
    * @return the session store
    */
  def create(vertx: Vertx,sessionMapName: String):ClusteredSessionStore = {
    ClusteredSessionStore(JClusteredSessionStore.create(vertx.asJava.asInstanceOf[JVertx],sessionMapName.asInstanceOf[java.lang.String]))
  }

  /**
    * Create a session store.<p/>
    *
    * The retry timeout value, configures how long the session handler will retry to get a session from the store
    * when it is not found.
    * @param vertx the Vert.x instance
    * @param sessionMapName the session map name
    * @param retryTimeout the store retry timeout, in ms
    * @return the session store
    */
  def create(vertx: Vertx,sessionMapName: String,retryTimeout: Long):ClusteredSessionStore = {
    ClusteredSessionStore(JClusteredSessionStore.create(vertx.asJava.asInstanceOf[JVertx],sessionMapName.asInstanceOf[java.lang.String],retryTimeout.asInstanceOf[java.lang.Long]))
  }

  /**
    * Create a session store
    * @param vertx the Vert.x instance
    * @return the session store
    */
  def create(vertx: Vertx):ClusteredSessionStore = {
    ClusteredSessionStore(JClusteredSessionStore.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Create a session store.<p/>
    *
    * The retry timeout value, configures how long the session handler will retry to get a session from the store
    * when it is not found.
    * @param vertx the Vert.x instance
    * @param retryTimeout the store retry timeout, in ms
    * @return the session store
    */
  def create(vertx: Vertx,retryTimeout: Long):ClusteredSessionStore = {
    ClusteredSessionStore(JClusteredSessionStore.create(vertx.asJava.asInstanceOf[JVertx],retryTimeout.asInstanceOf[java.lang.Long]))
  }

}
