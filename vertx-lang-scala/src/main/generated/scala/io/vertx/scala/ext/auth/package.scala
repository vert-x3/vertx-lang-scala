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

import io.vertx.ext.auth.{PubSecKeyOptions => JPubSecKeyOptions}
import io.vertx.core.buffer.Buffer
package object auth{





  type JWTOptions = io.vertx.ext.auth.JWTOptions
  object JWTOptions {
    def apply() = new JWTOptions()
    def apply(json: JsonObject) = new JWTOptions(json)
    def apply( algorithm: java.lang.String = null, audience: scala.collection.immutable.List[java.lang.String] = null, expiresInMinutes: java.lang.Integer = null, expiresInSeconds: java.lang.Integer = null, header: io.vertx.core.json.JsonObject = null, ignoreExpiration: java.lang.Boolean = null, issuer: java.lang.String = null, leeway: java.lang.Integer = null, noTimestamp: java.lang.Boolean = null, nonceAlgorithm: java.lang.String = null, permissions: scala.collection.immutable.List[java.lang.String] = null, scopeDelimiter: java.lang.String = null, scopes: scala.collection.immutable.List[java.lang.String] = null, subject: java.lang.String = null): JWTOptions = {
      val ret = new JWTOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (algorithm != null) ret.setAlgorithm(algorithm) 
      if (audience != null) ret.setAudience(audience.asJava) 
      if (expiresInMinutes != null) ret.setExpiresInMinutes(expiresInMinutes) 
      if (expiresInSeconds != null) ret.setExpiresInSeconds(expiresInSeconds) 
      if (header != null) ret.setHeader(header) 
      if (ignoreExpiration != null) ret.setIgnoreExpiration(ignoreExpiration) 
      if (issuer != null) ret.setIssuer(issuer) 
      if (leeway != null) ret.setLeeway(leeway) 
      if (noTimestamp != null) ret.setNoTimestamp(noTimestamp) 
      if (nonceAlgorithm != null) ret.setNonceAlgorithm(nonceAlgorithm) 
      if (permissions != null) ret.setPermissions(permissions.asJava) 
      if (scopes != null) ret.setScopes(scopes.asJava) 
      if (subject != null) ret.setSubject(subject) 
      ret
    }
  }



  type KeyStoreOptions = io.vertx.ext.auth.KeyStoreOptions
  object KeyStoreOptions {
    def apply() = new KeyStoreOptions()
    def apply(json: JsonObject) = new KeyStoreOptions(json)
    def apply( password: java.lang.String = null, passwordProtection: scala.collection.immutable.Map[String,java.lang.String] = null, path: java.lang.String = null, provider: java.lang.String = null, `type`: java.lang.String = null, value: io.vertx.core.buffer.Buffer = null): KeyStoreOptions = {
      val ret = new KeyStoreOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (password != null) ret.setPassword(password) 
      if (passwordProtection != null) ret.setPasswordProtection(passwordProtection.asJava) 
      if (path != null) ret.setPath(path) 
      if (provider != null) ret.setProvider(provider) 
      if (`type` != null) ret.setType(`type`) 
      if (value != null) ret.setValue(value) 
      ret
    }
  }



  type PubSecKeyOptions = io.vertx.ext.auth.PubSecKeyOptions
  object PubSecKeyOptions {
    def apply() = new PubSecKeyOptions()
    def apply(json: JsonObject) = new PubSecKeyOptions(json)
    def apply( algorithm: java.lang.String = null, buffer: io.vertx.core.buffer.Buffer = null, certificate: java.lang.Boolean = null, id: java.lang.String = null, publicKey: java.lang.String = null, secretKey: java.lang.String = null, symmetric: java.lang.Boolean = null): PubSecKeyOptions = {
      val ret = new PubSecKeyOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (algorithm != null) ret.setAlgorithm(algorithm) 
      if (buffer != null) ret.setBuffer(buffer) 
      if (certificate != null) ret.setCertificate(certificate) 
      if (id != null) ret.setId(id) 
      if (publicKey != null) ret.setPublicKey(publicKey) 
      if (secretKey != null) ret.setSecretKey(secretKey) 
      if (symmetric != null) ret.setSymmetric(symmetric) 
      ret
    }
  }



  type TokenCredentials = io.vertx.ext.auth.authentication.TokenCredentials
  object TokenCredentials {
    def apply(json: JsonObject) = new TokenCredentials(json)
    def apply(str: String) = new TokenCredentials(str)
    def apply( scopes: scala.collection.immutable.List[java.lang.String] = null, token: java.lang.String = null): TokenCredentials = {
      val ret = new TokenCredentials(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (scopes != null) ret.setScopes(scopes.asJava) 
      if (token != null) ret.setToken(token) 
      ret
    }
  }



  type UsernamePasswordCredentials = io.vertx.ext.auth.authentication.UsernamePasswordCredentials
  object UsernamePasswordCredentials {
    def apply(json: JsonObject) = new UsernamePasswordCredentials(json)
    def apply( password: java.lang.String = null, username: java.lang.String = null): UsernamePasswordCredentials = {
      val ret = new UsernamePasswordCredentials(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (password != null) ret.setPassword(password) 
      if (username != null) ret.setUsername(username) 
      ret
    }
  }



}
