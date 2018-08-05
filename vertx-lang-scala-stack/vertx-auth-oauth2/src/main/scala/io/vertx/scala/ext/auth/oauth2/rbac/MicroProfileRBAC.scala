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

import scala.reflect.runtime.universe._
import io.vertx.ext.auth.oauth2.{OAuth2RBAC => JOAuth2RBAC}
import io.vertx.ext.auth.oauth2.rbac.{MicroProfileRBAC => JMicroProfileRBAC}
import io.vertx.scala.ext.auth.oauth2.OAuth2RBAC
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Implementation of the Microprofile MP-JWT 1.1 RBAC based on the access token groups key.
  */

class MicroProfileRBAC(private val _asJava: Object) {
  def asJava = _asJava






}

object MicroProfileRBAC {
  def apply(asJava: JMicroProfileRBAC) = new MicroProfileRBAC(asJava)
  
  /**
   * Factory method to create a RBAC handler for tokens adhering to the MP-JWT 1.1 spec.   * @return a RBAC validator
   */
  def create(): OAuth2RBAC = {
    OAuth2RBAC(JMicroProfileRBAC.create())
  }

}
