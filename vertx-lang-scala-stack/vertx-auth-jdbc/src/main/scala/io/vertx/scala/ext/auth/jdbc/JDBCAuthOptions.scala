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

package io.vertx.scala.ext.auth.jdbc

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.scala.ext.auth.{AuthOptions => ExtAuthOptions}
import io.vertx.ext.auth.jdbc.{JDBCAuthOptions => JJDBCAuthOptions}
import io.vertx.core.json.JsonObject

/**
  * Options configuring JDBC authentication.
  */
class JDBCAuthOptions(private val _asJava: JJDBCAuthOptions) 
    extends ExtAuthOptions {

  def asJava = _asJava

  /**
    * Set the authentication query to use. Use this if you want to override the default authentication query.
    */
  def setAuthenticationQuery(value: String) = {
    asJava.setAuthenticationQuery(value)
    this
  }
  def getAuthenticationQuery: String = {
    asJava.getAuthenticationQuery().asInstanceOf[String]
  }

  /**
    * The configuration of the JDBC client: refer to the Vert.x JDBC Client configuration.
    */
  def setConfig(value: io.vertx.core.json.JsonObject) = {
    asJava.setConfig(value)
    this
  }
  def getConfig: io.vertx.core.json.JsonObject = {
    asJava.getConfig()
  }

  /**
    * Set the data source name to use, only use in shared mode.
    */
  def setDatasourceName(value: String) = {
    asJava.setDatasourceName(value)
    this
  }
  def getDatasourceName: String = {
    asJava.getDatasourceName().asInstanceOf[String]
  }

  /**
    * Set the permissions query to use. Use this if you want to override the default permissions query.
    */
  def setPermissionsQuery(value: String) = {
    asJava.setPermissionsQuery(value)
    this
  }
  def getPermissionsQuery: String = {
    asJava.getPermissionsQuery().asInstanceOf[String]
  }

  /**
    * Set the role prefix to distinguish from permissions when checking for isPermitted requests.
    */
  def setRolesPrefix(value: String) = {
    asJava.setRolesPrefix(value)
    this
  }
  def getRolesPrefix: String = {
    asJava.getRolesPrefix().asInstanceOf[String]
  }

  /**
    * Set the roles query to use. Use this if you want to override the default roles query.
    */
  def setRolesQuery(value: String) = {
    asJava.setRolesQuery(value)
    this
  }
  def getRolesQuery: String = {
    asJava.getRolesQuery().asInstanceOf[String]
  }

  /**
    * Set whether the JDBC client is shared or non shared.
    */
  def setShared(value: Boolean) = {
    asJava.setShared(value)
    this
  }
  def isShared: Boolean = {
    asJava.isShared().asInstanceOf[Boolean]
  }
}

object JDBCAuthOptions {
  
  def apply() = {
    new JDBCAuthOptions(new JJDBCAuthOptions(emptyObj()))
  }
  
  def apply(t: JJDBCAuthOptions) = {
    if(t != null)
      new JDBCAuthOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):JDBCAuthOptions = {
    if(json != null)
      new JDBCAuthOptions(new JJDBCAuthOptions(json))
    else
      null
  }
}
