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

import io.vertx.ext.auth.oauth2.{KeycloakHelper => JKeycloakHelper}
import scala.reflect.runtime.universe._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Helper class for processing Keycloak principal.
  */

class KeycloakHelper(private val _asJava: Object) {
  def asJava = _asJava






}

object KeycloakHelper {
  def apply(asJava: JKeycloakHelper) = new KeycloakHelper(asJava)

  /**
   * Get raw `id_token` string from the principal.   * @param principal user principal
   * @return the raw id token string
   */
  def rawIdToken(principal: io.vertx.core.json.JsonObject): String = {
    JKeycloakHelper.rawIdToken(principal).asInstanceOf[String]//2 rawIdToken
  }

  /**
   * Get decoded `id_token` from the principal.   * @param principal user principal
   * @return the id token
   */
  def idToken(principal: io.vertx.core.json.JsonObject): io.vertx.core.json.JsonObject = {
    JKeycloakHelper.idToken(principal)//2 idToken
  }

  /**
   * Get raw `access_token` string from the principal.   * @param principal user principal
   * @return the raw access token string
   */
  def rawAccessToken(principal: io.vertx.core.json.JsonObject): String = {
    JKeycloakHelper.rawAccessToken(principal).asInstanceOf[String]//2 rawAccessToken
  }

  /**
   * Get decoded `access_token` from the principal.   * @param principal user principal
   * @return the access token
   */
  def accessToken(principal: io.vertx.core.json.JsonObject): io.vertx.core.json.JsonObject = {
    JKeycloakHelper.accessToken(principal)//2 accessToken
  }


  def authTime(principal: io.vertx.core.json.JsonObject): Int = {
    JKeycloakHelper.authTime(principal).asInstanceOf[Int]//2 authTime
  }


  def sessionState(principal: io.vertx.core.json.JsonObject): String = {
    JKeycloakHelper.sessionState(principal).asInstanceOf[String]//2 sessionState
  }


  def acr(principal: io.vertx.core.json.JsonObject): String = {
    JKeycloakHelper.acr(principal).asInstanceOf[String]//2 acr
  }


  def name(principal: io.vertx.core.json.JsonObject): String = {
    JKeycloakHelper.name(principal).asInstanceOf[String]//2 name
  }


  def email(principal: io.vertx.core.json.JsonObject): String = {
    JKeycloakHelper.email(principal).asInstanceOf[String]//2 email
  }


  def preferredUsername(principal: io.vertx.core.json.JsonObject): String = {
    JKeycloakHelper.preferredUsername(principal).asInstanceOf[String]//2 preferredUsername
  }


  def nickName(principal: io.vertx.core.json.JsonObject): String = {
    JKeycloakHelper.nickName(principal).asInstanceOf[String]//2 nickName
  }


  def allowedOrigins(principal: io.vertx.core.json.JsonObject): scala.collection.mutable.Set[String] = {
    JKeycloakHelper.allowedOrigins(principal).asScala.map(x => x.asInstanceOf[String])//2 allowedOrigins
  }

  /**
   * Parse the token string with base64 decoder.
   * This will only obtain the "payload" part of the token.   * @param token token string
   * @return token payload json object
   */
  def parseToken(token: String): io.vertx.core.json.JsonObject = {
    JKeycloakHelper.parseToken(token.asInstanceOf[java.lang.String])//2 parseToken
  }

}
