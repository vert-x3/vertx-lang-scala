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
import io.vertx.ext.auth.jwt.{JWTAuthOptions => JJWTAuthOptions}
import io.vertx.ext.auth
import io.vertx.ext.auth.{PubSecKeyOptions => JPubSecKeyOptions}
import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.{KeyStoreOptions => JKeyStoreOptions}
package object jwt{


  type JWTAuthOptions = io.vertx.ext.auth.jwt.JWTAuthOptions
  object JWTAuthOptions {
    def apply() = new JWTAuthOptions()
    def apply(json: JsonObject) = new JWTAuthOptions(json)
    def apply( jwks: scala.collection.immutable.List[io.vertx.core.json.JsonObject] = null, jwtOptions: io.vertx.ext.auth.JWTOptions = null, keyStore: io.vertx.ext.auth.KeyStoreOptions = null, permissionsClaimKey: java.lang.String = null, pubSecKeys: scala.collection.immutable.List[io.vertx.ext.auth.PubSecKeyOptions] = null): JWTAuthOptions = {
      val ret = new JWTAuthOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (jwks != null) ret.setJwks(jwks.asJava) 
      if (jwtOptions != null) ret.setJWTOptions(jwtOptions) 
      if (keyStore != null) ret.setKeyStore(keyStore) 
      if (permissionsClaimKey != null) ret.setPermissionsClaimKey(permissionsClaimKey) 
      if (pubSecKeys != null) ret.setPubSecKeys(pubSecKeys.asJava) 
      ret
    }
  }



}
