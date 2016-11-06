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

package io.vertx.scala.ext.auth.oauth2

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.auth.oauth2.{KeycloakHelper => JKeycloakHelper}
    import io.vertx.core.json.JsonObject
  
/**
  * Helper class for processing Keycloak principal.
  */
class KeycloakHelper(private val _asJava: JKeycloakHelper) {

  def asJava: JKeycloakHelper = _asJava

}

object KeycloakHelper {

  def apply(_asJava: JKeycloakHelper): KeycloakHelper =
    new KeycloakHelper(_asJava)

  def rawIdToken(principal: JsonObject): String = {
    io.vertx.ext.auth.oauth2.KeycloakHelper.rawIdToken(principal)
  }

  def idToken(principal: JsonObject): JsonObject = {
    io.vertx.ext.auth.oauth2.KeycloakHelper.idToken(principal)
  }

  def rawAccessToken(principal: JsonObject): String = {
    io.vertx.ext.auth.oauth2.KeycloakHelper.rawAccessToken(principal)
  }

  def accessToken(principal: JsonObject): JsonObject = {
    io.vertx.ext.auth.oauth2.KeycloakHelper.accessToken(principal)
  }

  def authTime(principal: JsonObject): Int = {
    io.vertx.ext.auth.oauth2.KeycloakHelper.authTime(principal)
  }

  def sessionState(principal: JsonObject): String = {
    io.vertx.ext.auth.oauth2.KeycloakHelper.sessionState(principal)
  }

  def acr(principal: JsonObject): String = {
    io.vertx.ext.auth.oauth2.KeycloakHelper.acr(principal)
  }

  def name(principal: JsonObject): String = {
    io.vertx.ext.auth.oauth2.KeycloakHelper.name(principal)
  }

  def email(principal: JsonObject): String = {
    io.vertx.ext.auth.oauth2.KeycloakHelper.email(principal)
  }

  def preferredUsername(principal: JsonObject): String = {
    io.vertx.ext.auth.oauth2.KeycloakHelper.preferredUsername(principal)
  }

  def nickName(principal: JsonObject): String = {
    io.vertx.ext.auth.oauth2.KeycloakHelper.nickName(principal)
  }

  def allowedOrigins(principal: JsonObject): Set[String] = {
    io.vertx.ext.auth.oauth2.KeycloakHelper.allowedOrigins(principal).asScala.map(x => x:String).toSet
  }

  def parseToken(token: String): JsonObject = {
    io.vertx.ext.auth.oauth2.KeycloakHelper.parseToken(token)
  }

}
