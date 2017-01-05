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

package io.vertx.scala.ext.web

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.http.HttpServerResponse
import io.vertx.scala.core.http.HttpServerRequest
import io.vertx.ext.web.{Route => JRoute}
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.core.json.JsonArray
import io.vertx.scala.ext.auth.User
import io.vertx.ext.web.{Cookie => JCookie}
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.ext.web.{Locale => JLocale}
import io.vertx.ext.web.{LanguageHeader => JLanguageHeader}
import io.vertx.core.http.HttpMethod
import io.vertx.ext.auth.{User => JUser}
import io.vertx.ext.web.{Session => JSession}
import io.vertx.ext.web.{ParsedHeaderValues => JParsedHeaderValues}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.json.JsonObject
import io.vertx.core.Handler
import io.vertx.ext.web.{FileUpload => JFileUpload}

/**
  * Represents the context for the handling of a request in Vert.x-Web.
  * 
  * A new instance is created for each HTTP request that is received in the
  * [[io.vertx.scala.ext.web.Router#accept]] of the router.
  * 
  * The same instance is passed to any matching request or failure handlers during the routing of the request or
  * failure.
  * 
  * The context provides access to the  and 
  * and allows you to maintain arbitrary data that lives for the lifetime of the context. Contexts are discarded once they
  * have been routed to the handler for the request.
  * 
  * The context also provides access to the [[io.vertx.scala.ext.web.Session]], cookies and body for the request, given the correct handlers
  * in the application.
  */
class RoutingContext(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0:HttpServerRequest = _
  private var cached_1:HttpServerResponse = _
  private var cached_2:Throwable = _
  private var cached_3:Int = _
  private var cached_4:ParsedHeaderValues = _
  private var cached_5:scala.collection.mutable.Buffer[Locale] = _
  private var cached_6:scala.collection.mutable.Buffer[LanguageHeader] = _
  private var cached_7:Locale = _
  private var cached_8:LanguageHeader = _

//cached methods
  def request():HttpServerRequest = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JRoutingContext].request()
      cached_0 = HttpServerRequest(tmp)
    }
    cached_0
  }

  def response():HttpServerResponse = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JRoutingContext].response()
      cached_1 = HttpServerResponse(tmp)
    }
    cached_1
  }

  def failure():Throwable = {
    if(cached_2 == null) {
      var tmp = asJava.asInstanceOf[JRoutingContext].failure()
      cached_2 = tmp
    }
    cached_2
  }

  def statusCode():Int = {
    if(cached_3 == null) {
      var tmp = asJava.asInstanceOf[JRoutingContext].statusCode()
      cached_3 = tmp.asInstanceOf[Int]
    }
    cached_3
  }

  def parsedHeaders():ParsedHeaderValues = {
    if(cached_4 == null) {
      var tmp = asJava.asInstanceOf[JRoutingContext].parsedHeaders()
      cached_4 = ParsedHeaderValues(tmp)
    }
    cached_4
  }

  def acceptableLocales():scala.collection.mutable.Buffer[Locale] = {
    if(cached_5 == null) {
      var tmp = asJava.asInstanceOf[JRoutingContext].acceptableLocales()
      cached_5 = tmp.asScala.map(x => Locale(x))
    }
    cached_5
  }

  def acceptableLanguages():scala.collection.mutable.Buffer[LanguageHeader] = {
    if(cached_6 == null) {
      var tmp = asJava.asInstanceOf[JRoutingContext].acceptableLanguages()
      cached_6 = tmp.asScala.map(x => LanguageHeader(x))
    }
    cached_6
  }

  def preferredLocale():Locale = {
    if(cached_7 == null) {
      var tmp = asJava.asInstanceOf[JRoutingContext].preferredLocale()
      cached_7 = Locale(tmp)
    }
    cached_7
  }

  def preferredLanguage():LanguageHeader = {
    if(cached_8 == null) {
      var tmp = asJava.asInstanceOf[JRoutingContext].preferredLanguage()
      cached_8 = LanguageHeader(tmp)
    }
    cached_8
  }

//fluent methods
  def put(key: String,obj: AnyRef):RoutingContext = {
    asJava.asInstanceOf[JRoutingContext].put(key.asInstanceOf[java.lang.String],toJava[Object](obj))
    this
  }

  def addCookie(cookie: Cookie):RoutingContext = {
    asJava.asInstanceOf[JRoutingContext].addCookie(cookie.asJava.asInstanceOf[JCookie])
    this
  }

//default methods
  //io.vertx.ext.web.RoutingContext
  def reroute(path: String):Unit = {
    asJava.asInstanceOf[JRoutingContext].reroute(path.asInstanceOf[java.lang.String])
  }

