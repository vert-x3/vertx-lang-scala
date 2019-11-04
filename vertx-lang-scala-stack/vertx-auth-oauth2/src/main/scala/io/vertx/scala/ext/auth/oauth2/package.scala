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
import io.vertx.core.buffer.Buffer
import io.vertx.ext.auth.oauth2.{AccessToken => JAccessToken}
import io.vertx.core
import io.vertx.core.http.HttpMethod
import io.vertx.core.{Future => JFuture}
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.auth.oauth2.{OAuth2Response => JOAuth2Response}

package object oauth2{


  /**
    * AccessToken extension to the User interface
    */

  implicit class AccessTokenScala(val asJava: io.vertx.ext.auth.oauth2.AccessToken) extends AnyVal {

    /**
     * Like [[refresh]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def refreshFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.refresh({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[revoke]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def revokeFuture(token_type: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.revoke(token_type, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[logout]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def logoutFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.logout({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[introspect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def introspectFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.introspect({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[introspect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def introspectFuture(tokenType: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.introspect(tokenType, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[userInfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def userInfoFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.userInfo({a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[fetch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def fetchFuture(resource: java.lang.String): scala.concurrent.Future[io.vertx.ext.auth.oauth2.OAuth2Response] = {
      val promise = Promise[io.vertx.ext.auth.oauth2.OAuth2Response]()
      asJava.fetch(resource, {a:AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[fetch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def fetchFuture(method: io.vertx.core.http.HttpMethod,resource: java.lang.String,headers: io.vertx.core.json.JsonObject,payload: io.vertx.core.buffer.Buffer): scala.concurrent.Future[io.vertx.ext.auth.oauth2.OAuth2Response] = {
      val promise = Promise[io.vertx.ext.auth.oauth2.OAuth2Response]()
      asJava.fetch(method, resource, headers, payload, {a:AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  type AzureADAuth = io.vertx.ext.auth.oauth2.providers.AzureADAuth


  type BoxAuth = io.vertx.ext.auth.oauth2.providers.BoxAuth


  type CloudFoundryAuth = io.vertx.ext.auth.oauth2.providers.CloudFoundryAuth


  type DropboxAuth = io.vertx.ext.auth.oauth2.providers.DropboxAuth


  type FacebookAuth = io.vertx.ext.auth.oauth2.providers.FacebookAuth


  type FoursquareAuth = io.vertx.ext.auth.oauth2.providers.FoursquareAuth


  type GithubAuth = io.vertx.ext.auth.oauth2.providers.GithubAuth


  type GoogleAuth = io.vertx.ext.auth.oauth2.providers.GoogleAuth


  type HerokuAuth = io.vertx.ext.auth.oauth2.providers.HerokuAuth


  type InstagramAuth = io.vertx.ext.auth.oauth2.providers.InstagramAuth


  type KeycloakAuth = io.vertx.ext.auth.oauth2.providers.KeycloakAuth


  type KeycloakHelper = io.vertx.ext.auth.oauth2.KeycloakHelper


  type KeycloakRBAC = io.vertx.ext.auth.oauth2.rbac.KeycloakRBAC


  type LinkedInAuth = io.vertx.ext.auth.oauth2.providers.LinkedInAuth


  type LiveAuth = io.vertx.ext.auth.oauth2.providers.LiveAuth


  type MailchimpAuth = io.vertx.ext.auth.oauth2.providers.MailchimpAuth


  type MicroProfileRBAC = io.vertx.ext.auth.oauth2.rbac.MicroProfileRBAC



  /**
    * Factory interface for creating OAuth2 based [[io.vertx.ext.auth.AuthProvider]] instances.
    */

  implicit class OAuth2AuthScala(val asJava: io.vertx.ext.auth.oauth2.OAuth2Auth) extends AnyVal {

    /**
     * Like [[decodeToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def decodeTokenFuture(token: java.lang.String): scala.concurrent.Future[io.vertx.ext.auth.oauth2.AccessToken] = {
      val promise = Promise[io.vertx.ext.auth.oauth2.AccessToken]()
      asJava.decodeToken(token, {a:AsyncResult[io.vertx.ext.auth.oauth2.AccessToken] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[introspectToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def introspectTokenFuture(token: java.lang.String): scala.concurrent.Future[io.vertx.ext.auth.oauth2.AccessToken] = {
      val promise = Promise[io.vertx.ext.auth.oauth2.AccessToken]()
      asJava.introspectToken(token, {a:AsyncResult[io.vertx.ext.auth.oauth2.AccessToken] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[introspectToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def introspectTokenFuture(token: java.lang.String,tokenType: java.lang.String): scala.concurrent.Future[io.vertx.ext.auth.oauth2.AccessToken] = {
      val promise = Promise[io.vertx.ext.auth.oauth2.AccessToken]()
      asJava.introspectToken(token, tokenType, {a:AsyncResult[io.vertx.ext.auth.oauth2.AccessToken] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[loadJWK]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def loadJWKFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.loadJWK({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type OAuth2ClientOptions = io.vertx.ext.auth.oauth2.OAuth2ClientOptions
  object OAuth2ClientOptions {
    def apply() = new OAuth2ClientOptions()
    def apply(json: JsonObject) = new OAuth2ClientOptions(json)
  }




  /**
    * Functional interface that allows users to implement custom RBAC verifiers for OAuth2/OpenId Connect.
    *
    * Users are to implement the <code>isAuthorized</code> method to verify authorities. For provides that do not
    * export the permissions/roles in the token, this interface allows you to communicate with 3rd party services
    * such as graph APIs to collect the required data.
    *
    * The contract is that once an authority is checked for a given user, it's value is cached during the execution
    * of the request. If a user is stored to a persistent storage, or the token is introspected, the cache is cleared
    * and a new call will be handled to the implementation.

    */

  implicit class OAuth2RBACScala(val asJava: io.vertx.ext.auth.oauth2.OAuth2RBAC) extends AnyVal {

    /**
     * Like [[isAuthorized]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def isAuthorizedFuture(user: io.vertx.ext.auth.oauth2.AccessToken,authority: java.lang.String): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.isAuthorized(user, authority, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  type OAuth2Response = io.vertx.ext.auth.oauth2.OAuth2Response


  type OpenIDConnectAuth = io.vertx.ext.auth.oauth2.providers.OpenIDConnectAuth


  type SalesforceAuth = io.vertx.ext.auth.oauth2.providers.SalesforceAuth


  type ShopifyAuth = io.vertx.ext.auth.oauth2.providers.ShopifyAuth


  type SoundcloudAuth = io.vertx.ext.auth.oauth2.providers.SoundcloudAuth


  type StripeAuth = io.vertx.ext.auth.oauth2.providers.StripeAuth


  type TwitterAuth = io.vertx.ext.auth.oauth2.providers.TwitterAuth


}
