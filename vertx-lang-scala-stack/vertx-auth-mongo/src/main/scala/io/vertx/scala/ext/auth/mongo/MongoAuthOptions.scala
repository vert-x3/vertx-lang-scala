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

package io.vertx.scala.ext.auth.mongo

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.auth.mongo.{MongoAuthOptions => JMongoAuthOptions}
import io.vertx.core.json.JsonObject

/**
  * Options configuring Mongo authentication.
  */

class MongoAuthOptions(val asJava: JMongoAuthOptions) {

  /**
    * The property name to be used to set the name of the collection inside the config.
    */
  def setCollectionName(value: String) = {
    asJava.setCollectionName(value)
    this
  }
  def getCollectionName = {
    asJava.getCollectionName()
  }

  /**
    * The mongo client configuration: see Mongo Client documentation.
    */
  def setConfig(value: JsonObject) = {
    asJava.setConfig(value)
    this
  }
  def getConfig = {
    asJava.getConfig()
  }

  /**
    * The mongo data source name: see Mongo Client documentation.
    */
  def setDatasourceName(value: String) = {
    asJava.setDatasourceName(value)
    this
  }
  def getDatasourceName = {
    asJava.getDatasourceName()
  }

  /**
    * The property name to be used to set the name of the field, where the password is stored inside
    */
  def setPasswordField(value: String) = {
    asJava.setPasswordField(value)
    this
  }
  def getPasswordField = {
    asJava.getPasswordField()
  }

  /**
    * The property name to be used to set the name of the field, where the permissions are stored inside.
    */
  def setPermissionField(value: String) = {
    asJava.setPermissionField(value)
    this
  }
  def getPermissionField = {
    asJava.getPermissionField()
  }

  /**
    * The property name to be used to set the name of the field, where the roles are stored inside.
    */
  def setRoleField(value: String) = {
    asJava.setRoleField(value)
    this
  }
  def getRoleField = {
    asJava.getRoleField()
  }

  /**
    * The property name to be used to set the name of the field, where the SALT is stored inside.
    */
  def setSaltField(value: String) = {
    asJava.setSaltField(value)
    this
  }
  def getSaltField = {
    asJava.getSaltField()
  }

  /**
    * The property name to be used to set the name of the field, where the salt style is stored inside
    */
  def setSaltStyle(value: io.vertx.ext.auth.mongo.HashSaltStyle) = {
    asJava.setSaltStyle(value)
    this
  }
  def getSaltStyle = {
    asJava.getSaltStyle()
  }

  /**
    * Use a shared Mongo client or not.
    */
  def setShared(value: Boolean) = {
    asJava.setShared(value)
    this
  }
  def getShared = {
    asJava.getShared()
  }

  /**
    * The property name to be used to set the name of the field, where the username for the credentials is stored inside.
    */
  def setUsernameCredentialField(value: String) = {
    asJava.setUsernameCredentialField(value)
    this
  }
  def getUsernameCredentialField = {
    asJava.getUsernameCredentialField()
  }

  /**
    * The property name to be used to set the name of the field, where the username is stored inside.
    */
  def setUsernameField(value: String) = {
    asJava.setUsernameField(value)
    this
  }
  def getUsernameField = {
    asJava.getUsernameField()
  }
}

object MongoAuthOptions {
  
  def apply() = {
    new MongoAuthOptions(new JMongoAuthOptions(emptyObj()))
  }
  
  def apply(t: JMongoAuthOptions) = {
    if(t != null)
      new MongoAuthOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):MongoAuthOptions = {
    if(json != null)
      new MongoAuthOptions(new JMongoAuthOptions(json))
    else
      null
  }
}
