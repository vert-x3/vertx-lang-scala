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

import io.vertx.ext.auth.{JWTOptions => JJWTOptions}
import io.vertx.ext.auth
import io.vertx.ext.auth.jwt.{JWTAuthOptions => JJWTAuthOptions}
import io.vertx.core
import io.vertx.ext.auth.jwt.{JWTAuth => JJWTAuth}
import io.vertx.ext.auth.authentication.{AuthenticationProvider => JAuthenticationProvider}
import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.authentication
import io.vertx.core.{Vertx => JVertx}
package object jwt{


  object JWTAuth {
    /**
     * Create a JWT auth provider     * @param vertx the Vertx instance
     * @param config the config see <a href="../../../../../../../../cheatsheet/JWTAuthOptions.html">JWTAuthOptions</a>
     * @return the auth provider
     */
  def create(vertx: io.vertx.core.Vertx, config: io.vertx.ext.auth.jwt.JWTAuthOptions) = {
      io.vertx.ext.auth.jwt.JWTAuth.create(vertx, config)
  }
  }


  type JWTAuthOptions = io.vertx.ext.auth.jwt.JWTAuthOptions
  object JWTAuthOptions {
    def apply() = new JWTAuthOptions()
    def apply(json: JsonObject) = new JWTAuthOptions(json)
  }



  object JWTAuthorization {
    /**
     * Factory method to create a Authorization provider for JWT tokens.     * @param rootClaim slash separated string to the json array with the claims.
     * @return a AuthorizationProvider
     */
  def create(rootClaim: java.lang.String) = {
      io.vertx.ext.auth.jwt.authorization.JWTAuthorization.create(rootClaim)
  }
  }


  object MicroProfileAuthorization {
    /**
     * Factory method to create a Authorization provider for tokens adhering to the MP-JWT 1.1 spec.
     * When the user is known to not be a JWT, (e.g.: a OAuth2 response token) then the root claim
     * is expected to be extracted from  under the key `accessToken`.     * @return a AuthorizationProvider
     */
  def create() = {
      io.vertx.ext.auth.jwt.authorization.MicroProfileAuthorization.create()
  }
  }


}
