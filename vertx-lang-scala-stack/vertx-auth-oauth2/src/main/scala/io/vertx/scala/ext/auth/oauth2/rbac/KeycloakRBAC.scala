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

package io.vertx.scala.ext.auth.oauth2.rbac

import io.vertx.scala.ext.auth.oauth2.OAuth2ClientOptions
import scala.reflect.runtime.universe._
import io.vertx.ext.auth.oauth2.rbac.{KeycloakRBAC => JKeycloakRBAC}
import io.vertx.ext.auth.oauth2.{OAuth2RBAC => JOAuth2RBAC}
import io.vertx.scala.ext.auth.oauth2.OAuth2RBAC
import io.vertx.ext.auth.oauth2.{OAuth2ClientOptions => JOAuth2ClientOptions}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Implementation of the Keycloak RBAC handler.
  */

class KeycloakRBAC(private val _asJava: Object) {
  def asJava = _asJava






}

object KeycloakRBAC {
  def apply(asJava: JKeycloakRBAC) = new KeycloakRBAC(asJava)
  
  /**
   * Factory method to create a RBAC handler for tokens adhering to the Keycloak token format.   * @return a RBAC validator
   */
  def create(options: OAuth2ClientOptions): OAuth2RBAC = {
    OAuth2RBAC(JKeycloakRBAC.create(options.asJava))
  }

}
