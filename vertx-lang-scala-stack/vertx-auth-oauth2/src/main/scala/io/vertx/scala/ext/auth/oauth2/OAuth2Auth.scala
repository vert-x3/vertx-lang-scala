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

package io.vertx.scala.ext.auth.oauth2

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.auth.oauth2.{AccessToken => JAccessToken}
import io.vertx.ext.auth.oauth2.OAuth2FlowType
import io.vertx.ext.auth.oauth2.{OAuth2ClientOptions => JOAuth2ClientOptions}
import io.vertx.ext.auth.oauth2.{OAuth2Auth => JOAuth2Auth}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.scala.ext.auth.User
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.core.http.HttpMethod
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Factory interface for creating OAuth2 based [[io.vertx.scala.ext.auth.AuthProvider]] instances.
  */
class OAuth2Auth(private val _asJava: Object) 
    extends AuthProvider(_asJava) {


//cached methods
//fluent methods
  def api(method: io.vertx.core.http.HttpMethod,path: String,params: io.vertx.core.json.JsonObject,handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):OAuth2Auth = {
    asJava.asInstanceOf[JOAuth2Auth].api(method,path.asInstanceOf[java.lang.String],params,{x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  def decodeToken(token: String,handler: Handler[AsyncResult[AccessToken]]):OAuth2Auth = {
    asJava.asInstanceOf[JOAuth2Auth].decodeToken(token.asInstanceOf[java.lang.String],{x: AsyncResult[JAccessToken] => handler.handle(AsyncResultWrapper[JAccessToken,AccessToken](x, a => AccessToken(a)))})
    this
  }

  def introspectToken(token: String,handler: Handler[AsyncResult[AccessToken]]):OAuth2Auth = {
    asJava.asInstanceOf[JOAuth2Auth].introspectToken(token.asInstanceOf[java.lang.String],{x: AsyncResult[JAccessToken] => handler.handle(AsyncResultWrapper[JAccessToken,AccessToken](x, a => AccessToken(a)))})
    this
  }

  def introspectToken(token: String,tokenType: String,handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):OAuth2Auth = {
    asJava.asInstanceOf[JOAuth2Auth].introspectToken(token.asInstanceOf[java.lang.String],tokenType.asInstanceOf[java.lang.String],{x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

//default methods
//basic methods
  def authorizeURL(params: io.vertx.core.json.JsonObject):String = {
    asJava.asInstanceOf[JOAuth2Auth].authorizeURL(params).asInstanceOf[String]
  }

  def getToken(params: io.vertx.core.json.JsonObject,handler: Handler[AsyncResult[AccessToken]]):Unit = {
    asJava.asInstanceOf[JOAuth2Auth].getToken(params,{x: AsyncResult[JAccessToken] => handler.handle(AsyncResultWrapper[JAccessToken,AccessToken](x, a => AccessToken(a)))})
  }

  def hasJWTToken():Boolean = {
    asJava.asInstanceOf[JOAuth2Auth].hasJWTToken().asInstanceOf[Boolean]
  }

  def getScopeSeparator():String = {
    asJava.asInstanceOf[JOAuth2Auth].getScopeSeparator().asInstanceOf[String]
  }

//future methods
    def getTokenFuture(params: io.vertx.core.json.JsonObject):scala.concurrent.Future[AccessToken] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAccessToken, AccessToken](x => if (x == null) null.asInstanceOf[AccessToken] else AccessToken(x))
    asJava.asInstanceOf[JOAuth2Auth].getToken(params,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def apiFuture(method: io.vertx.core.http.HttpMethod,path: String,params: io.vertx.core.json.JsonObject):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonObject] else x)
    asJava.asInstanceOf[JOAuth2Auth].api(method,path.asInstanceOf[java.lang.String],params,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def decodeTokenFuture(token: String):scala.concurrent.Future[AccessToken] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAccessToken, AccessToken](x => if (x == null) null.asInstanceOf[AccessToken] else AccessToken(x))
    asJava.asInstanceOf[JOAuth2Auth].decodeToken(token.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def introspectTokenFuture(token: String):scala.concurrent.Future[AccessToken] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAccessToken, AccessToken](x => if (x == null) null.asInstanceOf[AccessToken] else AccessToken(x))
    asJava.asInstanceOf[JOAuth2Auth].introspectToken(token.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def introspectTokenFuture(token: String,tokenType: String):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonObject] else x)
    asJava.asInstanceOf[JOAuth2Auth].introspectToken(token.asInstanceOf[java.lang.String],tokenType.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object OAuth2Auth{
    def apply(asJava: JOAuth2Auth) = new OAuth2Auth(asJava)  
  //static methods
    def createKeycloak(vertx: Vertx,flow: io.vertx.ext.auth.oauth2.OAuth2FlowType,config: io.vertx.core.json.JsonObject):OAuth2Auth = {
      OAuth2Auth(JOAuth2Auth.createKeycloak(vertx.asJava.asInstanceOf[JVertx],flow,config))
    }

    def create(vertx: Vertx,flow: io.vertx.ext.auth.oauth2.OAuth2FlowType,config: OAuth2ClientOptions):OAuth2Auth = {
      OAuth2Auth(JOAuth2Auth.create(vertx.asJava.asInstanceOf[JVertx],flow,config.asJava))
    }

    def create(vertx: Vertx,flow: io.vertx.ext.auth.oauth2.OAuth2FlowType):OAuth2Auth = {
      OAuth2Auth(JOAuth2Auth.create(vertx.asJava.asInstanceOf[JVertx],flow))
    }

  }