//basic methods
  def next():Unit = {
    asJava.asInstanceOf[JRoutingContext].next()
  }

  def fail(statusCode: Int):Unit = {
    asJava.asInstanceOf[JRoutingContext].fail(statusCode.asInstanceOf[java.lang.Integer])
  }

  def fail(throwable: Throwable):Unit = {
    asJava.asInstanceOf[JRoutingContext].fail(throwable)
  }

  def get[T:TypeTag](key: String):T = {
    toScala[T](asJava.asInstanceOf[JRoutingContext].get[Object](key.asInstanceOf[java.lang.String]))
  }

  def remove[T:TypeTag](key: String):T = {
    toScala[T](asJava.asInstanceOf[JRoutingContext].remove[Object](key.asInstanceOf[java.lang.String]))
  }

  def vertx():Vertx = {
    Vertx(asJava.asInstanceOf[JRoutingContext].vertx())
  }

  def mountPoint():scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].mountPoint().asInstanceOf[String])
  }

  def currentRoute():Route = {
    Route(asJava.asInstanceOf[JRoutingContext].currentRoute())
  }

  def normalisedPath():String = {
    asJava.asInstanceOf[JRoutingContext].normalisedPath().asInstanceOf[String]
  }

  def getCookie(name: String):scala.Option[Cookie] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].getCookie(name.asInstanceOf[java.lang.String])).map(Cookie(_))
  }

  def removeCookie(name: String):scala.Option[Cookie] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].removeCookie(name.asInstanceOf[java.lang.String])).map(Cookie(_))
  }

  def cookieCount():Int = {
    asJava.asInstanceOf[JRoutingContext].cookieCount().asInstanceOf[Int]
  }

  def cookies():scala.collection.mutable.Set[Cookie] = {
    asJava.asInstanceOf[JRoutingContext].cookies().asScala.map(x => Cookie(x))
  }

  def getBodyAsString():scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].getBodyAsString().asInstanceOf[String])
  }

  def getBodyAsString(encoding: String):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].getBodyAsString(encoding.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  def getBodyAsJson():scala.Option[io.vertx.core.json.JsonObject] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].getBodyAsJson())
  }

  def getBodyAsJsonArray():scala.Option[io.vertx.core.json.JsonArray] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].getBodyAsJsonArray())
  }

  def getBody():scala.Option[Buffer] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].getBody()).map(Buffer(_))
  }

  def fileUploads():scala.collection.mutable.Set[FileUpload] = {
    asJava.asInstanceOf[JRoutingContext].fileUploads().asScala.map(x => FileUpload(x))
  }

  def session():scala.Option[Session] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].session()).map(Session(_))
  }

  def user():scala.Option[User] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].user()).map(User(_))
  }

  def getAcceptableContentType():scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].getAcceptableContentType().asInstanceOf[String])
  }

  def addHeadersEndHandler(handler: Handler[Unit]):Int = {
    asJava.asInstanceOf[JRoutingContext].addHeadersEndHandler({x: Void => handler.handle(x)}).asInstanceOf[Int]
  }

  def removeHeadersEndHandler(handlerID: Int):Boolean = {
    asJava.asInstanceOf[JRoutingContext].removeHeadersEndHandler(handlerID.asInstanceOf[java.lang.Integer]).asInstanceOf[Boolean]
  }

  def addBodyEndHandler(handler: Handler[Unit]):Int = {
    asJava.asInstanceOf[JRoutingContext].addBodyEndHandler({x: Void => handler.handle(x)}).asInstanceOf[Int]
  }

  def removeBodyEndHandler(handlerID: Int):Boolean = {
    asJava.asInstanceOf[JRoutingContext].removeBodyEndHandler(handlerID.asInstanceOf[java.lang.Integer]).asInstanceOf[Boolean]
  }

  def failed():Boolean = {
    asJava.asInstanceOf[JRoutingContext].failed().asInstanceOf[Boolean]
  }

  def setBody(body: Buffer):Unit = {
    asJava.asInstanceOf[JRoutingContext].setBody(body.asJava.asInstanceOf[JBuffer])
  }

  def setSession(session: Session):Unit = {
    asJava.asInstanceOf[JRoutingContext].setSession(session.asJava.asInstanceOf[JSession])
  }

  def setUser(user: User):Unit = {
    asJava.asInstanceOf[JRoutingContext].setUser(user.asJava.asInstanceOf[JUser])
  }

  def clearUser():Unit = {
    asJava.asInstanceOf[JRoutingContext].clearUser()
  }

  def setAcceptableContentType(contentType: scala.Option[String]):Unit = {
    asJava.asInstanceOf[JRoutingContext].setAcceptableContentType(contentType.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null))
  }

  def reroute(method: io.vertx.core.http.HttpMethod,path: String):Unit = {
    asJava.asInstanceOf[JRoutingContext].reroute(method,path.asInstanceOf[java.lang.String])
  }

  def pathParams():scala.collection.mutable.Map[String, String] = {
    collection.mutable.Map(asJava.asInstanceOf[JRoutingContext].pathParams().asScala.mapValues(x => x.asInstanceOf[String]).toSeq: _*)
  }

  def pathParam(name: String):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].pathParam(name.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

//future methods
}

  object RoutingContext{
    def apply(asJava: JRoutingContext) = new RoutingContext(asJava)  
  //static methods
  }
