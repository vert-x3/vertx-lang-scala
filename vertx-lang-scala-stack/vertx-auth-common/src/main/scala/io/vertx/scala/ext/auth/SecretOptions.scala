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

package io.vertx.scala.ext.auth

import io.vertx.ext.auth.{SecretOptions => JSecretOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Options describing a secret.
 */

class SecretOptions(private val _asJava: JSecretOptions) {
  def asJava = _asJava
  def setSecret(value: String) = {
    asJava.setSecret(value)
    this
  }

  def getSecret: String = {
    asJava.getSecret().asInstanceOf[String]
  }

  def setType(value: String) = {
    asJava.setType(value)
    this
  }

  def getType: String = {
    asJava.getType().asInstanceOf[String]
  }

}


object SecretOptions {
  
  def apply() = {
    new SecretOptions(new JSecretOptions(emptyObj()))
  }
  
  def apply(t: JSecretOptions) = {
    if (t != null) {
      new SecretOptions(t)
    } else {
      new SecretOptions(new JSecretOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): SecretOptions = {
    if (json != null) {
      new SecretOptions(new JSecretOptions(json))
    } else {
      new SecretOptions(new JSecretOptions(emptyObj()))
    }
  }
}

