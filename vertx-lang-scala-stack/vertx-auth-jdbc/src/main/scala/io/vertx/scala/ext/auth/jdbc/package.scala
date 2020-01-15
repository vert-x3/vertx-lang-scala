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

import io.vertx.ext.auth.jdbc.{JDBCAuthentication => JJDBCAuthentication}
import io.vertx.ext.auth.authentication.{AuthenticationProvider => JAuthenticationProvider}
import io.vertx.ext.auth.authentication
import scala.collection.JavaConverters._
import io.vertx.ext.jdbc.{JDBCClient => JJDBCClient}
import io.vertx.ext.jdbc
import io.vertx.ext.auth.jdbc.{JDBCHashStrategy => JJDBCHashStrategy}
import io.vertx.ext.auth.jdbc.{JDBCAuthenticationOptions => JJDBCAuthenticationOptions}

package object jdbc{

  object JDBCAuth {
    /**
     * Create a JDBC auth provider implementation     * @param client the JDBC client instance
     * @return the auth provider
     */
    def create(vertx: io.vertx.core.Vertx,client: io.vertx.ext.jdbc.JDBCClient) = {
      io.vertx.ext.auth.jdbc.JDBCAuth.create(vertx, client)
    }
  }



  type JDBCAuthOptions = io.vertx.ext.auth.jdbc.JDBCAuthOptions
  object JDBCAuthOptions {
    def apply() = new JDBCAuthOptions()
    def apply(json: JsonObject) = new JDBCAuthOptions(json)
  }



  object JDBCAuthentication {
    /**
     * Create a JDBC auth provider implementation     * @param client the JDBC client instance
     * @param hashStrategy legacy hashing strategy
     * @param options authentication options see <a href="../../../../../../../../cheatsheet/JDBCAuthenticationOptions.html">JDBCAuthenticationOptions</a>
     * @return the auth provider
     */
    def create(client: io.vertx.ext.jdbc.JDBCClient,hashStrategy: io.vertx.ext.auth.jdbc.JDBCHashStrategy,options: io.vertx.ext.auth.jdbc.JDBCAuthenticationOptions) = {
      io.vertx.ext.auth.jdbc.JDBCAuthentication.create(client, hashStrategy, options)
    }
    /**
     * Create a JDBC auth provider implementation     * @param client the JDBC client instance
     * @param options authentication options see <a href="../../../../../../../../cheatsheet/JDBCAuthenticationOptions.html">JDBCAuthenticationOptions</a>
     * @return the auth provider
     */
    def create(client: io.vertx.ext.jdbc.JDBCClient,options: io.vertx.ext.auth.jdbc.JDBCAuthenticationOptions) = {
      io.vertx.ext.auth.jdbc.JDBCAuthentication.create(client, options)
    }
  }



  type JDBCAuthenticationOptions = io.vertx.ext.auth.jdbc.JDBCAuthenticationOptions
  object JDBCAuthenticationOptions {
    def apply() = new JDBCAuthenticationOptions()
    def apply(json: JsonObject) = new JDBCAuthenticationOptions(json)
  }



  object JDBCAuthorization {
    /**
     * Create a JDBC authorization provider implementation     * @param providerId the provider id
     * @param client the JDBC client instance
     * @param options the JDBCAuthorizationOptions see <a href="../../../../../../../../cheatsheet/JDBCAuthorizationOptions.html">JDBCAuthorizationOptions</a>
     * @return the auth provider
     */
    def create(providerId: java.lang.String,client: io.vertx.ext.jdbc.JDBCClient,options: io.vertx.ext.auth.jdbc.JDBCAuthorizationOptions) = {
      io.vertx.ext.auth.jdbc.JDBCAuthorization.create(providerId, client, options)
    }
  }



  type JDBCAuthorizationOptions = io.vertx.ext.auth.jdbc.JDBCAuthorizationOptions
  object JDBCAuthorizationOptions {
    def apply() = new JDBCAuthorizationOptions()
    def apply(json: JsonObject) = new JDBCAuthorizationOptions(json)
  }



  object JDBCHashStrategy {
    /**
     * This is the current backwards compatible hashing implementation, new applications should prefer the
     * PBKDF2 implementation, unless the tradeoff between security and CPU usage is an option.     * @param vertx the vert.x instance
     * @return the implementation.
     */
    def createSHA512(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.auth.jdbc.JDBCHashStrategy.createSHA512(vertx)
    }
    /**
     * Implements a Hashing Strategy as per https://www.owasp.org/index.php/Password_Storage_Cheat_Sheet (2018-01-17).
     *
     * New deployments should use this strategy instead of the default one (which was the previous OWASP recommendation).
     *
     * The work factor can be updated by using the nonces json array.     * @param vertx the vert.x instance
     * @return the implementation.
     */
    def createPBKDF2(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.auth.jdbc.JDBCHashStrategy.createPBKDF2(vertx)
    }
    /**
     * Time constant string comparision to avoid timming attacks.     * @param hasha hash a to compare
     * @param hashb hash b to compare
     * @return true if equal
     */
    def isEqual(hasha: java.lang.String,hashb: java.lang.String) = {
      io.vertx.ext.auth.jdbc.JDBCHashStrategy.isEqual(hasha, hashb)
    }
  }


}
