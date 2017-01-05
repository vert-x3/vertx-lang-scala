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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Represents an authenticates User and contains operations to authorise the user.
  * 
  * Please consult the documentation for a detailed explanation.
  */
class User(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0:User = _
  private var cached_1:User = _

//cached methods
  def isAuthorised(authority: String,resultHandler: Handler[AsyncResult[Boolean]]):User = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JUser].isAuthorised(authority.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Boolean] => resultHandler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a.asInstanceOf[Boolean]))})
      cached_0 = User(tmp)
    }
    this
  }

  def clearCache():User = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JUser].clearCache()
      cached_1 = User(tmp)
    }
    this
  }

//fluent methods
//default methods
//basic methods
  def principal():io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JUser].principal()
  }

  def setAuthProvider(authProvider: AuthProvider):Unit = {
    asJava.asInstanceOf[JUser].setAuthProvider(authProvider.asJava.asInstanceOf[JAuthProvider])
  }

//future methods
    def isAuthorisedFuture(authority: String):scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => if (x == null) null.asInstanceOf[Boolean] else x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JUser].isAuthorised(authority.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object User{
    def apply(asJava: JUser) = new User(asJava)  
  //static methods
  }
