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

import io.vertx.ext.auth.htpasswd.{HtpasswdAuth => JHtpasswdAuth}
import io.vertx.core
import io.vertx.ext.auth.authentication.{AuthenticationProvider => JAuthenticationProvider}
import io.vertx.ext.auth.authentication
import io.vertx.ext.auth.htpasswd.{HtpasswdAuthOptions => JHtpasswdAuthOptions}
import io.vertx.core.{Vertx => JVertx}

package object htpasswd{

  object HtpasswdAuth {
    def create(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.auth.htpasswd.HtpasswdAuth.create(vertx)
    }
    def create(vertx: io.vertx.core.Vertx,htpasswdAuthOptions: io.vertx.ext.auth.htpasswd.HtpasswdAuthOptions) = {
      io.vertx.ext.auth.htpasswd.HtpasswdAuth.create(vertx, htpasswdAuthOptions)
    }
  }



  type HtpasswdAuthOptions = io.vertx.ext.auth.htpasswd.HtpasswdAuthOptions
  object HtpasswdAuthOptions {
    def apply() = new HtpasswdAuthOptions()
    def apply(json: JsonObject) = new HtpasswdAuthOptions(json)
  }



}
