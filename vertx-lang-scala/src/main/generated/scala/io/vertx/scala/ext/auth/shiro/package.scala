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

import io.vertx.ext.auth.shiro.{ShiroAuthOptions => JShiroAuthOptions}
import io.vertx.ext.auth
import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.{AuthOptions => JAuthOptions}
package object shiro{


  type ShiroAuthOptions = io.vertx.ext.auth.shiro.ShiroAuthOptions
  object ShiroAuthOptions {
    def apply() = new ShiroAuthOptions()
    def apply(json: JsonObject) = new ShiroAuthOptions(json)
    def apply( config: io.vertx.core.json.JsonObject = null, `type`: io.vertx.ext.auth.shiro.ShiroAuthRealmType = null): ShiroAuthOptions = {
      val ret = new ShiroAuthOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (config != null) ret.setConfig(config) 
      if (`type` != null) ret.setType(`type`) 
      ret
    }
  }



}
