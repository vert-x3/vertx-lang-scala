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

import io.vertx.ext.auth.{AndAuthorization => JAndAuthorization}
import io.vertx.ext.auth.{Authorization => JAuthorization}
import scala.collection.JavaConverters._

package object auth{

  object AndAuthorization {
    def create() = {
      io.vertx.ext.auth.AndAuthorization.create()
    }
  }







  /**
    *
    * User-facing interface for authenticating users.
    */

  implicit class AuthProviderScala(val asJava: io.vertx.ext.auth.AuthProvider) extends AnyVal {

    /**
     * Like [[authenticate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def authenticateFuture(authInfo: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.ext.auth.User] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.User]()
      asJava.authenticate(authInfo, {a:AsyncResult[io.vertx.ext.auth.User] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  /**
    * Generic interface to fetch user related information from a server backend.
    *
    * All methods of this interface are optional.
    */

  implicit class AuthStoreScala(val asJava: io.vertx.ext.auth.AuthStore) extends AnyVal {

    /**
     * Like [[getUserCredentialsByName]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getUserCredentialsByNameFuture(username: java.lang.String): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[java.util.List[io.vertx.core.json.JsonObject]]()
      asJava.getUserCredentialsByName(username, {a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getUserCredentialsById]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getUserCredentialsByIdFuture(rawId: java.lang.String): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[java.util.List[io.vertx.core.json.JsonObject]]()
      asJava.getUserCredentialsById(rawId, {a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[updateUserCredential]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def updateUserCredentialFuture(id: java.lang.String,data: io.vertx.core.json.JsonObject,upsert: java.lang.Boolean): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.updateUserCredential(id, data, upsert, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getUserRoles]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getUserRolesFuture(id: java.lang.String): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = concurrent.Promise[java.util.List[java.lang.String]]()
      asJava.getUserRoles(id, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getUserPermissions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getUserPermissionsFuture(id: java.lang.String): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = concurrent.Promise[java.util.List[java.lang.String]]()
      asJava.getUserPermissions(id, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }







  /**
    * The role of an AuthorizationProvider is to return a set of Authorization.
    * Note that each AuthorizationProvider must provide its own unique Id
    */

  implicit class AuthorizationProviderScala(val asJava: io.vertx.ext.auth.AuthorizationProvider) extends AnyVal {

    /**
     * Like [[getAuthorizations]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getAuthorizationsFuture(user: io.vertx.ext.auth.User): scala.concurrent.Future[java.util.Set[io.vertx.ext.auth.Authorization]] = {
      val promise = concurrent.Promise[java.util.Set[io.vertx.ext.auth.Authorization]]()
      asJava.getAuthorizations(user, {a:AsyncResult[java.util.Set[io.vertx.ext.auth.Authorization]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  object ChainAuth {
    /**
     * Like [[create]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def create() = {
      io.vertx.ext.auth.ChainAuth.create()
    }
  }




  object HashingStrategy {
    /**
     * Like [[load]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def load() = {
      io.vertx.ext.auth.HashingStrategy.load()
    }
  }



  type KeyStoreOptions = io.vertx.ext.auth.KeyStoreOptions
  object KeyStoreOptions {
    def apply() = new KeyStoreOptions()
    def apply(json: JsonObject) = new KeyStoreOptions(json)
  }



  object NotAuthorization {
    def create(authorization: io.vertx.ext.auth.Authorization) = {
      io.vertx.ext.auth.NotAuthorization.create(authorization)
    }
  }


  object OrAuthorization {
    def create() = {
      io.vertx.ext.auth.OrAuthorization.create()
    }
  }


  object PermissionBasedAuthorization {
    def create(permission: java.lang.String) = {
      io.vertx.ext.auth.PermissionBasedAuthorization.create(permission)
    }
  }



  type PubSecKeyOptions = io.vertx.ext.auth.PubSecKeyOptions
  object PubSecKeyOptions {
    def apply() = new PubSecKeyOptions()
    def apply(json: JsonObject) = new PubSecKeyOptions(json)
  }



  object RoleBasedAuthorization {
    def create(role: java.lang.String) = {
      io.vertx.ext.auth.RoleBasedAuthorization.create(role)
    }
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
      val promise = concurrent.Promise[java.lang.Boolean]()
      asJava.isAuthorized(authority, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  object VertxContextPRNG {
    /**
     * Like [[current]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def current() = {
      io.vertx.ext.auth.VertxContextPRNG.current()
    }
    /**
     * Like [[current]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def current(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.auth.VertxContextPRNG.current(vertx)
    }
  }


  object WildcardPermissionBasedAuthorization {
    def create(permission: java.lang.String) = {
      io.vertx.ext.auth.WildcardPermissionBasedAuthorization.create(permission)
    }
  }


}
