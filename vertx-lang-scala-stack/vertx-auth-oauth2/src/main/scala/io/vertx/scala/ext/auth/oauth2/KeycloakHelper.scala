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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.auth.oauth2.{KeycloakHelper => JKeycloakHelper}
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._

/**
  * Helper class for processing Keycloak principal.
  */
class KeycloakHelper(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
//future methods
}

  object KeycloakHelper{
    def apply(asJava: JKeycloakHelper) = new KeycloakHelper(asJava)  
  //static methods
    def rawIdToken(principal: io.vertx.core.json.JsonObject):String = {
      JKeycloakHelper.rawIdToken(principal).asInstanceOf[String]
    }

    def idToken(principal: io.vertx.core.json.JsonObject):io.vertx.core.json.JsonObject = {
      JKeycloakHelper.idToken(principal)
    }

    def rawAccessToken(principal: io.vertx.core.json.JsonObject):String = {
      JKeycloakHelper.rawAccessToken(principal).asInstanceOf[String]
    }

    def accessToken(principal: io.vertx.core.json.JsonObject):io.vertx.core.json.JsonObject = {
      JKeycloakHelper.accessToken(principal)
    }

    def authTime(principal: io.vertx.core.json.JsonObject):Int = {
      JKeycloakHelper.authTime(principal).asInstanceOf[Int]
    }

    def sessionState(principal: io.vertx.core.json.JsonObject):String = {
      JKeycloakHelper.sessionState(principal).asInstanceOf[String]
    }

    def acr(principal: io.vertx.core.json.JsonObject):String = {
      JKeycloakHelper.acr(principal).asInstanceOf[String]
    }

    def name(principal: io.vertx.core.json.JsonObject):String = {
      JKeycloakHelper.name(principal).asInstanceOf[String]
    }

    def email(principal: io.vertx.core.json.JsonObject):String = {
      JKeycloakHelper.email(principal).asInstanceOf[String]
    }

    def preferredUsername(principal: io.vertx.core.json.JsonObject):String = {
      JKeycloakHelper.preferredUsername(principal).asInstanceOf[String]
    }

    def nickName(principal: io.vertx.core.json.JsonObject):String = {
      JKeycloakHelper.nickName(principal).asInstanceOf[String]
    }

    def allowedOrigins(principal: io.vertx.core.json.JsonObject):scala.collection.mutable.Set[String] = {
      JKeycloakHelper.allowedOrigins(principal).asScala.map(x => x.asInstanceOf[String])
    }

    def parseToken(token: String):io.vertx.core.json.JsonObject = {
      JKeycloakHelper.parseToken(token.asInstanceOf[java.lang.String])
    }

  }
