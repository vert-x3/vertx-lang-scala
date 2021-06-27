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

import io.vertx.ext.auth.webauthn.{RelyingParty => JRelyingParty}
package object webauthn{


  type Authenticator = io.vertx.ext.auth.webauthn.Authenticator
  object Authenticator {
    def apply() = new Authenticator()
    def apply(json: JsonObject) = new Authenticator(json)
  }



  type RelyingParty = io.vertx.ext.auth.webauthn.RelyingParty
  object RelyingParty {
    def apply() = new RelyingParty()
    def apply(json: JsonObject) = new RelyingParty(json)
  }



  type WebAuthnCredentials = io.vertx.ext.auth.webauthn.WebAuthnCredentials
  object WebAuthnCredentials {
    def apply() = new WebAuthnCredentials()
    def apply(json: JsonObject) = new WebAuthnCredentials(json)
  }



  type WebAuthnOptions = io.vertx.ext.auth.webauthn.WebAuthnOptions
  object WebAuthnOptions {
    def apply() = new WebAuthnOptions()
    def apply(json: JsonObject) = new WebAuthnOptions(json)
  }



}
