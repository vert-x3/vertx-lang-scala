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

package io.vertx.scala.ext

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

package object auth{





  /**
    *
    * User-facing interface for authenticating users.
    */

  implicit class AuthProviderScala(val asJava: io.vertx.ext.auth.AuthProvider) extends AnyVal {

    /**
     * Like [[authenticate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def authenticateFuture(authInfo: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.ext.auth.User] = {
      val promise = Promise[io.vertx.ext.auth.User]()
      asJava.authenticate(authInfo, {a:AsyncResult[io.vertx.ext.auth.User] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }





  type KeyStoreOptions = io.vertx.ext.auth.KeyStoreOptions

  object KeyStoreOptions {
    def apply() = new KeyStoreOptions()
    def apply(json: JsonObject) = new KeyStoreOptions(json)
  }



  type PubSecKeyOptions = io.vertx.ext.auth.PubSecKeyOptions

  object PubSecKeyOptions {
    def apply() = new PubSecKeyOptions()
    def apply(json: JsonObject) = new PubSecKeyOptions(json)
  }



  type SecretOptions = io.vertx.ext.auth.SecretOptions

  object SecretOptions {
    def apply() = new SecretOptions()
    def apply(json: JsonObject) = new SecretOptions(json)
  }



  /**
    * Represents an authenticates User and contains operations to authorise the user.
    * 
    * Please consult the documentation for a detailed explanation.
    */

  implicit class UserScala(val asJava: io.vertx.ext.auth.User) extends AnyVal {

    /**
     * Like [[isAuthorized]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def isAuthorizedFuture(authority: java.lang.String): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.isAuthorized(authority, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[isAuthorised]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def isAuthorisedFuture(authority: java.lang.String): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.isAuthorised(authority, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


}
