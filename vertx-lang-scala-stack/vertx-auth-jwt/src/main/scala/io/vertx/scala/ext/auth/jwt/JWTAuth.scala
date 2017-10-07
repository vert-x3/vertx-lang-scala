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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.auth.jwt.{JWTAuthOptions => JJWTAuthOptions}
import io.vertx.ext.auth.jwt.{JWTOptions => JJWTOptions}
import io.vertx.ext.auth.jwt.{JWTAuth => JJWTAuth}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.scala.ext.auth.User
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Factory interface for creating JWT based [[io.vertx.scala.ext.auth.AuthProvider]] instances.
  */
class JWTAuth(private val _asJava: Object)
    extends AuthProvider(_asJava)   {


  /**
    * Generate a new JWT token.
    * @param claims Json with user defined claims for a list of official claims
    * @return JWT encoded token
    */
  def generateToken(claims: io.vertx.core.json.JsonObject): String = {
    asJava.asInstanceOf[JJWTAuth].generateToken(claims).asInstanceOf[String]
  }

  /**
    * Generate a new JWT token.
    * @param claims Json with user defined claims for a list of official claims
    * @param options extra options for the generationsee <a href="../../../../../../../../cheatsheet/JWTOptions.html">JWTOptions</a>
    * @return JWT encoded token
    */
  def generateToken(claims: io.vertx.core.json.JsonObject, options: JWTOptions): String = {
    asJava.asInstanceOf[JJWTAuth].generateToken(claims, options.asJava).asInstanceOf[String]
  }

}

object JWTAuth {
  def apply(asJava: JJWTAuth) = new JWTAuth(asJava)  
  /**
    * Create a JWT auth provider
    * @param vertx the Vertx instance
    * @param config the configsee <a href="../../../../../../../../cheatsheet/JWTAuthOptions.html">JWTAuthOptions</a>
    * @return the auth provider
    */
  def create(vertx: Vertx, config: JWTAuthOptions): JWTAuth = {
    JWTAuth(JJWTAuth.create(vertx.asJava.asInstanceOf[JVertx], config.asJava))
  }

}
