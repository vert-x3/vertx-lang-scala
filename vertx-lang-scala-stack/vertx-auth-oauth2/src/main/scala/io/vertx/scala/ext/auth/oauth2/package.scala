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

import io.vertx.ext.auth
import io.vertx.core.buffer.Buffer
import io.vertx.ext.auth.oauth2.{AccessToken => JAccessToken}
import io.vertx.core
import io.vertx.core.http.{HttpMethod => JHttpMethod}
import io.vertx.core.{Future => JFuture}
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.auth.oauth2.{OAuth2Response => JOAuth2Response}
import io.vertx.core.http
package object oauth2{



  /**
    * AccessToken extension to the User interface
    */

  implicit class AccessTokenScala(val asJava: io.vertx.ext.auth.oauth2.AccessToken) extends AnyVal {


    /**
     * Like refresh from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def refreshFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.refresh(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like revoke from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def revokeFuture(token_type: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.revoke(token_type, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like logout from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def logoutFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.logout(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like introspect from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def introspectFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.introspect(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like introspect from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def introspectFuture(tokenType: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.introspect(tokenType, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like userInfo from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def userInfoFuture() : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]()
      asJava.userInfo(new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like fetch from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def fetchFuture(resource: java.lang.String) : scala.concurrent.Future[io.vertx.ext.auth.oauth2.OAuth2Response] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.oauth2.OAuth2Response]()
      asJava.fetch(resource, new Handler[AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Response]] { override def handle(event: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like fetch from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def fetchFuture(method: io.vertx.core.http.HttpMethod,resource: java.lang.String,headers: io.vertx.core.json.JsonObject,payload: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.ext.auth.oauth2.OAuth2Response] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.oauth2.OAuth2Response]()
      asJava.fetch(method, resource, headers, payload, new Handler[AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Response]] { override def handle(event: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  }



  object AzureADAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.AzureADAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, guid: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.AzureADAuth.create(vertx, clientId, clientSecret, guid)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.AzureADAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, guid: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.AzureADAuth.create(vertx, clientId, clientSecret, guid, httpClientOptions)
  }

    /**
     * Like discover from [[io.vertx.ext.auth.oauth2.providers.AzureADAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def discover(vertx: io.vertx.core.Vertx, config: io.vertx.ext.auth.oauth2.OAuth2Options, handler: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth] => Unit) = {
      io.vertx.ext.auth.oauth2.providers.AzureADAuth.discover(vertx, config, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth]]])
  }
  }


  object BoxAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.BoxAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.BoxAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.BoxAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.BoxAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object CloudFoundryAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.CloudFoundryAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, uuaURL: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.CloudFoundryAuth.create(vertx, clientId, clientSecret, uuaURL)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.CloudFoundryAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, uuaURL: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.CloudFoundryAuth.create(vertx, clientId, clientSecret, uuaURL, httpClientOptions)
  }
  }


  object DropboxAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.DropboxAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.DropboxAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.DropboxAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.DropboxAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object FacebookAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.FacebookAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.FacebookAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.FacebookAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.FacebookAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object FoursquareAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.FoursquareAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.FoursquareAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.FoursquareAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.FoursquareAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object GithubAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.GithubAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.GithubAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.GithubAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.GithubAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object GoogleAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.GoogleAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.GoogleAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.GoogleAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.GoogleAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }

    /**
     * Like discover from [[io.vertx.ext.auth.oauth2.providers.GoogleAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def discover(vertx: io.vertx.core.Vertx, config: io.vertx.ext.auth.oauth2.OAuth2Options, handler: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth] => Unit) = {
      io.vertx.ext.auth.oauth2.providers.GoogleAuth.discover(vertx, config, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth]]])
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.GoogleAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, serviceAccountJson: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.providers.GoogleAuth.create(vertx, serviceAccountJson)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.GoogleAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, serviceAccountJson: io.vertx.core.json.JsonObject, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.GoogleAuth.create(vertx, serviceAccountJson, httpClientOptions)
  }
  }


  object HerokuAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.HerokuAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.HerokuAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.HerokuAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.HerokuAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object InstagramAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.InstagramAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.InstagramAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.InstagramAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.InstagramAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object KeycloakAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.KeycloakAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, config: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.providers.KeycloakAuth.create(vertx, config)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.KeycloakAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, flow: io.vertx.ext.auth.oauth2.OAuth2FlowType, config: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.providers.KeycloakAuth.create(vertx, flow, config)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.KeycloakAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, config: io.vertx.core.json.JsonObject, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.KeycloakAuth.create(vertx, config, httpClientOptions)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.KeycloakAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, flow: io.vertx.ext.auth.oauth2.OAuth2FlowType, config: io.vertx.core.json.JsonObject, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.KeycloakAuth.create(vertx, flow, config, httpClientOptions)
  }

    /**
     * Like discover from [[io.vertx.ext.auth.oauth2.providers.KeycloakAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def discover(vertx: io.vertx.core.Vertx, config: io.vertx.ext.auth.oauth2.OAuth2Options, handler: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth] => Unit) = {
      io.vertx.ext.auth.oauth2.providers.KeycloakAuth.discover(vertx, config, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth]]])
  }
  }


  object KeycloakAuthorization {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.authorization.KeycloakAuthorization]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create() = {
      io.vertx.ext.auth.oauth2.authorization.KeycloakAuthorization.create()
  }
  }


  object KeycloakHelper {
    /**
     * Like rawIdToken from [[io.vertx.ext.auth.oauth2.KeycloakHelper]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def rawIdToken(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.rawIdToken(principal)
  }

    /**
     * Like idToken from [[io.vertx.ext.auth.oauth2.KeycloakHelper]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def idToken(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.idToken(principal)
  }

    /**
     * Like rawAccessToken from [[io.vertx.ext.auth.oauth2.KeycloakHelper]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def rawAccessToken(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.rawAccessToken(principal)
  }

    /**
     * Like accessToken from [[io.vertx.ext.auth.oauth2.KeycloakHelper]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def accessToken(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.accessToken(principal)
  }

  def authTime(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.authTime(principal)
  }

  def sessionState(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.sessionState(principal)
  }

  def acr(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.acr(principal)
  }

  def name(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.name(principal)
  }

  def email(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.email(principal)
  }

  def preferredUsername(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.preferredUsername(principal)
  }

  def nickName(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.nickName(principal)
  }

  def allowedOrigins(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.allowedOrigins(principal)
  }

    /**
     * Like parseToken from [[io.vertx.ext.auth.oauth2.KeycloakHelper]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def parseToken(token: java.lang.String) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.parseToken(token)
  }
  }


  object KeycloakRBAC {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.rbac.KeycloakRBAC]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(options: io.vertx.ext.auth.oauth2.OAuth2Options) = {
      io.vertx.ext.auth.oauth2.rbac.KeycloakRBAC.create(options)
  }
  }


  object LinkedInAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.LinkedInAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.LinkedInAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.LinkedInAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.LinkedInAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object LiveAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.LiveAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.LiveAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.LiveAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.LiveAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object MailchimpAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.MailchimpAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.MailchimpAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.MailchimpAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.MailchimpAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object MicroProfileRBAC {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.rbac.MicroProfileRBAC]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create() = {
      io.vertx.ext.auth.oauth2.rbac.MicroProfileRBAC.create()
  }
  }



  /**
    * Factory interface for creating OAuth2 based [[io.vertx.ext.auth.authentication.AuthenticationProvider]] instances.
    */

  implicit class OAuth2AuthScala(val asJava: io.vertx.ext.auth.oauth2.OAuth2Auth) extends AnyVal {


    /**
     * Like jWKSet from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def jWKSetFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.jWKSet(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like refresh from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def refreshFuture(user: io.vertx.ext.auth.User) : scala.concurrent.Future[io.vertx.ext.auth.User] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.User]()
      asJava.refresh(user, new Handler[AsyncResult[io.vertx.ext.auth.User]] { override def handle(event: AsyncResult[io.vertx.ext.auth.User]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like revoke from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def revokeFuture(user: io.vertx.ext.auth.User,tokenType: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.revoke(user, tokenType, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like revoke from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def revokeFuture(user: io.vertx.ext.auth.User) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.revoke(user, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like userInfo from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def userInfoFuture(user: io.vertx.ext.auth.User) : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]()
      asJava.userInfo(user, new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like decodeToken from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def decodeTokenFuture(token: java.lang.String) : scala.concurrent.Future[io.vertx.ext.auth.oauth2.AccessToken] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.oauth2.AccessToken]()
      asJava.decodeToken(token, new Handler[AsyncResult[io.vertx.ext.auth.oauth2.AccessToken]] { override def handle(event: AsyncResult[io.vertx.ext.auth.oauth2.AccessToken]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like introspectToken from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def introspectTokenFuture(token: java.lang.String) : scala.concurrent.Future[io.vertx.ext.auth.oauth2.AccessToken] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.oauth2.AccessToken]()
      asJava.introspectToken(token, new Handler[AsyncResult[io.vertx.ext.auth.oauth2.AccessToken]] { override def handle(event: AsyncResult[io.vertx.ext.auth.oauth2.AccessToken]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like introspectToken from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def introspectTokenFuture(token: java.lang.String,tokenType: java.lang.String) : scala.concurrent.Future[io.vertx.ext.auth.oauth2.AccessToken] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.oauth2.AccessToken]()
      asJava.introspectToken(token, tokenType, new Handler[AsyncResult[io.vertx.ext.auth.oauth2.AccessToken]] { override def handle(event: AsyncResult[io.vertx.ext.auth.oauth2.AccessToken]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like loadJWK from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def loadJWKFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.loadJWK(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  }



  type OAuth2ClientOptions = io.vertx.ext.auth.oauth2.OAuth2ClientOptions
  object OAuth2ClientOptions {
    def apply() = new OAuth2ClientOptions()
    def apply(json: JsonObject) = new OAuth2ClientOptions(json)
  }



  type OAuth2Options = io.vertx.ext.auth.oauth2.OAuth2Options
  object OAuth2Options {
    def apply() = new OAuth2Options()
    def apply(json: JsonObject) = new OAuth2Options(json)
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
     * Like isAuthorized from [[io.vertx.ext.auth.oauth2.OAuth2RBAC]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def isAuthorizedFuture(user: io.vertx.ext.auth.oauth2.AccessToken,authority: java.lang.String) : scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]()
      asJava.isAuthorized(user, authority, new Handler[AsyncResult[java.lang.Boolean]] { override def handle(event: AsyncResult[java.lang.Boolean]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  }





  object OpenIDConnectAuth {
    /**
     * Like discover from [[io.vertx.ext.auth.oauth2.providers.OpenIDConnectAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def discover(vertx: io.vertx.core.Vertx, config: io.vertx.ext.auth.oauth2.OAuth2Options, handler: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth] => Unit) = {
      io.vertx.ext.auth.oauth2.providers.OpenIDConnectAuth.discover(vertx, config, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth]]])
  }
  }


  object SalesforceAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.SalesforceAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.SalesforceAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.SalesforceAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.SalesforceAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }

    /**
     * Like discover from [[io.vertx.ext.auth.oauth2.providers.SalesforceAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def discover(vertx: io.vertx.core.Vertx, config: io.vertx.ext.auth.oauth2.OAuth2Options, handler: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth] => Unit) = {
      io.vertx.ext.auth.oauth2.providers.SalesforceAuth.discover(vertx, config, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth]]])
  }
  }


  object ScopeAuthorization {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.authorization.ScopeAuthorization]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(scopeSeparator: java.lang.String) = {
      io.vertx.ext.auth.oauth2.authorization.ScopeAuthorization.create(scopeSeparator)
  }
  }


  object ShopifyAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.ShopifyAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, shop: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.ShopifyAuth.create(vertx, clientId, clientSecret, shop)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.ShopifyAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, shop: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.ShopifyAuth.create(vertx, clientId, clientSecret, shop, httpClientOptions)
  }
  }


  object SoundcloudAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.SoundcloudAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.SoundcloudAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.SoundcloudAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.SoundcloudAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object StripeAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.StripeAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.StripeAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.StripeAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.StripeAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object TwitterAuth {
    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.TwitterAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.TwitterAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Like create from [[io.vertx.ext.auth.oauth2.providers.TwitterAuth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.TwitterAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


}
