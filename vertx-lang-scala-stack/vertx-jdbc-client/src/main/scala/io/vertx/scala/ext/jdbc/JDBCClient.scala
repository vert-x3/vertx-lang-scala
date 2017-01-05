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

package io.vertx.scala.ext.jdbc

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.scala.ext.sql.SQLConnection
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.jdbc.{JDBCClient => JJDBCClient}
import io.vertx.scala.core.Vertx
import io.vertx.ext.sql.{SQLConnection => JSQLConnection}
import io.vertx.core.{Vertx => JVertx}

/**
  * An asynchronous client interface for interacting with a JDBC compliant database
  */
class JDBCClient(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
  def getConnection(handler: Handler[AsyncResult[SQLConnection]]):JDBCClient = {
    asJava.asInstanceOf[JJDBCClient].getConnection({x: AsyncResult[JSQLConnection] => handler.handle(AsyncResultWrapper[JSQLConnection,SQLConnection](x, a => SQLConnection(a)))})
    this
  }

//default methods
//basic methods
  def close():Unit = {
    asJava.asInstanceOf[JJDBCClient].close()
  }

//future methods
    def getConnectionFuture():scala.concurrent.Future[SQLConnection] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLConnection, SQLConnection](x => if (x == null) null.asInstanceOf[SQLConnection] else SQLConnection(x))
    asJava.asInstanceOf[JJDBCClient].getConnection(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object JDBCClient{
    def apply(asJava: JJDBCClient) = new JDBCClient(asJava)  
  //static methods
    def createNonShared(vertx: Vertx,config: io.vertx.core.json.JsonObject):JDBCClient = {
      JDBCClient(JJDBCClient.createNonShared(vertx.asJava.asInstanceOf[JVertx],config))
    }

    def createShared(vertx: Vertx,config: io.vertx.core.json.JsonObject,dataSourceName: String):JDBCClient = {
      JDBCClient(JJDBCClient.createShared(vertx.asJava.asInstanceOf[JVertx],config,dataSourceName.asInstanceOf[java.lang.String]))
    }

    def createShared(vertx: Vertx,config: io.vertx.core.json.JsonObject):JDBCClient = {
      JDBCClient(JJDBCClient.createShared(vertx.asJava.asInstanceOf[JVertx],config))
    }

  }
