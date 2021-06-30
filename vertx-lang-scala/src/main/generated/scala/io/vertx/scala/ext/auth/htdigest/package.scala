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

import io.vertx.ext.auth.htdigest.{HtdigestCredentials => JHtdigestCredentials}
import io.vertx.ext.auth.authentication
import io.vertx.ext.auth.authentication.{UsernamePasswordCredentials => JUsernamePasswordCredentials}
package object htdigest{


  type HtdigestCredentials = io.vertx.ext.auth.htdigest.HtdigestCredentials
  object HtdigestCredentials {
    def apply() = new HtdigestCredentials()
    def apply(json: JsonObject) = new HtdigestCredentials(json)
    def apply( algorithm: java.lang.String = null, cnonce: java.lang.String = null, method: java.lang.String = null, nc: java.lang.String = null, nonce: java.lang.String = null, opaque: java.lang.String = null, password: java.lang.String = null, qop: java.lang.String = null, realm: java.lang.String = null, response: java.lang.String = null, uri: java.lang.String = null, username: java.lang.String = null): HtdigestCredentials = {
      val ret = new HtdigestCredentials(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (algorithm != null) ret.setAlgorithm(algorithm) 
      if (cnonce != null) ret.setCnonce(cnonce) 
      if (method != null) ret.setMethod(method) 
      if (nc != null) ret.setNc(nc) 
      if (nonce != null) ret.setNonce(nonce) 
      if (opaque != null) ret.setOpaque(opaque) 
      if (password != null) ret.setPassword(password) 
      if (qop != null) ret.setQop(qop) 
      if (realm != null) ret.setRealm(realm) 
      if (response != null) ret.setResponse(response) 
      if (uri != null) ret.setUri(uri) 
      if (username != null) ret.setUsername(username) 
      ret
    }
  }



}
