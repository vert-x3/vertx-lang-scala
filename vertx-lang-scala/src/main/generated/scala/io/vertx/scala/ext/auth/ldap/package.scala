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

import io.vertx.ext.auth.ldap.{LdapAuthenticationOptions => JLdapAuthenticationOptions}
package object ldap{


  type LdapAuthenticationOptions = io.vertx.ext.auth.ldap.LdapAuthenticationOptions
  object LdapAuthenticationOptions {
    def apply() = new LdapAuthenticationOptions()
    def apply(json: JsonObject) = new LdapAuthenticationOptions(json)
    def apply( authenticationMechanism: java.lang.String = null, authenticationQuery: java.lang.String = null, referral: java.lang.String = null, url: java.lang.String = null): LdapAuthenticationOptions = {
      val ret = new LdapAuthenticationOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (authenticationMechanism != null) ret.setAuthenticationMechanism(authenticationMechanism) 
      if (authenticationQuery != null) ret.setAuthenticationQuery(authenticationQuery) 
      if (referral != null) ret.setReferral(referral) 
      if (url != null) ret.setUrl(url) 
      ret
    }
  }



}
