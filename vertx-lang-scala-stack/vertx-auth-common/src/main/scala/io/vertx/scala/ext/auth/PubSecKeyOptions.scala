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

import io.vertx.ext.auth.{PubSecKeyOptions => JPubSecKeyOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Options describing how a Cryptographic Key.
 */

class PubSecKeyOptions(private val _asJava: JPubSecKeyOptions) {
  def asJava = _asJava
  def setAlgorithm(value: String) = {
    asJava.setAlgorithm(value)
    this
  }

  def getAlgorithm: String = {
    asJava.getAlgorithm().asInstanceOf[String]
  }

  def setCertificate(value: Boolean) = {
    asJava.setCertificate(value)
    this
  }

  def isCertificate: Boolean = {
    asJava.isCertificate().asInstanceOf[Boolean]
  }

  def setPublicKey(value: String) = {
    asJava.setPublicKey(value)
    this
  }

  def getPublicKey: String = {
    asJava.getPublicKey().asInstanceOf[String]
  }

  def setSecretKey(value: String) = {
    asJava.setSecretKey(value)
    this
  }

  def getSecretKey: String = {
    asJava.getSecretKey().asInstanceOf[String]
  }

  def setSymmetric(value: Boolean) = {
    asJava.setSymmetric(value)
    this
  }

  def isSymmetric: Boolean = {
    asJava.isSymmetric().asInstanceOf[Boolean]
  }

}


object PubSecKeyOptions {

  def apply() = {
    new PubSecKeyOptions(new JPubSecKeyOptions(emptyObj()))
  }

  def apply(t: JPubSecKeyOptions) = {
    if (t != null) {
      new PubSecKeyOptions(t)
    } else {
      new PubSecKeyOptions(new JPubSecKeyOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): PubSecKeyOptions = {
    if (json != null) {
      new PubSecKeyOptions(new JPubSecKeyOptions(json))
    } else {
      new PubSecKeyOptions(new JPubSecKeyOptions(emptyObj()))
    }
  }
}

