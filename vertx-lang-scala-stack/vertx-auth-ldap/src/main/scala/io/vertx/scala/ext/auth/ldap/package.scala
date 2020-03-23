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

import io.vertx.core
import io.vertx.ext.auth.ldap.{LdapAuthenticationOptions => JLdapAuthenticationOptions}
import io.vertx.ext.auth.authentication.{AuthenticationProvider => JAuthenticationProvider}
import io.vertx.ext.auth.authentication
import io.vertx.ext.auth.ldap.{LdapAuthentication => JLdapAuthentication}
import io.vertx.core.{Vertx => JVertx}
package object ldap{


  object LdapAuthentication {
    /**
     * Like create from [[io.vertx.ext.auth.ldap.LdapAuthentication]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(vertx: io.vertx.core.Vertx, options: io.vertx.ext.auth.ldap.LdapAuthenticationOptions) = {
      io.vertx.ext.auth.ldap.LdapAuthentication.create(vertx, options)
}  }


  type LdapAuthenticationOptions = io.vertx.ext.auth.ldap.LdapAuthenticationOptions
  object LdapAuthenticationOptions {
    def apply() = new LdapAuthenticationOptions()
    def apply(json: JsonObject) = new LdapAuthenticationOptions(json)
  }



}
