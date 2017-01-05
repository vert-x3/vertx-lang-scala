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
import io.vertx.ext.auth.mongo.HashSaltStyle
import io.vertx.scala.ext.auth.User
import io.vertx.ext.auth.{User => JUser}
import io.vertx.ext.auth.mongo.{HashStrategy => JHashStrategy}

/**
  * Determines how the hashing is computed in the implementation You can implement this to provide a different hashing
  * strategy to the default.
  */
class HashStrategy(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Compute the hashed password given the unhashed password and the user
    * @param password the unhashed password
    * @param user the user to get the salt for. This paramter is needed, if the HashSaltStyle#COLUMN is declared to be used
    * @return the hashed password
    */
  def computeHash(password: String,user: User):String = {
    asJava.asInstanceOf[JHashStrategy].computeHash(password.asInstanceOf[java.lang.String],user.asJava.asInstanceOf[JUser]).asInstanceOf[String]
  }

  /**
    * Retrieve the password from the user, or as clear text or as hashed version, depending on the definition
    * @param user the user to get the stored password for
    * @return the password, either as hashed version or as cleartext, depending on the preferences
    */
  def getStoredPwd(user: User):String = {
    asJava.asInstanceOf[JHashStrategy].getStoredPwd(user.asJava.asInstanceOf[JUser]).asInstanceOf[String]
  }

  /**
    * Retrieve the salt. The source of the salt can be the external salt or the propriate column of the given user,
    * depending on the defined [[io.vertx.ext.auth.mongo.HashSaltStyle]]
    * @param user the user to get the salt for. This paramter is needed, if the HashSaltStyle#COLUMN is declared to be used
    * @return null in case of HashSaltStyle#NO_SALT the salt of the user or a defined external salt
    */
  def getSalt(user: User):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHashStrategy].getSalt(user.asJava.asInstanceOf[JUser]).asInstanceOf[String])
  }

  /**
    * Set an external salt. This method should be used in case of 
    * @param salt the salt, which shall be used
    */
  def setExternalSalt(salt: String):Unit = {
    asJava.asInstanceOf[JHashStrategy].setExternalSalt(salt.asInstanceOf[java.lang.String])
  }

  /**
    * Set the saltstyle as defined by [[io.vertx.ext.auth.mongo.HashSaltStyle]].
    * @param saltStyle the HashSaltStyle to be used
    */
  def setSaltStyle(saltStyle: io.vertx.ext.auth.mongo.HashSaltStyle):Unit = {
    asJava.asInstanceOf[JHashStrategy].setSaltStyle(saltStyle)
  }

  /**
    * Get the defined [[io.vertx.ext.auth.mongo.HashSaltStyle]] of the current instance
    * @return the saltStyle
    */
  def getSaltStyle():io.vertx.ext.auth.mongo.HashSaltStyle = {
    asJava.asInstanceOf[JHashStrategy].getSaltStyle()
  }

}

object HashStrategy{
  def apply(asJava: JHashStrategy) = new HashStrategy(asJava)  
}
