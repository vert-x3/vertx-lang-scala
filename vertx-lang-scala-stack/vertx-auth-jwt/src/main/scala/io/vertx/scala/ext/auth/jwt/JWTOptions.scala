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

import io.vertx.ext.auth.jwt.{JWTOptions => JJWTOptions}
import io.vertx.scala.ext.auth.{JWTOptions => ExtJWTOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Options related to creation of new tokens.
 *
 * If any expiresInMinutes, audience, subject, issuer are not provided, there is no default.
 * The jwt generated won't include those properties in the payload.
 *
 * Generated JWTs will include an iat claim by default unless noTimestamp is specified.
 */

class JWTOptions(private val _asJava: JJWTOptions) extends ExtJWTOptions(_asJava) {
  override def asJava = _asJava
  override def setAlgorithm(value: String) = {
    asJava.setAlgorithm(value)
    this
  }

  override def getAlgorithm: String = {
    asJava.getAlgorithm().asInstanceOf[String]
  }

  override def setAudience(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setAudience(value.asJava)
    this
  }

  override def getAudience: scala.collection.mutable.Buffer[String] = {
    asJava.getAudience().asScala.map(x => x.asInstanceOf[String])
  }

  override def addAudience(value: String) = {
    asJava.addAudience(value)
    this
  }

  override def setExpiresInMinutes(value: Int) = {
    asJava.setExpiresInMinutes(value)
    this
  }

  override def setExpiresInSeconds(value: Int) = {
    asJava.setExpiresInSeconds(value)
    this
  }

  override def getExpiresInSeconds: Int = {
    asJava.getExpiresInSeconds().asInstanceOf[Int]
  }

  override def setHeader(value: io.vertx.core.json.JsonObject) = {
    asJava.setHeader(value)
    this
  }

  override def getHeader: io.vertx.core.json.JsonObject = {
    asJava.getHeader()
  }

  override def setIgnoreExpiration(value: Boolean) = {
    asJava.setIgnoreExpiration(value)
    this
  }

  override def isIgnoreExpiration: Boolean = {
    asJava.isIgnoreExpiration().asInstanceOf[Boolean]
  }

  override def setIssuer(value: String) = {
    asJava.setIssuer(value)
    this
  }

  override def getIssuer: String = {
    asJava.getIssuer().asInstanceOf[String]
  }

  override def setLeeway(value: Int) = {
    asJava.setLeeway(value)
    this
  }

  override def getLeeway: Int = {
    asJava.getLeeway().asInstanceOf[Int]
  }

  override def setNoTimestamp(value: Boolean) = {
    asJava.setNoTimestamp(value)
    this
  }

  override def isNoTimestamp: Boolean = {
    asJava.isNoTimestamp().asInstanceOf[Boolean]
  }

  override def addPermission(value: String) = {
    asJava.addPermission(value)
    this
  }

  override def setPermissions(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setPermissions(value.asJava)
    this
  }

  override def getPermissions: scala.collection.mutable.Buffer[String] = {
    asJava.getPermissions().asScala.map(x => x.asInstanceOf[String])
  }

  override def setSubject(value: String) = {
    asJava.setSubject(value)
    this
  }

  override def getSubject: String = {
    asJava.getSubject().asInstanceOf[String]
  }

}


object JWTOptions {

  def apply() = {
    new JWTOptions(new JJWTOptions(emptyObj()))
  }

  def apply(t: JJWTOptions) = {
    if (t != null) {
      new JWTOptions(t)
    } else {
      new JWTOptions(new JJWTOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): JWTOptions = {
    if (json != null) {
      new JWTOptions(new JJWTOptions(json))
    } else {
      new JWTOptions(new JJWTOptions(emptyObj()))
    }
  }
}

