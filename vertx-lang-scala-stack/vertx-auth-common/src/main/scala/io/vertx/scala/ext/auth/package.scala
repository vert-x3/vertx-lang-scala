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

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.auth.{HashingStrategy => JHashingStrategy}
import io.vertx.ext.auth.{HashingAlgorithm => JHashingAlgorithm}
package object auth{


  object AndAuthorization {
def create() = {
      io.vertx.ext.auth.authorization.AndAuthorization.create()
}  }







  /**
    *
    * User-facing interface for authenticating users.
    */

  implicit class AuthenticationProviderScala(val asJava: io.vertx.ext.auth.authentication.AuthenticationProvider) extends AnyVal {


    /**
     * Like authenticate from [[io.vertx.ext.auth.authentication.AuthenticationProvider]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def authenticateFuture(authInfo: io.vertx.core.json.JsonObject) : scala.concurrent.Future[io.vertx.ext.auth.User] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.User]()
      asJava.authenticate(authInfo, new Handler[AsyncResult[io.vertx.ext.auth.User]] { override def handle(event: AsyncResult[io.vertx.ext.auth.User]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
  }





  object AuthorizationContext {
    /**
     * Like create from [[io.vertx.ext.auth.authorization.AuthorizationContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(user: io.vertx.ext.auth.User) = {
      io.vertx.ext.auth.authorization.AuthorizationContext.create(user)
}  }



  /**
    * The role of an AuthorizationProvider is to return a set of Authorization.
    * Note that each AuthorizationProvider must provide its own unique Id
    */

  implicit class AuthorizationProviderScala(val asJava: io.vertx.ext.auth.authorization.AuthorizationProvider) extends AnyVal {


    /**
     * Like getAuthorizations from [[io.vertx.ext.auth.authorization.AuthorizationProvider]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getAuthorizationsFuture(user: io.vertx.ext.auth.User) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.getAuthorizations(user, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
  }





  object ChainAuth {
    /**
     * Like create from [[io.vertx.ext.auth.ChainAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create() = {
      io.vertx.ext.auth.ChainAuth.create()
}
    /**
     * Like all from [[io.vertx.ext.auth.ChainAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def all() = {
      io.vertx.ext.auth.ChainAuth.all()
}
    /**
     * Like any from [[io.vertx.ext.auth.ChainAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def any() = {
      io.vertx.ext.auth.ChainAuth.any()
}  }




  object HashingStrategy {
    /**
     * Like load from [[io.vertx.ext.auth.HashingStrategy]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def load() = {
      io.vertx.ext.auth.HashingStrategy.load()
}  }


  type KeyStoreOptions = io.vertx.ext.auth.KeyStoreOptions
  object KeyStoreOptions {
    def apply() = new KeyStoreOptions()
    def apply(json: JsonObject) = new KeyStoreOptions(json)
  }



  object NotAuthorization {
def create(authorization: io.vertx.ext.auth.authorization.Authorization) = {
      io.vertx.ext.auth.authorization.NotAuthorization.create(authorization)
}  }


  object OrAuthorization {
def create() = {
      io.vertx.ext.auth.authorization.OrAuthorization.create()
}  }


  object PermissionBasedAuthorization {
def create(permission: java.lang.String) = {
      io.vertx.ext.auth.authorization.PermissionBasedAuthorization.create(permission)
}  }


  type PubSecKeyOptions = io.vertx.ext.auth.PubSecKeyOptions
  object PubSecKeyOptions {
    def apply() = new PubSecKeyOptions()
    def apply(json: JsonObject) = new PubSecKeyOptions(json)
  }



  object RoleBasedAuthorization {
def create(role: java.lang.String) = {
      io.vertx.ext.auth.authorization.RoleBasedAuthorization.create(role)
}  }



  /**
    * Represents an authenticates User and contains operations to authorise the user.
    * 
    * Please consult the documentation for a detailed explanation.
    */

  implicit class UserScala(val asJava: io.vertx.ext.auth.User) extends AnyVal {


    /**
     * Like isAuthorized from [[io.vertx.ext.auth.User]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def isAuthorizedFuture(authority: io.vertx.ext.auth.authorization.Authorization) : scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]()
      asJava.isAuthorized(authority, new Handler[AsyncResult[java.lang.Boolean]] { override def handle(event: AsyncResult[java.lang.Boolean]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like isAuthorized from [[io.vertx.ext.auth.User]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def isAuthorizedFuture(authority: java.lang.String) : scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]()
      asJava.isAuthorized(authority, new Handler[AsyncResult[java.lang.Boolean]] { override def handle(event: AsyncResult[java.lang.Boolean]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
  }



  object VertxContextPRNG {
    /**
     * Like current from [[io.vertx.ext.auth.VertxContextPRNG]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def current() = {
      io.vertx.ext.auth.VertxContextPRNG.current()
}
    /**
     * Like current from [[io.vertx.ext.auth.VertxContextPRNG]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def current(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.auth.VertxContextPRNG.current(vertx)
}  }


  object WildcardPermissionBasedAuthorization {
def create(permission: java.lang.String) = {
      io.vertx.ext.auth.authorization.WildcardPermissionBasedAuthorization.create(permission)
}  }


}
