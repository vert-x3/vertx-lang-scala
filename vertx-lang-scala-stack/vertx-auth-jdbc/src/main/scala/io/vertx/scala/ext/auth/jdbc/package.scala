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
     * Like [[create]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
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
     * Like [[create]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def create(client: io.vertx.ext.jdbc.JDBCClient,hashStrategy: io.vertx.ext.auth.jdbc.JDBCHashStrategy,options: io.vertx.ext.auth.jdbc.JDBCAuthenticationOptions) = {
      io.vertx.ext.auth.jdbc.JDBCAuthentication.create(client, hashStrategy, options)
    }
    /**
     * Like [[create]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
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
     * Like [[create]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
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
     * Like [[createSHA512]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createSHA512(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.auth.jdbc.JDBCHashStrategy.createSHA512(vertx)
    }
    /**
     * Like [[createPBKDF2]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createPBKDF2(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.auth.jdbc.JDBCHashStrategy.createPBKDF2(vertx)
    }
    /**
     * Like [[isEqual]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def isEqual(hasha: java.lang.String,hashb: java.lang.String) = {
      io.vertx.ext.auth.jdbc.JDBCHashStrategy.isEqual(hasha, hashb)
    }
  }


}
