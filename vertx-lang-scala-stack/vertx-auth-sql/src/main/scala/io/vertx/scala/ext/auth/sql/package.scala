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

import io.vertx.sqlclient
import io.vertx.sqlclient.{SqlClient => JSqlClient}
import io.vertx.core
import io.vertx.core.{Future => JFuture}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.auth.sql.{SqlUserUtil => JSqlUserUtil}
package object sql{


  object SqlAuthentication {
    /**
     * Create a JDBC auth provider implementation     * @param client the JDBC client instance
     * @return the auth provider
     */
  def create(client: io.vertx.sqlclient.SqlClient) = {
      io.vertx.ext.auth.sql.SqlAuthentication.create(client)
  }

    /**
     * Create a JDBC auth provider implementation     * @param client the JDBC client instance
     * @param options authentication options see <a href="../../../../../../../../cheatsheet/SqlAuthenticationOptions.html">SqlAuthenticationOptions</a>
     * @return the auth provider
     */
  def create(client: io.vertx.sqlclient.SqlClient, options: io.vertx.ext.auth.sql.SqlAuthenticationOptions) = {
      io.vertx.ext.auth.sql.SqlAuthentication.create(client, options)
  }
  }


  type SqlAuthenticationOptions = io.vertx.ext.auth.sql.SqlAuthenticationOptions
  object SqlAuthenticationOptions {
    def apply() = new SqlAuthenticationOptions()
    def apply(json: JsonObject) = new SqlAuthenticationOptions(json)
  }



  object SqlAuthorization {
    /**
     * Create a JDBC authorization provider implementation     * @param client the SQL client instance
     * @return the auth provider
     */
  def create(client: io.vertx.sqlclient.SqlClient) = {
      io.vertx.ext.auth.sql.SqlAuthorization.create(client)
  }

    /**
     * Create a JDBC authorization provider implementation     * @param client the SQL client instance
     * @param options the SqlAuthorizationOptions see <a href="../../../../../../../../cheatsheet/SqlAuthorizationOptions.html">SqlAuthorizationOptions</a>
     * @return the auth provider
     */
  def create(client: io.vertx.sqlclient.SqlClient, options: io.vertx.ext.auth.sql.SqlAuthorizationOptions) = {
      io.vertx.ext.auth.sql.SqlAuthorization.create(client, options)
  }
  }


  type SqlAuthorizationOptions = io.vertx.ext.auth.sql.SqlAuthorizationOptions
  object SqlAuthorizationOptions {
    def apply() = new SqlAuthorizationOptions()
    def apply(json: JsonObject) = new SqlAuthorizationOptions(json)
  }




  /**
    * Utility to create users/roles/permissions. This is a helper class and not intended to be a full user
    * management utility. While the standard authentication and authorization interfaces will require usually
    * read only access to the database, in order to use this API a full read/write access must be granted.

    */

  implicit class SqlUserUtilScala(val asJava: io.vertx.ext.auth.sql.SqlUserUtil) extends AnyVal {


    /**
     * Like createUser from [[io.vertx.ext.auth.sql.SqlUserUtil]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createUserFuture(username: java.lang.String, password: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.createUser(username, password, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createHashedUser from [[io.vertx.ext.auth.sql.SqlUserUtil]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createHashedUserFuture(username: java.lang.String, hash: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.createHashedUser(username, hash, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createUserRole from [[io.vertx.ext.auth.sql.SqlUserUtil]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createUserRoleFuture(username: java.lang.String, role: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.createUserRole(username, role, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createRolePermission from [[io.vertx.ext.auth.sql.SqlUserUtil]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createRolePermissionFuture(role: java.lang.String, permission: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.createRolePermission(role, permission, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



}
