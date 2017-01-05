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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
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


//cached methods
//fluent methods
  def setCollectionName(collectionName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setCollectionName(collectionName.asInstanceOf[java.lang.String])
    this
  }

  def setUsernameField(fieldName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setUsernameField(fieldName.asInstanceOf[java.lang.String])
    this
  }

  def setPasswordField(fieldName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setPasswordField(fieldName.asInstanceOf[java.lang.String])
    this
  }

  def setRoleField(fieldName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setRoleField(fieldName.asInstanceOf[java.lang.String])
    this
  }

  def setPermissionField(fieldName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setPermissionField(fieldName.asInstanceOf[java.lang.String])
    this
  }

  def setUsernameCredentialField(fieldName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setUsernameCredentialField(fieldName.asInstanceOf[java.lang.String])
    this
  }

  def setPasswordCredentialField(fieldName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setPasswordCredentialField(fieldName.asInstanceOf[java.lang.String])
    this
  }

  def setSaltField(fieldName: String):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setSaltField(fieldName.asInstanceOf[java.lang.String])
    this
  }

  def setHashStrategy(hashStrategy: HashStrategy):MongoAuth = {
    asJava.asInstanceOf[JMongoAuth].setHashStrategy(hashStrategy.asJava.asInstanceOf[JHashStrategy])
    this
  }

//default methods
//basic methods
  def getCollectionName():String = {
    asJava.asInstanceOf[JMongoAuth].getCollectionName().asInstanceOf[String]
  }

  def getUsernameField():String = {
    asJava.asInstanceOf[JMongoAuth].getUsernameField().asInstanceOf[String]
  }

  def getPasswordField():String = {
    asJava.asInstanceOf[JMongoAuth].getPasswordField().asInstanceOf[String]
  }

  def getRoleField():String = {
    asJava.asInstanceOf[JMongoAuth].getRoleField().asInstanceOf[String]
  }

  def getPermissionField():String = {
    asJava.asInstanceOf[JMongoAuth].getPermissionField().asInstanceOf[String]
  }

  def getUsernameCredentialField():String = {
    asJava.asInstanceOf[JMongoAuth].getUsernameCredentialField().asInstanceOf[String]
  }

  def getPasswordCredentialField():String = {
    asJava.asInstanceOf[JMongoAuth].getPasswordCredentialField().asInstanceOf[String]
  }

  def getSaltField():String = {
    asJava.asInstanceOf[JMongoAuth].getSaltField().asInstanceOf[String]
  }

  def getHashStrategy():HashStrategy = {
    HashStrategy(asJava.asInstanceOf[JMongoAuth].getHashStrategy())
  }

  def insertUser(username: String,password: String,roles: scala.collection.mutable.Buffer[String],permissions: scala.collection.mutable.Buffer[String],resultHandler: Handler[AsyncResult[String]]):Unit = {
    asJava.asInstanceOf[JMongoAuth].insertUser(username.asInstanceOf[java.lang.String],password.asInstanceOf[java.lang.String],roles.map(x => x.asInstanceOf[java.lang.String]).asJava,permissions.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
  }

//future methods
    def insertUserFuture(username: String,password: String,roles: scala.collection.mutable.Buffer[String],permissions: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => if (x == null) null.asInstanceOf[String] else x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoAuth].insertUser(username.asInstanceOf[java.lang.String],password.asInstanceOf[java.lang.String],roles.map(x => x.asInstanceOf[java.lang.String]).asJava,permissions.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object MongoAuth{
    def apply(asJava: JMongoAuth) = new MongoAuth(asJava)  
  //static methods
    def create(mongoClient: MongoClient,config: io.vertx.core.json.JsonObject):MongoAuth = {
      MongoAuth(JMongoAuth.create(mongoClient.asJava.asInstanceOf[JMongoClient],config))
    }

  }
