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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.mongo.{MongoClient => JMongoClient}
import scala.collection.JavaConverters._
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.scala.ext.auth.User
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.auth.mongo.{MongoAuth => JMongoAuth}
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.mongo.{HashStrategy => JHashStrategy}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.ext.mongo.MongoClient

/**
  * An extension of AuthProvider which is using  as store
  */
class MongoAuth(private val _asJava: Object) 
    extends AuthProvider(_asJava) {


  /**
    * Set the name of the collection to be used. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @param collectionName the name of the collection to be used for storing and reading user data
    * @return the current instance itself for fluent calls
    */
//java.lang.String
  def setCollectionName(collectionName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setCollectionName(collectionName.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set the name of the field to be used for the username. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @param fieldName the name of the field to be used
    * @return the current instance itself for fluent calls
    */
//java.lang.String
  def setUsernameField(fieldName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setUsernameField(fieldName.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set the name of the field to be used for the password Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @param fieldName the name of the field to be used
    * @return the current instance itself for fluent calls
    */
//java.lang.String
  def setPasswordField(fieldName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setPasswordField(fieldName.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set the name of the field to be used for the roles. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]. Roles are expected to
    * be saved as JsonArray
    * @param fieldName the name of the field to be used
    * @return the current instance itself for fluent calls
    */
//java.lang.String
  def setRoleField(fieldName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setRoleField(fieldName.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set the name of the field to be used for the permissions. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]].
    * Permissions are expected to be saved as JsonArray
    * @param fieldName the name of the field to be used
    * @return the current instance itself for fluent calls
    */
//java.lang.String
  def setPermissionField(fieldName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setPermissionField(fieldName.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set the name of the field to be used as property for the username in the method
    * [[io.vertx.scala.ext.auth.AuthProvider#authenticateFuture]]. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @param fieldName the name of the field to be used
    * @return the current instance itself for fluent calls
    */
//java.lang.String
  def setUsernameCredentialField(fieldName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setUsernameCredentialField(fieldName.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set the name of the field to be used as property for the password of credentials in the method
    * [[io.vertx.scala.ext.auth.AuthProvider#authenticateFuture]]. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @param fieldName the name of the field to be used
    * @return the current instance itself for fluent calls
    */
//java.lang.String
  def setPasswordCredentialField(fieldName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setPasswordCredentialField(fieldName.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set the name of the field to be used for the salt. Only used when [[io.vertx.scala.ext.auth.mongo.HashStrategy#setSaltStyle]] is
    * set to 
    * @param fieldName the name of the field to be used
    * @return the current instance itself for fluent calls
    */
//java.lang.String
  def setSaltField(fieldName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setSaltField(fieldName.asInstanceOf[java.lang.String])
    this
  }

  /**
    * The HashStrategy which is used by the current instance
    * @param hashStrategy the HashStrategy to be set
    * @return the current instance itself for fluent calls
    */
//io.vertx.ext.auth.mongo.HashStrategy
  def setHashStrategy(hashStrategy: HashStrategy):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setHashStrategy(hashStrategy.asJava.asInstanceOf[JHashStrategy])
    this
  }

  /**
    * The name of the collection used to store User objects inside. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @return the collectionName
    */
  def getCollectionName():String = {
    asJava.asInstanceOf[JMongoAuth].getCollectionName().asInstanceOf[String]
  }

  /**
    * Get the name of the field to be used for the username. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @return the usernameField
    */
  def getUsernameField():String = {
    asJava.asInstanceOf[JMongoAuth].getUsernameField().asInstanceOf[String]
  }

  /**
    * Get the name of the field to be used for the password Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @return the passwordField
    */
  def getPasswordField():String = {
    asJava.asInstanceOf[JMongoAuth].getPasswordField().asInstanceOf[String]
  }

  /**
    * Get the name of the field to be used for the roles. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]. Roles are expected to
    * be saved as JsonArray
    * @return the roleField
    */
  def getRoleField():String = {
    asJava.asInstanceOf[JMongoAuth].getRoleField().asInstanceOf[String]
  }

  /**
    * Get the name of the field to be used for the permissions. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]].
    * Permissions are expected to be saved as JsonArray
    * @return the permissionField
    */
  def getPermissionField():String = {
    asJava.asInstanceOf[JMongoAuth].getPermissionField().asInstanceOf[String]
  }

  /**
    * Get the name of the field to be used as property for the username in the method
    * [[io.vertx.scala.ext.auth.AuthProvider#authenticateFuture]]. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @return the usernameCredentialField
    */
  def getUsernameCredentialField():String = {
    asJava.asInstanceOf[JMongoAuth].getUsernameCredentialField().asInstanceOf[String]
  }

  /**
    * Get the name of the field to be used as property for the password of credentials in the method
    * [[io.vertx.scala.ext.auth.AuthProvider#authenticateFuture]]. Defaults to [[io.vertx.scala.ext.auth.mongo.MongoAuth]]
    * @return the passwordCredentialField
    */
  def getPasswordCredentialField():String = {
    asJava.asInstanceOf[JMongoAuth].getPasswordCredentialField().asInstanceOf[String]
  }

  /**
    * Get the name of the field to be used for the salt. Only used when [[io.vertx.scala.ext.auth.mongo.HashStrategy#setSaltStyle]] is
    * set to 
    * @return the saltField
    */
  def getSaltField():String = {
    asJava.asInstanceOf[JMongoAuth].getSaltField().asInstanceOf[String]
  }

  /**
    * The HashStrategy which is used by the current instance
    * @return the defined instance of HashStrategy
    */
  def getHashStrategy():HashStrategy = {
    HashStrategy(asJava.asInstanceOf[JMongoAuth].getHashStrategy())
  }

  /**
    * Insert a new user into mongo in the convenient way
    * @param username the username to be set
    * @param password the passsword in clear text, will be adapted following the definitions of the defined HashStrategy
    * @param roles a list of roles to be set
    * @param permissions a list of permissions to be set
    */
  def insertUser(username: String,password: String,roles: scala.collection.mutable.Buffer[String],permissions: scala.collection.mutable.Buffer[String],resultHandler: Handler[AsyncResult[String]]):Unit = {
    asJava.asInstanceOf[JMongoAuth].insertUser(username.asInstanceOf[java.lang.String],password.asInstanceOf[java.lang.String],roles.map(x => x.asInstanceOf[java.lang.String]).asJava,permissions.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
  }

 /**
   * Insert a new user into mongo in the convenient way
   * @param username the username to be set
   * @param password the passsword in clear text, will be adapted following the definitions of the defined HashStrategy
   * @param roles a list of roles to be set
   * @param permissions a list of permissions to be set
   * @return the ResultHandler will be provided with the id of the generated record
   */
    def insertUserFuture(username: String,password: String,roles: scala.collection.mutable.Buffer[String],permissions: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoAuth].insertUser(username.asInstanceOf[java.lang.String],password.asInstanceOf[java.lang.String],roles.map(x => x.asInstanceOf[java.lang.String]).asJava,permissions.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object MongoAuth{
  def apply(asJava: JMongoAuth) = new MongoAuth(asJava)  
  /**
    * Creates an instance of MongoAuth by using the given  and configuration object. An example for a
    * configuration object:
    * 
    * <pre>
    * JsonObject js = new JsonObject();
    * js.put(MongoAuth.PROPERTY_COLLECTION_NAME, createCollectionName(MongoAuth.DEFAULT_COLLECTION_NAME));
    * </pre>
    * @param mongoClient an instance of MongoClient to be used for data storage and retrival
    * @param config the configuration object for the current instance. By this
    * @return the created instance of MongoAuths
    */
  def create(mongoClient: MongoClient,config: io.vertx.core.json.JsonObject):MongoAuth = {
    MongoAuth(JMongoAuth.create(mongoClient.asJava.asInstanceOf[JMongoClient],config))
  }

}
