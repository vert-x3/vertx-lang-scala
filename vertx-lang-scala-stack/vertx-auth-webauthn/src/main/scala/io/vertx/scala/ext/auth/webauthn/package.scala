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

import io.vertx.ext.auth.webauthn.{CredentialStore => JCredentialStore}
import io.vertx.core
import io.vertx.core.{Future => JFuture}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler

package object webauthn{


  /**
    * Generic interface to fetch user related information from a server backend.
    *
    * All methods of this interface are optional.
    */

  implicit class CredentialStoreScala(val asJava: io.vertx.ext.auth.webauthn.CredentialStore) extends AnyVal {

    /**
     * Like getUserCredentialsByName from [[io.vertx.ext.auth.webauthn.CredentialStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def getUserCredentialsByNameFuture(username: java.lang.String): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[java.util.List[io.vertx.core.json.JsonObject]]()
      asJava.getUserCredentialsByName(username, {a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like getUserCredentialsById from [[io.vertx.ext.auth.webauthn.CredentialStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def getUserCredentialsByIdFuture(rawId: java.lang.String): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[java.util.List[io.vertx.core.json.JsonObject]]()
      asJava.getUserCredentialsById(rawId, {a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like updateUserCredential from [[io.vertx.ext.auth.webauthn.CredentialStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def updateUserCredentialFuture(id: java.lang.String,data: io.vertx.core.json.JsonObject,upsert: java.lang.Boolean): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.updateUserCredential(id, data, upsert, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type RelayParty = io.vertx.ext.auth.webauthn.RelayParty
  object RelayParty {
    def apply() = new RelayParty()
    def apply(json: JsonObject) = new RelayParty(json)
  }




  /**
    * Factory interface for creating WebAuthN based [[io.vertx.ext.auth.authentication.AuthenticationProvider]] instances.
    */

  implicit class WebAuthnScala(val asJava: io.vertx.ext.auth.webauthn.WebAuthn) extends AnyVal {


    /**
     * Like getCredentialsOptions from [[io.vertx.ext.auth.webauthn.WebAuthn]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def getCredentialsOptions(username: scala.Option[java.lang.String],handler: AsyncResult[io.vertx.core.json.JsonObject] => Unit): io.vertx.ext.auth.webauthn.WebAuthn = {
      asJava.getCredentialsOptions(username.orNull, {p:AsyncResult[io.vertx.core.json.JsonObject] => handler(p)})
    }

    /**
     * Like createCredentialsOptions from [[io.vertx.ext.auth.webauthn.WebAuthn]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def createCredentialsOptionsFuture(user: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]()
      asJava.createCredentialsOptions(user, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like getCredentialsOptions from [[io.vertx.ext.auth.webauthn.WebAuthn]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def getCredentialsOptionsFuture(username: scala.Option[java.lang.String]): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]()
      asJava.getCredentialsOptions(username, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def authenticateFuture(authInfo: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.ext.auth.User] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.User]()
      asJava.authenticate(authInfo, {a:AsyncResult[io.vertx.ext.auth.User] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type WebAuthnInfo = io.vertx.ext.auth.webauthn.WebAuthnInfo
  object WebAuthnInfo {
    def apply() = new WebAuthnInfo()
    def apply(json: JsonObject) = new WebAuthnInfo(json)
  }




  type WebAuthnOptions = io.vertx.ext.auth.webauthn.WebAuthnOptions
  object WebAuthnOptions {
    def apply() = new WebAuthnOptions()
    def apply(json: JsonObject) = new WebAuthnOptions(json)
  }



}
