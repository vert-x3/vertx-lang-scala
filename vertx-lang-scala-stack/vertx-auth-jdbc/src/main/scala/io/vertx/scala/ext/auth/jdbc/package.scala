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

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.auth.jdbc.{JDBCAuthentication => JJDBCAuthentication}
import io.vertx.ext.auth.authentication.{AuthenticationProvider => JAuthenticationProvider}
import io.vertx.ext.auth.authentication
import io.vertx.ext.jdbc.{JDBCClient => JJDBCClient}
import io.vertx.ext.jdbc
import io.vertx.ext.auth.jdbc.{JDBCHashStrategy => JJDBCHashStrategy}
import io.vertx.ext.auth.jdbc.{JDBCAuthenticationOptions => JJDBCAuthenticationOptions}
package object jdbc{


  object JDBCAuth {
    /**
     * Like create from [[io.vertx.ext.auth.jdbc.JDBCAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(vertx: io.vertx.core.Vertx,client: io.vertx.ext.jdbc.JDBCClient) = {
      io.vertx.ext.auth.jdbc.JDBCAuth.create(vertx, client)
}  }


  type JDBCAuthOptions = io.vertx.ext.auth.jdbc.JDBCAuthOptions
  object JDBCAuthOptions {
    def apply() = new JDBCAuthOptions()
    def apply(json: JsonObject) = new JDBCAuthOptions(json)
  }



  object JDBCAuthentication {
    /**
     * Like create from [[io.vertx.ext.auth.jdbc.JDBCAuthentication]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(client: io.vertx.ext.jdbc.JDBCClient,hashStrategy: io.vertx.ext.auth.jdbc.JDBCHashStrategy,options: io.vertx.ext.auth.jdbc.JDBCAuthenticationOptions) = {
      io.vertx.ext.auth.jdbc.JDBCAuthentication.create(client, hashStrategy, options)
}
    /**
     * Like create from [[io.vertx.ext.auth.jdbc.JDBCAuthentication]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(client: io.vertx.ext.jdbc.JDBCClient,options: io.vertx.ext.auth.jdbc.JDBCAuthenticationOptions) = {
      io.vertx.ext.auth.jdbc.JDBCAuthentication.create(client, options)
}  }


  type JDBCAuthenticationOptions = io.vertx.ext.auth.jdbc.JDBCAuthenticationOptions
  object JDBCAuthenticationOptions {
    def apply() = new JDBCAuthenticationOptions()
    def apply(json: JsonObject) = new JDBCAuthenticationOptions(json)
  }



  object JDBCAuthorization {
    /**
     * Like create from [[io.vertx.ext.auth.jdbc.JDBCAuthorization]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(providerId: java.lang.String,client: io.vertx.ext.jdbc.JDBCClient,options: io.vertx.ext.auth.jdbc.JDBCAuthorizationOptions) = {
      io.vertx.ext.auth.jdbc.JDBCAuthorization.create(providerId, client, options)
}  }


  type JDBCAuthorizationOptions = io.vertx.ext.auth.jdbc.JDBCAuthorizationOptions
  object JDBCAuthorizationOptions {
    def apply() = new JDBCAuthorizationOptions()
    def apply(json: JsonObject) = new JDBCAuthorizationOptions(json)
  }



  object JDBCHashStrategy {
    /**
     * Like createSHA512 from [[io.vertx.ext.auth.jdbc.JDBCHashStrategy]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def createSHA512(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.auth.jdbc.JDBCHashStrategy.createSHA512(vertx)
}
    /**
     * Like createPBKDF2 from [[io.vertx.ext.auth.jdbc.JDBCHashStrategy]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def createPBKDF2(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.auth.jdbc.JDBCHashStrategy.createPBKDF2(vertx)
}
    /**
     * Like isEqual from [[io.vertx.ext.auth.jdbc.JDBCHashStrategy]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def isEqual(hasha: java.lang.String,hashb: java.lang.String) = {
      io.vertx.ext.auth.jdbc.JDBCHashStrategy.isEqual(hasha, hashb)
}  }



  /**
    * Utility to create users/roles/permissions. This is a helper class and not intended to be a full user
    * management utility. While the standard authentication and authorization interfaces will require usually
    * read only access to the database, in order to use this API a full read/write access must be granted.

    */

  implicit class JDBCUserUtilScala(val asJava: io.vertx.ext.auth.jdbc.JDBCUserUtil) extends AnyVal {


    /**
     * Like createUser from [[io.vertx.ext.auth.jdbc.JDBCUserUtil]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def createUserFuture(username: java.lang.String,password: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.createUser(username, password, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like createHashedUser from [[io.vertx.ext.auth.jdbc.JDBCUserUtil]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def createHashedUserFuture(username: java.lang.String,hash: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.createHashedUser(username, hash, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like createUserRole from [[io.vertx.ext.auth.jdbc.JDBCUserUtil]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def createUserRoleFuture(username: java.lang.String,role: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.createUserRole(username, role, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like createRolePermission from [[io.vertx.ext.auth.jdbc.JDBCUserUtil]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def createRolePermissionFuture(role: java.lang.String,permission: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.createRolePermission(role, permission, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }



}
