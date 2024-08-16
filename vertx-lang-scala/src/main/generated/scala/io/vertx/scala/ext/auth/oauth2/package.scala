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

import io.vertx.ext.auth.{JWTOptions => JJWTOptions}
import io.vertx.ext.auth
import io.vertx.ext.auth.{PubSecKeyOptions => JPubSecKeyOptions}
import io.vertx.ext.auth.oauth2.{OAuth2Options => JOAuth2Options}
import io.vertx.core.http.{HttpClientOptions => JHttpClientOptions}
import io.vertx.core.json.JsonObject
import io.vertx.core.http
package object oauth2{


  type OAuth2Options = io.vertx.ext.auth.oauth2.OAuth2Options
  object OAuth2Options {
    def apply() = new OAuth2Options()
    def apply(json: JsonObject) = new OAuth2Options(json)
    def apply( authorizationPath: java.lang.String = null, clientAssertion: java.lang.String = null, clientAssertionType: java.lang.String = null, clientID: java.lang.String = null, clientId: java.lang.String = null, clientSecret: java.lang.String = null, extraParameters: io.vertx.core.json.JsonObject = null, flow: io.vertx.ext.auth.oauth2.OAuth2FlowType = null, headers: io.vertx.core.json.JsonObject = null, httpClientOptions: io.vertx.core.http.HttpClientOptions = null, introspectionPath: java.lang.String = null, jwkPath: java.lang.String = null, jwtOptions: io.vertx.ext.auth.JWTOptions = null, logoutPath: java.lang.String = null, pubSecKeys: scala.collection.immutable.List[io.vertx.ext.auth.PubSecKeyOptions] = null, revocationPath: java.lang.String = null, rotateJWKs: java.lang.Boolean = null, scopeSeparator: java.lang.String = null, site: java.lang.String = null, supportedGrantTypes: scala.collection.immutable.List[java.lang.String] = null, tenant: java.lang.String = null, tokenPath: java.lang.String = null, userAgent: java.lang.String = null, userInfoParameters: io.vertx.core.json.JsonObject = null, userInfoPath: java.lang.String = null, validateIssuer: java.lang.Boolean = null): OAuth2Options = {
      val ret = new OAuth2Options(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (authorizationPath != null) ret.setAuthorizationPath(authorizationPath) 
      if (clientAssertion != null) ret.setClientAssertion(clientAssertion) 
      if (clientAssertionType != null) ret.setClientAssertionType(clientAssertionType) 
      if (clientID != null) ret.setClientID(clientID) 
      if (clientId != null) ret.setClientId(clientId) 
      if (clientSecret != null) ret.setClientSecret(clientSecret) 
      if (extraParameters != null) ret.setExtraParameters(extraParameters) 
      if (flow != null) ret.setFlow(flow) 
      if (headers != null) ret.setHeaders(headers) 
      if (httpClientOptions != null) ret.setHttpClientOptions(httpClientOptions) 
      if (introspectionPath != null) ret.setIntrospectionPath(introspectionPath) 
      if (jwkPath != null) ret.setJwkPath(jwkPath) 
      if (jwtOptions != null) ret.setJWTOptions(jwtOptions) 
      if (logoutPath != null) ret.setLogoutPath(logoutPath) 
      if (pubSecKeys != null) ret.setPubSecKeys(pubSecKeys.asJava) 
      if (revocationPath != null) ret.setRevocationPath(revocationPath) 
      if (rotateJWKs != null) ret.setRotateJWKs(rotateJWKs) 
      if (scopeSeparator != null) ret.setScopeSeparator(scopeSeparator) 
      if (site != null) ret.setSite(site) 
      if (supportedGrantTypes != null) ret.setSupportedGrantTypes(supportedGrantTypes.asJava) 
      if (tenant != null) ret.setTenant(tenant) 
      if (tokenPath != null) ret.setTokenPath(tokenPath) 
      if (userAgent != null) ret.setUserAgent(userAgent) 
      if (userInfoParameters != null) ret.setUserInfoParameters(userInfoParameters) 
      if (userInfoPath != null) ret.setUserInfoPath(userInfoPath) 
      if (validateIssuer != null) ret.setValidateIssuer(validateIssuer) 
      ret
    }
  }



  type Oauth2Credentials = io.vertx.ext.auth.oauth2.Oauth2Credentials
  object Oauth2Credentials {
    def apply() = new Oauth2Credentials()
    def apply(json: JsonObject) = new Oauth2Credentials(json)
    def apply( assertion: java.lang.String = null, code: java.lang.String = null, codeVerifier: java.lang.String = null, jwt: io.vertx.core.json.JsonObject = null, password: java.lang.String = null, redirectUri: java.lang.String = null, scopes: scala.collection.immutable.List[java.lang.String] = null, username: java.lang.String = null): Oauth2Credentials = {
      val ret = new Oauth2Credentials(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (assertion != null) ret.setAssertion(assertion) 
      if (code != null) ret.setCode(code) 
      if (codeVerifier != null) ret.setCodeVerifier(codeVerifier) 
      if (jwt != null) ret.setJwt(jwt) 
      if (password != null) ret.setPassword(password) 
      if (redirectUri != null) ret.setRedirectUri(redirectUri) 
      if (scopes != null) ret.setScopes(scopes.asJava) 
      if (username != null) ret.setUsername(username) 
      ret
    }
  }



}
