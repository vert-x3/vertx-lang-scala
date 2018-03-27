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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
import io.vertx.scala.core.http.HttpServerResponse
import io.vertx.scala.core.http.HttpServerRequest
import scala.collection.JavaConverters._
import io.vertx.ext.web.{Route => JRoute}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.core.json.JsonArray
import io.vertx.scala.ext.auth.User
import io.vertx.ext.web.{Cookie => JCookie}
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.core.buffer.Buffer
import io.vertx.ext.web.{Locale => JLocale}
import io.vertx.ext.web.{LanguageHeader => JLanguageHeader}
import io.vertx.core.http.HttpMethod
import io.vertx.ext.auth.{User => JUser}
import io.vertx.ext.web.{ParsedHeaderValues => JParsedHeaderValues}
import io.vertx.ext.web.{Session => JSession}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.MultiMap
import io.vertx.core.Handler
import io.vertx.ext.web.{FileUpload => JFileUpload}

/**
  * Represents the context for the handling of a request in Vert.x-Web.
  * 
  * A new instance is created for each HTTP request that is received in the
  *  of the router.
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
  private var cached_0: Option[HttpServerRequest] = None
  private var cached_1: Option[HttpServerResponse] = None
  private var cached_2: Option[Vertx] = None
  private var cached_3: Option[Throwable] = None
  private var cached_4: Option[Int] = None
  private var cached_5: Option[ParsedHeaderValues] = None
  private var cached_6: Option[scala.collection.mutable.Buffer[Locale]] = None
  private var cached_7: Option[scala.collection.mutable.Buffer[LanguageHeader]] = None
  private var cached_8: Option[Locale] = None
  private var cached_9: Option[LanguageHeader] = None


  /**
    * @return the HTTP request object
    */
  def request(): HttpServerRequest = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JRoutingContext].request()
      cached_0 = Some(HttpServerRequest(tmp))
    }
    cached_0.get
  }

  /**
    * @return the HTTP response object
    */
  def response(): HttpServerResponse = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JRoutingContext].response()
      cached_1 = Some(HttpServerResponse(tmp))
    }
    cached_1.get
  }

  /**
    * @return the Vert.x instance associated to the initiating Router for this context
    */
  def vertx(): Vertx = {
    if (cached_2 == None) {
      val tmp = asJava.asInstanceOf[JRoutingContext].vertx()
      cached_2 = Some(Vertx(tmp))
    }
    cached_2.get
  }

  /**
    * If the context is being routed to failure handlers after a failure has been triggered by calling
    * [[io.vertx.scala.ext.web.RoutingContext#fail]] then this will return that throwable. It can be used by failure handlers to render a response,
    * e.g. create a failure response page.
    * @return the throwable used when signalling failure
    */
  def failure(): Throwable = {
    if (cached_3 == None) {
      val tmp = asJava.asInstanceOf[JRoutingContext].failure()
      cached_3 = Some(tmp)
    }
    cached_3.get
  }

  /**
    * If the context is being routed to failure handlers after a failure has been triggered by calling
    * [[io.vertx.scala.ext.web.RoutingContext#fail]]  then this will return that status code.  It can be used by failure handlers to render a response,
    * e.g. create a failure response page.
    *
    * When the status code has not been set yet (it is undefined) its value will be -1.
    * @return the status code used when signalling failure
    */
  def statusCode(): Int = {
    if (cached_4 == None) {
      val tmp = asJava.asInstanceOf[JRoutingContext].statusCode()
      cached_4 = Some(tmp.asInstanceOf[Int])
    }
    cached_4.get
  }

  /**
    * The headers:
    * <ol>
    * <li>Accept</li>
    * <li>Accept-Charset</li>
    * <li>Accept-Encoding</li>
    * <li>Accept-Language</li>
    * <li>Content-Type</li>
    * </ol>
    * Parsed into [[io.vertx.scala.ext.web.ParsedHeaderValue]]
    * @return A container with the parsed headers.
    */
  def parsedHeaders(): ParsedHeaderValues = {
    if (cached_5 == None) {
      val tmp = asJava.asInstanceOf[JRoutingContext].parsedHeaders()
      cached_5 = Some(ParsedHeaderValues(tmp))
    }
    cached_5.get
  }

  /**
    * Returns the locales for the current request. The locales are determined from the `accept-languages` header and
    * sorted on quality.
    *
    * When 2 or more entries have the same quality then the order used to return the best match is based on the lowest
    * index on the original list. For example if a user has en-US and en-GB with same quality and this order the best
    * match will be en-US because it was declared as first entry by the client.
    * @return the best matched locale for the request
    */
  def acceptableLocales(): scala.collection.mutable.Buffer[Locale] = {
    if (cached_6 == None) {
      val tmp = asJava.asInstanceOf[JRoutingContext].acceptableLocales()
      cached_6 = Some(tmp.asScala.map(x => Locale(x)))
    }
    cached_6.get
  }

  /**
    * Returns the languages for the current request. The languages are determined from the <code>Accept-Language</code>
    * header and sorted on quality.
    *
    * When 2 or more entries have the same quality then the order used to return the best match is based on the lowest
    * index on the original list. For example if a user has en-US and en-GB with same quality and this order the best
    * match will be en-US because it was declared as first entry by the client.
    * @return The best matched language for the request
    */
  def acceptableLanguages(): scala.collection.mutable.Buffer[LanguageHeader] = {
    if (cached_7 == None) {
      val tmp = asJava.asInstanceOf[JRoutingContext].acceptableLanguages()
      cached_7 = Some(tmp.asScala.map(x => LanguageHeader(x)))
    }
    cached_7.get
  }

  /**
    * Helper to return the user preferred locale. It is the same action as returning the first element of the acceptable
    * locales.
    * @return the users preferred locale.
    */
  def preferredLocale(): Locale = {
    if (cached_8 == None) {
      val tmp = asJava.asInstanceOf[JRoutingContext].preferredLocale()
      cached_8 = Some(Locale(tmp))
    }
    cached_8.get
  }

  /**
    * Helper to return the user preferred language.
    * It is the same action as returning the first element of the acceptable languages.
    * @return the users preferred locale.
    */
  def preferredLanguage(): LanguageHeader = {
    if (cached_9 == None) {
      val tmp = asJava.asInstanceOf[JRoutingContext].preferredLanguage()
      cached_9 = Some(LanguageHeader(tmp))
    }
    cached_9.get
  }

  /**
    * Put some arbitrary data in the context. This will be available in any handlers that receive the context.
    * @param key the key for the data
    * @param obj the data
    * @return a reference to this, so the API can be used fluently
    */
  def put(key: String, obj: AnyRef): RoutingContext = {
    asJava.asInstanceOf[JRoutingContext].put(key.asInstanceOf[java.lang.String], obj)
    this
  }

  /**
    * Add a cookie. This will be sent back to the client in the response. The context must have first been routed
    * to a [[io.vertx.scala.ext.web.handler.CookieHandler]] for this to work.
    * @param cookie the cookie
    * @return a reference to this, so the API can be used fluently
    */
  def addCookie(cookie: Cookie): RoutingContext = {
    asJava.asInstanceOf[JRoutingContext].addCookie(cookie.asJava.asInstanceOf[JCookie])
    this
  }

  /**
    * Expire a cookie, notifying a User Agent to remove it from its cookie jar. The context must have first been routed
    * to a [[io.vertx.scala.ext.web.handler.CookieHandler]] for this to work.
    * @param name the name of the cookie
    * @return the cookie, if it existed, or null
    */
  def removeCookie(name: String): scala.Option[Cookie] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].removeCookie(name.asInstanceOf[java.lang.String])).map(Cookie(_))
  }

  /**
    * Restarts the current router with a new path and reusing the original method. All path parameters are then parsed
    * and available on the params list.
    * @param path the new http path.
    */
  def reroute(path: String): Unit = {
    asJava.asInstanceOf[JRoutingContext].reroute(path.asInstanceOf[java.lang.String])
  }

  /**
    * Tell the router to route this context to the next matching route (if any).
    * This method, if called, does not need to be called during the execution of the handler, it can be called
    * some arbitrary time later, if required.
    * 
    * If next is not called for a handler then the handler should make sure it ends the response or no response
    * will be sent.
    */
  def next(): Unit = {
    asJava.asInstanceOf[JRoutingContext].next()
  }

  /**
    * Fail the context with the specified status code.
    * 
    * This will cause the router to route the context to any matching failure handlers for the request. If no failure handlers
    * match a default failure response will be sent.
    * @param statusCode the HTTP status code
    */
  def fail(statusCode: Int): Unit = {
    asJava.asInstanceOf[JRoutingContext].fail(statusCode.asInstanceOf[java.lang.Integer])
  }

  /**
    * Fail the context with the specified throwable.
    * 
    * This will cause the router to route the context to any matching failure handlers for the request. If no failure handlers
    * match a default failure response with status code 500 will be sent.
    * @param throwable a throwable representing the failure
    */
  def fail(throwable: Throwable): Unit = {
    asJava.asInstanceOf[JRoutingContext].fail(throwable)
  }

  /**
    * Get some data from the context. The data is available in any handlers that receive the context.
    * @param key the key for the data
    * @return the data
    */
  def get[T: TypeTag](key: String): T = {
    toScala[T](asJava.asInstanceOf[JRoutingContext].get[Object](key.asInstanceOf[java.lang.String]))
  }

  /**
    * Remove some data from the context. The data is available in any handlers that receive the context.
    * @param key the key for the data
    * @return the previous data associated with the key
    */
  def remove[T: TypeTag](key: String): T = {
    toScala[T](asJava.asInstanceOf[JRoutingContext].remove[Object](key.asInstanceOf[java.lang.String]))
  }

  /**
    * @return the mount point for this router. It will be null for a top level router. For a sub-router it will be the path at which the subrouter was mounted.
    */
  def mountPoint(): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].mountPoint().asInstanceOf[String])
  }

  /**
    * @return the current route this context is being routed through.
    */
  def currentRoute(): Route = {
    Route(asJava.asInstanceOf[JRoutingContext].currentRoute())
  }

  /**
    * Return the normalised path for the request.
    * 
    * The normalised path is where the URI path has been decoded, i.e. any unicode or other illegal URL characters that
    * were encoded in the original URL with `%` will be returned to their original form. E.g. `%20` will revert to a space.
    * Also `+` reverts to a space in a query.
    * 
    * The normalised path will also not contain any `..` character sequences to prevent resources being accessed outside
    * of the permitted area.
    * 
    * It's recommended to always use the normalised path as opposed to 
    * if accessing server resources requested by a client.
    * @return the normalised path
    */
  def normalisedPath(): String = {
    asJava.asInstanceOf[JRoutingContext].normalisedPath().asInstanceOf[String]
  }

  /**
    * Get the cookie with the specified name. The context must have first been routed to a [[io.vertx.scala.ext.web.handler.CookieHandler]]
    * for this to work.
    * @param name the cookie name
    * @return the cookie
    */
  def getCookie(name: String): scala.Option[Cookie] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].getCookie(name.asInstanceOf[java.lang.String])).map(Cookie(_))
  }

  /**
    * Remove a cookie from the cookie set. If invalidate is true then it will expire a cookie, notifying a User Agent to
    * remove it from its cookie jar. The context must have first been routed to a
    * [[io.vertx.scala.ext.web.handler.CookieHandler]] for this to work.
    * @param name the name of the cookie
    * @return the cookie, if it existed, or null
    */
  def removeCookie(name: String, invalidate: Boolean): scala.Option[Cookie] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].removeCookie(name.asInstanceOf[java.lang.String], invalidate.asInstanceOf[java.lang.Boolean])).map(Cookie(_))
  }

  /**
    * @return the number of cookies. The context must have first been routed to a io.vertx.scala.ext.web.handler.CookieHandler for this to work.
    */
  def cookieCount(): Int = {
    asJava.asInstanceOf[JRoutingContext].cookieCount().asInstanceOf[Int]
  }

  /**
    * @return a set of all the cookies. The context must have first been routed to a io.vertx.scala.ext.web.handler.CookieHandler for this to be populated.
    */
  def cookies(): scala.collection.mutable.Set[Cookie] = {
    asJava.asInstanceOf[JRoutingContext].cookies().asScala.map(x => Cookie(x))
  }

  /**
    * @return the entire HTTP request body as a string, assuming UTF-8 encoding. The context must have first been routed to a io.vertx.scala.ext.web.handler.BodyHandler for this to be populated.
    */
  def getBodyAsString(): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].getBodyAsString().asInstanceOf[String])
  }

  /**
    * Get the entire HTTP request body as a string, assuming the specified encoding. The context must have first been routed to a
    * [[io.vertx.scala.ext.web.handler.BodyHandler]] for this to be populated.
    * @param encoding the encoding, e.g. "UTF-16"
    * @return the body
    */
  def getBodyAsString(encoding: String): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].getBodyAsString(encoding.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  /**
    * @return Get the entire HTTP request body as a JsonObject. The context must have first been routed to a io.vertx.scala.ext.web.handler.BodyHandler for this to be populated.
    */
  def getBodyAsJson(): scala.Option[io.vertx.core.json.JsonObject] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].getBodyAsJson())
  }

  /**
    * @return Get the entire HTTP request body as a JsonArray. The context must have first been routed to a io.vertx.scala.ext.web.handler.BodyHandler for this to be populated.
    */
  def getBodyAsJsonArray(): scala.Option[io.vertx.core.json.JsonArray] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].getBodyAsJsonArray())
  }

  /**
    * @return Get the entire HTTP request body as a Buffer. The context must have first been routed to a io.vertx.scala.ext.web.handler.BodyHandler for this to be populated.
    */
  def getBody(): scala.Option[io.vertx.core.buffer.Buffer] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].getBody())
  }

  /**
    * @return a set of fileuploads (if any) for the request. The context must have first been routed to a io.vertx.scala.ext.web.handler.BodyHandler for this to work.
    */
  def fileUploads(): scala.collection.mutable.Set[FileUpload] = {
    asJava.asInstanceOf[JRoutingContext].fileUploads().asScala.map(x => FileUpload(x))
  }

  /**
    * Get the session. The context must have first been routed to a [[io.vertx.scala.ext.web.handler.SessionHandler]]
    * for this to be populated.
    * Sessions live for a browser session, and are maintained by session cookies.
    * @return the session.
    */
  def session(): scala.Option[Session] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].session()).map(Session(_))
  }

  /**
    * Get the authenticated user (if any). This will usually be injected by an auth handler if authentication if successful.
    * @return the user, or null if the current user is not authenticated.
    */
  def user(): scala.Option[User] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].user()).map(User(_))
  }

  /**
    * If the route specifies produces matches, e.g. produces `text/html` and `text/plain`, and the `accept` header
    * matches one or more of these then this returns the most acceptable match.
    * @return the most acceptable content type.
    */
  def getAcceptableContentType(): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].getAcceptableContentType().asInstanceOf[String])
  }

  /**
    * Add a handler that will be called just before headers are written to the response. This gives you a hook where
    * you can write any extra headers before the response has been written when it will be too late.
    * @param handler the handler
    * @return the id of the handler. This can be used if you later want to remove the handler.
    */
  def addHeadersEndHandler(handler: Handler[Unit]): Int = {
    asJava.asInstanceOf[JRoutingContext].addHeadersEndHandler({x: Void => handler.handle(x)}).asInstanceOf[Int]
  }

  /**
    * Remove a headers end handler
    * @param handlerID the id as returned from io.vertx.scala.ext.web.RoutingContext#addHeadersEndHandler(Handler).
    * @return true if the handler existed and was removed, false otherwise
    */
  def removeHeadersEndHandler(handlerID: Int): Boolean = {
    asJava.asInstanceOf[JRoutingContext].removeHeadersEndHandler(handlerID.asInstanceOf[java.lang.Integer]).asInstanceOf[Boolean]
  }

  /**
    * Provides a handler that will be called after the last part of the body is written to the wire.
    * The handler is called asynchronously of when the response has been received by the client.
    * This provides a hook allowing you to do more operations once the request has been sent over the wire.
    * Do not use this for resource cleanup as this handler might never get called (e.g. if the connection is reset).
    * @param handler the handler
    * @return the id of the handler. This can be used if you later want to remove the handler.
    */
  def addBodyEndHandler(handler: Handler[Unit]): Int = {
    asJava.asInstanceOf[JRoutingContext].addBodyEndHandler({x: Void => handler.handle(x)}).asInstanceOf[Int]
  }

  /**
    * Remove a body end handler
    * @param handlerID the id as returned from io.vertx.scala.ext.web.RoutingContext#addBodyEndHandler(Handler).
    * @return true if the handler existed and was removed, false otherwise
    */
  def removeBodyEndHandler(handlerID: Int): Boolean = {
    asJava.asInstanceOf[JRoutingContext].removeBodyEndHandler(handlerID.asInstanceOf[java.lang.Integer]).asInstanceOf[Boolean]
  }

  /**
    * @return true if the context is being routed to failure handlers.
    */
  def failed(): Boolean = {
    asJava.asInstanceOf[JRoutingContext].failed().asInstanceOf[Boolean]
  }

  /**
    * Set the body. Used by the [[io.vertx.scala.ext.web.handler.BodyHandler]]. You will not normally call this method.
    * @param body the body
    */
  def setBody(body: io.vertx.core.buffer.Buffer): Unit = {
    asJava.asInstanceOf[JRoutingContext].setBody(body)
  }

  /**
    * Set the session. Used by the [[io.vertx.scala.ext.web.handler.SessionHandler]]. You will not normally call this method.
    * @param session the session
    */
  def setSession(session: Session): Unit = {
    asJava.asInstanceOf[JRoutingContext].setSession(session.asJava.asInstanceOf[JSession])
  }

  /**
    * Set the user. Usually used by auth handlers to inject a User. You will not normally call this method.
    * @param user the user
    */
  def setUser(user: User): Unit = {
    asJava.asInstanceOf[JRoutingContext].setUser(user.asJava.asInstanceOf[JUser])
  }

  /**
    * Clear the current user object in the context. This usually is used for implementing a log out feature, since the
    * current user is unbounded from the routing context.
    */
  def clearUser(): Unit = {
    asJava.asInstanceOf[JRoutingContext].clearUser()
  }

  /**
    * Set the acceptable content type. Used by
    * @param contentType the content type
    */
  def setAcceptableContentType(contentType: scala.Option[String]): Unit = {
    asJava.asInstanceOf[JRoutingContext].setAcceptableContentType(contentType.map(x => x.asInstanceOf[java.lang.String]).orNull)
  }

  /**
    * Restarts the current router with a new method and path. All path parameters are then parsed and available on the
    * params list.
    * @param method the new http request
    * @param path the new http path.
    */
  def reroute(method: io.vertx.core.http.HttpMethod, path: String): Unit = {
    asJava.asInstanceOf[JRoutingContext].reroute(method, path.asInstanceOf[java.lang.String])
  }

  /**
    * Returns a map of named parameters as defined in path declaration with their actual values
    * @return the map of named parameters
    */
  def pathParams(): scala.collection.mutable.Map[String, String] = {
    collection.mutable.Map(asJava.asInstanceOf[JRoutingContext].pathParams().asScala.mapValues(x => x.asInstanceOf[String]).toSeq: _*)
  }

  /**
    * Gets the value of a single path parameter
    * @param name the name of parameter as defined in path declaration
    * @return the actual value of the parameter or null if it doesn't exist
    */
  def pathParam(name: String): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].pathParam(name.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  /**
    * Returns a map of all query parameters inside the <a href="https://en.wikipedia.org/wiki/Query_string">query string</a>
    * @return the multimap of query parameters
    */
  def queryParams(): MultiMap = {
    MultiMap(asJava.asInstanceOf[JRoutingContext].queryParams())
  }

  /**
    * Gets the value of a single query parameter
    * @param query The name of query parameter
    * @return The list of all elements inside query parameter
    */
  def queryParam(query: String): scala.Option[scala.collection.mutable.Buffer[String]] = {
    scala.Option(asJava.asInstanceOf[JRoutingContext].queryParam(query.asInstanceOf[java.lang.String])).map(_.asScala.map(x => x.asInstanceOf[String]))
  }

}

object RoutingContext {
  def apply(asJava: JRoutingContext) = new RoutingContext(asJava)  
}
