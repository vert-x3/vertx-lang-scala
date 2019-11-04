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

package io.vertx.scala.ext.auth

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.auth
import io.vertx.ext.auth.mongo.HashAlgorithm
import io.vertx.ext.mongo.{MongoClient => JMongoClient}
import io.vertx.core
import scala.collection.JavaConverters._
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.auth.mongo.{MongoAuth => JMongoAuth}
import io.vertx.core.{Future => JFuture}
import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.mongo.{HashStrategy => JHashStrategy}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.mongo

package object mongo{

  type HashStrategy = io.vertx.ext.auth.mongo.HashStrategy



  /**
    * An extension of AuthProvider which is using  as store
    */

  implicit class MongoAuthScala(val asJava: io.vertx.ext.auth.mongo.MongoAuth) extends AnyVal {

    /**
     * Like [[insertUser]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def insertUserFuture(username: java.lang.String,password: java.lang.String,roles: java.util.List[java.lang.String],permissions: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.insertUser(username, password, roles, permissions, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type MongoAuthOptions = io.vertx.ext.auth.mongo.MongoAuthOptions
  object MongoAuthOptions {
    def apply() = new MongoAuthOptions()
    def apply(json: JsonObject) = new MongoAuthOptions(json)
  }



}
