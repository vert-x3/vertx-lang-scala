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

//cached methods
//fluent methods
//default methods
//basic methods
  def computeHash(password: String,user: User):String = {
    asJava.asInstanceOf[JHashStrategy].computeHash(password.asInstanceOf[java.lang.String],user.asJava.asInstanceOf[JUser]).asInstanceOf[String]
  }

  def getStoredPwd(user: User):String = {
    asJava.asInstanceOf[JHashStrategy].getStoredPwd(user.asJava.asInstanceOf[JUser]).asInstanceOf[String]
  }

  def getSalt(user: User):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHashStrategy].getSalt(user.asJava.asInstanceOf[JUser]).asInstanceOf[String])
  }

  def setExternalSalt(salt: String):Unit = {
    asJava.asInstanceOf[JHashStrategy].setExternalSalt(salt.asInstanceOf[java.lang.String])
  }

  def setSaltStyle(saltStyle: io.vertx.ext.auth.mongo.HashSaltStyle):Unit = {
    asJava.asInstanceOf[JHashStrategy].setSaltStyle(saltStyle)
  }

  def getSaltStyle():io.vertx.ext.auth.mongo.HashSaltStyle = {
    asJava.asInstanceOf[JHashStrategy].getSaltStyle()
  }

//future methods
}

  object HashStrategy{
    def apply(asJava: JHashStrategy) = new HashStrategy(asJava)  
  //static methods
  }
