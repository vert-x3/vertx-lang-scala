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

package io.vertx.scala.ext.auth.jwt

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.ext.auth.User
import io.vertx.scala.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.core.Handler
import io.vertx.ext.auth.jwt.JWTOptions
import io.vertx.scala.ext.auth.AuthProvider

/**
  * Factory interface for creating JWT based [[io.vertx.scala.ext.auth.AuthProvider]] instances.
  */
class JWTAuth(private val _asJava: io.vertx.ext.auth.jwt.JWTAuth) {

  def asJava: io.vertx.ext.auth.jwt.JWTAuth = _asJava

  /**
    * Generate a new JWT token.
    * @param claims Json with user defined claims for a list of official claims
    * @param options extra options for the generationsee <a href="../../../../../../../../cheatsheet/JWTOptions.html">JWTOptions</a>
    * @return JWT encoded token
    */
  def generateToken(claims: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.auth.jwt.JWTOptions): String = {
    _asJava.generateToken(claims, options.asJava)
  }

}

object JWTAuth {

  def apply(_asJava: io.vertx.ext.auth.jwt.JWTAuth): io.vertx.scala.ext.auth.jwt.JWTAuth =
    new io.vertx.scala.ext.auth.jwt.JWTAuth(_asJava)

  def create(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject): io.vertx.scala.ext.auth.jwt.JWTAuth = {
    JWTAuth.apply(io.vertx.ext.auth.jwt.JWTAuth.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config))
  }

}
