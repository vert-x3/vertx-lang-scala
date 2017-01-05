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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.web.sstore.{SessionStore => JSessionStore}
import io.vertx.ext.web.sstore.{LocalSessionStore => JLocalSessionStore}
import io.vertx.ext.web.{Session => JSession}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.ext.web.Session
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * A session store which is only available on a single node.
  * 
  * Can be used when sticky sessions are being used.
  */
class LocalSessionStore(private val _asJava: Object) 
    extends SessionStore(_asJava) {


//cached methods
//fluent methods
//default methods
//basic methods
//future methods
}

  object LocalSessionStore{
    def apply(asJava: JLocalSessionStore) = new LocalSessionStore(asJava)  
  //static methods
    def create(vertx: Vertx):LocalSessionStore = {
      LocalSessionStore(JLocalSessionStore.create(vertx.asJava.asInstanceOf[JVertx]))
    }

    def create(vertx: Vertx,sessionMapName: String):LocalSessionStore = {
      LocalSessionStore(JLocalSessionStore.create(vertx.asJava.asInstanceOf[JVertx],sessionMapName.asInstanceOf[java.lang.String]))
    }

    def create(vertx: Vertx,sessionMapName: String,reaperInterval: Long):LocalSessionStore = {
      LocalSessionStore(JLocalSessionStore.create(vertx.asJava.asInstanceOf[JVertx],sessionMapName.asInstanceOf[java.lang.String],reaperInterval.asInstanceOf[java.lang.Long]))
    }

  }
