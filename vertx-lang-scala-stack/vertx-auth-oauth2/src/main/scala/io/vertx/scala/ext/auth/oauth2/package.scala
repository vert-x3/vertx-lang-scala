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
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.refresh(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like revoke from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def revokeFuture(token_type: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.revoke(token_type, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like logout from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def logoutFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.logout(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like introspect from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def introspectFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.introspect(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like introspect from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def introspectFuture(tokenType: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.introspect(tokenType, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like userInfo from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def userInfoFuture() : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]/*io.vertx.core.json.JsonObject JSON_OBJECT*/()
      asJava.userInfo(new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like fetch from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def fetchFuture(resource: java.lang.String) : scala.concurrent.Future[io.vertx.ext.auth.oauth2.OAuth2Response] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.oauth2.OAuth2Response]/*io.vertx.ext.auth.oauth2.OAuth2Response API*/()
      asJava.fetch(resource, new Handler[AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Response]] { override def handle(event: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like fetch from [[io.vertx.ext.auth.oauth2.AccessToken]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def fetchFuture(method: io.vertx.core.http.HttpMethod, resource: java.lang.String, headers: io.vertx.core.json.JsonObject, payload: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[io.vertx.ext.auth.oauth2.OAuth2Response] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.oauth2.OAuth2Response]/*io.vertx.ext.auth.oauth2.OAuth2Response API*/()
      asJava.fetch(method, resource, headers, payload, new Handler[AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Response]] { override def handle(event: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object AmazonCognitoAuth {
    /**
     * Create a OAuth2Auth provider for Amazon Cognito     * @param region the region to use
     * @param clientId the client id given to you by Amazon Cognito
     * @param clientSecret the client secret given to you by Amazon Cognito
     * @param guid the guid of your application given to you by Amazon Cognito
     */
  def create(vertx: io.vertx.core.Vertx, region: java.lang.String, clientId: java.lang.String, clientSecret: java.lang.String, guid: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.AmazonCognitoAuth.create(vertx, region, clientId, clientSecret, guid)
  }

    /**
     * Create a OAuth2Auth provider for Amazon Cognito     * @param region the region to use
     * @param clientId the client id given to you by Amazon Cognito
     * @param clientSecret the client secret given to you by Amazon Cognito
     * @param userPoolId the userPoolId of your application given to you by Amazon Cognito
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, region: java.lang.String, clientId: java.lang.String, clientSecret: java.lang.String, userPoolId: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.AmazonCognitoAuth.create(vertx, region, clientId, clientSecret, userPoolId, httpClientOptions)
  }

    /**
     * Create a OAuth2Auth provider for OpenID Connect Discovery. The discovery will use the default site in the
     * configuration options and attempt to load the well known descriptor. If a site is provided (for example when
     * running on a custom instance) that site will be used to do the lookup.
     * 
     * If the discovered config includes a json web key url, it will be also fetched and the JWKs will be loaded
     * into the OAuth provider so tokens can be decoded.     * @param vertx the vertx instance
     * @param config the initial config see <a href="../../../../../../../../../cheatsheet/OAuth2Options.html">OAuth2Options</a>
     * @param handler the instantiated Oauth2 provider instance handler
     */
  def discover(vertx: io.vertx.core.Vertx, config: io.vertx.ext.auth.oauth2.OAuth2Options, handler: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth] => Unit) = {
      io.vertx.ext.auth.oauth2.providers.AmazonCognitoAuth.discover(vertx, config, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth]]])
  }
  }


  object AzureADAuth {
    /**
     * Create a OAuth2Auth provider for Microsoft Azure Active Directory     * @param clientId the client id given to you by Azure
     * @param clientSecret the client secret given to you by Azure
     * @param guid the guid of your application given to you by Azure
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, guid: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.AzureADAuth.create(vertx, clientId, clientSecret, guid)
  }

    /**
     * Create a OAuth2Auth provider for Microsoft Azure Active Directory     * @param clientId the client id given to you by Azure
     * @param clientSecret the client secret given to you by Azure
     * @param guid the guid of your application given to you by Azure
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, guid: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.AzureADAuth.create(vertx, clientId, clientSecret, guid, httpClientOptions)
  }

    /**
     * Create a OAuth2Auth provider for OpenID Connect Discovery. The discovery will use the default site in the
     * configuration options and attempt to load the well known descriptor. If a site is provided (for example when
     * running on a custom instance) that site will be used to do the lookup.
     * 
     * If the discovered config includes a json web key url, it will be also fetched and the JWKs will be loaded
     * into the OAuth provider so tokens can be decoded.
     * 
     * With this provider, if the given configuration is using the flow type  then
     * the extra parameters object will include `requested_token_use = on_behalf_of` as required by
     * <a href="https://docs.microsoft.com/en-us/azure/active-directory/develop/v1-oauth2-on-behalf-of-flow">https://docs.microsoft.com/en-us/azure/active-directory</a>.     * @param vertx the vertx instance
     * @param config the initial config see <a href="../../../../../../../../../cheatsheet/OAuth2Options.html">OAuth2Options</a>
     * @param handler the instantiated Oauth2 provider instance handler
     */
  def discover(vertx: io.vertx.core.Vertx, config: io.vertx.ext.auth.oauth2.OAuth2Options, handler: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth] => Unit) = {
      io.vertx.ext.auth.oauth2.providers.AzureADAuth.discover(vertx, config, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth]]])
  }
  }


  object BoxAuth {
    /**
     * Create a OAuth2Auth provider for App.net     * @param clientId the client id given to you by box.com
     * @param clientSecret the client secret given to you by box.com
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.BoxAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for App.net     * @param clientId the client id given to you by box.com
     * @param clientSecret the client secret given to you by box.com
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.BoxAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object CloudFoundryAuth {
    /**
     * Create a OAuth2Auth provider for CloudFoundry UAA     * @param clientId the client id given to you by CloudFoundry UAA
     * @param clientSecret the client secret given to you by CloudFoundry UAA
     * @param uuaURL the url to your UUA server instance
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, uuaURL: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.CloudFoundryAuth.create(vertx, clientId, clientSecret, uuaURL)
  }

    /**
     * Create a OAuth2Auth provider for CloudFoundry UAA     * @param clientId the client id given to you by CloudFoundry UAA
     * @param clientSecret the client secret given to you by CloudFoundry UAA
     * @param uuaURL the url to your UUA server instance
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, uuaURL: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.CloudFoundryAuth.create(vertx, clientId, clientSecret, uuaURL, httpClientOptions)
  }
  }


  object DropboxAuth {
    /**
     * Create a OAuth2Auth provider for Dropbox     * @param clientId the client id given to you by Dropbox
     * @param clientSecret the client secret given to you by Dropbox
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.DropboxAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for Dropbox     * @param clientId the client id given to you by Dropbox
     * @param clientSecret the client secret given to you by Dropbox
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.DropboxAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object FacebookAuth {
    /**
     * Create a OAuth2Auth provider for Facebook     * @param clientId the client id given to you by Facebook
     * @param clientSecret the client secret given to you by Facebook
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.FacebookAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for Facebook     * @param clientId the client id given to you by Facebook
     * @param clientSecret the client secret given to you by Facebook
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.FacebookAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object FoursquareAuth {
    /**
     * Create a OAuth2Auth provider for Foursquare     * @param clientId the client id given to you by Foursquare
     * @param clientSecret the client secret given to you by Foursquare
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.FoursquareAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for Foursquare     * @param clientId the client id given to you by Foursquare
     * @param clientSecret the client secret given to you by Foursquare
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.FoursquareAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object GithubAuth {
    /**
     * Create a OAuth2Auth provider for Github     * @param clientId the client id given to you by Github
     * @param clientSecret the client secret given to you by Github
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.GithubAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for Github     * @param clientId the client id given to you by Github
     * @param clientSecret the client secret given to you by Github
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.GithubAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object GoogleAuth {
    /**
     * Create a OAuth2Auth provider for Google     * @param clientId the client id given to you by Google
     * @param clientSecret the client secret given to you by Google
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.GoogleAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for Google     * @param clientId the client id given to you by Google
     * @param clientSecret the client secret given to you by Google
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.GoogleAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }

    /**
     * Create a OAuth2Auth provider for OpenID Connect Discovery. The discovery will use the default site in the
     * configuration options and attempt to load the well known descriptor. If a site is provided (for example when
     * running on a custom instance) that site will be used to do the lookup.
     * 
     * If the discovered config includes a json web key url, it will be also fetched and the JWKs will be loaded
     * into the OAuth provider so tokens can be decoded.     * @param vertx the vertx instance
     * @param config the initial config see <a href="../../../../../../../../../cheatsheet/OAuth2Options.html">OAuth2Options</a>
     * @param handler the instantiated Oauth2 provider instance handler
     */
  def discover(vertx: io.vertx.core.Vertx, config: io.vertx.ext.auth.oauth2.OAuth2Options, handler: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth] => Unit) = {
      io.vertx.ext.auth.oauth2.providers.GoogleAuth.discover(vertx, config, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth]]])
  }

    /**
     * Create a OAuth2Auth provider for Google Service Account (Server to Server)     * @param serviceAccountJson the configuration json file from your Google API page
     */
  def create(vertx: io.vertx.core.Vertx, serviceAccountJson: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.providers.GoogleAuth.create(vertx, serviceAccountJson)
  }

    /**
     * Create a OAuth2Auth provider for Google Service Account (Server to Server)     * @param serviceAccountJson the configuration json file from your Google API page
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, serviceAccountJson: io.vertx.core.json.JsonObject, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.GoogleAuth.create(vertx, serviceAccountJson, httpClientOptions)
  }
  }


  object HerokuAuth {
    /**
     * Create a OAuth2Auth provider for Heroku     * @param clientId the client id given to you by Heroku
     * @param clientSecret the client secret given to you by Heroku
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.HerokuAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for Heroku     * @param clientId the client id given to you by Heroku
     * @param clientSecret the client secret given to you by Heroku
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.HerokuAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object IBMCloudAuth {
    /**
     * Create a OAuth2Auth provider for IBM Cloud     * @param region the region to use
     * @param clientId the client id given to you by IBM Cloud
     * @param clientSecret the client secret given to you by IBM Cloud
     * @param guid the guid of your application given to you by IBM Cloud
     */
  def create(vertx: io.vertx.core.Vertx, region: java.lang.String, clientId: java.lang.String, clientSecret: java.lang.String, guid: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.IBMCloudAuth.create(vertx, region, clientId, clientSecret, guid)
  }

    /**
     * Create a OAuth2Auth provider for IBM Cloud     * @param region the region to use
     * @param clientId the client id given to you by IBM Cloud
     * @param clientSecret the client secret given to you by IBM Cloud
     * @param guid the guid of your application given to you by IBM Cloud
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, region: java.lang.String, clientId: java.lang.String, clientSecret: java.lang.String, guid: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.IBMCloudAuth.create(vertx, region, clientId, clientSecret, guid, httpClientOptions)
  }

    /**
     * Create a OAuth2Auth provider for OpenID Connect Discovery. The discovery will use the default site in the
     * configuration options and attempt to load the well known descriptor. If a site is provided (for example when
     * running on a custom instance) that site will be used to do the lookup.
     * 
     * If the discovered config includes a json web key url, it will be also fetched and the JWKs will be loaded
     * into the OAuth provider so tokens can be decoded.     * @param vertx the vertx instance
     * @param config the initial config see <a href="../../../../../../../../../cheatsheet/OAuth2Options.html">OAuth2Options</a>
     * @param handler the instantiated Oauth2 provider instance handler
     */
  def discover(vertx: io.vertx.core.Vertx, config: io.vertx.ext.auth.oauth2.OAuth2Options, handler: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth] => Unit) = {
      io.vertx.ext.auth.oauth2.providers.IBMCloudAuth.discover(vertx, config, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth]]])
  }
  }


  object InstagramAuth {
    /**
     * Create a OAuth2Auth provider for Instagram     * @param clientId the client id given to you by Instagram
     * @param clientSecret the client secret given to you by Instagram
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.InstagramAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for Instagram     * @param clientId the client id given to you by Instagram
     * @param clientSecret the client secret given to you by Instagram
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.InstagramAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object KeycloakAuth {
    /**
     * Create a OAuth2Auth provider for Keycloak     * @param config the json config file exported from Keycloak admin console
     */
  def create(vertx: io.vertx.core.Vertx, config: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.providers.KeycloakAuth.create(vertx, config)
  }

    /**
     * Create a OAuth2Auth provider for Keycloak     * @param flow the oauth2 flow to use
     * @param config the json config file exported from Keycloak admin console
     */
  def create(vertx: io.vertx.core.Vertx, flow: io.vertx.ext.auth.oauth2.OAuth2FlowType, config: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.providers.KeycloakAuth.create(vertx, flow, config)
  }

    /**
     * Create a OAuth2Auth provider for Keycloak     * @param config the json config file exported from Keycloak admin console
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, config: io.vertx.core.json.JsonObject, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.KeycloakAuth.create(vertx, config, httpClientOptions)
  }

    /**
     * Create a OAuth2Auth provider for Keycloak     * @param flow the oauth2 flow to use
     * @param config the json config file exported from Keycloak admin console
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, flow: io.vertx.ext.auth.oauth2.OAuth2FlowType, config: io.vertx.core.json.JsonObject, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.KeycloakAuth.create(vertx, flow, config, httpClientOptions)
  }

    /**
     * Create a OAuth2Auth provider for OpenID Connect Discovery. The discovery will use the default site in the
     * configuration options and attempt to load the well known descriptor. If a site is provided (for example when
     * running on a custom instance) that site will be used to do the lookup.
     * 
     * If the discovered config includes a json web key url, it will be also fetched and the JWKs will be loaded
     * into the OAuth provider so tokens can be decoded.     * @param vertx the vertx instance
     * @param config the initial config see <a href="../../../../../../../../../cheatsheet/OAuth2Options.html">OAuth2Options</a>
     * @param handler the instantiated Oauth2 provider instance handler
     */
  def discover(vertx: io.vertx.core.Vertx, config: io.vertx.ext.auth.oauth2.OAuth2Options, handler: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth] => Unit) = {
      io.vertx.ext.auth.oauth2.providers.KeycloakAuth.discover(vertx, config, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth]]])
  }
  }


  object KeycloakAuthorization {
    /**
     * Factory method to create an Authorization Provider for tokens adhering to the Keycloak token format.
     * When the user is known to not be a JWT, (e.g.: a OAuth2 response token) then the root claim
     * is expected to be the extracted from the user  under the key: `accessToken`.     * @return a AuthorizationProvider
     */
  def create() = {
      io.vertx.ext.auth.oauth2.authorization.KeycloakAuthorization.create()
  }
  }


  object KeycloakHelper {
    /**
     * Get raw `id_token` string from the principal.     * @param principal user principal
     * @return the raw id token string
     */
  def rawIdToken(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.rawIdToken(principal)
  }

    /**
     * Get decoded `id_token` from the principal.     * @param principal user principal
     * @return the id token
     */
  def idToken(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.idToken(principal)
  }

    /**
     * Get raw `access_token` string from the principal.     * @param principal user principal
     * @return the raw access token string
     */
  def rawAccessToken(principal: io.vertx.core.json.JsonObject) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.rawAccessToken(principal)
  }

    /**
     * Get decoded `access_token` from the principal.     * @param principal user principal
     * @return the access token
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
     * Parse the token string with base64 decoder.
     * This will only obtain the "payload" part of the token.     * @param token token string
     * @return token payload json object
     */
  def parseToken(token: java.lang.String) = {
      io.vertx.ext.auth.oauth2.KeycloakHelper.parseToken(token)
  }
  }


  object KeycloakRBAC {
    /**
     * Factory method to create a RBAC handler for tokens adhering to the Keycloak token format.     * @return a RBAC validator
     */
  def create(options: io.vertx.ext.auth.oauth2.OAuth2Options) = {
      io.vertx.ext.auth.oauth2.rbac.KeycloakRBAC.create(options)
  }
  }


  object LinkedInAuth {
    /**
     * Create a OAuth2Auth provider for LinkedIn     * @param clientId the client id given to you by LinkedIn
     * @param clientSecret the client secret given to you by LinkedIn
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.LinkedInAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for LinkedIn     * @param clientId the client id given to you by LinkedIn
     * @param clientSecret the client secret given to you by LinkedIn
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.LinkedInAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object LiveAuth {
    /**
     * Create a OAuth2Auth provider for live.com     * @param clientId the client id given to you by live.com
     * @param clientSecret the client secret given to you by live.com
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.LiveAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for live.com     * @param clientId the client id given to you by live.com
     * @param clientSecret the client secret given to you by live.com
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.LiveAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object MailchimpAuth {
    /**
     * Create a OAuth2Auth provider for Mailchimp     * @param clientId the client id given to you by Mailchimp
     * @param clientSecret the client secret given to you by Mailchimp
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.MailchimpAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for Mailchimp     * @param clientId the client id given to you by Mailchimp
     * @param clientSecret the client secret given to you by Mailchimp
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.MailchimpAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object MicroProfileRBAC {
    /**
     * Factory method to create a RBAC handler for tokens adhering to the MP-JWT 1.1 spec.     * @return a RBAC validator
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
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.jWKSet(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like refresh from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def refreshFuture(user: io.vertx.ext.auth.User) : scala.concurrent.Future[io.vertx.ext.auth.User] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.User]/*io.vertx.ext.auth.User API*/()
      asJava.refresh(user, new Handler[AsyncResult[io.vertx.ext.auth.User]] { override def handle(event: AsyncResult[io.vertx.ext.auth.User]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like revoke from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def revokeFuture(user: io.vertx.ext.auth.User, tokenType: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.revoke(user, tokenType, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like revoke from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def revokeFuture(user: io.vertx.ext.auth.User) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.revoke(user, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like userInfo from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def userInfoFuture(user: io.vertx.ext.auth.User) : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]/*io.vertx.core.json.JsonObject JSON_OBJECT*/()
      asJava.userInfo(user, new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like decodeToken from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def decodeTokenFuture(token: java.lang.String) : scala.concurrent.Future[io.vertx.ext.auth.oauth2.AccessToken] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.oauth2.AccessToken]/*io.vertx.ext.auth.oauth2.AccessToken API*/()
      asJava.decodeToken(token, new Handler[AsyncResult[io.vertx.ext.auth.oauth2.AccessToken]] { override def handle(event: AsyncResult[io.vertx.ext.auth.oauth2.AccessToken]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like introspectToken from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def introspectTokenFuture(token: java.lang.String) : scala.concurrent.Future[io.vertx.ext.auth.oauth2.AccessToken] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.oauth2.AccessToken]/*io.vertx.ext.auth.oauth2.AccessToken API*/()
      asJava.introspectToken(token, new Handler[AsyncResult[io.vertx.ext.auth.oauth2.AccessToken]] { override def handle(event: AsyncResult[io.vertx.ext.auth.oauth2.AccessToken]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like introspectToken from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def introspectTokenFuture(token: java.lang.String, tokenType: java.lang.String) : scala.concurrent.Future[io.vertx.ext.auth.oauth2.AccessToken] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.oauth2.AccessToken]/*io.vertx.ext.auth.oauth2.AccessToken API*/()
      asJava.introspectToken(token, tokenType, new Handler[AsyncResult[io.vertx.ext.auth.oauth2.AccessToken]] { override def handle(event: AsyncResult[io.vertx.ext.auth.oauth2.AccessToken]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like loadJWK from [[io.vertx.ext.auth.oauth2.OAuth2Auth]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def loadJWKFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.loadJWK(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


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
  def isAuthorizedFuture(user: io.vertx.ext.auth.oauth2.AccessToken, authority: java.lang.String) : scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]/*java.lang.Boolean BOXED_PRIMITIVE*/()
      asJava.isAuthorized(user, authority, new Handler[AsyncResult[java.lang.Boolean]] { override def handle(event: AsyncResult[java.lang.Boolean]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }





  type Oauth2Credentials = io.vertx.ext.auth.oauth2.Oauth2Credentials
  object Oauth2Credentials {
    def apply() = new Oauth2Credentials()
    def apply(json: JsonObject) = new Oauth2Credentials(json)
  }



  object OpenIDConnectAuth {
    /**
     * Create a OAuth2Auth provider for OpenID Connect Discovery. The discovery will use the given site in the
     * configuration options and attempt to load the well known descriptor.
     * 
     * If the discovered config includes a json web key url, it will be also fetched and the JWKs will be loaded
     * into the OAuth provider so tokens can be decoded.     * @param vertx the vertx instance
     * @param config the initial config, it should contain a site url see <a href="../../../../../../../../../cheatsheet/OAuth2Options.html">OAuth2Options</a>
     * @param handler the instantiated Oauth2 provider instance handler
     */
  def discover(vertx: io.vertx.core.Vertx, config: io.vertx.ext.auth.oauth2.OAuth2Options, handler: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth] => Unit) = {
      io.vertx.ext.auth.oauth2.providers.OpenIDConnectAuth.discover(vertx, config, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth]]])
  }
  }


  object SalesforceAuth {
    /**
     * Create a OAuth2Auth provider for Salesforce     * @param clientId the client id given to you by Salesforce
     * @param clientSecret the client secret given to you by Salesforce
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.SalesforceAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for Salesforce     * @param clientId the client id given to you by Salesforce
     * @param clientSecret the client secret given to you by Salesforce
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.SalesforceAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }

    /**
     * Create a OAuth2Auth provider for OpenID Connect Discovery. The discovery will use the default site in the
     * configuration options and attempt to load the well known descriptor. If a site is provided (for example when
     * running on a custom instance) that site will be used to do the lookup.
     * 
     * If the discovered config includes a json web key url, it will be also fetched and the JWKs will be loaded
     * into the OAuth provider so tokens can be decoded.     * @param vertx the vertx instance
     * @param config the initial config see <a href="../../../../../../../../../cheatsheet/OAuth2Options.html">OAuth2Options</a>
     * @param handler the instantiated Oauth2 provider instance handler
     */
  def discover(vertx: io.vertx.core.Vertx, config: io.vertx.ext.auth.oauth2.OAuth2Options, handler: AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth] => Unit) = {
      io.vertx.ext.auth.oauth2.providers.SalesforceAuth.discover(vertx, config, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Auth]]])
  }
  }


  object ScopeAuthorization {
    /**
     * Factory method to create a Authorization provider for Oauth 2.0 scopes.     * @param scopeSeparator the scope separator e.g.: `" "`, `","`, `"+"`
     * @return a AuthorizationProvider
     */
  def create(scopeSeparator: java.lang.String) = {
      io.vertx.ext.auth.oauth2.authorization.ScopeAuthorization.create(scopeSeparator)
  }
  }


  object ShopifyAuth {
    /**
     * Create a OAuth2Auth provider for Shopify     * @param clientId the client id given to you by Shopify
     * @param clientSecret the client secret given to you by Shopify
     * @param shop your shop name
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, shop: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.ShopifyAuth.create(vertx, clientId, clientSecret, shop)
  }

    /**
     * Create a OAuth2Auth provider for Shopify     * @param clientId the client id given to you by Shopify
     * @param clientSecret the client secret given to you by Shopify
     * @param shop your shop name
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, shop: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.ShopifyAuth.create(vertx, clientId, clientSecret, shop, httpClientOptions)
  }
  }


  object SoundcloudAuth {
    /**
     * Create a OAuth2Auth provider for SoundCloud     * @param clientId the client id given to you by SoundCloud
     * @param clientSecret the client secret given to you by SoundCloud
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.SoundcloudAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for SoundCloud     * @param clientId the client id given to you by SoundCloud
     * @param clientSecret the client secret given to you by SoundCloud
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.SoundcloudAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object StripeAuth {
    /**
     * Create a OAuth2Auth provider for Stripe     * @param clientId the client id given to you by Stripe
     * @param clientSecret the client secret given to you by Stripe
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.StripeAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for Stripe     * @param clientId the client id given to you by Stripe
     * @param clientSecret the client secret given to you by Stripe
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.StripeAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


  object TwitterAuth {
    /**
     * Create a OAuth2Auth provider for Twitter     * @param clientId the client id given to you by Twitter
     * @param clientSecret the client secret given to you by Twitter
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String) = {
      io.vertx.ext.auth.oauth2.providers.TwitterAuth.create(vertx, clientId, clientSecret)
  }

    /**
     * Create a OAuth2Auth provider for Twitter     * @param clientId the client id given to you by Twitter
     * @param clientSecret the client secret given to you by Twitter
     * @param httpClientOptions custom http client options see <a href="../../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
     */
  def create(vertx: io.vertx.core.Vertx, clientId: java.lang.String, clientSecret: java.lang.String, httpClientOptions: io.vertx.core.http.HttpClientOptions) = {
      io.vertx.ext.auth.oauth2.providers.TwitterAuth.create(vertx, clientId, clientSecret, httpClientOptions)
  }
  }


}
