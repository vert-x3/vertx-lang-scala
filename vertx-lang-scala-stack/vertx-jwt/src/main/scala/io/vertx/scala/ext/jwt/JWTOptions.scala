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

package io.vertx.scala.ext.jwt

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.ext.jwt.{JWTOptions => JJWTOptions}
import io.vertx.core.json.JsonObject

class JWTOptions(private val _asJava: JJWTOptions) {

  def asJava = _asJava
  def setAlgorithm(value: String) = {
    asJava.setAlgorithm(value)
    this
  }
  def getAlgorithm: String = {
    asJava.getAlgorithm().asInstanceOf[String]
  }
  def setAudience(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setAudience(value.asJava)
    this
  }
  def getAudience: scala.collection.mutable.Buffer[String] = {
    asJava.getAudience().asScala.map(x => x.asInstanceOf[String])
  }
  def addAudience(value: String) = {
    asJava.addAudience(value)
    this
  }
  def setExpiresInMinutes(value: Int) = {
    asJava.setExpiresInMinutes(value)
    this
  }
  def setExpiresInSeconds(value: Int) = {
    asJava.setExpiresInSeconds(value)
    this
  }
  def getExpiresInSeconds: Int = {
    asJava.getExpiresInSeconds().asInstanceOf[Int]
  }
  def setHeader(value: io.vertx.core.json.JsonObject) = {
    asJava.setHeader(value)
    this
  }
  def getHeader: io.vertx.core.json.JsonObject = {
    asJava.getHeader()
  }
  def setIgnoreExpiration(value: Boolean) = {
    asJava.setIgnoreExpiration(value)
    this
  }
  def isIgnoreExpiration: Boolean = {
    asJava.isIgnoreExpiration().asInstanceOf[Boolean]
  }
  def setIssuer(value: String) = {
    asJava.setIssuer(value)
    this
  }
  def getIssuer: String = {
    asJava.getIssuer().asInstanceOf[String]
  }
  def setLeeway(value: Int) = {
    asJava.setLeeway(value)
    this
  }
  def getLeeway: Int = {
    asJava.getLeeway().asInstanceOf[Int]
  }
  def setNoTimestamp(value: Boolean) = {
    asJava.setNoTimestamp(value)
    this
  }
  def isNoTimestamp: Boolean = {
    asJava.isNoTimestamp().asInstanceOf[Boolean]
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
  def getPermissions: scala.collection.mutable.Buffer[String] = {
    asJava.getPermissions().asScala.map(x => x.asInstanceOf[String])
  }
  def setSubject(value: String) = {
    asJava.setSubject(value)
    this
  }
  def getSubject: String = {
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
