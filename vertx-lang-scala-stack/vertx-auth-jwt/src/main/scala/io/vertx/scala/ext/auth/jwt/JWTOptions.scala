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

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.auth.jwt.{JWTOptions => JJWTOptions}
import io.vertx.core.json.JsonObject

/**
  * Options related to creation of new tokens.
  *
  * If any expiresInMinutes, audience, subject, issuer are not provided, there is no default.
  * The jwt generated won't include those properties in the payload.
  *
  * Generated JWTs will include an iat claim by default unless noTimestamp is specified.
  */

class JWTOptions(val asJava: JJWTOptions) {

  /**
    * The algorithm to use, it should be one of the alias [HS256, HS384, HS512, RS256, RS384, RS512, ES256, ES384, ES512]
    */
  def setAlgorithm(value: String) = {
    asJava.setAlgorithm(value)
    this
  }
  def getAlgorithm = {
    asJava.getAlgorithm()
  }

  /**
    * The target audience of this token
    */
  def setAudience(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setAudience(value.asJava)
    this
  }
  def getAudience = {
    asJava.getAudience()
  }

  /**
    * The target audience of this token
    */
  def addAudience(value: String) = {
    asJava.addAudience(value)
    this
  }

  /**
    * The expiration time for the token in minutes
    */
  def setExpiresInMinutes(value: Long) = {
    asJava.setExpiresInMinutes(value)
    this
  }
  def getExpiresInMinutes = {
    asJava.getExpiresInMinutes()
  }

  /**
    * The expiration time for the token in seconds
    */
  def setExpiresInSeconds(value: Long) = {
    asJava.setExpiresInSeconds(value)
    this
  }
  def getExpiresInSeconds = {
    asJava.getExpiresInSeconds()
  }
  def addHeader(key: String, value: String) = {
    asJava.addHeader(key, value)
    this
  }

  /**
    * The issuer of this token
    */
  def setIssuer(value: String) = {
    asJava.setIssuer(value)
    this
  }
  def getIssuer = {
    asJava.getIssuer()
  }

  /**
    * Disable the generation of issued at claim
    */
  def setNoTimestamp(value: Boolean) = {
    asJava.setNoTimestamp(value)
    this
  }
  def getNoTimestamp = {
    asJava.getNoTimestamp()
  }

  /**
    * The permissions of this token.
    */
  def addPermission(value: String) = {
    asJava.addPermission(value)
    this
  }
  def setPermissions(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setPermissions(value.asJava)
    this
  }

  /**
    * The subject of this token
    */
  def setSubject(value: String) = {
    asJava.setSubject(value)
    this
  }
  def getSubject = {
    asJava.getSubject()
  }
}

object JWTOptions {
  
  def apply() = {
    new JWTOptions(new JJWTOptions(emptyObj()))
  }
  
  def apply(t: JJWTOptions) = {
    if(t != null)
      new JWTOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):JWTOptions = {
    if(json != null)
      new JWTOptions(new JJWTOptions(json))
    else
      null
  }
}
