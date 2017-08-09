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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.ext.auth.jwt.{JWTAuthOptions => JJWTAuthOptions}
import io.vertx.ext.auth.{PubSecKeyOptions => JPubSecKeyOptions}
import io.vertx.ext.auth.{SecretOptions => JSecretOptions}
import io.vertx.scala.ext.auth.SecretOptions
import io.vertx.scala.ext.auth.KeyStoreOptions
import io.vertx.scala.ext.auth.PubSecKeyOptions
import io.vertx.ext.auth.{KeyStoreOptions => JKeyStoreOptions}

/**
  * Options describing how an JWT Auth should behave.
  */
class JWTAuthOptions(private val _asJava: JJWTAuthOptions) {

  def asJava = _asJava

  /**
    * Set the audience list
    */
  def setAudience(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setAudience(value.asJava)
    this
  }
  def getAudience: scala.collection.mutable.Buffer[String] = {
    asJava.getAudience().asScala.map(x => x.asInstanceOf[String])
  }

  /**
    * Set the audience list
    */
  def addAudience(value: String) = {
    asJava.addAudience(value)
    this
  }

  /**
    * Set whether expiration is ignored
    */
  def setIgnoreExpiration(value: Boolean) = {
    asJava.setIgnoreExpiration(value)
    this
  }
  def isIgnoreExpiration: Boolean = {
    asJava.isIgnoreExpiration().asInstanceOf[Boolean]
  }

  /**
    * Set the issuer
    */
  def setIssuer(value: String) = {
    asJava.setIssuer(value)
    this
  }
  def getIssuer: String = {
    asJava.getIssuer().asInstanceOf[String]
  }
  def setKeyStore(value: KeyStoreOptions) = {
    asJava.setKeyStore(value.asJava)
    this
  }
  def getKeyStore: KeyStoreOptions = {
    KeyStoreOptions(asJava.getKeyStore())
  }
  def setPermissionsClaimKey(value: String) = {
    asJava.setPermissionsClaimKey(value)
    this
  }
  def getPermissionsClaimKey: String = {
    asJava.getPermissionsClaimKey().asInstanceOf[String]
  }
  def addPubSecKey(value: PubSecKeyOptions) = {
    asJava.addPubSecKey(value.asJava)
    this
  }
  def setPubSecKeys(value: scala.collection.mutable.Buffer[PubSecKeyOptions]) = {
    asJava.setPubSecKeys(value.map(_.asJava).asJava)
    this
  }
  def getPubSecKeys: scala.collection.mutable.Buffer[PubSecKeyOptions] = {
    asJava.getPubSecKeys().asScala.map(x => PubSecKeyOptions(x))
  }
  def addSecret(value: SecretOptions) = {
    asJava.addSecret(value.asJava)
    this
  }
  def setSecrets(value: scala.collection.mutable.Buffer[SecretOptions]) = {
    asJava.setSecrets(value.map(_.asJava).asJava)
    this
  }
  def getSecrets: scala.collection.mutable.Buffer[SecretOptions] = {
    asJava.getSecrets().asScala.map(x => SecretOptions(x))
  }
}

object JWTAuthOptions {
  
  def apply() = {
    new JWTAuthOptions(new JJWTAuthOptions(emptyObj()))
  }
  
  def apply(t: JJWTAuthOptions) = {
    if (t != null) {
      new JWTAuthOptions(t)
    } else {
      new JWTAuthOptions(new JJWTAuthOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): JWTAuthOptions = {
    if (json != null) {
      new JWTAuthOptions(new JJWTAuthOptions(json))
    } else {
      new JWTAuthOptions(new JJWTAuthOptions(emptyObj()))
    }
  }
}
