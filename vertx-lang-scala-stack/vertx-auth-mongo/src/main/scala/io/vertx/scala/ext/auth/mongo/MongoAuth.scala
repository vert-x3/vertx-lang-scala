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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.auth.mongo.{MongoAuth => JMongoAuth}
import io.vertx.ext.auth.{User => JUser}
import io.vertx.scala.ext.auth.User
import io.vertx.ext.mongo.{MongoClient => JMongoClient}
import io.vertx.scala.ext.mongo.MongoClient
import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.mongo.{HashStrategy => JHashStrategy}
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.scala.ext.auth.AuthProvider

/**
  * An extension of AuthProvider which is using  as store
  */
class MongoAuth(private val _asJava: JMongoAuth) 
    extends  {

  def asJava: JMongoAuth = _asJava

  /**
    * Set the name of the collection to be used. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @param collectionName the name of the collection to be used for storing and reading user data
    * @return the current instance itself for fluent calls
    */
  def setCollectionName(collectionName: String): MongoAuth = {
    _asJava.setCollectionName(collectionName)
    this
  }

  /**
    * Set the name of the field to be used for the username. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @param fieldName the name of the field to be used
    * @return the current instance itself for fluent calls
    */
  def setUsernameField(fieldName: String): MongoAuth = {
    _asJava.setUsernameField(fieldName)
    this
  }

  /**
    * Set the name of the field to be used for the password Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @param fieldName the name of the field to be used
    * @return the current instance itself for fluent calls
    */
  def setPasswordField(fieldName: String): MongoAuth = {
    _asJava.setPasswordField(fieldName)
    this
  }

  /**
    * Set the name of the field to be used for the roles. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]. Roles are expected to
    * be saved as JsonArray
    * @param fieldName the name of the field to be used
    * @return the current instance itself for fluent calls
    */
  def setRoleField(fieldName: String): MongoAuth = {
    _asJava.setRoleField(fieldName)
    this
  }

  /**
    * Set the name of the field to be used for the permissions. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]].
    * Permissions are expected to be saved as JsonArray
    * @param fieldName the name of the field to be used
    * @return the current instance itself for fluent calls
    */
  def setPermissionField(fieldName: String): MongoAuth = {
    _asJava.setPermissionField(fieldName)
    this
  }

  /**
    * Set the name of the field to be used as property for the username in the method
    * [[io.vertx.scala.ext.auth.AuthProvider#authenticate]]. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @param fieldName the name of the field to be used
    * @return the current instance itself for fluent calls
    */
  def setUsernameCredentialField(fieldName: String): MongoAuth = {
    _asJava.setUsernameCredentialField(fieldName)
    this
  }

  /**
    * Set the name of the field to be used as property for the password of credentials in the method
    * [[io.vertx.scala.ext.auth.AuthProvider#authenticate]]. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @param fieldName the name of the field to be used
    * @return the current instance itself for fluent calls
    */
  def setPasswordCredentialField(fieldName: String): MongoAuth = {
    _asJava.setPasswordCredentialField(fieldName)
    this
  }

  /**
    * Set the name of the field to be used for the salt. Only used when [[io.vertx.scala.ext.auth.mongo.HashStrategy#setSaltStyle]] is
    * set to 
    * @param fieldName the name of the field to be used
    * @return the current instance itself for fluent calls
    */
  def setSaltField(fieldName: String): MongoAuth = {
    _asJava.setSaltField(fieldName)
    this
  }

  /**
    * The name of the collection used to store User objects inside. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @return the collectionName
    */
  def getCollectionName(): String = {
    _asJava.getCollectionName()
  }

  /**
    * Get the name of the field to be used for the username. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @return the usernameField
    */
  def getUsernameField(): String = {
    _asJava.getUsernameField()
  }

  /**
    * Get the name of the field to be used for the password Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @return the passwordField
    */
  def getPasswordField(): String = {
    _asJava.getPasswordField()
  }

  /**
    * Get the name of the field to be used for the roles. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]. Roles are expected to
    * be saved as JsonArray
    * @return the roleField
    */
  def getRoleField(): String = {
    _asJava.getRoleField()
  }

  /**
    * Get the name of the field to be used for the permissions. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]].
    * Permissions are expected to be saved as JsonArray
    * @return the permissionField
    */
  def getPermissionField(): String = {
    _asJava.getPermissionField()
  }

  /**
    * Get the name of the field to be used as property for the username in the method
    * [[io.vertx.scala.ext.auth.AuthProvider#authenticate]]. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @return the usernameCredentialField
    */
  def getUsernameCredentialField(): String = {
    _asJava.getUsernameCredentialField()
  }

  /**
    * Get the name of the field to be used as property for the password of credentials in the method
    * [[io.vertx.scala.ext.auth.AuthProvider#authenticate]]. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @return the passwordCredentialField
    */
  def getPasswordCredentialField(): String = {
    _asJava.getPasswordCredentialField()
  }

  /**
    * Get the name of the field to be used for the salt. Only used when [[io.vertx.scala.ext.auth.mongo.HashStrategy#setSaltStyle]] is
    * set to 
    * @return the saltField
    */
  def getSaltField(): String = {
    _asJava.getSaltField()
  }

  /**
    * The HashStrategy which is used by the current instance
    * @param hashStrategy the [[HashStrategy]] to be set
    * @return the current instance itself for fluent calls
    */
  def setHashStrategy(hashStrategy: HashStrategy): MongoAuth = {
    _asJava.setHashStrategy(hashStrategy.asJava.asInstanceOf[JHashStrategy])
    this
  }

  /**
    * The HashStrategy which is used by the current instance
    * @return the defined instance of [[HashStrategy]]
    */
  def getHashStrategy(): HashStrategy = {
    HashStrategy.apply(_asJava.getHashStrategy())
  }

  /**
    * Insert a new user into mongo in the convenient way
    * @param username the username to be set
    * @param password the passsword in clear text, will be adapted following the definitions of the defined [[HashStrategy]]
    * @param roles a list of roles to be set
    * @param permissions a list of permissions to be set
    * @return the ResultHandler will be provided with the id of the generated record
    */
  def insertUserFuture(username: String, password: String, roles: scala.collection.mutable.Buffer[String], permissions: scala.collection.mutable.Buffer[String]): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.insertUser(username, password, roles.map(x => if (x == null) null else x:java.lang.String).asJava, permissions.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object MongoAuth {

  def apply(_asJava: JMongoAuth): MongoAuth =
    new MongoAuth(_asJava)

  def create(mongoClient: MongoClient, config: JsonObject): MongoAuth = {
    MongoAuth.apply(io.vertx.ext.auth.mongo.MongoAuth.create(mongoClient.asJava.asInstanceOf[JMongoClient], config))
  }

}
