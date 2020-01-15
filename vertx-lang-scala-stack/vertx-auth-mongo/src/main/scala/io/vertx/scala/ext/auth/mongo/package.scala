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




  /**
    * An extension of AuthProvider which is using  as store
    */

  implicit class MongoAuthScala(val asJava: io.vertx.ext.auth.mongo.MongoAuth) extends AnyVal {

    /**
     * Like insertUser from [[io.vertx.ext.auth.mongo.MongoAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def insertUserFuture(username: java.lang.String,password: java.lang.String,roles: java.util.List[java.lang.String],permissions: java.util.List[java.lang.String]): scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.insertUser(username, password, roles, permissions, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type MongoAuthOptions = io.vertx.ext.auth.mongo.MongoAuthOptions
  object MongoAuthOptions {
    def apply() = new MongoAuthOptions()
    def apply(json: JsonObject) = new MongoAuthOptions(json)
  }



  object MongoAuthentication {
    /**
     * Creates an instance of MongoAuth by using the given  and configuration object.     * @param mongoClient an instance of MongoClient to be used for data storage and retrival
     * @param options the configuration object for the current instance. see <a href="../../../../../../../../cheatsheet/MongoAuthenticationOptions.html">MongoAuthenticationOptions</a>
     * @return the created instance of MongoAuthentication
     */
    def create(mongoClient: io.vertx.ext.mongo.MongoClient,options: io.vertx.ext.auth.mongo.MongoAuthenticationOptions) = {
      io.vertx.ext.auth.mongo.MongoAuthentication.create(mongoClient, options)
    }
    def create(mongoClient: io.vertx.ext.mongo.MongoClient,hashStrategy: io.vertx.ext.auth.mongo.HashStrategy,options: io.vertx.ext.auth.mongo.MongoAuthenticationOptions) = {
      io.vertx.ext.auth.mongo.MongoAuthentication.create(mongoClient, hashStrategy, options)
    }
  }



  type MongoAuthenticationOptions = io.vertx.ext.auth.mongo.MongoAuthenticationOptions
  object MongoAuthenticationOptions {
    def apply() = new MongoAuthenticationOptions()
    def apply(json: JsonObject) = new MongoAuthenticationOptions(json)
  }



  object MongoAuthorization {
    /**
     * Creates an instance of MongoAuthorization by using the given  and configuration object.     * @param providerId the provider ID to differentiate from others
     * @param mongoClient an instance of MongoClient to be used for data storage and retrival
     * @param options the configuration object for the current instance. see <a href="../../../../../../../../cheatsheet/MongoAuthorizationOptions.html">MongoAuthorizationOptions</a>
     * @return the created instance of MongoAuthorization
     */
    def create(providerId: java.lang.String,mongoClient: io.vertx.ext.mongo.MongoClient,options: io.vertx.ext.auth.mongo.MongoAuthorizationOptions) = {
      io.vertx.ext.auth.mongo.MongoAuthorization.create(providerId, mongoClient, options)
    }
  }



  type MongoAuthorizationOptions = io.vertx.ext.auth.mongo.MongoAuthorizationOptions
  object MongoAuthorizationOptions {
    def apply() = new MongoAuthorizationOptions()
    def apply(json: JsonObject) = new MongoAuthorizationOptions(json)
  }



}
