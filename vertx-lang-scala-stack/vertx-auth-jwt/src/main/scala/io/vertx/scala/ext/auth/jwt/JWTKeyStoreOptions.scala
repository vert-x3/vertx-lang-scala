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
import io.vertx.ext.auth.jwt.{JWTKeyStoreOptions => JJWTKeyStoreOptions}

/**
  * Options describing how an JWT KeyStore should behave.
  */
class JWTKeyStoreOptions(private val _asJava: JJWTKeyStoreOptions) {

  def asJava = _asJava
  def setPassword(value: String) = {
    asJava.setPassword(value)
    this
  }
  def getPassword: String = {
    asJava.getPassword().asInstanceOf[String]
  }
  def setPath(value: String) = {
    asJava.setPath(value)
    this
  }
  def getPath: String = {
    asJava.getPath().asInstanceOf[String]
  }
  def setType(value: String) = {
    asJava.setType(value)
    this
  }
  def getType: String = {
    asJava.getType().asInstanceOf[String]
  }
}

object JWTKeyStoreOptions {
  
  def apply() = {
    new JWTKeyStoreOptions(new JJWTKeyStoreOptions(emptyObj()))
  }
  
  def apply(t: JJWTKeyStoreOptions) = {
    if (t != null) {
      new JWTKeyStoreOptions(t)
    } else {
      new JWTKeyStoreOptions(new JJWTKeyStoreOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): JWTKeyStoreOptions = {
    if (json != null) {
      new JWTKeyStoreOptions(new JJWTKeyStoreOptions(json))
    } else {
      new JWTKeyStoreOptions(new JJWTKeyStoreOptions(emptyObj()))
    }
  }
}
